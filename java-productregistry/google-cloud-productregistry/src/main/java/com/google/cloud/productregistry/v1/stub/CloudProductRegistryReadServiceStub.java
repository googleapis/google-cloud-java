/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.productregistry.v1.stub;

import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductVariantsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListLogicalProductsPagedResponse;
import static com.google.cloud.productregistry.v1.CloudProductRegistryReadServiceClient.ListProductSuitesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.productregistry.v1.GetLogicalProductRequest;
import com.google.cloud.productregistry.v1.GetLogicalProductVariantRequest;
import com.google.cloud.productregistry.v1.GetProductSuiteRequest;
import com.google.cloud.productregistry.v1.ListLogicalProductVariantsRequest;
import com.google.cloud.productregistry.v1.ListLogicalProductVariantsResponse;
import com.google.cloud.productregistry.v1.ListLogicalProductsRequest;
import com.google.cloud.productregistry.v1.ListLogicalProductsResponse;
import com.google.cloud.productregistry.v1.ListProductSuitesRequest;
import com.google.cloud.productregistry.v1.ListProductSuitesResponse;
import com.google.cloud.productregistry.v1.LogicalProduct;
import com.google.cloud.productregistry.v1.LogicalProductVariant;
import com.google.cloud.productregistry.v1.LookupEntityRequest;
import com.google.cloud.productregistry.v1.LookupEntityResponse;
import com.google.cloud.productregistry.v1.ProductSuite;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudProductRegistryReadService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class CloudProductRegistryReadServiceStub implements BackgroundResource {

  public UnaryCallable<GetProductSuiteRequest, ProductSuite> getProductSuiteCallable() {
    throw new UnsupportedOperationException("Not implemented: getProductSuiteCallable()");
  }

  public UnaryCallable<ListProductSuitesRequest, ListProductSuitesPagedResponse>
      listProductSuitesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductSuitesPagedCallable()");
  }

  public UnaryCallable<ListProductSuitesRequest, ListProductSuitesResponse>
      listProductSuitesCallable() {
    throw new UnsupportedOperationException("Not implemented: listProductSuitesCallable()");
  }

  public UnaryCallable<GetLogicalProductRequest, LogicalProduct> getLogicalProductCallable() {
    throw new UnsupportedOperationException("Not implemented: getLogicalProductCallable()");
  }

  public UnaryCallable<ListLogicalProductsRequest, ListLogicalProductsPagedResponse>
      listLogicalProductsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogicalProductsPagedCallable()");
  }

  public UnaryCallable<ListLogicalProductsRequest, ListLogicalProductsResponse>
      listLogicalProductsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogicalProductsCallable()");
  }

  public UnaryCallable<GetLogicalProductVariantRequest, LogicalProductVariant>
      getLogicalProductVariantCallable() {
    throw new UnsupportedOperationException("Not implemented: getLogicalProductVariantCallable()");
  }

  public UnaryCallable<ListLogicalProductVariantsRequest, ListLogicalProductVariantsPagedResponse>
      listLogicalProductVariantsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listLogicalProductVariantsPagedCallable()");
  }

  public UnaryCallable<ListLogicalProductVariantsRequest, ListLogicalProductVariantsResponse>
      listLogicalProductVariantsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listLogicalProductVariantsCallable()");
  }

  public UnaryCallable<LookupEntityRequest, LookupEntityResponse> lookupEntityCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupEntityCallable()");
  }

  @Override
  public abstract void close();
}
