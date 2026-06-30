/*
 * Copyright 2026 Google LLC
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

import static com.google.cloud.compute.v1.RegionInstantSnapshotGroupsClient.ListPagedResponse;

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
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.DeleteRegionInstantSnapshotGroupRequest;
import com.google.cloud.compute.v1.GetIamPolicyRegionInstantSnapshotGroupRequest;
import com.google.cloud.compute.v1.GetRegionInstantSnapshotGroupRequest;
import com.google.cloud.compute.v1.InsertRegionInstantSnapshotGroupRequest;
import com.google.cloud.compute.v1.InstantSnapshotGroup;
import com.google.cloud.compute.v1.ListInstantSnapshotGroups;
import com.google.cloud.compute.v1.ListRegionInstantSnapshotGroupsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyRegionInstantSnapshotGroupRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionInstantSnapshotGroupRequest;
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
 * REST stub implementation for the RegionInstantSnapshotGroups service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonRegionInstantSnapshotGroupsStub extends RegionInstantSnapshotGroupsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteRegionInstantSnapshotGroupRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionInstantSnapshotGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstantSnapshotGroups/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionInstantSnapshotGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instantSnapshotGroups/{instantSnapshotGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionInstantSnapshotGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instantSnapshotGroup", request.getInstantSnapshotGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionInstantSnapshotGroupRequest>
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
                  (DeleteRegionInstantSnapshotGroupRequest request, Operation response) -> {
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
          GetRegionInstantSnapshotGroupRequest, InstantSnapshotGroup>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionInstantSnapshotGroupRequest, InstantSnapshotGroup>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstantSnapshotGroups/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionInstantSnapshotGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instantSnapshotGroups/{instantSnapshotGroup}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionInstantSnapshotGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instantSnapshotGroup", request.getInstantSnapshotGroup());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionInstantSnapshotGroupRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstantSnapshotGroup>newBuilder()
                      .setDefaultInstance(InstantSnapshotGroup.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRegionInstantSnapshotGroupRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstantSnapshotGroups/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetIamPolicyRegionInstantSnapshotGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instantSnapshotGroups/{resource}/getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRegionInstantSnapshotGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRegionInstantSnapshotGroupRequest>
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

  private static final ApiMethodDescriptor<InsertRegionInstantSnapshotGroupRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionInstantSnapshotGroupRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstantSnapshotGroups/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionInstantSnapshotGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instantSnapshotGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionInstantSnapshotGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionInstantSnapshotGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            if (request.hasRequestId()) {
                              serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            }
                            if (request.hasSourceConsistencyGroup()) {
                              serializer.putQueryParam(
                                  fields,
                                  "sourceConsistencyGroup",
                                  request.getSourceConsistencyGroup());
                            }
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "instantSnapshotGroupResource",
                                      request.getInstantSnapshotGroupResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertRegionInstantSnapshotGroupRequest request, Operation response) -> {
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
          ListRegionInstantSnapshotGroupsRequest, ListInstantSnapshotGroups>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionInstantSnapshotGroupsRequest, ListInstantSnapshotGroups>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstantSnapshotGroups/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionInstantSnapshotGroupsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instantSnapshotGroups",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionInstantSnapshotGroupsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionInstantSnapshotGroupsRequest> serializer =
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
                  ProtoMessageResponseParser.<ListInstantSnapshotGroups>newBuilder()
                      .setDefaultInstance(ListInstantSnapshotGroups.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRegionInstantSnapshotGroupRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionInstantSnapshotGroups/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SetIamPolicyRegionInstantSnapshotGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instantSnapshotGroups/{resource}/setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRegionInstantSnapshotGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRegionInstantSnapshotGroupRequest>
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
          TestIamPermissionsRegionInstantSnapshotGroupRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsRegionInstantSnapshotGroupRequest, TestPermissionsResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstantSnapshotGroups/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<TestIamPermissionsRegionInstantSnapshotGroupRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instantSnapshotGroups/{resource}/testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRegionInstantSnapshotGroupRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRegionInstantSnapshotGroupRequest>
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

  private final UnaryCallable<DeleteRegionInstantSnapshotGroupRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRegionInstantSnapshotGroupRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetRegionInstantSnapshotGroupRequest, InstantSnapshotGroup>
      getCallable;
  private final UnaryCallable<GetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
      getIamPolicyCallable;
  private final UnaryCallable<InsertRegionInstantSnapshotGroupRequest, Operation> insertCallable;
  private final OperationCallable<InsertRegionInstantSnapshotGroupRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListRegionInstantSnapshotGroupsRequest, ListInstantSnapshotGroups>
      listCallable;
  private final UnaryCallable<ListRegionInstantSnapshotGroupsRequest, ListPagedResponse>
      listPagedCallable;
  private final UnaryCallable<SetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
      setIamPolicyCallable;
  private final UnaryCallable<
          TestIamPermissionsRegionInstantSnapshotGroupRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/instantSnapshotGroups/{instant_snapshot_group}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/instantSnapshotGroups/{instant_snapshot_group}");
  private static final PathTemplate GET_IAM_POLICY_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/regions/{region}/instantSnapshotGroups/{resource}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/regions/{region}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/regions/{region}");
  private static final PathTemplate SET_IAM_POLICY_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/regions/{region}/instantSnapshotGroups/{resource}");
  private static final PathTemplate TEST_IAM_PERMISSIONS_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create("projects/{project}/regions/{region}/instantSnapshotGroups/{resource}");

  public static final HttpJsonRegionInstantSnapshotGroupsStub create(
      RegionInstantSnapshotGroupsStubSettings settings) throws IOException {
    return new HttpJsonRegionInstantSnapshotGroupsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionInstantSnapshotGroupsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionInstantSnapshotGroupsStub(
        RegionInstantSnapshotGroupsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionInstantSnapshotGroupsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionInstantSnapshotGroupsStub(
        RegionInstantSnapshotGroupsStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionInstantSnapshotGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionInstantSnapshotGroupsStub(
      RegionInstantSnapshotGroupsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionInstantSnapshotGroupsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionInstantSnapshotGroupsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionInstantSnapshotGroupsStub(
      RegionInstantSnapshotGroupsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteRegionInstantSnapshotGroupRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteRegionInstantSnapshotGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instant_snapshot_group",
                          String.valueOf(request.getInstantSnapshotGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "instant_snapshot_group",
                          String.valueOf(request.getInstantSnapshotGroup()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<GetRegionInstantSnapshotGroupRequest, InstantSnapshotGroup>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetRegionInstantSnapshotGroupRequest, InstantSnapshotGroup>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instant_snapshot_group",
                          String.valueOf(request.getInstantSnapshotGroup()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "instant_snapshot_group",
                          String.valueOf(request.getInstantSnapshotGroup()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<GetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
        getIamPolicyTransportSettings =
            HttpJsonCallSettings.<GetIamPolicyRegionInstantSnapshotGroupRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      resourceNameSegments.put("resource", String.valueOf(request.getResource()));
                      return GET_IAM_POLICY_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<InsertRegionInstantSnapshotGroupRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertRegionInstantSnapshotGroupRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<ListRegionInstantSnapshotGroupsRequest, ListInstantSnapshotGroups>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionInstantSnapshotGroupsRequest, ListInstantSnapshotGroups>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<SetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
        setIamPolicyTransportSettings =
            HttpJsonCallSettings.<SetIamPolicyRegionInstantSnapshotGroupRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicyMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      resourceNameSegments.put("resource", String.valueOf(request.getResource()));
                      return SET_IAM_POLICY_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<
            TestIamPermissionsRegionInstantSnapshotGroupRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsRegionInstantSnapshotGroupRequest, TestPermissionsResponse>
                    newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      resourceNameSegments.put("resource", String.valueOf(request.getResource()));
                      return TEST_IAM_PERMISSIONS_RESOURCE_NAME_TEMPLATE.instantiate(
                          resourceNameSegments);
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
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteRegionInstantSnapshotGroupRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRegionInstantSnapshotGroupRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRegionInstantSnapshotGroupRequest, InstantSnapshotGroup> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
      getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<InsertRegionInstantSnapshotGroupRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRegionInstantSnapshotGroupRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegionInstantSnapshotGroupsRequest, ListInstantSnapshotGroups>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionInstantSnapshotGroupsRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
  }

  @Override
  public UnaryCallable<SetIamPolicyRegionInstantSnapshotGroupRequest, Policy>
      setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRegionInstantSnapshotGroupRequest, TestPermissionsResponse>
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
