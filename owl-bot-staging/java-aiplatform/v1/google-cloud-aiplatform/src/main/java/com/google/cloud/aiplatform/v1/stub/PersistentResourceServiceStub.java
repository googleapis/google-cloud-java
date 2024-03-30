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

import static com.google.cloud.aiplatform.v1.PersistentResourceServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.PersistentResourceServiceClient.ListPersistentResourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreatePersistentResourceOperationMetadata;
import com.google.cloud.aiplatform.v1.CreatePersistentResourceRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeletePersistentResourceRequest;
import com.google.cloud.aiplatform.v1.GetPersistentResourceRequest;
import com.google.cloud.aiplatform.v1.ListPersistentResourcesRequest;
import com.google.cloud.aiplatform.v1.ListPersistentResourcesResponse;
import com.google.cloud.aiplatform.v1.PersistentResource;
import com.google.cloud.aiplatform.v1.RebootPersistentResourceOperationMetadata;
import com.google.cloud.aiplatform.v1.RebootPersistentResourceRequest;
import com.google.cloud.aiplatform.v1.UpdatePersistentResourceOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdatePersistentResourceRequest;
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
 * Base stub class for the PersistentResourceService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PersistentResourceServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreatePersistentResourceRequest,
          PersistentResource,
          CreatePersistentResourceOperationMetadata>
      createPersistentResourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPersistentResourceOperationCallable()");
  }

  public UnaryCallable<CreatePersistentResourceRequest, Operation>
      createPersistentResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: createPersistentResourceCallable()");
  }

  public UnaryCallable<GetPersistentResourceRequest, PersistentResource>
      getPersistentResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getPersistentResourceCallable()");
  }

  public UnaryCallable<ListPersistentResourcesRequest, ListPersistentResourcesPagedResponse>
      listPersistentResourcesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listPersistentResourcesPagedCallable()");
  }

  public UnaryCallable<ListPersistentResourcesRequest, ListPersistentResourcesResponse>
      listPersistentResourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listPersistentResourcesCallable()");
  }

  public OperationCallable<DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
      deletePersistentResourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePersistentResourceOperationCallable()");
  }

  public UnaryCallable<DeletePersistentResourceRequest, Operation>
      deletePersistentResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePersistentResourceCallable()");
  }

  public OperationCallable<
          UpdatePersistentResourceRequest,
          PersistentResource,
          UpdatePersistentResourceOperationMetadata>
      updatePersistentResourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePersistentResourceOperationCallable()");
  }

  public UnaryCallable<UpdatePersistentResourceRequest, Operation>
      updatePersistentResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePersistentResourceCallable()");
  }

  public OperationCallable<
          RebootPersistentResourceRequest,
          PersistentResource,
          RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rebootPersistentResourceOperationCallable()");
  }

  public UnaryCallable<RebootPersistentResourceRequest, Operation>
      rebootPersistentResourceCallable() {
    throw new UnsupportedOperationException("Not implemented: rebootPersistentResourceCallable()");
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
