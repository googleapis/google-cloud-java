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

package com.google.analytics.data.v1alpha.stub;

import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListRecurringAudienceListsPagedResponse;
import static com.google.analytics.data.v1alpha.AlphaAnalyticsDataClient.ListReportTasksPagedResponse;

import com.google.analytics.data.v1alpha.AudienceList;
import com.google.analytics.data.v1alpha.AudienceListMetadata;
import com.google.analytics.data.v1alpha.CreateAudienceListRequest;
import com.google.analytics.data.v1alpha.CreateRecurringAudienceListRequest;
import com.google.analytics.data.v1alpha.CreateReportTaskRequest;
import com.google.analytics.data.v1alpha.GetAudienceListRequest;
import com.google.analytics.data.v1alpha.GetRecurringAudienceListRequest;
import com.google.analytics.data.v1alpha.GetReportTaskRequest;
import com.google.analytics.data.v1alpha.ListAudienceListsRequest;
import com.google.analytics.data.v1alpha.ListAudienceListsResponse;
import com.google.analytics.data.v1alpha.ListRecurringAudienceListsRequest;
import com.google.analytics.data.v1alpha.ListRecurringAudienceListsResponse;
import com.google.analytics.data.v1alpha.ListReportTasksRequest;
import com.google.analytics.data.v1alpha.ListReportTasksResponse;
import com.google.analytics.data.v1alpha.QueryAudienceListRequest;
import com.google.analytics.data.v1alpha.QueryAudienceListResponse;
import com.google.analytics.data.v1alpha.QueryReportTaskRequest;
import com.google.analytics.data.v1alpha.QueryReportTaskResponse;
import com.google.analytics.data.v1alpha.RecurringAudienceList;
import com.google.analytics.data.v1alpha.ReportTask;
import com.google.analytics.data.v1alpha.ReportTaskMetadata;
import com.google.analytics.data.v1alpha.RunFunnelReportRequest;
import com.google.analytics.data.v1alpha.RunFunnelReportResponse;
import com.google.analytics.data.v1alpha.SheetExportAudienceListRequest;
import com.google.analytics.data.v1alpha.SheetExportAudienceListResponse;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AlphaAnalyticsData service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AlphaAnalyticsDataStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<RunFunnelReportRequest, RunFunnelReportResponse> runFunnelReportCallable() {
    throw new UnsupportedOperationException("Not implemented: runFunnelReportCallable()");
  }

  public OperationCallable<CreateAudienceListRequest, AudienceList, AudienceListMetadata>
      createAudienceListOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAudienceListOperationCallable()");
  }

  public UnaryCallable<CreateAudienceListRequest, Operation> createAudienceListCallable() {
    throw new UnsupportedOperationException("Not implemented: createAudienceListCallable()");
  }

  public UnaryCallable<QueryAudienceListRequest, QueryAudienceListResponse>
      queryAudienceListCallable() {
    throw new UnsupportedOperationException("Not implemented: queryAudienceListCallable()");
  }

  public UnaryCallable<SheetExportAudienceListRequest, SheetExportAudienceListResponse>
      sheetExportAudienceListCallable() {
    throw new UnsupportedOperationException("Not implemented: sheetExportAudienceListCallable()");
  }

  public UnaryCallable<GetAudienceListRequest, AudienceList> getAudienceListCallable() {
    throw new UnsupportedOperationException("Not implemented: getAudienceListCallable()");
  }

  public UnaryCallable<ListAudienceListsRequest, ListAudienceListsPagedResponse>
      listAudienceListsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAudienceListsPagedCallable()");
  }

  public UnaryCallable<ListAudienceListsRequest, ListAudienceListsResponse>
      listAudienceListsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAudienceListsCallable()");
  }

  public UnaryCallable<CreateRecurringAudienceListRequest, RecurringAudienceList>
      createRecurringAudienceListCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createRecurringAudienceListCallable()");
  }

  public UnaryCallable<GetRecurringAudienceListRequest, RecurringAudienceList>
      getRecurringAudienceListCallable() {
    throw new UnsupportedOperationException("Not implemented: getRecurringAudienceListCallable()");
  }

  public UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsPagedResponse>
      listRecurringAudienceListsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRecurringAudienceListsPagedCallable()");
  }

  public UnaryCallable<ListRecurringAudienceListsRequest, ListRecurringAudienceListsResponse>
      listRecurringAudienceListsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRecurringAudienceListsCallable()");
  }

  public OperationCallable<CreateReportTaskRequest, ReportTask, ReportTaskMetadata>
      createReportTaskOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createReportTaskOperationCallable()");
  }

  public UnaryCallable<CreateReportTaskRequest, Operation> createReportTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: createReportTaskCallable()");
  }

  public UnaryCallable<QueryReportTaskRequest, QueryReportTaskResponse> queryReportTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: queryReportTaskCallable()");
  }

  public UnaryCallable<GetReportTaskRequest, ReportTask> getReportTaskCallable() {
    throw new UnsupportedOperationException("Not implemented: getReportTaskCallable()");
  }

  public UnaryCallable<ListReportTasksRequest, ListReportTasksPagedResponse>
      listReportTasksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportTasksPagedCallable()");
  }

  public UnaryCallable<ListReportTasksRequest, ListReportTasksResponse> listReportTasksCallable() {
    throw new UnsupportedOperationException("Not implemented: listReportTasksCallable()");
  }

  @Override
  public abstract void close();
}
