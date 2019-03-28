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
package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Stackdriver Logging API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcConfigServiceV2Stub extends ConfigServiceV2Stub {

  private static final MethodDescriptor<ListSinksRequest, ListSinksResponse>
      listSinksMethodDescriptor =
          MethodDescriptor.<ListSinksRequest, ListSinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/ListSinks")
              .setRequestMarshaller(ProtoUtils.marshaller(ListSinksRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListSinksResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetSinkRequest, LogSink> getSinkMethodDescriptor =
      MethodDescriptor.<GetSinkRequest, LogSink>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/GetSink")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogSink.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<CreateSinkRequest, LogSink> createSinkMethodDescriptor =
      MethodDescriptor.<CreateSinkRequest, LogSink>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/CreateSink")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateSinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogSink.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<UpdateSinkRequest, LogSink> updateSinkMethodDescriptor =
      MethodDescriptor.<UpdateSinkRequest, LogSink>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/UpdateSink")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateSinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(LogSink.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<DeleteSinkRequest, Empty> deleteSinkMethodDescriptor =
      MethodDescriptor.<DeleteSinkRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.logging.v2.ConfigServiceV2/DeleteSink")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteSinkRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListExclusionsRequest, ListExclusionsResponse>
      listExclusionsMethodDescriptor =
          MethodDescriptor.<ListExclusionsRequest, ListExclusionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/ListExclusions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListExclusionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListExclusionsResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetExclusionRequest, LogExclusion>
      getExclusionMethodDescriptor =
          MethodDescriptor.<GetExclusionRequest, LogExclusion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/GetExclusion")
              .setRequestMarshaller(ProtoUtils.marshaller(GetExclusionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogExclusion.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateExclusionRequest, LogExclusion>
      createExclusionMethodDescriptor =
          MethodDescriptor.<CreateExclusionRequest, LogExclusion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/CreateExclusion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateExclusionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogExclusion.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateExclusionRequest, LogExclusion>
      updateExclusionMethodDescriptor =
          MethodDescriptor.<UpdateExclusionRequest, LogExclusion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/UpdateExclusion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateExclusionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(LogExclusion.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteExclusionRequest, Empty>
      deleteExclusionMethodDescriptor =
          MethodDescriptor.<DeleteExclusionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.logging.v2.ConfigServiceV2/DeleteExclusion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteExclusionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<ListSinksRequest, ListSinksResponse> listSinksCallable;
  private final UnaryCallable<ListSinksRequest, ListSinksPagedResponse> listSinksPagedCallable;
  private final UnaryCallable<GetSinkRequest, LogSink> getSinkCallable;
  private final UnaryCallable<CreateSinkRequest, LogSink> createSinkCallable;
  private final UnaryCallable<UpdateSinkRequest, LogSink> updateSinkCallable;
  private final UnaryCallable<DeleteSinkRequest, Empty> deleteSinkCallable;
  private final UnaryCallable<ListExclusionsRequest, ListExclusionsResponse> listExclusionsCallable;
  private final UnaryCallable<ListExclusionsRequest, ListExclusionsPagedResponse>
      listExclusionsPagedCallable;
  private final UnaryCallable<GetExclusionRequest, LogExclusion> getExclusionCallable;
  private final UnaryCallable<CreateExclusionRequest, LogExclusion> createExclusionCallable;
  private final UnaryCallable<UpdateExclusionRequest, LogExclusion> updateExclusionCallable;
  private final UnaryCallable<DeleteExclusionRequest, Empty> deleteExclusionCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConfigServiceV2Stub create(ConfigServiceV2StubSettings settings)
      throws IOException {
    return new GrpcConfigServiceV2Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcConfigServiceV2Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConfigServiceV2Stub(
        ConfigServiceV2StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConfigServiceV2Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConfigServiceV2Stub(
        ConfigServiceV2StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConfigServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConfigServiceV2Stub(
      ConfigServiceV2StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcConfigServiceV2CallableFactory());
  }

  /**
   * Constructs an instance of GrpcConfigServiceV2Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConfigServiceV2Stub(
      ConfigServiceV2StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<ListSinksRequest, ListSinksResponse> listSinksTransportSettings =
        GrpcCallSettings.<ListSinksRequest, ListSinksResponse>newBuilder()
            .setMethodDescriptor(listSinksMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListSinksRequest>() {
                  @Override
                  public Map<String, String> extract(ListSinksRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetSinkRequest, LogSink> getSinkTransportSettings =
        GrpcCallSettings.<GetSinkRequest, LogSink>newBuilder()
            .setMethodDescriptor(getSinkMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetSinkRequest>() {
                  @Override
                  public Map<String, String> extract(GetSinkRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("sink_name", String.valueOf(request.getSinkName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateSinkRequest, LogSink> createSinkTransportSettings =
        GrpcCallSettings.<CreateSinkRequest, LogSink>newBuilder()
            .setMethodDescriptor(createSinkMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateSinkRequest>() {
                  @Override
                  public Map<String, String> extract(CreateSinkRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateSinkRequest, LogSink> updateSinkTransportSettings =
        GrpcCallSettings.<UpdateSinkRequest, LogSink>newBuilder()
            .setMethodDescriptor(updateSinkMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateSinkRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateSinkRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("sink_name", String.valueOf(request.getSinkName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteSinkRequest, Empty> deleteSinkTransportSettings =
        GrpcCallSettings.<DeleteSinkRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteSinkMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteSinkRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteSinkRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("sink_name", String.valueOf(request.getSinkName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListExclusionsRequest, ListExclusionsResponse>
        listExclusionsTransportSettings =
            GrpcCallSettings.<ListExclusionsRequest, ListExclusionsResponse>newBuilder()
                .setMethodDescriptor(listExclusionsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListExclusionsRequest>() {
                      @Override
                      public Map<String, String> extract(ListExclusionsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetExclusionRequest, LogExclusion> getExclusionTransportSettings =
        GrpcCallSettings.<GetExclusionRequest, LogExclusion>newBuilder()
            .setMethodDescriptor(getExclusionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetExclusionRequest>() {
                  @Override
                  public Map<String, String> extract(GetExclusionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateExclusionRequest, LogExclusion> createExclusionTransportSettings =
        GrpcCallSettings.<CreateExclusionRequest, LogExclusion>newBuilder()
            .setMethodDescriptor(createExclusionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateExclusionRequest>() {
                  @Override
                  public Map<String, String> extract(CreateExclusionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateExclusionRequest, LogExclusion> updateExclusionTransportSettings =
        GrpcCallSettings.<UpdateExclusionRequest, LogExclusion>newBuilder()
            .setMethodDescriptor(updateExclusionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateExclusionRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateExclusionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteExclusionRequest, Empty> deleteExclusionTransportSettings =
        GrpcCallSettings.<DeleteExclusionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteExclusionMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteExclusionRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteExclusionRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();

    this.listSinksCallable =
        callableFactory.createUnaryCallable(
            listSinksTransportSettings, settings.listSinksSettings(), clientContext);
    this.listSinksPagedCallable =
        callableFactory.createPagedCallable(
            listSinksTransportSettings, settings.listSinksSettings(), clientContext);
    this.getSinkCallable =
        callableFactory.createUnaryCallable(
            getSinkTransportSettings, settings.getSinkSettings(), clientContext);
    this.createSinkCallable =
        callableFactory.createUnaryCallable(
            createSinkTransportSettings, settings.createSinkSettings(), clientContext);
    this.updateSinkCallable =
        callableFactory.createUnaryCallable(
            updateSinkTransportSettings, settings.updateSinkSettings(), clientContext);
    this.deleteSinkCallable =
        callableFactory.createUnaryCallable(
            deleteSinkTransportSettings, settings.deleteSinkSettings(), clientContext);
    this.listExclusionsCallable =
        callableFactory.createUnaryCallable(
            listExclusionsTransportSettings, settings.listExclusionsSettings(), clientContext);
    this.listExclusionsPagedCallable =
        callableFactory.createPagedCallable(
            listExclusionsTransportSettings, settings.listExclusionsSettings(), clientContext);
    this.getExclusionCallable =
        callableFactory.createUnaryCallable(
            getExclusionTransportSettings, settings.getExclusionSettings(), clientContext);
    this.createExclusionCallable =
        callableFactory.createUnaryCallable(
            createExclusionTransportSettings, settings.createExclusionSettings(), clientContext);
    this.updateExclusionCallable =
        callableFactory.createUnaryCallable(
            updateExclusionTransportSettings, settings.updateExclusionSettings(), clientContext);
    this.deleteExclusionCallable =
        callableFactory.createUnaryCallable(
            deleteExclusionTransportSettings, settings.deleteExclusionSettings(), clientContext);

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

  public UnaryCallable<ListExclusionsRequest, ListExclusionsPagedResponse>
      listExclusionsPagedCallable() {
    return listExclusionsPagedCallable;
  }

  public UnaryCallable<ListExclusionsRequest, ListExclusionsResponse> listExclusionsCallable() {
    return listExclusionsCallable;
  }

  public UnaryCallable<GetExclusionRequest, LogExclusion> getExclusionCallable() {
    return getExclusionCallable;
  }

  public UnaryCallable<CreateExclusionRequest, LogExclusion> createExclusionCallable() {
    return createExclusionCallable;
  }

  public UnaryCallable<UpdateExclusionRequest, LogExclusion> updateExclusionCallable() {
    return updateExclusionCallable;
  }

  public UnaryCallable<DeleteExclusionRequest, Empty> deleteExclusionCallable() {
    return deleteExclusionCallable;
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
