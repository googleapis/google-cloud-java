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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.FeaturedContentNativeDashboardServiceClient.ListFeaturedContentNativeDashboardsPagedResponse;

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
import com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard;
import com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest;
import com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest;
import com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse;
import com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest;
import com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse;
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
 * REST stub implementation for the FeaturedContentNativeDashboardService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonFeaturedContentNativeDashboardServiceStub
    extends FeaturedContentNativeDashboardServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
      getFeaturedContentNativeDashboardMethodDescriptor =
          ApiMethodDescriptor
              .<GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FeaturedContentNativeDashboardService/GetFeaturedContentNativeDashboard")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetFeaturedContentNativeDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/contentHub/featuredContentNativeDashboards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFeaturedContentNativeDashboardRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFeaturedContentNativeDashboardRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FeaturedContentNativeDashboard>newBuilder()
                      .setDefaultInstance(FeaturedContentNativeDashboard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListFeaturedContentNativeDashboardsRequest, ListFeaturedContentNativeDashboardsResponse>
      listFeaturedContentNativeDashboardsMethodDescriptor =
          ApiMethodDescriptor
              .<ListFeaturedContentNativeDashboardsRequest,
                  ListFeaturedContentNativeDashboardsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FeaturedContentNativeDashboardService/ListFeaturedContentNativeDashboards")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListFeaturedContentNativeDashboardsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/contentHub}/featuredContentNativeDashboards",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeaturedContentNativeDashboardsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeaturedContentNativeDashboardsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListFeaturedContentNativeDashboardsResponse>newBuilder()
                      .setDefaultInstance(
                          ListFeaturedContentNativeDashboardsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          InstallFeaturedContentNativeDashboardRequest,
          InstallFeaturedContentNativeDashboardResponse>
      installFeaturedContentNativeDashboardMethodDescriptor =
          ApiMethodDescriptor
              .<InstallFeaturedContentNativeDashboardRequest,
                  InstallFeaturedContentNativeDashboardResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.chronicle.v1.FeaturedContentNativeDashboardService/InstallFeaturedContentNativeDashboard")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<InstallFeaturedContentNativeDashboardRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/contentHub/featuredContentNativeDashboards/*}:install",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InstallFeaturedContentNativeDashboardRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InstallFeaturedContentNativeDashboardRequest>
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
                  ProtoMessageResponseParser
                      .<InstallFeaturedContentNativeDashboardResponse>newBuilder()
                      .setDefaultInstance(
                          InstallFeaturedContentNativeDashboardResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<
          GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
      getFeaturedContentNativeDashboardCallable;
  private final UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest, ListFeaturedContentNativeDashboardsResponse>
      listFeaturedContentNativeDashboardsCallable;
  private final UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsPagedResponse>
      listFeaturedContentNativeDashboardsPagedCallable;
  private final UnaryCallable<
          InstallFeaturedContentNativeDashboardRequest,
          InstallFeaturedContentNativeDashboardResponse>
      installFeaturedContentNativeDashboardCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFeaturedContentNativeDashboardServiceStub create(
      FeaturedContentNativeDashboardServiceStubSettings settings) throws IOException {
    return new HttpJsonFeaturedContentNativeDashboardServiceStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonFeaturedContentNativeDashboardServiceStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonFeaturedContentNativeDashboardServiceStub(
        FeaturedContentNativeDashboardServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext);
  }

  public static final HttpJsonFeaturedContentNativeDashboardServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFeaturedContentNativeDashboardServiceStub(
        FeaturedContentNativeDashboardServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFeaturedContentNativeDashboardServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonFeaturedContentNativeDashboardServiceStub(
      FeaturedContentNativeDashboardServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(
        settings,
        clientContext,
        new HttpJsonFeaturedContentNativeDashboardServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFeaturedContentNativeDashboardServiceStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonFeaturedContentNativeDashboardServiceStub(
      FeaturedContentNativeDashboardServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
        getFeaturedContentNativeDashboardTransportSettings =
            HttpJsonCallSettings
                .<GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
                    newBuilder()
                .setMethodDescriptor(getFeaturedContentNativeDashboardMethodDescriptor)
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
            ListFeaturedContentNativeDashboardsRequest, ListFeaturedContentNativeDashboardsResponse>
        listFeaturedContentNativeDashboardsTransportSettings =
            HttpJsonCallSettings
                .<ListFeaturedContentNativeDashboardsRequest,
                    ListFeaturedContentNativeDashboardsResponse>
                    newBuilder()
                .setMethodDescriptor(listFeaturedContentNativeDashboardsMethodDescriptor)
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
            InstallFeaturedContentNativeDashboardRequest,
            InstallFeaturedContentNativeDashboardResponse>
        installFeaturedContentNativeDashboardTransportSettings =
            HttpJsonCallSettings
                .<InstallFeaturedContentNativeDashboardRequest,
                    InstallFeaturedContentNativeDashboardResponse>
                    newBuilder()
                .setMethodDescriptor(installFeaturedContentNativeDashboardMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getName())
                .build();

    this.getFeaturedContentNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            getFeaturedContentNativeDashboardTransportSettings,
            settings.getFeaturedContentNativeDashboardSettings(),
            clientContext);
    this.listFeaturedContentNativeDashboardsCallable =
        callableFactory.createUnaryCallable(
            listFeaturedContentNativeDashboardsTransportSettings,
            settings.listFeaturedContentNativeDashboardsSettings(),
            clientContext);
    this.listFeaturedContentNativeDashboardsPagedCallable =
        callableFactory.createPagedCallable(
            listFeaturedContentNativeDashboardsTransportSettings,
            settings.listFeaturedContentNativeDashboardsSettings(),
            clientContext);
    this.installFeaturedContentNativeDashboardCallable =
        callableFactory.createUnaryCallable(
            installFeaturedContentNativeDashboardTransportSettings,
            settings.installFeaturedContentNativeDashboardSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getFeaturedContentNativeDashboardMethodDescriptor);
    methodDescriptors.add(listFeaturedContentNativeDashboardsMethodDescriptor);
    methodDescriptors.add(installFeaturedContentNativeDashboardMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
      getFeaturedContentNativeDashboardCallable() {
    return getFeaturedContentNativeDashboardCallable;
  }

  @Override
  public UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest, ListFeaturedContentNativeDashboardsResponse>
      listFeaturedContentNativeDashboardsCallable() {
    return listFeaturedContentNativeDashboardsCallable;
  }

  @Override
  public UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsPagedResponse>
      listFeaturedContentNativeDashboardsPagedCallable() {
    return listFeaturedContentNativeDashboardsPagedCallable;
  }

  @Override
  public UnaryCallable<
          InstallFeaturedContentNativeDashboardRequest,
          InstallFeaturedContentNativeDashboardResponse>
      installFeaturedContentNativeDashboardCallable() {
    return installFeaturedContentNativeDashboardCallable;
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
