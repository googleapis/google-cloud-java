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

import static com.google.cloud.compute.v1.ProjectClient.GetXpnResourcesProjectsPagedResponse;
import static com.google.cloud.compute.v1.ProjectClient.ListXpnHostsProjectsPagedResponse;

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
import com.google.cloud.compute.v1.DisableXpnHostProjectHttpRequest;
import com.google.cloud.compute.v1.DisableXpnResourceProjectHttpRequest;
import com.google.cloud.compute.v1.EnableXpnHostProjectHttpRequest;
import com.google.cloud.compute.v1.EnableXpnResourceProjectHttpRequest;
import com.google.cloud.compute.v1.GetProjectHttpRequest;
import com.google.cloud.compute.v1.GetXpnHostProjectHttpRequest;
import com.google.cloud.compute.v1.GetXpnResourcesProjectsHttpRequest;
import com.google.cloud.compute.v1.ListXpnHostsProjectsHttpRequest;
import com.google.cloud.compute.v1.MoveDiskProjectHttpRequest;
import com.google.cloud.compute.v1.MoveInstanceProjectHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Project;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectsGetXpnResources;
import com.google.cloud.compute.v1.SetCommonInstanceMetadataProjectHttpRequest;
import com.google.cloud.compute.v1.SetUsageExportBucketProjectHttpRequest;
import com.google.cloud.compute.v1.XpnHostList;
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
public class HttpJsonProjectStub extends ProjectStub {
  @InternalApi
  public static final ApiMethodDescriptor<DisableXpnHostProjectHttpRequest, Operation>
      disableXpnHostProjectMethodDescriptor =
          ApiMethodDescriptor.<DisableXpnHostProjectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.projects.disableXpnHost")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DisableXpnHostProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/disableXpnHost"))
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
  public static final ApiMethodDescriptor<DisableXpnResourceProjectHttpRequest, Operation>
      disableXpnResourceProjectMethodDescriptor =
          ApiMethodDescriptor.<DisableXpnResourceProjectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.projects.disableXpnResource")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DisableXpnResourceProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/disableXpnResource"))
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
  public static final ApiMethodDescriptor<EnableXpnHostProjectHttpRequest, Operation>
      enableXpnHostProjectMethodDescriptor =
          ApiMethodDescriptor.<EnableXpnHostProjectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.projects.enableXpnHost")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<EnableXpnHostProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/enableXpnHost"))
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
  public static final ApiMethodDescriptor<EnableXpnResourceProjectHttpRequest, Operation>
      enableXpnResourceProjectMethodDescriptor =
          ApiMethodDescriptor.<EnableXpnResourceProjectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.projects.enableXpnResource")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<EnableXpnResourceProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/enableXpnResource"))
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
  public static final ApiMethodDescriptor<GetProjectHttpRequest, Project>
      getProjectMethodDescriptor =
          ApiMethodDescriptor.<GetProjectHttpRequest, Project>newBuilder()
              .setFullMethodName("compute.projects.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Project>newBuilder()
                      .setResponseInstance(Project.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetXpnHostProjectHttpRequest, Project>
      getXpnHostProjectMethodDescriptor =
          ApiMethodDescriptor.<GetXpnHostProjectHttpRequest, Project>newBuilder()
              .setFullMethodName("compute.projects.getXpnHost")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetXpnHostProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/getXpnHost"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Project>newBuilder()
                      .setResponseInstance(Project.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources>
      getXpnResourcesProjectsMethodDescriptor =
          ApiMethodDescriptor
              .<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources>newBuilder()
              .setFullMethodName("compute.projects.getXpnResources")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetXpnResourcesProjectsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/getXpnResources"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "order_by", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<ProjectsGetXpnResources>newBuilder()
                      .setResponseInstance(ProjectsGetXpnResources.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListXpnHostsProjectsHttpRequest, XpnHostList>
      listXpnHostsProjectsMethodDescriptor =
          ApiMethodDescriptor.<ListXpnHostsProjectsHttpRequest, XpnHostList>newBuilder()
              .setFullMethodName("compute.projects.listXpnHosts")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListXpnHostsProjectsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/listXpnHosts"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "order_by", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<XpnHostList>newBuilder()
                      .setResponseInstance(XpnHostList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<MoveDiskProjectHttpRequest, Operation>
      moveDiskProjectMethodDescriptor =
          ApiMethodDescriptor.<MoveDiskProjectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.projects.moveDisk")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<MoveDiskProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/moveDisk"))
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
  public static final ApiMethodDescriptor<MoveInstanceProjectHttpRequest, Operation>
      moveInstanceProjectMethodDescriptor =
          ApiMethodDescriptor.<MoveInstanceProjectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.projects.moveInstance")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<MoveInstanceProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/moveInstance"))
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
  public static final ApiMethodDescriptor<SetCommonInstanceMetadataProjectHttpRequest, Operation>
      setCommonInstanceMetadataProjectMethodDescriptor =
          ApiMethodDescriptor.<SetCommonInstanceMetadataProjectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.projects.setCommonInstanceMetadata")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetCommonInstanceMetadataProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/setCommonInstanceMetadata"))
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
  public static final ApiMethodDescriptor<SetUsageExportBucketProjectHttpRequest, Operation>
      setUsageExportBucketProjectMethodDescriptor =
          ApiMethodDescriptor.<SetUsageExportBucketProjectHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.projects.setUsageExportBucket")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<SetUsageExportBucketProjectHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/setUsageExportBucket"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DisableXpnHostProjectHttpRequest, Operation>
      disableXpnHostProjectCallable;
  private final UnaryCallable<DisableXpnResourceProjectHttpRequest, Operation>
      disableXpnResourceProjectCallable;
  private final UnaryCallable<EnableXpnHostProjectHttpRequest, Operation>
      enableXpnHostProjectCallable;
  private final UnaryCallable<EnableXpnResourceProjectHttpRequest, Operation>
      enableXpnResourceProjectCallable;
  private final UnaryCallable<GetProjectHttpRequest, Project> getProjectCallable;
  private final UnaryCallable<GetXpnHostProjectHttpRequest, Project> getXpnHostProjectCallable;
  private final UnaryCallable<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources>
      getXpnResourcesProjectsCallable;
  private final UnaryCallable<
          GetXpnResourcesProjectsHttpRequest, GetXpnResourcesProjectsPagedResponse>
      getXpnResourcesProjectsPagedCallable;
  private final UnaryCallable<ListXpnHostsProjectsHttpRequest, XpnHostList>
      listXpnHostsProjectsCallable;
  private final UnaryCallable<ListXpnHostsProjectsHttpRequest, ListXpnHostsProjectsPagedResponse>
      listXpnHostsProjectsPagedCallable;
  private final UnaryCallable<MoveDiskProjectHttpRequest, Operation> moveDiskProjectCallable;
  private final UnaryCallable<MoveInstanceProjectHttpRequest, Operation>
      moveInstanceProjectCallable;
  private final UnaryCallable<SetCommonInstanceMetadataProjectHttpRequest, Operation>
      setCommonInstanceMetadataProjectCallable;
  private final UnaryCallable<SetUsageExportBucketProjectHttpRequest, Operation>
      setUsageExportBucketProjectCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonProjectStub create(ProjectStubSettings settings) throws IOException {
    return new HttpJsonProjectStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonProjectStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonProjectStub(ProjectStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonProjectStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonProjectStub(
        ProjectStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonProjectStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonProjectStub(ProjectStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonProjectCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonProjectStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonProjectStub(
      ProjectStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DisableXpnHostProjectHttpRequest, Operation>
        disableXpnHostProjectTransportSettings =
            HttpJsonCallSettings.<DisableXpnHostProjectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(disableXpnHostProjectMethodDescriptor)
                .build();
    HttpJsonCallSettings<DisableXpnResourceProjectHttpRequest, Operation>
        disableXpnResourceProjectTransportSettings =
            HttpJsonCallSettings.<DisableXpnResourceProjectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(disableXpnResourceProjectMethodDescriptor)
                .build();
    HttpJsonCallSettings<EnableXpnHostProjectHttpRequest, Operation>
        enableXpnHostProjectTransportSettings =
            HttpJsonCallSettings.<EnableXpnHostProjectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(enableXpnHostProjectMethodDescriptor)
                .build();
    HttpJsonCallSettings<EnableXpnResourceProjectHttpRequest, Operation>
        enableXpnResourceProjectTransportSettings =
            HttpJsonCallSettings.<EnableXpnResourceProjectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(enableXpnResourceProjectMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetProjectHttpRequest, Project> getProjectTransportSettings =
        HttpJsonCallSettings.<GetProjectHttpRequest, Project>newBuilder()
            .setMethodDescriptor(getProjectMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetXpnHostProjectHttpRequest, Project> getXpnHostProjectTransportSettings =
        HttpJsonCallSettings.<GetXpnHostProjectHttpRequest, Project>newBuilder()
            .setMethodDescriptor(getXpnHostProjectMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources>
        getXpnResourcesProjectsTransportSettings =
            HttpJsonCallSettings
                .<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources>newBuilder()
                .setMethodDescriptor(getXpnResourcesProjectsMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListXpnHostsProjectsHttpRequest, XpnHostList>
        listXpnHostsProjectsTransportSettings =
            HttpJsonCallSettings.<ListXpnHostsProjectsHttpRequest, XpnHostList>newBuilder()
                .setMethodDescriptor(listXpnHostsProjectsMethodDescriptor)
                .build();
    HttpJsonCallSettings<MoveDiskProjectHttpRequest, Operation> moveDiskProjectTransportSettings =
        HttpJsonCallSettings.<MoveDiskProjectHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(moveDiskProjectMethodDescriptor)
            .build();
    HttpJsonCallSettings<MoveInstanceProjectHttpRequest, Operation>
        moveInstanceProjectTransportSettings =
            HttpJsonCallSettings.<MoveInstanceProjectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(moveInstanceProjectMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetCommonInstanceMetadataProjectHttpRequest, Operation>
        setCommonInstanceMetadataProjectTransportSettings =
            HttpJsonCallSettings
                .<SetCommonInstanceMetadataProjectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setCommonInstanceMetadataProjectMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetUsageExportBucketProjectHttpRequest, Operation>
        setUsageExportBucketProjectTransportSettings =
            HttpJsonCallSettings.<SetUsageExportBucketProjectHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setUsageExportBucketProjectMethodDescriptor)
                .build();

    this.disableXpnHostProjectCallable =
        callableFactory.createUnaryCallable(
            disableXpnHostProjectTransportSettings,
            settings.disableXpnHostProjectSettings(),
            clientContext);
    this.disableXpnResourceProjectCallable =
        callableFactory.createUnaryCallable(
            disableXpnResourceProjectTransportSettings,
            settings.disableXpnResourceProjectSettings(),
            clientContext);
    this.enableXpnHostProjectCallable =
        callableFactory.createUnaryCallable(
            enableXpnHostProjectTransportSettings,
            settings.enableXpnHostProjectSettings(),
            clientContext);
    this.enableXpnResourceProjectCallable =
        callableFactory.createUnaryCallable(
            enableXpnResourceProjectTransportSettings,
            settings.enableXpnResourceProjectSettings(),
            clientContext);
    this.getProjectCallable =
        callableFactory.createUnaryCallable(
            getProjectTransportSettings, settings.getProjectSettings(), clientContext);
    this.getXpnHostProjectCallable =
        callableFactory.createUnaryCallable(
            getXpnHostProjectTransportSettings,
            settings.getXpnHostProjectSettings(),
            clientContext);
    this.getXpnResourcesProjectsCallable =
        callableFactory.createUnaryCallable(
            getXpnResourcesProjectsTransportSettings,
            settings.getXpnResourcesProjectsSettings(),
            clientContext);
    this.getXpnResourcesProjectsPagedCallable =
        callableFactory.createPagedCallable(
            getXpnResourcesProjectsTransportSettings,
            settings.getXpnResourcesProjectsSettings(),
            clientContext);
    this.listXpnHostsProjectsCallable =
        callableFactory.createUnaryCallable(
            listXpnHostsProjectsTransportSettings,
            settings.listXpnHostsProjectsSettings(),
            clientContext);
    this.listXpnHostsProjectsPagedCallable =
        callableFactory.createPagedCallable(
            listXpnHostsProjectsTransportSettings,
            settings.listXpnHostsProjectsSettings(),
            clientContext);
    this.moveDiskProjectCallable =
        callableFactory.createUnaryCallable(
            moveDiskProjectTransportSettings, settings.moveDiskProjectSettings(), clientContext);
    this.moveInstanceProjectCallable =
        callableFactory.createUnaryCallable(
            moveInstanceProjectTransportSettings,
            settings.moveInstanceProjectSettings(),
            clientContext);
    this.setCommonInstanceMetadataProjectCallable =
        callableFactory.createUnaryCallable(
            setCommonInstanceMetadataProjectTransportSettings,
            settings.setCommonInstanceMetadataProjectSettings(),
            clientContext);
    this.setUsageExportBucketProjectCallable =
        callableFactory.createUnaryCallable(
            setUsageExportBucketProjectTransportSettings,
            settings.setUsageExportBucketProjectSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DisableXpnHostProjectHttpRequest, Operation>
      disableXpnHostProjectCallable() {
    return disableXpnHostProjectCallable;
  }

  @BetaApi
  public UnaryCallable<DisableXpnResourceProjectHttpRequest, Operation>
      disableXpnResourceProjectCallable() {
    return disableXpnResourceProjectCallable;
  }

  @BetaApi
  public UnaryCallable<EnableXpnHostProjectHttpRequest, Operation> enableXpnHostProjectCallable() {
    return enableXpnHostProjectCallable;
  }

  @BetaApi
  public UnaryCallable<EnableXpnResourceProjectHttpRequest, Operation>
      enableXpnResourceProjectCallable() {
    return enableXpnResourceProjectCallable;
  }

  @BetaApi
  public UnaryCallable<GetProjectHttpRequest, Project> getProjectCallable() {
    return getProjectCallable;
  }

  @BetaApi
  public UnaryCallable<GetXpnHostProjectHttpRequest, Project> getXpnHostProjectCallable() {
    return getXpnHostProjectCallable;
  }

  @BetaApi
  public UnaryCallable<GetXpnResourcesProjectsHttpRequest, GetXpnResourcesProjectsPagedResponse>
      getXpnResourcesProjectsPagedCallable() {
    return getXpnResourcesProjectsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<GetXpnResourcesProjectsHttpRequest, ProjectsGetXpnResources>
      getXpnResourcesProjectsCallable() {
    return getXpnResourcesProjectsCallable;
  }

  @BetaApi
  public UnaryCallable<ListXpnHostsProjectsHttpRequest, ListXpnHostsProjectsPagedResponse>
      listXpnHostsProjectsPagedCallable() {
    return listXpnHostsProjectsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListXpnHostsProjectsHttpRequest, XpnHostList>
      listXpnHostsProjectsCallable() {
    return listXpnHostsProjectsCallable;
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
  public UnaryCallable<SetCommonInstanceMetadataProjectHttpRequest, Operation>
      setCommonInstanceMetadataProjectCallable() {
    return setCommonInstanceMetadataProjectCallable;
  }

  @BetaApi
  public UnaryCallable<SetUsageExportBucketProjectHttpRequest, Operation>
      setUsageExportBucketProjectCallable() {
    return setUsageExportBucketProjectCallable;
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
