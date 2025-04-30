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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.CmekServiceClient.ListEncryptionConfigsPagedResponse;
import static com.google.cloud.dataplex.v1.CmekServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.EncryptionConfig;
import com.google.cloud.dataplex.v1.GetEncryptionConfigRequest;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest;
import com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest;
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
 * REST stub implementation for the CmekService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCmekServiceStub extends CmekServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(EncryptionConfig.getDescriptor())
          .add(OperationMetadata.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateEncryptionConfigRequest, Operation>
      createEncryptionConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateEncryptionConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/CreateEncryptionConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateEncryptionConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/encryptionConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEncryptionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEncryptionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "encryptionConfigId", request.getEncryptionConfigId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("encryptionConfig", request.getEncryptionConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateEncryptionConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateEncryptionConfigRequest, Operation>
      updateEncryptionConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateEncryptionConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/UpdateEncryptionConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateEncryptionConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{encryptionConfig.name=organizations/*/locations/*/encryptionConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEncryptionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "encryptionConfig.name",
                                request.getEncryptionConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEncryptionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("encryptionConfig", request.getEncryptionConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateEncryptionConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeleteEncryptionConfigRequest, Operation>
      deleteEncryptionConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteEncryptionConfigRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/DeleteEncryptionConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteEncryptionConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/encryptionConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEncryptionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEncryptionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "etag", request.getEtag());
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
                  (DeleteEncryptionConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<
          ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
      listEncryptionConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/ListEncryptionConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListEncryptionConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=organizations/*/locations/*}/encryptionConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEncryptionConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEncryptionConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListEncryptionConfigsResponse>newBuilder()
                      .setDefaultInstance(ListEncryptionConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEncryptionConfigRequest, EncryptionConfig>
      getEncryptionConfigMethodDescriptor =
          ApiMethodDescriptor.<GetEncryptionConfigRequest, EncryptionConfig>newBuilder()
              .setFullMethodName("google.cloud.dataplex.v1.CmekService/GetEncryptionConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEncryptionConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=organizations/*/locations/*/encryptionConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEncryptionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEncryptionConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EncryptionConfig>newBuilder()
                      .setDefaultInstance(EncryptionConfig.getDefaultInstance())
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

  private final UnaryCallable<CreateEncryptionConfigRequest, Operation>
      createEncryptionConfigCallable;
  private final OperationCallable<
          CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      createEncryptionConfigOperationCallable;
  private final UnaryCallable<UpdateEncryptionConfigRequest, Operation>
      updateEncryptionConfigCallable;
  private final OperationCallable<
          UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      updateEncryptionConfigOperationCallable;
  private final UnaryCallable<DeleteEncryptionConfigRequest, Operation>
      deleteEncryptionConfigCallable;
  private final OperationCallable<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
      deleteEncryptionConfigOperationCallable;
  private final UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
      listEncryptionConfigsCallable;
  private final UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsPagedResponse>
      listEncryptionConfigsPagedCallable;
  private final UnaryCallable<GetEncryptionConfigRequest, EncryptionConfig>
      getEncryptionConfigCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCmekServiceStub create(CmekServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCmekServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCmekServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCmekServiceStub(
        CmekServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCmekServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCmekServiceStub(
        CmekServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCmekServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCmekServiceStub(CmekServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonCmekServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCmekServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonCmekServiceStub(
      CmekServiceStubSettings settings,
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
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=organizations/*/locations/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setDelete("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=organizations/*/locations/*/operations/*}")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<CreateEncryptionConfigRequest, Operation>
        createEncryptionConfigTransportSettings =
            HttpJsonCallSettings.<CreateEncryptionConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(createEncryptionConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateEncryptionConfigRequest, Operation>
        updateEncryptionConfigTransportSettings =
            HttpJsonCallSettings.<UpdateEncryptionConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(updateEncryptionConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "encryption_config.name",
                          String.valueOf(request.getEncryptionConfig().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEncryptionConfigRequest, Operation>
        deleteEncryptionConfigTransportSettings =
            HttpJsonCallSettings.<DeleteEncryptionConfigRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteEncryptionConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
        listEncryptionConfigsTransportSettings =
            HttpJsonCallSettings
                .<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>newBuilder()
                .setMethodDescriptor(listEncryptionConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetEncryptionConfigRequest, EncryptionConfig>
        getEncryptionConfigTransportSettings =
            HttpJsonCallSettings.<GetEncryptionConfigRequest, EncryptionConfig>newBuilder()
                .setMethodDescriptor(getEncryptionConfigMethodDescriptor)
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

    this.createEncryptionConfigCallable =
        callableFactory.createUnaryCallable(
            createEncryptionConfigTransportSettings,
            settings.createEncryptionConfigSettings(),
            clientContext);
    this.createEncryptionConfigOperationCallable =
        callableFactory.createOperationCallable(
            createEncryptionConfigTransportSettings,
            settings.createEncryptionConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.updateEncryptionConfigCallable =
        callableFactory.createUnaryCallable(
            updateEncryptionConfigTransportSettings,
            settings.updateEncryptionConfigSettings(),
            clientContext);
    this.updateEncryptionConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateEncryptionConfigTransportSettings,
            settings.updateEncryptionConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.deleteEncryptionConfigCallable =
        callableFactory.createUnaryCallable(
            deleteEncryptionConfigTransportSettings,
            settings.deleteEncryptionConfigSettings(),
            clientContext);
    this.deleteEncryptionConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteEncryptionConfigTransportSettings,
            settings.deleteEncryptionConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listEncryptionConfigsCallable =
        callableFactory.createUnaryCallable(
            listEncryptionConfigsTransportSettings,
            settings.listEncryptionConfigsSettings(),
            clientContext);
    this.listEncryptionConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listEncryptionConfigsTransportSettings,
            settings.listEncryptionConfigsSettings(),
            clientContext);
    this.getEncryptionConfigCallable =
        callableFactory.createUnaryCallable(
            getEncryptionConfigTransportSettings,
            settings.getEncryptionConfigSettings(),
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
    methodDescriptors.add(createEncryptionConfigMethodDescriptor);
    methodDescriptors.add(updateEncryptionConfigMethodDescriptor);
    methodDescriptors.add(deleteEncryptionConfigMethodDescriptor);
    methodDescriptors.add(listEncryptionConfigsMethodDescriptor);
    methodDescriptors.add(getEncryptionConfigMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateEncryptionConfigRequest, Operation> createEncryptionConfigCallable() {
    return createEncryptionConfigCallable;
  }

  @Override
  public OperationCallable<CreateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      createEncryptionConfigOperationCallable() {
    return createEncryptionConfigOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateEncryptionConfigRequest, Operation> updateEncryptionConfigCallable() {
    return updateEncryptionConfigCallable;
  }

  @Override
  public OperationCallable<UpdateEncryptionConfigRequest, EncryptionConfig, OperationMetadata>
      updateEncryptionConfigOperationCallable() {
    return updateEncryptionConfigOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteEncryptionConfigRequest, Operation> deleteEncryptionConfigCallable() {
    return deleteEncryptionConfigCallable;
  }

  @Override
  public OperationCallable<DeleteEncryptionConfigRequest, Empty, OperationMetadata>
      deleteEncryptionConfigOperationCallable() {
    return deleteEncryptionConfigOperationCallable;
  }

  @Override
  public UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsResponse>
      listEncryptionConfigsCallable() {
    return listEncryptionConfigsCallable;
  }

  @Override
  public UnaryCallable<ListEncryptionConfigsRequest, ListEncryptionConfigsPagedResponse>
      listEncryptionConfigsPagedCallable() {
    return listEncryptionConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<GetEncryptionConfigRequest, EncryptionConfig> getEncryptionConfigCallable() {
    return getEncryptionConfigCallable;
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
