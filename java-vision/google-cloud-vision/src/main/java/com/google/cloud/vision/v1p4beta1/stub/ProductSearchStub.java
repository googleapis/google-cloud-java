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

package com.google.cloud.vision.v1p4beta1.stub;

import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductSetsPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductsInProductSetPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListProductsPagedResponse;
import static com.google.cloud.vision.v1p4beta1.ProductSearchClient.ListReferenceImagesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.vision.v1p4beta1.AddProductToProductSetRequest;
import com.google.cloud.vision.v1p4beta1.BatchOperationMetadata;
import com.google.cloud.vision.v1p4beta1.CreateProductRequest;
import com.google.cloud.vision.v1p4beta1.CreateProductSetRequest;
import com.google.cloud.vision.v1p4beta1.CreateReferenceImageRequest;
import com.google.cloud.vision.v1p4beta1.DeleteProductRequest;
import com.google.cloud.vision.v1p4beta1.DeleteProductSetRequest;
import com.google.cloud.vision.v1p4beta1.DeleteReferenceImageRequest;
import com.google.cloud.vision.v1p4beta1.GetProductRequest;
import com.google.cloud.vision.v1p4beta1.GetProductSetRequest;
import com.google.cloud.vision.v1p4beta1.GetReferenceImageRequest;
import com.google.cloud.vision.v1p4beta1.ImportProductSetsRequest;
import com.google.cloud.vision.v1p4beta1.ImportProductSetsResponse;
import com.google.cloud.vision.v1p4beta1.ListProductSetsRequest;
import com.google.cloud.vision.v1p4beta1.ListProductSetsResponse;
import com.google.cloud.vision.v1p4beta1.ListProductsInProductSetRequest;
import com.google.cloud.vision.v1p4beta1.ListProductsInProductSetResponse;
import com.google.cloud.vision.v1p4beta1.ListProductsRequest;
import com.google.cloud.vision.v1p4beta1.ListProductsResponse;
import com.google.cloud.vision.v1p4beta1.ListReferenceImagesRequest;
import com.google.cloud.vision.v1p4beta1.ListReferenceImagesResponse;
import com.google.cloud.vision.v1p4beta1.Product;
import com.google.cloud.vision.v1p4beta1.ProductSet;
import com.google.cloud.vision.v1p4beta1.PurgeProductsRequest;
import com.google.cloud.vision.v1p4beta1.ReferenceImage;
import com.google.cloud.vision.v1p4beta1.RemoveProductFromProductSetRequest;
import com.google.cloud.vision.v1p4beta1.UpdateProductRequest;
import com.google.cloud.vision.v1p4beta1.UpdateProductSetRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ProductSearch service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class ProductSearchStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateProductSetRequest, ProductSet> createProductSetCallable() {
    throw new UnsupportedOperationException("Not implemented: createProductSetCallable()");
  }

  public UnaryCallable<ListProductSetsRequest, ListProductSetsPagedResponse>
      listProductSetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductSetsPagedCallable()");
  }

  public UnaryCallable<ListProductSetsRequest, ListProductSetsResponse> listProductSetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductSetsCallable()");
  }

  public UnaryCallable<GetProductSetRequest, ProductSet> getProductSetCallable() {
    throw new UnsupportedOperationException("Not implemented: getProductSetCallable()");
  }

  public UnaryCallable<UpdateProductSetRequest, ProductSet> updateProductSetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProductSetCallable()");
  }

  public UnaryCallable<DeleteProductSetRequest, Empty> deleteProductSetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProductSetCallable()");
  }

  public UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    throw new UnsupportedOperationException("Not implemented: createProductCallable()");
  }

  public UnaryCallable<ListProductsRequest, ListProductsPagedResponse> listProductsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductsPagedCallable()");
  }

  public UnaryCallable<ListProductsRequest, ListProductsResponse> listProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductsCallable()");
  }

  public UnaryCallable<GetProductRequest, Product> getProductCallable() {
    throw new UnsupportedOperationException("Not implemented: getProductCallable()");
  }

  public UnaryCallable<UpdateProductRequest, Product> updateProductCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProductCallable()");
  }

  public UnaryCallable<DeleteProductRequest, Empty> deleteProductCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProductCallable()");
  }

  public UnaryCallable<CreateReferenceImageRequest, ReferenceImage> createReferenceImageCallable() {
    throw new UnsupportedOperationException("Not implemented: createReferenceImageCallable()");
  }

  public UnaryCallable<DeleteReferenceImageRequest, Empty> deleteReferenceImageCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReferenceImageCallable()");
  }

  public UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesPagedResponse>
      listReferenceImagesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReferenceImagesPagedCallable()");
  }

  public UnaryCallable<ListReferenceImagesRequest, ListReferenceImagesResponse>
      listReferenceImagesCallable() {
    throw new UnsupportedOperationException("Not implemented: listReferenceImagesCallable()");
  }

  public UnaryCallable<GetReferenceImageRequest, ReferenceImage> getReferenceImageCallable() {
    throw new UnsupportedOperationException("Not implemented: getReferenceImageCallable()");
  }

  public UnaryCallable<AddProductToProductSetRequest, Empty> addProductToProductSetCallable() {
    throw new UnsupportedOperationException("Not implemented: addProductToProductSetCallable()");
  }

  public UnaryCallable<RemoveProductFromProductSetRequest, Empty>
      removeProductFromProductSetCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeProductFromProductSetCallable()");
  }

  public UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetPagedResponse>
      listProductsInProductSetPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listProductsInProductSetPagedCallable()");
  }

  public UnaryCallable<ListProductsInProductSetRequest, ListProductsInProductSetResponse>
      listProductsInProductSetCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductsInProductSetCallable()");
  }

  public OperationCallable<
          ImportProductSetsRequest, ImportProductSetsResponse, BatchOperationMetadata>
      importProductSetsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importProductSetsOperationCallable()");
  }

  public UnaryCallable<ImportProductSetsRequest, Operation> importProductSetsCallable() {
    throw new UnsupportedOperationException("Not implemented: importProductSetsCallable()");
  }

  public OperationCallable<PurgeProductsRequest, Empty, BatchOperationMetadata>
      purgeProductsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeProductsOperationCallable()");
  }

  public UnaryCallable<PurgeProductsRequest, Operation> purgeProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: purgeProductsCallable()");
  }

  @Override
  public abstract void close();
}
