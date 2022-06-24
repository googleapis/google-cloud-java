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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.EnvironmentsClient.ListContinuousTestResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.EnvironmentsClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.EnvironmentsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.EnvironmentsClient.LookupEnvironmentHistoryPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.CreateEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeleteEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeployFlowMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.DeployFlowRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeployFlowResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Environment;
import com.google.cloud.dialogflow.cx.v3beta1.GetEnvironmentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListContinuousTestResultsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListContinuousTestResultsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListEnvironmentsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListEnvironmentsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.LookupEnvironmentHistoryRequest;
import com.google.cloud.dialogflow.cx.v3beta1.LookupEnvironmentHistoryResponse;
import com.google.cloud.dialogflow.cx.v3beta1.RunContinuousTestMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.RunContinuousTestRequest;
import com.google.cloud.dialogflow.cx.v3beta1.RunContinuousTestResponse;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateEnvironmentRequest;
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
 * Base stub class for the Environments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class EnvironmentsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
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

  public OperationCallable<
          RunContinuousTestRequest, RunContinuousTestResponse, RunContinuousTestMetadata>
      runContinuousTestOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: runContinuousTestOperationCallable()");
  }

  public UnaryCallable<RunContinuousTestRequest, Operation> runContinuousTestCallable() {
    throw new UnsupportedOperationException("Not implemented: runContinuousTestCallable()");
  }

  public UnaryCallable<ListContinuousTestResultsRequest, ListContinuousTestResultsPagedResponse>
      listContinuousTestResultsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listContinuousTestResultsPagedCallable()");
  }

  public UnaryCallable<ListContinuousTestResultsRequest, ListContinuousTestResultsResponse>
      listContinuousTestResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listContinuousTestResultsCallable()");
  }

  public OperationCallable<DeployFlowRequest, DeployFlowResponse, DeployFlowMetadata>
      deployFlowOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployFlowOperationCallable()");
  }

  public UnaryCallable<DeployFlowRequest, Operation> deployFlowCallable() {
    throw new UnsupportedOperationException("Not implemented: deployFlowCallable()");
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
