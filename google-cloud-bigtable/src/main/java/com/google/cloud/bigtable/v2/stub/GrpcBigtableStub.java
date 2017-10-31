/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.v2.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
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
import com.google.cloud.bigtable.v2.BigtableSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Google Cloud Bigtable API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcBigtableStub extends BigtableStub {
  private static final ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse>
      directReadRowsCallable =
          GrpcCallableFactory.createDirectServerStreamingCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
                  "google.bigtable.v2.Bigtable/ReadRows",
                  io.grpc.protobuf.ProtoUtils.marshaller(ReadRowsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(ReadRowsResponse.getDefaultInstance())));
  private static final ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse>
      directSampleRowKeysCallable =
          GrpcCallableFactory.createDirectServerStreamingCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
                  "google.bigtable.v2.Bigtable/SampleRowKeys",
                  io.grpc.protobuf.ProtoUtils.marshaller(SampleRowKeysRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      SampleRowKeysResponse.getDefaultInstance())));
  private static final UnaryCallable<MutateRowRequest, MutateRowResponse> directMutateRowCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.bigtable.v2.Bigtable/MutateRow",
              io.grpc.protobuf.ProtoUtils.marshaller(MutateRowRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(MutateRowResponse.getDefaultInstance())));
  private static final ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse>
      directMutateRowsCallable =
          GrpcCallableFactory.createDirectServerStreamingCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
                  "google.bigtable.v2.Bigtable/MutateRows",
                  io.grpc.protobuf.ProtoUtils.marshaller(MutateRowsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(MutateRowsResponse.getDefaultInstance())));
  private static final UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
      directCheckAndMutateRowCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.bigtable.v2.Bigtable/CheckAndMutateRow",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      CheckAndMutateRowRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      CheckAndMutateRowResponse.getDefaultInstance())));
  private static final UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
      directReadModifyWriteRowCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.bigtable.v2.Bigtable/ReadModifyWriteRow",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ReadModifyWriteRowRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ReadModifyWriteRowResponse.getDefaultInstance())));

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

  public static final GrpcBigtableStub create(BigtableSettings settings) throws IOException {
    return new GrpcBigtableStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigtableStub create(ClientContext clientContext) throws IOException {
    return new GrpcBigtableStub(BigtableSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcBigtableStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcBigtableStub(BigtableSettings settings, ClientContext clientContext)
      throws IOException {

    this.readRowsCallable =
        GrpcCallableFactory.create(
            directReadRowsCallable, settings.readRowsSettings(), clientContext);
    this.sampleRowKeysCallable =
        GrpcCallableFactory.create(
            directSampleRowKeysCallable, settings.sampleRowKeysSettings(), clientContext);
    this.mutateRowCallable =
        GrpcCallableFactory.create(
            directMutateRowCallable, settings.mutateRowSettings(), clientContext);
    this.mutateRowsCallable =
        GrpcCallableFactory.create(
            directMutateRowsCallable, settings.mutateRowsSettings(), clientContext);
    this.checkAndMutateRowCallable =
        GrpcCallableFactory.create(
            directCheckAndMutateRowCallable, settings.checkAndMutateRowSettings(), clientContext);
    this.readModifyWriteRowCallable =
        GrpcCallableFactory.create(
            directReadModifyWriteRowCallable, settings.readModifyWriteRowSettings(), clientContext);

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
