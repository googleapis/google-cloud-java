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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.PlacementServiceClient.ListPlacementsPagedResponse;

import com.google.ads.admanager.v1.GetPlacementRequest;
import com.google.ads.admanager.v1.ListPlacementsRequest;
import com.google.ads.admanager.v1.ListPlacementsResponse;
import com.google.ads.admanager.v1.Placement;
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

  @Override
  public abstract void close();
}
