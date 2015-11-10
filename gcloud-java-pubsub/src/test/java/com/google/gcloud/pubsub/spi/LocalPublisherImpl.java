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

import com.google.protobuf.Empty;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PublisherGrpc.Publisher;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;

import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalPublisherImpl implements Publisher {

  private Map<String, List<PubsubMessage>> topics = new HashMap<>();

  @Override
  public void createTopic(Topic request, StreamObserver<Topic> responseObserver) {
    topics.put(request.getName(), new ArrayList<PubsubMessage>());

    Topic response = Topic.newBuilder().setName(request.getName()).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void publish(PublishRequest request, StreamObserver<PublishResponse> responseObserver) {
    List<PubsubMessage> topicMessages = topics.get(request.getTopic());
    List<String> ids = new ArrayList<>();
    int index = 0;
    for (PubsubMessage msg : request.getMessagesList()) {
      topicMessages.add(msg);
      ids.add(new Integer(index).toString());
    }

    responseObserver.onNext(PublishResponse.newBuilder().addAllMessageIds(ids).build());
    responseObserver.onCompleted();
  }

  @Override
  public void getTopic(GetTopicRequest request, StreamObserver<Topic> responseObserver) {
    if (topics.get(request.getTopic()) == null) {
      throw new IllegalArgumentException("topic doesn't exist: " + request.getTopic());
    }

    Topic response = Topic.newBuilder().setName(request.getTopic()).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void listTopics(ListTopicsRequest request, StreamObserver<ListTopicsResponse> responseObserver) {
    List<Topic> responseTopics = new ArrayList<>();
    for (String topicName : topics.keySet()) {
      String projectOfTopic = PublisherApi.TOPIC_PATH_TEMPLATE.parse(topicName).get("project");
      String projectOfRequest = PublisherApi.PROJECT_PATH_TEMPLATE.parse(request.getProject()).get("project");
      if (projectOfTopic.equals(projectOfRequest)) {
        Topic topicObj = Topic.newBuilder().setName(topicName).build();
        responseTopics.add(topicObj);
      }
    }
    Collections.sort(responseTopics, new Comparator<Topic>() {
      @Override public int compare(Topic o1, Topic o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
    ListTopicsResponse.Builder response = ListTopicsResponse.newBuilder();
    response.setNextPageToken("");
    response.addAllTopics(responseTopics);
    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

  @Override
  public void listTopicSubscriptions(ListTopicSubscriptionsRequest request,
      StreamObserver<ListTopicSubscriptionsResponse> responseObserver) {
    responseObserver.onNext(ListTopicSubscriptionsResponse.getDefaultInstance());
    responseObserver.onCompleted();
  }

  @Override
  public void deleteTopic(DeleteTopicRequest request, StreamObserver<Empty> responseObserver) {
    topics.remove(request.getTopic());
    responseObserver.onNext(Empty.getDefaultInstance());
    responseObserver.onCompleted();
  }

  public Map<String, List<PubsubMessage>> getTopics() {
    return topics;
  }

  public void reset() {
    topics = new HashMap<>();
  }
}
