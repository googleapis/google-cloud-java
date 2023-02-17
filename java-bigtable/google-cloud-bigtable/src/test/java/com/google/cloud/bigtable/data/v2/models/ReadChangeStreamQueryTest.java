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

import com.google.bigtable.v2.ReadChangeStreamRequest;
import com.google.bigtable.v2.ReadChangeStreamRequest.Builder;
import com.google.bigtable.v2.RowRange;
import com.google.bigtable.v2.StreamContinuationToken;
import com.google.bigtable.v2.StreamContinuationTokens;
import com.google.bigtable.v2.StreamPartition;
import com.google.cloud.bigtable.data.v2.internal.NameUtil;
import com.google.cloud.bigtable.data.v2.internal.RequestContext;
import com.google.cloud.bigtable.data.v2.models.Range.ByteStringRange;
import com.google.protobuf.ByteString;
import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Instant;

@RunWith(JUnit4.class)
public class ReadChangeStreamQueryTest {
  private static final String PROJECT_ID = "fake-project";
  private static final String INSTANCE_ID = "fake-instance";
  private static final String TABLE_ID = "fake-table";
  private static final String APP_PROFILE_ID = "fake-profile-id";
  private RequestContext requestContext;
  private static final Instant FAKE_START_TIME = Instant.ofEpochSecond(1L, 1000L);
  private static final Instant FAKE_END_TIME = Instant.ofEpochSecond(1L, 2000L);

  @Rule public ExpectedException expect = ExpectedException.none();

  @Before
  public void setUp() {
    requestContext = RequestContext.create(PROJECT_ID, INSTANCE_ID, APP_PROFILE_ID);
  }

  @Test
  public void requestContextTest() {
    ReadChangeStreamQuery query = ReadChangeStreamQuery.create(TABLE_ID);

    ReadChangeStreamRequest proto = query.toProto(requestContext);
    assertThat(proto).isEqualTo(expectedProtoBuilder().build());
  }

  @Test
  public void streamPartitionTest() {
    // Case 1: String.
    ReadChangeStreamQuery query1 =
        ReadChangeStreamQuery.create(TABLE_ID).streamPartition("simple-begin", "simple-end");
    ReadChangeStreamRequest actualProto1 = query1.toProto(requestContext);
    Builder expectedProto1 = expectedProtoBuilder();
    expectedProto1.setPartition(
        StreamPartition.newBuilder()
            .setRowRange(
                RowRange.newBuilder()
                    .setStartKeyClosed(ByteString.copyFromUtf8("simple-begin"))
                    .setEndKeyOpen(ByteString.copyFromUtf8("simple-end"))
                    .build())
            .build());
    assertThat(actualProto1).isEqualTo(expectedProto1.build());

    // Case 2: ByteString.
    ReadChangeStreamQuery query2 =
        ReadChangeStreamQuery.create(TABLE_ID)
            .streamPartition(
                ByteString.copyFromUtf8("byte-begin"), ByteString.copyFromUtf8("byte-end"));
    ReadChangeStreamRequest actualProto2 = query2.toProto(requestContext);
    Builder expectedProto2 = expectedProtoBuilder();
    expectedProto2.setPartition(
        StreamPartition.newBuilder()
            .setRowRange(
                RowRange.newBuilder()
                    .setStartKeyClosed(ByteString.copyFromUtf8("byte-begin"))
                    .setEndKeyOpen(ByteString.copyFromUtf8("byte-end"))
                    .build())
            .build());
    assertThat(actualProto2).isEqualTo(expectedProto2.build());

    // Case 3: ByteStringRange.
    ReadChangeStreamQuery query3 =
        ReadChangeStreamQuery.create(TABLE_ID)
            .streamPartition(ByteStringRange.create("range-begin", "range-end"));
    ReadChangeStreamRequest actualProto3 = query3.toProto(requestContext);
    Builder expectedProto3 = expectedProtoBuilder();
    expectedProto3.setPartition(
        StreamPartition.newBuilder()
            .setRowRange(
                RowRange.newBuilder()
                    .setStartKeyClosed(ByteString.copyFromUtf8("range-begin"))
                    .setEndKeyOpen(ByteString.copyFromUtf8("range-end"))
                    .build())
            .build());
    assertThat(actualProto3).isEqualTo(expectedProto3.build());
  }

  @Test
  public void startTimeTest() {
    ReadChangeStreamQuery query = ReadChangeStreamQuery.create(TABLE_ID).startTime(FAKE_START_TIME);

    Builder expectedProto =
        expectedProtoBuilder()
            .setStartTime(
                Timestamp.newBuilder()
                    .setSeconds(FAKE_START_TIME.getEpochSecond())
                    .setNanos(FAKE_START_TIME.getNano()));

    ReadChangeStreamRequest actualProto = query.toProto(requestContext);
    assertThat(actualProto).isEqualTo(expectedProto.build());
  }

