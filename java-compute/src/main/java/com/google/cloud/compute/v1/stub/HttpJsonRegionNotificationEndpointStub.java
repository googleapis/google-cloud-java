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

import static com.google.cloud.compute.v1.RegionNotificationEndpointClient.ListRegionNotificationEndpointsPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMessageHttpRequestFormatter;
import com.google.api.gax.httpjson.ApiMessageHttpResponseParser;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.DeleteRegionNotificationEndpointHttpRequest;
import com.google.cloud.compute.v1.GetRegionNotificationEndpointHttpRequest;
import com.google.cloud.compute.v1.InsertRegionNotificationEndpointHttpRequest;
import com.google.cloud.compute.v1.ListRegionNotificationEndpointsHttpRequest;
import com.google.cloud.compute.v1.NotificationEndpoint;
import com.google.cloud.compute.v1.NotificationEndpointList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionNotificationEndpointName;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * HTTP stub implementation for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionNotificationEndpointStub extends RegionNotificationEndpointStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionNotificationEndpointHttpRequest, Operation>
      deleteRegionNotificationEndpointMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionNotificationEndpointHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionNotificationEndpoints.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeleteRegionNotificationEndpointHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/notificationEndpoints/{notificationEndpoint}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionNotificationEndpointName.newFactory())
                      .setResourceNameField("notificationEndpoint")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>
      getRegionNotificationEndpointMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>newBuilder()
              .setFullMethodName("compute.regionNotificationEndpoints.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<GetRegionNotificationEndpointHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/notificationEndpoints/{notificationEndpoint}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionNotificationEndpointName.newFactory())
                      .setResourceNameField("notificationEndpoint")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NotificationEndpoint>newBuilder()
                      .setResponseInstance(NotificationEndpoint.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionNotificationEndpointHttpRequest, Operation>
      insertRegionNotificationEndpointMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionNotificationEndpointHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionNotificationEndpoints.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<InsertRegionNotificationEndpointHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/notificationEndpoints"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListRegionNotificationEndpointsHttpRequest, NotificationEndpointList>
      listRegionNotificationEndpointsMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionNotificationEndpointsHttpRequest, NotificationEndpointList>newBuilder()
              .setFullMethodName("compute.regionNotificationEndpoints.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListRegionNotificationEndpointsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/notificationEndpoints"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NotificationEndpointList>newBuilder()
                      .setResponseInstance(NotificationEndpointList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionNotificationEndpointHttpRequest, Operation>
      deleteRegionNotificationEndpointCallable;
  private final UnaryCallable<GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>
      getRegionNotificationEndpointCallable;
  private final UnaryCallable<InsertRegionNotificationEndpointHttpRequest, Operation>
      insertRegionNotificationEndpointCallable;
  private final UnaryCallable<ListRegionNotificationEndpointsHttpRequest, NotificationEndpointList>
      listRegionNotificationEndpointsCallable;
  private final UnaryCallable<
          ListRegionNotificationEndpointsHttpRequest, ListRegionNotificationEndpointsPagedResponse>
      listRegionNotificationEndpointsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionNotificationEndpointStub create(
      RegionNotificationEndpointStubSettings settings) throws IOException {
    return new HttpJsonRegionNotificationEndpointStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionNotificationEndpointStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionNotificationEndpointStub(
        RegionNotificationEndpointStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionNotificationEndpointStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionNotificationEndpointStub(
        RegionNotificationEndpointStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionNotificationEndpointStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNotificationEndpointStub(
      RegionNotificationEndpointStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionNotificationEndpointCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionNotificationEndpointStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNotificationEndpointStub(
      RegionNotificationEndpointStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionNotificationEndpointHttpRequest, Operation>
        deleteRegionNotificationEndpointTransportSettings =
            HttpJsonCallSettings
                .<DeleteRegionNotificationEndpointHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionNotificationEndpointMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>
        getRegionNotificationEndpointTransportSettings =
            HttpJsonCallSettings
                .<GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>newBuilder()
                .setMethodDescriptor(getRegionNotificationEndpointMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionNotificationEndpointHttpRequest, Operation>
        insertRegionNotificationEndpointTransportSettings =
            HttpJsonCallSettings
                .<InsertRegionNotificationEndpointHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionNotificationEndpointMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionNotificationEndpointsHttpRequest, NotificationEndpointList>
        listRegionNotificationEndpointsTransportSettings =
            HttpJsonCallSettings
                .<ListRegionNotificationEndpointsHttpRequest, NotificationEndpointList>newBuilder()
                .setMethodDescriptor(listRegionNotificationEndpointsMethodDescriptor)
                .build();

    this.deleteRegionNotificationEndpointCallable =
        callableFactory.createUnaryCallable(
            deleteRegionNotificationEndpointTransportSettings,
            settings.deleteRegionNotificationEndpointSettings(),
            clientContext);
    this.getRegionNotificationEndpointCallable =
        callableFactory.createUnaryCallable(
            getRegionNotificationEndpointTransportSettings,
            settings.getRegionNotificationEndpointSettings(),
            clientContext);
    this.insertRegionNotificationEndpointCallable =
        callableFactory.createUnaryCallable(
            insertRegionNotificationEndpointTransportSettings,
            settings.insertRegionNotificationEndpointSettings(),
            clientContext);
    this.listRegionNotificationEndpointsCallable =
        callableFactory.createUnaryCallable(
            listRegionNotificationEndpointsTransportSettings,
            settings.listRegionNotificationEndpointsSettings(),
            clientContext);
    this.listRegionNotificationEndpointsPagedCallable =
        callableFactory.createPagedCallable(
            listRegionNotificationEndpointsTransportSettings,
            settings.listRegionNotificationEndpointsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionNotificationEndpointHttpRequest, Operation>
      deleteRegionNotificationEndpointCallable() {
    return deleteRegionNotificationEndpointCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionNotificationEndpointHttpRequest, NotificationEndpoint>
      getRegionNotificationEndpointCallable() {
    return getRegionNotificationEndpointCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionNotificationEndpointHttpRequest, Operation>
      insertRegionNotificationEndpointCallable() {
    return insertRegionNotificationEndpointCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListRegionNotificationEndpointsHttpRequest, ListRegionNotificationEndpointsPagedResponse>
      listRegionNotificationEndpointsPagedCallable() {
    return listRegionNotificationEndpointsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionNotificationEndpointsHttpRequest, NotificationEndpointList>
      listRegionNotificationEndpointsCallable() {
    return listRegionNotificationEndpointsCallable;
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
