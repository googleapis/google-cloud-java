/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.recommendationengine.v1beta1.stub;

import static com.google.cloud.recommendationengine.v1beta1.CatalogServiceClient.ListCatalogItemsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.recommendationengine.v1beta1.CatalogItem;
import com.google.cloud.recommendationengine.v1beta1.CreateCatalogItemRequest;
import com.google.cloud.recommendationengine.v1beta1.DeleteCatalogItemRequest;
import com.google.cloud.recommendationengine.v1beta1.GetCatalogItemRequest;
import com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsRequest;
import com.google.cloud.recommendationengine.v1beta1.ImportCatalogItemsResponse;
import com.google.cloud.recommendationengine.v1beta1.ImportMetadata;
import com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsRequest;
import com.google.cloud.recommendationengine.v1beta1.ListCatalogItemsResponse;
import com.google.cloud.recommendationengine.v1beta1.UpdateCatalogItemRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
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

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateCatalogItemRequest, CatalogItem> createCatalogItemCallable() {
    throw new UnsupportedOperationException("Not implemented: createCatalogItemCallable()");
  }

  public UnaryCallable<GetCatalogItemRequest, CatalogItem> getCatalogItemCallable() {
    throw new UnsupportedOperationException("Not implemented: getCatalogItemCallable()");
  }

  public UnaryCallable<ListCatalogItemsRequest, ListCatalogItemsPagedResponse>
      listCatalogItemsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogItemsPagedCallable()");
  }

  public UnaryCallable<ListCatalogItemsRequest, ListCatalogItemsResponse>
      listCatalogItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogItemsCallable()");
  }

  public UnaryCallable<UpdateCatalogItemRequest, CatalogItem> updateCatalogItemCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCatalogItemCallable()");
  }

  public UnaryCallable<DeleteCatalogItemRequest, Empty> deleteCatalogItemCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCatalogItemCallable()");
  }

  public OperationCallable<ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
      importCatalogItemsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importCatalogItemsOperationCallable()");
  }

  public UnaryCallable<ImportCatalogItemsRequest, Operation> importCatalogItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: importCatalogItemsCallable()");
  }

  @Override
  public abstract void close();
}
