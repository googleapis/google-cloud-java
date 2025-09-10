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

import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckConfigsPagedResponse;
import static com.google.cloud.monitoring.v3.UptimeCheckServiceClient.ListUptimeCheckIpsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.monitoring.v3.CreateUptimeCheckConfigRequest;
import com.google.monitoring.v3.DeleteUptimeCheckConfigRequest;
import com.google.monitoring.v3.GetUptimeCheckConfigRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsRequest;
import com.google.monitoring.v3.ListUptimeCheckConfigsResponse;
import com.google.monitoring.v3.ListUptimeCheckIpsRequest;
import com.google.monitoring.v3.ListUptimeCheckIpsResponse;
import com.google.monitoring.v3.UpdateUptimeCheckConfigRequest;
import com.google.monitoring.v3.UptimeCheckConfig;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the UptimeCheckService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcUptimeCheckServiceStub extends UptimeCheckServiceStub {
  private static final MethodDescriptor<
          ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>
      listUptimeCheckConfigsMethodDescriptor =
          MethodDescriptor
              .<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/ListUptimeCheckConfigs")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUptimeCheckConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUptimeCheckConfigsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigMethodDescriptor =
          MethodDescriptor.<GetUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/GetUptimeCheckConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UptimeCheckConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigMethodDescriptor =
          MethodDescriptor.<CreateUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/CreateUptimeCheckConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UptimeCheckConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigMethodDescriptor =
          MethodDescriptor.<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/UpdateUptimeCheckConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UptimeCheckConfig.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteUptimeCheckConfigRequest, Empty>
      deleteUptimeCheckConfigMethodDescriptor =
          MethodDescriptor.<DeleteUptimeCheckConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/DeleteUptimeCheckConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>
      listUptimeCheckIpsMethodDescriptor =
          MethodDescriptor.<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/ListUptimeCheckIps")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListUptimeCheckIpsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListUptimeCheckIpsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>
      listUptimeCheckConfigsCallable;
  private final UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsPagedResponse>
      listUptimeCheckConfigsPagedCallable;
  private final UnaryCallable<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigCallable;
  private final UnaryCallable<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigCallable;
  private final UnaryCallable<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigCallable;
  private final UnaryCallable<DeleteUptimeCheckConfigRequest, Empty>
      deleteUptimeCheckConfigCallable;
  private final UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>
      listUptimeCheckIpsCallable;
  private final UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsPagedResponse>
      listUptimeCheckIpsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcUptimeCheckServiceStub create(UptimeCheckServiceStubSettings settings)
      throws IOException {
    return new GrpcUptimeCheckServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcUptimeCheckServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcUptimeCheckServiceStub(
        UptimeCheckServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcUptimeCheckServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcUptimeCheckServiceStub(
        UptimeCheckServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcUptimeCheckServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcUptimeCheckServiceStub(
      UptimeCheckServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcUptimeCheckServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcUptimeCheckServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcUptimeCheckServiceStub(
      UptimeCheckServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>
        listUptimeCheckConfigsTransportSettings =
            GrpcCallSettings
                .<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>newBuilder()
                .setMethodDescriptor(listUptimeCheckConfigsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetUptimeCheckConfigRequest, UptimeCheckConfig>
        getUptimeCheckConfigTransportSettings =
            GrpcCallSettings.<GetUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
                .setMethodDescriptor(getUptimeCheckConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
        createUptimeCheckConfigTransportSettings =
            GrpcCallSettings.<CreateUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
                .setMethodDescriptor(createUptimeCheckConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
        updateUptimeCheckConfigTransportSettings =
            GrpcCallSettings.<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
                .setMethodDescriptor(updateUptimeCheckConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "uptime_check_config.name",
                          String.valueOf(request.getUptimeCheckConfig().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteUptimeCheckConfigRequest, Empty>
        deleteUptimeCheckConfigTransportSettings =
            GrpcCallSettings.<DeleteUptimeCheckConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteUptimeCheckConfigMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>
        listUptimeCheckIpsTransportSettings =
            GrpcCallSettings.<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>newBuilder()
                .setMethodDescriptor(listUptimeCheckIpsMethodDescriptor)
                .build();

    this.listUptimeCheckConfigsCallable =
        callableFactory.createUnaryCallable(
            listUptimeCheckConfigsTransportSettings,
            settings.listUptimeCheckConfigsSettings(),
            clientContext);
    this.listUptimeCheckConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listUptimeCheckConfigsTransportSettings,
            settings.listUptimeCheckConfigsSettings(),
            clientContext);
    this.getUptimeCheckConfigCallable =
        callableFactory.createUnaryCallable(
            getUptimeCheckConfigTransportSettings,
            settings.getUptimeCheckConfigSettings(),
            clientContext);
    this.createUptimeCheckConfigCallable =
        callableFactory.createUnaryCallable(
            createUptimeCheckConfigTransportSettings,
            settings.createUptimeCheckConfigSettings(),
            clientContext);
    this.updateUptimeCheckConfigCallable =
        callableFactory.createUnaryCallable(
            updateUptimeCheckConfigTransportSettings,
            settings.updateUptimeCheckConfigSettings(),
            clientContext);
    this.deleteUptimeCheckConfigCallable =
        callableFactory.createUnaryCallable(
            deleteUptimeCheckConfigTransportSettings,
            settings.deleteUptimeCheckConfigSettings(),
            clientContext);
    this.listUptimeCheckIpsCallable =
        callableFactory.createUnaryCallable(
            listUptimeCheckIpsTransportSettings,
            settings.listUptimeCheckIpsSettings(),
            clientContext);
    this.listUptimeCheckIpsPagedCallable =
        callableFactory.createPagedCallable(
            listUptimeCheckIpsTransportSettings,
            settings.listUptimeCheckIpsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>
      listUptimeCheckConfigsCallable() {
    return listUptimeCheckConfigsCallable;
  }

  @Override
  public UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsPagedResponse>
      listUptimeCheckConfigsPagedCallable() {
    return listUptimeCheckConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigCallable() {
    return getUptimeCheckConfigCallable;
  }

  @Override
  public UnaryCallable<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigCallable() {
    return createUptimeCheckConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigCallable() {
    return updateUptimeCheckConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteUptimeCheckConfigRequest, Empty> deleteUptimeCheckConfigCallable() {
    return deleteUptimeCheckConfigCallable;
  }

  @Override
  public UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>
      listUptimeCheckIpsCallable() {
    return listUptimeCheckIpsCallable;
  }

  @Override
  public UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsPagedResponse>
      listUptimeCheckIpsPagedCallable() {
    return listUptimeCheckIpsPagedCallable;
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
