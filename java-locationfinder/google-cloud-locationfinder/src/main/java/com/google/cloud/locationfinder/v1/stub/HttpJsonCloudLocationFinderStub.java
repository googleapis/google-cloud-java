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

package com.google.cloud.locationfinder.v1.stub;

import static com.google.cloud.locationfinder.v1.CloudLocationFinderClient.ListCloudLocationsPagedResponse;
import static com.google.cloud.locationfinder.v1.CloudLocationFinderClient.SearchCloudLocationsPagedResponse;

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
import com.google.cloud.locationfinder.v1.CloudLocation;
import com.google.cloud.locationfinder.v1.GetCloudLocationRequest;
import com.google.cloud.locationfinder.v1.ListCloudLocationsRequest;
import com.google.cloud.locationfinder.v1.ListCloudLocationsResponse;
import com.google.cloud.locationfinder.v1.SearchCloudLocationsRequest;
import com.google.cloud.locationfinder.v1.SearchCloudLocationsResponse;
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
 * REST stub implementation for the CloudLocationFinder service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCloudLocationFinderStub extends CloudLocationFinderStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListCloudLocationsRequest, ListCloudLocationsResponse>
      listCloudLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListCloudLocationsRequest, ListCloudLocationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.locationfinder.v1.CloudLocationFinder/ListCloudLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCloudLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/cloudLocations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCloudLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCloudLocationsResponse>newBuilder()
                      .setDefaultInstance(ListCloudLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetCloudLocationRequest, CloudLocation>
      getCloudLocationMethodDescriptor =
          ApiMethodDescriptor.<GetCloudLocationRequest, CloudLocation>newBuilder()
              .setFullMethodName(
                  "google.cloud.locationfinder.v1.CloudLocationFinder/GetCloudLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCloudLocationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/cloudLocations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCloudLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CloudLocation>newBuilder()
                      .setDefaultInstance(CloudLocation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          SearchCloudLocationsRequest, SearchCloudLocationsResponse>
      searchCloudLocationsMethodDescriptor =
          ApiMethodDescriptor
              .<SearchCloudLocationsRequest, SearchCloudLocationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.locationfinder.v1.CloudLocationFinder/SearchCloudLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchCloudLocationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/cloudLocations:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCloudLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchCloudLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "query", request.getQuery());
                            serializer.putQueryParam(
                                fields, "sourceCloudLocation", request.getSourceCloudLocation());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchCloudLocationsResponse>newBuilder()
                      .setDefaultInstance(SearchCloudLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsResponse>
      listCloudLocationsCallable;
  private final UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsPagedResponse>
      listCloudLocationsPagedCallable;
  private final UnaryCallable<GetCloudLocationRequest, CloudLocation> getCloudLocationCallable;
  private final UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsResponse>
      searchCloudLocationsCallable;
  private final UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsPagedResponse>
      searchCloudLocationsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCloudLocationFinderStub create(
      CloudLocationFinderStubSettings settings) throws IOException {
    return new HttpJsonCloudLocationFinderStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCloudLocationFinderStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCloudLocationFinderStub(
        CloudLocationFinderStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCloudLocationFinderStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCloudLocationFinderStub(
        CloudLocationFinderStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCloudLocationFinderStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudLocationFinderStub(
      CloudLocationFinderStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCloudLocationFinderCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCloudLocationFinderStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCloudLocationFinderStub(
      CloudLocationFinderStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListCloudLocationsRequest, ListCloudLocationsResponse>
        listCloudLocationsTransportSettings =
            HttpJsonCallSettings.<ListCloudLocationsRequest, ListCloudLocationsResponse>newBuilder()
                .setMethodDescriptor(listCloudLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetCloudLocationRequest, CloudLocation> getCloudLocationTransportSettings =
        HttpJsonCallSettings.<GetCloudLocationRequest, CloudLocation>newBuilder()
            .setMethodDescriptor(getCloudLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchCloudLocationsRequest, SearchCloudLocationsResponse>
        searchCloudLocationsTransportSettings =
            HttpJsonCallSettings
                .<SearchCloudLocationsRequest, SearchCloudLocationsResponse>newBuilder()
                .setMethodDescriptor(searchCloudLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.listCloudLocationsCallable =
        callableFactory.createUnaryCallable(
            listCloudLocationsTransportSettings,
            settings.listCloudLocationsSettings(),
            clientContext);
    this.listCloudLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listCloudLocationsTransportSettings,
            settings.listCloudLocationsSettings(),
            clientContext);
    this.getCloudLocationCallable =
        callableFactory.createUnaryCallable(
            getCloudLocationTransportSettings, settings.getCloudLocationSettings(), clientContext);
    this.searchCloudLocationsCallable =
        callableFactory.createUnaryCallable(
            searchCloudLocationsTransportSettings,
            settings.searchCloudLocationsSettings(),
            clientContext);
    this.searchCloudLocationsPagedCallable =
        callableFactory.createPagedCallable(
            searchCloudLocationsTransportSettings,
            settings.searchCloudLocationsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listCloudLocationsMethodDescriptor);
    methodDescriptors.add(getCloudLocationMethodDescriptor);
    methodDescriptors.add(searchCloudLocationsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsResponse>
      listCloudLocationsCallable() {
    return listCloudLocationsCallable;
  }

  @Override
  public UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsPagedResponse>
      listCloudLocationsPagedCallable() {
    return listCloudLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetCloudLocationRequest, CloudLocation> getCloudLocationCallable() {
    return getCloudLocationCallable;
  }

  @Override
  public UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsResponse>
      searchCloudLocationsCallable() {
    return searchCloudLocationsCallable;
  }

  @Override
  public UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsPagedResponse>
      searchCloudLocationsPagedCallable() {
    return searchCloudLocationsPagedCallable;
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
