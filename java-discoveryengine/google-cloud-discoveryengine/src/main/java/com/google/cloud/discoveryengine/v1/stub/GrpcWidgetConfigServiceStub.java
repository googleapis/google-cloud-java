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

package com.google.cloud.discoveryengine.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.GetWidgetConfigRequest;
import com.google.cloud.discoveryengine.v1.UpdateWidgetConfigRequest;
import com.google.cloud.discoveryengine.v1.WidgetConfig;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the WidgetConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GrpcWidgetConfigServiceStub extends WidgetConfigServiceStub {
  private static final MethodDescriptor<GetWidgetConfigRequest, WidgetConfig>
      getWidgetConfigMethodDescriptor =
          MethodDescriptor.<GetWidgetConfigRequest, WidgetConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.WidgetConfigService/GetWidgetConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWidgetConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WidgetConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateWidgetConfigRequest, WidgetConfig>
      updateWidgetConfigMethodDescriptor =
          MethodDescriptor.<UpdateWidgetConfigRequest, WidgetConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.WidgetConfigService/UpdateWidgetConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateWidgetConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WidgetConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetWidgetConfigRequest, WidgetConfig> getWidgetConfigCallable;
  private final UnaryCallable<UpdateWidgetConfigRequest, WidgetConfig> updateWidgetConfigCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcWidgetConfigServiceStub create(WidgetConfigServiceStubSettings settings)
      throws IOException {
    return new GrpcWidgetConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcWidgetConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcWidgetConfigServiceStub(
        WidgetConfigServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWidgetConfigServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWidgetConfigServiceStub(
        WidgetConfigServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWidgetConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWidgetConfigServiceStub(
      WidgetConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcWidgetConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcWidgetConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWidgetConfigServiceStub(
      WidgetConfigServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetWidgetConfigRequest, WidgetConfig> getWidgetConfigTransportSettings =
        GrpcCallSettings.<GetWidgetConfigRequest, WidgetConfig>newBuilder()
            .setMethodDescriptor(getWidgetConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateWidgetConfigRequest, WidgetConfig> updateWidgetConfigTransportSettings =
        GrpcCallSettings.<UpdateWidgetConfigRequest, WidgetConfig>newBuilder()
            .setMethodDescriptor(updateWidgetConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "widget_config.name", String.valueOf(request.getWidgetConfig().getName()));
                  return builder.build();
                })
            .build();

    this.getWidgetConfigCallable =
        callableFactory.createUnaryCallable(
            getWidgetConfigTransportSettings, settings.getWidgetConfigSettings(), clientContext);
    this.updateWidgetConfigCallable =
        callableFactory.createUnaryCallable(
            updateWidgetConfigTransportSettings,
            settings.updateWidgetConfigSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetWidgetConfigRequest, WidgetConfig> getWidgetConfigCallable() {
    return getWidgetConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateWidgetConfigRequest, WidgetConfig> updateWidgetConfigCallable() {
    return updateWidgetConfigCallable;
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
