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

package com.google.cloud.vectorsearch.v1beta.stub;

import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.QueryDataObjectsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.SearchDataObjectsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.AggregateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchSearchDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.QueryDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.QueryDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.SearchDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.SearchDataObjectsResponse;
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
 * REST stub implementation for the DataObjectSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonDataObjectSearchServiceStub extends DataObjectSearchServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<SearchDataObjectsRequest, SearchDataObjectsResponse>
      searchDataObjectsMethodDescriptor =
          ApiMethodDescriptor.<SearchDataObjectsRequest, SearchDataObjectsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectSearchService/SearchDataObjects")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchDataObjectsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/dataObjects:search",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchDataObjectsRequest> serializer =
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
                  ProtoMessageResponseParser.<SearchDataObjectsResponse>newBuilder()
                      .setDefaultInstance(SearchDataObjectsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<QueryDataObjectsRequest, QueryDataObjectsResponse>
      queryDataObjectsMethodDescriptor =
          ApiMethodDescriptor.<QueryDataObjectsRequest, QueryDataObjectsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectSearchService/QueryDataObjects")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryDataObjectsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/dataObjects:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryDataObjectsRequest> serializer =
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
                  ProtoMessageResponseParser.<QueryDataObjectsResponse>newBuilder()
                      .setDefaultInstance(QueryDataObjectsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          AggregateDataObjectsRequest, AggregateDataObjectsResponse>
      aggregateDataObjectsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregateDataObjectsRequest, AggregateDataObjectsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectSearchService/AggregateDataObjects")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregateDataObjectsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/dataObjects:aggregate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregateDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregateDataObjectsRequest> serializer =
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
                  ProtoMessageResponseParser.<AggregateDataObjectsResponse>newBuilder()
                      .setDefaultInstance(AggregateDataObjectsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
      batchSearchDataObjectsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.vectorsearch.v1beta.DataObjectSearchService/BatchSearchDataObjects")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchSearchDataObjectsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*/collections/*}/dataObjects:batchSearch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSearchDataObjectsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSearchDataObjectsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchSearchDataObjectsResponse>newBuilder()
                      .setDefaultInstance(BatchSearchDataObjectsResponse.getDefaultInstance())
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
                          "/v1beta/{name=projects/*}/locations",
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
                          "/v1beta/{name=projects/*/locations/*}",
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

  private final UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsResponse>
      searchDataObjectsCallable;
  private final UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsPagedResponse>
      searchDataObjectsPagedCallable;
  private final UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsResponse>
      queryDataObjectsCallable;
  private final UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsPagedResponse>
      queryDataObjectsPagedCallable;
  private final UnaryCallable<AggregateDataObjectsRequest, AggregateDataObjectsResponse>
      aggregateDataObjectsCallable;
  private final UnaryCallable<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
      batchSearchDataObjectsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDataObjectSearchServiceStub create(
      DataObjectSearchServiceStubSettings settings) throws IOException {
    return new HttpJsonDataObjectSearchServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDataObjectSearchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonDataObjectSearchServiceStub(
        DataObjectSearchServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonDataObjectSearchServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDataObjectSearchServiceStub(
        DataObjectSearchServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDataObjectSearchServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataObjectSearchServiceStub(
      DataObjectSearchServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDataObjectSearchServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDataObjectSearchServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonDataObjectSearchServiceStub(
      DataObjectSearchServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<SearchDataObjectsRequest, SearchDataObjectsResponse>
        searchDataObjectsTransportSettings =
            HttpJsonCallSettings.<SearchDataObjectsRequest, SearchDataObjectsResponse>newBuilder()
                .setMethodDescriptor(searchDataObjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<QueryDataObjectsRequest, QueryDataObjectsResponse>
        queryDataObjectsTransportSettings =
            HttpJsonCallSettings.<QueryDataObjectsRequest, QueryDataObjectsResponse>newBuilder()
                .setMethodDescriptor(queryDataObjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AggregateDataObjectsRequest, AggregateDataObjectsResponse>
        aggregateDataObjectsTransportSettings =
            HttpJsonCallSettings
                .<AggregateDataObjectsRequest, AggregateDataObjectsResponse>newBuilder()
                .setMethodDescriptor(aggregateDataObjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
        batchSearchDataObjectsTransportSettings =
            HttpJsonCallSettings
                .<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>newBuilder()
                .setMethodDescriptor(batchSearchDataObjectsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.searchDataObjectsCallable =
        callableFactory.createUnaryCallable(
            searchDataObjectsTransportSettings,
            settings.searchDataObjectsSettings(),
            clientContext);
    this.searchDataObjectsPagedCallable =
        callableFactory.createPagedCallable(
            searchDataObjectsTransportSettings,
            settings.searchDataObjectsSettings(),
            clientContext);
    this.queryDataObjectsCallable =
        callableFactory.createUnaryCallable(
            queryDataObjectsTransportSettings, settings.queryDataObjectsSettings(), clientContext);
    this.queryDataObjectsPagedCallable =
        callableFactory.createPagedCallable(
            queryDataObjectsTransportSettings, settings.queryDataObjectsSettings(), clientContext);
    this.aggregateDataObjectsCallable =
        callableFactory.createUnaryCallable(
            aggregateDataObjectsTransportSettings,
            settings.aggregateDataObjectsSettings(),
            clientContext);
    this.batchSearchDataObjectsCallable =
        callableFactory.createUnaryCallable(
            batchSearchDataObjectsTransportSettings,
            settings.batchSearchDataObjectsSettings(),
            clientContext);
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
    methodDescriptors.add(searchDataObjectsMethodDescriptor);
    methodDescriptors.add(queryDataObjectsMethodDescriptor);
    methodDescriptors.add(aggregateDataObjectsMethodDescriptor);
    methodDescriptors.add(batchSearchDataObjectsMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsResponse>
      searchDataObjectsCallable() {
    return searchDataObjectsCallable;
  }

  @Override
  public UnaryCallable<SearchDataObjectsRequest, SearchDataObjectsPagedResponse>
      searchDataObjectsPagedCallable() {
    return searchDataObjectsPagedCallable;
  }

  @Override
  public UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsResponse>
      queryDataObjectsCallable() {
    return queryDataObjectsCallable;
  }

  @Override
  public UnaryCallable<QueryDataObjectsRequest, QueryDataObjectsPagedResponse>
      queryDataObjectsPagedCallable() {
    return queryDataObjectsPagedCallable;
  }

  @Override
  public UnaryCallable<AggregateDataObjectsRequest, AggregateDataObjectsResponse>
      aggregateDataObjectsCallable() {
    return aggregateDataObjectsCallable;
  }

  @Override
  public UnaryCallable<BatchSearchDataObjectsRequest, BatchSearchDataObjectsResponse>
      batchSearchDataObjectsCallable() {
    return batchSearchDataObjectsCallable;
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
