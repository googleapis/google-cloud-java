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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.NetworkFirewallPoliciesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.NetworkFirewallPoliciesClient.ListPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddAssociationNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.AddPacketMirroringRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.AddRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.AggregatedListNetworkFirewallPoliciesRequest;
import com.google.cloud.compute.v1.CloneRulesNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.DeleteNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.FirewallPolicy;
import com.google.cloud.compute.v1.FirewallPolicyAssociation;
import com.google.cloud.compute.v1.FirewallPolicyList;
import com.google.cloud.compute.v1.FirewallPolicyRule;
import com.google.cloud.compute.v1.GetAssociationNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetIamPolicyNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetPacketMirroringRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.InsertNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.ListNetworkFirewallPoliciesRequest;
import com.google.cloud.compute.v1.NetworkFirewallPolicyAggregatedList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.PatchPacketMirroringRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveAssociationNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.RemovePacketMirroringRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.SetIamPolicyNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestIamPermissionsNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
 * REST stub implementation for the NetworkFirewallPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonNetworkFirewallPoliciesStub extends NetworkFirewallPoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddAssociationNetworkFirewallPolicyRequest, Operation>
      addAssociationMethodDescriptor =
          ApiMethodDescriptor.<AddAssociationNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/AddAssociation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AddAssociationNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/addAssociation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddAssociationNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddAssociationNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasReplaceExistingAssociation()) {
                              serializer.putQueryParam(
                                  fields,
                                  "replaceExistingAssociation",
                                  request.getReplaceExistingAssociation());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyAssociationResource",
                                      request.getFirewallPolicyAssociationResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddAssociationNetworkFirewallPolicyRequest request, Operation response) -> {
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
          AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      addPacketMirroringRuleMethodDescriptor =
          ApiMethodDescriptor
              .<AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkFirewallPolicies/AddPacketMirroringRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AddPacketMirroringRuleNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/addPacketMirroringRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddPacketMirroringRuleNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddPacketMirroringRuleNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasMaxPriority()) {
                              serializer.putQueryParam(
                                  fields, "maxPriority", request.getMaxPriority());
                            }
                            if (request.hasMinPriority()) {
                              serializer.putQueryParam(
                                  fields, "minPriority", request.getMinPriority());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyRuleResource",
                                      request.getFirewallPolicyRuleResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddPacketMirroringRuleNetworkFirewallPolicyRequest request,
                      Operation response) -> {
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

  private static final ApiMethodDescriptor<AddRuleNetworkFirewallPolicyRequest, Operation>
      addRuleMethodDescriptor =
          ApiMethodDescriptor.<AddRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/AddRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddRuleNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/addRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasMaxPriority()) {
                              serializer.putQueryParam(
                                  fields, "maxPriority", request.getMaxPriority());
                            }
                            if (request.hasMinPriority()) {
                              serializer.putQueryParam(
                                  fields, "minPriority", request.getMinPriority());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyRuleResource",
                                      request.getFirewallPolicyRuleResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddRuleNetworkFirewallPolicyRequest request, Operation response) -> {
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
          AggregatedListNetworkFirewallPoliciesRequest, NetworkFirewallPolicyAggregatedList>
      aggregatedListMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListNetworkFirewallPoliciesRequest, NetworkFirewallPolicyAggregatedList>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/AggregatedList")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AggregatedListNetworkFirewallPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/aggregated/firewallPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListNetworkFirewallPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AggregatedListNetworkFirewallPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
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
                            if (request.hasServiceProjectNumber()) {
                              serializer.putQueryParam(
                                  fields,
                                  "serviceProjectNumber",
                                  request.getServiceProjectNumber());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NetworkFirewallPolicyAggregatedList>newBuilder()
                      .setDefaultInstance(NetworkFirewallPolicyAggregatedList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CloneRulesNetworkFirewallPolicyRequest, Operation>
      cloneRulesMethodDescriptor =
          ApiMethodDescriptor.<CloneRulesNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/CloneRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CloneRulesNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/cloneRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CloneRulesNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CloneRulesNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasSourceFirewallPolicy()) {
                              serializer.putQueryParam(
                                  fields,
                                  "sourceFirewallPolicy",
                                  request.getSourceFirewallPolicy());
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
                  (CloneRulesNetworkFirewallPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<DeleteNetworkFirewallPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteNetworkFirewallPolicyRequest> serializer =
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
                  (DeleteNetworkFirewallPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetNetworkFirewallPolicyRequest, FirewallPolicy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetNetworkFirewallPolicyRequest, FirewallPolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallPolicy>newBuilder()
                      .setDefaultInstance(FirewallPolicy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/GetAssociation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetAssociationNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/getAssociation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssociationNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssociationNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasName()) {
                              serializer.putQueryParam(fields, "name", request.getName());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallPolicyAssociation>newBuilder()
                      .setDefaultInstance(FirewallPolicyAssociation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyNetworkFirewallPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetIamPolicyNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasOptionsRequestedPolicyVersion()) {
                              serializer.putQueryParam(
                                  fields,
                                  "optionsRequestedPolicyVersion",
                                  request.getOptionsRequestedPolicyVersion());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getPacketMirroringRuleMethodDescriptor =
          ApiMethodDescriptor
              .<GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkFirewallPolicies/GetPacketMirroringRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetPacketMirroringRuleNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/getPacketMirroringRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPacketMirroringRuleNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPacketMirroringRuleNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallPolicyRule>newBuilder()
                      .setDefaultInstance(FirewallPolicyRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleMethodDescriptor =
          ApiMethodDescriptor.<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/GetRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRuleNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/getRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallPolicyRule>newBuilder()
                      .setDefaultInstance(FirewallPolicyRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertNetworkFirewallPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertNetworkFirewallPolicyRequest> serializer =
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
                                      "firewallPolicyResource",
                                      request.getFirewallPolicyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertNetworkFirewallPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListNetworkFirewallPoliciesRequest, FirewallPolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListNetworkFirewallPoliciesRequest, FirewallPolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListNetworkFirewallPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkFirewallPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListNetworkFirewallPoliciesRequest> serializer =
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
                  ProtoMessageResponseParser.<FirewallPolicyList>newBuilder()
                      .setDefaultInstance(FirewallPolicyList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchNetworkFirewallPolicyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchNetworkFirewallPolicyRequest> serializer =
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
                                      "firewallPolicyResource",
                                      request.getFirewallPolicyResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchNetworkFirewallPolicyRequest request, Operation response) -> {
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
          PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      patchPacketMirroringRuleMethodDescriptor =
          ApiMethodDescriptor
              .<PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkFirewallPolicies/PatchPacketMirroringRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchPacketMirroringRuleNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/patchPacketMirroringRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    PatchPacketMirroringRuleNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    PatchPacketMirroringRuleNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyRuleResource",
                                      request.getFirewallPolicyRuleResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchPacketMirroringRuleNetworkFirewallPolicyRequest request,
                      Operation response) -> {
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

  private static final ApiMethodDescriptor<PatchRuleNetworkFirewallPolicyRequest, Operation>
      patchRuleMethodDescriptor =
          ApiMethodDescriptor.<PatchRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/PatchRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRuleNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/patchRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyRuleResource",
                                      request.getFirewallPolicyRuleResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchRuleNetworkFirewallPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
      removeAssociationMethodDescriptor =
          ApiMethodDescriptor.<RemoveAssociationNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkFirewallPolicies/RemoveAssociation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RemoveAssociationNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/removeAssociation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAssociationNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAssociationNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasName()) {
                              serializer.putQueryParam(fields, "name", request.getName());
                            }
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
                  (RemoveAssociationNetworkFirewallPolicyRequest request, Operation response) -> {
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
          RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      removePacketMirroringRuleMethodDescriptor =
          ApiMethodDescriptor
              .<RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkFirewallPolicies/RemovePacketMirroringRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RemovePacketMirroringRuleNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/removePacketMirroringRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    RemovePacketMirroringRuleNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    RemovePacketMirroringRuleNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
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
                  (RemovePacketMirroringRuleNetworkFirewallPolicyRequest request,
                      Operation response) -> {
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

  private static final ApiMethodDescriptor<RemoveRuleNetworkFirewallPolicyRequest, Operation>
      removeRuleMethodDescriptor =
          ApiMethodDescriptor.<RemoveRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/RemoveRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveRuleNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{firewallPolicy}/removeRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
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
                  (RemoveRuleNetworkFirewallPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyNetworkFirewallPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.NetworkFirewallPolicies/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetIamPolicyNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "globalSetPolicyRequestResource",
                                      request.getGlobalSetPolicyRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.NetworkFirewallPolicies/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/firewallPolicies/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<AddAssociationNetworkFirewallPolicyRequest, Operation>
      addAssociationCallable;
  private final OperationCallable<AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationCallable;
  private final UnaryCallable<AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      addPacketMirroringRuleCallable;
  private final OperationCallable<
          AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addPacketMirroringRuleOperationCallable;
  private final UnaryCallable<AddRuleNetworkFirewallPolicyRequest, Operation> addRuleCallable;
  private final OperationCallable<AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationCallable;
  private final UnaryCallable<
          AggregatedListNetworkFirewallPoliciesRequest, NetworkFirewallPolicyAggregatedList>
      aggregatedListCallable;
  private final UnaryCallable<
          AggregatedListNetworkFirewallPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable;
  private final UnaryCallable<CloneRulesNetworkFirewallPolicyRequest, Operation> cloneRulesCallable;
  private final OperationCallable<CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationCallable;
  private final UnaryCallable<DeleteNetworkFirewallPolicyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetNetworkFirewallPolicyRequest, FirewallPolicy> getCallable;
  private final UnaryCallable<GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable;
  private final UnaryCallable<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
      getIamPolicyCallable;
  private final UnaryCallable<
          GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getPacketMirroringRuleCallable;
  private final UnaryCallable<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleCallable;
  private final UnaryCallable<InsertNetworkFirewallPolicyRequest, Operation> insertCallable;
  private final OperationCallable<InsertNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListNetworkFirewallPoliciesRequest, FirewallPolicyList> listCallable;
  private final UnaryCallable<ListNetworkFirewallPoliciesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchNetworkFirewallPolicyRequest, Operation> patchCallable;
  private final OperationCallable<PatchNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      patchPacketMirroringRuleCallable;
  private final OperationCallable<
          PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchPacketMirroringRuleOperationCallable;
  private final UnaryCallable<PatchRuleNetworkFirewallPolicyRequest, Operation> patchRuleCallable;
  private final OperationCallable<PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationCallable;
  private final UnaryCallable<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
      removeAssociationCallable;
  private final OperationCallable<
          RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable;
  private final UnaryCallable<RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      removePacketMirroringRuleCallable;
  private final OperationCallable<
          RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removePacketMirroringRuleOperationCallable;
  private final UnaryCallable<RemoveRuleNetworkFirewallPolicyRequest, Operation> removeRuleCallable;
  private final OperationCallable<RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationCallable;
  private final UnaryCallable<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
      setIamPolicyCallable;
  private final UnaryCallable<
          TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNetworkFirewallPoliciesStub create(
      NetworkFirewallPoliciesStubSettings settings) throws IOException {
    return new HttpJsonNetworkFirewallPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNetworkFirewallPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNetworkFirewallPoliciesStub(
        NetworkFirewallPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNetworkFirewallPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNetworkFirewallPoliciesStub(
        NetworkFirewallPoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNetworkFirewallPoliciesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkFirewallPoliciesStub(
      NetworkFirewallPoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNetworkFirewallPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNetworkFirewallPoliciesStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkFirewallPoliciesStub(
      NetworkFirewallPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddAssociationNetworkFirewallPolicyRequest, Operation>
        addAssociationTransportSettings =
            HttpJsonCallSettings.<AddAssociationNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(addAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
        addPacketMirroringRuleTransportSettings =
            HttpJsonCallSettings
                .<AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(addPacketMirroringRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AddRuleNetworkFirewallPolicyRequest, Operation> addRuleTransportSettings =
        HttpJsonCallSettings.<AddRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(addRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<
            AggregatedListNetworkFirewallPoliciesRequest, NetworkFirewallPolicyAggregatedList>
        aggregatedListTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListNetworkFirewallPoliciesRequest, NetworkFirewallPolicyAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CloneRulesNetworkFirewallPolicyRequest, Operation>
        cloneRulesTransportSettings =
            HttpJsonCallSettings.<CloneRulesNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(cloneRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteNetworkFirewallPolicyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteNetworkFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetNetworkFirewallPolicyRequest, FirewallPolicy> getTransportSettings =
        HttpJsonCallSettings.<GetNetworkFirewallPolicyRequest, FirewallPolicy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
        getAssociationTransportSettings =
            HttpJsonCallSettings
                .<GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>newBuilder()
                .setMethodDescriptor(getAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
        getIamPolicyTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyNetworkFirewallPolicyRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
        getPacketMirroringRuleTransportSettings =
            HttpJsonCallSettings
                .<GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
                    newBuilder()
                .setMethodDescriptor(getPacketMirroringRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
        getRuleTransportSettings =
            HttpJsonCallSettings
                .<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>newBuilder()
                .setMethodDescriptor(getRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertNetworkFirewallPolicyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertNetworkFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListNetworkFirewallPoliciesRequest, FirewallPolicyList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkFirewallPoliciesRequest, FirewallPolicyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PatchNetworkFirewallPolicyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchNetworkFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
        patchPacketMirroringRuleTransportSettings =
            HttpJsonCallSettings
                .<PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(patchPacketMirroringRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PatchRuleNetworkFirewallPolicyRequest, Operation>
        patchRuleTransportSettings =
            HttpJsonCallSettings.<PatchRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
        removeAssociationTransportSettings =
            HttpJsonCallSettings
                .<RemoveAssociationNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(removeAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
        removePacketMirroringRuleTransportSettings =
            HttpJsonCallSettings
                .<RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(removePacketMirroringRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveRuleNetworkFirewallPolicyRequest, Operation>
        removeRuleTransportSettings =
            HttpJsonCallSettings.<RemoveRuleNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(removeRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("firewall_policy", String.valueOf(request.getFirewallPolicy()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
        setIamPolicyTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyNetworkFirewallPolicyRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
                    newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.addAssociationCallable =
        callableFactory.createUnaryCallable(
            addAssociationTransportSettings, settings.addAssociationSettings(), clientContext);
    this.addAssociationOperationCallable =
        callableFactory.createOperationCallable(
            addAssociationTransportSettings,
            settings.addAssociationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.addPacketMirroringRuleCallable =
        callableFactory.createUnaryCallable(
            addPacketMirroringRuleTransportSettings,
            settings.addPacketMirroringRuleSettings(),
            clientContext);
    this.addPacketMirroringRuleOperationCallable =
        callableFactory.createOperationCallable(
            addPacketMirroringRuleTransportSettings,
            settings.addPacketMirroringRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    this.cloneRulesCallable =
        callableFactory.createUnaryCallable(
            cloneRulesTransportSettings, settings.cloneRulesSettings(), clientContext);
    this.cloneRulesOperationCallable =
        callableFactory.createOperationCallable(
            cloneRulesTransportSettings,
            settings.cloneRulesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    this.getAssociationCallable =
        callableFactory.createUnaryCallable(
            getAssociationTransportSettings, settings.getAssociationSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.getPacketMirroringRuleCallable =
        callableFactory.createUnaryCallable(
            getPacketMirroringRuleTransportSettings,
            settings.getPacketMirroringRuleSettings(),
            clientContext);
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
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchOperationCallable =
        callableFactory.createOperationCallable(
            patchTransportSettings,
            settings.patchOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.patchPacketMirroringRuleCallable =
        callableFactory.createUnaryCallable(
            patchPacketMirroringRuleTransportSettings,
            settings.patchPacketMirroringRuleSettings(),
            clientContext);
    this.patchPacketMirroringRuleOperationCallable =
        callableFactory.createOperationCallable(
            patchPacketMirroringRuleTransportSettings,
            settings.patchPacketMirroringRuleOperationSettings(),
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
    this.removeAssociationCallable =
        callableFactory.createUnaryCallable(
            removeAssociationTransportSettings,
            settings.removeAssociationSettings(),
            clientContext);
    this.removeAssociationOperationCallable =
        callableFactory.createOperationCallable(
            removeAssociationTransportSettings,
            settings.removeAssociationOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.removePacketMirroringRuleCallable =
        callableFactory.createUnaryCallable(
            removePacketMirroringRuleTransportSettings,
            settings.removePacketMirroringRuleSettings(),
            clientContext);
    this.removePacketMirroringRuleOperationCallable =
        callableFactory.createOperationCallable(
            removePacketMirroringRuleTransportSettings,
            settings.removePacketMirroringRuleOperationSettings(),
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
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addAssociationMethodDescriptor);
    methodDescriptors.add(addPacketMirroringRuleMethodDescriptor);
    methodDescriptors.add(addRuleMethodDescriptor);
    methodDescriptors.add(aggregatedListMethodDescriptor);
    methodDescriptors.add(cloneRulesMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getAssociationMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(getPacketMirroringRuleMethodDescriptor);
    methodDescriptors.add(getRuleMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(patchPacketMirroringRuleMethodDescriptor);
    methodDescriptors.add(patchRuleMethodDescriptor);
    methodDescriptors.add(removeAssociationMethodDescriptor);
    methodDescriptors.add(removePacketMirroringRuleMethodDescriptor);
    methodDescriptors.add(removeRuleMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddAssociationNetworkFirewallPolicyRequest, Operation>
      addAssociationCallable() {
    return addAssociationCallable;
  }

  @Override
  public OperationCallable<AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationCallable() {
    return addAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      addPacketMirroringRuleCallable() {
    return addPacketMirroringRuleCallable;
  }

  @Override
  public OperationCallable<AddPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addPacketMirroringRuleOperationCallable() {
    return addPacketMirroringRuleOperationCallable;
  }

  @Override
  public UnaryCallable<AddRuleNetworkFirewallPolicyRequest, Operation> addRuleCallable() {
    return addRuleCallable;
  }

  @Override
  public OperationCallable<AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    return addRuleOperationCallable;
  }

  @Override
  public UnaryCallable<
          AggregatedListNetworkFirewallPoliciesRequest, NetworkFirewallPolicyAggregatedList>
      aggregatedListCallable() {
    return aggregatedListCallable;
  }

  @Override
  public UnaryCallable<AggregatedListNetworkFirewallPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return aggregatedListPagedCallable;
  }

  @Override
  public UnaryCallable<CloneRulesNetworkFirewallPolicyRequest, Operation> cloneRulesCallable() {
    return cloneRulesCallable;
  }

  @Override
  public OperationCallable<CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationCallable() {
    return cloneRulesOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteNetworkFirewallPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetNetworkFirewallPolicyRequest, FirewallPolicy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable() {
    return getAssociationCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyNetworkFirewallPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetPacketMirroringRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getPacketMirroringRuleCallable() {
    return getPacketMirroringRuleCallable;
  }

  @Override
  public UnaryCallable<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule> getRuleCallable() {
    return getRuleCallable;
  }

  @Override
  public UnaryCallable<InsertNetworkFirewallPolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListNetworkFirewallPoliciesRequest, FirewallPolicyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListNetworkFirewallPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchNetworkFirewallPolicyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      patchPacketMirroringRuleCallable() {
    return patchPacketMirroringRuleCallable;
  }

  @Override
  public OperationCallable<
          PatchPacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchPacketMirroringRuleOperationCallable() {
    return patchPacketMirroringRuleOperationCallable;
  }

  @Override
  public UnaryCallable<PatchRuleNetworkFirewallPolicyRequest, Operation> patchRuleCallable() {
    return patchRuleCallable;
  }

  @Override
  public OperationCallable<PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    return patchRuleOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
      removeAssociationCallable() {
    return removeAssociationCallable;
  }

  @Override
  public OperationCallable<RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable() {
    return removeAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation>
      removePacketMirroringRuleCallable() {
    return removePacketMirroringRuleCallable;
  }

  @Override
  public OperationCallable<
          RemovePacketMirroringRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removePacketMirroringRuleOperationCallable() {
    return removePacketMirroringRuleOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveRuleNetworkFirewallPolicyRequest, Operation> removeRuleCallable() {
    return removeRuleCallable;
  }

  @Override
  public OperationCallable<RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    return removeRuleOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyNetworkFirewallPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
