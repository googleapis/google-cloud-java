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

package com.google.appengine.v1.stub;

import static com.google.appengine.v1.FirewallClient.ListIngressRulesPagedResponse;

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
import com.google.appengine.v1.BatchUpdateIngressRulesRequest;
import com.google.appengine.v1.BatchUpdateIngressRulesResponse;
import com.google.appengine.v1.CreateIngressRuleRequest;
import com.google.appengine.v1.DeleteIngressRuleRequest;
import com.google.appengine.v1.GetIngressRuleRequest;
import com.google.appengine.v1.ListIngressRulesRequest;
import com.google.appengine.v1.ListIngressRulesResponse;
import com.google.appengine.v1.UpdateIngressRuleRequest;
import com.google.appengine.v1.firewall.FirewallRule;
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
 * REST stub implementation for the Firewall service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonFirewallStub extends FirewallStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<ListIngressRulesRequest, ListIngressRulesResponse>
      listIngressRulesMethodDescriptor =
          ApiMethodDescriptor.<ListIngressRulesRequest, ListIngressRulesResponse>newBuilder()
              .setFullMethodName("google.appengine.v1.Firewall/ListIngressRules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIngressRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=apps/*}/firewall/ingressRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIngressRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIngressRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "matchingAddress", request.getMatchingAddress());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIngressRulesResponse>newBuilder()
                      .setDefaultInstance(ListIngressRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>newBuilder()
              .setFullMethodName("google.appengine.v1.Firewall/BatchUpdateIngressRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchUpdateIngressRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/firewall/ingressRules}:batchUpdate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateIngressRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchUpdateIngressRulesRequest> serializer =
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
                  ProtoMessageResponseParser.<BatchUpdateIngressRulesResponse>newBuilder()
                      .setDefaultInstance(BatchUpdateIngressRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateIngressRuleRequest, FirewallRule>
      createIngressRuleMethodDescriptor =
          ApiMethodDescriptor.<CreateIngressRuleRequest, FirewallRule>newBuilder()
              .setFullMethodName("google.appengine.v1.Firewall/CreateIngressRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIngressRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=apps/*}/firewall/ingressRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIngressRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIngressRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("rule", request.getRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallRule>newBuilder()
                      .setDefaultInstance(FirewallRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIngressRuleRequest, FirewallRule>
      getIngressRuleMethodDescriptor =
          ApiMethodDescriptor.<GetIngressRuleRequest, FirewallRule>newBuilder()
              .setFullMethodName("google.appengine.v1.Firewall/GetIngressRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIngressRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/firewall/ingressRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIngressRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIngressRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallRule>newBuilder()
                      .setDefaultInstance(FirewallRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateIngressRuleRequest, FirewallRule>
      updateIngressRuleMethodDescriptor =
          ApiMethodDescriptor.<UpdateIngressRuleRequest, FirewallRule>newBuilder()
              .setFullMethodName("google.appengine.v1.Firewall/UpdateIngressRule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateIngressRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/firewall/ingressRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIngressRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIngressRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("rule", request.getRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallRule>newBuilder()
                      .setDefaultInstance(FirewallRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteIngressRuleRequest, Empty>
      deleteIngressRuleMethodDescriptor =
          ApiMethodDescriptor.<DeleteIngressRuleRequest, Empty>newBuilder()
              .setFullMethodName("google.appengine.v1.Firewall/DeleteIngressRule")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIngressRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=apps/*/firewall/ingressRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIngressRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIngressRuleRequest> serializer =
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

  private final UnaryCallable<ListIngressRulesRequest, ListIngressRulesResponse>
      listIngressRulesCallable;
  private final UnaryCallable<ListIngressRulesRequest, ListIngressRulesPagedResponse>
      listIngressRulesPagedCallable;
  private final UnaryCallable<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesCallable;
  private final UnaryCallable<CreateIngressRuleRequest, FirewallRule> createIngressRuleCallable;
  private final UnaryCallable<GetIngressRuleRequest, FirewallRule> getIngressRuleCallable;
  private final UnaryCallable<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleCallable;
  private final UnaryCallable<DeleteIngressRuleRequest, Empty> deleteIngressRuleCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFirewallStub create(FirewallStubSettings settings)
      throws IOException {
    return new HttpJsonFirewallStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFirewallStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonFirewallStub(
        FirewallStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonFirewallStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFirewallStub(
        FirewallStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFirewallStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFirewallStub(FirewallStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonFirewallCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFirewallStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonFirewallStub(
      FirewallStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<ListIngressRulesRequest, ListIngressRulesResponse>
        listIngressRulesTransportSettings =
            HttpJsonCallSettings.<ListIngressRulesRequest, ListIngressRulesResponse>newBuilder()
                .setMethodDescriptor(listIngressRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
        batchUpdateIngressRulesTransportSettings =
            HttpJsonCallSettings
                .<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>newBuilder()
                .setMethodDescriptor(batchUpdateIngressRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreateIngressRuleRequest, FirewallRule>
        createIngressRuleTransportSettings =
            HttpJsonCallSettings.<CreateIngressRuleRequest, FirewallRule>newBuilder()
                .setMethodDescriptor(createIngressRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetIngressRuleRequest, FirewallRule> getIngressRuleTransportSettings =
        HttpJsonCallSettings.<GetIngressRuleRequest, FirewallRule>newBuilder()
            .setMethodDescriptor(getIngressRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateIngressRuleRequest, FirewallRule>
        updateIngressRuleTransportSettings =
            HttpJsonCallSettings.<UpdateIngressRuleRequest, FirewallRule>newBuilder()
                .setMethodDescriptor(updateIngressRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteIngressRuleRequest, Empty> deleteIngressRuleTransportSettings =
        HttpJsonCallSettings.<DeleteIngressRuleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIngressRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listIngressRulesCallable =
        callableFactory.createUnaryCallable(
            listIngressRulesTransportSettings, settings.listIngressRulesSettings(), clientContext);
    this.listIngressRulesPagedCallable =
        callableFactory.createPagedCallable(
            listIngressRulesTransportSettings, settings.listIngressRulesSettings(), clientContext);
    this.batchUpdateIngressRulesCallable =
        callableFactory.createUnaryCallable(
            batchUpdateIngressRulesTransportSettings,
            settings.batchUpdateIngressRulesSettings(),
            clientContext);
    this.createIngressRuleCallable =
        callableFactory.createUnaryCallable(
            createIngressRuleTransportSettings,
            settings.createIngressRuleSettings(),
            clientContext);
    this.getIngressRuleCallable =
        callableFactory.createUnaryCallable(
            getIngressRuleTransportSettings, settings.getIngressRuleSettings(), clientContext);
    this.updateIngressRuleCallable =
        callableFactory.createUnaryCallable(
            updateIngressRuleTransportSettings,
            settings.updateIngressRuleSettings(),
            clientContext);
    this.deleteIngressRuleCallable =
        callableFactory.createUnaryCallable(
            deleteIngressRuleTransportSettings,
            settings.deleteIngressRuleSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listIngressRulesMethodDescriptor);
    methodDescriptors.add(batchUpdateIngressRulesMethodDescriptor);
    methodDescriptors.add(createIngressRuleMethodDescriptor);
    methodDescriptors.add(getIngressRuleMethodDescriptor);
    methodDescriptors.add(updateIngressRuleMethodDescriptor);
    methodDescriptors.add(deleteIngressRuleMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<ListIngressRulesRequest, ListIngressRulesResponse>
      listIngressRulesCallable() {
    return listIngressRulesCallable;
  }

  @Override
  public UnaryCallable<ListIngressRulesRequest, ListIngressRulesPagedResponse>
      listIngressRulesPagedCallable() {
    return listIngressRulesPagedCallable;
  }

  @Override
  public UnaryCallable<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesCallable() {
    return batchUpdateIngressRulesCallable;
  }

  @Override
  public UnaryCallable<CreateIngressRuleRequest, FirewallRule> createIngressRuleCallable() {
    return createIngressRuleCallable;
  }

  @Override
  public UnaryCallable<GetIngressRuleRequest, FirewallRule> getIngressRuleCallable() {
    return getIngressRuleCallable;
  }

  @Override
  public UnaryCallable<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleCallable() {
    return updateIngressRuleCallable;
  }

  @Override
  public UnaryCallable<DeleteIngressRuleRequest, Empty> deleteIngressRuleCallable() {
    return deleteIngressRuleCallable;
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
