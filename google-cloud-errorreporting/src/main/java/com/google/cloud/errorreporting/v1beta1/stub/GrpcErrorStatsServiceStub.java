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
package com.google.cloud.errorreporting.v1beta1.stub;

import static com.google.cloud.errorreporting.v1beta1.PagedResponseWrappers.ListEventsPagedResponse;
import static com.google.cloud.errorreporting.v1beta1.PagedResponseWrappers.ListGroupStatsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.errorreporting.v1beta1.ErrorStatsServiceSettings;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.DeleteEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListEventsResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ListGroupStatsResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Error Reporting API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class GrpcErrorStatsServiceStub extends ErrorStatsServiceStub {
  private static final UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse>
      directListGroupStatsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.devtools.clouderrorreporting.v1beta1.ErrorStatsService/ListGroupStats",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListGroupStatsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListGroupStatsResponse.getDefaultInstance())));
  private static final UnaryCallable<ListEventsRequest, ListEventsResponse>
      directListEventsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.devtools.clouderrorreporting.v1beta1.ErrorStatsService/ListEvents",
                  io.grpc.protobuf.ProtoUtils.marshaller(ListEventsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(ListEventsResponse.getDefaultInstance())));
  private static final UnaryCallable<DeleteEventsRequest, DeleteEventsResponse>
      directDeleteEventsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.devtools.clouderrorreporting.v1beta1.ErrorStatsService/DeleteEvents",
                  io.grpc.protobuf.ProtoUtils.marshaller(DeleteEventsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      DeleteEventsResponse.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse> listGroupStatsCallable;
  private final UnaryCallable<ListGroupStatsRequest, ListGroupStatsPagedResponse>
      listGroupStatsPagedCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable;
  private final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable;
  private final UnaryCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable;

  public static final GrpcErrorStatsServiceStub create(ErrorStatsServiceSettings settings)
      throws IOException {
    return new GrpcErrorStatsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcErrorStatsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcErrorStatsServiceStub(
        ErrorStatsServiceSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcErrorStatsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcErrorStatsServiceStub(
      ErrorStatsServiceSettings settings, ClientContext clientContext) throws IOException {

    this.listGroupStatsCallable =
        GrpcCallableFactory.create(
            directListGroupStatsCallable, settings.listGroupStatsSettings(), clientContext);
    this.listGroupStatsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListGroupStatsCallable, settings.listGroupStatsSettings(), clientContext);
    this.listEventsCallable =
        GrpcCallableFactory.create(
            directListEventsCallable, settings.listEventsSettings(), clientContext);
    this.listEventsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListEventsCallable, settings.listEventsSettings(), clientContext);
    this.deleteEventsCallable =
        GrpcCallableFactory.create(
            directDeleteEventsCallable, settings.deleteEventsSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<ListGroupStatsRequest, ListGroupStatsPagedResponse>
      listGroupStatsPagedCallable() {
    return listGroupStatsPagedCallable;
  }

  public UnaryCallable<ListGroupStatsRequest, ListGroupStatsResponse> listGroupStatsCallable() {
    return listGroupStatsCallable;
  }

  public UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return listEventsPagedCallable;
  }

  public UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return listEventsCallable;
  }

  public UnaryCallable<DeleteEventsRequest, DeleteEventsResponse> deleteEventsCallable() {
    return deleteEventsCallable;
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
