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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.DatasetServiceClient.ListAnnotationsPagedResponse;
import static com.google.cloud.aiplatform.v1.DatasetServiceClient.ListDataItemsPagedResponse;
import static com.google.cloud.aiplatform.v1.DatasetServiceClient.ListDatasetsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.AnnotationSpec;
import com.google.cloud.aiplatform.v1.CreateDatasetOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateDatasetRequest;
import com.google.cloud.aiplatform.v1.Dataset;
import com.google.cloud.aiplatform.v1.DeleteDatasetRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.ExportDataOperationMetadata;
import com.google.cloud.aiplatform.v1.ExportDataRequest;
import com.google.cloud.aiplatform.v1.ExportDataResponse;
import com.google.cloud.aiplatform.v1.GetAnnotationSpecRequest;
import com.google.cloud.aiplatform.v1.GetDatasetRequest;
import com.google.cloud.aiplatform.v1.ImportDataOperationMetadata;
import com.google.cloud.aiplatform.v1.ImportDataRequest;
import com.google.cloud.aiplatform.v1.ImportDataResponse;
import com.google.cloud.aiplatform.v1.ListAnnotationsRequest;
import com.google.cloud.aiplatform.v1.ListAnnotationsResponse;
import com.google.cloud.aiplatform.v1.ListDataItemsRequest;
import com.google.cloud.aiplatform.v1.ListDataItemsResponse;
import com.google.cloud.aiplatform.v1.ListDatasetsRequest;
import com.google.cloud.aiplatform.v1.ListDatasetsResponse;
import com.google.cloud.aiplatform.v1.UpdateDatasetRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DatasetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DatasetServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<CreateDatasetRequest, Dataset, CreateDatasetOperationMetadata>
      createDatasetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatasetOperationCallable()");
  }

  public UnaryCallable<CreateDatasetRequest, Operation> createDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatasetCallable()");
  }

  public UnaryCallable<GetDatasetRequest, Dataset> getDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatasetCallable()");
  }

  public UnaryCallable<UpdateDatasetRequest, Dataset> updateDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetCallable()");
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsPagedResponse> listDatasetsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetsPagedCallable()");
  }

  public UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> listDatasetsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetsCallable()");
  }

  public OperationCallable<DeleteDatasetRequest, Empty, DeleteOperationMetadata>
      deleteDatasetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatasetOperationCallable()");
  }

  public UnaryCallable<DeleteDatasetRequest, Operation> deleteDatasetCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatasetCallable()");
  }

  public OperationCallable<ImportDataRequest, ImportDataResponse, ImportDataOperationMetadata>
      importDataOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importDataOperationCallable()");
  }

  public UnaryCallable<ImportDataRequest, Operation> importDataCallable() {
    throw new UnsupportedOperationException("Not implemented: importDataCallable()");
  }

  public OperationCallable<ExportDataRequest, ExportDataResponse, ExportDataOperationMetadata>
      exportDataOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportDataOperationCallable()");
  }

  public UnaryCallable<ExportDataRequest, Operation> exportDataCallable() {
    throw new UnsupportedOperationException("Not implemented: exportDataCallable()");
  }

  public UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataItemsPagedCallable()");
  }

  public UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataItemsCallable()");
  }

  public UnaryCallable<GetAnnotationSpecRequest, AnnotationSpec> getAnnotationSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnnotationSpecCallable()");
  }

  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsPagedResponse>
      listAnnotationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnnotationsPagedCallable()");
  }

  public UnaryCallable<ListAnnotationsRequest, ListAnnotationsResponse> listAnnotationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnnotationsCallable()");
  }

  @Override
  public abstract void close();
}
