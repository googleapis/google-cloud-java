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

package com.google.shopping.merchant.conversions.v1beta;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.conversions.v1beta.ConversionSourcesServiceGrpc.ConversionSourcesServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockConversionSourcesServiceImpl extends ConversionSourcesServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockConversionSourcesServiceImpl() {
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
  public void createConversionSource(
      CreateConversionSourceRequest request, StreamObserver<ConversionSource> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversionSource) {
      requests.add(request);
      responseObserver.onNext(((ConversionSource) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateConversionSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversionSource.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConversionSource(
      UpdateConversionSourceRequest request, StreamObserver<ConversionSource> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversionSource) {
      requests.add(request);
      responseObserver.onNext(((ConversionSource) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConversionSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversionSource.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConversionSource(
      DeleteConversionSourceRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConversionSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeleteConversionSource(
      UndeleteConversionSourceRequest request, StreamObserver<ConversionSource> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversionSource) {
      requests.add(request);
      responseObserver.onNext(((ConversionSource) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UndeleteConversionSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversionSource.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConversionSource(
      GetConversionSourceRequest request, StreamObserver<ConversionSource> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversionSource) {
      requests.add(request);
      responseObserver.onNext(((ConversionSource) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConversionSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversionSource.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConversionSources(
      ListConversionSourcesRequest request,
      StreamObserver<ListConversionSourcesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConversionSourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConversionSourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConversionSources, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConversionSourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
