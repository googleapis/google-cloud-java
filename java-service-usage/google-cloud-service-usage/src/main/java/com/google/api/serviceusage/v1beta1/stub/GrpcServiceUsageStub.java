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

package com.google.api.serviceusage.v1beta1.stub;

import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListAdminOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerOverridesPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListConsumerQuotaMetricsPagedResponse;
import static com.google.api.serviceusage.v1beta1.ServiceUsageClient.ListServicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest;
import com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit;
import com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric;
import com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest;
import com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest;
import com.google.api.serviceusage.v1beta1.DisableServiceRequest;
import com.google.api.serviceusage.v1beta1.EnableServiceRequest;
import com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest;
import com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest;
import com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest;
import com.google.api.serviceusage.v1beta1.GetServiceRequest;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesMetadata;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest;
import com.google.api.serviceusage.v1beta1.ImportAdminOverridesResponse;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesMetadata;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest;
import com.google.api.serviceusage.v1beta1.ImportConsumerOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest;
import com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest;
import com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse;
import com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest;
import com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse;
import com.google.api.serviceusage.v1beta1.ListServicesRequest;
import com.google.api.serviceusage.v1beta1.ListServicesResponse;
import com.google.api.serviceusage.v1beta1.OperationMetadata;
import com.google.api.serviceusage.v1beta1.QuotaOverride;
import com.google.api.serviceusage.v1beta1.Service;
import com.google.api.serviceusage.v1beta1.ServiceIdentity;
import com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest;
import com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the ServiceUsage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcServiceUsageStub extends ServiceUsageStub {
  private static final MethodDescriptor<EnableServiceRequest, Operation>
      enableServiceMethodDescriptor =
          MethodDescriptor.<EnableServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/EnableService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableServiceRequest, Operation>
      disableServiceMethodDescriptor =
          MethodDescriptor.<DisableServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/DisableService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      MethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/GetService")
          .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchEnableServicesRequest, Operation>
      batchEnableServicesMethodDescriptor =
          MethodDescriptor.<BatchEnableServicesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/BatchEnableServices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchEnableServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
      listConsumerQuotaMetricsMethodDescriptor =
          MethodDescriptor
              .<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/ListConsumerQuotaMetrics")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConsumerQuotaMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConsumerQuotaMetricsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricMethodDescriptor =
          MethodDescriptor.<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/GetConsumerQuotaMetric")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConsumerQuotaMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConsumerQuotaMetric.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitMethodDescriptor =
          MethodDescriptor.<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/GetConsumerQuotaLimit")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConsumerQuotaLimitRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConsumerQuotaLimit.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateAdminOverrideRequest, Operation>
      createAdminOverrideMethodDescriptor =
          MethodDescriptor.<CreateAdminOverrideRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/CreateAdminOverride")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAdminOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateAdminOverrideRequest, Operation>
      updateAdminOverrideMethodDescriptor =
          MethodDescriptor.<UpdateAdminOverrideRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/UpdateAdminOverride")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAdminOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteAdminOverrideRequest, Operation>
      deleteAdminOverrideMethodDescriptor =
          MethodDescriptor.<DeleteAdminOverrideRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/DeleteAdminOverride")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAdminOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListAdminOverridesRequest, ListAdminOverridesResponse>
      listAdminOverridesMethodDescriptor =
          MethodDescriptor.<ListAdminOverridesRequest, ListAdminOverridesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1beta1.ServiceUsage/ListAdminOverrides")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAdminOverridesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAdminOverridesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportAdminOverridesRequest, Operation>
      importAdminOverridesMethodDescriptor =
          MethodDescriptor.<ImportAdminOverridesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/ImportAdminOverrides")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportAdminOverridesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConsumerOverrideRequest, Operation>
      createConsumerOverrideMethodDescriptor =
          MethodDescriptor.<CreateConsumerOverrideRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/CreateConsumerOverride")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConsumerOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConsumerOverrideRequest, Operation>
      updateConsumerOverrideMethodDescriptor =
          MethodDescriptor.<UpdateConsumerOverrideRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/UpdateConsumerOverride")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConsumerOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConsumerOverrideRequest, Operation>
      deleteConsumerOverrideMethodDescriptor =
          MethodDescriptor.<DeleteConsumerOverrideRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/DeleteConsumerOverride")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConsumerOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConsumerOverridesRequest, ListConsumerOverridesResponse>
      listConsumerOverridesMethodDescriptor =
          MethodDescriptor.<ListConsumerOverridesRequest, ListConsumerOverridesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/ListConsumerOverrides")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConsumerOverridesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConsumerOverridesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesMethodDescriptor =
          MethodDescriptor.<ImportConsumerOverridesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/ImportConsumerOverrides")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportConsumerOverridesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentityMethodDescriptor =
          MethodDescriptor.<GenerateServiceIdentityRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.serviceusage.v1beta1.ServiceUsage/GenerateServiceIdentity")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateServiceIdentityRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable;
  private final OperationCallable<EnableServiceRequest, Empty, OperationMetadata>
      enableServiceOperationCallable;
  private final UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable;
  private final OperationCallable<DisableServiceRequest, Empty, OperationMetadata>
      disableServiceOperationCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable;
  private final OperationCallable<BatchEnableServicesRequest, Empty, OperationMetadata>
      batchEnableServicesOperationCallable;
  private final UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
      listConsumerQuotaMetricsCallable;
  private final UnaryCallable<
          ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsPagedResponse>
      listConsumerQuotaMetricsPagedCallable;
  private final UnaryCallable<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricCallable;
  private final UnaryCallable<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitCallable;
  private final UnaryCallable<CreateAdminOverrideRequest, Operation> createAdminOverrideCallable;
  private final OperationCallable<CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      createAdminOverrideOperationCallable;
  private final UnaryCallable<UpdateAdminOverrideRequest, Operation> updateAdminOverrideCallable;
  private final OperationCallable<UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      updateAdminOverrideOperationCallable;
  private final UnaryCallable<DeleteAdminOverrideRequest, Operation> deleteAdminOverrideCallable;
  private final OperationCallable<DeleteAdminOverrideRequest, Empty, OperationMetadata>
      deleteAdminOverrideOperationCallable;
  private final UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesResponse>
      listAdminOverridesCallable;
  private final UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesPagedResponse>
      listAdminOverridesPagedCallable;
  private final UnaryCallable<ImportAdminOverridesRequest, Operation> importAdminOverridesCallable;
  private final OperationCallable<
          ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesOperationCallable;
  private final UnaryCallable<CreateConsumerOverrideRequest, Operation>
      createConsumerOverrideCallable;
  private final OperationCallable<CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      createConsumerOverrideOperationCallable;
  private final UnaryCallable<UpdateConsumerOverrideRequest, Operation>
      updateConsumerOverrideCallable;
  private final OperationCallable<UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      updateConsumerOverrideOperationCallable;
  private final UnaryCallable<DeleteConsumerOverrideRequest, Operation>
      deleteConsumerOverrideCallable;
  private final OperationCallable<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
      deleteConsumerOverrideOperationCallable;
  private final UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesResponse>
      listConsumerOverridesCallable;
  private final UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesPagedResponse>
      listConsumerOverridesPagedCallable;
  private final UnaryCallable<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesCallable;
  private final OperationCallable<
          ImportConsumerOverridesRequest,
          ImportConsumerOverridesResponse,
          ImportConsumerOverridesMetadata>
      importConsumerOverridesOperationCallable;
  private final UnaryCallable<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentityCallable;
  private final OperationCallable<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
      generateServiceIdentityOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcServiceUsageStub create(ServiceUsageStubSettings settings)
      throws IOException {
    return new GrpcServiceUsageStub(settings, ClientContext.create(settings));
  }

  public static final GrpcServiceUsageStub create(ClientContext clientContext) throws IOException {
    return new GrpcServiceUsageStub(ServiceUsageStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcServiceUsageStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcServiceUsageStub(
        ServiceUsageStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcServiceUsageStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcServiceUsageStub(ServiceUsageStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcServiceUsageCallableFactory());
  }

  /**
   * Constructs an instance of GrpcServiceUsageStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcServiceUsageStub(
      ServiceUsageStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<EnableServiceRequest, Operation> enableServiceTransportSettings =
        GrpcCallSettings.<EnableServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(enableServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DisableServiceRequest, Operation> disableServiceTransportSettings =
        GrpcCallSettings.<DisableServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(disableServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        GrpcCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        GrpcCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchEnableServicesRequest, Operation> batchEnableServicesTransportSettings =
        GrpcCallSettings.<BatchEnableServicesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchEnableServicesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
        listConsumerQuotaMetricsTransportSettings =
            GrpcCallSettings
                .<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>newBuilder()
                .setMethodDescriptor(listConsumerQuotaMetricsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
        getConsumerQuotaMetricTransportSettings =
            GrpcCallSettings.<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>newBuilder()
                .setMethodDescriptor(getConsumerQuotaMetricMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
        getConsumerQuotaLimitTransportSettings =
            GrpcCallSettings.<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>newBuilder()
                .setMethodDescriptor(getConsumerQuotaLimitMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreateAdminOverrideRequest, Operation> createAdminOverrideTransportSettings =
        GrpcCallSettings.<CreateAdminOverrideRequest, Operation>newBuilder()
            .setMethodDescriptor(createAdminOverrideMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateAdminOverrideRequest, Operation> updateAdminOverrideTransportSettings =
        GrpcCallSettings.<UpdateAdminOverrideRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAdminOverrideMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteAdminOverrideRequest, Operation> deleteAdminOverrideTransportSettings =
        GrpcCallSettings.<DeleteAdminOverrideRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAdminOverrideMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAdminOverridesRequest, ListAdminOverridesResponse>
        listAdminOverridesTransportSettings =
            GrpcCallSettings.<ListAdminOverridesRequest, ListAdminOverridesResponse>newBuilder()
                .setMethodDescriptor(listAdminOverridesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ImportAdminOverridesRequest, Operation> importAdminOverridesTransportSettings =
        GrpcCallSettings.<ImportAdminOverridesRequest, Operation>newBuilder()
            .setMethodDescriptor(importAdminOverridesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateConsumerOverrideRequest, Operation>
        createConsumerOverrideTransportSettings =
            GrpcCallSettings.<CreateConsumerOverrideRequest, Operation>newBuilder()
                .setMethodDescriptor(createConsumerOverrideMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateConsumerOverrideRequest, Operation>
        updateConsumerOverrideTransportSettings =
            GrpcCallSettings.<UpdateConsumerOverrideRequest, Operation>newBuilder()
                .setMethodDescriptor(updateConsumerOverrideMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConsumerOverrideRequest, Operation>
        deleteConsumerOverrideTransportSettings =
            GrpcCallSettings.<DeleteConsumerOverrideRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteConsumerOverrideMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListConsumerOverridesRequest, ListConsumerOverridesResponse>
        listConsumerOverridesTransportSettings =
            GrpcCallSettings
                .<ListConsumerOverridesRequest, ListConsumerOverridesResponse>newBuilder()
                .setMethodDescriptor(listConsumerOverridesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ImportConsumerOverridesRequest, Operation>
        importConsumerOverridesTransportSettings =
            GrpcCallSettings.<ImportConsumerOverridesRequest, Operation>newBuilder()
                .setMethodDescriptor(importConsumerOverridesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GenerateServiceIdentityRequest, Operation>
        generateServiceIdentityTransportSettings =
            GrpcCallSettings.<GenerateServiceIdentityRequest, Operation>newBuilder()
                .setMethodDescriptor(generateServiceIdentityMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();

    this.enableServiceCallable =
        callableFactory.createUnaryCallable(
            enableServiceTransportSettings, settings.enableServiceSettings(), clientContext);
    this.enableServiceOperationCallable =
        callableFactory.createOperationCallable(
            enableServiceTransportSettings,
            settings.enableServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.disableServiceCallable =
        callableFactory.createUnaryCallable(
            disableServiceTransportSettings, settings.disableServiceSettings(), clientContext);
    this.disableServiceOperationCallable =
        callableFactory.createOperationCallable(
            disableServiceTransportSettings,
            settings.disableServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.batchEnableServicesCallable =
        callableFactory.createUnaryCallable(
            batchEnableServicesTransportSettings,
            settings.batchEnableServicesSettings(),
            clientContext);
    this.batchEnableServicesOperationCallable =
        callableFactory.createOperationCallable(
            batchEnableServicesTransportSettings,
            settings.batchEnableServicesOperationSettings(),
            clientContext,
            operationsStub);
    this.listConsumerQuotaMetricsCallable =
        callableFactory.createUnaryCallable(
            listConsumerQuotaMetricsTransportSettings,
            settings.listConsumerQuotaMetricsSettings(),
            clientContext);
    this.listConsumerQuotaMetricsPagedCallable =
        callableFactory.createPagedCallable(
            listConsumerQuotaMetricsTransportSettings,
            settings.listConsumerQuotaMetricsSettings(),
            clientContext);
    this.getConsumerQuotaMetricCallable =
        callableFactory.createUnaryCallable(
            getConsumerQuotaMetricTransportSettings,
            settings.getConsumerQuotaMetricSettings(),
            clientContext);
    this.getConsumerQuotaLimitCallable =
        callableFactory.createUnaryCallable(
            getConsumerQuotaLimitTransportSettings,
            settings.getConsumerQuotaLimitSettings(),
            clientContext);
    this.createAdminOverrideCallable =
        callableFactory.createUnaryCallable(
            createAdminOverrideTransportSettings,
            settings.createAdminOverrideSettings(),
            clientContext);
    this.createAdminOverrideOperationCallable =
        callableFactory.createOperationCallable(
            createAdminOverrideTransportSettings,
            settings.createAdminOverrideOperationSettings(),
            clientContext,
            operationsStub);
    this.updateAdminOverrideCallable =
        callableFactory.createUnaryCallable(
            updateAdminOverrideTransportSettings,
            settings.updateAdminOverrideSettings(),
            clientContext);
    this.updateAdminOverrideOperationCallable =
        callableFactory.createOperationCallable(
            updateAdminOverrideTransportSettings,
            settings.updateAdminOverrideOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteAdminOverrideCallable =
        callableFactory.createUnaryCallable(
            deleteAdminOverrideTransportSettings,
            settings.deleteAdminOverrideSettings(),
            clientContext);
    this.deleteAdminOverrideOperationCallable =
        callableFactory.createOperationCallable(
            deleteAdminOverrideTransportSettings,
            settings.deleteAdminOverrideOperationSettings(),
            clientContext,
            operationsStub);
    this.listAdminOverridesCallable =
        callableFactory.createUnaryCallable(
            listAdminOverridesTransportSettings,
            settings.listAdminOverridesSettings(),
            clientContext);
    this.listAdminOverridesPagedCallable =
        callableFactory.createPagedCallable(
            listAdminOverridesTransportSettings,
            settings.listAdminOverridesSettings(),
            clientContext);
    this.importAdminOverridesCallable =
        callableFactory.createUnaryCallable(
            importAdminOverridesTransportSettings,
            settings.importAdminOverridesSettings(),
            clientContext);
    this.importAdminOverridesOperationCallable =
        callableFactory.createOperationCallable(
            importAdminOverridesTransportSettings,
            settings.importAdminOverridesOperationSettings(),
            clientContext,
            operationsStub);
    this.createConsumerOverrideCallable =
        callableFactory.createUnaryCallable(
            createConsumerOverrideTransportSettings,
            settings.createConsumerOverrideSettings(),
            clientContext);
    this.createConsumerOverrideOperationCallable =
        callableFactory.createOperationCallable(
            createConsumerOverrideTransportSettings,
            settings.createConsumerOverrideOperationSettings(),
            clientContext,
            operationsStub);
    this.updateConsumerOverrideCallable =
        callableFactory.createUnaryCallable(
            updateConsumerOverrideTransportSettings,
            settings.updateConsumerOverrideSettings(),
            clientContext);
    this.updateConsumerOverrideOperationCallable =
        callableFactory.createOperationCallable(
            updateConsumerOverrideTransportSettings,
            settings.updateConsumerOverrideOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteConsumerOverrideCallable =
        callableFactory.createUnaryCallable(
            deleteConsumerOverrideTransportSettings,
            settings.deleteConsumerOverrideSettings(),
            clientContext);
    this.deleteConsumerOverrideOperationCallable =
        callableFactory.createOperationCallable(
            deleteConsumerOverrideTransportSettings,
            settings.deleteConsumerOverrideOperationSettings(),
            clientContext,
            operationsStub);
    this.listConsumerOverridesCallable =
        callableFactory.createUnaryCallable(
            listConsumerOverridesTransportSettings,
            settings.listConsumerOverridesSettings(),
            clientContext);
    this.listConsumerOverridesPagedCallable =
        callableFactory.createPagedCallable(
            listConsumerOverridesTransportSettings,
            settings.listConsumerOverridesSettings(),
            clientContext);
    this.importConsumerOverridesCallable =
        callableFactory.createUnaryCallable(
            importConsumerOverridesTransportSettings,
            settings.importConsumerOverridesSettings(),
            clientContext);
    this.importConsumerOverridesOperationCallable =
        callableFactory.createOperationCallable(
            importConsumerOverridesTransportSettings,
            settings.importConsumerOverridesOperationSettings(),
            clientContext,
            operationsStub);
    this.generateServiceIdentityCallable =
        callableFactory.createUnaryCallable(
            generateServiceIdentityTransportSettings,
            settings.generateServiceIdentitySettings(),
            clientContext);
    this.generateServiceIdentityOperationCallable =
        callableFactory.createOperationCallable(
            generateServiceIdentityTransportSettings,
            settings.generateServiceIdentityOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable() {
    return enableServiceCallable;
  }

  @Override
  public OperationCallable<EnableServiceRequest, Empty, OperationMetadata>
      enableServiceOperationCallable() {
    return enableServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable() {
    return disableServiceCallable;
  }

  @Override
  public OperationCallable<DisableServiceRequest, Empty, OperationMetadata>
      disableServiceOperationCallable() {
    return disableServiceOperationCallable;
  }

  @Override
  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return listServicesCallable;
  }

  @Override
  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    return listServicesPagedCallable;
  }

  @Override
  public UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable() {
    return batchEnableServicesCallable;
  }

  @Override
  public OperationCallable<BatchEnableServicesRequest, Empty, OperationMetadata>
      batchEnableServicesOperationCallable() {
    return batchEnableServicesOperationCallable;
  }

  @Override
  public UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsResponse>
      listConsumerQuotaMetricsCallable() {
    return listConsumerQuotaMetricsCallable;
  }

  @Override
  public UnaryCallable<ListConsumerQuotaMetricsRequest, ListConsumerQuotaMetricsPagedResponse>
      listConsumerQuotaMetricsPagedCallable() {
    return listConsumerQuotaMetricsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConsumerQuotaMetricRequest, ConsumerQuotaMetric>
      getConsumerQuotaMetricCallable() {
    return getConsumerQuotaMetricCallable;
  }

  @Override
  public UnaryCallable<GetConsumerQuotaLimitRequest, ConsumerQuotaLimit>
      getConsumerQuotaLimitCallable() {
    return getConsumerQuotaLimitCallable;
  }

  @Override
  public UnaryCallable<CreateAdminOverrideRequest, Operation> createAdminOverrideCallable() {
    return createAdminOverrideCallable;
  }

  @Override
  public OperationCallable<CreateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      createAdminOverrideOperationCallable() {
    return createAdminOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateAdminOverrideRequest, Operation> updateAdminOverrideCallable() {
    return updateAdminOverrideCallable;
  }

  @Override
  public OperationCallable<UpdateAdminOverrideRequest, QuotaOverride, OperationMetadata>
      updateAdminOverrideOperationCallable() {
    return updateAdminOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteAdminOverrideRequest, Operation> deleteAdminOverrideCallable() {
    return deleteAdminOverrideCallable;
  }

  @Override
  public OperationCallable<DeleteAdminOverrideRequest, Empty, OperationMetadata>
      deleteAdminOverrideOperationCallable() {
    return deleteAdminOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesResponse>
      listAdminOverridesCallable() {
    return listAdminOverridesCallable;
  }

  @Override
  public UnaryCallable<ListAdminOverridesRequest, ListAdminOverridesPagedResponse>
      listAdminOverridesPagedCallable() {
    return listAdminOverridesPagedCallable;
  }

  @Override
  public UnaryCallable<ImportAdminOverridesRequest, Operation> importAdminOverridesCallable() {
    return importAdminOverridesCallable;
  }

  @Override
  public OperationCallable<
          ImportAdminOverridesRequest, ImportAdminOverridesResponse, ImportAdminOverridesMetadata>
      importAdminOverridesOperationCallable() {
    return importAdminOverridesOperationCallable;
  }

  @Override
  public UnaryCallable<CreateConsumerOverrideRequest, Operation> createConsumerOverrideCallable() {
    return createConsumerOverrideCallable;
  }

  @Override
  public OperationCallable<CreateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      createConsumerOverrideOperationCallable() {
    return createConsumerOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConsumerOverrideRequest, Operation> updateConsumerOverrideCallable() {
    return updateConsumerOverrideCallable;
  }

  @Override
  public OperationCallable<UpdateConsumerOverrideRequest, QuotaOverride, OperationMetadata>
      updateConsumerOverrideOperationCallable() {
    return updateConsumerOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConsumerOverrideRequest, Operation> deleteConsumerOverrideCallable() {
    return deleteConsumerOverrideCallable;
  }

  @Override
  public OperationCallable<DeleteConsumerOverrideRequest, Empty, OperationMetadata>
      deleteConsumerOverrideOperationCallable() {
    return deleteConsumerOverrideOperationCallable;
  }

  @Override
  public UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesResponse>
      listConsumerOverridesCallable() {
    return listConsumerOverridesCallable;
  }

  @Override
  public UnaryCallable<ListConsumerOverridesRequest, ListConsumerOverridesPagedResponse>
      listConsumerOverridesPagedCallable() {
    return listConsumerOverridesPagedCallable;
  }

  @Override
  public UnaryCallable<ImportConsumerOverridesRequest, Operation>
      importConsumerOverridesCallable() {
    return importConsumerOverridesCallable;
  }

  @Override
  public OperationCallable<
          ImportConsumerOverridesRequest,
          ImportConsumerOverridesResponse,
          ImportConsumerOverridesMetadata>
      importConsumerOverridesOperationCallable() {
    return importConsumerOverridesOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateServiceIdentityRequest, Operation>
      generateServiceIdentityCallable() {
    return generateServiceIdentityCallable;
  }

  @Override
  public OperationCallable<GenerateServiceIdentityRequest, ServiceIdentity, Empty>
      generateServiceIdentityOperationCallable() {
    return generateServiceIdentityOperationCallable;
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
