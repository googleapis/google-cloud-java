/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.notifications.v1beta.stub;

import static com.google.shopping.merchant.notifications.v1beta.NotificationsApiServiceClient.ListNotificationSubscriptionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest;
import com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest;
import com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest;
import com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest;
import com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsResponse;
import com.google.shopping.merchant.notifications.v1beta.NotificationSubscription;
import com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the NotificationsApiService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcNotificationsApiServiceStub extends NotificationsApiServiceStub {
  private static final MethodDescriptor<
          GetNotificationSubscriptionRequest, NotificationSubscription>
      getNotificationSubscriptionMethodDescriptor =
          MethodDescriptor
              .<GetNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/GetNotificationSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetNotificationSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotificationSubscription.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          CreateNotificationSubscriptionRequest, NotificationSubscription>
      createNotificationSubscriptionMethodDescriptor =
          MethodDescriptor
              .<CreateNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/CreateNotificationSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateNotificationSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotificationSubscription.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          UpdateNotificationSubscriptionRequest, NotificationSubscription>
      updateNotificationSubscriptionMethodDescriptor =
          MethodDescriptor
              .<UpdateNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/UpdateNotificationSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateNotificationSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(NotificationSubscription.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNotificationSubscriptionRequest, Empty>
      deleteNotificationSubscriptionMethodDescriptor =
          MethodDescriptor.<DeleteNotificationSubscriptionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/DeleteNotificationSubscription")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteNotificationSubscriptionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
      listNotificationSubscriptionsMethodDescriptor =
          MethodDescriptor
              .<ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/ListNotificationSubscriptions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNotificationSubscriptionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNotificationSubscriptionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<GetNotificationSubscriptionRequest, NotificationSubscription>
      getNotificationSubscriptionCallable;
  private final UnaryCallable<CreateNotificationSubscriptionRequest, NotificationSubscription>
      createNotificationSubscriptionCallable;
  private final UnaryCallable<UpdateNotificationSubscriptionRequest, NotificationSubscription>
      updateNotificationSubscriptionCallable;
  private final UnaryCallable<DeleteNotificationSubscriptionRequest, Empty>
      deleteNotificationSubscriptionCallable;
  private final UnaryCallable<
          ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
      listNotificationSubscriptionsCallable;
  private final UnaryCallable<
          ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsPagedResponse>
      listNotificationSubscriptionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcNotificationsApiServiceStub create(
      NotificationsApiServiceStubSettings settings) throws IOException {
    return new GrpcNotificationsApiServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcNotificationsApiServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcNotificationsApiServiceStub(
        NotificationsApiServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcNotificationsApiServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcNotificationsApiServiceStub(
        NotificationsApiServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcNotificationsApiServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNotificationsApiServiceStub(
      NotificationsApiServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcNotificationsApiServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcNotificationsApiServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcNotificationsApiServiceStub(
      NotificationsApiServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetNotificationSubscriptionRequest, NotificationSubscription>
        getNotificationSubscriptionTransportSettings =
            GrpcCallSettings
                .<GetNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
                .setMethodDescriptor(getNotificationSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateNotificationSubscriptionRequest, NotificationSubscription>
        createNotificationSubscriptionTransportSettings =
            GrpcCallSettings
                .<CreateNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
                .setMethodDescriptor(createNotificationSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateNotificationSubscriptionRequest, NotificationSubscription>
        updateNotificationSubscriptionTransportSettings =
            GrpcCallSettings
                .<UpdateNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
                .setMethodDescriptor(updateNotificationSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "notification_subscription.name",
                          String.valueOf(request.getNotificationSubscription().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteNotificationSubscriptionRequest, Empty>
        deleteNotificationSubscriptionTransportSettings =
            GrpcCallSettings.<DeleteNotificationSubscriptionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteNotificationSubscriptionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
        listNotificationSubscriptionsTransportSettings =
            GrpcCallSettings
                .<ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
                    newBuilder()
                .setMethodDescriptor(listNotificationSubscriptionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getNotificationSubscriptionCallable =
        callableFactory.createUnaryCallable(
            getNotificationSubscriptionTransportSettings,
            settings.getNotificationSubscriptionSettings(),
            clientContext);
    this.createNotificationSubscriptionCallable =
        callableFactory.createUnaryCallable(
            createNotificationSubscriptionTransportSettings,
            settings.createNotificationSubscriptionSettings(),
            clientContext);
    this.updateNotificationSubscriptionCallable =
        callableFactory.createUnaryCallable(
            updateNotificationSubscriptionTransportSettings,
            settings.updateNotificationSubscriptionSettings(),
            clientContext);
    this.deleteNotificationSubscriptionCallable =
        callableFactory.createUnaryCallable(
            deleteNotificationSubscriptionTransportSettings,
            settings.deleteNotificationSubscriptionSettings(),
            clientContext);
    this.listNotificationSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listNotificationSubscriptionsTransportSettings,
            settings.listNotificationSubscriptionsSettings(),
            clientContext);
    this.listNotificationSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listNotificationSubscriptionsTransportSettings,
            settings.listNotificationSubscriptionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetNotificationSubscriptionRequest, NotificationSubscription>
      getNotificationSubscriptionCallable() {
    return getNotificationSubscriptionCallable;
  }

  @Override
  public UnaryCallable<CreateNotificationSubscriptionRequest, NotificationSubscription>
      createNotificationSubscriptionCallable() {
    return createNotificationSubscriptionCallable;
  }

  @Override
  public UnaryCallable<UpdateNotificationSubscriptionRequest, NotificationSubscription>
      updateNotificationSubscriptionCallable() {
    return updateNotificationSubscriptionCallable;
  }

  @Override
  public UnaryCallable<DeleteNotificationSubscriptionRequest, Empty>
      deleteNotificationSubscriptionCallable() {
    return deleteNotificationSubscriptionCallable;
  }

  @Override
  public UnaryCallable<ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
      listNotificationSubscriptionsCallable() {
    return listNotificationSubscriptionsCallable;
  }

  @Override
  public UnaryCallable<
          ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsPagedResponse>
      listNotificationSubscriptionsPagedCallable() {
    return listNotificationSubscriptionsPagedCallable;
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
