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

package com.google.storagetransfer.v1.proto.stub;

import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListAgentPoolsPagedResponse;
import static com.google.storagetransfer.v1.proto.StorageTransferServiceClient.ListTransferJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.storagetransfer.v1.proto.TransferProto;
import com.google.storagetransfer.v1.proto.TransferTypes;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the StorageTransferService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class StorageTransferServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<
          TransferProto.GetGoogleServiceAccountRequest, TransferTypes.GoogleServiceAccount>
      getGoogleServiceAccountCallable() {
    throw new UnsupportedOperationException("Not implemented: getGoogleServiceAccountCallable()");
  }

  public UnaryCallable<TransferProto.CreateTransferJobRequest, TransferTypes.TransferJob>
      createTransferJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createTransferJobCallable()");
  }

  public UnaryCallable<TransferProto.UpdateTransferJobRequest, TransferTypes.TransferJob>
      updateTransferJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTransferJobCallable()");
  }

  public UnaryCallable<TransferProto.GetTransferJobRequest, TransferTypes.TransferJob>
      getTransferJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getTransferJobCallable()");
  }

  public UnaryCallable<TransferProto.ListTransferJobsRequest, ListTransferJobsPagedResponse>
      listTransferJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferJobsPagedCallable()");
  }

  public UnaryCallable<
          TransferProto.ListTransferJobsRequest, TransferProto.ListTransferJobsResponse>
      listTransferJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTransferJobsCallable()");
  }

  public UnaryCallable<TransferProto.PauseTransferOperationRequest, Empty>
      pauseTransferOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseTransferOperationCallable()");
  }

  public UnaryCallable<TransferProto.ResumeTransferOperationRequest, Empty>
      resumeTransferOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeTransferOperationCallable()");
  }

  public OperationCallable<
          TransferProto.RunTransferJobRequest, Empty, TransferTypes.TransferOperation>
      runTransferJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: runTransferJobOperationCallable()");
  }

  public UnaryCallable<TransferProto.RunTransferJobRequest, Operation> runTransferJobCallable() {
    throw new UnsupportedOperationException("Not implemented: runTransferJobCallable()");
  }

  public UnaryCallable<TransferProto.DeleteTransferJobRequest, Empty> deleteTransferJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTransferJobCallable()");
  }

  public UnaryCallable<TransferProto.CreateAgentPoolRequest, TransferTypes.AgentPool>
      createAgentPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createAgentPoolCallable()");
  }

  public UnaryCallable<TransferProto.UpdateAgentPoolRequest, TransferTypes.AgentPool>
      updateAgentPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAgentPoolCallable()");
  }

  public UnaryCallable<TransferProto.GetAgentPoolRequest, TransferTypes.AgentPool>
      getAgentPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getAgentPoolCallable()");
  }

  public UnaryCallable<TransferProto.ListAgentPoolsRequest, ListAgentPoolsPagedResponse>
      listAgentPoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAgentPoolsPagedCallable()");
  }

  public UnaryCallable<TransferProto.ListAgentPoolsRequest, TransferProto.ListAgentPoolsResponse>
      listAgentPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAgentPoolsCallable()");
  }

  public UnaryCallable<TransferProto.DeleteAgentPoolRequest, Empty> deleteAgentPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAgentPoolCallable()");
  }

  @Override
  public abstract void close();
}
