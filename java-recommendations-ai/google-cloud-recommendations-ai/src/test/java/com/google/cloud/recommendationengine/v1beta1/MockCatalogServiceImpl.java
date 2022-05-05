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

package com.google.cloud.recommendationengine.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.recommendationengine.v1beta1.CatalogServiceGrpc.CatalogServiceImplBase;
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
public class MockCatalogServiceImpl extends CatalogServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCatalogServiceImpl() {
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
  public void createCatalogItem(
      CreateCatalogItemRequest request, StreamObserver<CatalogItem> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CatalogItem) {
      requests.add(request);
      responseObserver.onNext(((CatalogItem) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCatalogItem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CatalogItem.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCatalogItem(
      GetCatalogItemRequest request, StreamObserver<CatalogItem> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CatalogItem) {
      requests.add(request);
      responseObserver.onNext(((CatalogItem) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCatalogItem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CatalogItem.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCatalogItems(
      ListCatalogItemsRequest request, StreamObserver<ListCatalogItemsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCatalogItemsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCatalogItemsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCatalogItems, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCatalogItemsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCatalogItem(
      UpdateCatalogItemRequest request, StreamObserver<CatalogItem> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CatalogItem) {
      requests.add(request);
      responseObserver.onNext(((CatalogItem) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCatalogItem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CatalogItem.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCatalogItem(
      DeleteCatalogItemRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCatalogItem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importCatalogItems(
      ImportCatalogItemsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportCatalogItems, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
