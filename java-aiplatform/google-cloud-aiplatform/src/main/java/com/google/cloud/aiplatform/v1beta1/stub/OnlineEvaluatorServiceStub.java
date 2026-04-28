/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.aiplatform.v1beta1.OnlineEvaluatorServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.OnlineEvaluatorServiceClient.ListOnlineEvaluatorsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ActivateOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.GetOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsRequest;
import com.google.cloud.aiplatform.v1beta1.ListOnlineEvaluatorsResponse;
import com.google.cloud.aiplatform.v1beta1.OnlineEvaluator;
import com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.SuspendOnlineEvaluatorRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateOnlineEvaluatorRequest;
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
 * Base stub class for the OnlineEvaluatorService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class OnlineEvaluatorServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<
          CreateOnlineEvaluatorRequest, OnlineEvaluator, CreateOnlineEvaluatorOperationMetadata>
      createOnlineEvaluatorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createOnlineEvaluatorOperationCallable()");
  }

  public UnaryCallable<CreateOnlineEvaluatorRequest, Operation> createOnlineEvaluatorCallable() {
    throw new UnsupportedOperationException("Not implemented: createOnlineEvaluatorCallable()");
  }

  public UnaryCallable<GetOnlineEvaluatorRequest, OnlineEvaluator> getOnlineEvaluatorCallable() {
    throw new UnsupportedOperationException("Not implemented: getOnlineEvaluatorCallable()");
  }

  public OperationCallable<
          UpdateOnlineEvaluatorRequest, OnlineEvaluator, UpdateOnlineEvaluatorOperationMetadata>
      updateOnlineEvaluatorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateOnlineEvaluatorOperationCallable()");
  }

  public UnaryCallable<UpdateOnlineEvaluatorRequest, Operation> updateOnlineEvaluatorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOnlineEvaluatorCallable()");
  }

  public OperationCallable<
          DeleteOnlineEvaluatorRequest, Empty, DeleteOnlineEvaluatorOperationMetadata>
      deleteOnlineEvaluatorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteOnlineEvaluatorOperationCallable()");
  }

  public UnaryCallable<DeleteOnlineEvaluatorRequest, Operation> deleteOnlineEvaluatorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOnlineEvaluatorCallable()");
  }

  public UnaryCallable<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsPagedResponse>
      listOnlineEvaluatorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOnlineEvaluatorsPagedCallable()");
  }

  public UnaryCallable<ListOnlineEvaluatorsRequest, ListOnlineEvaluatorsResponse>
      listOnlineEvaluatorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOnlineEvaluatorsCallable()");
  }

  public OperationCallable<
          ActivateOnlineEvaluatorRequest, OnlineEvaluator, ActivateOnlineEvaluatorOperationMetadata>
      activateOnlineEvaluatorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: activateOnlineEvaluatorOperationCallable()");
  }

  public UnaryCallable<ActivateOnlineEvaluatorRequest, Operation>
      activateOnlineEvaluatorCallable() {
    throw new UnsupportedOperationException("Not implemented: activateOnlineEvaluatorCallable()");
  }

  public OperationCallable<
          SuspendOnlineEvaluatorRequest, OnlineEvaluator, SuspendOnlineEvaluatorOperationMetadata>
      suspendOnlineEvaluatorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: suspendOnlineEvaluatorOperationCallable()");
  }

  public UnaryCallable<SuspendOnlineEvaluatorRequest, Operation> suspendOnlineEvaluatorCallable() {
    throw new UnsupportedOperationException("Not implemented: suspendOnlineEvaluatorCallable()");
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
