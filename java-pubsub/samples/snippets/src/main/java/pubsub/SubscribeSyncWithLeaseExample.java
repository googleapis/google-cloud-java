/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pubsub;

// [START pubsub_subscriber_sync_pull_with_lease]

import com.google.cloud.pubsub.v1.stub.GrpcSubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStubSettings;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.ReceivedMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubscribeSyncWithLeaseExample {
  public static void main(String... args) throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "your-project-id";
    String subscriptionId = "your-subscription-id";
    Integer numOfMessages = 10;

    projectId = "tz-playground-bigdata";
    subscriptionId = "uno";

    subscribeSyncWithLeaseExample(projectId, subscriptionId, numOfMessages);
  }

  public static void subscribeSyncWithLeaseExample(
      String projectId, String subscriptionId, Integer numOfMessages)
      throws IOException, InterruptedException {
    SubscriberStubSettings subscriberStubSettings =
        SubscriberStubSettings.newBuilder()
            .setTransportChannelProvider(
                SubscriberStubSettings.defaultGrpcTransportProviderBuilder()
                    .setMaxInboundMessageSize(20 << 20) // 20 MB
                    .build())
            .build();

    try (SubscriberStub subscriber = GrpcSubscriberStub.create(subscriberStubSettings)) {

      String subscriptionName = ProjectSubscriptionName.format(projectId, subscriptionId);

      PullRequest pullRequest =
          PullRequest.newBuilder()
              .setMaxMessages(numOfMessages)
              .setSubscription(subscriptionName)
              .build();

      // Use pullCallable().futureCall to asynchronously perform this operation.
      PullResponse pullResponse = subscriber.pullCallable().call(pullRequest);

      List<String> ackIds = new ArrayList<>();

      for (ReceivedMessage message : pullResponse.getReceivedMessagesList()) {
        ackIds.add(message.getAckId());

        // Modify the ack deadline of each received message from the default 10 seconds to 30.
        // This prevents the server from redelivering the message after the default 10 seconds
        // have passed.
        ModifyAckDeadlineRequest modifyAckDeadlineRequest =
            ModifyAckDeadlineRequest.newBuilder()
                .setSubscription(subscriptionName)
                .addAckIds(message.getAckId())
                .setAckDeadlineSeconds(30)
                .build();

        subscriber.modifyAckDeadlineCallable().call(modifyAckDeadlineRequest);
      }

      // Acknowledge received messages.
      AcknowledgeRequest acknowledgeRequest =
          AcknowledgeRequest.newBuilder()
              .setSubscription(subscriptionName)
              .addAllAckIds(ackIds)
              .build();

      // Use acknowledgeCallable().futureCall to asynchronously perform this operation.
      subscriber.acknowledgeCallable().call(acknowledgeRequest);
      System.out.println(pullResponse.getReceivedMessagesList());
    }
  }
}
// [END pubsub_subscriber_sync_pull_with_lease]
