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

import static com.google.cloud.compute.v1.GlobalOperationClient.AggregatedListGlobalOperationsPagedResponse;
import static com.google.cloud.compute.v1.GlobalOperationClient.ListGlobalOperationsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListGlobalOperationsHttpRequest;
import com.google.cloud.compute.v1.DeleteGlobalOperationHttpRequest;
import com.google.cloud.compute.v1.GetGlobalOperationHttpRequest;
import com.google.cloud.compute.v1.ListGlobalOperationsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationAggregatedList;
import com.google.cloud.compute.v1.OperationList;
import com.google.cloud.compute.v1.ProjectGlobalOperationName;
import com.google.cloud.compute.v1.ProjectName;
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
public class HttpJsonGlobalOperationStub extends GlobalOperationStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListGlobalOperationsHttpRequest, OperationAggregatedList>
      aggregatedListGlobalOperationsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListGlobalOperationsHttpRequest, OperationAggregatedList>newBuilder()
              .setFullMethodName("compute.globalOperations.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListGlobalOperationsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/operations"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<OperationAggregatedList>newBuilder()
                      .setResponseInstance(OperationAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteGlobalOperationHttpRequest, Void>
      deleteGlobalOperationMethodDescriptor =
          ApiMethodDescriptor.<DeleteGlobalOperationHttpRequest, Void>newBuilder()
              .setFullMethodName("compute.globalOperations.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteGlobalOperationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/operations/{operation}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalOperationName.newFactory())
                      .setResourceNameField("operation")
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetGlobalOperationHttpRequest, Operation>
      getGlobalOperationMethodDescriptor =
          ApiMethodDescriptor.<GetGlobalOperationHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.globalOperations.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetGlobalOperationHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/operations/{operation}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalOperationName.newFactory())
                      .setResourceNameField("operation")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListGlobalOperationsHttpRequest, OperationList>
      listGlobalOperationsMethodDescriptor =
          ApiMethodDescriptor.<ListGlobalOperationsHttpRequest, OperationList>newBuilder()
              .setFullMethodName("compute.globalOperations.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListGlobalOperationsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/operations"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<OperationList>newBuilder()
                      .setResponseInstance(OperationList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListGlobalOperationsHttpRequest, OperationAggregatedList>
      aggregatedListGlobalOperationsCallable;
  private final UnaryCallable<
          AggregatedListGlobalOperationsHttpRequest, AggregatedListGlobalOperationsPagedResponse>
      aggregatedListGlobalOperationsPagedCallable;
  private final UnaryCallable<DeleteGlobalOperationHttpRequest, Void> deleteGlobalOperationCallable;
  private final UnaryCallable<GetGlobalOperationHttpRequest, Operation> getGlobalOperationCallable;
  private final UnaryCallable<ListGlobalOperationsHttpRequest, OperationList>
      listGlobalOperationsCallable;
  private final UnaryCallable<ListGlobalOperationsHttpRequest, ListGlobalOperationsPagedResponse>
      listGlobalOperationsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonGlobalOperationStub create(GlobalOperationStubSettings settings)
      throws IOException {
    return new HttpJsonGlobalOperationStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonGlobalOperationStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonGlobalOperationStub(
        GlobalOperationStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonGlobalOperationStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonGlobalOperationStub(
        GlobalOperationStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonGlobalOperationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalOperationStub(
      GlobalOperationStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonGlobalOperationCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonGlobalOperationStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonGlobalOperationStub(
      GlobalOperationStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListGlobalOperationsHttpRequest, OperationAggregatedList>
        aggregatedListGlobalOperationsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListGlobalOperationsHttpRequest, OperationAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListGlobalOperationsMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteGlobalOperationHttpRequest, Void>
        deleteGlobalOperationTransportSettings =
            HttpJsonCallSettings.<DeleteGlobalOperationHttpRequest, Void>newBuilder()
                .setMethodDescriptor(deleteGlobalOperationMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetGlobalOperationHttpRequest, Operation>
        getGlobalOperationTransportSettings =
            HttpJsonCallSettings.<GetGlobalOperationHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(getGlobalOperationMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListGlobalOperationsHttpRequest, OperationList>
        listGlobalOperationsTransportSettings =
            HttpJsonCallSettings.<ListGlobalOperationsHttpRequest, OperationList>newBuilder()
                .setMethodDescriptor(listGlobalOperationsMethodDescriptor)
                .build();

    this.aggregatedListGlobalOperationsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListGlobalOperationsTransportSettings,
            settings.aggregatedListGlobalOperationsSettings(),
            clientContext);
    this.aggregatedListGlobalOperationsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListGlobalOperationsTransportSettings,
            settings.aggregatedListGlobalOperationsSettings(),
            clientContext);
    this.deleteGlobalOperationCallable =
        callableFactory.createUnaryCallable(
            deleteGlobalOperationTransportSettings,
            settings.deleteGlobalOperationSettings(),
            clientContext);
    this.getGlobalOperationCallable =
        callableFactory.createUnaryCallable(
            getGlobalOperationTransportSettings,
            settings.getGlobalOperationSettings(),
            clientContext);
    this.listGlobalOperationsCallable =
        callableFactory.createUnaryCallable(
            listGlobalOperationsTransportSettings,
            settings.listGlobalOperationsSettings(),
            clientContext);
    this.listGlobalOperationsPagedCallable =
        callableFactory.createPagedCallable(
            listGlobalOperationsTransportSettings,
            settings.listGlobalOperationsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListGlobalOperationsHttpRequest, AggregatedListGlobalOperationsPagedResponse>
      aggregatedListGlobalOperationsPagedCallable() {
    return aggregatedListGlobalOperationsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListGlobalOperationsHttpRequest, OperationAggregatedList>
      aggregatedListGlobalOperationsCallable() {
    return aggregatedListGlobalOperationsCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteGlobalOperationHttpRequest, Void> deleteGlobalOperationCallable() {
    return deleteGlobalOperationCallable;
  }

  @BetaApi
  public UnaryCallable<GetGlobalOperationHttpRequest, Operation> getGlobalOperationCallable() {
    return getGlobalOperationCallable;
  }

  @BetaApi
  public UnaryCallable<ListGlobalOperationsHttpRequest, ListGlobalOperationsPagedResponse>
      listGlobalOperationsPagedCallable() {
    return listGlobalOperationsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListGlobalOperationsHttpRequest, OperationList>
      listGlobalOperationsCallable() {
    return listGlobalOperationsCallable;
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
