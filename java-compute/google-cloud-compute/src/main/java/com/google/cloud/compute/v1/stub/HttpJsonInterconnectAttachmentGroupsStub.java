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

import static com.google.cloud.compute.v1.InterconnectAttachmentGroupsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.GetIamPolicyInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.GetInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.GetOperationalStatusInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.InsertInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.InterconnectAttachmentGroup;
import com.google.cloud.compute.v1.InterconnectAttachmentGroupsGetOperationalStatusResponse;
import com.google.cloud.compute.v1.InterconnectAttachmentGroupsListResponse;
import com.google.cloud.compute.v1.ListInterconnectAttachmentGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.PatchInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyInterconnectAttachmentGroupRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInterconnectAttachmentGroupRequest;
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
 * REST stub implementation for the InterconnectAttachmentGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonInterconnectAttachmentGroupsStub extends InterconnectAttachmentGroupsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteInterconnectAttachmentGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteInterconnectAttachmentGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectAttachmentGroups/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteInterconnectAttachmentGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectAttachmentGroups/{interconnectAttachmentGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInterconnectAttachmentGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "interconnectAttachmentGroup",
                                request.getInterconnectAttachmentGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInterconnectAttachmentGroupRequest>
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
                  (DeleteInterconnectAttachmentGroupRequest request, Operation response) -> {
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
          GetInterconnectAttachmentGroupRequest, InterconnectAttachmentGroup>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetInterconnectAttachmentGroupRequest, InterconnectAttachmentGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectAttachmentGroups/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetInterconnectAttachmentGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectAttachmentGroups/{interconnectAttachmentGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInterconnectAttachmentGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "interconnectAttachmentGroup",
                                request.getInterconnectAttachmentGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInterconnectAttachmentGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InterconnectAttachmentGroup>newBuilder()
                      .setDefaultInstance(InterconnectAttachmentGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyInterconnectAttachmentGroupRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyInterconnectAttachmentGroupRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InterconnectAttachmentGroups/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetIamPolicyInterconnectAttachmentGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectAttachmentGroups/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyInterconnectAttachmentGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyInterconnectAttachmentGroupRequest>
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
          GetOperationalStatusInterconnectAttachmentGroupRequest,
          InterconnectAttachmentGroupsGetOperationalStatusResponse>
      getOperationalStatusMethodDescriptor =
          ApiMethodDescriptor
              .<GetOperationalStatusInterconnectAttachmentGroupRequest,
                  InterconnectAttachmentGroupsGetOperationalStatusResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InterconnectAttachmentGroups/GetOperationalStatus")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetOperationalStatusInterconnectAttachmentGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectAttachmentGroups/{interconnectAttachmentGroup}/getOperationalStatus",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    GetOperationalStatusInterconnectAttachmentGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "interconnectAttachmentGroup",
                                request.getInterconnectAttachmentGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    GetOperationalStatusInterconnectAttachmentGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<InterconnectAttachmentGroupsGetOperationalStatusResponse>newBuilder()
                      .setDefaultInstance(
                          InterconnectAttachmentGroupsGetOperationalStatusResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertInterconnectAttachmentGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertInterconnectAttachmentGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectAttachmentGroups/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<InsertInterconnectAttachmentGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectAttachmentGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInterconnectAttachmentGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInterconnectAttachmentGroupRequest>
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
                                      "interconnectAttachmentGroupResource",
                                      request.getInterconnectAttachmentGroupResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertInterconnectAttachmentGroupRequest request, Operation response) -> {
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
          ListInterconnectAttachmentGroupsRequest, InterconnectAttachmentGroupsListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListInterconnectAttachmentGroupsRequest, InterconnectAttachmentGroupsListResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectAttachmentGroups/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListInterconnectAttachmentGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectAttachmentGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInterconnectAttachmentGroupsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInterconnectAttachmentGroupsRequest>
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
                  ProtoMessageResponseParser.<InterconnectAttachmentGroupsListResponse>newBuilder()
                      .setDefaultInstance(
                          InterconnectAttachmentGroupsListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<PatchInterconnectAttachmentGroupRequest, Operation>
      patchMethodDescriptor =
          ApiMethodDescriptor.<PatchInterconnectAttachmentGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InterconnectAttachmentGroups/Patch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PatchInterconnectAttachmentGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectAttachmentGroups/{interconnectAttachmentGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PatchInterconnectAttachmentGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "interconnectAttachmentGroup",
                                request.getInterconnectAttachmentGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PatchInterconnectAttachmentGroupRequest>
                                serializer = ProtoRestSerializer.create();
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
                                      "interconnectAttachmentGroupResource",
                                      request.getInterconnectAttachmentGroupResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (PatchInterconnectAttachmentGroupRequest request, Operation response) -> {
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

  private static final ApiMethodDescriptor<SetIamPolicyInterconnectAttachmentGroupRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyInterconnectAttachmentGroupRequest, Policy>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InterconnectAttachmentGroups/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetIamPolicyInterconnectAttachmentGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectAttachmentGroups/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyInterconnectAttachmentGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyInterconnectAttachmentGroupRequest>
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
          TestIamPermissionsInterconnectAttachmentGroupRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsInterconnectAttachmentGroupRequest, TestPermissionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InterconnectAttachmentGroups/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsInterconnectAttachmentGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/global/interconnectAttachmentGroups/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    TestIamPermissionsInterconnectAttachmentGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    TestIamPermissionsInterconnectAttachmentGroupRequest>
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

  private final UnaryCallable<DeleteInterconnectAttachmentGroupRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteInterconnectAttachmentGroupRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetInterconnectAttachmentGroupRequest, InterconnectAttachmentGroup>
      getCallable;
  private final UnaryCallable<GetIamPolicyInterconnectAttachmentGroupRequest, Policy>
      getIamPolicyCallable;
  private final UnaryCallable<
          GetOperationalStatusInterconnectAttachmentGroupRequest,
          InterconnectAttachmentGroupsGetOperationalStatusResponse>
      getOperationalStatusCallable;
  private final UnaryCallable<InsertInterconnectAttachmentGroupRequest, Operation> insertCallable;
  private final OperationCallable<InsertInterconnectAttachmentGroupRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<
          ListInterconnectAttachmentGroupsRequest, InterconnectAttachmentGroupsListResponse>
      listCallable;
  private final UnaryCallable<ListInterconnectAttachmentGroupsRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<PatchInterconnectAttachmentGroupRequest, Operation> patchCallable;
  private final OperationCallable<PatchInterconnectAttachmentGroupRequest, Operation, Operation>
      patchOperationCallable;
  private final UnaryCallable<SetIamPolicyInterconnectAttachmentGroupRequest, Policy>
      setIamPolicyCallable;
  private final UnaryCallable<
          TestIamPermissionsInterconnectAttachmentGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonGlobalOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInterconnectAttachmentGroupsStub create(
      InterconnectAttachmentGroupsStubSettings settings) throws IOException {
    return new HttpJsonInterconnectAttachmentGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInterconnectAttachmentGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInterconnectAttachmentGroupsStub(
        InterconnectAttachmentGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInterconnectAttachmentGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInterconnectAttachmentGroupsStub(
        InterconnectAttachmentGroupsStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInterconnectAttachmentGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonInterconnectAttachmentGroupsStub(
      InterconnectAttachmentGroupsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonInterconnectAttachmentGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInterconnectAttachmentGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonInterconnectAttachmentGroupsStub(
      InterconnectAttachmentGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonGlobalOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteInterconnectAttachmentGroupRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteInterconnectAttachmentGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "interconnect_attachment_group",
                          String.valueOf(request.getInterconnectAttachmentGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetInterconnectAttachmentGroupRequest, InterconnectAttachmentGroup>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetInterconnectAttachmentGroupRequest, InterconnectAttachmentGroup>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "interconnect_attachment_group",
                          String.valueOf(request.getInterconnectAttachmentGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetIamPolicyInterconnectAttachmentGroupRequest, Policy>
        getIamPolicyTransportSettings =
            HttpJsonCallSettings
                .<GetIamPolicyInterconnectAttachmentGroupRequest, Policy>newBuilder()
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
            GetOperationalStatusInterconnectAttachmentGroupRequest,
            InterconnectAttachmentGroupsGetOperationalStatusResponse>
        getOperationalStatusTransportSettings =
            HttpJsonCallSettings
                .<GetOperationalStatusInterconnectAttachmentGroupRequest,
                    InterconnectAttachmentGroupsGetOperationalStatusResponse>
                    newBuilder()
                .setMethodDescriptor(getOperationalStatusMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "interconnect_attachment_group",
                          String.valueOf(request.getInterconnectAttachmentGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertInterconnectAttachmentGroupRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertInterconnectAttachmentGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListInterconnectAttachmentGroupsRequest, InterconnectAttachmentGroupsListResponse>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListInterconnectAttachmentGroupsRequest, InterconnectAttachmentGroupsListResponse>
                    newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<PatchInterconnectAttachmentGroupRequest, Operation>
        patchTransportSettings =
            HttpJsonCallSettings.<PatchInterconnectAttachmentGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(patchMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "interconnect_attachment_group",
                          String.valueOf(request.getInterconnectAttachmentGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<SetIamPolicyInterconnectAttachmentGroupRequest, Policy>
        setIamPolicyTransportSettings =
            HttpJsonCallSettings
                .<SetIamPolicyInterconnectAttachmentGroupRequest, Policy>newBuilder()
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
    HttpJsonCallSettings<
            TestIamPermissionsInterconnectAttachmentGroupRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsInterconnectAttachmentGroupRequest, TestPermissionsResponse>
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
  public UnaryCallable<DeleteInterconnectAttachmentGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteInterconnectAttachmentGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetInterconnectAttachmentGroupRequest, InterconnectAttachmentGroup>
      getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyInterconnectAttachmentGroupRequest, Policy>
      getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<
          GetOperationalStatusInterconnectAttachmentGroupRequest,
          InterconnectAttachmentGroupsGetOperationalStatusResponse>
      getOperationalStatusCallable() {
    return getOperationalStatusCallable;
  }

  @Override
  public UnaryCallable<InsertInterconnectAttachmentGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertInterconnectAttachmentGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListInterconnectAttachmentGroupsRequest, InterconnectAttachmentGroupsListResponse>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListInterconnectAttachmentGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<PatchInterconnectAttachmentGroupRequest, Operation> patchCallable() {
    return patchCallable;
  }

  @Override
  public OperationCallable<PatchInterconnectAttachmentGroupRequest, Operation, Operation>
      patchOperationCallable() {
    return patchOperationCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyInterconnectAttachmentGroupRequest, Policy>
      setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<
          TestIamPermissionsInterconnectAttachmentGroupRequest, TestPermissionsResponse>
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