  @Test
  public void endTimeTest() {
    ReadChangeStreamQuery query = ReadChangeStreamQuery.create(TABLE_ID).endTime(FAKE_END_TIME);

    Builder expectedProto =
        expectedProtoBuilder()
            .setEndTime(
                Timestamp.newBuilder()
                    .setSeconds(FAKE_END_TIME.getEpochSecond())
                    .setNanos(FAKE_END_TIME.getNano()));

    ReadChangeStreamRequest actualProto = query.toProto(requestContext);
    assertThat(actualProto).isEqualTo(expectedProto.build());
  }

  @Test
  public void heartbeatDurationTest() {
    ReadChangeStreamQuery query =
        ReadChangeStreamQuery.create(TABLE_ID).heartbeatDuration(java.time.Duration.ofSeconds(5));

    Builder expectedProto =
        expectedProtoBuilder()
            .setHeartbeatDuration(com.google.protobuf.Duration.newBuilder().setSeconds(5).build());

    ReadChangeStreamRequest actualProto = query.toProto(requestContext);
    assertThat(actualProto).isEqualTo(expectedProto.build());
  }

  @Test
  public void continuationTokensTest() {
    StreamContinuationToken tokenProto =
        StreamContinuationToken.newBuilder()
            .setPartition(
                StreamPartition.newBuilder()
                    .setRowRange(
                        RowRange.newBuilder()
                            .setStartKeyClosed(ByteString.copyFromUtf8("start"))
                            .setEndKeyOpen(ByteString.copyFromUtf8("end"))
                            .build())
                    .build())
            .setToken("random-token")
            .build();
    ChangeStreamContinuationToken token = ChangeStreamContinuationToken.fromProto(tokenProto);
    ReadChangeStreamQuery query =
        ReadChangeStreamQuery.create(TABLE_ID).continuationTokens(Collections.singletonList(token));

    Builder expectedProto =
        expectedProtoBuilder()
            .setContinuationTokens(
                StreamContinuationTokens.newBuilder().addTokens(tokenProto).build());

    ReadChangeStreamRequest actualProto = query.toProto(requestContext);
    assertThat(actualProto).isEqualTo(expectedProto.build());
  }

  @Test(expected = IllegalStateException.class)
  public void createWithStartTimeAndContinuationTokensTest() {
    StreamContinuationToken tokenProto =
        StreamContinuationToken.newBuilder()
            .setPartition(
                StreamPartition.newBuilder()
                    .setRowRange(
                        RowRange.newBuilder()
                            .setStartKeyClosed(ByteString.copyFromUtf8("start"))
                            .setEndKeyOpen(ByteString.copyFromUtf8("end"))
                            .build())
                    .build())
            .setToken("random-token")
            .build();
    ChangeStreamContinuationToken token = ChangeStreamContinuationToken.fromProto(tokenProto);
    ReadChangeStreamQuery query =
        ReadChangeStreamQuery.create(TABLE_ID)
            .startTime(FAKE_START_TIME)
            .continuationTokens(Collections.singletonList(token));
    expect.expect(IllegalArgumentException.class);
    expect.expectMessage("startTime and continuationTokens can't be specified together");
  }

  @Test
  public void serializationTest() throws IOException, ClassNotFoundException {
    StreamContinuationToken tokenProto =
        StreamContinuationToken.newBuilder()
            .setPartition(
                StreamPartition.newBuilder()
                    .setRowRange(
                        RowRange.newBuilder()
                            .setStartKeyClosed(ByteString.copyFromUtf8("start"))
                            .setEndKeyOpen(ByteString.copyFromUtf8("end"))
                            .build())
                    .build())
            .setToken("random-token")
            .build();
    ChangeStreamContinuationToken token = ChangeStreamContinuationToken.fromProto(tokenProto);
    ReadChangeStreamQuery expected =
        ReadChangeStreamQuery.create(TABLE_ID)
            .streamPartition("simple-begin", "simple-end")
            .continuationTokens(Collections.singletonList(token))
            .endTime(FAKE_END_TIME)
            .heartbeatDuration(java.time.Duration.ofSeconds(5));

    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(bos);
    oos.writeObject(expected);
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

    ReadChangeStreamQuery actual = (ReadChangeStreamQuery) ois.readObject();
    assertThat(actual.toProto(requestContext)).isEqualTo(expected.toProto(requestContext));
  }

  private static ReadChangeStreamRequest.Builder expectedProtoBuilder() {
    return ReadChangeStreamRequest.newBuilder()
        .setTableName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
        .setAppProfileId(APP_PROFILE_ID);
  }

