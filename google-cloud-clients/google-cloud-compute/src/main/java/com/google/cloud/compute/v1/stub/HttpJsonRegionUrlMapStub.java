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

import static com.google.cloud.compute.v1.RegionUrlMapClient.ListRegionUrlMapsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.GetRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.InsertRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.ListRegionUrlMapsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionUrlMapName;
import com.google.cloud.compute.v1.UpdateRegionUrlMapHttpRequest;
import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapList;
import com.google.cloud.compute.v1.UrlMapsValidateResponse;
import com.google.cloud.compute.v1.ValidateRegionUrlMapHttpRequest;
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
public class HttpJsonRegionUrlMapStub extends RegionUrlMapStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionUrlMapHttpRequest, Operation>
      deleteRegionUrlMapMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionUrlMapHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionUrlMaps.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteRegionUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/urlMaps/{urlMap}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionUrlMapHttpRequest, UrlMap>
      getRegionUrlMapMethodDescriptor =
          ApiMethodDescriptor.<GetRegionUrlMapHttpRequest, UrlMap>newBuilder()
              .setFullMethodName("compute.regionUrlMaps.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/urlMaps/{urlMap}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<UrlMap>newBuilder()
                      .setResponseInstance(UrlMap.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionUrlMapHttpRequest, Operation>
      insertRegionUrlMapMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionUrlMapHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionUrlMaps.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertRegionUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/urlMaps"))
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
  public static final ApiMethodDescriptor<ListRegionUrlMapsHttpRequest, UrlMapList>
      listRegionUrlMapsMethodDescriptor =
          ApiMethodDescriptor.<ListRegionUrlMapsHttpRequest, UrlMapList>newBuilder()
              .setFullMethodName("compute.regionUrlMaps.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionUrlMapsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/urlMaps"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<UrlMapList>newBuilder()
                      .setResponseInstance(UrlMapList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchRegionUrlMapHttpRequest, Operation>
      patchRegionUrlMapMethodDescriptor =
          ApiMethodDescriptor.<PatchRegionUrlMapHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionUrlMaps.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchRegionUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/urlMaps/{urlMap}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateRegionUrlMapHttpRequest, Operation>
      updateRegionUrlMapMethodDescriptor =
          ApiMethodDescriptor.<UpdateRegionUrlMapHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionUrlMaps.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateRegionUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/urlMaps/{urlMap}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
      validateRegionUrlMapMethodDescriptor =
          ApiMethodDescriptor.<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>newBuilder()
              .setFullMethodName("compute.regionUrlMaps.validate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ValidateRegionUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/urlMaps/{urlMap}/validate"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<UrlMapsValidateResponse>newBuilder()
                      .setResponseInstance(UrlMapsValidateResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionUrlMapHttpRequest, Operation> deleteRegionUrlMapCallable;
  private final UnaryCallable<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapCallable;
  private final UnaryCallable<InsertRegionUrlMapHttpRequest, Operation> insertRegionUrlMapCallable;
  private final UnaryCallable<ListRegionUrlMapsHttpRequest, UrlMapList> listRegionUrlMapsCallable;
  private final UnaryCallable<ListRegionUrlMapsHttpRequest, ListRegionUrlMapsPagedResponse>
      listRegionUrlMapsPagedCallable;
  private final UnaryCallable<PatchRegionUrlMapHttpRequest, Operation> patchRegionUrlMapCallable;
  private final UnaryCallable<UpdateRegionUrlMapHttpRequest, Operation> updateRegionUrlMapCallable;
  private final UnaryCallable<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
      validateRegionUrlMapCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionUrlMapStub create(RegionUrlMapStubSettings settings)
      throws IOException {
    return new HttpJsonRegionUrlMapStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionUrlMapStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionUrlMapStub(
        RegionUrlMapStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionUrlMapStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionUrlMapStub(
        RegionUrlMapStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionUrlMapStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionUrlMapStub(RegionUrlMapStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionUrlMapCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionUrlMapStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionUrlMapStub(
      RegionUrlMapStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionUrlMapHttpRequest, Operation>
        deleteRegionUrlMapTransportSettings =
            HttpJsonCallSettings.<DeleteRegionUrlMapHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteRegionUrlMapMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapTransportSettings =
        HttpJsonCallSettings.<GetRegionUrlMapHttpRequest, UrlMap>newBuilder()
            .setMethodDescriptor(getRegionUrlMapMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionUrlMapHttpRequest, Operation>
        insertRegionUrlMapTransportSettings =
            HttpJsonCallSettings.<InsertRegionUrlMapHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionUrlMapMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionUrlMapsHttpRequest, UrlMapList>
        listRegionUrlMapsTransportSettings =
            HttpJsonCallSettings.<ListRegionUrlMapsHttpRequest, UrlMapList>newBuilder()
                .setMethodDescriptor(listRegionUrlMapsMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchRegionUrlMapHttpRequest, Operation>
        patchRegionUrlMapTransportSettings =
            HttpJsonCallSettings.<PatchRegionUrlMapHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchRegionUrlMapMethodDescriptor)
                .build();
    HttpJsonCallSettings<UpdateRegionUrlMapHttpRequest, Operation>
        updateRegionUrlMapTransportSettings =
            HttpJsonCallSettings.<UpdateRegionUrlMapHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(updateRegionUrlMapMethodDescriptor)
                .build();
    HttpJsonCallSettings<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
        validateRegionUrlMapTransportSettings =
            HttpJsonCallSettings
                .<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>newBuilder()
                .setMethodDescriptor(validateRegionUrlMapMethodDescriptor)
                .build();

    this.deleteRegionUrlMapCallable =
        callableFactory.createUnaryCallable(
            deleteRegionUrlMapTransportSettings,
            settings.deleteRegionUrlMapSettings(),
            clientContext);
    this.getRegionUrlMapCallable =
        callableFactory.createUnaryCallable(
            getRegionUrlMapTransportSettings, settings.getRegionUrlMapSettings(), clientContext);
    this.insertRegionUrlMapCallable =
        callableFactory.createUnaryCallable(
            insertRegionUrlMapTransportSettings,
            settings.insertRegionUrlMapSettings(),
            clientContext);
    this.listRegionUrlMapsCallable =
        callableFactory.createUnaryCallable(
            listRegionUrlMapsTransportSettings,
            settings.listRegionUrlMapsSettings(),
            clientContext);
    this.listRegionUrlMapsPagedCallable =
        callableFactory.createPagedCallable(
            listRegionUrlMapsTransportSettings,
            settings.listRegionUrlMapsSettings(),
            clientContext);
    this.patchRegionUrlMapCallable =
        callableFactory.createUnaryCallable(
            patchRegionUrlMapTransportSettings,
            settings.patchRegionUrlMapSettings(),
            clientContext);
    this.updateRegionUrlMapCallable =
        callableFactory.createUnaryCallable(
            updateRegionUrlMapTransportSettings,
            settings.updateRegionUrlMapSettings(),
            clientContext);
    this.validateRegionUrlMapCallable =
        callableFactory.createUnaryCallable(
            validateRegionUrlMapTransportSettings,
            settings.validateRegionUrlMapSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionUrlMapHttpRequest, Operation> deleteRegionUrlMapCallable() {
    return deleteRegionUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionUrlMapHttpRequest, UrlMap> getRegionUrlMapCallable() {
    return getRegionUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionUrlMapHttpRequest, Operation> insertRegionUrlMapCallable() {
    return insertRegionUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionUrlMapsHttpRequest, ListRegionUrlMapsPagedResponse>
      listRegionUrlMapsPagedCallable() {
    return listRegionUrlMapsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionUrlMapsHttpRequest, UrlMapList> listRegionUrlMapsCallable() {
    return listRegionUrlMapsCallable;
  }

  @BetaApi
  public UnaryCallable<PatchRegionUrlMapHttpRequest, Operation> patchRegionUrlMapCallable() {
    return patchRegionUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateRegionUrlMapHttpRequest, Operation> updateRegionUrlMapCallable() {
    return updateRegionUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<ValidateRegionUrlMapHttpRequest, UrlMapsValidateResponse>
      validateRegionUrlMapCallable() {
    return validateRegionUrlMapCallable;
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
