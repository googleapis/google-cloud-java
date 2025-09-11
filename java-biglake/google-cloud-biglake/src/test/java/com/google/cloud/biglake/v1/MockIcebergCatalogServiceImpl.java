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

package com.google.cloud.biglake.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.biglake.v1.IcebergCatalogServiceGrpc.IcebergCatalogServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockIcebergCatalogServiceImpl extends IcebergCatalogServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockIcebergCatalogServiceImpl() {
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
  public void getIcebergCatalog(
      GetIcebergCatalogRequest request, StreamObserver<IcebergCatalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IcebergCatalog) {
      requests.add(request);
      responseObserver.onNext(((IcebergCatalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIcebergCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IcebergCatalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIcebergCatalogs(
      ListIcebergCatalogsRequest request,
      StreamObserver<ListIcebergCatalogsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIcebergCatalogsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIcebergCatalogsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIcebergCatalogs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIcebergCatalogsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIcebergCatalog(
      UpdateIcebergCatalogRequest request, StreamObserver<IcebergCatalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IcebergCatalog) {
      requests.add(request);
      responseObserver.onNext(((IcebergCatalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateIcebergCatalog, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  IcebergCatalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createIcebergCatalog(
      CreateIcebergCatalogRequest request, StreamObserver<IcebergCatalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IcebergCatalog) {
      requests.add(request);
      responseObserver.onNext(((IcebergCatalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateIcebergCatalog, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  IcebergCatalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void failoverIcebergCatalog(
      FailoverIcebergCatalogRequest request,
      StreamObserver<FailoverIcebergCatalogResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FailoverIcebergCatalogResponse) {
      requests.add(request);
      responseObserver.onNext(((FailoverIcebergCatalogResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FailoverIcebergCatalog, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  FailoverIcebergCatalogResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
