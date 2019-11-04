/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.VpnGatewayClient.AggregatedListVpnGatewaysPagedResponse;
import static com.google.cloud.compute.v1.VpnGatewayClient.ListVpnGatewaysPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.DeleteVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.GetStatusVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.GetVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.InsertVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ListVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetLabelsVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.VpnGateway;
import com.google.cloud.compute.v1.VpnGatewayAggregatedList;
import com.google.cloud.compute.v1.VpnGatewayList;
import com.google.cloud.compute.v1.VpnGatewaysGetStatusResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class VpnGatewayStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AggregatedListVpnGatewaysHttpRequest, AggregatedListVpnGatewaysPagedResponse>
      aggregatedListVpnGatewaysPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListVpnGatewaysPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList>
      aggregatedListVpnGatewaysCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListVpnGatewaysCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteVpnGatewayHttpRequest, Operation> deleteVpnGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteVpnGatewayCallable()");
  }

  @BetaApi
  public UnaryCallable<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: getVpnGatewayCallable()");
  }

  @BetaApi
  public UnaryCallable<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
      getStatusVpnGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: getStatusVpnGatewayCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertVpnGatewayHttpRequest, Operation> insertVpnGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: insertVpnGatewayCallable()");
  }

  @BetaApi
  public UnaryCallable<ListVpnGatewaysHttpRequest, ListVpnGatewaysPagedResponse>
      listVpnGatewaysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listVpnGatewaysPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListVpnGatewaysHttpRequest, VpnGatewayList> listVpnGatewaysCallable() {
    throw new UnsupportedOperationException("Not implemented: listVpnGatewaysCallable()");
  }

  @BetaApi
  public UnaryCallable<SetLabelsVpnGatewayHttpRequest, Operation> setLabelsVpnGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsVpnGatewayCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsVpnGatewayCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsVpnGatewayCallable()");
  }

  @Override
  public abstract void close();
}
