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

import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.AggregatedListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.NetworkEndpointGroupClient.ListNetworkEndpointsNetworkEndpointGroupsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.AttachNetworkEndpointsNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DeleteNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.GetNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.InsertNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupAggregatedList;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.ProjectZoneNetworkEndpointGroupName;
import com.google.cloud.compute.v1.ProjectZoneNetworkEndpointGroupResourceName;
import com.google.cloud.compute.v1.TestIamPermissionsNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
public class HttpJsonNetworkEndpointGroupStub extends NetworkEndpointGroupStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListNetworkEndpointGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupAggregatedList>
                  newBuilder()
              .setFullMethodName("compute.networkEndpointGroups.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListNetworkEndpointGroupsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/aggregated/networkEndpointGroups"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NetworkEndpointGroupAggregatedList>newBuilder()
                      .setResponseInstance(NetworkEndpointGroupAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor
              .<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.networkEndpointGroups.attachNetworkEndpoints")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}/attachNetworkEndpoints"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteNetworkEndpointGroupHttpRequest, Operation>
      deleteNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.networkEndpointGroups.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor
              .<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.networkEndpointGroups.detachNetworkEndpoints")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}/detachNetworkEndpoints"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor.<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>newBuilder()
              .setFullMethodName("compute.networkEndpointGroups.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NetworkEndpointGroup>newBuilder()
                      .setResponseInstance(NetworkEndpointGroup.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertNetworkEndpointGroupHttpRequest, Operation>
      insertNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor.<InsertNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.networkEndpointGroups.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/networkEndpointGroups"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listNetworkEndpointGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>newBuilder()
              .setFullMethodName("compute.networkEndpointGroups.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListNetworkEndpointGroupsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/networkEndpointGroups"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NetworkEndpointGroupList>newBuilder()
                      .setResponseInstance(NetworkEndpointGroupList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsNetworkEndpointGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
                  NetworkEndpointGroupsListNetworkEndpoints>
                  newBuilder()
              .setFullMethodName("compute.networkEndpointGroups.listNetworkEndpoints")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListNetworkEndpointsNetworkEndpointGroupsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}/listNetworkEndpoints"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser
                      .<NetworkEndpointGroupsListNetworkEndpoints>newBuilder()
                      .setResponseInstance(
                          NetworkEndpointGroupsListNetworkEndpoints.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
                  newBuilder()
              .setFullMethodName("compute.networkEndpointGroups.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/networkEndpointGroups/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(
                          ProjectZoneNetworkEndpointGroupResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListNetworkEndpointGroupsCallable;
  private final UnaryCallable<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          AggregatedListNetworkEndpointGroupsPagedResponse>
      aggregatedListNetworkEndpointGroupsPagedCallable;
  private final UnaryCallable<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsNetworkEndpointGroupCallable;
  private final UnaryCallable<DeleteNetworkEndpointGroupHttpRequest, Operation>
      deleteNetworkEndpointGroupCallable;
  private final UnaryCallable<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsNetworkEndpointGroupCallable;
  private final UnaryCallable<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getNetworkEndpointGroupCallable;
  private final UnaryCallable<InsertNetworkEndpointGroupHttpRequest, Operation>
      insertNetworkEndpointGroupCallable;
  private final UnaryCallable<ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listNetworkEndpointGroupsCallable;
  private final UnaryCallable<
          ListNetworkEndpointGroupsHttpRequest, ListNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointGroupsPagedCallable;
  private final UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsNetworkEndpointGroupsCallable;
  private final UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsNetworkEndpointGroupsPagedCallable;
  private final UnaryCallable<
          TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNetworkEndpointGroupCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNetworkEndpointGroupStub create(
      NetworkEndpointGroupStubSettings settings) throws IOException {
    return new HttpJsonNetworkEndpointGroupStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNetworkEndpointGroupStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonNetworkEndpointGroupStub(
        NetworkEndpointGroupStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNetworkEndpointGroupStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNetworkEndpointGroupStub(
        NetworkEndpointGroupStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNetworkEndpointGroupStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkEndpointGroupStub(
      NetworkEndpointGroupStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonNetworkEndpointGroupCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNetworkEndpointGroupStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonNetworkEndpointGroupStub(
      NetworkEndpointGroupStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            AggregatedListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupAggregatedList>
        aggregatedListNetworkEndpointGroupsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListNetworkEndpointGroupsHttpRequest,
                    NetworkEndpointGroupAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListNetworkEndpointGroupsMethodDescriptor)
                .build();
    HttpJsonCallSettings<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
        attachNetworkEndpointsNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(attachNetworkEndpointsNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteNetworkEndpointGroupHttpRequest, Operation>
        deleteNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings.<DeleteNetworkEndpointGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
        detachNetworkEndpointsNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(detachNetworkEndpointsNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>newBuilder()
                .setMethodDescriptor(getNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertNetworkEndpointGroupHttpRequest, Operation>
        insertNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings.<InsertNetworkEndpointGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
        listNetworkEndpointGroupsTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>newBuilder()
                .setMethodDescriptor(listNetworkEndpointGroupsMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupsListNetworkEndpoints>
        listNetworkEndpointsNetworkEndpointGroupsTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
                    NetworkEndpointGroupsListNetworkEndpoints>
                    newBuilder()
                .setMethodDescriptor(listNetworkEndpointsNetworkEndpointGroupsMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
        testIamPermissionsNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
                    newBuilder()
                .setMethodDescriptor(testIamPermissionsNetworkEndpointGroupMethodDescriptor)
                .build();

    this.aggregatedListNetworkEndpointGroupsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListNetworkEndpointGroupsTransportSettings,
            settings.aggregatedListNetworkEndpointGroupsSettings(),
            clientContext);
    this.aggregatedListNetworkEndpointGroupsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListNetworkEndpointGroupsTransportSettings,
            settings.aggregatedListNetworkEndpointGroupsSettings(),
            clientContext);
    this.attachNetworkEndpointsNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            attachNetworkEndpointsNetworkEndpointGroupTransportSettings,
            settings.attachNetworkEndpointsNetworkEndpointGroupSettings(),
            clientContext);
    this.deleteNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            deleteNetworkEndpointGroupTransportSettings,
            settings.deleteNetworkEndpointGroupSettings(),
            clientContext);
    this.detachNetworkEndpointsNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            detachNetworkEndpointsNetworkEndpointGroupTransportSettings,
            settings.detachNetworkEndpointsNetworkEndpointGroupSettings(),
            clientContext);
    this.getNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            getNetworkEndpointGroupTransportSettings,
            settings.getNetworkEndpointGroupSettings(),
            clientContext);
    this.insertNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            insertNetworkEndpointGroupTransportSettings,
            settings.insertNetworkEndpointGroupSettings(),
            clientContext);
    this.listNetworkEndpointGroupsCallable =
        callableFactory.createUnaryCallable(
            listNetworkEndpointGroupsTransportSettings,
            settings.listNetworkEndpointGroupsSettings(),
            clientContext);
    this.listNetworkEndpointGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listNetworkEndpointGroupsTransportSettings,
            settings.listNetworkEndpointGroupsSettings(),
            clientContext);
    this.listNetworkEndpointsNetworkEndpointGroupsCallable =
        callableFactory.createUnaryCallable(
            listNetworkEndpointsNetworkEndpointGroupsTransportSettings,
            settings.listNetworkEndpointsNetworkEndpointGroupsSettings(),
            clientContext);
    this.listNetworkEndpointsNetworkEndpointGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listNetworkEndpointsNetworkEndpointGroupsTransportSettings,
            settings.listNetworkEndpointsNetworkEndpointGroupsSettings(),
            clientContext);
    this.testIamPermissionsNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsNetworkEndpointGroupTransportSettings,
            settings.testIamPermissionsNetworkEndpointGroupSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListNetworkEndpointGroupsHttpRequest,
          AggregatedListNetworkEndpointGroupsPagedResponse>
      aggregatedListNetworkEndpointGroupsPagedCallable() {
    return aggregatedListNetworkEndpointGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupAggregatedList>
      aggregatedListNetworkEndpointGroupsCallable() {
    return aggregatedListNetworkEndpointGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<AttachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsNetworkEndpointGroupCallable() {
    return attachNetworkEndpointsNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteNetworkEndpointGroupHttpRequest, Operation>
      deleteNetworkEndpointGroupCallable() {
    return deleteNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<DetachNetworkEndpointsNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsNetworkEndpointGroupCallable() {
    return detachNetworkEndpointsNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<GetNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getNetworkEndpointGroupCallable() {
    return getNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<InsertNetworkEndpointGroupHttpRequest, Operation>
      insertNetworkEndpointGroupCallable() {
    return insertNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<ListNetworkEndpointGroupsHttpRequest, ListNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointGroupsPagedCallable() {
    return listNetworkEndpointGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listNetworkEndpointGroupsCallable() {
    return listNetworkEndpointGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          ListNetworkEndpointsNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsNetworkEndpointGroupsPagedCallable() {
    return listNetworkEndpointsNetworkEndpointGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListNetworkEndpointsNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsNetworkEndpointGroupsCallable() {
    return listNetworkEndpointsNetworkEndpointGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsNetworkEndpointGroupHttpRequest, TestPermissionsResponse>
      testIamPermissionsNetworkEndpointGroupCallable() {
    return testIamPermissionsNetworkEndpointGroupCallable;
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
