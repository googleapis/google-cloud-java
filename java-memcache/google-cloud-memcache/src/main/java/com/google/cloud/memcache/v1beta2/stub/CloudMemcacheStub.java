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

package com.google.cloud.memcache.v1beta2.stub;

import static com.google.cloud.memcache.v1beta2.CloudMemcacheClient.ListInstancesPagedResponse;
import static com.google.cloud.memcache.v1beta2.CloudMemcacheClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.memcache.v1beta2.ApplyParametersRequest;
import com.google.cloud.memcache.v1beta2.ApplySoftwareUpdateRequest;
import com.google.cloud.memcache.v1beta2.CreateInstanceRequest;
import com.google.cloud.memcache.v1beta2.DeleteInstanceRequest;
import com.google.cloud.memcache.v1beta2.GetInstanceRequest;
import com.google.cloud.memcache.v1beta2.Instance;
import com.google.cloud.memcache.v1beta2.ListInstancesRequest;
import com.google.cloud.memcache.v1beta2.ListInstancesResponse;
import com.google.cloud.memcache.v1beta2.OperationMetadata;
import com.google.cloud.memcache.v1beta2.RescheduleMaintenanceRequest;
import com.google.cloud.memcache.v1beta2.UpdateInstanceRequest;
import com.google.cloud.memcache.v1beta2.UpdateParametersRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudMemcache service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class CloudMemcacheStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceOperationCallable()");
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceCallable()");
  }

  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceCallable()");
  }

  public OperationCallable<UpdateParametersRequest, Instance, OperationMetadata>
      updateParametersOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateParametersOperationCallable()");
  }

  public UnaryCallable<UpdateParametersRequest, Operation> updateParametersCallable() {
    throw new UnsupportedOperationException("Not implemented: updateParametersCallable()");
  }

  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
  }

  public OperationCallable<ApplyParametersRequest, Instance, OperationMetadata>
      applyParametersOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: applyParametersOperationCallable()");
  }

  public UnaryCallable<ApplyParametersRequest, Operation> applyParametersCallable() {
    throw new UnsupportedOperationException("Not implemented: applyParametersCallable()");
  }

  public OperationCallable<ApplySoftwareUpdateRequest, Instance, OperationMetadata>
      applySoftwareUpdateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: applySoftwareUpdateOperationCallable()");
  }

  public UnaryCallable<ApplySoftwareUpdateRequest, Operation> applySoftwareUpdateCallable() {
    throw new UnsupportedOperationException("Not implemented: applySoftwareUpdateCallable()");
  }

  public OperationCallable<RescheduleMaintenanceRequest, Instance, OperationMetadata>
      rescheduleMaintenanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rescheduleMaintenanceOperationCallable()");
  }

  public UnaryCallable<RescheduleMaintenanceRequest, Operation> rescheduleMaintenanceCallable() {
    throw new UnsupportedOperationException("Not implemented: rescheduleMaintenanceCallable()");
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

  @Override
  public abstract void close();
}
