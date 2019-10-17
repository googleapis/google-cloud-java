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

import static com.google.cloud.compute.v1.RegionTargetHttpProxyClient.ListRegionTargetHttpProxiesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.GetRegionTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.InsertRegionTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.ListRegionTargetHttpProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetUrlMapRegionTargetHttpProxyHttpRequest;
import com.google.cloud.compute.v1.TargetHttpProxy;
import com.google.cloud.compute.v1.TargetHttpProxyList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionTargetHttpProxyStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionTargetHttpProxyHttpRequest, Operation>
      deleteRegionTargetHttpProxyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRegionTargetHttpProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionTargetHttpProxyHttpRequest, TargetHttpProxy>
      getRegionTargetHttpProxyCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionTargetHttpProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionTargetHttpProxyHttpRequest, Operation>
      insertRegionTargetHttpProxyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: insertRegionTargetHttpProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListRegionTargetHttpProxiesHttpRequest, ListRegionTargetHttpProxiesPagedResponse>
      listRegionTargetHttpProxiesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionTargetHttpProxiesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionTargetHttpProxiesHttpRequest, TargetHttpProxyList>
      listRegionTargetHttpProxiesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionTargetHttpProxiesCallable()");
  }

  @BetaApi
  public UnaryCallable<SetUrlMapRegionTargetHttpProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpProxyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setUrlMapRegionTargetHttpProxyCallable()");
  }

  @Override
  public abstract void close();
}
