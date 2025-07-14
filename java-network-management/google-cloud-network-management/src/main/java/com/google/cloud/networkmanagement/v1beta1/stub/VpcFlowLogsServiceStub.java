/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.networkmanagement.v1beta1.stub;

import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.ListVpcFlowLogsConfigsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.QueryOrgVpcFlowLogsConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest;
import com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse;
import com.google.cloud.networkmanagement.v1beta1.OperationMetadata;
import com.google.cloud.networkmanagement.v1beta1.QueryOrgVpcFlowLogsConfigsRequest;
import com.google.cloud.networkmanagement.v1beta1.QueryOrgVpcFlowLogsConfigsResponse;
import com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest;
import com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig;
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
 * Base stub class for the VpcFlowLogsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class VpcFlowLogsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsPagedResponse>
      listVpcFlowLogsConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listVpcFlowLogsConfigsPagedCallable()");
  }

  public UnaryCallable<ListVpcFlowLogsConfigsRequest, ListVpcFlowLogsConfigsResponse>
      listVpcFlowLogsConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listVpcFlowLogsConfigsCallable()");
  }

  public UnaryCallable<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
      getVpcFlowLogsConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getVpcFlowLogsConfigCallable()");
  }

  public OperationCallable<CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      createVpcFlowLogsConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createVpcFlowLogsConfigOperationCallable()");
  }

  public UnaryCallable<CreateVpcFlowLogsConfigRequest, Operation>
      createVpcFlowLogsConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createVpcFlowLogsConfigCallable()");
  }

  public OperationCallable<UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      updateVpcFlowLogsConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateVpcFlowLogsConfigOperationCallable()");
  }

  public UnaryCallable<UpdateVpcFlowLogsConfigRequest, Operation>
      updateVpcFlowLogsConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateVpcFlowLogsConfigCallable()");
  }

  public OperationCallable<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
      deleteVpcFlowLogsConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteVpcFlowLogsConfigOperationCallable()");
  }

  public UnaryCallable<DeleteVpcFlowLogsConfigRequest, Operation>
      deleteVpcFlowLogsConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVpcFlowLogsConfigCallable()");
  }

  public UnaryCallable<QueryOrgVpcFlowLogsConfigsRequest, QueryOrgVpcFlowLogsConfigsPagedResponse>
      queryOrgVpcFlowLogsConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryOrgVpcFlowLogsConfigsPagedCallable()");
  }

  public UnaryCallable<QueryOrgVpcFlowLogsConfigsRequest, QueryOrgVpcFlowLogsConfigsResponse>
      queryOrgVpcFlowLogsConfigsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: queryOrgVpcFlowLogsConfigsCallable()");
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
