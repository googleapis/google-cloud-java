/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.conversions.v1beta.stub;

import static com.google.shopping.merchant.conversions.v1beta.ConversionSourcesServiceClient.ListConversionSourcesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.conversions.v1beta.ConversionSource;
import com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest;
import com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse;
import com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConversionSourcesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ConversionSourcesServiceStub implements BackgroundResource {

  public UnaryCallable<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversionSourceCallable()");
  }

  public UnaryCallable<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConversionSourceCallable()");
  }

  public UnaryCallable<DeleteConversionSourceRequest, Empty> deleteConversionSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConversionSourceCallable()");
  }

  public UnaryCallable<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: undeleteConversionSourceCallable()");
  }

  public UnaryCallable<GetConversionSourceRequest, ConversionSource> getConversionSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversionSourceCallable()");
  }

  public UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesPagedResponse>
      listConversionSourcesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConversionSourcesPagedCallable()");
  }

  public UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesResponse>
      listConversionSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversionSourcesCallable()");
  }

  @Override
  public abstract void close();
}
