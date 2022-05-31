/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dataplex.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.dataplex.v1.MetadataServiceGrpc.MetadataServiceImplBase;
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
public class MockMetadataServiceImpl extends MetadataServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMetadataServiceImpl() {
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
  public void createEntity(CreateEntityRequest request, StreamObserver<Entity> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entity) {
      requests.add(request);
      responseObserver.onNext(((Entity) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEntity, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entity.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEntity(UpdateEntityRequest request, StreamObserver<Entity> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entity) {
      requests.add(request);
      responseObserver.onNext(((Entity) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEntity, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entity.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEntity(DeleteEntityRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEntity, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEntity(GetEntityRequest request, StreamObserver<Entity> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entity) {
      requests.add(request);
      responseObserver.onNext(((Entity) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEntity, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entity.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntities(
      ListEntitiesRequest request, StreamObserver<ListEntitiesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntitiesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntitiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntities, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntitiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPartition(
      CreatePartitionRequest request, StreamObserver<Partition> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Partition) {
      requests.add(request);
      responseObserver.onNext(((Partition) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePartition, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Partition.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePartition(
      DeletePartitionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePartition, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPartition(
      GetPartitionRequest request, StreamObserver<Partition> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Partition) {
      requests.add(request);
      responseObserver.onNext(((Partition) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPartition, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Partition.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPartitions(
      ListPartitionsRequest request, StreamObserver<ListPartitionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPartitionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPartitionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPartitions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPartitionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
