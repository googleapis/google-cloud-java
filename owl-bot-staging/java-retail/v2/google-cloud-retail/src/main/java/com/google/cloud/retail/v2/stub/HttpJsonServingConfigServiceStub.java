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

package com.google.cloud.retail.v2.stub;

import static com.google.cloud.retail.v2.ServingConfigServiceClient.ListServingConfigsPagedResponse;

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
import com.google.cloud.retail.v2.AddControlRequest;
import com.google.cloud.retail.v2.CreateServingConfigRequest;
import com.google.cloud.retail.v2.DeleteServingConfigRequest;
import com.google.cloud.retail.v2.GetServingConfigRequest;
import com.google.cloud.retail.v2.ListServingConfigsRequest;
import com.google.cloud.retail.v2.ListServingConfigsResponse;
import com.google.cloud.retail.v2.RemoveControlRequest;
import com.google.cloud.retail.v2.ServingConfig;
import com.google.cloud.retail.v2.UpdateServingConfigRequest;
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
 * REST stub implementation for the ServingConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonServingConfigServiceStub extends ServingConfigServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateServingConfigRequest, ServingConfig>
      createServingConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateServingConfigRequest, ServingConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.ServingConfigService/CreateServingConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateServingConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/catalogs/*}/servingConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "servingConfigId", request.getServingConfigId());
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

  private static final ApiMethodDescriptor<DeleteServingConfigRequest, Empty>
      deleteServingConfigMethodDescriptor =
          ApiMethodDescriptor.<DeleteServingConfigRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.ServingConfigService/DeleteServingConfig")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteServingConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/catalogs/*/servingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateServingConfigRequest, ServingConfig>
      updateServingConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateServingConfigRequest, ServingConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.ServingConfigService/UpdateServingConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateServingConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{servingConfig.name=projects/*/locations/*/catalogs/*/servingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "servingConfig.name", request.getServingConfig().getName());
                            return fields;
                          })
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
              .setFullMethodName("google.cloud.retail.v2.ServingConfigService/GetServingConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetServingConfigRequest>newBuilder()
                      .setPath(
                          "/v2/{name=projects/*/locations/*/catalogs/*/servingConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetServingConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
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
              .setFullMethodName("google.cloud.retail.v2.ServingConfigService/ListServingConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListServingConfigsRequest>newBuilder()
                      .setPath(
                          "/v2/{parent=projects/*/locations/*/catalogs/*}/servingConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListServingConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
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

  private static final ApiMethodDescriptor<AddControlRequest, ServingConfig>
      addControlMethodDescriptor =
          ApiMethodDescriptor.<AddControlRequest, ServingConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.ServingConfigService/AddControl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddControlRequest>newBuilder()
                      .setPath(
                          "/v2/{servingConfig=projects/*/locations/*/catalogs/*/servingConfigs/*}:addControl",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "servingConfig", request.getServingConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddControlRequest> serializer =
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
                  ProtoMessageResponseParser.<ServingConfig>newBuilder()
                      .setDefaultInstance(ServingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveControlRequest, ServingConfig>
      removeControlMethodDescriptor =
          ApiMethodDescriptor.<RemoveControlRequest, ServingConfig>newBuilder()
              .setFullMethodName("google.cloud.retail.v2.ServingConfigService/RemoveControl")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveControlRequest>newBuilder()
                      .setPath(
                          "/v2/{servingConfig=projects/*/locations/*/catalogs/*/servingConfigs/*}:removeControl",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveControlRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "servingConfig", request.getServingConfig());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveControlRequest> serializer =
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
                  ProtoMessageResponseParser.<ServingConfig>newBuilder()
                      .setDefaultInstance(ServingConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateServingConfigRequest, ServingConfig>
      createServingConfigCallable;
  private final UnaryCallable<DeleteServingConfigRequest, Empty> deleteServingConfigCallable;
  private final UnaryCallable<UpdateServingConfigRequest, ServingConfig>
      updateServingConfigCallable;
  private final UnaryCallable<GetServingConfigRequest, ServingConfig> getServingConfigCallable;
  private final UnaryCallable<ListServingConfigsRequest, ListServingConfigsResponse>
      listServingConfigsCallable;
  private final UnaryCallable<ListServingConfigsRequest, ListServingConfigsPagedResponse>
      listServingConfigsPagedCallable;
  private final UnaryCallable<AddControlRequest, ServingConfig> addControlCallable;
  private final UnaryCallable<RemoveControlRequest, ServingConfig> removeControlCallable;

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

    HttpJsonCallSettings<CreateServingConfigRequest, ServingConfig>
        createServingConfigTransportSettings =
            HttpJsonCallSettings.<CreateServingConfigRequest, ServingConfig>newBuilder()
                .setMethodDescriptor(createServingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteServingConfigRequest, Empty> deleteServingConfigTransportSettings =
        HttpJsonCallSettings.<DeleteServingConfigRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteServingConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateServingConfigRequest, ServingConfig>
        updateServingConfigTransportSettings =
            HttpJsonCallSettings.<UpdateServingConfigRequest, ServingConfig>newBuilder()
                .setMethodDescriptor(updateServingConfigMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetServingConfigRequest, ServingConfig> getServingConfigTransportSettings =
        HttpJsonCallSettings.<GetServingConfigRequest, ServingConfig>newBuilder()
            .setMethodDescriptor(getServingConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListServingConfigsRequest, ListServingConfigsResponse>
        listServingConfigsTransportSettings =
            HttpJsonCallSettings.<ListServingConfigsRequest, ListServingConfigsResponse>newBuilder()
                .setMethodDescriptor(listServingConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AddControlRequest, ServingConfig> addControlTransportSettings =
        HttpJsonCallSettings.<AddControlRequest, ServingConfig>newBuilder()
            .setMethodDescriptor(addControlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RemoveControlRequest, ServingConfig> removeControlTransportSettings =
        HttpJsonCallSettings.<RemoveControlRequest, ServingConfig>newBuilder()
            .setMethodDescriptor(removeControlMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createServingConfigCallable =
        callableFactory.createUnaryCallable(
            createServingConfigTransportSettings,
            settings.createServingConfigSettings(),
            clientContext);
    this.deleteServingConfigCallable =
        callableFactory.createUnaryCallable(
            deleteServingConfigTransportSettings,
            settings.deleteServingConfigSettings(),
            clientContext);
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
    this.addControlCallable =
        callableFactory.createUnaryCallable(
            addControlTransportSettings, settings.addControlSettings(), clientContext);
    this.removeControlCallable =
        callableFactory.createUnaryCallable(
            removeControlTransportSettings, settings.removeControlSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createServingConfigMethodDescriptor);
    methodDescriptors.add(deleteServingConfigMethodDescriptor);
    methodDescriptors.add(updateServingConfigMethodDescriptor);
    methodDescriptors.add(getServingConfigMethodDescriptor);
    methodDescriptors.add(listServingConfigsMethodDescriptor);
    methodDescriptors.add(addControlMethodDescriptor);
    methodDescriptors.add(removeControlMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateServingConfigRequest, ServingConfig> createServingConfigCallable() {
    return createServingConfigCallable;
  }

  @Override
  public UnaryCallable<DeleteServingConfigRequest, Empty> deleteServingConfigCallable() {
    return deleteServingConfigCallable;
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
  public UnaryCallable<AddControlRequest, ServingConfig> addControlCallable() {
    return addControlCallable;
  }

  @Override
  public UnaryCallable<RemoveControlRequest, ServingConfig> removeControlCallable() {
    return removeControlCallable;
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
