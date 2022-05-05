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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
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
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcCertificateAuthorityServiceStub extends CertificateAuthorityServiceStub {
  private static final MethodDescriptor<CreateCertificateRequest, Certificate>
      createCertificateMethodDescriptor =
          MethodDescriptor.<CreateCertificateRequest, Certificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/CreateCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Certificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetCertificateRequest, Certificate>
      getCertificateMethodDescriptor =
          MethodDescriptor.<GetCertificateRequest, Certificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/GetCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Certificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListCertificatesRequest, ListCertificatesResponse>
      listCertificatesMethodDescriptor =
          MethodDescriptor.<ListCertificatesRequest, ListCertificatesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ListCertificates")
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/RevokeCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RevokeCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Certificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCertificateRequest, Certificate>
      updateCertificateMethodDescriptor =
          MethodDescriptor.<UpdateCertificateRequest, Certificate>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/UpdateCertificate")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCertificateRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Certificate.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<ActivateCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ActivateCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ActivateCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<CreateCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/CreateCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<DisableCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/DisableCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<EnableCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/EnableCertificateAuthority")
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/FetchCertificateAuthorityCsr")
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/GetCertificateAuthority")
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ListCertificateAuthorities")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListCertificateAuthoritiesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListCertificateAuthoritiesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RestoreCertificateAuthorityRequest, Operation>
      restoreCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<RestoreCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/RestoreCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RestoreCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ScheduleDeleteCertificateAuthorityRequest, Operation>
      scheduleDeleteCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<ScheduleDeleteCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ScheduleDeleteCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ScheduleDeleteCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthorityMethodDescriptor =
          MethodDescriptor.<UpdateCertificateAuthorityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/UpdateCertificateAuthority")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateCertificateAuthorityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListMethodDescriptor =
          MethodDescriptor
              .<GetCertificateRevocationListRequest, CertificateRevocationList>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/GetCertificateRevocationList")
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ListCertificateRevocationLists")
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
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/UpdateCertificateRevocationList")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      UpdateCertificateRevocationListRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetReusableConfigRequest, ReusableConfig>
      getReusableConfigMethodDescriptor =
          MethodDescriptor.<GetReusableConfigRequest, ReusableConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/GetReusableConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetReusableConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReusableConfig.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListReusableConfigsRequest, ListReusableConfigsResponse>
      listReusableConfigsMethodDescriptor =
          MethodDescriptor.<ListReusableConfigsRequest, ListReusableConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.security.privateca.v1beta1.CertificateAuthorityService/ListReusableConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListReusableConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListReusableConfigsResponse.getDefaultInstance()))
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
    GrpcCallSettings<RestoreCertificateAuthorityRequest, Operation>
        restoreCertificateAuthorityTransportSettings =
            GrpcCallSettings.<RestoreCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(restoreCertificateAuthorityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ScheduleDeleteCertificateAuthorityRequest, Operation>
        scheduleDeleteCertificateAuthorityTransportSettings =
            GrpcCallSettings.<ScheduleDeleteCertificateAuthorityRequest, Operation>newBuilder()
                .setMethodDescriptor(scheduleDeleteCertificateAuthorityMethodDescriptor)
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
    GrpcCallSettings<GetReusableConfigRequest, ReusableConfig> getReusableConfigTransportSettings =
        GrpcCallSettings.<GetReusableConfigRequest, ReusableConfig>newBuilder()
            .setMethodDescriptor(getReusableConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListReusableConfigsRequest, ListReusableConfigsResponse>
        listReusableConfigsTransportSettings =
            GrpcCallSettings.<ListReusableConfigsRequest, ListReusableConfigsResponse>newBuilder()
                .setMethodDescriptor(listReusableConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
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
            operationsStub);
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
