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

package com.google.cloud.retail.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.CreateProductRequest;
import com.google.cloud.retail.v2.DeleteProductRequest;
import com.google.cloud.retail.v2.GetProductRequest;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.cloud.retail.v2.ImportProductsRequest;
import com.google.cloud.retail.v2.ImportProductsResponse;
import com.google.cloud.retail.v2.Product;
import com.google.cloud.retail.v2.UpdateProductRequest;
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
@Generated("by gapic-generator-java")
public abstract class ProductServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateProductRequest, Product> createProductCallable() {
    throw new UnsupportedOperationException("Not implemented: createProductCallable()");
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

  public OperationCallable<ImportProductsRequest, ImportProductsResponse, ImportMetadata>
      importProductsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importProductsOperationCallable()");
  }

  public UnaryCallable<ImportProductsRequest, Operation> importProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: importProductsCallable()");
  }

  @Override
  public abstract void close();
}
