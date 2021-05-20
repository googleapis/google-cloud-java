/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.FirewallPoliciesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.AddAssociationFirewallPolicyRequest;
import com.google.cloud.compute.v1.AddRuleFirewallPolicyRequest;
import com.google.cloud.compute.v1.CloneRulesFirewallPolicyRequest;
import com.google.cloud.compute.v1.DeleteFirewallPolicyRequest;
import com.google.cloud.compute.v1.FirewallPoliciesListAssociationsResponse;
import com.google.cloud.compute.v1.FirewallPolicy;
import com.google.cloud.compute.v1.FirewallPolicyAssociation;
import com.google.cloud.compute.v1.FirewallPolicyList;
import com.google.cloud.compute.v1.FirewallPolicyRule;
import com.google.cloud.compute.v1.GetAssociationFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetIamPolicyFirewallPolicyRequest;
import com.google.cloud.compute.v1.GetRuleFirewallPolicyRequest;
import com.google.cloud.compute.v1.InsertFirewallPolicyRequest;
import com.google.cloud.compute.v1.ListAssociationsFirewallPolicyRequest;
import com.google.cloud.compute.v1.ListFirewallPoliciesRequest;
import com.google.cloud.compute.v1.MoveFirewallPolicyRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchFirewallPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleFirewallPolicyRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveAssociationFirewallPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleFirewallPolicyRequest;
import com.google.cloud.compute.v1.SetIamPolicyFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestIamPermissionsFirewallPolicyRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * REST stub implementation for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonFirewallPoliciesStub extends FirewallPoliciesStub {

  @InternalApi
  public static final ApiMethodDescriptor<AddAssociationFirewallPolicyRequest, Operation>
      addAssociationMethodDescriptor =
          ApiMethodDescriptor.<AddAssociationFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.AddAssociation")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddAssociationFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}/addAssociation",
                          new FieldsExtractor<
                              AddAssociationFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddAssociationFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddAssociationFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddAssociationFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddAssociationFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddAssociationFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasReplaceExistingAssociation()) {
                                serializer.putQueryParam(
                                    fields,
                                    "replaceExistingAssociation",
                                    request.getReplaceExistingAssociation());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddAssociationFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(AddAssociationFirewallPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyAssociationResource",
                                      request.getFirewallPolicyAssociationResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<AddRuleFirewallPolicyRequest, Operation>
      addRuleMethodDescriptor =
          ApiMethodDescriptor.<AddRuleFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.AddRule")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddRuleFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}/addRule",
                          new FieldsExtractor<AddRuleFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddRuleFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddRuleFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddRuleFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddRuleFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddRuleFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddRuleFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(AddRuleFirewallPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyRuleResource",
                                      request.getFirewallPolicyRuleResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<CloneRulesFirewallPolicyRequest, Operation>
      cloneRulesMethodDescriptor =
          ApiMethodDescriptor.<CloneRulesFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.CloneRules")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CloneRulesFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}/cloneRules",
                          new FieldsExtractor<
                              CloneRulesFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                CloneRulesFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<CloneRulesFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              CloneRulesFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                CloneRulesFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<CloneRulesFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              if (request.hasSourceFirewallPolicy()) {
                                serializer.putQueryParam(
                                    fields,
                                    "sourceFirewallPolicy",
                                    request.getSourceFirewallPolicy());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<CloneRulesFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(CloneRulesFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteFirewallPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}",
                          new FieldsExtractor<DeleteFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(DeleteFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetFirewallPolicyRequest, FirewallPolicy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetFirewallPolicyRequest, FirewallPolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}",
                          new FieldsExtractor<GetFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(GetFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(GetFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallPolicy>newBuilder()
                      .setDefaultInstance(FirewallPolicy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationMethodDescriptor =
          ApiMethodDescriptor
              .<GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.GetAssociation")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAssociationFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}/getAssociation",
                          new FieldsExtractor<
                              GetAssociationFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetAssociationFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetAssociationFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetAssociationFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetAssociationFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetAssociationFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasName()) {
                                serializer.putQueryParam(fields, "name", request.getName());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetAssociationFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(GetAssociationFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallPolicyAssociation>newBuilder()
                      .setDefaultInstance(FirewallPolicyAssociation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyFirewallPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyFirewallPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{resource}/getIamPolicy",
                          new FieldsExtractor<
                              GetIamPolicyFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetIamPolicyFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasOptionsRequestedPolicyVersion()) {
                                serializer.putQueryParam(
                                    fields,
                                    "optionsRequestedPolicyVersion",
                                    request.getOptionsRequestedPolicyVersion());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetIamPolicyFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRuleFirewallPolicyRequest, FirewallPolicyRule>
      getRuleMethodDescriptor =
          ApiMethodDescriptor.<GetRuleFirewallPolicyRequest, FirewallPolicyRule>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.GetRule")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRuleFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}/getRule",
                          new FieldsExtractor<GetRuleFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRuleFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRuleFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRuleFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRuleFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRuleFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasPriority()) {
                                serializer.putQueryParam(fields, "priority", request.getPriority());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRuleFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(GetRuleFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallPolicyRule>newBuilder()
                      .setDefaultInstance(FirewallPolicyRule.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertFirewallPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies",
                          new FieldsExtractor<InsertFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasParentId()) {
                                serializer.putQueryParam(fields, "parentId", request.getParentId());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(InsertFirewallPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyResource",
                                      request.getFirewallPolicyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListFirewallPoliciesRequest, FirewallPolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListFirewallPoliciesRequest, FirewallPolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFirewallPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies",
                          new FieldsExtractor<ListFirewallPoliciesRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListFirewallPoliciesRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListFirewallPoliciesRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListFirewallPoliciesRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListFirewallPoliciesRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListFirewallPoliciesRequest> serializer =
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
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListFirewallPoliciesRequest, String>() {
                            @Override
                            public String extract(ListFirewallPoliciesRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallPolicyList>newBuilder()
                      .setDefaultInstance(FirewallPolicyList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
      listAssociationsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.ListAssociations")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAssociationsFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/listAssociations",
                          new FieldsExtractor<
                              ListAssociationsFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListAssociationsFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListAssociationsFirewallPolicyRequest>
                                  serializer = ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListAssociationsFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListAssociationsFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListAssociationsFirewallPolicyRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasTargetResource()) {
                                serializer.putQueryParam(
                                    fields, "targetResource", request.getTargetResource());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ListAssociationsFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(ListAssociationsFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FirewallPoliciesListAssociationsResponse>newBuilder()
                      .setDefaultInstance(
                          FirewallPoliciesListAssociationsResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<MoveFirewallPolicyRequest, Operation>
      moveMethodDescriptor =
          ApiMethodDescriptor.<MoveFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.Move")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<MoveFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}/move",
                          new FieldsExtractor<MoveFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(MoveFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<MoveFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              MoveFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                MoveFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<MoveFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasParentId()) {
                                serializer.putQueryParam(fields, "parentId", request.getParentId());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<MoveFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(MoveFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchFirewallPolicyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.Patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}",
                          new FieldsExtractor<PatchFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(PatchFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(PatchFirewallPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyResource",
                                      request.getFirewallPolicyResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRuleFirewallPolicyRequest, Operation>
      patchRuleMethodDescriptor =
          ApiMethodDescriptor.<PatchRuleFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.PatchRule")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRuleFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}/patchRule",
                          new FieldsExtractor<
                              PatchRuleFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                PatchRuleFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRuleFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              PatchRuleFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                PatchRuleFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<PatchRuleFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasPriority()) {
                                serializer.putQueryParam(fields, "priority", request.getPriority());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<PatchRuleFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(PatchRuleFirewallPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "firewallPolicyRuleResource",
                                      request.getFirewallPolicyRuleResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveAssociationFirewallPolicyRequest, Operation>
      removeAssociationMethodDescriptor =
          ApiMethodDescriptor.<RemoveAssociationFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.RemoveAssociation")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveAssociationFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}/removeAssociation",
                          new FieldsExtractor<
                              RemoveAssociationFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemoveAssociationFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveAssociationFirewallPolicyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemoveAssociationFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemoveAssociationFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveAssociationFirewallPolicyRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasName()) {
                                serializer.putQueryParam(fields, "name", request.getName());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemoveAssociationFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(RemoveAssociationFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveRuleFirewallPolicyRequest, Operation>
      removeRuleMethodDescriptor =
          ApiMethodDescriptor.<RemoveRuleFirewallPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.RemoveRule")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveRuleFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{firewallPolicy}/removeRule",
                          new FieldsExtractor<
                              RemoveRuleFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemoveRuleFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveRuleFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields, "firewallPolicy", request.getFirewallPolicy());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemoveRuleFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemoveRuleFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveRuleFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasPriority()) {
                                serializer.putQueryParam(fields, "priority", request.getPriority());
                              }
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemoveRuleFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(RemoveRuleFirewallPolicyRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyFirewallPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyFirewallPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{resource}/setIamPolicy",
                          new FieldsExtractor<
                              SetIamPolicyFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetIamPolicyFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyFirewallPolicyRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyFirewallPolicyRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyFirewallPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "globalOrganizationSetPolicyRequestResource",
                                      request.getGlobalOrganizationSetPolicyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.FirewallPolicies.TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsFirewallPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/locations/global/firewallPolicies/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsFirewallPolicyRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsFirewallPolicyRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsFirewallPolicyRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsFirewallPolicyRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsFirewallPolicyRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsFirewallPolicyRequest>
                                  serializer = ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsFirewallPolicyRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsFirewallPolicyRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddAssociationFirewallPolicyRequest, Operation>
      addAssociationCallable;
  private final UnaryCallable<AddRuleFirewallPolicyRequest, Operation> addRuleCallable;
  private final UnaryCallable<CloneRulesFirewallPolicyRequest, Operation> cloneRulesCallable;
  private final UnaryCallable<DeleteFirewallPolicyRequest, Operation> deleteCallable;
  private final UnaryCallable<GetFirewallPolicyRequest, FirewallPolicy> getCallable;
  private final UnaryCallable<GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable;
  private final UnaryCallable<GetIamPolicyFirewallPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<GetRuleFirewallPolicyRequest, FirewallPolicyRule> getRuleCallable;
  private final UnaryCallable<InsertFirewallPolicyRequest, Operation> insertCallable;
  private final UnaryCallable<ListFirewallPoliciesRequest, FirewallPolicyList> listCallable;
  private final UnaryCallable<ListFirewallPoliciesRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<
          ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
      listAssociationsCallable;
  private final UnaryCallable<MoveFirewallPolicyRequest, Operation> moveCallable;
  private final UnaryCallable<PatchFirewallPolicyRequest, Operation> patchCallable;
  private final UnaryCallable<PatchRuleFirewallPolicyRequest, Operation> patchRuleCallable;
  private final UnaryCallable<RemoveAssociationFirewallPolicyRequest, Operation>
      removeAssociationCallable;
  private final UnaryCallable<RemoveRuleFirewallPolicyRequest, Operation> removeRuleCallable;
  private final UnaryCallable<SetIamPolicyFirewallPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonFirewallPoliciesStub create(FirewallPoliciesStubSettings settings)
      throws IOException {
    return new HttpJsonFirewallPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonFirewallPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonFirewallPoliciesStub(
        FirewallPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonFirewallPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonFirewallPoliciesStub(
        FirewallPoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonFirewallPoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFirewallPoliciesStub(
      FirewallPoliciesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonFirewallPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonFirewallPoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonFirewallPoliciesStub(
      FirewallPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddAssociationFirewallPolicyRequest, Operation>
        addAssociationTransportSettings =
            HttpJsonCallSettings.<AddAssociationFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(addAssociationMethodDescriptor)
                .build();
    HttpJsonCallSettings<AddRuleFirewallPolicyRequest, Operation> addRuleTransportSettings =
        HttpJsonCallSettings.<AddRuleFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(addRuleMethodDescriptor)
            .build();
    HttpJsonCallSettings<CloneRulesFirewallPolicyRequest, Operation> cloneRulesTransportSettings =
        HttpJsonCallSettings.<CloneRulesFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(cloneRulesMethodDescriptor)
            .build();
    HttpJsonCallSettings<DeleteFirewallPolicyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetFirewallPolicyRequest, FirewallPolicy> getTransportSettings =
        HttpJsonCallSettings.<GetFirewallPolicyRequest, FirewallPolicy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>
        getAssociationTransportSettings =
            HttpJsonCallSettings
                .<GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>newBuilder()
                .setMethodDescriptor(getAssociationMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetIamPolicyFirewallPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyFirewallPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRuleFirewallPolicyRequest, FirewallPolicyRule>
        getRuleTransportSettings =
            HttpJsonCallSettings.<GetRuleFirewallPolicyRequest, FirewallPolicyRule>newBuilder()
                .setMethodDescriptor(getRuleMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertFirewallPolicyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListFirewallPoliciesRequest, FirewallPolicyList> listTransportSettings =
        HttpJsonCallSettings.<ListFirewallPoliciesRequest, FirewallPolicyList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<
            ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
        listAssociationsTransportSettings =
            HttpJsonCallSettings
                .<ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
                    newBuilder()
                .setMethodDescriptor(listAssociationsMethodDescriptor)
                .build();
    HttpJsonCallSettings<MoveFirewallPolicyRequest, Operation> moveTransportSettings =
        HttpJsonCallSettings.<MoveFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(moveMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchFirewallPolicyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchRuleFirewallPolicyRequest, Operation> patchRuleTransportSettings =
        HttpJsonCallSettings.<PatchRuleFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchRuleMethodDescriptor)
            .build();
    HttpJsonCallSettings<RemoveAssociationFirewallPolicyRequest, Operation>
        removeAssociationTransportSettings =
            HttpJsonCallSettings.<RemoveAssociationFirewallPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(removeAssociationMethodDescriptor)
                .build();
    HttpJsonCallSettings<RemoveRuleFirewallPolicyRequest, Operation> removeRuleTransportSettings =
        HttpJsonCallSettings.<RemoveRuleFirewallPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(removeRuleMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicyFirewallPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyFirewallPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();

    this.addAssociationCallable =
        callableFactory.createUnaryCallable(
            addAssociationTransportSettings, settings.addAssociationSettings(), clientContext);
    this.addRuleCallable =
        callableFactory.createUnaryCallable(
            addRuleTransportSettings, settings.addRuleSettings(), clientContext);
    this.cloneRulesCallable =
        callableFactory.createUnaryCallable(
            cloneRulesTransportSettings, settings.cloneRulesSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getAssociationCallable =
        callableFactory.createUnaryCallable(
            getAssociationTransportSettings, settings.getAssociationSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
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
    this.listAssociationsCallable =
        callableFactory.createUnaryCallable(
            listAssociationsTransportSettings, settings.listAssociationsSettings(), clientContext);
    this.moveCallable =
        callableFactory.createUnaryCallable(
            moveTransportSettings, settings.moveSettings(), clientContext);
    this.patchCallable =
        callableFactory.createUnaryCallable(
            patchTransportSettings, settings.patchSettings(), clientContext);
    this.patchRuleCallable =
        callableFactory.createUnaryCallable(
            patchRuleTransportSettings, settings.patchRuleSettings(), clientContext);
    this.removeAssociationCallable =
        callableFactory.createUnaryCallable(
            removeAssociationTransportSettings,
            settings.removeAssociationSettings(),
            clientContext);
    this.removeRuleCallable =
        callableFactory.createUnaryCallable(
            removeRuleTransportSettings, settings.removeRuleSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AddAssociationFirewallPolicyRequest, Operation> addAssociationCallable() {
    return addAssociationCallable;
  }

  public UnaryCallable<AddRuleFirewallPolicyRequest, Operation> addRuleCallable() {
    return addRuleCallable;
  }

  public UnaryCallable<CloneRulesFirewallPolicyRequest, Operation> cloneRulesCallable() {
    return cloneRulesCallable;
  }

  public UnaryCallable<DeleteFirewallPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetFirewallPolicyRequest, FirewallPolicy> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationCallable() {
    return getAssociationCallable;
  }

  public UnaryCallable<GetIamPolicyFirewallPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<GetRuleFirewallPolicyRequest, FirewallPolicyRule> getRuleCallable() {
    return getRuleCallable;
  }

  public UnaryCallable<InsertFirewallPolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListFirewallPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListFirewallPoliciesRequest, FirewallPolicyList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<
          ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
      listAssociationsCallable() {
    return listAssociationsCallable;
  }

  public UnaryCallable<MoveFirewallPolicyRequest, Operation> moveCallable() {
    return moveCallable;
  }

  public UnaryCallable<PatchFirewallPolicyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  public UnaryCallable<PatchRuleFirewallPolicyRequest, Operation> patchRuleCallable() {
    return patchRuleCallable;
  }

  public UnaryCallable<RemoveAssociationFirewallPolicyRequest, Operation>
      removeAssociationCallable() {
    return removeAssociationCallable;
  }

  public UnaryCallable<RemoveRuleFirewallPolicyRequest, Operation> removeRuleCallable() {
    return removeRuleCallable;
  }

  public UnaryCallable<SetIamPolicyFirewallPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
