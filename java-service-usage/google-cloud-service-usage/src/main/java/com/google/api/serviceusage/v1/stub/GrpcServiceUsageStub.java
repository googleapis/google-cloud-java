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

package com.google.api.serviceusage.v1.stub;

import static com.google.api.serviceusage.v1.ServiceUsageClient.ListServicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.serviceusage.v1.BatchEnableServicesRequest;
import com.google.api.serviceusage.v1.BatchEnableServicesResponse;
import com.google.api.serviceusage.v1.BatchGetServicesRequest;
import com.google.api.serviceusage.v1.BatchGetServicesResponse;
import com.google.api.serviceusage.v1.DisableServiceRequest;
import com.google.api.serviceusage.v1.DisableServiceResponse;
import com.google.api.serviceusage.v1.EnableServiceRequest;
import com.google.api.serviceusage.v1.EnableServiceResponse;
import com.google.api.serviceusage.v1.GetServiceRequest;
import com.google.api.serviceusage.v1.ListServicesRequest;
import com.google.api.serviceusage.v1.ListServicesResponse;
import com.google.api.serviceusage.v1.OperationMetadata;
import com.google.api.serviceusage.v1.Service;
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
 * gRPC stub implementation for the ServiceUsage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcServiceUsageStub extends ServiceUsageStub {
  private static final MethodDescriptor<EnableServiceRequest, Operation>
      enableServiceMethodDescriptor =
          MethodDescriptor.<EnableServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/EnableService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EnableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DisableServiceRequest, Operation>
      disableServiceMethodDescriptor =
          MethodDescriptor.<DisableServiceRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/DisableService")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DisableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetServiceRequest, Service> getServiceMethodDescriptor =
      MethodDescriptor.<GetServiceRequest, Service>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/GetService")
          .setRequestMarshaller(ProtoUtils.marshaller(GetServiceRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Service.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListServicesRequest, ListServicesResponse>
      listServicesMethodDescriptor =
          MethodDescriptor.<ListServicesRequest, ListServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/ListServices")
              .setRequestMarshaller(ProtoUtils.marshaller(ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServicesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchEnableServicesRequest, Operation>
      batchEnableServicesMethodDescriptor =
          MethodDescriptor.<BatchEnableServicesRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/BatchEnableServices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchEnableServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesMethodDescriptor =
          MethodDescriptor.<BatchGetServicesRequest, BatchGetServicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.api.serviceusage.v1.ServiceUsage/BatchGetServices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchGetServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchGetServicesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<EnableServiceRequest, Operation> enableServiceCallable;
  private final OperationCallable<EnableServiceRequest, EnableServiceResponse, OperationMetadata>
      enableServiceOperationCallable;
  private final UnaryCallable<DisableServiceRequest, Operation> disableServiceCallable;
  private final OperationCallable<DisableServiceRequest, DisableServiceResponse, OperationMetadata>
      disableServiceOperationCallable;
  private final UnaryCallable<GetServiceRequest, Service> getServiceCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable;
  private final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable;
  private final UnaryCallable<BatchEnableServicesRequest, Operation> batchEnableServicesCallable;
  private final OperationCallable<
          BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
      batchEnableServicesOperationCallable;
  private final UnaryCallable<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesCallable;

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
    GrpcCallSettings<BatchGetServicesRequest, BatchGetServicesResponse>
        batchGetServicesTransportSettings =
            GrpcCallSettings.<BatchGetServicesRequest, BatchGetServicesResponse>newBuilder()
                .setMethodDescriptor(batchGetServicesMethodDescriptor)
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
    this.batchGetServicesCallable =
        callableFactory.createUnaryCallable(
            batchGetServicesTransportSettings, settings.batchGetServicesSettings(), clientContext);

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
  public OperationCallable<
          BatchEnableServicesRequest, BatchEnableServicesResponse, OperationMetadata>
      batchEnableServicesOperationCallable() {
    return batchEnableServicesOperationCallable;
  }

  @Override
  public UnaryCallable<BatchGetServicesRequest, BatchGetServicesResponse>
      batchGetServicesCallable() {
    return batchGetServicesCallable;
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
