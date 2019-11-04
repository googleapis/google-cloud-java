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

import static com.google.cloud.compute.v1.AutoscalerClient.AggregatedListAutoscalersPagedResponse;
import static com.google.cloud.compute.v1.AutoscalerClient.ListAutoscalersPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListAutoscalersHttpRequest;
import com.google.cloud.compute.v1.Autoscaler;
import com.google.cloud.compute.v1.AutoscalerAggregatedList;
import com.google.cloud.compute.v1.AutoscalerList;
import com.google.cloud.compute.v1.DeleteAutoscalerHttpRequest;
import com.google.cloud.compute.v1.GetAutoscalerHttpRequest;
import com.google.cloud.compute.v1.InsertAutoscalerHttpRequest;
import com.google.cloud.compute.v1.ListAutoscalersHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchAutoscalerHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneAutoscalerName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.UpdateAutoscalerHttpRequest;
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
public class HttpJsonAutoscalerStub extends AutoscalerStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListAutoscalersHttpRequest, AutoscalerAggregatedList>
      aggregatedListAutoscalersMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListAutoscalersHttpRequest, AutoscalerAggregatedList>newBuilder()
              .setFullMethodName("compute.autoscalers.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListAutoscalersHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/autoscalers"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<AutoscalerAggregatedList>newBuilder()
                      .setResponseInstance(AutoscalerAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteAutoscalerHttpRequest, Operation>
      deleteAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<DeleteAutoscalerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.autoscalers.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/autoscalers/{autoscaler}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneAutoscalerName.newFactory())
                      .setResourceNameField("autoscaler")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetAutoscalerHttpRequest, Autoscaler>
      getAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<GetAutoscalerHttpRequest, Autoscaler>newBuilder()
              .setFullMethodName("compute.autoscalers.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/autoscalers/{autoscaler}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectZoneAutoscalerName.newFactory())
                      .setResourceNameField("autoscaler")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Autoscaler>newBuilder()
                      .setResponseInstance(Autoscaler.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertAutoscalerHttpRequest, Operation>
      insertAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<InsertAutoscalerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.autoscalers.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/autoscalers"))
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
  public static final ApiMethodDescriptor<ListAutoscalersHttpRequest, AutoscalerList>
      listAutoscalersMethodDescriptor =
          ApiMethodDescriptor.<ListAutoscalersHttpRequest, AutoscalerList>newBuilder()
              .setFullMethodName("compute.autoscalers.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListAutoscalersHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/autoscalers"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<AutoscalerList>newBuilder()
                      .setResponseInstance(AutoscalerList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchAutoscalerHttpRequest, Operation>
      patchAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<PatchAutoscalerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.autoscalers.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/autoscalers"))
                      .setQueryParams(Sets.<String>newHashSet("autoscaler", "requestId"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<UpdateAutoscalerHttpRequest, Operation>
      updateAutoscalerMethodDescriptor =
          ApiMethodDescriptor.<UpdateAutoscalerHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.autoscalers.update")
              .setHttpMethod(HttpMethods.PUT)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<UpdateAutoscalerHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/autoscalers"))
                      .setQueryParams(Sets.<String>newHashSet("autoscaler", "requestId"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListAutoscalersHttpRequest, AutoscalerAggregatedList>
      aggregatedListAutoscalersCallable;
  private final UnaryCallable<
          AggregatedListAutoscalersHttpRequest, AggregatedListAutoscalersPagedResponse>
      aggregatedListAutoscalersPagedCallable;
  private final UnaryCallable<DeleteAutoscalerHttpRequest, Operation> deleteAutoscalerCallable;
  private final UnaryCallable<GetAutoscalerHttpRequest, Autoscaler> getAutoscalerCallable;
  private final UnaryCallable<InsertAutoscalerHttpRequest, Operation> insertAutoscalerCallable;
  private final UnaryCallable<ListAutoscalersHttpRequest, AutoscalerList> listAutoscalersCallable;
  private final UnaryCallable<ListAutoscalersHttpRequest, ListAutoscalersPagedResponse>
      listAutoscalersPagedCallable;
  private final UnaryCallable<PatchAutoscalerHttpRequest, Operation> patchAutoscalerCallable;
  private final UnaryCallable<UpdateAutoscalerHttpRequest, Operation> updateAutoscalerCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonAutoscalerStub create(AutoscalerStubSettings settings)
      throws IOException {
    return new HttpJsonAutoscalerStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonAutoscalerStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonAutoscalerStub(AutoscalerStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonAutoscalerStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonAutoscalerStub(
        AutoscalerStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonAutoscalerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAutoscalerStub(AutoscalerStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonAutoscalerCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonAutoscalerStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonAutoscalerStub(
      AutoscalerStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListAutoscalersHttpRequest, AutoscalerAggregatedList>
        aggregatedListAutoscalersTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListAutoscalersHttpRequest, AutoscalerAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListAutoscalersMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteAutoscalerHttpRequest, Operation> deleteAutoscalerTransportSettings =
        HttpJsonCallSettings.<DeleteAutoscalerHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteAutoscalerMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetAutoscalerHttpRequest, Autoscaler> getAutoscalerTransportSettings =
        HttpJsonCallSettings.<GetAutoscalerHttpRequest, Autoscaler>newBuilder()
            .setMethodDescriptor(getAutoscalerMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertAutoscalerHttpRequest, Operation> insertAutoscalerTransportSettings =
        HttpJsonCallSettings.<InsertAutoscalerHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertAutoscalerMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListAutoscalersHttpRequest, AutoscalerList>
        listAutoscalersTransportSettings =
            HttpJsonCallSettings.<ListAutoscalersHttpRequest, AutoscalerList>newBuilder()
                .setMethodDescriptor(listAutoscalersMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchAutoscalerHttpRequest, Operation> patchAutoscalerTransportSettings =
        HttpJsonCallSettings.<PatchAutoscalerHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(patchAutoscalerMethodDescriptor)
            .build();
    HttpJsonCallSettings<UpdateAutoscalerHttpRequest, Operation> updateAutoscalerTransportSettings =
        HttpJsonCallSettings.<UpdateAutoscalerHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(updateAutoscalerMethodDescriptor)
            .build();

    this.aggregatedListAutoscalersCallable =
        callableFactory.createUnaryCallable(
            aggregatedListAutoscalersTransportSettings,
            settings.aggregatedListAutoscalersSettings(),
            clientContext);
    this.aggregatedListAutoscalersPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListAutoscalersTransportSettings,
            settings.aggregatedListAutoscalersSettings(),
            clientContext);
    this.deleteAutoscalerCallable =
        callableFactory.createUnaryCallable(
            deleteAutoscalerTransportSettings, settings.deleteAutoscalerSettings(), clientContext);
    this.getAutoscalerCallable =
        callableFactory.createUnaryCallable(
            getAutoscalerTransportSettings, settings.getAutoscalerSettings(), clientContext);
    this.insertAutoscalerCallable =
        callableFactory.createUnaryCallable(
            insertAutoscalerTransportSettings, settings.insertAutoscalerSettings(), clientContext);
    this.listAutoscalersCallable =
        callableFactory.createUnaryCallable(
            listAutoscalersTransportSettings, settings.listAutoscalersSettings(), clientContext);
    this.listAutoscalersPagedCallable =
        callableFactory.createPagedCallable(
            listAutoscalersTransportSettings, settings.listAutoscalersSettings(), clientContext);
    this.patchAutoscalerCallable =
        callableFactory.createUnaryCallable(
            patchAutoscalerTransportSettings, settings.patchAutoscalerSettings(), clientContext);
    this.updateAutoscalerCallable =
        callableFactory.createUnaryCallable(
            updateAutoscalerTransportSettings, settings.updateAutoscalerSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AggregatedListAutoscalersHttpRequest, AggregatedListAutoscalersPagedResponse>
      aggregatedListAutoscalersPagedCallable() {
    return aggregatedListAutoscalersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListAutoscalersHttpRequest, AutoscalerAggregatedList>
      aggregatedListAutoscalersCallable() {
    return aggregatedListAutoscalersCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteAutoscalerHttpRequest, Operation> deleteAutoscalerCallable() {
    return deleteAutoscalerCallable;
  }

  @BetaApi
  public UnaryCallable<GetAutoscalerHttpRequest, Autoscaler> getAutoscalerCallable() {
    return getAutoscalerCallable;
  }

  @BetaApi
  public UnaryCallable<InsertAutoscalerHttpRequest, Operation> insertAutoscalerCallable() {
    return insertAutoscalerCallable;
  }

  @BetaApi
  public UnaryCallable<ListAutoscalersHttpRequest, ListAutoscalersPagedResponse>
      listAutoscalersPagedCallable() {
    return listAutoscalersPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListAutoscalersHttpRequest, AutoscalerList> listAutoscalersCallable() {
    return listAutoscalersCallable;
  }

  @BetaApi
  public UnaryCallable<PatchAutoscalerHttpRequest, Operation> patchAutoscalerCallable() {
    return patchAutoscalerCallable;
  }

  @BetaApi
  public UnaryCallable<UpdateAutoscalerHttpRequest, Operation> updateAutoscalerCallable() {
    return updateAutoscalerCallable;
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
