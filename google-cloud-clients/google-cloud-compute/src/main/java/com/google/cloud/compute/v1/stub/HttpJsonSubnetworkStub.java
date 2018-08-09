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

import static com.google.cloud.compute.v1.SubnetworkClient.AggregatedListSubnetworksPagedResponse;
import static com.google.cloud.compute.v1.SubnetworkClient.ListSubnetworksPagedResponse;
import static com.google.cloud.compute.v1.SubnetworkClient.ListUsableSubnetworksPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListSubnetworksHttpRequest;
import com.google.cloud.compute.v1.DeleteSubnetworkHttpRequest;
import com.google.cloud.compute.v1.ExpandIpCidrRangeSubnetworkHttpRequest;
import com.google.cloud.compute.v1.GetSubnetworkHttpRequest;
import com.google.cloud.compute.v1.InsertSubnetworkHttpRequest;
import com.google.cloud.compute.v1.ListSubnetworksHttpRequest;
import com.google.cloud.compute.v1.ListUsableSubnetworksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchSubnetworkHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionSubnetworkName;
import com.google.cloud.compute.v1.SetPrivateIpGoogleAccessSubnetworkHttpRequest;
import com.google.cloud.compute.v1.Subnetwork;
import com.google.cloud.compute.v1.SubnetworkAggregatedList;
import com.google.cloud.compute.v1.SubnetworkList;
import com.google.cloud.compute.v1.UsableSubnetworksAggregatedList;
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
public class HttpJsonSubnetworkStub extends SubnetworkStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListSubnetworksHttpRequest, SubnetworkAggregatedList>
      aggregatedListSubnetworksMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListSubnetworksHttpRequest, SubnetworkAggregatedList>newBuilder()
              .setFullMethodName("compute.subnetworks.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListSubnetworksHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/subnetworks"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SubnetworkAggregatedList>newBuilder()
                      .setResponseInstance(SubnetworkAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteSubnetworkHttpRequest, Operation>
      deleteSubnetworkMethodDescriptor =
          ApiMethodDescriptor.<DeleteSubnetworkHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.subnetworks.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteSubnetworkHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/subnetworks/{subnetwork}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionSubnetworkName.newFactory())
                      .setResourceNameField("subnetwork")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
      expandIpCidrRangeSubnetworkMethodDescriptor =
          ApiMethodDescriptor.<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.subnetworks.expandIpCidrRange")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ExpandIpCidrRangeSubnetworkHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/subnetworks/{subnetwork}/expandIpCidrRange"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionSubnetworkName.newFactory())
                      .setResourceNameField("subnetwork")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetSubnetworkHttpRequest, Subnetwork>
      getSubnetworkMethodDescriptor =
          ApiMethodDescriptor.<GetSubnetworkHttpRequest, Subnetwork>newBuilder()
              .setFullMethodName("compute.subnetworks.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetSubnetworkHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/subnetworks/{subnetwork}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionSubnetworkName.newFactory())
                      .setResourceNameField("subnetwork")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Subnetwork>newBuilder()
                      .setResponseInstance(Subnetwork.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertSubnetworkHttpRequest, Operation>
      insertSubnetworkMethodDescriptor =
          ApiMethodDescriptor.<InsertSubnetworkHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.subnetworks.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertSubnetworkHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/subnetworks"))
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
  public static final ApiMethodDescriptor<ListSubnetworksHttpRequest, SubnetworkList>
      listSubnetworksMethodDescriptor =
          ApiMethodDescriptor.<ListSubnetworksHttpRequest, SubnetworkList>newBuilder()
              .setFullMethodName("compute.subnetworks.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListSubnetworksHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/subnetworks"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SubnetworkList>newBuilder()
                      .setResponseInstance(SubnetworkList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList>
      listUsableSubnetworksMethodDescriptor =
          ApiMethodDescriptor
              .<ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList>newBuilder()
              .setFullMethodName("compute.subnetworks.listUsable")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListUsableSubnetworksHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/aggregated/subnetworks/listUsable"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<UsableSubnetworksAggregatedList>newBuilder()
                      .setResponseInstance(UsableSubnetworksAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchSubnetworkHttpRequest, Operation>
      patchSubnetworkMethodDescriptor =
          ApiMethodDescriptor.<PatchSubnetworkHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.subnetworks.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchSubnetworkHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/subnetworks/{subnetwork}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionSubnetworkName.newFactory())
                      .setResourceNameField("subnetwork")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
      setPrivateIpGoogleAccessSubnetworkMethodDescriptor =
          ApiMethodDescriptor.<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.subnetworks.setPrivateIpGoogleAccess")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetPrivateIpGoogleAccessSubnetworkHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/subnetworks/{subnetwork}/setPrivateIpGoogleAccess"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionSubnetworkName.newFactory())
                      .setResourceNameField("subnetwork")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListSubnetworksHttpRequest, SubnetworkAggregatedList>
      aggregatedListSubnetworksCallable;
  private final UnaryCallable<
          AggregatedListSubnetworksHttpRequest, AggregatedListSubnetworksPagedResponse>
      aggregatedListSubnetworksPagedCallable;
  private final UnaryCallable<DeleteSubnetworkHttpRequest, Operation> deleteSubnetworkCallable;
  private final UnaryCallable<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
      expandIpCidrRangeSubnetworkCallable;
  private final UnaryCallable<GetSubnetworkHttpRequest, Subnetwork> getSubnetworkCallable;
  private final UnaryCallable<InsertSubnetworkHttpRequest, Operation> insertSubnetworkCallable;
  private final UnaryCallable<ListSubnetworksHttpRequest, SubnetworkList> listSubnetworksCallable;
  private final UnaryCallable<ListSubnetworksHttpRequest, ListSubnetworksPagedResponse>
      listSubnetworksPagedCallable;
  private final UnaryCallable<ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList>
      listUsableSubnetworksCallable;
  private final UnaryCallable<ListUsableSubnetworksHttpRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable;
  private final UnaryCallable<PatchSubnetworkHttpRequest, Operation> patchSubnetworkCallable;
  private final UnaryCallable<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
      setPrivateIpGoogleAccessSubnetworkCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSubnetworkStub create(SubnetworkStubSettings settings)
      throws IOException {
    return new HttpJsonSubnetworkStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSubnetworkStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSubnetworkStub(SubnetworkStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSubnetworkStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSubnetworkStub(
        SubnetworkStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSubnetworkStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSubnetworkStub(SubnetworkStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSubnetworkCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSubnetworkStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSubnetworkStub(
      SubnetworkStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListSubnetworksHttpRequest, SubnetworkAggregatedList>
        aggregatedListSubnetworksTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListSubnetworksHttpRequest, SubnetworkAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListSubnetworksMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteSubnetworkHttpRequest, Operation> deleteSubnetworkTransportSettings =
        HttpJsonCallSettings.<DeleteSubnetworkHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSubnetworkMethodDescriptor)
            .build();
    HttpJsonCallSettings<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
        expandIpCidrRangeSubnetworkTransportSettings =
            HttpJsonCallSettings.<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(expandIpCidrRangeSubnetworkMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetSubnetworkHttpRequest, Subnetwork> getSubnetworkTransportSettings =
        HttpJsonCallSettings.<GetSubnetworkHttpRequest, Subnetwork>newBuilder()
            .setMethodDescriptor(getSubnetworkMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertSubnetworkHttpRequest, Operation> insertSubnetworkTransportSettings =
        HttpJsonCallSettings.<InsertSubnetworkHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertSubnetworkMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListSubnetworksHttpRequest, SubnetworkList>
        listSubnetworksTransportSettings =
            HttpJsonCallSettings.<ListSubnetworksHttpRequest, SubnetworkList>newBuilder()
                .setMethodDescriptor(listSubnetworksMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList>
        listUsableSubnetworksTransportSettings =
            HttpJsonCallSettings
                .<ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList>newBuilder()
                .setMethodDescriptor(listUsableSubnetworksMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchSubnetworkHttpRequest, Operation> patchSubnetworkTransportSettings =
        HttpJsonCallSettings.<PatchSubnetworkHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(patchSubnetworkMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
        setPrivateIpGoogleAccessSubnetworkTransportSettings =
            HttpJsonCallSettings
                .<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setPrivateIpGoogleAccessSubnetworkMethodDescriptor)
                .build();

    this.aggregatedListSubnetworksCallable =
        callableFactory.createUnaryCallable(
            aggregatedListSubnetworksTransportSettings,
            settings.aggregatedListSubnetworksSettings(),
            clientContext);
    this.aggregatedListSubnetworksPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListSubnetworksTransportSettings,
            settings.aggregatedListSubnetworksSettings(),
            clientContext);
    this.deleteSubnetworkCallable =
        callableFactory.createUnaryCallable(
            deleteSubnetworkTransportSettings, settings.deleteSubnetworkSettings(), clientContext);
    this.expandIpCidrRangeSubnetworkCallable =
        callableFactory.createUnaryCallable(
            expandIpCidrRangeSubnetworkTransportSettings,
            settings.expandIpCidrRangeSubnetworkSettings(),
            clientContext);
    this.getSubnetworkCallable =
        callableFactory.createUnaryCallable(
            getSubnetworkTransportSettings, settings.getSubnetworkSettings(), clientContext);
    this.insertSubnetworkCallable =
        callableFactory.createUnaryCallable(
            insertSubnetworkTransportSettings, settings.insertSubnetworkSettings(), clientContext);
    this.listSubnetworksCallable =
        callableFactory.createUnaryCallable(
            listSubnetworksTransportSettings, settings.listSubnetworksSettings(), clientContext);
    this.listSubnetworksPagedCallable =
        callableFactory.createPagedCallable(
            listSubnetworksTransportSettings, settings.listSubnetworksSettings(), clientContext);
    this.listUsableSubnetworksCallable =
        callableFactory.createUnaryCallable(
            listUsableSubnetworksTransportSettings,
            settings.listUsableSubnetworksSettings(),
            clientContext);
    this.listUsableSubnetworksPagedCallable =
        callableFactory.createPagedCallable(
            listUsableSubnetworksTransportSettings,
            settings.listUsableSubnetworksSettings(),
            clientContext);
    this.patchSubnetworkCallable =
        callableFactory.createUnaryCallable(
            patchSubnetworkTransportSettings, settings.patchSubnetworkSettings(), clientContext);
    this.setPrivateIpGoogleAccessSubnetworkCallable =
        callableFactory.createUnaryCallable(
            setPrivateIpGoogleAccessSubnetworkTransportSettings,
            settings.setPrivateIpGoogleAccessSubnetworkSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AggregatedListSubnetworksHttpRequest, AggregatedListSubnetworksPagedResponse>
      aggregatedListSubnetworksPagedCallable() {
    return aggregatedListSubnetworksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListSubnetworksHttpRequest, SubnetworkAggregatedList>
      aggregatedListSubnetworksCallable() {
    return aggregatedListSubnetworksCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteSubnetworkHttpRequest, Operation> deleteSubnetworkCallable() {
    return deleteSubnetworkCallable;
  }

  @BetaApi
  public UnaryCallable<ExpandIpCidrRangeSubnetworkHttpRequest, Operation>
      expandIpCidrRangeSubnetworkCallable() {
    return expandIpCidrRangeSubnetworkCallable;
  }

  @BetaApi
  public UnaryCallable<GetSubnetworkHttpRequest, Subnetwork> getSubnetworkCallable() {
    return getSubnetworkCallable;
  }

  @BetaApi
  public UnaryCallable<InsertSubnetworkHttpRequest, Operation> insertSubnetworkCallable() {
    return insertSubnetworkCallable;
  }

  @BetaApi
  public UnaryCallable<ListSubnetworksHttpRequest, ListSubnetworksPagedResponse>
      listSubnetworksPagedCallable() {
    return listSubnetworksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListSubnetworksHttpRequest, SubnetworkList> listSubnetworksCallable() {
    return listSubnetworksCallable;
  }

  @BetaApi
  public UnaryCallable<ListUsableSubnetworksHttpRequest, ListUsableSubnetworksPagedResponse>
      listUsableSubnetworksPagedCallable() {
    return listUsableSubnetworksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListUsableSubnetworksHttpRequest, UsableSubnetworksAggregatedList>
      listUsableSubnetworksCallable() {
    return listUsableSubnetworksCallable;
  }

  @BetaApi
  public UnaryCallable<PatchSubnetworkHttpRequest, Operation> patchSubnetworkCallable() {
    return patchSubnetworkCallable;
  }

  @BetaApi
  public UnaryCallable<SetPrivateIpGoogleAccessSubnetworkHttpRequest, Operation>
      setPrivateIpGoogleAccessSubnetworkCallable() {
    return setPrivateIpGoogleAccessSubnetworkCallable;
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
