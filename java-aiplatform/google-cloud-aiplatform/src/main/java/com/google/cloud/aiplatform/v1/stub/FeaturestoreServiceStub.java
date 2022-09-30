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

package com.google.cloud.aiplatform.v1.stub;

import static com.google.cloud.aiplatform.v1.FeaturestoreServiceClient.ListEntityTypesPagedResponse;
import static com.google.cloud.aiplatform.v1.FeaturestoreServiceClient.ListFeaturesPagedResponse;
import static com.google.cloud.aiplatform.v1.FeaturestoreServiceClient.ListFeaturestoresPagedResponse;
import static com.google.cloud.aiplatform.v1.FeaturestoreServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.FeaturestoreServiceClient.SearchFeaturesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.BatchCreateFeaturesOperationMetadata;
import com.google.cloud.aiplatform.v1.BatchCreateFeaturesRequest;
import com.google.cloud.aiplatform.v1.BatchCreateFeaturesResponse;
import com.google.cloud.aiplatform.v1.BatchReadFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1.BatchReadFeatureValuesRequest;
import com.google.cloud.aiplatform.v1.BatchReadFeatureValuesResponse;
import com.google.cloud.aiplatform.v1.CreateEntityTypeOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateEntityTypeRequest;
import com.google.cloud.aiplatform.v1.CreateFeatureOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateFeatureRequest;
import com.google.cloud.aiplatform.v1.CreateFeaturestoreOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateFeaturestoreRequest;
import com.google.cloud.aiplatform.v1.DeleteEntityTypeRequest;
import com.google.cloud.aiplatform.v1.DeleteFeatureRequest;
import com.google.cloud.aiplatform.v1.DeleteFeaturestoreRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.EntityType;
import com.google.cloud.aiplatform.v1.ExportFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1.ExportFeatureValuesRequest;
import com.google.cloud.aiplatform.v1.ExportFeatureValuesResponse;
import com.google.cloud.aiplatform.v1.Feature;
import com.google.cloud.aiplatform.v1.Featurestore;
import com.google.cloud.aiplatform.v1.GetEntityTypeRequest;
import com.google.cloud.aiplatform.v1.GetFeatureRequest;
import com.google.cloud.aiplatform.v1.GetFeaturestoreRequest;
import com.google.cloud.aiplatform.v1.ImportFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1.ImportFeatureValuesRequest;
import com.google.cloud.aiplatform.v1.ImportFeatureValuesResponse;
import com.google.cloud.aiplatform.v1.ListEntityTypesRequest;
import com.google.cloud.aiplatform.v1.ListEntityTypesResponse;
import com.google.cloud.aiplatform.v1.ListFeaturesRequest;
import com.google.cloud.aiplatform.v1.ListFeaturesResponse;
import com.google.cloud.aiplatform.v1.ListFeaturestoresRequest;
import com.google.cloud.aiplatform.v1.ListFeaturestoresResponse;
import com.google.cloud.aiplatform.v1.SearchFeaturesRequest;
import com.google.cloud.aiplatform.v1.SearchFeaturesResponse;
import com.google.cloud.aiplatform.v1.UpdateEntityTypeRequest;
import com.google.cloud.aiplatform.v1.UpdateFeatureRequest;
import com.google.cloud.aiplatform.v1.UpdateFeaturestoreOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateFeaturestoreRequest;
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
 * Base stub class for the FeaturestoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FeaturestoreServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateFeaturestoreRequest, Featurestore, CreateFeaturestoreOperationMetadata>
      createFeaturestoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFeaturestoreOperationCallable()");
  }

  public UnaryCallable<CreateFeaturestoreRequest, Operation> createFeaturestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeaturestoreCallable()");
  }

  public UnaryCallable<GetFeaturestoreRequest, Featurestore> getFeaturestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeaturestoreCallable()");
  }

  public UnaryCallable<ListFeaturestoresRequest, ListFeaturestoresPagedResponse>
      listFeaturestoresPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeaturestoresPagedCallable()");
  }

  public UnaryCallable<ListFeaturestoresRequest, ListFeaturestoresResponse>
      listFeaturestoresCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeaturestoresCallable()");
  }

  public OperationCallable<
          UpdateFeaturestoreRequest, Featurestore, UpdateFeaturestoreOperationMetadata>
      updateFeaturestoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFeaturestoreOperationCallable()");
  }

  public UnaryCallable<UpdateFeaturestoreRequest, Operation> updateFeaturestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeaturestoreCallable()");
  }

  public OperationCallable<DeleteFeaturestoreRequest, Empty, DeleteOperationMetadata>
      deleteFeaturestoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFeaturestoreOperationCallable()");
  }

  public UnaryCallable<DeleteFeaturestoreRequest, Operation> deleteFeaturestoreCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeaturestoreCallable()");
  }

  public OperationCallable<CreateEntityTypeRequest, EntityType, CreateEntityTypeOperationMetadata>
      createEntityTypeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntityTypeOperationCallable()");
  }

  public UnaryCallable<CreateEntityTypeRequest, Operation> createEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntityTypeCallable()");
  }

  public UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntityTypeCallable()");
  }

  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntityTypesPagedCallable()");
  }

  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse> listEntityTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntityTypesCallable()");
  }

  public UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntityTypeCallable()");
  }

  public OperationCallable<DeleteEntityTypeRequest, Empty, DeleteOperationMetadata>
      deleteEntityTypeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntityTypeOperationCallable()");
  }

  public UnaryCallable<DeleteEntityTypeRequest, Operation> deleteEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntityTypeCallable()");
  }

  public OperationCallable<CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
      createFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureOperationCallable()");
  }

  public UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureCallable()");
  }

  public OperationCallable<
          BatchCreateFeaturesRequest,
          BatchCreateFeaturesResponse,
          BatchCreateFeaturesOperationMetadata>
      batchCreateFeaturesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateFeaturesOperationCallable()");
  }

  public UnaryCallable<BatchCreateFeaturesRequest, Operation> batchCreateFeaturesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateFeaturesCallable()");
  }

  public UnaryCallable<GetFeatureRequest, Feature> getFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeatureCallable()");
  }

  public UnaryCallable<ListFeaturesRequest, ListFeaturesPagedResponse> listFeaturesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeaturesPagedCallable()");
  }

  public UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> listFeaturesCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeaturesCallable()");
  }

  public UnaryCallable<UpdateFeatureRequest, Feature> updateFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureCallable()");
  }

  public OperationCallable<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureOperationCallable()");
  }

  public UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureCallable()");
  }

  public OperationCallable<
          ImportFeatureValuesRequest,
          ImportFeatureValuesResponse,
          ImportFeatureValuesOperationMetadata>
      importFeatureValuesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importFeatureValuesOperationCallable()");
  }

  public UnaryCallable<ImportFeatureValuesRequest, Operation> importFeatureValuesCallable() {
    throw new UnsupportedOperationException("Not implemented: importFeatureValuesCallable()");
  }

  public OperationCallable<
          BatchReadFeatureValuesRequest,
          BatchReadFeatureValuesResponse,
          BatchReadFeatureValuesOperationMetadata>
      batchReadFeatureValuesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchReadFeatureValuesOperationCallable()");
  }

  public UnaryCallable<BatchReadFeatureValuesRequest, Operation> batchReadFeatureValuesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchReadFeatureValuesCallable()");
  }

  public OperationCallable<
          ExportFeatureValuesRequest,
          ExportFeatureValuesResponse,
          ExportFeatureValuesOperationMetadata>
      exportFeatureValuesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportFeatureValuesOperationCallable()");
  }

  public UnaryCallable<ExportFeatureValuesRequest, Operation> exportFeatureValuesCallable() {
    throw new UnsupportedOperationException("Not implemented: exportFeatureValuesCallable()");
  }

  public UnaryCallable<SearchFeaturesRequest, SearchFeaturesPagedResponse>
      searchFeaturesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchFeaturesPagedCallable()");
  }

  public UnaryCallable<SearchFeaturesRequest, SearchFeaturesResponse> searchFeaturesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchFeaturesCallable()");
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
