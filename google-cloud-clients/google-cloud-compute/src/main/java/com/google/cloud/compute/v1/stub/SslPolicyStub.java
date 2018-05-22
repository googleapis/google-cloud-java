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

import static com.google.cloud.compute.v1.SslPolicyClient.ListSslPoliciesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteSslPolicyHttpRequest;
import com.google.cloud.compute.v1.GetSslPolicyHttpRequest;
import com.google.cloud.compute.v1.InsertSslPolicyHttpRequest;
import com.google.cloud.compute.v1.ListAvailableFeaturesSslPoliciesHttpRequest;
import com.google.cloud.compute.v1.ListSslPoliciesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchSslPolicyHttpRequest;
import com.google.cloud.compute.v1.SslPoliciesList;
import com.google.cloud.compute.v1.SslPoliciesListAvailableFeaturesResponse;
import com.google.cloud.compute.v1.SslPolicy;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class SslPolicyStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteSslPolicyHttpRequest, Operation> deleteSslPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSslPolicyCallable()");
  }

  @BetaApi
  public UnaryCallable<GetSslPolicyHttpRequest, SslPolicy> getSslPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getSslPolicyCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertSslPolicyHttpRequest, Operation> insertSslPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: insertSslPolicyCallable()");
  }

  @BetaApi
  public UnaryCallable<ListSslPoliciesHttpRequest, ListSslPoliciesPagedResponse>
      listSslPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSslPoliciesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListSslPoliciesHttpRequest, SslPoliciesList> listSslPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSslPoliciesCallable()");
  }

  @BetaApi
  public UnaryCallable<
          ListAvailableFeaturesSslPoliciesHttpRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesSslPoliciesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAvailableFeaturesSslPoliciesCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchSslPolicyHttpRequest, Operation> patchSslPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: patchSslPolicyCallable()");
  }

  @Override
  public abstract void close();
}
