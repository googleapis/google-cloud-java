/*
 * Copyright 2021 Google LLC
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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Timestamp;
import com.google.spanner.v1.CommitResponse.CommitStats;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CommitResponseTest {

  @Test
  public void testConstructWithTimestamp() {
    Timestamp timestamp = Timestamp.ofTimeSecondsAndNanos(100L, 100);
    CommitResponse response = new CommitResponse(timestamp);
    assertEquals(timestamp, response.getCommitTimestamp());
  }

  @Test
  public void testFromProto() {
    long mutationCount = 5L;
    com.google.protobuf.Timestamp timestamp =
        com.google.protobuf.Timestamp.newBuilder().setSeconds(123L).setNanos(456).build();
    com.google.spanner.v1.CommitResponse proto =
        com.google.spanner.v1.CommitResponse.newBuilder()
            .setCommitStats(
                com.google.spanner.v1.CommitResponse.CommitStats.newBuilder()
                    .setMutationCount(mutationCount)
                    .build())
            .setCommitTimestamp(timestamp)
            .build();

    CommitResponse response = new CommitResponse(proto);

    assertEquals(Timestamp.ofTimeSecondsAndNanos(123L, 456), response.getCommitTimestamp());
    assertEquals(mutationCount, response.getCommitStats().getMutationCount());
  }

  @Test
  public void testEqualsAndHashCode() {
    com.google.spanner.v1.CommitResponse proto1 =
        com.google.spanner.v1.CommitResponse.newBuilder()
            .setCommitTimestamp(com.google.protobuf.Timestamp.newBuilder().setSeconds(1L).build())
            .build();
    com.google.spanner.v1.CommitResponse proto2 =
        com.google.spanner.v1.CommitResponse.newBuilder()
            .setCommitTimestamp(com.google.protobuf.Timestamp.newBuilder().setSeconds(2L).build())
            .build();
    com.google.spanner.v1.CommitResponse proto3 =
        com.google.spanner.v1.CommitResponse.newBuilder()
            .setCommitTimestamp(com.google.protobuf.Timestamp.newBuilder().setSeconds(1L).build())
            .build();

    CommitResponse response1 = new CommitResponse(proto1);
    CommitResponse response2 = new CommitResponse(proto2);
    CommitResponse response3 = new CommitResponse(proto3);

    assertEquals(response3, response1);
    assertNotEquals(response2, response1);
    assertNotEquals(response3, response2);
    assertNotEquals(response1, null);
    assertNotEquals(response1, new Object());

    assertEquals(response3.hashCode(), response1.hashCode());
    assertNotEquals(response2.hashCode(), response1.hashCode());
    assertNotEquals(response3.hashCode(), response2.hashCode());
  }

  @Test
  public void testHasCommitStats() {
    com.google.spanner.v1.CommitResponse protoWithoutCommitStats =
        com.google.spanner.v1.CommitResponse.getDefaultInstance();
    CommitResponse responseWithoutCommitStats = new CommitResponse(protoWithoutCommitStats);
    assertFalse(responseWithoutCommitStats.hasCommitStats());

    com.google.spanner.v1.CommitResponse protoWithCommitStats =
        com.google.spanner.v1.CommitResponse.newBuilder()
            .setCommitStats(CommitStats.getDefaultInstance())
            .build();
    CommitResponse responseWithCommitStats = new CommitResponse(protoWithCommitStats);
    assertTrue(responseWithCommitStats.hasCommitStats());
  }

  @Test
  public void testGetSnapshotTimestamp() {
    com.google.spanner.v1.CommitResponse protoWithoutSnapshotTimestamp =
        com.google.spanner.v1.CommitResponse.getDefaultInstance();
    CommitResponse responseWithoutSnapshotTimestamp =
        new CommitResponse(protoWithoutSnapshotTimestamp);
    assertEquals(null, responseWithoutSnapshotTimestamp.getSnapshotTimestamp());

    com.google.protobuf.Timestamp timestamp =
        com.google.protobuf.Timestamp.newBuilder().setSeconds(123L).setNanos(456).build();
    com.google.spanner.v1.CommitResponse protoWithSnapshotTimestamp =
        com.google.spanner.v1.CommitResponse.newBuilder().setSnapshotTimestamp(timestamp).build();
    CommitResponse responseWithSnapshotTimestamp = new CommitResponse(protoWithSnapshotTimestamp);
    assertEquals(
        Timestamp.ofTimeSecondsAndNanos(123L, 456),
        responseWithSnapshotTimestamp.getSnapshotTimestamp());
  }
}
