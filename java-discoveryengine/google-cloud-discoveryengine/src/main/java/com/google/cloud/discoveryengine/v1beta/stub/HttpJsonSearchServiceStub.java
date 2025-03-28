/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.discoveryengine.v1beta.SearchServiceClient.SearchLitePagedResponse;
import static com.google.cloud.discoveryengine.v1beta.SearchServiceClient.SearchPagedResponse;

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
import com.google.cloud.discoveryengine.v1beta.SearchRequest;
import com.google.cloud.discoveryengine.v1beta.SearchResponse;
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
 * REST stub implementation for the SearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSearchServiceStub extends SearchServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SearchRequest, SearchResponse> searchMethodDescriptor =
      ApiMethodDescriptor.<SearchRequest, SearchResponse>newBuilder()
          .setFullMethodName("google.cloud.discoveryengine.v1beta.SearchService/Search")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<SearchRequest>newBuilder()
                  .setPath(
                      "/v1beta/{servingConfig=projects/*/locations/*/dataStores/*/servingConfigs/*}:search",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<SearchRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(
                            fields, "servingConfig", request.getServingConfig());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1beta/{servingConfig=projects/*/locations/*/collections/*/dataStores/*/servingConfigs/*}:search",
                      "/v1beta/{servingConfig=projects/*/locations/*/collections/*/engines/*/servingConfigs/*}:search")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<SearchRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearServingConfig().build(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<SearchResponse>newBuilder()
                  .setDefaultInstance(SearchResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<SearchRequest, SearchResponse>
      searchLiteMethodDescriptor =
          ApiMethodDescriptor.<SearchRequest, SearchResponse>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1beta.SearchService/SearchLite")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchRequest>newBuilder()
                      .setPath(
                          "/v1beta/{servingConfig=projects/*/locations/*/dataStores/*/servingConfigs/*}:searchLite",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "servingConfig", request.getServingConfig());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta/{servingConfig=projects/*/locations/*/collections/*/dataStores/*/servingConfigs/*}:searchLite",
                          "/v1beta/{servingConfig=projects/*/locations/*/collections/*/engines/*/servingConfigs/*}:searchLite")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearServingConfig().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchResponse>newBuilder()
                      .setDefaultInstance(SearchResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SearchRequest, SearchResponse> searchCallable;
  private final UnaryCallable<SearchRequest, SearchPagedResponse> searchPagedCallable;
  private final UnaryCallable<SearchRequest, SearchResponse> searchLiteCallable;
  private final UnaryCallable<SearchRequest, SearchLitePagedResponse> searchLitePagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSearchServiceStub create(SearchServiceStubSettings settings)
      throws IOException {
    return new HttpJsonSearchServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSearchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSearchServiceStub(
        SearchServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSearchServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSearchServiceStub(
        SearchServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSearchServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSearchServiceStub(
      SearchServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSearchServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSearchServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSearchServiceStub(
      SearchServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SearchRequest, SearchResponse> searchTransportSettings =
        HttpJsonCallSettings.<SearchRequest, SearchResponse>newBuilder()
            .setMethodDescriptor(searchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("serving_config", String.valueOf(request.getServingConfig()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchRequest, SearchResponse> searchLiteTransportSettings =
        HttpJsonCallSettings.<SearchRequest, SearchResponse>newBuilder()
            .setMethodDescriptor(searchLiteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("serving_config", String.valueOf(request.getServingConfig()));
                  return builder.build();
                })
            .build();

    this.searchCallable =
        callableFactory.createUnaryCallable(
            searchTransportSettings, settings.searchSettings(), clientContext);
    this.searchPagedCallable =
        callableFactory.createPagedCallable(
            searchTransportSettings, settings.searchSettings(), clientContext);
    this.searchLiteCallable =
        callableFactory.createUnaryCallable(
            searchLiteTransportSettings, settings.searchLiteSettings(), clientContext);
    this.searchLitePagedCallable =
        callableFactory.createPagedCallable(
            searchLiteTransportSettings, settings.searchLiteSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(searchMethodDescriptor);
    methodDescriptors.add(searchLiteMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SearchRequest, SearchResponse> searchCallable() {
    return searchCallable;
  }

  @Override
  public UnaryCallable<SearchRequest, SearchPagedResponse> searchPagedCallable() {
    return searchPagedCallable;
  }

  @Override
  public UnaryCallable<SearchRequest, SearchResponse> searchLiteCallable() {
    return searchLiteCallable;
  }

  @Override
  public UnaryCallable<SearchRequest, SearchLitePagedResponse> searchLitePagedCallable() {
    return searchLitePagedCallable;
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
