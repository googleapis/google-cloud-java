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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListConversationModelsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationModelsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.ConversationModel;
import com.google.cloud.dialogflow.v2.ConversationModelEvaluation;
import com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationModelEvaluationRequest;
import com.google.cloud.dialogflow.v2.CreateConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.CreateConversationModelRequest;
import com.google.cloud.dialogflow.v2.DeleteConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.DeleteConversationModelRequest;
import com.google.cloud.dialogflow.v2.DeployConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.DeployConversationModelRequest;
import com.google.cloud.dialogflow.v2.GetConversationModelEvaluationRequest;
import com.google.cloud.dialogflow.v2.GetConversationModelRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelEvaluationsResponse;
import com.google.cloud.dialogflow.v2.ListConversationModelsRequest;
import com.google.cloud.dialogflow.v2.ListConversationModelsResponse;
import com.google.cloud.dialogflow.v2.UndeployConversationModelOperationMetadata;
import com.google.cloud.dialogflow.v2.UndeployConversationModelRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ConversationModels service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ConversationModelsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<
          CreateConversationModelRequest,
          ConversationModel,
          CreateConversationModelOperationMetadata>
      createConversationModelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConversationModelOperationCallable()");
  }

  public UnaryCallable<CreateConversationModelRequest, Operation>
      createConversationModelCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversationModelCallable()");
  }

  public UnaryCallable<GetConversationModelRequest, ConversationModel>
      getConversationModelCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversationModelCallable()");
  }

  public UnaryCallable<ListConversationModelsRequest, ListConversationModelsPagedResponse>
      listConversationModelsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConversationModelsPagedCallable()");
  }

  public UnaryCallable<ListConversationModelsRequest, ListConversationModelsResponse>
      listConversationModelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationModelsCallable()");
  }

  public OperationCallable<
          DeleteConversationModelRequest, Empty, DeleteConversationModelOperationMetadata>
      deleteConversationModelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConversationModelOperationCallable()");
  }

  public UnaryCallable<DeleteConversationModelRequest, Operation>
      deleteConversationModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConversationModelCallable()");
  }

  public OperationCallable<
          DeployConversationModelRequest, Empty, DeployConversationModelOperationMetadata>
      deployConversationModelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deployConversationModelOperationCallable()");
  }

  public UnaryCallable<DeployConversationModelRequest, Operation>
      deployConversationModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deployConversationModelCallable()");
  }

  public OperationCallable<
          UndeployConversationModelRequest, Empty, UndeployConversationModelOperationMetadata>
      undeployConversationModelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeployConversationModelOperationCallable()");
  }

  public UnaryCallable<UndeployConversationModelRequest, Operation>
      undeployConversationModelCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployConversationModelCallable()");
  }

  public UnaryCallable<GetConversationModelEvaluationRequest, ConversationModelEvaluation>
      getConversationModelEvaluationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getConversationModelEvaluationCallable()");
  }

  public UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsPagedResponse>
      listConversationModelEvaluationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConversationModelEvaluationsPagedCallable()");
  }

  public UnaryCallable<
          ListConversationModelEvaluationsRequest, ListConversationModelEvaluationsResponse>
      listConversationModelEvaluationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConversationModelEvaluationsCallable()");
  }

  public OperationCallable<
          CreateConversationModelEvaluationRequest,
          ConversationModelEvaluation,
          CreateConversationModelEvaluationOperationMetadata>
      createConversationModelEvaluationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConversationModelEvaluationOperationCallable()");
  }

  public UnaryCallable<CreateConversationModelEvaluationRequest, Operation>
      createConversationModelEvaluationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConversationModelEvaluationCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
