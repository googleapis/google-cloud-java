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

import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.FetchExamplesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.ListExampleStoresPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateExampleStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateExampleStoreRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteExampleStoreRequest;
import com.google.cloud.aiplatform.v1beta1.ExampleStore;
import com.google.cloud.aiplatform.v1beta1.FetchExamplesRequest;
import com.google.cloud.aiplatform.v1beta1.FetchExamplesResponse;
import com.google.cloud.aiplatform.v1beta1.GetExampleStoreRequest;
import com.google.cloud.aiplatform.v1beta1.ListExampleStoresRequest;
import com.google.cloud.aiplatform.v1beta1.ListExampleStoresResponse;
import com.google.cloud.aiplatform.v1beta1.RemoveExamplesRequest;
import com.google.cloud.aiplatform.v1beta1.RemoveExamplesResponse;
import com.google.cloud.aiplatform.v1beta1.SearchExamplesRequest;
import com.google.cloud.aiplatform.v1beta1.SearchExamplesResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateExampleStoreRequest;
import com.google.cloud.aiplatform.v1beta1.UpsertExamplesRequest;
import com.google.cloud.aiplatform.v1beta1.UpsertExamplesResponse;
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
 * Base stub class for the ExampleStoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ExampleStoreServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateExampleStoreRequest, ExampleStore, CreateExampleStoreOperationMetadata>
      createExampleStoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createExampleStoreOperationCallable()");
  }

  public UnaryCallable<CreateExampleStoreRequest, Operation> createExampleStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: createExampleStoreCallable()");
  }

  public UnaryCallable<GetExampleStoreRequest, ExampleStore> getExampleStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: getExampleStoreCallable()");
  }

  public OperationCallable<
          UpdateExampleStoreRequest, ExampleStore, UpdateExampleStoreOperationMetadata>
      updateExampleStoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateExampleStoreOperationCallable()");
  }

  public UnaryCallable<UpdateExampleStoreRequest, Operation> updateExampleStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: updateExampleStoreCallable()");
  }

  public OperationCallable<DeleteExampleStoreRequest, Empty, DeleteExampleStoreOperationMetadata>
      deleteExampleStoreOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteExampleStoreOperationCallable()");
  }

  public UnaryCallable<DeleteExampleStoreRequest, Operation> deleteExampleStoreCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExampleStoreCallable()");
  }

  public UnaryCallable<ListExampleStoresRequest, ListExampleStoresPagedResponse>
      listExampleStoresPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExampleStoresPagedCallable()");
  }

  public UnaryCallable<ListExampleStoresRequest, ListExampleStoresResponse>
      listExampleStoresCallable() {
    throw new UnsupportedOperationException("Not implemented: listExampleStoresCallable()");
  }

  public UnaryCallable<UpsertExamplesRequest, UpsertExamplesResponse> upsertExamplesCallable() {
    throw new UnsupportedOperationException("Not implemented: upsertExamplesCallable()");
  }

  public UnaryCallable<RemoveExamplesRequest, RemoveExamplesResponse> removeExamplesCallable() {
    throw new UnsupportedOperationException("Not implemented: removeExamplesCallable()");
  }

  public UnaryCallable<SearchExamplesRequest, SearchExamplesResponse> searchExamplesCallable() {
    throw new UnsupportedOperationException("Not implemented: searchExamplesCallable()");
  }

  public UnaryCallable<FetchExamplesRequest, FetchExamplesPagedResponse>
      fetchExamplesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchExamplesPagedCallable()");
  }

  public UnaryCallable<FetchExamplesRequest, FetchExamplesResponse> fetchExamplesCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchExamplesCallable()");
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
