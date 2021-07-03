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

import static com.google.cloud.compute.v1.RegionNotificationEndpointsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionNotificationEndpointRequest;
import com.google.cloud.compute.v1.GetRegionNotificationEndpointRequest;
import com.google.cloud.compute.v1.InsertRegionNotificationEndpointRequest;
import com.google.cloud.compute.v1.ListRegionNotificationEndpointsRequest;
import com.google.cloud.compute.v1.NotificationEndpoint;
import com.google.cloud.compute.v1.NotificationEndpointList;
import com.google.cloud.compute.v1.Operation;
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
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionNotificationEndpointsStub extends RegionNotificationEndpointsStub {
  private static final ApiMethodDescriptor<DeleteRegionNotificationEndpointRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionNotificationEndpointRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNotificationEndpoints/Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionNotificationEndpointRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/notificationEndpoints/{notificationEndpoint}",
                          new FieldsExtractor<
                              DeleteRegionNotificationEndpointRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                DeleteRegionNotificationEndpointRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionNotificationEndpointRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "notificationEndpoint",
                                  request.getNotificationEndpoint());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionNotificationEndpointRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionNotificationEndpointRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionNotificationEndpointRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionNotificationEndpointRequest, String>() {
                            @Override
                            public String extract(DeleteRegionNotificationEndpointRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetRegionNotificationEndpointRequest, NotificationEndpoint>
      getMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionNotificationEndpointRequest, NotificationEndpoint>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNotificationEndpoints/Get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRegionNotificationEndpointRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/notificationEndpoints/{notificationEndpoint}",
                          new FieldsExtractor<
                              GetRegionNotificationEndpointRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetRegionNotificationEndpointRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionNotificationEndpointRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(
                                  fields,
                                  "notificationEndpoint",
                                  request.getNotificationEndpoint());
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetRegionNotificationEndpointRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetRegionNotificationEndpointRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetRegionNotificationEndpointRequest> serializer =
                                  ProtoRestSerializer.create();
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetRegionNotificationEndpointRequest, String>() {
                            @Override
                            public String extract(GetRegionNotificationEndpointRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NotificationEndpoint>newBuilder()
                      .setDefaultInstance(NotificationEndpoint.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<InsertRegionNotificationEndpointRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionNotificationEndpointRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNotificationEndpoints/Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionNotificationEndpointRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/notificationEndpoints",
                          new FieldsExtractor<
                              InsertRegionNotificationEndpointRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                InsertRegionNotificationEndpointRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionNotificationEndpointRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionNotificationEndpointRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionNotificationEndpointRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionNotificationEndpointRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionNotificationEndpointRequest, String>() {
                            @Override
                            public String extract(InsertRegionNotificationEndpointRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "notificationEndpointResource",
                                      request.getNotificationEndpointResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListRegionNotificationEndpointsRequest, NotificationEndpointList>
      listMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionNotificationEndpointsRequest, NotificationEndpointList>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionNotificationEndpoints/List")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRegionNotificationEndpointsRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/notificationEndpoints",
                          new FieldsExtractor<
                              ListRegionNotificationEndpointsRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                ListRegionNotificationEndpointsRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionNotificationEndpointsRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ListRegionNotificationEndpointsRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ListRegionNotificationEndpointsRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ListRegionNotificationEndpointsRequest>
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
                          new FieldsExtractor<ListRegionNotificationEndpointsRequest, String>() {
                            @Override
                            public String extract(ListRegionNotificationEndpointsRequest request) {
                              return null;
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<NotificationEndpointList>newBuilder()
                      .setDefaultInstance(NotificationEndpointList.getDefaultInstance())
                      .build())
              .build();

  private final UnaryCallable<DeleteRegionNotificationEndpointRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionNotificationEndpointRequest, NotificationEndpoint>
      getCallable;
  private final UnaryCallable<InsertRegionNotificationEndpointRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionNotificationEndpointsRequest, NotificationEndpointList>
      listCallable;
  private final UnaryCallable<ListRegionNotificationEndpointsRequest, ListPagedResponse>
      listPagedCallable;

  private final BackgroundResource backgroundResources;
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

    HttpJsonCallSettings<DeleteRegionNotificationEndpointRequest, Operation>
        deleteTransportSettings =
            HttpJsonCallSettings.<DeleteRegionNotificationEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionNotificationEndpointRequest, NotificationEndpoint>
        getTransportSettings =
            HttpJsonCallSettings
                .<GetRegionNotificationEndpointRequest, NotificationEndpoint>newBuilder()
                .setMethodDescriptor(getMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionNotificationEndpointRequest, Operation>
        insertTransportSettings =
            HttpJsonCallSettings.<InsertRegionNotificationEndpointRequest, Operation>newBuilder()
                .setMethodDescriptor(insertMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionNotificationEndpointsRequest, NotificationEndpointList>
        listTransportSettings =
            HttpJsonCallSettings
                .<ListRegionNotificationEndpointsRequest, NotificationEndpointList>newBuilder()
                .setMethodDescriptor(listMethodDescriptor)
                .build();

    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
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
  public UnaryCallable<GetRegionNotificationEndpointRequest, NotificationEndpoint> getCallable() {
    return getCallable;
  }

  @Override
  public UnaryCallable<InsertRegionNotificationEndpointRequest, Operation> insertCallable() {
    return insertCallable;
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
