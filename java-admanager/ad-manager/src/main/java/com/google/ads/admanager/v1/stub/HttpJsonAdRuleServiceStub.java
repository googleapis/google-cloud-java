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

import static com.google.ads.admanager.v1.AdRuleServiceClient.ListAdRulesPagedResponse;

import com.google.ads.admanager.v1.AdRule;
import com.google.ads.admanager.v1.BatchActivateAdRulesRequest;
import com.google.ads.admanager.v1.BatchActivateAdRulesResponse;
import com.google.ads.admanager.v1.BatchCreateAdRulesRequest;
import com.google.ads.admanager.v1.BatchCreateAdRulesResponse;
import com.google.ads.admanager.v1.BatchDeactivateAdRulesRequest;
import com.google.ads.admanager.v1.BatchDeactivateAdRulesResponse;
import com.google.ads.admanager.v1.BatchDeleteAdRulesRequest;
import com.google.ads.admanager.v1.BatchUpdateAdRulesRequest;
import com.google.ads.admanager.v1.BatchUpdateAdRulesResponse;
import com.google.ads.admanager.v1.CreateAdRuleRequest;
import com.google.ads.admanager.v1.GetAdRuleRequest;
import com.google.ads.admanager.v1.ListAdRulesRequest;
import com.google.ads.admanager.v1.ListAdRulesResponse;
import com.google.ads.admanager.v1.UpdateAdRuleRequest;
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
import com.google.protobuf.Empty;
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
 * REST stub implementation for the AdRuleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class HttpJsonAdRuleServiceStub extends AdRuleServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetAdRuleRequest, AdRule> getAdRuleMethodDescriptor =
      ApiMethodDescriptor.<GetAdRuleRequest, AdRule>newBuilder()
          .setFullMethodName("google.ads.admanager.v1.AdRuleService/GetAdRule")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetAdRuleRequest>newBuilder()
                  .setPath(
                      "/v1/{name=networks/*/adRules/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdRuleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetAdRuleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<AdRule>newBuilder()
                  .setDefaultInstance(AdRule.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListAdRulesRequest, ListAdRulesResponse>
      listAdRulesMethodDescriptor =
          ApiMethodDescriptor.<ListAdRulesRequest, ListAdRulesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdRuleService/ListAdRules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAdRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAdRulesRequest> serializer =
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
                  ProtoMessageResponseParser.<ListAdRulesResponse>newBuilder()
                      .setDefaultInstance(ListAdRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAdRuleRequest, AdRule>
      createAdRuleMethodDescriptor =
          ApiMethodDescriptor.<CreateAdRuleRequest, AdRule>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdRuleService/CreateAdRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAdRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAdRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("adRule", request.getAdRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdRule>newBuilder()
                      .setDefaultInstance(AdRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
      batchCreateAdRulesMethodDescriptor =
          ApiMethodDescriptor.<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdRuleService/BatchCreateAdRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchCreateAdRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adRules:batchCreate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateAdRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchCreateAdRulesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchCreateAdRulesResponse>newBuilder()
                      .setDefaultInstance(BatchCreateAdRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAdRuleRequest, AdRule>
      updateAdRuleMethodDescriptor =
          ApiMethodDescriptor.<UpdateAdRuleRequest, AdRule>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdRuleService/UpdateAdRule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAdRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{adRule.name=networks/*/adRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "adRule.name", request.getAdRule().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAdRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("adRule", request.getAdRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AdRule>newBuilder()
                      .setDefaultInstance(AdRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
      batchUpdateAdRulesMethodDescriptor =
          ApiMethodDescriptor.<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdRuleService/BatchUpdateAdRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateAdRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adRules:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAdRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateAdRulesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateAdRulesResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateAdRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
      batchActivateAdRulesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdRuleService/BatchActivateAdRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchActivateAdRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adRules:batchActivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateAdRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchActivateAdRulesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchActivateAdRulesResponse>newBuilder()
                      .setDefaultInstance(BatchActivateAdRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
      batchDeactivateAdRulesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdRuleService/BatchDeactivateAdRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeactivateAdRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adRules:batchDeactivate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateAdRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeactivateAdRulesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchDeactivateAdRulesResponse>newBuilder()
                      .setDefaultInstance(BatchDeactivateAdRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchDeleteAdRulesRequest, Empty>
      batchDeleteAdRulesMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteAdRulesRequest, Empty>newBuilder()
              .setFullMethodName("google.ads.admanager.v1.AdRuleService/BatchDeleteAdRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteAdRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=networks/*}/adRules:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteAdRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteAdRulesRequest> serializer =
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
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetAdRuleRequest, AdRule> getAdRuleCallable;
  private final UnaryCallable<ListAdRulesRequest, ListAdRulesResponse> listAdRulesCallable;
  private final UnaryCallable<ListAdRulesRequest, ListAdRulesPagedResponse>
      listAdRulesPagedCallable;
  private final UnaryCallable<CreateAdRuleRequest, AdRule> createAdRuleCallable;
  private final UnaryCallable<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
      batchCreateAdRulesCallable;
  private final UnaryCallable<UpdateAdRuleRequest, AdRule> updateAdRuleCallable;
  private final UnaryCallable<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
      batchUpdateAdRulesCallable;
  private final UnaryCallable<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
      batchActivateAdRulesCallable;
  private final UnaryCallable<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
      batchDeactivateAdRulesCallable;
  private final UnaryCallable<BatchDeleteAdRulesRequest, Empty> batchDeleteAdRulesCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAdRuleServiceStub create(AdRuleServiceStubSettings settings)
      throws IOException {
    return new HttpJsonAdRuleServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAdRuleServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAdRuleServiceStub(
        AdRuleServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAdRuleServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAdRuleServiceStub(
        AdRuleServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAdRuleServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdRuleServiceStub(
      AdRuleServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAdRuleServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAdRuleServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAdRuleServiceStub(
      AdRuleServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetAdRuleRequest, AdRule> getAdRuleTransportSettings =
        HttpJsonCallSettings.<GetAdRuleRequest, AdRule>newBuilder()
            .setMethodDescriptor(getAdRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getName())
            .build();
    HttpJsonCallSettings<ListAdRulesRequest, ListAdRulesResponse> listAdRulesTransportSettings =
        HttpJsonCallSettings.<ListAdRulesRequest, ListAdRulesResponse>newBuilder()
            .setMethodDescriptor(listAdRulesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<CreateAdRuleRequest, AdRule> createAdRuleTransportSettings =
        HttpJsonCallSettings.<CreateAdRuleRequest, AdRule>newBuilder()
            .setMethodDescriptor(createAdRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();
    HttpJsonCallSettings<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
        batchCreateAdRulesTransportSettings =
            HttpJsonCallSettings.<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>newBuilder()
                .setMethodDescriptor(batchCreateAdRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<UpdateAdRuleRequest, AdRule> updateAdRuleTransportSettings =
        HttpJsonCallSettings.<UpdateAdRuleRequest, AdRule>newBuilder()
            .setMethodDescriptor(updateAdRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("ad_rule.name", String.valueOf(request.getAdRule().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
        batchUpdateAdRulesTransportSettings =
            HttpJsonCallSettings.<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>newBuilder()
                .setMethodDescriptor(batchUpdateAdRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
        batchActivateAdRulesTransportSettings =
            HttpJsonCallSettings
                .<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>newBuilder()
                .setMethodDescriptor(batchActivateAdRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
        batchDeactivateAdRulesTransportSettings =
            HttpJsonCallSettings
                .<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>newBuilder()
                .setMethodDescriptor(batchDeactivateAdRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .setResourceNameExtractor(request -> request.getParent())
                .build();
    HttpJsonCallSettings<BatchDeleteAdRulesRequest, Empty> batchDeleteAdRulesTransportSettings =
        HttpJsonCallSettings.<BatchDeleteAdRulesRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteAdRulesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .setResourceNameExtractor(request -> request.getParent())
            .build();

    this.getAdRuleCallable =
        callableFactory.createUnaryCallable(
            getAdRuleTransportSettings, settings.getAdRuleSettings(), clientContext);
    this.listAdRulesCallable =
        callableFactory.createUnaryCallable(
            listAdRulesTransportSettings, settings.listAdRulesSettings(), clientContext);
    this.listAdRulesPagedCallable =
        callableFactory.createPagedCallable(
            listAdRulesTransportSettings, settings.listAdRulesSettings(), clientContext);
    this.createAdRuleCallable =
        callableFactory.createUnaryCallable(
            createAdRuleTransportSettings, settings.createAdRuleSettings(), clientContext);
    this.batchCreateAdRulesCallable =
        callableFactory.createUnaryCallable(
            batchCreateAdRulesTransportSettings,
            settings.batchCreateAdRulesSettings(),
            clientContext);
    this.updateAdRuleCallable =
        callableFactory.createUnaryCallable(
            updateAdRuleTransportSettings, settings.updateAdRuleSettings(), clientContext);
    this.batchUpdateAdRulesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateAdRulesTransportSettings,
            settings.batchUpdateAdRulesSettings(),
            clientContext);
    this.batchActivateAdRulesCallable =
        callableFactory.createUnaryCallable(
            batchActivateAdRulesTransportSettings,
            settings.batchActivateAdRulesSettings(),
            clientContext);
    this.batchDeactivateAdRulesCallable =
        callableFactory.createUnaryCallable(
            batchDeactivateAdRulesTransportSettings,
            settings.batchDeactivateAdRulesSettings(),
            clientContext);
    this.batchDeleteAdRulesCallable =
        callableFactory.createUnaryCallable(
            batchDeleteAdRulesTransportSettings,
            settings.batchDeleteAdRulesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getAdRuleMethodDescriptor);
    methodDescriptors.add(listAdRulesMethodDescriptor);
    methodDescriptors.add(createAdRuleMethodDescriptor);
    methodDescriptors.add(batchCreateAdRulesMethodDescriptor);
    methodDescriptors.add(updateAdRuleMethodDescriptor);
    methodDescriptors.add(batchUpdateAdRulesMethodDescriptor);
    methodDescriptors.add(batchActivateAdRulesMethodDescriptor);
    methodDescriptors.add(batchDeactivateAdRulesMethodDescriptor);
    methodDescriptors.add(batchDeleteAdRulesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetAdRuleRequest, AdRule> getAdRuleCallable() {
    return getAdRuleCallable;
  }

  @Override
  public UnaryCallable<ListAdRulesRequest, ListAdRulesResponse> listAdRulesCallable() {
    return listAdRulesCallable;
  }

  @Override
  public UnaryCallable<ListAdRulesRequest, ListAdRulesPagedResponse> listAdRulesPagedCallable() {
    return listAdRulesPagedCallable;
  }

  @Override
  public UnaryCallable<CreateAdRuleRequest, AdRule> createAdRuleCallable() {
    return createAdRuleCallable;
  }

  @Override
  public UnaryCallable<BatchCreateAdRulesRequest, BatchCreateAdRulesResponse>
      batchCreateAdRulesCallable() {
    return batchCreateAdRulesCallable;
  }

  @Override
  public UnaryCallable<UpdateAdRuleRequest, AdRule> updateAdRuleCallable() {
    return updateAdRuleCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateAdRulesRequest, BatchUpdateAdRulesResponse>
      batchUpdateAdRulesCallable() {
    return batchUpdateAdRulesCallable;
  }

  @Override
  public UnaryCallable<BatchActivateAdRulesRequest, BatchActivateAdRulesResponse>
      batchActivateAdRulesCallable() {
    return batchActivateAdRulesCallable;
  }

  @Override
  public UnaryCallable<BatchDeactivateAdRulesRequest, BatchDeactivateAdRulesResponse>
      batchDeactivateAdRulesCallable() {
    return batchDeactivateAdRulesCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteAdRulesRequest, Empty> batchDeleteAdRulesCallable() {
    return batchDeleteAdRulesCallable;
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
