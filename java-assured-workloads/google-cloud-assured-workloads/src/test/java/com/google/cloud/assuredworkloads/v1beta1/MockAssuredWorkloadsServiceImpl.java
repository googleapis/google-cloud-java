/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.assuredworkloads.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.assuredworkloads.v1beta1.AssuredWorkloadsServiceGrpc.AssuredWorkloadsServiceImplBase;
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
public class MockAssuredWorkloadsServiceImpl extends AssuredWorkloadsServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAssuredWorkloadsServiceImpl() {
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
  public void createWorkload(
      CreateWorkloadRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkload(
      UpdateWorkloadRequest request, StreamObserver<Workload> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Workload) {
      requests.add(request);
      responseObserver.onNext(((Workload) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Workload.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restrictAllowedResources(
      RestrictAllowedResourcesRequest request,
      StreamObserver<RestrictAllowedResourcesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RestrictAllowedResourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((RestrictAllowedResourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RestrictAllowedResources, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RestrictAllowedResourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkload(
      DeleteWorkloadRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkload(GetWorkloadRequest request, StreamObserver<Workload> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Workload) {
      requests.add(request);
      responseObserver.onNext(((Workload) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Workload.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void analyzeWorkloadMove(
      AnalyzeWorkloadMoveRequest request,
      StreamObserver<AnalyzeWorkloadMoveResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalyzeWorkloadMoveResponse) {
      requests.add(request);
      responseObserver.onNext(((AnalyzeWorkloadMoveResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AnalyzeWorkloadMove, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalyzeWorkloadMoveResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkloads(
      ListWorkloadsRequest request, StreamObserver<ListWorkloadsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkloadsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkloadsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkloads, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkloadsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
