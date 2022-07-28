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

package com.google.cloud.privatecatalog.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.privatecatalog.v1beta1.PrivateCatalogGrpc.PrivateCatalogImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockPrivateCatalogImpl extends PrivateCatalogImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPrivateCatalogImpl() {
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
  public void searchCatalogs(
      SearchCatalogsRequest request, StreamObserver<SearchCatalogsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchCatalogsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchCatalogsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchCatalogs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchCatalogsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchProducts(
      SearchProductsRequest request, StreamObserver<SearchProductsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchProductsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchProductsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchProducts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchProductsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchVersions(
      SearchVersionsRequest request, StreamObserver<SearchVersionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchVersions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
