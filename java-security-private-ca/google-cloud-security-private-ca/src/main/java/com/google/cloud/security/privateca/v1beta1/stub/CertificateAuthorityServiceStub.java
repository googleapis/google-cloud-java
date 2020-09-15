/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.security.privateca.v1beta1.stub;

import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateAuthoritiesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateRevocationListsPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificatesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListReusableConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.Certificate;
import com.google.cloud.security.privateca.v1beta1.CertificateAuthority;
import com.google.cloud.security.privateca.v1beta1.CertificateRevocationList;
import com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest;
import com.google.cloud.security.privateca.v1beta1.CreateCertificateRevocationListRequest;
import com.google.cloud.security.privateca.v1beta1.CreateReusableConfigRequest;
import com.google.cloud.security.privateca.v1beta1.DeleteReusableConfigRequest;
import com.google.cloud.security.privateca.v1beta1.DisableCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.EnableCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrRequest;
import com.google.cloud.security.privateca.v1beta1.FetchCertificateAuthorityCsrResponse;
import com.google.cloud.security.privateca.v1beta1.GetCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.GetCertificateRequest;
import com.google.cloud.security.privateca.v1beta1.GetCertificateRevocationListRequest;
import com.google.cloud.security.privateca.v1beta1.GetReusableConfigRequest;
import com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesRequest;
import com.google.cloud.security.privateca.v1beta1.ListCertificateAuthoritiesResponse;
import com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsRequest;
import com.google.cloud.security.privateca.v1beta1.ListCertificateRevocationListsResponse;
import com.google.cloud.security.privateca.v1beta1.ListCertificatesRequest;
import com.google.cloud.security.privateca.v1beta1.ListCertificatesResponse;
import com.google.cloud.security.privateca.v1beta1.ListReusableConfigsRequest;
import com.google.cloud.security.privateca.v1beta1.ListReusableConfigsResponse;
import com.google.cloud.security.privateca.v1beta1.OperationMetadata;
import com.google.cloud.security.privateca.v1beta1.RestoreCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.ReusableConfig;
import com.google.cloud.security.privateca.v1beta1.RevokeCertificateRequest;
import com.google.cloud.security.privateca.v1beta1.ScheduleDeleteCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.UpdateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.UpdateCertificateRequest;
import com.google.cloud.security.privateca.v1beta1.UpdateCertificateRevocationListRequest;
import com.google.cloud.security.privateca.v1beta1.UpdateReusableConfigRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Certificate Authority API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class CertificateAuthorityServiceStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<CreateCertificateRequest, Certificate> createCertificateCallable() {
    throw new UnsupportedOperationException("Not implemented: createCertificateCallable()");
  }

  public UnaryCallable<GetCertificateRequest, Certificate> getCertificateCallable() {
    throw new UnsupportedOperationException("Not implemented: getCertificateCallable()");
  }

  public UnaryCallable<ListCertificatesRequest, ListCertificatesPagedResponse>
      listCertificatesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCertificatesPagedCallable()");
  }

  public UnaryCallable<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listCertificatesCallable()");
  }

  public UnaryCallable<RevokeCertificateRequest, Certificate> revokeCertificateCallable() {
    throw new UnsupportedOperationException("Not implemented: revokeCertificateCallable()");
  }

  public UnaryCallable<UpdateCertificateRequest, Certificate> updateCertificateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCertificateCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: activateCertificateAuthorityOperationCallable()");
  }

  public UnaryCallable<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: activateCertificateAuthorityCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      createCertificateAuthorityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCertificateAuthorityOperationCallable()");
  }

  public UnaryCallable<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCertificateAuthorityCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableCertificateAuthorityOperationCallable()");
  }

  public UnaryCallable<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: disableCertificateAuthorityCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enableCertificateAuthorityOperationCallable()");
  }

  public UnaryCallable<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: enableCertificateAuthorityCallable()");
  }

  public UnaryCallable<FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
      fetchCertificateAuthorityCsrCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchCertificateAuthorityCsrCallable()");
  }

  public UnaryCallable<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityCallable() {
    throw new UnsupportedOperationException("Not implemented: getCertificateAuthorityCallable()");
  }

  public UnaryCallable<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesPagedResponse>
      listCertificateAuthoritiesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCertificateAuthoritiesPagedCallable()");
  }

  public UnaryCallable<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>
      listCertificateAuthoritiesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCertificateAuthoritiesCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          RestoreCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      restoreCertificateAuthorityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: restoreCertificateAuthorityOperationCallable()");
  }

  public UnaryCallable<RestoreCertificateAuthorityRequest, Operation>
      restoreCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: restoreCertificateAuthorityCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          ScheduleDeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      scheduleDeleteCertificateAuthorityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: scheduleDeleteCertificateAuthorityOperationCallable()");
  }

  public UnaryCallable<ScheduleDeleteCertificateAuthorityRequest, Operation>
      scheduleDeleteCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: scheduleDeleteCertificateAuthorityCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateCertificateAuthorityOperationCallable()");
  }

  public UnaryCallable<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateCertificateAuthorityCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          CreateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
      createCertificateRevocationListOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCertificateRevocationListOperationCallable()");
  }

  public UnaryCallable<CreateCertificateRevocationListRequest, Operation>
      createCertificateRevocationListCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCertificateRevocationListCallable()");
  }

  public UnaryCallable<GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getCertificateRevocationListCallable()");
  }

  public UnaryCallable<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsPagedResponse>
      listCertificateRevocationListsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCertificateRevocationListsPagedCallable()");
  }

  public UnaryCallable<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
      listCertificateRevocationListsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCertificateRevocationListsCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<
          UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
      updateCertificateRevocationListOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateCertificateRevocationListOperationCallable()");
  }

  public UnaryCallable<UpdateCertificateRevocationListRequest, Operation>
      updateCertificateRevocationListCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateCertificateRevocationListCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateReusableConfigRequest, ReusableConfig, OperationMetadata>
      createReusableConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createReusableConfigOperationCallable()");
  }

  public UnaryCallable<CreateReusableConfigRequest, Operation> createReusableConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createReusableConfigCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<DeleteReusableConfigRequest, Empty, OperationMetadata>
      deleteReusableConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteReusableConfigOperationCallable()");
  }

  public UnaryCallable<DeleteReusableConfigRequest, Operation> deleteReusableConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReusableConfigCallable()");
  }

  public UnaryCallable<GetReusableConfigRequest, ReusableConfig> getReusableConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getReusableConfigCallable()");
  }

  public UnaryCallable<ListReusableConfigsRequest, ListReusableConfigsPagedResponse>
      listReusableConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReusableConfigsPagedCallable()");
  }

  public UnaryCallable<ListReusableConfigsRequest, ListReusableConfigsResponse>
      listReusableConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReusableConfigsCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateReusableConfigRequest, ReusableConfig, OperationMetadata>
      updateReusableConfigOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateReusableConfigOperationCallable()");
  }

  public UnaryCallable<UpdateReusableConfigRequest, Operation> updateReusableConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateReusableConfigCallable()");
  }

  @Override
  public abstract void close();
}
