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

package com.google.cloud.bigquery.storage.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.bigquery.storage.v1beta.MetastorePartitionServiceGrpc.MetastorePartitionServiceImplBase;
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
public class MockMetastorePartitionServiceImpl extends MetastorePartitionServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMetastorePartitionServiceImpl() {
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
  public void batchCreateMetastorePartitions(
      BatchCreateMetastorePartitionsRequest request,
      StreamObserver<BatchCreateMetastorePartitionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateMetastorePartitionsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateMetastorePartitionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateMetastorePartitions,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateMetastorePartitionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteMetastorePartitions(
      BatchDeleteMetastorePartitionsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method BatchDeleteMetastorePartitions,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchUpdateMetastorePartitions(
      BatchUpdateMetastorePartitionsRequest request,
      StreamObserver<BatchUpdateMetastorePartitionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchUpdateMetastorePartitionsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchUpdateMetastorePartitionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchUpdateMetastorePartitions,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchUpdateMetastorePartitionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMetastorePartitions(
      ListMetastorePartitionsRequest request,
      StreamObserver<ListMetastorePartitionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMetastorePartitionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMetastorePartitionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMetastorePartitions, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMetastorePartitionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<StreamMetastorePartitionsRequest> streamMetastorePartitions(
      final StreamObserver<StreamMetastorePartitionsResponse> responseObserver) {
    StreamObserver<StreamMetastorePartitionsRequest> requestObserver =
        new StreamObserver<StreamMetastorePartitionsRequest>() {
          @Override
          public void onNext(StreamMetastorePartitionsRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamMetastorePartitionsResponse) {
              responseObserver.onNext(((StreamMetastorePartitionsResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamMetastorePartitions,"
                              + " expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamMetastorePartitionsResponse.class.getName(),
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
}
