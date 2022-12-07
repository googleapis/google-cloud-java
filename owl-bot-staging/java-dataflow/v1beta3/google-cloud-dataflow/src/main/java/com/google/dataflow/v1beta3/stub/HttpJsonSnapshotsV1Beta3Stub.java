/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.dataflow.v1beta3.stub;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.dataflow.v1beta3.DeleteSnapshotRequest;
import com.google.dataflow.v1beta3.DeleteSnapshotResponse;
import com.google.dataflow.v1beta3.GetSnapshotRequest;
import com.google.dataflow.v1beta3.ListSnapshotsRequest;
import com.google.dataflow.v1beta3.ListSnapshotsResponse;
import com.google.dataflow.v1beta3.Snapshot;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the SnapshotsV1Beta3 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonSnapshotsV1Beta3Stub extends SnapshotsV1Beta3Stub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetSnapshotRequest, Snapshot>
      getSnapshotMethodDescriptor =
          ApiMethodDescriptor.<GetSnapshotRequest, Snapshot>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.SnapshotsV1Beta3/GetSnapshot")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSnapshotRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/snapshots/{snapshotId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "snapshotId", request.getSnapshotId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1b3/projects/{projectId}/snapshots/{snapshotId}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Snapshot>newBuilder()
                      .setDefaultInstance(Snapshot.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSnapshotRequest, DeleteSnapshotResponse>
      deleteSnapshotMethodDescriptor =
          ApiMethodDescriptor.<DeleteSnapshotRequest, DeleteSnapshotResponse>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.SnapshotsV1Beta3/DeleteSnapshot")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteSnapshotRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/snapshots/{snapshotId}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            serializer.putPathParam(fields, "snapshotId", request.getSnapshotId());
                            return fields;
                          })
                      .setAdditionalPaths("/v1b3/projects/{projectId}/snapshots")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSnapshotRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DeleteSnapshotResponse>newBuilder()
                      .setDefaultInstance(DeleteSnapshotResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSnapshotsRequest, ListSnapshotsResponse>
      listSnapshotsMethodDescriptor =
          ApiMethodDescriptor.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
              .setFullMethodName("google.dataflow.v1beta3.SnapshotsV1Beta3/ListSnapshots")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSnapshotsRequest>newBuilder()
                      .setPath(
                          "/v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/snapshots",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSnapshotsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "jobId", request.getJobId());
                            serializer.putPathParam(fields, "location", request.getLocation());
                            serializer.putPathParam(fields, "projectId", request.getProjectId());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1b3/projects/{projectId}/locations/{location}/snapshots",
                          "/v1b3/projects/{projectId}/snapshots")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSnapshotsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSnapshotsResponse>newBuilder()
                      .setDefaultInstance(ListSnapshotsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable;
  private final UnaryCallable<DeleteSnapshotRequest, DeleteSnapshotResponse> deleteSnapshotCallable;
  private final UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSnapshotsV1Beta3Stub create(SnapshotsV1Beta3StubSettings settings)
      throws IOException {
    return new HttpJsonSnapshotsV1Beta3Stub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSnapshotsV1Beta3Stub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSnapshotsV1Beta3Stub(
        SnapshotsV1Beta3StubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSnapshotsV1Beta3Stub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSnapshotsV1Beta3Stub(
        SnapshotsV1Beta3StubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSnapshotsV1Beta3Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSnapshotsV1Beta3Stub(
      SnapshotsV1Beta3StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonSnapshotsV1Beta3CallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSnapshotsV1Beta3Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSnapshotsV1Beta3Stub(
      SnapshotsV1Beta3StubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetSnapshotRequest, Snapshot> getSnapshotTransportSettings =
        HttpJsonCallSettings.<GetSnapshotRequest, Snapshot>newBuilder()
            .setMethodDescriptor(getSnapshotMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteSnapshotRequest, DeleteSnapshotResponse>
        deleteSnapshotTransportSettings =
            HttpJsonCallSettings.<DeleteSnapshotRequest, DeleteSnapshotResponse>newBuilder()
                .setMethodDescriptor(deleteSnapshotMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListSnapshotsRequest, ListSnapshotsResponse>
        listSnapshotsTransportSettings =
            HttpJsonCallSettings.<ListSnapshotsRequest, ListSnapshotsResponse>newBuilder()
                .setMethodDescriptor(listSnapshotsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();

    this.getSnapshotCallable =
        callableFactory.createUnaryCallable(
            getSnapshotTransportSettings, settings.getSnapshotSettings(), clientContext);
    this.deleteSnapshotCallable =
        callableFactory.createUnaryCallable(
            deleteSnapshotTransportSettings, settings.deleteSnapshotSettings(), clientContext);
    this.listSnapshotsCallable =
        callableFactory.createUnaryCallable(
            listSnapshotsTransportSettings, settings.listSnapshotsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getSnapshotMethodDescriptor);
    methodDescriptors.add(deleteSnapshotMethodDescriptor);
    methodDescriptors.add(listSnapshotsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetSnapshotRequest, Snapshot> getSnapshotCallable() {
    return getSnapshotCallable;
  }

  @Override
  public UnaryCallable<DeleteSnapshotRequest, DeleteSnapshotResponse> deleteSnapshotCallable() {
    return deleteSnapshotCallable;
  }

  @Override
  public UnaryCallable<ListSnapshotsRequest, ListSnapshotsResponse> listSnapshotsCallable() {
    return listSnapshotsCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
