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

package com.google.cloud.discoveryengine.v1.stub;

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
import com.google.cloud.discoveryengine.v1.CmekConfig;
import com.google.cloud.discoveryengine.v1.DeleteCmekConfigMetadata;
import com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest;
import com.google.cloud.discoveryengine.v1.GetCmekConfigRequest;
import com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest;
import com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse;
import com.google.cloud.discoveryengine.v1.UpdateCmekConfigMetadata;
import com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest;
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
 * REST stub implementation for the CmekConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonCmekConfigServiceStub extends CmekConfigServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(Empty.getDescriptor())
          .add(DeleteCmekConfigMetadata.getDescriptor())
          .add(UpdateCmekConfigMetadata.getDescriptor())
          .add(CmekConfig.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<UpdateCmekConfigRequest, Operation>
      updateCmekConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateCmekConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.CmekConfigService/UpdateCmekConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCmekConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{config.name=projects/*/locations/*/cmekConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCmekConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "config.name", request.getConfig().getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{config.name=projects/*/locations/*/cmekConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCmekConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "setDefault", request.getSetDefault());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("config", request.getConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UpdateCmekConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetCmekConfigRequest, CmekConfig>
      getCmekConfigMethodDescriptor =
          ApiMethodDescriptor.<GetCmekConfigRequest, CmekConfig>newBuilder()
              .setFullMethodName("google.cloud.discoveryengine.v1.CmekConfigService/GetCmekConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCmekConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/cmekConfig}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCmekConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1/{name=projects/*/locations/*/cmekConfigs/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCmekConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CmekConfig>newBuilder()
                      .setDefaultInstance(CmekConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCmekConfigsRequest, ListCmekConfigsResponse>
      listCmekConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListCmekConfigsRequest, ListCmekConfigsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.CmekConfigService/ListCmekConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCmekConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/cmekConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCmekConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCmekConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCmekConfigsResponse>newBuilder()
                      .setDefaultInstance(ListCmekConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteCmekConfigRequest, Operation>
      deleteCmekConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteCmekConfigRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1.CmekConfigService/DeleteCmekConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteCmekConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/cmekConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCmekConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteCmekConfigRequest> serializer =
                                ProtoRestSerializer.create();
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
                  (DeleteCmekConfigRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private final UnaryCallable<UpdateCmekConfigRequest, Operation> updateCmekConfigCallable;
  private final OperationCallable<UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
      updateCmekConfigOperationCallable;
  private final UnaryCallable<GetCmekConfigRequest, CmekConfig> getCmekConfigCallable;
  private final UnaryCallable<ListCmekConfigsRequest, ListCmekConfigsResponse>
      listCmekConfigsCallable;
  private final UnaryCallable<DeleteCmekConfigRequest, Operation> deleteCmekConfigCallable;
  private final OperationCallable<DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
      deleteCmekConfigOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCmekConfigServiceStub create(CmekConfigServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCmekConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCmekConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCmekConfigServiceStub(
        CmekConfigServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonCmekConfigServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCmekConfigServiceStub(
        CmekConfigServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCmekConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCmekConfigServiceStub(
      CmekConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCmekConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCmekConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCmekConfigServiceStub(
      CmekConfigServiceStubSettings settings,
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
                        .setPost("/v1/{name=projects/*/operations/*}:cancel")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}:cancel")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=projects/*/locations/*/collections/*/engines/*/operations/*}:cancel")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setPost(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}:cancel")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/operations/*}")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataConnector/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/engines/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/branches/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/models/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/identityMappingStores/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/operations/*}")
                                .build())
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*}/operations")
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataConnector}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/schemas/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine/targetSites}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*/siteSearchEngine}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*/engines/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/collections/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/branches/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/dataStores/*/models/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*/dataStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet(
                                    "/v1/{name=projects/*/locations/*/identityMappingStores/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*/locations/*}/operations")
                                .build())
                        .addAdditionalBindings(
                            HttpRule.newBuilder()
                                .setGet("/v1/{name=projects/*}/operations")
                                .build())
                        .build())
                .build());

    HttpJsonCallSettings<UpdateCmekConfigRequest, Operation> updateCmekConfigTransportSettings =
        HttpJsonCallSettings.<UpdateCmekConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(updateCmekConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("config.name", String.valueOf(request.getConfig().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetCmekConfigRequest, CmekConfig> getCmekConfigTransportSettings =
        HttpJsonCallSettings.<GetCmekConfigRequest, CmekConfig>newBuilder()
            .setMethodDescriptor(getCmekConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListCmekConfigsRequest, ListCmekConfigsResponse>
        listCmekConfigsTransportSettings =
            HttpJsonCallSettings.<ListCmekConfigsRequest, ListCmekConfigsResponse>newBuilder()
                .setMethodDescriptor(listCmekConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteCmekConfigRequest, Operation> deleteCmekConfigTransportSettings =
        HttpJsonCallSettings.<DeleteCmekConfigRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteCmekConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.updateCmekConfigCallable =
        callableFactory.createUnaryCallable(
            updateCmekConfigTransportSettings, settings.updateCmekConfigSettings(), clientContext);
    this.updateCmekConfigOperationCallable =
        callableFactory.createOperationCallable(
            updateCmekConfigTransportSettings,
            settings.updateCmekConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCmekConfigCallable =
        callableFactory.createUnaryCallable(
            getCmekConfigTransportSettings, settings.getCmekConfigSettings(), clientContext);
    this.listCmekConfigsCallable =
        callableFactory.createUnaryCallable(
            listCmekConfigsTransportSettings, settings.listCmekConfigsSettings(), clientContext);
    this.deleteCmekConfigCallable =
        callableFactory.createUnaryCallable(
            deleteCmekConfigTransportSettings, settings.deleteCmekConfigSettings(), clientContext);
    this.deleteCmekConfigOperationCallable =
        callableFactory.createOperationCallable(
            deleteCmekConfigTransportSettings,
            settings.deleteCmekConfigOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(updateCmekConfigMethodDescriptor);
    methodDescriptors.add(getCmekConfigMethodDescriptor);
    methodDescriptors.add(listCmekConfigsMethodDescriptor);
    methodDescriptors.add(deleteCmekConfigMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<UpdateCmekConfigRequest, Operation> updateCmekConfigCallable() {
    return updateCmekConfigCallable;
  }

  @Override
  public OperationCallable<UpdateCmekConfigRequest, CmekConfig, UpdateCmekConfigMetadata>
      updateCmekConfigOperationCallable() {
    return updateCmekConfigOperationCallable;
  }

  @Override
  public UnaryCallable<GetCmekConfigRequest, CmekConfig> getCmekConfigCallable() {
    return getCmekConfigCallable;
  }

  @Override
  public UnaryCallable<ListCmekConfigsRequest, ListCmekConfigsResponse> listCmekConfigsCallable() {
    return listCmekConfigsCallable;
  }

  @Override
  public UnaryCallable<DeleteCmekConfigRequest, Operation> deleteCmekConfigCallable() {
    return deleteCmekConfigCallable;
  }

  @Override
  public OperationCallable<DeleteCmekConfigRequest, Empty, DeleteCmekConfigMetadata>
      deleteCmekConfigOperationCallable() {
    return deleteCmekConfigOperationCallable;
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
