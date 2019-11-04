/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionUrlMapClient.ListRegionUrlMapsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.GetRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.InsertRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.ListRegionUrlMapsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.UpdateRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapList;
import com.google.cloud.compute.v1.UrlMapsValidateResponse;
import com.google.cloud.compute.v1.ValidateRegionUrlMapHttpRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionUrlMapStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteRegionUrlMapHttpRequest, Operation> deleteRegionUrlMapCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRegionUrlMapCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionUrlMapCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionUrlMapHttpRequest, Operation> insertRegionUrlMapCallable() {
    throw new UnsupportedOperationException("Not implemented: insertRegionUrlMapCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionUrlMapsHttpRequest, ListRegionUrlMapsPagedResponse>
      listRegionUrlMapsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionUrlMapsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionUrlMapsHttpRequest, UrlMapList> listRegionUrlMapsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionUrlMapsCallable()");
  }

  @BetaApi
  public UnaryCallable<PatchRegionUrlMapHttpRequest, Operation> patchRegionUrlMapCallable() {
    throw new UnsupportedOperationException("Not implemented: patchRegionUrlMapCallable()");
  }

  @BetaApi
  public UnaryCallable<UpdateRegionUrlMapHttpRequest, Operation> updateRegionUrlMapCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRegionUrlMapCallable()");
  }

  @BetaApi
  public UnaryCallable<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
      validateRegionUrlMapCallable() {
    throw new UnsupportedOperationException("Not implemented: validateRegionUrlMapCallable()");
  }

  @Override
  public abstract void close();
}
