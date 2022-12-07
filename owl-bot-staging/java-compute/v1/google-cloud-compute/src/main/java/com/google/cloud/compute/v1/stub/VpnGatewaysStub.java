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

import static com.google.cloud.compute.v1.VpnGatewaysClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.VpnGatewaysClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListVpnGatewaysRequest;
import com.google.cloud.compute.v1.DeleteVpnGatewayRequest;
import com.google.cloud.compute.v1.GetStatusVpnGatewayRequest;
import com.google.cloud.compute.v1.GetVpnGatewayRequest;
import com.google.cloud.compute.v1.InsertVpnGatewayRequest;
import com.google.cloud.compute.v1.ListVpnGatewaysRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetLabelsVpnGatewayRequest;
import com.google.cloud.compute.v1.TestIamPermissionsVpnGatewayRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.VpnGateway;
import com.google.cloud.compute.v1.VpnGatewayAggregatedList;
import com.google.cloud.compute.v1.VpnGatewayList;
import com.google.cloud.compute.v1.VpnGatewaysGetStatusResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the VpnGateways service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class VpnGatewaysStub implements BackgroundResource {

  public UnaryCallable<AggregatedListVpnGatewaysRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListVpnGatewaysRequest, VpnGatewayAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteVpnGatewayRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteVpnGatewayRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetVpnGatewayRequest, VpnGateway> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetStatusVpnGatewayRequest, VpnGatewaysGetStatusResponse>
      getStatusCallable() {
    throw new UnsupportedOperationException("Not implemented: getStatusCallable()");
  }

  public OperationCallable<InsertVpnGatewayRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertVpnGatewayRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListVpnGatewaysRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListVpnGatewaysRequest, VpnGatewayList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<SetLabelsVpnGatewayRequest, Operation, Operation>
      setLabelsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsOperationCallable()");
  }

  public UnaryCallable<SetLabelsVpnGatewayRequest, Operation> setLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsCallable()");
  }

  public UnaryCallable<TestIamPermissionsVpnGatewayRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
