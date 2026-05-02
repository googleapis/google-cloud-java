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

import static com.google.cloud.compute.v1.RegionInstanceGroupManagerResizeRequestsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.CancelRegionInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.DeleteRegionInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.GetRegionInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.InsertRegionInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.InstanceGroupManagerResizeRequest;
import com.google.cloud.compute.v1.ListRegionInstanceGroupManagerResizeRequestsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
import com.google.cloud.compute.v1.RegionInstanceGroupManagerResizeRequestsListResponse;
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
 * REST stub implementation for the RegionInstanceGroupManagerResizeRequests service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonRegionInstanceGroupManagerResizeRequestsStub
    extends RegionInstanceGroupManagerResizeRequestsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          CancelRegionInstanceGroupManagerResizeRequestRequest, Operation>
      cancelMethodDescriptor =
          ApiMethodDescriptor
              .<CancelRegionInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagerResizeRequests/Cancel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CancelRegionInstanceGroupManagerResizeRequestRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/resizeRequests/{resizeRequest}/cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    CancelRegionInstanceGroupManagerResizeRequestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "resizeRequest", request.getResizeRequest());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    CancelRegionInstanceGroupManagerResizeRequestRequest>
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
                  (CancelRegionInstanceGroupManagerResizeRequestRequest request,
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

  private static final ApiMethodDescriptor<
          DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagerResizeRequests/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteRegionInstanceGroupManagerResizeRequestRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/resizeRequests/{resizeRequest}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    DeleteRegionInstanceGroupManagerResizeRequestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "resizeRequest", request.getResizeRequest());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    DeleteRegionInstanceGroupManagerResizeRequestRequest>
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
                  (DeleteRegionInstanceGroupManagerResizeRequestRequest request,
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

  private static final ApiMethodDescriptor<
          GetRegionInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionInstanceGroupManagerResizeRequestRequest,
                  InstanceGroupManagerResizeRequest>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagerResizeRequests/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetRegionInstanceGroupManagerResizeRequestRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/resizeRequests/{resizeRequest}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionInstanceGroupManagerResizeRequestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            serializer.putPathParam(
                                fields, "resizeRequest", request.getResizeRequest());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionInstanceGroupManagerResizeRequestRequest>
                                serializer = ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<InstanceGroupManagerResizeRequest>newBuilder()
                      .setDefaultInstance(InstanceGroupManagerResizeRequest.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          InsertRegionInstanceGroupManagerResizeRequestRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor
              .<InsertRegionInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagerResizeRequests/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<InsertRegionInstanceGroupManagerResizeRequestRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/resizeRequests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    InsertRegionInstanceGroupManagerResizeRequestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    InsertRegionInstanceGroupManagerResizeRequestRequest>
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
                                      "instanceGroupManagerResizeRequestResource",
                                      request.getInstanceGroupManagerResizeRequestResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertRegionInstanceGroupManagerResizeRequestRequest request,
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

  private static final ApiMethodDescriptor<
          ListRegionInstanceGroupManagerResizeRequestsRequest,
          RegionInstanceGroupManagerResizeRequestsListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionInstanceGroupManagerResizeRequestsRequest,
                  RegionInstanceGroupManagerResizeRequestsListResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.RegionInstanceGroupManagerResizeRequests/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListRegionInstanceGroupManagerResizeRequestsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/resizeRequests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionInstanceGroupManagerResizeRequestsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionInstanceGroupManagerResizeRequestsRequest>
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
                      .<RegionInstanceGroupManagerResizeRequestsListResponse>newBuilder()
                      .setDefaultInstance(
                          RegionInstanceGroupManagerResizeRequestsListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CancelRegionInstanceGroupManagerResizeRequestRequest, Operation>
      cancelCallable;
  private final OperationCallable<
          CancelRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      cancelOperationCallable;
  private final UnaryCallable<DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation>
      deleteCallable;
  private final OperationCallable<
          DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<
          GetRegionInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getCallable;
  private final UnaryCallable<InsertRegionInstanceGroupManagerResizeRequestRequest, Operation>
      insertCallable;
  private final OperationCallable<
          InsertRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<
          ListRegionInstanceGroupManagerResizeRequestsRequest,
          RegionInstanceGroupManagerResizeRequestsListResponse>
      listCallable;
  private final UnaryCallable<
          ListRegionInstanceGroupManagerResizeRequestsRequest, ListPagedResponse>
      listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  private static final PathTemplate CANCEL_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/instanceGroupManagers/{instance_group_manager}/resizeRequests/{resize_request}");
  private static final PathTemplate DELETE_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/instanceGroupManagers/{instance_group_manager}/resizeRequests/{resize_request}");
  private static final PathTemplate GET_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/instanceGroupManagers/{instance_group_manager}/resizeRequests/{resize_request}");
  private static final PathTemplate INSERT_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/instanceGroupManagers/{instance_group_manager}");
  private static final PathTemplate LIST_RESOURCE_NAME_TEMPLATE =
      PathTemplate.create(
          "projects/{project}/regions/{region}/instanceGroupManagers/{instance_group_manager}");

  public static final HttpJsonRegionInstanceGroupManagerResizeRequestsStub create(
      RegionInstanceGroupManagerResizeRequestsStubSettings settings) throws IOException {
    return new HttpJsonRegionInstanceGroupManagerResizeRequestsStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionInstanceGroupManagerResizeRequestsStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonRegionInstanceGroupManagerResizeRequestsStub(
        RegionInstanceGroupManagerResizeRequestsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionInstanceGroupManagerResizeRequestsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionInstanceGroupManagerResizeRequestsStub(
        RegionInstanceGroupManagerResizeRequestsStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionInstanceGroupManagerResizeRequestsStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonRegionInstanceGroupManagerResizeRequestsStub(
      RegionInstanceGroupManagerResizeRequestsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(
        settings,
        clientContext,
        new HttpJsonRegionInstanceGroupManagerResizeRequestsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionInstanceGroupManagerResizeRequestsStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonRegionInstanceGroupManagerResizeRequestsStub(
      RegionInstanceGroupManagerResizeRequestsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<CancelRegionInstanceGroupManagerResizeRequestRequest, Operation>
        cancelTransportSettings =
            HttpJsonCallSettings
                .<CancelRegionInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
                .setMethodDescriptor(cancelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("resize_request", String.valueOf(request.getResizeRequest()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      resourceNameSegments.put(
                          "resize_request", String.valueOf(request.getResizeRequest()));
                      return CANCEL_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings
                .<DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("resize_request", String.valueOf(request.getResizeRequest()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      resourceNameSegments.put(
                          "resize_request", String.valueOf(request.getResizeRequest()));
                      return DELETE_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<
            GetRegionInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetRegionInstanceGroupManagerResizeRequestRequest,
                    InstanceGroupManagerResizeRequest>
                    newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      builder.add("resize_request", String.valueOf(request.getResizeRequest()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      resourceNameSegments.put(
                          "resize_request", String.valueOf(request.getResizeRequest()));
                      return GET_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<InsertRegionInstanceGroupManagerResizeRequestRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings
                .<InsertRegionInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return INSERT_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();
    HttpJsonCallSettings<
            ListRegionInstanceGroupManagerResizeRequestsRequest,
            RegionInstanceGroupManagerResizeRequestsListResponse>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionInstanceGroupManagerResizeRequestsRequest,
                    RegionInstanceGroupManagerResizeRequestsListResponse>
                    newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("region", String.valueOf(request.getRegion()));
                      return builder.build();
                    })
                .setResourceNameExtractor(
                    request -> {
                      Map<String, String> resourceNameSegments = new HashMap<String, String>();
                      resourceNameSegments.put(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      resourceNameSegments.put("project", String.valueOf(request.getProject()));
                      resourceNameSegments.put("region", String.valueOf(request.getRegion()));
                      return LIST_RESOURCE_NAME_TEMPLATE.instantiate(resourceNameSegments);
                    })
                .build();

    this.cancelCallable =
        callableFactory.createUnaryCallable(
            cancelTransportSettings, settings.cancelSettings(), clientContext);
    this.cancelOperationCallable =
        callableFactory.createOperationCallable(
            cancelTransportSettings,
            settings.cancelOperationSettings(),
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(cancelMethodDescriptor);
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<CancelRegionInstanceGroupManagerResizeRequestRequest, Operation>
      cancelCallable() {
    return cancelCallable;
  }

  @Override
  public OperationCallable<
          CancelRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      cancelOperationCallable() {
    return cancelOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation>
      deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<
          DeleteRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<
          GetRegionInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionInstanceGroupManagerResizeRequestRequest, Operation>
      insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<
          InsertRegionInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListRegionInstanceGroupManagerResizeRequestsRequest,
          RegionInstanceGroupManagerResizeRequestsListResponse>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionInstanceGroupManagerResizeRequestsRequest, ListPagedResponse>
      listPagedCallable() {
    return listPagedCallable;
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
