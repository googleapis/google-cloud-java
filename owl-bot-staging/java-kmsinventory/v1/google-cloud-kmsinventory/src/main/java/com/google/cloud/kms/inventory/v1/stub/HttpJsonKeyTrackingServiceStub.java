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

package com.google.cloud.kms.inventory.v1.stub;

import static com.google.cloud.kms.inventory.v1.KeyTrackingServiceClient.SearchProtectedResourcesPagedResponse;

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
import com.google.cloud.kms.inventory.v1.GetProtectedResourcesSummaryRequest;
import com.google.cloud.kms.inventory.v1.ProtectedResourcesSummary;
import com.google.cloud.kms.inventory.v1.SearchProtectedResourcesRequest;
import com.google.cloud.kms.inventory.v1.SearchProtectedResourcesResponse;
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
 * REST stub implementation for the KeyTrackingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonKeyTrackingServiceStub extends KeyTrackingServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
      getProtectedResourcesSummaryMethodDescriptor =
          ApiMethodDescriptor
              .<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>newBuilder()
              .setFullMethodName(
                  "google.cloud.kms.inventory.v1.KeyTrackingService/GetProtectedResourcesSummary")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetProtectedResourcesSummaryRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/keyRings/*/cryptoKeys/**}/protectedResourcesSummary",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetProtectedResourcesSummaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetProtectedResourcesSummaryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProtectedResourcesSummary>newBuilder()
                      .setDefaultInstance(ProtectedResourcesSummary.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
      searchProtectedResourcesMethodDescriptor =
          ApiMethodDescriptor
              .<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.kms.inventory.v1.KeyTrackingService/SearchProtectedResources")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchProtectedResourcesRequest>newBuilder()
                      .setPath(
                          "/v1/{scope=organizations/*}/protectedResources:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchProtectedResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "scope", request.getScope());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchProtectedResourcesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "cryptoKey", request.getCryptoKey());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(
                                fields, "resourceTypes", request.getResourceTypesList());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchProtectedResourcesResponse>newBuilder()
                      .setDefaultInstance(SearchProtectedResourcesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
      getProtectedResourcesSummaryCallable;
  private final UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
      searchProtectedResourcesCallable;
  private final UnaryCallable<
          SearchProtectedResourcesRequest, SearchProtectedResourcesPagedResponse>
      searchProtectedResourcesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonKeyTrackingServiceStub create(KeyTrackingServiceStubSettings settings)
      throws IOException {
    return new HttpJsonKeyTrackingServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonKeyTrackingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonKeyTrackingServiceStub(
        KeyTrackingServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonKeyTrackingServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonKeyTrackingServiceStub(
        KeyTrackingServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonKeyTrackingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonKeyTrackingServiceStub(
      KeyTrackingServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonKeyTrackingServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonKeyTrackingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonKeyTrackingServiceStub(
      KeyTrackingServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
        getProtectedResourcesSummaryTransportSettings =
            HttpJsonCallSettings
                .<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>newBuilder()
                .setMethodDescriptor(getProtectedResourcesSummaryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
        searchProtectedResourcesTransportSettings =
            HttpJsonCallSettings
                .<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>newBuilder()
                .setMethodDescriptor(searchProtectedResourcesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("scope", String.valueOf(request.getScope()));
                      return builder.build();
                    })
                .build();

    this.getProtectedResourcesSummaryCallable =
        callableFactory.createUnaryCallable(
            getProtectedResourcesSummaryTransportSettings,
            settings.getProtectedResourcesSummarySettings(),
            clientContext);
    this.searchProtectedResourcesCallable =
        callableFactory.createUnaryCallable(
            searchProtectedResourcesTransportSettings,
            settings.searchProtectedResourcesSettings(),
            clientContext);
    this.searchProtectedResourcesPagedCallable =
        callableFactory.createPagedCallable(
            searchProtectedResourcesTransportSettings,
            settings.searchProtectedResourcesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getProtectedResourcesSummaryMethodDescriptor);
    methodDescriptors.add(searchProtectedResourcesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetProtectedResourcesSummaryRequest, ProtectedResourcesSummary>
      getProtectedResourcesSummaryCallable() {
    return getProtectedResourcesSummaryCallable;
  }

  @Override
  public UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesResponse>
      searchProtectedResourcesCallable() {
    return searchProtectedResourcesCallable;
  }

  @Override
  public UnaryCallable<SearchProtectedResourcesRequest, SearchProtectedResourcesPagedResponse>
      searchProtectedResourcesPagedCallable() {
    return searchProtectedResourcesPagedCallable;
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
