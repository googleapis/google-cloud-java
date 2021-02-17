/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.LoggingClient.ListLogEntriesPagedResponse;
import static com.google.cloud.logging.v2.LoggingClient.ListLogsPagedResponse;
import static com.google.cloud.logging.v2.LoggingClient.ListMonitoredResourceDescriptorsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the LoggingServiceV2 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcLoggingServiceV2Stub extends LoggingServiceV2Stub {
  private static final MethodDescriptor<DeleteLogRequest, Empty> deleteLogMethodDescriptor =
      MethodDescriptor.<DeleteLogRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.LoggingServiceV2/DeleteLog")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteLogRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesMethodDescriptor =
          MethodDescriptor.<WriteLogEntriesRequest, WriteLogEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.LoggingServiceV2/WriteLogEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(WriteLogEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(WriteLogEntriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLogEntriesRequest, ListLogEntriesResponse>
      listLogEntriesMethodDescriptor =
          MethodDescriptor.<ListLogEntriesRequest, ListLogEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.LoggingServiceV2/ListLogEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLogEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLogEntriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsMethodDescriptor =
          MethodDescriptor
              .<ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.logging.v2.LoggingServiceV2/ListMonitoredResourceDescriptors")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      ListMonitoredResourceDescriptorsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      ListMonitoredResourceDescriptorsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLogsRequest, ListLogsResponse>
      listLogsMethodDescriptor =
          MethodDescriptor.<ListLogsRequest, ListLogsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.LoggingServiceV2/ListLogs")
              .setRequestMarshaller(ProtoUtils.marshaller(ListLogsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListLogsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<TailLogEntriesRequest, TailLogEntriesResponse>
      tailLogEntriesMethodDescriptor =
          MethodDescriptor.<TailLogEntriesRequest, TailLogEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.logging.v2.LoggingServiceV2/TailLogEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TailLogEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TailLogEntriesResponse.getDefaultInstance()))
              .build();

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
  private final BidiStreamingCallable<TailLogEntriesRequest, TailLogEntriesResponse>
      tailLogEntriesCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcLoggingServiceV2Stub create(LoggingServiceV2StubSettings settings)
      throws IOException {
    return new GrpcLoggingServiceV2Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcLoggingServiceV2Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcLoggingServiceV2Stub(
        LoggingServiceV2StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcLoggingServiceV2Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcLoggingServiceV2Stub(
        LoggingServiceV2StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcLoggingServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLoggingServiceV2Stub(
      LoggingServiceV2StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcLoggingServiceV2CallableFactory());
  }

  /**
   * Constructs an instance of GrpcLoggingServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcLoggingServiceV2Stub(
      LoggingServiceV2StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<DeleteLogRequest, Empty> deleteLogTransportSettings =
        GrpcCallSettings.<DeleteLogRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteLogMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteLogRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteLogRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("log_name", String.valueOf(request.getLogName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<WriteLogEntriesRequest, WriteLogEntriesResponse>
        writeLogEntriesTransportSettings =
            GrpcCallSettings.<WriteLogEntriesRequest, WriteLogEntriesResponse>newBuilder()
                .setMethodDescriptor(writeLogEntriesMethodDescriptor)
                .build();
    GrpcCallSettings<ListLogEntriesRequest, ListLogEntriesResponse>
        listLogEntriesTransportSettings =
            GrpcCallSettings.<ListLogEntriesRequest, ListLogEntriesResponse>newBuilder()
                .setMethodDescriptor(listLogEntriesMethodDescriptor)
                .build();
    GrpcCallSettings<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
        listMonitoredResourceDescriptorsTransportSettings =
            GrpcCallSettings
                .<ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
                    newBuilder()
                .setMethodDescriptor(listMonitoredResourceDescriptorsMethodDescriptor)
                .build();
    GrpcCallSettings<ListLogsRequest, ListLogsResponse> listLogsTransportSettings =
        GrpcCallSettings.<ListLogsRequest, ListLogsResponse>newBuilder()
            .setMethodDescriptor(listLogsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListLogsRequest>() {
                  @Override
                  public Map<String, String> extract(ListLogsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<TailLogEntriesRequest, TailLogEntriesResponse>
        tailLogEntriesTransportSettings =
            GrpcCallSettings.<TailLogEntriesRequest, TailLogEntriesResponse>newBuilder()
                .setMethodDescriptor(tailLogEntriesMethodDescriptor)
                .build();

    this.deleteLogCallable =
        callableFactory.createUnaryCallable(
            deleteLogTransportSettings, settings.deleteLogSettings(), clientContext);
    this.writeLogEntriesCallable =
        callableFactory.createUnaryCallable(
            writeLogEntriesTransportSettings, settings.writeLogEntriesSettings(), clientContext);
    this.listLogEntriesCallable =
        callableFactory.createUnaryCallable(
            listLogEntriesTransportSettings, settings.listLogEntriesSettings(), clientContext);
    this.listLogEntriesPagedCallable =
        callableFactory.createPagedCallable(
            listLogEntriesTransportSettings, settings.listLogEntriesSettings(), clientContext);
    this.listMonitoredResourceDescriptorsCallable =
        callableFactory.createUnaryCallable(
            listMonitoredResourceDescriptorsTransportSettings,
            settings.listMonitoredResourceDescriptorsSettings(),
            clientContext);
    this.listMonitoredResourceDescriptorsPagedCallable =
        callableFactory.createPagedCallable(
            listMonitoredResourceDescriptorsTransportSettings,
            settings.listMonitoredResourceDescriptorsSettings(),
            clientContext);
    this.listLogsCallable =
        callableFactory.createUnaryCallable(
            listLogsTransportSettings, settings.listLogsSettings(), clientContext);
    this.listLogsPagedCallable =
        callableFactory.createPagedCallable(
            listLogsTransportSettings, settings.listLogsSettings(), clientContext);
    this.tailLogEntriesCallable =
        callableFactory.createBidiStreamingCallable(
            tailLogEntriesTransportSettings, settings.tailLogEntriesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<DeleteLogRequest, Empty> deleteLogCallable() {
    return deleteLogCallable;
  }

  @Override
  public UnaryCallable<WriteLogEntriesRequest, WriteLogEntriesResponse> writeLogEntriesCallable() {
    return writeLogEntriesCallable;
  }

  @Override
  public UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse> listLogEntriesCallable() {
    return listLogEntriesCallable;
  }

  @Override
  public UnaryCallable<ListLogEntriesRequest, ListLogEntriesPagedResponse>
      listLogEntriesPagedCallable() {
    return listLogEntriesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse>
      listMonitoredResourceDescriptorsCallable() {
    return listMonitoredResourceDescriptorsCallable;
  }

  @Override
  public UnaryCallable<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsPagedCallable() {
    return listMonitoredResourceDescriptorsPagedCallable;
  }

  @Override
  public UnaryCallable<ListLogsRequest, ListLogsResponse> listLogsCallable() {
    return listLogsCallable;
  }

  @Override
  public UnaryCallable<ListLogsRequest, ListLogsPagedResponse> listLogsPagedCallable() {
    return listLogsPagedCallable;
  }

  @Override
  public BidiStreamingCallable<TailLogEntriesRequest, TailLogEntriesResponse>
      tailLogEntriesCallable() {
    return tailLogEntriesCallable;
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
