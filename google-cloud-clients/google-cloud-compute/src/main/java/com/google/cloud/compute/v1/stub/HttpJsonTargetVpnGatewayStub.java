/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.compute.v1.TargetVpnGatewayClient.AggregatedListTargetVpnGatewaysPagedResponse;
import static com.google.cloud.compute.v1.TargetVpnGatewayClient.ListTargetVpnGatewaysPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListTargetVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.DeleteTargetVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.GetTargetVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.InsertTargetVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ListTargetVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionTargetVpnGatewayName;
import com.google.cloud.compute.v1.TargetVpnGateway;
import com.google.cloud.compute.v1.TargetVpnGatewayAggregatedList;
import com.google.cloud.compute.v1.TargetVpnGatewayList;
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
public class HttpJsonTargetVpnGatewayStub extends TargetVpnGatewayStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListTargetVpnGatewaysHttpRequest, TargetVpnGatewayAggregatedList>
      aggregatedListTargetVpnGatewaysMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetVpnGatewaysHttpRequest, TargetVpnGatewayAggregatedList>
                  newBuilder()
              .setFullMethodName("compute.targetVpnGateways.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListTargetVpnGatewaysHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/aggregated/targetVpnGateways"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetVpnGatewayAggregatedList>newBuilder()
                      .setResponseInstance(TargetVpnGatewayAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetVpnGatewayHttpRequest, Operation>
      deleteTargetVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetVpnGatewayHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetVpnGateways.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteTargetVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetVpnGateways/{targetVpnGateway}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetVpnGatewayName.newFactory())
                      .setResourceNameField("targetVpnGateway")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetTargetVpnGatewayHttpRequest, TargetVpnGateway>
      getTargetVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<GetTargetVpnGatewayHttpRequest, TargetVpnGateway>newBuilder()
              .setFullMethodName("compute.targetVpnGateways.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetTargetVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetVpnGateways/{targetVpnGateway}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionTargetVpnGatewayName.newFactory())
                      .setResourceNameField("targetVpnGateway")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetVpnGateway>newBuilder()
                      .setResponseInstance(TargetVpnGateway.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetVpnGatewayHttpRequest, Operation>
      insertTargetVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetVpnGatewayHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetVpnGateways.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertTargetVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/targetVpnGateways"))
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
  public static final ApiMethodDescriptor<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList>
      listTargetVpnGatewaysMethodDescriptor =
          ApiMethodDescriptor.<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList>newBuilder()
              .setFullMethodName("compute.targetVpnGateways.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListTargetVpnGatewaysHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/targetVpnGateways"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetVpnGatewayList>newBuilder()
                      .setResponseInstance(TargetVpnGatewayList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListTargetVpnGatewaysHttpRequest, TargetVpnGatewayAggregatedList>
      aggregatedListTargetVpnGatewaysCallable;
  private final UnaryCallable<
          AggregatedListTargetVpnGatewaysHttpRequest, AggregatedListTargetVpnGatewaysPagedResponse>
      aggregatedListTargetVpnGatewaysPagedCallable;
  private final UnaryCallable<DeleteTargetVpnGatewayHttpRequest, Operation>
      deleteTargetVpnGatewayCallable;
  private final UnaryCallable<GetTargetVpnGatewayHttpRequest, TargetVpnGateway>
      getTargetVpnGatewayCallable;
  private final UnaryCallable<InsertTargetVpnGatewayHttpRequest, Operation>
      insertTargetVpnGatewayCallable;
  private final UnaryCallable<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList>
      listTargetVpnGatewaysCallable;
  private final UnaryCallable<ListTargetVpnGatewaysHttpRequest, ListTargetVpnGatewaysPagedResponse>
      listTargetVpnGatewaysPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetVpnGatewayStub create(TargetVpnGatewayStubSettings settings)
      throws IOException {
    return new HttpJsonTargetVpnGatewayStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetVpnGatewayStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetVpnGatewayStub(
        TargetVpnGatewayStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetVpnGatewayStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetVpnGatewayStub(
        TargetVpnGatewayStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetVpnGatewayStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetVpnGatewayStub(
      TargetVpnGatewayStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetVpnGatewayCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetVpnGatewayStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetVpnGatewayStub(
      TargetVpnGatewayStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListTargetVpnGatewaysHttpRequest, TargetVpnGatewayAggregatedList>
        aggregatedListTargetVpnGatewaysTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetVpnGatewaysHttpRequest, TargetVpnGatewayAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListTargetVpnGatewaysMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteTargetVpnGatewayHttpRequest, Operation>
        deleteTargetVpnGatewayTransportSettings =
            HttpJsonCallSettings.<DeleteTargetVpnGatewayHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTargetVpnGatewayMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetTargetVpnGatewayHttpRequest, TargetVpnGateway>
        getTargetVpnGatewayTransportSettings =
            HttpJsonCallSettings.<GetTargetVpnGatewayHttpRequest, TargetVpnGateway>newBuilder()
                .setMethodDescriptor(getTargetVpnGatewayMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertTargetVpnGatewayHttpRequest, Operation>
        insertTargetVpnGatewayTransportSettings =
            HttpJsonCallSettings.<InsertTargetVpnGatewayHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertTargetVpnGatewayMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList>
        listTargetVpnGatewaysTransportSettings =
            HttpJsonCallSettings
                .<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList>newBuilder()
                .setMethodDescriptor(listTargetVpnGatewaysMethodDescriptor)
                .build();

    this.aggregatedListTargetVpnGatewaysCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTargetVpnGatewaysTransportSettings,
            settings.aggregatedListTargetVpnGatewaysSettings(),
            clientContext);
    this.aggregatedListTargetVpnGatewaysPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTargetVpnGatewaysTransportSettings,
            settings.aggregatedListTargetVpnGatewaysSettings(),
            clientContext);
    this.deleteTargetVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            deleteTargetVpnGatewayTransportSettings,
            settings.deleteTargetVpnGatewaySettings(),
            clientContext);
    this.getTargetVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            getTargetVpnGatewayTransportSettings,
            settings.getTargetVpnGatewaySettings(),
            clientContext);
    this.insertTargetVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            insertTargetVpnGatewayTransportSettings,
            settings.insertTargetVpnGatewaySettings(),
            clientContext);
    this.listTargetVpnGatewaysCallable =
        callableFactory.createUnaryCallable(
            listTargetVpnGatewaysTransportSettings,
            settings.listTargetVpnGatewaysSettings(),
            clientContext);
    this.listTargetVpnGatewaysPagedCallable =
        callableFactory.createPagedCallable(
            listTargetVpnGatewaysTransportSettings,
            settings.listTargetVpnGatewaysSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListTargetVpnGatewaysHttpRequest, AggregatedListTargetVpnGatewaysPagedResponse>
      aggregatedListTargetVpnGatewaysPagedCallable() {
    return aggregatedListTargetVpnGatewaysPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListTargetVpnGatewaysHttpRequest, TargetVpnGatewayAggregatedList>
      aggregatedListTargetVpnGatewaysCallable() {
    return aggregatedListTargetVpnGatewaysCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteTargetVpnGatewayHttpRequest, Operation>
      deleteTargetVpnGatewayCallable() {
    return deleteTargetVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<GetTargetVpnGatewayHttpRequest, TargetVpnGateway>
      getTargetVpnGatewayCallable() {
    return getTargetVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<InsertTargetVpnGatewayHttpRequest, Operation>
      insertTargetVpnGatewayCallable() {
    return insertTargetVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetVpnGatewaysHttpRequest, ListTargetVpnGatewaysPagedResponse>
      listTargetVpnGatewaysPagedCallable() {
    return listTargetVpnGatewaysPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetVpnGatewaysHttpRequest, TargetVpnGatewayList>
      listTargetVpnGatewaysCallable() {
    return listTargetVpnGatewaysCallable;
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
