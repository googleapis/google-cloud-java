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

package com.google.storagetransfer.v1.proto;

import com.google.api.core.BetaApi;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.storagetransfer.v1.proto.StorageTransferServiceGrpc.StorageTransferServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockStorageTransferServiceImpl extends StorageTransferServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockStorageTransferServiceImpl() {
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
  public void getGoogleServiceAccount(
      TransferProto.GetGoogleServiceAccountRequest request,
      StreamObserver<TransferTypes.GoogleServiceAccount> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferTypes.GoogleServiceAccount) {
      requests.add(request);
      responseObserver.onNext(((TransferTypes.GoogleServiceAccount) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGoogleServiceAccount, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferTypes.GoogleServiceAccount.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTransferJob(
      TransferProto.CreateTransferJobRequest request,
      StreamObserver<TransferTypes.TransferJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferTypes.TransferJob) {
      requests.add(request);
      responseObserver.onNext(((TransferTypes.TransferJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTransferJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferTypes.TransferJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTransferJob(
      TransferProto.UpdateTransferJobRequest request,
      StreamObserver<TransferTypes.TransferJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferTypes.TransferJob) {
      requests.add(request);
      responseObserver.onNext(((TransferTypes.TransferJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTransferJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferTypes.TransferJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTransferJob(
      TransferProto.GetTransferJobRequest request,
      StreamObserver<TransferTypes.TransferJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferTypes.TransferJob) {
      requests.add(request);
      responseObserver.onNext(((TransferTypes.TransferJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTransferJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferTypes.TransferJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTransferJobs(
      TransferProto.ListTransferJobsRequest request,
      StreamObserver<TransferProto.ListTransferJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferProto.ListTransferJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((TransferProto.ListTransferJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTransferJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferProto.ListTransferJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void pauseTransferOperation(
      TransferProto.PauseTransferOperationRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method PauseTransferOperation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resumeTransferOperation(
      TransferProto.ResumeTransferOperationRequest request,
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
                  "Unrecognized response type %s for method ResumeTransferOperation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runTransferJob(
      TransferProto.RunTransferJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RunTransferJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTransferJob(
      TransferProto.DeleteTransferJobRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTransferJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAgentPool(
      TransferProto.CreateAgentPoolRequest request,
      StreamObserver<TransferTypes.AgentPool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferTypes.AgentPool) {
      requests.add(request);
      responseObserver.onNext(((TransferTypes.AgentPool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAgentPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferTypes.AgentPool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAgentPool(
      TransferProto.UpdateAgentPoolRequest request,
      StreamObserver<TransferTypes.AgentPool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferTypes.AgentPool) {
      requests.add(request);
      responseObserver.onNext(((TransferTypes.AgentPool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAgentPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferTypes.AgentPool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAgentPool(
      TransferProto.GetAgentPoolRequest request,
      StreamObserver<TransferTypes.AgentPool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferTypes.AgentPool) {
      requests.add(request);
      responseObserver.onNext(((TransferTypes.AgentPool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAgentPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferTypes.AgentPool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAgentPools(
      TransferProto.ListAgentPoolsRequest request,
      StreamObserver<TransferProto.ListAgentPoolsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TransferProto.ListAgentPoolsResponse) {
      requests.add(request);
      responseObserver.onNext(((TransferProto.ListAgentPoolsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAgentPools, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TransferProto.ListAgentPoolsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAgentPool(
      TransferProto.DeleteAgentPoolRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAgentPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
