/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.privatecatalog.v1beta1.stub;

import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchCatalogsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchProductsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchVersionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse;
import com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PrivateCatalog service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class PrivateCatalogStub implements BackgroundResource {

  public UnaryCallable<SearchCatalogsRequest, SearchCatalogsPagedResponse>
      searchCatalogsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCatalogsPagedCallable()");
  }

  public UnaryCallable<SearchCatalogsRequest, SearchCatalogsResponse> searchCatalogsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchCatalogsCallable()");
  }

  public UnaryCallable<SearchProductsRequest, SearchProductsPagedResponse>
      searchProductsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchProductsPagedCallable()");
  }

  public UnaryCallable<SearchProductsRequest, SearchProductsResponse> searchProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchProductsCallable()");
  }

  public UnaryCallable<SearchVersionsRequest, SearchVersionsPagedResponse>
      searchVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchVersionsPagedCallable()");
  }

  public UnaryCallable<SearchVersionsRequest, SearchVersionsResponse> searchVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchVersionsCallable()");
  }

  @Override
  public abstract void close();
}
