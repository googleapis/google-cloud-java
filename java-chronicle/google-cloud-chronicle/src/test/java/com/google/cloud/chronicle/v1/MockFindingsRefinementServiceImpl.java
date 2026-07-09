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

package com.google.cloud.chronicle.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.chronicle.v1.FindingsRefinementServiceGrpc.FindingsRefinementServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockFindingsRefinementServiceImpl extends FindingsRefinementServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFindingsRefinementServiceImpl() {
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
  public void getFindingsRefinement(
      GetFindingsRefinementRequest request, StreamObserver<FindingsRefinement> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FindingsRefinement) {
      requests.add(request);
      responseObserver.onNext(((FindingsRefinement) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFindingsRefinement, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  FindingsRefinement.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFindingsRefinements(
      ListFindingsRefinementsRequest request,
      StreamObserver<ListFindingsRefinementsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFindingsRefinementsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFindingsRefinementsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFindingsRefinements, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFindingsRefinementsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFindingsRefinement(
      CreateFindingsRefinementRequest request,
      StreamObserver<FindingsRefinement> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FindingsRefinement) {
      requests.add(request);
      responseObserver.onNext(((FindingsRefinement) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFindingsRefinement, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FindingsRefinement.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFindingsRefinement(
      UpdateFindingsRefinementRequest request,
      StreamObserver<FindingsRefinement> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FindingsRefinement) {
      requests.add(request);
      responseObserver.onNext(((FindingsRefinement) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFindingsRefinement, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FindingsRefinement.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFindingsRefinementDeployment(
      GetFindingsRefinementDeploymentRequest request,
      StreamObserver<FindingsRefinementDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FindingsRefinementDeployment) {
      requests.add(request);
      responseObserver.onNext(((FindingsRefinementDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFindingsRefinementDeployment,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FindingsRefinementDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFindingsRefinementDeployment(
      UpdateFindingsRefinementDeploymentRequest request,
      StreamObserver<FindingsRefinementDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FindingsRefinementDeployment) {
      requests.add(request);
      responseObserver.onNext(((FindingsRefinementDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFindingsRefinementDeployment,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FindingsRefinementDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAllFindingsRefinementDeployments(
      ListAllFindingsRefinementDeploymentsRequest request,
      StreamObserver<ListAllFindingsRefinementDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAllFindingsRefinementDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAllFindingsRefinementDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAllFindingsRefinementDeployments,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAllFindingsRefinementDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void computeFindingsRefinementActivity(
      ComputeFindingsRefinementActivityRequest request,
      StreamObserver<ComputeFindingsRefinementActivityResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ComputeFindingsRefinementActivityResponse) {
      requests.add(request);
      responseObserver.onNext(((ComputeFindingsRefinementActivityResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ComputeFindingsRefinementActivity,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ComputeFindingsRefinementActivityResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void computeAllFindingsRefinementActivities(
      ComputeAllFindingsRefinementActivitiesRequest request,
      StreamObserver<ComputeAllFindingsRefinementActivitiesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ComputeAllFindingsRefinementActivitiesResponse) {
      requests.add(request);
      responseObserver.onNext(((ComputeAllFindingsRefinementActivitiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ComputeAllFindingsRefinementActivities,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ComputeAllFindingsRefinementActivitiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
