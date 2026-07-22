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

import static com.google.ads.admanager.v1.SuggestedAdUnitServiceClient.ListSuggestedAdUnitsPagedResponse;

import com.google.ads.admanager.v1.BatchApproveSuggestedAdUnitsRequest;
import com.google.ads.admanager.v1.BatchApproveSuggestedAdUnitsResponse;
import com.google.ads.admanager.v1.GetSuggestedAdUnitRequest;
import com.google.ads.admanager.v1.ListSuggestedAdUnitsRequest;
import com.google.ads.admanager.v1.ListSuggestedAdUnitsResponse;
import com.google.ads.admanager.v1.SuggestedAdUnit;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SuggestedAdUnitService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class SuggestedAdUnitServiceStub implements BackgroundResource {

  public UnaryCallable<GetSuggestedAdUnitRequest, SuggestedAdUnit> getSuggestedAdUnitCallable() {
    throw new UnsupportedOperationException("Not implemented: getSuggestedAdUnitCallable()");
  }

  public UnaryCallable<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsPagedResponse>
      listSuggestedAdUnitsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSuggestedAdUnitsPagedCallable()");
  }

  public UnaryCallable<ListSuggestedAdUnitsRequest, ListSuggestedAdUnitsResponse>
      listSuggestedAdUnitsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSuggestedAdUnitsCallable()");
  }

  public UnaryCallable<BatchApproveSuggestedAdUnitsRequest, BatchApproveSuggestedAdUnitsResponse>
      batchApproveSuggestedAdUnitsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchApproveSuggestedAdUnitsCallable()");
  }

  @Override
  public abstract void close();
}
