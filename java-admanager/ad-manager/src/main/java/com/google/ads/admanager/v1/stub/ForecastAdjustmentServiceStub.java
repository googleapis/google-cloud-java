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

import static com.google.ads.admanager.v1.ForecastAdjustmentServiceClient.ListForecastAdjustmentsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchActivateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.BatchCreateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchCreateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.BatchDeactivateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchDeactivateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.BatchUpdateForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.BatchUpdateForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.CalculateDailyAdOpportunityCountsRequest;
import com.google.ads.admanager.v1.CalculateDailyAdOpportunityCountsResponse;
import com.google.ads.admanager.v1.CreateForecastAdjustmentRequest;
import com.google.ads.admanager.v1.ForecastAdjustment;
import com.google.ads.admanager.v1.GetForecastAdjustmentRequest;
import com.google.ads.admanager.v1.ListForecastAdjustmentsRequest;
import com.google.ads.admanager.v1.ListForecastAdjustmentsResponse;
import com.google.ads.admanager.v1.UpdateForecastAdjustmentRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ForecastAdjustmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class ForecastAdjustmentServiceStub implements BackgroundResource {

  public UnaryCallable<GetForecastAdjustmentRequest, ForecastAdjustment>
      getForecastAdjustmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getForecastAdjustmentCallable()");
  }

  public UnaryCallable<ListForecastAdjustmentsRequest, ListForecastAdjustmentsPagedResponse>
      listForecastAdjustmentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listForecastAdjustmentsPagedCallable()");
  }

  public UnaryCallable<ListForecastAdjustmentsRequest, ListForecastAdjustmentsResponse>
      listForecastAdjustmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listForecastAdjustmentsCallable()");
  }

  public UnaryCallable<CreateForecastAdjustmentRequest, ForecastAdjustment>
      createForecastAdjustmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createForecastAdjustmentCallable()");
  }

  public UnaryCallable<
          BatchCreateForecastAdjustmentsRequest, BatchCreateForecastAdjustmentsResponse>
      batchCreateForecastAdjustmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateForecastAdjustmentsCallable()");
  }

  public UnaryCallable<
          BatchActivateForecastAdjustmentsRequest, BatchActivateForecastAdjustmentsResponse>
      batchActivateForecastAdjustmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchActivateForecastAdjustmentsCallable()");
  }

  public UnaryCallable<
          BatchDeactivateForecastAdjustmentsRequest, BatchDeactivateForecastAdjustmentsResponse>
      batchDeactivateForecastAdjustmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeactivateForecastAdjustmentsCallable()");
  }

  public UnaryCallable<UpdateForecastAdjustmentRequest, ForecastAdjustment>
      updateForecastAdjustmentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateForecastAdjustmentCallable()");
  }

  public UnaryCallable<
          BatchUpdateForecastAdjustmentsRequest, BatchUpdateForecastAdjustmentsResponse>
      batchUpdateForecastAdjustmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateForecastAdjustmentsCallable()");
  }

  public UnaryCallable<
          CalculateDailyAdOpportunityCountsRequest, CalculateDailyAdOpportunityCountsResponse>
      calculateDailyAdOpportunityCountsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: calculateDailyAdOpportunityCountsCallable()");
  }

  @Override
  public abstract void close();
}
