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

import static com.google.cloud.aiplatform.v1.SpecialistPoolServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.SpecialistPoolServiceClient.ListSpecialistPoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.CreateSpecialistPoolOperationMetadata;
import com.google.cloud.aiplatform.v1.CreateSpecialistPoolRequest;
import com.google.cloud.aiplatform.v1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1.DeleteSpecialistPoolRequest;
import com.google.cloud.aiplatform.v1.GetSpecialistPoolRequest;
import com.google.cloud.aiplatform.v1.ListSpecialistPoolsRequest;
import com.google.cloud.aiplatform.v1.ListSpecialistPoolsResponse;
import com.google.cloud.aiplatform.v1.SpecialistPool;
import com.google.cloud.aiplatform.v1.UpdateSpecialistPoolOperationMetadata;
import com.google.cloud.aiplatform.v1.UpdateSpecialistPoolRequest;
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
 * Base stub class for the SpecialistPoolService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SpecialistPoolServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateSpecialistPoolRequest, SpecialistPool, CreateSpecialistPoolOperationMetadata>
      createSpecialistPoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createSpecialistPoolOperationCallable()");
  }

  public UnaryCallable<CreateSpecialistPoolRequest, Operation> createSpecialistPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createSpecialistPoolCallable()");
  }

  public UnaryCallable<GetSpecialistPoolRequest, SpecialistPool> getSpecialistPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getSpecialistPoolCallable()");
  }

  public UnaryCallable<ListSpecialistPoolsRequest, ListSpecialistPoolsPagedResponse>
      listSpecialistPoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpecialistPoolsPagedCallable()");
  }

  public UnaryCallable<ListSpecialistPoolsRequest, ListSpecialistPoolsResponse>
      listSpecialistPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSpecialistPoolsCallable()");
  }

  public OperationCallable<DeleteSpecialistPoolRequest, Empty, DeleteOperationMetadata>
      deleteSpecialistPoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteSpecialistPoolOperationCallable()");
  }

  public UnaryCallable<DeleteSpecialistPoolRequest, Operation> deleteSpecialistPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSpecialistPoolCallable()");
  }

  public OperationCallable<
          UpdateSpecialistPoolRequest, SpecialistPool, UpdateSpecialistPoolOperationMetadata>
      updateSpecialistPoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateSpecialistPoolOperationCallable()");
  }

  public UnaryCallable<UpdateSpecialistPoolRequest, Operation> updateSpecialistPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSpecialistPoolCallable()");
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
