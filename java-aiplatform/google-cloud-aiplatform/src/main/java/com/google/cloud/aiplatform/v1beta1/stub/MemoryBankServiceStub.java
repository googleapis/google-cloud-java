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

import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListMemoriesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateMemoryOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateMemoryRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteMemoryOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteMemoryRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateMemoriesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.GenerateMemoriesRequest;
import com.google.cloud.aiplatform.v1beta1.GenerateMemoriesResponse;
import com.google.cloud.aiplatform.v1beta1.GetMemoryRequest;
import com.google.cloud.aiplatform.v1beta1.ListMemoriesRequest;
import com.google.cloud.aiplatform.v1beta1.ListMemoriesResponse;
import com.google.cloud.aiplatform.v1beta1.Memory;
import com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesRequest;
import com.google.cloud.aiplatform.v1beta1.RetrieveMemoriesResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateMemoryOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateMemoryRequest;
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
 * Base stub class for the MemoryBankService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class MemoryBankServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
      createMemoryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createMemoryOperationCallable()");
  }

  public UnaryCallable<CreateMemoryRequest, Operation> createMemoryCallable() {
    throw new UnsupportedOperationException("Not implemented: createMemoryCallable()");
  }

  public UnaryCallable<GetMemoryRequest, Memory> getMemoryCallable() {
    throw new UnsupportedOperationException("Not implemented: getMemoryCallable()");
  }

  public OperationCallable<UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
      updateMemoryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMemoryOperationCallable()");
  }

  public UnaryCallable<UpdateMemoryRequest, Operation> updateMemoryCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMemoryCallable()");
  }

  public UnaryCallable<ListMemoriesRequest, ListMemoriesPagedResponse> listMemoriesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMemoriesPagedCallable()");
  }

  public UnaryCallable<ListMemoriesRequest, ListMemoriesResponse> listMemoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: listMemoriesCallable()");
  }

  public OperationCallable<DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
      deleteMemoryOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMemoryOperationCallable()");
  }

  public UnaryCallable<DeleteMemoryRequest, Operation> deleteMemoryCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMemoryCallable()");
  }

  public OperationCallable<
          GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: generateMemoriesOperationCallable()");
  }

  public UnaryCallable<GenerateMemoriesRequest, Operation> generateMemoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: generateMemoriesCallable()");
  }

  public UnaryCallable<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
      retrieveMemoriesCallable() {
    throw new UnsupportedOperationException("Not implemented: retrieveMemoriesCallable()");
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
