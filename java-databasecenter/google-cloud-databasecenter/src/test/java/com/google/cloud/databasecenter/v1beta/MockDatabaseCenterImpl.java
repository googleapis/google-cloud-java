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

package com.google.cloud.databasecenter.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.databasecenter.v1beta.DatabaseCenterGrpc.DatabaseCenterImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDatabaseCenterImpl extends DatabaseCenterImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDatabaseCenterImpl() {
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
  public void queryProducts(
      QueryProductsRequest request, StreamObserver<QueryProductsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryProductsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryProductsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryProducts, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryProductsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void aggregateFleet(
      AggregateFleetRequest request, StreamObserver<AggregateFleetResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AggregateFleetResponse) {
      requests.add(request);
      responseObserver.onNext(((AggregateFleetResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AggregateFleet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AggregateFleetResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryDatabaseResourceGroups(
      QueryDatabaseResourceGroupsRequest request,
      StreamObserver<QueryDatabaseResourceGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QueryDatabaseResourceGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((QueryDatabaseResourceGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryDatabaseResourceGroups, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QueryDatabaseResourceGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
