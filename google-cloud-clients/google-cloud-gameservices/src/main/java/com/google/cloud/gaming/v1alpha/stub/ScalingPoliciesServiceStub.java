/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1alpha.stub;

import static com.google.cloud.gaming.v1alpha.ScalingPoliciesServiceClient.ListScalingPoliciesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1alpha.CreateScalingPolicyRequest;
import com.google.cloud.gaming.v1alpha.DeleteScalingPolicyRequest;
import com.google.cloud.gaming.v1alpha.GetScalingPolicyRequest;
import com.google.cloud.gaming.v1alpha.ListScalingPoliciesRequest;
import com.google.cloud.gaming.v1alpha.ListScalingPoliciesResponse;
import com.google.cloud.gaming.v1alpha.ScalingPolicy;
import com.google.cloud.gaming.v1alpha.UpdateScalingPolicyRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for gameservices API (prod).
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class ScalingPoliciesServiceStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListScalingPoliciesRequest, ListScalingPoliciesPagedResponse>
      listScalingPoliciesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listScalingPoliciesPagedCallable()");
  }

  public UnaryCallable<ListScalingPoliciesRequest, ListScalingPoliciesResponse>
      listScalingPoliciesCallable() {
    throw new UnsupportedOperationException("Not implemented: listScalingPoliciesCallable()");
  }

  public UnaryCallable<GetScalingPolicyRequest, ScalingPolicy> getScalingPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getScalingPolicyCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateScalingPolicyRequest, ScalingPolicy, Empty>
      createScalingPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createScalingPolicyOperationCallable()");
  }

  public UnaryCallable<CreateScalingPolicyRequest, Operation> createScalingPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: createScalingPolicyCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<DeleteScalingPolicyRequest, Empty, Empty>
      deleteScalingPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteScalingPolicyOperationCallable()");
  }

  public UnaryCallable<DeleteScalingPolicyRequest, Operation> deleteScalingPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteScalingPolicyCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
      updateScalingPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateScalingPolicyOperationCallable()");
  }

  public UnaryCallable<UpdateScalingPolicyRequest, Operation> updateScalingPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateScalingPolicyCallable()");
  }

  @Override
  public abstract void close();
}
