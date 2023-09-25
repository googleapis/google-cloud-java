/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.advisorynotifications.v1.stub;

import static com.google.cloud.advisorynotifications.v1.AdvisoryNotificationsServiceClient.ListNotificationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.advisorynotifications.v1.GetNotificationRequest;
import com.google.cloud.advisorynotifications.v1.GetSettingsRequest;
import com.google.cloud.advisorynotifications.v1.ListNotificationsRequest;
import com.google.cloud.advisorynotifications.v1.ListNotificationsResponse;
import com.google.cloud.advisorynotifications.v1.Notification;
import com.google.cloud.advisorynotifications.v1.Settings;
import com.google.cloud.advisorynotifications.v1.UpdateSettingsRequest;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AdvisoryNotificationsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcAdvisoryNotificationsServiceStub extends AdvisoryNotificationsServiceStub {
  private static final MethodDescriptor<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsMethodDescriptor =
          MethodDescriptor.<ListNotificationsRequest, ListNotificationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.advisorynotifications.v1.AdvisoryNotificationsService/ListNotifications")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNotificationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNotificationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNotificationRequest, Notification>
      getNotificationMethodDescriptor =
          MethodDescriptor.<GetNotificationRequest, Notification>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.advisorynotifications.v1.AdvisoryNotificationsService/GetNotification")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Notification.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetSettingsRequest, Settings> getSettingsMethodDescriptor =
      MethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.advisorynotifications.v1.AdvisoryNotificationsService/GetSettings")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSettingsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<UpdateSettingsRequest, Settings>
      updateSettingsMethodDescriptor =
          MethodDescriptor.<UpdateSettingsRequest, Settings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.advisorynotifications.v1.AdvisoryNotificationsService/UpdateSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
              .build();

  private final UnaryCallable<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsCallable;
  private final UnaryCallable<ListNotificationsRequest, ListNotificationsPagedResponse>
      listNotificationsPagedCallable;
  private final UnaryCallable<GetNotificationRequest, Notification> getNotificationCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAdvisoryNotificationsServiceStub create(
      AdvisoryNotificationsServiceStubSettings settings) throws IOException {
    return new GrpcAdvisoryNotificationsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAdvisoryNotificationsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcAdvisoryNotificationsServiceStub(
        AdvisoryNotificationsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAdvisoryNotificationsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAdvisoryNotificationsServiceStub(
        AdvisoryNotificationsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcAdvisoryNotificationsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAdvisoryNotificationsServiceStub(
      AdvisoryNotificationsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAdvisoryNotificationsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAdvisoryNotificationsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcAdvisoryNotificationsServiceStub(
      AdvisoryNotificationsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListNotificationsRequest, ListNotificationsResponse>
        listNotificationsTransportSettings =
            GrpcCallSettings.<ListNotificationsRequest, ListNotificationsResponse>newBuilder()
                .setMethodDescriptor(listNotificationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetNotificationRequest, Notification> getNotificationTransportSettings =
        GrpcCallSettings.<GetNotificationRequest, Notification>newBuilder()
            .setMethodDescriptor(getNotificationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
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

    this.listNotificationsCallable =
        callableFactory.createUnaryCallable(
            listNotificationsTransportSettings,
            settings.listNotificationsSettings(),
            clientContext);
    this.listNotificationsPagedCallable =
        callableFactory.createPagedCallable(
            listNotificationsTransportSettings,
            settings.listNotificationsSettings(),
            clientContext);
    this.getNotificationCallable =
        callableFactory.createUnaryCallable(
            getNotificationTransportSettings, settings.getNotificationSettings(), clientContext);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsCallable() {
    return listNotificationsCallable;
  }

  @Override
  public UnaryCallable<ListNotificationsRequest, ListNotificationsPagedResponse>
      listNotificationsPagedCallable() {
    return listNotificationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetNotificationRequest, Notification> getNotificationCallable() {
    return getNotificationCallable;
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
