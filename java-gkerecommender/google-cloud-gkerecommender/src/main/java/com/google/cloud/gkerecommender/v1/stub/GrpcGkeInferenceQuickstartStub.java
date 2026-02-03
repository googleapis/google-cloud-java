/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.gkerecommender.v1.stub;

import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServerVersionsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelServersPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchModelsPagedResponse;
import static com.google.cloud.gkerecommender.v1.GkeInferenceQuickstartClient.FetchProfilesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataRequest;
import com.google.cloud.gkerecommender.v1.FetchBenchmarkingDataResponse;
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsRequest;
import com.google.cloud.gkerecommender.v1.FetchModelServerVersionsResponse;
import com.google.cloud.gkerecommender.v1.FetchModelServersRequest;
import com.google.cloud.gkerecommender.v1.FetchModelServersResponse;
import com.google.cloud.gkerecommender.v1.FetchModelsRequest;
import com.google.cloud.gkerecommender.v1.FetchModelsResponse;
import com.google.cloud.gkerecommender.v1.FetchProfilesRequest;
import com.google.cloud.gkerecommender.v1.FetchProfilesResponse;
import com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestRequest;
import com.google.cloud.gkerecommender.v1.GenerateOptimizedManifestResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the GkeInferenceQuickstart service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcGkeInferenceQuickstartStub extends GkeInferenceQuickstartStub {
  private static final MethodDescriptor<FetchModelsRequest, FetchModelsResponse>
      fetchModelsMethodDescriptor =
          MethodDescriptor.<FetchModelsRequest, FetchModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchModels")
              .setRequestMarshaller(ProtoUtils.marshaller(FetchModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchModelsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FetchModelServersRequest, FetchModelServersResponse>
      fetchModelServersMethodDescriptor =
          MethodDescriptor.<FetchModelServersRequest, FetchModelServersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchModelServers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchModelServersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchModelServersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
      fetchModelServerVersionsMethodDescriptor =
          MethodDescriptor
              .<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchModelServerVersions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchModelServerVersionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchModelServerVersionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FetchProfilesRequest, FetchProfilesResponse>
      fetchProfilesMethodDescriptor =
          MethodDescriptor.<FetchProfilesRequest, FetchProfilesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchProfiles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchProfilesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestMethodDescriptor =
          MethodDescriptor
              .<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/GenerateOptimizedManifest")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateOptimizedManifestRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateOptimizedManifestResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataMethodDescriptor =
          MethodDescriptor.<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.gkerecommender.v1.GkeInferenceQuickstart/FetchBenchmarkingData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchBenchmarkingDataRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchBenchmarkingDataResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<FetchModelsRequest, FetchModelsResponse> fetchModelsCallable;
  private final UnaryCallable<FetchModelsRequest, FetchModelsPagedResponse>
      fetchModelsPagedCallable;
  private final UnaryCallable<FetchModelServersRequest, FetchModelServersResponse>
      fetchModelServersCallable;
  private final UnaryCallable<FetchModelServersRequest, FetchModelServersPagedResponse>
      fetchModelServersPagedCallable;
  private final UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
      fetchModelServerVersionsCallable;
  private final UnaryCallable<
          FetchModelServerVersionsRequest, FetchModelServerVersionsPagedResponse>
      fetchModelServerVersionsPagedCallable;
  private final UnaryCallable<FetchProfilesRequest, FetchProfilesResponse> fetchProfilesCallable;
  private final UnaryCallable<FetchProfilesRequest, FetchProfilesPagedResponse>
      fetchProfilesPagedCallable;
  private final UnaryCallable<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestCallable;
  private final UnaryCallable<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGkeInferenceQuickstartStub create(
      GkeInferenceQuickstartStubSettings settings) throws IOException {
    return new GrpcGkeInferenceQuickstartStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGkeInferenceQuickstartStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGkeInferenceQuickstartStub(
        GkeInferenceQuickstartStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGkeInferenceQuickstartStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGkeInferenceQuickstartStub(
        GkeInferenceQuickstartStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGkeInferenceQuickstartStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGkeInferenceQuickstartStub(
      GkeInferenceQuickstartStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcGkeInferenceQuickstartCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGkeInferenceQuickstartStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcGkeInferenceQuickstartStub(
      GkeInferenceQuickstartStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<FetchModelsRequest, FetchModelsResponse> fetchModelsTransportSettings =
        GrpcCallSettings.<FetchModelsRequest, FetchModelsResponse>newBuilder()
            .setMethodDescriptor(fetchModelsMethodDescriptor)
            .build();
    GrpcCallSettings<FetchModelServersRequest, FetchModelServersResponse>
        fetchModelServersTransportSettings =
            GrpcCallSettings.<FetchModelServersRequest, FetchModelServersResponse>newBuilder()
                .setMethodDescriptor(fetchModelServersMethodDescriptor)
                .build();
    GrpcCallSettings<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
        fetchModelServerVersionsTransportSettings =
            GrpcCallSettings
                .<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>newBuilder()
                .setMethodDescriptor(fetchModelServerVersionsMethodDescriptor)
                .build();
    GrpcCallSettings<FetchProfilesRequest, FetchProfilesResponse> fetchProfilesTransportSettings =
        GrpcCallSettings.<FetchProfilesRequest, FetchProfilesResponse>newBuilder()
            .setMethodDescriptor(fetchProfilesMethodDescriptor)
            .build();
    GrpcCallSettings<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
        generateOptimizedManifestTransportSettings =
            GrpcCallSettings
                .<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>newBuilder()
                .setMethodDescriptor(generateOptimizedManifestMethodDescriptor)
                .build();
    GrpcCallSettings<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
        fetchBenchmarkingDataTransportSettings =
            GrpcCallSettings
                .<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>newBuilder()
                .setMethodDescriptor(fetchBenchmarkingDataMethodDescriptor)
                .build();

    this.fetchModelsCallable =
        callableFactory.createUnaryCallable(
            fetchModelsTransportSettings, settings.fetchModelsSettings(), clientContext);
    this.fetchModelsPagedCallable =
        callableFactory.createPagedCallable(
            fetchModelsTransportSettings, settings.fetchModelsSettings(), clientContext);
    this.fetchModelServersCallable =
        callableFactory.createUnaryCallable(
            fetchModelServersTransportSettings,
            settings.fetchModelServersSettings(),
            clientContext);
    this.fetchModelServersPagedCallable =
        callableFactory.createPagedCallable(
            fetchModelServersTransportSettings,
            settings.fetchModelServersSettings(),
            clientContext);
    this.fetchModelServerVersionsCallable =
        callableFactory.createUnaryCallable(
            fetchModelServerVersionsTransportSettings,
            settings.fetchModelServerVersionsSettings(),
            clientContext);
    this.fetchModelServerVersionsPagedCallable =
        callableFactory.createPagedCallable(
            fetchModelServerVersionsTransportSettings,
            settings.fetchModelServerVersionsSettings(),
            clientContext);
    this.fetchProfilesCallable =
        callableFactory.createUnaryCallable(
            fetchProfilesTransportSettings, settings.fetchProfilesSettings(), clientContext);
    this.fetchProfilesPagedCallable =
        callableFactory.createPagedCallable(
            fetchProfilesTransportSettings, settings.fetchProfilesSettings(), clientContext);
    this.generateOptimizedManifestCallable =
        callableFactory.createUnaryCallable(
            generateOptimizedManifestTransportSettings,
            settings.generateOptimizedManifestSettings(),
            clientContext);
    this.fetchBenchmarkingDataCallable =
        callableFactory.createUnaryCallable(
            fetchBenchmarkingDataTransportSettings,
            settings.fetchBenchmarkingDataSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<FetchModelsRequest, FetchModelsResponse> fetchModelsCallable() {
    return fetchModelsCallable;
  }

  @Override
  public UnaryCallable<FetchModelsRequest, FetchModelsPagedResponse> fetchModelsPagedCallable() {
    return fetchModelsPagedCallable;
  }

  @Override
  public UnaryCallable<FetchModelServersRequest, FetchModelServersResponse>
      fetchModelServersCallable() {
    return fetchModelServersCallable;
  }

  @Override
  public UnaryCallable<FetchModelServersRequest, FetchModelServersPagedResponse>
      fetchModelServersPagedCallable() {
    return fetchModelServersPagedCallable;
  }

  @Override
  public UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsResponse>
      fetchModelServerVersionsCallable() {
    return fetchModelServerVersionsCallable;
  }

  @Override
  public UnaryCallable<FetchModelServerVersionsRequest, FetchModelServerVersionsPagedResponse>
      fetchModelServerVersionsPagedCallable() {
    return fetchModelServerVersionsPagedCallable;
  }

  @Override
  public UnaryCallable<FetchProfilesRequest, FetchProfilesResponse> fetchProfilesCallable() {
    return fetchProfilesCallable;
  }

  @Override
  public UnaryCallable<FetchProfilesRequest, FetchProfilesPagedResponse>
      fetchProfilesPagedCallable() {
    return fetchProfilesPagedCallable;
  }

  @Override
  public UnaryCallable<GenerateOptimizedManifestRequest, GenerateOptimizedManifestResponse>
      generateOptimizedManifestCallable() {
    return generateOptimizedManifestCallable;
  }

  @Override
  public UnaryCallable<FetchBenchmarkingDataRequest, FetchBenchmarkingDataResponse>
      fetchBenchmarkingDataCallable() {
    return fetchBenchmarkingDataCallable;
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
