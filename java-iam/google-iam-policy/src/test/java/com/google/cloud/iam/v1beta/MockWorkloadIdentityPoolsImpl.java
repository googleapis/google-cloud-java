/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iam.v1beta;

import com.google.api.core.BetaApi;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.GetWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest;
import com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest;
import com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest;
import com.google.iam.v1beta.WorkloadIdentityPool;
import com.google.iam.v1beta.WorkloadIdentityPoolProvider;
import com.google.iam.v1beta.WorkloadIdentityPoolsGrpc.WorkloadIdentityPoolsImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockWorkloadIdentityPoolsImpl extends WorkloadIdentityPoolsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockWorkloadIdentityPoolsImpl() {
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
  public void listWorkloadIdentityPools(
      ListWorkloadIdentityPoolsRequest request,
      StreamObserver<ListWorkloadIdentityPoolsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkloadIdentityPoolsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkloadIdentityPoolsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkloadIdentityPools, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkloadIdentityPoolsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkloadIdentityPool(
      GetWorkloadIdentityPoolRequest request,
      StreamObserver<WorkloadIdentityPool> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkloadIdentityPool) {
      requests.add(request);
      responseObserver.onNext(((WorkloadIdentityPool) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkloadIdentityPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkloadIdentityPool.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkloadIdentityPool(
      CreateWorkloadIdentityPoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateWorkloadIdentityPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkloadIdentityPool(
      UpdateWorkloadIdentityPoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateWorkloadIdentityPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkloadIdentityPool(
      DeleteWorkloadIdentityPoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkloadIdentityPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeleteWorkloadIdentityPool(
      UndeleteWorkloadIdentityPoolRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UndeleteWorkloadIdentityPool, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkloadIdentityPoolProviders(
      ListWorkloadIdentityPoolProvidersRequest request,
      StreamObserver<ListWorkloadIdentityPoolProvidersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkloadIdentityPoolProvidersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkloadIdentityPoolProvidersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkloadIdentityPoolProviders, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkloadIdentityPoolProvidersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkloadIdentityPoolProvider(
      GetWorkloadIdentityPoolProviderRequest request,
      StreamObserver<WorkloadIdentityPoolProvider> responseObserver) {
    Object response = responses.poll();
    if (response instanceof WorkloadIdentityPoolProvider) {
      requests.add(request);
      responseObserver.onNext(((WorkloadIdentityPoolProvider) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkloadIdentityPoolProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  WorkloadIdentityPoolProvider.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkloadIdentityPoolProvider(
      CreateWorkloadIdentityPoolProviderRequest request,
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
                  "Unrecognized response type %s for method CreateWorkloadIdentityPoolProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkloadIdentityPoolProvider(
      UpdateWorkloadIdentityPoolProviderRequest request,
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
                  "Unrecognized response type %s for method UpdateWorkloadIdentityPoolProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkloadIdentityPoolProvider(
      DeleteWorkloadIdentityPoolProviderRequest request,
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
                  "Unrecognized response type %s for method DeleteWorkloadIdentityPoolProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeleteWorkloadIdentityPoolProvider(
      UndeleteWorkloadIdentityPoolProviderRequest request,
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
                  "Unrecognized response type %s for method UndeleteWorkloadIdentityPoolProvider, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
