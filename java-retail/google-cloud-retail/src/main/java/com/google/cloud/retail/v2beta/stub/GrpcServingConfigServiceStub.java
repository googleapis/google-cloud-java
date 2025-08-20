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

import static com.google.cloud.retail.v2beta.ServingConfigServiceClient.ListServingConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2beta.AddControlRequest;
import com.google.cloud.retail.v2beta.CreateServingConfigRequest;
import com.google.cloud.retail.v2beta.DeleteServingConfigRequest;
import com.google.cloud.retail.v2beta.GetServingConfigRequest;
import com.google.cloud.retail.v2beta.ListServingConfigsRequest;
import com.google.cloud.retail.v2beta.ListServingConfigsResponse;
import com.google.cloud.retail.v2beta.RemoveControlRequest;
import com.google.cloud.retail.v2beta.ServingConfig;
import com.google.cloud.retail.v2beta.UpdateServingConfigRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ServingConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcServingConfigServiceStub extends ServingConfigServiceStub {
  private static final MethodDescriptor<CreateServingConfigRequest, ServingConfig>
      createServingConfigMethodDescriptor =
          MethodDescriptor.<CreateServingConfigRequest, ServingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.ServingConfigService/CreateServingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateServingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServingConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteServingConfigRequest, Empty>
      deleteServingConfigMethodDescriptor =
          MethodDescriptor.<DeleteServingConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.ServingConfigService/DeleteServingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteServingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateServingConfigRequest, ServingConfig>
      updateServingConfigMethodDescriptor =
          MethodDescriptor.<UpdateServingConfigRequest, ServingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.ServingConfigService/UpdateServingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateServingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServingConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetServingConfigRequest, ServingConfig>
      getServingConfigMethodDescriptor =
          MethodDescriptor.<GetServingConfigRequest, ServingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.ServingConfigService/GetServingConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetServingConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServingConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListServingConfigsRequest, ListServingConfigsResponse>
      listServingConfigsMethodDescriptor =
          MethodDescriptor.<ListServingConfigsRequest, ListServingConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.retail.v2beta.ServingConfigService/ListServingConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListServingConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListServingConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<AddControlRequest, ServingConfig>
      addControlMethodDescriptor =
          MethodDescriptor.<AddControlRequest, ServingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.ServingConfigService/AddControl")
              .setRequestMarshaller(ProtoUtils.marshaller(AddControlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServingConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RemoveControlRequest, ServingConfig>
      removeControlMethodDescriptor =
          MethodDescriptor.<RemoveControlRequest, ServingConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.retail.v2beta.ServingConfigService/RemoveControl")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveControlRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ServingConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateServingConfigRequest, ServingConfig>
      createServingConfigCallable;
  private final UnaryCallable<DeleteServingConfigRequest, Empty> deleteServingConfigCallable;
  private final UnaryCallable<UpdateServingConfigRequest, ServingConfig>
      updateServingConfigCallable;
  private final UnaryCallable<GetServingConfigRequest, ServingConfig> getServingConfigCallable;
  private final UnaryCallable<ListServingConfigsRequest, ListServingConfigsResponse>
      listServingConfigsCallable;
  private final UnaryCallable<ListServingConfigsRequest, ListServingConfigsPagedResponse>
      listServingConfigsPagedCallable;
  private final UnaryCallable<AddControlRequest, ServingConfig> addControlCallable;
  private final UnaryCallable<RemoveControlRequest, ServingConfig> removeControlCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcServingConfigServiceStub create(ServingConfigServiceStubSettings settings)
      throws IOException {
    return new GrpcServingConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcServingConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcServingConfigServiceStub(
        ServingConfigServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcServingConfigServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcServingConfigServiceStub(
        ServingConfigServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcServingConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcServingConfigServiceStub(
      ServingConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcServingConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcServingConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcServingConfigServiceStub(
      ServingConfigServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateServingConfigRequest, ServingConfig>
        createServingConfigTransportSettings =
            GrpcCallSettings.<CreateServingConfigRequest, ServingConfig>newBuilder()
                .setMethodDescriptor(createServingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteServingConfigRequest, Empty> deleteServingConfigTransportSettings =
        GrpcCallSettings.<DeleteServingConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteServingConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateServingConfigRequest, ServingConfig>
        updateServingConfigTransportSettings =
            GrpcCallSettings.<UpdateServingConfigRequest, ServingConfig>newBuilder()
                .setMethodDescriptor(updateServingConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "serving_config.name",
                          String.valueOf(request.getServingConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetServingConfigRequest, ServingConfig> getServingConfigTransportSettings =
        GrpcCallSettings.<GetServingConfigRequest, ServingConfig>newBuilder()
            .setMethodDescriptor(getServingConfigMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListServingConfigsRequest, ListServingConfigsResponse>
        listServingConfigsTransportSettings =
            GrpcCallSettings.<ListServingConfigsRequest, ListServingConfigsResponse>newBuilder()
                .setMethodDescriptor(listServingConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<AddControlRequest, ServingConfig> addControlTransportSettings =
        GrpcCallSettings.<AddControlRequest, ServingConfig>newBuilder()
            .setMethodDescriptor(addControlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("serving_config", String.valueOf(request.getServingConfig()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RemoveControlRequest, ServingConfig> removeControlTransportSettings =
        GrpcCallSettings.<RemoveControlRequest, ServingConfig>newBuilder()
            .setMethodDescriptor(removeControlMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("serving_config", String.valueOf(request.getServingConfig()));
                  return builder.build();
                })
            .build();

    this.createServingConfigCallable =
        callableFactory.createUnaryCallable(
            createServingConfigTransportSettings,
            settings.createServingConfigSettings(),
            clientContext);
    this.deleteServingConfigCallable =
        callableFactory.createUnaryCallable(
            deleteServingConfigTransportSettings,
            settings.deleteServingConfigSettings(),
            clientContext);
    this.updateServingConfigCallable =
        callableFactory.createUnaryCallable(
            updateServingConfigTransportSettings,
            settings.updateServingConfigSettings(),
            clientContext);
    this.getServingConfigCallable =
        callableFactory.createUnaryCallable(
            getServingConfigTransportSettings, settings.getServingConfigSettings(), clientContext);
    this.listServingConfigsCallable =
        callableFactory.createUnaryCallable(
            listServingConfigsTransportSettings,
            settings.listServingConfigsSettings(),
            clientContext);
    this.listServingConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listServingConfigsTransportSettings,
            settings.listServingConfigsSettings(),
            clientContext);
    this.addControlCallable =
        callableFactory.createUnaryCallable(
            addControlTransportSettings, settings.addControlSettings(), clientContext);
    this.removeControlCallable =
        callableFactory.createUnaryCallable(
            removeControlTransportSettings, settings.removeControlSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateServingConfigRequest, ServingConfig> createServingConfigCallable() {
    return createServingConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteServingConfigRequest, Empty> deleteServingConfigCallable() {
    return deleteServingConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateServingConfigRequest, ServingConfig> updateServingConfigCallable() {
    return updateServingConfigCallable;
  }

  @Override
  public UnaryCallable<GetServingConfigRequest, ServingConfig> getServingConfigCallable() {
    return getServingConfigCallable;
  }

  @Override
  public UnaryCallable<ListServingConfigsRequest, ListServingConfigsResponse>
      listServingConfigsCallable() {
    return listServingConfigsCallable;
  }

  @Override
  public UnaryCallable<ListServingConfigsRequest, ListServingConfigsPagedResponse>
      listServingConfigsPagedCallable() {
    return listServingConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<AddControlRequest, ServingConfig> addControlCallable() {
    return addControlCallable;
  }

  @Override
  public UnaryCallable<RemoveControlRequest, ServingConfig> removeControlCallable() {
    return removeControlCallable;
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
