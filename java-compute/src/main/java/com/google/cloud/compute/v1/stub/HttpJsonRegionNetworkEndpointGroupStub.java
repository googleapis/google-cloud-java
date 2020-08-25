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

import static com.google.cloud.compute.v1.RegionNetworkEndpointGroupClient.ListRegionNetworkEndpointGroupsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.GetRegionNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.InsertRegionNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.ListRegionNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionNetworkEndpointGroupName;
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
public class HttpJsonRegionNetworkEndpointGroupStub extends RegionNetworkEndpointGroupStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>
      deleteRegionNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionNetworkEndpointGroups.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeleteRegionNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getRegionNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor
              .<GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>newBuilder()
              .setFullMethodName("compute.regionNetworkEndpointGroups.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<GetRegionNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NetworkEndpointGroup>newBuilder()
                      .setResponseInstance(NetworkEndpointGroup.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionNetworkEndpointGroupHttpRequest, Operation>
      insertRegionNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionNetworkEndpointGroups.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<InsertRegionNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/networkEndpointGroups"))
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
          ListRegionNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listRegionNetworkEndpointGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<ListRegionNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>newBuilder()
              .setFullMethodName("compute.regionNetworkEndpointGroups.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListRegionNetworkEndpointGroupsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/networkEndpointGroups"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NetworkEndpointGroupList>newBuilder()
                      .setResponseInstance(NetworkEndpointGroupList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>
      deleteRegionNetworkEndpointGroupCallable;
  private final UnaryCallable<GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getRegionNetworkEndpointGroupCallable;
  private final UnaryCallable<InsertRegionNetworkEndpointGroupHttpRequest, Operation>
      insertRegionNetworkEndpointGroupCallable;
  private final UnaryCallable<ListRegionNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listRegionNetworkEndpointGroupsCallable;
  private final UnaryCallable<
          ListRegionNetworkEndpointGroupsHttpRequest, ListRegionNetworkEndpointGroupsPagedResponse>
      listRegionNetworkEndpointGroupsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionNetworkEndpointGroupStub create(
      RegionNetworkEndpointGroupStubSettings settings) throws IOException {
    return new HttpJsonRegionNetworkEndpointGroupStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionNetworkEndpointGroupStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionNetworkEndpointGroupStub(
        RegionNetworkEndpointGroupStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionNetworkEndpointGroupStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionNetworkEndpointGroupStub(
        RegionNetworkEndpointGroupStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionNetworkEndpointGroupStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNetworkEndpointGroupStub(
      RegionNetworkEndpointGroupStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionNetworkEndpointGroupCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionNetworkEndpointGroupStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonRegionNetworkEndpointGroupStub(
      RegionNetworkEndpointGroupStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>
        deleteRegionNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getRegionNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>newBuilder()
                .setMethodDescriptor(getRegionNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionNetworkEndpointGroupHttpRequest, Operation>
        insertRegionNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<InsertRegionNetworkEndpointGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
        listRegionNetworkEndpointGroupsTransportSettings =
            HttpJsonCallSettings
                .<ListRegionNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>newBuilder()
                .setMethodDescriptor(listRegionNetworkEndpointGroupsMethodDescriptor)
                .build();

    this.deleteRegionNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            deleteRegionNetworkEndpointGroupTransportSettings,
            settings.deleteRegionNetworkEndpointGroupSettings(),
            clientContext);
    this.getRegionNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            getRegionNetworkEndpointGroupTransportSettings,
            settings.getRegionNetworkEndpointGroupSettings(),
            clientContext);
    this.insertRegionNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            insertRegionNetworkEndpointGroupTransportSettings,
            settings.insertRegionNetworkEndpointGroupSettings(),
            clientContext);
    this.listRegionNetworkEndpointGroupsCallable =
        callableFactory.createUnaryCallable(
            listRegionNetworkEndpointGroupsTransportSettings,
            settings.listRegionNetworkEndpointGroupsSettings(),
            clientContext);
    this.listRegionNetworkEndpointGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listRegionNetworkEndpointGroupsTransportSettings,
            settings.listRegionNetworkEndpointGroupsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionNetworkEndpointGroupHttpRequest, Operation>
      deleteRegionNetworkEndpointGroupCallable() {
    return deleteRegionNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getRegionNetworkEndpointGroupCallable() {
    return getRegionNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionNetworkEndpointGroupHttpRequest, Operation>
      insertRegionNetworkEndpointGroupCallable() {
    return insertRegionNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListRegionNetworkEndpointGroupsHttpRequest, ListRegionNetworkEndpointGroupsPagedResponse>
      listRegionNetworkEndpointGroupsPagedCallable() {
    return listRegionNetworkEndpointGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listRegionNetworkEndpointGroupsCallable() {
    return listRegionNetworkEndpointGroupsCallable;
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
