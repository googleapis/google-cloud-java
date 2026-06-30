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

package com.google.cloud.kms.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.kms.v1.HsmManagementGrpc.HsmManagementImplBase;
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
public class MockHsmManagementImpl extends HsmManagementImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockHsmManagementImpl() {
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
  public void listSingleTenantHsmInstances(
      ListSingleTenantHsmInstancesRequest request,
      StreamObserver<ListSingleTenantHsmInstancesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSingleTenantHsmInstancesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSingleTenantHsmInstancesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSingleTenantHsmInstances, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSingleTenantHsmInstancesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSingleTenantHsmInstance(
      GetSingleTenantHsmInstanceRequest request,
      StreamObserver<SingleTenantHsmInstance> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SingleTenantHsmInstance) {
      requests.add(request);
      responseObserver.onNext(((SingleTenantHsmInstance) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSingleTenantHsmInstance, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SingleTenantHsmInstance.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSingleTenantHsmInstance(
      CreateSingleTenantHsmInstanceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateSingleTenantHsmInstance, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSingleTenantHsmInstanceProposal(
      CreateSingleTenantHsmInstanceProposalRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateSingleTenantHsmInstanceProposal,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void approveSingleTenantHsmInstanceProposal(
      ApproveSingleTenantHsmInstanceProposalRequest request,
      StreamObserver<ApproveSingleTenantHsmInstanceProposalResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApproveSingleTenantHsmInstanceProposalResponse) {
      requests.add(request);
      responseObserver.onNext(((ApproveSingleTenantHsmInstanceProposalResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ApproveSingleTenantHsmInstanceProposal,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApproveSingleTenantHsmInstanceProposalResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void executeSingleTenantHsmInstanceProposal(
      ExecuteSingleTenantHsmInstanceProposalRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExecuteSingleTenantHsmInstanceProposal,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSingleTenantHsmInstanceProposal(
      GetSingleTenantHsmInstanceProposalRequest request,
      StreamObserver<SingleTenantHsmInstanceProposal> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SingleTenantHsmInstanceProposal) {
      requests.add(request);
      responseObserver.onNext(((SingleTenantHsmInstanceProposal) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSingleTenantHsmInstanceProposal,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SingleTenantHsmInstanceProposal.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSingleTenantHsmInstanceProposals(
      ListSingleTenantHsmInstanceProposalsRequest request,
      StreamObserver<ListSingleTenantHsmInstanceProposalsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSingleTenantHsmInstanceProposalsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSingleTenantHsmInstanceProposalsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSingleTenantHsmInstanceProposals,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSingleTenantHsmInstanceProposalsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSingleTenantHsmInstanceProposal(
      DeleteSingleTenantHsmInstanceProposalRequest request,
      StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSingleTenantHsmInstanceProposal,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
