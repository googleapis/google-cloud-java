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

package com.google.cloud.datastore.v1;

import com.google.api.core.BetaApi;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.DatastoreGrpc.DatastoreImplBase;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDatastoreImpl extends DatastoreImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDatastoreImpl() {
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
  public void lookup(LookupRequest request, StreamObserver<LookupResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LookupResponse) {
      requests.add(request);
      responseObserver.onNext(((LookupResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Lookup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LookupResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runQuery(RunQueryRequest request, StreamObserver<RunQueryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunQueryResponse) {
      requests.add(request);
      responseObserver.onNext(((RunQueryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunQueryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runAggregationQuery(
      RunAggregationQueryRequest request,
      StreamObserver<RunAggregationQueryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunAggregationQueryResponse) {
      requests.add(request);
      responseObserver.onNext(((RunAggregationQueryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunAggregationQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunAggregationQueryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void beginTransaction(
      BeginTransactionRequest request, StreamObserver<BeginTransactionResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BeginTransactionResponse) {
      requests.add(request);
      responseObserver.onNext(((BeginTransactionResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BeginTransaction, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BeginTransactionResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void commit(CommitRequest request, StreamObserver<CommitResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CommitResponse) {
      requests.add(request);
      responseObserver.onNext(((CommitResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Commit, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CommitResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rollback(RollbackRequest request, StreamObserver<RollbackResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RollbackResponse) {
      requests.add(request);
      responseObserver.onNext(((RollbackResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Rollback, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RollbackResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void allocateIds(
      AllocateIdsRequest request, StreamObserver<AllocateIdsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AllocateIdsResponse) {
      requests.add(request);
      responseObserver.onNext(((AllocateIdsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AllocateIds, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AllocateIdsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void reserveIds(
      ReserveIdsRequest request, StreamObserver<ReserveIdsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReserveIdsResponse) {
      requests.add(request);
      responseObserver.onNext(((ReserveIdsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReserveIds, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReserveIdsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
