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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.RuleSetServiceClient.ListRuleSetsPagedResponse;

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
import com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest;
import com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest;
import com.google.cloud.contentwarehouse.v1.GetRuleSetRequest;
import com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest;
import com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse;
import com.google.cloud.contentwarehouse.v1.RuleSet;
import com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest;
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
 * REST stub implementation for the RuleSetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRuleSetServiceStub extends RuleSetServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateRuleSetRequest, RuleSet>
      createRuleSetMethodDescriptor =
          ApiMethodDescriptor.<CreateRuleSetRequest, RuleSet>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/CreateRuleSet")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRuleSetRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/ruleSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRuleSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRuleSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("ruleSet", request.getRuleSet(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RuleSet>newBuilder()
                      .setDefaultInstance(RuleSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRuleSetRequest, RuleSet> getRuleSetMethodDescriptor =
      ApiMethodDescriptor.<GetRuleSetRequest, RuleSet>newBuilder()
          .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/GetRuleSet")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRuleSetRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/ruleSets/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRuleSetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRuleSetRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<RuleSet>newBuilder()
                  .setDefaultInstance(RuleSet.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateRuleSetRequest, RuleSet>
      updateRuleSetMethodDescriptor =
          ApiMethodDescriptor.<UpdateRuleSetRequest, RuleSet>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/UpdateRuleSet")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRuleSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/ruleSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRuleSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRuleSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RuleSet>newBuilder()
                      .setDefaultInstance(RuleSet.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRuleSetRequest, Empty>
      deleteRuleSetMethodDescriptor =
          ApiMethodDescriptor.<DeleteRuleSetRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/DeleteRuleSet")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRuleSetRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/ruleSets/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRuleSetRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRuleSetRequest> serializer =
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

  private static final ApiMethodDescriptor<ListRuleSetsRequest, ListRuleSetsResponse>
      listRuleSetsMethodDescriptor =
          ApiMethodDescriptor.<ListRuleSetsRequest, ListRuleSetsResponse>newBuilder()
              .setFullMethodName("google.cloud.contentwarehouse.v1.RuleSetService/ListRuleSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRuleSetsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/ruleSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuleSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuleSetsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRuleSetsResponse>newBuilder()
                      .setDefaultInstance(ListRuleSetsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateRuleSetRequest, RuleSet> createRuleSetCallable;
  private final UnaryCallable<GetRuleSetRequest, RuleSet> getRuleSetCallable;
  private final UnaryCallable<UpdateRuleSetRequest, RuleSet> updateRuleSetCallable;
  private final UnaryCallable<DeleteRuleSetRequest, Empty> deleteRuleSetCallable;
  private final UnaryCallable<ListRuleSetsRequest, ListRuleSetsResponse> listRuleSetsCallable;
  private final UnaryCallable<ListRuleSetsRequest, ListRuleSetsPagedResponse>
      listRuleSetsPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRuleSetServiceStub create(RuleSetServiceStubSettings settings)
      throws IOException {
    return new HttpJsonRuleSetServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRuleSetServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRuleSetServiceStub(
        RuleSetServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRuleSetServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRuleSetServiceStub(
        RuleSetServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRuleSetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRuleSetServiceStub(
      RuleSetServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRuleSetServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRuleSetServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRuleSetServiceStub(
      RuleSetServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateRuleSetRequest, RuleSet> createRuleSetTransportSettings =
        HttpJsonCallSettings.<CreateRuleSetRequest, RuleSet>newBuilder()
            .setMethodDescriptor(createRuleSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetRuleSetRequest, RuleSet> getRuleSetTransportSettings =
        HttpJsonCallSettings.<GetRuleSetRequest, RuleSet>newBuilder()
            .setMethodDescriptor(getRuleSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateRuleSetRequest, RuleSet> updateRuleSetTransportSettings =
        HttpJsonCallSettings.<UpdateRuleSetRequest, RuleSet>newBuilder()
            .setMethodDescriptor(updateRuleSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteRuleSetRequest, Empty> deleteRuleSetTransportSettings =
        HttpJsonCallSettings.<DeleteRuleSetRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRuleSetMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListRuleSetsRequest, ListRuleSetsResponse> listRuleSetsTransportSettings =
        HttpJsonCallSettings.<ListRuleSetsRequest, ListRuleSetsResponse>newBuilder()
            .setMethodDescriptor(listRuleSetsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.createRuleSetCallable =
        callableFactory.createUnaryCallable(
            createRuleSetTransportSettings, settings.createRuleSetSettings(), clientContext);
    this.getRuleSetCallable =
        callableFactory.createUnaryCallable(
            getRuleSetTransportSettings, settings.getRuleSetSettings(), clientContext);
    this.updateRuleSetCallable =
        callableFactory.createUnaryCallable(
            updateRuleSetTransportSettings, settings.updateRuleSetSettings(), clientContext);
    this.deleteRuleSetCallable =
        callableFactory.createUnaryCallable(
            deleteRuleSetTransportSettings, settings.deleteRuleSetSettings(), clientContext);
    this.listRuleSetsCallable =
        callableFactory.createUnaryCallable(
            listRuleSetsTransportSettings, settings.listRuleSetsSettings(), clientContext);
    this.listRuleSetsPagedCallable =
        callableFactory.createPagedCallable(
            listRuleSetsTransportSettings, settings.listRuleSetsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createRuleSetMethodDescriptor);
    methodDescriptors.add(getRuleSetMethodDescriptor);
    methodDescriptors.add(updateRuleSetMethodDescriptor);
    methodDescriptors.add(deleteRuleSetMethodDescriptor);
    methodDescriptors.add(listRuleSetsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateRuleSetRequest, RuleSet> createRuleSetCallable() {
    return createRuleSetCallable;
  }

  @Override
  public UnaryCallable<GetRuleSetRequest, RuleSet> getRuleSetCallable() {
    return getRuleSetCallable;
  }

  @Override
  public UnaryCallable<UpdateRuleSetRequest, RuleSet> updateRuleSetCallable() {
    return updateRuleSetCallable;
  }

  @Override
  public UnaryCallable<DeleteRuleSetRequest, Empty> deleteRuleSetCallable() {
    return deleteRuleSetCallable;
  }

  @Override
  public UnaryCallable<ListRuleSetsRequest, ListRuleSetsResponse> listRuleSetsCallable() {
    return listRuleSetsCallable;
  }

  @Override
  public UnaryCallable<ListRuleSetsRequest, ListRuleSetsPagedResponse> listRuleSetsPagedCallable() {
    return listRuleSetsPagedCallable;
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
