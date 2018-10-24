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

import static com.google.cloud.compute.v1.TargetPoolClient.AggregatedListTargetPoolsPagedResponse;
import static com.google.cloud.compute.v1.TargetPoolClient.ListTargetPoolsPagedResponse;

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
import com.google.cloud.compute.v1.AddHealthCheckTargetPoolHttpRequest;
import com.google.cloud.compute.v1.AddInstanceTargetPoolHttpRequest;
import com.google.cloud.compute.v1.AggregatedListTargetPoolsHttpRequest;
import com.google.cloud.compute.v1.DeleteTargetPoolHttpRequest;
import com.google.cloud.compute.v1.GetHealthTargetPoolHttpRequest;
import com.google.cloud.compute.v1.GetTargetPoolHttpRequest;
import com.google.cloud.compute.v1.InsertTargetPoolHttpRequest;
import com.google.cloud.compute.v1.ListTargetPoolsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionTargetPoolName;
import com.google.cloud.compute.v1.RemoveHealthCheckTargetPoolHttpRequest;
import com.google.cloud.compute.v1.RemoveInstanceTargetPoolHttpRequest;
import com.google.cloud.compute.v1.SetBackupTargetPoolHttpRequest;
import com.google.cloud.compute.v1.TargetPool;
import com.google.cloud.compute.v1.TargetPoolAggregatedList;
import com.google.cloud.compute.v1.TargetPoolInstanceHealth;
import com.google.cloud.compute.v1.TargetPoolList;
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
public class HttpJsonTargetPoolStub extends TargetPoolStub {
  @InternalApi
  public static final ApiMethodDescriptor<AddHealthCheckTargetPoolHttpRequest, Operation>
      addHealthCheckTargetPoolMethodDescriptor =
          ApiMethodDescriptor.<AddHealthCheckTargetPoolHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetPools.addHealthCheck")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AddHealthCheckTargetPoolHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetPools/{targetPool}/addHealthCheck"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetPoolName.newFactory())
                      .setResourceNameField("targetPool")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<AddInstanceTargetPoolHttpRequest, Operation>
      addInstanceTargetPoolMethodDescriptor =
          ApiMethodDescriptor.<AddInstanceTargetPoolHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetPools.addInstance")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AddInstanceTargetPoolHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetPools/{targetPool}/addInstance"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetPoolName.newFactory())
                      .setResourceNameField("targetPool")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListTargetPoolsHttpRequest, TargetPoolAggregatedList>
      aggregatedListTargetPoolsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListTargetPoolsHttpRequest, TargetPoolAggregatedList>newBuilder()
              .setFullMethodName("compute.targetPools.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListTargetPoolsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/targetPools"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetPoolAggregatedList>newBuilder()
                      .setResponseInstance(TargetPoolAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteTargetPoolHttpRequest, Operation>
      deleteTargetPoolMethodDescriptor =
          ApiMethodDescriptor.<DeleteTargetPoolHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetPools.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteTargetPoolHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetPools/{targetPool}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetPoolName.newFactory())
                      .setResourceNameField("targetPool")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetTargetPoolHttpRequest, TargetPool>
      getTargetPoolMethodDescriptor =
          ApiMethodDescriptor.<GetTargetPoolHttpRequest, TargetPool>newBuilder()
              .setFullMethodName("compute.targetPools.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetTargetPoolHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetPools/{targetPool}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionTargetPoolName.newFactory())
                      .setResourceNameField("targetPool")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetPool>newBuilder()
                      .setResponseInstance(TargetPool.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>
      getHealthTargetPoolMethodDescriptor =
          ApiMethodDescriptor.<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>newBuilder()
              .setFullMethodName("compute.targetPools.getHealth")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetHealthTargetPoolHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetPools/{targetPool}/getHealth"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionTargetPoolName.newFactory())
                      .setResourceNameField("targetPool")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetPoolInstanceHealth>newBuilder()
                      .setResponseInstance(TargetPoolInstanceHealth.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertTargetPoolHttpRequest, Operation>
      insertTargetPoolMethodDescriptor =
          ApiMethodDescriptor.<InsertTargetPoolHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetPools.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertTargetPoolHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/targetPools"))
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
  public static final ApiMethodDescriptor<ListTargetPoolsHttpRequest, TargetPoolList>
      listTargetPoolsMethodDescriptor =
          ApiMethodDescriptor.<ListTargetPoolsHttpRequest, TargetPoolList>newBuilder()
              .setFullMethodName("compute.targetPools.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListTargetPoolsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/targetPools"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TargetPoolList>newBuilder()
                      .setResponseInstance(TargetPoolList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveHealthCheckTargetPoolHttpRequest, Operation>
      removeHealthCheckTargetPoolMethodDescriptor =
          ApiMethodDescriptor.<RemoveHealthCheckTargetPoolHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetPools.removeHealthCheck")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<RemoveHealthCheckTargetPoolHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetPools/{targetPool}/removeHealthCheck"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetPoolName.newFactory())
                      .setResourceNameField("targetPool")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveInstanceTargetPoolHttpRequest, Operation>
      removeInstanceTargetPoolMethodDescriptor =
          ApiMethodDescriptor.<RemoveInstanceTargetPoolHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetPools.removeInstance")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<RemoveInstanceTargetPoolHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetPools/{targetPool}/removeInstance"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionTargetPoolName.newFactory())
                      .setResourceNameField("targetPool")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetBackupTargetPoolHttpRequest, Operation>
      setBackupTargetPoolMethodDescriptor =
          ApiMethodDescriptor.<SetBackupTargetPoolHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.targetPools.setBackup")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetBackupTargetPoolHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/targetPools/{targetPool}/setBackup"))
                      .setQueryParams(Sets.<String>newHashSet("failoverRatio", "requestId"))
                      .setResourceNameFactory(ProjectRegionTargetPoolName.newFactory())
                      .setResourceNameField("targetPool")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddHealthCheckTargetPoolHttpRequest, Operation>
      addHealthCheckTargetPoolCallable;
  private final UnaryCallable<AddInstanceTargetPoolHttpRequest, Operation>
      addInstanceTargetPoolCallable;
  private final UnaryCallable<AggregatedListTargetPoolsHttpRequest, TargetPoolAggregatedList>
      aggregatedListTargetPoolsCallable;
  private final UnaryCallable<
          AggregatedListTargetPoolsHttpRequest, AggregatedListTargetPoolsPagedResponse>
      aggregatedListTargetPoolsPagedCallable;
  private final UnaryCallable<DeleteTargetPoolHttpRequest, Operation> deleteTargetPoolCallable;
  private final UnaryCallable<GetTargetPoolHttpRequest, TargetPool> getTargetPoolCallable;
  private final UnaryCallable<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>
      getHealthTargetPoolCallable;
  private final UnaryCallable<InsertTargetPoolHttpRequest, Operation> insertTargetPoolCallable;
  private final UnaryCallable<ListTargetPoolsHttpRequest, TargetPoolList> listTargetPoolsCallable;
  private final UnaryCallable<ListTargetPoolsHttpRequest, ListTargetPoolsPagedResponse>
      listTargetPoolsPagedCallable;
  private final UnaryCallable<RemoveHealthCheckTargetPoolHttpRequest, Operation>
      removeHealthCheckTargetPoolCallable;
  private final UnaryCallable<RemoveInstanceTargetPoolHttpRequest, Operation>
      removeInstanceTargetPoolCallable;
  private final UnaryCallable<SetBackupTargetPoolHttpRequest, Operation>
      setBackupTargetPoolCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTargetPoolStub create(TargetPoolStubSettings settings)
      throws IOException {
    return new HttpJsonTargetPoolStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTargetPoolStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonTargetPoolStub(TargetPoolStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonTargetPoolStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTargetPoolStub(
        TargetPoolStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTargetPoolStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTargetPoolStub(TargetPoolStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTargetPoolCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTargetPoolStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTargetPoolStub(
      TargetPoolStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddHealthCheckTargetPoolHttpRequest, Operation>
        addHealthCheckTargetPoolTransportSettings =
            HttpJsonCallSettings.<AddHealthCheckTargetPoolHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(addHealthCheckTargetPoolMethodDescriptor)
                .build();
    HttpJsonCallSettings<AddInstanceTargetPoolHttpRequest, Operation>
        addInstanceTargetPoolTransportSettings =
            HttpJsonCallSettings.<AddInstanceTargetPoolHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(addInstanceTargetPoolMethodDescriptor)
                .build();
    HttpJsonCallSettings<AggregatedListTargetPoolsHttpRequest, TargetPoolAggregatedList>
        aggregatedListTargetPoolsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListTargetPoolsHttpRequest, TargetPoolAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListTargetPoolsMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteTargetPoolHttpRequest, Operation> deleteTargetPoolTransportSettings =
        HttpJsonCallSettings.<DeleteTargetPoolHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteTargetPoolMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetTargetPoolHttpRequest, TargetPool> getTargetPoolTransportSettings =
        HttpJsonCallSettings.<GetTargetPoolHttpRequest, TargetPool>newBuilder()
            .setMethodDescriptor(getTargetPoolMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>
        getHealthTargetPoolTransportSettings =
            HttpJsonCallSettings
                .<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>newBuilder()
                .setMethodDescriptor(getHealthTargetPoolMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertTargetPoolHttpRequest, Operation> insertTargetPoolTransportSettings =
        HttpJsonCallSettings.<InsertTargetPoolHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertTargetPoolMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListTargetPoolsHttpRequest, TargetPoolList>
        listTargetPoolsTransportSettings =
            HttpJsonCallSettings.<ListTargetPoolsHttpRequest, TargetPoolList>newBuilder()
                .setMethodDescriptor(listTargetPoolsMethodDescriptor)
                .build();
    HttpJsonCallSettings<RemoveHealthCheckTargetPoolHttpRequest, Operation>
        removeHealthCheckTargetPoolTransportSettings =
            HttpJsonCallSettings.<RemoveHealthCheckTargetPoolHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(removeHealthCheckTargetPoolMethodDescriptor)
                .build();
    HttpJsonCallSettings<RemoveInstanceTargetPoolHttpRequest, Operation>
        removeInstanceTargetPoolTransportSettings =
            HttpJsonCallSettings.<RemoveInstanceTargetPoolHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(removeInstanceTargetPoolMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetBackupTargetPoolHttpRequest, Operation>
        setBackupTargetPoolTransportSettings =
            HttpJsonCallSettings.<SetBackupTargetPoolHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setBackupTargetPoolMethodDescriptor)
                .build();

    this.addHealthCheckTargetPoolCallable =
        callableFactory.createUnaryCallable(
            addHealthCheckTargetPoolTransportSettings,
            settings.addHealthCheckTargetPoolSettings(),
            clientContext);
    this.addInstanceTargetPoolCallable =
        callableFactory.createUnaryCallable(
            addInstanceTargetPoolTransportSettings,
            settings.addInstanceTargetPoolSettings(),
            clientContext);
    this.aggregatedListTargetPoolsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListTargetPoolsTransportSettings,
            settings.aggregatedListTargetPoolsSettings(),
            clientContext);
    this.aggregatedListTargetPoolsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListTargetPoolsTransportSettings,
            settings.aggregatedListTargetPoolsSettings(),
            clientContext);
    this.deleteTargetPoolCallable =
        callableFactory.createUnaryCallable(
            deleteTargetPoolTransportSettings, settings.deleteTargetPoolSettings(), clientContext);
    this.getTargetPoolCallable =
        callableFactory.createUnaryCallable(
            getTargetPoolTransportSettings, settings.getTargetPoolSettings(), clientContext);
    this.getHealthTargetPoolCallable =
        callableFactory.createUnaryCallable(
            getHealthTargetPoolTransportSettings,
            settings.getHealthTargetPoolSettings(),
            clientContext);
    this.insertTargetPoolCallable =
        callableFactory.createUnaryCallable(
            insertTargetPoolTransportSettings, settings.insertTargetPoolSettings(), clientContext);
    this.listTargetPoolsCallable =
        callableFactory.createUnaryCallable(
            listTargetPoolsTransportSettings, settings.listTargetPoolsSettings(), clientContext);
    this.listTargetPoolsPagedCallable =
        callableFactory.createPagedCallable(
            listTargetPoolsTransportSettings, settings.listTargetPoolsSettings(), clientContext);
    this.removeHealthCheckTargetPoolCallable =
        callableFactory.createUnaryCallable(
            removeHealthCheckTargetPoolTransportSettings,
            settings.removeHealthCheckTargetPoolSettings(),
            clientContext);
    this.removeInstanceTargetPoolCallable =
        callableFactory.createUnaryCallable(
            removeInstanceTargetPoolTransportSettings,
            settings.removeInstanceTargetPoolSettings(),
            clientContext);
    this.setBackupTargetPoolCallable =
        callableFactory.createUnaryCallable(
            setBackupTargetPoolTransportSettings,
            settings.setBackupTargetPoolSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AddHealthCheckTargetPoolHttpRequest, Operation>
      addHealthCheckTargetPoolCallable() {
    return addHealthCheckTargetPoolCallable;
  }

  @BetaApi
  public UnaryCallable<AddInstanceTargetPoolHttpRequest, Operation>
      addInstanceTargetPoolCallable() {
    return addInstanceTargetPoolCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListTargetPoolsHttpRequest, AggregatedListTargetPoolsPagedResponse>
      aggregatedListTargetPoolsPagedCallable() {
    return aggregatedListTargetPoolsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListTargetPoolsHttpRequest, TargetPoolAggregatedList>
      aggregatedListTargetPoolsCallable() {
    return aggregatedListTargetPoolsCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteTargetPoolHttpRequest, Operation> deleteTargetPoolCallable() {
    return deleteTargetPoolCallable;
  }

  @BetaApi
  public UnaryCallable<GetTargetPoolHttpRequest, TargetPool> getTargetPoolCallable() {
    return getTargetPoolCallable;
  }

  @BetaApi
  public UnaryCallable<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>
      getHealthTargetPoolCallable() {
    return getHealthTargetPoolCallable;
  }

  @BetaApi
  public UnaryCallable<InsertTargetPoolHttpRequest, Operation> insertTargetPoolCallable() {
    return insertTargetPoolCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetPoolsHttpRequest, ListTargetPoolsPagedResponse>
      listTargetPoolsPagedCallable() {
    return listTargetPoolsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListTargetPoolsHttpRequest, TargetPoolList> listTargetPoolsCallable() {
    return listTargetPoolsCallable;
  }

  @BetaApi
  public UnaryCallable<RemoveHealthCheckTargetPoolHttpRequest, Operation>
      removeHealthCheckTargetPoolCallable() {
    return removeHealthCheckTargetPoolCallable;
  }

  @BetaApi
  public UnaryCallable<RemoveInstanceTargetPoolHttpRequest, Operation>
      removeInstanceTargetPoolCallable() {
    return removeInstanceTargetPoolCallable;
  }

  @BetaApi
  public UnaryCallable<SetBackupTargetPoolHttpRequest, Operation> setBackupTargetPoolCallable() {
    return setBackupTargetPoolCallable;
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
