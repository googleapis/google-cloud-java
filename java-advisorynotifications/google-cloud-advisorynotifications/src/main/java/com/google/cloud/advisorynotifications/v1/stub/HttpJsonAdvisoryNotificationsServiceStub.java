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

package com.google.cloud.advisorynotifications.v1.stub;

import static com.google.cloud.advisorynotifications.v1.AdvisoryNotificationsServiceClient.ListNotificationsPagedResponse;

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
import com.google.cloud.advisorynotifications.v1.GetNotificationRequest;
import com.google.cloud.advisorynotifications.v1.GetSettingsRequest;
import com.google.cloud.advisorynotifications.v1.ListNotificationsRequest;
import com.google.cloud.advisorynotifications.v1.ListNotificationsResponse;
import com.google.cloud.advisorynotifications.v1.Notification;
import com.google.cloud.advisorynotifications.v1.Settings;
import com.google.cloud.advisorynotifications.v1.UpdateSettingsRequest;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the AdvisoryNotificationsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonAdvisoryNotificationsServiceStub extends AdvisoryNotificationsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsMethodDescriptor =
          ApiMethodDescriptor.<ListNotificationsRequest, ListNotificationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.advisorynotifications.v1.AdvisoryNotificationsService/ListNotifications")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNotificationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/notifications",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNotificationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{parent=projects/*/locations/*}/notifications")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNotificationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListNotificationsResponse>newBuilder()
                      .setDefaultInstance(ListNotificationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetNotificationRequest, Notification>
      getNotificationMethodDescriptor =
          ApiMethodDescriptor.<GetNotificationRequest, Notification>newBuilder()
              .setFullMethodName(
                  "google.cloud.advisorynotifications.v1.AdvisoryNotificationsService/GetNotification")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNotificationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/notifications/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNotificationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/notifications/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNotificationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "languageCode", request.getLanguageCode());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Notification>newBuilder()
                      .setDefaultInstance(Notification.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSettingsRequest, Settings>
      getSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
              .setFullMethodName(
                  "google.cloud.advisorynotifications.v1.AdvisoryNotificationsService/GetSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/settings}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Settings>newBuilder()
                      .setDefaultInstance(Settings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSettingsRequest, Settings>
      updateSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateSettingsRequest, Settings>newBuilder()
              .setFullMethodName(
                  "google.cloud.advisorynotifications.v1.AdvisoryNotificationsService/UpdateSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{settings.name=organizations/*/locations/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "settings.name", request.getSettings().getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{settings.name=projects/*/locations/*/settings}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("settings", request.getSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Settings>newBuilder()
                      .setDefaultInstance(Settings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListNotificationsRequest, ListNotificationsResponse>
      listNotificationsCallable;
  private final UnaryCallable<ListNotificationsRequest, ListNotificationsPagedResponse>
      listNotificationsPagedCallable;
  private final UnaryCallable<GetNotificationRequest, Notification> getNotificationCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdvisoryNotificationsServiceStub create(
      AdvisoryNotificationsServiceStubSettings settings) throws IOException {
    return new HttpJsonAdvisoryNotificationsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdvisoryNotificationsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAdvisoryNotificationsServiceStub(
        AdvisoryNotificationsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonAdvisoryNotificationsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdvisoryNotificationsServiceStub(
        AdvisoryNotificationsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdvisoryNotificationsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonAdvisoryNotificationsServiceStub(
      AdvisoryNotificationsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAdvisoryNotificationsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdvisoryNotificationsServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonAdvisoryNotificationsServiceStub(
      AdvisoryNotificationsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListNotificationsRequest, ListNotificationsResponse>
        listNotificationsTransportSettings =
            HttpJsonCallSettings.<ListNotificationsRequest, ListNotificationsResponse>newBuilder()
                .setMethodDescriptor(listNotificationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetNotificationRequest, Notification> getNotificationTransportSettings =
        HttpJsonCallSettings.<GetNotificationRequest, Notification>newBuilder()
            .setMethodDescriptor(getNotificationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        HttpJsonCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        HttpJsonCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listNotificationsMethodDescriptor);
    methodDescriptors.add(getNotificationMethodDescriptor);
    methodDescriptors.add(getSettingsMethodDescriptor);
    methodDescriptors.add(updateSettingsMethodDescriptor);
    return methodDescriptors;
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
