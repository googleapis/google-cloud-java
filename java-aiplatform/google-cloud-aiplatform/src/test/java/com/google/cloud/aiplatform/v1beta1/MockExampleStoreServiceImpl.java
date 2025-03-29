/*
 * Copyright 2025 Google LLC
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
import com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceGrpc.ExampleStoreServiceImplBase;
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
public class MockExampleStoreServiceImpl extends ExampleStoreServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockExampleStoreServiceImpl() {
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
  public void createExampleStore(
      CreateExampleStoreRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateExampleStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getExampleStore(
      GetExampleStoreRequest request, StreamObserver<ExampleStore> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExampleStore) {
      requests.add(request);
      responseObserver.onNext(((ExampleStore) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetExampleStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExampleStore.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExampleStore(
      UpdateExampleStoreRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateExampleStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteExampleStore(
      DeleteExampleStoreRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteExampleStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listExampleStores(
      ListExampleStoresRequest request,
      StreamObserver<ListExampleStoresResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListExampleStoresResponse) {
      requests.add(request);
      responseObserver.onNext(((ListExampleStoresResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListExampleStores, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListExampleStoresResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void upsertExamples(
      UpsertExamplesRequest request, StreamObserver<UpsertExamplesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UpsertExamplesResponse) {
      requests.add(request);
      responseObserver.onNext(((UpsertExamplesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpsertExamples, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UpsertExamplesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeExamples(
      RemoveExamplesRequest request, StreamObserver<RemoveExamplesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RemoveExamplesResponse) {
      requests.add(request);
      responseObserver.onNext(((RemoveExamplesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveExamples, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RemoveExamplesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchExamples(
      SearchExamplesRequest request, StreamObserver<SearchExamplesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchExamplesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchExamplesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchExamples, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchExamplesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchExamples(
      FetchExamplesRequest request, StreamObserver<FetchExamplesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchExamplesResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchExamplesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchExamples, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchExamplesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
