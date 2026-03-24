/*
 * Copyright 2017 Google LLC
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

import static com.google.common.testing.SerializableTester.reserialize;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.MultiplexedSessionPrecommitToken;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.QueryPlan;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.ResultSetStats;
import com.google.spanner.v1.Transaction;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link GrpcResultSet}. */
@RunWith(JUnit4.class)
public class GrpcResultSetTest {

  private GrpcResultSet resultSet;
  private SpannerRpc.ResultStreamConsumer consumer;
  private GrpcStreamIterator stream;
  private final Duration streamWaitTimeout = Duration.ofNanos(1L);

  private static class NoOpListener implements AbstractResultSet.Listener {
    @Override
    public void onTransactionMetadata(Transaction transaction, boolean shouldIncludeId)
        throws SpannerException {}

    @Override
    public SpannerException onError(
        SpannerException e, boolean withBeginTransaction, boolean lastStatement) {
      return e;
    }

    @Override
    public void onDone(boolean withBeginTransaction) {}

    @Override
    public void onPrecommitToken(MultiplexedSessionPrecommitToken token) {}
  }

  @Before
  public void setUp() {
    stream =
        new GrpcStreamIterator(
            /* lastStatement= */ false, 10, /* cancelQueryWhenClientIsClosed= */ false);
    stream.setCall(
        new SpannerRpc.StreamingCall() {
          @Override
          public ApiCallContext getCallContext() {
            return GrpcCallContext.createDefault().withStreamWaitTimeoutDuration(streamWaitTimeout);
          }

          @Override
          public void cancel(@Nullable String message) {}

          @Override
          public void request(int numMessages) {}
        },
        false);
    consumer = stream.consumer();
    resultSet = new GrpcResultSet(stream, new NoOpListener());
  }

  public GrpcResultSet resultSetWithMode(QueryMode queryMode) {
    return new GrpcResultSet(stream, new NoOpListener());
  }

  @Test
  public void testStreamTimeout() {
    // We don't add any results to the stream. That means that it will time out after 1ns.
    SpannerException exception = assertThrows(SpannerException.class, resultSet::next);
    assertEquals(ErrorCode.DEADLINE_EXCEEDED, exception.getErrorCode());
    assertTrue(exception.getMessage(), exception.getMessage().contains("stream wait timeout"));
  }

  @Test
  public void metadata() {
    Type rowType = Type.struct(Type.StructField.of("f", Type.string()));
    ResultSetMetadata.Builder metadataBuilder = ResultSetMetadata.newBuilder();
    metadataBuilder
        .setRowType(rowType.toProto().getStructType())
        .getTransactionBuilder()
        .setId(ByteString.copyFromUtf8("t1"));
    PartialResultSet partialResultSet =
        PartialResultSet.newBuilder().setMetadata(metadataBuilder.build()).build();

    consumer.onPartialResultSet(partialResultSet);
    consumer.onCompleted();
    assertThat(resultSet.next()).isFalse();
    assertThat(resultSet.getType()).isEqualTo(rowType);
  }

  @Test
  public void metadataFailure() {
    SpannerException t =
        SpannerExceptionFactory.newSpannerException(ErrorCode.DEADLINE_EXCEEDED, "outatime");
    consumer.onError(t);
    SpannerException e = assertThrows(SpannerException.class, () -> resultSet.next());
    assertEquals(ErrorCode.DEADLINE_EXCEEDED, e.getErrorCode());
    assertThat(e.getMessage()).contains("outatime");
  }

  @Test
  public void noMetadata() {
    consumer.onCompleted();
    SpannerException e = assertThrows(SpannerException.class, () -> resultSet.next());
    assertEquals(ErrorCode.INTERNAL, e.getErrorCode());
  }

  @Test
  public void empty() {
    Type type = Type.struct(Type.StructField.of("f", Type.string()));
    PartialResultSet partialResultSet =
        PartialResultSet.newBuilder().setMetadata(makeMetadata(type)).build();
    consumer.onPartialResultSet(partialResultSet);
    consumer.onCompleted();
    assertThat(resultSet.next()).isFalse();
    assertThat(resultSet.getType()).isEqualTo(type);
  }

  @Test
  public void emptyMultipleResponses() {
    PartialResultSet partialResultSet =
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .build();
    consumer.onPartialResultSet(partialResultSet);
    consumer.onPartialResultSet(PartialResultSet.getDefaultInstance());
    consumer.onPartialResultSet(PartialResultSet.getDefaultInstance());
    consumer.onCompleted();
    assertThat(resultSet.next()).isFalse();
  }

