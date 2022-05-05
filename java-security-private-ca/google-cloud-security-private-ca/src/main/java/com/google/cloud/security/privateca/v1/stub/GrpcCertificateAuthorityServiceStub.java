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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
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
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the CertificateAuthorityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCertificateAuthorityServiceStub extends CertificateAuthorityServiceStub {
  private static final MethodDescriptor<CreateCertificateRequest, Certificate>
      createCertificateMethodDescriptor =
          MethodDescriptor.<CreateCertificateRequest, Certificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/CreateCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Certificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCertificateRequest, Certificate>
      getCertificateMethodDescriptor =
          MethodDescriptor.<GetCertificateRequest, Certificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Certificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesMethodDescriptor =
          MethodDescriptor.<ListCertificatesRequest, ListCertificatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCertificates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCertificatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCertificatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RevokeCertificateRequest, Certificate>
      revokeCertificateMethodDescriptor =
          MethodDescriptor.<RevokeCertificateRequest, Certificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/RevokeCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RevokeCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Certificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCertificateRequest, Certificate>
      updateCertificateMethodDescriptor =
          MethodDescriptor.<UpdateCertificateRequest, Certificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Certificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<ActivateCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ActivateCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ActivateCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<CreateCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/CreateCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<DisableCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/DisableCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<EnableCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/EnableCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
      fetchCertificateAuthorityCsrMethodDescriptor =
          MethodDescriptor
              .<FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/FetchCertificateAuthorityCsr")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchCertificateAuthorityCsrRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchCertificateAuthorityCsrResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<GetCertificateAuthorityRequest, CertificateAuthority>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CertificateAuthority.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>
      listCertificateAuthoritiesMethodDescriptor =
          MethodDescriptor
              .<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCertificateAuthorities")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCertificateAuthoritiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCertificateAuthoritiesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeleteCertificateAuthorityRequest, Operation>
      undeleteCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<UndeleteCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UndeleteCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCertificateAuthorityRequest, Operation>
      deleteCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<DeleteCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/DeleteCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<UpdateCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCaPoolRequest, Operation>
      createCaPoolMethodDescriptor =
          MethodDescriptor.<CreateCaPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/CreateCaPool")
              .setRequestMarshaller(ProtoUtils.marshaller(CreateCaPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCaPoolRequest, Operation>
      updateCaPoolMethodDescriptor =
          MethodDescriptor.<UpdateCaPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCaPool")
              .setRequestMarshaller(ProtoUtils.marshaller(UpdateCaPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCaPoolRequest, CaPool> getCaPoolMethodDescriptor =
      MethodDescriptor.<GetCaPoolRequest, CaPool>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCaPool")
          .setRequestMarshaller(ProtoUtils.marshaller(GetCaPoolRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(CaPool.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListCaPoolsRequest, ListCaPoolsResponse>
      listCaPoolsMethodDescriptor =
          MethodDescriptor.<ListCaPoolsRequest, ListCaPoolsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCaPools")
              .setRequestMarshaller(ProtoUtils.marshaller(ListCaPoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCaPoolsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCaPoolRequest, Operation>
      deleteCaPoolMethodDescriptor =
          MethodDescriptor.<DeleteCaPoolRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/DeleteCaPool")
              .setRequestMarshaller(ProtoUtils.marshaller(DeleteCaPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchCaCertsRequest, FetchCaCertsResponse>
      fetchCaCertsMethodDescriptor =
          MethodDescriptor.<FetchCaCertsRequest, FetchCaCertsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/FetchCaCerts")
              .setRequestMarshaller(ProtoUtils.marshaller(FetchCaCertsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchCaCertsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListMethodDescriptor =
          MethodDescriptor
              .<GetCertificateRevocationListRequest, CertificateRevocationList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCertificateRevocationList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateRevocationListRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CertificateRevocationList.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
      listCertificateRevocationListsMethodDescriptor =
          MethodDescriptor
              .<ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCertificateRevocationLists")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCertificateRevocationListsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListCertificateRevocationListsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCertificateRevocationListRequest, Operation>
      updateCertificateRevocationListMethodDescriptor =
          MethodDescriptor.<UpdateCertificateRevocationListRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCertificateRevocationList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateCertificateRevocationListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCertificateTemplateRequest, Operation>
      createCertificateTemplateMethodDescriptor =
          MethodDescriptor.<CreateCertificateTemplateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/CreateCertificateTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCertificateTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteCertificateTemplateRequest, Operation>
      deleteCertificateTemplateMethodDescriptor =
          MethodDescriptor.<DeleteCertificateTemplateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/DeleteCertificateTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteCertificateTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCertificateTemplateRequest, CertificateTemplate>
      getCertificateTemplateMethodDescriptor =
          MethodDescriptor.<GetCertificateTemplateRequest, CertificateTemplate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCertificateTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CertificateTemplate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>
      listCertificateTemplatesMethodDescriptor =
          MethodDescriptor
              .<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCertificateTemplates")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCertificateTemplatesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCertificateTemplatesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCertificateTemplateRequest, Operation>
      updateCertificateTemplateMethodDescriptor =
          MethodDescriptor.<UpdateCertificateTemplateRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCertificateTemplate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCertificateTemplateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateCertificateRequest, Certificate> createCertificateCallable;
  private final UnaryCallable<GetCertificateRequest, Certificate> getCertificateCallable;
  private final UnaryCallable<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesCallable;
  private final UnaryCallable<ListCertificatesRequest, ListCertificatesPagedResponse>
      listCertificatesPagedCallable;
  private final UnaryCallable<RevokeCertificateRequest, Certificate> revokeCertificateCallable;
  private final UnaryCallable<UpdateCertificateRequest, Certificate> updateCertificateCallable;
  private final UnaryCallable<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthorityCallable;
  private final OperationCallable<
          ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityOperationCallable;
  private final UnaryCallable<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthorityCallable;
  private final OperationCallable<
          CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      createCertificateAuthorityOperationCallable;
  private final UnaryCallable<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthorityCallable;
  private final OperationCallable<
          DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityOperationCallable;
  private final UnaryCallable<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthorityCallable;
  private final OperationCallable<
          EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityOperationCallable;
  private final UnaryCallable<
          FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
      fetchCertificateAuthorityCsrCallable;
  private final UnaryCallable<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityCallable;
  private final UnaryCallable<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>
      listCertificateAuthoritiesCallable;
  private final UnaryCallable<
          ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesPagedResponse>
      listCertificateAuthoritiesPagedCallable;
  private final UnaryCallable<UndeleteCertificateAuthorityRequest, Operation>
      undeleteCertificateAuthorityCallable;
  private final OperationCallable<
          UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityOperationCallable;
  private final UnaryCallable<DeleteCertificateAuthorityRequest, Operation>
      deleteCertificateAuthorityCallable;
  private final OperationCallable<
          DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityOperationCallable;
  private final UnaryCallable<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthorityCallable;
  private final OperationCallable<
          UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityOperationCallable;
  private final UnaryCallable<CreateCaPoolRequest, Operation> createCaPoolCallable;
  private final OperationCallable<CreateCaPoolRequest, CaPool, OperationMetadata>
      createCaPoolOperationCallable;
  private final UnaryCallable<UpdateCaPoolRequest, Operation> updateCaPoolCallable;
  private final OperationCallable<UpdateCaPoolRequest, CaPool, OperationMetadata>
      updateCaPoolOperationCallable;
  private final UnaryCallable<GetCaPoolRequest, CaPool> getCaPoolCallable;
  private final UnaryCallable<ListCaPoolsRequest, ListCaPoolsResponse> listCaPoolsCallable;
  private final UnaryCallable<ListCaPoolsRequest, ListCaPoolsPagedResponse>
      listCaPoolsPagedCallable;
  private final UnaryCallable<DeleteCaPoolRequest, Operation> deleteCaPoolCallable;
  private final OperationCallable<DeleteCaPoolRequest, Empty, OperationMetadata>
      deleteCaPoolOperationCallable;
  private final UnaryCallable<FetchCaCertsRequest, FetchCaCertsResponse> fetchCaCertsCallable;
  private final UnaryCallable<GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListCallable;
  private final UnaryCallable<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
      listCertificateRevocationListsCallable;
  private final UnaryCallable<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsPagedResponse>
      listCertificateRevocationListsPagedCallable;
  private final UnaryCallable<UpdateCertificateRevocationListRequest, Operation>
      updateCertificateRevocationListCallable;
  private final OperationCallable<
          UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
      updateCertificateRevocationListOperationCallable;
  private final UnaryCallable<CreateCertificateTemplateRequest, Operation>
      createCertificateTemplateCallable;
  private final OperationCallable<
          CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      createCertificateTemplateOperationCallable;
  private final UnaryCallable<DeleteCertificateTemplateRequest, Operation>
      deleteCertificateTemplateCallable;
  private final OperationCallable<DeleteCertificateTemplateRequest, Empty, OperationMetadata>
      deleteCertificateTemplateOperationCallable;
  private final UnaryCallable<GetCertificateTemplateRequest, CertificateTemplate>
      getCertificateTemplateCallable;
  private final UnaryCallable<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>
      listCertificateTemplatesCallable;
  private final UnaryCallable<
          ListCertificateTemplatesRequest, ListCertificateTemplatesPagedResponse>
      listCertificateTemplatesPagedCallable;
  private final UnaryCallable<UpdateCertificateTemplateRequest, Operation>
      updateCertificateTemplateCallable;
  private final OperationCallable<
          UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      updateCertificateTemplateOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCertificateAuthorityServiceStub create(
      CertificateAuthorityServiceStubSettings settings) throws IOException {
    return new GrpcCertificateAuthorityServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCertificateAuthorityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCertificateAuthorityServiceStub(
        CertificateAuthorityServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCertificateAuthorityServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCertificateAuthorityServiceStub(
        CertificateAuthorityServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcCertificateAuthorityServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCertificateAuthorityServiceStub(
      CertificateAuthorityServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcCertificateAuthorityServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCertificateAuthorityServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCertificateAuthorityServiceStub(
      CertificateAuthorityServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateCertificateRequest, Certificate> createCertificateTransportSettings =
        GrpcCallSettings.<CreateCertificateRequest, Certificate>newBuilder()
            .setMethodDescriptor(createCertificateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCertificateRequest, Certificate> getCertificateTransportSettings =
        GrpcCallSettings.<GetCertificateRequest, Certificate>newBuilder()
            .setMethodDescriptor(getCertificateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCertificatesRequest, ListCertificatesResponse>
        listCertificatesTransportSettings =
            GrpcCallSettings.<ListCertificatesRequest, ListCertificatesResponse>newBuilder()
                .setMethodDescriptor(listCertificatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<RevokeCertificateRequest, Certificate> revokeCertificateTransportSettings =
        GrpcCallSettings.<RevokeCertificateRequest, Certificate>newBuilder()
            .setMethodDescriptor(revokeCertificateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCertificateRequest, Certificate> updateCertificateTransportSettings =
        GrpcCallSettings.<UpdateCertificateRequest, Certificate>newBuilder()
            .setMethodDescriptor(updateCertificateMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "certificate.name", String.valueOf(request.getCertificate().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ActivateCertificateAuthorityRequest, Operation>
        activateCertificateAuthorityTransportSettings =
            GrpcCallSettings.<ActivateCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(activateCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateCertificateAuthorityRequest, Operation>
        createCertificateAuthorityTransportSettings =
            GrpcCallSettings.<CreateCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(createCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DisableCertificateAuthorityRequest, Operation>
        disableCertificateAuthorityTransportSettings =
            GrpcCallSettings.<DisableCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(disableCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<EnableCertificateAuthorityRequest, Operation>
        enableCertificateAuthorityTransportSettings =
            GrpcCallSettings.<EnableCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(enableCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
        fetchCertificateAuthorityCsrTransportSettings =
            GrpcCallSettings
                .<FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
                    newBuilder()
                .setMethodDescriptor(fetchCertificateAuthorityCsrMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCertificateAuthorityRequest, CertificateAuthority>
        getCertificateAuthorityTransportSettings =
            GrpcCallSettings.<GetCertificateAuthorityRequest, CertificateAuthority>newBuilder()
                .setMethodDescriptor(getCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>
        listCertificateAuthoritiesTransportSettings =
            GrpcCallSettings
                .<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>newBuilder()
                .setMethodDescriptor(listCertificateAuthoritiesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UndeleteCertificateAuthorityRequest, Operation>
        undeleteCertificateAuthorityTransportSettings =
            GrpcCallSettings.<UndeleteCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(undeleteCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteCertificateAuthorityRequest, Operation>
        deleteCertificateAuthorityTransportSettings =
            GrpcCallSettings.<DeleteCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateCertificateAuthorityRequest, Operation>
        updateCertificateAuthorityTransportSettings =
            GrpcCallSettings.<UpdateCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(updateCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "certificate_authority.name",
                          String.valueOf(request.getCertificateAuthority().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateCaPoolRequest, Operation> createCaPoolTransportSettings =
        GrpcCallSettings.<CreateCaPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createCaPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateCaPoolRequest, Operation> updateCaPoolTransportSettings =
        GrpcCallSettings.<UpdateCaPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCaPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("ca_pool.name", String.valueOf(request.getCaPool().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCaPoolRequest, CaPool> getCaPoolTransportSettings =
        GrpcCallSettings.<GetCaPoolRequest, CaPool>newBuilder()
            .setMethodDescriptor(getCaPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListCaPoolsRequest, ListCaPoolsResponse> listCaPoolsTransportSettings =
        GrpcCallSettings.<ListCaPoolsRequest, ListCaPoolsResponse>newBuilder()
            .setMethodDescriptor(listCaPoolsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteCaPoolRequest, Operation> deleteCaPoolTransportSettings =
        GrpcCallSettings.<DeleteCaPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCaPoolMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<FetchCaCertsRequest, FetchCaCertsResponse> fetchCaCertsTransportSettings =
        GrpcCallSettings.<FetchCaCertsRequest, FetchCaCertsResponse>newBuilder()
            .setMethodDescriptor(fetchCaCertsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("ca_pool", String.valueOf(request.getCaPool()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetCertificateRevocationListRequest, CertificateRevocationList>
        getCertificateRevocationListTransportSettings =
            GrpcCallSettings
                .<GetCertificateRevocationListRequest, CertificateRevocationList>newBuilder()
                .setMethodDescriptor(getCertificateRevocationListMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
        listCertificateRevocationListsTransportSettings =
            GrpcCallSettings
                .<ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
                    newBuilder()
                .setMethodDescriptor(listCertificateRevocationListsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateCertificateRevocationListRequest, Operation>
        updateCertificateRevocationListTransportSettings =
            GrpcCallSettings.<UpdateCertificateRevocationListRequest, Operation>newBuilder()
                .setMethodDescriptor(updateCertificateRevocationListMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "certificate_revocation_list.name",
                          String.valueOf(request.getCertificateRevocationList().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateCertificateTemplateRequest, Operation>
        createCertificateTemplateTransportSettings =
            GrpcCallSettings.<CreateCertificateTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(createCertificateTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteCertificateTemplateRequest, Operation>
        deleteCertificateTemplateTransportSettings =
            GrpcCallSettings.<DeleteCertificateTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCertificateTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetCertificateTemplateRequest, CertificateTemplate>
        getCertificateTemplateTransportSettings =
            GrpcCallSettings.<GetCertificateTemplateRequest, CertificateTemplate>newBuilder()
                .setMethodDescriptor(getCertificateTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>
        listCertificateTemplatesTransportSettings =
            GrpcCallSettings
                .<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>newBuilder()
                .setMethodDescriptor(listCertificateTemplatesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateCertificateTemplateRequest, Operation>
        updateCertificateTemplateTransportSettings =
            GrpcCallSettings.<UpdateCertificateTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(updateCertificateTemplateMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "certificate_template.name",
                          String.valueOf(request.getCertificateTemplate().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("resource", String.valueOf(request.getResource()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("resource", String.valueOf(request.getResource()));
                      return params.build();
                    })
                .build();

    this.createCertificateCallable =
        callableFactory.createUnaryCallable(
            createCertificateTransportSettings,
            settings.createCertificateSettings(),
            clientContext);
    this.getCertificateCallable =
        callableFactory.createUnaryCallable(
            getCertificateTransportSettings, settings.getCertificateSettings(), clientContext);
    this.listCertificatesCallable =
        callableFactory.createUnaryCallable(
            listCertificatesTransportSettings, settings.listCertificatesSettings(), clientContext);
    this.listCertificatesPagedCallable =
        callableFactory.createPagedCallable(
            listCertificatesTransportSettings, settings.listCertificatesSettings(), clientContext);
    this.revokeCertificateCallable =
        callableFactory.createUnaryCallable(
            revokeCertificateTransportSettings,
            settings.revokeCertificateSettings(),
            clientContext);
    this.updateCertificateCallable =
        callableFactory.createUnaryCallable(
            updateCertificateTransportSettings,
            settings.updateCertificateSettings(),
            clientContext);
    this.activateCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            activateCertificateAuthorityTransportSettings,
            settings.activateCertificateAuthoritySettings(),
            clientContext);
    this.activateCertificateAuthorityOperationCallable =
        callableFactory.createOperationCallable(
            activateCertificateAuthorityTransportSettings,
            settings.activateCertificateAuthorityOperationSettings(),
            clientContext,
            operationsStub);
    this.createCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            createCertificateAuthorityTransportSettings,
            settings.createCertificateAuthoritySettings(),
            clientContext);
    this.createCertificateAuthorityOperationCallable =
        callableFactory.createOperationCallable(
            createCertificateAuthorityTransportSettings,
            settings.createCertificateAuthorityOperationSettings(),
            clientContext,
            operationsStub);
    this.disableCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            disableCertificateAuthorityTransportSettings,
            settings.disableCertificateAuthoritySettings(),
            clientContext);
    this.disableCertificateAuthorityOperationCallable =
        callableFactory.createOperationCallable(
            disableCertificateAuthorityTransportSettings,
            settings.disableCertificateAuthorityOperationSettings(),
            clientContext,
            operationsStub);
    this.enableCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            enableCertificateAuthorityTransportSettings,
            settings.enableCertificateAuthoritySettings(),
            clientContext);
    this.enableCertificateAuthorityOperationCallable =
        callableFactory.createOperationCallable(
            enableCertificateAuthorityTransportSettings,
            settings.enableCertificateAuthorityOperationSettings(),
            clientContext,
            operationsStub);
    this.fetchCertificateAuthorityCsrCallable =
        callableFactory.createUnaryCallable(
            fetchCertificateAuthorityCsrTransportSettings,
            settings.fetchCertificateAuthorityCsrSettings(),
            clientContext);
    this.getCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            getCertificateAuthorityTransportSettings,
            settings.getCertificateAuthoritySettings(),
            clientContext);
    this.listCertificateAuthoritiesCallable =
        callableFactory.createUnaryCallable(
            listCertificateAuthoritiesTransportSettings,
            settings.listCertificateAuthoritiesSettings(),
            clientContext);
    this.listCertificateAuthoritiesPagedCallable =
        callableFactory.createPagedCallable(
            listCertificateAuthoritiesTransportSettings,
            settings.listCertificateAuthoritiesSettings(),
            clientContext);
    this.undeleteCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            undeleteCertificateAuthorityTransportSettings,
            settings.undeleteCertificateAuthoritySettings(),
            clientContext);
    this.undeleteCertificateAuthorityOperationCallable =
        callableFactory.createOperationCallable(
            undeleteCertificateAuthorityTransportSettings,
            settings.undeleteCertificateAuthorityOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            deleteCertificateAuthorityTransportSettings,
            settings.deleteCertificateAuthoritySettings(),
            clientContext);
    this.deleteCertificateAuthorityOperationCallable =
        callableFactory.createOperationCallable(
            deleteCertificateAuthorityTransportSettings,
            settings.deleteCertificateAuthorityOperationSettings(),
            clientContext,
            operationsStub);
    this.updateCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            updateCertificateAuthorityTransportSettings,
            settings.updateCertificateAuthoritySettings(),
            clientContext);
    this.updateCertificateAuthorityOperationCallable =
        callableFactory.createOperationCallable(
            updateCertificateAuthorityTransportSettings,
            settings.updateCertificateAuthorityOperationSettings(),
            clientContext,
            operationsStub);
    this.createCaPoolCallable =
        callableFactory.createUnaryCallable(
            createCaPoolTransportSettings, settings.createCaPoolSettings(), clientContext);
    this.createCaPoolOperationCallable =
        callableFactory.createOperationCallable(
            createCaPoolTransportSettings,
            settings.createCaPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.updateCaPoolCallable =
        callableFactory.createUnaryCallable(
            updateCaPoolTransportSettings, settings.updateCaPoolSettings(), clientContext);
    this.updateCaPoolOperationCallable =
        callableFactory.createOperationCallable(
            updateCaPoolTransportSettings,
            settings.updateCaPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.getCaPoolCallable =
        callableFactory.createUnaryCallable(
            getCaPoolTransportSettings, settings.getCaPoolSettings(), clientContext);
    this.listCaPoolsCallable =
        callableFactory.createUnaryCallable(
            listCaPoolsTransportSettings, settings.listCaPoolsSettings(), clientContext);
    this.listCaPoolsPagedCallable =
        callableFactory.createPagedCallable(
            listCaPoolsTransportSettings, settings.listCaPoolsSettings(), clientContext);
    this.deleteCaPoolCallable =
        callableFactory.createUnaryCallable(
            deleteCaPoolTransportSettings, settings.deleteCaPoolSettings(), clientContext);
    this.deleteCaPoolOperationCallable =
        callableFactory.createOperationCallable(
            deleteCaPoolTransportSettings,
            settings.deleteCaPoolOperationSettings(),
            clientContext,
            operationsStub);
    this.fetchCaCertsCallable =
        callableFactory.createUnaryCallable(
            fetchCaCertsTransportSettings, settings.fetchCaCertsSettings(), clientContext);
    this.getCertificateRevocationListCallable =
        callableFactory.createUnaryCallable(
            getCertificateRevocationListTransportSettings,
            settings.getCertificateRevocationListSettings(),
            clientContext);
    this.listCertificateRevocationListsCallable =
        callableFactory.createUnaryCallable(
            listCertificateRevocationListsTransportSettings,
            settings.listCertificateRevocationListsSettings(),
            clientContext);
    this.listCertificateRevocationListsPagedCallable =
        callableFactory.createPagedCallable(
            listCertificateRevocationListsTransportSettings,
            settings.listCertificateRevocationListsSettings(),
            clientContext);
    this.updateCertificateRevocationListCallable =
        callableFactory.createUnaryCallable(
            updateCertificateRevocationListTransportSettings,
            settings.updateCertificateRevocationListSettings(),
            clientContext);
    this.updateCertificateRevocationListOperationCallable =
        callableFactory.createOperationCallable(
            updateCertificateRevocationListTransportSettings,
            settings.updateCertificateRevocationListOperationSettings(),
            clientContext,
            operationsStub);
    this.createCertificateTemplateCallable =
        callableFactory.createUnaryCallable(
            createCertificateTemplateTransportSettings,
            settings.createCertificateTemplateSettings(),
            clientContext);
    this.createCertificateTemplateOperationCallable =
        callableFactory.createOperationCallable(
            createCertificateTemplateTransportSettings,
            settings.createCertificateTemplateOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteCertificateTemplateCallable =
        callableFactory.createUnaryCallable(
            deleteCertificateTemplateTransportSettings,
            settings.deleteCertificateTemplateSettings(),
            clientContext);
    this.deleteCertificateTemplateOperationCallable =
        callableFactory.createOperationCallable(
            deleteCertificateTemplateTransportSettings,
            settings.deleteCertificateTemplateOperationSettings(),
            clientContext,
            operationsStub);
    this.getCertificateTemplateCallable =
        callableFactory.createUnaryCallable(
            getCertificateTemplateTransportSettings,
            settings.getCertificateTemplateSettings(),
            clientContext);
    this.listCertificateTemplatesCallable =
        callableFactory.createUnaryCallable(
            listCertificateTemplatesTransportSettings,
            settings.listCertificateTemplatesSettings(),
            clientContext);
    this.listCertificateTemplatesPagedCallable =
        callableFactory.createPagedCallable(
            listCertificateTemplatesTransportSettings,
            settings.listCertificateTemplatesSettings(),
            clientContext);
    this.updateCertificateTemplateCallable =
        callableFactory.createUnaryCallable(
            updateCertificateTemplateTransportSettings,
            settings.updateCertificateTemplateSettings(),
            clientContext);
    this.updateCertificateTemplateOperationCallable =
        callableFactory.createOperationCallable(
            updateCertificateTemplateTransportSettings,
            settings.updateCertificateTemplateOperationSettings(),
            clientContext,
            operationsStub);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateCertificateRequest, Certificate> createCertificateCallable() {
    return createCertificateCallable;
  }

  @Override
  public UnaryCallable<GetCertificateRequest, Certificate> getCertificateCallable() {
    return getCertificateCallable;
  }

  @Override
  public UnaryCallable<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesCallable() {
    return listCertificatesCallable;
  }

  @Override
  public UnaryCallable<ListCertificatesRequest, ListCertificatesPagedResponse>
      listCertificatesPagedCallable() {
    return listCertificatesPagedCallable;
  }

  @Override
  public UnaryCallable<RevokeCertificateRequest, Certificate> revokeCertificateCallable() {
    return revokeCertificateCallable;
  }

  @Override
  public UnaryCallable<UpdateCertificateRequest, Certificate> updateCertificateCallable() {
    return updateCertificateCallable;
  }

  @Override
  public UnaryCallable<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthorityCallable() {
    return activateCertificateAuthorityCallable;
  }

  @Override
  public OperationCallable<
          ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityOperationCallable() {
    return activateCertificateAuthorityOperationCallable;
  }

  @Override
  public UnaryCallable<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthorityCallable() {
    return createCertificateAuthorityCallable;
  }

  @Override
  public OperationCallable<
          CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      createCertificateAuthorityOperationCallable() {
    return createCertificateAuthorityOperationCallable;
  }

  @Override
  public UnaryCallable<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthorityCallable() {
    return disableCertificateAuthorityCallable;
  }

  @Override
  public OperationCallable<
          DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityOperationCallable() {
    return disableCertificateAuthorityOperationCallable;
  }

  @Override
  public UnaryCallable<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthorityCallable() {
    return enableCertificateAuthorityCallable;
  }

  @Override
  public OperationCallable<
          EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityOperationCallable() {
    return enableCertificateAuthorityOperationCallable;
  }

  @Override
  public UnaryCallable<FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
      fetchCertificateAuthorityCsrCallable() {
    return fetchCertificateAuthorityCsrCallable;
  }

  @Override
  public UnaryCallable<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityCallable() {
    return getCertificateAuthorityCallable;
  }

  @Override
  public UnaryCallable<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>
      listCertificateAuthoritiesCallable() {
    return listCertificateAuthoritiesCallable;
  }

  @Override
  public UnaryCallable<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesPagedResponse>
      listCertificateAuthoritiesPagedCallable() {
    return listCertificateAuthoritiesPagedCallable;
  }

  @Override
  public UnaryCallable<UndeleteCertificateAuthorityRequest, Operation>
      undeleteCertificateAuthorityCallable() {
    return undeleteCertificateAuthorityCallable;
  }

  @Override
  public OperationCallable<
          UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityOperationCallable() {
    return undeleteCertificateAuthorityOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCertificateAuthorityRequest, Operation>
      deleteCertificateAuthorityCallable() {
    return deleteCertificateAuthorityCallable;
  }

  @Override
  public OperationCallable<
          DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityOperationCallable() {
    return deleteCertificateAuthorityOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthorityCallable() {
    return updateCertificateAuthorityCallable;
  }

  @Override
  public OperationCallable<
          UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityOperationCallable() {
    return updateCertificateAuthorityOperationCallable;
  }

  @Override
  public UnaryCallable<CreateCaPoolRequest, Operation> createCaPoolCallable() {
    return createCaPoolCallable;
  }

  @Override
  public OperationCallable<CreateCaPoolRequest, CaPool, OperationMetadata>
      createCaPoolOperationCallable() {
    return createCaPoolOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateCaPoolRequest, Operation> updateCaPoolCallable() {
    return updateCaPoolCallable;
  }

  @Override
  public OperationCallable<UpdateCaPoolRequest, CaPool, OperationMetadata>
      updateCaPoolOperationCallable() {
    return updateCaPoolOperationCallable;
  }

  @Override
  public UnaryCallable<GetCaPoolRequest, CaPool> getCaPoolCallable() {
    return getCaPoolCallable;
  }

  @Override
  public UnaryCallable<ListCaPoolsRequest, ListCaPoolsResponse> listCaPoolsCallable() {
    return listCaPoolsCallable;
  }

  @Override
  public UnaryCallable<ListCaPoolsRequest, ListCaPoolsPagedResponse> listCaPoolsPagedCallable() {
    return listCaPoolsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteCaPoolRequest, Operation> deleteCaPoolCallable() {
    return deleteCaPoolCallable;
  }

  @Override
  public OperationCallable<DeleteCaPoolRequest, Empty, OperationMetadata>
      deleteCaPoolOperationCallable() {
    return deleteCaPoolOperationCallable;
  }

  @Override
  public UnaryCallable<FetchCaCertsRequest, FetchCaCertsResponse> fetchCaCertsCallable() {
    return fetchCaCertsCallable;
  }

  @Override
  public UnaryCallable<GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListCallable() {
    return getCertificateRevocationListCallable;
  }

  @Override
  public UnaryCallable<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
      listCertificateRevocationListsCallable() {
    return listCertificateRevocationListsCallable;
  }

  @Override
  public UnaryCallable<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsPagedResponse>
      listCertificateRevocationListsPagedCallable() {
    return listCertificateRevocationListsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateCertificateRevocationListRequest, Operation>
      updateCertificateRevocationListCallable() {
    return updateCertificateRevocationListCallable;
  }

  @Override
  public OperationCallable<
          UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
      updateCertificateRevocationListOperationCallable() {
    return updateCertificateRevocationListOperationCallable;
  }

  @Override
  public UnaryCallable<CreateCertificateTemplateRequest, Operation>
      createCertificateTemplateCallable() {
    return createCertificateTemplateCallable;
  }

  @Override
  public OperationCallable<CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      createCertificateTemplateOperationCallable() {
    return createCertificateTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteCertificateTemplateRequest, Operation>
      deleteCertificateTemplateCallable() {
    return deleteCertificateTemplateCallable;
  }

  @Override
  public OperationCallable<DeleteCertificateTemplateRequest, Empty, OperationMetadata>
      deleteCertificateTemplateOperationCallable() {
    return deleteCertificateTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<GetCertificateTemplateRequest, CertificateTemplate>
      getCertificateTemplateCallable() {
    return getCertificateTemplateCallable;
  }

  @Override
  public UnaryCallable<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>
      listCertificateTemplatesCallable() {
    return listCertificateTemplatesCallable;
  }

  @Override
  public UnaryCallable<ListCertificateTemplatesRequest, ListCertificateTemplatesPagedResponse>
      listCertificateTemplatesPagedCallable() {
    return listCertificateTemplatesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateCertificateTemplateRequest, Operation>
      updateCertificateTemplateCallable() {
    return updateCertificateTemplateCallable;
  }

  @Override
  public OperationCallable<UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      updateCertificateTemplateOperationCallable() {
    return updateCertificateTemplateOperationCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
