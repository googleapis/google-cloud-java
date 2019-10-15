/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner;

import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.spanner.admin.instance.v1.InstanceAdminGrpc.InstanceAdminImplBase;
import io.grpc.ServerServiceDefinition;
import io.grpc.stub.StreamObserver;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MockInstanceAdminServiceImpl extends InstanceAdminImplBase implements MockGrpcService {
  private ConcurrentMap<String, Policy> policies = new ConcurrentHashMap<>();

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Policy policy = policies.get(request.getResource());
    if (policy != null) {
      responseObserver.onNext(policy);
    } else {
      responseObserver.onNext(Policy.getDefaultInstance());
    }
    responseObserver.onCompleted();
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    policies.put(request.getResource(), request.getPolicy());
    responseObserver.onNext(request.getPolicy());
    responseObserver.onCompleted();
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    // Just return the same permissions as in the request, as we don't have any credentials.
    responseObserver.onNext(
        TestIamPermissionsResponse.newBuilder()
            .addAllPermissions(request.getPermissionsList())
            .build());
    responseObserver.onCompleted();
  }

  @Override
  public List<AbstractMessage> getRequests() {
    return Collections.emptyList();
  }

  @Override
  public void addResponse(AbstractMessage response) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addException(Exception exception) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ServerServiceDefinition getServiceDefinition() {
    return bindService();
  }

  @Override
  public void reset() {
    policies.clear();
  }
}
