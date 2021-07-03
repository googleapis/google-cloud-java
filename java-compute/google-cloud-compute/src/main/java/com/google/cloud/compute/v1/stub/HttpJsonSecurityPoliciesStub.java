/*
 * Copyright 2021 Google LLC
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

import static com.google.cloud.compute.v1.SecurityPoliciesClient.ListPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.DeleteSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetSecurityPolicyRequest;
import com.google.cloud.compute.v1.InsertSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListPreconfiguredExpressionSetsSecurityPoliciesRequest;
import com.google.cloud.compute.v1.ListSecurityPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.PatchSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleSecurityPolicyRequest;
import com.google.cloud.compute.v1.SecurityPoliciesListPreconfiguredExpressionSetsResponse;
import com.google.cloud.compute.v1.SecurityPolicy;
import com.google.cloud.compute.v1.SecurityPolicyList;
import com.google.cloud.compute.v1.SecurityPolicyRule;
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
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonSecurityPoliciesStub extends SecurityPoliciesStub {
  private static final ApiMethodDescriptor<AddRuleSecurityPolicyRequest, Operation>
      addRuleMethodDescriptor =
          ApiMethodDescriptor.<AddRuleSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/AddRule")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddRuleSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}/addRule",
                          new FieldsExtractor<AddRuleSecurityPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddRuleSecurityPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddRuleSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "securityPolicy", request.getSecurityPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddRuleSecurityPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddRuleSecurityPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddRuleSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddRuleSecurityPolicyRequest, String>() {
                            @Override
                            public String extract(AddRuleSecurityPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "securityPolicyRuleResource",
                                      request.getSecurityPolicyRuleResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSecurityPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}",
                          new FieldsExtractor<DeleteSecurityPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteSecurityPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "securityPolicy", request.getSecurityPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteSecurityPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteSecurityPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteSecurityPolicyRequest, String>() {
                            @Override
                            public String extract(DeleteSecurityPolicyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSecurityPolicyRequest, SecurityPolicy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetSecurityPolicyRequest, SecurityPolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}",
                          new FieldsExtractor<GetSecurityPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetSecurityPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "securityPolicy", request.getSecurityPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetSecurityPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetSecurityPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetSecurityPolicyRequest, String>() {
                            @Override
                            public String extract(GetSecurityPolicyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityPolicy>newBuilder()
                      .setDefaultInstance(SecurityPolicy.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRuleSecurityPolicyRequest, SecurityPolicyRule>
      getRuleMethodDescriptor =
          ApiMethodDescriptor.<GetRuleSecurityPolicyRequest, SecurityPolicyRule>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/GetRule")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRuleSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}/getRule",
                          new FieldsExtractor<GetRuleSecurityPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRuleSecurityPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRuleSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "securityPolicy", request.getSecurityPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRuleSecurityPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRuleSecurityPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRuleSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasPriority()) {
                                serializer.putQueryParam(fields, "priority", request.getPriority());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRuleSecurityPolicyRequest, String>() {
                            @Override
                            public String extract(GetRuleSecurityPolicyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityPolicyRule>newBuilder()
                      .setDefaultInstance(SecurityPolicyRule.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertSecurityPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies",
                          new FieldsExtractor<InsertSecurityPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertSecurityPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertSecurityPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertSecurityPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertSecurityPolicyRequest, String>() {
                            @Override
                            public String extract(InsertSecurityPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "securityPolicyResource",
                                      request.getSecurityPolicyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSecurityPoliciesRequest, SecurityPolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListSecurityPoliciesRequest, SecurityPolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSecurityPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies",
                          new FieldsExtractor<ListSecurityPoliciesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListSecurityPoliciesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListSecurityPoliciesRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListSecurityPoliciesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListSecurityPoliciesRequest request) {
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
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListSecurityPoliciesRequest, String>() {
                            @Override
                            public String extract(ListSecurityPoliciesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityPolicyList>newBuilder()
                      .setDefaultInstance(SecurityPolicyList.getDefaultInstance())
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
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListPreconfiguredExpressionSetsSecurityPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/listPreconfiguredExpressionSets",
                          new FieldsExtractor<
                              ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
                              Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListPreconfiguredExpressionSetsSecurityPoliciesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<
                                      ListPreconfiguredExpressionSetsSecurityPoliciesRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListPreconfiguredExpressionSetsSecurityPoliciesRequest request) {
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
                                serializer.putQueryParam(
                                    fields, "pageToken", request.getPageToken());
                              }
                              if (request.hasReturnPartialSuccess()) {
                                serializer.putQueryParam(
                                    fields,
                                    "returnPartialSuccess",
                                    request.getReturnPartialSuccess());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<
                              ListPreconfiguredExpressionSetsSecurityPoliciesRequest, String>() {
                            @Override
                            public String extract(
                                ListPreconfiguredExpressionSetsSecurityPoliciesRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<SecurityPoliciesListPreconfiguredExpressionSetsResponse>newBuilder()
                      .setDefaultInstance(
                          SecurityPoliciesListPreconfiguredExpressionSetsResponse
                              .getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchSecurityPolicyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}",
                          new FieldsExtractor<PatchSecurityPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(PatchSecurityPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "securityPolicy", request.getSecurityPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchSecurityPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchSecurityPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchSecurityPolicyRequest, String>() {
                            @Override
                            public String extract(PatchSecurityPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "securityPolicyResource",
                                      request.getSecurityPolicyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchRuleSecurityPolicyRequest, Operation>
      patchRuleMethodDescriptor =
          ApiMethodDescriptor.<PatchRuleSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/PatchRule")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRuleSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}/patchRule",
                          new FieldsExtractor<
                              PatchRuleSecurityPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchRuleSecurityPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRuleSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "securityPolicy", request.getSecurityPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchRuleSecurityPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchRuleSecurityPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRuleSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasPriority()) {
                                serializer.putQueryParam(fields, "priority", request.getPriority());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchRuleSecurityPolicyRequest, String>() {
                            @Override
                            public String extract(PatchRuleSecurityPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "securityPolicyRuleResource",
                                      request.getSecurityPolicyRuleResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<RemoveRuleSecurityPolicyRequest, Operation>
      removeRuleMethodDescriptor =
          ApiMethodDescriptor.<RemoveRuleSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.SecurityPolicies/RemoveRule")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveRuleSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/securityPolicies/{securityPolicy}/removeRule",
                          new FieldsExtractor<
                              RemoveRuleSecurityPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemoveRuleSecurityPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveRuleSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(
                                  fields, "securityPolicy", request.getSecurityPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemoveRuleSecurityPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemoveRuleSecurityPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveRuleSecurityPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasPriority()) {
                                serializer.putQueryParam(fields, "priority", request.getPriority());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemoveRuleSecurityPolicyRequest, String>() {
                            @Override
                            public String extract(RemoveRuleSecurityPolicyRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<AddRuleSecurityPolicyRequest, Operation> addRuleCallable;
  private final UnaryCallable<DeleteSecurityPolicyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetSecurityPolicyRequest, SecurityPolicy> getCallable;
  private final UnaryCallable<GetRuleSecurityPolicyRequest, SecurityPolicyRule> getRuleCallable;
  private final UnaryCallable<InsertSecurityPolicyRequest, Operation> insertCallable;
  private final UnaryCallable<ListSecurityPoliciesRequest, SecurityPolicyList> listCallable;
  private final UnaryCallable<ListSecurityPoliciesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<
          ListPreconfiguredExpressionSetsSecurityPoliciesRequest,
          SecurityPoliciesListPreconfiguredExpressionSetsResponse>
      listPreconfiguredExpressionSetsCallable;
  private final UnaryCallable<PatchSecurityPolicyRequest, Operation> patchCallable;
  private final UnaryCallable<PatchRuleSecurityPolicyRequest, Operation> patchRuleCallable;
  private final UnaryCallable<RemoveRuleSecurityPolicyRequest, Operation> removeRuleCallable;

  private final BackgroundResource backgroundResources;
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

    HttpJsonCallSettings<AddRuleSecurityPolicyRequest, Operation> addRuleTransportSettings =
        HttpJsonCallSettings.<AddRuleSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(addRuleMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteSecurityPolicyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetSecurityPolicyRequest, SecurityPolicy> getTransportSettings =
        HttpJsonCallSettings.<GetSecurityPolicyRequest, SecurityPolicy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRuleSecurityPolicyRequest, SecurityPolicyRule>
        getRuleTransportSettings =
            HttpJsonCallSettings.<GetRuleSecurityPolicyRequest, SecurityPolicyRule>newBuilder()
                .setMethodDescriptor(getRuleMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertSecurityPolicyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListSecurityPoliciesRequest, SecurityPolicyList> listTransportSettings =
        HttpJsonCallSettings.<ListSecurityPoliciesRequest, SecurityPolicyList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
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
                .build();
    HttpJsonCallSettings<PatchSecurityPolicyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchRuleSecurityPolicyRequest, Operation> patchRuleTransportSettings =
        HttpJsonCallSettings.<PatchRuleSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchRuleMethodDescriptor)
            .build();
    HttpJsonCallSettings<RemoveRuleSecurityPolicyRequest, Operation> removeRuleTransportSettings =
        HttpJsonCallSettings.<RemoveRuleSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(removeRuleMethodDescriptor)
            .build();

    this.addRuleCallable =
        callableFactory.createUnaryCallable(
            addRuleTransportSettings, settings.addRuleSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getRuleCallable =
        callableFactory.createUnaryCallable(
            getRuleTransportSettings, settings.getRuleSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
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
    this.patchRuleCallable =
        callableFactory.createUnaryCallable(
            patchRuleTransportSettings, settings.patchRuleSettings(), clientContext);
    this.removeRuleCallable =
        callableFactory.createUnaryCallable(
            removeRuleTransportSettings, settings.removeRuleSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(addRuleMethodDescriptor);
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
  public UnaryCallable<DeleteSecurityPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
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
  public UnaryCallable<PatchRuleSecurityPolicyRequest, Operation> patchRuleCallable() {
    return patchRuleCallable;
  }

  @Override
  public UnaryCallable<RemoveRuleSecurityPolicyRequest, Operation> removeRuleCallable() {
    return removeRuleCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
