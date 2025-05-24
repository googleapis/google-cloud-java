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

import static com.google.cloud.aiplatform.v1beta1.IndexServiceClient.ListIndexesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.IndexServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateIndexRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteIndexRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GetIndexRequest;
import com.google.cloud.aiplatform.v1beta1.ImportIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportIndexRequest;
import com.google.cloud.aiplatform.v1beta1.Index;
import com.google.cloud.aiplatform.v1beta1.ListIndexesRequest;
import com.google.cloud.aiplatform.v1beta1.ListIndexesResponse;
import com.google.cloud.aiplatform.v1beta1.RemoveDatapointsRequest;
import com.google.cloud.aiplatform.v1beta1.RemoveDatapointsResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateIndexOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateIndexRequest;
import com.google.cloud.aiplatform.v1beta1.UpsertDatapointsRequest;
import com.google.cloud.aiplatform.v1beta1.UpsertDatapointsResponse;
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
 * Base stub class for the IndexService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class IndexServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<CreateIndexRequest, Index, CreateIndexOperationMetadata>
      createIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexOperationCallable()");
  }

  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexCallable()");
  }

  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: getIndexCallable()");
  }

  public OperationCallable<ImportIndexRequest, Index, ImportIndexOperationMetadata>
      importIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importIndexOperationCallable()");
  }

  public UnaryCallable<ImportIndexRequest, Operation> importIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: importIndexCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesPagedCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesCallable()");
  }

  public OperationCallable<UpdateIndexRequest, Index, UpdateIndexOperationMetadata>
      updateIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIndexOperationCallable()");
  }

  public UnaryCallable<UpdateIndexRequest, Operation> updateIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIndexCallable()");
  }

  public OperationCallable<DeleteIndexRequest, Empty, DeleteOperationMetadata>
      deleteIndexOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexOperationCallable()");
  }

  public UnaryCallable<DeleteIndexRequest, Operation> deleteIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexCallable()");
  }

  public UnaryCallable<UpsertDatapointsRequest, UpsertDatapointsResponse>
      upsertDatapointsCallable() {
    throw new UnsupportedOperationException("Not implemented: upsertDatapointsCallable()");
  }

  public UnaryCallable<RemoveDatapointsRequest, RemoveDatapointsResponse>
      removeDatapointsCallable() {
    throw new UnsupportedOperationException("Not implemented: removeDatapointsCallable()");
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
