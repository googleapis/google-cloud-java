/*
 * Copyright 2022 Google LLC
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

package com.google.analytics.data.v1beta.stub;

import com.google.analytics.data.v1beta.BatchRunPivotReportsRequest;
import com.google.analytics.data.v1beta.BatchRunPivotReportsResponse;
import com.google.analytics.data.v1beta.BatchRunReportsRequest;
import com.google.analytics.data.v1beta.BatchRunReportsResponse;
import com.google.analytics.data.v1beta.CheckCompatibilityRequest;
import com.google.analytics.data.v1beta.CheckCompatibilityResponse;
import com.google.analytics.data.v1beta.GetMetadataRequest;
import com.google.analytics.data.v1beta.Metadata;
import com.google.analytics.data.v1beta.RunPivotReportRequest;
import com.google.analytics.data.v1beta.RunPivotReportResponse;
import com.google.analytics.data.v1beta.RunRealtimeReportRequest;
import com.google.analytics.data.v1beta.RunRealtimeReportResponse;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BetaAnalyticsData service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class BetaAnalyticsDataStub implements BackgroundResource {

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

  public UnaryCallable<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilityCallable() {
    throw new UnsupportedOperationException("Not implemented: checkCompatibilityCallable()");
  }

  @Override
  public abstract void close();
}
