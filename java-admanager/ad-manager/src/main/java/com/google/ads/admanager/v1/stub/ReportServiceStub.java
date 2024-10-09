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

import static com.google.ads.admanager.v1.ReportServiceClient.FetchReportResultRowsPagedResponse;
import static com.google.ads.admanager.v1.ReportServiceClient.ListReportsPagedResponse;

import com.google.ads.admanager.v1.CreateReportRequest;
import com.google.ads.admanager.v1.FetchReportResultRowsRequest;
import com.google.ads.admanager.v1.FetchReportResultRowsResponse;
import com.google.ads.admanager.v1.GetReportRequest;
import com.google.ads.admanager.v1.ListReportsRequest;
import com.google.ads.admanager.v1.ListReportsResponse;
import com.google.ads.admanager.v1.Report;
import com.google.ads.admanager.v1.RunReportMetadata;
import com.google.ads.admanager.v1.RunReportRequest;
import com.google.ads.admanager.v1.RunReportResponse;
import com.google.ads.admanager.v1.UpdateReportRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.stub.OperationsStub;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ReportService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ReportServiceStub implements BackgroundResource {

  public OperationsStub getHttpJsonOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getHttpJsonOperationsStub()");
  }

  public UnaryCallable<GetReportRequest, Report> getReportCallable() {
    throw new UnsupportedOperationException("Not implemented: getReportCallable()");
  }

  public UnaryCallable<ListReportsRequest, ListReportsPagedResponse> listReportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportsPagedCallable()");
  }

  public UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportsCallable()");
  }

  public UnaryCallable<CreateReportRequest, Report> createReportCallable() {
    throw new UnsupportedOperationException("Not implemented: createReportCallable()");
  }

  public UnaryCallable<UpdateReportRequest, Report> updateReportCallable() {
    throw new UnsupportedOperationException("Not implemented: updateReportCallable()");
  }

  public OperationCallable<RunReportRequest, RunReportResponse, RunReportMetadata>
      runReportOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: runReportOperationCallable()");
  }

  public UnaryCallable<RunReportRequest, Operation> runReportCallable() {
    throw new UnsupportedOperationException("Not implemented: runReportCallable()");
  }

  public UnaryCallable<FetchReportResultRowsRequest, FetchReportResultRowsPagedResponse>
      fetchReportResultRowsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchReportResultRowsPagedCallable()");
  }

  public UnaryCallable<FetchReportResultRowsRequest, FetchReportResultRowsResponse>
      fetchReportResultRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchReportResultRowsCallable()");
  }

  @Override
  public abstract void close();
}
