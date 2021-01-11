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

package com.google.cloud.asset.v1p4beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyRequest;
import com.google.cloud.asset.v1p4beta1.AnalyzeIamPolicyResponse;
import com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisRequest;
import com.google.cloud.asset.v1p4beta1.ExportIamPolicyAnalysisResponse;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the AssetService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcAssetServiceStub extends AssetServiceStub {
  private static final MethodDescriptor<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyMethodDescriptor =
          MethodDescriptor.<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.asset.v1p4beta1.AssetService/AnalyzeIamPolicy")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnalyzeIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnalyzeIamPolicyResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ExportIamPolicyAnalysisRequest, Operation>
      exportIamPolicyAnalysisMethodDescriptor =
          MethodDescriptor.<ExportIamPolicyAnalysisRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.asset.v1p4beta1.AssetService/ExportIamPolicyAnalysis")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportIamPolicyAnalysisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyCallable;
  private final UnaryCallable<ExportIamPolicyAnalysisRequest, Operation>
      exportIamPolicyAnalysisCallable;
  private final OperationCallable<
          ExportIamPolicyAnalysisRequest,
          ExportIamPolicyAnalysisResponse,
          ExportIamPolicyAnalysisRequest>
      exportIamPolicyAnalysisOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcAssetServiceStub create(AssetServiceStubSettings settings)
      throws IOException {
    return new GrpcAssetServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcAssetServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcAssetServiceStub(AssetServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcAssetServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcAssetServiceStub(
        AssetServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcAssetServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAssetServiceStub(AssetServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcAssetServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcAssetServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcAssetServiceStub(
      AssetServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
        analyzeIamPolicyTransportSettings =
            GrpcCallSettings.<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>newBuilder()
                .setMethodDescriptor(analyzeIamPolicyMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<AnalyzeIamPolicyRequest>() {
                      @Override
                      public Map<String, String> extract(AnalyzeIamPolicyRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "analysis_query.parent",
                            String.valueOf(request.getAnalysisQuery().getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<ExportIamPolicyAnalysisRequest, Operation>
        exportIamPolicyAnalysisTransportSettings =
            GrpcCallSettings.<ExportIamPolicyAnalysisRequest, Operation>newBuilder()
                .setMethodDescriptor(exportIamPolicyAnalysisMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ExportIamPolicyAnalysisRequest>() {
                      @Override
                      public Map<String, String> extract(ExportIamPolicyAnalysisRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put(
                            "analysis_query.parent",
                            String.valueOf(request.getAnalysisQuery().getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.analyzeIamPolicyCallable =
        callableFactory.createUnaryCallable(
            analyzeIamPolicyTransportSettings, settings.analyzeIamPolicySettings(), clientContext);
    this.exportIamPolicyAnalysisCallable =
        callableFactory.createUnaryCallable(
            exportIamPolicyAnalysisTransportSettings,
            settings.exportIamPolicyAnalysisSettings(),
            clientContext);
    this.exportIamPolicyAnalysisOperationCallable =
        callableFactory.createOperationCallable(
            exportIamPolicyAnalysisTransportSettings,
            settings.exportIamPolicyAnalysisOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyCallable() {
    return analyzeIamPolicyCallable;
  }

  public UnaryCallable<ExportIamPolicyAnalysisRequest, Operation>
      exportIamPolicyAnalysisCallable() {
    return exportIamPolicyAnalysisCallable;
  }

  public OperationCallable<
          ExportIamPolicyAnalysisRequest,
          ExportIamPolicyAnalysisResponse,
          ExportIamPolicyAnalysisRequest>
      exportIamPolicyAnalysisOperationCallable() {
    return exportIamPolicyAnalysisOperationCallable;
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
