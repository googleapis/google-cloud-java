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

package com.google.cloud.developerconnect.v1.stub;

import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListInsightsConfigsPagedResponse;
import static com.google.cloud.developerconnect.v1.InsightsConfigServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.developerconnect.v1.CreateInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.DeleteInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.GetInsightsConfigRequest;
import com.google.cloud.developerconnect.v1.InsightsConfig;
import com.google.cloud.developerconnect.v1.ListInsightsConfigsRequest;
import com.google.cloud.developerconnect.v1.ListInsightsConfigsResponse;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.cloud.developerconnect.v1.UpdateInsightsConfigRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
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
 * REST stub implementation for the InsightsConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonInsightsConfigServiceStub extends InsightsConfigServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(InsightsConfig.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
      listInsightsConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListInsightsConfigsRequest, ListInsightsConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/ListInsightsConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInsightsConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/insightsConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInsightsConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInsightsConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListInsightsConfigsResponse>newBuilder()
                      .setDefaultInstance(ListInsightsConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateInsightsConfigRequest, Operation>
      createInsightsConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateInsightsConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/CreateInsightsConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateInsightsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/insightsConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInsightsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateInsightsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "insightsConfigId", request.getInsightsConfigId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("insightsConfig", request.getInsightsConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateInsightsConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetInsightsConfigRequest, InsightsConfig>
      getInsightsConfigMethodDescriptor =
          ApiMethodDescriptor.<GetInsightsConfigRequest, InsightsConfig>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/GetInsightsConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInsightsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/insightsConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInsightsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInsightsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InsightsConfig>newBuilder()
                      .setDefaultInstance(InsightsConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateInsightsConfigRequest, Operation>
      updateInsightsConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateInsightsConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/UpdateInsightsConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateInsightsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{insightsConfig.name=projects/*/locations/*/insightsConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInsightsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "insightsConfig.name",
                                request.getInsightsConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateInsightsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("insightsConfig", request.getInsightsConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateInsightsConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteInsightsConfigRequest, Operation>
      deleteInsightsConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteInsightsConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.InsightsConfigService/DeleteInsightsConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInsightsConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/insightsConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInsightsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInsightsConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteInsightsConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
                          "/v1/{name=projects/*}/locations",
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
                          "/v1/{name=projects/*/locations/*}",
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

  private final UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
      listInsightsConfigsCallable;
  private final UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsPagedResponse>
      listInsightsConfigsPagedCallable;
  private final UnaryCallable<CreateInsightsConfigRequest, Operation> createInsightsConfigCallable;
  private final OperationCallable<CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      createInsightsConfigOperationCallable;
  private final UnaryCallable<GetInsightsConfigRequest, InsightsConfig> getInsightsConfigCallable;
  private final UnaryCallable<UpdateInsightsConfigRequest, Operation> updateInsightsConfigCallable;
  private final OperationCallable<UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      updateInsightsConfigOperationCallable;
  private final UnaryCallable<DeleteInsightsConfigRequest, Operation> deleteInsightsConfigCallable;
  private final OperationCallable<DeleteInsightsConfigRequest, Empty, OperationMetadata>
      deleteInsightsConfigOperationCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInsightsConfigServiceStub create(
      InsightsConfigServiceStubSettings settings) throws IOException {
    return new HttpJsonInsightsConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInsightsConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInsightsConfigServiceStub(
        InsightsConfigServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonInsightsConfigServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInsightsConfigServiceStub(
        InsightsConfigServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInsightsConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInsightsConfigServiceStub(
      InsightsConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInsightsConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInsightsConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInsightsConfigServiceStub(
      InsightsConfigServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
        listInsightsConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListInsightsConfigsRequest, ListInsightsConfigsResponse>newBuilder()
                .setMethodDescriptor(listInsightsConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateInsightsConfigRequest, Operation>
        createInsightsConfigTransportSettings =
            HttpJsonCallSettings.<CreateInsightsConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createInsightsConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInsightsConfigRequest, InsightsConfig>
        getInsightsConfigTransportSettings =
            HttpJsonCallSettings.<GetInsightsConfigRequest, InsightsConfig>newBuilder()
                .setMethodDescriptor(getInsightsConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateInsightsConfigRequest, Operation>
        updateInsightsConfigTransportSettings =
            HttpJsonCallSettings.<UpdateInsightsConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateInsightsConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "insights_config.name",
                          String.valueOf(request.getInsightsConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteInsightsConfigRequest, Operation>
        deleteInsightsConfigTransportSettings =
            HttpJsonCallSettings.<DeleteInsightsConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInsightsConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
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

    this.listInsightsConfigsCallable =
        callableFactory.createUnaryCallable(
            listInsightsConfigsTransportSettings,
            settings.listInsightsConfigsSettings(),
            clientContext);
    this.listInsightsConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listInsightsConfigsTransportSettings,
            settings.listInsightsConfigsSettings(),
            clientContext);
    this.createInsightsConfigCallable =
        callableFactory.createUnaryCallable(
            createInsightsConfigTransportSettings,
            settings.createInsightsConfigSettings(),
            clientContext);
    this.createInsightsConfigOperationCallable =
        callableFactory.createOperationCallable(
            createInsightsConfigTransportSettings,
            settings.createInsightsConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getInsightsConfigCallable =
        callableFactory.createUnaryCallable(
            getInsightsConfigTransportSettings,
            settings.getInsightsConfigSettings(),
            clientContext);
    this.updateInsightsConfigCallable =
        callableFactory.createUnaryCallable(
            updateInsightsConfigTransportSettings,
            settings.updateInsightsConfigSettings(),
            clientContext);
    this.updateInsightsConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateInsightsConfigTransportSettings,
            settings.updateInsightsConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteInsightsConfigCallable =
        callableFactory.createUnaryCallable(
            deleteInsightsConfigTransportSettings,
            settings.deleteInsightsConfigSettings(),
            clientContext);
    this.deleteInsightsConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteInsightsConfigTransportSettings,
            settings.deleteInsightsConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    methodDescriptors.add(listInsightsConfigsMethodDescriptor);
    methodDescriptors.add(createInsightsConfigMethodDescriptor);
    methodDescriptors.add(getInsightsConfigMethodDescriptor);
    methodDescriptors.add(updateInsightsConfigMethodDescriptor);
    methodDescriptors.add(deleteInsightsConfigMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsResponse>
      listInsightsConfigsCallable() {
    return listInsightsConfigsCallable;
  }

  @Override
  public UnaryCallable<ListInsightsConfigsRequest, ListInsightsConfigsPagedResponse>
      listInsightsConfigsPagedCallable() {
    return listInsightsConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateInsightsConfigRequest, Operation> createInsightsConfigCallable() {
    return createInsightsConfigCallable;
  }

  @Override
  public OperationCallable<CreateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      createInsightsConfigOperationCallable() {
    return createInsightsConfigOperationCallable;
  }

  @Override
  public UnaryCallable<GetInsightsConfigRequest, InsightsConfig> getInsightsConfigCallable() {
    return getInsightsConfigCallable;
  }

  @Override
  public UnaryCallable<UpdateInsightsConfigRequest, Operation> updateInsightsConfigCallable() {
    return updateInsightsConfigCallable;
  }

  @Override
  public OperationCallable<UpdateInsightsConfigRequest, InsightsConfig, OperationMetadata>
      updateInsightsConfigOperationCallable() {
    return updateInsightsConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInsightsConfigRequest, Operation> deleteInsightsConfigCallable() {
    return deleteInsightsConfigCallable;
  }

  @Override
  public OperationCallable<DeleteInsightsConfigRequest, Empty, OperationMetadata>
      deleteInsightsConfigOperationCallable() {
    return deleteInsightsConfigOperationCallable;
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
