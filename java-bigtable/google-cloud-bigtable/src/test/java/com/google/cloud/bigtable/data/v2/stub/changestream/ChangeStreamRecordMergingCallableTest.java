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
package com.google.cloud.bigtable.data.v2.stub.changestream;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadChangeStreamResponse;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.StreamContinuationToken;
import com.google.bigtable.v2.StreamPartition;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamContinuationToken;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecord;
import com.google.cloud.bigtable.data.v2.models.CloseStream;
import com.google.cloud.bigtable.data.v2.models.DefaultChangeStreamRecordAdapter;
import com.google.cloud.bigtable.data.v2.models.Heartbeat;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi;
import com.google.cloud.bigtable.gaxx.testing.FakeStreamingApi.ServerStreamingStashCallable;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Instant;

/**
 * Additional tests in addition to {@link ReadChangeStreamMergingAcceptanceTest}.
 *
 * <p>All the ChangeStreamMutation tests are in {@link ReadChangeStreamMergingAcceptanceTest}.
 */
@RunWith(JUnit4.class)
public class ChangeStreamRecordMergingCallableTest {

  @Test
  public void heartbeatTest() {
    RowRange rowRange = RowRange.newBuilder().getDefaultInstanceForType();
    ReadChangeStreamResponse.Heartbeat heartbeatProto =
        ReadChangeStreamResponse.Heartbeat.newBuilder()
            .setEstimatedLowWatermark(Timestamp.newBuilder().setSeconds(1000).build())
            .setContinuationToken(
                StreamContinuationToken.newBuilder()
                    .setPartition(StreamPartition.newBuilder().setRowRange(rowRange))
                    .setToken("random-token")
                    .build())
            .build();
    ReadChangeStreamResponse response =
        ReadChangeStreamResponse.newBuilder().setHeartbeat(heartbeatProto).build();
    FakeStreamingApi.ServerStreamingStashCallable<ReadChangeStreamRequest, ReadChangeStreamResponse>
        inner = new ServerStreamingStashCallable<>(Collections.singletonList(response));

    ChangeStreamRecordMergingCallable<ChangeStreamRecord> mergingCallable =
        new ChangeStreamRecordMergingCallable<>(inner, new DefaultChangeStreamRecordAdapter());
    List<ChangeStreamRecord> results =
        mergingCallable.all().call(ReadChangeStreamRequest.getDefaultInstance());

    // Validate the result.
    assertThat(results.size()).isEqualTo(1);
    ChangeStreamRecord record = results.get(0);
    Assert.assertTrue(record instanceof Heartbeat);
    Heartbeat heartbeat = (Heartbeat) record;
    assertThat(heartbeat.getChangeStreamContinuationToken().getPartition())
        .isEqualTo(ByteStringRange.create(rowRange.getStartKeyClosed(), rowRange.getEndKeyOpen()));
    assertThat(heartbeat.getChangeStreamContinuationToken().getToken())
        .isEqualTo(heartbeatProto.getContinuationToken().getToken());
    assertThat(heartbeat.getEstimatedLowWatermark())
        .isEqualTo(
            Instant.ofEpochSecond(
                heartbeatProto.getEstimatedLowWatermark().getSeconds(),
                heartbeatProto.getEstimatedLowWatermark().getNanos()));
  }

  @Test
  public void closeStreamTest() {
    RowRange rowRange =
        RowRange.newBuilder()
            .setStartKeyClosed(ByteString.copyFromUtf8(""))
            .setEndKeyOpen(ByteString.copyFromUtf8(""))
            .build();
    StreamContinuationToken streamContinuationToken =
        StreamContinuationToken.newBuilder()
            .setPartition(StreamPartition.newBuilder().setRowRange(rowRange).build())
            .setToken("random-token")
            .build();
    ReadChangeStreamResponse.CloseStream closeStreamProto =
        ReadChangeStreamResponse.CloseStream.newBuilder()
            .addContinuationTokens(streamContinuationToken)
            .addNewPartitions(StreamPartition.newBuilder().setRowRange(rowRange))
            .setStatus(Status.newBuilder().setCode(11))
            .build();
    ReadChangeStreamResponse response =
        ReadChangeStreamResponse.newBuilder().setCloseStream(closeStreamProto).build();
    FakeStreamingApi.ServerStreamingStashCallable<ReadChangeStreamRequest, ReadChangeStreamResponse>
        inner = new ServerStreamingStashCallable<>(Collections.singletonList(response));

    ChangeStreamRecordMergingCallable<ChangeStreamRecord> mergingCallable =
        new ChangeStreamRecordMergingCallable<>(inner, new DefaultChangeStreamRecordAdapter());
    List<ChangeStreamRecord> results =
        mergingCallable.all().call(ReadChangeStreamRequest.getDefaultInstance());

    // Validate the result.
    assertThat(results.size()).isEqualTo(1);
    ChangeStreamRecord record = results.get(0);
    Assert.assertTrue(record instanceof CloseStream);
    CloseStream closeStream = (CloseStream) record;
    assertThat(closeStream.getStatus().toProto()).isEqualTo(closeStreamProto.getStatus());
    assertThat(closeStream.getChangeStreamContinuationTokens().size()).isEqualTo(1);
    ChangeStreamContinuationToken changeStreamContinuationToken =
        closeStream.getChangeStreamContinuationTokens().get(0);
    assertThat(changeStreamContinuationToken.getPartition())
        .isEqualTo(ByteStringRange.create(rowRange.getStartKeyClosed(), rowRange.getEndKeyOpen()));
    assertThat(changeStreamContinuationToken.getToken())
        .isEqualTo(streamContinuationToken.getToken());
    assertThat(closeStream.getNewPartitions().size()).isEqualTo(1);
    assertThat(closeStream.getNewPartitions().get(0))
        .isEqualTo(ByteStringRange.create(rowRange.getStartKeyClosed(), rowRange.getEndKeyOpen()));
  }
}
