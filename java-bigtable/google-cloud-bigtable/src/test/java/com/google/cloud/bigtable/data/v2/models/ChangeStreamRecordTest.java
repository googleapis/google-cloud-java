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

import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.StreamContinuationToken;
import com.google.bigtable.v2.StreamPartition;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
public class ChangeStreamRecordTest {

  @Rule public ExpectedException expect = ExpectedException.none();

  @Test
  public void heartbeatSerializationTest() throws IOException, ClassNotFoundException {
    ReadChangeStreamResponse.Heartbeat heartbeatProto =
        ReadChangeStreamResponse.Heartbeat.newBuilder()
            .setEstimatedLowWatermark(
                com.google.protobuf.Timestamp.newBuilder().setSeconds(1000).build())
            .setContinuationToken(
                StreamContinuationToken.newBuilder().setToken("random-token").build())
            .build();
    Heartbeat heartbeat = Heartbeat.fromProto(heartbeatProto);

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(heartbeat);
    oos.close();
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Heartbeat actual = (Heartbeat) ois.readObject();
    assertThat(actual).isEqualTo(heartbeat);
  }

  @Test
  public void closeStreamSerializationTest() throws IOException, ClassNotFoundException {
    Status status = Status.newBuilder().setCode(11).build();
    RowRange rowRange1 =
        RowRange.newBuilder()
            .setStartKeyClosed(ByteString.copyFromUtf8(""))
            .setEndKeyOpen(ByteString.copyFromUtf8("apple"))
            .build();
    String token1 = "close-stream-token-1";
    RowRange rowRange2 =
        RowRange.newBuilder()
            .setStartKeyClosed(ByteString.copyFromUtf8("apple"))
            .setEndKeyOpen(ByteString.copyFromUtf8(""))
            .build();
    String token2 = "close-stream-token-2";
    ReadChangeStreamResponse.CloseStream closeStreamProto =
        ReadChangeStreamResponse.CloseStream.newBuilder()
            .addContinuationTokens(
                StreamContinuationToken.newBuilder()
                    .setPartition(StreamPartition.newBuilder().setRowRange(rowRange1).build())
                    .setToken(token1)
                    .build())
            .addContinuationTokens(
                StreamContinuationToken.newBuilder()
                    .setPartition(StreamPartition.newBuilder().setRowRange(rowRange2).build())
                    .setToken(token2)
                    .build())
            .addNewPartitions(StreamPartition.newBuilder().setRowRange(rowRange1))
            .addNewPartitions(StreamPartition.newBuilder().setRowRange(rowRange2))
            .setStatus(status)
            .build();
    CloseStream closeStream = CloseStream.fromProto(closeStreamProto);

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(closeStream);
    oos.close();
    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
    CloseStream actual = (CloseStream) ois.readObject();
    assertThat(actual.getChangeStreamContinuationTokens())
        .isEqualTo(closeStream.getChangeStreamContinuationTokens());
    assertThat(actual.getStatus()).isEqualTo(closeStream.getStatus());
    assertThat(actual.getNewPartitions()).isEqualTo(closeStream.getNewPartitions());
  }

  @Test
  public void heartbeatTest() {
    Timestamp lowWatermark = Timestamp.newBuilder().setSeconds(1000).build();
    RowRange rowRange =
        RowRange.newBuilder()
            .setStartKeyClosed(ByteString.copyFromUtf8("apple"))
            .setEndKeyOpen(ByteString.copyFromUtf8("banana"))
            .build();
    String token = "heartbeat-token";
    ReadChangeStreamResponse.Heartbeat heartbeatProto =
        ReadChangeStreamResponse.Heartbeat.newBuilder()
            .setEstimatedLowWatermark(lowWatermark)
            .setContinuationToken(
                StreamContinuationToken.newBuilder()
                    .setPartition(StreamPartition.newBuilder().setRowRange(rowRange).build())
                    .setToken(token)
                    .build())
            .build();
    Heartbeat actualHeartbeat = Heartbeat.fromProto(heartbeatProto);

    assertThat(actualHeartbeat.getEstimatedLowWatermark())
        .isEqualTo(Instant.ofEpochSecond(lowWatermark.getSeconds(), lowWatermark.getNanos()));
    assertThat(actualHeartbeat.getChangeStreamContinuationToken().getPartition())
        .isEqualTo(ByteStringRange.create(rowRange.getStartKeyClosed(), rowRange.getEndKeyOpen()));
    assertThat(actualHeartbeat.getChangeStreamContinuationToken().getToken()).isEqualTo(token);
  }

