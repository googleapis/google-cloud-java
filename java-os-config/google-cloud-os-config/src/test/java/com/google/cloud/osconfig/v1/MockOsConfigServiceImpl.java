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

package com.google.cloud.osconfig.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.osconfig.v1.OsConfigServiceGrpc.OsConfigServiceImplBase;
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
      PatchJobs.ExecutePatchJobRequest request,
      StreamObserver<PatchJobs.PatchJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchJobs.PatchJob) {
      requests.add(request);
      responseObserver.onNext(((PatchJobs.PatchJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExecutePatchJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchJobs.PatchJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPatchJob(
      PatchJobs.GetPatchJobRequest request, StreamObserver<PatchJobs.PatchJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchJobs.PatchJob) {
      requests.add(request);
      responseObserver.onNext(((PatchJobs.PatchJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPatchJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchJobs.PatchJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void cancelPatchJob(
      PatchJobs.CancelPatchJobRequest request,
      StreamObserver<PatchJobs.PatchJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchJobs.PatchJob) {
      requests.add(request);
      responseObserver.onNext(((PatchJobs.PatchJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CancelPatchJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchJobs.PatchJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPatchJobs(
      PatchJobs.ListPatchJobsRequest request,
      StreamObserver<PatchJobs.ListPatchJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchJobs.ListPatchJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((PatchJobs.ListPatchJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPatchJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchJobs.ListPatchJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPatchJobInstanceDetails(
      PatchJobs.ListPatchJobInstanceDetailsRequest request,
      StreamObserver<PatchJobs.ListPatchJobInstanceDetailsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchJobs.ListPatchJobInstanceDetailsResponse) {
      requests.add(request);
      responseObserver.onNext(((PatchJobs.ListPatchJobInstanceDetailsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPatchJobInstanceDetails, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchJobs.ListPatchJobInstanceDetailsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPatchDeployment(
      PatchDeployments.CreatePatchDeploymentRequest request,
      StreamObserver<PatchDeployments.PatchDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchDeployments.PatchDeployment) {
      requests.add(request);
      responseObserver.onNext(((PatchDeployments.PatchDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePatchDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchDeployments.PatchDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPatchDeployment(
      PatchDeployments.GetPatchDeploymentRequest request,
      StreamObserver<PatchDeployments.PatchDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchDeployments.PatchDeployment) {
      requests.add(request);
      responseObserver.onNext(((PatchDeployments.PatchDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPatchDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchDeployments.PatchDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPatchDeployments(
      PatchDeployments.ListPatchDeploymentsRequest request,
      StreamObserver<PatchDeployments.ListPatchDeploymentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchDeployments.ListPatchDeploymentsResponse) {
      requests.add(request);
      responseObserver.onNext(((PatchDeployments.ListPatchDeploymentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPatchDeployments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchDeployments.ListPatchDeploymentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePatchDeployment(
      PatchDeployments.DeletePatchDeploymentRequest request,
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
                  "Unrecognized response type %s for method DeletePatchDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePatchDeployment(
      PatchDeployments.UpdatePatchDeploymentRequest request,
      StreamObserver<PatchDeployments.PatchDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchDeployments.PatchDeployment) {
      requests.add(request);
      responseObserver.onNext(((PatchDeployments.PatchDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePatchDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchDeployments.PatchDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pausePatchDeployment(
      PatchDeployments.PausePatchDeploymentRequest request,
      StreamObserver<PatchDeployments.PatchDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchDeployments.PatchDeployment) {
      requests.add(request);
      responseObserver.onNext(((PatchDeployments.PatchDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PausePatchDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchDeployments.PatchDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resumePatchDeployment(
      PatchDeployments.ResumePatchDeploymentRequest request,
      StreamObserver<PatchDeployments.PatchDeployment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PatchDeployments.PatchDeployment) {
      requests.add(request);
      responseObserver.onNext(((PatchDeployments.PatchDeployment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ResumePatchDeployment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PatchDeployments.PatchDeployment.class.getName(),
                  Exception.class.getName())));
    }
  }
}
