/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.workloadmanager.v1.stub;

import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListEvaluationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionResultsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListExecutionsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.workloadmanager.v1.WorkloadManagerClient.ListScannedResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.workloadmanager.v1.CreateEvaluationRequest;
import com.google.cloud.workloadmanager.v1.DeleteEvaluationRequest;
import com.google.cloud.workloadmanager.v1.DeleteExecutionRequest;
import com.google.cloud.workloadmanager.v1.Evaluation;
import com.google.cloud.workloadmanager.v1.Execution;
import com.google.cloud.workloadmanager.v1.GetEvaluationRequest;
import com.google.cloud.workloadmanager.v1.GetExecutionRequest;
import com.google.cloud.workloadmanager.v1.ListEvaluationsRequest;
import com.google.cloud.workloadmanager.v1.ListEvaluationsResponse;
import com.google.cloud.workloadmanager.v1.ListExecutionResultsRequest;
import com.google.cloud.workloadmanager.v1.ListExecutionResultsResponse;
import com.google.cloud.workloadmanager.v1.ListExecutionsRequest;
import com.google.cloud.workloadmanager.v1.ListExecutionsResponse;
import com.google.cloud.workloadmanager.v1.ListRulesRequest;
import com.google.cloud.workloadmanager.v1.ListRulesResponse;
import com.google.cloud.workloadmanager.v1.ListScannedResourcesRequest;
import com.google.cloud.workloadmanager.v1.ListScannedResourcesResponse;
import com.google.cloud.workloadmanager.v1.OperationMetadata;
import com.google.cloud.workloadmanager.v1.RunEvaluationRequest;
import com.google.cloud.workloadmanager.v1.UpdateEvaluationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the WorkloadManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class WorkloadManagerStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationsPagedCallable()");
  }

  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse> listEvaluationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationsCallable()");
  }

  public UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: getEvaluationCallable()");
  }

  public OperationCallable<CreateEvaluationRequest, Evaluation, OperationMetadata>
      createEvaluationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEvaluationOperationCallable()");
  }

  public UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEvaluationCallable()");
  }

  public OperationCallable<UpdateEvaluationRequest, Evaluation, OperationMetadata>
      updateEvaluationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEvaluationOperationCallable()");
  }

  public UnaryCallable<UpdateEvaluationRequest, Operation> updateEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEvaluationCallable()");
  }

  public OperationCallable<DeleteEvaluationRequest, Empty, OperationMetadata>
      deleteEvaluationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEvaluationOperationCallable()");
  }

  public UnaryCallable<DeleteEvaluationRequest, Operation> deleteEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEvaluationCallable()");
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsPagedCallable()");
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsCallable()");
  }

  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: getExecutionCallable()");
  }

  public OperationCallable<RunEvaluationRequest, Execution, OperationMetadata>
      runEvaluationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: runEvaluationOperationCallable()");
  }

  public UnaryCallable<RunEvaluationRequest, Operation> runEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: runEvaluationCallable()");
  }

  public OperationCallable<DeleteExecutionRequest, Empty, OperationMetadata>
      deleteExecutionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExecutionOperationCallable()");
  }

  public UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExecutionCallable()");
  }

  public UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsPagedResponse>
      listExecutionResultsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionResultsPagedCallable()");
  }

  public UnaryCallable<ListExecutionResultsRequest, ListExecutionResultsResponse>
      listExecutionResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionResultsCallable()");
  }

  public UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listRulesCallable()");
  }

  public UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesPagedResponse>
      listScannedResourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listScannedResourcesPagedCallable()");
  }

  public UnaryCallable<ListScannedResourcesRequest, ListScannedResourcesResponse>
      listScannedResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listScannedResourcesCallable()");
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
