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

import static com.google.cloud.retail.v2beta.ProductServiceClient.ListProductsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.AddFulfillmentPlacesMetadata;
import com.google.cloud.retail.v2beta.AddFulfillmentPlacesRequest;
import com.google.cloud.retail.v2beta.AddFulfillmentPlacesResponse;
import com.google.cloud.retail.v2beta.AddLocalInventoriesMetadata;
import com.google.cloud.retail.v2beta.AddLocalInventoriesRequest;
import com.google.cloud.retail.v2beta.AddLocalInventoriesResponse;
import com.google.cloud.retail.v2beta.CreateProductRequest;
import com.google.cloud.retail.v2beta.DeleteProductRequest;
import com.google.cloud.retail.v2beta.GetProductRequest;
import com.google.cloud.retail.v2beta.ImportMetadata;
import com.google.cloud.retail.v2beta.ImportProductsRequest;
import com.google.cloud.retail.v2beta.ImportProductsResponse;
import com.google.cloud.retail.v2beta.ListProductsRequest;
import com.google.cloud.retail.v2beta.ListProductsResponse;
import com.google.cloud.retail.v2beta.Product;
import com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesMetadata;
import com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesRequest;
import com.google.cloud.retail.v2beta.RemoveFulfillmentPlacesResponse;
import com.google.cloud.retail.v2beta.RemoveLocalInventoriesMetadata;
import com.google.cloud.retail.v2beta.RemoveLocalInventoriesRequest;
import com.google.cloud.retail.v2beta.RemoveLocalInventoriesResponse;
import com.google.cloud.retail.v2beta.SetInventoryMetadata;
import com.google.cloud.retail.v2beta.SetInventoryRequest;
import com.google.cloud.retail.v2beta.SetInventoryResponse;
import com.google.cloud.retail.v2beta.UpdateProductRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ProductService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ProductServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    throw new UnsupportedOperationException("Not implemented: createProductCallable()");
  }

  public UnaryCallable<GetProductRequest, Product> getProductCallable() {
    throw new UnsupportedOperationException("Not implemented: getProductCallable()");
  }

  public UnaryCallable<ListProductsRequest, ListProductsPagedResponse> listProductsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductsPagedCallable()");
  }

  public UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductsCallable()");
  }

  public UnaryCallable<UpdateProductRequest, Product> updateProductCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProductCallable()");
  }

  public UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProductCallable()");
  }

  public OperationCallable<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importProductsOperationCallable()");
  }

  public UnaryCallable<ImportProductsRequest, Operation> importProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: importProductsCallable()");
  }

  public OperationCallable<SetInventoryRequest, SetInventoryResponse, SetInventoryMetadata>
      setInventoryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setInventoryOperationCallable()");
  }

  public UnaryCallable<SetInventoryRequest, Operation> setInventoryCallable() {
    throw new UnsupportedOperationException("Not implemented: setInventoryCallable()");
  }

  public OperationCallable<
          AddFulfillmentPlacesRequest, AddFulfillmentPlacesResponse, AddFulfillmentPlacesMetadata>
      addFulfillmentPlacesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: addFulfillmentPlacesOperationCallable()");
  }

  public UnaryCallable<AddFulfillmentPlacesRequest, Operation> addFulfillmentPlacesCallable() {
    throw new UnsupportedOperationException("Not implemented: addFulfillmentPlacesCallable()");
  }

  public OperationCallable<
          RemoveFulfillmentPlacesRequest,
          RemoveFulfillmentPlacesResponse,
          RemoveFulfillmentPlacesMetadata>
      removeFulfillmentPlacesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeFulfillmentPlacesOperationCallable()");
  }

  public UnaryCallable<RemoveFulfillmentPlacesRequest, Operation>
      removeFulfillmentPlacesCallable() {
    throw new UnsupportedOperationException("Not implemented: removeFulfillmentPlacesCallable()");
  }

  public OperationCallable<
          AddLocalInventoriesRequest, AddLocalInventoriesResponse, AddLocalInventoriesMetadata>
      addLocalInventoriesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: addLocalInventoriesOperationCallable()");
  }

  public UnaryCallable<AddLocalInventoriesRequest, Operation> addLocalInventoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: addLocalInventoriesCallable()");
  }

  public OperationCallable<
          RemoveLocalInventoriesRequest,
          RemoveLocalInventoriesResponse,
          RemoveLocalInventoriesMetadata>
      removeLocalInventoriesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeLocalInventoriesOperationCallable()");
  }

  public UnaryCallable<RemoveLocalInventoriesRequest, Operation> removeLocalInventoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: removeLocalInventoriesCallable()");
  }

  @Override
  public abstract void close();
}
