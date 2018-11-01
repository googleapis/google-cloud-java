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

import static com.google.cloud.compute.v1.AcceleratorTypeClient.AggregatedListAcceleratorTypesPagedResponse;
import static com.google.cloud.compute.v1.AcceleratorTypeClient.ListAcceleratorTypesPagedResponse;

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
import com.google.cloud.compute.v1.AcceleratorType;
import com.google.cloud.compute.v1.AcceleratorTypeAggregatedList;
import com.google.cloud.compute.v1.AcceleratorTypeList;
import com.google.cloud.compute.v1.AggregatedListAcceleratorTypesHttpRequest;
import com.google.cloud.compute.v1.GetAcceleratorTypeHttpRequest;
import com.google.cloud.compute.v1.ListAcceleratorTypesHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneAcceleratorTypeName;
import com.google.cloud.compute.v1.ProjectZoneName;
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
public class HttpJsonAcceleratorTypeStub extends AcceleratorTypeStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListAcceleratorTypesHttpRequest, AcceleratorTypeAggregatedList>
      aggregatedListAcceleratorTypesMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListAcceleratorTypesHttpRequest, AcceleratorTypeAggregatedList>
                  newBuilder()
              .setFullMethodName("compute.acceleratorTypes.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListAcceleratorTypesHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/acceleratorTypes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<AcceleratorTypeAggregatedList>newBuilder()
                      .setResponseInstance(AcceleratorTypeAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetAcceleratorTypeHttpRequest, AcceleratorType>
      getAcceleratorTypeMethodDescriptor =
          ApiMethodDescriptor.<GetAcceleratorTypeHttpRequest, AcceleratorType>newBuilder()
              .setFullMethodName("compute.acceleratorTypes.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetAcceleratorTypeHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/zones/{zone}/acceleratorTypes/{acceleratorType}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneAcceleratorTypeName.newFactory())
                      .setResourceNameField("acceleratorType")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<AcceleratorType>newBuilder()
                      .setResponseInstance(AcceleratorType.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListAcceleratorTypesHttpRequest, AcceleratorTypeList>
      listAcceleratorTypesMethodDescriptor =
          ApiMethodDescriptor.<ListAcceleratorTypesHttpRequest, AcceleratorTypeList>newBuilder()
              .setFullMethodName("compute.acceleratorTypes.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListAcceleratorTypesHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/acceleratorTypes"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<AcceleratorTypeList>newBuilder()
                      .setResponseInstance(AcceleratorTypeList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListAcceleratorTypesHttpRequest, AcceleratorTypeAggregatedList>
      aggregatedListAcceleratorTypesCallable;
  private final UnaryCallable<
          AggregatedListAcceleratorTypesHttpRequest, AggregatedListAcceleratorTypesPagedResponse>
      aggregatedListAcceleratorTypesPagedCallable;
  private final UnaryCallable<GetAcceleratorTypeHttpRequest, AcceleratorType>
      getAcceleratorTypeCallable;
  private final UnaryCallable<ListAcceleratorTypesHttpRequest, AcceleratorTypeList>
      listAcceleratorTypesCallable;
  private final UnaryCallable<ListAcceleratorTypesHttpRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAcceleratorTypeStub create(AcceleratorTypeStubSettings settings)
      throws IOException {
    return new HttpJsonAcceleratorTypeStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAcceleratorTypeStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAcceleratorTypeStub(
        AcceleratorTypeStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAcceleratorTypeStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAcceleratorTypeStub(
        AcceleratorTypeStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAcceleratorTypeStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAcceleratorTypeStub(
      AcceleratorTypeStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonAcceleratorTypeCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAcceleratorTypeStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonAcceleratorTypeStub(
      AcceleratorTypeStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListAcceleratorTypesHttpRequest, AcceleratorTypeAggregatedList>
        aggregatedListAcceleratorTypesTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListAcceleratorTypesHttpRequest, AcceleratorTypeAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListAcceleratorTypesMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetAcceleratorTypeHttpRequest, AcceleratorType>
        getAcceleratorTypeTransportSettings =
            HttpJsonCallSettings.<GetAcceleratorTypeHttpRequest, AcceleratorType>newBuilder()
                .setMethodDescriptor(getAcceleratorTypeMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListAcceleratorTypesHttpRequest, AcceleratorTypeList>
        listAcceleratorTypesTransportSettings =
            HttpJsonCallSettings.<ListAcceleratorTypesHttpRequest, AcceleratorTypeList>newBuilder()
                .setMethodDescriptor(listAcceleratorTypesMethodDescriptor)
                .build();

    this.aggregatedListAcceleratorTypesCallable =
        callableFactory.createUnaryCallable(
            aggregatedListAcceleratorTypesTransportSettings,
            settings.aggregatedListAcceleratorTypesSettings(),
            clientContext);
    this.aggregatedListAcceleratorTypesPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListAcceleratorTypesTransportSettings,
            settings.aggregatedListAcceleratorTypesSettings(),
            clientContext);
    this.getAcceleratorTypeCallable =
        callableFactory.createUnaryCallable(
            getAcceleratorTypeTransportSettings,
            settings.getAcceleratorTypeSettings(),
            clientContext);
    this.listAcceleratorTypesCallable =
        callableFactory.createUnaryCallable(
            listAcceleratorTypesTransportSettings,
            settings.listAcceleratorTypesSettings(),
            clientContext);
    this.listAcceleratorTypesPagedCallable =
        callableFactory.createPagedCallable(
            listAcceleratorTypesTransportSettings,
            settings.listAcceleratorTypesSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListAcceleratorTypesHttpRequest, AggregatedListAcceleratorTypesPagedResponse>
      aggregatedListAcceleratorTypesPagedCallable() {
    return aggregatedListAcceleratorTypesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListAcceleratorTypesHttpRequest, AcceleratorTypeAggregatedList>
      aggregatedListAcceleratorTypesCallable() {
    return aggregatedListAcceleratorTypesCallable;
  }

  @BetaApi
  public UnaryCallable<GetAcceleratorTypeHttpRequest, AcceleratorType>
      getAcceleratorTypeCallable() {
    return getAcceleratorTypeCallable;
  }

  @BetaApi
  public UnaryCallable<ListAcceleratorTypesHttpRequest, ListAcceleratorTypesPagedResponse>
      listAcceleratorTypesPagedCallable() {
    return listAcceleratorTypesPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListAcceleratorTypesHttpRequest, AcceleratorTypeList>
      listAcceleratorTypesCallable() {
    return listAcceleratorTypesCallable;
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
