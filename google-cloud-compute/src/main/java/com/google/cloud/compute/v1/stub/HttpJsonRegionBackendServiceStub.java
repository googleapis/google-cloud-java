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

import static com.google.cloud.compute.v1.RegionBackendServiceClient.ListRegionBackendServicesPagedResponse;

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
import com.google.cloud.compute.v1.BackendService;
import com.google.cloud.compute.v1.BackendServiceGroupHealth;
import com.google.cloud.compute.v1.BackendServiceList;
import com.google.cloud.compute.v1.DeleteRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.GetHealthRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.GetRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.InsertRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.ListRegionBackendServicesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionBackendServiceHttpRequest;
import com.google.cloud.compute.v1.ProjectRegionBackendServiceName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.UpdateRegionBackendServiceHttpRequest;
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
public class HttpJsonRegionBackendServiceStub extends RegionBackendServiceStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionBackendServiceHttpRequest, Operation>
      deleteRegionBackendServiceMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionBackendServiceHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionBackendServices.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteRegionBackendServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/backendServices/{backendService}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionBackendServiceName.newFactory())
                      .setResourceNameField("backendService")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionBackendServiceHttpRequest, BackendService>
      getRegionBackendServiceMethodDescriptor =
          ApiMethodDescriptor.<GetRegionBackendServiceHttpRequest, BackendService>newBuilder()
              .setFullMethodName("compute.regionBackendServices.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionBackendServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/backendServices/{backendService}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionBackendServiceName.newFactory())
                      .setResourceNameField("backendService")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<BackendService>newBuilder()
                      .setResponseInstance(BackendService.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
      getHealthRegionBackendServiceMethodDescriptor =
          ApiMethodDescriptor
              .<GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>newBuilder()
              .setFullMethodName("compute.regionBackendServices.getHealth")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<GetHealthRegionBackendServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/backendServices/{backendService}/getHealth"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionBackendServiceName.newFactory())
                      .setResourceNameField("backendService")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<BackendServiceGroupHealth>newBuilder()
                      .setResponseInstance(BackendServiceGroupHealth.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionBackendServiceHttpRequest, Operation>
      insertRegionBackendServiceMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionBackendServiceHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionBackendServices.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertRegionBackendServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/backendServices"))
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
  public static final ApiMethodDescriptor<ListRegionBackendServicesHttpRequest, BackendServiceList>
      listRegionBackendServicesMethodDescriptor =
          ApiMethodDescriptor.<ListRegionBackendServicesHttpRequest, BackendServiceList>newBuilder()
              .setFullMethodName("compute.regionBackendServices.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionBackendServicesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/backendServices"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<BackendServiceList>newBuilder()
                      .setResponseInstance(BackendServiceList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRegionBackendServiceHttpRequest, Operation>
      patchRegionBackendServiceMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionBackendServiceHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionBackendServices.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchRegionBackendServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/backendServices/{backendService}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionBackendServiceName.newFactory())
                      .setResourceNameField("backendService")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateRegionBackendServiceHttpRequest, Operation>
      updateRegionBackendServiceMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionBackendServiceHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionBackendServices.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateRegionBackendServiceHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/backendServices/{backendService}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionBackendServiceName.newFactory())
                      .setResourceNameField("backendService")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionBackendServiceHttpRequest, Operation>
      deleteRegionBackendServiceCallable;
  private final UnaryCallable<GetRegionBackendServiceHttpRequest, BackendService>
      getRegionBackendServiceCallable;
  private final UnaryCallable<GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
      getHealthRegionBackendServiceCallable;
  private final UnaryCallable<InsertRegionBackendServiceHttpRequest, Operation>
      insertRegionBackendServiceCallable;
  private final UnaryCallable<ListRegionBackendServicesHttpRequest, BackendServiceList>
      listRegionBackendServicesCallable;
  private final UnaryCallable<
          ListRegionBackendServicesHttpRequest, ListRegionBackendServicesPagedResponse>
      listRegionBackendServicesPagedCallable;
  private final UnaryCallable<PatchRegionBackendServiceHttpRequest, Operation>
      patchRegionBackendServiceCallable;
  private final UnaryCallable<UpdateRegionBackendServiceHttpRequest, Operation>
      updateRegionBackendServiceCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionBackendServiceStub create(
      RegionBackendServiceStubSettings settings) throws IOException {
    return new HttpJsonRegionBackendServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionBackendServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionBackendServiceStub(
        RegionBackendServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionBackendServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionBackendServiceStub(
        RegionBackendServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionBackendServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionBackendServiceStub(
      RegionBackendServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionBackendServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionBackendServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionBackendServiceStub(
      RegionBackendServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionBackendServiceHttpRequest, Operation>
        deleteRegionBackendServiceTransportSettings =
            HttpJsonCallSettings.<DeleteRegionBackendServiceHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionBackendServiceMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionBackendServiceHttpRequest, BackendService>
        getRegionBackendServiceTransportSettings =
            HttpJsonCallSettings.<GetRegionBackendServiceHttpRequest, BackendService>newBuilder()
                .setMethodDescriptor(getRegionBackendServiceMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
        getHealthRegionBackendServiceTransportSettings =
            HttpJsonCallSettings
                .<GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>newBuilder()
                .setMethodDescriptor(getHealthRegionBackendServiceMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionBackendServiceHttpRequest, Operation>
        insertRegionBackendServiceTransportSettings =
            HttpJsonCallSettings.<InsertRegionBackendServiceHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionBackendServiceMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionBackendServicesHttpRequest, BackendServiceList>
        listRegionBackendServicesTransportSettings =
            HttpJsonCallSettings
                .<ListRegionBackendServicesHttpRequest, BackendServiceList>newBuilder()
                .setMethodDescriptor(listRegionBackendServicesMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchRegionBackendServiceHttpRequest, Operation>
        patchRegionBackendServiceTransportSettings =
            HttpJsonCallSettings.<PatchRegionBackendServiceHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRegionBackendServiceMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateRegionBackendServiceHttpRequest, Operation>
        updateRegionBackendServiceTransportSettings =
            HttpJsonCallSettings.<UpdateRegionBackendServiceHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(updateRegionBackendServiceMethodDescriptor)
                .build();

    this.deleteRegionBackendServiceCallable =
        callableFactory.createUnaryCallable(
            deleteRegionBackendServiceTransportSettings,
            settings.deleteRegionBackendServiceSettings(),
            clientContext);
    this.getRegionBackendServiceCallable =
        callableFactory.createUnaryCallable(
            getRegionBackendServiceTransportSettings,
            settings.getRegionBackendServiceSettings(),
            clientContext);
    this.getHealthRegionBackendServiceCallable =
        callableFactory.createUnaryCallable(
            getHealthRegionBackendServiceTransportSettings,
            settings.getHealthRegionBackendServiceSettings(),
            clientContext);
    this.insertRegionBackendServiceCallable =
        callableFactory.createUnaryCallable(
            insertRegionBackendServiceTransportSettings,
            settings.insertRegionBackendServiceSettings(),
            clientContext);
    this.listRegionBackendServicesCallable =
        callableFactory.createUnaryCallable(
            listRegionBackendServicesTransportSettings,
            settings.listRegionBackendServicesSettings(),
            clientContext);
    this.listRegionBackendServicesPagedCallable =
        callableFactory.createPagedCallable(
            listRegionBackendServicesTransportSettings,
            settings.listRegionBackendServicesSettings(),
            clientContext);
    this.patchRegionBackendServiceCallable =
        callableFactory.createUnaryCallable(
            patchRegionBackendServiceTransportSettings,
            settings.patchRegionBackendServiceSettings(),
            clientContext);
    this.updateRegionBackendServiceCallable =
        callableFactory.createUnaryCallable(
            updateRegionBackendServiceTransportSettings,
            settings.updateRegionBackendServiceSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionBackendServiceHttpRequest, Operation>
      deleteRegionBackendServiceCallable() {
    return deleteRegionBackendServiceCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionBackendServiceHttpRequest, BackendService>
      getRegionBackendServiceCallable() {
    return getRegionBackendServiceCallable;
  }

  @BetaApi
  public UnaryCallable<GetHealthRegionBackendServiceHttpRequest, BackendServiceGroupHealth>
      getHealthRegionBackendServiceCallable() {
    return getHealthRegionBackendServiceCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionBackendServiceHttpRequest, Operation>
      insertRegionBackendServiceCallable() {
    return insertRegionBackendServiceCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionBackendServicesHttpRequest, ListRegionBackendServicesPagedResponse>
      listRegionBackendServicesPagedCallable() {
    return listRegionBackendServicesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionBackendServicesHttpRequest, BackendServiceList>
      listRegionBackendServicesCallable() {
    return listRegionBackendServicesCallable;
  }

  @BetaApi
  public UnaryCallable<PatchRegionBackendServiceHttpRequest, Operation>
      patchRegionBackendServiceCallable() {
    return patchRegionBackendServiceCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateRegionBackendServiceHttpRequest, Operation>
      updateRegionBackendServiceCallable() {
    return updateRegionBackendServiceCallable;
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
