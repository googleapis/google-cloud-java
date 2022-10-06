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

package com.google.cloud.resourcesettings.v1.stub;

import static com.google.cloud.resourcesettings.v1.ResourceSettingsServiceClient.ListSettingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcesettings.v1.GetSettingRequest;
import com.google.cloud.resourcesettings.v1.ListSettingsRequest;
import com.google.cloud.resourcesettings.v1.ListSettingsResponse;
import com.google.cloud.resourcesettings.v1.Setting;
import com.google.cloud.resourcesettings.v1.UpdateSettingRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ResourceSettingsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcResourceSettingsServiceStub extends ResourceSettingsServiceStub {
  private static final MethodDescriptor<ListSettingsRequest, ListSettingsResponse>
      listSettingsMethodDescriptor =
          MethodDescriptor.<ListSettingsRequest, ListSettingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.resourcesettings.v1.ResourceSettingsService/ListSettings")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSettingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSettingRequest, Setting> getSettingMethodDescriptor =
      MethodDescriptor.<GetSettingRequest, Setting>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.resourcesettings.v1.ResourceSettingsService/GetSetting")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSettingRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Setting.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSettingRequest, Setting>
      updateSettingMethodDescriptor =
          MethodDescriptor.<UpdateSettingRequest, Setting>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.resourcesettings.v1.ResourceSettingsService/UpdateSetting")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSettingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Setting.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListSettingsRequest, ListSettingsResponse> listSettingsCallable;
  private final UnaryCallable<ListSettingsRequest, ListSettingsPagedResponse>
      listSettingsPagedCallable;
  private final UnaryCallable<GetSettingRequest, Setting> getSettingCallable;
  private final UnaryCallable<UpdateSettingRequest, Setting> updateSettingCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcResourceSettingsServiceStub create(
      ResourceSettingsServiceStubSettings settings) throws IOException {
    return new GrpcResourceSettingsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcResourceSettingsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcResourceSettingsServiceStub(
        ResourceSettingsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcResourceSettingsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcResourceSettingsServiceStub(
        ResourceSettingsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcResourceSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcResourceSettingsServiceStub(
      ResourceSettingsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcResourceSettingsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcResourceSettingsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcResourceSettingsServiceStub(
      ResourceSettingsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListSettingsRequest, ListSettingsResponse> listSettingsTransportSettings =
        GrpcCallSettings.<ListSettingsRequest, ListSettingsResponse>newBuilder()
            .setMethodDescriptor(listSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetSettingRequest, Setting> getSettingTransportSettings =
        GrpcCallSettings.<GetSettingRequest, Setting>newBuilder()
            .setMethodDescriptor(getSettingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateSettingRequest, Setting> updateSettingTransportSettings =
        GrpcCallSettings.<UpdateSettingRequest, Setting>newBuilder()
            .setMethodDescriptor(updateSettingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("setting.name", String.valueOf(request.getSetting().getName()));
                  return params.build();
                })
            .build();

    this.listSettingsCallable =
        callableFactory.createUnaryCallable(
            listSettingsTransportSettings, settings.listSettingsSettings(), clientContext);
    this.listSettingsPagedCallable =
        callableFactory.createPagedCallable(
            listSettingsTransportSettings, settings.listSettingsSettings(), clientContext);
    this.getSettingCallable =
        callableFactory.createUnaryCallable(
            getSettingTransportSettings, settings.getSettingSettings(), clientContext);
    this.updateSettingCallable =
        callableFactory.createUnaryCallable(
            updateSettingTransportSettings, settings.updateSettingSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListSettingsRequest, ListSettingsResponse> listSettingsCallable() {
    return listSettingsCallable;
  }

  @Override
  public UnaryCallable<ListSettingsRequest, ListSettingsPagedResponse> listSettingsPagedCallable() {
    return listSettingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetSettingRequest, Setting> getSettingCallable() {
    return getSettingCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingRequest, Setting> updateSettingCallable() {
    return updateSettingCallable;
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
