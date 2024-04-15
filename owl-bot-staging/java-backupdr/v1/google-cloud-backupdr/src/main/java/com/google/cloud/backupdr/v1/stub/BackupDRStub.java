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

package com.google.cloud.backupdr.v1.stub;

import static com.google.cloud.backupdr.v1.BackupDRClient.ListLocationsPagedResponse;
import static com.google.cloud.backupdr.v1.BackupDRClient.ListManagementServersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.backupdr.v1.CreateManagementServerRequest;
import com.google.cloud.backupdr.v1.DeleteManagementServerRequest;
import com.google.cloud.backupdr.v1.GetManagementServerRequest;
import com.google.cloud.backupdr.v1.ListManagementServersRequest;
import com.google.cloud.backupdr.v1.ListManagementServersResponse;
import com.google.cloud.backupdr.v1.ManagementServer;
import com.google.cloud.backupdr.v1.OperationMetadata;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BackupDR service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BackupDRStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListManagementServersRequest, ListManagementServersPagedResponse>
      listManagementServersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listManagementServersPagedCallable()");
  }

  public UnaryCallable<ListManagementServersRequest, ListManagementServersResponse>
      listManagementServersCallable() {
    throw new UnsupportedOperationException("Not implemented: listManagementServersCallable()");
  }

  public UnaryCallable<GetManagementServerRequest, ManagementServer> getManagementServerCallable() {
    throw new UnsupportedOperationException("Not implemented: getManagementServerCallable()");
  }

  public OperationCallable<CreateManagementServerRequest, ManagementServer, OperationMetadata>
      createManagementServerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createManagementServerOperationCallable()");
  }

  public UnaryCallable<CreateManagementServerRequest, Operation> createManagementServerCallable() {
    throw new UnsupportedOperationException("Not implemented: createManagementServerCallable()");
  }

  public OperationCallable<DeleteManagementServerRequest, Empty, OperationMetadata>
      deleteManagementServerOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteManagementServerOperationCallable()");
  }

  public UnaryCallable<DeleteManagementServerRequest, Operation> deleteManagementServerCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteManagementServerCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
