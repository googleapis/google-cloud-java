/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.gcloud.pubsub.spi;

import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PublisherGrpc;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;

import io.gapi.gax.grpc.ServiceApiSettings;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.netty.NegotiationType;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.NettyServerBuilder;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalServerChannel;

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
  private static Server server;
  private static LocalPublisherImpl publisherImpl;
  private ManagedChannel channel;
  private PublisherApi publisherApi;

  @BeforeClass
  public static void startStaticServer() {
    publisherImpl = new LocalPublisherImpl();
    NettyServerBuilder builder = NettyServerBuilder
        .forAddress(new LocalAddress("in-process-1"))
        .flowControlWindow(65 * 1024)
        .channelType(LocalServerChannel.class);
    builder.addService(PublisherGrpc.bindService(publisherImpl));
    try {
      server = builder.build().start();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  @AfterClass
  public static void stopServer() {
    server.shutdownNow();
  }

  @Before
  public void setUp() throws Exception {
    publisherImpl.reset();
    channel = NettyChannelBuilder
        .forAddress(new LocalAddress("in-process-1"))
        .negotiationType(NegotiationType.PLAINTEXT)
        .channelType(LocalChannel.class)
        .build();

    ServiceApiSettings settings = new ServiceApiSettings();
    settings.setChannel(channel);
    publisherApi = PublisherApi.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    if (channel != null) {
      channel.shutdown();
    }
    if (publisherApi != null) {
      publisherApi.close();
    }
    publisherImpl.reset();
  }

  @Test
  public void testCreateTopic() throws Exception {
    String topicName = PublisherApi.createTopic("my-project", "my-topic");

    Topic result = publisherApi.createTopic(topicName);
    Assert.assertEquals(topicName, result.getName());

    Assert.assertEquals(1, publisherImpl.getTopics().size());
    Assert.assertNotNull(publisherImpl.getTopics().get(topicName));
  }

  @Test
  public void testPublish() throws Exception {
    String topicName = PublisherApi.createTopic("my-project", "publish-topic");

    publisherApi.createTopic(topicName);
    PubsubMessage msg = PubsubMessage.newBuilder()
        .setData(ByteString.copyFromUtf8("pubsub-message"))
        .build();
    publisherApi.publish(topicName, Collections.singletonList(msg));
    List<PubsubMessage> publishedMessages = publisherImpl.getTopics().get(topicName);
    Assert.assertEquals(1, publishedMessages.size());
    Assert.assertEquals("pubsub-message", publishedMessages.get(0).getData().toStringUtf8());
  }

  @Test
  public void testGetTopic() throws Exception {
    String topicName = PublisherApi.createTopic("my-project", "fun-topic");

    publisherApi.createTopic(topicName);
    Topic result = publisherApi.getTopic(topicName);
    Assert.assertNotNull(result);
    Assert.assertEquals(topicName, result.getName());
  }

  @Test
  public void testListTopics() throws Exception {
    String project1 = PublisherApi.createProject("project.1");
    String topicName1 = PublisherApi.createTopic("project.1", "topic.1");
    String topicName2 = PublisherApi.createTopic("project.1", "topic.2");
    String topicName3 = PublisherApi.createTopic("project.2", "topic.3");

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
    String topicName = PublisherApi.createTopic("my-project", "fun-topic");

    publisherApi.createTopic(topicName);
    publisherApi.deleteTopic(topicName);
    Assert.assertEquals(0, publisherImpl.getTopics().size());
  }
}
