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

import static com.google.cloud.compute.v1.InstanceGroupClient.AggregatedListInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupClient.ListInstanceGroupsPagedResponse;
import static com.google.cloud.compute.v1.InstanceGroupClient.ListInstancesInstanceGroupsPagedResponse;

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
import com.google.cloud.compute.v1.AddInstancesInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.AggregatedListInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.DeleteInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.GetInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.InsertInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.InstanceGroup;
import com.google.cloud.compute.v1.InstanceGroupAggregatedList;
import com.google.cloud.compute.v1.InstanceGroupList;
import com.google.cloud.compute.v1.InstanceGroupsListInstances;
import com.google.cloud.compute.v1.ListInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.ListInstancesInstanceGroupsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneInstanceGroupName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.RemoveInstancesInstanceGroupHttpRequest;
import com.google.cloud.compute.v1.SetNamedPortsInstanceGroupHttpRequest;
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
public class HttpJsonInstanceGroupStub extends InstanceGroupStub {
  @InternalApi
  public static final ApiMethodDescriptor<AddInstancesInstanceGroupHttpRequest, Operation>
      addInstancesInstanceGroupMethodDescriptor =
          ApiMethodDescriptor.<AddInstancesInstanceGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroups.addInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AddInstancesInstanceGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroups/{instanceGroup}/addInstances"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupName.newFactory())
                      .setResourceNameField("instanceGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList>
      aggregatedListInstanceGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList>newBuilder()
              .setFullMethodName("compute.instanceGroups.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListInstanceGroupsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/instanceGroups"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceGroupAggregatedList>newBuilder()
                      .setResponseInstance(InstanceGroupAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteInstanceGroupHttpRequest, Operation>
      deleteInstanceGroupMethodDescriptor =
          ApiMethodDescriptor.<DeleteInstanceGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroups.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteInstanceGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroups/{instanceGroup}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupName.newFactory())
                      .setResourceNameField("instanceGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetInstanceGroupHttpRequest, InstanceGroup>
      getInstanceGroupMethodDescriptor =
          ApiMethodDescriptor.<GetInstanceGroupHttpRequest, InstanceGroup>newBuilder()
              .setFullMethodName("compute.instanceGroups.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetInstanceGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroups/{instanceGroup}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneInstanceGroupName.newFactory())
                      .setResourceNameField("instanceGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceGroup>newBuilder()
                      .setResponseInstance(InstanceGroup.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertInstanceGroupHttpRequest, Operation>
      insertInstanceGroupMethodDescriptor =
          ApiMethodDescriptor.<InsertInstanceGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroups.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertInstanceGroupHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/instanceGroups"))
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
  public static final ApiMethodDescriptor<ListInstanceGroupsHttpRequest, InstanceGroupList>
      listInstanceGroupsMethodDescriptor =
          ApiMethodDescriptor.<ListInstanceGroupsHttpRequest, InstanceGroupList>newBuilder()
              .setFullMethodName("compute.instanceGroups.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListInstanceGroupsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/instanceGroups"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceGroupList>newBuilder()
                      .setResponseInstance(InstanceGroupList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances>
      listInstancesInstanceGroupsMethodDescriptor =
          ApiMethodDescriptor
              .<ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances>newBuilder()
              .setFullMethodName("compute.instanceGroups.listInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListInstancesInstanceGroupsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroups/{instanceGroup}/listInstances"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupName.newFactory())
                      .setResourceNameField("instanceGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InstanceGroupsListInstances>newBuilder()
                      .setResponseInstance(InstanceGroupsListInstances.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveInstancesInstanceGroupHttpRequest, Operation>
      removeInstancesInstanceGroupMethodDescriptor =
          ApiMethodDescriptor.<RemoveInstancesInstanceGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroups.removeInstances")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<RemoveInstancesInstanceGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroups/{instanceGroup}/removeInstances"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupName.newFactory())
                      .setResourceNameField("instanceGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetNamedPortsInstanceGroupHttpRequest, Operation>
      setNamedPortsInstanceGroupMethodDescriptor =
          ApiMethodDescriptor.<SetNamedPortsInstanceGroupHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.instanceGroups.setNamedPorts")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetNamedPortsInstanceGroupHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/instanceGroups/{instanceGroup}/setNamedPorts"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneInstanceGroupName.newFactory())
                      .setResourceNameField("instanceGroup")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddInstancesInstanceGroupHttpRequest, Operation>
      addInstancesInstanceGroupCallable;
  private final UnaryCallable<AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList>
      aggregatedListInstanceGroupsCallable;
  private final UnaryCallable<
          AggregatedListInstanceGroupsHttpRequest, AggregatedListInstanceGroupsPagedResponse>
      aggregatedListInstanceGroupsPagedCallable;
  private final UnaryCallable<DeleteInstanceGroupHttpRequest, Operation>
      deleteInstanceGroupCallable;
  private final UnaryCallable<GetInstanceGroupHttpRequest, InstanceGroup> getInstanceGroupCallable;
  private final UnaryCallable<InsertInstanceGroupHttpRequest, Operation>
      insertInstanceGroupCallable;
  private final UnaryCallable<ListInstanceGroupsHttpRequest, InstanceGroupList>
      listInstanceGroupsCallable;
  private final UnaryCallable<ListInstanceGroupsHttpRequest, ListInstanceGroupsPagedResponse>
      listInstanceGroupsPagedCallable;
  private final UnaryCallable<ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances>
      listInstancesInstanceGroupsCallable;
  private final UnaryCallable<
          ListInstancesInstanceGroupsHttpRequest, ListInstancesInstanceGroupsPagedResponse>
      listInstancesInstanceGroupsPagedCallable;
  private final UnaryCallable<RemoveInstancesInstanceGroupHttpRequest, Operation>
      removeInstancesInstanceGroupCallable;
  private final UnaryCallable<SetNamedPortsInstanceGroupHttpRequest, Operation>
      setNamedPortsInstanceGroupCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInstanceGroupStub create(InstanceGroupStubSettings settings)
      throws IOException {
    return new HttpJsonInstanceGroupStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInstanceGroupStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInstanceGroupStub(
        InstanceGroupStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInstanceGroupStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInstanceGroupStub(
        InstanceGroupStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupStub(
      InstanceGroupStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInstanceGroupCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInstanceGroupStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInstanceGroupStub(
      InstanceGroupStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddInstancesInstanceGroupHttpRequest, Operation>
        addInstancesInstanceGroupTransportSettings =
            HttpJsonCallSettings.<AddInstancesInstanceGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(addInstancesInstanceGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList>
        aggregatedListInstanceGroupsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListInstanceGroupsMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteInstanceGroupHttpRequest, Operation>
        deleteInstanceGroupTransportSettings =
            HttpJsonCallSettings.<DeleteInstanceGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInstanceGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetInstanceGroupHttpRequest, InstanceGroup>
        getInstanceGroupTransportSettings =
            HttpJsonCallSettings.<GetInstanceGroupHttpRequest, InstanceGroup>newBuilder()
                .setMethodDescriptor(getInstanceGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertInstanceGroupHttpRequest, Operation>
        insertInstanceGroupTransportSettings =
            HttpJsonCallSettings.<InsertInstanceGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertInstanceGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListInstanceGroupsHttpRequest, InstanceGroupList>
        listInstanceGroupsTransportSettings =
            HttpJsonCallSettings.<ListInstanceGroupsHttpRequest, InstanceGroupList>newBuilder()
                .setMethodDescriptor(listInstanceGroupsMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances>
        listInstancesInstanceGroupsTransportSettings =
            HttpJsonCallSettings
                .<ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances>newBuilder()
                .setMethodDescriptor(listInstancesInstanceGroupsMethodDescriptor)
                .build();
    HttpJsonCallSettings<RemoveInstancesInstanceGroupHttpRequest, Operation>
        removeInstancesInstanceGroupTransportSettings =
            HttpJsonCallSettings.<RemoveInstancesInstanceGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(removeInstancesInstanceGroupMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetNamedPortsInstanceGroupHttpRequest, Operation>
        setNamedPortsInstanceGroupTransportSettings =
            HttpJsonCallSettings.<SetNamedPortsInstanceGroupHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setNamedPortsInstanceGroupMethodDescriptor)
                .build();

    this.addInstancesInstanceGroupCallable =
        callableFactory.createUnaryCallable(
            addInstancesInstanceGroupTransportSettings,
            settings.addInstancesInstanceGroupSettings(),
            clientContext);
    this.aggregatedListInstanceGroupsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListInstanceGroupsTransportSettings,
            settings.aggregatedListInstanceGroupsSettings(),
            clientContext);
    this.aggregatedListInstanceGroupsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListInstanceGroupsTransportSettings,
            settings.aggregatedListInstanceGroupsSettings(),
            clientContext);
    this.deleteInstanceGroupCallable =
        callableFactory.createUnaryCallable(
            deleteInstanceGroupTransportSettings,
            settings.deleteInstanceGroupSettings(),
            clientContext);
    this.getInstanceGroupCallable =
        callableFactory.createUnaryCallable(
            getInstanceGroupTransportSettings, settings.getInstanceGroupSettings(), clientContext);
    this.insertInstanceGroupCallable =
        callableFactory.createUnaryCallable(
            insertInstanceGroupTransportSettings,
            settings.insertInstanceGroupSettings(),
            clientContext);
    this.listInstanceGroupsCallable =
        callableFactory.createUnaryCallable(
            listInstanceGroupsTransportSettings,
            settings.listInstanceGroupsSettings(),
            clientContext);
    this.listInstanceGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listInstanceGroupsTransportSettings,
            settings.listInstanceGroupsSettings(),
            clientContext);
    this.listInstancesInstanceGroupsCallable =
        callableFactory.createUnaryCallable(
            listInstancesInstanceGroupsTransportSettings,
            settings.listInstancesInstanceGroupsSettings(),
            clientContext);
    this.listInstancesInstanceGroupsPagedCallable =
        callableFactory.createPagedCallable(
            listInstancesInstanceGroupsTransportSettings,
            settings.listInstancesInstanceGroupsSettings(),
            clientContext);
    this.removeInstancesInstanceGroupCallable =
        callableFactory.createUnaryCallable(
            removeInstancesInstanceGroupTransportSettings,
            settings.removeInstancesInstanceGroupSettings(),
            clientContext);
    this.setNamedPortsInstanceGroupCallable =
        callableFactory.createUnaryCallable(
            setNamedPortsInstanceGroupTransportSettings,
            settings.setNamedPortsInstanceGroupSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AddInstancesInstanceGroupHttpRequest, Operation>
      addInstancesInstanceGroupCallable() {
    return addInstancesInstanceGroupCallable;
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListInstanceGroupsHttpRequest, AggregatedListInstanceGroupsPagedResponse>
      aggregatedListInstanceGroupsPagedCallable() {
    return aggregatedListInstanceGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListInstanceGroupsHttpRequest, InstanceGroupAggregatedList>
      aggregatedListInstanceGroupsCallable() {
    return aggregatedListInstanceGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteInstanceGroupHttpRequest, Operation> deleteInstanceGroupCallable() {
    return deleteInstanceGroupCallable;
  }

  @BetaApi
  public UnaryCallable<GetInstanceGroupHttpRequest, InstanceGroup> getInstanceGroupCallable() {
    return getInstanceGroupCallable;
  }

  @BetaApi
  public UnaryCallable<InsertInstanceGroupHttpRequest, Operation> insertInstanceGroupCallable() {
    return insertInstanceGroupCallable;
  }

  @BetaApi
  public UnaryCallable<ListInstanceGroupsHttpRequest, ListInstanceGroupsPagedResponse>
      listInstanceGroupsPagedCallable() {
    return listInstanceGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListInstanceGroupsHttpRequest, InstanceGroupList>
      listInstanceGroupsCallable() {
    return listInstanceGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListInstancesInstanceGroupsHttpRequest, ListInstancesInstanceGroupsPagedResponse>
      listInstancesInstanceGroupsPagedCallable() {
    return listInstancesInstanceGroupsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListInstancesInstanceGroupsHttpRequest, InstanceGroupsListInstances>
      listInstancesInstanceGroupsCallable() {
    return listInstancesInstanceGroupsCallable;
  }

  @BetaApi
  public UnaryCallable<RemoveInstancesInstanceGroupHttpRequest, Operation>
      removeInstancesInstanceGroupCallable() {
    return removeInstancesInstanceGroupCallable;
  }

  @BetaApi
  public UnaryCallable<SetNamedPortsInstanceGroupHttpRequest, Operation>
      setNamedPortsInstanceGroupCallable() {
    return setNamedPortsInstanceGroupCallable;
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
