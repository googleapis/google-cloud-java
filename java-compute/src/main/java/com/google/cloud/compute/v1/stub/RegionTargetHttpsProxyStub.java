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

import static com.google.cloud.compute.v1.RegionTargetHttpsProxyClient.ListRegionTargetHttpsProxiesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.GetRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.InsertRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.ListRegionTargetHttpsProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetSslCertificatesRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.SetUrlMapRegionTargetHttpsProxyHttpRequest;
import com.google.cloud.compute.v1.TargetHttpsProxy;
import com.google.cloud.compute.v1.TargetHttpsProxyList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionTargetHttpsProxyStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionTargetHttpsProxyHttpRequest, Operation>
      deleteRegionTargetHttpsProxyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRegionTargetHttpsProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionTargetHttpsProxyHttpRequest, TargetHttpsProxy>
      getRegionTargetHttpsProxyCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionTargetHttpsProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionTargetHttpsProxyHttpRequest, Operation>
      insertRegionTargetHttpsProxyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: insertRegionTargetHttpsProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListRegionTargetHttpsProxiesHttpRequest, ListRegionTargetHttpsProxiesPagedResponse>
      listRegionTargetHttpsProxiesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionTargetHttpsProxiesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionTargetHttpsProxiesHttpRequest, TargetHttpsProxyList>
      listRegionTargetHttpsProxiesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionTargetHttpsProxiesCallable()");
  }

  @BetaApi
  public UnaryCallable<SetSslCertificatesRegionTargetHttpsProxyHttpRequest, Operation>
      setSslCertificatesRegionTargetHttpsProxyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setSslCertificatesRegionTargetHttpsProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<SetUrlMapRegionTargetHttpsProxyHttpRequest, Operation>
      setUrlMapRegionTargetHttpsProxyCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setUrlMapRegionTargetHttpsProxyCallable()");
  }

  @Override
  public abstract void close();
}
