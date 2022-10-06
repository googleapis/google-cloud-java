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

package com.google.cloud.automl.v1beta1.stub;

import static com.google.cloud.automl.v1beta1.AutoMlClient.ListColumnSpecsPagedResponse;
import static com.google.cloud.automl.v1beta1.AutoMlClient.ListDatasetsPagedResponse;
import static com.google.cloud.automl.v1beta1.AutoMlClient.ListModelEvaluationsPagedResponse;
import static com.google.cloud.automl.v1beta1.AutoMlClient.ListModelsPagedResponse;
import static com.google.cloud.automl.v1beta1.AutoMlClient.ListTableSpecsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.automl.v1beta1.AnnotationSpec;
import com.google.cloud.automl.v1beta1.ColumnSpec;
import com.google.cloud.automl.v1beta1.CreateDatasetRequest;
import com.google.cloud.automl.v1beta1.CreateModelRequest;
import com.google.cloud.automl.v1beta1.Dataset;
import com.google.cloud.automl.v1beta1.DeleteDatasetRequest;
import com.google.cloud.automl.v1beta1.DeleteModelRequest;
import com.google.cloud.automl.v1beta1.DeployModelRequest;
import com.google.cloud.automl.v1beta1.ExportDataRequest;
import com.google.cloud.automl.v1beta1.ExportEvaluatedExamplesRequest;
import com.google.cloud.automl.v1beta1.ExportModelRequest;
import com.google.cloud.automl.v1beta1.GetAnnotationSpecRequest;
import com.google.cloud.automl.v1beta1.GetColumnSpecRequest;
import com.google.cloud.automl.v1beta1.GetDatasetRequest;
import com.google.cloud.automl.v1beta1.GetModelEvaluationRequest;
import com.google.cloud.automl.v1beta1.GetModelRequest;
import com.google.cloud.automl.v1beta1.GetTableSpecRequest;
import com.google.cloud.automl.v1beta1.ImportDataRequest;
import com.google.cloud.automl.v1beta1.ListColumnSpecsRequest;
import com.google.cloud.automl.v1beta1.ListColumnSpecsResponse;
import com.google.cloud.automl.v1beta1.ListDatasetsRequest;
import com.google.cloud.automl.v1beta1.ListDatasetsResponse;
import com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest;
import com.google.cloud.automl.v1beta1.ListModelEvaluationsResponse;
import com.google.cloud.automl.v1beta1.ListModelsRequest;
import com.google.cloud.automl.v1beta1.ListModelsResponse;
import com.google.cloud.automl.v1beta1.ListTableSpecsRequest;
import com.google.cloud.automl.v1beta1.ListTableSpecsResponse;
import com.google.cloud.automl.v1beta1.Model;
import com.google.cloud.automl.v1beta1.ModelEvaluation;
import com.google.cloud.automl.v1beta1.OperationMetadata;
import com.google.cloud.automl.v1beta1.TableSpec;
import com.google.cloud.automl.v1beta1.UndeployModelRequest;
import com.google.cloud.automl.v1beta1.UpdateColumnSpecRequest;
import com.google.cloud.automl.v1beta1.UpdateDatasetRequest;
import com.google.cloud.automl.v1beta1.UpdateTableSpecRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AutoMl service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class AutoMlStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateDatasetRequest, Dataset> createDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatasetCallable()");
  }

  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatasetCallable()");
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetsPagedCallable()");
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetsCallable()");
  }

  public UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetCallable()");
  }

  public OperationCallable<DeleteDatasetRequest, Empty, OperationMetadata>
      deleteDatasetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatasetOperationCallable()");
  }

  public UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatasetCallable()");
  }

  public OperationCallable<ImportDataRequest, Empty, OperationMetadata>
      importDataOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importDataOperationCallable()");
  }

  public UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    throw new UnsupportedOperationException("Not implemented: importDataCallable()");
  }

  public OperationCallable<ExportDataRequest, Empty, OperationMetadata>
      exportDataOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportDataOperationCallable()");
  }

  public UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    throw new UnsupportedOperationException("Not implemented: exportDataCallable()");
  }

  public UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnnotationSpecCallable()");
  }

  public UnaryCallable<GetTableSpecRequest, TableSpec> getTableSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: getTableSpecCallable()");
  }

  public UnaryCallable<ListTableSpecsRequest, ListTableSpecsPagedResponse>
      listTableSpecsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTableSpecsPagedCallable()");
  }

  public UnaryCallable<ListTableSpecsRequest, ListTableSpecsResponse> listTableSpecsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTableSpecsCallable()");
  }

  public UnaryCallable<UpdateTableSpecRequest, TableSpec> updateTableSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTableSpecCallable()");
  }

  public UnaryCallable<GetColumnSpecRequest, ColumnSpec> getColumnSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: getColumnSpecCallable()");
  }

  public UnaryCallable<ListColumnSpecsRequest, ListColumnSpecsPagedResponse>
      listColumnSpecsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listColumnSpecsPagedCallable()");
  }

  public UnaryCallable<ListColumnSpecsRequest, ListColumnSpecsResponse> listColumnSpecsCallable() {
    throw new UnsupportedOperationException("Not implemented: listColumnSpecsCallable()");
  }

  public UnaryCallable<UpdateColumnSpecRequest, ColumnSpec> updateColumnSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: updateColumnSpecCallable()");
  }

  public OperationCallable<CreateModelRequest, Model, OperationMetadata>
      createModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createModelOperationCallable()");
  }

  public UnaryCallable<CreateModelRequest, Operation> createModelCallable() {
    throw new UnsupportedOperationException("Not implemented: createModelCallable()");
  }

  public UnaryCallable<GetModelRequest, Model> getModelCallable() {
    throw new UnsupportedOperationException("Not implemented: getModelCallable()");
  }

  public UnaryCallable<ListModelsRequest, ListModelsPagedResponse> listModelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelsPagedCallable()");
  }

  public UnaryCallable<ListModelsRequest, ListModelsResponse> listModelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelsCallable()");
  }

  public OperationCallable<DeleteModelRequest, Empty, OperationMetadata>
      deleteModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteModelOperationCallable()");
  }

  public UnaryCallable<DeleteModelRequest, Operation> deleteModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteModelCallable()");
  }

  public OperationCallable<DeployModelRequest, Empty, OperationMetadata>
      deployModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployModelOperationCallable()");
  }

  public UnaryCallable<DeployModelRequest, Operation> deployModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deployModelCallable()");
  }

  public OperationCallable<UndeployModelRequest, Empty, OperationMetadata>
      undeployModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployModelOperationCallable()");
  }

  public UnaryCallable<UndeployModelRequest, Operation> undeployModelCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployModelCallable()");
  }

  public OperationCallable<ExportModelRequest, Empty, OperationMetadata>
      exportModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportModelOperationCallable()");
  }

  public UnaryCallable<ExportModelRequest, Operation> exportModelCallable() {
    throw new UnsupportedOperationException("Not implemented: exportModelCallable()");
  }

  public OperationCallable<ExportEvaluatedExamplesRequest, Empty, OperationMetadata>
      exportEvaluatedExamplesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportEvaluatedExamplesOperationCallable()");
  }

  public UnaryCallable<ExportEvaluatedExamplesRequest, Operation>
      exportEvaluatedExamplesCallable() {
    throw new UnsupportedOperationException("Not implemented: exportEvaluatedExamplesCallable()");
  }

  public UnaryCallable<GetModelEvaluationRequest, ModelEvaluation> getModelEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: getModelEvaluationCallable()");
  }

  public UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsPagedResponse>
      listModelEvaluationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelEvaluationsPagedCallable()");
  }

  public UnaryCallable<ListModelEvaluationsRequest, ListModelEvaluationsResponse>
      listModelEvaluationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listModelEvaluationsCallable()");
  }

  @Override
  public abstract void close();
}
