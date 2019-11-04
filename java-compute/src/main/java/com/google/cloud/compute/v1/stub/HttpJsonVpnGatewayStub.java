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

import static com.google.cloud.compute.v1.VpnGatewayClient.AggregatedListVpnGatewaysPagedResponse;
import static com.google.cloud.compute.v1.VpnGatewayClient.ListVpnGatewaysPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.DeleteVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.GetStatusVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.GetVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.InsertVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.ListVpnGatewaysHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionVpnGatewayName;
import com.google.cloud.compute.v1.ProjectRegionVpnGatewayResourceName;
import com.google.cloud.compute.v1.SetLabelsVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsVpnGatewayHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.VpnGateway;
import com.google.cloud.compute.v1.VpnGatewayAggregatedList;
import com.google.cloud.compute.v1.VpnGatewayList;
import com.google.cloud.compute.v1.VpnGatewaysGetStatusResponse;
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
public class HttpJsonVpnGatewayStub extends VpnGatewayStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList>
      aggregatedListVpnGatewaysMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList>newBuilder()
              .setFullMethodName("compute.vpnGateways.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListVpnGatewaysHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/vpnGateways"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<VpnGatewayAggregatedList>newBuilder()
                      .setResponseInstance(VpnGatewayAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteVpnGatewayHttpRequest, Operation>
      deleteVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<DeleteVpnGatewayHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.vpnGateways.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/vpnGateways/{vpnGateway}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionVpnGatewayName.newFactory())
                      .setResourceNameField("vpnGateway")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetVpnGatewayHttpRequest, VpnGateway>
      getVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<GetVpnGatewayHttpRequest, VpnGateway>newBuilder()
              .setFullMethodName("compute.vpnGateways.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/vpnGateways/{vpnGateway}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionVpnGatewayName.newFactory())
                      .setResourceNameField("vpnGateway")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<VpnGateway>newBuilder()
                      .setResponseInstance(VpnGateway.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
      getStatusVpnGatewayMethodDescriptor =
          ApiMethodDescriptor
              .<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>newBuilder()
              .setFullMethodName("compute.vpnGateways.getStatus")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetStatusVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/vpnGateways/{vpnGateway}/getStatus"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionVpnGatewayName.newFactory())
                      .setResourceNameField("vpnGateway")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<VpnGatewaysGetStatusResponse>newBuilder()
                      .setResponseInstance(VpnGatewaysGetStatusResponse.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertVpnGatewayHttpRequest, Operation>
      insertVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<InsertVpnGatewayHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.vpnGateways.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/vpnGateways"))
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
  public static final ApiMethodDescriptor<ListVpnGatewaysHttpRequest, VpnGatewayList>
      listVpnGatewaysMethodDescriptor =
          ApiMethodDescriptor.<ListVpnGatewaysHttpRequest, VpnGatewayList>newBuilder()
              .setFullMethodName("compute.vpnGateways.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListVpnGatewaysHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/vpnGateways"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<VpnGatewayList>newBuilder()
                      .setResponseInstance(VpnGatewayList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsVpnGatewayHttpRequest, Operation>
      setLabelsVpnGatewayMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsVpnGatewayHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.vpnGateways.setLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetLabelsVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/vpnGateways/{resource}/setLabels"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionVpnGatewayResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsVpnGatewayMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.vpnGateways.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsVpnGatewayHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/vpnGateways/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionVpnGatewayResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList>
      aggregatedListVpnGatewaysCallable;
  private final UnaryCallable<
          AggregatedListVpnGatewaysHttpRequest, AggregatedListVpnGatewaysPagedResponse>
      aggregatedListVpnGatewaysPagedCallable;
  private final UnaryCallable<DeleteVpnGatewayHttpRequest, Operation> deleteVpnGatewayCallable;
  private final UnaryCallable<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewayCallable;
  private final UnaryCallable<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
      getStatusVpnGatewayCallable;
  private final UnaryCallable<InsertVpnGatewayHttpRequest, Operation> insertVpnGatewayCallable;
  private final UnaryCallable<ListVpnGatewaysHttpRequest, VpnGatewayList> listVpnGatewaysCallable;
  private final UnaryCallable<ListVpnGatewaysHttpRequest, ListVpnGatewaysPagedResponse>
      listVpnGatewaysPagedCallable;
  private final UnaryCallable<SetLabelsVpnGatewayHttpRequest, Operation>
      setLabelsVpnGatewayCallable;
  private final UnaryCallable<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsVpnGatewayCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonVpnGatewayStub create(VpnGatewayStubSettings settings)
      throws IOException {
    return new HttpJsonVpnGatewayStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonVpnGatewayStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonVpnGatewayStub(VpnGatewayStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonVpnGatewayStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonVpnGatewayStub(
        VpnGatewayStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonVpnGatewayStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVpnGatewayStub(VpnGatewayStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonVpnGatewayCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonVpnGatewayStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonVpnGatewayStub(
      VpnGatewayStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList>
        aggregatedListVpnGatewaysTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListVpnGatewaysMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteVpnGatewayHttpRequest, Operation> deleteVpnGatewayTransportSettings =
        HttpJsonCallSettings.<DeleteVpnGatewayHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteVpnGatewayMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewayTransportSettings =
        HttpJsonCallSettings.<GetVpnGatewayHttpRequest, VpnGateway>newBuilder()
            .setMethodDescriptor(getVpnGatewayMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
        getStatusVpnGatewayTransportSettings =
            HttpJsonCallSettings
                .<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>newBuilder()
                .setMethodDescriptor(getStatusVpnGatewayMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertVpnGatewayHttpRequest, Operation> insertVpnGatewayTransportSettings =
        HttpJsonCallSettings.<InsertVpnGatewayHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertVpnGatewayMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListVpnGatewaysHttpRequest, VpnGatewayList>
        listVpnGatewaysTransportSettings =
            HttpJsonCallSettings.<ListVpnGatewaysHttpRequest, VpnGatewayList>newBuilder()
                .setMethodDescriptor(listVpnGatewaysMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetLabelsVpnGatewayHttpRequest, Operation>
        setLabelsVpnGatewayTransportSettings =
            HttpJsonCallSettings.<SetLabelsVpnGatewayHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setLabelsVpnGatewayMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
        testIamPermissionsVpnGatewayTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsVpnGatewayMethodDescriptor)
                .build();

    this.aggregatedListVpnGatewaysCallable =
        callableFactory.createUnaryCallable(
            aggregatedListVpnGatewaysTransportSettings,
            settings.aggregatedListVpnGatewaysSettings(),
            clientContext);
    this.aggregatedListVpnGatewaysPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListVpnGatewaysTransportSettings,
            settings.aggregatedListVpnGatewaysSettings(),
            clientContext);
    this.deleteVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            deleteVpnGatewayTransportSettings, settings.deleteVpnGatewaySettings(), clientContext);
    this.getVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            getVpnGatewayTransportSettings, settings.getVpnGatewaySettings(), clientContext);
    this.getStatusVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            getStatusVpnGatewayTransportSettings,
            settings.getStatusVpnGatewaySettings(),
            clientContext);
    this.insertVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            insertVpnGatewayTransportSettings, settings.insertVpnGatewaySettings(), clientContext);
    this.listVpnGatewaysCallable =
        callableFactory.createUnaryCallable(
            listVpnGatewaysTransportSettings, settings.listVpnGatewaysSettings(), clientContext);
    this.listVpnGatewaysPagedCallable =
        callableFactory.createPagedCallable(
            listVpnGatewaysTransportSettings, settings.listVpnGatewaysSettings(), clientContext);
    this.setLabelsVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            setLabelsVpnGatewayTransportSettings,
            settings.setLabelsVpnGatewaySettings(),
            clientContext);
    this.testIamPermissionsVpnGatewayCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsVpnGatewayTransportSettings,
            settings.testIamPermissionsVpnGatewaySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AggregatedListVpnGatewaysHttpRequest, AggregatedListVpnGatewaysPagedResponse>
      aggregatedListVpnGatewaysPagedCallable() {
    return aggregatedListVpnGatewaysPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListVpnGatewaysHttpRequest, VpnGatewayAggregatedList>
      aggregatedListVpnGatewaysCallable() {
    return aggregatedListVpnGatewaysCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteVpnGatewayHttpRequest, Operation> deleteVpnGatewayCallable() {
    return deleteVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<GetVpnGatewayHttpRequest, VpnGateway> getVpnGatewayCallable() {
    return getVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<GetStatusVpnGatewayHttpRequest, VpnGatewaysGetStatusResponse>
      getStatusVpnGatewayCallable() {
    return getStatusVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<InsertVpnGatewayHttpRequest, Operation> insertVpnGatewayCallable() {
    return insertVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<ListVpnGatewaysHttpRequest, ListVpnGatewaysPagedResponse>
      listVpnGatewaysPagedCallable() {
    return listVpnGatewaysPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListVpnGatewaysHttpRequest, VpnGatewayList> listVpnGatewaysCallable() {
    return listVpnGatewaysCallable;
  }

  @BetaApi
  public UnaryCallable<SetLabelsVpnGatewayHttpRequest, Operation> setLabelsVpnGatewayCallable() {
    return setLabelsVpnGatewayCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsVpnGatewayHttpRequest, TestPermissionsResponse>
      testIamPermissionsVpnGatewayCallable() {
    return testIamPermissionsVpnGatewayCallable;
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
