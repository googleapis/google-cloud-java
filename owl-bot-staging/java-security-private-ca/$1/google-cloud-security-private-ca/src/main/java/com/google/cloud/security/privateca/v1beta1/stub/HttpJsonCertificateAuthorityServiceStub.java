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

package com.google.cloud.security.privateca.v1beta1.stub;

import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateAuthoritiesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificateRevocationListsPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListCertificatesPagedResponse;
import static com.google.cloud.security.privateca.v1beta1.CertificateAuthorityServiceClient.ListReusableConfigsPagedResponse;

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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.security.privateca.v1beta1.ActivateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.Certificate;
import com.google.cloud.security.privateca.v1beta1.CertificateAuthority;
import com.google.cloud.security.privateca.v1beta1.CertificateRevocationList;
import com.google.cloud.security.privateca.v1beta1.CreateCertificateAuthorityRequest;
import com.google.cloud.security.privateca.v1beta1.CreateCertificateRequest;
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
import com.google.longrunning.Operation;
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
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonCertificateAuthorityServiceStub extends CertificateAuthorityServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(CertificateAuthority.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .add(CertificateRevocationList.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateCertificateRequest, Certificate>
      createCertificateMethodDescriptor =
          ApiMethodDescriptor.<CreateCertificateRequest, Certificate>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/CreateCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCertificateRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/certificateAuthorities/*}/certificates",
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
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/GetCertificate")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCertificateRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*/certificates/*}",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ListCertificates")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCertificatesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/certificateAuthorities/*}/certificates",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/RevokeCertificate")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RevokeCertificateRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*/certificates/*}:revoke",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/UpdateCertificate")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCertificateRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{certificate.name=projects/*/locations/*/certificateAuthorities/*/certificates/*}",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ActivateCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ActivateCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*}:activate",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/CreateCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/certificateAuthorities",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/DisableCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DisableCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*}:disable",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/EnableCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<EnableCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*}:enable",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/FetchCertificateAuthorityCsr")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<FetchCertificateAuthorityCsrRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*}:fetch",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/GetCertificateAuthority")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*}",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ListCertificateAuthorities")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCertificateAuthoritiesRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/certificateAuthorities",
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

  private static final ApiMethodDescriptor<RestoreCertificateAuthorityRequest, Operation>
      restoreCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<RestoreCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/RestoreCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RestoreCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*}:restore",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreCertificateAuthorityRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RestoreCertificateAuthorityRequest> serializer =
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
                  (RestoreCertificateAuthorityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ScheduleDeleteCertificateAuthorityRequest, Operation>
      scheduleDeleteCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<ScheduleDeleteCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ScheduleDeleteCertificateAuthority")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ScheduleDeleteCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*}:scheduleDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ScheduleDeleteCertificateAuthorityRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ScheduleDeleteCertificateAuthorityRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (ScheduleDeleteCertificateAuthorityRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthorityMethodDescriptor =
          ApiMethodDescriptor.<UpdateCertificateAuthorityRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/UpdateCertificateAuthority")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCertificateAuthorityRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{certificateAuthority.name=projects/*/locations/*/certificateAuthorities/*}",
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

  private static final ApiMethodDescriptor<
          GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListMethodDescriptor =
          ApiMethodDescriptor
              .<GetCertificateRevocationListRequest, CertificateRevocationList>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/GetCertificateRevocationList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCertificateRevocationListRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/certificateAuthorities/*/certificateRevocationLists/*}",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ListCertificateRevocationLists")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCertificateRevocationListsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*/certificateAuthorities/*}/certificateRevocationLists",
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/UpdateCertificateRevocationList")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCertificateRevocationListRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{certificateRevocationList.name=projects/*/locations/*/certificateAuthorities/*/certificateRevocationLists/*}",
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

  private static final ApiMethodDescriptor<GetReusableConfigRequest, ReusableConfig>
      getReusableConfigMethodDescriptor =
          ApiMethodDescriptor.<GetReusableConfigRequest, ReusableConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/GetReusableConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetReusableConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{name=projects/*/locations/*/reusableConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetReusableConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetReusableConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ReusableConfig>newBuilder()
                      .setDefaultInstance(ReusableConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListReusableConfigsRequest, ListReusableConfigsResponse>
      listReusableConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListReusableConfigsRequest, ListReusableConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ListReusableConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListReusableConfigsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{parent=projects/*/locations/*}/reusableConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListReusableConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListReusableConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListReusableConfigsResponse>newBuilder()
                      .setDefaultInstance(ListReusableConfigsResponse.getDefaultInstance())
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
  private final UnaryCallable<RestoreCertificateAuthorityRequest, Operation>
      restoreCertificateAuthorityCallable;
  private final OperationCallable<
          RestoreCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      restoreCertificateAuthorityOperationCallable;
  private final UnaryCallable<ScheduleDeleteCertificateAuthorityRequest, Operation>
      scheduleDeleteCertificateAuthorityCallable;
  private final OperationCallable<
          ScheduleDeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      scheduleDeleteCertificateAuthorityOperationCallable;
  private final UnaryCallable<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthorityCallable;
  private final OperationCallable<
          UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityOperationCallable;
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
  private final UnaryCallable<GetReusableConfigRequest, ReusableConfig> getReusableConfigCallable;
  private final UnaryCallable<ListReusableConfigsRequest, ListReusableConfigsResponse>
      listReusableConfigsCallable;
  private final UnaryCallable<ListReusableConfigsRequest, ListReusableConfigsPagedResponse>
      listReusableConfigsPagedCallable;

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
    HttpJsonCallSettings<RestoreCertificateAuthorityRequest, Operation>
        restoreCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<RestoreCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(restoreCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ScheduleDeleteCertificateAuthorityRequest, Operation>
        scheduleDeleteCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<ScheduleDeleteCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(scheduleDeleteCertificateAuthorityMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateCertificateAuthorityRequest, Operation>
        updateCertificateAuthorityTransportSettings =
            HttpJsonCallSettings.<UpdateCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(updateCertificateAuthorityMethodDescriptor)
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
    HttpJsonCallSettings<GetReusableConfigRequest, ReusableConfig>
        getReusableConfigTransportSettings =
            HttpJsonCallSettings.<GetReusableConfigRequest, ReusableConfig>newBuilder()
                .setMethodDescriptor(getReusableConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListReusableConfigsRequest, ListReusableConfigsResponse>
        listReusableConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListReusableConfigsRequest, ListReusableConfigsResponse>newBuilder()
                .setMethodDescriptor(listReusableConfigsMethodDescriptor)
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
    this.restoreCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            restoreCertificateAuthorityTransportSettings,
            settings.restoreCertificateAuthoritySettings(),
            clientContext);
    this.restoreCertificateAuthorityOperationCallable =
        callableFactory.createOperationCallable(
            restoreCertificateAuthorityTransportSettings,
            settings.restoreCertificateAuthorityOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.scheduleDeleteCertificateAuthorityCallable =
        callableFactory.createUnaryCallable(
            scheduleDeleteCertificateAuthorityTransportSettings,
            settings.scheduleDeleteCertificateAuthoritySettings(),
            clientContext);
    this.scheduleDeleteCertificateAuthorityOperationCallable =
        callableFactory.createOperationCallable(
            scheduleDeleteCertificateAuthorityTransportSettings,
            settings.scheduleDeleteCertificateAuthorityOperationSettings(),
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
    this.getReusableConfigCallable =
        callableFactory.createUnaryCallable(
            getReusableConfigTransportSettings,
            settings.getReusableConfigSettings(),
            clientContext);
    this.listReusableConfigsCallable =
        callableFactory.createUnaryCallable(
            listReusableConfigsTransportSettings,
            settings.listReusableConfigsSettings(),
            clientContext);
    this.listReusableConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listReusableConfigsTransportSettings,
            settings.listReusableConfigsSettings(),
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
    methodDescriptors.add(restoreCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(scheduleDeleteCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(updateCertificateAuthorityMethodDescriptor);
    methodDescriptors.add(getCertificateRevocationListMethodDescriptor);
    methodDescriptors.add(listCertificateRevocationListsMethodDescriptor);
    methodDescriptors.add(updateCertificateRevocationListMethodDescriptor);
    methodDescriptors.add(getReusableConfigMethodDescriptor);
    methodDescriptors.add(listReusableConfigsMethodDescriptor);
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
  public UnaryCallable<RestoreCertificateAuthorityRequest, Operation>
      restoreCertificateAuthorityCallable() {
    return restoreCertificateAuthorityCallable;
  }

  @Override
  public OperationCallable<
          RestoreCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      restoreCertificateAuthorityOperationCallable() {
    return restoreCertificateAuthorityOperationCallable;
  }

  @Override
  public UnaryCallable<ScheduleDeleteCertificateAuthorityRequest, Operation>
      scheduleDeleteCertificateAuthorityCallable() {
    return scheduleDeleteCertificateAuthorityCallable;
  }

  @Override
  public OperationCallable<
          ScheduleDeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      scheduleDeleteCertificateAuthorityOperationCallable() {
    return scheduleDeleteCertificateAuthorityOperationCallable;
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
  public UnaryCallable<GetReusableConfigRequest, ReusableConfig> getReusableConfigCallable() {
    return getReusableConfigCallable;
  }

  @Override
  public UnaryCallable<ListReusableConfigsRequest, ListReusableConfigsResponse>
      listReusableConfigsCallable() {
    return listReusableConfigsCallable;
  }

  @Override
  public UnaryCallable<ListReusableConfigsRequest, ListReusableConfigsPagedResponse>
      listReusableConfigsPagedCallable() {
    return listReusableConfigsPagedCallable;
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
