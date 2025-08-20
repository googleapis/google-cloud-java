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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.ContextRetrievalServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryRecentRelevantTablesResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsFromRecentTablesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsFromRecentTablesResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableContextsResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedDescriptionsResponse;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesRequest;
import com.google.cloud.geminidataanalytics.v1beta.RetrieveBigQueryTableSuggestedExamplesResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * REST stub implementation for the ContextRetrievalService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonContextRetrievalServiceStub extends ContextRetrievalServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextMethodDescriptor =
          ApiMethodDescriptor
              .<RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableContext")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetrieveBigQueryTableContextRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}:retrieveBigQueryTableContext",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryTableContextRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryTableContextRequest> serializer =
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
                  ProtoMessageResponseParser.<RetrieveBigQueryTableContextResponse>newBuilder()
                      .setDefaultInstance(RetrieveBigQueryTableContextResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsMethodDescriptor =
          ApiMethodDescriptor
              .<RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableContexts")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RetrieveBigQueryTableContextsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/retrieval:retrieveBigQueryTableContexts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryTableContextsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryTableContextsRequest> serializer =
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
                  ProtoMessageResponseParser.<RetrieveBigQueryTableContextsResponse>newBuilder()
                      .setDefaultInstance(
                          RetrieveBigQueryTableContextsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesMethodDescriptor =
          ApiMethodDescriptor
              .<RetrieveBigQueryTableContextsFromRecentTablesRequest,
                  RetrieveBigQueryTableContextsFromRecentTablesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableContextsFromRecentTables")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RetrieveBigQueryTableContextsFromRecentTablesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/retrieval:retrieveBigQueryTableContextsFromRecentTables",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    RetrieveBigQueryTableContextsFromRecentTablesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    RetrieveBigQueryTableContextsFromRecentTablesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<RetrieveBigQueryTableContextsFromRecentTablesResponse>newBuilder()
                      .setDefaultInstance(
                          RetrieveBigQueryTableContextsFromRecentTablesResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsMethodDescriptor =
          ApiMethodDescriptor
              .<RetrieveBigQueryTableSuggestedDescriptionsRequest,
                  RetrieveBigQueryTableSuggestedDescriptionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableSuggestedDescriptions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RetrieveBigQueryTableSuggestedDescriptionsRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/retrieval:retrieveBigQueryTableSuggestedDescriptions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryTableSuggestedDescriptionsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryTableSuggestedDescriptionsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<RetrieveBigQueryTableSuggestedDescriptionsResponse>newBuilder()
                      .setDefaultInstance(
                          RetrieveBigQueryTableSuggestedDescriptionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesMethodDescriptor =
          ApiMethodDescriptor
              .<RetrieveBigQueryTableSuggestedExamplesRequest,
                  RetrieveBigQueryTableSuggestedExamplesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryTableSuggestedExamples")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RetrieveBigQueryTableSuggestedExamplesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/retrieval:retrieveBigQueryTableSuggestedExamples",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryTableSuggestedExamplesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryTableSuggestedExamplesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<RetrieveBigQueryTableSuggestedExamplesResponse>newBuilder()
                      .setDefaultInstance(
                          RetrieveBigQueryTableSuggestedExamplesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesMethodDescriptor =
          ApiMethodDescriptor
              .<RetrieveBigQueryRecentRelevantTablesRequest,
                  RetrieveBigQueryRecentRelevantTablesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.ContextRetrievalService/RetrieveBigQueryRecentRelevantTables")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RetrieveBigQueryRecentRelevantTablesRequest>newBuilder()
                      .setPath(
                          "/v1beta/{parent=projects/*/locations/*}/retrieval:retrieveBigQueryRecentRelevantTables",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryRecentRelevantTablesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RetrieveBigQueryRecentRelevantTablesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<RetrieveBigQueryRecentRelevantTablesResponse>newBuilder()
                      .setDefaultInstance(
                          RetrieveBigQueryRecentRelevantTablesResponse.getDefaultInstance())
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

  private final UnaryCallable<
          RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextCallable;
  private final UnaryCallable<
          RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsCallable;
  private final UnaryCallable<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesCallable;
  private final UnaryCallable<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsCallable;
  private final UnaryCallable<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesCallable;
  private final UnaryCallable<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonContextRetrievalServiceStub create(
      ContextRetrievalServiceStubSettings settings) throws IOException {
    return new HttpJsonContextRetrievalServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonContextRetrievalServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonContextRetrievalServiceStub(
        ContextRetrievalServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonContextRetrievalServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonContextRetrievalServiceStub(
        ContextRetrievalServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonContextRetrievalServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContextRetrievalServiceStub(
      ContextRetrievalServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonContextRetrievalServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonContextRetrievalServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContextRetrievalServiceStub(
      ContextRetrievalServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
        retrieveBigQueryTableContextTransportSettings =
            HttpJsonCallSettings
                .<RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableContextMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
        retrieveBigQueryTableContextsTransportSettings =
            HttpJsonCallSettings
                .<RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableContextsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            RetrieveBigQueryTableContextsFromRecentTablesRequest,
            RetrieveBigQueryTableContextsFromRecentTablesResponse>
        retrieveBigQueryTableContextsFromRecentTablesTransportSettings =
            HttpJsonCallSettings
                .<RetrieveBigQueryTableContextsFromRecentTablesRequest,
                    RetrieveBigQueryTableContextsFromRecentTablesResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableContextsFromRecentTablesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            RetrieveBigQueryTableSuggestedDescriptionsRequest,
            RetrieveBigQueryTableSuggestedDescriptionsResponse>
        retrieveBigQueryTableSuggestedDescriptionsTransportSettings =
            HttpJsonCallSettings
                .<RetrieveBigQueryTableSuggestedDescriptionsRequest,
                    RetrieveBigQueryTableSuggestedDescriptionsResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableSuggestedDescriptionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            RetrieveBigQueryTableSuggestedExamplesRequest,
            RetrieveBigQueryTableSuggestedExamplesResponse>
        retrieveBigQueryTableSuggestedExamplesTransportSettings =
            HttpJsonCallSettings
                .<RetrieveBigQueryTableSuggestedExamplesRequest,
                    RetrieveBigQueryTableSuggestedExamplesResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryTableSuggestedExamplesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            RetrieveBigQueryRecentRelevantTablesRequest,
            RetrieveBigQueryRecentRelevantTablesResponse>
        retrieveBigQueryRecentRelevantTablesTransportSettings =
            HttpJsonCallSettings
                .<RetrieveBigQueryRecentRelevantTablesRequest,
                    RetrieveBigQueryRecentRelevantTablesResponse>
                    newBuilder()
                .setMethodDescriptor(retrieveBigQueryRecentRelevantTablesMethodDescriptor)
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

    this.retrieveBigQueryTableContextCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableContextTransportSettings,
            settings.retrieveBigQueryTableContextSettings(),
            clientContext);
    this.retrieveBigQueryTableContextsCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableContextsTransportSettings,
            settings.retrieveBigQueryTableContextsSettings(),
            clientContext);
    this.retrieveBigQueryTableContextsFromRecentTablesCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableContextsFromRecentTablesTransportSettings,
            settings.retrieveBigQueryTableContextsFromRecentTablesSettings(),
            clientContext);
    this.retrieveBigQueryTableSuggestedDescriptionsCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableSuggestedDescriptionsTransportSettings,
            settings.retrieveBigQueryTableSuggestedDescriptionsSettings(),
            clientContext);
    this.retrieveBigQueryTableSuggestedExamplesCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryTableSuggestedExamplesTransportSettings,
            settings.retrieveBigQueryTableSuggestedExamplesSettings(),
            clientContext);
    this.retrieveBigQueryRecentRelevantTablesCallable =
        callableFactory.createUnaryCallable(
            retrieveBigQueryRecentRelevantTablesTransportSettings,
            settings.retrieveBigQueryRecentRelevantTablesSettings(),
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
    methodDescriptors.add(retrieveBigQueryTableContextMethodDescriptor);
    methodDescriptors.add(retrieveBigQueryTableContextsMethodDescriptor);
    methodDescriptors.add(retrieveBigQueryTableContextsFromRecentTablesMethodDescriptor);
    methodDescriptors.add(retrieveBigQueryTableSuggestedDescriptionsMethodDescriptor);
    methodDescriptors.add(retrieveBigQueryTableSuggestedExamplesMethodDescriptor);
    methodDescriptors.add(retrieveBigQueryRecentRelevantTablesMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<RetrieveBigQueryTableContextRequest, RetrieveBigQueryTableContextResponse>
      retrieveBigQueryTableContextCallable() {
    return retrieveBigQueryTableContextCallable;
  }

  @Override
  public UnaryCallable<RetrieveBigQueryTableContextsRequest, RetrieveBigQueryTableContextsResponse>
      retrieveBigQueryTableContextsCallable() {
    return retrieveBigQueryTableContextsCallable;
  }

  @Override
  public UnaryCallable<
          RetrieveBigQueryTableContextsFromRecentTablesRequest,
          RetrieveBigQueryTableContextsFromRecentTablesResponse>
      retrieveBigQueryTableContextsFromRecentTablesCallable() {
    return retrieveBigQueryTableContextsFromRecentTablesCallable;
  }

  @Override
  public UnaryCallable<
          RetrieveBigQueryTableSuggestedDescriptionsRequest,
          RetrieveBigQueryTableSuggestedDescriptionsResponse>
      retrieveBigQueryTableSuggestedDescriptionsCallable() {
    return retrieveBigQueryTableSuggestedDescriptionsCallable;
  }

  @Override
  public UnaryCallable<
          RetrieveBigQueryTableSuggestedExamplesRequest,
          RetrieveBigQueryTableSuggestedExamplesResponse>
      retrieveBigQueryTableSuggestedExamplesCallable() {
    return retrieveBigQueryTableSuggestedExamplesCallable;
  }

  @Override
  public UnaryCallable<
          RetrieveBigQueryRecentRelevantTablesRequest, RetrieveBigQueryRecentRelevantTablesResponse>
      retrieveBigQueryRecentRelevantTablesCallable() {
    return retrieveBigQueryRecentRelevantTablesCallable;
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
