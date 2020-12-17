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

package com.google.cloud.bigquery.storage.v1alpha2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1alpha2.Storage;
import com.google.cloud.bigquery.storage.v1alpha2.Stream;
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
  private static final MethodDescriptor<Storage.CreateWriteStreamRequest, Stream.WriteStream>
      createWriteStreamMethodDescriptor =
          MethodDescriptor.<Storage.CreateWriteStreamRequest, Stream.WriteStream>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1alpha2.BigQueryWrite/CreateWriteStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Storage.CreateWriteStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Stream.WriteStream.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Storage.AppendRowsRequest, Storage.AppendRowsResponse>
      appendRowsMethodDescriptor =
          MethodDescriptor.<Storage.AppendRowsRequest, Storage.AppendRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.bigquery.storage.v1alpha2.BigQueryWrite/AppendRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Storage.AppendRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(Storage.AppendRowsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Storage.GetWriteStreamRequest, Stream.WriteStream>
      getWriteStreamMethodDescriptor =
          MethodDescriptor.<Storage.GetWriteStreamRequest, Stream.WriteStream>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1alpha2.BigQueryWrite/GetWriteStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Storage.GetWriteStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Stream.WriteStream.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
      finalizeWriteStreamMethodDescriptor =
          MethodDescriptor
              .<Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1alpha2.BigQueryWrite/FinalizeWriteStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Storage.FinalizeWriteStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(Storage.FinalizeWriteStreamResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsMethodDescriptor =
          MethodDescriptor
              .<Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1alpha2.BigQueryWrite/BatchCommitWriteStreams")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      Storage.BatchCommitWriteStreamsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      Storage.BatchCommitWriteStreamsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Storage.FlushRowsRequest, Storage.FlushRowsResponse>
      flushRowsMethodDescriptor =
          MethodDescriptor.<Storage.FlushRowsRequest, Storage.FlushRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.storage.v1alpha2.BigQueryWrite/FlushRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Storage.FlushRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(Storage.FlushRowsResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<Storage.CreateWriteStreamRequest, Stream.WriteStream>
      createWriteStreamCallable;
  private final BidiStreamingCallable<Storage.AppendRowsRequest, Storage.AppendRowsResponse>
      appendRowsCallable;
  private final UnaryCallable<Storage.GetWriteStreamRequest, Stream.WriteStream>
      getWriteStreamCallable;
  private final UnaryCallable<
          Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
      finalizeWriteStreamCallable;
  private final UnaryCallable<
          Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsCallable;
  private final UnaryCallable<Storage.FlushRowsRequest, Storage.FlushRowsResponse>
      flushRowsCallable;

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

    GrpcCallSettings<Storage.CreateWriteStreamRequest, Stream.WriteStream>
        createWriteStreamTransportSettings =
            GrpcCallSettings.<Storage.CreateWriteStreamRequest, Stream.WriteStream>newBuilder()
                .setMethodDescriptor(createWriteStreamMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<Storage.CreateWriteStreamRequest>() {
                      @Override
                      public Map<String, String> extract(Storage.CreateWriteStreamRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<Storage.AppendRowsRequest, Storage.AppendRowsResponse>
        appendRowsTransportSettings =
            GrpcCallSettings.<Storage.AppendRowsRequest, Storage.AppendRowsResponse>newBuilder()
                .setMethodDescriptor(appendRowsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<Storage.AppendRowsRequest>() {
                      @Override
                      public Map<String, String> extract(Storage.AppendRowsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("write_stream", String.valueOf(request.getWriteStream()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<Storage.GetWriteStreamRequest, Stream.WriteStream>
        getWriteStreamTransportSettings =
            GrpcCallSettings.<Storage.GetWriteStreamRequest, Stream.WriteStream>newBuilder()
                .setMethodDescriptor(getWriteStreamMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<Storage.GetWriteStreamRequest>() {
                      @Override
                      public Map<String, String> extract(Storage.GetWriteStreamRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
        finalizeWriteStreamTransportSettings =
            GrpcCallSettings
                .<Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
                    newBuilder()
                .setMethodDescriptor(finalizeWriteStreamMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<Storage.FinalizeWriteStreamRequest>() {
                      @Override
                      public Map<String, String> extract(
                          Storage.FinalizeWriteStreamRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<
            Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
        batchCommitWriteStreamsTransportSettings =
            GrpcCallSettings
                .<Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCommitWriteStreamsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<Storage.BatchCommitWriteStreamsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          Storage.BatchCommitWriteStreamsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<Storage.FlushRowsRequest, Storage.FlushRowsResponse>
        flushRowsTransportSettings =
            GrpcCallSettings.<Storage.FlushRowsRequest, Storage.FlushRowsResponse>newBuilder()
                .setMethodDescriptor(flushRowsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<Storage.FlushRowsRequest>() {
                      @Override
                      public Map<String, String> extract(Storage.FlushRowsRequest request) {
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

  public UnaryCallable<Storage.CreateWriteStreamRequest, Stream.WriteStream>
      createWriteStreamCallable() {
    return createWriteStreamCallable;
  }

  public BidiStreamingCallable<Storage.AppendRowsRequest, Storage.AppendRowsResponse>
      appendRowsCallable() {
    return appendRowsCallable;
  }

  public UnaryCallable<Storage.GetWriteStreamRequest, Stream.WriteStream> getWriteStreamCallable() {
    return getWriteStreamCallable;
  }

  public UnaryCallable<Storage.FinalizeWriteStreamRequest, Storage.FinalizeWriteStreamResponse>
      finalizeWriteStreamCallable() {
    return finalizeWriteStreamCallable;
  }

  public UnaryCallable<
          Storage.BatchCommitWriteStreamsRequest, Storage.BatchCommitWriteStreamsResponse>
      batchCommitWriteStreamsCallable() {
    return batchCommitWriteStreamsCallable;
  }

  public UnaryCallable<Storage.FlushRowsRequest, Storage.FlushRowsResponse> flushRowsCallable() {
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
