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

package com.google.cloud.support.v2beta.stub;

import static com.google.cloud.support.v2beta.SupportEventSubscriptionServiceClient.ListSupportEventSubscriptionsPagedResponse;

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
import com.google.cloud.support.v2beta.CreateSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.DeleteSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.GetSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.ListSupportEventSubscriptionsRequest;
import com.google.cloud.support.v2beta.ListSupportEventSubscriptionsResponse;
import com.google.cloud.support.v2beta.SupportEventSubscription;
import com.google.cloud.support.v2beta.UndeleteSupportEventSubscriptionRequest;
import com.google.cloud.support.v2beta.UpdateSupportEventSubscriptionRequest;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the SupportEventSubscriptionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSupportEventSubscriptionServiceStub
    extends SupportEventSubscriptionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionMethodDescriptor =
          ApiMethodDescriptor
              .<CreateSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setFullMethodName(
                  "google.cloud.support.v2beta.SupportEventSubscriptionService/CreateSupportEventSubscription")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSupportEventSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=*/*}/supportEventSubscriptions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSupportEventSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSupportEventSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "supportEventSubscription",
                                      request.getSupportEventSubscription(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SupportEventSubscription>newBuilder()
                      .setDefaultInstance(SupportEventSubscription.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionMethodDescriptor =
          ApiMethodDescriptor
              .<GetSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setFullMethodName(
                  "google.cloud.support.v2beta.SupportEventSubscriptionService/GetSupportEventSubscription")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSupportEventSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=*/*/supportEventSubscriptions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSupportEventSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSupportEventSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SupportEventSubscription>newBuilder()
                      .setDefaultInstance(SupportEventSubscription.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
      listSupportEventSubscriptionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.support.v2beta.SupportEventSubscriptionService/ListSupportEventSubscriptions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSupportEventSubscriptionsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=*/*}/supportEventSubscriptions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSupportEventSubscriptionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSupportEventSubscriptionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "showDeleted", request.getShowDeleted());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSupportEventSubscriptionsResponse>newBuilder()
                      .setDefaultInstance(
                          ListSupportEventSubscriptionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setFullMethodName(
                  "google.cloud.support.v2beta.SupportEventSubscriptionService/UpdateSupportEventSubscription")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSupportEventSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{supportEventSubscription.name=*/*/supportEventSubscriptions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSupportEventSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "supportEventSubscription.name",
                                request.getSupportEventSubscription().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSupportEventSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "supportEventSubscription",
                                      request.getSupportEventSubscription(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SupportEventSubscription>newBuilder()
                      .setDefaultInstance(SupportEventSubscription.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setFullMethodName(
                  "google.cloud.support.v2beta.SupportEventSubscriptionService/DeleteSupportEventSubscription")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSupportEventSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=*/*/supportEventSubscriptions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSupportEventSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSupportEventSubscriptionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SupportEventSubscription>newBuilder()
                      .setDefaultInstance(SupportEventSubscription.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionMethodDescriptor =
          ApiMethodDescriptor
              .<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
              .setFullMethodName(
                  "google.cloud.support.v2beta.SupportEventSubscriptionService/UndeleteSupportEventSubscription")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeleteSupportEventSubscriptionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=*/*/supportEventSubscriptions/*}:undelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteSupportEventSubscriptionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeleteSupportEventSubscriptionRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SupportEventSubscription>newBuilder()
                      .setDefaultInstance(SupportEventSubscription.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionCallable;
  private final UnaryCallable<GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionCallable;
  private final UnaryCallable<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
      listSupportEventSubscriptionsCallable;
  private final UnaryCallable<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsPagedResponse>
      listSupportEventSubscriptionsPagedCallable;
  private final UnaryCallable<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionCallable;
  private final UnaryCallable<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionCallable;
  private final UnaryCallable<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSupportEventSubscriptionServiceStub create(
      SupportEventSubscriptionServiceStubSettings settings) throws IOException {
    return new HttpJsonSupportEventSubscriptionServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonSupportEventSubscriptionServiceStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonSupportEventSubscriptionServiceStub(
        SupportEventSubscriptionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSupportEventSubscriptionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSupportEventSubscriptionServiceStub(
        SupportEventSubscriptionServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSupportEventSubscriptionServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonSupportEventSubscriptionServiceStub(
      SupportEventSubscriptionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSupportEventSubscriptionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSupportEventSubscriptionServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonSupportEventSubscriptionServiceStub(
      SupportEventSubscriptionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
        createSupportEventSubscriptionTransportSettings =
            HttpJsonCallSettings
                .<CreateSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(createSupportEventSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<GetSupportEventSubscriptionRequest, SupportEventSubscription>
        getSupportEventSubscriptionTransportSettings =
            HttpJsonCallSettings
                .<GetSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(getSupportEventSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<
            ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
        listSupportEventSubscriptionsTransportSettings =
            HttpJsonCallSettings
                .<ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
                    newBuilder()
                .setMethodDescriptor(listSupportEventSubscriptionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
        updateSupportEventSubscriptionTransportSettings =
            HttpJsonCallSettings
                .<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(updateSupportEventSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "support_event_subscription.name",
                          String.valueOf(request.getSupportEventSubscription().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        deleteSupportEventSubscriptionTransportSettings =
            HttpJsonCallSettings
                .<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(deleteSupportEventSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
        undeleteSupportEventSubscriptionTransportSettings =
            HttpJsonCallSettings
                .<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>newBuilder()
                .setMethodDescriptor(undeleteSupportEventSubscriptionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.createSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            createSupportEventSubscriptionTransportSettings,
            settings.createSupportEventSubscriptionSettings(),
            clientContext);
    this.getSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            getSupportEventSubscriptionTransportSettings,
            settings.getSupportEventSubscriptionSettings(),
            clientContext);
    this.listSupportEventSubscriptionsCallable =
        callableFactory.createUnaryCallable(
            listSupportEventSubscriptionsTransportSettings,
            settings.listSupportEventSubscriptionsSettings(),
            clientContext);
    this.listSupportEventSubscriptionsPagedCallable =
        callableFactory.createPagedCallable(
            listSupportEventSubscriptionsTransportSettings,
            settings.listSupportEventSubscriptionsSettings(),
            clientContext);
    this.updateSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            updateSupportEventSubscriptionTransportSettings,
            settings.updateSupportEventSubscriptionSettings(),
            clientContext);
    this.deleteSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            deleteSupportEventSubscriptionTransportSettings,
            settings.deleteSupportEventSubscriptionSettings(),
            clientContext);
    this.undeleteSupportEventSubscriptionCallable =
        callableFactory.createUnaryCallable(
            undeleteSupportEventSubscriptionTransportSettings,
            settings.undeleteSupportEventSubscriptionSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createSupportEventSubscriptionMethodDescriptor);
    methodDescriptors.add(getSupportEventSubscriptionMethodDescriptor);
    methodDescriptors.add(listSupportEventSubscriptionsMethodDescriptor);
    methodDescriptors.add(updateSupportEventSubscriptionMethodDescriptor);
    methodDescriptors.add(deleteSupportEventSubscriptionMethodDescriptor);
    methodDescriptors.add(undeleteSupportEventSubscriptionMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateSupportEventSubscriptionRequest, SupportEventSubscription>
      createSupportEventSubscriptionCallable() {
    return createSupportEventSubscriptionCallable;
  }

  @Override
  public UnaryCallable<GetSupportEventSubscriptionRequest, SupportEventSubscription>
      getSupportEventSubscriptionCallable() {
    return getSupportEventSubscriptionCallable;
  }

  @Override
  public UnaryCallable<ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsResponse>
      listSupportEventSubscriptionsCallable() {
    return listSupportEventSubscriptionsCallable;
  }

  @Override
  public UnaryCallable<
          ListSupportEventSubscriptionsRequest, ListSupportEventSubscriptionsPagedResponse>
      listSupportEventSubscriptionsPagedCallable() {
    return listSupportEventSubscriptionsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateSupportEventSubscriptionRequest, SupportEventSubscription>
      updateSupportEventSubscriptionCallable() {
    return updateSupportEventSubscriptionCallable;
  }

  @Override
  public UnaryCallable<DeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      deleteSupportEventSubscriptionCallable() {
    return deleteSupportEventSubscriptionCallable;
  }

  @Override
  public UnaryCallable<UndeleteSupportEventSubscriptionRequest, SupportEventSubscription>
      undeleteSupportEventSubscriptionCallable() {
    return undeleteSupportEventSubscriptionCallable;
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
