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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.AdUnitServiceClient.ListAdUnitSizesPagedResponse;
import static com.google.ads.admanager.v1.AdUnitServiceClient.ListAdUnitsPagedResponse;

import com.google.ads.admanager.v1.AdUnit;
import com.google.ads.admanager.v1.BatchActivateAdUnitsRequest;
import com.google.ads.admanager.v1.BatchActivateAdUnitsResponse;
import com.google.ads.admanager.v1.BatchArchiveAdUnitsRequest;
import com.google.ads.admanager.v1.BatchArchiveAdUnitsResponse;
import com.google.ads.admanager.v1.BatchCreateAdUnitsRequest;
import com.google.ads.admanager.v1.BatchCreateAdUnitsResponse;
import com.google.ads.admanager.v1.BatchDeactivateAdUnitsRequest;
import com.google.ads.admanager.v1.BatchDeactivateAdUnitsResponse;
import com.google.ads.admanager.v1.BatchUpdateAdUnitsRequest;
import com.google.ads.admanager.v1.BatchUpdateAdUnitsResponse;
import com.google.ads.admanager.v1.CreateAdUnitRequest;
import com.google.ads.admanager.v1.GetAdUnitRequest;
import com.google.ads.admanager.v1.ListAdUnitSizesRequest;
import com.google.ads.admanager.v1.ListAdUnitSizesResponse;
import com.google.ads.admanager.v1.ListAdUnitsRequest;
import com.google.ads.admanager.v1.ListAdUnitsResponse;
import com.google.ads.admanager.v1.UpdateAdUnitRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AdUnitService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AdUnitServiceStub implements BackgroundResource {

  public UnaryCallable<GetAdUnitRequest, AdUnit> getAdUnitCallable() {
    throw new UnsupportedOperationException("Not implemented: getAdUnitCallable()");
  }

  public UnaryCallable<ListAdUnitsRequest, ListAdUnitsPagedResponse> listAdUnitsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdUnitsPagedCallable()");
  }

  public UnaryCallable<ListAdUnitsRequest, ListAdUnitsResponse> listAdUnitsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdUnitsCallable()");
  }

  public UnaryCallable<ListAdUnitSizesRequest, ListAdUnitSizesPagedResponse>
      listAdUnitSizesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdUnitSizesPagedCallable()");
  }

  public UnaryCallable<ListAdUnitSizesRequest, ListAdUnitSizesResponse> listAdUnitSizesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAdUnitSizesCallable()");
  }

  public UnaryCallable<CreateAdUnitRequest, AdUnit> createAdUnitCallable() {
    throw new UnsupportedOperationException("Not implemented: createAdUnitCallable()");
  }

  public UnaryCallable<UpdateAdUnitRequest, AdUnit> updateAdUnitCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAdUnitCallable()");
  }

  public UnaryCallable<BatchCreateAdUnitsRequest, BatchCreateAdUnitsResponse>
      batchCreateAdUnitsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateAdUnitsCallable()");
  }

  public UnaryCallable<BatchUpdateAdUnitsRequest, BatchUpdateAdUnitsResponse>
      batchUpdateAdUnitsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateAdUnitsCallable()");
  }

  public UnaryCallable<BatchActivateAdUnitsRequest, BatchActivateAdUnitsResponse>
      batchActivateAdUnitsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivateAdUnitsCallable()");
  }

  public UnaryCallable<BatchDeactivateAdUnitsRequest, BatchDeactivateAdUnitsResponse>
      batchDeactivateAdUnitsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeactivateAdUnitsCallable()");
  }

  public UnaryCallable<BatchArchiveAdUnitsRequest, BatchArchiveAdUnitsResponse>
      batchArchiveAdUnitsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchiveAdUnitsCallable()");
  }

  @Override
  public abstract void close();
}
