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

package com.google.gcloud.pubsub.spi.testing;

import com.google.gcloud.pubsub.spi.PublisherApi;
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
  public void listTopics(
      ListTopicsRequest request, StreamObserver<ListTopicsResponse> responseObserver) {
    List<Topic> responseTopics = new ArrayList<>();
    for (String topicName : topics.keySet()) {
      String projectOfTopic = PublisherApi.ResourceNames.parseProjectFromTopicPath(topicName);
      String projectOfRequest = PublisherApi.ResourceNames.parseProjectFromProjectPath(request.getProject());
      if (projectOfTopic.equals(projectOfRequest)) {
        Topic topicObj = Topic.newBuilder().setName(topicName).build();
        responseTopics.add(topicObj);
      }
    }
    Collections.sort(
        responseTopics,
        new Comparator<Topic>() {
          @Override
          public int compare(Topic o1, Topic o2) {
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
  public void listTopicSubscriptions(
      ListTopicSubscriptionsRequest request,
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
