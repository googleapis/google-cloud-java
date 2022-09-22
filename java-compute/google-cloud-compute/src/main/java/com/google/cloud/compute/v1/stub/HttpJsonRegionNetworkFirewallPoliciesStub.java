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

import static com.google.cloud.compute.v1.RegionNetworkFirewallPoliciesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddAssociationRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.AddRuleRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.CloneRulesRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.DeleteRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.FirewallPolicy;
import com.google.cloud.compute.v1.FirewallPolicyAssociation;
import com.google.cloud.compute.v1.FirewallPolicyList;
import com.google.cloud.compute.v1.FirewallPolicyRule;
import com.google.cloud.compute.v1.GetAssociationRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetIamPolicyRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetRuleRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.InsertRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.ListRegionNetworkFirewallPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse;
import com.google.cloud.compute.v1.RemoveAssociationRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.SetIamPolicyRegionNetworkFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionNetworkFirewallPolicyRequest;
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
 * REST stub implementation for the RegionNetworkFirewallPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRegionNetworkFirewallPoliciesStub extends RegionNetworkFirewallPoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AddAssociationRegionNetworkFirewallPolicyRequest, Operation>
      addAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<AddAssociationRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkFirewallPolicies/AddAssociation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AddAssociationRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/addAssociation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddAssociationRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddAssociationRegionNetworkFirewallPolicyRequest>
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
                  (AddAssociationRegionNetworkFirewallPolicyRequest request,
                      Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<AddRuleRegionNetworkFirewallPolicyRequest, Operation>
      addRuleMethodDescriptor =
          ApiMethodDescriptor.<AddRuleRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/AddRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AddRuleRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/addRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleRegionNetworkFirewallPolicyRequest>
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
                  (AddRuleRegionNetworkFirewallPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>
      cloneRulesMethodDescriptor =
          ApiMethodDescriptor.<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/CloneRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CloneRulesRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/cloneRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CloneRulesRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CloneRulesRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (CloneRulesRegionNetworkFirewallPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<DeleteRegionNetworkFirewallPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (DeleteRegionNetworkFirewallPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionNetworkFirewallPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionNetworkFirewallPolicyRequest> serializer =
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
          GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkFirewallPolicies/GetAssociation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetAssociationRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/getAssociation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssociationRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssociationRegionNetworkFirewallPolicyRequest>
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

  private static final ApiMethodDescriptor<
          GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
          RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsMethodDescriptor =
          ApiMethodDescriptor
              .<GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
                  RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkFirewallPolicies/GetEffectiveFirewalls")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/getEffectiveFirewalls",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "network", request.getNetwork());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>newBuilder()
                      .setDefaultInstance(
                          RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkFirewallPolicies/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetIamPolicyRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRegionNetworkFirewallPolicyRequest>
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
          GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleMethodDescriptor =
          ApiMethodDescriptor
              .<GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/GetRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetRuleRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/getRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleRegionNetworkFirewallPolicyRequest>
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

  private static final ApiMethodDescriptor<InsertRegionNetworkFirewallPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<InsertRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (InsertRegionNetworkFirewallPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
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
          ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListRegionNetworkFirewallPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionNetworkFirewallPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionNetworkFirewallPoliciesRequest>
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
                  ProtoMessageResponseParser.<FirewallPolicyList>newBuilder()
                      .setDefaultInstance(FirewallPolicyList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchRegionNetworkFirewallPolicyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
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
                  (PatchRegionNetworkFirewallPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<PatchRuleRegionNetworkFirewallPolicyRequest, Operation>
      patchRuleMethodDescriptor =
          ApiMethodDescriptor.<PatchRuleRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/PatchRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchRuleRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/patchRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleRegionNetworkFirewallPolicyRequest>
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
                  (PatchRuleRegionNetworkFirewallPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
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
          RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>
      removeAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkFirewallPolicies/RemoveAssociation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RemoveAssociationRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/removeAssociation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAssociationRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAssociationRegionNetworkFirewallPolicyRequest>
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
                  (RemoveAssociationRegionNetworkFirewallPolicyRequest request,
                      Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>
      removeRuleMethodDescriptor =
          ApiMethodDescriptor.<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNetworkFirewallPolicies/RemoveRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RemoveRuleRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{firewallPolicy}/removeRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "firewallPolicy", request.getFirewallPolicy());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleRegionNetworkFirewallPolicyRequest>
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
                  (RemoveRuleRegionNetworkFirewallPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getRegion());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkFirewallPolicies/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetIamPolicyRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "regionSetPolicyRequestResource",
                                      request.getRegionSetPolicyRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionNetworkFirewallPolicies/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsRegionNetworkFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/firewallPolicies/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    TestIamPermissionsRegionNetworkFirewallPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    TestIamPermissionsRegionNetworkFirewallPolicyRequest>
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

  private final UnaryCallable<AddAssociationRegionNetworkFirewallPolicyRequest, Operation>
      addAssociationCallable;
  private final OperationCallable<
          AddAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationCallable;
  private final UnaryCallable<AddRuleRegionNetworkFirewallPolicyRequest, Operation> addRuleCallable;
  private final OperationCallable<AddRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationCallable;
  private final UnaryCallable<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>
      cloneRulesCallable;
  private final OperationCallable<
          CloneRulesRegionNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationCallable;
  private final UnaryCallable<DeleteRegionNetworkFirewallPolicyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRegionNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy> getCallable;
  private final UnaryCallable<
          GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable;
  private final UnaryCallable<
          GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
          RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable;
  private final UnaryCallable<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      getIamPolicyCallable;
  private final UnaryCallable<GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleCallable;
  private final UnaryCallable<InsertRegionNetworkFirewallPolicyRequest, Operation> insertCallable;
  private final OperationCallable<InsertRegionNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList>
      listCallable;
  private final UnaryCallable<ListRegionNetworkFirewallPoliciesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchRegionNetworkFirewallPolicyRequest, Operation> patchCallable;
  private final OperationCallable<PatchRegionNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<PatchRuleRegionNetworkFirewallPolicyRequest, Operation>
      patchRuleCallable;
  private final OperationCallable<PatchRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationCallable;
  private final UnaryCallable<RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>
      removeAssociationCallable;
  private final OperationCallable<
          RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable;
  private final UnaryCallable<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>
      removeRuleCallable;
  private final OperationCallable<
          RemoveRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationCallable;
  private final UnaryCallable<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      setIamPolicyCallable;
  private final UnaryCallable<
          TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionNetworkFirewallPoliciesStub create(
      RegionNetworkFirewallPoliciesStubSettings settings) throws IOException {
    return new HttpJsonRegionNetworkFirewallPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionNetworkFirewallPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionNetworkFirewallPoliciesStub(
        RegionNetworkFirewallPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionNetworkFirewallPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionNetworkFirewallPoliciesStub(
        RegionNetworkFirewallPoliciesStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionNetworkFirewallPoliciesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNetworkFirewallPoliciesStub(
      RegionNetworkFirewallPoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionNetworkFirewallPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionNetworkFirewallPoliciesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNetworkFirewallPoliciesStub(
      RegionNetworkFirewallPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddAssociationRegionNetworkFirewallPolicyRequest, Operation>
        addAssociationTransportSettings =
            HttpJsonCallSettings
                .<AddAssociationRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(addAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<AddRuleRegionNetworkFirewallPolicyRequest, Operation>
        addRuleTransportSettings =
            HttpJsonCallSettings.<AddRuleRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(addRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>
        cloneRulesTransportSettings =
            HttpJsonCallSettings
                .<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(cloneRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteRegionNetworkFirewallPolicyRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy>
        getTransportSettings =
            HttpJsonCallSettings.<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
        getAssociationTransportSettings =
            HttpJsonCallSettings
                .<GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
                    newBuilder()
                .setMethodDescriptor(getAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
            RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
        getEffectiveFirewallsTransportSettings =
            HttpJsonCallSettings
                .<GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
                    RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
                    newBuilder()
                .setMethodDescriptor(getEffectiveFirewallsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
        getIamPolicyTransportSettings =
            HttpJsonCallSettings
                .<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>
        getRuleTransportSettings =
            HttpJsonCallSettings
                .<GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>newBuilder()
                .setMethodDescriptor(getRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertRegionNetworkFirewallPolicyRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchRegionNetworkFirewallPolicyRequest, Operation>
        patchTransportSettings =
            HttpJsonCallSettings.<PatchRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(patchMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<PatchRuleRegionNetworkFirewallPolicyRequest, Operation>
        patchRuleTransportSettings =
            HttpJsonCallSettings
                .<PatchRuleRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>
        removeAssociationTransportSettings =
            HttpJsonCallSettings
                .<RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(removeAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>
        removeRuleTransportSettings =
            HttpJsonCallSettings
                .<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(removeRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
        setIamPolicyTransportSettings =
            HttpJsonCallSettings
                .<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
                    newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
    this.addRuleCallable =
        callableFactory.createUnaryCallable(
            addRuleTransportSettings, settings.addRuleSettings(), clientContext);
    this.addRuleOperationCallable =
        callableFactory.createOperationCallable(
            addRuleTransportSettings,
            settings.addRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
    this.getEffectiveFirewallsCallable =
        callableFactory.createUnaryCallable(
            getEffectiveFirewallsTransportSettings,
            settings.getEffectiveFirewallsSettings(),
            clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
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
    methodDescriptors.add(addRuleMethodDescriptor);
    methodDescriptors.add(cloneRulesMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getAssociationMethodDescriptor);
    methodDescriptors.add(getEffectiveFirewallsMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(getRuleMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(patchRuleMethodDescriptor);
    methodDescriptors.add(removeAssociationMethodDescriptor);
    methodDescriptors.add(removeRuleMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddAssociationRegionNetworkFirewallPolicyRequest, Operation>
      addAssociationCallable() {
    return addAssociationCallable;
  }

  @Override
  public OperationCallable<AddAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationCallable() {
    return addAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<AddRuleRegionNetworkFirewallPolicyRequest, Operation> addRuleCallable() {
    return addRuleCallable;
  }

  @Override
  public OperationCallable<AddRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    return addRuleOperationCallable;
  }

  @Override
  public UnaryCallable<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>
      cloneRulesCallable() {
    return cloneRulesCallable;
  }

  @Override
  public OperationCallable<CloneRulesRegionNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationCallable() {
    return cloneRulesOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionNetworkFirewallPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRegionNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable() {
    return getAssociationCallable;
  }

  @Override
  public UnaryCallable<
          GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
          RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsCallable() {
    return getEffectiveFirewallsCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleCallable() {
    return getRuleCallable;
  }

  @Override
  public UnaryCallable<InsertRegionNetworkFirewallPolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRegionNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionNetworkFirewallPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchRegionNetworkFirewallPolicyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchRegionNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<PatchRuleRegionNetworkFirewallPolicyRequest, Operation> patchRuleCallable() {
    return patchRuleCallable;
  }

  @Override
  public OperationCallable<PatchRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    return patchRuleOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>
      removeAssociationCallable() {
    return removeAssociationCallable;
  }

  @Override
  public OperationCallable<
          RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable() {
    return removeAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>
      removeRuleCallable() {
    return removeRuleCallable;
  }

  @Override
  public OperationCallable<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationCallable() {
    return removeRuleOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<
          TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
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
