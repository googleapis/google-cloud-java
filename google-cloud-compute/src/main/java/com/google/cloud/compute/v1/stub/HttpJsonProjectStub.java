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
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.compute.v1.DiskMoveRequest;
import com.google.cloud.compute.v1.GetProjectHttpRequest;
import com.google.cloud.compute.v1.InstanceMoveRequest;
import com.google.cloud.compute.v1.Metadata;
import com.google.cloud.compute.v1.MoveDiskProjectHttpRequest;
import com.google.cloud.compute.v1.MoveInstanceProjectHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Project;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectSettings;
import com.google.cloud.compute.v1.SetCommonInstanceMetadataProjectHttpRequest;
import com.google.cloud.compute.v1.SetUsageExportBucketProjectHttpRequest;
import com.google.cloud.compute.v1.UsageExportLocation;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * HTTP stub implementation for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonProjectStub extends ProjectStub {
  @InternalApi
  public static final ApiMethodDescriptor<GetProjectHttpRequest, Project> getProjectMethodDescriptor =
      ApiMethodDescriptor.<GetProjectHttpRequest, Project>newBuilder()
          .setFullMethodName("compute.projects.get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<GetProjectHttpRequest>newBuilder()
                  .setRequestInstance(GetProjectHttpRequest.getDefaultInstance())
                  .setPathTemplate(PathTemplate.create("{project}"))
                  .setQueryParams(Sets.<String>newHashSet(
                                     ))
                  .setResourceNameFactory(ProjectName.newFactory())
                  .setResourceNameField("project")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Project>newBuilder()
                  .setResponseInstance(Project.getDefaultInstance())
                  .build())
          .build();
  @InternalApi
  public static final ApiMethodDescriptor<MoveDiskProjectHttpRequest, Operation> moveDiskProjectMethodDescriptor =
      ApiMethodDescriptor.<MoveDiskProjectHttpRequest, Operation>newBuilder()
          .setFullMethodName("compute.projects.moveDisk")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<MoveDiskProjectHttpRequest>newBuilder()
                  .setRequestInstance(MoveDiskProjectHttpRequest.getDefaultInstance())
                  .setPathTemplate(PathTemplate.create("{project}/moveDisk"))
                  .setQueryParams(Sets.<String>newHashSet(
                                     ))
                  .setResourceNameFactory(ProjectName.newFactory())
                  .setResourceNameField("project")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Operation>newBuilder()
                  .setResponseInstance(Operation.getDefaultInstance())
                  .build())
          .build();
  @InternalApi
  public static final ApiMethodDescriptor<MoveInstanceProjectHttpRequest, Operation> moveInstanceProjectMethodDescriptor =
      ApiMethodDescriptor.<MoveInstanceProjectHttpRequest, Operation>newBuilder()
          .setFullMethodName("compute.projects.moveInstance")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<MoveInstanceProjectHttpRequest>newBuilder()
                  .setRequestInstance(MoveInstanceProjectHttpRequest.getDefaultInstance())
                  .setPathTemplate(PathTemplate.create("{project}/moveInstance"))
                  .setQueryParams(Sets.<String>newHashSet(
                                     ))
                  .setResourceNameFactory(ProjectName.newFactory())
                  .setResourceNameField("project")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Operation>newBuilder()
                  .setResponseInstance(Operation.getDefaultInstance())
                  .build())
          .build();
  @InternalApi
  public static final ApiMethodDescriptor<SetCommonInstanceMetadataProjectHttpRequest, Operation> setCommonInstanceMetadataProjectMethodDescriptor =
      ApiMethodDescriptor.<SetCommonInstanceMetadataProjectHttpRequest, Operation>newBuilder()
          .setFullMethodName("compute.projects.setCommonInstanceMetadata")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<SetCommonInstanceMetadataProjectHttpRequest>newBuilder()
                  .setRequestInstance(SetCommonInstanceMetadataProjectHttpRequest.getDefaultInstance())
                  .setPathTemplate(PathTemplate.create("{project}/setCommonInstanceMetadata"))
                  .setQueryParams(Sets.<String>newHashSet(
                                     ))
                  .setResourceNameFactory(ProjectName.newFactory())
                  .setResourceNameField("project")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Operation>newBuilder()
                  .setResponseInstance(Operation.getDefaultInstance())
                  .build())
          .build();
  @InternalApi
  public static final ApiMethodDescriptor<SetUsageExportBucketProjectHttpRequest, Operation> setUsageExportBucketProjectMethodDescriptor =
      ApiMethodDescriptor.<SetUsageExportBucketProjectHttpRequest, Operation>newBuilder()
          .setFullMethodName("compute.projects.setUsageExportBucket")
          .setHttpMethod(HttpMethods.POST)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<SetUsageExportBucketProjectHttpRequest>newBuilder()
                  .setRequestInstance(SetUsageExportBucketProjectHttpRequest.getDefaultInstance())
                  .setPathTemplate(PathTemplate.create("{project}/setUsageExportBucket"))
                  .setQueryParams(Sets.<String>newHashSet(
                                     ))
                  .setResourceNameFactory(ProjectName.newFactory())
                  .setResourceNameField("project")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Operation>newBuilder()
                  .setResponseInstance(Operation.getDefaultInstance())
                  .build())
          .build();
  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetProjectHttpRequest, Project> getProjectCallable;
  private final UnaryCallable<MoveDiskProjectHttpRequest, Operation> moveDiskProjectCallable;
  private final UnaryCallable<MoveInstanceProjectHttpRequest, Operation> moveInstanceProjectCallable;
  private final UnaryCallable<SetCommonInstanceMetadataProjectHttpRequest, Operation> setCommonInstanceMetadataProjectCallable;
  private final UnaryCallable<SetUsageExportBucketProjectHttpRequest, Operation> setUsageExportBucketProjectCallable;

  private final HttpJsonStubCallableFactory callableFactory;
  public static final HttpJsonProjectStub create(ProjectStubSettings settings) throws IOException {
    return new HttpJsonProjectStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProjectStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonProjectStub(ProjectStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonProjectStub create(ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProjectStub(ProjectStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProjectStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonProjectStub(ProjectStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonProjectCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProjectStub, using the given settings.
   * This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected HttpJsonProjectStub(ProjectStubSettings settings, ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetProjectHttpRequest, Project> getProjectTransportSettings =
        HttpJsonCallSettings.<GetProjectHttpRequest, Project>newBuilder()
            .setMethodDescriptor(getProjectMethodDescriptor)
            .build();
    HttpJsonCallSettings<MoveDiskProjectHttpRequest, Operation> moveDiskProjectTransportSettings =
        HttpJsonCallSettings.<MoveDiskProjectHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(moveDiskProjectMethodDescriptor)
            .build();
    HttpJsonCallSettings<MoveInstanceProjectHttpRequest, Operation> moveInstanceProjectTransportSettings =
        HttpJsonCallSettings.<MoveInstanceProjectHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(moveInstanceProjectMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetCommonInstanceMetadataProjectHttpRequest, Operation> setCommonInstanceMetadataProjectTransportSettings =
        HttpJsonCallSettings.<SetCommonInstanceMetadataProjectHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(setCommonInstanceMetadataProjectMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetUsageExportBucketProjectHttpRequest, Operation> setUsageExportBucketProjectTransportSettings =
        HttpJsonCallSettings.<SetUsageExportBucketProjectHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(setUsageExportBucketProjectMethodDescriptor)
            .build();

    this.getProjectCallable = callableFactory.createUnaryCallable(getProjectTransportSettings,settings.getProjectSettings(), clientContext);
    this.moveDiskProjectCallable = callableFactory.createUnaryCallable(moveDiskProjectTransportSettings,settings.moveDiskProjectSettings(), clientContext);
    this.moveInstanceProjectCallable = callableFactory.createUnaryCallable(moveInstanceProjectTransportSettings,settings.moveInstanceProjectSettings(), clientContext);
    this.setCommonInstanceMetadataProjectCallable = callableFactory.createUnaryCallable(setCommonInstanceMetadataProjectTransportSettings,settings.setCommonInstanceMetadataProjectSettings(), clientContext);
    this.setUsageExportBucketProjectCallable = callableFactory.createUnaryCallable(setUsageExportBucketProjectTransportSettings,settings.setUsageExportBucketProjectSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<GetProjectHttpRequest, Project> getProjectCallable() {
    return getProjectCallable;
  }

  @BetaApi
  public UnaryCallable<MoveDiskProjectHttpRequest, Operation> moveDiskProjectCallable() {
    return moveDiskProjectCallable;
  }

  @BetaApi
  public UnaryCallable<MoveInstanceProjectHttpRequest, Operation> moveInstanceProjectCallable() {
    return moveInstanceProjectCallable;
  }

  @BetaApi
  public UnaryCallable<SetCommonInstanceMetadataProjectHttpRequest, Operation> setCommonInstanceMetadataProjectCallable() {
    return setCommonInstanceMetadataProjectCallable;
  }

  @BetaApi
  public UnaryCallable<SetUsageExportBucketProjectHttpRequest, Operation> setUsageExportBucketProjectCallable() {
    return setUsageExportBucketProjectCallable;
  }

  @Override
  public final void close() throws Exception {
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