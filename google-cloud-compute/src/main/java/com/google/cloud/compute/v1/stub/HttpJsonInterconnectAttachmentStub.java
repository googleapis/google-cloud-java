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

import static com.google.cloud.compute.v1.InterconnectAttachmentClient.AggregatedListInterconnectAttachmentsPagedResponse;
import static com.google.cloud.compute.v1.InterconnectAttachmentClient.ListInterconnectAttachmentsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListInterconnectAttachmentsHttpRequest;
import com.google.cloud.compute.v1.DeleteInterconnectAttachmentHttpRequest;
import com.google.cloud.compute.v1.GetInterconnectAttachmentHttpRequest;
import com.google.cloud.compute.v1.InsertInterconnectAttachmentHttpRequest;
import com.google.cloud.compute.v1.InterconnectAttachment;
import com.google.cloud.compute.v1.InterconnectAttachmentAggregatedList;
import com.google.cloud.compute.v1.InterconnectAttachmentList;
import com.google.cloud.compute.v1.ListInterconnectAttachmentsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionInterconnectAttachmentName;
import com.google.cloud.compute.v1.ProjectRegionName;
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
public class HttpJsonInterconnectAttachmentStub extends InterconnectAttachmentStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListInterconnectAttachmentsHttpRequest, InterconnectAttachmentAggregatedList>
      aggregatedListInterconnectAttachmentsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListInterconnectAttachmentsHttpRequest,
                  InterconnectAttachmentAggregatedList>
                  newBuilder()
              .setFullMethodName("compute.interconnectAttachments.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListInterconnectAttachmentsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/aggregated/interconnectAttachments"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InterconnectAttachmentAggregatedList>newBuilder()
                      .setResponseInstance(
                          InterconnectAttachmentAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteInterconnectAttachmentHttpRequest, Operation>
      deleteInterconnectAttachmentMethodDescriptor =
          ApiMethodDescriptor.<DeleteInterconnectAttachmentHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.interconnectAttachments.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<DeleteInterconnectAttachmentHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/interconnectAttachments/{interconnectAttachment}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionInterconnectAttachmentName.newFactory())
                      .setResourceNameField("interconnectAttachment")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
      getInterconnectAttachmentMethodDescriptor =
          ApiMethodDescriptor
              .<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>newBuilder()
              .setFullMethodName("compute.interconnectAttachments.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetInterconnectAttachmentHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/interconnectAttachments/{interconnectAttachment}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionInterconnectAttachmentName.newFactory())
                      .setResourceNameField("interconnectAttachment")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InterconnectAttachment>newBuilder()
                      .setResponseInstance(InterconnectAttachment.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertInterconnectAttachmentHttpRequest, Operation>
      insertInterconnectAttachmentMethodDescriptor =
          ApiMethodDescriptor.<InsertInterconnectAttachmentHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.interconnectAttachments.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<InsertInterconnectAttachmentHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/interconnectAttachments"))
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
  public static final ApiMethodDescriptor<
          ListInterconnectAttachmentsHttpRequest, InterconnectAttachmentList>
      listInterconnectAttachmentsMethodDescriptor =
          ApiMethodDescriptor
              .<ListInterconnectAttachmentsHttpRequest, InterconnectAttachmentList>newBuilder()
              .setFullMethodName("compute.interconnectAttachments.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<ListInterconnectAttachmentsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/interconnectAttachments"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<InterconnectAttachmentList>newBuilder()
                      .setResponseInstance(InterconnectAttachmentList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListInterconnectAttachmentsHttpRequest, InterconnectAttachmentAggregatedList>
      aggregatedListInterconnectAttachmentsCallable;
  private final UnaryCallable<
          AggregatedListInterconnectAttachmentsHttpRequest,
          AggregatedListInterconnectAttachmentsPagedResponse>
      aggregatedListInterconnectAttachmentsPagedCallable;
  private final UnaryCallable<DeleteInterconnectAttachmentHttpRequest, Operation>
      deleteInterconnectAttachmentCallable;
  private final UnaryCallable<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
      getInterconnectAttachmentCallable;
  private final UnaryCallable<InsertInterconnectAttachmentHttpRequest, Operation>
      insertInterconnectAttachmentCallable;
  private final UnaryCallable<ListInterconnectAttachmentsHttpRequest, InterconnectAttachmentList>
      listInterconnectAttachmentsCallable;
  private final UnaryCallable<
          ListInterconnectAttachmentsHttpRequest, ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonInterconnectAttachmentStub create(
      InterconnectAttachmentStubSettings settings) throws IOException {
    return new HttpJsonInterconnectAttachmentStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonInterconnectAttachmentStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonInterconnectAttachmentStub(
        InterconnectAttachmentStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonInterconnectAttachmentStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonInterconnectAttachmentStub(
        InterconnectAttachmentStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonInterconnectAttachmentStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInterconnectAttachmentStub(
      InterconnectAttachmentStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonInterconnectAttachmentCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonInterconnectAttachmentStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonInterconnectAttachmentStub(
      InterconnectAttachmentStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            AggregatedListInterconnectAttachmentsHttpRequest, InterconnectAttachmentAggregatedList>
        aggregatedListInterconnectAttachmentsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListInterconnectAttachmentsHttpRequest,
                    InterconnectAttachmentAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListInterconnectAttachmentsMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteInterconnectAttachmentHttpRequest, Operation>
        deleteInterconnectAttachmentTransportSettings =
            HttpJsonCallSettings.<DeleteInterconnectAttachmentHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteInterconnectAttachmentMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
        getInterconnectAttachmentTransportSettings =
            HttpJsonCallSettings
                .<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>newBuilder()
                .setMethodDescriptor(getInterconnectAttachmentMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertInterconnectAttachmentHttpRequest, Operation>
        insertInterconnectAttachmentTransportSettings =
            HttpJsonCallSettings.<InsertInterconnectAttachmentHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertInterconnectAttachmentMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListInterconnectAttachmentsHttpRequest, InterconnectAttachmentList>
        listInterconnectAttachmentsTransportSettings =
            HttpJsonCallSettings
                .<ListInterconnectAttachmentsHttpRequest, InterconnectAttachmentList>newBuilder()
                .setMethodDescriptor(listInterconnectAttachmentsMethodDescriptor)
                .build();

    this.aggregatedListInterconnectAttachmentsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListInterconnectAttachmentsTransportSettings,
            settings.aggregatedListInterconnectAttachmentsSettings(),
            clientContext);
    this.aggregatedListInterconnectAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListInterconnectAttachmentsTransportSettings,
            settings.aggregatedListInterconnectAttachmentsSettings(),
            clientContext);
    this.deleteInterconnectAttachmentCallable =
        callableFactory.createUnaryCallable(
            deleteInterconnectAttachmentTransportSettings,
            settings.deleteInterconnectAttachmentSettings(),
            clientContext);
    this.getInterconnectAttachmentCallable =
        callableFactory.createUnaryCallable(
            getInterconnectAttachmentTransportSettings,
            settings.getInterconnectAttachmentSettings(),
            clientContext);
    this.insertInterconnectAttachmentCallable =
        callableFactory.createUnaryCallable(
            insertInterconnectAttachmentTransportSettings,
            settings.insertInterconnectAttachmentSettings(),
            clientContext);
    this.listInterconnectAttachmentsCallable =
        callableFactory.createUnaryCallable(
            listInterconnectAttachmentsTransportSettings,
            settings.listInterconnectAttachmentsSettings(),
            clientContext);
    this.listInterconnectAttachmentsPagedCallable =
        callableFactory.createPagedCallable(
            listInterconnectAttachmentsTransportSettings,
            settings.listInterconnectAttachmentsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListInterconnectAttachmentsHttpRequest,
          AggregatedListInterconnectAttachmentsPagedResponse>
      aggregatedListInterconnectAttachmentsPagedCallable() {
    return aggregatedListInterconnectAttachmentsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListInterconnectAttachmentsHttpRequest, InterconnectAttachmentAggregatedList>
      aggregatedListInterconnectAttachmentsCallable() {
    return aggregatedListInterconnectAttachmentsCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteInterconnectAttachmentHttpRequest, Operation>
      deleteInterconnectAttachmentCallable() {
    return deleteInterconnectAttachmentCallable;
  }

  @BetaApi
  public UnaryCallable<GetInterconnectAttachmentHttpRequest, InterconnectAttachment>
      getInterconnectAttachmentCallable() {
    return getInterconnectAttachmentCallable;
  }

  @BetaApi
  public UnaryCallable<InsertInterconnectAttachmentHttpRequest, Operation>
      insertInterconnectAttachmentCallable() {
    return insertInterconnectAttachmentCallable;
  }

  @BetaApi
  public UnaryCallable<
          ListInterconnectAttachmentsHttpRequest, ListInterconnectAttachmentsPagedResponse>
      listInterconnectAttachmentsPagedCallable() {
    return listInterconnectAttachmentsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListInterconnectAttachmentsHttpRequest, InterconnectAttachmentList>
      listInterconnectAttachmentsCallable() {
    return listInterconnectAttachmentsCallable;
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
