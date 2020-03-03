/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.compute.v1.PacketMirroringClient.AggregatedListPacketMirroringsPagedResponse;
import static com.google.cloud.compute.v1.PacketMirroringClient.ListPacketMirroringsPagedResponse;

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
import com.google.cloud.compute.v1.AggregatedListPacketMirroringsHttpRequest;
import com.google.cloud.compute.v1.DeletePacketMirroringHttpRequest;
import com.google.cloud.compute.v1.GetPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.InsertPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.ListPacketMirroringsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PacketMirroring;
import com.google.cloud.compute.v1.PacketMirroringAggregatedList;
import com.google.cloud.compute.v1.PacketMirroringList;
import com.google.cloud.compute.v1.PatchPacketMirroringHttpRequest;
import com.google.cloud.compute.v1.ProjectName;
import com.google.cloud.compute.v1.ProjectRegionName;
import com.google.cloud.compute.v1.ProjectRegionPacketMirroringName;
import com.google.cloud.compute.v1.ProjectRegionPacketMirroringResourceName;
import com.google.cloud.compute.v1.TestIamPermissionsPacketMirroringHttpRequest;
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
public class HttpJsonPacketMirroringStub extends PacketMirroringStub {
  @InternalApi
  public static final ApiMethodDescriptor<
          AggregatedListPacketMirroringsHttpRequest, PacketMirroringAggregatedList>
      aggregatedListPacketMirroringsMethodDescriptor =
          ApiMethodDescriptor
              .<AggregatedListPacketMirroringsHttpRequest, PacketMirroringAggregatedList>
                  newBuilder()
              .setFullMethodName("compute.packetMirrorings.aggregatedList")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<AggregatedListPacketMirroringsHttpRequest>newBuilder()
                      .setPathTemplate(PathTemplate.create("{project}/aggregated/packetMirrorings"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectName.newFactory())
                      .setResourceNameField("project")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<PacketMirroringAggregatedList>newBuilder()
                      .setResponseInstance(PacketMirroringAggregatedList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeletePacketMirroringHttpRequest, Operation>
      deletePacketMirroringMethodDescriptor =
          ApiMethodDescriptor.<DeletePacketMirroringHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.packetMirrorings.delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<DeletePacketMirroringHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/packetMirrorings/{packetMirroring}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionPacketMirroringName.newFactory())
                      .setResourceNameField("packetMirroring")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetPacketMirroringHttpRequest, PacketMirroring>
      getPacketMirroringMethodDescriptor =
          ApiMethodDescriptor.<GetPacketMirroringHttpRequest, PacketMirroring>newBuilder()
              .setFullMethodName("compute.packetMirrorings.get")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<GetPacketMirroringHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/packetMirrorings/{packetMirroring}"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionPacketMirroringName.newFactory())
                      .setResourceNameField("packetMirroring")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<PacketMirroring>newBuilder()
                      .setResponseInstance(PacketMirroring.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertPacketMirroringHttpRequest, Operation>
      insertPacketMirroringMethodDescriptor =
          ApiMethodDescriptor.<InsertPacketMirroringHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.packetMirrorings.insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<InsertPacketMirroringHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/packetMirrorings"))
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
  public static final ApiMethodDescriptor<ListPacketMirroringsHttpRequest, PacketMirroringList>
      listPacketMirroringsMethodDescriptor =
          ApiMethodDescriptor.<ListPacketMirroringsHttpRequest, PacketMirroringList>newBuilder()
              .setFullMethodName("compute.packetMirrorings.list")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<ListPacketMirroringsHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create("{project}/regions/{region}/packetMirrorings"))
                      .setQueryParams(
                          Sets.<String>newHashSet("filter", "maxResults", "orderBy", "pageToken"))
                      .setResourceNameFactory(ProjectRegionName.newFactory())
                      .setResourceNameField("region")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<PacketMirroringList>newBuilder()
                      .setResponseInstance(PacketMirroringList.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<PatchPacketMirroringHttpRequest, Operation>
      patchPacketMirroringMethodDescriptor =
          ApiMethodDescriptor.<PatchPacketMirroringHttpRequest, Operation>newBuilder()
              .setFullMethodName("compute.packetMirrorings.patch")
              .setHttpMethod(HttpMethods.PATCH)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter.<PatchPacketMirroringHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/packetMirrorings/{packetMirroring}"))
                      .setQueryParams(Sets.<String>newHashSet("requestId"))
                      .setResourceNameFactory(ProjectRegionPacketMirroringName.newFactory())
                      .setResourceNameField("packetMirroring")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<Operation>newBuilder()
                      .setResponseInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
      testIamPermissionsPacketMirroringMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("compute.packetMirrorings.testIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ApiMessageHttpRequestFormatter
                      .<TestIamPermissionsPacketMirroringHttpRequest>newBuilder()
                      .setPathTemplate(
                          PathTemplate.create(
                              "{project}/regions/{region}/packetMirrorings/{resource}/testIamPermissions"))
                      .setQueryParams(Sets.<String>newHashSet())
                      .setResourceNameFactory(ProjectRegionPacketMirroringResourceName.newFactory())
                      .setResourceNameField("resource")
                      .build())
              .setResponseParser(
                  ApiMessageHttpResponseParser.<TestPermissionsResponse>newBuilder()
                      .setResponseInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<
          AggregatedListPacketMirroringsHttpRequest, PacketMirroringAggregatedList>
      aggregatedListPacketMirroringsCallable;
  private final UnaryCallable<
          AggregatedListPacketMirroringsHttpRequest, AggregatedListPacketMirroringsPagedResponse>
      aggregatedListPacketMirroringsPagedCallable;
  private final UnaryCallable<DeletePacketMirroringHttpRequest, Operation>
      deletePacketMirroringCallable;
  private final UnaryCallable<GetPacketMirroringHttpRequest, PacketMirroring>
      getPacketMirroringCallable;
  private final UnaryCallable<InsertPacketMirroringHttpRequest, Operation>
      insertPacketMirroringCallable;
  private final UnaryCallable<ListPacketMirroringsHttpRequest, PacketMirroringList>
      listPacketMirroringsCallable;
  private final UnaryCallable<ListPacketMirroringsHttpRequest, ListPacketMirroringsPagedResponse>
      listPacketMirroringsPagedCallable;
  private final UnaryCallable<PatchPacketMirroringHttpRequest, Operation>
      patchPacketMirroringCallable;
  private final UnaryCallable<TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
      testIamPermissionsPacketMirroringCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonPacketMirroringStub create(PacketMirroringStubSettings settings)
      throws IOException {
    return new HttpJsonPacketMirroringStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPacketMirroringStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPacketMirroringStub(
        PacketMirroringStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonPacketMirroringStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPacketMirroringStub(
        PacketMirroringStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPacketMirroringStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPacketMirroringStub(
      PacketMirroringStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPacketMirroringCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPacketMirroringStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPacketMirroringStub(
      PacketMirroringStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AggregatedListPacketMirroringsHttpRequest, PacketMirroringAggregatedList>
        aggregatedListPacketMirroringsTransportSettings =
            HttpJsonCallSettings
                .<AggregatedListPacketMirroringsHttpRequest, PacketMirroringAggregatedList>
                    newBuilder()
                .setMethodDescriptor(aggregatedListPacketMirroringsMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeletePacketMirroringHttpRequest, Operation>
        deletePacketMirroringTransportSettings =
            HttpJsonCallSettings.<DeletePacketMirroringHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(deletePacketMirroringMethodDescriptor)
                .build();
    HttpJsonCallSettings<GetPacketMirroringHttpRequest, PacketMirroring>
        getPacketMirroringTransportSettings =
            HttpJsonCallSettings.<GetPacketMirroringHttpRequest, PacketMirroring>newBuilder()
                .setMethodDescriptor(getPacketMirroringMethodDescriptor)
                .build();
    HttpJsonCallSettings<InsertPacketMirroringHttpRequest, Operation>
        insertPacketMirroringTransportSettings =
            HttpJsonCallSettings.<InsertPacketMirroringHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(insertPacketMirroringMethodDescriptor)
                .build();
    HttpJsonCallSettings<ListPacketMirroringsHttpRequest, PacketMirroringList>
        listPacketMirroringsTransportSettings =
            HttpJsonCallSettings.<ListPacketMirroringsHttpRequest, PacketMirroringList>newBuilder()
                .setMethodDescriptor(listPacketMirroringsMethodDescriptor)
                .build();
    HttpJsonCallSettings<PatchPacketMirroringHttpRequest, Operation>
        patchPacketMirroringTransportSettings =
            HttpJsonCallSettings.<PatchPacketMirroringHttpRequest, Operation>newBuilder()
                .setMethodDescriptor(patchPacketMirroringMethodDescriptor)
                .build();
    HttpJsonCallSettings<TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
        testIamPermissionsPacketMirroringTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsPacketMirroringMethodDescriptor)
                .build();

    this.aggregatedListPacketMirroringsCallable =
        callableFactory.createUnaryCallable(
            aggregatedListPacketMirroringsTransportSettings,
            settings.aggregatedListPacketMirroringsSettings(),
            clientContext);
    this.aggregatedListPacketMirroringsPagedCallable =
        callableFactory.createPagedCallable(
            aggregatedListPacketMirroringsTransportSettings,
            settings.aggregatedListPacketMirroringsSettings(),
            clientContext);
    this.deletePacketMirroringCallable =
        callableFactory.createUnaryCallable(
            deletePacketMirroringTransportSettings,
            settings.deletePacketMirroringSettings(),
            clientContext);
    this.getPacketMirroringCallable =
        callableFactory.createUnaryCallable(
            getPacketMirroringTransportSettings,
            settings.getPacketMirroringSettings(),
            clientContext);
    this.insertPacketMirroringCallable =
        callableFactory.createUnaryCallable(
            insertPacketMirroringTransportSettings,
            settings.insertPacketMirroringSettings(),
            clientContext);
    this.listPacketMirroringsCallable =
        callableFactory.createUnaryCallable(
            listPacketMirroringsTransportSettings,
            settings.listPacketMirroringsSettings(),
            clientContext);
    this.listPacketMirroringsPagedCallable =
        callableFactory.createPagedCallable(
            listPacketMirroringsTransportSettings,
            settings.listPacketMirroringsSettings(),
            clientContext);
    this.patchPacketMirroringCallable =
        callableFactory.createUnaryCallable(
            patchPacketMirroringTransportSettings,
            settings.patchPacketMirroringSettings(),
            clientContext);
    this.testIamPermissionsPacketMirroringCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsPacketMirroringTransportSettings,
            settings.testIamPermissionsPacketMirroringSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @BetaApi
  public UnaryCallable<
          AggregatedListPacketMirroringsHttpRequest, AggregatedListPacketMirroringsPagedResponse>
      aggregatedListPacketMirroringsPagedCallable() {
    return aggregatedListPacketMirroringsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<AggregatedListPacketMirroringsHttpRequest, PacketMirroringAggregatedList>
      aggregatedListPacketMirroringsCallable() {
    return aggregatedListPacketMirroringsCallable;
  }

  @BetaApi
  public UnaryCallable<DeletePacketMirroringHttpRequest, Operation>
      deletePacketMirroringCallable() {
    return deletePacketMirroringCallable;
  }

  @BetaApi
  public UnaryCallable<GetPacketMirroringHttpRequest, PacketMirroring>
      getPacketMirroringCallable() {
    return getPacketMirroringCallable;
  }

  @BetaApi
  public UnaryCallable<InsertPacketMirroringHttpRequest, Operation>
      insertPacketMirroringCallable() {
    return insertPacketMirroringCallable;
  }

  @BetaApi
  public UnaryCallable<ListPacketMirroringsHttpRequest, ListPacketMirroringsPagedResponse>
      listPacketMirroringsPagedCallable() {
    return listPacketMirroringsPagedCallable;
  }

  @BetaApi
  public UnaryCallable<ListPacketMirroringsHttpRequest, PacketMirroringList>
      listPacketMirroringsCallable() {
    return listPacketMirroringsCallable;
  }

  @BetaApi
  public UnaryCallable<PatchPacketMirroringHttpRequest, Operation> patchPacketMirroringCallable() {
    return patchPacketMirroringCallable;
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsPacketMirroringHttpRequest, TestPermissionsResponse>
      testIamPermissionsPacketMirroringCallable() {
    return testIamPermissionsPacketMirroringCallable;
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
