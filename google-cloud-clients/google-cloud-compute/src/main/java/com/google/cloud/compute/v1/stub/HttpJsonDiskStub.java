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

import static com.google.cloud.compute.v1.DiskClient.AggregatedListDisksPagedResponse;
import static com.google.cloud.compute.v1.DiskClient.ListDisksPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListDisksHttpRequest;
import com.google.cloud.compute.v1.CreateSnapshotDiskHttpRequest;
import com.google.cloud.compute.v1.DeleteDiskHttpRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskAggregatedList;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.GetDiskHttpRequest;
import com.google.cloud.compute.v1.InsertDiskHttpRequest;
import com.google.cloud.compute.v1.ListDisksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectZoneDiskName;
import com.google.cloud.compute.v1.ProjectZoneDiskResourceName;
import com.google.cloud.compute.v1.ProjectZoneName;
import com.google.cloud.compute.v1.ResizeDiskHttpRequest;
import com.google.cloud.compute.v1.SetLabelsDiskHttpRequest;
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
public class HttpJsonDiskStub extends DiskStub {
  @InternalApi
  public static final ApiMethodDescriptor<AggregatedListDisksHttpRequest, DiskAggregatedList>
      aggregatedListDisksMethodDescriptor =
          ApiMethodDescriptor.<AggregatedListDisksHttpRequest, DiskAggregatedList>newBuilder()
              .setFullMethodName("compute.disks.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<AggregatedListDisksHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/disks"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<DiskAggregatedList>newBuilder()
                      .setResponseInstance(DiskAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<CreateSnapshotDiskHttpRequest, Operation>
      createSnapshotDiskMethodDescriptor =
          ApiMethodDescriptor.<CreateSnapshotDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.disks.createSnapshot")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<CreateSnapshotDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/disks/{disk}/createSnapshot"))
                      .setQueryParams(Sets.<String>newHashSet("guestFlush", "requestId"))
                      .setResourceNameFactory(ProjectZoneDiskName.newFactory())
                      .setResourceNameField("disk")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteDiskHttpRequest, Operation>
      deleteDiskMethodDescriptor =
          ApiMethodDescriptor.<DeleteDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.disks.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteDiskHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/disks/{disk}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneDiskName.newFactory())
                      .setResourceNameField("disk")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetDiskHttpRequest, Disk> getDiskMethodDescriptor =
      ApiMethodDescriptor.<GetDiskHttpRequest, Disk>newBuilder()
          .setFullMethodName("compute.disks.get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ApiMessageHttpRequestFormatter.<GetDiskHttpRequest>newBuilder()
                  .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/disks/{disk}"))
                  .setQueryParams(Sets.<String>newHashSet())
                  .setResourceNameFactory(ProjectZoneDiskName.newFactory())
                  .setResourceNameField("disk")
                  .build())
          .setResponseParser(
              ApiMessageHttpResponseParser.<Disk>newBuilder()
                  .setResponseInstance(Disk.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertDiskHttpRequest, Operation>
      insertDiskMethodDescriptor =
          ApiMethodDescriptor.<InsertDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.disks.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertDiskHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/disks"))
                      .setQueryParams(Sets.<String>newHashSet("requestId", "sourceImage"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListDisksHttpRequest, DiskList>
      listDisksMethodDescriptor =
          ApiMethodDescriptor.<ListDisksHttpRequest, DiskList>newBuilder()
              .setFullMethodName("compute.disks.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListDisksHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/zones/{zone}/disks"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectZoneName.newFactory())
                      .setResourceNameField("zone")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<DiskList>newBuilder()
                      .setResponseInstance(DiskList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ResizeDiskHttpRequest, Operation>
      resizeDiskMethodDescriptor =
          ApiMethodDescriptor.<ResizeDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.disks.resize")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ResizeDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/disks/{disk}/resize"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneDiskName.newFactory())
                      .setResourceNameField("disk")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsDiskHttpRequest, Operation>
      setLabelsDiskMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.disks.setLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetLabelsDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/zones/{zone}/disks/{resource}/setLabels"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectZoneDiskResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AggregatedListDisksHttpRequest, DiskAggregatedList>
      aggregatedListDisksCallable;
  private final UnaryCallable<AggregatedListDisksHttpRequest, AggregatedListDisksPagedResponse>
      aggregatedListDisksPagedCallable;
  private final UnaryCallable<CreateSnapshotDiskHttpRequest, Operation> createSnapshotDiskCallable;
  private final UnaryCallable<DeleteDiskHttpRequest, Operation> deleteDiskCallable;
  private final UnaryCallable<GetDiskHttpRequest, Disk> getDiskCallable;
  private final UnaryCallable<InsertDiskHttpRequest, Operation> insertDiskCallable;
  private final UnaryCallable<ListDisksHttpRequest, DiskList> listDisksCallable;
  private final UnaryCallable<ListDisksHttpRequest, ListDisksPagedResponse> listDisksPagedCallable;
  private final UnaryCallable<ResizeDiskHttpRequest, Operation> resizeDiskCallable;
  private final UnaryCallable<SetLabelsDiskHttpRequest, Operation> setLabelsDiskCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonDiskStub create(DiskStubSettings settings) throws IOException {
    return new HttpJsonDiskStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonDiskStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonDiskStub(DiskStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonDiskStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonDiskStub(
        DiskStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonDiskStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonDiskStub(DiskStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonDiskCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonDiskStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected HttpJsonDiskStub(
      DiskStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListDisksHttpRequest, DiskAggregatedList>
        aggregatedListDisksTransportSettings =
            HttpJsonCallSettings.<AggregatedListDisksHttpRequest, DiskAggregatedList>newBuilder()
                .setMethodDescriptor(aggregatedListDisksMethodDescriptor)
                .build();
    HttpJsonCallSettings<CreateSnapshotDiskHttpRequest, Operation>
        createSnapshotDiskTransportSettings =
            HttpJsonCallSettings.<CreateSnapshotDiskHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(createSnapshotDiskMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteDiskHttpRequest, Operation> deleteDiskTransportSettings =
        HttpJsonCallSettings.<DeleteDiskHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetDiskHttpRequest, Disk> getDiskTransportSettings =
        HttpJsonCallSettings.<GetDiskHttpRequest, Disk>newBuilder()
            .setMethodDescriptor(getDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertDiskHttpRequest, Operation> insertDiskTransportSettings =
        HttpJsonCallSettings.<InsertDiskHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListDisksHttpRequest, DiskList> listDisksTransportSettings =
        HttpJsonCallSettings.<ListDisksHttpRequest, DiskList>newBuilder()
            .setMethodDescriptor(listDisksMethodDescriptor)
            .build();
    HttpJsonCallSettings<ResizeDiskHttpRequest, Operation> resizeDiskTransportSettings =
        HttpJsonCallSettings.<ResizeDiskHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetLabelsDiskHttpRequest, Operation> setLabelsDiskTransportSettings =
        HttpJsonCallSettings.<SetLabelsDiskHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsDiskMethodDescriptor)
            .build();

    this.aggregatedListDisksCallable =
        callableFactory.createUnaryCallable(
            aggregatedListDisksTransportSettings,
            settings.aggregatedListDisksSettings(),
            clientContext);
    this.aggregatedListDisksPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListDisksTransportSettings,
            settings.aggregatedListDisksSettings(),
            clientContext);
    this.createSnapshotDiskCallable =
        callableFactory.createUnaryCallable(
            createSnapshotDiskTransportSettings,
            settings.createSnapshotDiskSettings(),
            clientContext);
    this.deleteDiskCallable =
        callableFactory.createUnaryCallable(
            deleteDiskTransportSettings, settings.deleteDiskSettings(), clientContext);
    this.getDiskCallable =
        callableFactory.createUnaryCallable(
            getDiskTransportSettings, settings.getDiskSettings(), clientContext);
    this.insertDiskCallable =
        callableFactory.createUnaryCallable(
            insertDiskTransportSettings, settings.insertDiskSettings(), clientContext);
    this.listDisksCallable =
        callableFactory.createUnaryCallable(
            listDisksTransportSettings, settings.listDisksSettings(), clientContext);
    this.listDisksPagedCallable =
        callableFactory.createPagedCallable(
            listDisksTransportSettings, settings.listDisksSettings(), clientContext);
    this.resizeDiskCallable =
        callableFactory.createUnaryCallable(
            resizeDiskTransportSettings, settings.resizeDiskSettings(), clientContext);
    this.setLabelsDiskCallable =
        callableFactory.createUnaryCallable(
            setLabelsDiskTransportSettings, settings.setLabelsDiskSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AggregatedListDisksHttpRequest, AggregatedListDisksPagedResponse>
      aggregatedListDisksPagedCallable() {
    return aggregatedListDisksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListDisksHttpRequest, DiskAggregatedList>
      aggregatedListDisksCallable() {
    return aggregatedListDisksCallable;
  }

  @BetaApi
  public UnaryCallable<CreateSnapshotDiskHttpRequest, Operation> createSnapshotDiskCallable() {
    return createSnapshotDiskCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteDiskHttpRequest, Operation> deleteDiskCallable() {
    return deleteDiskCallable;
  }

  @BetaApi
  public UnaryCallable<GetDiskHttpRequest, Disk> getDiskCallable() {
    return getDiskCallable;
  }

  @BetaApi
  public UnaryCallable<InsertDiskHttpRequest, Operation> insertDiskCallable() {
    return insertDiskCallable;
  }

  @BetaApi
  public UnaryCallable<ListDisksHttpRequest, ListDisksPagedResponse> listDisksPagedCallable() {
    return listDisksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListDisksHttpRequest, DiskList> listDisksCallable() {
    return listDisksCallable;
  }

  @BetaApi
  public UnaryCallable<ResizeDiskHttpRequest, Operation> resizeDiskCallable() {
    return resizeDiskCallable;
  }

  @BetaApi
  public UnaryCallable<SetLabelsDiskHttpRequest, Operation> setLabelsDiskCallable() {
    return setLabelsDiskCallable;
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
