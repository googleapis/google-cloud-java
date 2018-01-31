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
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Cloud Bigtable API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcBigtableStub extends BigtableStub {

  private static final MethodDescriptor<ReadRowsRequest, ReadRowsResponse>
      readRowsMethodDescriptor =
          MethodDescriptor.<ReadRowsRequest, ReadRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.bigtable.v2.Bigtable/ReadRows")
              .setRequestMarshaller(ProtoUtils.marshaller(ReadRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReadRowsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<SampleRowKeysRequest, SampleRowKeysResponse>
      sampleRowKeysMethodDescriptor =
          MethodDescriptor.<SampleRowKeysRequest, SampleRowKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.bigtable.v2.Bigtable/SampleRowKeys")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SampleRowKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SampleRowKeysResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<MutateRowRequest, MutateRowResponse>
      mutateRowMethodDescriptor =
          MethodDescriptor.<MutateRowRequest, MutateRowResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.v2.Bigtable/MutateRow")
              .setRequestMarshaller(ProtoUtils.marshaller(MutateRowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MutateRowResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<MutateRowsRequest, MutateRowsResponse>
      mutateRowsMethodDescriptor =
          MethodDescriptor.<MutateRowsRequest, MutateRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.bigtable.v2.Bigtable/MutateRows")
              .setRequestMarshaller(ProtoUtils.marshaller(MutateRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MutateRowsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
      checkAndMutateRowMethodDescriptor =
          MethodDescriptor.<CheckAndMutateRowRequest, CheckAndMutateRowResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.v2.Bigtable/CheckAndMutateRow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CheckAndMutateRowRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CheckAndMutateRowResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
      readModifyWriteRowMethodDescriptor =
          MethodDescriptor.<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.v2.Bigtable/ReadModifyWriteRow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReadModifyWriteRowRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReadModifyWriteRowResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable;
  private final ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse>
      sampleRowKeysCallable;
  private final UnaryCallable<MutateRowRequest, MutateRowResponse> mutateRowCallable;
  private final ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> mutateRowsCallable;
  private final UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
      checkAndMutateRowCallable;
  private final UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
      readModifyWriteRowCallable;

  public static final GrpcBigtableStub create(BigtableStubSettings settings) throws IOException {
    return new GrpcBigtableStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigtableStub create(ClientContext clientContext) throws IOException {
    return new GrpcBigtableStub(BigtableStubSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcBigtableStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcBigtableStub(BigtableStubSettings settings, ClientContext clientContext)
      throws IOException {

    GrpcCallSettings<ReadRowsRequest, ReadRowsResponse> readRowsTransportSettings =
        GrpcCallSettings.<ReadRowsRequest, ReadRowsResponse>newBuilder()
            .setMethodDescriptor(readRowsMethodDescriptor)
            .build();
    GrpcCallSettings<SampleRowKeysRequest, SampleRowKeysResponse> sampleRowKeysTransportSettings =
        GrpcCallSettings.<SampleRowKeysRequest, SampleRowKeysResponse>newBuilder()
            .setMethodDescriptor(sampleRowKeysMethodDescriptor)
            .build();
    GrpcCallSettings<MutateRowRequest, MutateRowResponse> mutateRowTransportSettings =
        GrpcCallSettings.<MutateRowRequest, MutateRowResponse>newBuilder()
            .setMethodDescriptor(mutateRowMethodDescriptor)
            .build();
    GrpcCallSettings<MutateRowsRequest, MutateRowsResponse> mutateRowsTransportSettings =
        GrpcCallSettings.<MutateRowsRequest, MutateRowsResponse>newBuilder()
            .setMethodDescriptor(mutateRowsMethodDescriptor)
            .build();
    GrpcCallSettings<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
        checkAndMutateRowTransportSettings =
            GrpcCallSettings.<CheckAndMutateRowRequest, CheckAndMutateRowResponse>newBuilder()
                .setMethodDescriptor(checkAndMutateRowMethodDescriptor)
                .build();
    GrpcCallSettings<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
        readModifyWriteRowTransportSettings =
            GrpcCallSettings.<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>newBuilder()
                .setMethodDescriptor(readModifyWriteRowMethodDescriptor)
                .build();

    this.readRowsCallable =
        GrpcCallableFactory.createServerStreamingCallable(
            readRowsTransportSettings, settings.readRowsSettings(), clientContext);
    this.sampleRowKeysCallable =
        GrpcCallableFactory.createServerStreamingCallable(
            sampleRowKeysTransportSettings, settings.sampleRowKeysSettings(), clientContext);
    this.mutateRowCallable =
        GrpcCallableFactory.createUnaryCallable(
            mutateRowTransportSettings, settings.mutateRowSettings(), clientContext);
    this.mutateRowsCallable =
        GrpcCallableFactory.createServerStreamingCallable(
            mutateRowsTransportSettings, settings.mutateRowsSettings(), clientContext);
    this.checkAndMutateRowCallable =
        GrpcCallableFactory.createUnaryCallable(
            checkAndMutateRowTransportSettings,
            settings.checkAndMutateRowSettings(),
            clientContext);
    this.readModifyWriteRowCallable =
        GrpcCallableFactory.createUnaryCallable(
            readModifyWriteRowTransportSettings,
            settings.readModifyWriteRowSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable() {
    return readRowsCallable;
  }

  public ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse>
      sampleRowKeysCallable() {
    return sampleRowKeysCallable;
  }

  public UnaryCallable<MutateRowRequest, MutateRowResponse> mutateRowCallable() {
    return mutateRowCallable;
  }

  public ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> mutateRowsCallable() {
    return mutateRowsCallable;
  }

  public UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
      checkAndMutateRowCallable() {
    return checkAndMutateRowCallable;
  }

  public UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
      readModifyWriteRowCallable() {
    return readModifyWriteRowCallable;
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
