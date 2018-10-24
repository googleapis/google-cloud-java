/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.TargetTcpProxyClient.ListTargetTcpProxiesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.GetTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.InsertTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.ListTargetTcpProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetBackendServiceTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.SetProxyHeaderTargetTcpProxyHttpRequest;
import com.google.cloud.compute.v1.TargetTcpProxy;
import com.google.cloud.compute.v1.TargetTcpProxyList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class TargetTcpProxyStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteTargetTcpProxyHttpRequest, Operation> deleteTargetTcpProxyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTargetTcpProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<GetTargetTcpProxyHttpRequest, TargetTcpProxy> getTargetTcpProxyCallable() {
    throw new UnsupportedOperationException("Not implemented: getTargetTcpProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertTargetTcpProxyHttpRequest, Operation> insertTargetTcpProxyCallable() {
    throw new UnsupportedOperationException("Not implemented: insertTargetTcpProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<ListTargetTcpProxiesHttpRequest, ListTargetTcpProxiesPagedResponse>
      listTargetTcpProxiesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetTcpProxiesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListTargetTcpProxiesHttpRequest, TargetTcpProxyList>
      listTargetTcpProxiesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetTcpProxiesCallable()");
  }

  @BetaApi
  public UnaryCallable<SetBackendServiceTargetTcpProxyHttpRequest, Operation>
      setBackendServiceTargetTcpProxyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setBackendServiceTargetTcpProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<SetProxyHeaderTargetTcpProxyHttpRequest, Operation>
      setProxyHeaderTargetTcpProxyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setProxyHeaderTargetTcpProxyCallable()");
  }

  @Override
  public abstract void close();
}
