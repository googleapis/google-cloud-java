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

import static com.google.cloud.compute.v1.RegionNotificationEndpointsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionNotificationEndpointRequest;
import com.google.cloud.compute.v1.GetRegionNotificationEndpointRequest;
import com.google.cloud.compute.v1.InsertRegionNotificationEndpointRequest;
import com.google.cloud.compute.v1.ListRegionNotificationEndpointsRequest;
import com.google.cloud.compute.v1.NotificationEndpoint;
import com.google.cloud.compute.v1.NotificationEndpointList;
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
 * REST stub implementation for the RegionNotificationEndpoints service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonRegionNotificationEndpointsStub extends RegionNotificationEndpointsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder().add(Operation.getDescriptor()).build();

  private static final ApiMethodDescriptor<DeleteRegionNotificationEndpointRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionNotificationEndpointRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNotificationEndpoints/Delete")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionNotificationEndpointRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/notificationEndpoints/{notificationEndpoint}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionNotificationEndpointRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "notificationEndpoint", request.getNotificationEndpoint());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteRegionNotificationEndpointRequest>
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
                  (DeleteRegionNotificationEndpointRequest request, Operation response) -> {
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
          GetRegionNotificationEndpointRequest, NotificationEndpoint>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionNotificationEndpointRequest, NotificationEndpoint>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNotificationEndpoints/Get")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionNotificationEndpointRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/notificationEndpoints/{notificationEndpoint}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionNotificationEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "notificationEndpoint", request.getNotificationEndpoint());
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRegionNotificationEndpointRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NotificationEndpoint>newBuilder()
                      .setDefaultInstance(NotificationEndpoint.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRegionNotificationEndpointRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionNotificationEndpointRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNotificationEndpoints/Insert")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionNotificationEndpointRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/notificationEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionNotificationEndpointRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InsertRegionNotificationEndpointRequest>
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
                                      "notificationEndpointResource",
                                      request.getNotificationEndpointResource(),
                                      false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InsertRegionNotificationEndpointRequest request, Operation response) -> {
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
          ListRegionNotificationEndpointsRequest, NotificationEndpointList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionNotificationEndpointsRequest, NotificationEndpointList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNotificationEndpoints/List")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionNotificationEndpointsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/notificationEndpoints",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionNotificationEndpointsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "project", request.getProject());
                            serializer.putPathParam(fields, "region", request.getRegion());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRegionNotificationEndpointsRequest> serializer =
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
                  ProtoMessageResponseParser.<NotificationEndpointList>newBuilder()
                      .setDefaultInstance(NotificationEndpointList.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<DeleteRegionNotificationEndpointRequest, Operation> deleteCallable;
  private final OperationCallable<DeleteRegionNotificationEndpointRequest, Operation, Operation>
      deleteOperationCallable;
  private final UnaryCallable<GetRegionNotificationEndpointRequest, NotificationEndpoint>
      getCallable;
  private final UnaryCallable<InsertRegionNotificationEndpointRequest, Operation> insertCallable;
  private final OperationCallable<InsertRegionNotificationEndpointRequest, Operation, Operation>
      insertOperationCallable;
  private final UnaryCallable<ListRegionNotificationEndpointsRequest, NotificationEndpointList>
      listCallable;
  private final UnaryCallable<ListRegionNotificationEndpointsRequest, ListPagedResponse>
      listPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonRegionOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionNotificationEndpointsStub create(
      RegionNotificationEndpointsStubSettings settings) throws IOException {
    return new HttpJsonRegionNotificationEndpointsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionNotificationEndpointsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionNotificationEndpointsStub(
        RegionNotificationEndpointsStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionNotificationEndpointsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionNotificationEndpointsStub(
        RegionNotificationEndpointsStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionNotificationEndpointsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNotificationEndpointsStub(
      RegionNotificationEndpointsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionNotificationEndpointsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionNotificationEndpointsStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNotificationEndpointsStub(
      RegionNotificationEndpointsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonRegionOperationsStub.create(clientContext, callableFactory);

    HttpJsonCallSettings<DeleteRegionNotificationEndpointRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteRegionNotificationEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetRegionNotificationEndpointRequest, NotificationEndpoint>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetRegionNotificationEndpointRequest, NotificationEndpoint>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<InsertRegionNotificationEndpointRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertRegionNotificationEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListRegionNotificationEndpointsRequest, NotificationEndpointList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionNotificationEndpointsRequest, NotificationEndpointList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
    methodDescriptors.add(deleteMethodDescriptor);
    methodDescriptors.add(getMethodDescriptor);
    methodDescriptors.add(insertMethodDescriptor);
    methodDescriptors.add(listMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<DeleteRegionNotificationEndpointRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  @Override
  public OperationCallable<DeleteRegionNotificationEndpointRequest, Operation, Operation>
      deleteOperationCallable() {
    return deleteOperationCallable;
  }

  @Override
  public UnaryCallable<GetRegionNotificationEndpointRequest, NotificationEndpoint> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionNotificationEndpointRequest, Operation> insertCallable() {
    return insertCallable;
  }

  @Override
  public OperationCallable<InsertRegionNotificationEndpointRequest, Operation, Operation>
      insertOperationCallable() {
    return insertOperationCallable;
  }

  @Override
  public UnaryCallable<ListRegionNotificationEndpointsRequest, NotificationEndpointList>
      listCallable() {
    return listCallable;
  }

  @Override
  public UnaryCallable<ListRegionNotificationEndpointsRequest, ListPagedResponse>
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
