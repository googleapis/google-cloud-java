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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import com.google.shopping.merchant.notifications.v1beta.CreateNotificationSubscriptionRequest;
import com.google.shopping.merchant.notifications.v1beta.DeleteNotificationSubscriptionRequest;
import com.google.shopping.merchant.notifications.v1beta.GetNotificationSubscriptionRequest;
import com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsRequest;
import com.google.shopping.merchant.notifications.v1beta.ListNotificationSubscriptionsResponse;
import com.google.shopping.merchant.notifications.v1beta.NotificationSubscription;
import com.google.shopping.merchant.notifications.v1beta.UpdateNotificationSubscriptionRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the NotificationsApiService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonNotificationsApiServiceStub extends NotificationsApiServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GetNotificationSubscriptionRequest, NotificationSubscription>
      getNotificationSubscriptionMethodDescriptor =
          ApiMethodDescriptor
              .<GetNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/GetNotificationSubscription")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNotificationSubscriptionRequest>newBuilder()
                      .setPath(
                          "/notifications/v1beta/{name=accounts/*/notificationsubscriptions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNotificationSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNotificationSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NotificationSubscription>newBuilder()
                      .setDefaultInstance(NotificationSubscription.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateNotificationSubscriptionRequest, NotificationSubscription>
      createNotificationSubscriptionMethodDescriptor =
          ApiMethodDescriptor
              .<CreateNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/CreateNotificationSubscription")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateNotificationSubscriptionRequest>newBuilder()
                      .setPath(
                          "/notifications/v1beta/{parent=accounts/*}/notificationsubscriptions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNotificationSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateNotificationSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "notificationSubscription",
                                      request.getNotificationSubscription(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NotificationSubscription>newBuilder()
                      .setDefaultInstance(NotificationSubscription.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateNotificationSubscriptionRequest, NotificationSubscription>
      updateNotificationSubscriptionMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/UpdateNotificationSubscription")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateNotificationSubscriptionRequest>newBuilder()
                      .setPath(
                          "/notifications/v1beta/{notificationSubscription.name=accounts/*/notificationsubscriptions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNotificationSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "notificationSubscription.name",
                                request.getNotificationSubscription().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateNotificationSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "notificationSubscription",
                                      request.getNotificationSubscription(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NotificationSubscription>newBuilder()
                      .setDefaultInstance(NotificationSubscription.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteNotificationSubscriptionRequest, Empty>
      deleteNotificationSubscriptionMethodDescriptor =
          ApiMethodDescriptor.<DeleteNotificationSubscriptionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/DeleteNotificationSubscription")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNotificationSubscriptionRequest>newBuilder()
                      .setPath(
                          "/notifications/v1beta/{name=accounts/*/notificationsubscriptions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNotificationSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNotificationSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
      listNotificationSubscriptionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.shopping.merchant.notifications.v1beta.NotificationsApiService/ListNotificationSubscriptions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNotificationSubscriptionsRequest>newBuilder()
                      .setPath(
                          "/notifications/v1beta/{parent=accounts/*}/notificationsubscriptions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNotificationSubscriptionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNotificationSubscriptionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNotificationSubscriptionsResponse>newBuilder()
                      .setDefaultInstance(
                          ListNotificationSubscriptionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNotificationsApiServiceStub create(
      NotificationsApiServiceStubSettings settings) throws IOException {
    return new HttpJsonNotificationsApiServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNotificationsApiServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNotificationsApiServiceStub(
        NotificationsApiServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonNotificationsApiServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNotificationsApiServiceStub(
        NotificationsApiServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNotificationsApiServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNotificationsApiServiceStub(
      NotificationsApiServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNotificationsApiServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNotificationsApiServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNotificationsApiServiceStub(
      NotificationsApiServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetNotificationSubscriptionRequest, NotificationSubscription>
        getNotificationSubscriptionTransportSettings =
            HttpJsonCallSettings
                .<GetNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
                .setMethodDescriptor(getNotificationSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateNotificationSubscriptionRequest, NotificationSubscription>
        createNotificationSubscriptionTransportSettings =
            HttpJsonCallSettings
                .<CreateNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
                .setMethodDescriptor(createNotificationSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateNotificationSubscriptionRequest, NotificationSubscription>
        updateNotificationSubscriptionTransportSettings =
            HttpJsonCallSettings
                .<UpdateNotificationSubscriptionRequest, NotificationSubscription>newBuilder()
                .setMethodDescriptor(updateNotificationSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "notification_subscription.name",
                          String.valueOf(request.getNotificationSubscription().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteNotificationSubscriptionRequest, Empty>
        deleteNotificationSubscriptionTransportSettings =
            HttpJsonCallSettings.<DeleteNotificationSubscriptionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteNotificationSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
        listNotificationSubscriptionsTransportSettings =
            HttpJsonCallSettings
                .<ListNotificationSubscriptionsRequest, ListNotificationSubscriptionsResponse>
                    newBuilder()
                .setMethodDescriptor(listNotificationSubscriptionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getNotificationSubscriptionMethodDescriptor);
    methodDescriptors.add(createNotificationSubscriptionMethodDescriptor);
    methodDescriptors.add(updateNotificationSubscriptionMethodDescriptor);
    methodDescriptors.add(deleteNotificationSubscriptionMethodDescriptor);
    methodDescriptors.add(listNotificationSubscriptionsMethodDescriptor);
    return methodDescriptors;
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
