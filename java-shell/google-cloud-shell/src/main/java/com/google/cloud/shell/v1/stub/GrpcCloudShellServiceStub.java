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

package com.google.cloud.shell.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.shell.v1.AddPublicKeyMetadata;
import com.google.cloud.shell.v1.AddPublicKeyRequest;
import com.google.cloud.shell.v1.AddPublicKeyResponse;
import com.google.cloud.shell.v1.AuthorizeEnvironmentMetadata;
import com.google.cloud.shell.v1.AuthorizeEnvironmentRequest;
import com.google.cloud.shell.v1.AuthorizeEnvironmentResponse;
import com.google.cloud.shell.v1.Environment;
import com.google.cloud.shell.v1.GetEnvironmentRequest;
import com.google.cloud.shell.v1.RemovePublicKeyMetadata;
import com.google.cloud.shell.v1.RemovePublicKeyRequest;
import com.google.cloud.shell.v1.RemovePublicKeyResponse;
import com.google.cloud.shell.v1.StartEnvironmentMetadata;
import com.google.cloud.shell.v1.StartEnvironmentRequest;
import com.google.cloud.shell.v1.StartEnvironmentResponse;
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
 * gRPC stub implementation for the CloudShellService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcCloudShellServiceStub extends CloudShellServiceStub {
  private static final MethodDescriptor<GetEnvironmentRequest, Environment>
      getEnvironmentMethodDescriptor =
          MethodDescriptor.<GetEnvironmentRequest, Environment>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/GetEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Environment.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<StartEnvironmentRequest, Operation>
      startEnvironmentMethodDescriptor =
          MethodDescriptor.<StartEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/StartEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StartEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AuthorizeEnvironmentRequest, Operation>
      authorizeEnvironmentMethodDescriptor =
          MethodDescriptor.<AuthorizeEnvironmentRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/AuthorizeEnvironment")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AuthorizeEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AddPublicKeyRequest, Operation>
      addPublicKeyMethodDescriptor =
          MethodDescriptor.<AddPublicKeyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/AddPublicKey")
              .setRequestMarshaller(ProtoUtils.marshaller(AddPublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<RemovePublicKeyRequest, Operation>
      removePublicKeyMethodDescriptor =
          MethodDescriptor.<RemovePublicKeyRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.shell.v1.CloudShellService/RemovePublicKey")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemovePublicKeyRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable;
  private final UnaryCallable<StartEnvironmentRequest, Operation> startEnvironmentCallable;
  private final OperationCallable<
          StartEnvironmentRequest, StartEnvironmentResponse, StartEnvironmentMetadata>
      startEnvironmentOperationCallable;
  private final UnaryCallable<AuthorizeEnvironmentRequest, Operation> authorizeEnvironmentCallable;
  private final OperationCallable<
          AuthorizeEnvironmentRequest, AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata>
      authorizeEnvironmentOperationCallable;
  private final UnaryCallable<AddPublicKeyRequest, Operation> addPublicKeyCallable;
  private final OperationCallable<AddPublicKeyRequest, AddPublicKeyResponse, AddPublicKeyMetadata>
      addPublicKeyOperationCallable;
  private final UnaryCallable<RemovePublicKeyRequest, Operation> removePublicKeyCallable;
  private final OperationCallable<
          RemovePublicKeyRequest, RemovePublicKeyResponse, RemovePublicKeyMetadata>
      removePublicKeyOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcCloudShellServiceStub create(CloudShellServiceStubSettings settings)
      throws IOException {
    return new GrpcCloudShellServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcCloudShellServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcCloudShellServiceStub(
        CloudShellServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcCloudShellServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcCloudShellServiceStub(
        CloudShellServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcCloudShellServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudShellServiceStub(
      CloudShellServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcCloudShellServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcCloudShellServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcCloudShellServiceStub(
      CloudShellServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetEnvironmentRequest, Environment> getEnvironmentTransportSettings =
        GrpcCallSettings.<GetEnvironmentRequest, Environment>newBuilder()
            .setMethodDescriptor(getEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<StartEnvironmentRequest, Operation> startEnvironmentTransportSettings =
        GrpcCallSettings.<StartEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(startEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AuthorizeEnvironmentRequest, Operation> authorizeEnvironmentTransportSettings =
        GrpcCallSettings.<AuthorizeEnvironmentRequest, Operation>newBuilder()
            .setMethodDescriptor(authorizeEnvironmentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AddPublicKeyRequest, Operation> addPublicKeyTransportSettings =
        GrpcCallSettings.<AddPublicKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(addPublicKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("environment", String.valueOf(request.getEnvironment()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<RemovePublicKeyRequest, Operation> removePublicKeyTransportSettings =
        GrpcCallSettings.<RemovePublicKeyRequest, Operation>newBuilder()
            .setMethodDescriptor(removePublicKeyMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("environment", String.valueOf(request.getEnvironment()));
                  return params.build();
                })
            .build();

    this.getEnvironmentCallable =
        callableFactory.createUnaryCallable(
            getEnvironmentTransportSettings, settings.getEnvironmentSettings(), clientContext);
    this.startEnvironmentCallable =
        callableFactory.createUnaryCallable(
            startEnvironmentTransportSettings, settings.startEnvironmentSettings(), clientContext);
    this.startEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            startEnvironmentTransportSettings,
            settings.startEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.authorizeEnvironmentCallable =
        callableFactory.createUnaryCallable(
            authorizeEnvironmentTransportSettings,
            settings.authorizeEnvironmentSettings(),
            clientContext);
    this.authorizeEnvironmentOperationCallable =
        callableFactory.createOperationCallable(
            authorizeEnvironmentTransportSettings,
            settings.authorizeEnvironmentOperationSettings(),
            clientContext,
            operationsStub);
    this.addPublicKeyCallable =
        callableFactory.createUnaryCallable(
            addPublicKeyTransportSettings, settings.addPublicKeySettings(), clientContext);
    this.addPublicKeyOperationCallable =
        callableFactory.createOperationCallable(
            addPublicKeyTransportSettings,
            settings.addPublicKeyOperationSettings(),
            clientContext,
            operationsStub);
    this.removePublicKeyCallable =
        callableFactory.createUnaryCallable(
            removePublicKeyTransportSettings, settings.removePublicKeySettings(), clientContext);
    this.removePublicKeyOperationCallable =
        callableFactory.createOperationCallable(
            removePublicKeyTransportSettings,
            settings.removePublicKeyOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetEnvironmentRequest, Environment> getEnvironmentCallable() {
    return getEnvironmentCallable;
  }

  @Override
  public UnaryCallable<StartEnvironmentRequest, Operation> startEnvironmentCallable() {
    return startEnvironmentCallable;
  }

  @Override
  public OperationCallable<
          StartEnvironmentRequest, StartEnvironmentResponse, StartEnvironmentMetadata>
      startEnvironmentOperationCallable() {
    return startEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<AuthorizeEnvironmentRequest, Operation> authorizeEnvironmentCallable() {
    return authorizeEnvironmentCallable;
  }

  @Override
  public OperationCallable<
          AuthorizeEnvironmentRequest, AuthorizeEnvironmentResponse, AuthorizeEnvironmentMetadata>
      authorizeEnvironmentOperationCallable() {
    return authorizeEnvironmentOperationCallable;
  }

  @Override
  public UnaryCallable<AddPublicKeyRequest, Operation> addPublicKeyCallable() {
    return addPublicKeyCallable;
  }

  @Override
  public OperationCallable<AddPublicKeyRequest, AddPublicKeyResponse, AddPublicKeyMetadata>
      addPublicKeyOperationCallable() {
    return addPublicKeyOperationCallable;
  }

  @Override
  public UnaryCallable<RemovePublicKeyRequest, Operation> removePublicKeyCallable() {
    return removePublicKeyCallable;
  }

  @Override
  public OperationCallable<RemovePublicKeyRequest, RemovePublicKeyResponse, RemovePublicKeyMetadata>
      removePublicKeyOperationCallable() {
    return removePublicKeyOperationCallable;
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
