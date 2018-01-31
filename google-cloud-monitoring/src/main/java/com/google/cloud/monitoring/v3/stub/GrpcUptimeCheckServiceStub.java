/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.monitoring.v3.stub;

import static com.google.cloud.monitoring.v3.PagedResponseWrappers.ListUptimeCheckConfigsPagedResponse;
import static com.google.cloud.monitoring.v3.PagedResponseWrappers.ListUptimeCheckIpsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Monitoring API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
              .build();
  private static final MethodDescriptor<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigMethodDescriptor =
          MethodDescriptor.<GetUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/GetUptimeCheckConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UptimeCheckConfig.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigMethodDescriptor =
          MethodDescriptor.<CreateUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/CreateUptimeCheckConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UptimeCheckConfig.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigMethodDescriptor =
          MethodDescriptor.<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/UpdateUptimeCheckConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(UptimeCheckConfig.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteUptimeCheckConfigRequest, Empty>
      deleteUptimeCheckConfigMethodDescriptor =
          MethodDescriptor.<DeleteUptimeCheckConfigRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.monitoring.v3.UptimeCheckService/DeleteUptimeCheckConfig")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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
              .build();

  private final BackgroundResource backgroundResources;

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

  public static final GrpcUptimeCheckServiceStub create(UptimeCheckServiceStubSettings settings)
      throws IOException {
    return new GrpcUptimeCheckServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcUptimeCheckServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcUptimeCheckServiceStub(
        UptimeCheckServiceStubSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcUptimeCheckServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcUptimeCheckServiceStub(
      UptimeCheckServiceStubSettings settings, ClientContext clientContext) throws IOException {

    GrpcCallSettings<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>
        listUptimeCheckConfigsTransportSettings =
            GrpcCallSettings
                .<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>newBuilder()
                .setMethodDescriptor(listUptimeCheckConfigsMethodDescriptor)
                .build();
    GrpcCallSettings<GetUptimeCheckConfigRequest, UptimeCheckConfig>
        getUptimeCheckConfigTransportSettings =
            GrpcCallSettings.<GetUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
                .setMethodDescriptor(getUptimeCheckConfigMethodDescriptor)
                .build();
    GrpcCallSettings<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
        createUptimeCheckConfigTransportSettings =
            GrpcCallSettings.<CreateUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
                .setMethodDescriptor(createUptimeCheckConfigMethodDescriptor)
                .build();
    GrpcCallSettings<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
        updateUptimeCheckConfigTransportSettings =
            GrpcCallSettings.<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>newBuilder()
                .setMethodDescriptor(updateUptimeCheckConfigMethodDescriptor)
                .build();
    GrpcCallSettings<DeleteUptimeCheckConfigRequest, Empty>
        deleteUptimeCheckConfigTransportSettings =
            GrpcCallSettings.<DeleteUptimeCheckConfigRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteUptimeCheckConfigMethodDescriptor)
                .build();
    GrpcCallSettings<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>
        listUptimeCheckIpsTransportSettings =
            GrpcCallSettings.<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>newBuilder()
                .setMethodDescriptor(listUptimeCheckIpsMethodDescriptor)
                .build();

    this.listUptimeCheckConfigsCallable =
        GrpcCallableFactory.createUnaryCallable(
            listUptimeCheckConfigsTransportSettings,
            settings.listUptimeCheckConfigsSettings(),
            clientContext);
    this.listUptimeCheckConfigsPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            listUptimeCheckConfigsTransportSettings,
            settings.listUptimeCheckConfigsSettings(),
            clientContext);
    this.getUptimeCheckConfigCallable =
        GrpcCallableFactory.createUnaryCallable(
            getUptimeCheckConfigTransportSettings,
            settings.getUptimeCheckConfigSettings(),
            clientContext);
    this.createUptimeCheckConfigCallable =
        GrpcCallableFactory.createUnaryCallable(
            createUptimeCheckConfigTransportSettings,
            settings.createUptimeCheckConfigSettings(),
            clientContext);
    this.updateUptimeCheckConfigCallable =
        GrpcCallableFactory.createUnaryCallable(
            updateUptimeCheckConfigTransportSettings,
            settings.updateUptimeCheckConfigSettings(),
            clientContext);
    this.deleteUptimeCheckConfigCallable =
        GrpcCallableFactory.createUnaryCallable(
            deleteUptimeCheckConfigTransportSettings,
            settings.deleteUptimeCheckConfigSettings(),
            clientContext);
    this.listUptimeCheckIpsCallable =
        GrpcCallableFactory.createUnaryCallable(
            listUptimeCheckIpsTransportSettings,
            settings.listUptimeCheckIpsSettings(),
            clientContext);
    this.listUptimeCheckIpsPagedCallable =
        GrpcCallableFactory.createPagedCallable(
            listUptimeCheckIpsTransportSettings,
            settings.listUptimeCheckIpsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsPagedResponse>
      listUptimeCheckConfigsPagedCallable() {
    return listUptimeCheckConfigsPagedCallable;
  }

  public UnaryCallable<ListUptimeCheckConfigsRequest, ListUptimeCheckConfigsResponse>
      listUptimeCheckConfigsCallable() {
    return listUptimeCheckConfigsCallable;
  }

  public UnaryCallable<GetUptimeCheckConfigRequest, UptimeCheckConfig>
      getUptimeCheckConfigCallable() {
    return getUptimeCheckConfigCallable;
  }

  public UnaryCallable<CreateUptimeCheckConfigRequest, UptimeCheckConfig>
      createUptimeCheckConfigCallable() {
    return createUptimeCheckConfigCallable;
  }

  public UnaryCallable<UpdateUptimeCheckConfigRequest, UptimeCheckConfig>
      updateUptimeCheckConfigCallable() {
    return updateUptimeCheckConfigCallable;
  }

  public UnaryCallable<DeleteUptimeCheckConfigRequest, Empty> deleteUptimeCheckConfigCallable() {
    return deleteUptimeCheckConfigCallable;
  }

  public UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsPagedResponse>
      listUptimeCheckIpsPagedCallable() {
    return listUptimeCheckIpsPagedCallable;
  }

  public UnaryCallable<ListUptimeCheckIpsRequest, ListUptimeCheckIpsResponse>
      listUptimeCheckIpsCallable() {
    return listUptimeCheckIpsCallable;
  }

  @Override
  public final void close() throws Exception {
    shutdown();
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
