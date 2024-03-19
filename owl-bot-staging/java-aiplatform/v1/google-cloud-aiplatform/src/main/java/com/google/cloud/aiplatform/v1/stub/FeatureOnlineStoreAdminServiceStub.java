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

import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListFeatureOnlineStoresPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewSyncsPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewsPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1.CreateFeatureViewOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateFeatureViewRequest;
import com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.FeatureOnlineStore;
import com.google.cloud.aiplatform.v1.FeatureView;
import com.google.cloud.aiplatform.v1.FeatureViewSync;
import com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1.GetFeatureViewRequest;
import com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest;
import com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest;
import com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse;
import com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest;
import com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse;
import com.google.cloud.aiplatform.v1.ListFeatureViewsRequest;
import com.google.cloud.aiplatform.v1.ListFeatureViewsResponse;
import com.google.cloud.aiplatform.v1.SyncFeatureViewRequest;
import com.google.cloud.aiplatform.v1.SyncFeatureViewResponse;
import com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1.UpdateFeatureViewOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest;
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
 * Base stub class for the FeatureOnlineStoreAdminService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FeatureOnlineStoreAdminServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFeatureOnlineStoreOperationCallable()");
  }

  public UnaryCallable<CreateFeatureOnlineStoreRequest, Operation>
      createFeatureOnlineStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureOnlineStoreCallable()");
  }

  public UnaryCallable<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
      getFeatureOnlineStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeatureOnlineStoreCallable()");
  }

  public UnaryCallable<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresPagedResponse>
      listFeatureOnlineStoresPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listFeatureOnlineStoresPagedCallable()");
  }

  public UnaryCallable<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse>
      listFeatureOnlineStoresCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeatureOnlineStoresCallable()");
  }

  public OperationCallable<
          UpdateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          UpdateFeatureOnlineStoreOperationMetadata>
      updateFeatureOnlineStoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFeatureOnlineStoreOperationCallable()");
  }

  public UnaryCallable<UpdateFeatureOnlineStoreRequest, Operation>
      updateFeatureOnlineStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureOnlineStoreCallable()");
  }

  public OperationCallable<DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOnlineStoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFeatureOnlineStoreOperationCallable()");
  }

  public UnaryCallable<DeleteFeatureOnlineStoreRequest, Operation>
      deleteFeatureOnlineStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureOnlineStoreCallable()");
  }

  public OperationCallable<
          CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createFeatureViewOperationCallable()");
  }

  public UnaryCallable<CreateFeatureViewRequest, Operation> createFeatureViewCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeatureViewCallable()");
  }

  public UnaryCallable<GetFeatureViewRequest, FeatureView> getFeatureViewCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeatureViewCallable()");
  }

  public UnaryCallable<ListFeatureViewsRequest, ListFeatureViewsPagedResponse>
      listFeatureViewsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeatureViewsPagedCallable()");
  }

  public UnaryCallable<ListFeatureViewsRequest, ListFeatureViewsResponse>
      listFeatureViewsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeatureViewsCallable()");
  }

  public OperationCallable<
          UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
      updateFeatureViewOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateFeatureViewOperationCallable()");
  }

  public UnaryCallable<UpdateFeatureViewRequest, Operation> updateFeatureViewCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeatureViewCallable()");
  }

  public OperationCallable<DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
      deleteFeatureViewOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteFeatureViewOperationCallable()");
  }

  public UnaryCallable<DeleteFeatureViewRequest, Operation> deleteFeatureViewCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeatureViewCallable()");
  }

  public UnaryCallable<SyncFeatureViewRequest, SyncFeatureViewResponse> syncFeatureViewCallable() {
    throw new UnsupportedOperationException("Not implemented: syncFeatureViewCallable()");
  }

  public UnaryCallable<GetFeatureViewSyncRequest, FeatureViewSync> getFeatureViewSyncCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeatureViewSyncCallable()");
  }

  public UnaryCallable<ListFeatureViewSyncsRequest, ListFeatureViewSyncsPagedResponse>
      listFeatureViewSyncsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeatureViewSyncsPagedCallable()");
  }

  public UnaryCallable<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse>
      listFeatureViewSyncsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeatureViewSyncsCallable()");
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
