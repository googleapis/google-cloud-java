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

package com.google.cloud.pubsub.v1;

import com.google.cloud.pubsub.v1.MessageDispatcher.PendingModifyAckDeadline;
import com.google.common.truth.Truth;
import com.google.pubsub.v1.StreamingPullRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class StreamingSubscriberConnectionTest {
  @Test
  public void testPartitionAckOperations() {
    List<StreamingPullRequest> requests;

    requests =
        StreamingSubscriberConnection.partitionAckOperations(
            Collections.<String>emptyList(), Collections.<PendingModifyAckDeadline>emptyList(), 3);
    Truth.assertThat(requests).isEmpty();

    requests =
        StreamingSubscriberConnection.partitionAckOperations(
            Arrays.asList("a", "b", "c"), Collections.<PendingModifyAckDeadline>emptyList(), 3);
    Truth.assertThat(requests)
        .containsExactly(
            StreamingPullRequest.newBuilder().addAckIds("a").addAckIds("b").addAckIds("c").build())
        .inOrder();

    requests =
        StreamingSubscriberConnection.partitionAckOperations(
            Arrays.asList("a", "b", "c", "d"),
            Collections.<PendingModifyAckDeadline>emptyList(),
            3);
    Truth.assertThat(requests)
        .containsExactly(
            StreamingPullRequest.newBuilder().addAckIds("a").addAckIds("b").addAckIds("c").build(),
            StreamingPullRequest.newBuilder().addAckIds("d").build())
        .inOrder();

    requests =
        StreamingSubscriberConnection.partitionAckOperations(
            Arrays.asList("a", "b", "c", "d"),
            Arrays.asList(new PendingModifyAckDeadline(42, "w")),
            3);
    Truth.assertThat(requests)
        .containsExactly(
            StreamingPullRequest.newBuilder()
                .addAckIds("a")
                .addAckIds("b")
                .addAckIds("c")
                .addModifyDeadlineAckIds("w")
                .addModifyDeadlineSeconds(42)
                .build(),
            StreamingPullRequest.newBuilder().addAckIds("d").build())
        .inOrder();

    requests =
        StreamingSubscriberConnection.partitionAckOperations(
            Arrays.asList("a"), Arrays.asList(new PendingModifyAckDeadline(42, "w", "x")), 3);
    Truth.assertThat(requests)
        .containsExactly(
            StreamingPullRequest.newBuilder()
                .addAckIds("a")
                .addModifyDeadlineAckIds("w")
                .addModifyDeadlineSeconds(42)
                .addModifyDeadlineAckIds("x")
                .addModifyDeadlineSeconds(42)
                .build())
        .inOrder();

    requests =
        StreamingSubscriberConnection.partitionAckOperations(
            Arrays.asList("a"),
            Arrays.asList(
                new PendingModifyAckDeadline(42, "w", "x"),
                new PendingModifyAckDeadline(43, "y", "z")),
            3);
    Truth.assertThat(requests)
        .containsExactly(
            StreamingPullRequest.newBuilder()
                .addAckIds("a")
                .addModifyDeadlineAckIds("w")
                .addModifyDeadlineSeconds(42)
                .addModifyDeadlineAckIds("x")
                .addModifyDeadlineSeconds(42)
                .addModifyDeadlineAckIds("y")
                .addModifyDeadlineSeconds(43)
                .build(),
            StreamingPullRequest.newBuilder()
                .addModifyDeadlineAckIds("z")
                .addModifyDeadlineSeconds(43)
                .build())
        .inOrder();
  }
}
