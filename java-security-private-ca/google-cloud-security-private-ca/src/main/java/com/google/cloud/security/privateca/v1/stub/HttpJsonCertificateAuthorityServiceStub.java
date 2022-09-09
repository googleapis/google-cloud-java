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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CertificateAuthorityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonCertificateAuthorityServiceStub extends CertificateAuthorityServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(CaPool.getDescriptor())
          .add(CertificateRevocationList.getDescriptor())
          .add(CertificateAuthority.getDescriptor())
          .add(CertificateTemplate.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateCertificateRequest, Certificate>
      createCertificateMethodDescriptor =
          ApiMethodDescriptor.<CreateCertificateRequest, Certificate>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/CreateCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCertificateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/caPools/*}/certificates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "certificateId", request.getCertificateId());
                            serializer.putQueryParam(
                                fields,
                                "issuingCertificateAuthorityId",
                                request.getIssuingCertificateAuthorityId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("certificate", request.getCertificate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Certificate>newBuilder()
                      .setDefaultInstance(Certificate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCertificateRequest, Certificate>
      getCertificateMethodDescriptor =
          ApiMethodDescriptor.<GetCertificateRequest, Certificate>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCertificate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCertificateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Certificate>newBuilder()
                      .setDefaultInstance(Certificate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesMethodDescriptor =
          ApiMethodDescriptor.<ListCertificatesRequest, ListCertificatesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCertificates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCertificatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/caPools/*}/certificates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCertificatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCertificatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCertificatesResponse>newBuilder()
                      .setDefaultInstance(ListCertificatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RevokeCertificateRequest, Certificate>
      revokeCertificateMethodDescriptor =
          ApiMethodDescriptor.<RevokeCertificateRequest, Certificate>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/RevokeCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RevokeCertificateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificates/*}:revoke",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RevokeCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RevokeCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Certificate>newBuilder()
                      .setDefaultInstance(Certificate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCertificateRequest, Certificate>
      updateCertificateMethodDescriptor =
          ApiMethodDescriptor.<UpdateCertificateRequest, Certificate>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCertificate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCertificateRequest>newBuilder()
                      .setPath(
                          "/v1/{certificate.name=projects/*/locations/*/caPools/*/certificates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "certificate.name", request.getCertificate().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCertificateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("certificate", request.getCertificate(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Certificate>newBuilder()
                      .setDefaultInstance(Certificate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<ActivateCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ActivateCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ActivateCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificateAuthorities/*}:activate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ActivateCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ActivateCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ActivateCertificateAuthorityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<CreateCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/CreateCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/caPools/*}/certificateAuthorities",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "certificateAuthorityId",
                                request.getCertificateAuthorityId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "certificateAuthority",
                                      request.getCertificateAuthority(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCertificateAuthorityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<DisableCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/DisableCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificateAuthorities/*}:disable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DisableCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DisableCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DisableCertificateAuthorityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<EnableCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/EnableCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificateAuthorities/*}:enable",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<EnableCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<EnableCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (EnableCertificateAuthorityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
      fetchCertificateAuthorityCsrMethodDescriptor =
          ApiMethodDescriptor
              .<FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/FetchCertificateAuthorityCsr")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchCertificateAuthorityCsrRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificateAuthorities/*}:fetch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchCertificateAuthorityCsrRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchCertificateAuthorityCsrRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchCertificateAuthorityCsrResponse>newBuilder()
                      .setDefaultInstance(FetchCertificateAuthorityCsrResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<GetCertificateAuthorityRequest, CertificateAuthority>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCertificateAuthority")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificateAuthorities/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CertificateAuthority>newBuilder()
                      .setDefaultInstance(CertificateAuthority.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>
      listCertificateAuthoritiesMethodDescriptor =
          ApiMethodDescriptor
              .<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCertificateAuthorities")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCertificateAuthoritiesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/caPools/*}/certificateAuthorities",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCertificateAuthoritiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCertificateAuthoritiesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCertificateAuthoritiesResponse>newBuilder()
                      .setDefaultInstance(ListCertificateAuthoritiesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UndeleteCertificateAuthorityRequest, Operation>
      undeleteCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<UndeleteCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UndeleteCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificateAuthorities/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeleteCertificateAuthorityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCertificateAuthorityRequest, Operation>
      deleteCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<DeleteCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/DeleteCertificateAuthority")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificateAuthorities/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "ignoreActiveCertificates",
                                request.getIgnoreActiveCertificates());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "skipGracePeriod", request.getSkipGracePeriod());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteCertificateAuthorityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<UpdateCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCertificateAuthority")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1/{certificateAuthority.name=projects/*/locations/*/caPools/*/certificateAuthorities/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "certificateAuthority.name",
                                request.getCertificateAuthority().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "certificateAuthority",
                                      request.getCertificateAuthority(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCertificateAuthorityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateCaPoolRequest, Operation>
      createCaPoolMethodDescriptor =
          ApiMethodDescriptor.<CreateCaPoolRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/CreateCaPool")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCaPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/caPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCaPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCaPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "caPoolId", request.getCaPoolId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("caPool", request.getCaPool(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCaPoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateCaPoolRequest, Operation>
      updateCaPoolMethodDescriptor =
          ApiMethodDescriptor.<UpdateCaPoolRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCaPool")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCaPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{caPool.name=projects/*/locations/*/caPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCaPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "caPool.name", request.getCaPool().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCaPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("caPool", request.getCaPool(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCaPoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetCaPoolRequest, CaPool> getCaPoolMethodDescriptor =
      ApiMethodDescriptor.<GetCaPoolRequest, CaPool>newBuilder()
          .setFullMethodName(
              "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCaPool")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetCaPoolRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/caPools/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetCaPoolRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetCaPoolRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<CaPool>newBuilder()
                  .setDefaultInstance(CaPool.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListCaPoolsRequest, ListCaPoolsResponse>
      listCaPoolsMethodDescriptor =
          ApiMethodDescriptor.<ListCaPoolsRequest, ListCaPoolsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCaPools")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCaPoolsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/caPools",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCaPoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCaPoolsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCaPoolsResponse>newBuilder()
                      .setDefaultInstance(ListCaPoolsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCaPoolRequest, Operation>
      deleteCaPoolMethodDescriptor =
          ApiMethodDescriptor.<DeleteCaPoolRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/DeleteCaPool")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCaPoolRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCaPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCaPoolRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteCaPoolRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<FetchCaCertsRequest, FetchCaCertsResponse>
      fetchCaCertsMethodDescriptor =
          ApiMethodDescriptor.<FetchCaCertsRequest, FetchCaCertsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/FetchCaCerts")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchCaCertsRequest>newBuilder()
                      .setPath(
                          "/v1/{caPool=projects/*/locations/*/caPools/*}:fetchCaCerts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<FetchCaCertsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "caPool", request.getCaPool());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<FetchCaCertsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearCaPool().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FetchCaCertsResponse>newBuilder()
                      .setDefaultInstance(FetchCaCertsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListMethodDescriptor =
          ApiMethodDescriptor
              .<GetCertificateRevocationListRequest, CertificateRevocationList>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCertificateRevocationList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCertificateRevocationListRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/caPools/*/certificateAuthorities/*/certificateRevocationLists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCertificateRevocationListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCertificateRevocationListRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CertificateRevocationList>newBuilder()
                      .setDefaultInstance(CertificateRevocationList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
      listCertificateRevocationListsMethodDescriptor =
          ApiMethodDescriptor
              .<ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCertificateRevocationLists")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCertificateRevocationListsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/caPools/*/certificateAuthorities/*}/certificateRevocationLists",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCertificateRevocationListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCertificateRevocationListsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCertificateRevocationListsResponse>newBuilder()
                      .setDefaultInstance(
                          ListCertificateRevocationListsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCertificateRevocationListRequest, Operation>
      updateCertificateRevocationListMethodDescriptor =
          ApiMethodDescriptor.<UpdateCertificateRevocationListRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCertificateRevocationList")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCertificateRevocationListRequest>newBuilder()
                      .setPath(
                          "/v1/{certificateRevocationList.name=projects/*/locations/*/caPools/*/certificateAuthorities/*/certificateRevocationLists/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCertificateRevocationListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "certificateRevocationList.name",
                                request.getCertificateRevocationList().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCertificateRevocationListRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "certificateRevocationList",
                                      request.getCertificateRevocationList(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCertificateRevocationListRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateCertificateTemplateRequest, Operation>
      createCertificateTemplateMethodDescriptor =
          ApiMethodDescriptor.<CreateCertificateTemplateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/CreateCertificateTemplate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCertificateTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/certificateTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCertificateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCertificateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "certificateTemplateId",
                                request.getCertificateTemplateId());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "certificateTemplate",
                                      request.getCertificateTemplate(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateCertificateTemplateRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteCertificateTemplateRequest, Operation>
      deleteCertificateTemplateMethodDescriptor =
          ApiMethodDescriptor.<DeleteCertificateTemplateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/DeleteCertificateTemplate")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCertificateTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/certificateTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCertificateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCertificateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteCertificateTemplateRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetCertificateTemplateRequest, CertificateTemplate>
      getCertificateTemplateMethodDescriptor =
          ApiMethodDescriptor.<GetCertificateTemplateRequest, CertificateTemplate>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/GetCertificateTemplate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCertificateTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/certificateTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCertificateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCertificateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CertificateTemplate>newBuilder()
                      .setDefaultInstance(CertificateTemplate.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>
      listCertificateTemplatesMethodDescriptor =
          ApiMethodDescriptor
              .<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/ListCertificateTemplates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCertificateTemplatesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/certificateTemplates",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCertificateTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCertificateTemplatesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCertificateTemplatesResponse>newBuilder()
                      .setDefaultInstance(ListCertificateTemplatesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCertificateTemplateRequest, Operation>
      updateCertificateTemplateMethodDescriptor =
          ApiMethodDescriptor.<UpdateCertificateTemplateRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1.CertificateAuthorityService/UpdateCertificateTemplate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCertificateTemplateRequest>newBuilder()
                      .setPath(
                          "/v1/{certificateTemplate.name=projects/*/locations/*/certificateTemplates/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCertificateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "certificateTemplate.name",
                                request.getCertificateTemplate().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCertificateTemplateRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "certificateTemplate",
                                      request.getCertificateTemplate(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCertificateTemplateRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/caPools/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/certificateTemplates/*}:setIamPolicy",
                          "/v1/{resource=projects/*/locations/*/caPools/*/certificateAuthorities/*/certificateRevocationLists/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/caPools/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/certificateTemplates/*}:getIamPolicy",
                          "/v1/{resource=projects/*/locations/*/caPools/*/certificateAuthorities/*/certificateRevocationLists/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1/{resource=projects/*/locations/*/caPools/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{resource=projects/*/locations/*/certificateTemplates/*}:testIamPermissions",
                          "/v1/{resource=projects/*/locations/*/caPools/*/certificateAuthorities/*/certificateRevocationLists/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCertificateAuthorityServiceStub create(
      CertificateAuthorityServiceStubSettings settings) throws IOException {
    return new HttpJsonCertificateAuthorityServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCertificateAuthorityServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCertificateAuthorityServiceStub(
        CertificateAuthorityServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCertificateAuthorityServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCertificateAuthorityServiceStub(
        CertificateAuthorityServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCertificateAuthorityServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCertificateAuthorityServiceStub(
      CertificateAuthorityServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCertificateAuthorityServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCertificateAuthorityServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonCertificateAuthorityServiceStub(
      CertificateAuthorityServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateCertificateRequest, Certificate> createCertificateTransportSettings =
        HttpJsonCallSettings.<CreateCertificateRequest, Certificate>newBuilder()
            .setMethodDescriptor(createCertificateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetCertificateRequest, Certificate> getCertificateTransportSettings =
        HttpJsonCallSettings.<GetCertificateRequest, Certificate>newBuilder()
            .setMethodDescriptor(getCertificateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCertificatesRequest, ListCertificatesResponse>
        listCertificatesTransportSettings =
            HttpJsonCallSettings.<ListCertificatesRequest, ListCertificatesResponse>newBuilder()
                .setMethodDescriptor(listCertificatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RevokeCertificateRequest, Certificate> revokeCertificateTransportSettings =
        HttpJsonCallSettings.<RevokeCertificateRequest, Certificate>newBuilder()
            .setMethodDescriptor(revokeCertificateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateCertificateRequest, Certificate> updateCertificateTransportSettings =
        HttpJsonCallSettings.<UpdateCertificateRequest, Certificate>newBuilder()
            .setMethodDescriptor(updateCertificateMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ActivateCertificateAuthorityRequest, Operation>
        activateCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<ActivateCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(activateCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateCertificateAuthorityRequest, Operation>
        createCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<CreateCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(createCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DisableCertificateAuthorityRequest, Operation>
        disableCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<DisableCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(disableCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<EnableCertificateAuthorityRequest, Operation>
        enableCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<EnableCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(enableCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
        fetchCertificateAuthorityCsrTransportSettings =
            HttpJsonCallSettings
                .<FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
                    newBuilder()
                .setMethodDescriptor(fetchCertificateAuthorityCsrMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetCertificateAuthorityRequest, CertificateAuthority>
        getCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<GetCertificateAuthorityRequest, CertificateAuthority>newBuilder()
                .setMethodDescriptor(getCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>
        listCertificateAuthoritiesTransportSettings =
            HttpJsonCallSettings
                .<ListCertificateAuthoritiesRequest, ListCertificateAuthoritiesResponse>newBuilder()
                .setMethodDescriptor(listCertificateAuthoritiesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UndeleteCertificateAuthorityRequest, Operation>
        undeleteCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<UndeleteCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(undeleteCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteCertificateAuthorityRequest, Operation>
        deleteCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<DeleteCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCertificateAuthorityRequest, Operation>
        updateCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<UpdateCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(updateCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateCaPoolRequest, Operation> createCaPoolTransportSettings =
        HttpJsonCallSettings.<CreateCaPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(createCaPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateCaPoolRequest, Operation> updateCaPoolTransportSettings =
        HttpJsonCallSettings.<UpdateCaPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCaPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetCaPoolRequest, CaPool> getCaPoolTransportSettings =
        HttpJsonCallSettings.<GetCaPoolRequest, CaPool>newBuilder()
            .setMethodDescriptor(getCaPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListCaPoolsRequest, ListCaPoolsResponse> listCaPoolsTransportSettings =
        HttpJsonCallSettings.<ListCaPoolsRequest, ListCaPoolsResponse>newBuilder()
            .setMethodDescriptor(listCaPoolsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteCaPoolRequest, Operation> deleteCaPoolTransportSettings =
        HttpJsonCallSettings.<DeleteCaPoolRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCaPoolMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<FetchCaCertsRequest, FetchCaCertsResponse> fetchCaCertsTransportSettings =
        HttpJsonCallSettings.<FetchCaCertsRequest, FetchCaCertsResponse>newBuilder()
            .setMethodDescriptor(fetchCaCertsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetCertificateRevocationListRequest, CertificateRevocationList>
        getCertificateRevocationListTransportSettings =
            HttpJsonCallSettings
                .<GetCertificateRevocationListRequest, CertificateRevocationList>newBuilder()
                .setMethodDescriptor(getCertificateRevocationListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
        listCertificateRevocationListsTransportSettings =
            HttpJsonCallSettings
                .<ListCertificateRevocationListsRequest, ListCertificateRevocationListsResponse>
                    newBuilder()
                .setMethodDescriptor(listCertificateRevocationListsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCertificateRevocationListRequest, Operation>
        updateCertificateRevocationListTransportSettings =
            HttpJsonCallSettings.<UpdateCertificateRevocationListRequest, Operation>newBuilder()
                .setMethodDescriptor(updateCertificateRevocationListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateCertificateTemplateRequest, Operation>
        createCertificateTemplateTransportSettings =
            HttpJsonCallSettings.<CreateCertificateTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(createCertificateTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteCertificateTemplateRequest, Operation>
        deleteCertificateTemplateTransportSettings =
            HttpJsonCallSettings.<DeleteCertificateTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteCertificateTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetCertificateTemplateRequest, CertificateTemplate>
        getCertificateTemplateTransportSettings =
            HttpJsonCallSettings.<GetCertificateTemplateRequest, CertificateTemplate>newBuilder()
                .setMethodDescriptor(getCertificateTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>
        listCertificateTemplatesTransportSettings =
            HttpJsonCallSettings
                .<ListCertificateTemplatesRequest, ListCertificateTemplatesResponse>newBuilder()
                .setMethodDescriptor(listCertificateTemplatesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCertificateTemplateRequest, Operation>
        updateCertificateTemplateTransportSettings =
            HttpJsonCallSettings.<UpdateCertificateTemplateRequest, Operation>newBuilder()
                .setMethodDescriptor(updateCertificateTemplateMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.createCaPoolCallable =
        callableFactory.createUnaryCallable(
            createCaPoolTransportSettings, settings.createCaPoolSettings(), clientContext);
    this.createCaPoolOperationCallable =
        callableFactory.createOperationCallable(
            createCaPoolTransportSettings,
            settings.createCaPoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateCaPoolCallable =
        callableFactory.createUnaryCallable(
            updateCaPoolTransportSettings, settings.updateCaPoolSettings(), clientContext);
    this.updateCaPoolOperationCallable =
        callableFactory.createOperationCallable(
            updateCaPoolTransportSettings,
            settings.updateCaPoolOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createCertificateMethodDescriptor);
    methodDescriptors.add(getCertificateMethodDescriptor);
    methodDescriptors.add(listCertificatesMethodDescriptor);
    methodDescriptors.add(revokeCertificateMethodDescriptor);
    methodDescriptors.add(updateCertificateMethodDescriptor);
    methodDescriptors.add(activateCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(createCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(disableCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(enableCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(fetchCertificateAuthorityCsrMethodDescriptor);
    methodDescriptors.add(getCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(listCertificateAuthoritiesMethodDescriptor);
    methodDescriptors.add(undeleteCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(deleteCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(updateCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(createCaPoolMethodDescriptor);
    methodDescriptors.add(updateCaPoolMethodDescriptor);
    methodDescriptors.add(getCaPoolMethodDescriptor);
    methodDescriptors.add(listCaPoolsMethodDescriptor);
    methodDescriptors.add(deleteCaPoolMethodDescriptor);
    methodDescriptors.add(fetchCaCertsMethodDescriptor);
    methodDescriptors.add(getCertificateRevocationListMethodDescriptor);
    methodDescriptors.add(listCertificateRevocationListsMethodDescriptor);
    methodDescriptors.add(updateCertificateRevocationListMethodDescriptor);
    methodDescriptors.add(createCertificateTemplateMethodDescriptor);
    methodDescriptors.add(deleteCertificateTemplateMethodDescriptor);
    methodDescriptors.add(getCertificateTemplateMethodDescriptor);
    methodDescriptors.add(listCertificateTemplatesMethodDescriptor);
    methodDescriptors.add(updateCertificateTemplateMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
