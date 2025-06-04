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

package com.google.cloud.discoveryengine.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.discoveryengine.v1.IdentityMappingStoreServiceGrpc.IdentityMappingStoreServiceImplBase;
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
public class MockIdentityMappingStoreServiceImpl extends IdentityMappingStoreServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockIdentityMappingStoreServiceImpl() {
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
  public void createIdentityMappingStore(
      CreateIdentityMappingStoreRequest request,
      StreamObserver<IdentityMappingStore> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IdentityMappingStore) {
      requests.add(request);
      responseObserver.onNext(((IdentityMappingStore) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateIdentityMappingStore, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IdentityMappingStore.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIdentityMappingStore(
      GetIdentityMappingStoreRequest request,
      StreamObserver<IdentityMappingStore> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IdentityMappingStore) {
      requests.add(request);
      responseObserver.onNext(((IdentityMappingStore) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIdentityMappingStore, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  IdentityMappingStore.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIdentityMappingStore(
      DeleteIdentityMappingStoreRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteIdentityMappingStore, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importIdentityMappings(
      ImportIdentityMappingsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportIdentityMappings, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void purgeIdentityMappings(
      PurgeIdentityMappingsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method PurgeIdentityMappings, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIdentityMappings(
      ListIdentityMappingsRequest request,
      StreamObserver<ListIdentityMappingsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIdentityMappingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIdentityMappingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIdentityMappings, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIdentityMappingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIdentityMappingStores(
      ListIdentityMappingStoresRequest request,
      StreamObserver<ListIdentityMappingStoresResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIdentityMappingStoresResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIdentityMappingStoresResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIdentityMappingStores, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIdentityMappingStoresResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
