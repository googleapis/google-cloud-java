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

package com.google.cloud.notebooks.v1.stub;

import static com.google.cloud.notebooks.v1.ManagedNotebookServiceClient.ListRuntimesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.notebooks.v1.CreateRuntimeRequest;
import com.google.cloud.notebooks.v1.DeleteRuntimeRequest;
import com.google.cloud.notebooks.v1.GetRuntimeRequest;
import com.google.cloud.notebooks.v1.ListRuntimesRequest;
import com.google.cloud.notebooks.v1.ListRuntimesResponse;
import com.google.cloud.notebooks.v1.OperationMetadata;
import com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalRequest;
import com.google.cloud.notebooks.v1.RefreshRuntimeTokenInternalResponse;
import com.google.cloud.notebooks.v1.ReportRuntimeEventRequest;
import com.google.cloud.notebooks.v1.ResetRuntimeRequest;
import com.google.cloud.notebooks.v1.Runtime;
import com.google.cloud.notebooks.v1.StartRuntimeRequest;
import com.google.cloud.notebooks.v1.StopRuntimeRequest;
import com.google.cloud.notebooks.v1.SwitchRuntimeRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ManagedNotebookService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ManagedNotebookServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListRuntimesRequest, ListRuntimesPagedResponse> listRuntimesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuntimesPagedCallable()");
  }

  public UnaryCallable<ListRuntimesRequest, ListRuntimesResponse> listRuntimesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRuntimesCallable()");
  }

  public UnaryCallable<GetRuntimeRequest, Runtime> getRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: getRuntimeCallable()");
  }

  public OperationCallable<CreateRuntimeRequest, Runtime, OperationMetadata>
      createRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createRuntimeOperationCallable()");
  }

  public UnaryCallable<CreateRuntimeRequest, Operation> createRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: createRuntimeCallable()");
  }

  public OperationCallable<DeleteRuntimeRequest, Empty, OperationMetadata>
      deleteRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRuntimeOperationCallable()");
  }

  public UnaryCallable<DeleteRuntimeRequest, Operation> deleteRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRuntimeCallable()");
  }

  public OperationCallable<StartRuntimeRequest, Runtime, OperationMetadata>
      startRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startRuntimeOperationCallable()");
  }

  public UnaryCallable<StartRuntimeRequest, Operation> startRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: startRuntimeCallable()");
  }

  public OperationCallable<StopRuntimeRequest, Runtime, OperationMetadata>
      stopRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopRuntimeOperationCallable()");
  }

  public UnaryCallable<StopRuntimeRequest, Operation> stopRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: stopRuntimeCallable()");
  }

  public OperationCallable<SwitchRuntimeRequest, Runtime, OperationMetadata>
      switchRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: switchRuntimeOperationCallable()");
  }

  public UnaryCallable<SwitchRuntimeRequest, Operation> switchRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: switchRuntimeCallable()");
  }

  public OperationCallable<ResetRuntimeRequest, Runtime, OperationMetadata>
      resetRuntimeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resetRuntimeOperationCallable()");
  }

  public UnaryCallable<ResetRuntimeRequest, Operation> resetRuntimeCallable() {
    throw new UnsupportedOperationException("Not implemented: resetRuntimeCallable()");
  }

  public OperationCallable<ReportRuntimeEventRequest, Runtime, OperationMetadata>
      reportRuntimeEventOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: reportRuntimeEventOperationCallable()");
  }

  public UnaryCallable<ReportRuntimeEventRequest, Operation> reportRuntimeEventCallable() {
    throw new UnsupportedOperationException("Not implemented: reportRuntimeEventCallable()");
  }

  public UnaryCallable<RefreshRuntimeTokenInternalRequest, RefreshRuntimeTokenInternalResponse>
      refreshRuntimeTokenInternalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: refreshRuntimeTokenInternalCallable()");
  }

  @Override
  public abstract void close();
}
