/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.aiplatform.v1.FeatureRegistryServiceClient.ListFeatureGroupsPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureRegistryServiceClient.ListFeaturesPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureRegistryServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateFeatureGroupOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateFeatureGroupRequest;
import com.google.cloud.aiplatform.v1.CreateFeatureOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateFeatureRequest;
import com.google.cloud.aiplatform.v1.DeleteFeatureGroupRequest;
import com.google.cloud.aiplatform.v1.DeleteFeatureRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.Feature;
import com.google.cloud.aiplatform.v1.FeatureGroup;
import com.google.cloud.aiplatform.v1.GetFeatureGroupRequest;
import com.google.cloud.aiplatform.v1.GetFeatureRequest;
import com.google.cloud.aiplatform.v1.ListFeatureGroupsRequest;
import com.google.cloud.aiplatform.v1.ListFeatureGroupsResponse;
import com.google.cloud.aiplatform.v1.ListFeaturesRequest;
import com.google.cloud.aiplatform.v1.ListFeaturesResponse;
import com.google.cloud.aiplatform.v1.UpdateFeatureGroupOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateFeatureGroupRequest;
import com.google.cloud.aiplatform.v1.UpdateFeatureOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateFeatureRequest;
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
 * Base stub class for the FeatureRegistryService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FeatureRegistryServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateFeatureGroupRequest, FeatureGroup, CreateFeatureGroupOperationMetadata>
      createFeatureGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFeatureGroupOperationCallable()");
  }

  public UnaryCallable<CreateFeatureGroupRequest, Operation> createFeatureGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureGroupCallable()");
  }

  public UnaryCallable<GetFeatureGroupRequest, FeatureGroup> getFeatureGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeatureGroupCallable()");
  }

  public UnaryCallable<ListFeatureGroupsRequest, ListFeatureGroupsPagedResponse>
      listFeatureGroupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeatureGroupsPagedCallable()");
  }

  public UnaryCallable<ListFeatureGroupsRequest, ListFeatureGroupsResponse>
      listFeatureGroupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeatureGroupsCallable()");
  }

  public OperationCallable<
          UpdateFeatureGroupRequest, FeatureGroup, UpdateFeatureGroupOperationMetadata>
      updateFeatureGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFeatureGroupOperationCallable()");
  }

  public UnaryCallable<UpdateFeatureGroupRequest, Operation> updateFeatureGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureGroupCallable()");
  }

  public OperationCallable<DeleteFeatureGroupRequest, Empty, DeleteOperationMetadata>
      deleteFeatureGroupOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFeatureGroupOperationCallable()");
  }

  public UnaryCallable<DeleteFeatureGroupRequest, Operation> deleteFeatureGroupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureGroupCallable()");
  }

  public OperationCallable<CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
      createFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureOperationCallable()");
  }

  public UnaryCallable<CreateFeatureRequest, Operation> createFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureCallable()");
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

  public OperationCallable<UpdateFeatureRequest, Feature, UpdateFeatureOperationMetadata>
      updateFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureOperationCallable()");
  }

  public UnaryCallable<UpdateFeatureRequest, Operation> updateFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureCallable()");
  }

  public OperationCallable<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureOperationCallable()");
  }

  public UnaryCallable<DeleteFeatureRequest, Operation> deleteFeatureCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureCallable()");
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
