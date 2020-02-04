/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigquery.storage.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.BatchCreateReadSessionStreamsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.FinalizeStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1beta1.Storage.ReadSession;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1beta1.Storage.SplitReadStreamResponse;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for BigQuery Storage API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcBigQueryStorageStub extends BigQueryStorageStub {

  private static final MethodDescriptor<CreateReadSessionRequest, ReadSession>
      createReadSessionMethodDescriptor =
          MethodDescriptor.<CreateReadSessionRequest, ReadSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta1.BigQueryStorage/CreateReadSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReadSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReadSession.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ReadRowsRequest, ReadRowsResponse>
      readRowsMethodDescriptor =
          MethodDescriptor.<ReadRowsRequest, ReadRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.cloud.bigquery.storage.v1beta1.BigQueryStorage/ReadRows")
              .setRequestMarshaller(ProtoUtils.marshaller(ReadRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReadRowsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<
          BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsMethodDescriptor =
          MethodDescriptor
              .<BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta1.BigQueryStorage/BatchCreateReadSessionStreams")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateReadSessionStreamsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateReadSessionStreamsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<FinalizeStreamRequest, Empty>
      finalizeStreamMethodDescriptor =
          MethodDescriptor.<FinalizeStreamRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta1.BigQueryStorage/FinalizeStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FinalizeStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<SplitReadStreamRequest, SplitReadStreamResponse>
      splitReadStreamMethodDescriptor =
          MethodDescriptor.<SplitReadStreamRequest, SplitReadStreamResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta1.BigQueryStorage/SplitReadStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SplitReadStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SplitReadStreamResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<CreateReadSessionRequest, ReadSession> createReadSessionCallable;
  private final ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable;
  private final UnaryCallable<
          BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsCallable;
  private final UnaryCallable<FinalizeStreamRequest, Empty> finalizeStreamCallable;
  private final UnaryCallable<SplitReadStreamRequest, SplitReadStreamResponse>
      splitReadStreamCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBigQueryStorageStub create(BigQueryStorageStubSettings settings)
      throws IOException {
    return new GrpcBigQueryStorageStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigQueryStorageStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcBigQueryStorageStub(
        BigQueryStorageStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBigQueryStorageStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBigQueryStorageStub(
        BigQueryStorageStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBigQueryStorageStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBigQueryStorageStub(
      BigQueryStorageStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcBigQueryStorageCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBigQueryStorageStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBigQueryStorageStub(
      BigQueryStorageStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<CreateReadSessionRequest, ReadSession> createReadSessionTransportSettings =
        GrpcCallSettings.<CreateReadSessionRequest, ReadSession>newBuilder()
            .setMethodDescriptor(createReadSessionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateReadSessionRequest>() {
                  @Override
                  public Map<String, String> extract(CreateReadSessionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "table_reference.project_id",
                        String.valueOf(request.getTableReference().getProjectId()));
                    params.put(
                        "table_reference.dataset_id",
                        String.valueOf(request.getTableReference().getDatasetId()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ReadRowsRequest, ReadRowsResponse> readRowsTransportSettings =
        GrpcCallSettings.<ReadRowsRequest, ReadRowsResponse>newBuilder()
            .setMethodDescriptor(readRowsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ReadRowsRequest>() {
                  @Override
                  public Map<String, String> extract(ReadRowsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "read_position.stream.name",
                        String.valueOf(request.getReadPosition().getStream().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
        batchCreateReadSessionStreamsTransportSettings =
            GrpcCallSettings
                .<BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateReadSessionStreamsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchCreateReadSessionStreamsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          BatchCreateReadSessionStreamsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("session.name", String.valueOf(request.getSession().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<FinalizeStreamRequest, Empty> finalizeStreamTransportSettings =
        GrpcCallSettings.<FinalizeStreamRequest, Empty>newBuilder()
            .setMethodDescriptor(finalizeStreamMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<FinalizeStreamRequest>() {
                  @Override
                  public Map<String, String> extract(FinalizeStreamRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("stream.name", String.valueOf(request.getStream().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<SplitReadStreamRequest, SplitReadStreamResponse>
        splitReadStreamTransportSettings =
            GrpcCallSettings.<SplitReadStreamRequest, SplitReadStreamResponse>newBuilder()
                .setMethodDescriptor(splitReadStreamMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<SplitReadStreamRequest>() {
                      @Override
                      public Map<String, String> extract(SplitReadStreamRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "original_stream.name",
                            String.valueOf(request.getOriginalStream().getName()));
                        return params.build();
                      }
                    })
                .build();

    this.createReadSessionCallable =
        callableFactory.createUnaryCallable(
            createReadSessionTransportSettings,
            settings.createReadSessionSettings(),
            clientContext);
    this.readRowsCallable =
        callableFactory.createServerStreamingCallable(
            readRowsTransportSettings, settings.readRowsSettings(), clientContext);
    this.batchCreateReadSessionStreamsCallable =
        callableFactory.createUnaryCallable(
            batchCreateReadSessionStreamsTransportSettings,
            settings.batchCreateReadSessionStreamsSettings(),
            clientContext);
    this.finalizeStreamCallable =
        callableFactory.createUnaryCallable(
            finalizeStreamTransportSettings, settings.finalizeStreamSettings(), clientContext);
    this.splitReadStreamCallable =
        callableFactory.createUnaryCallable(
            splitReadStreamTransportSettings, settings.splitReadStreamSettings(), clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<CreateReadSessionRequest, ReadSession> createReadSessionCallable() {
    return createReadSessionCallable;
  }

  public ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable() {
    return readRowsCallable;
  }

  public UnaryCallable<BatchCreateReadSessionStreamsRequest, BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsCallable() {
    return batchCreateReadSessionStreamsCallable;
  }

  public UnaryCallable<FinalizeStreamRequest, Empty> finalizeStreamCallable() {
    return finalizeStreamCallable;
  }

  public UnaryCallable<SplitReadStreamRequest, SplitReadStreamResponse> splitReadStreamCallable() {
    return splitReadStreamCallable;
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
