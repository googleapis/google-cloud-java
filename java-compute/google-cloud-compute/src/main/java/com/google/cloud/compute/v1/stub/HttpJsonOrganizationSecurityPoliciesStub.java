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

import static com.google.cloud.compute.v1.OrganizationSecurityPoliciesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddAssociationOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.AddRuleOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.CopyRulesOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.DeleteOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetAssociationOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRuleOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.InsertOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListAssociationsOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListOrganizationSecurityPoliciesRequest;
import com.google.cloud.compute.v1.ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest;
import com.google.cloud.compute.v1.MoveOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.OrganizationSecurityPoliciesListAssociationsResponse;
import com.google.cloud.compute.v1.PatchOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveAssociationOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleOrganizationSecurityPolicyRequest;
import com.google.cloud.compute.v1.SecurityPoliciesListPreconfiguredExpressionSetsResponse;
import com.google.cloud.compute.v1.SecurityPolicy;
import com.google.cloud.compute.v1.SecurityPolicyAssociation;
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
 * REST stub implementation for the OrganizationSecurityPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonOrganizationSecurityPoliciesStub extends OrganizationSecurityPoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          AddAssociationOrganizationSecurityPolicyRequest, Operation>
      addAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<AddAssociationOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.OrganizationSecurityPolicies/AddAssociation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AddAssociationOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}/addAssociation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddAssociationOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddAssociationOrganizationSecurityPolicyRequest>
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
                                      "securityPolicyAssociationResource",
                                      request.getSecurityPolicyAssociationResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (AddAssociationOrganizationSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<AddRuleOrganizationSecurityPolicyRequest, Operation>
      addRuleMethodDescriptor =
          ApiMethodDescriptor.<AddRuleOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/AddRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<AddRuleOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}/addRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleOrganizationSecurityPolicyRequest>
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
                  (AddRuleOrganizationSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<CopyRulesOrganizationSecurityPolicyRequest, Operation>
      copyRulesMethodDescriptor =
          ApiMethodDescriptor.<CopyRulesOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/CopyRules")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CopyRulesOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}/copyRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CopyRulesOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CopyRulesOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasSourceSecurityPolicy()) {
                              serializer.putQueryParam(
                                  fields,
                                  "sourceSecurityPolicy",
                                  request.getSourceSecurityPolicy());
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
                  (CopyRulesOrganizationSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<DeleteOrganizationSecurityPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteOrganizationSecurityPolicyRequest>
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
                  (DeleteOrganizationSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<GetOrganizationSecurityPolicyRequest, SecurityPolicy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetOrganizationSecurityPolicyRequest, SecurityPolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOrganizationSecurityPolicyRequest> serializer =
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

  private static final ApiMethodDescriptor<
          GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
      getAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.OrganizationSecurityPolicies/GetAssociation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetAssociationOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}/getAssociation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssociationOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAssociationOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasName()) {
                              serializer.putQueryParam(fields, "name", request.getName());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityPolicyAssociation>newBuilder()
                      .setDefaultInstance(SecurityPolicyAssociation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>
      getRuleMethodDescriptor =
          ApiMethodDescriptor
              .<GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/GetRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetRuleOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}/getRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
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

  private static final ApiMethodDescriptor<InsertOrganizationSecurityPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasParentId()) {
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
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
                  (InsertOrganizationSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getParentId());
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
          ListOrganizationSecurityPoliciesRequest, SecurityPolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListOrganizationSecurityPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrganizationSecurityPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListOrganizationSecurityPoliciesRequest>
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
                            if (request.hasParentId()) {
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
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
          ListAssociationsOrganizationSecurityPolicyRequest,
          OrganizationSecurityPoliciesListAssociationsResponse>
      listAssociationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAssociationsOrganizationSecurityPolicyRequest,
                  OrganizationSecurityPoliciesListAssociationsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.OrganizationSecurityPolicies/ListAssociations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListAssociationsOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/listAssociations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssociationsOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAssociationsOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasTargetResource()) {
                              serializer.putQueryParam(
                                  fields, "targetResource", request.getTargetResource());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<OrganizationSecurityPoliciesListAssociationsResponse>newBuilder()
                      .setDefaultInstance(
                          OrganizationSecurityPoliciesListAssociationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsMethodDescriptor =
          ApiMethodDescriptor
              .<ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
                  SecurityPoliciesListPreconfiguredExpressionSetsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.OrganizationSecurityPolicies/ListPreconfiguredExpressionSets")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest>
                          newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/listPreconfiguredExpressionSets",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest>
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
                            if (request.hasParentId()) {
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
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

  private static final ApiMethodDescriptor<MoveOrganizationSecurityPolicyRequest, Operation>
      moveMethodDescriptor =
          ApiMethodDescriptor.<MoveOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/Move")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}/move",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<MoveOrganizationSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<MoveOrganizationSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasParentId()) {
                              serializer.putQueryParam(fields, "parentId", request.getParentId());
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
                  (MoveOrganizationSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getParentId());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<PatchOrganizationSecurityPolicyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchOrganizationSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchOrganizationSecurityPolicyRequest> serializer =
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
                  (PatchOrganizationSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<PatchRuleOrganizationSecurityPolicyRequest, Operation>
      patchRuleMethodDescriptor =
          ApiMethodDescriptor.<PatchRuleOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/PatchRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<PatchRuleOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}/patchRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleOrganizationSecurityPolicyRequest>
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
                  (PatchRuleOrganizationSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
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
          RemoveAssociationOrganizationSecurityPolicyRequest, Operation>
      removeAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<RemoveAssociationOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.OrganizationSecurityPolicies/RemoveAssociation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RemoveAssociationOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}/removeAssociation",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAssociationOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveAssociationOrganizationSecurityPolicyRequest>
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
                  (RemoveAssociationOrganizationSecurityPolicyRequest request,
                      Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private static final ApiMethodDescriptor<RemoveRuleOrganizationSecurityPolicyRequest, Operation>
      removeRuleMethodDescriptor =
          ApiMethodDescriptor.<RemoveRuleOrganizationSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.OrganizationSecurityPolicies/RemoveRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<RemoveRuleOrganizationSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/securityPolicies/{securityPolicy}/removeRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleOrganizationSecurityPolicyRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleOrganizationSecurityPolicyRequest>
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
                  (RemoveRuleOrganizationSecurityPolicyRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    return HttpJsonOperationSnapshot.newBuilder()
                        .setName(opName.toString())
                        .setMetadata(response)
                        .setDone(Status.DONE.equals(response.getStatus()))
                        .setResponse(response)
                        .setError(response.getHttpErrorStatusCode(), response.getHttpErrorMessage())
                        .build();
                  })
              .build();

  private final UnaryCallable<AddAssociationOrganizationSecurityPolicyRequest, Operation>
      addAssociationCallable;
  private final OperationCallable<
          AddAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      addAssociationOperationCallable;
  private final UnaryCallable<AddRuleOrganizationSecurityPolicyRequest, Operation> addRuleCallable;
  private final OperationCallable<AddRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable;
  private final UnaryCallable<CopyRulesOrganizationSecurityPolicyRequest, Operation>
      copyRulesCallable;
  private final OperationCallable<CopyRulesOrganizationSecurityPolicyRequest, Operation, Operation>
      copyRulesOperationCallable;
  private final UnaryCallable<DeleteOrganizationSecurityPolicyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteOrganizationSecurityPolicyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetOrganizationSecurityPolicyRequest, SecurityPolicy> getCallable;
  private final UnaryCallable<
          GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
      getAssociationCallable;
  private final UnaryCallable<GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>
      getRuleCallable;
  private final UnaryCallable<InsertOrganizationSecurityPolicyRequest, Operation> insertCallable;
  private final OperationCallable<InsertOrganizationSecurityPolicyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList>
      listCallable;
  private final UnaryCallable<ListOrganizationSecurityPoliciesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<
          ListAssociationsOrganizationSecurityPolicyRequest,
          OrganizationSecurityPoliciesListAssociationsResponse>
      listAssociationsCallable;
  private final UnaryCallable<
          ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable;
  private final UnaryCallable<MoveOrganizationSecurityPolicyRequest, Operation> moveCallable;
  private final OperationCallable<MoveOrganizationSecurityPolicyRequest, Operation, Operation>
      moveOperationCallable;
  private final UnaryCallable<PatchOrganizationSecurityPolicyRequest, Operation> patchCallable;
  private final OperationCallable<PatchOrganizationSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<PatchRuleOrganizationSecurityPolicyRequest, Operation>
      patchRuleCallable;
  private final OperationCallable<PatchRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable;
  private final UnaryCallable<RemoveAssociationOrganizationSecurityPolicyRequest, Operation>
      removeAssociationCallable;
  private final OperationCallable<
          RemoveAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable;
  private final UnaryCallable<RemoveRuleOrganizationSecurityPolicyRequest, Operation>
      removeRuleCallable;
  private final OperationCallable<RemoveRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOrganizationOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonOrganizationSecurityPoliciesStub create(
      OrganizationSecurityPoliciesStubSettings settings) throws IOException {
    return new HttpJsonOrganizationSecurityPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonOrganizationSecurityPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonOrganizationSecurityPoliciesStub(
        OrganizationSecurityPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonOrganizationSecurityPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonOrganizationSecurityPoliciesStub(
        OrganizationSecurityPoliciesStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonOrganizationSecurityPoliciesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonOrganizationSecurityPoliciesStub(
      OrganizationSecurityPoliciesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonOrganizationSecurityPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonOrganizationSecurityPoliciesStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonOrganizationSecurityPoliciesStub(
      OrganizationSecurityPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOrganizationOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddAssociationOrganizationSecurityPolicyRequest, Operation>
        addAssociationTransportSettings =
            HttpJsonCallSettings
                .<AddAssociationOrganizationSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(addAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<AddRuleOrganizationSecurityPolicyRequest, Operation>
        addRuleTransportSettings =
            HttpJsonCallSettings.<AddRuleOrganizationSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(addRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CopyRulesOrganizationSecurityPolicyRequest, Operation>
        copyRulesTransportSettings =
            HttpJsonCallSettings.<CopyRulesOrganizationSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(copyRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteOrganizationSecurityPolicyRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteOrganizationSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetOrganizationSecurityPolicyRequest, SecurityPolicy>
        getTransportSettings =
            HttpJsonCallSettings.<GetOrganizationSecurityPolicyRequest, SecurityPolicy>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
        getAssociationTransportSettings =
            HttpJsonCallSettings
                .<GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
                    newBuilder()
                .setMethodDescriptor(getAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>
        getRuleTransportSettings =
            HttpJsonCallSettings
                .<GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>newBuilder()
                .setMethodDescriptor(getRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertOrganizationSecurityPolicyRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertOrganizationSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListAssociationsOrganizationSecurityPolicyRequest,
            OrganizationSecurityPoliciesListAssociationsResponse>
        listAssociationsTransportSettings =
            HttpJsonCallSettings
                .<ListAssociationsOrganizationSecurityPolicyRequest,
                    OrganizationSecurityPoliciesListAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(listAssociationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<
            ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
            SecurityPoliciesListPreconfiguredExpressionSetsResponse>
        listPreconfiguredExpressionSetsTransportSettings =
            HttpJsonCallSettings
                .<ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
                    SecurityPoliciesListPreconfiguredExpressionSetsResponse>
                    newBuilder()
                .setMethodDescriptor(listPreconfiguredExpressionSetsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<MoveOrganizationSecurityPolicyRequest, Operation> moveTransportSettings =
        HttpJsonCallSettings.<MoveOrganizationSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(moveMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PatchOrganizationSecurityPolicyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchOrganizationSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PatchRuleOrganizationSecurityPolicyRequest, Operation>
        patchRuleTransportSettings =
            HttpJsonCallSettings.<PatchRuleOrganizationSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveAssociationOrganizationSecurityPolicyRequest, Operation>
        removeAssociationTransportSettings =
            HttpJsonCallSettings
                .<RemoveAssociationOrganizationSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(removeAssociationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveRuleOrganizationSecurityPolicyRequest, Operation>
        removeRuleTransportSettings =
            HttpJsonCallSettings
                .<RemoveRuleOrganizationSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(removeRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
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
    this.addRuleCallable =
        callableFactory.createUnaryCallable(
            addRuleTransportSettings, settings.addRuleSettings(), clientContext);
    this.addRuleOperationCallable =
        callableFactory.createOperationCallable(
            addRuleTransportSettings,
            settings.addRuleOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.copyRulesCallable =
        callableFactory.createUnaryCallable(
            copyRulesTransportSettings, settings.copyRulesSettings(), clientContext);
    this.copyRulesOperationCallable =
        callableFactory.createOperationCallable(
            copyRulesTransportSettings,
            settings.copyRulesOperationSettings(),
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
    this.listAssociationsCallable =
        callableFactory.createUnaryCallable(
            listAssociationsTransportSettings, settings.listAssociationsSettings(), clientContext);
    this.listPreconfiguredExpressionSetsCallable =
        callableFactory.createUnaryCallable(
            listPreconfiguredExpressionSetsTransportSettings,
            settings.listPreconfiguredExpressionSetsSettings(),
            clientContext);
    this.moveCallable =
        callableFactory.createUnaryCallable(
            moveTransportSettings, settings.moveSettings(), clientContext);
    this.moveOperationCallable =
        callableFactory.createOperationCallable(
            moveTransportSettings,
            settings.moveOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addAssociationMethodDescriptor);
    methodDescriptors.add(addRuleMethodDescriptor);
    methodDescriptors.add(copyRulesMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getAssociationMethodDescriptor);
    methodDescriptors.add(getRuleMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(listAssociationsMethodDescriptor);
    methodDescriptors.add(listPreconfiguredExpressionSetsMethodDescriptor);
    methodDescriptors.add(moveMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(patchRuleMethodDescriptor);
    methodDescriptors.add(removeAssociationMethodDescriptor);
    methodDescriptors.add(removeRuleMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddAssociationOrganizationSecurityPolicyRequest, Operation>
      addAssociationCallable() {
    return addAssociationCallable;
  }

  @Override
  public OperationCallable<AddAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      addAssociationOperationCallable() {
    return addAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<AddRuleOrganizationSecurityPolicyRequest, Operation> addRuleCallable() {
    return addRuleCallable;
  }

  @Override
  public OperationCallable<AddRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    return addRuleOperationCallable;
  }

  @Override
  public UnaryCallable<CopyRulesOrganizationSecurityPolicyRequest, Operation> copyRulesCallable() {
    return copyRulesCallable;
  }

  @Override
  public OperationCallable<CopyRulesOrganizationSecurityPolicyRequest, Operation, Operation>
      copyRulesOperationCallable() {
    return copyRulesOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteOrganizationSecurityPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteOrganizationSecurityPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetOrganizationSecurityPolicyRequest, SecurityPolicy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetAssociationOrganizationSecurityPolicyRequest, SecurityPolicyAssociation>
      getAssociationCallable() {
    return getAssociationCallable;
  }

  @Override
  public UnaryCallable<GetRuleOrganizationSecurityPolicyRequest, SecurityPolicyRule>
      getRuleCallable() {
    return getRuleCallable;
  }

  @Override
  public UnaryCallable<InsertOrganizationSecurityPolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertOrganizationSecurityPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListOrganizationSecurityPoliciesRequest, SecurityPolicyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListOrganizationSecurityPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListAssociationsOrganizationSecurityPolicyRequest,
          OrganizationSecurityPoliciesListAssociationsResponse>
      listAssociationsCallable() {
    return listAssociationsCallable;
  }

  @Override
  public UnaryCallable<
          ListPreconfiguredExpressionSetsOrganizationSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable() {
    return listPreconfiguredExpressionSetsCallable;
  }

  @Override
  public UnaryCallable<MoveOrganizationSecurityPolicyRequest, Operation> moveCallable() {
    return moveCallable;
  }

  @Override
  public OperationCallable<MoveOrganizationSecurityPolicyRequest, Operation, Operation>
      moveOperationCallable() {
    return moveOperationCallable;
  }

  @Override
  public UnaryCallable<PatchOrganizationSecurityPolicyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchOrganizationSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<PatchRuleOrganizationSecurityPolicyRequest, Operation> patchRuleCallable() {
    return patchRuleCallable;
  }

  @Override
  public OperationCallable<PatchRuleOrganizationSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    return patchRuleOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveAssociationOrganizationSecurityPolicyRequest, Operation>
      removeAssociationCallable() {
    return removeAssociationCallable;
  }

  @Override
  public OperationCallable<RemoveAssociationOrganizationSecurityPolicyRequest, Operation, Operation>
      removeAssociationOperationCallable() {
    return removeAssociationOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveRuleOrganizationSecurityPolicyRequest, Operation>
      removeRuleCallable() {
    return removeRuleCallable;
  }

  @Override
  public OperationCallable<RemoveRuleOrganizationSecurityPolicyRequest, Operation, Operation>
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
