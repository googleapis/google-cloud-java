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

import static com.google.ads.admanager.v1.PlacementServiceClient.ListPlacementsPagedResponse;

import com.google.ads.admanager.v1.BatchActivatePlacementsRequest;
import com.google.ads.admanager.v1.BatchActivatePlacementsResponse;
import com.google.ads.admanager.v1.BatchArchivePlacementsRequest;
import com.google.ads.admanager.v1.BatchArchivePlacementsResponse;
import com.google.ads.admanager.v1.BatchCreatePlacementsRequest;
import com.google.ads.admanager.v1.BatchCreatePlacementsResponse;
import com.google.ads.admanager.v1.BatchDeactivatePlacementsRequest;
import com.google.ads.admanager.v1.BatchDeactivatePlacementsResponse;
import com.google.ads.admanager.v1.BatchUpdatePlacementsRequest;
import com.google.ads.admanager.v1.BatchUpdatePlacementsResponse;
import com.google.ads.admanager.v1.CreatePlacementRequest;
import com.google.ads.admanager.v1.GetPlacementRequest;
import com.google.ads.admanager.v1.ListPlacementsRequest;
import com.google.ads.admanager.v1.ListPlacementsResponse;
import com.google.ads.admanager.v1.Placement;
import com.google.ads.admanager.v1.UpdatePlacementRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PlacementService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PlacementServiceStub implements BackgroundResource {

  public UnaryCallable<GetPlacementRequest, Placement> getPlacementCallable() {
    throw new UnsupportedOperationException("Not implemented: getPlacementCallable()");
  }

  public UnaryCallable<ListPlacementsRequest, ListPlacementsPagedResponse>
      listPlacementsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPlacementsPagedCallable()");
  }

  public UnaryCallable<ListPlacementsRequest, ListPlacementsResponse> listPlacementsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPlacementsCallable()");
  }

  public UnaryCallable<CreatePlacementRequest, Placement> createPlacementCallable() {
    throw new UnsupportedOperationException("Not implemented: createPlacementCallable()");
  }

  public UnaryCallable<UpdatePlacementRequest, Placement> updatePlacementCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePlacementCallable()");
  }

  public UnaryCallable<BatchCreatePlacementsRequest, BatchCreatePlacementsResponse>
      batchCreatePlacementsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreatePlacementsCallable()");
  }

  public UnaryCallable<BatchUpdatePlacementsRequest, BatchUpdatePlacementsResponse>
      batchUpdatePlacementsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdatePlacementsCallable()");
  }

  public UnaryCallable<BatchActivatePlacementsRequest, BatchActivatePlacementsResponse>
      batchActivatePlacementsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchActivatePlacementsCallable()");
  }

  public UnaryCallable<BatchDeactivatePlacementsRequest, BatchDeactivatePlacementsResponse>
      batchDeactivatePlacementsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeactivatePlacementsCallable()");
  }

  public UnaryCallable<BatchArchivePlacementsRequest, BatchArchivePlacementsResponse>
      batchArchivePlacementsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchivePlacementsCallable()");
  }

  @Override
  public abstract void close();
}
