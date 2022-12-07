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

package com.google.cloud.security.privateca.v1.stub;

import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCaPoolsPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateAuthoritiesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateRevocationListsPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateTemplatesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificatesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.security.privateca.v1.ActivateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.CaPool;
import com.google.cloud.security.privateca.v1.Certificate;
import com.google.cloud.security.privateca.v1.CertificateAuthority;
import com.google.cloud.security.privateca.v1.CertificateRevocationList;
import com.google.cloud.security.privateca.v1.CertificateTemplate;
import com.google.cloud.security.privateca.v1.CreateCaPoolRequest;
import com.google.cloud.security.privateca.v1.CreateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.CreateCertificateRequest;
import com.google.cloud.security.privateca.v1.CreateCertificateTemplateRequest;
import com.google.cloud.security.privateca.v1.DeleteCaPoolRequest;
import com.google.cloud.security.privateca.v1.DeleteCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.DeleteCertificateTemplateRequest;
import com.google.cloud.security.privateca.v1.DisableCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.EnableCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.FetchCaCertsRequest;
import com.google.cloud.security.privateca.v1.FetchCaCertsResponse;
import com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrRequest;
import com.google.cloud.security.privateca.v1.FetchCertificateAuthorityCsrResponse;
import com.google.cloud.security.privateca.v1.GetCaPoolRequest;
import com.google.cloud.security.privateca.v1.GetCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.GetCertificateRequest;
import com.google.cloud.security.privateca.v1.GetCertificateRevocationListRequest;
import com.google.cloud.security.privateca.v1.GetCertificateTemplateRequest;
import com.google.cloud.security.privateca.v1.ListCaPoolsRequest;
import com.google.cloud.security.privateca.v1.ListCaPoolsResponse;
import com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesRequest;
import com.google.cloud.security.privateca.v1.ListCertificateAuthoritiesResponse;
import com.google.cloud.security.privateca.v1.ListCertificateRevocationListsRequest;
import com.google.cloud.security.privateca.v1.ListCertificateRevocationListsResponse;
import com.google.cloud.security.privateca.v1.ListCertificateTemplatesRequest;
import com.google.cloud.security.privateca.v1.ListCertificateTemplatesResponse;
import com.google.cloud.security.privateca.v1.ListCertificatesRequest;
import com.google.cloud.security.privateca.v1.ListCertificatesResponse;
import com.google.cloud.security.privateca.v1.OperationMetadata;
import com.google.cloud.security.privateca.v1.RevokeCertificateRequest;
import com.google.cloud.security.privateca.v1.UndeleteCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.UpdateCaPoolRequest;
import com.google.cloud.security.privateca.v1.UpdateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1.UpdateCertificateRequest;
import com.google.cloud.security.privateca.v1.UpdateCertificateRevocationListRequest;
import com.google.cloud.security.privateca.v1.UpdateCertificateTemplateRequest;
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
 * Base stub class for the CertificateAuthorityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CertificateAuthorityServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
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

  public OperationCallable<
          UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeleteCertificateAuthorityOperationCallable()");
  }

  public UnaryCallable<UndeleteCertificateAuthorityRequest, Operation>
      undeleteCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeleteCertificateAuthorityCallable()");
  }

  public OperationCallable<
          DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCertificateAuthorityOperationCallable()");
  }

  public UnaryCallable<DeleteCertificateAuthorityRequest, Operation>
      deleteCertificateAuthorityCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCertificateAuthorityCallable()");
  }

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

  public OperationCallable<CreateCaPoolRequest, CaPool, OperationMetadata>
      createCaPoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createCaPoolOperationCallable()");
  }

  public UnaryCallable<CreateCaPoolRequest, Operation> createCaPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createCaPoolCallable()");
  }

  public OperationCallable<UpdateCaPoolRequest, CaPool, OperationMetadata>
      updateCaPoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCaPoolOperationCallable()");
  }

  public UnaryCallable<UpdateCaPoolRequest, Operation> updateCaPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCaPoolCallable()");
  }

  public UnaryCallable<GetCaPoolRequest, CaPool> getCaPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getCaPoolCallable()");
  }

  public UnaryCallable<ListCaPoolsRequest, ListCaPoolsPagedResponse> listCaPoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCaPoolsPagedCallable()");
  }

  public UnaryCallable<ListCaPoolsRequest, ListCaPoolsResponse> listCaPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCaPoolsCallable()");
  }

  public OperationCallable<DeleteCaPoolRequest, Empty, OperationMetadata>
      deleteCaPoolOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCaPoolOperationCallable()");
  }

  public UnaryCallable<DeleteCaPoolRequest, Operation> deleteCaPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCaPoolCallable()");
  }

  public UnaryCallable<FetchCaCertsRequest, FetchCaCertsResponse> fetchCaCertsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchCaCertsCallable()");
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

  public OperationCallable<CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      createCertificateTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createCertificateTemplateOperationCallable()");
  }

  public UnaryCallable<CreateCertificateTemplateRequest, Operation>
      createCertificateTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: createCertificateTemplateCallable()");
  }

  public OperationCallable<DeleteCertificateTemplateRequest, Empty, OperationMetadata>
      deleteCertificateTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteCertificateTemplateOperationCallable()");
  }

  public UnaryCallable<DeleteCertificateTemplateRequest, Operation>
      deleteCertificateTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCertificateTemplateCallable()");
  }

  public UnaryCallable<GetCertificateTemplateRequest, CertificateTemplate>
      getCertificateTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getCertificateTemplateCallable()");
  }

  public UnaryCallable<ListCertificateTemplatesRequest, ListCertificateTemplatesPagedResponse>
      listCertificateTemplatesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCertificateTemplatesPagedCallable()");
  }

  public UnaryCallable<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>
      listCertificateTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listCertificateTemplatesCallable()");
  }

  public OperationCallable<UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      updateCertificateTemplateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateCertificateTemplateOperationCallable()");
  }

  public UnaryCallable<UpdateCertificateTemplateRequest, Operation>
      updateCertificateTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCertificateTemplateCallable()");
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
