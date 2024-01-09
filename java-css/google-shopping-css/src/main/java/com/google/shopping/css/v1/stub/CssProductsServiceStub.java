/*
 * Copyright 2023 Google LLC
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

package com.google.shopping.css.v1.stub;

import static com.google.shopping.css.v1.CssProductsServiceClient.ListCssProductsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.shopping.css.v1.CssProduct;
import com.google.shopping.css.v1.GetCssProductRequest;
import com.google.shopping.css.v1.ListCssProductsRequest;
import com.google.shopping.css.v1.ListCssProductsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CssProductsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CssProductsServiceStub implements BackgroundResource {

  public UnaryCallable<GetCssProductRequest, CssProduct> getCssProductCallable() {
    throw new UnsupportedOperationException("Not implemented: getCssProductCallable()");
  }

  public UnaryCallable<ListCssProductsRequest, ListCssProductsPagedResponse>
      listCssProductsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCssProductsPagedCallable()");
  }

  public UnaryCallable<ListCssProductsRequest, ListCssProductsResponse> listCssProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCssProductsCallable()");
  }

  @Override
  public abstract void close();
}
