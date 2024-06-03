/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.managedkafka.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.managedkafka.v1.ManagedKafkaGrpc.ManagedKafkaImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockManagedKafkaImpl extends ManagedKafkaImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockManagedKafkaImpl() {
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
  public void listClusters(
      ListClustersRequest request, StreamObserver<ListClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCluster(GetClusterRequest request, StreamObserver<Cluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Cluster) {
      requests.add(request);
      responseObserver.onNext(((Cluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Cluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCluster(
      CreateClusterRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCluster(
      UpdateClusterRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCluster(
      DeleteClusterRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
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
  public void createTopic(CreateTopicRequest request, StreamObserver<Topic> responseObserver) {
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
  public void listConsumerGroups(
      ListConsumerGroupsRequest request,
      StreamObserver<ListConsumerGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConsumerGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConsumerGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConsumerGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConsumerGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConsumerGroup(
      GetConsumerGroupRequest request, StreamObserver<ConsumerGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConsumerGroup) {
      requests.add(request);
      responseObserver.onNext(((ConsumerGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConsumerGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConsumerGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConsumerGroup(
      UpdateConsumerGroupRequest request, StreamObserver<ConsumerGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConsumerGroup) {
      requests.add(request);
      responseObserver.onNext(((ConsumerGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConsumerGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConsumerGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConsumerGroup(
      DeleteConsumerGroupRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConsumerGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
