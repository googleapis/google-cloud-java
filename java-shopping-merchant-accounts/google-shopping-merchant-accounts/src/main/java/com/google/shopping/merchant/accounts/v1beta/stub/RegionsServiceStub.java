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

package com.google.shopping.merchant.accounts.v1beta.stub;

import static com.google.shopping.merchant.accounts.v1beta.RegionsServiceClient.ListRegionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1beta.CreateRegionRequest;
import com.google.shopping.merchant.accounts.v1beta.DeleteRegionRequest;
import com.google.shopping.merchant.accounts.v1beta.GetRegionRequest;
import com.google.shopping.merchant.accounts.v1beta.ListRegionsRequest;
import com.google.shopping.merchant.accounts.v1beta.ListRegionsResponse;
import com.google.shopping.merchant.accounts.v1beta.Region;
import com.google.shopping.merchant.accounts.v1beta.UpdateRegionRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class RegionsServiceStub implements BackgroundResource {

  public UnaryCallable<GetRegionRequest, Region> getRegionCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionCallable()");
  }

  public UnaryCallable<CreateRegionRequest, Region> createRegionCallable() {
    throw new UnsupportedOperationException("Not implemented: createRegionCallable()");
  }

  public UnaryCallable<UpdateRegionRequest, Region> updateRegionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRegionCallable()");
  }

  public UnaryCallable<DeleteRegionRequest, Empty> deleteRegionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRegionCallable()");
  }

  public UnaryCallable<ListRegionsRequest, ListRegionsPagedResponse> listRegionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionsPagedCallable()");
  }

  public UnaryCallable<ListRegionsRequest, ListRegionsResponse> listRegionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionsCallable()");
  }

  @Override
  public abstract void close();
}
