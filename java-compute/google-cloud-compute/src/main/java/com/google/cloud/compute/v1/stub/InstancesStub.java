/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.compute.v1.InstancesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListReferrersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.AddResourcePoliciesInstanceRequest;
import com.google.cloud.compute.v1.AggregatedListInstancesRequest;
import com.google.cloud.compute.v1.AttachDiskInstanceRequest;
import com.google.cloud.compute.v1.BulkInsertInstanceRequest;
import com.google.cloud.compute.v1.DeleteAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.DeleteInstanceRequest;
import com.google.cloud.compute.v1.DetachDiskInstanceRequest;
import com.google.cloud.compute.v1.GetEffectiveFirewallsInstanceRequest;
import com.google.cloud.compute.v1.GetGuestAttributesInstanceRequest;
import com.google.cloud.compute.v1.GetIamPolicyInstanceRequest;
import com.google.cloud.compute.v1.GetInstanceRequest;
import com.google.cloud.compute.v1.GetScreenshotInstanceRequest;
import com.google.cloud.compute.v1.GetSerialPortOutputInstanceRequest;
import com.google.cloud.compute.v1.GetShieldedInstanceIdentityInstanceRequest;
import com.google.cloud.compute.v1.GuestAttributes;
import com.google.cloud.compute.v1.InsertInstanceRequest;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstanceAggregatedList;
import com.google.cloud.compute.v1.InstanceList;
import com.google.cloud.compute.v1.InstanceListReferrers;
import com.google.cloud.compute.v1.InstancesGetEffectiveFirewallsResponse;
import com.google.cloud.compute.v1.ListInstancesRequest;
import com.google.cloud.compute.v1.ListReferrersInstancesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesInstanceRequest;
import com.google.cloud.compute.v1.ResetInstanceRequest;
import com.google.cloud.compute.v1.Screenshot;
import com.google.cloud.compute.v1.SerialPortOutput;
import com.google.cloud.compute.v1.SetDeletionProtectionInstanceRequest;
import com.google.cloud.compute.v1.SetDiskAutoDeleteInstanceRequest;
import com.google.cloud.compute.v1.SetIamPolicyInstanceRequest;
import com.google.cloud.compute.v1.SetLabelsInstanceRequest;
import com.google.cloud.compute.v1.SetMachineResourcesInstanceRequest;
import com.google.cloud.compute.v1.SetMachineTypeInstanceRequest;
import com.google.cloud.compute.v1.SetMetadataInstanceRequest;
import com.google.cloud.compute.v1.SetMinCpuPlatformInstanceRequest;
import com.google.cloud.compute.v1.SetSchedulingInstanceRequest;
import com.google.cloud.compute.v1.SetServiceAccountInstanceRequest;
import com.google.cloud.compute.v1.SetShieldedInstanceIntegrityPolicyInstanceRequest;
import com.google.cloud.compute.v1.SetTagsInstanceRequest;
import com.google.cloud.compute.v1.ShieldedInstanceIdentity;
import com.google.cloud.compute.v1.SimulateMaintenanceEventInstanceRequest;
import com.google.cloud.compute.v1.StartInstanceRequest;
import com.google.cloud.compute.v1.StartWithEncryptionKeyInstanceRequest;
import com.google.cloud.compute.v1.StopInstanceRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInstanceRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.UpdateDisplayDeviceInstanceRequest;
import com.google.cloud.compute.v1.UpdateInstanceRequest;
import com.google.cloud.compute.v1.UpdateNetworkInterfaceInstanceRequest;
import com.google.cloud.compute.v1.UpdateShieldedInstanceConfigInstanceRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Instances service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class InstancesStub implements BackgroundResource {

  public UnaryCallable<AddAccessConfigInstanceRequest, Operation> addAccessConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: addAccessConfigCallable()");
  }

  public UnaryCallable<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: addResourcePoliciesCallable()");
  }

  public UnaryCallable<AggregatedListInstancesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListInstancesRequest, InstanceAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public UnaryCallable<AttachDiskInstanceRequest, Operation> attachDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: attachDiskCallable()");
  }

  public UnaryCallable<BulkInsertInstanceRequest, Operation> bulkInsertCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkInsertCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<DeleteAccessConfigInstanceRequest, Operation> deleteAccessConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAccessConfigCallable()");
  }

  public UnaryCallable<DetachDiskInstanceRequest, Operation> detachDiskCallable() {
    throw new UnsupportedOperationException("Not implemented: detachDiskCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable() {
    throw new UnsupportedOperationException("Not implemented: getEffectiveFirewallsCallable()");
  }

  public UnaryCallable<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesCallable() {
    throw new UnsupportedOperationException("Not implemented: getGuestAttributesCallable()");
  }

  public UnaryCallable<GetIamPolicyInstanceRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<GetScreenshotInstanceRequest, Screenshot> getScreenshotCallable() {
    throw new UnsupportedOperationException("Not implemented: getScreenshotCallable()");
  }

  public UnaryCallable<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputCallable() {
    throw new UnsupportedOperationException("Not implemented: getSerialPortOutputCallable()");
  }

  public UnaryCallable<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getShieldedInstanceIdentityCallable()");
  }

  public UnaryCallable<InsertInstanceRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, InstanceList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<ListReferrersInstancesRequest, ListReferrersPagedResponse>
      listReferrersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReferrersPagedCallable()");
  }

  public UnaryCallable<ListReferrersInstancesRequest, InstanceListReferrers>
      listReferrersCallable() {
    throw new UnsupportedOperationException("Not implemented: listReferrersCallable()");
  }

  public UnaryCallable<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: removeResourcePoliciesCallable()");
  }

  public UnaryCallable<ResetInstanceRequest, Operation> resetCallable() {
    throw new UnsupportedOperationException("Not implemented: resetCallable()");
  }

  public UnaryCallable<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionCallable() {
    throw new UnsupportedOperationException("Not implemented: setDeletionProtectionCallable()");
  }

  public UnaryCallable<SetDiskAutoDeleteInstanceRequest, Operation> setDiskAutoDeleteCallable() {
    throw new UnsupportedOperationException("Not implemented: setDiskAutoDeleteCallable()");
  }

  public UnaryCallable<SetIamPolicyInstanceRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<SetLabelsInstanceRequest, Operation> setLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsCallable()");
  }

  public UnaryCallable<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: setMachineResourcesCallable()");
  }

  public UnaryCallable<SetMachineTypeInstanceRequest, Operation> setMachineTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: setMachineTypeCallable()");
  }

  public UnaryCallable<SetMetadataInstanceRequest, Operation> setMetadataCallable() {
    throw new UnsupportedOperationException("Not implemented: setMetadataCallable()");
  }

  public UnaryCallable<SetMinCpuPlatformInstanceRequest, Operation> setMinCpuPlatformCallable() {
    throw new UnsupportedOperationException("Not implemented: setMinCpuPlatformCallable()");
  }

  public UnaryCallable<SetSchedulingInstanceRequest, Operation> setSchedulingCallable() {
    throw new UnsupportedOperationException("Not implemented: setSchedulingCallable()");
  }

  public UnaryCallable<SetServiceAccountInstanceRequest, Operation> setServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: setServiceAccountCallable()");
  }

  public UnaryCallable<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setShieldedInstanceIntegrityPolicyCallable()");
  }

  public UnaryCallable<SetTagsInstanceRequest, Operation> setTagsCallable() {
    throw new UnsupportedOperationException("Not implemented: setTagsCallable()");
  }

  public UnaryCallable<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventCallable() {
    throw new UnsupportedOperationException("Not implemented: simulateMaintenanceEventCallable()");
  }

  public UnaryCallable<StartInstanceRequest, Operation> startCallable() {
    throw new UnsupportedOperationException("Not implemented: startCallable()");
  }

  public UnaryCallable<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: startWithEncryptionKeyCallable()");
  }

  public UnaryCallable<StopInstanceRequest, Operation> stopCallable() {
    throw new UnsupportedOperationException("Not implemented: stopCallable()");
  }

  public UnaryCallable<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  public UnaryCallable<UpdateAccessConfigInstanceRequest, Operation> updateAccessConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccessConfigCallable()");
  }

  public UnaryCallable<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDisplayDeviceCallable()");
  }

  public UnaryCallable<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateNetworkInterfaceCallable()");
  }

  public UnaryCallable<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateShieldedInstanceConfigCallable()");
  }

  @Override
  public abstract void close();
}
