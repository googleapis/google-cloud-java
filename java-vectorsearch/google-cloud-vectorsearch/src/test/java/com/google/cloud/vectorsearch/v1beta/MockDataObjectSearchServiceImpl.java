/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.vectorsearch.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceGrpc.DataObjectSearchServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDataObjectSearchServiceImpl extends DataObjectSearchServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataObjectSearchServiceImpl() {
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
  public void searchDataObjects(
      SearchDataObjectsRequest request,
      StreamObserver<SearchDataObjectsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchDataObjectsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchDataObjectsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchDataObjects, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchDataObjectsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryDataObjects(
      QueryDataObjectsRequest request, StreamObserver<QueryDataObjectsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryDataObjectsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryDataObjectsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryDataObjects, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryDataObjectsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void aggregateDataObjects(
      AggregateDataObjectsRequest request,
      StreamObserver<AggregateDataObjectsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AggregateDataObjectsResponse) {
      requests.add(request);
      responseObserver.onNext(((AggregateDataObjectsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AggregateDataObjects, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  AggregateDataObjectsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchSearchDataObjects(
      BatchSearchDataObjectsRequest request,
      StreamObserver<BatchSearchDataObjectsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchSearchDataObjectsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchSearchDataObjectsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchSearchDataObjects, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchSearchDataObjectsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
