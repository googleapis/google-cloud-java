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

package com.google.cloud.spanner.admin.instance.v1.stub;

import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstanceConfigOperationsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstanceConfigsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancePartitionOperationsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancePartitionsPagedResponse;
import static com.google.cloud.spanner.admin.instance.v1.InstanceAdminClient.ListInstancesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.spanner.admin.instance.v1.CreateInstanceConfigMetadata;
import com.google.spanner.admin.instance.v1.CreateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceMetadata;
import com.google.spanner.admin.instance.v1.CreateInstancePartitionMetadata;
import com.google.spanner.admin.instance.v1.CreateInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.CreateInstanceRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.DeleteInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.DeleteInstanceRequest;
import com.google.spanner.admin.instance.v1.GetInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.GetInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.GetInstanceRequest;
import com.google.spanner.admin.instance.v1.Instance;
import com.google.spanner.admin.instance.v1.InstanceConfig;
import com.google.spanner.admin.instance.v1.InstancePartition;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigOperationsResponse;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsRequest;
import com.google.spanner.admin.instance.v1.ListInstanceConfigsResponse;
import com.google.spanner.admin.instance.v1.ListInstancePartitionOperationsRequest;
import com.google.spanner.admin.instance.v1.ListInstancePartitionOperationsResponse;
import com.google.spanner.admin.instance.v1.ListInstancePartitionsRequest;
import com.google.spanner.admin.instance.v1.ListInstancePartitionsResponse;
import com.google.spanner.admin.instance.v1.ListInstancesRequest;
import com.google.spanner.admin.instance.v1.ListInstancesResponse;
import com.google.spanner.admin.instance.v1.MoveInstanceMetadata;
import com.google.spanner.admin.instance.v1.MoveInstanceRequest;
import com.google.spanner.admin.instance.v1.MoveInstanceResponse;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstanceConfigRequest;
import com.google.spanner.admin.instance.v1.UpdateInstanceMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstancePartitionMetadata;
import com.google.spanner.admin.instance.v1.UpdateInstancePartitionRequest;
import com.google.spanner.admin.instance.v1.UpdateInstanceRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the InstanceAdmin service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class InstanceAdminStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListInstanceConfigsRequest, ListInstanceConfigsPagedResponse>
      listInstanceConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstanceConfigsPagedCallable()");
  }

  public UnaryCallable<ListInstanceConfigsRequest, ListInstanceConfigsResponse>
      listInstanceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstanceConfigsCallable()");
  }

  public UnaryCallable<GetInstanceConfigRequest, InstanceConfig> getInstanceConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceConfigCallable()");
  }

  public OperationCallable<
          CreateInstanceConfigRequest, InstanceConfig, CreateInstanceConfigMetadata>
      createInstanceConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInstanceConfigOperationCallable()");
  }

  public UnaryCallable<CreateInstanceConfigRequest, Operation> createInstanceConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceConfigCallable()");
  }

  public OperationCallable<
          UpdateInstanceConfigRequest, InstanceConfig, UpdateInstanceConfigMetadata>
      updateInstanceConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInstanceConfigOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceConfigRequest, Operation> updateInstanceConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceConfigCallable()");
  }

  public UnaryCallable<DeleteInstanceConfigRequest, Empty> deleteInstanceConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceConfigCallable()");
  }

  public UnaryCallable<
          ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsPagedResponse>
      listInstanceConfigOperationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstanceConfigOperationsPagedCallable()");
  }

  public UnaryCallable<ListInstanceConfigOperationsRequest, ListInstanceConfigOperationsResponse>
      listInstanceConfigOperationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstanceConfigOperationsCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<ListInstancePartitionsRequest, ListInstancePartitionsPagedResponse>
      listInstancePartitionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstancePartitionsPagedCallable()");
  }

  public UnaryCallable<ListInstancePartitionsRequest, ListInstancePartitionsResponse>
      listInstancePartitionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancePartitionsCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceOperationCallable()");
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceCallable()");
  }

  public OperationCallable<UpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      updateInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Empty> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
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

  public UnaryCallable<GetInstancePartitionRequest, InstancePartition>
      getInstancePartitionCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstancePartitionCallable()");
  }

  public OperationCallable<
          CreateInstancePartitionRequest, InstancePartition, CreateInstancePartitionMetadata>
      createInstancePartitionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createInstancePartitionOperationCallable()");
  }

  public UnaryCallable<CreateInstancePartitionRequest, Operation>
      createInstancePartitionCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstancePartitionCallable()");
  }

  public UnaryCallable<DeleteInstancePartitionRequest, Empty> deleteInstancePartitionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstancePartitionCallable()");
  }

  public OperationCallable<
          UpdateInstancePartitionRequest, InstancePartition, UpdateInstancePartitionMetadata>
      updateInstancePartitionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateInstancePartitionOperationCallable()");
  }

  public UnaryCallable<UpdateInstancePartitionRequest, Operation>
      updateInstancePartitionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstancePartitionCallable()");
  }

  public UnaryCallable<
          ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsPagedResponse>
      listInstancePartitionOperationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstancePartitionOperationsPagedCallable()");
  }

  public UnaryCallable<
          ListInstancePartitionOperationsRequest, ListInstancePartitionOperationsResponse>
      listInstancePartitionOperationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstancePartitionOperationsCallable()");
  }

  public OperationCallable<MoveInstanceRequest, MoveInstanceResponse, MoveInstanceMetadata>
      moveInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: moveInstanceOperationCallable()");
  }

  public UnaryCallable<MoveInstanceRequest, Operation> moveInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: moveInstanceCallable()");
  }

  @Override
  public abstract void close();
}
