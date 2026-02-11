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

package com.google.cloud.networksecurity.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.networksecurity.v1beta1.DnsThreatDetectorServiceGrpc.DnsThreatDetectorServiceImplBase;
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
public class MockDnsThreatDetectorServiceImpl extends DnsThreatDetectorServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDnsThreatDetectorServiceImpl() {
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
  public void listDnsThreatDetectors(
      ListDnsThreatDetectorsRequest request,
      StreamObserver<ListDnsThreatDetectorsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDnsThreatDetectorsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDnsThreatDetectorsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDnsThreatDetectors, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDnsThreatDetectorsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDnsThreatDetector(
      GetDnsThreatDetectorRequest request, StreamObserver<DnsThreatDetector> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DnsThreatDetector) {
      requests.add(request);
      responseObserver.onNext(((DnsThreatDetector) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDnsThreatDetector, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  DnsThreatDetector.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDnsThreatDetector(
      CreateDnsThreatDetectorRequest request, StreamObserver<DnsThreatDetector> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DnsThreatDetector) {
      requests.add(request);
      responseObserver.onNext(((DnsThreatDetector) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDnsThreatDetector, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  DnsThreatDetector.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDnsThreatDetector(
      UpdateDnsThreatDetectorRequest request, StreamObserver<DnsThreatDetector> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DnsThreatDetector) {
      requests.add(request);
      responseObserver.onNext(((DnsThreatDetector) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDnsThreatDetector, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  DnsThreatDetector.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDnsThreatDetector(
      DeleteDnsThreatDetectorRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDnsThreatDetector, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
