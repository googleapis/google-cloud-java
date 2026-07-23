/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.sql.v1beta4.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.sql.v1beta4.ConnectSettings;
import com.google.cloud.sql.v1beta4.GenerateEphemeralCertRequest;
import com.google.cloud.sql.v1beta4.GenerateEphemeralCertResponse;
import com.google.cloud.sql.v1beta4.GetConnectSettingsRequest;
import com.google.cloud.sql.v1beta4.ResolveConnectSettingsRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the SqlConnectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSqlConnectServiceStub extends SqlConnectServiceStub {
  private static final MethodDescriptor<GetConnectSettingsRequest, ConnectSettings>
      getConnectSettingsMethodDescriptor =
          MethodDescriptor.<GetConnectSettingsRequest, ConnectSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlConnectService/GetConnectSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConnectSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConnectSettings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ResolveConnectSettingsRequest, ConnectSettings>
      resolveConnectSettingsMethodDescriptor =
          MethodDescriptor.<ResolveConnectSettingsRequest, ConnectSettings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.sql.v1beta4.SqlConnectService/ResolveConnectSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ResolveConnectSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConnectSettings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
      generateEphemeralCertMethodDescriptor =
          MethodDescriptor.<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.sql.v1beta4.SqlConnectService/GenerateEphemeralCert")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateEphemeralCertRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateEphemeralCertResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetConnectSettingsRequest, ConnectSettings>
      getConnectSettingsCallable;
  private final UnaryCallable<ResolveConnectSettingsRequest, ConnectSettings>
      resolveConnectSettingsCallable;
  private final UnaryCallable<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
      generateEphemeralCertCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSqlConnectServiceStub create(SqlConnectServiceStubSettings settings)
      throws IOException {
    return new GrpcSqlConnectServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSqlConnectServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcSqlConnectServiceStub(
        SqlConnectServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSqlConnectServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSqlConnectServiceStub(
        SqlConnectServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSqlConnectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlConnectServiceStub(
      SqlConnectServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcSqlConnectServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSqlConnectServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcSqlConnectServiceStub(
      SqlConnectServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetConnectSettingsRequest, ConnectSettings>
        getConnectSettingsTransportSettings =
            GrpcCallSettings.<GetConnectSettingsRequest, ConnectSettings>newBuilder()
                .setMethodDescriptor(getConnectSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ResolveConnectSettingsRequest, ConnectSettings>
        resolveConnectSettingsTransportSettings =
            GrpcCallSettings.<ResolveConnectSettingsRequest, ConnectSettings>newBuilder()
                .setMethodDescriptor(resolveConnectSettingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("dns_name", String.valueOf(request.getDnsName()));
                      builder.add("location", String.valueOf(request.getLocation()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
        generateEphemeralCertTransportSettings =
            GrpcCallSettings
                .<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>newBuilder()
                .setMethodDescriptor(generateEphemeralCertMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("instance", String.valueOf(request.getInstance()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();

    this.getConnectSettingsCallable =
        callableFactory.createUnaryCallable(
            getConnectSettingsTransportSettings,
            settings.getConnectSettingsSettings(),
            clientContext);
    this.resolveConnectSettingsCallable =
        callableFactory.createUnaryCallable(
            resolveConnectSettingsTransportSettings,
            settings.resolveConnectSettingsSettings(),
            clientContext);
    this.generateEphemeralCertCallable =
        callableFactory.createUnaryCallable(
            generateEphemeralCertTransportSettings,
            settings.generateEphemeralCertSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetConnectSettingsRequest, ConnectSettings> getConnectSettingsCallable() {
    return getConnectSettingsCallable;
  }

  @Override
  public UnaryCallable<ResolveConnectSettingsRequest, ConnectSettings>
      resolveConnectSettingsCallable() {
    return resolveConnectSettingsCallable;
  }

  @Override
  public UnaryCallable<GenerateEphemeralCertRequest, GenerateEphemeralCertResponse>
      generateEphemeralCertCallable() {
    return generateEphemeralCertCallable;
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
