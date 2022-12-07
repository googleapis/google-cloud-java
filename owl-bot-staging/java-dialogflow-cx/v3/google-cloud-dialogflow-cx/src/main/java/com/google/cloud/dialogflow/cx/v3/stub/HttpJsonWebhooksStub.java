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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.WebhooksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3.WebhooksClient.ListWebhooksPagedResponse;

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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateWebhookRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteWebhookRequest;
import com.google.cloud.dialogflow.cx.v3.GetWebhookRequest;
import com.google.cloud.dialogflow.cx.v3.ListWebhooksRequest;
import com.google.cloud.dialogflow.cx.v3.ListWebhooksResponse;
import com.google.cloud.dialogflow.cx.v3.UpdateWebhookRequest;
import com.google.cloud.dialogflow.cx.v3.Webhook;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the Webhooks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonWebhooksStub extends WebhooksStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListWebhooksRequest, ListWebhooksResponse>
      listWebhooksMethodDescriptor =
          ApiMethodDescriptor.<ListWebhooksRequest, ListWebhooksResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Webhooks/ListWebhooks")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListWebhooksRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*}/webhooks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListWebhooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListWebhooksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListWebhooksResponse>newBuilder()
                      .setDefaultInstance(ListWebhooksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetWebhookRequest, Webhook> getWebhookMethodDescriptor =
      ApiMethodDescriptor.<GetWebhookRequest, Webhook>newBuilder()
          .setFullMethodName("google.cloud.dialogflow.cx.v3.Webhooks/GetWebhook")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetWebhookRequest>newBuilder()
                  .setPath(
                      "/v3/{name=projects/*/locations/*/agents/*/webhooks/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetWebhookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetWebhookRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Webhook>newBuilder()
                  .setDefaultInstance(Webhook.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<CreateWebhookRequest, Webhook>
      createWebhookMethodDescriptor =
          ApiMethodDescriptor.<CreateWebhookRequest, Webhook>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Webhooks/CreateWebhook")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateWebhookRequest>newBuilder()
                      .setPath(
                          "/v3/{parent=projects/*/locations/*/agents/*}/webhooks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWebhookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateWebhookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("webhook", request.getWebhook(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Webhook>newBuilder()
                      .setDefaultInstance(Webhook.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateWebhookRequest, Webhook>
      updateWebhookMethodDescriptor =
          ApiMethodDescriptor.<UpdateWebhookRequest, Webhook>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Webhooks/UpdateWebhook")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateWebhookRequest>newBuilder()
                      .setPath(
                          "/v3/{webhook.name=projects/*/locations/*/agents/*/webhooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWebhookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "webhook.name", request.getWebhook().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateWebhookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("webhook", request.getWebhook(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Webhook>newBuilder()
                      .setDefaultInstance(Webhook.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteWebhookRequest, Empty>
      deleteWebhookMethodDescriptor =
          ApiMethodDescriptor.<DeleteWebhookRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3.Webhooks/DeleteWebhook")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteWebhookRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*/agents/*/webhooks/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWebhookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteWebhookRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v3/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListWebhooksRequest, ListWebhooksResponse> listWebhooksCallable;
  private final UnaryCallable<ListWebhooksRequest, ListWebhooksPagedResponse>
      listWebhooksPagedCallable;
  private final UnaryCallable<GetWebhookRequest, Webhook> getWebhookCallable;
  private final UnaryCallable<CreateWebhookRequest, Webhook> createWebhookCallable;
  private final UnaryCallable<UpdateWebhookRequest, Webhook> updateWebhookCallable;
  private final UnaryCallable<DeleteWebhookRequest, Empty> deleteWebhookCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonWebhooksStub create(WebhooksStubSettings settings)
      throws IOException {
    return new HttpJsonWebhooksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonWebhooksStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonWebhooksStub(
        WebhooksStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonWebhooksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonWebhooksStub(
        WebhooksStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonWebhooksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWebhooksStub(WebhooksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonWebhooksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonWebhooksStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonWebhooksStub(
      WebhooksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListWebhooksRequest, ListWebhooksResponse> listWebhooksTransportSettings =
        HttpJsonCallSettings.<ListWebhooksRequest, ListWebhooksResponse>newBuilder()
            .setMethodDescriptor(listWebhooksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetWebhookRequest, Webhook> getWebhookTransportSettings =
        HttpJsonCallSettings.<GetWebhookRequest, Webhook>newBuilder()
            .setMethodDescriptor(getWebhookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateWebhookRequest, Webhook> createWebhookTransportSettings =
        HttpJsonCallSettings.<CreateWebhookRequest, Webhook>newBuilder()
            .setMethodDescriptor(createWebhookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateWebhookRequest, Webhook> updateWebhookTransportSettings =
        HttpJsonCallSettings.<UpdateWebhookRequest, Webhook>newBuilder()
            .setMethodDescriptor(updateWebhookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteWebhookRequest, Empty> deleteWebhookTransportSettings =
        HttpJsonCallSettings.<DeleteWebhookRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteWebhookMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listWebhooksCallable =
        callableFactory.createUnaryCallable(
            listWebhooksTransportSettings, settings.listWebhooksSettings(), clientContext);
    this.listWebhooksPagedCallable =
        callableFactory.createPagedCallable(
            listWebhooksTransportSettings, settings.listWebhooksSettings(), clientContext);
    this.getWebhookCallable =
        callableFactory.createUnaryCallable(
            getWebhookTransportSettings, settings.getWebhookSettings(), clientContext);
    this.createWebhookCallable =
        callableFactory.createUnaryCallable(
            createWebhookTransportSettings, settings.createWebhookSettings(), clientContext);
    this.updateWebhookCallable =
        callableFactory.createUnaryCallable(
            updateWebhookTransportSettings, settings.updateWebhookSettings(), clientContext);
    this.deleteWebhookCallable =
        callableFactory.createUnaryCallable(
            deleteWebhookTransportSettings, settings.deleteWebhookSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listWebhooksMethodDescriptor);
    methodDescriptors.add(getWebhookMethodDescriptor);
    methodDescriptors.add(createWebhookMethodDescriptor);
    methodDescriptors.add(updateWebhookMethodDescriptor);
    methodDescriptors.add(deleteWebhookMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListWebhooksRequest, ListWebhooksResponse> listWebhooksCallable() {
    return listWebhooksCallable;
  }

  @Override
  public UnaryCallable<ListWebhooksRequest, ListWebhooksPagedResponse> listWebhooksPagedCallable() {
    return listWebhooksPagedCallable;
  }

  @Override
  public UnaryCallable<GetWebhookRequest, Webhook> getWebhookCallable() {
    return getWebhookCallable;
  }

  @Override
  public UnaryCallable<CreateWebhookRequest, Webhook> createWebhookCallable() {
    return createWebhookCallable;
  }

  @Override
  public UnaryCallable<UpdateWebhookRequest, Webhook> updateWebhookCallable() {
    return updateWebhookCallable;
  }

  @Override
  public UnaryCallable<DeleteWebhookRequest, Empty> deleteWebhookCallable() {
    return deleteWebhookCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
