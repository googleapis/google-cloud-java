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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListAnnotationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDataItemsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDatasetVersionsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListDatasetsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.ListSavedQueriesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DatasetServiceClient.SearchDataItemsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.AnnotationSpec;
import com.google.cloud.aiplatform.v1beta1.AssembleDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.AssembleDataRequest;
import com.google.cloud.aiplatform.v1beta1.AssembleDataResponse;
import com.google.cloud.aiplatform.v1beta1.AssessDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.AssessDataRequest;
import com.google.cloud.aiplatform.v1beta1.AssessDataResponse;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetVersionOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.Dataset;
import com.google.cloud.aiplatform.v1beta1.DatasetVersion;
import com.google.cloud.aiplatform.v1beta1.DeleteDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteSavedQueryRequest;
import com.google.cloud.aiplatform.v1beta1.ExportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportDataRequest;
import com.google.cloud.aiplatform.v1beta1.ExportDataResponse;
import com.google.cloud.aiplatform.v1beta1.GetAnnotationSpecRequest;
import com.google.cloud.aiplatform.v1beta1.GetDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.GetDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.ImportDataOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportDataRequest;
import com.google.cloud.aiplatform.v1beta1.ImportDataResponse;
import com.google.cloud.aiplatform.v1beta1.ListAnnotationsRequest;
import com.google.cloud.aiplatform.v1beta1.ListAnnotationsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDataItemsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDataItemsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDatasetVersionsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDatasetVersionsResponse;
import com.google.cloud.aiplatform.v1beta1.ListDatasetsRequest;
import com.google.cloud.aiplatform.v1beta1.ListDatasetsResponse;
import com.google.cloud.aiplatform.v1beta1.ListSavedQueriesRequest;
import com.google.cloud.aiplatform.v1beta1.ListSavedQueriesResponse;
import com.google.cloud.aiplatform.v1beta1.RestoreDatasetVersionOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.RestoreDatasetVersionRequest;
import com.google.cloud.aiplatform.v1beta1.SearchDataItemsRequest;
import com.google.cloud.aiplatform.v1beta1.SearchDataItemsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateDatasetRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateDatasetVersionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
@BetaApi
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

  public OperationCallable<
          CreateDatasetVersionRequest, DatasetVersion, CreateDatasetVersionOperationMetadata>
      createDatasetVersionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createDatasetVersionOperationCallable()");
  }

  public UnaryCallable<CreateDatasetVersionRequest, Operation> createDatasetVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatasetVersionCallable()");
  }

  public UnaryCallable<UpdateDatasetVersionRequest, DatasetVersion> updateDatasetVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatasetVersionCallable()");
  }

  public OperationCallable<DeleteDatasetVersionRequest, Empty, DeleteOperationMetadata>
      deleteDatasetVersionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteDatasetVersionOperationCallable()");
  }

  public UnaryCallable<DeleteDatasetVersionRequest, Operation> deleteDatasetVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatasetVersionCallable()");
  }

  public UnaryCallable<GetDatasetVersionRequest, DatasetVersion> getDatasetVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatasetVersionCallable()");
  }

  public UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsPagedResponse>
      listDatasetVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetVersionsPagedCallable()");
  }

  public UnaryCallable<ListDatasetVersionsRequest, ListDatasetVersionsResponse>
      listDatasetVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatasetVersionsCallable()");
  }

  public OperationCallable<
          RestoreDatasetVersionRequest, DatasetVersion, RestoreDatasetVersionOperationMetadata>
      restoreDatasetVersionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: restoreDatasetVersionOperationCallable()");
  }

  public UnaryCallable<RestoreDatasetVersionRequest, Operation> restoreDatasetVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreDatasetVersionCallable()");
  }

  public UnaryCallable<ListDataItemsRequest, ListDataItemsPagedResponse>
      listDataItemsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataItemsPagedCallable()");
  }

  public UnaryCallable<ListDataItemsRequest, ListDataItemsResponse> listDataItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataItemsCallable()");
  }

  public UnaryCallable<SearchDataItemsRequest, SearchDataItemsPagedResponse>
      searchDataItemsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchDataItemsPagedCallable()");
  }

  public UnaryCallable<SearchDataItemsRequest, SearchDataItemsResponse> searchDataItemsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchDataItemsCallable()");
  }

  public UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesPagedResponse>
      listSavedQueriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSavedQueriesPagedCallable()");
  }

  public UnaryCallable<ListSavedQueriesRequest, ListSavedQueriesResponse>
      listSavedQueriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listSavedQueriesCallable()");
  }

  public OperationCallable<DeleteSavedQueryRequest, Empty, DeleteOperationMetadata>
      deleteSavedQueryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSavedQueryOperationCallable()");
  }

  public UnaryCallable<DeleteSavedQueryRequest, Operation> deleteSavedQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSavedQueryCallable()");
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

  public OperationCallable<AssessDataRequest, AssessDataResponse, AssessDataOperationMetadata>
      assessDataOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: assessDataOperationCallable()");
  }

  public UnaryCallable<AssessDataRequest, Operation> assessDataCallable() {
    throw new UnsupportedOperationException("Not implemented: assessDataCallable()");
  }

  public OperationCallable<AssembleDataRequest, AssembleDataResponse, AssembleDataOperationMetadata>
      assembleDataOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: assembleDataOperationCallable()");
  }

  public UnaryCallable<AssembleDataRequest, Operation> assembleDataCallable() {
    throw new UnsupportedOperationException("Not implemented: assembleDataCallable()");
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

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