  @Test
  public void closeStreamTest() {
    Status status = Status.newBuilder().setCode(11).build();
    RowRange rowRange1 =
        RowRange.newBuilder()
            .setStartKeyClosed(ByteString.copyFromUtf8(""))
            .setEndKeyOpen(ByteString.copyFromUtf8("apple"))
            .build();
    String token1 = "close-stream-token-1";
    RowRange rowRange2 =
        RowRange.newBuilder()
            .setStartKeyClosed(ByteString.copyFromUtf8("apple"))
            .setEndKeyOpen(ByteString.copyFromUtf8(""))
            .build();
    String token2 = "close-stream-token-2";
    ReadChangeStreamResponse.CloseStream closeStreamProto =
        ReadChangeStreamResponse.CloseStream.newBuilder()
            .addContinuationTokens(
                StreamContinuationToken.newBuilder()
                    .setPartition(StreamPartition.newBuilder().setRowRange(rowRange1).build())
                    .setToken(token1)
                    .build())
            .addContinuationTokens(
                StreamContinuationToken.newBuilder()
                    .setPartition(StreamPartition.newBuilder().setRowRange(rowRange2).build())
                    .setToken(token2)
                    .build())
            .addNewPartitions(StreamPartition.newBuilder().setRowRange(rowRange1))
            .addNewPartitions(StreamPartition.newBuilder().setRowRange(rowRange2))
            .setStatus(status)
            .build();
    CloseStream actualCloseStream = CloseStream.fromProto(closeStreamProto);

    assertThat(status).isEqualTo(actualCloseStream.getStatus().toProto());
    assertThat(actualCloseStream.getChangeStreamContinuationTokens().get(0).getPartition())
        .isEqualTo(
            ByteStringRange.create(rowRange1.getStartKeyClosed(), rowRange1.getEndKeyOpen()));
    assertThat(token1)
        .isEqualTo(actualCloseStream.getChangeStreamContinuationTokens().get(0).getToken());
    assertThat(actualCloseStream.getChangeStreamContinuationTokens().get(1).getPartition())
        .isEqualTo(
            ByteStringRange.create(rowRange2.getStartKeyClosed(), rowRange2.getEndKeyOpen()));
    assertThat(token2)
        .isEqualTo(actualCloseStream.getChangeStreamContinuationTokens().get(1).getToken());
    assertThat(actualCloseStream.getNewPartitions().get(0))
        .isEqualTo(
            ByteStringRange.create(rowRange1.getStartKeyClosed(), rowRange1.getEndKeyOpen()));
    assertThat(actualCloseStream.getNewPartitions().get(1))
        .isEqualTo(
            ByteStringRange.create(rowRange2.getStartKeyClosed(), rowRange2.getEndKeyOpen()));
  }

  // Tests that an OK CloseStream should not have continuation tokens.
  @Test(expected = IllegalStateException.class)
  public void closeStreamOkWithContinuationTokenShouldFail() {
    Status status = Status.newBuilder().setCode(0).build();
    RowRange rowRange =
        RowRange.newBuilder()
            .setStartKeyClosed(ByteString.copyFromUtf8(""))
            .setEndKeyOpen(ByteString.copyFromUtf8("apple"))
            .build();
    String token = "close-stream-token-1";
    ReadChangeStreamResponse.CloseStream closeStreamProto =
        ReadChangeStreamResponse.CloseStream.newBuilder()
            .addContinuationTokens(
                StreamContinuationToken.newBuilder()
                    .setPartition(StreamPartition.newBuilder().setRowRange(rowRange))
                    .setToken(token))
            .setStatus(status)
            .build();
    Assert.assertThrows(
        IllegalStateException.class, (ThrowingRunnable) CloseStream.fromProto(closeStreamProto));
  }

  // Tests that a non-OK CloseStream should have continuation tokens.
  @Test(expected = IllegalStateException.class)
  public void closeStreamErrorWithoutContinuationTokenShouldFail() {
    Status status = Status.newBuilder().setCode(11).build();
    ReadChangeStreamResponse.CloseStream closeStreamProto =
        ReadChangeStreamResponse.CloseStream.newBuilder().setStatus(status).build();
    Assert.assertThrows(
        IllegalStateException.class, (ThrowingRunnable) CloseStream.fromProto(closeStreamProto));
  }

  // Tests that the number of continuation tokens should match the number of new partitions.
  @Test(expected = IllegalStateException.class)
  public void closeStreamTokenAndNewPartitionCountMismatchedTest() {
    Status status = Status.newBuilder().setCode(11).build();
    RowRange rowRange =
        RowRange.newBuilder()
            .setStartKeyClosed(ByteString.copyFromUtf8(""))
            .setEndKeyOpen(ByteString.copyFromUtf8("apple"))
            .build();
    String token = "close-stream-token-1";
    ReadChangeStreamResponse.CloseStream closeStreamProto =
        ReadChangeStreamResponse.CloseStream.newBuilder()
            .addContinuationTokens(
                StreamContinuationToken.newBuilder()
                    .setPartition(StreamPartition.newBuilder().setRowRange(rowRange))
                    .setToken(token))
            .setStatus(status)
            .build();
    Assert.assertThrows(
        IllegalStateException.class, (ThrowingRunnable) CloseStream.fromProto(closeStreamProto));
  }
}
