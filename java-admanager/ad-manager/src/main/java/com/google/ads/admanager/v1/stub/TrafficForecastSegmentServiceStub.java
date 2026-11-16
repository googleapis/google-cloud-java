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

import static com.google.ads.admanager.v1.TrafficForecastSegmentServiceClient.ListTrafficForecastSegmentsPagedResponse;

import com.google.ads.admanager.v1.BatchCreateTrafficForecastSegmentsRequest;
import com.google.ads.admanager.v1.BatchCreateTrafficForecastSegmentsResponse;
import com.google.ads.admanager.v1.BatchUpdateTrafficForecastSegmentsRequest;
import com.google.ads.admanager.v1.BatchUpdateTrafficForecastSegmentsResponse;
import com.google.ads.admanager.v1.CreateTrafficForecastSegmentRequest;
import com.google.ads.admanager.v1.GetTrafficForecastSegmentRequest;
import com.google.ads.admanager.v1.ListTrafficForecastSegmentsRequest;
import com.google.ads.admanager.v1.ListTrafficForecastSegmentsResponse;
import com.google.ads.admanager.v1.TrafficForecastSegment;
import com.google.ads.admanager.v1.UpdateTrafficForecastSegmentRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TrafficForecastSegmentService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class TrafficForecastSegmentServiceStub implements BackgroundResource {

  public UnaryCallable<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
      getTrafficForecastSegmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getTrafficForecastSegmentCallable()");
  }

  public UnaryCallable<ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsPagedResponse>
      listTrafficForecastSegmentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTrafficForecastSegmentsPagedCallable()");
  }

  public UnaryCallable<ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsResponse>
      listTrafficForecastSegmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listTrafficForecastSegmentsCallable()");
  }

  public UnaryCallable<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
      createTrafficForecastSegmentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createTrafficForecastSegmentCallable()");
  }

  public UnaryCallable<
          BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
      batchCreateTrafficForecastSegmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateTrafficForecastSegmentsCallable()");
  }

  public UnaryCallable<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
      updateTrafficForecastSegmentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateTrafficForecastSegmentCallable()");
  }

  public UnaryCallable<
          BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
      batchUpdateTrafficForecastSegmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateTrafficForecastSegmentsCallable()");
  }

  @Override
  public abstract void close();
}
