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
package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.PagedResponseWrappers.ListSinksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.logging.v2.ConfigSettings;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Logging API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcConfigServiceV2Stub extends ConfigServiceV2Stub {
  private static final UnaryCallable<ListSinksRequest, ListSinksResponse> directListSinksCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.logging.v2.ConfigServiceV2/ListSinks",
              io.grpc.protobuf.ProtoUtils.marshaller(ListSinksRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(ListSinksResponse.getDefaultInstance())));
  private static final UnaryCallable<GetSinkRequest, LogSink> directGetSinkCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.logging.v2.ConfigServiceV2/GetSink",
              io.grpc.protobuf.ProtoUtils.marshaller(GetSinkRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(LogSink.getDefaultInstance())));
  private static final UnaryCallable<CreateSinkRequest, LogSink> directCreateSinkCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.logging.v2.ConfigServiceV2/CreateSink",
              io.grpc.protobuf.ProtoUtils.marshaller(CreateSinkRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(LogSink.getDefaultInstance())));
  private static final UnaryCallable<UpdateSinkRequest, LogSink> directUpdateSinkCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.logging.v2.ConfigServiceV2/UpdateSink",
              io.grpc.protobuf.ProtoUtils.marshaller(UpdateSinkRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(LogSink.getDefaultInstance())));
  private static final UnaryCallable<DeleteSinkRequest, Empty> directDeleteSinkCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.logging.v2.ConfigServiceV2/DeleteSink",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteSinkRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable;
  private final UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable;
  private final UnaryCallable<GetSinkRequest, LogSink> getSinkCallable;
  private final UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable;
  private final UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable;
  private final UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable;

  public static final GrpcConfigServiceV2Stub create(ConfigSettings settings) throws IOException {
    return new GrpcConfigServiceV2Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcConfigServiceV2Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConfigServiceV2Stub(ConfigSettings.defaultBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcConfigServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConfigServiceV2Stub(ConfigSettings settings, ClientContext clientContext)
      throws IOException {

    this.listSinksCallable =
        GrpcCallableFactory.create(
            directListSinksCallable, settings.listSinksSettings(), clientContext);
    this.listSinksPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListSinksCallable, settings.listSinksSettings(), clientContext);
    this.getSinkCallable =
        GrpcCallableFactory.create(
            directGetSinkCallable, settings.getSinkSettings(), clientContext);
    this.createSinkCallable =
        GrpcCallableFactory.create(
            directCreateSinkCallable, settings.createSinkSettings(), clientContext);
    this.updateSinkCallable =
        GrpcCallableFactory.create(
            directUpdateSinkCallable, settings.updateSinkSettings(), clientContext);
    this.deleteSinkCallable =
        GrpcCallableFactory.create(
            directDeleteSinkCallable, settings.deleteSinkSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable() {
    return listSinksPagedCallable;
  }

  public UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable() {
    return listSinksCallable;
  }

  public UnaryCallable<GetSinkRequest, LogSink> getSinkCallable() {
    return getSinkCallable;
  }

  public UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable() {
    return createSinkCallable;
  }

  public UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable() {
    return updateSinkCallable;
  }

  public UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable() {
    return deleteSinkCallable;
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
