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

package com.google.cloud.managedidentities.v1.stub;

import static com.google.cloud.managedidentities.v1.ManagedIdentitiesServiceClient.ListDomainsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.managedidentities.v1.AttachTrustRequest;
import com.google.cloud.managedidentities.v1.CreateMicrosoftAdDomainRequest;
import com.google.cloud.managedidentities.v1.DeleteDomainRequest;
import com.google.cloud.managedidentities.v1.DetachTrustRequest;
import com.google.cloud.managedidentities.v1.Domain;
import com.google.cloud.managedidentities.v1.GetDomainRequest;
import com.google.cloud.managedidentities.v1.ListDomainsRequest;
import com.google.cloud.managedidentities.v1.ListDomainsResponse;
import com.google.cloud.managedidentities.v1.OpMetadata;
import com.google.cloud.managedidentities.v1.ReconfigureTrustRequest;
import com.google.cloud.managedidentities.v1.ResetAdminPasswordRequest;
import com.google.cloud.managedidentities.v1.ResetAdminPasswordResponse;
import com.google.cloud.managedidentities.v1.UpdateDomainRequest;
import com.google.cloud.managedidentities.v1.ValidateTrustRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ManagedIdentitiesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ManagedIdentitiesServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public OperationCallable<CreateMicrosoftAdDomainRequest, Domain, OpMetadata>
      createMicrosoftAdDomainOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMicrosoftAdDomainOperationCallable()");
  }

  public UnaryCallable<CreateMicrosoftAdDomainRequest, Operation>
      createMicrosoftAdDomainCallable() {
    throw new UnsupportedOperationException("Not implemented: createMicrosoftAdDomainCallable()");
  }

  public UnaryCallable<ResetAdminPasswordRequest, ResetAdminPasswordResponse>
      resetAdminPasswordCallable() {
    throw new UnsupportedOperationException("Not implemented: resetAdminPasswordCallable()");
  }

  public UnaryCallable<ListDomainsRequest, ListDomainsPagedResponse> listDomainsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDomainsPagedCallable()");
  }

  public UnaryCallable<ListDomainsRequest, ListDomainsResponse> listDomainsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDomainsCallable()");
  }

  public UnaryCallable<GetDomainRequest, Domain> getDomainCallable() {
    throw new UnsupportedOperationException("Not implemented: getDomainCallable()");
  }

  public OperationCallable<UpdateDomainRequest, Domain, OpMetadata>
      updateDomainOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDomainOperationCallable()");
  }

  public UnaryCallable<UpdateDomainRequest, Operation> updateDomainCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDomainCallable()");
  }

  public OperationCallable<DeleteDomainRequest, Empty, OpMetadata> deleteDomainOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDomainOperationCallable()");
  }

  public UnaryCallable<DeleteDomainRequest, Operation> deleteDomainCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDomainCallable()");
  }

  public OperationCallable<AttachTrustRequest, Domain, OpMetadata> attachTrustOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: attachTrustOperationCallable()");
  }

  public UnaryCallable<AttachTrustRequest, Operation> attachTrustCallable() {
    throw new UnsupportedOperationException("Not implemented: attachTrustCallable()");
  }

  public OperationCallable<ReconfigureTrustRequest, Domain, OpMetadata>
      reconfigureTrustOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: reconfigureTrustOperationCallable()");
  }

  public UnaryCallable<ReconfigureTrustRequest, Operation> reconfigureTrustCallable() {
    throw new UnsupportedOperationException("Not implemented: reconfigureTrustCallable()");
  }

  public OperationCallable<DetachTrustRequest, Domain, OpMetadata> detachTrustOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: detachTrustOperationCallable()");
  }

  public UnaryCallable<DetachTrustRequest, Operation> detachTrustCallable() {
    throw new UnsupportedOperationException("Not implemented: detachTrustCallable()");
  }

  public OperationCallable<ValidateTrustRequest, Domain, OpMetadata>
      validateTrustOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: validateTrustOperationCallable()");
  }

  public UnaryCallable<ValidateTrustRequest, Operation> validateTrustCallable() {
    throw new UnsupportedOperationException("Not implemented: validateTrustCallable()");
  }

  @Override
  public abstract void close();
}
