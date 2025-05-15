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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRetrohuntsPagedResponse;
import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRuleDeploymentsPagedResponse;
import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRuleRevisionsPagedResponse;
import static com.google.cloud.chronicle.v1.RuleServiceClient.ListRulesPagedResponse;

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
import com.google.cloud.chronicle.v1.CreateRetrohuntRequest;
import com.google.cloud.chronicle.v1.CreateRuleRequest;
import com.google.cloud.chronicle.v1.DeleteRuleRequest;
import com.google.cloud.chronicle.v1.GetRetrohuntRequest;
import com.google.cloud.chronicle.v1.GetRuleDeploymentRequest;
import com.google.cloud.chronicle.v1.GetRuleRequest;
import com.google.cloud.chronicle.v1.ListRetrohuntsRequest;
import com.google.cloud.chronicle.v1.ListRetrohuntsResponse;
import com.google.cloud.chronicle.v1.ListRuleDeploymentsRequest;
import com.google.cloud.chronicle.v1.ListRuleDeploymentsResponse;
import com.google.cloud.chronicle.v1.ListRuleRevisionsRequest;
import com.google.cloud.chronicle.v1.ListRuleRevisionsResponse;
import com.google.cloud.chronicle.v1.ListRulesRequest;
import com.google.cloud.chronicle.v1.ListRulesResponse;
import com.google.cloud.chronicle.v1.Retrohunt;
import com.google.cloud.chronicle.v1.RetrohuntMetadata;
import com.google.cloud.chronicle.v1.Rule;
import com.google.cloud.chronicle.v1.RuleDeployment;
import com.google.cloud.chronicle.v1.UpdateRuleDeploymentRequest;
import com.google.cloud.chronicle.v1.UpdateRuleRequest;
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
 * REST stub implementation for the RuleService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonRuleServiceStub extends RuleServiceStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(RetrohuntMetadata.getDescriptor())
          .add(Retrohunt.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateRuleRequest, Rule> createRuleMethodDescriptor =
      ApiMethodDescriptor.<CreateRuleRequest, Rule>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.RuleService/CreateRule")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateRuleRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/instances/*}/rules",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateRuleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateRuleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("rule", request.getRule(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Rule>newBuilder()
                  .setDefaultInstance(Rule.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetRuleRequest, Rule> getRuleMethodDescriptor =
      ApiMethodDescriptor.<GetRuleRequest, Rule>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.RuleService/GetRule")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRuleRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/instances/*/rules/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRuleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRuleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "view", request.getViewValue());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Rule>newBuilder()
                  .setDefaultInstance(Rule.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListRulesRequest, ListRulesResponse>
      listRulesMethodDescriptor =
          ApiMethodDescriptor.<ListRulesRequest, ListRulesResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/ListRules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*}/rules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRulesResponse>newBuilder()
                      .setDefaultInstance(ListRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRuleRequest, Rule> updateRuleMethodDescriptor =
      ApiMethodDescriptor.<UpdateRuleRequest, Rule>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.RuleService/UpdateRule")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateRuleRequest>newBuilder()
                  .setPath(
                      "/v1/{rule.name=projects/*/locations/*/instances/*/rules/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateRuleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "rule.name", request.getRule().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateRuleRequest> serializer =
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
              ProtoMessageResponseParser.<Rule>newBuilder()
                  .setDefaultInstance(Rule.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteRuleRequest, Empty> deleteRuleMethodDescriptor =
      ApiMethodDescriptor.<DeleteRuleRequest, Empty>newBuilder()
          .setFullMethodName("google.cloud.chronicle.v1.RuleService/DeleteRule")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteRuleRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/instances/*/rules/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteRuleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteRuleRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "force", request.getForce());
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

  private static final ApiMethodDescriptor<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
      listRuleRevisionsMethodDescriptor =
          ApiMethodDescriptor.<ListRuleRevisionsRequest, ListRuleRevisionsResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/ListRuleRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRuleRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/rules/*}:listRevisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuleRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuleRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRuleRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListRuleRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateRetrohuntRequest, Operation>
      createRetrohuntMethodDescriptor =
          ApiMethodDescriptor.<CreateRetrohuntRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/CreateRetrohunt")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateRetrohuntRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/rules/*}/retrohunts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRetrohuntRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateRetrohuntRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("retrohunt", request.getRetrohunt(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateRetrohuntRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetRetrohuntRequest, Retrohunt>
      getRetrohuntMethodDescriptor =
          ApiMethodDescriptor.<GetRetrohuntRequest, Retrohunt>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/GetRetrohunt")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRetrohuntRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/rules/*/retrohunts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRetrohuntRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRetrohuntRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Retrohunt>newBuilder()
                      .setDefaultInstance(Retrohunt.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRetrohuntsRequest, ListRetrohuntsResponse>
      listRetrohuntsMethodDescriptor =
          ApiMethodDescriptor.<ListRetrohuntsRequest, ListRetrohuntsResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/ListRetrohunts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRetrohuntsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/rules/*}/retrohunts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRetrohuntsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRetrohuntsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRetrohuntsResponse>newBuilder()
                      .setDefaultInstance(ListRetrohuntsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRuleDeploymentRequest, RuleDeployment>
      getRuleDeploymentMethodDescriptor =
          ApiMethodDescriptor.<GetRuleDeploymentRequest, RuleDeployment>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/GetRuleDeployment")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRuleDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/instances/*/rules/*/deployment}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RuleDeployment>newBuilder()
                      .setDefaultInstance(RuleDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
      listRuleDeploymentsMethodDescriptor =
          ApiMethodDescriptor.<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/ListRuleDeployments")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRuleDeploymentsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/instances/*/rules/*}/deployments",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuleDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRuleDeploymentsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRuleDeploymentsResponse>newBuilder()
                      .setDefaultInstance(ListRuleDeploymentsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateRuleDeploymentRequest, RuleDeployment>
      updateRuleDeploymentMethodDescriptor =
          ApiMethodDescriptor.<UpdateRuleDeploymentRequest, RuleDeployment>newBuilder()
              .setFullMethodName("google.cloud.chronicle.v1.RuleService/UpdateRuleDeployment")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateRuleDeploymentRequest>newBuilder()
                      .setPath(
                          "/v1/{ruleDeployment.name=projects/*/locations/*/instances/*/rules/*/deployment}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRuleDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "ruleDeployment.name",
                                request.getRuleDeployment().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateRuleDeploymentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("ruleDeployment", request.getRuleDeployment(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RuleDeployment>newBuilder()
                      .setDefaultInstance(RuleDeployment.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateRuleRequest, Rule> createRuleCallable;
  private final UnaryCallable<GetRuleRequest, Rule> getRuleCallable;
  private final UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable;
  private final UnaryCallable<ListRulesRequest, ListRulesPagedResponse> listRulesPagedCallable;
  private final UnaryCallable<UpdateRuleRequest, Rule> updateRuleCallable;
  private final UnaryCallable<DeleteRuleRequest, Empty> deleteRuleCallable;
  private final UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
      listRuleRevisionsCallable;
  private final UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsPagedResponse>
      listRuleRevisionsPagedCallable;
  private final UnaryCallable<CreateRetrohuntRequest, Operation> createRetrohuntCallable;
  private final OperationCallable<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
      createRetrohuntOperationCallable;
  private final UnaryCallable<GetRetrohuntRequest, Retrohunt> getRetrohuntCallable;
  private final UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsResponse> listRetrohuntsCallable;
  private final UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsPagedResponse>
      listRetrohuntsPagedCallable;
  private final UnaryCallable<GetRuleDeploymentRequest, RuleDeployment> getRuleDeploymentCallable;
  private final UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
      listRuleDeploymentsCallable;
  private final UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsPagedResponse>
      listRuleDeploymentsPagedCallable;
  private final UnaryCallable<UpdateRuleDeploymentRequest, RuleDeployment>
      updateRuleDeploymentCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRuleServiceStub create(RuleServiceStubSettings settings)
      throws IOException {
    return new HttpJsonRuleServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRuleServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRuleServiceStub(
        RuleServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonRuleServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRuleServiceStub(
        RuleServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRuleServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRuleServiceStub(RuleServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRuleServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRuleServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRuleServiceStub(
      RuleServiceStubSettings settings,
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
                        .setPost(
                            "/v1/{name=projects/*/locations/*/instances/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/instances/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/instances/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/instances/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<CreateRuleRequest, Rule> createRuleTransportSettings =
        HttpJsonCallSettings.<CreateRuleRequest, Rule>newBuilder()
            .setMethodDescriptor(createRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRuleRequest, Rule> getRuleTransportSettings =
        HttpJsonCallSettings.<GetRuleRequest, Rule>newBuilder()
            .setMethodDescriptor(getRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRulesRequest, ListRulesResponse> listRulesTransportSettings =
        HttpJsonCallSettings.<ListRulesRequest, ListRulesResponse>newBuilder()
            .setMethodDescriptor(listRulesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateRuleRequest, Rule> updateRuleTransportSettings =
        HttpJsonCallSettings.<UpdateRuleRequest, Rule>newBuilder()
            .setMethodDescriptor(updateRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("rule.name", String.valueOf(request.getRule().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRuleRequest, Empty> deleteRuleTransportSettings =
        HttpJsonCallSettings.<DeleteRuleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
        listRuleRevisionsTransportSettings =
            HttpJsonCallSettings.<ListRuleRevisionsRequest, ListRuleRevisionsResponse>newBuilder()
                .setMethodDescriptor(listRuleRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateRetrohuntRequest, Operation> createRetrohuntTransportSettings =
        HttpJsonCallSettings.<CreateRetrohuntRequest, Operation>newBuilder()
            .setMethodDescriptor(createRetrohuntMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRetrohuntRequest, Retrohunt> getRetrohuntTransportSettings =
        HttpJsonCallSettings.<GetRetrohuntRequest, Retrohunt>newBuilder()
            .setMethodDescriptor(getRetrohuntMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRetrohuntsRequest, ListRetrohuntsResponse>
        listRetrohuntsTransportSettings =
            HttpJsonCallSettings.<ListRetrohuntsRequest, ListRetrohuntsResponse>newBuilder()
                .setMethodDescriptor(listRetrohuntsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRuleDeploymentRequest, RuleDeployment>
        getRuleDeploymentTransportSettings =
            HttpJsonCallSettings.<GetRuleDeploymentRequest, RuleDeployment>newBuilder()
                .setMethodDescriptor(getRuleDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
        listRuleDeploymentsTransportSettings =
            HttpJsonCallSettings
                .<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>newBuilder()
                .setMethodDescriptor(listRuleDeploymentsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateRuleDeploymentRequest, RuleDeployment>
        updateRuleDeploymentTransportSettings =
            HttpJsonCallSettings.<UpdateRuleDeploymentRequest, RuleDeployment>newBuilder()
                .setMethodDescriptor(updateRuleDeploymentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "rule_deployment.name",
                          String.valueOf(request.getRuleDeployment().getName()));
                      return builder.build();
                    })
                .build();

    this.createRuleCallable =
        callableFactory.createUnaryCallable(
            createRuleTransportSettings, settings.createRuleSettings(), clientContext);
    this.getRuleCallable =
        callableFactory.createUnaryCallable(
            getRuleTransportSettings, settings.getRuleSettings(), clientContext);
    this.listRulesCallable =
        callableFactory.createUnaryCallable(
            listRulesTransportSettings, settings.listRulesSettings(), clientContext);
    this.listRulesPagedCallable =
        callableFactory.createPagedCallable(
            listRulesTransportSettings, settings.listRulesSettings(), clientContext);
    this.updateRuleCallable =
        callableFactory.createUnaryCallable(
            updateRuleTransportSettings, settings.updateRuleSettings(), clientContext);
    this.deleteRuleCallable =
        callableFactory.createUnaryCallable(
            deleteRuleTransportSettings, settings.deleteRuleSettings(), clientContext);
    this.listRuleRevisionsCallable =
        callableFactory.createUnaryCallable(
            listRuleRevisionsTransportSettings,
            settings.listRuleRevisionsSettings(),
            clientContext);
    this.listRuleRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listRuleRevisionsTransportSettings,
            settings.listRuleRevisionsSettings(),
            clientContext);
    this.createRetrohuntCallable =
        callableFactory.createUnaryCallable(
            createRetrohuntTransportSettings, settings.createRetrohuntSettings(), clientContext);
    this.createRetrohuntOperationCallable =
        callableFactory.createOperationCallable(
            createRetrohuntTransportSettings,
            settings.createRetrohuntOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getRetrohuntCallable =
        callableFactory.createUnaryCallable(
            getRetrohuntTransportSettings, settings.getRetrohuntSettings(), clientContext);
    this.listRetrohuntsCallable =
        callableFactory.createUnaryCallable(
            listRetrohuntsTransportSettings, settings.listRetrohuntsSettings(), clientContext);
    this.listRetrohuntsPagedCallable =
        callableFactory.createPagedCallable(
            listRetrohuntsTransportSettings, settings.listRetrohuntsSettings(), clientContext);
    this.getRuleDeploymentCallable =
        callableFactory.createUnaryCallable(
            getRuleDeploymentTransportSettings,
            settings.getRuleDeploymentSettings(),
            clientContext);
    this.listRuleDeploymentsCallable =
        callableFactory.createUnaryCallable(
            listRuleDeploymentsTransportSettings,
            settings.listRuleDeploymentsSettings(),
            clientContext);
    this.listRuleDeploymentsPagedCallable =
        callableFactory.createPagedCallable(
            listRuleDeploymentsTransportSettings,
            settings.listRuleDeploymentsSettings(),
            clientContext);
    this.updateRuleDeploymentCallable =
        callableFactory.createUnaryCallable(
            updateRuleDeploymentTransportSettings,
            settings.updateRuleDeploymentSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createRuleMethodDescriptor);
    methodDescriptors.add(getRuleMethodDescriptor);
    methodDescriptors.add(listRulesMethodDescriptor);
    methodDescriptors.add(updateRuleMethodDescriptor);
    methodDescriptors.add(deleteRuleMethodDescriptor);
    methodDescriptors.add(listRuleRevisionsMethodDescriptor);
    methodDescriptors.add(createRetrohuntMethodDescriptor);
    methodDescriptors.add(getRetrohuntMethodDescriptor);
    methodDescriptors.add(listRetrohuntsMethodDescriptor);
    methodDescriptors.add(getRuleDeploymentMethodDescriptor);
    methodDescriptors.add(listRuleDeploymentsMethodDescriptor);
    methodDescriptors.add(updateRuleDeploymentMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<CreateRuleRequest, Rule> createRuleCallable() {
    return createRuleCallable;
  }

  @Override
  public UnaryCallable<GetRuleRequest, Rule> getRuleCallable() {
    return getRuleCallable;
  }

  @Override
  public UnaryCallable<ListRulesRequest, ListRulesResponse> listRulesCallable() {
    return listRulesCallable;
  }

  @Override
  public UnaryCallable<ListRulesRequest, ListRulesPagedResponse> listRulesPagedCallable() {
    return listRulesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateRuleRequest, Rule> updateRuleCallable() {
    return updateRuleCallable;
  }

  @Override
  public UnaryCallable<DeleteRuleRequest, Empty> deleteRuleCallable() {
    return deleteRuleCallable;
  }

  @Override
  public UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsResponse>
      listRuleRevisionsCallable() {
    return listRuleRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListRuleRevisionsRequest, ListRuleRevisionsPagedResponse>
      listRuleRevisionsPagedCallable() {
    return listRuleRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateRetrohuntRequest, Operation> createRetrohuntCallable() {
    return createRetrohuntCallable;
  }

  @Override
  public OperationCallable<CreateRetrohuntRequest, Retrohunt, RetrohuntMetadata>
      createRetrohuntOperationCallable() {
    return createRetrohuntOperationCallable;
  }

  @Override
  public UnaryCallable<GetRetrohuntRequest, Retrohunt> getRetrohuntCallable() {
    return getRetrohuntCallable;
  }

  @Override
  public UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsResponse> listRetrohuntsCallable() {
    return listRetrohuntsCallable;
  }

  @Override
  public UnaryCallable<ListRetrohuntsRequest, ListRetrohuntsPagedResponse>
      listRetrohuntsPagedCallable() {
    return listRetrohuntsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRuleDeploymentRequest, RuleDeployment> getRuleDeploymentCallable() {
    return getRuleDeploymentCallable;
  }

  @Override
  public UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsResponse>
      listRuleDeploymentsCallable() {
    return listRuleDeploymentsCallable;
  }

  @Override
  public UnaryCallable<ListRuleDeploymentsRequest, ListRuleDeploymentsPagedResponse>
      listRuleDeploymentsPagedCallable() {
    return listRuleDeploymentsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateRuleDeploymentRequest, RuleDeployment> updateRuleDeploymentCallable() {
    return updateRuleDeploymentCallable;
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
