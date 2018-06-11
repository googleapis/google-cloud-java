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

import static com.google.cloud.compute.v1.RegionOperationClient.ListRegionOperationsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteRegionOperationHttpRequest;
import com.google.cloud.compute.v1.GetRegionOperationHttpRequest;
import com.google.cloud.compute.v1.ListRegionOperationsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationList;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionOperationName;
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
public class HttpJsonRegionOperationStub extends RegionOperationStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionOperationHttpRequest, Void>
      deleteRegionOperationMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionOperationHttpRequest, Void>newBuilder()
              .setFullMethodName("compute.regionOperations.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteRegionOperationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/operations/{operation}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionOperationName.newFactory())
                      .setResourceNameField("operation")
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionOperationHttpRequest, Operation>
      getRegionOperationMethodDescriptor =
          ApiMethodDescriptor.<GetRegionOperationHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionOperations.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionOperationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/operations/{operation}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionOperationName.newFactory())
                      .setResourceNameField("operation")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRegionOperationsHttpRequest, OperationList>
      listRegionOperationsMethodDescriptor =
          ApiMethodDescriptor.<ListRegionOperationsHttpRequest, OperationList>newBuilder()
              .setFullMethodName("compute.regionOperations.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionOperationsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/operations"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<OperationList>newBuilder()
                      .setResponseInstance(OperationList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteRegionOperationHttpRequest, Void> deleteRegionOperationCallable;
  private final UnaryCallable<GetRegionOperationHttpRequest, Operation> getRegionOperationCallable;
  private final UnaryCallable<ListRegionOperationsHttpRequest, OperationList>
      listRegionOperationsCallable;
  private final UnaryCallable<ListRegionOperationsHttpRequest, ListRegionOperationsPagedResponse>
      listRegionOperationsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionOperationStub create(RegionOperationStubSettings settings)
      throws IOException {
    return new HttpJsonRegionOperationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionOperationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionOperationStub(
        RegionOperationStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionOperationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionOperationStub(
        RegionOperationStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionOperationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionOperationStub(
      RegionOperationStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionOperationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionOperationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionOperationStub(
      RegionOperationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteRegionOperationHttpRequest, Void>
        deleteRegionOperationTransportSettings =
            HttpJsonCallSettings.<DeleteRegionOperationHttpRequest, Void>newBuilder()
                .setMethodDescriptor(deleteRegionOperationMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionOperationHttpRequest, Operation>
        getRegionOperationTransportSettings =
            HttpJsonCallSettings.<GetRegionOperationHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(getRegionOperationMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionOperationsHttpRequest, OperationList>
        listRegionOperationsTransportSettings =
            HttpJsonCallSettings.<ListRegionOperationsHttpRequest, OperationList>newBuilder()
                .setMethodDescriptor(listRegionOperationsMethodDescriptor)
                .build();

    this.deleteRegionOperationCallable =
        callableFactory.createUnaryCallable(
            deleteRegionOperationTransportSettings,
            settings.deleteRegionOperationSettings(),
            clientContext);
    this.getRegionOperationCallable =
        callableFactory.createUnaryCallable(
            getRegionOperationTransportSettings,
            settings.getRegionOperationSettings(),
            clientContext);
    this.listRegionOperationsCallable =
        callableFactory.createUnaryCallable(
            listRegionOperationsTransportSettings,
            settings.listRegionOperationsSettings(),
            clientContext);
    this.listRegionOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listRegionOperationsTransportSettings,
            settings.listRegionOperationsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteRegionOperationHttpRequest, Void> deleteRegionOperationCallable() {
    return deleteRegionOperationCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionOperationHttpRequest, Operation> getRegionOperationCallable() {
    return getRegionOperationCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionOperationsHttpRequest, ListRegionOperationsPagedResponse>
      listRegionOperationsPagedCallable() {
    return listRegionOperationsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionOperationsHttpRequest, OperationList>
      listRegionOperationsCallable() {
    return listRegionOperationsCallable;
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
