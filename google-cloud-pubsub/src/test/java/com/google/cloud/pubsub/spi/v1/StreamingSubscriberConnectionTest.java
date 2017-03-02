/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub.spi.v1;

import com.google.cloud.pubsub.spi.v1.MessageDispatcher.PendingModifyAckDeadline;
import com.google.common.truth.Truth;
import com.google.pubsub.v1.StreamingPullRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class StreamingSubscriberConnectionTest {
  private static List<StreamingPullRequest> partitionAckOperations(
      List<String> acksToSend, List<PendingModifyAckDeadline> ackDeadlineExtensions, int size) {
    List<StreamingPullRequest> requests = new ArrayList<>();
    for (StreamingPullRequest req :
        StreamingSubscriberConnection.partitionAckOperations(
            acksToSend, ackDeadlineExtensions, size)) {
      requests.add(req);
    }
    return requests;
  }

  @Test
  public void testPartitionAckOperations() {
    List<StreamingPullRequest> requests;

    requests =
        partitionAckOperations(
            Collections.<String>emptyList(), Collections.<PendingModifyAckDeadline>emptyList(), 3);
    Truth.assertThat(requests).isEmpty();

    requests =
        partitionAckOperations(
            Arrays.asList("a", "b", "c"), Collections.<PendingModifyAckDeadline>emptyList(), 3);
    Truth.assertThat(requests)
        .contains(
            StreamingPullRequest.newBuilder().addAckIds("a").addAckIds("b").addAckIds("c").build());

    requests =
        partitionAckOperations(
            Arrays.asList("a", "b", "c", "d"),
            Collections.<PendingModifyAckDeadline>emptyList(),
            3);
    Truth.assertThat(requests)
        .contains(
            StreamingPullRequest.newBuilder().addAckIds("a").addAckIds("b").addAckIds("c").build());
    Truth.assertThat(requests).contains(StreamingPullRequest.newBuilder().addAckIds("d").build());

    requests =
        partitionAckOperations(
            Arrays.asList("a", "b", "c", "d"),
            Arrays.asList(new PendingModifyAckDeadline(42, "A")),
            3);
    Truth.assertThat(requests)
        .contains(
            StreamingPullRequest.newBuilder()
                .addAckIds("a")
                .addAckIds("b")
                .addAckIds("c")
                .addModifyDeadlineAckIds("A")
                .addModifyDeadlineSeconds(42)
                .build());
    Truth.assertThat(requests).contains(StreamingPullRequest.newBuilder().addAckIds("d").build());

    requests =
        partitionAckOperations(
            Arrays.asList("a"), Arrays.asList(new PendingModifyAckDeadline(42, "A", "B")), 3);
    Truth.assertThat(requests)
        .contains(
            StreamingPullRequest.newBuilder()
                .addAckIds("a")
                .addModifyDeadlineAckIds("A")
                .addModifyDeadlineSeconds(42)
                .addModifyDeadlineAckIds("B")
                .addModifyDeadlineSeconds(42)
                .build());

    requests =
        partitionAckOperations(
            Arrays.asList("a"),
            Arrays.asList(
                new PendingModifyAckDeadline(42, "A", "B"),
                new PendingModifyAckDeadline(43, "C", "D")),
            3);
    Truth.assertThat(requests)
        .contains(
            StreamingPullRequest.newBuilder()
                .addAckIds("a")
                .addModifyDeadlineAckIds("A")
                .addModifyDeadlineSeconds(42)
                .addModifyDeadlineAckIds("B")
                .addModifyDeadlineSeconds(42)
                .addModifyDeadlineAckIds("C")
                .addModifyDeadlineSeconds(43)
                .build());
    Truth.assertThat(requests)
        .contains(
            StreamingPullRequest.newBuilder()
                .addModifyDeadlineAckIds("D")
                .addModifyDeadlineSeconds(43)
                .build());
  }
}
