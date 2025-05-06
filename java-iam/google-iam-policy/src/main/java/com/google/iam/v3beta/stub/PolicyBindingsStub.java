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

package com.google.iam.v3beta.stub;

import static com.google.iam.v3beta.PolicyBindingsClient.ListPolicyBindingsPagedResponse;
import static com.google.iam.v3beta.PolicyBindingsClient.SearchTargetPolicyBindingsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v3beta.CreatePolicyBindingRequest;
import com.google.iam.v3beta.DeletePolicyBindingRequest;
import com.google.iam.v3beta.GetPolicyBindingRequest;
import com.google.iam.v3beta.ListPolicyBindingsRequest;
import com.google.iam.v3beta.ListPolicyBindingsResponse;
import com.google.iam.v3beta.OperationMetadata;
import com.google.iam.v3beta.PolicyBinding;
import com.google.iam.v3beta.SearchTargetPolicyBindingsRequest;
import com.google.iam.v3beta.SearchTargetPolicyBindingsResponse;
import com.google.iam.v3beta.UpdatePolicyBindingRequest;
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
@BetaApi
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
