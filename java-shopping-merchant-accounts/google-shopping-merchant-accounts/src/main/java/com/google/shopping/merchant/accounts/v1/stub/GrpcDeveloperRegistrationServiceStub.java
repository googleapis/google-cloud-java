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

package com.google.shopping.merchant.accounts.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.accounts.v1.DeveloperRegistration;
import com.google.shopping.merchant.accounts.v1.GetDeveloperRegistrationRequest;
import com.google.shopping.merchant.accounts.v1.RegisterGcpRequest;
import com.google.shopping.merchant.accounts.v1.UnregisterGcpRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DeveloperRegistrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDeveloperRegistrationServiceStub extends DeveloperRegistrationServiceStub {
  private static final MethodDescriptor<RegisterGcpRequest, DeveloperRegistration>
      registerGcpMethodDescriptor =
          MethodDescriptor.<RegisterGcpRequest, DeveloperRegistration>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.DeveloperRegistrationService/RegisterGcp")
              .setRequestMarshaller(ProtoUtils.marshaller(RegisterGcpRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DeveloperRegistration.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetDeveloperRegistrationRequest, DeveloperRegistration>
      getDeveloperRegistrationMethodDescriptor =
          MethodDescriptor.<GetDeveloperRegistrationRequest, DeveloperRegistration>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.accounts.v1.DeveloperRegistrationService/GetDeveloperRegistration")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetDeveloperRegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DeveloperRegistration.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UnregisterGcpRequest, Empty> unregisterGcpMethodDescriptor =
      MethodDescriptor.<UnregisterGcpRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.shopping.merchant.accounts.v1.DeveloperRegistrationService/UnregisterGcp")
          .setRequestMarshaller(ProtoUtils.marshaller(UnregisterGcpRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private final UnaryCallable<RegisterGcpRequest, DeveloperRegistration> registerGcpCallable;
  private final UnaryCallable<GetDeveloperRegistrationRequest, DeveloperRegistration>
      getDeveloperRegistrationCallable;
  private final UnaryCallable<UnregisterGcpRequest, Empty> unregisterGcpCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDeveloperRegistrationServiceStub create(
      DeveloperRegistrationServiceStubSettings settings) throws IOException {
    return new GrpcDeveloperRegistrationServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDeveloperRegistrationServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDeveloperRegistrationServiceStub(
        DeveloperRegistrationServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDeveloperRegistrationServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDeveloperRegistrationServiceStub(
        DeveloperRegistrationServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcDeveloperRegistrationServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDeveloperRegistrationServiceStub(
      DeveloperRegistrationServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDeveloperRegistrationServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDeveloperRegistrationServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcDeveloperRegistrationServiceStub(
      DeveloperRegistrationServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RegisterGcpRequest, DeveloperRegistration> registerGcpTransportSettings =
        GrpcCallSettings.<RegisterGcpRequest, DeveloperRegistration>newBuilder()
            .setMethodDescriptor(registerGcpMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetDeveloperRegistrationRequest, DeveloperRegistration>
        getDeveloperRegistrationTransportSettings =
            GrpcCallSettings.<GetDeveloperRegistrationRequest, DeveloperRegistration>newBuilder()
                .setMethodDescriptor(getDeveloperRegistrationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UnregisterGcpRequest, Empty> unregisterGcpTransportSettings =
        GrpcCallSettings.<UnregisterGcpRequest, Empty>newBuilder()
            .setMethodDescriptor(unregisterGcpMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.registerGcpCallable =
        callableFactory.createUnaryCallable(
            registerGcpTransportSettings, settings.registerGcpSettings(), clientContext);
    this.getDeveloperRegistrationCallable =
        callableFactory.createUnaryCallable(
            getDeveloperRegistrationTransportSettings,
            settings.getDeveloperRegistrationSettings(),
            clientContext);
    this.unregisterGcpCallable =
        callableFactory.createUnaryCallable(
            unregisterGcpTransportSettings, settings.unregisterGcpSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<RegisterGcpRequest, DeveloperRegistration> registerGcpCallable() {
    return registerGcpCallable;
  }

  @Override
  public UnaryCallable<GetDeveloperRegistrationRequest, DeveloperRegistration>
      getDeveloperRegistrationCallable() {
    return getDeveloperRegistrationCallable;
  }

  @Override
  public UnaryCallable<UnregisterGcpRequest, Empty> unregisterGcpCallable() {
    return unregisterGcpCallable;
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
