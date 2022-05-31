/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.webrisk.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.webrisk.v1beta1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1beta1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1beta1.SearchHashesRequest;
import com.google.webrisk.v1beta1.SearchHashesResponse;
import com.google.webrisk.v1beta1.SearchUrisRequest;
import com.google.webrisk.v1beta1.SearchUrisResponse;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the WebRiskServiceV1Beta1 service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcWebRiskServiceV1Beta1Stub extends WebRiskServiceV1Beta1Stub {
  private static final MethodDescriptor<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffMethodDescriptor =
          MethodDescriptor.<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1/ComputeThreatListDiff")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ComputeThreatListDiffRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ComputeThreatListDiffResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchUrisRequest, SearchUrisResponse>
      searchUrisMethodDescriptor =
          MethodDescriptor.<SearchUrisRequest, SearchUrisResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1/SearchUris")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchUrisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(SearchUrisResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchHashesRequest, SearchHashesResponse>
      searchHashesMethodDescriptor =
          MethodDescriptor.<SearchHashesRequest, SearchHashesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.webrisk.v1beta1.WebRiskServiceV1Beta1/SearchHashes")
              .setRequestMarshaller(ProtoUtils.marshaller(SearchHashesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchHashesResponse.getDefaultInstance()))
              .build();

  private final UnaryCallable<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffCallable;
  private final UnaryCallable<SearchUrisRequest, SearchUrisResponse> searchUrisCallable;
  private final UnaryCallable<SearchHashesRequest, SearchHashesResponse> searchHashesCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcWebRiskServiceV1Beta1Stub create(
      WebRiskServiceV1Beta1StubSettings settings) throws IOException {
    return new GrpcWebRiskServiceV1Beta1Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcWebRiskServiceV1Beta1Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcWebRiskServiceV1Beta1Stub(
        WebRiskServiceV1Beta1StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcWebRiskServiceV1Beta1Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcWebRiskServiceV1Beta1Stub(
        WebRiskServiceV1Beta1StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcWebRiskServiceV1Beta1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWebRiskServiceV1Beta1Stub(
      WebRiskServiceV1Beta1StubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcWebRiskServiceV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of GrpcWebRiskServiceV1Beta1Stub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcWebRiskServiceV1Beta1Stub(
      WebRiskServiceV1Beta1StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
        computeThreatListDiffTransportSettings =
            GrpcCallSettings
                .<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>newBuilder()
                .setMethodDescriptor(computeThreatListDiffMethodDescriptor)
                .build();
    GrpcCallSettings<SearchUrisRequest, SearchUrisResponse> searchUrisTransportSettings =
        GrpcCallSettings.<SearchUrisRequest, SearchUrisResponse>newBuilder()
            .setMethodDescriptor(searchUrisMethodDescriptor)
            .build();
    GrpcCallSettings<SearchHashesRequest, SearchHashesResponse> searchHashesTransportSettings =
        GrpcCallSettings.<SearchHashesRequest, SearchHashesResponse>newBuilder()
            .setMethodDescriptor(searchHashesMethodDescriptor)
            .build();

    this.computeThreatListDiffCallable =
        callableFactory.createUnaryCallable(
            computeThreatListDiffTransportSettings,
            settings.computeThreatListDiffSettings(),
            clientContext);
    this.searchUrisCallable =
        callableFactory.createUnaryCallable(
            searchUrisTransportSettings, settings.searchUrisSettings(), clientContext);
    this.searchHashesCallable =
        callableFactory.createUnaryCallable(
            searchHashesTransportSettings, settings.searchHashesSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffCallable() {
    return computeThreatListDiffCallable;
  }

  @Override
  public UnaryCallable<SearchUrisRequest, SearchUrisResponse> searchUrisCallable() {
    return searchUrisCallable;
  }

  @Override
  public UnaryCallable<SearchHashesRequest, SearchHashesResponse> searchHashesCallable() {
    return searchHashesCallable;
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
