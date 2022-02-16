/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.bigtable.v2.CheckAndMutateRowRequest;
import com.google.bigtable.v2.CheckAndMutateRowResponse;
import com.google.bigtable.v2.MutateRowRequest;
import com.google.bigtable.v2.MutateRowResponse;
import com.google.bigtable.v2.MutateRowsRequest;
import com.google.bigtable.v2.MutateRowsResponse;
import com.google.bigtable.v2.PingAndWarmRequest;
import com.google.bigtable.v2.PingAndWarmResponse;
import com.google.bigtable.v2.ReadModifyWriteRowRequest;
import com.google.bigtable.v2.ReadModifyWriteRowResponse;
import com.google.bigtable.v2.ReadRowsRequest;
import com.google.bigtable.v2.ReadRowsResponse;
import com.google.bigtable.v2.SampleRowKeysRequest;
import com.google.bigtable.v2.SampleRowKeysResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** For internal use only. */
@Generated("by gapic-generator")
@InternalApi
public class GrpcBigtableStub extends BigtableStub {
  private static final MethodDescriptor<ReadRowsRequest, ReadRowsResponse>
      readRowsMethodDescriptor =
          MethodDescriptor.<ReadRowsRequest, ReadRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.bigtable.v2.Bigtable/ReadRows")
              .setRequestMarshaller(ProtoUtils.marshaller(ReadRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ReadRowsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SampleRowKeysRequest, SampleRowKeysResponse>
      sampleRowKeysMethodDescriptor =
          MethodDescriptor.<SampleRowKeysRequest, SampleRowKeysResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.bigtable.v2.Bigtable/SampleRowKeys")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SampleRowKeysRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SampleRowKeysResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MutateRowRequest, MutateRowResponse>
      mutateRowMethodDescriptor =
          MethodDescriptor.<MutateRowRequest, MutateRowResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.v2.Bigtable/MutateRow")
              .setRequestMarshaller(ProtoUtils.marshaller(MutateRowRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MutateRowResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<MutateRowsRequest, MutateRowsResponse>
      mutateRowsMethodDescriptor =
          MethodDescriptor.<MutateRowsRequest, MutateRowsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName("google.bigtable.v2.Bigtable/MutateRows")
              .setRequestMarshaller(ProtoUtils.marshaller(MutateRowsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(MutateRowsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
      checkAndMutateRowMethodDescriptor =
          MethodDescriptor.<CheckAndMutateRowRequest, CheckAndMutateRowResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.v2.Bigtable/CheckAndMutateRow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CheckAndMutateRowRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CheckAndMutateRowResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<PingAndWarmRequest, PingAndWarmResponse>
      pingAndWarmMethodDescriptor =
          MethodDescriptor.<PingAndWarmRequest, PingAndWarmResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.v2.Bigtable/PingAndWarm")
              .setRequestMarshaller(ProtoUtils.marshaller(PingAndWarmRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PingAndWarmResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
      readModifyWriteRowMethodDescriptor =
          MethodDescriptor.<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.bigtable.v2.Bigtable/ReadModifyWriteRow")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReadModifyWriteRowRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReadModifyWriteRowResponse.getDefaultInstance()))
              .build();

  private final ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable;
  private final ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse>
      sampleRowKeysCallable;
  private final UnaryCallable<MutateRowRequest, MutateRowResponse> mutateRowCallable;
  private final ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> mutateRowsCallable;
  private final UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
      checkAndMutateRowCallable;
  private final UnaryCallable<PingAndWarmRequest, PingAndWarmResponse> pingAndWarmCallable;
  private final UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
      readModifyWriteRowCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  private static final PathTemplate READ_ROWS_0_PATH_TEMPLATE =
      PathTemplate.create("{table_name=projects/*/instances/*/tables/*}");
  private static final PathTemplate READ_ROWS_1_PATH_TEMPLATE =
      PathTemplate.create("{app_profile_id=**}");
  private static final PathTemplate SAMPLE_ROW_KEYS_0_PATH_TEMPLATE =
      PathTemplate.create("{table_name=projects/*/instances/*/tables/*}");
  private static final PathTemplate SAMPLE_ROW_KEYS_1_PATH_TEMPLATE =
      PathTemplate.create("{app_profile_id=**}");
  private static final PathTemplate MUTATE_ROW_0_PATH_TEMPLATE =
      PathTemplate.create("{table_name=projects/*/instances/*/tables/*}");
  private static final PathTemplate MUTATE_ROW_1_PATH_TEMPLATE =
      PathTemplate.create("{app_profile_id=**}");
  private static final PathTemplate MUTATE_ROWS_0_PATH_TEMPLATE =
      PathTemplate.create("{table_name=projects/*/instances/*/tables/*}");
  private static final PathTemplate MUTATE_ROWS_1_PATH_TEMPLATE =
      PathTemplate.create("{app_profile_id=**}");
  private static final PathTemplate CHECK_AND_MUTATE_ROW_0_PATH_TEMPLATE =
      PathTemplate.create("{table_name=projects/*/instances/*/tables/*}");
  private static final PathTemplate CHECK_AND_MUTATE_ROW_1_PATH_TEMPLATE =
      PathTemplate.create("{app_profile_id=**}");
  private static final PathTemplate PING_AND_WARM_0_PATH_TEMPLATE =
      PathTemplate.create("{name=projects/*/instances/*}");
  private static final PathTemplate PING_AND_WARM_1_PATH_TEMPLATE =
      PathTemplate.create("{app_profile_id=**}");
  private static final PathTemplate READ_MODIFY_WRITE_ROW_0_PATH_TEMPLATE =
      PathTemplate.create("{table_name=projects/*/instances/*/tables/*}");
  private static final PathTemplate READ_MODIFY_WRITE_ROW_1_PATH_TEMPLATE =
      PathTemplate.create("{app_profile_id=**}");

  public static final GrpcBigtableStub create(BigtableStubSettings settings) throws IOException {
    return new GrpcBigtableStub(settings, ClientContext.create(settings));
  }

  public static final GrpcBigtableStub create(ClientContext clientContext) throws IOException {
    return new GrpcBigtableStub(BigtableStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcBigtableStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcBigtableStub(
        BigtableStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcBigtableStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcBigtableStub(BigtableStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcBigtableCallableFactory());
  }

  /**
   * Constructs an instance of GrpcBigtableStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcBigtableStub(
      BigtableStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ReadRowsRequest, ReadRowsResponse> readRowsTransportSettings =
        GrpcCallSettings.<ReadRowsRequest, ReadRowsResponse>newBuilder()
            .setMethodDescriptor(readRowsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getTableName(), "table_name", READ_ROWS_0_PATH_TEMPLATE);
                  builder.add(
                      request.getAppProfileId(), "app_profile_id", READ_ROWS_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SampleRowKeysRequest, SampleRowKeysResponse> sampleRowKeysTransportSettings =
        GrpcCallSettings.<SampleRowKeysRequest, SampleRowKeysResponse>newBuilder()
            .setMethodDescriptor(sampleRowKeysMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      request.getTableName(), "table_name", SAMPLE_ROW_KEYS_0_PATH_TEMPLATE);
                  builder.add(
                      request.getAppProfileId(), "app_profile_id", SAMPLE_ROW_KEYS_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MutateRowRequest, MutateRowResponse> mutateRowTransportSettings =
        GrpcCallSettings.<MutateRowRequest, MutateRowResponse>newBuilder()
            .setMethodDescriptor(mutateRowMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getTableName(), "table_name", MUTATE_ROW_0_PATH_TEMPLATE);
                  builder.add(
                      request.getAppProfileId(), "app_profile_id", MUTATE_ROW_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<MutateRowsRequest, MutateRowsResponse> mutateRowsTransportSettings =
        GrpcCallSettings.<MutateRowsRequest, MutateRowsResponse>newBuilder()
            .setMethodDescriptor(mutateRowsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getTableName(), "table_name", MUTATE_ROWS_0_PATH_TEMPLATE);
                  builder.add(
                      request.getAppProfileId(), "app_profile_id", MUTATE_ROWS_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
        checkAndMutateRowTransportSettings =
            GrpcCallSettings.<CheckAndMutateRowRequest, CheckAndMutateRowResponse>newBuilder()
                .setMethodDescriptor(checkAndMutateRowMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getTableName(),
                          "table_name",
                          CHECK_AND_MUTATE_ROW_0_PATH_TEMPLATE);
                      builder.add(
                          request.getAppProfileId(),
                          "app_profile_id",
                          CHECK_AND_MUTATE_ROW_1_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<PingAndWarmRequest, PingAndWarmResponse> pingAndWarmTransportSettings =
        GrpcCallSettings.<PingAndWarmRequest, PingAndWarmResponse>newBuilder()
            .setMethodDescriptor(pingAndWarmMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(request.getName(), "name", PING_AND_WARM_0_PATH_TEMPLATE);
                  builder.add(
                      request.getAppProfileId(), "app_profile_id", PING_AND_WARM_1_PATH_TEMPLATE);
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
        readModifyWriteRowTransportSettings =
            GrpcCallSettings.<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>newBuilder()
                .setMethodDescriptor(readModifyWriteRowMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          request.getTableName(),
                          "table_name",
                          READ_MODIFY_WRITE_ROW_0_PATH_TEMPLATE);
                      builder.add(
                          request.getAppProfileId(),
                          "app_profile_id",
                          READ_MODIFY_WRITE_ROW_1_PATH_TEMPLATE);
                      return builder.build();
                    })
                .build();

    this.readRowsCallable =
        callableFactory.createServerStreamingCallable(
            readRowsTransportSettings, settings.readRowsSettings(), clientContext);
    this.sampleRowKeysCallable =
        callableFactory.createServerStreamingCallable(
            sampleRowKeysTransportSettings, settings.sampleRowKeysSettings(), clientContext);
    this.mutateRowCallable =
        callableFactory.createUnaryCallable(
            mutateRowTransportSettings, settings.mutateRowSettings(), clientContext);
    this.mutateRowsCallable =
        callableFactory.createServerStreamingCallable(
            mutateRowsTransportSettings, settings.mutateRowsSettings(), clientContext);
    this.checkAndMutateRowCallable =
        callableFactory.createUnaryCallable(
            checkAndMutateRowTransportSettings,
            settings.checkAndMutateRowSettings(),
            clientContext);
    this.pingAndWarmCallable =
        callableFactory.createUnaryCallable(
            pingAndWarmTransportSettings, settings.pingAndWarmSettings(), clientContext);
    this.readModifyWriteRowCallable =
        callableFactory.createUnaryCallable(
            readModifyWriteRowTransportSettings,
            settings.readModifyWriteRowSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public ServerStreamingCallable<ReadRowsRequest, ReadRowsResponse> readRowsCallable() {
    return readRowsCallable;
  }

  @Override
  public ServerStreamingCallable<SampleRowKeysRequest, SampleRowKeysResponse>
      sampleRowKeysCallable() {
    return sampleRowKeysCallable;
  }

  @Override
  public UnaryCallable<MutateRowRequest, MutateRowResponse> mutateRowCallable() {
    return mutateRowCallable;
  }

  @Override
  public ServerStreamingCallable<MutateRowsRequest, MutateRowsResponse> mutateRowsCallable() {
    return mutateRowsCallable;
  }

  @Override
  public UnaryCallable<CheckAndMutateRowRequest, CheckAndMutateRowResponse>
      checkAndMutateRowCallable() {
    return checkAndMutateRowCallable;
  }

  @Override
  public UnaryCallable<PingAndWarmRequest, PingAndWarmResponse> pingAndWarmCallable() {
    return pingAndWarmCallable;
  }

  @Override
  public UnaryCallable<ReadModifyWriteRowRequest, ReadModifyWriteRowResponse>
      readModifyWriteRowCallable() {
    return readModifyWriteRowCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
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
