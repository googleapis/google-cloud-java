/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.billing.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.billing.v1.CloudBillingGrpc.CloudBillingImplBase;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockCloudBillingImpl extends CloudBillingImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCloudBillingImpl() {
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
  public void getBillingAccount(
      GetBillingAccountRequest request, StreamObserver<BillingAccount> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BillingAccount) {
      requests.add(request);
      responseObserver.onNext(((BillingAccount) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBillingAccount, expected %s or %s",
                  response.getClass().getName(),
                  BillingAccount.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBillingAccounts(
      ListBillingAccountsRequest request,
      StreamObserver<ListBillingAccountsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListBillingAccountsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBillingAccountsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBillingAccounts, expected %s or %s",
                  response.getClass().getName(),
                  ListBillingAccountsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBillingAccount(
      UpdateBillingAccountRequest request, StreamObserver<BillingAccount> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BillingAccount) {
      requests.add(request);
      responseObserver.onNext(((BillingAccount) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBillingAccount, expected %s or %s",
                  response.getClass().getName(),
                  BillingAccount.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBillingAccount(
      CreateBillingAccountRequest request, StreamObserver<BillingAccount> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BillingAccount) {
      requests.add(request);
      responseObserver.onNext(((BillingAccount) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBillingAccount, expected %s or %s",
                  response.getClass().getName(),
                  BillingAccount.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listProjectBillingInfo(
      ListProjectBillingInfoRequest request,
      StreamObserver<ListProjectBillingInfoResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListProjectBillingInfoResponse) {
      requests.add(request);
      responseObserver.onNext(((ListProjectBillingInfoResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListProjectBillingInfo, expected %s or %s",
                  response.getClass().getName(),
                  ListProjectBillingInfoResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getProjectBillingInfo(
      GetProjectBillingInfoRequest request, StreamObserver<ProjectBillingInfo> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ProjectBillingInfo) {
      requests.add(request);
      responseObserver.onNext(((ProjectBillingInfo) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetProjectBillingInfo, expected %s or %s",
                  response.getClass().getName(),
                  ProjectBillingInfo.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateProjectBillingInfo(
      UpdateProjectBillingInfoRequest request,
      StreamObserver<ProjectBillingInfo> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ProjectBillingInfo) {
      requests.add(request);
      responseObserver.onNext(((ProjectBillingInfo) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateProjectBillingInfo, expected %s or %s",
                  response.getClass().getName(),
                  ProjectBillingInfo.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIamPolicy, expected %s or %s",
                  response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetIamPolicy, expected %s or %s",
                  response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TestIamPermissionsResponse) {
      requests.add(request);
      responseObserver.onNext(((TestIamPermissionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TestIamPermissions, expected %s or %s",
                  response.getClass().getName(),
                  TestIamPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
