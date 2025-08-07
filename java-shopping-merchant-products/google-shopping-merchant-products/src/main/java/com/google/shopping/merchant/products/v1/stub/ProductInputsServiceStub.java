/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.products.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.products.v1.DeleteProductInputRequest;
import com.google.shopping.merchant.products.v1.InsertProductInputRequest;
import com.google.shopping.merchant.products.v1.ProductInput;
import com.google.shopping.merchant.products.v1.UpdateProductInputRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ProductInputsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ProductInputsServiceStub implements BackgroundResource {

  public UnaryCallable<InsertProductInputRequest, ProductInput> insertProductInputCallable() {
    throw new UnsupportedOperationException("Not implemented: insertProductInputCallable()");
  }

  public UnaryCallable<UpdateProductInputRequest, ProductInput> updateProductInputCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProductInputCallable()");
  }

  public UnaryCallable<DeleteProductInputRequest, Empty> deleteProductInputCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProductInputCallable()");
  }

  @Override
  public abstract void close();
}
