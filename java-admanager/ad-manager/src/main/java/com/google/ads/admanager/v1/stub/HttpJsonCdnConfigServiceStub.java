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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.CdnConfigServiceClient.ListCdnConfigsPagedResponse;

import com.google.ads.admanager.v1.BatchActivateCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchActivateCdnConfigsResponse;
import com.google.ads.admanager.v1.BatchArchiveCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchArchiveCdnConfigsResponse;
import com.google.ads.admanager.v1.BatchCreateCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchCreateCdnConfigsResponse;
import com.google.ads.admanager.v1.BatchUpdateCdnConfigsRequest;
import com.google.ads.admanager.v1.BatchUpdateCdnConfigsResponse;
import com.google.ads.admanager.v1.CdnConfig;
import com.google.ads.admanager.v1.CreateCdnConfigRequest;
import com.google.ads.admanager.v1.GetCdnConfigRequest;
import com.google.ads.admanager.v1.ListCdnConfigsRequest;
import com.google.ads.admanager.v1.ListCdnConfigsResponse;
import com.google.ads.admanager.v1.UpdateCdnConfigRequest;
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
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the CdnConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonCdnConfigServiceStub extends CdnConfigServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetCdnConfigRequest, CdnConfig>
      getCdnConfigMethodDescriptor =
          ApiMethodDescriptor.<GetCdnConfigRequest, CdnConfig>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CdnConfigService/GetCdnConfig")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetCdnConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{name=networks/*/cdnConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetCdnConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetCdnConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CdnConfig>newBuilder()
                      .setDefaultInstance(CdnConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListCdnConfigsRequest, ListCdnConfigsResponse>
      listCdnConfigsMethodDescriptor =
          ApiMethodDescriptor.<ListCdnConfigsRequest, ListCdnConfigsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CdnConfigService/ListCdnConfigs")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListCdnConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/cdnConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListCdnConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListCdnConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "skip", request.getSkip());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListCdnConfigsResponse>newBuilder()
                      .setDefaultInstance(ListCdnConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateCdnConfigRequest, CdnConfig>
      createCdnConfigMethodDescriptor =
          ApiMethodDescriptor.<CreateCdnConfigRequest, CdnConfig>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CdnConfigService/CreateCdnConfig")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateCdnConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/cdnConfigs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCdnConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateCdnConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cdnConfig", request.getCdnConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CdnConfig>newBuilder()
                      .setDefaultInstance(CdnConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
      batchCreateCdnConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CdnConfigService/BatchCreateCdnConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateCdnConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/cdnConfigs:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCdnConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateCdnConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateCdnConfigsResponse>newBuilder()
                      .setDefaultInstance(BatchCreateCdnConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateCdnConfigRequest, CdnConfig>
      updateCdnConfigMethodDescriptor =
          ApiMethodDescriptor.<UpdateCdnConfigRequest, CdnConfig>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CdnConfigService/UpdateCdnConfig")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateCdnConfigRequest>newBuilder()
                      .setPath(
                          "/v1/{cdnConfig.name=networks/*/cdnConfigs/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCdnConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "cdnConfig.name", request.getCdnConfig().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateCdnConfigRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("cdnConfig", request.getCdnConfig(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CdnConfig>newBuilder()
                      .setDefaultInstance(CdnConfig.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
      batchUpdateCdnConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CdnConfigService/BatchUpdateCdnConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateCdnConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/cdnConfigs:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCdnConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateCdnConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateCdnConfigsResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateCdnConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
      batchActivateCdnConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CdnConfigService/BatchActivateCdnConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateCdnConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/cdnConfigs:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCdnConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateCdnConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateCdnConfigsResponse>newBuilder()
                      .setDefaultInstance(BatchActivateCdnConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
      batchArchiveCdnConfigsMethodDescriptor =
          ApiMethodDescriptor
              .<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.CdnConfigService/BatchArchiveCdnConfigs")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchArchiveCdnConfigsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/cdnConfigs:batchArchive",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveCdnConfigsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchArchiveCdnConfigsRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchArchiveCdnConfigsResponse>newBuilder()
                      .setDefaultInstance(BatchArchiveCdnConfigsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetCdnConfigRequest, CdnConfig> getCdnConfigCallable;
  private final UnaryCallable<ListCdnConfigsRequest, ListCdnConfigsResponse> listCdnConfigsCallable;
  private final UnaryCallable<ListCdnConfigsRequest, ListCdnConfigsPagedResponse>
      listCdnConfigsPagedCallable;
  private final UnaryCallable<CreateCdnConfigRequest, CdnConfig> createCdnConfigCallable;
  private final UnaryCallable<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
      batchCreateCdnConfigsCallable;
  private final UnaryCallable<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigCallable;
  private final UnaryCallable<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
      batchUpdateCdnConfigsCallable;
  private final UnaryCallable<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
      batchActivateCdnConfigsCallable;
  private final UnaryCallable<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
      batchArchiveCdnConfigsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonCdnConfigServiceStub create(CdnConfigServiceStubSettings settings)
      throws IOException {
    return new HttpJsonCdnConfigServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonCdnConfigServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonCdnConfigServiceStub(
        CdnConfigServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonCdnConfigServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonCdnConfigServiceStub(
        CdnConfigServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonCdnConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCdnConfigServiceStub(
      CdnConfigServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonCdnConfigServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonCdnConfigServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonCdnConfigServiceStub(
      CdnConfigServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetCdnConfigRequest, CdnConfig> getCdnConfigTransportSettings =
        HttpJsonCallSettings.<GetCdnConfigRequest, CdnConfig>newBuilder()
            .setMethodDescriptor(getCdnConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListCdnConfigsRequest, ListCdnConfigsResponse>
        listCdnConfigsTransportSettings =
            HttpJsonCallSettings.<ListCdnConfigsRequest, ListCdnConfigsResponse>newBuilder()
                .setMethodDescriptor(listCdnConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<CreateCdnConfigRequest, CdnConfig> createCdnConfigTransportSettings =
        HttpJsonCallSettings.<CreateCdnConfigRequest, CdnConfig>newBuilder()
            .setMethodDescriptor(createCdnConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
        batchCreateCdnConfigsTransportSettings =
            HttpJsonCallSettings
                .<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>newBuilder()
                .setMethodDescriptor(batchCreateCdnConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigTransportSettings =
        HttpJsonCallSettings.<UpdateCdnConfigRequest, CdnConfig>newBuilder()
            .setMethodDescriptor(updateCdnConfigMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("cdn_config.name", String.valueOf(request.getCdnConfig().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
        batchUpdateCdnConfigsTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>newBuilder()
                .setMethodDescriptor(batchUpdateCdnConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
        batchActivateCdnConfigsTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>newBuilder()
                .setMethodDescriptor(batchActivateCdnConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
        batchArchiveCdnConfigsTransportSettings =
            HttpJsonCallSettings
                .<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>newBuilder()
                .setMethodDescriptor(batchArchiveCdnConfigsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();

    this.getCdnConfigCallable =
        callableFactory.createUnaryCallable(
            getCdnConfigTransportSettings, settings.getCdnConfigSettings(), clientContext);
    this.listCdnConfigsCallable =
        callableFactory.createUnaryCallable(
            listCdnConfigsTransportSettings, settings.listCdnConfigsSettings(), clientContext);
    this.listCdnConfigsPagedCallable =
        callableFactory.createPagedCallable(
            listCdnConfigsTransportSettings, settings.listCdnConfigsSettings(), clientContext);
    this.createCdnConfigCallable =
        callableFactory.createUnaryCallable(
            createCdnConfigTransportSettings, settings.createCdnConfigSettings(), clientContext);
    this.batchCreateCdnConfigsCallable =
        callableFactory.createUnaryCallable(
            batchCreateCdnConfigsTransportSettings,
            settings.batchCreateCdnConfigsSettings(),
            clientContext);
    this.updateCdnConfigCallable =
        callableFactory.createUnaryCallable(
            updateCdnConfigTransportSettings, settings.updateCdnConfigSettings(), clientContext);
    this.batchUpdateCdnConfigsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateCdnConfigsTransportSettings,
            settings.batchUpdateCdnConfigsSettings(),
            clientContext);
    this.batchActivateCdnConfigsCallable =
        callableFactory.createUnaryCallable(
            batchActivateCdnConfigsTransportSettings,
            settings.batchActivateCdnConfigsSettings(),
            clientContext);
    this.batchArchiveCdnConfigsCallable =
        callableFactory.createUnaryCallable(
            batchArchiveCdnConfigsTransportSettings,
            settings.batchArchiveCdnConfigsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getCdnConfigMethodDescriptor);
    methodDescriptors.add(listCdnConfigsMethodDescriptor);
    methodDescriptors.add(createCdnConfigMethodDescriptor);
    methodDescriptors.add(batchCreateCdnConfigsMethodDescriptor);
    methodDescriptors.add(updateCdnConfigMethodDescriptor);
    methodDescriptors.add(batchUpdateCdnConfigsMethodDescriptor);
    methodDescriptors.add(batchActivateCdnConfigsMethodDescriptor);
    methodDescriptors.add(batchArchiveCdnConfigsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetCdnConfigRequest, CdnConfig> getCdnConfigCallable() {
    return getCdnConfigCallable;
  }

  @Override
  public UnaryCallable<ListCdnConfigsRequest, ListCdnConfigsResponse> listCdnConfigsCallable() {
    return listCdnConfigsCallable;
  }

  @Override
  public UnaryCallable<ListCdnConfigsRequest, ListCdnConfigsPagedResponse>
      listCdnConfigsPagedCallable() {
    return listCdnConfigsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateCdnConfigRequest, CdnConfig> createCdnConfigCallable() {
    return createCdnConfigCallable;
  }

  @Override
  public UnaryCallable<BatchCreateCdnConfigsRequest, BatchCreateCdnConfigsResponse>
      batchCreateCdnConfigsCallable() {
    return batchCreateCdnConfigsCallable;
  }

  @Override
  public UnaryCallable<UpdateCdnConfigRequest, CdnConfig> updateCdnConfigCallable() {
    return updateCdnConfigCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateCdnConfigsRequest, BatchUpdateCdnConfigsResponse>
      batchUpdateCdnConfigsCallable() {
    return batchUpdateCdnConfigsCallable;
  }

  @Override
  public UnaryCallable<BatchActivateCdnConfigsRequest, BatchActivateCdnConfigsResponse>
      batchActivateCdnConfigsCallable() {
    return batchActivateCdnConfigsCallable;
  }

  @Override
  public UnaryCallable<BatchArchiveCdnConfigsRequest, BatchArchiveCdnConfigsResponse>
      batchArchiveCdnConfigsCallable() {
    return batchArchiveCdnConfigsCallable;
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
