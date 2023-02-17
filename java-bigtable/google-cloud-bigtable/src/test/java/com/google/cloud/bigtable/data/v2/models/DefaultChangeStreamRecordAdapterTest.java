/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.models;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.Mutation;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.bigtable.v2.StreamContinuationToken;
import com.google.bigtable.v2.TimestampRange;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecordAdapter.ChangeStreamRecordBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
public class DefaultChangeStreamRecordAdapterTest {

  private final DefaultChangeStreamRecordAdapter adapter = new DefaultChangeStreamRecordAdapter();
  private ChangeStreamRecordBuilder<ChangeStreamRecord> changeStreamRecordBuilder;
  private static final Instant FAKE_COMMIT_TIMESTAMP = Instant.ofEpochSecond(0L, 1000L);
  private static final Instant FAKE_LOW_WATERMARK = Instant.ofEpochSecond(0L, 2000L);

  @Rule public ExpectedException expect = ExpectedException.none();

  @Before
  public void setUp() {
    changeStreamRecordBuilder = adapter.createChangeStreamRecordBuilder();
  }

  @Test
  public void isHeartbeatTest() {
    ChangeStreamRecord heartbeatRecord =
        Heartbeat.fromProto(ReadChangeStreamResponse.Heartbeat.getDefaultInstance());
    ChangeStreamRecord closeStreamRecord =
        CloseStream.fromProto(ReadChangeStreamResponse.CloseStream.getDefaultInstance());
    ChangeStreamRecord changeStreamMutationRecord =
        ChangeStreamMutation.createGcMutation(
                ByteString.copyFromUtf8("key"), FAKE_COMMIT_TIMESTAMP, 0)
            .setToken("token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK)
            .build();
    Assert.assertTrue(adapter.isHeartbeat(heartbeatRecord));
    Assert.assertFalse(adapter.isHeartbeat(closeStreamRecord));
    Assert.assertFalse(adapter.isHeartbeat(changeStreamMutationRecord));
  }

  @Test
  public void getTokenFromHeartbeatTest() {
    ChangeStreamRecord heartbeatRecord =
        Heartbeat.fromProto(
            ReadChangeStreamResponse.Heartbeat.newBuilder()
                .setEstimatedLowWatermark(
                    Timestamp.newBuilder()
                        .setSeconds(FAKE_LOW_WATERMARK.getEpochSecond())
                        .setNanos(FAKE_LOW_WATERMARK.getNano()))
                .setContinuationToken(
                    StreamContinuationToken.newBuilder().setToken("heartbeat-token").build())
                .build());
    Assert.assertEquals(adapter.getTokenFromHeartbeat(heartbeatRecord), "heartbeat-token");
  }

  @Test(expected = IllegalArgumentException.class)
  public void getTokenFromHeartbeatInvalidTypeTest() {
    ChangeStreamRecord closeStreamRecord =
        CloseStream.fromProto(ReadChangeStreamResponse.CloseStream.getDefaultInstance());
    adapter.getTokenFromHeartbeat(closeStreamRecord);
    expect.expectMessage("record is not a Heartbeat.");
  }

  @Test
  public void isChangeStreamMutationTest() {
    ChangeStreamRecord heartbeatRecord =
        Heartbeat.fromProto(ReadChangeStreamResponse.Heartbeat.getDefaultInstance());
    ChangeStreamRecord closeStreamRecord =
        CloseStream.fromProto(ReadChangeStreamResponse.CloseStream.getDefaultInstance());
    ChangeStreamRecord changeStreamMutationRecord =
        ChangeStreamMutation.createGcMutation(
                ByteString.copyFromUtf8("key"), FAKE_COMMIT_TIMESTAMP, 0)
            .setToken("token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK)
            .build();
    Assert.assertFalse(adapter.isChangeStreamMutation(heartbeatRecord));
    Assert.assertFalse(adapter.isChangeStreamMutation(closeStreamRecord));
    Assert.assertTrue(adapter.isChangeStreamMutation(changeStreamMutationRecord));
  }

  @Test
  public void getTokenFromChangeStreamMutationTest() {
    ChangeStreamRecord changeStreamMutationRecord =
        ChangeStreamMutation.createGcMutation(
                ByteString.copyFromUtf8("key"), FAKE_COMMIT_TIMESTAMP, 0)
            .setToken("change-stream-mutation-token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK)
            .build();
    Assert.assertEquals(
        adapter.getTokenFromChangeStreamMutation(changeStreamMutationRecord),
        "change-stream-mutation-token");
  }

  @Test(expected = IllegalArgumentException.class)
  public void getTokenFromChangeStreamMutationInvalidTypeTest() {
    ChangeStreamRecord closeStreamRecord =
        CloseStream.fromProto(ReadChangeStreamResponse.CloseStream.getDefaultInstance());
    adapter.getTokenFromChangeStreamMutation(closeStreamRecord);
    expect.expectMessage("record is not a ChangeStreamMutation.");
  }

  @Test
  public void heartbeatTest() {
    ReadChangeStreamResponse.Heartbeat expectedHeartbeat =
        ReadChangeStreamResponse.Heartbeat.newBuilder()
            .setEstimatedLowWatermark(
                Timestamp.newBuilder()
                    .setSeconds(FAKE_LOW_WATERMARK.getEpochSecond())
                    .setNanos(FAKE_LOW_WATERMARK.getNano())
                    .build())
            .setContinuationToken(
                StreamContinuationToken.newBuilder().setToken("random-token").build())
            .build();
    assertThat(changeStreamRecordBuilder.onHeartbeat(expectedHeartbeat))
        .isEqualTo(Heartbeat.fromProto(expectedHeartbeat));
    // Call again.
    assertThat(changeStreamRecordBuilder.onHeartbeat(expectedHeartbeat))
        .isEqualTo(Heartbeat.fromProto(expectedHeartbeat));
  }

  @Test
  public void closeStreamTest() {
    ReadChangeStreamResponse.CloseStream expectedCloseStream =
        ReadChangeStreamResponse.CloseStream.newBuilder()
            .addContinuationTokens(
                StreamContinuationToken.newBuilder().setToken("random-token").build())
            .setStatus(Status.newBuilder().setCode(0).build())
            .build();
    assertThat(changeStreamRecordBuilder.onCloseStream(expectedCloseStream))
        .isEqualTo(CloseStream.fromProto(expectedCloseStream));
    // Call again.
    assertThat(changeStreamRecordBuilder.onCloseStream(expectedCloseStream))
        .isEqualTo(CloseStream.fromProto(expectedCloseStream));
  }

  @Test(expected = IllegalStateException.class)
  public void createHeartbeatWithExistingMutationShouldFailTest() {
    changeStreamRecordBuilder.startGcMutation(
        ByteString.copyFromUtf8("key"), FAKE_COMMIT_TIMESTAMP, 0);
    changeStreamRecordBuilder.onHeartbeat(ReadChangeStreamResponse.Heartbeat.getDefaultInstance());
  }

  @Test(expected = IllegalStateException.class)
  public void createCloseStreamWithExistingMutationShouldFailTest() {
    changeStreamRecordBuilder.startGcMutation(
        ByteString.copyFromUtf8("key"), FAKE_COMMIT_TIMESTAMP, 0);
    changeStreamRecordBuilder.onCloseStream(
        ReadChangeStreamResponse.CloseStream.getDefaultInstance());
  }

  @Test
  public void singleDeleteFamilyTest() {
    // Suppose this is the mod we get from the ReadChangeStreamResponse.
    Mutation.DeleteFromFamily deleteFromFamily =
        Mutation.DeleteFromFamily.newBuilder().setFamilyName("fake-family").build();

    // Expected logical mutation in the change stream record.
    ChangeStreamMutation expectedChangeStreamMutation =
        ChangeStreamMutation.createUserMutation(
                ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0)
            .deleteFamily("fake-family")
            .setToken("fake-token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK)
            .build();

    // Create the ChangeStreamMutation through the ChangeStreamRecordBuilder.
    changeStreamRecordBuilder.startUserMutation(
        ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0);
    changeStreamRecordBuilder.deleteFamily(deleteFromFamily.getFamilyName());
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);
    // Call again.
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);
  }

  @Test
  public void singleDeleteCellTest() {
    // Suppose this is the mod we get from the ReadChangeStreamResponse.
    Mutation.DeleteFromColumn deleteFromColumn =
        Mutation.DeleteFromColumn.newBuilder()
            .setFamilyName("fake-family")
            .setColumnQualifier(ByteString.copyFromUtf8("fake-qualifier"))
            .setTimeRange(
                TimestampRange.newBuilder()
                    .setStartTimestampMicros(1000L)
                    .setEndTimestampMicros(2000L)
                    .build())
            .build();

    // Expected logical mutation in the change stream record.
    ChangeStreamMutation expectedChangeStreamMutation =
        ChangeStreamMutation.createUserMutation(
                ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0)
            .deleteCells(
                "fake-family",
                ByteString.copyFromUtf8("fake-qualifier"),
                Range.TimestampRange.create(1000L, 2000L))
            .setToken("fake-token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK)
            .build();

    // Create the ChangeStreamMutation through the ChangeStreamRecordBuilder.
    changeStreamRecordBuilder.startUserMutation(
        ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0);
    changeStreamRecordBuilder.deleteCells(
        deleteFromColumn.getFamilyName(),
        deleteFromColumn.getColumnQualifier(),
        Range.TimestampRange.create(
            deleteFromColumn.getTimeRange().getStartTimestampMicros(),
            deleteFromColumn.getTimeRange().getEndTimestampMicros()));
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);
    // Call again.
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);
  }

  @Test
  public void singleNonChunkedCellTest() {
    // Expected logical mutation in the change stream record.
    ChangeStreamMutation expectedChangeStreamMutation =
        ChangeStreamMutation.createUserMutation(
                ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0)
            .setCell(
                "fake-family",
                ByteString.copyFromUtf8("fake-qualifier"),
                100L,
                ByteString.copyFromUtf8("fake-value"))
            .setToken("fake-token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK)
            .build();

    // Create the ChangeStreamMutation through the ChangeStreamRecordBuilder.
    // Suppose the SetCell is not chunked and the state machine calls `cellValue()` once.
    changeStreamRecordBuilder.startUserMutation(
        ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0);
    changeStreamRecordBuilder.startCell(
        "fake-family", ByteString.copyFromUtf8("fake-qualifier"), 100L);
    changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("fake-value"));
    changeStreamRecordBuilder.finishCell();
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);
    // Call again.
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);
  }

  @Test
  public void singleChunkedCellTest() {
    // Expected logical mutation in the change stream record.
    ChangeStreamMutation expectedChangeStreamMutation =
        ChangeStreamMutation.createUserMutation(
                ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0)
            .setCell(
                "fake-family",
                ByteString.copyFromUtf8("fake-qualifier"),
                100L,
                ByteString.copyFromUtf8("fake-value1-value2"))
            .setToken("fake-token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK)
            .build();

    // Create the ChangeStreamMutation through the ChangeStreamRecordBuilder.
    // Suppose the SetCell is chunked into two pieces and the state machine calls `cellValue()`
    // twice.
    changeStreamRecordBuilder.startUserMutation(
        ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0);
    changeStreamRecordBuilder.startCell(
        "fake-family", ByteString.copyFromUtf8("fake-qualifier"), 100L);
    changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("fake-value1"));
    changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("-value2"));
    changeStreamRecordBuilder.finishCell();
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);
    // Call again.
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);
  }

  @Test
  public void multipleChunkedCellsTest() {
    // Expected logical mutation in the change stream record.
    ChangeStreamMutation.Builder expectedChangeStreamMutationBuilder =
        ChangeStreamMutation.createUserMutation(
            ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0);
    for (int i = 0; i < 10; ++i) {
      expectedChangeStreamMutationBuilder.setCell(
          "fake-family",
          ByteString.copyFromUtf8("fake-qualifier"),
          100L,
          ByteString.copyFromUtf8(i + "-fake-value1-value2-value3"));
    }
    expectedChangeStreamMutationBuilder
        .setToken("fake-token")
        .setEstimatedLowWatermark(FAKE_LOW_WATERMARK);

    // Create the ChangeStreamMutation through the ChangeStreamRecordBuilder.
    changeStreamRecordBuilder.startUserMutation(
        ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0);
    for (int i = 0; i < 10; ++i) {
      changeStreamRecordBuilder.startCell(
          "fake-family", ByteString.copyFromUtf8("fake-qualifier"), 100L);
      changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8(i + "-fake-value1"));
      changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("-value2"));
      changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("-value3"));
      changeStreamRecordBuilder.finishCell();
    }
    // Check that they're the same.
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutationBuilder.build());
    // Call again.
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutationBuilder.build());
  }

  @Test
  public void multipleDifferentModsTest() {
    // Expected logical mutation in the change stream record, which contains one DeleteFromFamily,
    // one non-chunked cell, and one chunked cell.
    ChangeStreamMutation.Builder expectedChangeStreamMutationBuilder =
        ChangeStreamMutation.createUserMutation(
                ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0)
            .deleteFamily("fake-family")
            .setCell(
                "fake-family",
                ByteString.copyFromUtf8("fake-qualifier"),
                100L,
                ByteString.copyFromUtf8("non-chunked-value"))
            .setCell(
                "fake-family",
                ByteString.copyFromUtf8("fake-qualifier"),
                100L,
                ByteString.copyFromUtf8("chunked-value"))
            .setToken("fake-token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK);

    // Create the ChangeStreamMutation through the ChangeStreamRecordBuilder.
    changeStreamRecordBuilder.startUserMutation(
        ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0);
    changeStreamRecordBuilder.deleteFamily("fake-family");
    // Add non-chunked cell.
    changeStreamRecordBuilder.startCell(
        "fake-family", ByteString.copyFromUtf8("fake-qualifier"), 100L);
    changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("non-chunked-value"));
    changeStreamRecordBuilder.finishCell();
    // Add chunked cell.
    changeStreamRecordBuilder.startCell(
        "fake-family", ByteString.copyFromUtf8("fake-qualifier"), 100L);
    changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("chunked"));
    changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("-value"));
    changeStreamRecordBuilder.finishCell();
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutationBuilder.build());
  }

  @Test
  public void resetTest() {
    // Build a Heartbeat.
    ReadChangeStreamResponse.Heartbeat expectedHeartbeat =
        ReadChangeStreamResponse.Heartbeat.getDefaultInstance();
    assertThat(changeStreamRecordBuilder.onHeartbeat(expectedHeartbeat))
        .isEqualTo(Heartbeat.fromProto(expectedHeartbeat));

    // Reset and build a CloseStream.
    changeStreamRecordBuilder.reset();
    ReadChangeStreamResponse.CloseStream expectedCloseStream =
        ReadChangeStreamResponse.CloseStream.getDefaultInstance();
    assertThat(changeStreamRecordBuilder.onCloseStream(expectedCloseStream))
        .isEqualTo(CloseStream.fromProto(expectedCloseStream));

    // Reset and build a DeleteFamily.
    changeStreamRecordBuilder.reset();
    Mutation deleteFromFamily =
        Mutation.newBuilder()
            .setDeleteFromFamily(
                Mutation.DeleteFromFamily.newBuilder().setFamilyName("fake-family").build())
            .build();
    ChangeStreamMutation expectedChangeStreamMutation =
        ChangeStreamMutation.createUserMutation(
                ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0)
            .deleteFamily("fake-family")
            .setToken("fake-token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK)
            .build();
    changeStreamRecordBuilder.startUserMutation(
        ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0);
    changeStreamRecordBuilder.deleteFamily(deleteFromFamily.getDeleteFromFamily().getFamilyName());
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);

    // Reset a build a cell.
    changeStreamRecordBuilder.reset();
    expectedChangeStreamMutation =
        ChangeStreamMutation.createUserMutation(
                ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0)
            .setCell(
                "fake-family",
                ByteString.copyFromUtf8("fake-qualifier"),
                100L,
                ByteString.copyFromUtf8("fake-value1-value2"))
            .setToken("fake-token")
            .setEstimatedLowWatermark(FAKE_LOW_WATERMARK)
            .build();

    changeStreamRecordBuilder.startUserMutation(
        ByteString.copyFromUtf8("key"), "fake-source-cluster-id", FAKE_COMMIT_TIMESTAMP, 0);
    changeStreamRecordBuilder.startCell(
        "fake-family", ByteString.copyFromUtf8("fake-qualifier"), 100L);
    changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("fake-value1"));
    changeStreamRecordBuilder.cellValue(ByteString.copyFromUtf8("-value2"));
    changeStreamRecordBuilder.finishCell();
    assertThat(
            changeStreamRecordBuilder.finishChangeStreamMutation("fake-token", FAKE_LOW_WATERMARK))
        .isEqualTo(expectedChangeStreamMutation);
  }
}
