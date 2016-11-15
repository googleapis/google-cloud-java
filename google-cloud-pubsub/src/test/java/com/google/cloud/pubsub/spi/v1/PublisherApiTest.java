/*
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.pubsub.spi.v1;

import com.google.api.gax.grpc.BundlingSettings;
import com.google.api.gax.grpc.FixedChannelProvider;
import com.google.cloud.pubsub.testing.LocalPubSubHelper;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.SubscriptionName;

import io.grpc.ManagedChannel;

import org.joda.time.Duration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PublisherApiTest {
  private static LocalPubSubHelper pubsubHelper;
  private PublisherApi publisherApi;
  private PublisherApi bundledPublisherApi;
  private SubscriberApi subscriberApi;
  private ManagedChannel channel;

  @BeforeClass
  public static void startServer() throws IOException, InterruptedException {
    pubsubHelper = LocalPubSubHelper.create();
    pubsubHelper.start();
  }

  @AfterClass
  public static void stopServer() throws IOException, InterruptedException {
    pubsubHelper.stop();
  }

  @Before
  public void setUp() throws Exception {
    channel = pubsubHelper.createChannel();
    FixedChannelProvider fixedChannelProvider = FixedChannelProvider.create(channel);

    PublisherSettings publisherSettings =
        PublisherSettings.defaultBuilder()
            .setChannelProvider(fixedChannelProvider)
            .build();
    publisherApi = PublisherApi.create(publisherSettings);

    BundlingSettings.Builder bundlingSettings =
        BundlingSettings.newBuilder()
            .setElementCountThreshold(10)
            .setDelayThreshold(Duration.standardSeconds(30));

    PublisherSettings.Builder bundledPublisherSettingsBuilder = PublisherSettings.defaultBuilder();
    bundledPublisherSettingsBuilder
        .setChannelProvider(fixedChannelProvider)
        .publishSettings()
        .setBundlingSettingsBuilder(bundlingSettings);

    PublisherSettings bundledPublisherSettings = bundledPublisherSettingsBuilder.build();
    bundledPublisherApi = PublisherApi.create(bundledPublisherSettings);

    SubscriberSettings subscriberSettings = SubscriberSettings.defaultBuilder()
        .setChannelProvider(fixedChannelProvider)
        .build();
    subscriberApi = SubscriberApi.create(subscriberSettings);
  }

  @After
  public void tearDown() throws Exception {
    if (publisherApi != null) {
      publisherApi.close();
    }
    if (subscriberApi != null) {
      subscriberApi.close();
    }
    if (bundledPublisherApi != null) {
      bundledPublisherApi.close();
    }
    if (channel != null) {
      channel.shutdown();
    }
    pubsubHelper.reset();
  }

  @Test
  public void testCreateTopic() throws Exception {
    TopicName topicName = TopicName.create("my-project", "my-topic");
    Topic result = publisherApi.createTopic(topicName);
    Assert.assertEquals(topicName, result.getNameAsTopicName());
  }

  @Test
  public void testPublish() throws Exception {
    TopicName topicName = TopicName.create("my-project", "my-topic");
    publisherApi.createTopic(topicName);

    SubscriptionName subscriberName = SubscriptionName.create("my-project", "my-subscribe");
    PushConfig config = PushConfig.getDefaultInstance();
    subscriberApi.createSubscription(subscriberName, topicName, config, 5);

    PubsubMessage msg =
        PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("pubsub-message")).build();
    publisherApi.publish(topicName, Collections.singletonList(msg));

    PullResponse response = subscriberApi.pull(subscriberName, true, 100);
    Assert.assertEquals(1, response.getReceivedMessagesCount());
    Assert.assertEquals(
        "pubsub-message", response.getReceivedMessages(0).getMessage().getData().toStringUtf8());
  }

  @Test
  public void testBundledPublish() throws Exception {
    TopicName topicName = TopicName.create("my-project", "my-topic");
    bundledPublisherApi.createTopic(topicName);

    SubscriptionName subscriberName = SubscriptionName.create("my-project", "my-subscribe");
    PushConfig config = PushConfig.getDefaultInstance();
    subscriberApi.createSubscription(subscriberName, topicName, config, 5);

    PubsubMessage msg =
        PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("pubsub-message")).build();
    // This is a synchronous publish and should trigger the default blockingCallCountThreshold of 1
    bundledPublisherApi.publish(topicName, Collections.singletonList(msg));

    PullResponse response = subscriberApi.pull(subscriberName, true, 100);
    Assert.assertEquals(1, response.getReceivedMessagesCount());
    Assert.assertEquals(
        "pubsub-message", response.getReceivedMessages(0).getMessage().getData().toStringUtf8());
  }

  @Test
  public void testGetTopic() throws Exception {
    TopicName topicName = TopicName.create("my-project", "my-topic");
    publisherApi.createTopic(topicName);
    Topic result = publisherApi.getTopic(topicName);
    Assert.assertNotNull(result);
    Assert.assertEquals(topicName, result.getNameAsTopicName());
  }

  @Test
  public void testListTopics() throws Exception {
    ProjectName project1 = ProjectName.create("project.1");
    TopicName topicName1 = TopicName.create("project.1", "topic.1");
    TopicName topicName2 = TopicName.create("project.1", "topic.2");
    TopicName topicName3 = TopicName.create("project.2", "topic.3");
    publisherApi.createTopic(topicName1);
    publisherApi.createTopic(topicName2);
    publisherApi.createTopic(topicName3);
    List<Topic> topics = new ArrayList<>();
    for (Topic topic : publisherApi.listTopics(project1).iterateAllElements()) {
      topics.add(topic);
    }
    Assert.assertEquals(2, topics.size());
    Assert.assertEquals(topicName1, topics.get(0).getNameAsTopicName());
    Assert.assertEquals(topicName2, topics.get(1).getNameAsTopicName());
  }

  @Test
  public void testDeleteTopic() throws Exception {
    ProjectName project = ProjectName.create("project.1");
    TopicName topicName = TopicName.create("my-project", "my-topic");
    publisherApi.createTopic(topicName);
    publisherApi.deleteTopic(topicName);
    List<Topic> topics = new ArrayList<>();
    for (Topic topic : publisherApi.listTopics(project).iterateAllElements()) {
      topics.add(topic);
    }
    Assert.assertEquals(0, topics.size());
  }
}
