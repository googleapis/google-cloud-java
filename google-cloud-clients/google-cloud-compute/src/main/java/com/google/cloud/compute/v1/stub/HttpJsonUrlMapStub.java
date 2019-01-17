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

import static com.google.cloud.compute.v1.UrlMapClient.ListUrlMapsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteUrlMapHttpRequest;
import com.google.cloud.compute.v1.GetUrlMapHttpRequest;
import com.google.cloud.compute.v1.InsertUrlMapHttpRequest;
import com.google.cloud.compute.v1.InvalidateCacheUrlMapHttpRequest;
import com.google.cloud.compute.v1.ListUrlMapsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchUrlMapHttpRequest;
import com.google.cloud.compute.v1.ProjectGlobalUrlMapName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.UpdateUrlMapHttpRequest;
import com.google.cloud.compute.v1.UrlMap;
import com.google.cloud.compute.v1.UrlMapList;
import com.google.cloud.compute.v1.UrlMapsValidateResponse;
import com.google.cloud.compute.v1.ValidateUrlMapHttpRequest;
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
public class HttpJsonUrlMapStub extends UrlMapStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteUrlMapHttpRequest, Operation>
      deleteUrlMapMethodDescriptor =
          ApiMethodDescriptor.<DeleteUrlMapHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.urlMaps.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/urlMaps/{urlMap}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetUrlMapHttpRequest, UrlMap> getUrlMapMethodDescriptor =
      ApiMethodDescriptor.<GetUrlMapHttpRequest, UrlMap>newBuilder()
          .setFullMethodName("compute.urlMaps.get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<GetUrlMapHttpRequest>newBuilder()
                  .setPathTemplate(PathTemplate.create("{project}/global/urlMaps/{urlMap}"))
                  .setQueryParams(Sets.<String>newHashSet())
                  .setResourceNameFactory(ProjectGlobalUrlMapName.newFactory())
                  .setResourceNameField("urlMap")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<UrlMap>newBuilder()
                  .setResponseInstance(UrlMap.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertUrlMapHttpRequest, Operation>
      insertUrlMapMethodDescriptor =
          ApiMethodDescriptor.<InsertUrlMapHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.urlMaps.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/urlMaps"))
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
  public static final ApiMethodDescriptor<InvalidateCacheUrlMapHttpRequest, Operation>
      invalidateCacheUrlMapMethodDescriptor =
          ApiMethodDescriptor.<InvalidateCacheUrlMapHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.urlMaps.invalidateCache")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InvalidateCacheUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/urlMaps/{urlMap}/invalidateCache"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListUrlMapsHttpRequest, UrlMapList>
      listUrlMapsMethodDescriptor =
          ApiMethodDescriptor.<ListUrlMapsHttpRequest, UrlMapList>newBuilder()
              .setFullMethodName("compute.urlMaps.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListUrlMapsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/urlMaps"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<UrlMapList>newBuilder()
                      .setResponseInstance(UrlMapList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchUrlMapHttpRequest, Operation>
      patchUrlMapMethodDescriptor =
          ApiMethodDescriptor.<PatchUrlMapHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.urlMaps.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/urlMaps/{urlMap}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateUrlMapHttpRequest, Operation>
      updateUrlMapMethodDescriptor =
          ApiMethodDescriptor.<UpdateUrlMapHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.urlMaps.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/urlMaps/{urlMap}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
      validateUrlMapMethodDescriptor =
          ApiMethodDescriptor.<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>newBuilder()
              .setFullMethodName("compute.urlMaps.validate")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ValidateUrlMapHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/urlMaps/{urlMap}/validate"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalUrlMapName.newFactory())
                      .setResourceNameField("urlMap")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<UrlMapsValidateResponse>newBuilder()
                      .setResponseInstance(UrlMapsValidateResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteUrlMapHttpRequest, Operation> deleteUrlMapCallable;
  private final UnaryCallable<GetUrlMapHttpRequest, UrlMap> getUrlMapCallable;
  private final UnaryCallable<InsertUrlMapHttpRequest, Operation> insertUrlMapCallable;
  private final UnaryCallable<InvalidateCacheUrlMapHttpRequest, Operation>
      invalidateCacheUrlMapCallable;
  private final UnaryCallable<ListUrlMapsHttpRequest, UrlMapList> listUrlMapsCallable;
  private final UnaryCallable<ListUrlMapsHttpRequest, ListUrlMapsPagedResponse>
      listUrlMapsPagedCallable;
  private final UnaryCallable<PatchUrlMapHttpRequest, Operation> patchUrlMapCallable;
  private final UnaryCallable<UpdateUrlMapHttpRequest, Operation> updateUrlMapCallable;
  private final UnaryCallable<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
      validateUrlMapCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonUrlMapStub create(UrlMapStubSettings settings) throws IOException {
    return new HttpJsonUrlMapStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonUrlMapStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonUrlMapStub(UrlMapStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonUrlMapStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonUrlMapStub(
        UrlMapStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonUrlMapStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUrlMapStub(UrlMapStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonUrlMapCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonUrlMapStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonUrlMapStub(
      UrlMapStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteUrlMapHttpRequest, Operation> deleteUrlMapTransportSettings =
        HttpJsonCallSettings.<DeleteUrlMapHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteUrlMapMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetUrlMapHttpRequest, UrlMap> getUrlMapTransportSettings =
        HttpJsonCallSettings.<GetUrlMapHttpRequest, UrlMap>newBuilder()
            .setMethodDescriptor(getUrlMapMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertUrlMapHttpRequest, Operation> insertUrlMapTransportSettings =
        HttpJsonCallSettings.<InsertUrlMapHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertUrlMapMethodDescriptor)
            .build();
    HttpJsonCallSettings<InvalidateCacheUrlMapHttpRequest, Operation>
        invalidateCacheUrlMapTransportSettings =
            HttpJsonCallSettings.<InvalidateCacheUrlMapHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(invalidateCacheUrlMapMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListUrlMapsHttpRequest, UrlMapList> listUrlMapsTransportSettings =
        HttpJsonCallSettings.<ListUrlMapsHttpRequest, UrlMapList>newBuilder()
            .setMethodDescriptor(listUrlMapsMethodDescriptor)
            .build();
    HttpJsonCallSettings<PatchUrlMapHttpRequest, Operation> patchUrlMapTransportSettings =
        HttpJsonCallSettings.<PatchUrlMapHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(patchUrlMapMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateUrlMapHttpRequest, Operation> updateUrlMapTransportSettings =
        HttpJsonCallSettings.<UpdateUrlMapHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(updateUrlMapMethodDescriptor)
            .build();
    HttpJsonCallSettings<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
        validateUrlMapTransportSettings =
            HttpJsonCallSettings.<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>newBuilder()
                .setMethodDescriptor(validateUrlMapMethodDescriptor)
                .build();

    this.deleteUrlMapCallable =
        callableFactory.createUnaryCallable(
            deleteUrlMapTransportSettings, settings.deleteUrlMapSettings(), clientContext);
    this.getUrlMapCallable =
        callableFactory.createUnaryCallable(
            getUrlMapTransportSettings, settings.getUrlMapSettings(), clientContext);
    this.insertUrlMapCallable =
        callableFactory.createUnaryCallable(
            insertUrlMapTransportSettings, settings.insertUrlMapSettings(), clientContext);
    this.invalidateCacheUrlMapCallable =
        callableFactory.createUnaryCallable(
            invalidateCacheUrlMapTransportSettings,
            settings.invalidateCacheUrlMapSettings(),
            clientContext);
    this.listUrlMapsCallable =
        callableFactory.createUnaryCallable(
            listUrlMapsTransportSettings, settings.listUrlMapsSettings(), clientContext);
    this.listUrlMapsPagedCallable =
        callableFactory.createPagedCallable(
            listUrlMapsTransportSettings, settings.listUrlMapsSettings(), clientContext);
    this.patchUrlMapCallable =
        callableFactory.createUnaryCallable(
            patchUrlMapTransportSettings, settings.patchUrlMapSettings(), clientContext);
    this.updateUrlMapCallable =
        callableFactory.createUnaryCallable(
            updateUrlMapTransportSettings, settings.updateUrlMapSettings(), clientContext);
    this.validateUrlMapCallable =
        callableFactory.createUnaryCallable(
            validateUrlMapTransportSettings, settings.validateUrlMapSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteUrlMapHttpRequest, Operation> deleteUrlMapCallable() {
    return deleteUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<GetUrlMapHttpRequest, UrlMap> getUrlMapCallable() {
    return getUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<InsertUrlMapHttpRequest, Operation> insertUrlMapCallable() {
    return insertUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<InvalidateCacheUrlMapHttpRequest, Operation>
      invalidateCacheUrlMapCallable() {
    return invalidateCacheUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<ListUrlMapsHttpRequest, ListUrlMapsPagedResponse>
      listUrlMapsPagedCallable() {
    return listUrlMapsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListUrlMapsHttpRequest, UrlMapList> listUrlMapsCallable() {
    return listUrlMapsCallable;
  }

  @BetaApi
  public UnaryCallable<PatchUrlMapHttpRequest, Operation> patchUrlMapCallable() {
    return patchUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateUrlMapHttpRequest, Operation> updateUrlMapCallable() {
    return updateUrlMapCallable;
  }

  @BetaApi
  public UnaryCallable<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
      validateUrlMapCallable() {
    return validateUrlMapCallable;
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
