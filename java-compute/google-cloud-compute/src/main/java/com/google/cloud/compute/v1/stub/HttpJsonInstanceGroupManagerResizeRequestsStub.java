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

import static com.google.cloud.compute.v1.InstanceGroupManagerResizeRequestsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.CancelInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.GetInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupManagerResizeRequestRequest;
import com.google.cloud.compute.v1.InstanceGroupManagerResizeRequest;
import com.google.cloud.compute.v1.InstanceGroupManagerResizeRequestsListResponse;
import com.google.cloud.compute.v1.ListInstanceGroupManagerResizeRequestsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Operation.Status;
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
 * REST stub implementation for the InstanceGroupManagerResizeRequests service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonInstanceGroupManagerResizeRequestsStub
    extends InstanceGroupManagerResizeRequestsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<
          CancelInstanceGroupManagerResizeRequestRequest, Operation>
      cancelMethodDescriptor =
          ApiMethodDescriptor
              .<CancelInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagerResizeRequests/Cancel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CancelInstanceGroupManagerResizeRequestRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests/{resizeRequest}/cancel",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CancelInstanceGroupManagerResizeRequestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "resizeRequest", request.getResizeRequest());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CancelInstanceGroupManagerResizeRequestRequest>
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
                  (CancelInstanceGroupManagerResizeRequestRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
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
          DeleteInstanceGroupManagerResizeRequestRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor
              .<DeleteInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagerResizeRequests/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteInstanceGroupManagerResizeRequestRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests/{resizeRequest}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceGroupManagerResizeRequestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "resizeRequest", request.getResizeRequest());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteInstanceGroupManagerResizeRequestRequest>
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
                  (DeleteInstanceGroupManagerResizeRequestRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
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
          GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagerResizeRequests/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetInstanceGroupManagerResizeRequestRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests/{resizeRequest}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceGroupManagerResizeRequestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(
                                fields, "resizeRequest", request.getResizeRequest());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetInstanceGroupManagerResizeRequestRequest>
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
          InsertInstanceGroupManagerResizeRequestRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor
              .<InsertInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.compute.v1.InstanceGroupManagerResizeRequests/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<InsertInstanceGroupManagerResizeRequestRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInstanceGroupManagerResizeRequestRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertInstanceGroupManagerResizeRequestRequest>
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
                  (InsertInstanceGroupManagerResizeRequestRequest request, Operation response) -> {
                    StringBuilder opName = new StringBuilder(response.getName());
                    opName.append(":").append(request.getProject());
                    opName.append(":").append(request.getZone());
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
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListInstanceGroupManagerResizeRequestsRequest,
                  InstanceGroupManagerResizeRequestsListResponse>
                  newBuilder()
              .setFullMethodName("google.cloud.compute.v1.InstanceGroupManagerResizeRequests/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListInstanceGroupManagerResizeRequestsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resizeRequests",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstanceGroupManagerResizeRequestsRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "instanceGroupManager", request.getInstanceGroupManager());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "zone", request.getZone());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListInstanceGroupManagerResizeRequestsRequest>
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
                      .<InstanceGroupManagerResizeRequestsListResponse>newBuilder()
                      .setDefaultInstance(
                          InstanceGroupManagerResizeRequestsListResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CancelInstanceGroupManagerResizeRequestRequest, Operation>
      cancelCallable;
  private final OperationCallable<
          CancelInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      cancelOperationCallable;
  private final UnaryCallable<DeleteInstanceGroupManagerResizeRequestRequest, Operation>
      deleteCallable;
  private final OperationCallable<
          DeleteInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<
          GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getCallable;
  private final UnaryCallable<InsertInstanceGroupManagerResizeRequestRequest, Operation>
      insertCallable;
  private final OperationCallable<
          InsertInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse>
      listCallable;
  private final UnaryCallable<ListInstanceGroupManagerResizeRequestsRequest, ListPagedResponse>
      listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonZoneOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstanceGroupManagerResizeRequestsStub create(
      InstanceGroupManagerResizeRequestsStubSettings settings) throws IOException {
    return new HttpJsonInstanceGroupManagerResizeRequestsStub(
        settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstanceGroupManagerResizeRequestsStub create(
      ClientContext clientContext) throws IOException {
    return new HttpJsonInstanceGroupManagerResizeRequestsStub(
        InstanceGroupManagerResizeRequestsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstanceGroupManagerResizeRequestsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstanceGroupManagerResizeRequestsStub(
        InstanceGroupManagerResizeRequestsStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupManagerResizeRequestsStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonInstanceGroupManagerResizeRequestsStub(
      InstanceGroupManagerResizeRequestsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonInstanceGroupManagerResizeRequestsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupManagerResizeRequestsStub, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonInstanceGroupManagerResizeRequestsStub(
      InstanceGroupManagerResizeRequestsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub = HttpJsonZoneOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<CancelInstanceGroupManagerResizeRequestRequest, Operation>
        cancelTransportSettings =
            HttpJsonCallSettings
                .<CancelInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
                .setMethodDescriptor(cancelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("resize_request", String.valueOf(request.getResizeRequest()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteInstanceGroupManagerResizeRequestRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings
                .<DeleteInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("resize_request", String.valueOf(request.getResizeRequest()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
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
                      builder.add("resize_request", String.valueOf(request.getResizeRequest()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InsertInstanceGroupManagerResizeRequestRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings
                .<InsertInstanceGroupManagerResizeRequestRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "instance_group_manager",
                          String.valueOf(request.getInstanceGroupManager()));
                      builder.add("project", String.valueOf(request.getProject()));
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListInstanceGroupManagerResizeRequestsRequest,
            InstanceGroupManagerResizeRequestsListResponse>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListInstanceGroupManagerResizeRequestsRequest,
                    InstanceGroupManagerResizeRequestsListResponse>
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
                      builder.add("zone", String.valueOf(request.getZone()));
                      return builder.build();
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
  public UnaryCallable<CancelInstanceGroupManagerResizeRequestRequest, Operation> cancelCallable() {
    return cancelCallable;
  }

  @Override
  public OperationCallable<CancelInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      cancelOperationCallable() {
    return cancelOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteInstanceGroupManagerResizeRequestRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<
          GetInstanceGroupManagerResizeRequestRequest, InstanceGroupManagerResizeRequest>
      getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertInstanceGroupManagerResizeRequestRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertInstanceGroupManagerResizeRequestRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<
          ListInstanceGroupManagerResizeRequestsRequest,
          InstanceGroupManagerResizeRequestsListResponse>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListInstanceGroupManagerResizeRequestsRequest, ListPagedResponse>
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
