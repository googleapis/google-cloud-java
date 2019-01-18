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

import static com.google.cloud.compute.v1.RegionCommitmentClient.AggregatedListRegionCommitmentsPagedResponse;
import static com.google.cloud.compute.v1.RegionCommitmentClient.ListRegionCommitmentsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListRegionCommitmentsHttpRequest;
import com.google.cloud.compute.v1.Commitment;
import com.google.cloud.compute.v1.CommitmentAggregatedList;
import com.google.cloud.compute.v1.CommitmentList;
import com.google.cloud.compute.v1.GetRegionCommitmentHttpRequest;
import com.google.cloud.compute.v1.InsertRegionCommitmentHttpRequest;
import com.google.cloud.compute.v1.ListRegionCommitmentsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionCommitmentName;
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
public class HttpJsonRegionCommitmentStub extends RegionCommitmentStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListRegionCommitmentsHttpRequest, CommitmentAggregatedList>
      aggregatedListRegionCommitmentsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListRegionCommitmentsHttpRequest, CommitmentAggregatedList>newBuilder()
              .setFullMethodName("compute.regionCommitments.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListRegionCommitmentsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/commitments"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<CommitmentAggregatedList>newBuilder()
                      .setResponseInstance(CommitmentAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionCommitmentHttpRequest, Commitment>
      getRegionCommitmentMethodDescriptor =
          ApiMethodDescriptor.<GetRegionCommitmentHttpRequest, Commitment>newBuilder()
              .setFullMethodName("compute.regionCommitments.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionCommitmentHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/commitments/{commitment}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionCommitmentName.newFactory())
                      .setResourceNameField("commitment")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Commitment>newBuilder()
                      .setResponseInstance(Commitment.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionCommitmentHttpRequest, Operation>
      insertRegionCommitmentMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionCommitmentHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionCommitments.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertRegionCommitmentHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/commitments"))
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
  public static final ApiMethodDescriptor<ListRegionCommitmentsHttpRequest, CommitmentList>
      listRegionCommitmentsMethodDescriptor =
          ApiMethodDescriptor.<ListRegionCommitmentsHttpRequest, CommitmentList>newBuilder()
              .setFullMethodName("compute.regionCommitments.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionCommitmentsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/commitments"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<CommitmentList>newBuilder()
                      .setResponseInstance(CommitmentList.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListRegionCommitmentsHttpRequest, CommitmentAggregatedList>
      aggregatedListRegionCommitmentsCallable;
  private final UnaryCallable<
          AggregatedListRegionCommitmentsHttpRequest, AggregatedListRegionCommitmentsPagedResponse>
      aggregatedListRegionCommitmentsPagedCallable;
  private final UnaryCallable<GetRegionCommitmentHttpRequest, Commitment>
      getRegionCommitmentCallable;
  private final UnaryCallable<InsertRegionCommitmentHttpRequest, Operation>
      insertRegionCommitmentCallable;
  private final UnaryCallable<ListRegionCommitmentsHttpRequest, CommitmentList>
      listRegionCommitmentsCallable;
  private final UnaryCallable<ListRegionCommitmentsHttpRequest, ListRegionCommitmentsPagedResponse>
      listRegionCommitmentsPagedCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionCommitmentStub create(RegionCommitmentStubSettings settings)
      throws IOException {
    return new HttpJsonRegionCommitmentStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionCommitmentStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionCommitmentStub(
        RegionCommitmentStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionCommitmentStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionCommitmentStub(
        RegionCommitmentStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionCommitmentStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionCommitmentStub(
      RegionCommitmentStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonRegionCommitmentCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionCommitmentStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonRegionCommitmentStub(
      RegionCommitmentStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListRegionCommitmentsHttpRequest, CommitmentAggregatedList>
        aggregatedListRegionCommitmentsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListRegionCommitmentsHttpRequest, CommitmentAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListRegionCommitmentsMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetRegionCommitmentHttpRequest, Commitment>
        getRegionCommitmentTransportSettings =
            HttpJsonCallSettings.<GetRegionCommitmentHttpRequest, Commitment>newBuilder()
                .setMethodDescriptor(getRegionCommitmentMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertRegionCommitmentHttpRequest, Operation>
        insertRegionCommitmentTransportSettings =
            HttpJsonCallSettings.<InsertRegionCommitmentHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertRegionCommitmentMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListRegionCommitmentsHttpRequest, CommitmentList>
        listRegionCommitmentsTransportSettings =
            HttpJsonCallSettings.<ListRegionCommitmentsHttpRequest, CommitmentList>newBuilder()
                .setMethodDescriptor(listRegionCommitmentsMethodDescriptor)
                .build();

    this.aggregatedListRegionCommitmentsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListRegionCommitmentsTransportSettings,
            settings.aggregatedListRegionCommitmentsSettings(),
            clientContext);
    this.aggregatedListRegionCommitmentsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListRegionCommitmentsTransportSettings,
            settings.aggregatedListRegionCommitmentsSettings(),
            clientContext);
    this.getRegionCommitmentCallable =
        callableFactory.createUnaryCallable(
            getRegionCommitmentTransportSettings,
            settings.getRegionCommitmentSettings(),
            clientContext);
    this.insertRegionCommitmentCallable =
        callableFactory.createUnaryCallable(
            insertRegionCommitmentTransportSettings,
            settings.insertRegionCommitmentSettings(),
            clientContext);
    this.listRegionCommitmentsCallable =
        callableFactory.createUnaryCallable(
            listRegionCommitmentsTransportSettings,
            settings.listRegionCommitmentsSettings(),
            clientContext);
    this.listRegionCommitmentsPagedCallable =
        callableFactory.createPagedCallable(
            listRegionCommitmentsTransportSettings,
            settings.listRegionCommitmentsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListRegionCommitmentsHttpRequest, AggregatedListRegionCommitmentsPagedResponse>
      aggregatedListRegionCommitmentsPagedCallable() {
    return aggregatedListRegionCommitmentsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListRegionCommitmentsHttpRequest, CommitmentAggregatedList>
      aggregatedListRegionCommitmentsCallable() {
    return aggregatedListRegionCommitmentsCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionCommitmentHttpRequest, Commitment> getRegionCommitmentCallable() {
    return getRegionCommitmentCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionCommitmentHttpRequest, Operation>
      insertRegionCommitmentCallable() {
    return insertRegionCommitmentCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionCommitmentsHttpRequest, ListRegionCommitmentsPagedResponse>
      listRegionCommitmentsPagedCallable() {
    return listRegionCommitmentsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionCommitmentsHttpRequest, CommitmentList>
      listRegionCommitmentsCallable() {
    return listRegionCommitmentsCallable;
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
