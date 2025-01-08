/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigquery.storage.v1alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.BatchCreateMetastorePartitionsResponse;
import com.google.cloud.bigquery.storage.v1alpha.BatchDeleteMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.BatchUpdateMetastorePartitionsResponse;
import com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.ListMetastorePartitionsResponse;
import com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsRequest;
import com.google.cloud.bigquery.storage.v1alpha.StreamMetastorePartitionsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MetastorePartitionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcMetastorePartitionServiceStub extends MetastorePartitionServiceStub {
  private static final MethodDescriptor<
          BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
      batchCreateMetastorePartitionsMethodDescriptor =
          MethodDescriptor
              .<BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1alpha.MetastorePartitionService/BatchCreateMetastorePartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateMetastorePartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchCreateMetastorePartitionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchDeleteMetastorePartitionsRequest, Empty>
      batchDeleteMetastorePartitionsMethodDescriptor =
          MethodDescriptor.<BatchDeleteMetastorePartitionsRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1alpha.MetastorePartitionService/BatchDeleteMetastorePartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchDeleteMetastorePartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
      batchUpdateMetastorePartitionsMethodDescriptor =
          MethodDescriptor
              .<BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1alpha.MetastorePartitionService/BatchUpdateMetastorePartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchUpdateMetastorePartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      BatchUpdateMetastorePartitionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
      listMetastorePartitionsMethodDescriptor =
          MethodDescriptor
              .<ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1alpha.MetastorePartitionService/ListMetastorePartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListMetastorePartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMetastorePartitionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
      streamMetastorePartitionsMethodDescriptor =
          MethodDescriptor
              .<StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1alpha.MetastorePartitionService/StreamMetastorePartitions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamMetastorePartitionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamMetastorePartitionsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<
          BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
      batchCreateMetastorePartitionsCallable;
  private final UnaryCallable<BatchDeleteMetastorePartitionsRequest, Empty>
      batchDeleteMetastorePartitionsCallable;
  private final UnaryCallable<
          BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
      batchUpdateMetastorePartitionsCallable;
  private final UnaryCallable<ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
      listMetastorePartitionsCallable;
  private final BidiStreamingCallable<
          StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
      streamMetastorePartitionsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMetastorePartitionServiceStub create(
      MetastorePartitionServiceStubSettings settings) throws IOException {
    return new GrpcMetastorePartitionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMetastorePartitionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMetastorePartitionServiceStub(
        MetastorePartitionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMetastorePartitionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMetastorePartitionServiceStub(
        MetastorePartitionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcMetastorePartitionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMetastorePartitionServiceStub(
      MetastorePartitionServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMetastorePartitionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMetastorePartitionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMetastorePartitionServiceStub(
      MetastorePartitionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
        batchCreateMetastorePartitionsTransportSettings =
            GrpcCallSettings
                .<BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateMetastorePartitionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchDeleteMetastorePartitionsRequest, Empty>
        batchDeleteMetastorePartitionsTransportSettings =
            GrpcCallSettings.<BatchDeleteMetastorePartitionsRequest, Empty>newBuilder()
                .setMethodDescriptor(batchDeleteMetastorePartitionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
        batchUpdateMetastorePartitionsTransportSettings =
            GrpcCallSettings
                .<BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
                    newBuilder()
                .setMethodDescriptor(batchUpdateMetastorePartitionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
        listMetastorePartitionsTransportSettings =
            GrpcCallSettings
                .<ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>newBuilder()
                .setMethodDescriptor(listMetastorePartitionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
        streamMetastorePartitionsTransportSettings =
            GrpcCallSettings
                .<StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>newBuilder()
                .setMethodDescriptor(streamMetastorePartitionsMethodDescriptor)
                .build();

    this.batchCreateMetastorePartitionsCallable =
        callableFactory.createUnaryCallable(
            batchCreateMetastorePartitionsTransportSettings,
            settings.batchCreateMetastorePartitionsSettings(),
            clientContext);
    this.batchDeleteMetastorePartitionsCallable =
        callableFactory.createUnaryCallable(
            batchDeleteMetastorePartitionsTransportSettings,
            settings.batchDeleteMetastorePartitionsSettings(),
            clientContext);
    this.batchUpdateMetastorePartitionsCallable =
        callableFactory.createUnaryCallable(
            batchUpdateMetastorePartitionsTransportSettings,
            settings.batchUpdateMetastorePartitionsSettings(),
            clientContext);
    this.listMetastorePartitionsCallable =
        callableFactory.createUnaryCallable(
            listMetastorePartitionsTransportSettings,
            settings.listMetastorePartitionsSettings(),
            clientContext);
    this.streamMetastorePartitionsCallable =
        callableFactory.createBidiStreamingCallable(
            streamMetastorePartitionsTransportSettings,
            settings.streamMetastorePartitionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          BatchCreateMetastorePartitionsRequest, BatchCreateMetastorePartitionsResponse>
      batchCreateMetastorePartitionsCallable() {
    return batchCreateMetastorePartitionsCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteMetastorePartitionsRequest, Empty>
      batchDeleteMetastorePartitionsCallable() {
    return batchDeleteMetastorePartitionsCallable;
  }

  @Override
  public UnaryCallable<
          BatchUpdateMetastorePartitionsRequest, BatchUpdateMetastorePartitionsResponse>
      batchUpdateMetastorePartitionsCallable() {
    return batchUpdateMetastorePartitionsCallable;
  }

  @Override
  public UnaryCallable<ListMetastorePartitionsRequest, ListMetastorePartitionsResponse>
      listMetastorePartitionsCallable() {
    return listMetastorePartitionsCallable;
  }

  @Override
  public BidiStreamingCallable<StreamMetastorePartitionsRequest, StreamMetastorePartitionsResponse>
      streamMetastorePartitionsCallable() {
    return streamMetastorePartitionsCallable;
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