  @Test
  public void testFromProto() {
    StreamContinuationToken token =
        StreamContinuationToken.newBuilder()
            .setPartition(
                StreamPartition.newBuilder()
                    .setRowRange(
                        RowRange.newBuilder()
                            .setStartKeyClosed(ByteString.copyFromUtf8(""))
                            .setEndKeyOpen(ByteString.copyFromUtf8(""))
                            .build())
                    .build())
            .setToken("random-token")
            .build();
    ReadChangeStreamRequest request =
        ReadChangeStreamRequest.newBuilder()
            .setTableName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
            .setAppProfileId(APP_PROFILE_ID)
            .setPartition(
                StreamPartition.newBuilder()
                    .setRowRange(
                        RowRange.newBuilder()
                            .setStartKeyClosed(ByteString.copyFromUtf8(""))
                            .setEndKeyClosed(ByteString.copyFromUtf8(""))
                            .build()))
            .setContinuationTokens(StreamContinuationTokens.newBuilder().addTokens(token).build())
            .setEndTime(
                Timestamp.newBuilder()
                    .setSeconds(FAKE_END_TIME.getEpochSecond())
                    .setNanos(FAKE_END_TIME.getNano()))
            .setHeartbeatDuration(Duration.newBuilder().setSeconds(5).build())
            .build();
    ReadChangeStreamQuery query = ReadChangeStreamQuery.fromProto(request);
    assertThat(query.toProto(requestContext)).isEqualTo(request);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFromProtoWithEmptyTableId() {
    ReadChangeStreamQuery.fromProto(ReadChangeStreamRequest.getDefaultInstance());

    expect.expect(IllegalArgumentException.class);
    expect.expectMessage("Invalid table name:");
  }

  @Test
  public void testEquality() {
    ReadChangeStreamQuery request =
        ReadChangeStreamQuery.create(TABLE_ID)
            .streamPartition("simple-begin", "simple-end")
            .startTime(FAKE_START_TIME)
            .endTime(FAKE_END_TIME)
            .heartbeatDuration(java.time.Duration.ofSeconds(5));

    // ReadChangeStreamQuery#toProto should not change the ReadChangeStreamQuery instance state
    request.toProto(requestContext);
    assertThat(request)
        .isEqualTo(
            ReadChangeStreamQuery.create(TABLE_ID)
                .streamPartition("simple-begin", "simple-end")
                .startTime(FAKE_START_TIME)
                .endTime(FAKE_END_TIME)
                .heartbeatDuration(java.time.Duration.ofSeconds(5)));

    assertThat(ReadChangeStreamQuery.create(TABLE_ID).streamPartition("begin-1", "end-1"))
        .isNotEqualTo(ReadChangeStreamQuery.create(TABLE_ID).streamPartition("begin-2", "end-1"));
    assertThat(ReadChangeStreamQuery.create(TABLE_ID).startTime(FAKE_START_TIME))
        .isNotEqualTo(
            ReadChangeStreamQuery.create(TABLE_ID).startTime(Instant.ofEpochSecond(1L, 1001L)));
    assertThat(ReadChangeStreamQuery.create(TABLE_ID).endTime(FAKE_END_TIME))
        .isNotEqualTo(
            ReadChangeStreamQuery.create(TABLE_ID).endTime(Instant.ofEpochSecond(1L, 1001L)));
    assertThat(
            ReadChangeStreamQuery.create(TABLE_ID)
                .heartbeatDuration(java.time.Duration.ofSeconds(5)))
        .isNotEqualTo(
            ReadChangeStreamQuery.create(TABLE_ID)
                .heartbeatDuration(java.time.Duration.ofSeconds(6)));
  }

  @Test
  public void testClone() {
    StreamContinuationToken tokenProto =
        StreamContinuationToken.newBuilder()
            .setPartition(
                StreamPartition.newBuilder()
                    .setRowRange(
                        RowRange.newBuilder()
                            .setStartKeyClosed(ByteString.copyFromUtf8("start"))
                            .setEndKeyOpen(ByteString.copyFromUtf8("end"))
                            .build())
                    .build())
            .setToken("random-token")
            .build();
    ChangeStreamContinuationToken token = ChangeStreamContinuationToken.fromProto(tokenProto);
    ReadChangeStreamQuery query =
        ReadChangeStreamQuery.create(TABLE_ID)
            .streamPartition("begin", "end")
            .continuationTokens(Collections.singletonList(token))
            .endTime(FAKE_END_TIME)
            .heartbeatDuration(java.time.Duration.ofSeconds(5));
    ReadChangeStreamRequest request =
        ReadChangeStreamRequest.newBuilder()
            .setTableName(NameUtil.formatTableName(PROJECT_ID, INSTANCE_ID, TABLE_ID))
            .setAppProfileId(APP_PROFILE_ID)
            .setPartition(
                StreamPartition.newBuilder()
                    .setRowRange(
                        RowRange.newBuilder()
                            .setStartKeyClosed(ByteString.copyFromUtf8("begin"))
                            .setEndKeyOpen(ByteString.copyFromUtf8("end"))
                            .build()))
            .setContinuationTokens(
                StreamContinuationTokens.newBuilder().addTokens(tokenProto).build())
            .setEndTime(
                Timestamp.newBuilder()
                    .setSeconds(FAKE_END_TIME.getEpochSecond())
                    .setNanos(FAKE_END_TIME.getNano()))
            .setHeartbeatDuration(Duration.newBuilder().setSeconds(5).build())
            .build();

    ReadChangeStreamQuery clonedReq = query.clone();
    assertThat(clonedReq).isEqualTo(query);
    assertThat(clonedReq.toProto(requestContext)).isEqualTo(request);
  }
}
