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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.SecurityPoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.SecurityPoliciesClient.ListPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.AggregatedListSecurityPoliciesRequest;
import com.google.cloud.compute.v1.DeleteSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetSecurityPolicyRequest;
import com.google.cloud.compute.v1.InsertSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListPreconfiguredExpressionSetsSecurityPoliciesRequest;
import com.google.cloud.compute.v1.ListSecurityPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.PatchSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.SecurityPoliciesAggregatedList;
import com.google.cloud.compute.v1.SecurityPoliciesListPreconfiguredExpressionSetsResponse;
import com.google.cloud.compute.v1.SecurityPolicy;
import com.google.cloud.compute.v1.SecurityPolicyList;
import com.google.cloud.compute.v1.SecurityPolicyRule;
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
 * REST stub implementation for the SecurityPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonSecurityPoliciesStub extends SecurityPoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddRuleSecurityPolicyRequest, Operation>
      addRuleMethodDescriptor =
          ApiMethodDescriptor.<AddRuleSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/AddRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddRuleSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}/addRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasValidateOnly()) {
                              serializer.putQueryParam(
                                  fields, "validateOnly", request.getValidateOnly());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "securityPolicyRuleResource",
                                      request.getSecurityPolicyRuleResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddRuleSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<
          AggregatedListSecurityPoliciesRequest, SecurityPoliciesAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListSecurityPoliciesRequest, SecurityPoliciesAggregatedList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AggregatedListSecurityPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/securityPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListSecurityPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListSecurityPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasIncludeAllScopes()) {
                              serializer.putQueryParam(
                                  fields, "includeAllScopes", request.getIncludeAllScopes());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityPoliciesAggregatedList>newBuilder()
                      .setDefaultInstance(SecurityPoliciesAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSecurityPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
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
                  (DeleteSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetSecurityPolicyRequest, SecurityPolicy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetSecurityPolicyRequest, SecurityPolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityPolicy>newBuilder()
                      .setDefaultInstance(SecurityPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRuleSecurityPolicyRequest, SecurityPolicyRule>
      getRuleMethodDescriptor =
          ApiMethodDescriptor.<GetRuleSecurityPolicyRequest, SecurityPolicyRule>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/GetRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRuleSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}/getRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityPolicyRule>newBuilder()
                      .setDefaultInstance(SecurityPolicyRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertSecurityPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasValidateOnly()) {
                              serializer.putQueryParam(
                                  fields, "validateOnly", request.getValidateOnly());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "securityPolicyResource",
                                      request.getSecurityPolicyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<ListSecurityPoliciesRequest, SecurityPolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListSecurityPoliciesRequest, SecurityPolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSecurityPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecurityPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecurityPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityPolicyList>newBuilder()
                      .setDefaultInstance(SecurityPolicyList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
                  SecurityPoliciesListPreconfiguredExpressionSetsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.SecurityPolicies/ListPreconfiguredExpressionSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPreconfiguredExpressionSetsSecurityPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/listPreconfiguredExpressionSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListPreconfiguredExpressionSetsSecurityPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListPreconfiguredExpressionSetsSecurityPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasFilter()) {
                              serializer.putQueryParam(fields, "filter", request.getFilter());
                            }
                            if (request.hasMaxResults()) {
                              serializer.putQueryParam(
                                  fields, "maxResults", request.getMaxResults());
                            }
                            if (request.hasOrderBy()) {
                              serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            }
                            if (request.hasPageToken()) {
                              serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            }
                            if (request.hasReturnPartialSuccess()) {
                              serializer.putQueryParam(
                                  fields,
                                  "returnPartialSuccess",
                                  request.getReturnPartialSuccess());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<SecurityPoliciesListPreconfiguredExpressionSetsResponse>newBuilder()
                      .setDefaultInstance(
                          SecurityPoliciesListPreconfiguredExpressionSetsResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchSecurityPolicyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "securityPolicyResource",
                                      request.getSecurityPolicyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<PatchRuleSecurityPolicyRequest, Operation>
      patchRuleMethodDescriptor =
          ApiMethodDescriptor.<PatchRuleSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/PatchRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRuleSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}/patchRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
                            if (request.hasValidateOnly()) {
                              serializer.putQueryParam(
                                  fields, "validateOnly", request.getValidateOnly());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "securityPolicyRuleResource",
                                      request.getSecurityPolicyRuleResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchRuleSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<RemoveRuleSecurityPolicyRequest, Operation>
      removeRuleMethodDescriptor =
          ApiMethodDescriptor.<RemoveRuleSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/RemoveRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveRuleSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}/removeRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
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
                  (RemoveRuleSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<AddRuleSecurityPolicyRequest, Operation> addRuleCallable;
  private final OperationCallable<AddRuleSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable;
  private final UnaryCallable<AggregatedListSecurityPoliciesRequest, SecurityPoliciesAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<AggregatedListSecurityPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<DeleteSecurityPolicyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteSecurityPolicyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetSecurityPolicyRequest, SecurityPolicy> getCallable;
  private final UnaryCallable<GetRuleSecurityPolicyRequest, SecurityPolicyRule> getRuleCallable;
  private final UnaryCallable<InsertSecurityPolicyRequest, Operation> insertCallable;
  private final OperationCallable<InsertSecurityPolicyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListSecurityPoliciesRequest, SecurityPolicyList> listCallable;
  private final UnaryCallable<ListSecurityPoliciesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable;
  private final UnaryCallable<PatchSecurityPolicyRequest, Operation> patchCallable;
  private final OperationCallable<PatchSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<PatchRuleSecurityPolicyRequest, Operation> patchRuleCallable;
  private final OperationCallable<PatchRuleSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable;
  private final UnaryCallable<RemoveRuleSecurityPolicyRequest, Operation> removeRuleCallable;
  private final OperationCallable<RemoveRuleSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSecurityPoliciesStub create(SecurityPoliciesStubSettings settings)
      throws IOException {
    return new HttpJsonSecurityPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSecurityPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSecurityPoliciesStub(
        SecurityPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSecurityPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSecurityPoliciesStub(
        SecurityPoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSecurityPoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityPoliciesStub(
      SecurityPoliciesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSecurityPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSecurityPoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityPoliciesStub(
      SecurityPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddRuleSecurityPolicyRequest, Operation> addRuleTransportSettings =
        HttpJsonCallSettings.<AddRuleSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(addRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AggregatedListSecurityPoliciesRequest, SecurityPoliciesAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListSecurityPoliciesRequest, SecurityPoliciesAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteSecurityPolicyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetSecurityPolicyRequest, SecurityPolicy> getTransportSettings =
        HttpJsonCallSettings.<GetSecurityPolicyRequest, SecurityPolicy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetRuleSecurityPolicyRequest, SecurityPolicyRule>
        getRuleTransportSettings =
            HttpJsonCallSettings.<GetRuleSecurityPolicyRequest, SecurityPolicyRule>newBuilder()
                .setMethodDescriptor(getRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertSecurityPolicyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListSecurityPoliciesRequest, SecurityPolicyList> listTransportSettings =
        HttpJsonCallSettings.<ListSecurityPoliciesRequest, SecurityPolicyList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<
            ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
            SecurityPoliciesListPreconfiguredExpressionSetsResponse>
        listPreconfiguredExpressionSetsTransportSettings =
            HttpJsonCallSettings
                .<ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
                    SecurityPoliciesListPreconfiguredExpressionSetsResponse>
                    newBuilder()
                .setMethodDescriptor(listPreconfiguredExpressionSetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchSecurityPolicyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<PatchRuleSecurityPolicyRequest, Operation> patchRuleTransportSettings =
        HttpJsonCallSettings.<PatchRuleSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RemoveRuleSecurityPolicyRequest, Operation> removeRuleTransportSettings =
        HttpJsonCallSettings.<RemoveRuleSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(removeRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.addRuleCallable =
        callableFactory.createUnaryCallable(
            addRuleTransportSettings, settings.addRuleSettings(), clientContext);
    this.addRuleOperationCallable =
        callableFactory.createOperationCallable(
            addRuleTransportSettings,
            settings.addRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.aggregatedListCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.aggregatedListPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTransportSettings, settings.aggregatedListSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.deleteOperationCallable =
        callableFactory.createOperationCallable(
            deleteTransportSettings,
            settings.deleteOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getRuleCallable =
        callableFactory.createUnaryCallable(
            getRuleTransportSettings, settings.getRuleSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.insertOperationCallable =
        callableFactory.createOperationCallable(
            insertTransportSettings,
            settings.insertOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPreconfiguredExpressionSetsCallable =
        callableFactory.createUnaryCallable(
            listPreconfiguredExpressionSetsTransportSettings,
            settings.listPreconfiguredExpressionSetsSettings(),
            clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.patchRuleCallable =
        callableFactory.createUnaryCallable(
            patchRuleTransportSettings, settings.patchRuleSettings(), clientContext);
    this.patchRuleOperationCallable =
        callableFactory.createOperationCallable(
            patchRuleTransportSettings,
            settings.patchRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removeRuleCallable =
        callableFactory.createUnaryCallable(
            removeRuleTransportSettings, settings.removeRuleSettings(), clientContext);
    this.removeRuleOperationCallable =
        callableFactory.createOperationCallable(
            removeRuleTransportSettings,
            settings.removeRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addRuleMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getRuleMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listPreconfiguredExpressionSetsMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(patchRuleMethodDescriptor);
    methodDescriptors.add(removeRuleMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddRuleSecurityPolicyRequest, Operation> addRuleCallable() {
    return addRuleCallable;
  }

  @Override
  public OperationCallable<AddRuleSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    return addRuleOperationCallable;
  }

  @Override
  public UnaryCallable<AggregatedListSecurityPoliciesRequest, SecurityPoliciesAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListSecurityPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteSecurityPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteSecurityPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetSecurityPolicyRequest, SecurityPolicy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetRuleSecurityPolicyRequest, SecurityPolicyRule> getRuleCallable() {
    return getRuleCallable;
  }

  @Override
  public UnaryCallable<InsertSecurityPolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertSecurityPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListSecurityPoliciesRequest, SecurityPolicyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListSecurityPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable() {
    return listPreconfiguredExpressionSetsCallable;
  }

  @Override
  public UnaryCallable<PatchSecurityPolicyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<PatchRuleSecurityPolicyRequest, Operation> patchRuleCallable() {
    return patchRuleCallable;
  }

  @Override
  public OperationCallable<PatchRuleSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    return patchRuleOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveRuleSecurityPolicyRequest, Operation> removeRuleCallable() {
    return removeRuleCallable;
  }

  @Override
  public OperationCallable<RemoveRuleSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    return removeRuleOperationCallable;
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
