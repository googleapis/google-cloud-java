/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.api.servicemanagement.v1.stub;

import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceConfigsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServiceRolloutsPagedResponse;
import static com.google.cloud.api.servicemanagement.v1.ServiceManagerClient.ListServicesPagedResponse;

import com.google.api.Service;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.servicemanagement.v1.CreateServiceConfigRequest;
import com.google.api.servicemanagement.v1.CreateServiceRequest;
import com.google.api.servicemanagement.v1.CreateServiceRolloutRequest;
import com.google.api.servicemanagement.v1.DeleteServiceRequest;
import com.google.api.servicemanagement.v1.DisableServiceRequest;
import com.google.api.servicemanagement.v1.DisableServiceResponse;
import com.google.api.servicemanagement.v1.EnableServiceRequest;
import com.google.api.servicemanagement.v1.EnableServiceResponse;
import com.google.api.servicemanagement.v1.GenerateConfigReportRequest;
import com.google.api.servicemanagement.v1.GenerateConfigReportResponse;
import com.google.api.servicemanagement.v1.GetServiceConfigRequest;
import com.google.api.servicemanagement.v1.GetServiceRequest;
import com.google.api.servicemanagement.v1.GetServiceRolloutRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsRequest;
import com.google.api.servicemanagement.v1.ListServiceConfigsResponse;
import com.google.api.servicemanagement.v1.ListServiceRolloutsRequest;
import com.google.api.servicemanagement.v1.ListServiceRolloutsResponse;
import com.google.api.servicemanagement.v1.ListServicesRequest;
import com.google.api.servicemanagement.v1.ListServicesResponse;
import com.google.api.servicemanagement.v1.ManagedService;
import com.google.api.servicemanagement.v1.OperationMetadata;
import com.google.api.servicemanagement.v1.Rollout;
import com.google.api.servicemanagement.v1.SubmitConfigSourceRequest;
import com.google.api.servicemanagement.v1.SubmitConfigSourceResponse;
import com.google.api.servicemanagement.v1.UndeleteServiceRequest;
import com.google.api.servicemanagement.v1.UndeleteServiceResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ServiceManager service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcServiceManagerStub extends ServiceManagerStub {
  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceRequest, ManagedService>
      getServiceMethodDescriptor =
          MethodDescriptor.<GetServiceRequest, ManagedService>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/GetService")
              .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ManagedService.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceRequest, Operation>
      createServiceMethodDescriptor =
          MethodDescriptor.<CreateServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/CreateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteServiceRequest, Operation>
      deleteServiceMethodDescriptor =
          MethodDescriptor.<DeleteServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/DeleteService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UndeleteServiceRequest, Operation>
      undeleteServiceMethodDescriptor =
          MethodDescriptor.<UndeleteServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/UndeleteService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeleteServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListServiceConfigsRequest, ListServiceConfigsResponse>
      listServiceConfigsMethodDescriptor =
          MethodDescriptor.<ListServiceConfigsRequest, ListServiceConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/ListServiceConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceConfigsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceConfigRequest, Service>
      getServiceConfigMethodDescriptor =
          MethodDescriptor.<GetServiceConfigRequest, Service>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/GetServiceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceConfigRequest, Service>
      createServiceConfigMethodDescriptor =
          MethodDescriptor.<CreateServiceConfigRequest, Service>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/CreateServiceConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SubmitConfigSourceRequest, Operation>
      submitConfigSourceMethodDescriptor =
          MethodDescriptor.<SubmitConfigSourceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/SubmitConfigSource")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SubmitConfigSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
      listServiceRolloutsMethodDescriptor =
          MethodDescriptor.<ListServiceRolloutsRequest, ListServiceRolloutsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/ListServiceRollouts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceRolloutsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceRolloutsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceRolloutRequest, Rollout>
      getServiceRolloutMethodDescriptor =
          MethodDescriptor.<GetServiceRolloutRequest, Rollout>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/GetServiceRollout")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceRolloutRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Rollout.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateServiceRolloutRequest, Operation>
      createServiceRolloutMethodDescriptor =
          MethodDescriptor.<CreateServiceRolloutRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/CreateServiceRollout")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceRolloutRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateConfigReportRequest, GenerateConfigReportResponse>
      generateConfigReportMethodDescriptor =
          MethodDescriptor.<GenerateConfigReportRequest, GenerateConfigReportResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.api.servicemanagement.v1.ServiceManager/GenerateConfigReport")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateConfigReportRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateConfigReportResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<EnableServiceRequest, Operation>
      enableServiceMethodDescriptor =
          MethodDescriptor.<EnableServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/EnableService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableServiceRequest, Operation>
      disableServiceMethodDescriptor =
          MethodDescriptor.<DisableServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.servicemanagement.v1.ServiceManager/DisableService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<GetServiceRequest, ManagedService> getServiceCallable;
  private final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable;
  private final OperationCallable<CreateServiceRequest, ManagedService, OperationMetadata>
      createServiceOperationCallable;
  private final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable;
  private final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable;
  private final UnaryCallable<UndeleteServiceRequest, Operation> undeleteServiceCallable;
  private final OperationCallable<
          UndeleteServiceRequest, UndeleteServiceResponse, OperationMetadata>
      undeleteServiceOperationCallable;
  private final UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsResponse>
      listServiceConfigsCallable;
  private final UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsPagedResponse>
      listServiceConfigsPagedCallable;
  private final UnaryCallable<GetServiceConfigRequest, Service> getServiceConfigCallable;
  private final UnaryCallable<CreateServiceConfigRequest, Service> createServiceConfigCallable;
  private final UnaryCallable<SubmitConfigSourceRequest, Operation> submitConfigSourceCallable;
  private final OperationCallable<
          SubmitConfigSourceRequest, SubmitConfigSourceResponse, OperationMetadata>
      submitConfigSourceOperationCallable;
  private final UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
      listServiceRolloutsCallable;
  private final UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsPagedResponse>
      listServiceRolloutsPagedCallable;
  private final UnaryCallable<GetServiceRolloutRequest, Rollout> getServiceRolloutCallable;
  private final UnaryCallable<CreateServiceRolloutRequest, Operation> createServiceRolloutCallable;
  private final OperationCallable<CreateServiceRolloutRequest, Rollout, OperationMetadata>
      createServiceRolloutOperationCallable;
  private final UnaryCallable<GenerateConfigReportRequest, GenerateConfigReportResponse>
      generateConfigReportCallable;
  private final UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable;
  private final OperationCallable<EnableServiceRequest, EnableServiceResponse, OperationMetadata>
      enableServiceOperationCallable;
  private final UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable;
  private final OperationCallable<DisableServiceRequest, DisableServiceResponse, OperationMetadata>
      disableServiceOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcServiceManagerStub create(ServiceManagerStubSettings settings)
      throws IOException {
    return new GrpcServiceManagerStub(settings, ClientContext.create(settings));
  }

  public static final GrpcServiceManagerStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcServiceManagerStub(
        ServiceManagerStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcServiceManagerStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcServiceManagerStub(
        ServiceManagerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcServiceManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcServiceManagerStub(ServiceManagerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcServiceManagerCallableFactory());
  }

  /**
   * Constructs an instance of GrpcServiceManagerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcServiceManagerStub(
      ServiceManagerStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        GrpcCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .build();
    GrpcCallSettings<GetServiceRequest, ManagedService> getServiceTransportSettings =
        GrpcCallSettings.<GetServiceRequest, ManagedService>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetServiceRequest>() {
                  @Override
                  public Map<String, String> extract(GetServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateServiceRequest, Operation> createServiceTransportSettings =
        GrpcCallSettings.<CreateServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteServiceRequest, Operation> deleteServiceTransportSettings =
        GrpcCallSettings.<DeleteServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteServiceRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UndeleteServiceRequest, Operation> undeleteServiceTransportSettings =
        GrpcCallSettings.<UndeleteServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(undeleteServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UndeleteServiceRequest>() {
                  @Override
                  public Map<String, String> extract(UndeleteServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListServiceConfigsRequest, ListServiceConfigsResponse>
        listServiceConfigsTransportSettings =
            GrpcCallSettings.<ListServiceConfigsRequest, ListServiceConfigsResponse>newBuilder()
                .setMethodDescriptor(listServiceConfigsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListServiceConfigsRequest>() {
                      @Override
                      public Map<String, String> extract(ListServiceConfigsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("service_name", String.valueOf(request.getServiceName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetServiceConfigRequest, Service> getServiceConfigTransportSettings =
        GrpcCallSettings.<GetServiceConfigRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetServiceConfigRequest>() {
                  @Override
                  public Map<String, String> extract(GetServiceConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("config_id", String.valueOf(request.getConfigId()));
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateServiceConfigRequest, Service> createServiceConfigTransportSettings =
        GrpcCallSettings.<CreateServiceConfigRequest, Service>newBuilder()
            .setMethodDescriptor(createServiceConfigMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateServiceConfigRequest>() {
                  @Override
                  public Map<String, String> extract(CreateServiceConfigRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SubmitConfigSourceRequest, Operation> submitConfigSourceTransportSettings =
        GrpcCallSettings.<SubmitConfigSourceRequest, Operation>newBuilder()
            .setMethodDescriptor(submitConfigSourceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<SubmitConfigSourceRequest>() {
                  @Override
                  public Map<String, String> extract(SubmitConfigSourceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
        listServiceRolloutsTransportSettings =
            GrpcCallSettings.<ListServiceRolloutsRequest, ListServiceRolloutsResponse>newBuilder()
                .setMethodDescriptor(listServiceRolloutsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListServiceRolloutsRequest>() {
                      @Override
                      public Map<String, String> extract(ListServiceRolloutsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("service_name", String.valueOf(request.getServiceName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetServiceRolloutRequest, Rollout> getServiceRolloutTransportSettings =
        GrpcCallSettings.<GetServiceRolloutRequest, Rollout>newBuilder()
            .setMethodDescriptor(getServiceRolloutMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetServiceRolloutRequest>() {
                  @Override
                  public Map<String, String> extract(GetServiceRolloutRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("rollout_id", String.valueOf(request.getRolloutId()));
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateServiceRolloutRequest, Operation> createServiceRolloutTransportSettings =
        GrpcCallSettings.<CreateServiceRolloutRequest, Operation>newBuilder()
            .setMethodDescriptor(createServiceRolloutMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateServiceRolloutRequest>() {
                  @Override
                  public Map<String, String> extract(CreateServiceRolloutRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GenerateConfigReportRequest, GenerateConfigReportResponse>
        generateConfigReportTransportSettings =
            GrpcCallSettings.<GenerateConfigReportRequest, GenerateConfigReportResponse>newBuilder()
                .setMethodDescriptor(generateConfigReportMethodDescriptor)
                .build();
    GrpcCallSettings<EnableServiceRequest, Operation> enableServiceTransportSettings =
        GrpcCallSettings.<EnableServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(enableServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<EnableServiceRequest>() {
                  @Override
                  public Map<String, String> extract(EnableServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DisableServiceRequest, Operation> disableServiceTransportSettings =
        GrpcCallSettings.<DisableServiceRequest, Operation>newBuilder()
            .setMethodDescriptor(disableServiceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DisableServiceRequest>() {
                  @Override
                  public Map<String, String> extract(DisableServiceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("service_name", String.valueOf(request.getServiceName()));
                    return params.build();
                  }
                })
            .build();

    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.createServiceCallable =
        callableFactory.createUnaryCallable(
            createServiceTransportSettings, settings.createServiceSettings(), clientContext);
    this.createServiceOperationCallable =
        callableFactory.createOperationCallable(
            createServiceTransportSettings,
            settings.createServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteServiceCallable =
        callableFactory.createUnaryCallable(
            deleteServiceTransportSettings, settings.deleteServiceSettings(), clientContext);
    this.deleteServiceOperationCallable =
        callableFactory.createOperationCallable(
            deleteServiceTransportSettings,
            settings.deleteServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.undeleteServiceCallable =
        callableFactory.createUnaryCallable(
            undeleteServiceTransportSettings, settings.undeleteServiceSettings(), clientContext);
    this.undeleteServiceOperationCallable =
        callableFactory.createOperationCallable(
            undeleteServiceTransportSettings,
            settings.undeleteServiceOperationSettings(),
            clientContext,
            operationsStub);
    this.listServiceConfigsCallable =
        callableFactory.createUnaryCallable(
            listServiceConfigsTransportSettings,
            settings.listServiceConfigsSettings(),
            clientContext);
    this.listServiceConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listServiceConfigsTransportSettings,
            settings.listServiceConfigsSettings(),
            clientContext);
    this.getServiceConfigCallable =
        callableFactory.createUnaryCallable(
            getServiceConfigTransportSettings, settings.getServiceConfigSettings(), clientContext);
    this.createServiceConfigCallable =
        callableFactory.createUnaryCallable(
            createServiceConfigTransportSettings,
            settings.createServiceConfigSettings(),
            clientContext);
    this.submitConfigSourceCallable =
        callableFactory.createUnaryCallable(
            submitConfigSourceTransportSettings,
            settings.submitConfigSourceSettings(),
            clientContext);
    this.submitConfigSourceOperationCallable =
        callableFactory.createOperationCallable(
            submitConfigSourceTransportSettings,
            settings.submitConfigSourceOperationSettings(),
            clientContext,
            operationsStub);
    this.listServiceRolloutsCallable =
        callableFactory.createUnaryCallable(
            listServiceRolloutsTransportSettings,
            settings.listServiceRolloutsSettings(),
            clientContext);
    this.listServiceRolloutsPagedCallable =
        callableFactory.createPagedCallable(
            listServiceRolloutsTransportSettings,
            settings.listServiceRolloutsSettings(),
            clientContext);
    this.getServiceRolloutCallable =
        callableFactory.createUnaryCallable(
            getServiceRolloutTransportSettings,
            settings.getServiceRolloutSettings(),
            clientContext);
    this.createServiceRolloutCallable =
        callableFactory.createUnaryCallable(
            createServiceRolloutTransportSettings,
            settings.createServiceRolloutSettings(),
            clientContext);
    this.createServiceRolloutOperationCallable =
        callableFactory.createOperationCallable(
            createServiceRolloutTransportSettings,
            settings.createServiceRolloutOperationSettings(),
            clientContext,
            operationsStub);
    this.generateConfigReportCallable =
        callableFactory.createUnaryCallable(
            generateConfigReportTransportSettings,
            settings.generateConfigReportSettings(),
            clientContext);
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
  public UnaryCallable<GetServiceRequest, ManagedService> getServiceCallable() {
    return getServiceCallable;
  }

  @Override
  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    return createServiceCallable;
  }

  @Override
  public OperationCallable<CreateServiceRequest, ManagedService, OperationMetadata>
      createServiceOperationCallable() {
    return createServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    return deleteServiceCallable;
  }

  @Override
  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    return deleteServiceOperationCallable;
  }

  @Override
  public UnaryCallable<UndeleteServiceRequest, Operation> undeleteServiceCallable() {
    return undeleteServiceCallable;
  }

  @Override
  public OperationCallable<UndeleteServiceRequest, UndeleteServiceResponse, OperationMetadata>
      undeleteServiceOperationCallable() {
    return undeleteServiceOperationCallable;
  }

  @Override
  public UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsResponse>
      listServiceConfigsCallable() {
    return listServiceConfigsCallable;
  }

  @Override
  public UnaryCallable<ListServiceConfigsRequest, ListServiceConfigsPagedResponse>
      listServiceConfigsPagedCallable() {
    return listServiceConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceConfigRequest, Service> getServiceConfigCallable() {
    return getServiceConfigCallable;
  }

  @Override
  public UnaryCallable<CreateServiceConfigRequest, Service> createServiceConfigCallable() {
    return createServiceConfigCallable;
  }

  @Override
  public UnaryCallable<SubmitConfigSourceRequest, Operation> submitConfigSourceCallable() {
    return submitConfigSourceCallable;
  }

  @Override
  public OperationCallable<SubmitConfigSourceRequest, SubmitConfigSourceResponse, OperationMetadata>
      submitConfigSourceOperationCallable() {
    return submitConfigSourceOperationCallable;
  }

  @Override
  public UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsResponse>
      listServiceRolloutsCallable() {
    return listServiceRolloutsCallable;
  }

  @Override
  public UnaryCallable<ListServiceRolloutsRequest, ListServiceRolloutsPagedResponse>
      listServiceRolloutsPagedCallable() {
    return listServiceRolloutsPagedCallable;
  }

  @Override
  public UnaryCallable<GetServiceRolloutRequest, Rollout> getServiceRolloutCallable() {
    return getServiceRolloutCallable;
  }

  @Override
  public UnaryCallable<CreateServiceRolloutRequest, Operation> createServiceRolloutCallable() {
    return createServiceRolloutCallable;
  }

  @Override
  public OperationCallable<CreateServiceRolloutRequest, Rollout, OperationMetadata>
      createServiceRolloutOperationCallable() {
    return createServiceRolloutOperationCallable;
  }

  @Override
  public UnaryCallable<GenerateConfigReportRequest, GenerateConfigReportResponse>
      generateConfigReportCallable() {
    return generateConfigReportCallable;
  }

  @Override
  public UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable() {
    return enableServiceCallable;
  }

  @Override
  public OperationCallable<EnableServiceRequest, EnableServiceResponse, OperationMetadata>
      enableServiceOperationCallable() {
    return enableServiceOperationCallable;
  }

  @Override
  public UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable() {
    return disableServiceCallable;
  }

  @Override
  public OperationCallable<DisableServiceRequest, DisableServiceResponse, OperationMetadata>
      disableServiceOperationCallable() {
    return disableServiceOperationCallable;
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
