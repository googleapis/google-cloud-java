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

package com.google.analytics.data.v1alpha.stub;

import com.google.analytics.data.v1alpha.BatchRunPivotReportsRequest;
import com.google.analytics.data.v1alpha.BatchRunPivotReportsResponse;
import com.google.analytics.data.v1alpha.BatchRunReportsRequest;
import com.google.analytics.data.v1alpha.BatchRunReportsResponse;
import com.google.analytics.data.v1alpha.GetMetadataRequest;
import com.google.analytics.data.v1alpha.Metadata;
import com.google.analytics.data.v1alpha.RunPivotReportRequest;
import com.google.analytics.data.v1alpha.RunPivotReportResponse;
import com.google.analytics.data.v1alpha.RunRealtimeReportRequest;
import com.google.analytics.data.v1alpha.RunRealtimeReportResponse;
import com.google.analytics.data.v1alpha.RunReportRequest;
import com.google.analytics.data.v1alpha.RunReportResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AlphaAnalyticsData service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class AlphaAnalyticsDataStub implements BackgroundResource {

  public UnaryCallable<RunReportRequest, RunReportResponse> runReportCallable() {
    throw new UnsupportedOperationException("Not implemented: runReportCallable()");
  }

  public UnaryCallable<RunPivotReportRequest, RunPivotReportResponse> runPivotReportCallable() {
    throw new UnsupportedOperationException("Not implemented: runPivotReportCallable()");
  }

  public UnaryCallable<BatchRunReportsRequest, BatchRunReportsResponse> batchRunReportsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchRunReportsCallable()");
  }

  public UnaryCallable<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchRunPivotReportsCallable()");
  }

  public UnaryCallable<GetMetadataRequest, Metadata> getMetadataCallable() {
    throw new UnsupportedOperationException("Not implemented: getMetadataCallable()");
  }

  public UnaryCallable<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportCallable() {
    throw new UnsupportedOperationException("Not implemented: runRealtimeReportCallable()");
  }

  @Override
  public abstract void close();
}
