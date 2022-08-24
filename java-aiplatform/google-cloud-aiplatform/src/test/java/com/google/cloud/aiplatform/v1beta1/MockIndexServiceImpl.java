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

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1beta1.IndexServiceGrpc.IndexServiceImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockIndexServiceImpl extends IndexServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockIndexServiceImpl() {
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
  public void createIndex(CreateIndexRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIndex(GetIndexRequest request, StreamObserver<Index> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Index) {
      requests.add(request);
      responseObserver.onNext(((Index) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Index.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIndexes(
      ListIndexesRequest request, StreamObserver<ListIndexesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIndexesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIndexesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIndexes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIndexesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIndex(UpdateIndexRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIndex(DeleteIndexRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void upsertDatapoints(
      UpsertDatapointsRequest request, StreamObserver<UpsertDatapointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UpsertDatapointsResponse) {
      requests.add(request);
      responseObserver.onNext(((UpsertDatapointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpsertDatapoints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UpsertDatapointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeDatapoints(
      RemoveDatapointsRequest request, StreamObserver<RemoveDatapointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RemoveDatapointsResponse) {
      requests.add(request);
      responseObserver.onNext(((RemoveDatapointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveDatapoints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RemoveDatapointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
