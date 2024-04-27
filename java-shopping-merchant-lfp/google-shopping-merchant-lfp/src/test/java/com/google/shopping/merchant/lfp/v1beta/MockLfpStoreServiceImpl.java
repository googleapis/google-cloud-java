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

package com.google.shopping.merchant.lfp.v1beta;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.lfp.v1beta.LfpStoreServiceGrpc.LfpStoreServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockLfpStoreServiceImpl extends LfpStoreServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockLfpStoreServiceImpl() {
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
  public void getLfpStore(GetLfpStoreRequest request, StreamObserver<LfpStore> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LfpStore) {
      requests.add(request);
      responseObserver.onNext(((LfpStore) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetLfpStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LfpStore.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void insertLfpStore(
      InsertLfpStoreRequest request, StreamObserver<LfpStore> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LfpStore) {
      requests.add(request);
      responseObserver.onNext(((LfpStore) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method InsertLfpStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LfpStore.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteLfpStore(
      DeleteLfpStoreRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteLfpStore, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLfpStores(
      ListLfpStoresRequest request, StreamObserver<ListLfpStoresResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLfpStoresResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLfpStoresResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLfpStores, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLfpStoresResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
