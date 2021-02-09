/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.domains.v1beta1.stub;

import static com.google.cloud.domains.v1beta1.DomainsClient.ListRegistrationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.domains.v1beta1.AuthorizationCode;
import com.google.cloud.domains.v1beta1.ConfigureContactSettingsRequest;
import com.google.cloud.domains.v1beta1.ConfigureDnsSettingsRequest;
import com.google.cloud.domains.v1beta1.ConfigureManagementSettingsRequest;
import com.google.cloud.domains.v1beta1.DeleteRegistrationRequest;
import com.google.cloud.domains.v1beta1.ExportRegistrationRequest;
import com.google.cloud.domains.v1beta1.GetRegistrationRequest;
import com.google.cloud.domains.v1beta1.ListRegistrationsRequest;
import com.google.cloud.domains.v1beta1.ListRegistrationsResponse;
import com.google.cloud.domains.v1beta1.OperationMetadata;
import com.google.cloud.domains.v1beta1.RegisterDomainRequest;
import com.google.cloud.domains.v1beta1.Registration;
import com.google.cloud.domains.v1beta1.ResetAuthorizationCodeRequest;
import com.google.cloud.domains.v1beta1.RetrieveAuthorizationCodeRequest;
import com.google.cloud.domains.v1beta1.RetrieveRegisterParametersRequest;
import com.google.cloud.domains.v1beta1.RetrieveRegisterParametersResponse;
import com.google.cloud.domains.v1beta1.SearchDomainsRequest;
import com.google.cloud.domains.v1beta1.SearchDomainsResponse;
import com.google.cloud.domains.v1beta1.UpdateRegistrationRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Domains service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DomainsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<SearchDomainsRequest, SearchDomainsResponse> searchDomainsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchDomainsCallable()");
  }

  public UnaryCallable<RetrieveRegisterParametersRequest, RetrieveRegisterParametersResponse>
      retrieveRegisterParametersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: retrieveRegisterParametersCallable()");
  }

  public OperationCallable<RegisterDomainRequest, Registration, OperationMetadata>
      registerDomainOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: registerDomainOperationCallable()");
  }

  public UnaryCallable<RegisterDomainRequest, Operation> registerDomainCallable() {
    throw new UnsupportedOperationException("Not implemented: registerDomainCallable()");
  }

  public UnaryCallable<ListRegistrationsRequest, ListRegistrationsPagedResponse>
      listRegistrationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegistrationsPagedCallable()");
  }

  public UnaryCallable<ListRegistrationsRequest, ListRegistrationsResponse>
      listRegistrationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegistrationsCallable()");
  }

  public UnaryCallable<GetRegistrationRequest, Registration> getRegistrationCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegistrationCallable()");
  }

  public OperationCallable<UpdateRegistrationRequest, Registration, OperationMetadata>
      updateRegistrationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateRegistrationOperationCallable()");
  }

  public UnaryCallable<UpdateRegistrationRequest, Operation> updateRegistrationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRegistrationCallable()");
  }

  public OperationCallable<ConfigureManagementSettingsRequest, Registration, OperationMetadata>
      configureManagementSettingsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: configureManagementSettingsOperationCallable()");
  }

  public UnaryCallable<ConfigureManagementSettingsRequest, Operation>
      configureManagementSettingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: configureManagementSettingsCallable()");
  }

  public OperationCallable<ConfigureDnsSettingsRequest, Registration, OperationMetadata>
      configureDnsSettingsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: configureDnsSettingsOperationCallable()");
  }

  public UnaryCallable<ConfigureDnsSettingsRequest, Operation> configureDnsSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: configureDnsSettingsCallable()");
  }

  public OperationCallable<ConfigureContactSettingsRequest, Registration, OperationMetadata>
      configureContactSettingsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: configureContactSettingsOperationCallable()");
  }

  public UnaryCallable<ConfigureContactSettingsRequest, Operation>
      configureContactSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: configureContactSettingsCallable()");
  }

  public OperationCallable<ExportRegistrationRequest, Registration, OperationMetadata>
      exportRegistrationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportRegistrationOperationCallable()");
  }

  public UnaryCallable<ExportRegistrationRequest, Operation> exportRegistrationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportRegistrationCallable()");
  }

  public OperationCallable<DeleteRegistrationRequest, Empty, OperationMetadata>
      deleteRegistrationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteRegistrationOperationCallable()");
  }

  public UnaryCallable<DeleteRegistrationRequest, Operation> deleteRegistrationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRegistrationCallable()");
  }

  public UnaryCallable<RetrieveAuthorizationCodeRequest, AuthorizationCode>
      retrieveAuthorizationCodeCallable() {
    throw new UnsupportedOperationException("Not implemented: retrieveAuthorizationCodeCallable()");
  }

  public UnaryCallable<ResetAuthorizationCodeRequest, AuthorizationCode>
      resetAuthorizationCodeCallable() {
    throw new UnsupportedOperationException("Not implemented: resetAuthorizationCodeCallable()");
  }

  @Override
  public abstract void close();
}
