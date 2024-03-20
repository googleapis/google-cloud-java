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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.ReasoningEngineServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ReasoningEngineServiceClient.ListReasoningEnginesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateReasoningEngineRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteReasoningEngineRequest;
import com.google.cloud.aiplatform.v1beta1.GetReasoningEngineRequest;
import com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesRequest;
import com.google.cloud.aiplatform.v1beta1.ListReasoningEnginesResponse;
import com.google.cloud.aiplatform.v1beta1.ReasoningEngine;
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
 * Base stub class for the ReasoningEngineService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ReasoningEngineServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createReasoningEngineOperationCallable()");
  }

  public UnaryCallable<CreateReasoningEngineRequest, Operation> createReasoningEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: createReasoningEngineCallable()");
  }

  public UnaryCallable<GetReasoningEngineRequest, ReasoningEngine> getReasoningEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: getReasoningEngineCallable()");
  }

  public UnaryCallable<ListReasoningEnginesRequest, ListReasoningEnginesPagedResponse>
      listReasoningEnginesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReasoningEnginesPagedCallable()");
  }

  public UnaryCallable<ListReasoningEnginesRequest, ListReasoningEnginesResponse>
      listReasoningEnginesCallable() {
    throw new UnsupportedOperationException("Not implemented: listReasoningEnginesCallable()");
  }

  public OperationCallable<DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
      deleteReasoningEngineOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteReasoningEngineOperationCallable()");
  }

  public UnaryCallable<DeleteReasoningEngineRequest, Operation> deleteReasoningEngineCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReasoningEngineCallable()");
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
