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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.core.BetaApi;
import com.google.cloud.discoveryengine.v1alpha.SampleQueryServiceGrpc.SampleQueryServiceImplBase;
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
public class MockSampleQueryServiceImpl extends SampleQueryServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSampleQueryServiceImpl() {
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
  public void getSampleQuery(
      GetSampleQueryRequest request, StreamObserver<SampleQuery> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SampleQuery) {
      requests.add(request);
      responseObserver.onNext(((SampleQuery) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSampleQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SampleQuery.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSampleQueries(
      ListSampleQueriesRequest request,
      StreamObserver<ListSampleQueriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSampleQueriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSampleQueriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSampleQueries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSampleQueriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSampleQuery(
      CreateSampleQueryRequest request, StreamObserver<SampleQuery> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SampleQuery) {
      requests.add(request);
      responseObserver.onNext(((SampleQuery) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSampleQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SampleQuery.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSampleQuery(
      UpdateSampleQueryRequest request, StreamObserver<SampleQuery> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SampleQuery) {
      requests.add(request);
      responseObserver.onNext(((SampleQuery) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSampleQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SampleQuery.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSampleQuery(
      DeleteSampleQueryRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSampleQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importSampleQueries(
      ImportSampleQueriesRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportSampleQueries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
