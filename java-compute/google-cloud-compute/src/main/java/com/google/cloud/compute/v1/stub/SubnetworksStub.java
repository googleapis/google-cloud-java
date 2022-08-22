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

import static com.google.cloud.compute.v1.SubnetworksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListUsablePagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListSubnetworksRequest;
import com.google.cloud.compute.v1.DeleteSubnetworkRequest;
import com.google.cloud.compute.v1.ExpandIpCidrRangeSubnetworkRequest;
import com.google.cloud.compute.v1.GetIamPolicySubnetworkRequest;
import com.google.cloud.compute.v1.GetSubnetworkRequest;
import com.google.cloud.compute.v1.InsertSubnetworkRequest;
import com.google.cloud.compute.v1.ListSubnetworksRequest;
import com.google.cloud.compute.v1.ListUsableSubnetworksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchSubnetworkRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicySubnetworkRequest;
import com.google.cloud.compute.v1.SetPrivateIpGoogleAccessSubnetworkRequest;
import com.google.cloud.compute.v1.Subnetwork;
import com.google.cloud.compute.v1.SubnetworkAggregatedList;
import com.google.cloud.compute.v1.SubnetworkList;
import com.google.cloud.compute.v1.TestIamPermissionsSubnetworkRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UsableSubnetworksAggregatedList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Subnetworks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SubnetworksStub implements BackgroundResource {

  public UnaryCallable<AggregatedListSubnetworksRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListSubnetworksRequest, SubnetworkAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteSubnetworkRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteSubnetworkRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public OperationCallable<ExpandIpCidrRangeSubnetworkRequest, Operation, Operation>
      expandIpCidrRangeOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: expandIpCidrRangeOperationCallable()");
  }

  public UnaryCallable<ExpandIpCidrRangeSubnetworkRequest, Operation> expandIpCidrRangeCallable() {
    throw new UnsupportedOperationException("Not implemented: expandIpCidrRangeCallable()");
  }

  public UnaryCallable<GetSubnetworkRequest, Subnetwork> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetIamPolicySubnetworkRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public OperationCallable<InsertSubnetworkRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertSubnetworkRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListSubnetworksRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListSubnetworksRequest, SubnetworkList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<ListUsableSubnetworksRequest, ListUsablePagedResponse>
      listUsablePagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsablePagedCallable()");
  }

  public UnaryCallable<ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList>
      listUsableCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsableCallable()");
  }

  public OperationCallable<PatchSubnetworkRequest, Operation, Operation> patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchSubnetworkRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<SetIamPolicySubnetworkRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public OperationCallable<SetPrivateIpGoogleAccessSubnetworkRequest, Operation, Operation>
      setPrivateIpGoogleAccessOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setPrivateIpGoogleAccessOperationCallable()");
  }

  public UnaryCallable<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessCallable() {
    throw new UnsupportedOperationException("Not implemented: setPrivateIpGoogleAccessCallable()");
  }

  public UnaryCallable<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
