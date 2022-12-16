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

package com.google.cloud.retail.v2beta.stub;

import static com.google.cloud.retail.v2beta.CatalogServiceClient.ListCatalogsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.AddCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.AttributesConfig;
import com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesRequest;
import com.google.cloud.retail.v2beta.BatchRemoveCatalogAttributesResponse;
import com.google.cloud.retail.v2beta.Catalog;
import com.google.cloud.retail.v2beta.CompletionConfig;
import com.google.cloud.retail.v2beta.GetAttributesConfigRequest;
import com.google.cloud.retail.v2beta.GetCompletionConfigRequest;
import com.google.cloud.retail.v2beta.GetDefaultBranchRequest;
import com.google.cloud.retail.v2beta.GetDefaultBranchResponse;
import com.google.cloud.retail.v2beta.ListCatalogsRequest;
import com.google.cloud.retail.v2beta.ListCatalogsResponse;
import com.google.cloud.retail.v2beta.RemoveCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.ReplaceCatalogAttributeRequest;
import com.google.cloud.retail.v2beta.SetDefaultBranchRequest;
import com.google.cloud.retail.v2beta.UpdateAttributesConfigRequest;
import com.google.cloud.retail.v2beta.UpdateCatalogRequest;
import com.google.cloud.retail.v2beta.UpdateCompletionConfigRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class CatalogServiceStub implements BackgroundResource {

  public UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse> listCatalogsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogsPagedCallable()");
  }

  public UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogsCallable()");
  }

  public UnaryCallable<UpdateCatalogRequest, Catalog> updateCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCatalogCallable()");
  }

  public UnaryCallable<SetDefaultBranchRequest, Empty> setDefaultBranchCallable() {
    throw new UnsupportedOperationException("Not implemented: setDefaultBranchCallable()");
  }

  public UnaryCallable<GetDefaultBranchRequest, GetDefaultBranchResponse>
      getDefaultBranchCallable() {
    throw new UnsupportedOperationException("Not implemented: getDefaultBranchCallable()");
  }

  public UnaryCallable<GetCompletionConfigRequest, CompletionConfig> getCompletionConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getCompletionConfigCallable()");
  }

  public UnaryCallable<UpdateCompletionConfigRequest, CompletionConfig>
      updateCompletionConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCompletionConfigCallable()");
  }

  public UnaryCallable<GetAttributesConfigRequest, AttributesConfig> getAttributesConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAttributesConfigCallable()");
  }

  public UnaryCallable<UpdateAttributesConfigRequest, AttributesConfig>
      updateAttributesConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAttributesConfigCallable()");
  }

  public UnaryCallable<AddCatalogAttributeRequest, AttributesConfig> addCatalogAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: addCatalogAttributeCallable()");
  }

  public UnaryCallable<RemoveCatalogAttributeRequest, AttributesConfig>
      removeCatalogAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: removeCatalogAttributeCallable()");
  }

  public UnaryCallable<BatchRemoveCatalogAttributesRequest, BatchRemoveCatalogAttributesResponse>
      batchRemoveCatalogAttributesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchRemoveCatalogAttributesCallable()");
  }

  public UnaryCallable<ReplaceCatalogAttributeRequest, AttributesConfig>
      replaceCatalogAttributeCallable() {
    throw new UnsupportedOperationException("Not implemented: replaceCatalogAttributeCallable()");
  }

  @Override
  public abstract void close();
}
