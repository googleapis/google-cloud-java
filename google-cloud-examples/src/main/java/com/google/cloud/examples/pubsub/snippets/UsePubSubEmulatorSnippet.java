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

package com.google.cloud.examples.pubsub.snippets;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminSettings;
import com.google.pubsub.v1.TopicName;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;

/**
 * Snippet that demonstrates creating Pub/Sub clients using the Google Cloud Pub/Sub emulator.
 *
 * <p>Note: clients cannot start/stop the emulator.
 */
public class UsePubSubEmulatorSnippet {

  public static void main(String... args) throws IOException {
    // [START pubsub_use_emulator]
    String hostport = System.getenv("PUBSUB_EMULATOR_HOST");
    ManagedChannel channel = ManagedChannelBuilder.forTarget(hostport).usePlaintext().build();
    try {
      TransportChannelProvider channelProvider =
          FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel));
      CredentialsProvider credentialsProvider = NoCredentialsProvider.create();

      // Set the channel and credentials provider when creating a `TopicAdminClient`.
      // Similarly for SubscriptionAdminClient
      TopicAdminClient topicClient =
          TopicAdminClient.create(
              TopicAdminSettings.newBuilder()
                  .setTransportChannelProvider(channelProvider)
                  .setCredentialsProvider(credentialsProvider)
                  .build());

      TopicName topicName = TopicName.of("my-project-id", "my-topic-id");
      // Set the channel and credentials provider when creating a `Publisher`.
      // Similarly for Subscriber
      Publisher publisher =
          Publisher.newBuilder(topicName)
              .setChannelProvider(channelProvider)
              .setCredentialsProvider(credentialsProvider)
              .build();
    } finally {
      channel.shutdown();
    }
    // [END pubsub_use_emulator]
  }
}
