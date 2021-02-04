/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.MetricsClient.ListLogMetricsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.logging.v2.CreateLogMetricRequest;
import com.google.logging.v2.DeleteLogMetricRequest;
import com.google.logging.v2.GetLogMetricRequest;
import com.google.logging.v2.ListLogMetricsRequest;
import com.google.logging.v2.ListLogMetricsResponse;
import com.google.logging.v2.LogMetric;
import com.google.logging.v2.UpdateLogMetricRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MetricsServiceV2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class MetricsServiceV2Stub implements BackgroundResource {

  public UnaryCallable<ListLogMetricsRequest, ListLogMetricsPagedResponse>
      listLogMetricsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogMetricsPagedCallable()");
  }

  public UnaryCallable<ListLogMetricsRequest, ListLogMetricsResponse> listLogMetricsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLogMetricsCallable()");
  }

  public UnaryCallable<GetLogMetricRequest, LogMetric> getLogMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: getLogMetricCallable()");
  }

  public UnaryCallable<CreateLogMetricRequest, LogMetric> createLogMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: createLogMetricCallable()");
  }

  public UnaryCallable<UpdateLogMetricRequest, LogMetric> updateLogMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: updateLogMetricCallable()");
  }

  public UnaryCallable<DeleteLogMetricRequest, Empty> deleteLogMetricCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLogMetricCallable()");
  }

  @Override
  public abstract void close();
}
