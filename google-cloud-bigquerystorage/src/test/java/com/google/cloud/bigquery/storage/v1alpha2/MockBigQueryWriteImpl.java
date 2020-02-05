/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.api.core.BetaApi;
import com.google.cloud.bigquery.storage.v1alpha2.BigQueryWriteGrpc.BigQueryWriteImplBase;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FinalizeWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1alpha2.Storage.GetWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1alpha2.Stream.WriteStream;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockBigQueryWriteImpl extends BigQueryWriteImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockBigQueryWriteImpl() {
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
  public void createWriteStream(
      CreateWriteStreamRequest request, StreamObserver<WriteStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof WriteStream) {
      requests.add(request);
      responseObserver.onNext((WriteStream) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public StreamObserver<AppendRowsRequest> appendRows(
      final StreamObserver<AppendRowsResponse> responseObserver) {
    final Object response = responses.remove();
    StreamObserver<AppendRowsRequest> requestObserver =
        new StreamObserver<AppendRowsRequest>() {
          @Override
          public void onNext(AppendRowsRequest value) {
            if (response instanceof AppendRowsResponse) {
              responseObserver.onNext((AppendRowsResponse) response);
            } else if (response instanceof Exception) {
              responseObserver.onError((Exception) response);
            } else {
              responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
            }
          }

          @Override
          public void onError(Throwable t) {
            responseObserver.onError(t);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        };
    return requestObserver;
  }

  @Override
  public void getWriteStream(
      GetWriteStreamRequest request, StreamObserver<WriteStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof WriteStream) {
      requests.add(request);
      responseObserver.onNext((WriteStream) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void finalizeWriteStream(
      FinalizeWriteStreamRequest request,
      StreamObserver<FinalizeWriteStreamResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof FinalizeWriteStreamResponse) {
      requests.add(request);
      responseObserver.onNext((FinalizeWriteStreamResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void batchCommitWriteStreams(
      BatchCommitWriteStreamsRequest request,
      StreamObserver<BatchCommitWriteStreamsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchCommitWriteStreamsResponse) {
      requests.add(request);
      responseObserver.onNext((BatchCommitWriteStreamsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
