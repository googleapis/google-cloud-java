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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.EnvironmentsClient.LookupEnvironmentHistoryPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3.Environment;
import com.google.cloud.dialogflow.cx.v3.GetEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3.ListEnvironmentsRequest;
import com.google.cloud.dialogflow.cx.v3.ListEnvironmentsResponse;
import com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryRequest;
import com.google.cloud.dialogflow.cx.v3.LookupEnvironmentHistoryResponse;
import com.google.cloud.dialogflow.cx.v3.UpdateEnvironmentRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Environments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class EnvironmentsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsPagedResponse>
      listEnvironmentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnvironmentsPagedCallable()");
  }

  public UnaryCallable<ListEnvironmentsRequest, ListEnvironmentsResponse>
      listEnvironmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEnvironmentsCallable()");
  }

  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getEnvironmentCallable()");
  }

  public OperationCallable<CreateEnvironmentRequest, Environment, Struct>
      createEnvironmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEnvironmentOperationCallable()");
  }

  public UnaryCallable<CreateEnvironmentRequest, Operation> createEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createEnvironmentCallable()");
  }

  public OperationCallable<UpdateEnvironmentRequest, Environment, Struct>
      updateEnvironmentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEnvironmentOperationCallable()");
  }

  public UnaryCallable<UpdateEnvironmentRequest, Operation> updateEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEnvironmentCallable()");
  }

  public UnaryCallable<DeleteEnvironmentRequest, Empty> deleteEnvironmentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEnvironmentCallable()");
  }

  public UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryPagedResponse>
      lookupEnvironmentHistoryPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: lookupEnvironmentHistoryPagedCallable()");
  }

  public UnaryCallable<LookupEnvironmentHistoryRequest, LookupEnvironmentHistoryResponse>
      lookupEnvironmentHistoryCallable() {
    throw new UnsupportedOperationException("Not implemented: lookupEnvironmentHistoryCallable()");
  }

  @Override
  public abstract void close();
}
