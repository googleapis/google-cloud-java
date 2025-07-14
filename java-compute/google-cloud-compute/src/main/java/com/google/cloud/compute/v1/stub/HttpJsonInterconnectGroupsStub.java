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

import static com.google.cloud.compute.v1.InterconnectGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.CreateMembersInterconnectGroupRequest;
import com.google.cloud.compute.v1.DeleteInterconnectGroupRequest;
import com.google.cloud.compute.v1.GetIamPolicyInterconnectGroupRequest;
import com.google.cloud.compute.v1.GetInterconnectGroupRequest;
import com.google.cloud.compute.v1.GetOperationalStatusInterconnectGroupRequest;
import com.google.cloud.compute.v1.InsertInterconnectGroupRequest;
import com.google.cloud.compute.v1.InterconnectGroup;
import com.google.cloud.compute.v1.InterconnectGroupsGetOperationalStatusResponse;
import com.google.cloud.compute.v1.InterconnectGroupsListResponse;
import com.google.cloud.compute.v1.ListInterconnectGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchInterconnectGroupRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyInterconnectGroupRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInterconnectGroupRequest;
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
 * REST stub implementation for the InterconnectGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonInterconnectGroupsStub extends InterconnectGroupsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<CreateMembersInterconnectGroupRequest, Operation>
      createMembersMethodDescriptor =
          ApiMethodDescriptor.<CreateMembersInterconnectGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/CreateMembers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateMembersInterconnectGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups/{interconnectGroup}/createMembers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembersInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "interconnectGroup", request.getInterconnectGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateMembersInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "interconnectGroupsCreateMembersRequestResource",
                                      request.getInterconnectGroupsCreateMembersRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateMembersInterconnectGroupRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<DeleteInterconnectGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteInterconnectGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteInterconnectGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups/{interconnectGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "interconnectGroup", request.getInterconnectGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInterconnectGroupRequest> serializer =
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
                  (DeleteInterconnectGroupRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<GetInterconnectGroupRequest, InterconnectGroup>
      getMethodDescriptor =
          ApiMethodDescriptor.<GetInterconnectGroupRequest, InterconnectGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInterconnectGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups/{interconnectGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "interconnectGroup", request.getInterconnectGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InterconnectGroup>newBuilder()
                      .setDefaultInstance(InterconnectGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyInterconnectGroupRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyInterconnectGroupRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyInterconnectGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
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
          GetOperationalStatusInterconnectGroupRequest,
          InterconnectGroupsGetOperationalStatusResponse>
      getOperationalStatusMethodDescriptor =
          ApiMethodDescriptor
              .<GetOperationalStatusInterconnectGroupRequest,
                  InterconnectGroupsGetOperationalStatusResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/GetOperationalStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetOperationalStatusInterconnectGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups/{interconnectGroup}/getOperationalStatus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetOperationalStatusInterconnectGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "interconnectGroup", request.getInterconnectGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetOperationalStatusInterconnectGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<InterconnectGroupsGetOperationalStatusResponse>newBuilder()
                      .setDefaultInstance(
                          InterconnectGroupsGetOperationalStatusResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertInterconnectGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertInterconnectGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertInterconnectGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInterconnectGroupRequest> serializer =
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
                                      "interconnectGroupResource",
                                      request.getInterconnectGroupResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertInterconnectGroupRequest request, Operation response) -> {
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
          ListInterconnectGroupsRequest, InterconnectGroupsListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListInterconnectGroupsRequest, InterconnectGroupsListResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInterconnectGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInterconnectGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInterconnectGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<InterconnectGroupsListResponse>newBuilder()
                      .setDefaultInstance(InterconnectGroupsListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchInterconnectGroupRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchInterconnectGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchInterconnectGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups/{interconnectGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "interconnectGroup", request.getInterconnectGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchInterconnectGroupRequest> serializer =
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
                                      "interconnectGroupResource",
                                      request.getInterconnectGroupResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchInterconnectGroupRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetIamPolicyInterconnectGroupRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyInterconnectGroupRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyInterconnectGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyInterconnectGroupRequest> serializer =
                                ProtoRestSerializer.create();
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
          TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectGroups/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsInterconnectGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectGroups/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsInterconnectGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsInterconnectGroupRequest>
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

  private final UnaryCallable<CreateMembersInterconnectGroupRequest, Operation>
      createMembersCallable;
  private final OperationCallable<CreateMembersInterconnectGroupRequest, Operation, Operation>
      createMembersOperationCallable;
  private final UnaryCallable<DeleteInterconnectGroupRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteInterconnectGroupRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetInterconnectGroupRequest, InterconnectGroup> getCallable;
  private final UnaryCallable<GetIamPolicyInterconnectGroupRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<
          GetOperationalStatusInterconnectGroupRequest,
          InterconnectGroupsGetOperationalStatusResponse>
      getOperationalStatusCallable;
  private final UnaryCallable<InsertInterconnectGroupRequest, Operation> insertCallable;
  private final OperationCallable<InsertInterconnectGroupRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListInterconnectGroupsRequest, InterconnectGroupsListResponse>
      listCallable;
  private final UnaryCallable<ListInterconnectGroupsRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<PatchInterconnectGroupRequest, Operation> patchCallable;
  private final OperationCallable<PatchInterconnectGroupRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetIamPolicyInterconnectGroupRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInterconnectGroupsStub create(InterconnectGroupsStubSettings settings)
      throws IOException {
    return new HttpJsonInterconnectGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInterconnectGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInterconnectGroupsStub(
        InterconnectGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInterconnectGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInterconnectGroupsStub(
        InterconnectGroupsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInterconnectGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInterconnectGroupsStub(
      InterconnectGroupsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInterconnectGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInterconnectGroupsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInterconnectGroupsStub(
      InterconnectGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<CreateMembersInterconnectGroupRequest, Operation>
        createMembersTransportSettings =
            HttpJsonCallSettings.<CreateMembersInterconnectGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(createMembersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "interconnect_group", String.valueOf(request.getInterconnectGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteInterconnectGroupRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteInterconnectGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("interconnect_group", String.valueOf(request.getInterconnectGroup()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetInterconnectGroupRequest, InterconnectGroup> getTransportSettings =
        HttpJsonCallSettings.<GetInterconnectGroupRequest, InterconnectGroup>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("interconnect_group", String.valueOf(request.getInterconnectGroup()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyInterconnectGroupRequest, Policy>
        getIamPolicyTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyInterconnectGroupRequest, Policy>newBuilder()
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
    HttpJsonCallSettings<
            GetOperationalStatusInterconnectGroupRequest,
            InterconnectGroupsGetOperationalStatusResponse>
        getOperationalStatusTransportSettings =
            HttpJsonCallSettings
                .<GetOperationalStatusInterconnectGroupRequest,
                    InterconnectGroupsGetOperationalStatusResponse>
                    newBuilder()
                .setMethodDescriptor(getOperationalStatusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "interconnect_group", String.valueOf(request.getInterconnectGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertInterconnectGroupRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertInterconnectGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListInterconnectGroupsRequest, InterconnectGroupsListResponse>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListInterconnectGroupsRequest, InterconnectGroupsListResponse>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PatchInterconnectGroupRequest, Operation> patchTransportSettings =
        HttpJsonCallSettings.<PatchInterconnectGroupRequest, Operation>newBuilder()
            .setMethodDescriptor(patchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("interconnect_group", String.valueOf(request.getInterconnectGroup()));
                  builder.add("project", String.valueOf(request.getProject()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SetIamPolicyInterconnectGroupRequest, Policy>
        setIamPolicyTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyInterconnectGroupRequest, Policy>newBuilder()
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
    HttpJsonCallSettings<TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>newBuilder()
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

    this.createMembersCallable =
        callableFactory.createUnaryCallable(
            createMembersTransportSettings, settings.createMembersSettings(), clientContext);
    this.createMembersOperationCallable =
        callableFactory.createOperationCallable(
            createMembersTransportSettings,
            settings.createMembersOperationSettings(),
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
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.getOperationalStatusCallable =
        callableFactory.createUnaryCallable(
            getOperationalStatusTransportSettings,
            settings.getOperationalStatusSettings(),
            clientContext);
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
    methodDescriptors.add(createMembersMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(getOperationalStatusMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(patchMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CreateMembersInterconnectGroupRequest, Operation> createMembersCallable() {
    return createMembersCallable;
  }

  @Override
  public OperationCallable<CreateMembersInterconnectGroupRequest, Operation, Operation>
      createMembersOperationCallable() {
    return createMembersOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInterconnectGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteInterconnectGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetInterconnectGroupRequest, InterconnectGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyInterconnectGroupRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<
          GetOperationalStatusInterconnectGroupRequest,
          InterconnectGroupsGetOperationalStatusResponse>
      getOperationalStatusCallable() {
    return getOperationalStatusCallable;
  }

  @Override
  public UnaryCallable<InsertInterconnectGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertInterconnectGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectGroupsRequest, InterconnectGroupsListResponse>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectGroupsRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchInterconnectGroupRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchInterconnectGroupRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyInterconnectGroupRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsInterconnectGroupRequest, TestPermissionsResponse>
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