  private List<String> consumeAllString() {
    List<String> results = new ArrayList<>();
    while (resultSet.next()) {
      results.add(resultSet.getString(0));
    }
    return results;
  }

  @Test
  public void singleResponse() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .addValues(Value.string("a").toProto())
            .addValues(Value.string("b").toProto())
            .addValues(Value.string("c").toProto())
            .build());
    consumer.onCompleted();
    assertThat(consumeAllString()).containsExactly("a", "b", "c").inOrder();
  }

  @Test
  public void multiResponse() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .addValues(Value.string("a").toProto())
            .addValues(Value.string("b").toProto())
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(Value.string("c").toProto())
            .addValues(Value.string("d").toProto())
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(Value.string("e").toProto())
            .addValues(Value.string("f").toProto())
            .build());
    consumer.onCompleted();
    assertThat(consumeAllString()).containsExactly("a", "b", "c", "d", "e", "f").inOrder();
  }

  @Test
  public void multiResponseChunkingStreamClosed() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .addValues(Value.string("abcdefg").toProto())
            .setChunkedValue(true)
            .build());
    consumer.onCompleted();
    SpannerException e = assertThrows(SpannerException.class, () -> resultSet.next());
    assertEquals(ErrorCode.INTERNAL, e.getErrorCode());
  }

  @Test
  public void multiResponseChunkingStrings() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.string()))))
            .addValues(Value.string("before").toProto())
            .addValues(Value.string("abcdefg").toProto())
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(Value.string("hijklmnop").toProto())
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(Value.string("qrstuvwxyz").toProto())
            .addValues(Value.string("after").toProto())
            .setChunkedValue(false)
            .build());
    consumer.onCompleted();
    assertThat(consumeAllString())
        .containsExactly("before", "abcdefghijklmnopqrstuvwxyz", "after")
        .inOrder();
  }

  @Test
  public void multiResponseChunkingBytes() {
    ByteArray expectedBytes = ByteArray.copyFrom("abcdefghijklmnopqrstuvwxyz");
    String base64 = expectedBytes.toBase64();
    String chunk1 = base64.substring(0, 10);
    String chunk2 = base64.substring(10, 20);
    String chunk3 = base64.substring(20);
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.bytes()))))
            .addValues(Value.bytes(ByteArray.copyFrom("before")).toProto())
            .addValues(com.google.protobuf.Value.newBuilder().setStringValue(chunk1))
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(com.google.protobuf.Value.newBuilder().setStringValue(chunk2))
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(com.google.protobuf.Value.newBuilder().setStringValue(chunk3))
            .addValues(Value.bytes(ByteArray.copyFrom("after")).toProto())
            .setChunkedValue(false)
            .build());
    consumer.onCompleted();
    List<ByteArray> results = new ArrayList<>();
    while (resultSet.next()) {
      results.add(resultSet.getBytes(0));
    }
    assertThat(results)
        .containsExactly(ByteArray.copyFrom("before"), expectedBytes, ByteArray.copyFrom("after"))
        .inOrder();
  }

  @Test
  public void multiResponseChunkingBoolArray() {
    List<Boolean> beforeValue = Collections.singletonList(true);
    List<Boolean> chunkedValue = Arrays.asList(false, null, true, true, true, null, null, false);
    List<Boolean> afterValue = Collections.singletonList(true);
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.bool(),
        input -> Value.boolArray(input).toProto(),
        input -> input.getBooleanList(0));
  }

  @Test
  public void multiResponseChunkingInt64Array() {
    List<Long> beforeValue = Collections.singletonList(10L);
    List<Long> chunkedValue = Arrays.asList(1L, 2L, null, null, 5L, null, 7L, 8L);
    List<Long> afterValue = Collections.singletonList(20L);
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.int64(),
        input -> Value.int64Array(input).toProto(),
        input -> input.getLongList(0));
  }

  @Test
  public void multiResponseChunkingFloat64Array() {
    List<Double> beforeValue = Collections.singletonList(10.0);
    List<Double> chunkedValue = Arrays.asList(null, 2.0, 3.0, 4.0, null, 6.0, 7.0, null);
    List<Double> afterValue = Collections.singletonList(20.0);
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.float64(),
        input -> Value.float64Array(input).toProto(),
        input -> input.getDoubleList(0));
  }

  @Test
  public void multiResponseChunkingStringArray() {
    List<String> beforeValue = Collections.singletonList("before");
    List<String> chunkedValue = Arrays.asList("a", "b", null, "d", null, "f", null, "h");
    List<String> afterValue = Collections.singletonList("after");
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.string(),
        input -> Value.stringArray(input).toProto(),
        input -> input.getStringList(0));
  }

  private static ByteArray b(String data) {
    return ByteArray.copyFrom(data);
  }

  @Test
  public void multiResponseChunkingBytesArray() {
    List<ByteArray> beforeValue = Collections.singletonList(b("before"));
    List<ByteArray> chunkedValue =
        Arrays.asList(b("a"), b("b"), null, b("d"), null, b("f"), null, b("h"));
    List<ByteArray> afterValue = Collections.singletonList(b("after"));
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        Type.bytes(),
        input -> Value.bytesArray(input).toProto(),
        input -> input.getBytesList(0));
  }

  private static Struct s(String a, long b) {
    return Struct.newBuilder().set("a").to(a).set("b").to(b).build();
  }

  @Test
  public void multiResponseChunkingStructArray() {
    final Type elementType =
        Type.struct(
            Type.StructField.of("a", Type.string()), Type.StructField.of("b", Type.int64()));
    List<Struct> beforeValue = Collections.singletonList(s("before", 10));
    List<Struct> chunkedValue =
        Arrays.asList(
            s("a", 1), s("b", 2), s("c", 3), null, s(null, 5), null, s("g", 7), s("h", 8));
    List<Struct> afterValue = Collections.singletonList(s("after", 20));
    doArrayTest(
        beforeValue,
        chunkedValue,
        afterValue,
        elementType,
        input -> Value.structArray(elementType, input).toProto(),
        input -> input.getStructList(0));
  }

  @Test
  public void profileResultInFinalResultSet() {
    Map<String, com.google.protobuf.Value> statsMap =
        ImmutableMap.of(
            "f1", Value.string("").toProto(),
            "f2", Value.string("").toProto());
    ResultSetStats stats =
        ResultSetStats.newBuilder()
            .setQueryPlan(QueryPlan.newBuilder().build())
            .setQueryStats(com.google.protobuf.Struct.newBuilder().putAllFields(statsMap).build())
            .build();
    ArrayList<Type.StructField> dataType = new ArrayList<>();
    dataType.add(Type.StructField.of("data", Type.string()));
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(dataType)))
            .addValues(Value.string("d1").toProto())
            .setChunkedValue(false)
            .setStats(stats)
            .build());
    resultSet = resultSetWithMode(QueryMode.PROFILE);
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.next()).isFalse();
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(stats).isEqualTo(receivedStats);
    resultSet.close();
  }

  @Test
  public void profileResultInExtraFinalResultSet() {
    Map<String, com.google.protobuf.Value> statsMap =
        ImmutableMap.of(
            "f1", Value.string("").toProto(),
            "f2", Value.string("").toProto());
    ResultSetStats stats =
        ResultSetStats.newBuilder()
            .setQueryPlan(QueryPlan.newBuilder().build())
            .setQueryStats(com.google.protobuf.Struct.newBuilder().putAllFields(statsMap).build())
            .build();
    ArrayList<Type.StructField> dataType = new ArrayList<>();
    dataType.add(Type.StructField.of("data", Type.string()));
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(dataType)))
            .addValues(Value.string("d1").toProto())
            .setChunkedValue(false)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(dataType)))
            .setChunkedValue(false)
            .setStats(stats)
            .build());
    resultSet = resultSetWithMode(QueryMode.PROFILE);
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.next()).isFalse();
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(stats).isEqualTo(receivedStats);
    resultSet.close();
  }

  @Test
  public void planResult() {
    ResultSetStats stats =
        ResultSetStats.newBuilder().setQueryPlan(QueryPlan.newBuilder().build()).build();
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(new ArrayList<>())))
            .setChunkedValue(false)
            .setStats(stats)
            .build());
    resultSet = resultSetWithMode(QueryMode.PLAN);
    consumer.onCompleted();
    assertThat(resultSet.next()).isFalse();
    ResultSetStats receivedStats = resultSet.getStats();
    assertThat(stats).isEqualTo(receivedStats);
    resultSet.close();
  }

  @Test
  public void statsUnavailable() {
    ResultSetStats stats = ResultSetStats.newBuilder().build();
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(new ArrayList<>())))
            .setChunkedValue(false)
            .setStats(stats)
            .build());
    resultSet = resultSetWithMode(QueryMode.PROFILE);
    consumer.onCompleted();
    assertThat(resultSet.getStats()).isNull();
  }

  private <T> void doArrayTest(
      List<T> beforeValue,
      List<T> chunkedValue,
      List<T> afterValue,
      Type elementType,
      Function<List<T>, com.google.protobuf.Value> toProto,
      Function<StructReader, List<T>> getter) {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(elementType)))))
            .addValues(toProto.apply(beforeValue))
            .addValues(toProto.apply(chunkedValue.subList(0, 3)))
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(toProto.apply(chunkedValue.subList(3, 5)))
            .setChunkedValue(true)
            .build());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .addValues(toProto.apply(chunkedValue.subList(5, chunkedValue.size())))
            .addValues(toProto.apply(afterValue))
            .setChunkedValue(false)
            .build());
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(getter.apply(resultSet)).containsExactlyElementsIn(beforeValue).inOrder();
    assertThat(resultSet.next()).isTrue();
    assertThat(getter.apply(resultSet)).containsExactlyElementsIn(chunkedValue).inOrder();
    assertThat(resultSet.next()).isTrue();
    assertThat(getter.apply(resultSet)).containsExactlyElementsIn(afterValue).inOrder();
    assertThat(resultSet.next()).isFalse();
  }

  private static ResultSetMetadata makeMetadata(Type rowType) {
    com.google.spanner.v1.Type typeProto = rowType.toProto();
    return ResultSetMetadata.newBuilder().setRowType(typeProto.getStructType()).build();
  }

  @Test
  public void serialization() {
    Type structType =
        Type.struct(
            Arrays.asList(
                Type.StructField.of("a", Type.string()), Type.StructField.of("b", Type.int64())));

    verifySerialization(
        Value.string("a"),
        Value.string(null),
        Value.bool(true),
        Value.bool(null),
        Value.int64(1),
        Value.int64(null),
        Value.float64(1.0),
        Value.float64(null),
        Value.float32(1.0f),
        Value.float32(null),
        Value.bytes(ByteArray.fromBase64("abcd")),
        Value.bytesFromBase64(
            Base64.getEncoder().encodeToString("test".getBytes(StandardCharsets.UTF_8))),
        Value.bytes(null),
        Value.bytesFromBase64(null),
        Value.timestamp(Timestamp.ofTimeSecondsAndNanos(1, 2)),
        Value.timestamp(null),
        Value.date(Date.fromYearMonthDay(2017, 4, 17)),
        Value.date(null),
        Value.uuid(UUID.randomUUID()),
        Value.uuid(null),
        Value.interval(
            Interval.builder()
                .setMonths(100)
                .setDays(10)
                .setNanos(BigInteger.valueOf(1000010))
                .build()),
        Value.interval(null),
        Value.stringArray(ImmutableList.of("one", "two")),
        Value.stringArray(null),
        Value.boolArray(new boolean[] {true, false}),
        Value.boolArray((boolean[]) null),
        Value.int64Array(new long[] {1, 2, 3}),
        Value.int64Array((long[]) null),
        Value.float64Array(new double[] {1.1, 2.2, 3.3}),
        Value.float64Array((double[]) null),
        Value.float32Array(new float[] {1.1f, 2.2f, 3.3f}),
        Value.float32Array((float[]) null),
        Value.bytesArray(Arrays.asList(ByteArray.fromBase64("abcd"), null)),
        Value.bytesArrayFromBase64(
            Arrays.asList(
                Base64.getEncoder().encodeToString("test".getBytes(StandardCharsets.UTF_8)), null)),
        Value.bytesArray(null),
        Value.bytesArrayFromBase64(null),
        Value.timestampArray(ImmutableList.of(Timestamp.MAX_VALUE, Timestamp.MAX_VALUE)),
        Value.timestampArray(null),
        Value.dateArray(
            ImmutableList.of(
                Date.fromYearMonthDay(2017, 4, 17), Date.fromYearMonthDay(2017, 5, 18))),
        Value.dateArray(null),
        Value.uuidArray(ImmutableList.of(UUID.randomUUID(), UUID.randomUUID())),
        Value.uuidArray(null),
        Value.intervalArray(
            ImmutableList.of(
                Interval.parseFromString("P0Y"),
                Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(30000L)))),
        Value.intervalArray(null),
        Value.struct(s(null, 30)),
        Value.struct(structType, null),
        Value.structArray(structType, Arrays.asList(s("def", 10), null)),
        Value.structArray(structType, Collections.singletonList(null)),
        Value.structArray(structType, null));
  }

  @Test
  public void nestedStructSerialization() {
    Type structType =
        Type.struct(
            Arrays.asList(
                Type.StructField.of("a", Type.string()), Type.StructField.of("b", Type.int64())));

    Struct nestedStruct = s("1", 2L);
    Value struct = Value.structArray(structType, Collections.singletonList(nestedStruct));
    verifySerialization(
        new Function<Value, com.google.protobuf.Value>() {

          @Override
          @Nullable
          public com.google.protobuf.Value apply(@Nullable Value input) {
            return input.toProto();
          }
        },
        struct);
  }

  private void verifySerialization(Value... values) {
    verifySerialization(
        new Function<Value, com.google.protobuf.Value>() {

          @Override
          @Nullable
          public com.google.protobuf.Value apply(@Nullable Value input) {
            return input.toProto();
          }
        },
        values);
  }

  private void verifySerialization(
      Function<Value, com.google.protobuf.Value> protoFn, Value... values) {
    resultSet = new GrpcResultSet(stream, new NoOpListener());
    PartialResultSet.Builder builder = PartialResultSet.newBuilder();
    List<Type.StructField> types = new ArrayList<>();
    for (Value value : values) {
      types.add(Type.StructField.of("f", value.getType()));
      builder.addValues(protoFn.apply(value));
    }
    consumer.onPartialResultSet(builder.setMetadata(makeMetadata(Type.struct(types))).build());
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    Struct row = resultSet.getCurrentRowAsStruct();
    Struct copy = reserialize(row);
    assertThat(row).isEqualTo(copy);
  }

  @Test
  public void getBoolean() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.bool()))))
            .addValues(Value.bool(true).toProto())
            .addValues(Value.bool(false).toProto())
            .build());
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getBoolean(0)).isTrue();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getBoolean(0)).isFalse();
  }

  @Test
  public void getDouble() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.float64()))))
            .addValues(Value.float64(Double.MIN_VALUE).toProto())
            .addValues(Value.float64(Double.MAX_VALUE).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getDouble(0)).isWithin(0.0).of(Double.MIN_VALUE);
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getDouble(0)).isWithin(0.0).of(Double.MAX_VALUE);
  }

  @Test
  public void getFloat() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.float32()))))
            .addValues(Value.float32(Float.MIN_VALUE).toProto())
            .addValues(Value.float32(Float.MAX_VALUE).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getFloat(0)).isWithin(0.0f).of(Float.MIN_VALUE);
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getFloat(0)).isWithin(0.0f).of(Float.MAX_VALUE);
  }

  @Test
  public void getBigDecimal() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.numeric()))))
            .addValues(
                Value.numeric(
                        new BigDecimal(
                            "-" + Strings.repeat("9", 29) + "." + Strings.repeat("9", 9)))
                    .toProto())
            .addValues(
                Value.numeric(
                        new BigDecimal(Strings.repeat("9", 29) + "." + Strings.repeat("9", 9)))
                    .toProto())
            .addValues(Value.numeric(BigDecimal.ZERO).toProto())
            .addValues(Value.numeric(new BigDecimal("1.23456")).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getBigDecimal(0).toPlainString())
        .isEqualTo("-99999999999999999999999999999.999999999");
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getBigDecimal(0).toPlainString())
        .isEqualTo("99999999999999999999999999999.999999999");
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getBigDecimal(0)).isEqualTo(BigDecimal.ZERO);
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getBigDecimal(0)).isEqualTo(BigDecimal.valueOf(123456, 5));
  }

  @Test
  public void getLong() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.int64()))))
            .addValues(Value.int64(Long.MIN_VALUE).toProto())
            .addValues(Value.int64(Long.MAX_VALUE).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getLong(0)).isEqualTo(Long.MIN_VALUE);
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getLong(0)).isEqualTo(Long.MAX_VALUE);
  }

  @Test
  public void getDate() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.date()))))
            .addValues(Value.date(Date.fromYearMonthDay(2018, 5, 29)).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getDate(0)).isEqualTo(Date.fromYearMonthDay(2018, 5, 29));
  }

  @Test
  public void getUuid() {
    final UUID uuid = UUID.randomUUID();
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.uuid()))))
            .addValues(Value.uuid(uuid).toProto())
            .build());
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getUuid(0)).isEqualTo(uuid);
  }

  @Test
  public void getInterval() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.interval()))))
            .addValues(
                Value.interval(Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(12345678)))
                    .toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getInterval(0))
        .isEqualTo(Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(12345678)));
  }

  @Test
  public void getTimestamp() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.timestamp()))))
            .addValues(Value.timestamp(Timestamp.parseTimestamp("0001-01-01T00:00:00Z")).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getTimestamp(0))
        .isEqualTo(Timestamp.parseTimestamp("0001-01-01T00:00:00Z"));
  }

  @Test
  public void getJson() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.json()))))
            .addValues(Value.json("{\"color\":\"red\",\"value\":\"#f00\"}").toProto())
            .addValues(Value.json("{}").toProto())
            .addValues(Value.json("[]").toProto())
            .build());
    consumer.onCompleted();

    assertTrue(resultSet.next());
    assertEquals("{\"color\":\"red\",\"value\":\"#f00\"}", resultSet.getJson(0));
    assertTrue(resultSet.next());
    assertEquals("{}", resultSet.getJson(0));
    assertTrue(resultSet.next());
    assertEquals("[]", resultSet.getJson(0));
  }

  @Test
  public void getPgJsonb() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.pgJsonb()))))
            .addValues(Value.pgJsonb("{\"color\":\"red\",\"value\":\"#f00\"}").toProto())
            .addValues(Value.pgJsonb("{}").toProto())
            .addValues(Value.pgJsonb("[]").toProto())
            .build());
    consumer.onCompleted();

    assertTrue(resultSet.next());
    assertEquals("{\"color\":\"red\",\"value\":\"#f00\"}", resultSet.getPgJsonb(0));
    assertTrue(resultSet.next());
    assertEquals("{}", resultSet.getPgJsonb(0));
    assertTrue(resultSet.next());
    assertEquals("[]", resultSet.getPgJsonb(0));
  }

  @Test
  public void getPgOid() {
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(makeMetadata(Type.struct(Type.StructField.of("f", Type.pgOid()))))
            .addValues(Value.pgOid(Long.MIN_VALUE).toProto())
            .addValues(Value.pgOid(Long.MAX_VALUE).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getLong(0)).isEqualTo(Long.MIN_VALUE);
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getLong(0)).isEqualTo(Long.MAX_VALUE);
  }

  @Test
  public void getProtoMessage() {
    SingerInfo singerInfo1 =
        SingerInfo.newBuilder()
            .setSingerId(111)
            .setNationality("COUNTRY1")
            .setGenre(Genre.FOLK)
            .build();
    SingerInfo singerInfo2 = SingerInfo.newBuilder().setSingerId(222).setGenre(Genre.JAZZ).build();
    String singerInfoFullName = SingerInfo.getDescriptor().getFullName();

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.proto(singerInfoFullName)))))
            .addValues(Value.protoMessage(singerInfo1).toProto())
            .addValues(
                Value.protoMessage(
                        ByteArray.copyFrom(singerInfo2.toByteArray()), singerInfoFullName)
                    .toProto())
            .addValues(Value.protoMessage(null, SingerInfo.getDescriptor().getFullName()).toProto())
            .build());
    consumer.onCompleted();

    assertTrue(resultSet.next());
    assertEquals(singerInfo1, resultSet.getProtoMessage(0, SingerInfo.getDefaultInstance()));
    assertTrue(resultSet.next());
    assertEquals(singerInfo2, resultSet.getProtoMessage(0, SingerInfo.getDefaultInstance()));
    assertTrue(resultSet.next());
    assertThrows(
        NullPointerException.class,
        () -> {
          resultSet.getProtoMessage(0, SingerInfo.getDefaultInstance());
        });
  }

  @Test
  public void getProtoEnum() {
    String genreFullyQualifiedName = Genre.getDescriptor().getFullName();
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(
                    Type.struct(Type.StructField.of("f", Type.protoEnum(genreFullyQualifiedName)))))
            .addValues(Value.protoEnum(Genre.FOLK).toProto())
            .addValues(Value.protoEnum(Genre.JAZZ.getNumber(), genreFullyQualifiedName).toProto())
            .addValues(Value.protoEnum(null, genreFullyQualifiedName).toProto())
            .build());
    consumer.onCompleted();

    assertTrue(resultSet.next());
    assertEquals(Genre.FOLK, resultSet.getProtoEnum(0, Genre::forNumber));
    assertTrue(resultSet.next());
    assertEquals(Genre.JAZZ, resultSet.getProtoEnum(0, Genre::forNumber));
    assertTrue(resultSet.next());
    assertThrows(
        NullPointerException.class,
        () -> {
          resultSet.getProtoEnum(0, Genre::forNumber);
        });
  }

  @Test
  public void getBooleanArray() {
    boolean[] boolArray = {true, true, false};
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.bool())))))
            .addValues(Value.boolArray(boolArray).toProto())
            .build());
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getBooleanArray(0)).isEqualTo(boolArray);
  }

  @Test
  public void getLongArray() {
    long[] longArray = {111, 333, 444, 0, -1, -2234, Long.MAX_VALUE, Long.MIN_VALUE};

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.int64())))))
            .addValues(Value.int64Array(longArray).toProto())
            .build());
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getLongArray(0)).isEqualTo(longArray);
  }

  @Test
  public void getDoubleArray() {
    double[] doubleArray = {Double.MAX_VALUE, Double.MIN_VALUE, 111, 333, 444, 0, -1, -2234};

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.float64())))))
            .addValues(Value.float64Array(doubleArray).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getDoubleArray(0))
        .usingTolerance(0.0)
        .containsExactly(doubleArray)
        .inOrder();
  }

  @Test
  public void getFloatArray() {
    float[] floatArray = {Float.MAX_VALUE, Float.MIN_VALUE, 111, 333, 444, 0, -1, -2234};

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.float32())))))
            .addValues(Value.float32Array(floatArray).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getFloatArray(0))
        .usingTolerance(0.0)
        .containsExactly(floatArray)
        .inOrder();
  }

  @Test
  public void getBigDecimalList() {
    List<BigDecimal> bigDecimalsList = new ArrayList<>();
    bigDecimalsList.add(BigDecimal.valueOf(Double.MIN_VALUE));
    bigDecimalsList.add(BigDecimal.valueOf(Double.MAX_VALUE));
    bigDecimalsList.add(BigDecimal.ZERO);
    bigDecimalsList.add(new BigDecimal("1.23456"));

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.numeric())))))
            .addValues(Value.numericArray(bigDecimalsList).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getBigDecimalList(0)).isEqualTo(bigDecimalsList);
  }

  @Test
  public void getTimestampList() {
    List<Timestamp> timestampList = new ArrayList<>();
    timestampList.add(Timestamp.parseTimestamp("0001-01-01T00:00:00Z"));
    timestampList.add(Timestamp.parseTimestamp("0002-02-02T02:00:00Z"));

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.timestamp())))))
            .addValues(Value.timestampArray(timestampList).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getTimestampList(0)).isEqualTo(timestampList);
  }

  @Test
  public void getDateList() {
    List<Date> dateList = new ArrayList<>();
    dateList.add(Date.fromYearMonthDay(1999, 8, 23));
    dateList.add(Date.fromYearMonthDay(1986, 3, 17));

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.date())))))
            .addValues(Value.dateArray(dateList).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getDateList(0)).isEqualTo(dateList);
  }

  @Test
  public void getUuidList() {
    List<UUID> uuidList = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.uuid())))))
            .addValues(Value.uuidArray(uuidList).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getUuidList(0)).isEqualTo(uuidList);
  }

  @Test
  public void getIntervalList() {
    List<Interval> intervalList = new ArrayList<>();
    intervalList.add(Interval.fromMonthsDaysNanos(10, 20, BigInteger.valueOf(100)));
    intervalList.add(Interval.fromMonthsDaysNanos(-10, -20, BigInteger.valueOf(134520)));

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.interval())))))
            .addValues(Value.intervalArray(intervalList).toProto())
            .build());
    consumer.onCompleted();

    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getIntervalList(0)).isEqualTo(intervalList);
  }

  @Test
  public void getJsonList() {
    List<String> jsonList = new ArrayList<>();
    jsonList.add("{\"color\":\"red\",\"value\":\"#f00\"}");
    jsonList.add("{\"special\":\"%😃∮πρότερονแผ่นดินฮั่นเสื่อมሰማይᚻᛖ\"}");
    jsonList.add("[]");

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.json())))))
            .addValues(Value.jsonArray(jsonList).toProto())
            .build());
    consumer.onCompleted();

    assertTrue(resultSet.next());
    assertEquals(jsonList, resultSet.getJsonList(0));
  }

  @Test
  public void getPgJsonbList() {
    List<String> jsonList = new ArrayList<>();
    jsonList.add("{\"color\":\"red\",\"value\":\"#f00\"}");
    jsonList.add("{\"special\":\"%😃∮πρότερονแผ่นดินฮั่นเสื่อมሰማይᚻᛖ\"}");
    jsonList.add("[]");

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.pgJsonb())))))
            .addValues(Value.pgJsonbArray(jsonList).toProto())
            .build());
    consumer.onCompleted();

    assertTrue(resultSet.next());
    assertEquals(jsonList, resultSet.getPgJsonbList(0));
  }

  @Test
  public void getPgOidArray() {
    long[] longArray = {111, 333, 444, 0, -1, -2234, Long.MAX_VALUE, Long.MIN_VALUE};

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.pgOid())))))
            .addValues(Value.pgOidArray(longArray).toProto())
            .build());
    consumer.onCompleted();
    assertThat(resultSet.next()).isTrue();
    assertThat(resultSet.getLongArray(0)).isEqualTo(longArray);
  }

  @Test
  public void getProtoMessageList() {
    SingerInfo singerInfo1 =
        SingerInfo.newBuilder()
            .setSingerId(111)
            .setNationality("COUNTRY1")
            .setGenre(Genre.FOLK)
            .build();
    SingerInfo singerInfo2 = SingerInfo.newBuilder().setSingerId(222).setGenre(Genre.JAZZ).build();
    String singerInfoFullName = SingerInfo.getDescriptor().getFullName();

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(
                    Type.struct(
                        Type.StructField.of("f", Type.array(Type.proto(singerInfoFullName))))))
            .addValues(
                Value.protoMessageArray(
                        Arrays.asList(singerInfo1, singerInfo2), SingerInfo.getDescriptor())
                    .toProto())
            .addValues(
                Value.protoMessageArray(
                        Arrays.asList(singerInfo2, null, singerInfo1), SingerInfo.getDescriptor())
                    .toProto())
            .addValues(Value.protoMessageArray(null, SingerInfo.getDescriptor()).toProto())
            .build());
    consumer.onCompleted();

    assertTrue(resultSet.next());
    assertEquals(
        Arrays.asList(singerInfo1, singerInfo2),
        resultSet.getProtoMessageList(0, SingerInfo.getDefaultInstance()));
    assertTrue(resultSet.next());
    assertEquals(
        Arrays.asList(singerInfo2, null, singerInfo1),
        resultSet.getProtoMessageList(0, SingerInfo.getDefaultInstance()));
    assertTrue(resultSet.next());
    assertThrows(
        NullPointerException.class,
        () -> {
          resultSet.getProtoMessageList(0, SingerInfo.getDefaultInstance());
        });
  }

  @Test
  public void getProtoEnumList() {
    String genreFullyQualifiedName = Genre.getDescriptor().getFullName();
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(
                    Type.struct(Type.StructField.of("f", Type.protoEnum(genreFullyQualifiedName)))))
            .addValues(Value.protoEnum(Genre.FOLK).toProto())
            .addValues(Value.protoEnum(Genre.JAZZ.getNumber(), genreFullyQualifiedName).toProto())
            .addValues(Value.protoEnum(null, genreFullyQualifiedName).toProto())
            .build());
    consumer.onCompleted();

    assertTrue(resultSet.next());
    assertEquals(Genre.FOLK, resultSet.getProtoEnum(0, Genre::forNumber));
    assertTrue(resultSet.next());
    assertEquals(Genre.JAZZ, resultSet.getProtoEnum(0, Genre::forNumber));
    assertTrue(resultSet.next());
    assertThrows(
        NullPointerException.class,
        () -> {
          resultSet.getProtoEnum(0, Genre::forNumber);
        });
  }

  @Test
  public void verifyResultSetWithLastTrue() {
    long[] longArray = {111, 333, 444, 0, -1, -2234, Long.MAX_VALUE, Long.MIN_VALUE};

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.int64())))))
            .addValues(Value.int64Array(longArray).toProto())
            .setLast(false)
            .build());
    assertTrue(resultSet.next());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.int64())))))
            .addValues(Value.int64Array(longArray).toProto())
            .setLast(true)
            .build());
    assertTrue(resultSet.next());
    assertFalse(resultSet.next());
    consumer.onCompleted();
  }

  @Test
  public void shouldThrowDeadlineExceededIfLastTrueIsNotReceived() {
    long[] longArray = {111, 333, 444, 0, -1, -2234, Long.MAX_VALUE, Long.MIN_VALUE};

    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.int64())))))
            .addValues(Value.int64Array(longArray).toProto())
            .setLast(false)
            .build());
    assertTrue(resultSet.next());
    consumer.onPartialResultSet(
        PartialResultSet.newBuilder()
            .setMetadata(
                makeMetadata(Type.struct(Type.StructField.of("f", Type.array(Type.int64())))))
            .addValues(Value.int64Array(longArray).toProto())
            .setLast(false)
            .build());
    assertTrue(resultSet.next());
    SpannerException spannerException =
        assertThrows(
            SpannerException.class,
            () -> {
              assertThat(resultSet.next()).isFalse();
            });
    assertEquals("DEADLINE_EXCEEDED: stream wait timeout", spannerException.getMessage());
    consumer.onCompleted();
  }
}
