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

import static com.google.cloud.compute.v1.RegionAutoscalerClient.ListRegionAutoscalersPagedResponse;

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
import com.google.cloud.compute.v1.Autoscaler;
import com.google.cloud.compute.v1.DeleteRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.GetRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.InsertRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.ListRegionAutoscalersHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionAutoscalerHttpRequest;
import com.google.cloud.compute.v1.ProjectRegionAutoscalerName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.RegionAutoscalerList;
import com.google.cloud.compute.v1.UpdateRegionAutoscalerHttpRequest;
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
public class HttpJsonRegionAutoscalerStub extends RegionAutoscalerStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionAutoscalerHttpRequest, Operation>
      deleteRegionAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionAutoscalerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionAutoscalers.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteRegionAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/autoscalers/{autoscaler}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionAutoscalerName.newFactory())
                      .setResourceNameField("autoscaler")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionAutoscalerHttpRequest, Autoscaler>
      getRegionAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<GetRegionAutoscalerHttpRequest, Autoscaler>newBuilder()
              .setFullMethodName("compute.regionAutoscalers.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/autoscalers/{autoscaler}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionAutoscalerName.newFactory())
                      .setResourceNameField("autoscaler")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Autoscaler>newBuilder()
                      .setResponseInstance(Autoscaler.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionAutoscalerHttpRequest, Operation>
      insertRegionAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionAutoscalerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionAutoscalers.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertRegionAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/autoscalers"))
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
  public static final ApiMethodDescriptor<ListRegionAutoscalersHttpRequest, RegionAutoscalerList>
      listRegionAutoscalersMethodDescriptor =
          ApiMethodDescriptor.<ListRegionAutoscalersHttpRequest, RegionAutoscalerList>newBuilder()
              .setFullMethodName("compute.regionAutoscalers.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionAutoscalersHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/autoscalers"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<RegionAutoscalerList>newBuilder()
                      .setResponseInstance(RegionAutoscalerList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRegionAutoscalerHttpRequest, Operation>
      patchRegionAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionAutoscalerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionAutoscalers.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchRegionAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/autoscalers"))
                      .setQueryParams(Sets.<String>newHashSet("autoscaler", "requestId"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateRegionAutoscalerHttpRequest, Operation>
      updateRegionAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionAutoscalerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionAutoscalers.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateRegionAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/autoscalers"))
                      .setQueryParams(Sets.<String>newHashSet("autoscaler", "requestId"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionAutoscalerHttpRequest, Operation>
      deleteRegionAutoscalerCallable;
  private final UnaryCallable<GetRegionAutoscalerHttpRequest, Autoscaler>
      getRegionAutoscalerCallable;
  private final UnaryCallable<InsertRegionAutoscalerHttpRequest, Operation>
      insertRegionAutoscalerCallable;
  private final UnaryCallable<ListRegionAutoscalersHttpRequest, RegionAutoscalerList>
      listRegionAutoscalersCallable;
  private final UnaryCallable<ListRegionAutoscalersHttpRequest, ListRegionAutoscalersPagedResponse>
      listRegionAutoscalersPagedCallable;
  private final UnaryCallable<PatchRegionAutoscalerHttpRequest, Operation>
      patchRegionAutoscalerCallable;
  private final UnaryCallable<UpdateRegionAutoscalerHttpRequest, Operation>
      updateRegionAutoscalerCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionAutoscalerStub create(RegionAutoscalerStubSettings settings)
      throws IOException {
    return new HttpJsonRegionAutoscalerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionAutoscalerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionAutoscalerStub(
        RegionAutoscalerStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionAutoscalerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionAutoscalerStub(
        RegionAutoscalerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionAutoscalerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionAutoscalerStub(
      RegionAutoscalerStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionAutoscalerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionAutoscalerStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionAutoscalerStub(
      RegionAutoscalerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionAutoscalerHttpRequest, Operation>
        deleteRegionAutoscalerTransportSettings =
            HttpJsonCallSettings.<DeleteRegionAutoscalerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionAutoscalerMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionAutoscalerHttpRequest, Autoscaler>
        getRegionAutoscalerTransportSettings =
            HttpJsonCallSettings.<GetRegionAutoscalerHttpRequest, Autoscaler>newBuilder()
                .setMethodDescriptor(getRegionAutoscalerMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionAutoscalerHttpRequest, Operation>
        insertRegionAutoscalerTransportSettings =
            HttpJsonCallSettings.<InsertRegionAutoscalerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionAutoscalerMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionAutoscalersHttpRequest, RegionAutoscalerList>
        listRegionAutoscalersTransportSettings =
            HttpJsonCallSettings
                .<ListRegionAutoscalersHttpRequest, RegionAutoscalerList>newBuilder()
                .setMethodDescriptor(listRegionAutoscalersMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchRegionAutoscalerHttpRequest, Operation>
        patchRegionAutoscalerTransportSettings =
            HttpJsonCallSettings.<PatchRegionAutoscalerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRegionAutoscalerMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateRegionAutoscalerHttpRequest, Operation>
        updateRegionAutoscalerTransportSettings =
            HttpJsonCallSettings.<UpdateRegionAutoscalerHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(updateRegionAutoscalerMethodDescriptor)
                .build();

    this.deleteRegionAutoscalerCallable =
        callableFactory.createUnaryCallable(
            deleteRegionAutoscalerTransportSettings,
            settings.deleteRegionAutoscalerSettings(),
            clientContext);
    this.getRegionAutoscalerCallable =
        callableFactory.createUnaryCallable(
            getRegionAutoscalerTransportSettings,
            settings.getRegionAutoscalerSettings(),
            clientContext);
    this.insertRegionAutoscalerCallable =
        callableFactory.createUnaryCallable(
            insertRegionAutoscalerTransportSettings,
            settings.insertRegionAutoscalerSettings(),
            clientContext);
    this.listRegionAutoscalersCallable =
        callableFactory.createUnaryCallable(
            listRegionAutoscalersTransportSettings,
            settings.listRegionAutoscalersSettings(),
            clientContext);
    this.listRegionAutoscalersPagedCallable =
        callableFactory.createPagedCallable(
            listRegionAutoscalersTransportSettings,
            settings.listRegionAutoscalersSettings(),
            clientContext);
    this.patchRegionAutoscalerCallable =
        callableFactory.createUnaryCallable(
            patchRegionAutoscalerTransportSettings,
            settings.patchRegionAutoscalerSettings(),
            clientContext);
    this.updateRegionAutoscalerCallable =
        callableFactory.createUnaryCallable(
            updateRegionAutoscalerTransportSettings,
            settings.updateRegionAutoscalerSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionAutoscalerHttpRequest, Operation>
      deleteRegionAutoscalerCallable() {
    return deleteRegionAutoscalerCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionAutoscalerHttpRequest, Autoscaler> getRegionAutoscalerCallable() {
    return getRegionAutoscalerCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionAutoscalerHttpRequest, Operation>
      insertRegionAutoscalerCallable() {
    return insertRegionAutoscalerCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionAutoscalersHttpRequest, ListRegionAutoscalersPagedResponse>
      listRegionAutoscalersPagedCallable() {
    return listRegionAutoscalersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionAutoscalersHttpRequest, RegionAutoscalerList>
      listRegionAutoscalersCallable() {
    return listRegionAutoscalersCallable;
  }

  @BetaApi
  public UnaryCallable<PatchRegionAutoscalerHttpRequest, Operation>
      patchRegionAutoscalerCallable() {
    return patchRegionAutoscalerCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateRegionAutoscalerHttpRequest, Operation>
      updateRegionAutoscalerCallable() {
    return updateRegionAutoscalerCallable;
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
