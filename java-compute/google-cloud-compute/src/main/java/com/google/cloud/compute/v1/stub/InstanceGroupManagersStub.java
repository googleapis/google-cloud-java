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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.InstanceGroupManagersClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListErrorsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListManagedInstancesPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupManagersClient.ListPerInstanceConfigsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AbandonInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ApplyUpdatesToInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.CreateInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeletePerInstanceConfigsInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.GetInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.InstanceGroupManagerAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupManagerList;
import com.google.cloud.compute.v1.InstanceGroupManagersListErrorsResponse;
import com.google.cloud.compute.v1.InstanceGroupManagersListManagedInstancesResponse;
import com.google.cloud.compute.v1.InstanceGroupManagersListPerInstanceConfigsResp;
import com.google.cloud.compute.v1.ListErrorsInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListManagedInstancesInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListPerInstanceConfigsInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.PatchPerInstanceConfigsInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.RecreateInstancesInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.ResizeInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetInstanceTemplateInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetTargetPoolsInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.UpdatePerInstanceConfigsInstanceGroupManagerRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the InstanceGroupManagers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class InstanceGroupManagersStub implements BackgroundResource {

  public OperationCallable<AbandonInstancesInstanceGroupManagerRequest, Operation, Operation>
      abandonInstancesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: abandonInstancesOperationCallable()");
  }

  public UnaryCallable<AbandonInstancesInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: abandonInstancesCallable()");
  }

  public UnaryCallable<AggregatedListInstanceGroupManagersRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<
          AggregatedListInstanceGroupManagersRequest, InstanceGroupManagerAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation, Operation>
      applyUpdatesToInstancesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: applyUpdatesToInstancesOperationCallable()");
  }

  public UnaryCallable<ApplyUpdatesToInstancesInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: applyUpdatesToInstancesCallable()");
  }

  public OperationCallable<CreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      createInstancesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstancesOperationCallable()");
  }

  public UnaryCallable<CreateInstancesInstanceGroupManagerRequest, Operation>
      createInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstancesCallable()");
  }

  public OperationCallable<DeleteInstanceGroupManagerRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceGroupManagerRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public OperationCallable<DeleteInstancesInstanceGroupManagerRequest, Operation, Operation>
      deleteInstancesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstancesOperationCallable()");
  }

  public UnaryCallable<DeleteInstancesInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstancesCallable()");
  }

  public OperationCallable<
          DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      deletePerInstanceConfigsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePerInstanceConfigsOperationCallable()");
  }

  public UnaryCallable<DeletePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePerInstanceConfigsCallable()");
  }

  public UnaryCallable<GetInstanceGroupManagerRequest, InstanceGroupManager> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertInstanceGroupManagerRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertInstanceGroupManagerRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListInstanceGroupManagersRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListInstanceGroupManagersRequest, InstanceGroupManagerList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<ListErrorsInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listErrorsPagedCallable()");
  }

  public UnaryCallable<
          ListErrorsInstanceGroupManagersRequest, InstanceGroupManagersListErrorsResponse>
      listErrorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listErrorsCallable()");
  }

  public UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listManagedInstancesPagedCallable()");
  }

  public UnaryCallable<
          ListManagedInstancesInstanceGroupManagersRequest,
          InstanceGroupManagersListManagedInstancesResponse>
      listManagedInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listManagedInstancesCallable()");
  }

  public UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest, ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPerInstanceConfigsPagedCallable()");
  }

  public UnaryCallable<
          ListPerInstanceConfigsInstanceGroupManagersRequest,
          InstanceGroupManagersListPerInstanceConfigsResp>
      listPerInstanceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPerInstanceConfigsCallable()");
  }

  public OperationCallable<PatchInstanceGroupManagerRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchInstanceGroupManagerRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      patchPerInstanceConfigsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: patchPerInstanceConfigsOperationCallable()");
  }

  public UnaryCallable<PatchPerInstanceConfigsInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: patchPerInstanceConfigsCallable()");
  }

  public OperationCallable<RecreateInstancesInstanceGroupManagerRequest, Operation, Operation>
      recreateInstancesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: recreateInstancesOperationCallable()");
  }

  public UnaryCallable<RecreateInstancesInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: recreateInstancesCallable()");
  }

  public OperationCallable<ResizeInstanceGroupManagerRequest, Operation, Operation>
      resizeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeOperationCallable()");
  }

  public UnaryCallable<ResizeInstanceGroupManagerRequest, Operation> resizeCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeCallable()");
  }

  public OperationCallable<SetInstanceTemplateInstanceGroupManagerRequest, Operation, Operation>
      setInstanceTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setInstanceTemplateOperationCallable()");
  }

  public UnaryCallable<SetInstanceTemplateInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: setInstanceTemplateCallable()");
  }

  public OperationCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation, Operation>
      setTargetPoolsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setTargetPoolsOperationCallable()");
  }

  public UnaryCallable<SetTargetPoolsInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: setTargetPoolsCallable()");
  }

  public OperationCallable<
          UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation, Operation>
      updatePerInstanceConfigsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePerInstanceConfigsOperationCallable()");
  }

  public UnaryCallable<UpdatePerInstanceConfigsInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePerInstanceConfigsCallable()");
  }

  @Override
  public abstract void close();
}
