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

import static com.google.cloud.logging.v2.PagedResponseWrappers.ListLogEntriesPagedResponse;
import static com.google.cloud.logging.v2.PagedResponseWrappers.ListLogsPagedResponse;
import static com.google.cloud.logging.v2.PagedResponseWrappers.ListMonitoredResourceDescriptorsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.logging.v2.LoggingSettings;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
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
public class GrpcLoggingServiceV2Stub extends LoggingServiceV2Stub {
  private static final UnaryCallable<DeleteLogRequest, Empty> directDeleteLogCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.logging.v2.LoggingServiceV2/DeleteLog",
              io.grpc.protobuf.ProtoUtils.marshaller(DeleteLogRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(Empty.getDefaultInstance())));
  private static final UnaryCallable<WriteLogEntriesRequest, WriteLogEntriesResponse>
      directWriteLogEntriesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.logging.v2.LoggingServiceV2/WriteLogEntries",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      WriteLogEntriesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      WriteLogEntriesResponse.getDefaultInstance())));
  private static final UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse>
      directListLogEntriesCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.logging.v2.LoggingServiceV2/ListLogEntries",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListLogEntriesRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListLogEntriesResponse.getDefaultInstance())));
  private static final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      directListMonitoredResourceDescriptorsCallable =
          GrpcCallableFactory.createDirectCallable(
              io.grpc.MethodDescriptor.create(
                  io.grpc.MethodDescriptor.MethodType.UNARY,
                  "google.logging.v2.LoggingServiceV2/ListMonitoredResourceDescriptors",
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListMonitoredResourceDescriptorsRequest.getDefaultInstance()),
                  io.grpc.protobuf.ProtoUtils.marshaller(
                      ListMonitoredResourceDescriptorsResponse.getDefaultInstance())));
  private static final UnaryCallable<ListLogsRequest, ListLogsResponse> directListLogsCallable =
      GrpcCallableFactory.createDirectCallable(
          io.grpc.MethodDescriptor.create(
              io.grpc.MethodDescriptor.MethodType.UNARY,
              "google.logging.v2.LoggingServiceV2/ListLogs",
              io.grpc.protobuf.ProtoUtils.marshaller(ListLogsRequest.getDefaultInstance()),
              io.grpc.protobuf.ProtoUtils.marshaller(ListLogsResponse.getDefaultInstance())));

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<DeleteLogRequest, Empty> deleteLogCallable;
  private final UnaryCallable<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesCallable;
  private final UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse> listLogEntriesCallable;
  private final UnaryCallable<ListLogEntriesRequest, ListLogEntriesPagedResponse>
      listLogEntriesPagedCallable;
  private final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable;
  private final UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable;
  private final UnaryCallable<ListLogsRequest, ListLogsResponse> listLogsCallable;
  private final UnaryCallable<ListLogsRequest, ListLogsPagedResponse> listLogsPagedCallable;

  public static final GrpcLoggingServiceV2Stub create(LoggingSettings settings) throws IOException {
    return new GrpcLoggingServiceV2Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcLoggingServiceV2Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLoggingServiceV2Stub(LoggingSettings.newBuilder().build(), clientContext);
  }

  /**
   * Constructs an instance of GrpcLoggingServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLoggingServiceV2Stub(LoggingSettings settings, ClientContext clientContext)
      throws IOException {

    this.deleteLogCallable =
        GrpcCallableFactory.create(
            directDeleteLogCallable, settings.deleteLogSettings(), clientContext);
    this.writeLogEntriesCallable =
        GrpcCallableFactory.create(
            directWriteLogEntriesCallable, settings.writeLogEntriesSettings(), clientContext);
    this.listLogEntriesCallable =
        GrpcCallableFactory.create(
            directListLogEntriesCallable, settings.listLogEntriesSettings(), clientContext);
    this.listLogEntriesPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListLogEntriesCallable, settings.listLogEntriesSettings(), clientContext);
    this.listMonitoredResourceDescriptorsCallable =
        GrpcCallableFactory.create(
            directListMonitoredResourceDescriptorsCallable,
            settings.listMonitoredResourceDescriptorsSettings(),
            clientContext);
    this.listMonitoredResourceDescriptorsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListMonitoredResourceDescriptorsCallable,
            settings.listMonitoredResourceDescriptorsSettings(),
            clientContext);
    this.listLogsCallable =
        GrpcCallableFactory.create(
            directListLogsCallable, settings.listLogsSettings(), clientContext);
    this.listLogsPagedCallable =
        GrpcCallableFactory.createPagedVariant(
            directListLogsCallable, settings.listLogsSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<DeleteLogRequest, Empty> deleteLogCallable() {
    return deleteLogCallable;
  }

  public UnaryCallable<WriteLogEntriesRequest, WriteLogEntriesResponse> writeLogEntriesCallable() {
    return writeLogEntriesCallable;
  }

  public UnaryCallable<ListLogEntriesRequest, ListLogEntriesPagedResponse>
      listLogEntriesPagedCallable() {
    return listLogEntriesPagedCallable;
  }

  public UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse> listLogEntriesCallable() {
    return listLogEntriesCallable;
  }

  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable() {
    return listMonitoredResourceDescriptorsPagedCallable;
  }

  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable() {
    return listMonitoredResourceDescriptorsCallable;
  }

  public UnaryCallable<ListLogsRequest, ListLogsPagedResponse> listLogsPagedCallable() {
    return listLogsPagedCallable;
  }

  public UnaryCallable<ListLogsRequest, ListLogsResponse> listLogsCallable() {
    return listLogsCallable;
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
