/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.TargetGrpcProxyClient.ListTargetGrpcProxiesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.GetTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.InsertTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.ListTargetGrpcProxiesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchTargetGrpcProxyHttpRequest;
import com.google.cloud.compute.v1.TargetGrpcProxy;
import com.google.cloud.compute.v1.TargetGrpcProxyList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class TargetGrpcProxyStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteTargetGrpcProxyHttpRequest, Operation>
      deleteTargetGrpcProxyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTargetGrpcProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<GetTargetGrpcProxyHttpRequest, TargetGrpcProxy>
      getTargetGrpcProxyCallable() {
    throw new UnsupportedOperationException("Not implemented: getTargetGrpcProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertTargetGrpcProxyHttpRequest, Operation>
      insertTargetGrpcProxyCallable() {
    throw new UnsupportedOperationException("Not implemented: insertTargetGrpcProxyCallable()");
  }

  @BetaApi
  public UnaryCallable<ListTargetGrpcProxiesHttpRequest, ListTargetGrpcProxiesPagedResponse>
      listTargetGrpcProxiesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTargetGrpcProxiesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListTargetGrpcProxiesHttpRequest, TargetGrpcProxyList>
      listTargetGrpcProxiesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetGrpcProxiesCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchTargetGrpcProxyHttpRequest, Operation> patchTargetGrpcProxyCallable() {
    throw new UnsupportedOperationException("Not implemented: patchTargetGrpcProxyCallable()");
  }

  @Override
  public abstract void close();
}
