/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.DetachSubscriptionRequest;
import com.google.pubsub.v1.DetachSubscriptionResponse;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSnapshotsRequest;
import com.google.pubsub.v1.ListTopicSnapshotsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PublisherGrpc.PublisherImplBase;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.UpdateTopicRequest;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockPublisherImpl extends PublisherImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPublisherImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void createTopic(Topic request, StreamObserver<Topic> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Topic) {
      requests.add(request);
      responseObserver.onNext(((Topic) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTopic, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Topic.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTopic(UpdateTopicRequest request, StreamObserver<Topic> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Topic) {
      requests.add(request);
      responseObserver.onNext(((Topic) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTopic, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Topic.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void publish(PublishRequest request, StreamObserver<PublishResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PublishResponse) {
      requests.add(request);
      responseObserver.onNext(((PublishResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Publish, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PublishResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTopic(GetTopicRequest request, StreamObserver<Topic> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Topic) {
      requests.add(request);
      responseObserver.onNext(((Topic) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTopic, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Topic.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTopics(
      ListTopicsRequest request, StreamObserver<ListTopicsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTopicsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTopicsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTopics, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTopicsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTopicSubscriptions(
      ListTopicSubscriptionsRequest request,
      StreamObserver<ListTopicSubscriptionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTopicSubscriptionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTopicSubscriptionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTopicSubscriptions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTopicSubscriptionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTopicSnapshots(
      ListTopicSnapshotsRequest request,
      StreamObserver<ListTopicSnapshotsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTopicSnapshotsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTopicSnapshotsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTopicSnapshots, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTopicSnapshotsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTopic(DeleteTopicRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteTopic, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void detachSubscription(
      DetachSubscriptionRequest request,
      StreamObserver<DetachSubscriptionResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DetachSubscriptionResponse) {
      requests.add(request);
      responseObserver.onNext(((DetachSubscriptionResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DetachSubscription, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DetachSubscriptionResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
