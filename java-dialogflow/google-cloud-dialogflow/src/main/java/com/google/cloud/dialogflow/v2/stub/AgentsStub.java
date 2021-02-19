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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.AgentsClient.SearchAgentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.Agent;
import com.google.cloud.dialogflow.v2.DeleteAgentRequest;
import com.google.cloud.dialogflow.v2.ExportAgentRequest;
import com.google.cloud.dialogflow.v2.ExportAgentResponse;
import com.google.cloud.dialogflow.v2.GetAgentRequest;
import com.google.cloud.dialogflow.v2.GetValidationResultRequest;
import com.google.cloud.dialogflow.v2.ImportAgentRequest;
import com.google.cloud.dialogflow.v2.RestoreAgentRequest;
import com.google.cloud.dialogflow.v2.SearchAgentsRequest;
import com.google.cloud.dialogflow.v2.SearchAgentsResponse;
import com.google.cloud.dialogflow.v2.SetAgentRequest;
import com.google.cloud.dialogflow.v2.TrainAgentRequest;
import com.google.cloud.dialogflow.v2.ValidationResult;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Agents service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AgentsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: getAgentCallable()");
  }

  public UnaryCallable<SetAgentRequest, Agent> setAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: setAgentCallable()");
  }

  public UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAgentCallable()");
  }

  public UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse> searchAgentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAgentsPagedCallable()");
  }

  public UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAgentsCallable()");
  }

  public OperationCallable<TrainAgentRequest, Empty, Struct> trainAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: trainAgentOperationCallable()");
  }

  public UnaryCallable<TrainAgentRequest, Operation> trainAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: trainAgentCallable()");
  }

  public OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAgentOperationCallable()");
  }

  public UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: exportAgentCallable()");
  }

  public OperationCallable<ImportAgentRequest, Empty, Struct> importAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importAgentOperationCallable()");
  }

  public UnaryCallable<ImportAgentRequest, Operation> importAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: importAgentCallable()");
  }

  public OperationCallable<RestoreAgentRequest, Empty, Struct> restoreAgentOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreAgentOperationCallable()");
  }

  public UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreAgentCallable()");
  }

  public UnaryCallable<GetValidationResultRequest, ValidationResult> getValidationResultCallable() {
    throw new UnsupportedOperationException("Not implemented: getValidationResultCallable()");
  }

  @Override
  public abstract void close();
}
