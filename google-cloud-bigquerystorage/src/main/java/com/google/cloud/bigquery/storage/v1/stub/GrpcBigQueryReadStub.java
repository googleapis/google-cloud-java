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

package com.google.cloud.bigquery.storage.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.storage.v1.CreateReadSessionRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsRequest;
import com.google.cloud.bigquery.storage.v1.ReadRowsResponse;
import com.google.cloud.bigquery.storage.v1.ReadSession;
import com.google.cloud.bigquery.storage.v1.SplitReadStreamRequest;
import com.google.cloud.bigquery.storage.v1.SplitReadStreamResponse;
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
 * gRPC stub implementation for the BigQueryRead service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcBigQueryReadStub extends BigQueryReadStub {
  private static final MethodDescriptor<CreateReadSessionRequest, ReadSession>
      createReadSessionMethodDescriptor =
          MethodDescriptor.<CreateReadSessionRequest, ReadSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.storage.v1.BigQueryRead/CreateReadSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateReadSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReadSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReadRowsRequest, ReadRowsResponse>
      readRowsMethodDescriptor =
          MethodDescriptor.<ReadRowsRequest, ReadRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.cloud.bigquery.storage.v1.BigQueryRead/ReadRows")
              .setRequestMarshaller(ProtoUtils.marshaller(ReadRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReadRowsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SplitReadStreamRequest, SplitReadStreamResponse>
      splitReadStreamMethodDescriptor =
          MethodDescriptor.<SplitReadStreamRequest, SplitReadStreamResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.bigquery.storage.v1.BigQueryRead/SplitReadStream")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SplitReadStreamRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SplitReadStreamResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<CreateReadSessionRequest, ReadSession> createReadSessionCallable;
  private final ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable;
  private final UnaryCallable<SplitReadStreamRequest, SplitReadStreamResponse>
      splitReadStreamCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcBigQueryReadStub create(BigQueryReadStubSettings settings)
      throws IOException {
    return new GrpcBigQueryReadStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigQueryReadStub create(ClientContext clientContext) throws IOException {
    return new GrpcBigQueryReadStub(BigQueryReadStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBigQueryReadStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBigQueryReadStub(
        BigQueryReadStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBigQueryReadStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBigQueryReadStub(BigQueryReadStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBigQueryReadCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBigQueryReadStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcBigQueryReadStub(
      BigQueryReadStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateReadSessionRequest, ReadSession> createReadSessionTransportSettings =
        GrpcCallSettings.<CreateReadSessionRequest, ReadSession>newBuilder()
            .setMethodDescriptor(createReadSessionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateReadSessionRequest>() {
                  @Override
                  public Map<String, String> extract(CreateReadSessionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "read_session.table", String.valueOf(request.getReadSession().getTable()));
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
                    params.put("read_stream", String.valueOf(request.getReadStream()));
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
                        params.put("name", String.valueOf(request.getName()));
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
    this.splitReadStreamCallable =
        callableFactory.createUnaryCallable(
            splitReadStreamTransportSettings, settings.splitReadStreamSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<CreateReadSessionRequest, ReadSession> createReadSessionCallable() {
    return createReadSessionCallable;
  }

  public ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable() {
    return readRowsCallable;
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
