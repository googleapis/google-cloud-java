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

import static com.google.cloud.compute.v1.SnapshotClient.ListSnapshotsPagedResponse;

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
import com.google.cloud.compute.v1.DeleteSnapshotHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicySnapshotHttpRequest;
import com.google.cloud.compute.v1.GetSnapshotHttpRequest;
import com.google.cloud.compute.v1.ListSnapshotsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.ProjectGlobalSnapshotName;
import com.google.cloud.compute.v1.ProjectGlobalSnapshotResourceName;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.SetIamPolicySnapshotHttpRequest;
import com.google.cloud.compute.v1.SetLabelsSnapshotHttpRequest;
import com.google.cloud.compute.v1.Snapshot;
import com.google.cloud.compute.v1.SnapshotList;
import com.google.cloud.compute.v1.TestIamPermissionsSnapshotHttpRequest;
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
public class HttpJsonSnapshotStub extends SnapshotStub {
  @InternalApi
  public static final ApiMethodDescriptor<DeleteSnapshotHttpRequest, Operation>
      deleteSnapshotMethodDescriptor =
          ApiMethodDescriptor.<DeleteSnapshotHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.snapshots.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeleteSnapshotHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/snapshots/{snapshot}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectGlobalSnapshotName.newFactory())
                      .setResourceNameField("snapshot")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetSnapshotHttpRequest, Snapshot>
      getSnapshotMethodDescriptor =
          ApiMethodDescriptor.<GetSnapshotHttpRequest, Snapshot>newBuilder()
              .setFullMethodName("compute.snapshots.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetSnapshotHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/snapshots/{snapshot}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalSnapshotName.newFactory())
                      .setResourceNameField("snapshot")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Snapshot>newBuilder()
                      .setResponseInstance(Snapshot.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicySnapshotHttpRequest, Policy>
      getIamPolicySnapshotMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicySnapshotHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.snapshots.getIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetIamPolicySnapshotHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/snapshots/{resource}/getIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalSnapshotResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListSnapshotsHttpRequest, SnapshotList>
      listSnapshotsMethodDescriptor =
          ApiMethodDescriptor.<ListSnapshotsHttpRequest, SnapshotList>newBuilder()
              .setFullMethodName("compute.snapshots.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListSnapshotsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/global/snapshots"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<SnapshotList>newBuilder()
                      .setResponseInstance(SnapshotList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicySnapshotHttpRequest, Policy>
      setIamPolicySnapshotMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicySnapshotHttpRequest, Policy>newBuilder()
              .setFullMethodName("compute.snapshots.setIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetIamPolicySnapshotHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/snapshots/{resource}/setIamPolicy"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalSnapshotResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Policy>newBuilder()
                      .setResponseInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsSnapshotHttpRequest, Operation>
      setLabelsSnapshotMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsSnapshotHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.snapshots.setLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<SetLabelsSnapshotHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/global/snapshots/{resource}/setLabels"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalSnapshotResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>
      testIamPermissionsSnapshotMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.snapshots.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<TestIamPermissionsSnapshotHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/global/snapshots/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectGlobalSnapshotResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteSnapshotHttpRequest, Operation> deleteSnapshotCallable;
  private final UnaryCallable<GetSnapshotHttpRequest, Snapshot> getSnapshotCallable;
  private final UnaryCallable<GetIamPolicySnapshotHttpRequest, Policy> getIamPolicySnapshotCallable;
  private final UnaryCallable<ListSnapshotsHttpRequest, SnapshotList> listSnapshotsCallable;
  private final UnaryCallable<ListSnapshotsHttpRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable;
  private final UnaryCallable<SetIamPolicySnapshotHttpRequest, Policy> setIamPolicySnapshotCallable;
  private final UnaryCallable<SetLabelsSnapshotHttpRequest, Operation> setLabelsSnapshotCallable;
  private final UnaryCallable<TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>
      testIamPermissionsSnapshotCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSnapshotStub create(SnapshotStubSettings settings)
      throws IOException {
    return new HttpJsonSnapshotStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSnapshotStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonSnapshotStub(SnapshotStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonSnapshotStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSnapshotStub(
        SnapshotStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSnapshotStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSnapshotStub(SnapshotStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSnapshotCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSnapshotStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonSnapshotStub(
      SnapshotStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<DeleteSnapshotHttpRequest, Operation> deleteSnapshotTransportSettings =
        HttpJsonCallSettings.<DeleteSnapshotHttpRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteSnapshotMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetSnapshotHttpRequest, Snapshot> getSnapshotTransportSettings =
        HttpJsonCallSettings.<GetSnapshotHttpRequest, Snapshot>newBuilder()
            .setMethodDescriptor(getSnapshotMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicySnapshotHttpRequest, Policy>
        getIamPolicySnapshotTransportSettings =
            HttpJsonCallSettings.<GetIamPolicySnapshotHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(getIamPolicySnapshotMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListSnapshotsHttpRequest, SnapshotList> listSnapshotsTransportSettings =
        HttpJsonCallSettings.<ListSnapshotsHttpRequest, SnapshotList>newBuilder()
            .setMethodDescriptor(listSnapshotsMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicySnapshotHttpRequest, Policy>
        setIamPolicySnapshotTransportSettings =
            HttpJsonCallSettings.<SetIamPolicySnapshotHttpRequest, Policy>newBuilder()
                .setMethodDescriptor(setIamPolicySnapshotMethodDescriptor)
                .build();
    HttpJsonCallSettings<SetLabelsSnapshotHttpRequest, Operation>
        setLabelsSnapshotTransportSettings =
            HttpJsonCallSettings.<SetLabelsSnapshotHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(setLabelsSnapshotMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>
        testIamPermissionsSnapshotTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsSnapshotMethodDescriptor)
                .build();

    this.deleteSnapshotCallable =
        callableFactory.createUnaryCallable(
            deleteSnapshotTransportSettings, settings.deleteSnapshotSettings(), clientContext);
    this.getSnapshotCallable =
        callableFactory.createUnaryCallable(
            getSnapshotTransportSettings, settings.getSnapshotSettings(), clientContext);
    this.getIamPolicySnapshotCallable =
        callableFactory.createUnaryCallable(
            getIamPolicySnapshotTransportSettings,
            settings.getIamPolicySnapshotSettings(),
            clientContext);
    this.listSnapshotsCallable =
        callableFactory.createUnaryCallable(
            listSnapshotsTransportSettings, settings.listSnapshotsSettings(), clientContext);
    this.listSnapshotsPagedCallable =
        callableFactory.createPagedCallable(
            listSnapshotsTransportSettings, settings.listSnapshotsSettings(), clientContext);
    this.setIamPolicySnapshotCallable =
        callableFactory.createUnaryCallable(
            setIamPolicySnapshotTransportSettings,
            settings.setIamPolicySnapshotSettings(),
            clientContext);
    this.setLabelsSnapshotCallable =
        callableFactory.createUnaryCallable(
            setLabelsSnapshotTransportSettings,
            settings.setLabelsSnapshotSettings(),
            clientContext);
    this.testIamPermissionsSnapshotCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsSnapshotTransportSettings,
            settings.testIamPermissionsSnapshotSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<DeleteSnapshotHttpRequest, Operation> deleteSnapshotCallable() {
    return deleteSnapshotCallable;
  }

  @BetaApi
  public UnaryCallable<GetSnapshotHttpRequest, Snapshot> getSnapshotCallable() {
    return getSnapshotCallable;
  }

  @BetaApi
  public UnaryCallable<GetIamPolicySnapshotHttpRequest, Policy> getIamPolicySnapshotCallable() {
    return getIamPolicySnapshotCallable;
  }

  @BetaApi
  public UnaryCallable<ListSnapshotsHttpRequest, ListSnapshotsPagedResponse>
      listSnapshotsPagedCallable() {
    return listSnapshotsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListSnapshotsHttpRequest, SnapshotList> listSnapshotsCallable() {
    return listSnapshotsCallable;
  }

  @BetaApi
  public UnaryCallable<SetIamPolicySnapshotHttpRequest, Policy> setIamPolicySnapshotCallable() {
    return setIamPolicySnapshotCallable;
  }

  @BetaApi
  public UnaryCallable<SetLabelsSnapshotHttpRequest, Operation> setLabelsSnapshotCallable() {
    return setLabelsSnapshotCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsSnapshotHttpRequest, TestPermissionsResponse>
      testIamPermissionsSnapshotCallable() {
    return testIamPermissionsSnapshotCallable;
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
