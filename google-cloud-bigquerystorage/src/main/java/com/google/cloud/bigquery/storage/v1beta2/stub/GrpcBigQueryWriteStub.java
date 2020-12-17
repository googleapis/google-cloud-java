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

package com.google.cloud.bigquery.storage.v1beta2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1beta2.AppendRowsRequest;
import com.google.cloud.bigquery.storage.v1beta2.AppendRowsResponse;
import com.google.cloud.bigquery.storage.v1beta2.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1beta2.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1beta2.CreateWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1beta2.FinalizeWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1beta2.FinalizeWriteStreamResponse;
import com.google.cloud.bigquery.storage.v1beta2.FlushRowsRequest;
import com.google.cloud.bigquery.storage.v1beta2.FlushRowsResponse;
import com.google.cloud.bigquery.storage.v1beta2.GetWriteStreamRequest;
import com.google.cloud.bigquery.storage.v1beta2.WriteStream;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the BigQueryWrite service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBigQueryWriteStub extends BigQueryWriteStub {
  private static final MethodDescriptor<CreateWriteStreamRequest, WriteStream>
      createWriteStreamMethodDescriptor =
          MethodDescriptor.<CreateWriteStreamRequest, WriteStream>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta2.BigQueryWrite/CreateWriteStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateWriteStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WriteStream.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AppendRowsRequest, AppendRowsResponse>
      appendRowsMethodDescriptor =
          MethodDescriptor.<AppendRowsRequest, AppendRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.bigquery.storage.v1beta2.BigQueryWrite/AppendRows")
              .setRequestMarshaller(ProtoUtils.marshaller(AppendRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AppendRowsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetWriteStreamRequest, WriteStream>
      getWriteStreamMethodDescriptor =
          MethodDescriptor.<GetWriteStreamRequest, WriteStream>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta2.BigQueryWrite/GetWriteStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetWriteStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(WriteStream.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FinalizeWriteStreamRequest, FinalizeWriteStreamResponse>
      finalizeWriteStreamMethodDescriptor =
          MethodDescriptor.<FinalizeWriteStreamRequest, FinalizeWriteStreamResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta2.BigQueryWrite/FinalizeWriteStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FinalizeWriteStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FinalizeWriteStreamResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          BatchCommitWriteStreamsRequest, BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsMethodDescriptor =
          MethodDescriptor
              .<BatchCommitWriteStreamsRequest, BatchCommitWriteStreamsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta2.BigQueryWrite/BatchCommitWriteStreams")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCommitWriteStreamsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCommitWriteStreamsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FlushRowsRequest, FlushRowsResponse>
      flushRowsMethodDescriptor =
          MethodDescriptor.<FlushRowsRequest, FlushRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.storage.v1beta2.BigQueryWrite/FlushRows")
              .setRequestMarshaller(ProtoUtils.marshaller(FlushRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FlushRowsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateWriteStreamRequest, WriteStream> createWriteStreamCallable;
  private final BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> appendRowsCallable;
  private final UnaryCallable<GetWriteStreamRequest, WriteStream> getWriteStreamCallable;
  private final UnaryCallable<FinalizeWriteStreamRequest, FinalizeWriteStreamResponse>
      finalizeWriteStreamCallable;
  private final UnaryCallable<BatchCommitWriteStreamsRequest, BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsCallable;
  private final UnaryCallable<FlushRowsRequest, FlushRowsResponse> flushRowsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBigQueryWriteStub create(BigQueryWriteStubSettings settings)
      throws IOException {
    return new GrpcBigQueryWriteStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigQueryWriteStub create(ClientContext clientContext) throws IOException {
    return new GrpcBigQueryWriteStub(BigQueryWriteStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBigQueryWriteStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBigQueryWriteStub(
        BigQueryWriteStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBigQueryWriteStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBigQueryWriteStub(BigQueryWriteStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBigQueryWriteCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBigQueryWriteStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBigQueryWriteStub(
      BigQueryWriteStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateWriteStreamRequest, WriteStream> createWriteStreamTransportSettings =
        GrpcCallSettings.<CreateWriteStreamRequest, WriteStream>newBuilder()
            .setMethodDescriptor(createWriteStreamMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateWriteStreamRequest>() {
                  @Override
                  public Map<String, String> extract(CreateWriteStreamRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<AppendRowsRequest, AppendRowsResponse> appendRowsTransportSettings =
        GrpcCallSettings.<AppendRowsRequest, AppendRowsResponse>newBuilder()
            .setMethodDescriptor(appendRowsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<AppendRowsRequest>() {
                  @Override
                  public Map<String, String> extract(AppendRowsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("write_stream", String.valueOf(request.getWriteStream()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetWriteStreamRequest, WriteStream> getWriteStreamTransportSettings =
        GrpcCallSettings.<GetWriteStreamRequest, WriteStream>newBuilder()
            .setMethodDescriptor(getWriteStreamMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetWriteStreamRequest>() {
                  @Override
                  public Map<String, String> extract(GetWriteStreamRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<FinalizeWriteStreamRequest, FinalizeWriteStreamResponse>
        finalizeWriteStreamTransportSettings =
            GrpcCallSettings.<FinalizeWriteStreamRequest, FinalizeWriteStreamResponse>newBuilder()
                .setMethodDescriptor(finalizeWriteStreamMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<FinalizeWriteStreamRequest>() {
                      @Override
                      public Map<String, String> extract(FinalizeWriteStreamRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<BatchCommitWriteStreamsRequest, BatchCommitWriteStreamsResponse>
        batchCommitWriteStreamsTransportSettings =
            GrpcCallSettings
                .<BatchCommitWriteStreamsRequest, BatchCommitWriteStreamsResponse>newBuilder()
                .setMethodDescriptor(batchCommitWriteStreamsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchCommitWriteStreamsRequest>() {
                      @Override
                      public Map<String, String> extract(BatchCommitWriteStreamsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<FlushRowsRequest, FlushRowsResponse> flushRowsTransportSettings =
        GrpcCallSettings.<FlushRowsRequest, FlushRowsResponse>newBuilder()
            .setMethodDescriptor(flushRowsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<FlushRowsRequest>() {
                  @Override
                  public Map<String, String> extract(FlushRowsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("write_stream", String.valueOf(request.getWriteStream()));
                    return params.build();
                  }
                })
            .build();

    this.createWriteStreamCallable =
        callableFactory.createUnaryCallable(
            createWriteStreamTransportSettings,
            settings.createWriteStreamSettings(),
            clientContext);
    this.appendRowsCallable =
        callableFactory.createBidiStreamingCallable(
            appendRowsTransportSettings, settings.appendRowsSettings(), clientContext);
    this.getWriteStreamCallable =
        callableFactory.createUnaryCallable(
            getWriteStreamTransportSettings, settings.getWriteStreamSettings(), clientContext);
    this.finalizeWriteStreamCallable =
        callableFactory.createUnaryCallable(
            finalizeWriteStreamTransportSettings,
            settings.finalizeWriteStreamSettings(),
            clientContext);
    this.batchCommitWriteStreamsCallable =
        callableFactory.createUnaryCallable(
            batchCommitWriteStreamsTransportSettings,
            settings.batchCommitWriteStreamsSettings(),
            clientContext);
    this.flushRowsCallable =
        callableFactory.createUnaryCallable(
            flushRowsTransportSettings, settings.flushRowsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateWriteStreamRequest, WriteStream> createWriteStreamCallable() {
    return createWriteStreamCallable;
  }

  public BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> appendRowsCallable() {
    return appendRowsCallable;
  }

  public UnaryCallable<GetWriteStreamRequest, WriteStream> getWriteStreamCallable() {
    return getWriteStreamCallable;
  }

  public UnaryCallable<FinalizeWriteStreamRequest, FinalizeWriteStreamResponse>
      finalizeWriteStreamCallable() {
    return finalizeWriteStreamCallable;
  }

  public UnaryCallable<BatchCommitWriteStreamsRequest, BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsCallable() {
    return batchCommitWriteStreamsCallable;
  }

  public UnaryCallable<FlushRowsRequest, FlushRowsResponse> flushRowsCallable() {
    return flushRowsCallable;
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
