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

import com.google.ads.admanager.v1.RunAvailabilityForecastRequest;
import com.google.ads.admanager.v1.RunAvailabilityForecastResponse;
import com.google.ads.admanager.v1.RunDeliveryForecastRequest;
import com.google.ads.admanager.v1.RunDeliveryForecastResponse;
import com.google.ads.admanager.v1.RunTrafficDataRequest;
import com.google.ads.admanager.v1.RunTrafficDataResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ForecastService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class ForecastServiceStub implements BackgroundResource {

  public UnaryCallable<RunAvailabilityForecastRequest, RunAvailabilityForecastResponse>
      runAvailabilityForecastCallable() {
    throw new UnsupportedOperationException("Not implemented: runAvailabilityForecastCallable()");
  }

  public UnaryCallable<RunDeliveryForecastRequest, RunDeliveryForecastResponse>
      runDeliveryForecastCallable() {
    throw new UnsupportedOperationException("Not implemented: runDeliveryForecastCallable()");
  }

  public UnaryCallable<RunTrafficDataRequest, RunTrafficDataResponse> runTrafficDataCallable() {
    throw new UnsupportedOperationException("Not implemented: runTrafficDataCallable()");
  }

  @Override
  public abstract void close();
}
