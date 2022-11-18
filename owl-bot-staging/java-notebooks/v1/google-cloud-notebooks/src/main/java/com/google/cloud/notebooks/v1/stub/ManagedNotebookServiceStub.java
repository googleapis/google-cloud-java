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

package com.google.cloud.notebooks.v1.stub;

import static com.google.cloud.notebooks.v1.ManagedNotebookServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.notebooks.v1.ManagedNotebookServiceClient.ListRuntimesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.notebooks.v1.CreateRuntimeRequest;
import com.google.cloud.notebooks.v1.DeleteRuntimeRequest;
import com.google.cloud.notebooks.v1.DiagnoseRuntimeRequest;
import com.google.cloud.notebooks.v1.GetRuntimeRequest;
import com.google.cloud.notebooks.v1.ListRuntimesRequest;
import com.google.cloud.notebooks.v1.ListRuntimesResponse;
import com.google.cloud.notebooks.v1.OperationMetadata;
import com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest;
import com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse;
import com.google.cloud.notebooks.v1.ReportRuntimeEventRequest;
import com.google.cloud.notebooks.v1.ResetRuntimeRequest;
import com.google.cloud.notebooks.v1.Runtime;
import com.google.cloud.notebooks.v1.StartRuntimeRequest;
import com.google.cloud.notebooks.v1.StopRuntimeRequest;
import com.google.cloud.notebooks.v1.SwitchRuntimeRequest;
import com.google.cloud.notebooks.v1.UpdateRuntimeRequest;
import com.google.cloud.notebooks.v1.UpgradeRuntimeRequest;
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
 * Base stub class for the ManagedNotebookService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ManagedNotebookServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListRuntimesRequest, ListRuntimesPagedResponse> listRuntimesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuntimesPagedCallable()");
  }

  public UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuntimesCallable()");
  }

  public UnaryCallable<GetRuntimeRequest, Runtime> getRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuntimeCallable()");
  }

  public OperationCallable<CreateRuntimeRequest, Runtime, OperationMetadata>
      createRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRuntimeOperationCallable()");
  }

  public UnaryCallable<CreateRuntimeRequest, Operation> createRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: createRuntimeCallable()");
  }

  public OperationCallable<UpdateRuntimeRequest, Runtime, OperationMetadata>
      updateRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRuntimeOperationCallable()");
  }

  public UnaryCallable<UpdateRuntimeRequest, Operation> updateRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRuntimeCallable()");
  }

  public OperationCallable<DeleteRuntimeRequest, Empty, OperationMetadata>
      deleteRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRuntimeOperationCallable()");
  }

  public UnaryCallable<DeleteRuntimeRequest, Operation> deleteRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRuntimeCallable()");
  }

  public OperationCallable<StartRuntimeRequest, Runtime, OperationMetadata>
      startRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startRuntimeOperationCallable()");
  }

  public UnaryCallable<StartRuntimeRequest, Operation> startRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: startRuntimeCallable()");
  }

  public OperationCallable<StopRuntimeRequest, Runtime, OperationMetadata>
      stopRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopRuntimeOperationCallable()");
  }

  public UnaryCallable<StopRuntimeRequest, Operation> stopRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: stopRuntimeCallable()");
  }

  public OperationCallable<SwitchRuntimeRequest, Runtime, OperationMetadata>
      switchRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: switchRuntimeOperationCallable()");
  }

  public UnaryCallable<SwitchRuntimeRequest, Operation> switchRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: switchRuntimeCallable()");
  }

  public OperationCallable<ResetRuntimeRequest, Runtime, OperationMetadata>
      resetRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resetRuntimeOperationCallable()");
  }

  public UnaryCallable<ResetRuntimeRequest, Operation> resetRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: resetRuntimeCallable()");
  }

  public OperationCallable<UpgradeRuntimeRequest, Runtime, OperationMetadata>
      upgradeRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeRuntimeOperationCallable()");
  }

  public UnaryCallable<UpgradeRuntimeRequest, Operation> upgradeRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeRuntimeCallable()");
  }

  public OperationCallable<ReportRuntimeEventRequest, Runtime, OperationMetadata>
      reportRuntimeEventOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: reportRuntimeEventOperationCallable()");
  }

  public UnaryCallable<ReportRuntimeEventRequest, Operation> reportRuntimeEventCallable() {
    throw new UnsupportedOperationException("Not implemented: reportRuntimeEventCallable()");
  }

  public UnaryCallable<RefreshRuntimeTokenInternalRequest, RefreshRuntimeTokenInternalResponse>
      refreshRuntimeTokenInternalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: refreshRuntimeTokenInternalCallable()");
  }

  public OperationCallable<DiagnoseRuntimeRequest, Runtime, OperationMetadata>
      diagnoseRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: diagnoseRuntimeOperationCallable()");
  }

  public UnaryCallable<DiagnoseRuntimeRequest, Operation> diagnoseRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: diagnoseRuntimeCallable()");
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
