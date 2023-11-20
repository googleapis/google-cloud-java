/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.telcoautomation.v1alpha1;

import com.google.api.core.BetaApi;
import com.google.cloud.telcoautomation.v1alpha1.TelcoAutomationGrpc.TelcoAutomationImplBase;
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
public class MockTelcoAutomationImpl extends TelcoAutomationImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockTelcoAutomationImpl() {
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
  public void listOrchestrationClusters(
      ListOrchestrationClustersRequest request,
      StreamObserver<ListOrchestrationClustersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListOrchestrationClustersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListOrchestrationClustersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListOrchestrationClusters, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListOrchestrationClustersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getOrchestrationCluster(
      GetOrchestrationClusterRequest request,
      StreamObserver<OrchestrationCluster> responseObserver) {
    Object response = responses.poll();
    if (response instanceof OrchestrationCluster) {
      requests.add(request);
      responseObserver.onNext(((OrchestrationCluster) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOrchestrationCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  OrchestrationCluster.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createOrchestrationCluster(
      CreateOrchestrationClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateOrchestrationCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteOrchestrationCluster(
      DeleteOrchestrationClusterRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteOrchestrationCluster, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEdgeSlms(
      ListEdgeSlmsRequest request, StreamObserver<ListEdgeSlmsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEdgeSlmsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEdgeSlmsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEdgeSlms, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEdgeSlmsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEdgeSlm(GetEdgeSlmRequest request, StreamObserver<EdgeSlm> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EdgeSlm) {
      requests.add(request);
      responseObserver.onNext(((EdgeSlm) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEdgeSlm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EdgeSlm.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEdgeSlm(
      CreateEdgeSlmRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateEdgeSlm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEdgeSlm(
      DeleteEdgeSlmRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEdgeSlm, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBlueprint(
      CreateBlueprintRequest request, StreamObserver<Blueprint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blueprint) {
      requests.add(request);
      responseObserver.onNext(((Blueprint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBlueprint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blueprint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBlueprint(
      UpdateBlueprintRequest request, StreamObserver<Blueprint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blueprint) {
      requests.add(request);
      responseObserver.onNext(((Blueprint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBlueprint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blueprint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBlueprint(
      GetBlueprintRequest request, StreamObserver<Blueprint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blueprint) {
      requests.add(request);
      responseObserver.onNext(((Blueprint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBlueprint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blueprint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBlueprint(
      DeleteBlueprintRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteBlueprint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBlueprintRevision(
      DeleteBlueprintRevisionRequest request, StreamObserver<Blueprint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blueprint) {
      requests.add(request);
      responseObserver.onNext(((Blueprint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteBlueprintRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blueprint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBlueprints(
      ListBlueprintsRequest request, StreamObserver<ListBlueprintsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBlueprintsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBlueprintsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBlueprints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBlueprintsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void approveBlueprint(
      ApproveBlueprintRequest request, StreamObserver<Blueprint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blueprint) {
      requests.add(request);
      responseObserver.onNext(((Blueprint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ApproveBlueprint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blueprint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void proposeBlueprint(
      ProposeBlueprintRequest request, StreamObserver<Blueprint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blueprint) {
      requests.add(request);
      responseObserver.onNext(((Blueprint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ProposeBlueprint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blueprint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rejectBlueprint(
      RejectBlueprintRequest request, StreamObserver<Blueprint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Blueprint) {
      requests.add(request);
      responseObserver.onNext(((Blueprint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RejectBlueprint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Blueprint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBlueprintRevisions(
      ListBlueprintRevisionsRequest request,
      StreamObserver<ListBlueprintRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBlueprintRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBlueprintRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBlueprintRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBlueprintRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchBlueprintRevisions(
      SearchBlueprintRevisionsRequest request,
      StreamObserver<SearchBlueprintRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchBlueprintRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchBlueprintRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchBlueprintRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchBlueprintRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchDeploymentRevisions(
      SearchDeploymentRevisionsRequest request,
      StreamObserver<SearchDeploymentRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchDeploymentRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchDeploymentRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchDeploymentRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchDeploymentRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void discardBlueprintChanges(
      DiscardBlueprintChangesRequest request,
      StreamObserver<DiscardBlueprintChangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiscardBlueprintChangesResponse) {
      requests.add(request);
      responseObserver.onNext(((DiscardBlueprintChangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DiscardBlueprintChanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiscardBlueprintChangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPublicBlueprints(
      ListPublicBlueprintsRequest request,
      StreamObserver<ListPublicBlueprintsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPublicBlueprintsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPublicBlueprintsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPublicBlueprints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPublicBlueprintsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPublicBlueprint(
      GetPublicBlueprintRequest request, StreamObserver<PublicBlueprint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PublicBlueprint) {
      requests.add(request);
      responseObserver.onNext(((PublicBlueprint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPublicBlueprint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PublicBlueprint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDeployment(
      CreateDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDeployment(
      UpdateDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDeployment(
      GetDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeployment(
      DeleteDeploymentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeDeployment(
      RemoveDeploymentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method RemoveDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDeploymentRevision(
      DeleteDeploymentRevisionRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteDeploymentRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeployments(
      ListDeploymentsRequest request, StreamObserver<ListDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeployments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDeploymentRevisions(
      ListDeploymentRevisionsRequest request,
      StreamObserver<ListDeploymentRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDeploymentRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDeploymentRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDeploymentRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDeploymentRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void discardDeploymentChanges(
      DiscardDeploymentChangesRequest request,
      StreamObserver<DiscardDeploymentChangesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiscardDeploymentChangesResponse) {
      requests.add(request);
      responseObserver.onNext(((DiscardDeploymentChangesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DiscardDeploymentChanges, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiscardDeploymentChangesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void applyDeployment(
      ApplyDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ApplyDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void computeDeploymentStatus(
      ComputeDeploymentStatusRequest request,
      StreamObserver<ComputeDeploymentStatusResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ComputeDeploymentStatusResponse) {
      requests.add(request);
      responseObserver.onNext(((ComputeDeploymentStatusResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ComputeDeploymentStatus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ComputeDeploymentStatusResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rollbackDeployment(
      RollbackDeploymentRequest request, StreamObserver<Deployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Deployment) {
      requests.add(request);
      responseObserver.onNext(((Deployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RollbackDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Deployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHydratedDeployment(
      GetHydratedDeploymentRequest request, StreamObserver<HydratedDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HydratedDeployment) {
      requests.add(request);
      responseObserver.onNext(((HydratedDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHydratedDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HydratedDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHydratedDeployments(
      ListHydratedDeploymentsRequest request,
      StreamObserver<ListHydratedDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHydratedDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHydratedDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHydratedDeployments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHydratedDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHydratedDeployment(
      UpdateHydratedDeploymentRequest request,
      StreamObserver<HydratedDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HydratedDeployment) {
      requests.add(request);
      responseObserver.onNext(((HydratedDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateHydratedDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HydratedDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void applyHydratedDeployment(
      ApplyHydratedDeploymentRequest request, StreamObserver<HydratedDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HydratedDeployment) {
      requests.add(request);
      responseObserver.onNext(((HydratedDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ApplyHydratedDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HydratedDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }
}
