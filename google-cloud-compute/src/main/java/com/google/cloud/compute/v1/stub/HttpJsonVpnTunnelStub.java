/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.VpnTunnelClient.AggregatedListVpnTunnelsPagedResponse;
import static com.google.cloud.compute.v1.VpnTunnelClient.ListVpnTunnelsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListVpnTunnelsHttpRequest;
import com.google.cloud.compute.v1.DeleteVpnTunnelHttpRequest;
import com.google.cloud.compute.v1.GetVpnTunnelHttpRequest;
import com.google.cloud.compute.v1.InsertVpnTunnelHttpRequest;
import com.google.cloud.compute.v1.ListVpnTunnelsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionVpnTunnelName;
import com.google.cloud.compute.v1.VpnTunnel;
import com.google.cloud.compute.v1.VpnTunnelAggregatedList;
import com.google.cloud.compute.v1.VpnTunnelList;
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
public class HttpJsonVpnTunnelStub extends VpnTunnelStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList>
      aggregatedListVpnTunnelsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList>newBuilder()
              .setFullMethodName("compute.vpnTunnels.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListVpnTunnelsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/vpnTunnels"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<VpnTunnelAggregatedList>newBuilder()
                      .setResponseInstance(VpnTunnelAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteVpnTunnelHttpRequest, Operation>
      deleteVpnTunnelMethodDescriptor =
          ApiMethodDescriptor.<DeleteVpnTunnelHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.vpnTunnels.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteVpnTunnelHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/vpnTunnels/{vpnTunnel}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionVpnTunnelName.newFactory())
                      .setResourceNameField("vpnTunnel")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetVpnTunnelHttpRequest, VpnTunnel>
      getVpnTunnelMethodDescriptor =
          ApiMethodDescriptor.<GetVpnTunnelHttpRequest, VpnTunnel>newBuilder()
              .setFullMethodName("compute.vpnTunnels.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetVpnTunnelHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/vpnTunnels/{vpnTunnel}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionVpnTunnelName.newFactory())
                      .setResourceNameField("vpnTunnel")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<VpnTunnel>newBuilder()
                      .setResponseInstance(VpnTunnel.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertVpnTunnelHttpRequest, Operation>
      insertVpnTunnelMethodDescriptor =
          ApiMethodDescriptor.<InsertVpnTunnelHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.vpnTunnels.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertVpnTunnelHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/vpnTunnels"))
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
  public static final ApiMethodDescriptor<ListVpnTunnelsHttpRequest, VpnTunnelList>
      listVpnTunnelsMethodDescriptor =
          ApiMethodDescriptor.<ListVpnTunnelsHttpRequest, VpnTunnelList>newBuilder()
              .setFullMethodName("compute.vpnTunnels.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListVpnTunnelsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/vpnTunnels"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<VpnTunnelList>newBuilder()
                      .setResponseInstance(VpnTunnelList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList>
      aggregatedListVpnTunnelsCallable;
  private final UnaryCallable<
          AggregatedListVpnTunnelsHttpRequest, AggregatedListVpnTunnelsPagedResponse>
      aggregatedListVpnTunnelsPagedCallable;
  private final UnaryCallable<DeleteVpnTunnelHttpRequest, Operation> deleteVpnTunnelCallable;
  private final UnaryCallable<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelCallable;
  private final UnaryCallable<InsertVpnTunnelHttpRequest, Operation> insertVpnTunnelCallable;
  private final UnaryCallable<ListVpnTunnelsHttpRequest, VpnTunnelList> listVpnTunnelsCallable;
  private final UnaryCallable<ListVpnTunnelsHttpRequest, ListVpnTunnelsPagedResponse>
      listVpnTunnelsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonVpnTunnelStub create(VpnTunnelStubSettings settings)
      throws IOException {
    return new HttpJsonVpnTunnelStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVpnTunnelStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonVpnTunnelStub(VpnTunnelStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonVpnTunnelStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVpnTunnelStub(
        VpnTunnelStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVpnTunnelStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVpnTunnelStub(VpnTunnelStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonVpnTunnelCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVpnTunnelStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVpnTunnelStub(
      VpnTunnelStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList>
        aggregatedListVpnTunnelsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListVpnTunnelsMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteVpnTunnelHttpRequest, Operation> deleteVpnTunnelTransportSettings =
        HttpJsonCallSettings.<DeleteVpnTunnelHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteVpnTunnelMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelTransportSettings =
        HttpJsonCallSettings.<GetVpnTunnelHttpRequest, VpnTunnel>newBuilder()
            .setMethodDescriptor(getVpnTunnelMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertVpnTunnelHttpRequest, Operation> insertVpnTunnelTransportSettings =
        HttpJsonCallSettings.<InsertVpnTunnelHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertVpnTunnelMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListVpnTunnelsHttpRequest, VpnTunnelList> listVpnTunnelsTransportSettings =
        HttpJsonCallSettings.<ListVpnTunnelsHttpRequest, VpnTunnelList>newBuilder()
            .setMethodDescriptor(listVpnTunnelsMethodDescriptor)
            .build();

    this.aggregatedListVpnTunnelsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListVpnTunnelsTransportSettings,
            settings.aggregatedListVpnTunnelsSettings(),
            clientContext);
    this.aggregatedListVpnTunnelsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListVpnTunnelsTransportSettings,
            settings.aggregatedListVpnTunnelsSettings(),
            clientContext);
    this.deleteVpnTunnelCallable =
        callableFactory.createUnaryCallable(
            deleteVpnTunnelTransportSettings, settings.deleteVpnTunnelSettings(), clientContext);
    this.getVpnTunnelCallable =
        callableFactory.createUnaryCallable(
            getVpnTunnelTransportSettings, settings.getVpnTunnelSettings(), clientContext);
    this.insertVpnTunnelCallable =
        callableFactory.createUnaryCallable(
            insertVpnTunnelTransportSettings, settings.insertVpnTunnelSettings(), clientContext);
    this.listVpnTunnelsCallable =
        callableFactory.createUnaryCallable(
            listVpnTunnelsTransportSettings, settings.listVpnTunnelsSettings(), clientContext);
    this.listVpnTunnelsPagedCallable =
        callableFactory.createPagedCallable(
            listVpnTunnelsTransportSettings, settings.listVpnTunnelsSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AggregatedListVpnTunnelsHttpRequest, AggregatedListVpnTunnelsPagedResponse>
      aggregatedListVpnTunnelsPagedCallable() {
    return aggregatedListVpnTunnelsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListVpnTunnelsHttpRequest, VpnTunnelAggregatedList>
      aggregatedListVpnTunnelsCallable() {
    return aggregatedListVpnTunnelsCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteVpnTunnelHttpRequest, Operation> deleteVpnTunnelCallable() {
    return deleteVpnTunnelCallable;
  }

  @BetaApi
  public UnaryCallable<GetVpnTunnelHttpRequest, VpnTunnel> getVpnTunnelCallable() {
    return getVpnTunnelCallable;
  }

  @BetaApi
  public UnaryCallable<InsertVpnTunnelHttpRequest, Operation> insertVpnTunnelCallable() {
    return insertVpnTunnelCallable;
  }

  @BetaApi
  public UnaryCallable<ListVpnTunnelsHttpRequest, ListVpnTunnelsPagedResponse>
      listVpnTunnelsPagedCallable() {
    return listVpnTunnelsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListVpnTunnelsHttpRequest, VpnTunnelList> listVpnTunnelsCallable() {
    return listVpnTunnelsCallable;
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
