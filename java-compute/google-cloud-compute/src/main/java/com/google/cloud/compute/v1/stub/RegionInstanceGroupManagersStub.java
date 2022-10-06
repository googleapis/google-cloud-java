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

import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListErrorsPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListManagedInstancesPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListPagedResponse;
import static com.google.cloud.compute.v1.RegionInstanceGroupManagersClient.ListPerInstanceConfigsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AbandonInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.CreateInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeletePerInstanceConfigsRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.DeleteRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.GetRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InsertRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.InstanceGroupManager;
import com.google.cloud.compute.v1.ListErrorsRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListManagedInstancesRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListPerInstanceConfigsRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.ListRegionInstanceGroupManagersRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchPerInstanceConfigsRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.PatchRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.RecreateInstancesRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.RegionInstanceGroupManagerList;
import com.google.cloud.compute.v1.RegionInstanceGroupManagersListErrorsResponse;
import com.google.cloud.compute.v1.RegionInstanceGroupManagersListInstanceConfigsResp;
import com.google.cloud.compute.v1.RegionInstanceGroupManagersListInstancesResponse;
import com.google.cloud.compute.v1.ResizeRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetInstanceTemplateRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.SetTargetPoolsRegionInstanceGroupManagerRequest;
import com.google.cloud.compute.v1.UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionInstanceGroupManagers service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionInstanceGroupManagersStub implements BackgroundResource {

  public OperationCallable<AbandonInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      abandonInstancesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: abandonInstancesOperationCallable()");
  }

  public UnaryCallable<AbandonInstancesRegionInstanceGroupManagerRequest, Operation>
      abandonInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: abandonInstancesCallable()");
  }

  public OperationCallable<
          ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      applyUpdatesToInstancesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: applyUpdatesToInstancesOperationCallable()");
  }

  public UnaryCallable<ApplyUpdatesToInstancesRegionInstanceGroupManagerRequest, Operation>
      applyUpdatesToInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: applyUpdatesToInstancesCallable()");
  }

  public OperationCallable<CreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      createInstancesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstancesOperationCallable()");
  }

  public UnaryCallable<CreateInstancesRegionInstanceGroupManagerRequest, Operation>
      createInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstancesCallable()");
  }

  public OperationCallable<DeleteRegionInstanceGroupManagerRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRegionInstanceGroupManagerRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public OperationCallable<DeleteInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      deleteInstancesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstancesOperationCallable()");
  }

  public UnaryCallable<DeleteInstancesRegionInstanceGroupManagerRequest, Operation>
      deleteInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstancesCallable()");
  }

  public OperationCallable<
          DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      deletePerInstanceConfigsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePerInstanceConfigsOperationCallable()");
  }

  public UnaryCallable<DeletePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      deletePerInstanceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePerInstanceConfigsCallable()");
  }

  public UnaryCallable<GetRegionInstanceGroupManagerRequest, InstanceGroupManager> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertRegionInstanceGroupManagerRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionInstanceGroupManagerRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionInstanceGroupManagersRequest, ListPagedResponse>
      listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionInstanceGroupManagersRequest, RegionInstanceGroupManagerList>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<ListErrorsRegionInstanceGroupManagersRequest, ListErrorsPagedResponse>
      listErrorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listErrorsPagedCallable()");
  }

  public UnaryCallable<
          ListErrorsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListErrorsResponse>
      listErrorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listErrorsCallable()");
  }

  public UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest, ListManagedInstancesPagedResponse>
      listManagedInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listManagedInstancesPagedCallable()");
  }

  public UnaryCallable<
          ListManagedInstancesRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstancesResponse>
      listManagedInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listManagedInstancesCallable()");
  }

  public UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          ListPerInstanceConfigsPagedResponse>
      listPerInstanceConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPerInstanceConfigsPagedCallable()");
  }

  public UnaryCallable<
          ListPerInstanceConfigsRegionInstanceGroupManagersRequest,
          RegionInstanceGroupManagersListInstanceConfigsResp>
      listPerInstanceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPerInstanceConfigsCallable()");
  }

  public OperationCallable<PatchRegionInstanceGroupManagerRequest, Operation, Operation>
      patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchRegionInstanceGroupManagerRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public OperationCallable<
          PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      patchPerInstanceConfigsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: patchPerInstanceConfigsOperationCallable()");
  }

  public UnaryCallable<PatchPerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      patchPerInstanceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: patchPerInstanceConfigsCallable()");
  }

  public OperationCallable<RecreateInstancesRegionInstanceGroupManagerRequest, Operation, Operation>
      recreateInstancesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: recreateInstancesOperationCallable()");
  }

  public UnaryCallable<RecreateInstancesRegionInstanceGroupManagerRequest, Operation>
      recreateInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: recreateInstancesCallable()");
  }

  public OperationCallable<ResizeRegionInstanceGroupManagerRequest, Operation, Operation>
      resizeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeOperationCallable()");
  }

  public UnaryCallable<ResizeRegionInstanceGroupManagerRequest, Operation> resizeCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeCallable()");
  }

  public OperationCallable<
          SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation, Operation>
      setInstanceTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setInstanceTemplateOperationCallable()");
  }

  public UnaryCallable<SetInstanceTemplateRegionInstanceGroupManagerRequest, Operation>
      setInstanceTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: setInstanceTemplateCallable()");
  }

  public OperationCallable<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation, Operation>
      setTargetPoolsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setTargetPoolsOperationCallable()");
  }

  public UnaryCallable<SetTargetPoolsRegionInstanceGroupManagerRequest, Operation>
      setTargetPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: setTargetPoolsCallable()");
  }

  public OperationCallable<
          UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation, Operation>
      updatePerInstanceConfigsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePerInstanceConfigsOperationCallable()");
  }

  public UnaryCallable<UpdatePerInstanceConfigsRegionInstanceGroupManagerRequest, Operation>
      updatePerInstanceConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePerInstanceConfigsCallable()");
  }

  @Override
  public abstract void close();
}
