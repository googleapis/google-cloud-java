/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigquery.storage.v1alpha2;

import com.google.api.core.BetaApi;
import com.google.cloud.bigquery.storage.v1alpha2.BigQueryWriteGrpc.BigQueryWriteImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
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
      Storage.CreateWriteStreamRequest request,
      StreamObserver<Stream.WriteStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Stream.WriteStream) {
      requests.add(request);
      responseObserver.onNext(((Stream.WriteStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateWriteStream, expected %s or %s",
                  response.getClass().getName(),
                  Stream.WriteStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<Storage.AppendRowsRequest> appendRows(
      final StreamObserver<Storage.AppendRowsResponse> responseObserver) {
    StreamObserver<Storage.AppendRowsRequest> requestObserver =
        new StreamObserver<Storage.AppendRowsRequest>() {
          @Override
          public void onNext(Storage.AppendRowsRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof Storage.AppendRowsResponse) {
              responseObserver.onNext(((Storage.AppendRowsResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method AppendRows, expected %s or %s",
                          response.getClass().getName(),
                          Storage.AppendRowsResponse.class.getName(),
                          Exception.class.getName())));
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
      Storage.GetWriteStreamRequest request, StreamObserver<Stream.WriteStream> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Stream.WriteStream) {
      requests.add(request);
      responseObserver.onNext(((Stream.WriteStream) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWriteStream, expected %s or %s",
                  response.getClass().getName(),
                  Stream.WriteStream.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void finalizeWriteStream(
      Storage.FinalizeWriteStreamRequest request,
      StreamObserver<Storage.FinalizeWriteStreamResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Storage.FinalizeWriteStreamResponse) {
      requests.add(request);
      responseObserver.onNext(((Storage.FinalizeWriteStreamResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FinalizeWriteStream, expected %s or %s",
                  response.getClass().getName(),
                  Storage.FinalizeWriteStreamResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCommitWriteStreams(
      Storage.BatchCommitWriteStreamsRequest request,
      StreamObserver<Storage.BatchCommitWriteStreamsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Storage.BatchCommitWriteStreamsResponse) {
      requests.add(request);
      responseObserver.onNext(((Storage.BatchCommitWriteStreamsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCommitWriteStreams, expected %s or %s",
                  response.getClass().getName(),
                  Storage.BatchCommitWriteStreamsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void flushRows(
      Storage.FlushRowsRequest request,
      StreamObserver<Storage.FlushRowsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Storage.FlushRowsResponse) {
      requests.add(request);
      responseObserver.onNext(((Storage.FlushRowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FlushRows, expected %s or %s",
                  response.getClass().getName(),
                  Storage.FlushRowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
