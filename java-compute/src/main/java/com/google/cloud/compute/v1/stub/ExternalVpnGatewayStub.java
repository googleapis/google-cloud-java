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

import static com.google.cloud.compute.v1.ExternalVpnGatewayClient.ListExternalVpnGatewaysPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ExternalVpnGateway;
import com.google.cloud.compute.v1.ExternalVpnGatewayList;
import com.google.cloud.compute.v1.GetExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.InsertExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ListExternalVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetLabelsExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsExternalVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class ExternalVpnGatewayStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteExternalVpnGatewayHttpRequest, Operation>
      deleteExternalVpnGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExternalVpnGatewayCallable()");
  }

  @BetaApi
  public UnaryCallable<GetExternalVpnGatewayHttpRequest, ExternalVpnGateway>
      getExternalVpnGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: getExternalVpnGatewayCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertExternalVpnGatewayHttpRequest, Operation>
      insertExternalVpnGatewayCallable() {
    throw new UnsupportedOperationException("Not implemented: insertExternalVpnGatewayCallable()");
  }

  @BetaApi
  public UnaryCallable<ListExternalVpnGatewaysHttpRequest, ListExternalVpnGatewaysPagedResponse>
      listExternalVpnGatewaysPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listExternalVpnGatewaysPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListExternalVpnGatewaysHttpRequest, ExternalVpnGatewayList>
      listExternalVpnGatewaysCallable() {
    throw new UnsupportedOperationException("Not implemented: listExternalVpnGatewaysCallable()");
  }

  @BetaApi
  public UnaryCallable<SetLabelsExternalVpnGatewayHttpRequest, Operation>
      setLabelsExternalVpnGatewayCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setLabelsExternalVpnGatewayCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsExternalVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsExternalVpnGatewayCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsExternalVpnGatewayCallable()");
  }

  @Override
  public abstract void close();
}
