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

package com.google.cloud.retail.v2beta.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.AlertConfig;
import com.google.cloud.retail.v2beta.GetAlertConfigRequest;
import com.google.cloud.retail.v2beta.UpdateAlertConfigRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ProjectService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcProjectServiceStub extends ProjectServiceStub {
  private static final MethodDescriptor<GetAlertConfigRequest, AlertConfig>
      getAlertConfigMethodDescriptor =
          MethodDescriptor.<GetAlertConfigRequest, AlertConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.ProjectService/GetAlertConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAlertConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AlertConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAlertConfigRequest, AlertConfig>
      updateAlertConfigMethodDescriptor =
          MethodDescriptor.<UpdateAlertConfigRequest, AlertConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.ProjectService/UpdateAlertConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAlertConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AlertConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable;
  private final UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcProjectServiceStub create(ProjectServiceStubSettings settings)
      throws IOException {
    return new GrpcProjectServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcProjectServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcProjectServiceStub(
        ProjectServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcProjectServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcProjectServiceStub(
        ProjectServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcProjectServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProjectServiceStub(ProjectServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcProjectServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcProjectServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcProjectServiceStub(
      ProjectServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetAlertConfigRequest, AlertConfig> getAlertConfigTransportSettings =
        GrpcCallSettings.<GetAlertConfigRequest, AlertConfig>newBuilder()
            .setMethodDescriptor(getAlertConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigTransportSettings =
        GrpcCallSettings.<UpdateAlertConfigRequest, AlertConfig>newBuilder()
            .setMethodDescriptor(updateAlertConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "alert_config.name", String.valueOf(request.getAlertConfig().getName()));
                  return builder.build();
                })
            .build();

    this.getAlertConfigCallable =
        callableFactory.createUnaryCallable(
            getAlertConfigTransportSettings, settings.getAlertConfigSettings(), clientContext);
    this.updateAlertConfigCallable =
        callableFactory.createUnaryCallable(
            updateAlertConfigTransportSettings,
            settings.updateAlertConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable() {
    return getAlertConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable() {
    return updateAlertConfigCallable;
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
