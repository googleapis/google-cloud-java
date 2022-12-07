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

package com.google.protos.google.cloud.binaryauthorization.v1.stub;

import static com.google.protos.google.cloud.binaryauthorization.v1.BinauthzManagementServiceV1Client.ListAttestorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.protos.google.cloud.binaryauthorization.v1.Resources;
import com.google.protos.google.cloud.binaryauthorization.v1.Service;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the BinauthzManagementServiceV1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class BinauthzManagementServiceV1Stub implements BackgroundResource {

  public UnaryCallable<Service.GetPolicyRequest, Resources.Policy> getPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getPolicyCallable()");
  }

  public UnaryCallable<Service.UpdatePolicyRequest, Resources.Policy> updatePolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePolicyCallable()");
  }

  public UnaryCallable<Service.CreateAttestorRequest, Resources.Attestor> createAttestorCallable() {
    throw new UnsupportedOperationException("Not implemented: createAttestorCallable()");
  }

  public UnaryCallable<Service.GetAttestorRequest, Resources.Attestor> getAttestorCallable() {
    throw new UnsupportedOperationException("Not implemented: getAttestorCallable()");
  }

  public UnaryCallable<Service.UpdateAttestorRequest, Resources.Attestor> updateAttestorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAttestorCallable()");
  }

  public UnaryCallable<Service.ListAttestorsRequest, ListAttestorsPagedResponse>
      listAttestorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttestorsPagedCallable()");
  }

  public UnaryCallable<Service.ListAttestorsRequest, Service.ListAttestorsResponse>
      listAttestorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttestorsCallable()");
  }

  public UnaryCallable<Service.DeleteAttestorRequest, Empty> deleteAttestorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAttestorCallable()");
  }

  @Override
  public abstract void close();
}
