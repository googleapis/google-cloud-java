/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.compute.v1.RegionSecurityPoliciesClient.ListPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddRuleRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.DeleteRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.GetRuleRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.InsertRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.ListRegionSecurityPoliciesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.PatchRuleRegionSecurityPolicyRequest;
import com.google.cloud.compute.v1.RemoveRuleRegionSecurityPolicyRequest;
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
 * REST stub implementation for the RegionSecurityPolicies service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRegionSecurityPoliciesStub extends RegionSecurityPoliciesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<AddRuleRegionSecurityPolicyRequest, Operation>
      addRuleMethodDescriptor =
          ApiMethodDescriptor.<AddRuleRegionSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSecurityPolicies/AddRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddRuleRegionSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/securityPolicies/{securityPolicy}/addRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AddRuleRegionSecurityPolicyRequest> serializer =
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
                  (AddRuleRegionSecurityPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<DeleteRegionSecurityPolicyRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSecurityPolicies/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/securityPolicies/{securityPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionSecurityPolicyRequest> serializer =
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
                  (DeleteRegionSecurityPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetRegionSecurityPolicyRequest, SecurityPolicy>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetRegionSecurityPolicyRequest, SecurityPolicy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSecurityPolicies/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/securityPolicies/{securityPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionSecurityPolicyRequest> serializer =
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

  private static final ApiMethodDescriptor<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
      getRuleMethodDescriptor =
          ApiMethodDescriptor.<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSecurityPolicies/GetRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRuleRegionSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/securityPolicies/{securityPolicy}/getRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRuleRegionSecurityPolicyRequest> serializer =
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

  private static final ApiMethodDescriptor<InsertRegionSecurityPolicyRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSecurityPolicies/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/securityPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionSecurityPolicyRequest> serializer =
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
                  (InsertRegionSecurityPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<ListRegionSecurityPoliciesRequest, SecurityPolicyList>
      listMethodDescriptor =
          ApiMethodDescriptor.<ListRegionSecurityPoliciesRequest, SecurityPolicyList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSecurityPolicies/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionSecurityPoliciesRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/securityPolicies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionSecurityPoliciesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionSecurityPoliciesRequest> serializer =
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

  private static final ApiMethodDescriptor<PatchRegionSecurityPolicyRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSecurityPolicies/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRegionSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/securityPolicies/{securityPolicy}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasUpdateMask()) {
                              serializer.putQueryParam(
                                  fields, "updateMask", request.getUpdateMask());
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
                  (PatchRegionSecurityPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<PatchRuleRegionSecurityPolicyRequest, Operation>
      patchRuleMethodDescriptor =
          ApiMethodDescriptor.<PatchRuleRegionSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSecurityPolicies/PatchRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchRuleRegionSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/securityPolicies/{securityPolicy}/patchRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchRuleRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            if (request.hasPriority()) {
                              serializer.putQueryParam(fields, "priority", request.getPriority());
                            }
                            if (request.hasUpdateMask()) {
                              serializer.putQueryParam(
                                  fields, "updateMask", request.getUpdateMask());
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
                  (PatchRuleRegionSecurityPolicyRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<RemoveRuleRegionSecurityPolicyRequest, Operation>
      removeRuleMethodDescriptor =
          ApiMethodDescriptor.<RemoveRuleRegionSecurityPolicyRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionSecurityPolicies/RemoveRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveRuleRegionSecurityPolicyRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/securityPolicies/{securityPolicy}/removeRule",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleRegionSecurityPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "securityPolicy", request.getSecurityPolicy());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RemoveRuleRegionSecurityPolicyRequest> serializer =
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
                  (RemoveRuleRegionSecurityPolicyRequest request, Operation response) -> {
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

  private final UnaryCallable<AddRuleRegionSecurityPolicyRequest, Operation> addRuleCallable;
  private final OperationCallable<AddRuleRegionSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable;
  private final UnaryCallable<DeleteRegionSecurityPolicyRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRegionSecurityPolicyRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetRegionSecurityPolicyRequest, SecurityPolicy> getCallable;
  private final UnaryCallable<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
      getRuleCallable;
  private final UnaryCallable<InsertRegionSecurityPolicyRequest, Operation> insertCallable;
  private final OperationCallable<InsertRegionSecurityPolicyRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListRegionSecurityPoliciesRequest, SecurityPolicyList> listCallable;
  private final UnaryCallable<ListRegionSecurityPoliciesRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchRegionSecurityPolicyRequest, Operation> patchCallable;
  private final OperationCallable<PatchRegionSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<PatchRuleRegionSecurityPolicyRequest, Operation> patchRuleCallable;
  private final OperationCallable<PatchRuleRegionSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable;
  private final UnaryCallable<RemoveRuleRegionSecurityPolicyRequest, Operation> removeRuleCallable;
  private final OperationCallable<RemoveRuleRegionSecurityPolicyRequest, Operation, Operation>
      removeRuleOperationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionSecurityPoliciesStub create(
      RegionSecurityPoliciesStubSettings settings) throws IOException {
    return new HttpJsonRegionSecurityPoliciesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionSecurityPoliciesStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionSecurityPoliciesStub(
        RegionSecurityPoliciesStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionSecurityPoliciesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionSecurityPoliciesStub(
        RegionSecurityPoliciesStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionSecurityPoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionSecurityPoliciesStub(
      RegionSecurityPoliciesStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionSecurityPoliciesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionSecurityPoliciesStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionSecurityPoliciesStub(
      RegionSecurityPoliciesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<AddRuleRegionSecurityPolicyRequest, Operation> addRuleTransportSettings =
        HttpJsonCallSettings.<AddRuleRegionSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(addRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRegionSecurityPolicyRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRegionSecurityPolicyRequest, SecurityPolicy> getTransportSettings =
        HttpJsonCallSettings.<GetRegionSecurityPolicyRequest, SecurityPolicy>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>
        getRuleTransportSettings =
            HttpJsonCallSettings
                .<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule>newBuilder()
                .setMethodDescriptor(getRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertRegionSecurityPolicyRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRegionSecurityPoliciesRequest, SecurityPolicyList>
        listTransportSettings =
            HttpJsonCallSettings.<ListRegionSecurityPoliciesRequest, SecurityPolicyList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PatchRegionSecurityPolicyRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchRegionSecurityPolicyRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  builder.add("region", String.valueOf(request.getRegion()));
                  builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<PatchRuleRegionSecurityPolicyRequest, Operation>
        patchRuleTransportSettings =
            HttpJsonCallSettings.<PatchRuleRegionSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RemoveRuleRegionSecurityPolicyRequest, Operation>
        removeRuleTransportSettings =
            HttpJsonCallSettings.<RemoveRuleRegionSecurityPolicyRequest, Operation>newBuilder()
                .setMethodDescriptor(removeRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("security_policy", String.valueOf(request.getSecurityPolicy()));
                      return builder.build();
                    })
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
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getRuleMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(patchRuleMethodDescriptor);
    methodDescriptors.add(removeRuleMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<AddRuleRegionSecurityPolicyRequest, Operation> addRuleCallable() {
    return addRuleCallable;
  }

  @Override
  public OperationCallable<AddRuleRegionSecurityPolicyRequest, Operation, Operation>
      addRuleOperationCallable() {
    return addRuleOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionSecurityPolicyRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRegionSecurityPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRegionSecurityPolicyRequest, SecurityPolicy> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetRuleRegionSecurityPolicyRequest, SecurityPolicyRule> getRuleCallable() {
    return getRuleCallable;
  }

  @Override
  public UnaryCallable<InsertRegionSecurityPolicyRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRegionSecurityPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegionSecurityPoliciesRequest, SecurityPolicyList> listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionSecurityPoliciesRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchRegionSecurityPolicyRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchRegionSecurityPolicyRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<PatchRuleRegionSecurityPolicyRequest, Operation> patchRuleCallable() {
    return patchRuleCallable;
  }

  @Override
  public OperationCallable<PatchRuleRegionSecurityPolicyRequest, Operation, Operation>
      patchRuleOperationCallable() {
    return patchRuleOperationCallable;
  }

  @Override
  public UnaryCallable<RemoveRuleRegionSecurityPolicyRequest, Operation> removeRuleCallable() {
    return removeRuleCallable;
  }

  @Override
  public OperationCallable<RemoveRuleRegionSecurityPolicyRequest, Operation, Operation>
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
