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

package com.google.cloud.bigquery.storage.v1beta1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1beta1.Storage;
import com.google.common.collect.ImmutableMap;
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
 * gRPC stub implementation for the BigQueryStorage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBigQueryStorageStub extends BigQueryStorageStub {
  private static final MethodDescriptor<Storage.CreateReadSessionRequest, Storage.ReadSession>
      createReadSessionMethodDescriptor =
          MethodDescriptor.<Storage.CreateReadSessionRequest, Storage.ReadSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta1.BigQueryStorage/CreateReadSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Storage.CreateReadSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(Storage.ReadSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Storage.ReadRowsRequest, Storage.ReadRowsResponse>
      readRowsMethodDescriptor =
          MethodDescriptor.<Storage.ReadRowsRequest, Storage.ReadRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.cloud.bigquery.storage.v1beta1.BigQueryStorage/ReadRows")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Storage.ReadRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(Storage.ReadRowsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          Storage.BatchCreateReadSessionStreamsRequest,
          Storage.BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsMethodDescriptor =
          MethodDescriptor
              .<Storage.BatchCreateReadSessionStreamsRequest,
                  Storage.BatchCreateReadSessionStreamsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta1.BigQueryStorage/BatchCreateReadSessionStreams")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      Storage.BatchCreateReadSessionStreamsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      Storage.BatchCreateReadSessionStreamsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<Storage.FinalizeStreamRequest, Empty>
      finalizeStreamMethodDescriptor =
          MethodDescriptor.<Storage.FinalizeStreamRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta1.BigQueryStorage/FinalizeStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Storage.FinalizeStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
      splitReadStreamMethodDescriptor =
          MethodDescriptor
              .<Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.bigquery.storage.v1beta1.BigQueryStorage/SplitReadStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(Storage.SplitReadStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(Storage.SplitReadStreamResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<Storage.CreateReadSessionRequest, Storage.ReadSession>
      createReadSessionCallable;
  private final ServerStreamingCallable<Storage.ReadRowsRequest, Storage.ReadRowsResponse>
      readRowsCallable;
  private final UnaryCallable<
          Storage.BatchCreateReadSessionStreamsRequest,
          Storage.BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsCallable;
  private final UnaryCallable<Storage.FinalizeStreamRequest, Empty> finalizeStreamCallable;
  private final UnaryCallable<Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
      splitReadStreamCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
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
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<Storage.CreateReadSessionRequest, Storage.ReadSession>
        createReadSessionTransportSettings =
            GrpcCallSettings.<Storage.CreateReadSessionRequest, Storage.ReadSession>newBuilder()
                .setMethodDescriptor(createReadSessionMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<Storage.CreateReadSessionRequest>() {
                      @Override
                      public Map<String, String> extract(Storage.CreateReadSessionRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "table_reference.dataset_id",
                            String.valueOf(request.getTableReference().getDatasetId()));
                        params.put(
                            "table_reference.project_id",
                            String.valueOf(request.getTableReference().getProjectId()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<Storage.ReadRowsRequest, Storage.ReadRowsResponse> readRowsTransportSettings =
        GrpcCallSettings.<Storage.ReadRowsRequest, Storage.ReadRowsResponse>newBuilder()
            .setMethodDescriptor(readRowsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<Storage.ReadRowsRequest>() {
                  @Override
                  public Map<String, String> extract(Storage.ReadRowsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "read_position.stream.name",
                        String.valueOf(request.getReadPosition().getStream().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<
            Storage.BatchCreateReadSessionStreamsRequest,
            Storage.BatchCreateReadSessionStreamsResponse>
        batchCreateReadSessionStreamsTransportSettings =
            GrpcCallSettings
                .<Storage.BatchCreateReadSessionStreamsRequest,
                    Storage.BatchCreateReadSessionStreamsResponse>
                    newBuilder()
                .setMethodDescriptor(batchCreateReadSessionStreamsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<Storage.BatchCreateReadSessionStreamsRequest>() {
                      @Override
                      public Map<String, String> extract(
                          Storage.BatchCreateReadSessionStreamsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("session.name", String.valueOf(request.getSession().getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<Storage.FinalizeStreamRequest, Empty> finalizeStreamTransportSettings =
        GrpcCallSettings.<Storage.FinalizeStreamRequest, Empty>newBuilder()
            .setMethodDescriptor(finalizeStreamMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<Storage.FinalizeStreamRequest>() {
                  @Override
                  public Map<String, String> extract(Storage.FinalizeStreamRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("stream.name", String.valueOf(request.getStream().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
        splitReadStreamTransportSettings =
            GrpcCallSettings
                .<Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>newBuilder()
                .setMethodDescriptor(splitReadStreamMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<Storage.SplitReadStreamRequest>() {
                      @Override
                      public Map<String, String> extract(Storage.SplitReadStreamRequest request) {
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<Storage.CreateReadSessionRequest, Storage.ReadSession>
      createReadSessionCallable() {
    return createReadSessionCallable;
  }

  public ServerStreamingCallable<Storage.ReadRowsRequest, Storage.ReadRowsResponse>
      readRowsCallable() {
    return readRowsCallable;
  }

  public UnaryCallable<
          Storage.BatchCreateReadSessionStreamsRequest,
          Storage.BatchCreateReadSessionStreamsResponse>
      batchCreateReadSessionStreamsCallable() {
    return batchCreateReadSessionStreamsCallable;
  }

  public UnaryCallable<Storage.FinalizeStreamRequest, Empty> finalizeStreamCallable() {
    return finalizeStreamCallable;
  }

  public UnaryCallable<Storage.SplitReadStreamRequest, Storage.SplitReadStreamResponse>
      splitReadStreamCallable() {
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
