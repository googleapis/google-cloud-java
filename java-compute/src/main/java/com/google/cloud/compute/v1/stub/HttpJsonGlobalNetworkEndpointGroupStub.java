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

import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListGlobalNetworkEndpointGroupsPagedResponse;
import static com.google.cloud.compute.v1.GlobalNetworkEndpointGroupClient.ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse;

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
import com.google.cloud.compute.v1.AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DeleteGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.GetGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.InsertGlobalNetworkEndpointGroupHttpRequest;
import com.google.cloud.compute.v1.ListGlobalNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest;
import com.google.cloud.compute.v1.NetworkEndpointGroup;
import com.google.cloud.compute.v1.NetworkEndpointGroupList;
import com.google.cloud.compute.v1.NetworkEndpointGroupsListNetworkEndpoints;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalNetworkEndpointGroupName;
import com.google.cloud.compute.v1.ProjectName;
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
public class HttpJsonGlobalNetworkEndpointGroupStub extends GlobalNetworkEndpointGroupStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsGlobalNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor
              .<AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalNetworkEndpointGroups.attachNetworkEndpoints")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/networkEndpointGroups/{networkEndpointGroup}/attachNetworkEndpoints"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
      deleteGlobalNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalNetworkEndpointGroups.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeleteGlobalNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/networkEndpointGroups/{networkEndpointGroup}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsGlobalNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor
              .<DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalNetworkEndpointGroups.detachNetworkEndpoints")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/networkEndpointGroups/{networkEndpointGroup}/detachNetworkEndpoints"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getGlobalNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor
              .<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>newBuilder()
              .setFullMethodName("compute.globalNetworkEndpointGroups.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<GetGlobalNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/networkEndpointGroups/{networkEndpointGroup}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NetworkEndpointGroup>newBuilder()
                      .setResponseInstance(NetworkEndpointGroup.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
      insertGlobalNetworkEndpointGroupMethodDescriptor =
          ApiMethodDescriptor.<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalNetworkEndpointGroups.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<InsertGlobalNetworkEndpointGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/networkEndpointGroups"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListGlobalNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listGlobalNetworkEndpointGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<ListGlobalNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>newBuilder()
              .setFullMethodName("compute.globalNetworkEndpointGroups.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListGlobalNetworkEndpointGroupsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/networkEndpointGroups"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NetworkEndpointGroupList>newBuilder()
                      .setResponseInstance(NetworkEndpointGroupList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsGlobalNetworkEndpointGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
                  NetworkEndpointGroupsListNetworkEndpoints>
                  newBuilder()
              .setFullMethodName("compute.globalNetworkEndpointGroups.listNetworkEndpoints")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/networkEndpointGroups/{networkEndpointGroup}/listNetworkEndpoints"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectGlobalNetworkEndpointGroupName.newFactory())
                      .setResourceNameField("networkEndpointGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser
                      .<NetworkEndpointGroupsListNetworkEndpoints>newBuilder()
                      .setResponseInstance(
                          NetworkEndpointGroupsListNetworkEndpoints.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsGlobalNetworkEndpointGroupCallable;
  private final UnaryCallable<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
      deleteGlobalNetworkEndpointGroupCallable;
  private final UnaryCallable<
          DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsGlobalNetworkEndpointGroupCallable;
  private final UnaryCallable<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getGlobalNetworkEndpointGroupCallable;
  private final UnaryCallable<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
      insertGlobalNetworkEndpointGroupCallable;
  private final UnaryCallable<ListGlobalNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listGlobalNetworkEndpointGroupsCallable;
  private final UnaryCallable<
          ListGlobalNetworkEndpointGroupsHttpRequest, ListGlobalNetworkEndpointGroupsPagedResponse>
      listGlobalNetworkEndpointGroupsPagedCallable;
  private final UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsGlobalNetworkEndpointGroupsCallable;
  private final UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalNetworkEndpointGroupStub create(
      GlobalNetworkEndpointGroupStubSettings settings) throws IOException {
    return new HttpJsonGlobalNetworkEndpointGroupStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalNetworkEndpointGroupStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalNetworkEndpointGroupStub(
        GlobalNetworkEndpointGroupStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalNetworkEndpointGroupStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalNetworkEndpointGroupStub(
        GlobalNetworkEndpointGroupStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalNetworkEndpointGroupStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalNetworkEndpointGroupStub(
      GlobalNetworkEndpointGroupStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonGlobalNetworkEndpointGroupCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalNetworkEndpointGroupStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static factory
   * methods should be preferred.
   */
  protected HttpJsonGlobalNetworkEndpointGroupStub(
      GlobalNetworkEndpointGroupStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
        attachNetworkEndpointsGlobalNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
                    newBuilder()
                .setMethodDescriptor(
                    attachNetworkEndpointsGlobalNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
        deleteGlobalNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGlobalNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
        detachNetworkEndpointsGlobalNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
                    newBuilder()
                .setMethodDescriptor(
                    detachNetworkEndpointsGlobalNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
        getGlobalNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>newBuilder()
                .setMethodDescriptor(getGlobalNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
        insertGlobalNetworkEndpointGroupTransportSettings =
            HttpJsonCallSettings
                .<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertGlobalNetworkEndpointGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListGlobalNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
        listGlobalNetworkEndpointGroupsTransportSettings =
            HttpJsonCallSettings
                .<ListGlobalNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>newBuilder()
                .setMethodDescriptor(listGlobalNetworkEndpointGroupsMethodDescriptor)
                .build();
    HttpJsonCallSettings<
            ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
            NetworkEndpointGroupsListNetworkEndpoints>
        listNetworkEndpointsGlobalNetworkEndpointGroupsTransportSettings =
            HttpJsonCallSettings
                .<ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
                    NetworkEndpointGroupsListNetworkEndpoints>
                    newBuilder()
                .setMethodDescriptor(
                    listNetworkEndpointsGlobalNetworkEndpointGroupsMethodDescriptor)
                .build();

    this.attachNetworkEndpointsGlobalNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            attachNetworkEndpointsGlobalNetworkEndpointGroupTransportSettings,
            settings.attachNetworkEndpointsGlobalNetworkEndpointGroupSettings(),
            clientContext);
    this.deleteGlobalNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            deleteGlobalNetworkEndpointGroupTransportSettings,
            settings.deleteGlobalNetworkEndpointGroupSettings(),
            clientContext);
    this.detachNetworkEndpointsGlobalNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            detachNetworkEndpointsGlobalNetworkEndpointGroupTransportSettings,
            settings.detachNetworkEndpointsGlobalNetworkEndpointGroupSettings(),
            clientContext);
    this.getGlobalNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            getGlobalNetworkEndpointGroupTransportSettings,
            settings.getGlobalNetworkEndpointGroupSettings(),
            clientContext);
    this.insertGlobalNetworkEndpointGroupCallable =
        callableFactory.createUnaryCallable(
            insertGlobalNetworkEndpointGroupTransportSettings,
            settings.insertGlobalNetworkEndpointGroupSettings(),
            clientContext);
    this.listGlobalNetworkEndpointGroupsCallable =
        callableFactory.createUnaryCallable(
            listGlobalNetworkEndpointGroupsTransportSettings,
            settings.listGlobalNetworkEndpointGroupsSettings(),
            clientContext);
    this.listGlobalNetworkEndpointGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listGlobalNetworkEndpointGroupsTransportSettings,
            settings.listGlobalNetworkEndpointGroupsSettings(),
            clientContext);
    this.listNetworkEndpointsGlobalNetworkEndpointGroupsCallable =
        callableFactory.createUnaryCallable(
            listNetworkEndpointsGlobalNetworkEndpointGroupsTransportSettings,
            settings.listNetworkEndpointsGlobalNetworkEndpointGroupsSettings(),
            clientContext);
    this.listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listNetworkEndpointsGlobalNetworkEndpointGroupsTransportSettings,
            settings.listNetworkEndpointsGlobalNetworkEndpointGroupsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AttachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      attachNetworkEndpointsGlobalNetworkEndpointGroupCallable() {
    return attachNetworkEndpointsGlobalNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteGlobalNetworkEndpointGroupHttpRequest, Operation>
      deleteGlobalNetworkEndpointGroupCallable() {
    return deleteGlobalNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<DetachNetworkEndpointsGlobalNetworkEndpointGroupHttpRequest, Operation>
      detachNetworkEndpointsGlobalNetworkEndpointGroupCallable() {
    return detachNetworkEndpointsGlobalNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<GetGlobalNetworkEndpointGroupHttpRequest, NetworkEndpointGroup>
      getGlobalNetworkEndpointGroupCallable() {
    return getGlobalNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<InsertGlobalNetworkEndpointGroupHttpRequest, Operation>
      insertGlobalNetworkEndpointGroupCallable() {
    return insertGlobalNetworkEndpointGroupCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListGlobalNetworkEndpointGroupsHttpRequest, ListGlobalNetworkEndpointGroupsPagedResponse>
      listGlobalNetworkEndpointGroupsPagedCallable() {
    return listGlobalNetworkEndpointGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListGlobalNetworkEndpointGroupsHttpRequest, NetworkEndpointGroupList>
      listGlobalNetworkEndpointGroupsCallable() {
    return listGlobalNetworkEndpointGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          ListNetworkEndpointsGlobalNetworkEndpointGroupsPagedResponse>
      listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable() {
    return listNetworkEndpointsGlobalNetworkEndpointGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListNetworkEndpointsGlobalNetworkEndpointGroupsHttpRequest,
          NetworkEndpointGroupsListNetworkEndpoints>
      listNetworkEndpointsGlobalNetworkEndpointGroupsCallable() {
    return listNetworkEndpointsGlobalNetworkEndpointGroupsCallable;
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
