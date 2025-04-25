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
import com.google.cloud.discoveryengine.v1alpha.SampleQuerySetServiceGrpc.SampleQuerySetServiceImplBase;
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
public class MockSampleQuerySetServiceImpl extends SampleQuerySetServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSampleQuerySetServiceImpl() {
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
  public void getSampleQuerySet(
      GetSampleQuerySetRequest request, StreamObserver<SampleQuerySet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SampleQuerySet) {
      requests.add(request);
      responseObserver.onNext(((SampleQuerySet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSampleQuerySet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SampleQuerySet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSampleQuerySets(
      ListSampleQuerySetsRequest request,
      StreamObserver<ListSampleQuerySetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSampleQuerySetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSampleQuerySetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSampleQuerySets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSampleQuerySetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSampleQuerySet(
      CreateSampleQuerySetRequest request, StreamObserver<SampleQuerySet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SampleQuerySet) {
      requests.add(request);
      responseObserver.onNext(((SampleQuerySet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSampleQuerySet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SampleQuerySet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSampleQuerySet(
      UpdateSampleQuerySetRequest request, StreamObserver<SampleQuerySet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SampleQuerySet) {
      requests.add(request);
      responseObserver.onNext(((SampleQuerySet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSampleQuerySet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SampleQuerySet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSampleQuerySet(
      DeleteSampleQuerySetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSampleQuerySet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
