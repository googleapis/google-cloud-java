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

import static com.google.cloud.compute.v1.RegionDiskClient.ListRegionDisksPagedResponse;

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
import com.google.cloud.compute.v1.AddResourcePoliciesRegionDiskHttpRequest;
import com.google.cloud.compute.v1.CreateSnapshotRegionDiskHttpRequest;
import com.google.cloud.compute.v1.DeleteRegionDiskHttpRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.GetRegionDiskHttpRequest;
import com.google.cloud.compute.v1.InsertRegionDiskHttpRequest;
import com.google.cloud.compute.v1.ListRegionDisksHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectRegionDiskName;
import com.google.cloud.compute.v1.ProjectRegionDiskResourceName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.RemoveResourcePoliciesRegionDiskHttpRequest;
import com.google.cloud.compute.v1.ResizeRegionDiskHttpRequest;
import com.google.cloud.compute.v1.SetLabelsRegionDiskHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionDiskHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
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
public class HttpJsonRegionDiskStub extends RegionDiskStub {
  @InternalApi
  public static final ApiMethodDescriptor<AddResourcePoliciesRegionDiskHttpRequest, Operation>
      addResourcePoliciesRegionDiskMethodDescriptor =
          ApiMethodDescriptor.<AddResourcePoliciesRegionDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionDisks.addResourcePolicies")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AddResourcePoliciesRegionDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/disks/{disk}/addResourcePolicies"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionDiskName.newFactory())
                      .setResourceNameField("disk")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<CreateSnapshotRegionDiskHttpRequest, Operation>
      createSnapshotRegionDiskMethodDescriptor =
          ApiMethodDescriptor.<CreateSnapshotRegionDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionDisks.createSnapshot")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<CreateSnapshotRegionDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/disks/{disk}/createSnapshot"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionDiskName.newFactory())
                      .setResourceNameField("disk")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionDiskHttpRequest, Operation>
      deleteRegionDiskMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionDisks.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteRegionDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/disks/{disk}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionDiskName.newFactory())
                      .setResourceNameField("disk")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionDiskHttpRequest, Disk>
      getRegionDiskMethodDescriptor =
          ApiMethodDescriptor.<GetRegionDiskHttpRequest, Disk>newBuilder()
              .setFullMethodName("compute.regionDisks.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetRegionDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/disks/{disk}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionDiskName.newFactory())
                      .setResourceNameField("disk")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Disk>newBuilder()
                      .setResponseInstance(Disk.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionDiskHttpRequest, Operation>
      insertRegionDiskMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionDisks.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertRegionDiskHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/disks"))
                      .setQueryParams(Sets.<String>newHashSet("requestId", "sourceImage"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRegionDisksHttpRequest, DiskList>
      listRegionDisksMethodDescriptor =
          ApiMethodDescriptor.<ListRegionDisksHttpRequest, DiskList>newBuilder()
              .setFullMethodName("compute.regionDisks.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListRegionDisksHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/regions/{region}/disks"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<DiskList>newBuilder()
                      .setResponseInstance(DiskList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveResourcePoliciesRegionDiskHttpRequest, Operation>
      removeResourcePoliciesRegionDiskMethodDescriptor =
          ApiMethodDescriptor.<RemoveResourcePoliciesRegionDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionDisks.removeResourcePolicies")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<RemoveResourcePoliciesRegionDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/disks/{disk}/removeResourcePolicies"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionDiskName.newFactory())
                      .setResourceNameField("disk")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ResizeRegionDiskHttpRequest, Operation>
      resizeRegionDiskMethodDescriptor =
          ApiMethodDescriptor.<ResizeRegionDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionDisks.resize")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ResizeRegionDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/disks/{disk}/resize"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionDiskName.newFactory())
                      .setResourceNameField("disk")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsRegionDiskHttpRequest, Operation>
      setLabelsRegionDiskMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsRegionDiskHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.regionDisks.setLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetLabelsRegionDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/disks/{resource}/setLabels"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionDiskResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsRegionDiskMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.regionDisks.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsRegionDiskHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/disks/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionDiskResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddResourcePoliciesRegionDiskHttpRequest, Operation>
      addResourcePoliciesRegionDiskCallable;
  private final UnaryCallable<CreateSnapshotRegionDiskHttpRequest, Operation>
      createSnapshotRegionDiskCallable;
  private final UnaryCallable<DeleteRegionDiskHttpRequest, Operation> deleteRegionDiskCallable;
  private final UnaryCallable<GetRegionDiskHttpRequest, Disk> getRegionDiskCallable;
  private final UnaryCallable<InsertRegionDiskHttpRequest, Operation> insertRegionDiskCallable;
  private final UnaryCallable<ListRegionDisksHttpRequest, DiskList> listRegionDisksCallable;
  private final UnaryCallable<ListRegionDisksHttpRequest, ListRegionDisksPagedResponse>
      listRegionDisksPagedCallable;
  private final UnaryCallable<RemoveResourcePoliciesRegionDiskHttpRequest, Operation>
      removeResourcePoliciesRegionDiskCallable;
  private final UnaryCallable<ResizeRegionDiskHttpRequest, Operation> resizeRegionDiskCallable;
  private final UnaryCallable<SetLabelsRegionDiskHttpRequest, Operation>
      setLabelsRegionDiskCallable;
  private final UnaryCallable<TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsRegionDiskCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionDiskStub create(RegionDiskStubSettings settings)
      throws IOException {
    return new HttpJsonRegionDiskStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionDiskStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionDiskStub(RegionDiskStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionDiskStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionDiskStub(
        RegionDiskStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionDiskStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionDiskStub(RegionDiskStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionDiskCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionDiskStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionDiskStub(
      RegionDiskStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddResourcePoliciesRegionDiskHttpRequest, Operation>
        addResourcePoliciesRegionDiskTransportSettings =
            HttpJsonCallSettings.<AddResourcePoliciesRegionDiskHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(addResourcePoliciesRegionDiskMethodDescriptor)
                .build();
    HttpJsonCallSettings<CreateSnapshotRegionDiskHttpRequest, Operation>
        createSnapshotRegionDiskTransportSettings =
            HttpJsonCallSettings.<CreateSnapshotRegionDiskHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(createSnapshotRegionDiskMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteRegionDiskHttpRequest, Operation> deleteRegionDiskTransportSettings =
        HttpJsonCallSettings.<DeleteRegionDiskHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRegionDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionDiskHttpRequest, Disk> getRegionDiskTransportSettings =
        HttpJsonCallSettings.<GetRegionDiskHttpRequest, Disk>newBuilder()
            .setMethodDescriptor(getRegionDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionDiskHttpRequest, Operation> insertRegionDiskTransportSettings =
        HttpJsonCallSettings.<InsertRegionDiskHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(insertRegionDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionDisksHttpRequest, DiskList> listRegionDisksTransportSettings =
        HttpJsonCallSettings.<ListRegionDisksHttpRequest, DiskList>newBuilder()
            .setMethodDescriptor(listRegionDisksMethodDescriptor)
            .build();
    HttpJsonCallSettings<RemoveResourcePoliciesRegionDiskHttpRequest, Operation>
        removeResourcePoliciesRegionDiskTransportSettings =
            HttpJsonCallSettings
                .<RemoveResourcePoliciesRegionDiskHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(removeResourcePoliciesRegionDiskMethodDescriptor)
                .build();
    HttpJsonCallSettings<ResizeRegionDiskHttpRequest, Operation> resizeRegionDiskTransportSettings =
        HttpJsonCallSettings.<ResizeRegionDiskHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeRegionDiskMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetLabelsRegionDiskHttpRequest, Operation>
        setLabelsRegionDiskTransportSettings =
            HttpJsonCallSettings.<SetLabelsRegionDiskHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setLabelsRegionDiskMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
        testIamPermissionsRegionDiskTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsRegionDiskMethodDescriptor)
                .build();

    this.addResourcePoliciesRegionDiskCallable =
        callableFactory.createUnaryCallable(
            addResourcePoliciesRegionDiskTransportSettings,
            settings.addResourcePoliciesRegionDiskSettings(),
            clientContext);
    this.createSnapshotRegionDiskCallable =
        callableFactory.createUnaryCallable(
            createSnapshotRegionDiskTransportSettings,
            settings.createSnapshotRegionDiskSettings(),
            clientContext);
    this.deleteRegionDiskCallable =
        callableFactory.createUnaryCallable(
            deleteRegionDiskTransportSettings, settings.deleteRegionDiskSettings(), clientContext);
    this.getRegionDiskCallable =
        callableFactory.createUnaryCallable(
            getRegionDiskTransportSettings, settings.getRegionDiskSettings(), clientContext);
    this.insertRegionDiskCallable =
        callableFactory.createUnaryCallable(
            insertRegionDiskTransportSettings, settings.insertRegionDiskSettings(), clientContext);
    this.listRegionDisksCallable =
        callableFactory.createUnaryCallable(
            listRegionDisksTransportSettings, settings.listRegionDisksSettings(), clientContext);
    this.listRegionDisksPagedCallable =
        callableFactory.createPagedCallable(
            listRegionDisksTransportSettings, settings.listRegionDisksSettings(), clientContext);
    this.removeResourcePoliciesRegionDiskCallable =
        callableFactory.createUnaryCallable(
            removeResourcePoliciesRegionDiskTransportSettings,
            settings.removeResourcePoliciesRegionDiskSettings(),
            clientContext);
    this.resizeRegionDiskCallable =
        callableFactory.createUnaryCallable(
            resizeRegionDiskTransportSettings, settings.resizeRegionDiskSettings(), clientContext);
    this.setLabelsRegionDiskCallable =
        callableFactory.createUnaryCallable(
            setLabelsRegionDiskTransportSettings,
            settings.setLabelsRegionDiskSettings(),
            clientContext);
    this.testIamPermissionsRegionDiskCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsRegionDiskTransportSettings,
            settings.testIamPermissionsRegionDiskSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<AddResourcePoliciesRegionDiskHttpRequest, Operation>
      addResourcePoliciesRegionDiskCallable() {
    return addResourcePoliciesRegionDiskCallable;
  }

  @BetaApi
  public UnaryCallable<CreateSnapshotRegionDiskHttpRequest, Operation>
      createSnapshotRegionDiskCallable() {
    return createSnapshotRegionDiskCallable;
  }

  @BetaApi
  public UnaryCallable<DeleteRegionDiskHttpRequest, Operation> deleteRegionDiskCallable() {
    return deleteRegionDiskCallable;
  }

  @BetaApi
  public UnaryCallable<GetRegionDiskHttpRequest, Disk> getRegionDiskCallable() {
    return getRegionDiskCallable;
  }

  @BetaApi
  public UnaryCallable<InsertRegionDiskHttpRequest, Operation> insertRegionDiskCallable() {
    return insertRegionDiskCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionDisksHttpRequest, ListRegionDisksPagedResponse>
      listRegionDisksPagedCallable() {
    return listRegionDisksPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListRegionDisksHttpRequest, DiskList> listRegionDisksCallable() {
    return listRegionDisksCallable;
  }

  @BetaApi
  public UnaryCallable<RemoveResourcePoliciesRegionDiskHttpRequest, Operation>
      removeResourcePoliciesRegionDiskCallable() {
    return removeResourcePoliciesRegionDiskCallable;
  }

  @BetaApi
  public UnaryCallable<ResizeRegionDiskHttpRequest, Operation> resizeRegionDiskCallable() {
    return resizeRegionDiskCallable;
  }

  @BetaApi
  public UnaryCallable<SetLabelsRegionDiskHttpRequest, Operation> setLabelsRegionDiskCallable() {
    return setLabelsRegionDiskCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsRegionDiskHttpRequest, TestPermissionsResponse>
      testIamPermissionsRegionDiskCallable() {
    return testIamPermissionsRegionDiskCallable;
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
