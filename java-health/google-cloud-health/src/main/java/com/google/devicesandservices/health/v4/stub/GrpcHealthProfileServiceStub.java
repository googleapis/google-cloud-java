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

package com.google.devicesandservices.health.v4.stub;

import static com.google.devicesandservices.health.v4.HealthProfileServiceClient.ListPairedDevicesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.devicesandservices.health.v4.GetIdentityRequest;
import com.google.devicesandservices.health.v4.GetIrnProfileRequest;
import com.google.devicesandservices.health.v4.GetPairedDeviceRequest;
import com.google.devicesandservices.health.v4.GetProfileRequest;
import com.google.devicesandservices.health.v4.GetSettingsRequest;
import com.google.devicesandservices.health.v4.Identity;
import com.google.devicesandservices.health.v4.IrnProfile;
import com.google.devicesandservices.health.v4.ListPairedDevicesRequest;
import com.google.devicesandservices.health.v4.ListPairedDevicesResponse;
import com.google.devicesandservices.health.v4.PairedDevice;
import com.google.devicesandservices.health.v4.Profile;
import com.google.devicesandservices.health.v4.Settings;
import com.google.devicesandservices.health.v4.UpdateProfileRequest;
import com.google.devicesandservices.health.v4.UpdateSettingsRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the HealthProfileService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcHealthProfileServiceStub extends HealthProfileServiceStub {
  private static final MethodDescriptor<GetProfileRequest, Profile> getProfileMethodDescriptor =
      MethodDescriptor.<GetProfileRequest, Profile>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devicesandservices.health.v4.HealthProfileService/GetProfile")
          .setRequestMarshaller(ProtoUtils.marshaller(GetProfileRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Profile.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateProfileRequest, Profile>
      updateProfileMethodDescriptor =
          MethodDescriptor.<UpdateProfileRequest, Profile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/UpdateProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Profile.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSettingsRequest, Settings> getSettingsMethodDescriptor =
      MethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devicesandservices.health.v4.HealthProfileService/GetSettings")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSettingsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateSettingsRequest, Settings>
      updateSettingsMethodDescriptor =
          MethodDescriptor.<UpdateSettingsRequest, Settings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/UpdateSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIdentityRequest, Identity> getIdentityMethodDescriptor =
      MethodDescriptor.<GetIdentityRequest, Identity>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devicesandservices.health.v4.HealthProfileService/GetIdentity")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIdentityRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Identity.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetIrnProfileRequest, IrnProfile>
      getIrnProfileMethodDescriptor =
          MethodDescriptor.<GetIrnProfileRequest, IrnProfile>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/GetIrnProfile")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIrnProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IrnProfile.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPairedDeviceRequest, PairedDevice>
      getPairedDeviceMethodDescriptor =
          MethodDescriptor.<GetPairedDeviceRequest, PairedDevice>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/GetPairedDevice")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPairedDeviceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PairedDevice.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListPairedDevicesRequest, ListPairedDevicesResponse>
      listPairedDevicesMethodDescriptor =
          MethodDescriptor.<ListPairedDevicesRequest, ListPairedDevicesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devicesandservices.health.v4.HealthProfileService/ListPairedDevices")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPairedDevicesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPairedDevicesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<GetProfileRequest, Profile> getProfileCallable;
  private final UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable;
  private final UnaryCallable<GetIdentityRequest, Identity> getIdentityCallable;
  private final UnaryCallable<GetIrnProfileRequest, IrnProfile> getIrnProfileCallable;
  private final UnaryCallable<GetPairedDeviceRequest, PairedDevice> getPairedDeviceCallable;
  private final UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesResponse>
      listPairedDevicesCallable;
  private final UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesPagedResponse>
      listPairedDevicesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcHealthProfileServiceStub create(HealthProfileServiceStubSettings settings)
      throws IOException {
    return new GrpcHealthProfileServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcHealthProfileServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcHealthProfileServiceStub(
        HealthProfileServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcHealthProfileServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcHealthProfileServiceStub(
        HealthProfileServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcHealthProfileServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcHealthProfileServiceStub(
      HealthProfileServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcHealthProfileServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcHealthProfileServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcHealthProfileServiceStub(
      HealthProfileServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetProfileRequest, Profile> getProfileTransportSettings =
        GrpcCallSettings.<GetProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(getProfileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateProfileRequest, Profile> updateProfileTransportSettings =
        GrpcCallSettings.<UpdateProfileRequest, Profile>newBuilder()
            .setMethodDescriptor(updateProfileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("profile.name", String.valueOf(request.getProfile().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        GrpcCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        GrpcCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("settings.name", String.valueOf(request.getSettings().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIdentityRequest, Identity> getIdentityTransportSettings =
        GrpcCallSettings.<GetIdentityRequest, Identity>newBuilder()
            .setMethodDescriptor(getIdentityMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetIrnProfileRequest, IrnProfile> getIrnProfileTransportSettings =
        GrpcCallSettings.<GetIrnProfileRequest, IrnProfile>newBuilder()
            .setMethodDescriptor(getIrnProfileMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<GetPairedDeviceRequest, PairedDevice> getPairedDeviceTransportSettings =
        GrpcCallSettings.<GetPairedDeviceRequest, PairedDevice>newBuilder()
            .setMethodDescriptor(getPairedDeviceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    GrpcCallSettings<ListPairedDevicesRequest, ListPairedDevicesResponse>
        listPairedDevicesTransportSettings =
            GrpcCallSettings.<ListPairedDevicesRequest, ListPairedDevicesResponse>newBuilder()
                .setMethodDescriptor(listPairedDevicesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getProfileCallable =
        callableFactory.createUnaryCallable(
            getProfileTransportSettings, settings.getProfileSettings(), clientContext);
    this.updateProfileCallable =
        callableFactory.createUnaryCallable(
            updateProfileTransportSettings, settings.updateProfileSettings(), clientContext);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);
    this.getIdentityCallable =
        callableFactory.createUnaryCallable(
            getIdentityTransportSettings, settings.getIdentitySettings(), clientContext);
    this.getIrnProfileCallable =
        callableFactory.createUnaryCallable(
            getIrnProfileTransportSettings, settings.getIrnProfileSettings(), clientContext);
    this.getPairedDeviceCallable =
        callableFactory.createUnaryCallable(
            getPairedDeviceTransportSettings, settings.getPairedDeviceSettings(), clientContext);
    this.listPairedDevicesCallable =
        callableFactory.createUnaryCallable(
            listPairedDevicesTransportSettings,
            settings.listPairedDevicesSettings(),
            clientContext);
    this.listPairedDevicesPagedCallable =
        callableFactory.createPagedCallable(
            listPairedDevicesTransportSettings,
            settings.listPairedDevicesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetProfileRequest, Profile> getProfileCallable() {
    return getProfileCallable;
  }

  @Override
  public UnaryCallable<UpdateProfileRequest, Profile> updateProfileCallable() {
    return updateProfileCallable;
  }

  @Override
  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return getSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return updateSettingsCallable;
  }

  @Override
  public UnaryCallable<GetIdentityRequest, Identity> getIdentityCallable() {
    return getIdentityCallable;
  }

  @Override
  public UnaryCallable<GetIrnProfileRequest, IrnProfile> getIrnProfileCallable() {
    return getIrnProfileCallable;
  }

  @Override
  public UnaryCallable<GetPairedDeviceRequest, PairedDevice> getPairedDeviceCallable() {
    return getPairedDeviceCallable;
  }

  @Override
  public UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesResponse>
      listPairedDevicesCallable() {
    return listPairedDevicesCallable;
  }

  @Override
  public UnaryCallable<ListPairedDevicesRequest, ListPairedDevicesPagedResponse>
      listPairedDevicesPagedCallable() {
    return listPairedDevicesPagedCallable;
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
