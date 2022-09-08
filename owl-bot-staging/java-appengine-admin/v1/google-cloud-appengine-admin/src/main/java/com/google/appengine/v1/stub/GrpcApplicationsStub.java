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

package com.google.appengine.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.appengine.v1.Application;
import com.google.appengine.v1.CreateApplicationRequest;
import com.google.appengine.v1.GetApplicationRequest;
import com.google.appengine.v1.OperationMetadataV1;
import com.google.appengine.v1.RepairApplicationRequest;
import com.google.appengine.v1.UpdateApplicationRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Applications service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcApplicationsStub extends ApplicationsStub {
  private static final MethodDescriptor<GetApplicationRequest, Application>
      getApplicationMethodDescriptor =
          MethodDescriptor.<GetApplicationRequest, Application>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Applications/GetApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Application.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateApplicationRequest, Operation>
      createApplicationMethodDescriptor =
          MethodDescriptor.<CreateApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Applications/CreateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateApplicationRequest, Operation>
      updateApplicationMethodDescriptor =
          MethodDescriptor.<UpdateApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Applications/UpdateApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RepairApplicationRequest, Operation>
      repairApplicationMethodDescriptor =
          MethodDescriptor.<RepairApplicationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.appengine.v1.Applications/RepairApplication")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RepairApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetApplicationRequest, Application> getApplicationCallable;
  private final UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable;
  private final OperationCallable<CreateApplicationRequest, Application, OperationMetadataV1>
      createApplicationOperationCallable;
  private final UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable;
  private final OperationCallable<UpdateApplicationRequest, Application, OperationMetadataV1>
      updateApplicationOperationCallable;
  private final UnaryCallable<RepairApplicationRequest, Operation> repairApplicationCallable;
  private final OperationCallable<RepairApplicationRequest, Application, OperationMetadataV1>
      repairApplicationOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcApplicationsStub create(ApplicationsStubSettings settings)
      throws IOException {
    return new GrpcApplicationsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcApplicationsStub create(ClientContext clientContext) throws IOException {
    return new GrpcApplicationsStub(ApplicationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcApplicationsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcApplicationsStub(
        ApplicationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcApplicationsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcApplicationsStub(ApplicationsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcApplicationsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcApplicationsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcApplicationsStub(
      ApplicationsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetApplicationRequest, Application> getApplicationTransportSettings =
        GrpcCallSettings.<GetApplicationRequest, Application>newBuilder()
            .setMethodDescriptor(getApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateApplicationRequest, Operation> createApplicationTransportSettings =
        GrpcCallSettings.<CreateApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(createApplicationMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateApplicationRequest, Operation> updateApplicationTransportSettings =
        GrpcCallSettings.<UpdateApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(updateApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RepairApplicationRequest, Operation> repairApplicationTransportSettings =
        GrpcCallSettings.<RepairApplicationRequest, Operation>newBuilder()
            .setMethodDescriptor(repairApplicationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.getApplicationCallable =
        callableFactory.createUnaryCallable(
            getApplicationTransportSettings, settings.getApplicationSettings(), clientContext);
    this.createApplicationCallable =
        callableFactory.createUnaryCallable(
            createApplicationTransportSettings,
            settings.createApplicationSettings(),
            clientContext);
    this.createApplicationOperationCallable =
        callableFactory.createOperationCallable(
            createApplicationTransportSettings,
            settings.createApplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateApplicationCallable =
        callableFactory.createUnaryCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationSettings(),
            clientContext);
    this.updateApplicationOperationCallable =
        callableFactory.createOperationCallable(
            updateApplicationTransportSettings,
            settings.updateApplicationOperationSettings(),
            clientContext,
            operationsStub);
    this.repairApplicationCallable =
        callableFactory.createUnaryCallable(
            repairApplicationTransportSettings,
            settings.repairApplicationSettings(),
            clientContext);
    this.repairApplicationOperationCallable =
        callableFactory.createOperationCallable(
            repairApplicationTransportSettings,
            settings.repairApplicationOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetApplicationRequest, Application> getApplicationCallable() {
    return getApplicationCallable;
  }

  @Override
  public UnaryCallable<CreateApplicationRequest, Operation> createApplicationCallable() {
    return createApplicationCallable;
  }

  @Override
  public OperationCallable<CreateApplicationRequest, Application, OperationMetadataV1>
      createApplicationOperationCallable() {
    return createApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateApplicationRequest, Operation> updateApplicationCallable() {
    return updateApplicationCallable;
  }

  @Override
  public OperationCallable<UpdateApplicationRequest, Application, OperationMetadataV1>
      updateApplicationOperationCallable() {
    return updateApplicationOperationCallable;
  }

  @Override
  public UnaryCallable<RepairApplicationRequest, Operation> repairApplicationCallable() {
    return repairApplicationCallable;
  }

  @Override
  public OperationCallable<RepairApplicationRequest, Application, OperationMetadataV1>
      repairApplicationOperationCallable() {
    return repairApplicationOperationCallable;
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
