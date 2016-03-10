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

package com.google.gcloud.pubsub.spi;

import com.google.gcloud.pubsub.testing.LocalPubsubHelper;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.Topic;

import io.grpc.ManagedChannel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PublisherApiTest {
  private static LocalPubsubHelper pubsubHelper;
  private PublisherApi publisherApi;
  private SubscriberApi subscriberApi;

  @BeforeClass
  public static void startServer() throws IOException, InterruptedException {
    pubsubHelper = new LocalPubsubHelper();
    pubsubHelper.start();
  }

  @AfterClass
  public static void stopServer() throws IOException, InterruptedException {
    pubsubHelper.stop();
  }

  @Before
  public void setUp() throws Exception {
    ManagedChannel channel = pubsubHelper.createChannel();

    PublisherSettings publisherSettings = PublisherApi.newSettings();
    publisherSettings.provideChannelWith(channel);
    publisherApi = PublisherApi.create(publisherSettings);

    SubscriberSettings subscriberSettings = SubscriberApi.newSettings();
    subscriberSettings.provideChannelWith(channel);
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
    pubsubHelper.reset();
  }

  @Test
  public void testCreateTopic() throws Exception {
    String topicName = PublisherApi.ResourceNames.formatTopicPath("my-project", "my-topic");
    Topic result = publisherApi.createTopic(topicName);
    Assert.assertEquals(topicName, result.getName());
  }

  @Test
  public void testPublish() throws Exception {
    String topicName = PublisherApi.ResourceNames.formatTopicPath("my-project", "publish-topic");
    publisherApi.createTopic(topicName);

    String subscriberName = SubscriberApi.ResourceNames.formatSubscriptionPath("my-project", "my-subscribe");
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
  public void testGetTopic() throws Exception {
    String topicName = PublisherApi.ResourceNames.formatTopicPath("my-project", "fun-topic");
    publisherApi.createTopic(topicName);
    Topic result = publisherApi.getTopic(topicName);
    Assert.assertNotNull(result);
    Assert.assertEquals(topicName, result.getName());
  }

  @Test
  public void testListTopics() throws Exception {
    String project1 = PublisherApi.ResourceNames.formatProjectPath("project.1");
    String topicName1 = PublisherApi.ResourceNames.formatTopicPath("project.1", "topic.1");
    String topicName2 = PublisherApi.ResourceNames.formatTopicPath("project.1", "topic.2");
    String topicName3 = PublisherApi.ResourceNames.formatTopicPath("project.2", "topic.3");
    publisherApi.createTopic(topicName1);
    publisherApi.createTopic(topicName2);
    publisherApi.createTopic(topicName3);
    List<Topic> topics = new ArrayList<>();
    for (Topic topic : publisherApi.listTopics(project1)) {
      topics.add(topic);
    }
    Assert.assertEquals(2, topics.size());
    Assert.assertEquals(topicName1, topics.get(0).getName());
    Assert.assertEquals(topicName2, topics.get(1).getName());
  }

  @Test
  public void testDeleteTopic() throws Exception {
    String project = PublisherApi.ResourceNames.formatProjectPath("project.1");
    String topicName = PublisherApi.ResourceNames.formatTopicPath("my-project", "fun-topic");
    publisherApi.createTopic(topicName);
    publisherApi.deleteTopic(topicName);
    List<Topic> topics = new ArrayList<>();
    for (Topic topic : publisherApi.listTopics(project)) {
      topics.add(topic);
    }
    Assert.assertEquals(0, topics.size());
  }
}
