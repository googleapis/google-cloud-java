package com.google.cloud.examples.pubsub.snippets;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.FixedChannelProvider;
import com.google.api.gax.grpc.GrpcTransportProvider;
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

  public static void createClientsUsingEmulator() throws IOException {
    // [START use_pubsub_emulator]
    String hostport = System.getenv("PUBSUB_EMULATOR_HOST");
    ManagedChannel channel = ManagedChannelBuilder.forTarget(hostport).usePlaintext(true).build();
    try {
      ChannelProvider channelProvider = FixedChannelProvider.create(channel);
      CredentialsProvider credentialsProvider = new NoCredentialsProvider();

      // Set the channel and credentials provider when creating a `TopicAdminClient`.
      // Similarly for SubscriptionAdminClient
      TopicAdminClient topicClient =
          TopicAdminClient.create(
              TopicAdminSettings.newBuilder()
                  .setTransportProvider(
                      GrpcTransportProvider.newBuilder()
                          .setChannelProvider(channelProvider)
                          .build())
                  .setCredentialsProvider(credentialsProvider)
                  .build());

      TopicName topicName = TopicName.create("my-project-id", "my-topic-id");
      // Set the channel and credentials provider when creating a `Publisher`.
      // Similarly for Subscriber
      Publisher publisher =
          Publisher.defaultBuilder(topicName)
              .setChannelProvider(channelProvider)
              .setCredentialsProvider(credentialsProvider)
              .build();
    } finally {
      channel.shutdown();
    }
    // [END use_pubsub_emulator]
  }
}
