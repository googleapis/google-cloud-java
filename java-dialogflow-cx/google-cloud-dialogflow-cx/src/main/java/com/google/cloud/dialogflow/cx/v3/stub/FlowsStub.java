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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.FlowsClient.ListFlowsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.FlowsClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateFlowRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteFlowRequest;
import com.google.cloud.dialogflow.cx.v3.ExportFlowRequest;
import com.google.cloud.dialogflow.cx.v3.ExportFlowResponse;
import com.google.cloud.dialogflow.cx.v3.Flow;
import com.google.cloud.dialogflow.cx.v3.FlowValidationResult;
import com.google.cloud.dialogflow.cx.v3.GetFlowRequest;
import com.google.cloud.dialogflow.cx.v3.GetFlowValidationResultRequest;
import com.google.cloud.dialogflow.cx.v3.ImportFlowRequest;
import com.google.cloud.dialogflow.cx.v3.ImportFlowResponse;
import com.google.cloud.dialogflow.cx.v3.ListFlowsRequest;
import com.google.cloud.dialogflow.cx.v3.ListFlowsResponse;
import com.google.cloud.dialogflow.cx.v3.TrainFlowRequest;
import com.google.cloud.dialogflow.cx.v3.UpdateFlowRequest;
import com.google.cloud.dialogflow.cx.v3.ValidateFlowRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Flows service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FlowsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateFlowRequest, Flow> createFlowCallable() {
    throw new UnsupportedOperationException("Not implemented: createFlowCallable()");
  }

  public UnaryCallable<DeleteFlowRequest, Empty> deleteFlowCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFlowCallable()");
  }

  public UnaryCallable<ListFlowsRequest, ListFlowsPagedResponse> listFlowsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFlowsPagedCallable()");
  }

  public UnaryCallable<ListFlowsRequest, ListFlowsResponse> listFlowsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFlowsCallable()");
  }

  public UnaryCallable<GetFlowRequest, Flow> getFlowCallable() {
    throw new UnsupportedOperationException("Not implemented: getFlowCallable()");
  }

  public UnaryCallable<UpdateFlowRequest, Flow> updateFlowCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFlowCallable()");
  }

  public OperationCallable<TrainFlowRequest, Empty, Struct> trainFlowOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: trainFlowOperationCallable()");
  }

  public UnaryCallable<TrainFlowRequest, Operation> trainFlowCallable() {
    throw new UnsupportedOperationException("Not implemented: trainFlowCallable()");
  }

  public UnaryCallable<ValidateFlowRequest, FlowValidationResult> validateFlowCallable() {
    throw new UnsupportedOperationException("Not implemented: validateFlowCallable()");
  }

  public UnaryCallable<GetFlowValidationResultRequest, FlowValidationResult>
      getFlowValidationResultCallable() {
    throw new UnsupportedOperationException("Not implemented: getFlowValidationResultCallable()");
  }

  public OperationCallable<ImportFlowRequest, ImportFlowResponse, Struct>
      importFlowOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importFlowOperationCallable()");
  }

  public UnaryCallable<ImportFlowRequest, Operation> importFlowCallable() {
    throw new UnsupportedOperationException("Not implemented: importFlowCallable()");
  }

  public OperationCallable<ExportFlowRequest, ExportFlowResponse, Struct>
      exportFlowOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportFlowOperationCallable()");
  }

  public UnaryCallable<ExportFlowRequest, Operation> exportFlowCallable() {
    throw new UnsupportedOperationException("Not implemented: exportFlowCallable()");
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
