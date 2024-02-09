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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.ServingConfigServiceClient.ListServingConfigsPagedResponse;

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
import com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest;
import com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest;
import com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse;
import com.google.cloud.discoveryengine.v1beta.ServingConfig;
import com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest;
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
 * REST stub implementation for the ServingConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonServingConfigServiceStub extends ServingConfigServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<UpdateServingConfigRequest, ServingConfig>
      updateServingConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateServingConfigRequest, ServingConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ServingConfigService/UpdateServingConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateServingConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{servingConfig.name=projects/*/locations/*/dataStores/*/servingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "servingConfig.name", request.getServingConfig().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{servingConfig.name=projects/*/locations/*/collections/*/dataStores/*/servingConfigs/*}",
                          "/v1beta/{servingConfig.name=projects/*/locations/*/collections/*/engines/*/servingConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("servingConfig", request.getServingConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ServingConfig>newBuilder()
                      .setDefaultInstance(ServingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetServingConfigRequest, ServingConfig>
      getServingConfigMethodDescriptor =
          ApiMethodDescriptor.<GetServingConfigRequest, ServingConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ServingConfigService/GetServingConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServingConfigRequest>newBuilder()
                      .setPath(
                          "/v1beta/{name=projects/*/locations/*/dataStores/*/servingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{name=projects/*/locations/*/collections/*/dataStores/*/servingConfigs/*}",
                          "/v1beta/{name=projects/*/locations/*/collections/*/engines/*/servingConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ServingConfig>newBuilder()
                      .setDefaultInstance(ServingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListServingConfigsRequest, ListServingConfigsResponse>
      listServingConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListServingConfigsRequest, ListServingConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1beta.ServingConfigService/ListServingConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServingConfigsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/dataStores/*}/servingConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServingConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{parent=projects/*/locations/*/collections/*/dataStores/*}/servingConfigs",
                          "/v1beta/{parent=projects/*/locations/*/collections/*/engines/*}/servingConfigs")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListServingConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListServingConfigsResponse>newBuilder()
                      .setDefaultInstance(ListServingConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<UpdateServingConfigRequest, ServingConfig>
      updateServingConfigCallable;
  private final UnaryCallable<GetServingConfigRequest, ServingConfig> getServingConfigCallable;
  private final UnaryCallable<ListServingConfigsRequest, ListServingConfigsResponse>
      listServingConfigsCallable;
  private final UnaryCallable<ListServingConfigsRequest, ListServingConfigsPagedResponse>
      listServingConfigsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonServingConfigServiceStub create(
      ServingConfigServiceStubSettings settings) throws IOException {
    return new HttpJsonServingConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonServingConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonServingConfigServiceStub(
        ServingConfigServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonServingConfigServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonServingConfigServiceStub(
        ServingConfigServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonServingConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServingConfigServiceStub(
      ServingConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonServingConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonServingConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonServingConfigServiceStub(
      ServingConfigServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<UpdateServingConfigRequest, ServingConfig>
        updateServingConfigTransportSettings =
            HttpJsonCallSettings.<UpdateServingConfigRequest, ServingConfig>newBuilder()
                .setMethodDescriptor(updateServingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "serving_config.name",
                          String.valueOf(request.getServingConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetServingConfigRequest, ServingConfig> getServingConfigTransportSettings =
        HttpJsonCallSettings.<GetServingConfigRequest, ServingConfig>newBuilder()
            .setMethodDescriptor(getServingConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListServingConfigsRequest, ListServingConfigsResponse>
        listServingConfigsTransportSettings =
            HttpJsonCallSettings.<ListServingConfigsRequest, ListServingConfigsResponse>newBuilder()
                .setMethodDescriptor(listServingConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.updateServingConfigCallable =
        callableFactory.createUnaryCallable(
            updateServingConfigTransportSettings,
            settings.updateServingConfigSettings(),
            clientContext);
    this.getServingConfigCallable =
        callableFactory.createUnaryCallable(
            getServingConfigTransportSettings, settings.getServingConfigSettings(), clientContext);
    this.listServingConfigsCallable =
        callableFactory.createUnaryCallable(
            listServingConfigsTransportSettings,
            settings.listServingConfigsSettings(),
            clientContext);
    this.listServingConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listServingConfigsTransportSettings,
            settings.listServingConfigsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(updateServingConfigMethodDescriptor);
    methodDescriptors.add(getServingConfigMethodDescriptor);
    methodDescriptors.add(listServingConfigsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<UpdateServingConfigRequest, ServingConfig> updateServingConfigCallable() {
    return updateServingConfigCallable;
  }

  @Override
  public UnaryCallable<GetServingConfigRequest, ServingConfig> getServingConfigCallable() {
    return getServingConfigCallable;
  }

  @Override
  public UnaryCallable<ListServingConfigsRequest, ListServingConfigsResponse>
      listServingConfigsCallable() {
    return listServingConfigsCallable;
  }

  @Override
  public UnaryCallable<ListServingConfigsRequest, ListServingConfigsPagedResponse>
      listServingConfigsPagedCallable() {
    return listServingConfigsPagedCallable;
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
