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

import static com.google.cloud.compute.v1.TargetSslProxiesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteTargetSslProxyRequest;
import com.google.cloud.compute.v1.GetTargetSslProxyRequest;
import com.google.cloud.compute.v1.InsertTargetSslProxyRequest;
import com.google.cloud.compute.v1.ListTargetSslProxiesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetBackendServiceTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetProxyHeaderTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetSslCertificatesTargetSslProxyRequest;
import com.google.cloud.compute.v1.SetSslPolicyTargetSslProxyRequest;
import com.google.cloud.compute.v1.TargetSslProxy;
import com.google.cloud.compute.v1.TargetSslProxyList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TargetSslProxies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TargetSslProxiesStub implements BackgroundResource {

  public UnaryCallable<DeleteTargetSslProxyRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetTargetSslProxyRequest, TargetSslProxy> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<InsertTargetSslProxyRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListTargetSslProxiesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListTargetSslProxiesRequest, TargetSslProxyList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public UnaryCallable<SetBackendServiceTargetSslProxyRequest, Operation>
      setBackendServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: setBackendServiceCallable()");
  }

  public UnaryCallable<SetProxyHeaderTargetSslProxyRequest, Operation> setProxyHeaderCallable() {
    throw new UnsupportedOperationException("Not implemented: setProxyHeaderCallable()");
  }

  public UnaryCallable<SetSslCertificatesTargetSslProxyRequest, Operation>
      setSslCertificatesCallable() {
    throw new UnsupportedOperationException("Not implemented: setSslCertificatesCallable()");
  }

  public UnaryCallable<SetSslPolicyTargetSslProxyRequest, Operation> setSslPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setSslPolicyCallable()");
  }

  @Override
  public abstract void close();
}
