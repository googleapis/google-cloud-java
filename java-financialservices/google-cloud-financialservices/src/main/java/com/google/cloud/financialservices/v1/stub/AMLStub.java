/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.financialservices.v1.stub;

import static com.google.cloud.financialservices.v1.AMLClient.ListBacktestResultsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListDatasetsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineConfigsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListEngineVersionsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListInstancesPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListLocationsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListModelsPagedResponse;
import static com.google.cloud.financialservices.v1.AMLClient.ListPredictionResultsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.financialservices.v1.BacktestResult;
import com.google.cloud.financialservices.v1.CreateBacktestResultRequest;
import com.google.cloud.financialservices.v1.CreateDatasetRequest;
import com.google.cloud.financialservices.v1.CreateEngineConfigRequest;
import com.google.cloud.financialservices.v1.CreateInstanceRequest;
import com.google.cloud.financialservices.v1.CreateModelRequest;
import com.google.cloud.financialservices.v1.CreatePredictionResultRequest;
import com.google.cloud.financialservices.v1.Dataset;
import com.google.cloud.financialservices.v1.DeleteBacktestResultRequest;
import com.google.cloud.financialservices.v1.DeleteDatasetRequest;
import com.google.cloud.financialservices.v1.DeleteEngineConfigRequest;
import com.google.cloud.financialservices.v1.DeleteInstanceRequest;
import com.google.cloud.financialservices.v1.DeleteModelRequest;
import com.google.cloud.financialservices.v1.DeletePredictionResultRequest;
import com.google.cloud.financialservices.v1.EngineConfig;
import com.google.cloud.financialservices.v1.EngineVersion;
import com.google.cloud.financialservices.v1.ExportBacktestResultMetadataRequest;
import com.google.cloud.financialservices.v1.ExportBacktestResultMetadataResponse;
import com.google.cloud.financialservices.v1.ExportEngineConfigMetadataRequest;
import com.google.cloud.financialservices.v1.ExportEngineConfigMetadataResponse;
import com.google.cloud.financialservices.v1.ExportModelMetadataRequest;
import com.google.cloud.financialservices.v1.ExportModelMetadataResponse;
import com.google.cloud.financialservices.v1.ExportPredictionResultMetadataRequest;
import com.google.cloud.financialservices.v1.ExportPredictionResultMetadataResponse;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ExportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.GetBacktestResultRequest;
import com.google.cloud.financialservices.v1.GetDatasetRequest;
import com.google.cloud.financialservices.v1.GetEngineConfigRequest;
import com.google.cloud.financialservices.v1.GetEngineVersionRequest;
import com.google.cloud.financialservices.v1.GetInstanceRequest;
import com.google.cloud.financialservices.v1.GetModelRequest;
import com.google.cloud.financialservices.v1.GetPredictionResultRequest;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesRequest;
import com.google.cloud.financialservices.v1.ImportRegisteredPartiesResponse;
import com.google.cloud.financialservices.v1.Instance;
import com.google.cloud.financialservices.v1.ListBacktestResultsRequest;
import com.google.cloud.financialservices.v1.ListBacktestResultsResponse;
import com.google.cloud.financialservices.v1.ListDatasetsRequest;
import com.google.cloud.financialservices.v1.ListDatasetsResponse;
import com.google.cloud.financialservices.v1.ListEngineConfigsRequest;
import com.google.cloud.financialservices.v1.ListEngineConfigsResponse;
import com.google.cloud.financialservices.v1.ListEngineVersionsRequest;
import com.google.cloud.financialservices.v1.ListEngineVersionsResponse;
import com.google.cloud.financialservices.v1.ListInstancesRequest;
import com.google.cloud.financialservices.v1.ListInstancesResponse;
import com.google.cloud.financialservices.v1.ListModelsRequest;
import com.google.cloud.financialservices.v1.ListModelsResponse;
import com.google.cloud.financialservices.v1.ListPredictionResultsRequest;
import com.google.cloud.financialservices.v1.ListPredictionResultsResponse;
import com.google.cloud.financialservices.v1.Model;
import com.google.cloud.financialservices.v1.OperationMetadata;
import com.google.cloud.financialservices.v1.PredictionResult;
import com.google.cloud.financialservices.v1.UpdateBacktestResultRequest;
import com.google.cloud.financialservices.v1.UpdateDatasetRequest;
import com.google.cloud.financialservices.v1.UpdateEngineConfigRequest;
import com.google.cloud.financialservices.v1.UpdateInstanceRequest;
import com.google.cloud.financialservices.v1.UpdateModelRequest;
import com.google.cloud.financialservices.v1.UpdatePredictionResultRequest;
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
 * Base stub class for the AML service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AMLStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceOperationCallable()");
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceCallable()");
  }

  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceCallable()");
  }

  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
  }

  public OperationCallable<
          ImportRegisteredPartiesRequest, ImportRegisteredPartiesResponse, OperationMetadata>
      importRegisteredPartiesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importRegisteredPartiesOperationCallable()");
  }

  public UnaryCallable<ImportRegisteredPartiesRequest, Operation>
      importRegisteredPartiesCallable() {
    throw new UnsupportedOperationException("Not implemented: importRegisteredPartiesCallable()");
  }

  public OperationCallable<
          ExportRegisteredPartiesRequest, ExportRegisteredPartiesResponse, OperationMetadata>
      exportRegisteredPartiesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportRegisteredPartiesOperationCallable()");
  }

  public UnaryCallable<ExportRegisteredPartiesRequest, Operation>
      exportRegisteredPartiesCallable() {
    throw new UnsupportedOperationException("Not implemented: exportRegisteredPartiesCallable()");
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetsPagedCallable()");
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetsCallable()");
  }

  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatasetCallable()");
  }

  public OperationCallable<CreateDatasetRequest, Dataset, OperationMetadata>
      createDatasetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatasetOperationCallable()");
  }

  public UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatasetCallable()");
  }

  public OperationCallable<UpdateDatasetRequest, Dataset, OperationMetadata>
      updateDatasetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetOperationCallable()");
  }

  public UnaryCallable<UpdateDatasetRequest, Operation> updateDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetCallable()");
  }

  public OperationCallable<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatasetOperationCallable()");
  }

  public UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatasetCallable()");
  }

  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelsPagedCallable()");
  }

  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelsCallable()");
  }

  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    throw new UnsupportedOperationException("Not implemented: getModelCallable()");
  }

  public OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createModelOperationCallable()");
  }

  public UnaryCallable<CreateModelRequest, Operation> createModelCallable() {
    throw new UnsupportedOperationException("Not implemented: createModelCallable()");
  }

  public OperationCallable<UpdateModelRequest, Model, OperationMetadata>
      updateModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateModelOperationCallable()");
  }

  public UnaryCallable<UpdateModelRequest, Operation> updateModelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateModelCallable()");
  }

  public OperationCallable<
          ExportModelMetadataRequest, ExportModelMetadataResponse, OperationMetadata>
      exportModelMetadataOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportModelMetadataOperationCallable()");
  }

  public UnaryCallable<ExportModelMetadataRequest, Operation> exportModelMetadataCallable() {
    throw new UnsupportedOperationException("Not implemented: exportModelMetadataCallable()");
  }

  public OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteModelOperationCallable()");
  }

  public UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteModelCallable()");
  }

  public UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsPagedResponse>
      listEngineConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEngineConfigsPagedCallable()");
  }

  public UnaryCallable<ListEngineConfigsRequest, ListEngineConfigsResponse>
      listEngineConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEngineConfigsCallable()");
  }

  public UnaryCallable<GetEngineConfigRequest, EngineConfig> getEngineConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getEngineConfigCallable()");
  }

  public OperationCallable<CreateEngineConfigRequest, EngineConfig, OperationMetadata>
      createEngineConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEngineConfigOperationCallable()");
  }

  public UnaryCallable<CreateEngineConfigRequest, Operation> createEngineConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createEngineConfigCallable()");
  }

  public OperationCallable<UpdateEngineConfigRequest, EngineConfig, OperationMetadata>
      updateEngineConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEngineConfigOperationCallable()");
  }

  public UnaryCallable<UpdateEngineConfigRequest, Operation> updateEngineConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEngineConfigCallable()");
  }

  public OperationCallable<
          ExportEngineConfigMetadataRequest, ExportEngineConfigMetadataResponse, OperationMetadata>
      exportEngineConfigMetadataOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportEngineConfigMetadataOperationCallable()");
  }

  public UnaryCallable<ExportEngineConfigMetadataRequest, Operation>
      exportEngineConfigMetadataCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportEngineConfigMetadataCallable()");
  }

  public OperationCallable<DeleteEngineConfigRequest, Empty, OperationMetadata>
      deleteEngineConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteEngineConfigOperationCallable()");
  }

  public UnaryCallable<DeleteEngineConfigRequest, Operation> deleteEngineConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEngineConfigCallable()");
  }

  public UnaryCallable<GetEngineVersionRequest, EngineVersion> getEngineVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getEngineVersionCallable()");
  }

  public UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsPagedResponse>
      listEngineVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEngineVersionsPagedCallable()");
  }

  public UnaryCallable<ListEngineVersionsRequest, ListEngineVersionsResponse>
      listEngineVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEngineVersionsCallable()");
  }

  public UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsPagedResponse>
      listPredictionResultsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPredictionResultsPagedCallable()");
  }

  public UnaryCallable<ListPredictionResultsRequest, ListPredictionResultsResponse>
      listPredictionResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPredictionResultsCallable()");
  }

  public UnaryCallable<GetPredictionResultRequest, PredictionResult> getPredictionResultCallable() {
    throw new UnsupportedOperationException("Not implemented: getPredictionResultCallable()");
  }

  public OperationCallable<CreatePredictionResultRequest, PredictionResult, OperationMetadata>
      createPredictionResultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPredictionResultOperationCallable()");
  }

  public UnaryCallable<CreatePredictionResultRequest, Operation> createPredictionResultCallable() {
    throw new UnsupportedOperationException("Not implemented: createPredictionResultCallable()");
  }

  public OperationCallable<UpdatePredictionResultRequest, PredictionResult, OperationMetadata>
      updatePredictionResultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePredictionResultOperationCallable()");
  }

  public UnaryCallable<UpdatePredictionResultRequest, Operation> updatePredictionResultCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePredictionResultCallable()");
  }

  public OperationCallable<
          ExportPredictionResultMetadataRequest,
          ExportPredictionResultMetadataResponse,
          OperationMetadata>
      exportPredictionResultMetadataOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportPredictionResultMetadataOperationCallable()");
  }

  public UnaryCallable<ExportPredictionResultMetadataRequest, Operation>
      exportPredictionResultMetadataCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportPredictionResultMetadataCallable()");
  }

  public OperationCallable<DeletePredictionResultRequest, Empty, OperationMetadata>
      deletePredictionResultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePredictionResultOperationCallable()");
  }

  public UnaryCallable<DeletePredictionResultRequest, Operation> deletePredictionResultCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePredictionResultCallable()");
  }

  public UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsPagedResponse>
      listBacktestResultsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBacktestResultsPagedCallable()");
  }

  public UnaryCallable<ListBacktestResultsRequest, ListBacktestResultsResponse>
      listBacktestResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBacktestResultsCallable()");
  }

  public UnaryCallable<GetBacktestResultRequest, BacktestResult> getBacktestResultCallable() {
    throw new UnsupportedOperationException("Not implemented: getBacktestResultCallable()");
  }

  public OperationCallable<CreateBacktestResultRequest, BacktestResult, OperationMetadata>
      createBacktestResultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createBacktestResultOperationCallable()");
  }

  public UnaryCallable<CreateBacktestResultRequest, Operation> createBacktestResultCallable() {
    throw new UnsupportedOperationException("Not implemented: createBacktestResultCallable()");
  }

  public OperationCallable<UpdateBacktestResultRequest, BacktestResult, OperationMetadata>
      updateBacktestResultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateBacktestResultOperationCallable()");
  }

  public UnaryCallable<UpdateBacktestResultRequest, Operation> updateBacktestResultCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBacktestResultCallable()");
  }

  public OperationCallable<
          ExportBacktestResultMetadataRequest,
          ExportBacktestResultMetadataResponse,
          OperationMetadata>
      exportBacktestResultMetadataOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportBacktestResultMetadataOperationCallable()");
  }

  public UnaryCallable<ExportBacktestResultMetadataRequest, Operation>
      exportBacktestResultMetadataCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportBacktestResultMetadataCallable()");
  }

  public OperationCallable<DeleteBacktestResultRequest, Empty, OperationMetadata>
      deleteBacktestResultOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteBacktestResultOperationCallable()");
  }

  public UnaryCallable<DeleteBacktestResultRequest, Operation> deleteBacktestResultCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBacktestResultCallable()");
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
