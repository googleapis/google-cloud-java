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
package com.google.cloud.asset.v1p1beta1.stub;

import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchAllIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchAllResourcesPagedResponse;
import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchIamPoliciesPagedResponse;
import static com.google.cloud.asset.v1p1beta1.AssetServiceClient.SearchResourcesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1p1beta1.SearchAllIamPoliciesRequest;
import com.google.cloud.asset.v1p1beta1.SearchAllIamPoliciesResponse;
import com.google.cloud.asset.v1p1beta1.SearchAllResourcesRequest;
import com.google.cloud.asset.v1p1beta1.SearchAllResourcesResponse;
import com.google.cloud.asset.v1p1beta1.SearchIamPoliciesRequest;
import com.google.cloud.asset.v1p1beta1.SearchIamPoliciesResponse;
import com.google.cloud.asset.v1p1beta1.SearchResourcesRequest;
import com.google.cloud.asset.v1p1beta1.SearchResourcesResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Cloud Asset API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class AssetServiceStub implements BackgroundResource {

  public UnaryCallable<SearchResourcesRequest, SearchResourcesPagedResponse>
      searchResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchResourcesPagedCallable()");
  }

  public UnaryCallable<SearchResourcesRequest, SearchResourcesResponse> searchResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchResourcesCallable()");
  }

  public UnaryCallable<SearchIamPoliciesRequest, SearchIamPoliciesPagedResponse>
      searchIamPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchIamPoliciesPagedCallable()");
  }

  public UnaryCallable<SearchIamPoliciesRequest, SearchIamPoliciesResponse>
      searchIamPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchIamPoliciesCallable()");
  }

  public UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesPagedResponse>
      searchAllResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllResourcesPagedCallable()");
  }

  public UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllResourcesCallable()");
  }

  public UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllIamPoliciesPagedCallable()");
  }

  public UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllIamPoliciesCallable()");
  }

  @Override
  public abstract void close();
}
