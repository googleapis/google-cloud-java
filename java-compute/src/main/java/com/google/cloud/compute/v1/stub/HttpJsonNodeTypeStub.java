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

import static com.google.cloud.compute.v1.NodeTypeClient.AggregatedListNodeTypesPagedResponse;
import static com.google.cloud.compute.v1.NodeTypeClient.ListNodeTypesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListNodeTypesHttpRequest;
import com.google.cloud.compute.v1.GetNodeTypeHttpRequest;
import com.google.cloud.compute.v1.ListNodeTypesHttpRequest;
import com.google.cloud.compute.v1.NodeType;
import com.google.cloud.compute.v1.NodeTypeAggregatedList;
import com.google.cloud.compute.v1.NodeTypeList;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.ProjectZoneNodeTypeName;
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
public class HttpJsonNodeTypeStub extends NodeTypeStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList>
      aggregatedListNodeTypesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList>newBuilder()
              .setFullMethodName("compute.nodeTypes.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListNodeTypesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/nodeTypes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeTypeAggregatedList>newBuilder()
                      .setResponseInstance(NodeTypeAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetNodeTypeHttpRequest, NodeType>
      getNodeTypeMethodDescriptor =
          ApiMethodDescriptor.<GetNodeTypeHttpRequest, NodeType>newBuilder()
              .setFullMethodName("compute.nodeTypes.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetNodeTypeHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/nodeTypes/{nodeType}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneNodeTypeName.newFactory())
                      .setResourceNameField("nodeType")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeType>newBuilder()
                      .setResponseInstance(NodeType.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListNodeTypesHttpRequest, NodeTypeList>
      listNodeTypesMethodDescriptor =
          ApiMethodDescriptor.<ListNodeTypesHttpRequest, NodeTypeList>newBuilder()
              .setFullMethodName("compute.nodeTypes.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListNodeTypesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/nodeTypes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<NodeTypeList>newBuilder()
                      .setResponseInstance(NodeTypeList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList>
      aggregatedListNodeTypesCallable;
  private final UnaryCallable<
          AggregatedListNodeTypesHttpRequest, AggregatedListNodeTypesPagedResponse>
      aggregatedListNodeTypesPagedCallable;
  private final UnaryCallable<GetNodeTypeHttpRequest, NodeType> getNodeTypeCallable;
  private final UnaryCallable<ListNodeTypesHttpRequest, NodeTypeList> listNodeTypesCallable;
  private final UnaryCallable<ListNodeTypesHttpRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonNodeTypeStub create(NodeTypeStubSettings settings)
      throws IOException {
    return new HttpJsonNodeTypeStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonNodeTypeStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonNodeTypeStub(NodeTypeStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonNodeTypeStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonNodeTypeStub(
        NodeTypeStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonNodeTypeStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeTypeStub(NodeTypeStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonNodeTypeCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonNodeTypeStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonNodeTypeStub(
      NodeTypeStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList>
        aggregatedListNodeTypesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListNodeTypesMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetNodeTypeHttpRequest, NodeType> getNodeTypeTransportSettings =
        HttpJsonCallSettings.<GetNodeTypeHttpRequest, NodeType>newBuilder()
            .setMethodDescriptor(getNodeTypeMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListNodeTypesHttpRequest, NodeTypeList> listNodeTypesTransportSettings =
        HttpJsonCallSettings.<ListNodeTypesHttpRequest, NodeTypeList>newBuilder()
            .setMethodDescriptor(listNodeTypesMethodDescriptor)
            .build();

    this.aggregatedListNodeTypesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListNodeTypesTransportSettings,
            settings.aggregatedListNodeTypesSettings(),
            clientContext);
    this.aggregatedListNodeTypesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListNodeTypesTransportSettings,
            settings.aggregatedListNodeTypesSettings(),
            clientContext);
    this.getNodeTypeCallable =
        callableFactory.createUnaryCallable(
            getNodeTypeTransportSettings, settings.getNodeTypeSettings(), clientContext);
    this.listNodeTypesCallable =
        callableFactory.createUnaryCallable(
            listNodeTypesTransportSettings, settings.listNodeTypesSettings(), clientContext);
    this.listNodeTypesPagedCallable =
        callableFactory.createPagedCallable(
            listNodeTypesTransportSettings, settings.listNodeTypesSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AggregatedListNodeTypesHttpRequest, AggregatedListNodeTypesPagedResponse>
      aggregatedListNodeTypesPagedCallable() {
    return aggregatedListNodeTypesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListNodeTypesHttpRequest, NodeTypeAggregatedList>
      aggregatedListNodeTypesCallable() {
    return aggregatedListNodeTypesCallable;
  }

  @BetaApi
  public UnaryCallable<GetNodeTypeHttpRequest, NodeType> getNodeTypeCallable() {
    return getNodeTypeCallable;
  }

  @BetaApi
  public UnaryCallable<ListNodeTypesHttpRequest, ListNodeTypesPagedResponse>
      listNodeTypesPagedCallable() {
    return listNodeTypesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListNodeTypesHttpRequest, NodeTypeList> listNodeTypesCallable() {
    return listNodeTypesCallable;
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
