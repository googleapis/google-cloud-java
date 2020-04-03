/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.osconfig.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.osconfig.v1.OsConfigServiceGrpc.OsConfigServiceImplBase;
import com.google.cloud.osconfig.v1.PatchDeployments.CreatePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.DeletePatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.GetPatchDeploymentRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsRequest;
import com.google.cloud.osconfig.v1.PatchDeployments.ListPatchDeploymentsResponse;
import com.google.cloud.osconfig.v1.PatchDeployments.PatchDeployment;
import com.google.cloud.osconfig.v1.PatchJobs.CancelPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ExecutePatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.GetPatchJobRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobInstanceDetailsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsRequest;
import com.google.cloud.osconfig.v1.PatchJobs.ListPatchJobsResponse;
import com.google.cloud.osconfig.v1.PatchJobs.PatchJob;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockOsConfigServiceImpl extends OsConfigServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockOsConfigServiceImpl() {
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
  public void executePatchJob(
      ExecutePatchJobRequest request, StreamObserver<PatchJob> responseObserver) {
    Object response = responses.remove();
    if (response instanceof PatchJob) {
      requests.add(request);
      responseObserver.onNext((PatchJob) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getPatchJob(GetPatchJobRequest request, StreamObserver<PatchJob> responseObserver) {
    Object response = responses.remove();
    if (response instanceof PatchJob) {
      requests.add(request);
      responseObserver.onNext((PatchJob) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void cancelPatchJob(
      CancelPatchJobRequest request, StreamObserver<PatchJob> responseObserver) {
    Object response = responses.remove();
    if (response instanceof PatchJob) {
      requests.add(request);
      responseObserver.onNext((PatchJob) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listPatchJobs(
      ListPatchJobsRequest request, StreamObserver<ListPatchJobsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListPatchJobsResponse) {
      requests.add(request);
      responseObserver.onNext((ListPatchJobsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listPatchJobInstanceDetails(
      ListPatchJobInstanceDetailsRequest request,
      StreamObserver<ListPatchJobInstanceDetailsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListPatchJobInstanceDetailsResponse) {
      requests.add(request);
      responseObserver.onNext((ListPatchJobInstanceDetailsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createPatchDeployment(
      CreatePatchDeploymentRequest request, StreamObserver<PatchDeployment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof PatchDeployment) {
      requests.add(request);
      responseObserver.onNext((PatchDeployment) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getPatchDeployment(
      GetPatchDeploymentRequest request, StreamObserver<PatchDeployment> responseObserver) {
    Object response = responses.remove();
    if (response instanceof PatchDeployment) {
      requests.add(request);
      responseObserver.onNext((PatchDeployment) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listPatchDeployments(
      ListPatchDeploymentsRequest request,
      StreamObserver<ListPatchDeploymentsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListPatchDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext((ListPatchDeploymentsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deletePatchDeployment(
      DeletePatchDeploymentRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
