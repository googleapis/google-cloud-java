/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.AbstractResultSet.CloseableIterator;
import com.google.cloud.spanner.AbstractResultSet.Listener;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.spanner.v1.MultiplexedSessionPrecommitToken;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeCode;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GrpcValueIteratorTest {
  @SuppressWarnings("unchecked")
  private final CloseableIterator<PartialResultSet> stream = mock(CloseableIterator.class);

  private final Listener listener = mock(Listener.class);

  private static StructType createSingleColumnRowType(String columnName, TypeCode typeCode) {
    return StructType.newBuilder()
        .addFields(
            Field.newBuilder().setName(columnName).setType(Type.newBuilder().setCode(typeCode)))
        .build();
  }

  private static StructType createArrayColumnRowType(String columnName, TypeCode elementTypeCode) {
    return StructType.newBuilder()
        .addFields(
            Field.newBuilder()
                .setName(columnName)
                .setType(
                    Type.newBuilder()
                        .setCode(TypeCode.ARRAY)
                        .setArrayElementType(Type.newBuilder().setCode(elementTypeCode))))
        .build();
  }

  private static StructType createMultiColumnRowType(String[] columnNames, TypeCode[] typeCodes) {
    StructType.Builder builder = StructType.newBuilder();
    for (int index = 0; index < columnNames.length; index++) {
      builder.addFields(
          Field.newBuilder()
              .setName(columnNames[index])
              .setType(Type.newBuilder().setCode(typeCodes[index])));
    }
    return builder.build();
  }

  private static PartialResultSet createChunkWithMetadata(
      StructType rowType, boolean chunkedValue, com.google.protobuf.Value... values) {
    PartialResultSet.Builder builder =
        PartialResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().setRowType(rowType))
            .setChunkedValue(chunkedValue);
    for (com.google.protobuf.Value value : values) {
      builder.addValues(value);
    }
    return builder.build();
  }

  private static PartialResultSet createChunkWithoutMetadata(
      boolean chunkedValue, com.google.protobuf.Value... values) {
    PartialResultSet.Builder builder = PartialResultSet.newBuilder().setChunkedValue(chunkedValue);
    for (com.google.protobuf.Value value : values) {
      builder.addValues(value);
    }
    return builder.build();
  }

  private static com.google.protobuf.Value stringValue(String value) {
    return com.google.protobuf.Value.newBuilder().setStringValue(value).build();
  }

  private static com.google.protobuf.Value int64Value(long value) {
    return com.google.protobuf.Value.newBuilder().setStringValue(String.valueOf(value)).build();
  }

  private static com.google.protobuf.Value listValue(String... elements) {
    ListValue.Builder listBuilder = ListValue.newBuilder();
    for (String element : elements) {
      listBuilder.addValues(com.google.protobuf.Value.newBuilder().setStringValue(element));
    }
    return com.google.protobuf.Value.newBuilder().setListValue(listBuilder).build();
  }

  @Test
  public void testIsDataAvailableWhenCurrentIsNull() {
    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(false);
    when(stream.isDataAvailable()).thenReturn(false);
    assertFalse(iterator.isDataAvailable());

    when(stream.isDataAvailable()).thenReturn(true);
    assertTrue(iterator.isDataAvailable());
  }

  @Test
  public void testIsDataAvailableWhenValuesRemainInCurrentChunk() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    PartialResultSet chunk =
        createChunkWithMetadata(rowType, false, stringValue("val1"), stringValue("val2"));

    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(chunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.isDataAvailable()).thenReturn(false);

    // Initial state before reading: current is null, stream has no data available
    assertFalse(iterator.isDataAvailable());

    // Advance iterator: reads first value "val1", current is set, pos is now 1 (1 < 2 values)
    assertTrue(iterator.hasNext());
    assertEquals("val1", iterator.next().getStringValue());

    // Even though stream.isDataAvailable() is false, iterator has 1 value remaining in current
    assertFalse(stream.isDataAvailable());
    assertTrue(iterator.isDataAvailable());

    // Read second value "val2", pos is now 2 (all 2 values consumed from current chunk)
    assertTrue(iterator.hasNext());
    assertEquals("val2", iterator.next().getStringValue());

    // Now all values in current chunk are consumed, so isDataAvailable matches stream
    assertFalse(iterator.isDataAvailable());
    when(stream.isDataAvailable()).thenReturn(true);
    assertTrue(iterator.isDataAvailable());
  }

  @Test
  public void testIsDataAvailableMultiColumnRowAcrossChunks() {
    StructType rowType =
        createMultiColumnRowType(
            new String[] {"col1", "col2", "col3"},
            new TypeCode[] {TypeCode.STRING, TypeCode.STRING, TypeCode.STRING});
    PartialResultSet firstChunk =
        createChunkWithMetadata(rowType, false, stringValue("val1"), stringValue("val2"));
    PartialResultSet secondChunk = createChunkWithoutMetadata(false, stringValue("val3"));

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(firstChunk);
    when(stream.isDataAvailable()).thenReturn(false);

    // After buffering firstChunk, only 2 complete values are present for a 3-column row.
    // Row is incomplete, so isDataAvailable must return false.
    assertFalse(iterator.isDataAvailable());

    // Now secondChunk becomes available to poll without blocking
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(secondChunk);

    // With secondChunk buffered, 3 complete values are present, forming a full row.
    assertTrue(iterator.isDataAvailable());

    assertTrue(iterator.hasNext());
    assertEquals("val1", iterator.next().getStringValue());
    assertTrue(iterator.hasNext());
    assertEquals("val2", iterator.next().getStringValue());
    assertTrue(iterator.hasNext());
    assertEquals("val3", iterator.next().getStringValue());
  }

  @Test
  public void testIsDataAvailableWhenCurrentEndsWithChunkedValueAndStreamHasNoData() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    PartialResultSet firstChunk =
        createChunkWithMetadata(
            rowType, true, stringValue("complete_val"), stringValue("chunked_part_1_"));
    PartialResultSet secondChunk = createChunkWithoutMetadata(false, stringValue("chunked_part_2"));

    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(false);
    when(stream.hasNext()).thenReturn(true, true, false);
    when(stream.next()).thenReturn(firstChunk, secondChunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.isDataAvailable()).thenReturn(false);

    // Read the first complete value; pos is now 1 (pointing to the last value in firstChunk,
    // which has chunked_value = true).
    assertTrue(iterator.hasNext());
    assertEquals("complete_val", iterator.next().getStringValue());

    // Because the remaining value in firstChunk is chunked and stream.isDataAvailable() is false,
    // advancing the iterator would block waiting for secondChunk, so isDataAvailable() must be
    // false.
    assertFalse(iterator.isDataAvailable());

    // Once secondChunk is available on the stream, isDataAvailable() becomes true.
    when(stream.isDataAvailable()).thenReturn(true);
    assertTrue(iterator.isDataAvailable());
    assertTrue(iterator.hasNext());
    assertEquals("chunked_part_1_chunked_part_2", iterator.next().getStringValue());
  }

  @Test
  public void testIsDataAvailableChunkedStringAcrossThreeChunks() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    PartialResultSet firstChunk = createChunkWithMetadata(rowType, true, stringValue("part1_"));
    PartialResultSet secondChunk = createChunkWithoutMetadata(true, stringValue("part2_"));
    PartialResultSet thirdChunk = createChunkWithoutMetadata(false, stringValue("part3"));

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(firstChunk);
    when(stream.isDataAvailable()).thenReturn(false);

    // First chunk has chunked_value = true, so 0 complete values are available.
    assertFalse(iterator.isDataAvailable());

    // Second chunk arrives, but it is also chunked (part 2 of 3).
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(secondChunk);
    assertFalse(iterator.isDataAvailable());

    // Third chunk arrives with chunked_value = false, completing the string value.
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(thirdChunk);
    assertTrue(iterator.isDataAvailable());

    assertTrue(iterator.hasNext());
    assertEquals("part1_part2_part3", iterator.next().getStringValue());
  }

  @Test
  public void testIsDataAvailableChunkedListAcrossChunks() {
    StructType rowType = createArrayColumnRowType("col", TypeCode.STRING);
    PartialResultSet firstChunk =
        createChunkWithMetadata(rowType, true, listValue("a", "b_part1_"));
    PartialResultSet secondChunk = createChunkWithoutMetadata(false, listValue("part2_b", "c"));

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(firstChunk);
    when(stream.isDataAvailable()).thenReturn(false);

    // List is chunked, so 0 complete values are buffered.
    assertFalse(iterator.isDataAvailable());

    // Second chunk arrives with remaining elements.
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(secondChunk);
    assertTrue(iterator.isDataAvailable());

    assertTrue(iterator.hasNext());
    com.google.protobuf.Value mergedValue = iterator.next();
    assertEquals(3, mergedValue.getListValue().getValuesCount());
    assertEquals("a", mergedValue.getListValue().getValues(0).getStringValue());
    assertEquals("b_part1_part2_b", mergedValue.getListValue().getValues(1).getStringValue());
    assertEquals("c", mergedValue.getListValue().getValues(2).getStringValue());
  }

  @Test
  public void testIsDataAvailableZeroColumnStatementWaitsForStreamFinished() {
    // 0-column statement (e.g. DML or QueryMode.PLAN)
    StructType emptyRowType = StructType.newBuilder().build();
    PartialResultSet firstChunk =
        PartialResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().setRowType(emptyRowType))
            .build();
    ResultSetStats expectedStats = ResultSetStats.newBuilder().setRowCountExact(42L).build();
    PartialResultSet secondChunk = PartialResultSet.newBuilder().setStats(expectedStats).build();

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);

    // Chunk 1 arrives with metadata, but stream is not finished yet.
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(firstChunk);
    when(stream.isDataAvailable()).thenReturn(false);

    // For 0-column statements, requiredCompleteValues is Math.max(1, 0) = 1.
    // Since completeValues is 0 and streamFinished is false, isDataAvailable must be false.
    assertFalse(iterator.isDataAvailable());

    // Chunk 2 arrives with stats and finishes the stream (EOF).
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(secondChunk);

    // Now streamFinished becomes true when EOF is hit during bufferAvailableChunks.
    assertTrue(iterator.isDataAvailable());

    // hasNext should be false, and stats must be collected.
    assertFalse(iterator.hasNext());
    assertEquals(expectedStats, iterator.getStats());
  }

  @Test
  public void testIsDataAvailableSurfacesMissingMetadataImmediately() {
    // First chunk has no metadata at all.
    PartialResultSet chunkWithoutMetadata =
        PartialResultSet.newBuilder().addValues(stringValue("orphan_value")).build();

    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(chunkWithoutMetadata);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);

    // isDataAvailable should return true immediately to allow ensureReady to fail fast.
    assertTrue(iterator.isDataAvailable());

    SpannerException spannerException = assertThrows(SpannerException.class, iterator::hasNext);
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
    assertTrue(spannerException.getMessage().contains("Missing type metadata in first message"));
  }

  @Test
  public void testIsDataAvailableSurfacesMissingRowTypeImmediately() {
    // First chunk has metadata but no rowType.
    PartialResultSet chunkWithoutRowType =
        PartialResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().build())
            .addValues(stringValue("orphan_value"))
            .build();

    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(chunkWithoutRowType);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);

    // isDataAvailable should return true immediately.
    assertTrue(iterator.isDataAvailable());

    SpannerException spannerException = assertThrows(SpannerException.class, iterator::hasNext);
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
    assertTrue(spannerException.getMessage().contains("Missing type metadata in first message"));
  }

  @Test
  public void testInvalidTypeMetadataThrowsException() {
    // Struct with invalid field type that fails Type.fromProto()
    StructType invalidRowType =
        StructType.newBuilder()
            .addFields(
                Field.newBuilder()
                    .setName("invalid_col")
                    .setType(Type.newBuilder().setCode(TypeCode.ARRAY)))
            .build();
    PartialResultSet invalidChunk =
        PartialResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().setRowType(invalidRowType))
            .build();

    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(invalidChunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);

    SpannerException spannerException = assertThrows(SpannerException.class, iterator::hasNext);
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
    assertTrue(spannerException.getMessage().contains("Invalid type metadata"));
  }

  @Test
  public void testIsDataAvailableWhenStreamHasError() {
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(false);
    when(stream.isDataAvailable()).thenReturn(true);
    when(stream.hasNext())
        .thenThrow(
            SpannerExceptionFactory.newSpannerException(ErrorCode.UNAVAILABLE, "Transport error"));

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    assertTrue(iterator.isDataAvailable());

    SpannerException spannerException = assertThrows(SpannerException.class, iterator::hasNext);
    assertEquals(ErrorCode.UNAVAILABLE, spannerException.getErrorCode());
    assertTrue(spannerException.getMessage().contains("Transport error"));
  }

  @Test
  public void testBufferAvailableChunksPullsMultipleChunks() {
    StructType rowType =
        createMultiColumnRowType(
            new String[] {"col1", "col2"}, new TypeCode[] {TypeCode.STRING, TypeCode.INT64});
    PartialResultSet firstChunk = createChunkWithMetadata(rowType, false, stringValue("first"));
    PartialResultSet secondChunk = createChunkWithoutMetadata(false, int64Value(100L));

    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, true, false);
    when(stream.hasNext()).thenReturn(true, true, false);
    when(stream.next()).thenReturn(firstChunk, secondChunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    assertTrue(iterator.isDataAvailable());

    assertTrue(iterator.hasNext());
    assertEquals("first", iterator.next().getStringValue());
    assertTrue(iterator.hasNext());
    assertEquals("100", iterator.next().getStringValue());
    assertNotNull(iterator.type());
    assertEquals(2, iterator.type().getStructFields().size());
  }

  @Test
  public void testCloseClearsBufferedChunksAndClosesStream() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    PartialResultSet chunk = createChunkWithMetadata(rowType, false, stringValue("val1"));

    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(chunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    assertTrue(iterator.isDataAvailable());

    iterator.close("Test close");
    verify(stream).close("Test close");

    // After close, buffered chunks are cleared and streamFinished is true
    assertFalse(iterator.hasNext());
  }

  @Test
  public void testGetMetadataWhenMetadataReceived() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    ResultSetMetadata metadata = ResultSetMetadata.newBuilder().setRowType(rowType).build();
    PartialResultSet chunk = PartialResultSet.newBuilder().setMetadata(metadata).build();

    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(chunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    assertEquals(metadata, iterator.getMetadata());
    assertNotNull(iterator.type());
  }

  @Test
  public void testGetMetadataMultipleTimesDoesNotAdvanceStream() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    ResultSetMetadata metadata = ResultSetMetadata.newBuilder().setRowType(rowType).build();
    PartialResultSet firstChunk = PartialResultSet.newBuilder().setMetadata(metadata).build();
    PartialResultSet secondChunk = createChunkWithoutMetadata(false, stringValue("val"));

    when(stream.hasNext()).thenReturn(true, true, false);
    when(stream.next()).thenReturn(firstChunk, secondChunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);

    // First call to getMetadata advances to firstChunk and initializes metadata
    assertEquals(metadata, iterator.getMetadata());
    verify(stream, times(1)).next();

    // Subsequent calls to getMetadata return the cached metadata and must NOT advance to
    // secondChunk
    assertEquals(metadata, iterator.getMetadata());
    assertEquals(metadata, iterator.getMetadata());
    verify(stream, times(1)).next();

    // When iterating values, secondChunk is finally fetched from the stream
    assertTrue(iterator.hasNext());
    verify(stream, times(2)).next();
    assertEquals("val", iterator.next().getStringValue());
    assertFalse(iterator.hasNext());
  }

  @Test
  public void testGetMetadataAfterConsumingChunkValuesDoesNotAdvanceStream() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    ResultSetMetadata metadata = ResultSetMetadata.newBuilder().setRowType(rowType).build();
    PartialResultSet firstChunk =
        PartialResultSet.newBuilder().setMetadata(metadata).addValues(stringValue("val1")).build();
    PartialResultSet secondChunk = createChunkWithoutMetadata(false, stringValue("val2"));

    when(stream.hasNext()).thenReturn(true, true, false);
    when(stream.next()).thenReturn(firstChunk, secondChunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);

    // Consume val1 so pos == 1 (all values in firstChunk consumed; hasUnreadValuesInCurrentChunk()
    // is false)
    assertTrue(iterator.hasNext());
    assertEquals("val1", iterator.next().getStringValue());
    verify(stream, times(1)).next();

    // Calling getMetadata when pos == valuesCount must not advance the stream to secondChunk
    assertEquals(metadata, iterator.getMetadata());
    verify(stream, times(1)).next();

    // Iterating then advances to secondChunk
    assertTrue(iterator.hasNext());
    verify(stream, times(2)).next();
    assertEquals("val2", iterator.next().getStringValue());
  }

  @Test
  public void testGetMetadataWhenStreamClosedWithoutMetadataThrowsException() {
    when(stream.hasNext()).thenReturn(false);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    SpannerException spannerException = assertThrows(SpannerException.class, iterator::getMetadata);
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
    assertTrue(spannerException.getMessage().contains("Stream closed without sending metadata"));
  }

  @Test
  public void testTypeBeforeMetadataThrowsIllegalStateException() {
    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    assertThrows(IllegalStateException.class, iterator::type);
  }

  @Test
  public void testPrecommitTokenAndStatsCollection() {
    MultiplexedSessionPrecommitToken precommitToken =
        MultiplexedSessionPrecommitToken.newBuilder().setSeqNum(12345).build();
    ResultSetStats stats = ResultSetStats.newBuilder().setRowCountExact(10L).build();
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    PartialResultSet chunk =
        PartialResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().setRowType(rowType))
            .setPrecommitToken(precommitToken)
            .setStats(stats)
            .addValues(stringValue("value"))
            .build();

    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(chunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    assertTrue(iterator.hasNext());
    assertEquals("value", iterator.next().getStringValue());

    verify(listener).onPrecommitToken(precommitToken);
    assertEquals(stats, iterator.getStats());
  }

  @Test
  public void testInitiateStreamingDelegation() {
    AsyncResultSet.StreamMessageListener streamMessageListener =
        mock(AsyncResultSet.StreamMessageListener.class);
    when(stream.initiateStreaming(streamMessageListener)).thenReturn(true);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    assertTrue(iterator.initiateStreaming(streamMessageListener));
    verify(stream).initiateStreaming(streamMessageListener);
  }

  @Test
  public void testIsWithBeginTransactionAndIsLastStatementDelegation() {
    when(stream.isWithBeginTransaction()).thenReturn(true);
    when(stream.isLastStatement()).thenReturn(false);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    assertTrue(iterator.isWithBeginTransaction());
    assertFalse(iterator.isLastStatement());
  }

  @Test
  public void testUnexpectedChunkedPartialResultSetNonMergeable() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.BOOL);
    com.google.protobuf.Value boolValue =
        com.google.protobuf.Value.newBuilder().setBoolValue(true).build();
    PartialResultSet chunk = createChunkWithMetadata(rowType, true, boolValue);

    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(chunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    SpannerException spannerException = assertThrows(SpannerException.class, iterator::hasNext);
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
    assertTrue(spannerException.getMessage().contains("Unexpected chunked PartialResultSet."));
  }

  @Test
  public void testStreamClosedInMiddleOfChunkedValue() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    PartialResultSet chunk = createChunkWithMetadata(rowType, true, stringValue("partial"));

    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(chunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    SpannerException spannerException = assertThrows(SpannerException.class, iterator::hasNext);
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
    assertTrue(
        spannerException.getMessage().contains("Stream closed in the middle of chunked value"));
  }

  @Test
  public void testUnexpectedTypeInMiddleOfChunkedValue() {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    PartialResultSet firstChunk =
        createChunkWithMetadata(rowType, true, stringValue("partial_string"));
    com.google.protobuf.Value nullValue =
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
    PartialResultSet secondChunk = createChunkWithoutMetadata(false, nullValue);

    when(stream.hasNext()).thenReturn(true, true, false);
    when(stream.next()).thenReturn(firstChunk, secondChunk);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    SpannerException spannerException = assertThrows(SpannerException.class, iterator::hasNext);
    assertEquals(ErrorCode.INTERNAL, spannerException.getErrorCode());
    assertTrue(
        spannerException.getMessage().contains("Unexpected type in middle of chunked value"));
  }

  @Test
  public void testIsDataAvailableMetadataOnlyChunkWaitsForDataChunk() {
    StructType rowType =
        createMultiColumnRowType(
            new String[] {"col1", "col2"}, new TypeCode[] {TypeCode.STRING, TypeCode.STRING});
    PartialResultSet metadataChunk =
        PartialResultSet.newBuilder()
            .setMetadata(ResultSetMetadata.newBuilder().setRowType(rowType))
            .build();
    PartialResultSet dataChunk =
        createChunkWithoutMetadata(false, stringValue("val1"), stringValue("val2"));

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(metadataChunk);
    when(stream.isDataAvailable()).thenReturn(false);

    // After buffering metadata-only chunk, completeValues is 0 (< 2 required for 2-column row).
    // isDataAvailable must return false so async callers do not prematurely invoke next() and
    // block.
    assertFalse(iterator.isDataAvailable());

    // When dataChunk becomes available to poll without blocking:
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(dataChunk);

    assertTrue(iterator.isDataAvailable());
    assertTrue(iterator.hasNext());
    assertEquals("val1", iterator.next().getStringValue());
    assertTrue(iterator.hasNext());
    assertEquals("val2", iterator.next().getStringValue());
  }

  @Test
  public void testIsDataAvailableMultipleRowsInSingleChunk() {
    StructType rowType =
        createMultiColumnRowType(
            new String[] {"col1", "col2"}, new TypeCode[] {TypeCode.STRING, TypeCode.STRING});
    PartialResultSet singleChunk =
        createChunkWithMetadata(
            rowType,
            false,
            stringValue("r1c1"),
            stringValue("r1c2"),
            stringValue("r2c1"),
            stringValue("r2c2"));

    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(singleChunk);
    when(stream.isDataAvailable()).thenReturn(false);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);

    // Initial check: singleChunk has 4 values (2 rows of 2 columns)
    assertTrue(iterator.isDataAvailable());

    // Read row 1
    assertTrue(iterator.hasNext());
    assertEquals("r1c1", iterator.next().getStringValue());
    assertTrue(iterator.hasNext());
    assertEquals("r1c2", iterator.next().getStringValue());

    // Even though stream.isDataAvailable() is false, row 2 is buffered in current
    assertFalse(stream.isDataAvailable());
    assertTrue(iterator.isDataAvailable());

    // Read row 2
    assertTrue(iterator.hasNext());
    assertEquals("r2c1", iterator.next().getStringValue());
    assertTrue(iterator.hasNext());
    assertEquals("r2c2", iterator.next().getStringValue());

    // All rows in the chunk are consumed
    assertFalse(iterator.isDataAvailable());
  }

  @Test
  public void testIsDataAvailableEmptyIntermediateChunk() {
    StructType rowType =
        createMultiColumnRowType(
            new String[] {"col1", "col2"}, new TypeCode[] {TypeCode.STRING, TypeCode.STRING});
    PartialResultSet firstChunk = createChunkWithMetadata(rowType, false, stringValue("val1"));
    MultiplexedSessionPrecommitToken token =
        MultiplexedSessionPrecommitToken.newBuilder().setSeqNum(999).build();
    PartialResultSet emptyIntermediateChunk =
        PartialResultSet.newBuilder().setPrecommitToken(token).build();
    PartialResultSet thirdChunk = createChunkWithoutMetadata(false, stringValue("val2"));

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(firstChunk);
    when(stream.isDataAvailable()).thenReturn(false);

    // Chunk 1 has 1 value (row requires 2)
    assertFalse(iterator.isDataAvailable());

    // Intermediate empty chunk arrives (0 values)
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(emptyIntermediateChunk);
    assertFalse(iterator.isDataAvailable());

    // Third chunk arrives with the remaining value
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(thirdChunk);
    assertTrue(iterator.isDataAvailable());

    assertTrue(iterator.hasNext());
    assertEquals("val1", iterator.next().getStringValue());
    assertTrue(iterator.hasNext());
    assertEquals("val2", iterator.next().getStringValue());
    verify(listener).onPrecommitToken(token);
  }

  @Test
  public void testIsDataAvailableCompoundMultiColumnChunking() {
    StructType rowType =
        createMultiColumnRowType(
            new String[] {"col1", "col2"}, new TypeCode[] {TypeCode.STRING, TypeCode.STRING});
    PartialResultSet firstChunk =
        createChunkWithMetadata(rowType, true, stringValue("val1_part1_"));
    PartialResultSet secondChunk =
        createChunkWithoutMetadata(true, stringValue("part2"), stringValue("val2_part1_"));
    PartialResultSet thirdChunk = createChunkWithoutMetadata(false, stringValue("part2"));

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(firstChunk);
    when(stream.isDataAvailable()).thenReturn(false);

    // Chunk 1 has 1 incomplete trailing value, so 0 complete values are buffered
    assertFalse(iterator.isDataAvailable());

    // Chunk 2 completes col1 ("val1_part1_part2"), but starts chunked col2 ("val2_part1_")
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(secondChunk);

    // Total complete values is 1 (only col1 is complete, row needs 2). Still false!
    assertFalse(iterator.isDataAvailable());

    // Chunk 3 arrives completing col2 ("val2_part1_part2")
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(true, false);
    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next()).thenReturn(thirdChunk);
    assertTrue(iterator.isDataAvailable());

    assertTrue(iterator.hasNext());
    assertEquals("val1_part1_part2", iterator.next().getStringValue());
    assertTrue(iterator.hasNext());
    assertEquals("val2_part1_part2", iterator.next().getStringValue());
  }

  @Test
  public void testConcurrentIsDataAvailableAndAdvance() throws Exception {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    int rowCount = 100;
    List<PartialResultSet> chunks = new ArrayList<>(rowCount);
    for (int index = 0; index < rowCount; index++) {
      if (index == 0) {
        chunks.add(createChunkWithMetadata(rowType, false, stringValue("val_" + index)));
      } else {
        chunks.add(createChunkWithoutMetadata(false, stringValue("val_" + index)));
      }
    }

    AtomicInteger streamIndex = new AtomicInteger(0);
    when(stream.canPollWithoutErrorOrBlocking())
        .thenAnswer(invocation -> streamIndex.get() < chunks.size());
    when(stream.hasNext()).thenAnswer(invocation -> streamIndex.get() < chunks.size());
    when(stream.next())
        .thenAnswer(
            invocation -> {
              int currentIndex = streamIndex.getAndIncrement();
              if (currentIndex < chunks.size()) {
                return chunks.get(currentIndex);
              }
              throw new NoSuchElementException("No more chunks available in stream");
            });

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    AtomicBoolean running = new AtomicBoolean(true);
    AtomicReference<Throwable> errorRef = new AtomicReference<>();

    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      // Thread 1: repeatedly checks isDataAvailable
      Future<?> future1 =
          executor.submit(
              () -> {
                while (running.get()) {
                  try {
                    iterator.isDataAvailable();
                    Thread.yield();
                  } catch (Throwable t) {
                    errorRef.set(t);
                    break;
                  }
                }
              });

      // Thread 2: consumes rows
      Future<?> future2 =
          executor.submit(
              () -> {
                try {
                  for (int index = 0; index < rowCount; index++) {
                    assertTrue(iterator.hasNext());
                    assertEquals("val_" + index, iterator.next().getStringValue());
                  }
                } catch (Throwable t) {
                  errorRef.set(t);
                } finally {
                  running.set(false);
                }
              });

      future2.get(10, TimeUnit.SECONDS);
      future1.get(10, TimeUnit.SECONDS);
      if (errorRef.get() != null) {
        throw new AssertionError("Concurrent execution failed", errorRef.get());
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testIsDataAvailableDoesNotBlockWhenAdvanceToNextChunkIsPollingStream()
      throws Exception {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    PartialResultSet chunk = createChunkWithMetadata(rowType, false, stringValue("val1"));

    CountDownLatch streamNextEnteredLatch = new CountDownLatch(1);
    CountDownLatch allowStreamNextToCompleteLatch = new CountDownLatch(1);

    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next())
        .thenAnswer(
            invocation -> {
              streamNextEnteredLatch.countDown();
              allowStreamNextToCompleteLatch.await();
              return chunk;
            });
    when(stream.canPollWithoutErrorOrBlocking()).thenReturn(false);
    when(stream.isDataAvailable()).thenReturn(false);

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      // Thread 1 initiates hasNext(), which enters advanceToNextChunk() -> stream.next()
      Future<Boolean> consumerFuture = executor.submit(iterator::hasNext);

      // Deterministically wait until Thread 1 is inside stream.next() holding streamPollLock
      assertTrue(streamNextEnteredLatch.await(5, TimeUnit.SECONDS));

      // At this point, Thread 1 holds streamPollLock and is blocked in stream.next().
      // isDataAvailable() must NOT block waiting for streamPollLock; tryLock() returns false,
      // and isDataAvailable() returns immediately without blocking.
      assertFalse(iterator.isDataAvailable());

      // Release Thread 1 to finish stream.next()
      allowStreamNextToCompleteLatch.countDown();

      // Consumer finishes successfully
      assertTrue(consumerFuture.get(5, TimeUnit.SECONDS));
      assertEquals("val1", iterator.next().getStringValue());
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testCloseWhileStreamNextIsInFlightDoesNotResurrectState() throws Exception {
    StructType rowType = createSingleColumnRowType("col", TypeCode.STRING);
    PartialResultSet chunk = createChunkWithMetadata(rowType, false, stringValue("val1"));

    CountDownLatch streamNextEnteredLatch = new CountDownLatch(1);
    CountDownLatch allowStreamNextToCompleteLatch = new CountDownLatch(1);

    when(stream.hasNext()).thenReturn(true, false);
    when(stream.next())
        .thenAnswer(
            invocation -> {
              streamNextEnteredLatch.countDown();
              allowStreamNextToCompleteLatch.await();
              return chunk;
            });

    GrpcValueIterator iterator = new GrpcValueIterator(stream, listener);
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      // Thread 1 initiates hasNext(), which enters stream.next()
      Future<Boolean> consumerFuture = executor.submit(iterator::hasNext);

      // Deterministically wait until Thread 1 is in flight inside stream.next()
      assertTrue(streamNextEnteredLatch.await(5, TimeUnit.SECONDS));

      // Close the iterator while stream.next() is in flight
      iterator.close("Cancelled");

      // Now allow stream.next() to finish returning chunk
      allowStreamNextToCompleteLatch.countDown();

      // Because closed is true, advanceToNextChunk() must discard chunk, avoid setting current,
      // and return false. hasNext() must return false.
      assertFalse(consumerFuture.get(5, TimeUnit.SECONDS));
      assertFalse(iterator.hasNext());
    } finally {
      executor.shutdownNow();
    }
  }
}
