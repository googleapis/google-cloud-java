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

package com.google.cloud.binaryauthorization.v1beta1.stub;

import static com.google.cloud.binaryauthorization.v1beta1.BinauthzManagementServiceV1Beta1Client.ListAttestorsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.binaryauthorization.v1beta1.Attestor;
import com.google.cloud.binaryauthorization.v1beta1.CreateAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.DeleteAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.GetAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.GetPolicyRequest;
import com.google.cloud.binaryauthorization.v1beta1.ListAttestorsRequest;
import com.google.cloud.binaryauthorization.v1beta1.ListAttestorsResponse;
import com.google.cloud.binaryauthorization.v1beta1.Policy;
import com.google.cloud.binaryauthorization.v1beta1.UpdateAttestorRequest;
import com.google.cloud.binaryauthorization.v1beta1.UpdatePolicyRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BinauthzManagementServiceV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class BinauthzManagementServiceV1Beta1Stub implements BackgroundResource {

  public UnaryCallable<GetPolicyRequest, Policy> getPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getPolicyCallable()");
  }

  public UnaryCallable<UpdatePolicyRequest, Policy> updatePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePolicyCallable()");
  }

  public UnaryCallable<CreateAttestorRequest, Attestor> createAttestorCallable() {
    throw new UnsupportedOperationException("Not implemented: createAttestorCallable()");
  }

  public UnaryCallable<GetAttestorRequest, Attestor> getAttestorCallable() {
    throw new UnsupportedOperationException("Not implemented: getAttestorCallable()");
  }

  public UnaryCallable<UpdateAttestorRequest, Attestor> updateAttestorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAttestorCallable()");
  }

  public UnaryCallable<ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttestorsPagedCallable()");
  }

  public UnaryCallable<ListAttestorsRequest, ListAttestorsResponse> listAttestorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttestorsCallable()");
  }

  public UnaryCallable<DeleteAttestorRequest, Empty> deleteAttestorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAttestorCallable()");
  }

  @Override
  public abstract void close();
}
