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

import static com.google.cloud.compute.v1.TargetInstanceClient.AggregatedListTargetInstancesPagedResponse;
import static com.google.cloud.compute.v1.TargetInstanceClient.ListTargetInstancesPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListTargetInstancesHttpRequest;
import com.google.cloud.compute.v1.DeleteTargetInstanceHttpRequest;
import com.google.cloud.compute.v1.GetTargetInstanceHttpRequest;
import com.google.cloud.compute.v1.InsertTargetInstanceHttpRequest;
import com.google.cloud.compute.v1.ListTargetInstancesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.ProjectZoneTargetInstanceName;
import com.google.cloud.compute.v1.TargetInstance;
import com.google.cloud.compute.v1.TargetInstanceAggregatedList;
import com.google.cloud.compute.v1.TargetInstanceList;
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
public class HttpJsonTargetInstanceStub extends TargetInstanceStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList>
      aggregatedListTargetInstancesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList>newBuilder()
              .setFullMethodName("compute.targetInstances.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListTargetInstancesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/targetInstances"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetInstanceAggregatedList>newBuilder()
                      .setResponseInstance(TargetInstanceAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetInstanceHttpRequest, Operation>
      deleteTargetInstanceMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetInstanceHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetInstances.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteTargetInstanceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/targetInstances/{targetInstance}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneTargetInstanceName.newFactory())
                      .setResourceNameField("targetInstance")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetTargetInstanceHttpRequest, TargetInstance>
      getTargetInstanceMethodDescriptor =
          ApiMethodDescriptor.<GetTargetInstanceHttpRequest, TargetInstance>newBuilder()
              .setFullMethodName("compute.targetInstances.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetTargetInstanceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/targetInstances/{targetInstance}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneTargetInstanceName.newFactory())
                      .setResourceNameField("targetInstance")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetInstance>newBuilder()
                      .setResponseInstance(TargetInstance.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetInstanceHttpRequest, Operation>
      insertTargetInstanceMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetInstanceHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetInstances.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertTargetInstanceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/targetInstances"))
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
  public static final ApiMethodDescriptor<ListTargetInstancesHttpRequest, TargetInstanceList>
      listTargetInstancesMethodDescriptor =
          ApiMethodDescriptor.<ListTargetInstancesHttpRequest, TargetInstanceList>newBuilder()
              .setFullMethodName("compute.targetInstances.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListTargetInstancesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/targetInstances"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetInstanceList>newBuilder()
                      .setResponseInstance(TargetInstanceList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList>
      aggregatedListTargetInstancesCallable;
  private final UnaryCallable<
          AggregatedListTargetInstancesHttpRequest, AggregatedListTargetInstancesPagedResponse>
      aggregatedListTargetInstancesPagedCallable;
  private final UnaryCallable<DeleteTargetInstanceHttpRequest, Operation>
      deleteTargetInstanceCallable;
  private final UnaryCallable<GetTargetInstanceHttpRequest, TargetInstance>
      getTargetInstanceCallable;
  private final UnaryCallable<InsertTargetInstanceHttpRequest, Operation>
      insertTargetInstanceCallable;
  private final UnaryCallable<ListTargetInstancesHttpRequest, TargetInstanceList>
      listTargetInstancesCallable;
  private final UnaryCallable<ListTargetInstancesHttpRequest, ListTargetInstancesPagedResponse>
      listTargetInstancesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetInstanceStub create(TargetInstanceStubSettings settings)
      throws IOException {
    return new HttpJsonTargetInstanceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetInstanceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetInstanceStub(
        TargetInstanceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetInstanceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetInstanceStub(
        TargetInstanceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetInstanceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetInstanceStub(
      TargetInstanceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonTargetInstanceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetInstanceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonTargetInstanceStub(
      TargetInstanceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList>
        aggregatedListTargetInstancesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListTargetInstancesMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteTargetInstanceHttpRequest, Operation>
        deleteTargetInstanceTransportSettings =
            HttpJsonCallSettings.<DeleteTargetInstanceHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteTargetInstanceMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetTargetInstanceHttpRequest, TargetInstance>
        getTargetInstanceTransportSettings =
            HttpJsonCallSettings.<GetTargetInstanceHttpRequest, TargetInstance>newBuilder()
                .setMethodDescriptor(getTargetInstanceMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertTargetInstanceHttpRequest, Operation>
        insertTargetInstanceTransportSettings =
            HttpJsonCallSettings.<InsertTargetInstanceHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertTargetInstanceMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListTargetInstancesHttpRequest, TargetInstanceList>
        listTargetInstancesTransportSettings =
            HttpJsonCallSettings.<ListTargetInstancesHttpRequest, TargetInstanceList>newBuilder()
                .setMethodDescriptor(listTargetInstancesMethodDescriptor)
                .build();

    this.aggregatedListTargetInstancesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTargetInstancesTransportSettings,
            settings.aggregatedListTargetInstancesSettings(),
            clientContext);
    this.aggregatedListTargetInstancesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTargetInstancesTransportSettings,
            settings.aggregatedListTargetInstancesSettings(),
            clientContext);
    this.deleteTargetInstanceCallable =
        callableFactory.createUnaryCallable(
            deleteTargetInstanceTransportSettings,
            settings.deleteTargetInstanceSettings(),
            clientContext);
    this.getTargetInstanceCallable =
        callableFactory.createUnaryCallable(
            getTargetInstanceTransportSettings,
            settings.getTargetInstanceSettings(),
            clientContext);
    this.insertTargetInstanceCallable =
        callableFactory.createUnaryCallable(
            insertTargetInstanceTransportSettings,
            settings.insertTargetInstanceSettings(),
            clientContext);
    this.listTargetInstancesCallable =
        callableFactory.createUnaryCallable(
            listTargetInstancesTransportSettings,
            settings.listTargetInstancesSettings(),
            clientContext);
    this.listTargetInstancesPagedCallable =
        callableFactory.createPagedCallable(
            listTargetInstancesTransportSettings,
            settings.listTargetInstancesSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListTargetInstancesHttpRequest, AggregatedListTargetInstancesPagedResponse>
      aggregatedListTargetInstancesPagedCallable() {
    return aggregatedListTargetInstancesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList>
      aggregatedListTargetInstancesCallable() {
    return aggregatedListTargetInstancesCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteTargetInstanceHttpRequest, Operation> deleteTargetInstanceCallable() {
    return deleteTargetInstanceCallable;
  }

  @BetaApi
  public UnaryCallable<GetTargetInstanceHttpRequest, TargetInstance> getTargetInstanceCallable() {
    return getTargetInstanceCallable;
  }

  @BetaApi
  public UnaryCallable<InsertTargetInstanceHttpRequest, Operation> insertTargetInstanceCallable() {
    return insertTargetInstanceCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetInstancesHttpRequest, ListTargetInstancesPagedResponse>
      listTargetInstancesPagedCallable() {
    return listTargetInstancesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetInstancesHttpRequest, TargetInstanceList>
      listTargetInstancesCallable() {
    return listTargetInstancesCallable;
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
