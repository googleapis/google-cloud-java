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

package com.google.cloud.iap.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.iap.v1.IdentityAwareProxyAdminServiceGrpc.IdentityAwareProxyAdminServiceImplBase;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
public class MockIdentityAwareProxyAdminServiceImpl extends IdentityAwareProxyAdminServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockIdentityAwareProxyAdminServiceImpl() {
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
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  TestIamPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIapSettings(
      GetIapSettingsRequest request, StreamObserver<IapSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IapSettings) {
      requests.add(request);
      responseObserver.onNext(((IapSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIapSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IapSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIapSettings(
      UpdateIapSettingsRequest request, StreamObserver<IapSettings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IapSettings) {
      requests.add(request);
      responseObserver.onNext(((IapSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateIapSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IapSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTunnelDestGroups(
      ListTunnelDestGroupsRequest request,
      StreamObserver<ListTunnelDestGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTunnelDestGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTunnelDestGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTunnelDestGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTunnelDestGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTunnelDestGroup(
      CreateTunnelDestGroupRequest request, StreamObserver<TunnelDestGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TunnelDestGroup) {
      requests.add(request);
      responseObserver.onNext(((TunnelDestGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTunnelDestGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TunnelDestGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTunnelDestGroup(
      GetTunnelDestGroupRequest request, StreamObserver<TunnelDestGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TunnelDestGroup) {
      requests.add(request);
      responseObserver.onNext(((TunnelDestGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTunnelDestGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TunnelDestGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTunnelDestGroup(
      DeleteTunnelDestGroupRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTunnelDestGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTunnelDestGroup(
      UpdateTunnelDestGroupRequest request, StreamObserver<TunnelDestGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TunnelDestGroup) {
      requests.add(request);
      responseObserver.onNext(((TunnelDestGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTunnelDestGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TunnelDestGroup.class.getName(),
                  Exception.class.getName())));
    }
  }
}
