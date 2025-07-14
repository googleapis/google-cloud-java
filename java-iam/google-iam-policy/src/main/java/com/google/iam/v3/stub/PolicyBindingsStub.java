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

package com.google.iam.v3.stub;

import static com.google.iam.v3.PolicyBindingsClient.ListPolicyBindingsPagedResponse;
import static com.google.iam.v3.PolicyBindingsClient.SearchTargetPolicyBindingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v3.CreatePolicyBindingRequest;
import com.google.iam.v3.DeletePolicyBindingRequest;
import com.google.iam.v3.GetPolicyBindingRequest;
import com.google.iam.v3.ListPolicyBindingsRequest;
import com.google.iam.v3.ListPolicyBindingsResponse;
import com.google.iam.v3.OperationMetadata;
import com.google.iam.v3.PolicyBinding;
import com.google.iam.v3.SearchTargetPolicyBindingsRequest;
import com.google.iam.v3.SearchTargetPolicyBindingsResponse;
import com.google.iam.v3.UpdatePolicyBindingRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the PolicyBindings service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PolicyBindingsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      createPolicyBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createPolicyBindingOperationCallable()");
  }

  public UnaryCallable<CreatePolicyBindingRequest, Operation> createPolicyBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: createPolicyBindingCallable()");
  }

  public UnaryCallable<GetPolicyBindingRequest, PolicyBinding> getPolicyBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: getPolicyBindingCallable()");
  }

  public OperationCallable<UpdatePolicyBindingRequest, PolicyBinding, OperationMetadata>
      updatePolicyBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updatePolicyBindingOperationCallable()");
  }

  public UnaryCallable<UpdatePolicyBindingRequest, Operation> updatePolicyBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePolicyBindingCallable()");
  }

  public OperationCallable<DeletePolicyBindingRequest, Empty, OperationMetadata>
      deletePolicyBindingOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deletePolicyBindingOperationCallable()");
  }

  public UnaryCallable<DeletePolicyBindingRequest, Operation> deletePolicyBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePolicyBindingCallable()");
  }

  public UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsPagedResponse>
      listPolicyBindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPolicyBindingsPagedCallable()");
  }

  public UnaryCallable<ListPolicyBindingsRequest, ListPolicyBindingsResponse>
      listPolicyBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPolicyBindingsCallable()");
  }

  public UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsPagedResponse>
      searchTargetPolicyBindingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchTargetPolicyBindingsPagedCallable()");
  }

  public UnaryCallable<SearchTargetPolicyBindingsRequest, SearchTargetPolicyBindingsResponse>
      searchTargetPolicyBindingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: searchTargetPolicyBindingsCallable()");
  }

  @Override
  public abstract void close();
}
