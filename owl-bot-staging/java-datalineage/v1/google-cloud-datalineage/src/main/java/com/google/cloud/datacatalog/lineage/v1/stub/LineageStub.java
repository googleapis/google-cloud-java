/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.datacatalog.lineage.v1.stub;

import static com.google.cloud.datacatalog.lineage.v1.LineageClient.BatchSearchLinkProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListLineageEventsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListRunsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.SearchLinksPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest;
import com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse;
import com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.CreateRunRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest;
import com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.GetProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.GetRunRequest;
import com.google.cloud.datacatalog.lineage.v1.LineageEvent;
import com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest;
import com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse;
import com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest;
import com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse;
import com.google.cloud.datacatalog.lineage.v1.ListRunsRequest;
import com.google.cloud.datacatalog.lineage.v1.ListRunsResponse;
import com.google.cloud.datacatalog.lineage.v1.OperationMetadata;
import com.google.cloud.datacatalog.lineage.v1.Process;
import com.google.cloud.datacatalog.lineage.v1.ProcessOpenLineageRunEventRequest;
import com.google.cloud.datacatalog.lineage.v1.ProcessOpenLineageRunEventResponse;
import com.google.cloud.datacatalog.lineage.v1.Run;
import com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest;
import com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse;
import com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Lineage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class LineageStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: processOpenLineageRunEventCallable()");
  }

  public UnaryCallable<CreateProcessRequest, Process> createProcessCallable() {
    throw new UnsupportedOperationException("Not implemented: createProcessCallable()");
  }

  public UnaryCallable<UpdateProcessRequest, Process> updateProcessCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProcessCallable()");
  }

  public UnaryCallable<GetProcessRequest, Process> getProcessCallable() {
    throw new UnsupportedOperationException("Not implemented: getProcessCallable()");
  }

  public UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessesPagedCallable()");
  }

  public UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable() {
    throw new UnsupportedOperationException("Not implemented: listProcessesCallable()");
  }

  public OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProcessOperationCallable()");
  }

  public UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteProcessCallable()");
  }

  public UnaryCallable<CreateRunRequest, Run> createRunCallable() {
    throw new UnsupportedOperationException("Not implemented: createRunCallable()");
  }

  public UnaryCallable<UpdateRunRequest, Run> updateRunCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRunCallable()");
  }

  public UnaryCallable<GetRunRequest, Run> getRunCallable() {
    throw new UnsupportedOperationException("Not implemented: getRunCallable()");
  }

  public UnaryCallable<ListRunsRequest, ListRunsPagedResponse> listRunsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRunsPagedCallable()");
  }

  public UnaryCallable<ListRunsRequest, ListRunsResponse> listRunsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRunsCallable()");
  }

  public OperationCallable<DeleteRunRequest, Empty, OperationMetadata>
      deleteRunOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRunOperationCallable()");
  }

  public UnaryCallable<DeleteRunRequest, Operation> deleteRunCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRunCallable()");
  }

  public UnaryCallable<CreateLineageEventRequest, LineageEvent> createLineageEventCallable() {
    throw new UnsupportedOperationException("Not implemented: createLineageEventCallable()");
  }

  public UnaryCallable<GetLineageEventRequest, LineageEvent> getLineageEventCallable() {
    throw new UnsupportedOperationException("Not implemented: getLineageEventCallable()");
  }

  public UnaryCallable<ListLineageEventsRequest, ListLineageEventsPagedResponse>
      listLineageEventsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLineageEventsPagedCallable()");
  }

  public UnaryCallable<ListLineageEventsRequest, ListLineageEventsResponse>
      listLineageEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLineageEventsCallable()");
  }

  public UnaryCallable<DeleteLineageEventRequest, Empty> deleteLineageEventCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteLineageEventCallable()");
  }

  public UnaryCallable<SearchLinksRequest, SearchLinksPagedResponse> searchLinksPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchLinksPagedCallable()");
  }

  public UnaryCallable<SearchLinksRequest, SearchLinksResponse> searchLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: searchLinksCallable()");
  }

  public UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesPagedResponse>
      batchSearchLinkProcessesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchSearchLinkProcessesPagedCallable()");
  }

  public UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
      batchSearchLinkProcessesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchSearchLinkProcessesCallable()");
  }

  @Override
  public abstract void close();
}
