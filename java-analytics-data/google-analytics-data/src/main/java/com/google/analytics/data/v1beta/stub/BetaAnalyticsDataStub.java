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

package com.google.analytics.data.v1beta.stub;

import static com.google.analytics.data.v1beta.BetaAnalyticsDataClient.ListAudienceExportsPagedResponse;

import com.google.analytics.data.v1beta.AudienceExport;
import com.google.analytics.data.v1beta.AudienceExportMetadata;
import com.google.analytics.data.v1beta.BatchRunPivotReportsRequest;
import com.google.analytics.data.v1beta.BatchRunPivotReportsResponse;
import com.google.analytics.data.v1beta.BatchRunReportsRequest;
import com.google.analytics.data.v1beta.BatchRunReportsResponse;
import com.google.analytics.data.v1beta.CheckCompatibilityRequest;
import com.google.analytics.data.v1beta.CheckCompatibilityResponse;
import com.google.analytics.data.v1beta.CreateAudienceExportRequest;
import com.google.analytics.data.v1beta.GetAudienceExportRequest;
import com.google.analytics.data.v1beta.GetMetadataRequest;
import com.google.analytics.data.v1beta.ListAudienceExportsRequest;
import com.google.analytics.data.v1beta.ListAudienceExportsResponse;
import com.google.analytics.data.v1beta.Metadata;
import com.google.analytics.data.v1beta.QueryAudienceExportRequest;
import com.google.analytics.data.v1beta.QueryAudienceExportResponse;
import com.google.analytics.data.v1beta.RunPivotReportRequest;
import com.google.analytics.data.v1beta.RunPivotReportResponse;
import com.google.analytics.data.v1beta.RunRealtimeReportRequest;
import com.google.analytics.data.v1beta.RunRealtimeReportResponse;
import com.google.analytics.data.v1beta.RunReportRequest;
import com.google.analytics.data.v1beta.RunReportResponse;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
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

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

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

  public OperationCallable<CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
      createAudienceExportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAudienceExportOperationCallable()");
  }

  public UnaryCallable<CreateAudienceExportRequest, Operation> createAudienceExportCallable() {
    throw new UnsupportedOperationException("Not implemented: createAudienceExportCallable()");
  }

  public UnaryCallable<QueryAudienceExportRequest, QueryAudienceExportResponse>
      queryAudienceExportCallable() {
    throw new UnsupportedOperationException("Not implemented: queryAudienceExportCallable()");
  }

  public UnaryCallable<GetAudienceExportRequest, AudienceExport> getAudienceExportCallable() {
    throw new UnsupportedOperationException("Not implemented: getAudienceExportCallable()");
  }

  public UnaryCallable<ListAudienceExportsRequest, ListAudienceExportsPagedResponse>
      listAudienceExportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAudienceExportsPagedCallable()");
  }

  public UnaryCallable<ListAudienceExportsRequest, ListAudienceExportsResponse>
      listAudienceExportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAudienceExportsCallable()");
  }

  @Override
  public abstract void close();
}
