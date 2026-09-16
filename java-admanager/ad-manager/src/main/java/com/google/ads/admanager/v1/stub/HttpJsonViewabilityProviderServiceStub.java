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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.ViewabilityProviderServiceClient.ListViewabilityProvidersPagedResponse;

import com.google.ads.admanager.v1.BatchCreateViewabilityProvidersRequest;
import com.google.ads.admanager.v1.BatchCreateViewabilityProvidersResponse;
import com.google.ads.admanager.v1.BatchUpdateViewabilityProvidersRequest;
import com.google.ads.admanager.v1.BatchUpdateViewabilityProvidersResponse;
import com.google.ads.admanager.v1.CreateViewabilityProviderRequest;
import com.google.ads.admanager.v1.GetViewabilityProviderRequest;
import com.google.ads.admanager.v1.ListViewabilityProvidersRequest;
import com.google.ads.admanager.v1.ListViewabilityProvidersResponse;
import com.google.ads.admanager.v1.UpdateViewabilityProviderRequest;
import com.google.ads.admanager.v1.ViewabilityProvider;
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
 * REST stub implementation for the ViewabilityProviderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonViewabilityProviderServiceStub extends ViewabilityProviderServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetViewabilityProviderRequest, ViewabilityProvider>
      getViewabilityProviderMethodDescriptor =
          ApiMethodDescriptor.<GetViewabilityProviderRequest, ViewabilityProvider>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ViewabilityProviderService/GetViewabilityProvider")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetViewabilityProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/viewabilityProviders/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetViewabilityProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetViewabilityProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ViewabilityProvider>newBuilder()
                      .setDefaultInstance(ViewabilityProvider.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListViewabilityProvidersRequest, ListViewabilityProvidersResponse>
      listViewabilityProvidersMethodDescriptor =
          ApiMethodDescriptor
              .<ListViewabilityProvidersRequest, ListViewabilityProvidersResponse>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ViewabilityProviderService/ListViewabilityProviders")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListViewabilityProvidersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/viewabilityProviders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListViewabilityProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListViewabilityProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListViewabilityProvidersResponse>newBuilder()
                      .setDefaultInstance(ListViewabilityProvidersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateViewabilityProviderRequest, ViewabilityProvider>
      createViewabilityProviderMethodDescriptor =
          ApiMethodDescriptor.<CreateViewabilityProviderRequest, ViewabilityProvider>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ViewabilityProviderService/CreateViewabilityProvider")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateViewabilityProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/viewabilityProviders",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateViewabilityProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateViewabilityProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "viewabilityProvider",
                                      request.getViewabilityProvider(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ViewabilityProvider>newBuilder()
                      .setDefaultInstance(ViewabilityProvider.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
      batchCreateViewabilityProvidersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ViewabilityProviderService/BatchCreateViewabilityProviders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateViewabilityProvidersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/viewabilityProviders:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateViewabilityProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateViewabilityProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchCreateViewabilityProvidersResponse>newBuilder()
                      .setDefaultInstance(
                          BatchCreateViewabilityProvidersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateViewabilityProviderRequest, ViewabilityProvider>
      updateViewabilityProviderMethodDescriptor =
          ApiMethodDescriptor.<UpdateViewabilityProviderRequest, ViewabilityProvider>newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ViewabilityProviderService/UpdateViewabilityProvider")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateViewabilityProviderRequest>newBuilder()
                      .setPath(
                          "/v1/{viewabilityProvider.name=networks/*/viewabilityProviders/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateViewabilityProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "viewabilityProvider.name",
                                request.getViewabilityProvider().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateViewabilityProviderRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "viewabilityProvider",
                                      request.getViewabilityProvider(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ViewabilityProvider>newBuilder()
                      .setDefaultInstance(ViewabilityProvider.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
      batchUpdateViewabilityProvidersMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.ads.admanager.v1.ViewabilityProviderService/BatchUpdateViewabilityProviders")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateViewabilityProvidersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/viewabilityProviders:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateViewabilityProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateViewabilityProvidersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchUpdateViewabilityProvidersResponse>newBuilder()
                      .setDefaultInstance(
                          BatchUpdateViewabilityProvidersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetViewabilityProviderRequest, ViewabilityProvider>
      getViewabilityProviderCallable;
  private final UnaryCallable<ListViewabilityProvidersRequest, ListViewabilityProvidersResponse>
      listViewabilityProvidersCallable;
  private final UnaryCallable<
          ListViewabilityProvidersRequest, ListViewabilityProvidersPagedResponse>
      listViewabilityProvidersPagedCallable;
  private final UnaryCallable<CreateViewabilityProviderRequest, ViewabilityProvider>
      createViewabilityProviderCallable;
  private final UnaryCallable<
          BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
      batchCreateViewabilityProvidersCallable;
  private final UnaryCallable<UpdateViewabilityProviderRequest, ViewabilityProvider>
      updateViewabilityProviderCallable;
  private final UnaryCallable<
          BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
      batchUpdateViewabilityProvidersCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonViewabilityProviderServiceStub create(
      ViewabilityProviderServiceStubSettings settings) throws IOException {
    return new HttpJsonViewabilityProviderServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonViewabilityProviderServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonViewabilityProviderServiceStub(
        ViewabilityProviderServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonViewabilityProviderServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonViewabilityProviderServiceStub(
        ViewabilityProviderServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonViewabilityProviderServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonViewabilityProviderServiceStub(
      ViewabilityProviderServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonViewabilityProviderServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonViewabilityProviderServiceStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonViewabilityProviderServiceStub(
      ViewabilityProviderServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetViewabilityProviderRequest, ViewabilityProvider>
        getViewabilityProviderTransportSettings =
            HttpJsonCallSettings.<GetViewabilityProviderRequest, ViewabilityProvider>newBuilder()
                .setMethodDescriptor(getViewabilityProviderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();
    HttpJsonCallSettings<ListViewabilityProvidersRequest, ListViewabilityProvidersResponse>
        listViewabilityProvidersTransportSettings =
            HttpJsonCallSettings
                .<ListViewabilityProvidersRequest, ListViewabilityProvidersResponse>newBuilder()
                .setMethodDescriptor(listViewabilityProvidersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateViewabilityProviderRequest, ViewabilityProvider>
        createViewabilityProviderTransportSettings =
            HttpJsonCallSettings.<CreateViewabilityProviderRequest, ViewabilityProvider>newBuilder()
                .setMethodDescriptor(createViewabilityProviderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<
            BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
        batchCreateViewabilityProvidersTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateViewabilityProvidersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateViewabilityProviderRequest, ViewabilityProvider>
        updateViewabilityProviderTransportSettings =
            HttpJsonCallSettings.<UpdateViewabilityProviderRequest, ViewabilityProvider>newBuilder()
                .setMethodDescriptor(updateViewabilityProviderMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "viewability_provider.name",
                          String.valueOf(request.getViewabilityProvider().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
        batchUpdateViewabilityProvidersTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateViewabilityProvidersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getViewabilityProviderCallable =
        callableFactory.createUnaryCallable(
            getViewabilityProviderTransportSettings,
            settings.getViewabilityProviderSettings(),
            clientContext);
    this.listViewabilityProvidersCallable =
        callableFactory.createUnaryCallable(
            listViewabilityProvidersTransportSettings,
            settings.listViewabilityProvidersSettings(),
            clientContext);
    this.listViewabilityProvidersPagedCallable =
        callableFactory.createPagedCallable(
            listViewabilityProvidersTransportSettings,
            settings.listViewabilityProvidersSettings(),
            clientContext);
    this.createViewabilityProviderCallable =
        callableFactory.createUnaryCallable(
            createViewabilityProviderTransportSettings,
            settings.createViewabilityProviderSettings(),
            clientContext);
    this.batchCreateViewabilityProvidersCallable =
        callableFactory.createUnaryCallable(
            batchCreateViewabilityProvidersTransportSettings,
            settings.batchCreateViewabilityProvidersSettings(),
            clientContext);
    this.updateViewabilityProviderCallable =
        callableFactory.createUnaryCallable(
            updateViewabilityProviderTransportSettings,
            settings.updateViewabilityProviderSettings(),
            clientContext);
    this.batchUpdateViewabilityProvidersCallable =
        callableFactory.createUnaryCallable(
            batchUpdateViewabilityProvidersTransportSettings,
            settings.batchUpdateViewabilityProvidersSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getViewabilityProviderMethodDescriptor);
    methodDescriptors.add(listViewabilityProvidersMethodDescriptor);
    methodDescriptors.add(createViewabilityProviderMethodDescriptor);
    methodDescriptors.add(batchCreateViewabilityProvidersMethodDescriptor);
    methodDescriptors.add(updateViewabilityProviderMethodDescriptor);
    methodDescriptors.add(batchUpdateViewabilityProvidersMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetViewabilityProviderRequest, ViewabilityProvider>
      getViewabilityProviderCallable() {
    return getViewabilityProviderCallable;
  }

  @Override
  public UnaryCallable<ListViewabilityProvidersRequest, ListViewabilityProvidersResponse>
      listViewabilityProvidersCallable() {
    return listViewabilityProvidersCallable;
  }

  @Override
  public UnaryCallable<ListViewabilityProvidersRequest, ListViewabilityProvidersPagedResponse>
      listViewabilityProvidersPagedCallable() {
    return listViewabilityProvidersPagedCallable;
  }

  @Override
  public UnaryCallable<CreateViewabilityProviderRequest, ViewabilityProvider>
      createViewabilityProviderCallable() {
    return createViewabilityProviderCallable;
  }

  @Override
  public UnaryCallable<
          BatchCreateViewabilityProvidersRequest, BatchCreateViewabilityProvidersResponse>
      batchCreateViewabilityProvidersCallable() {
    return batchCreateViewabilityProvidersCallable;
  }

  @Override
  public UnaryCallable<UpdateViewabilityProviderRequest, ViewabilityProvider>
      updateViewabilityProviderCallable() {
    return updateViewabilityProviderCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateViewabilityProvidersRequest, BatchUpdateViewabilityProvidersResponse>
      batchUpdateViewabilityProvidersCallable() {
    return batchUpdateViewabilityProvidersCallable;
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
