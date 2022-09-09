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

package com.google.cloud.privatecatalog.v1beta1.stub;

import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchCatalogsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchProductsPagedResponse;
import static com.google.cloud.privatecatalog.v1beta1.PrivateCatalogClient.SearchVersionsPagedResponse;

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
import com.google.cloud.privatecatalog.v1beta1.SearchCatalogsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchCatalogsResponse;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchProductsResponse;
import com.google.cloud.privatecatalog.v1beta1.SearchVersionsRequest;
import com.google.cloud.privatecatalog.v1beta1.SearchVersionsResponse;
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
 * REST stub implementation for the PrivateCatalog service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPrivateCatalogStub extends PrivateCatalogStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SearchCatalogsRequest, SearchCatalogsResponse>
      searchCatalogsMethodDescriptor =
          ApiMethodDescriptor.<SearchCatalogsRequest, SearchCatalogsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.privatecatalog.v1beta1.PrivateCatalog/SearchCatalogs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchCatalogsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*}/catalogs:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=organizations/*}/catalogs:search",
                          "/v1beta1/{resource=folders/*}/catalogs:search")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCatalogsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchCatalogsResponse>newBuilder()
                      .setDefaultInstance(SearchCatalogsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchProductsRequest, SearchProductsResponse>
      searchProductsMethodDescriptor =
          ApiMethodDescriptor.<SearchProductsRequest, SearchProductsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.privatecatalog.v1beta1.PrivateCatalog/SearchProducts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchProductsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*}/products:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=organizations/*}/products:search",
                          "/v1beta1/{resource=folders/*}/products:search")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchProductsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchProductsResponse>newBuilder()
                      .setDefaultInstance(SearchProductsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchVersionsRequest, SearchVersionsResponse>
      searchVersionsMethodDescriptor =
          ApiMethodDescriptor.<SearchVersionsRequest, SearchVersionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.privatecatalog.v1beta1.PrivateCatalog/SearchVersions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchVersionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*}/versions:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=organizations/*}/versions:search",
                          "/v1beta1/{resource=folders/*}/versions:search")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchVersionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchVersionsResponse>newBuilder()
                      .setDefaultInstance(SearchVersionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<SearchCatalogsRequest, SearchCatalogsResponse> searchCatalogsCallable;
  private final UnaryCallable<SearchCatalogsRequest, SearchCatalogsPagedResponse>
      searchCatalogsPagedCallable;
  private final UnaryCallable<SearchProductsRequest, SearchProductsResponse> searchProductsCallable;
  private final UnaryCallable<SearchProductsRequest, SearchProductsPagedResponse>
      searchProductsPagedCallable;
  private final UnaryCallable<SearchVersionsRequest, SearchVersionsResponse> searchVersionsCallable;
  private final UnaryCallable<SearchVersionsRequest, SearchVersionsPagedResponse>
      searchVersionsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPrivateCatalogStub create(PrivateCatalogStubSettings settings)
      throws IOException {
    return new HttpJsonPrivateCatalogStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPrivateCatalogStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPrivateCatalogStub(
        PrivateCatalogStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPrivateCatalogStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPrivateCatalogStub(
        PrivateCatalogStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPrivateCatalogStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPrivateCatalogStub(
      PrivateCatalogStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPrivateCatalogCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPrivateCatalogStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPrivateCatalogStub(
      PrivateCatalogStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SearchCatalogsRequest, SearchCatalogsResponse>
        searchCatalogsTransportSettings =
            HttpJsonCallSettings.<SearchCatalogsRequest, SearchCatalogsResponse>newBuilder()
                .setMethodDescriptor(searchCatalogsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SearchProductsRequest, SearchProductsResponse>
        searchProductsTransportSettings =
            HttpJsonCallSettings.<SearchProductsRequest, SearchProductsResponse>newBuilder()
                .setMethodDescriptor(searchProductsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SearchVersionsRequest, SearchVersionsResponse>
        searchVersionsTransportSettings =
            HttpJsonCallSettings.<SearchVersionsRequest, SearchVersionsResponse>newBuilder()
                .setMethodDescriptor(searchVersionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.searchCatalogsCallable =
        callableFactory.createUnaryCallable(
            searchCatalogsTransportSettings, settings.searchCatalogsSettings(), clientContext);
    this.searchCatalogsPagedCallable =
        callableFactory.createPagedCallable(
            searchCatalogsTransportSettings, settings.searchCatalogsSettings(), clientContext);
    this.searchProductsCallable =
        callableFactory.createUnaryCallable(
            searchProductsTransportSettings, settings.searchProductsSettings(), clientContext);
    this.searchProductsPagedCallable =
        callableFactory.createPagedCallable(
            searchProductsTransportSettings, settings.searchProductsSettings(), clientContext);
    this.searchVersionsCallable =
        callableFactory.createUnaryCallable(
            searchVersionsTransportSettings, settings.searchVersionsSettings(), clientContext);
    this.searchVersionsPagedCallable =
        callableFactory.createPagedCallable(
            searchVersionsTransportSettings, settings.searchVersionsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(searchCatalogsMethodDescriptor);
    methodDescriptors.add(searchProductsMethodDescriptor);
    methodDescriptors.add(searchVersionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SearchCatalogsRequest, SearchCatalogsResponse> searchCatalogsCallable() {
    return searchCatalogsCallable;
  }

  @Override
  public UnaryCallable<SearchCatalogsRequest, SearchCatalogsPagedResponse>
      searchCatalogsPagedCallable() {
    return searchCatalogsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchProductsRequest, SearchProductsResponse> searchProductsCallable() {
    return searchProductsCallable;
  }

  @Override
  public UnaryCallable<SearchProductsRequest, SearchProductsPagedResponse>
      searchProductsPagedCallable() {
    return searchProductsPagedCallable;
  }

  @Override
  public UnaryCallable<SearchVersionsRequest, SearchVersionsResponse> searchVersionsCallable() {
    return searchVersionsCallable;
  }

  @Override
  public UnaryCallable<SearchVersionsRequest, SearchVersionsPagedResponse>
      searchVersionsPagedCallable() {
    return searchVersionsPagedCallable;
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
