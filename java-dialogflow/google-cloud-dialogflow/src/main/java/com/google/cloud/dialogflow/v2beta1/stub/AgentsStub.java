/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.AgentsClient.SearchAgentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.Agent;
import com.google.cloud.dialogflow.v2beta1.DeleteAgentRequest;
import com.google.cloud.dialogflow.v2beta1.ExportAgentRequest;
import com.google.cloud.dialogflow.v2beta1.ExportAgentResponse;
import com.google.cloud.dialogflow.v2beta1.GetAgentRequest;
import com.google.cloud.dialogflow.v2beta1.ImportAgentRequest;
import com.google.cloud.dialogflow.v2beta1.RestoreAgentRequest;
import com.google.cloud.dialogflow.v2beta1.SearchAgentsRequest;
import com.google.cloud.dialogflow.v2beta1.SearchAgentsResponse;
import com.google.cloud.dialogflow.v2beta1.SetAgentRequest;
import com.google.cloud.dialogflow.v2beta1.TrainAgentRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Dialogflow API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class AgentsStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: getAgentCallable()");
  }

  public UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse> searchAgentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAgentsPagedCallable()");
  }

  public UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAgentsCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<TrainAgentRequest, Empty, Struct> trainAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: trainAgentOperationCallable()");
  }

  public UnaryCallable<TrainAgentRequest, Operation> trainAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: trainAgentCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAgentOperationCallable()");
  }

  public UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAgentCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<ImportAgentRequest, Empty, Struct> importAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importAgentOperationCallable()");
  }

  public UnaryCallable<ImportAgentRequest, Operation> importAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: importAgentCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreAgentOperationCallable()");
  }

  public UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreAgentCallable()");
  }

  public UnaryCallable<SetAgentRequest, Agent> setAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: setAgentCallable()");
  }

  public UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAgentCallable()");
  }

  @Override
  public abstract void close();
}
