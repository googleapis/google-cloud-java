/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.iap.v1.stub;

import static com.google.cloud.iap.v1.IdentityAwareProxyOAuthServiceClient.ListIdentityAwareProxyClientsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iap.v1.Brand;
import com.google.cloud.iap.v1.CreateBrandRequest;
import com.google.cloud.iap.v1.CreateIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.DeleteIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.GetBrandRequest;
import com.google.cloud.iap.v1.GetIdentityAwareProxyClientRequest;
import com.google.cloud.iap.v1.IdentityAwareProxyClient;
import com.google.cloud.iap.v1.ListBrandsRequest;
import com.google.cloud.iap.v1.ListBrandsResponse;
import com.google.cloud.iap.v1.ListIdentityAwareProxyClientsRequest;
import com.google.cloud.iap.v1.ListIdentityAwareProxyClientsResponse;
import com.google.cloud.iap.v1.ResetIdentityAwareProxyClientSecretRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IdentityAwareProxyOAuthService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IdentityAwareProxyOAuthServiceStub implements BackgroundResource {

  public UnaryCallable<ListBrandsRequest, ListBrandsResponse> listBrandsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBrandsCallable()");
  }

  public UnaryCallable<CreateBrandRequest, Brand> createBrandCallable() {
    throw new UnsupportedOperationException("Not implemented: createBrandCallable()");
  }

  public UnaryCallable<GetBrandRequest, Brand> getBrandCallable() {
    throw new UnsupportedOperationException("Not implemented: getBrandCallable()");
  }

  public UnaryCallable<CreateIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      createIdentityAwareProxyClientCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createIdentityAwareProxyClientCallable()");
  }

  public UnaryCallable<
          ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsPagedResponse>
      listIdentityAwareProxyClientsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listIdentityAwareProxyClientsPagedCallable()");
  }

  public UnaryCallable<ListIdentityAwareProxyClientsRequest, ListIdentityAwareProxyClientsResponse>
      listIdentityAwareProxyClientsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listIdentityAwareProxyClientsCallable()");
  }

  public UnaryCallable<GetIdentityAwareProxyClientRequest, IdentityAwareProxyClient>
      getIdentityAwareProxyClientCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getIdentityAwareProxyClientCallable()");
  }

  public UnaryCallable<ResetIdentityAwareProxyClientSecretRequest, IdentityAwareProxyClient>
      resetIdentityAwareProxyClientSecretCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resetIdentityAwareProxyClientSecretCallable()");
  }

  public UnaryCallable<DeleteIdentityAwareProxyClientRequest, Empty>
      deleteIdentityAwareProxyClientCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteIdentityAwareProxyClientCallable()");
  }

  @Override
  public abstract void close();
}
