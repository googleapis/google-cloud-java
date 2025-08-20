/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.ServiceMonitoringServiceClient.ListServiceLevelObjectivesPagedResponse;
import static com.google.cloud.monitoring.v3.ServiceMonitoringServiceClient.ListServicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.monitoring.v3.CreateServiceLevelObjectiveRequest;
import com.google.monitoring.v3.CreateServiceRequest;
import com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest;
import com.google.monitoring.v3.DeleteServiceRequest;
import com.google.monitoring.v3.GetServiceLevelObjectiveRequest;
import com.google.monitoring.v3.GetServiceRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesRequest;
import com.google.monitoring.v3.ListServiceLevelObjectivesResponse;
import com.google.monitoring.v3.ListServicesRequest;
import com.google.monitoring.v3.ListServicesResponse;
import com.google.monitoring.v3.Service;
import com.google.monitoring.v3.ServiceLevelObjective;
import com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest;
import com.google.monitoring.v3.UpdateServiceRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ServiceMonitoringService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcServiceMonitoringServiceStub extends ServiceMonitoringServiceStub {
  private static final MethodDescriptor<CreateServiceRequest, Service>
      createServiceMethodDescriptor =
          MethodDescriptor.<CreateServiceRequest, Service>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.ServiceMonitoringService/CreateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      MethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.monitoring.v3.ServiceMonitoringService/GetService")
          .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.ServiceMonitoringService/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateServiceRequest, Service>
      updateServiceMethodDescriptor =
          MethodDescriptor.<UpdateServiceRequest, Service>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.ServiceMonitoringService/UpdateService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteServiceRequest, Empty> deleteServiceMethodDescriptor =
      MethodDescriptor.<DeleteServiceRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.monitoring.v3.ServiceMonitoringService/DeleteService")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<CreateServiceLevelObjectiveRequest, ServiceLevelObjective>
      createServiceLevelObjectiveMethodDescriptor =
          MethodDescriptor.<CreateServiceLevelObjectiveRequest, ServiceLevelObjective>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.ServiceMonitoringService/CreateServiceLevelObjective")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServiceLevelObjectiveRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ServiceLevelObjective.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetServiceLevelObjectiveRequest, ServiceLevelObjective>
      getServiceLevelObjectiveMethodDescriptor =
          MethodDescriptor.<GetServiceLevelObjectiveRequest, ServiceLevelObjective>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.ServiceMonitoringService/GetServiceLevelObjective")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServiceLevelObjectiveRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ServiceLevelObjective.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesResponse>
      listServiceLevelObjectivesMethodDescriptor =
          MethodDescriptor
              .<ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.ServiceMonitoringService/ListServiceLevelObjectives")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServiceLevelObjectivesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServiceLevelObjectivesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateServiceLevelObjectiveRequest, ServiceLevelObjective>
      updateServiceLevelObjectiveMethodDescriptor =
          MethodDescriptor.<UpdateServiceLevelObjectiveRequest, ServiceLevelObjective>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.ServiceMonitoringService/UpdateServiceLevelObjective")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServiceLevelObjectiveRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ServiceLevelObjective.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteServiceLevelObjectiveRequest, Empty>
      deleteServiceLevelObjectiveMethodDescriptor =
          MethodDescriptor.<DeleteServiceLevelObjectiveRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.monitoring.v3.ServiceMonitoringService/DeleteServiceLevelObjective")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServiceLevelObjectiveRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateServiceRequest, Service> createServiceCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<UpdateServiceRequest, Service> updateServiceCallable;
  private final UnaryCallable<DeleteServiceRequest, Empty> deleteServiceCallable;
  private final UnaryCallable<CreateServiceLevelObjectiveRequest, ServiceLevelObjective>
      createServiceLevelObjectiveCallable;
  private final UnaryCallable<GetServiceLevelObjectiveRequest, ServiceLevelObjective>
      getServiceLevelObjectiveCallable;
  private final UnaryCallable<ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesResponse>
      listServiceLevelObjectivesCallable;
  private final UnaryCallable<
          ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesPagedResponse>
      listServiceLevelObjectivesPagedCallable;
  private final UnaryCallable<UpdateServiceLevelObjectiveRequest, ServiceLevelObjective>
      updateServiceLevelObjectiveCallable;
  private final UnaryCallable<DeleteServiceLevelObjectiveRequest, Empty>
      deleteServiceLevelObjectiveCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcServiceMonitoringServiceStub create(
      ServiceMonitoringServiceStubSettings settings) throws IOException {
    return new GrpcServiceMonitoringServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcServiceMonitoringServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcServiceMonitoringServiceStub(
        ServiceMonitoringServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcServiceMonitoringServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcServiceMonitoringServiceStub(
        ServiceMonitoringServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcServiceMonitoringServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcServiceMonitoringServiceStub(
      ServiceMonitoringServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcServiceMonitoringServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcServiceMonitoringServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcServiceMonitoringServiceStub(
      ServiceMonitoringServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateServiceRequest, Service> createServiceTransportSettings =
        GrpcCallSettings.<CreateServiceRequest, Service>newBuilder()
            .setMethodDescriptor(createServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetServiceRequest, Service> getServiceTransportSettings =
        GrpcCallSettings.<GetServiceRequest, Service>newBuilder()
            .setMethodDescriptor(getServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListServicesRequest, ListServicesResponse> listServicesTransportSettings =
        GrpcCallSettings.<ListServicesRequest, ListServicesResponse>newBuilder()
            .setMethodDescriptor(listServicesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateServiceRequest, Service> updateServiceTransportSettings =
        GrpcCallSettings.<UpdateServiceRequest, Service>newBuilder()
            .setMethodDescriptor(updateServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("service.name", String.valueOf(request.getService().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteServiceRequest, Empty> deleteServiceTransportSettings =
        GrpcCallSettings.<DeleteServiceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteServiceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateServiceLevelObjectiveRequest, ServiceLevelObjective>
        createServiceLevelObjectiveTransportSettings =
            GrpcCallSettings.<CreateServiceLevelObjectiveRequest, ServiceLevelObjective>newBuilder()
                .setMethodDescriptor(createServiceLevelObjectiveMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetServiceLevelObjectiveRequest, ServiceLevelObjective>
        getServiceLevelObjectiveTransportSettings =
            GrpcCallSettings.<GetServiceLevelObjectiveRequest, ServiceLevelObjective>newBuilder()
                .setMethodDescriptor(getServiceLevelObjectiveMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesResponse>
        listServiceLevelObjectivesTransportSettings =
            GrpcCallSettings
                .<ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesResponse>newBuilder()
                .setMethodDescriptor(listServiceLevelObjectivesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateServiceLevelObjectiveRequest, ServiceLevelObjective>
        updateServiceLevelObjectiveTransportSettings =
            GrpcCallSettings.<UpdateServiceLevelObjectiveRequest, ServiceLevelObjective>newBuilder()
                .setMethodDescriptor(updateServiceLevelObjectiveMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "service_level_objective.name",
                          String.valueOf(request.getServiceLevelObjective().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteServiceLevelObjectiveRequest, Empty>
        deleteServiceLevelObjectiveTransportSettings =
            GrpcCallSettings.<DeleteServiceLevelObjectiveRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteServiceLevelObjectiveMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();

    this.createServiceCallable =
        callableFactory.createUnaryCallable(
            createServiceTransportSettings, settings.createServiceSettings(), clientContext);
    this.getServiceCallable =
        callableFactory.createUnaryCallable(
            getServiceTransportSettings, settings.getServiceSettings(), clientContext);
    this.listServicesCallable =
        callableFactory.createUnaryCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.listServicesPagedCallable =
        callableFactory.createPagedCallable(
            listServicesTransportSettings, settings.listServicesSettings(), clientContext);
    this.updateServiceCallable =
        callableFactory.createUnaryCallable(
            updateServiceTransportSettings, settings.updateServiceSettings(), clientContext);
    this.deleteServiceCallable =
        callableFactory.createUnaryCallable(
            deleteServiceTransportSettings, settings.deleteServiceSettings(), clientContext);
    this.createServiceLevelObjectiveCallable =
        callableFactory.createUnaryCallable(
            createServiceLevelObjectiveTransportSettings,
            settings.createServiceLevelObjectiveSettings(),
            clientContext);
    this.getServiceLevelObjectiveCallable =
        callableFactory.createUnaryCallable(
            getServiceLevelObjectiveTransportSettings,
            settings.getServiceLevelObjectiveSettings(),
            clientContext);
    this.listServiceLevelObjectivesCallable =
        callableFactory.createUnaryCallable(
            listServiceLevelObjectivesTransportSettings,
            settings.listServiceLevelObjectivesSettings(),
            clientContext);
    this.listServiceLevelObjectivesPagedCallable =
        callableFactory.createPagedCallable(
            listServiceLevelObjectivesTransportSettings,
            settings.listServiceLevelObjectivesSettings(),
            clientContext);
    this.updateServiceLevelObjectiveCallable =
        callableFactory.createUnaryCallable(
            updateServiceLevelObjectiveTransportSettings,
            settings.updateServiceLevelObjectiveSettings(),
            clientContext);
    this.deleteServiceLevelObjectiveCallable =
        callableFactory.createUnaryCallable(
            deleteServiceLevelObjectiveTransportSettings,
            settings.deleteServiceLevelObjectiveSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateServiceRequest, Service> createServiceCallable() {
    return createServiceCallable;
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
  public UnaryCallable<UpdateServiceRequest, Service> updateServiceCallable() {
    return updateServiceCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceRequest, Empty> deleteServiceCallable() {
    return deleteServiceCallable;
  }

  @Override
  public UnaryCallable<CreateServiceLevelObjectiveRequest, ServiceLevelObjective>
      createServiceLevelObjectiveCallable() {
    return createServiceLevelObjectiveCallable;
  }

  @Override
  public UnaryCallable<GetServiceLevelObjectiveRequest, ServiceLevelObjective>
      getServiceLevelObjectiveCallable() {
    return getServiceLevelObjectiveCallable;
  }

  @Override
  public UnaryCallable<ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesResponse>
      listServiceLevelObjectivesCallable() {
    return listServiceLevelObjectivesCallable;
  }

  @Override
  public UnaryCallable<ListServiceLevelObjectivesRequest, ListServiceLevelObjectivesPagedResponse>
      listServiceLevelObjectivesPagedCallable() {
    return listServiceLevelObjectivesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateServiceLevelObjectiveRequest, ServiceLevelObjective>
      updateServiceLevelObjectiveCallable() {
    return updateServiceLevelObjectiveCallable;
  }

  @Override
  public UnaryCallable<DeleteServiceLevelObjectiveRequest, Empty>
      deleteServiceLevelObjectiveCallable() {
    return deleteServiceLevelObjectiveCallable;
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
