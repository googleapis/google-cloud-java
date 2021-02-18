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

package com.google.cloud.aiplatform.v1beta1.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.ExplainRequest;
import com.google.cloud.aiplatform.v1beta1.ExplainResponse;
import com.google.cloud.aiplatform.v1beta1.PredictRequest;
import com.google.cloud.aiplatform.v1beta1.PredictResponse;
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
 * gRPC stub implementation for the PredictionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcPredictionServiceStub extends PredictionServiceStub {
  private static final MethodDescriptor<PredictRequest, PredictResponse> predictMethodDescriptor =
      MethodDescriptor.<PredictRequest, PredictResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.PredictionService/Predict")
          .setRequestMarshaller(ProtoUtils.marshaller(PredictRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(PredictResponse.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ExplainRequest, ExplainResponse> explainMethodDescriptor =
      MethodDescriptor.<ExplainRequest, ExplainResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.aiplatform.v1beta1.PredictionService/Explain")
          .setRequestMarshaller(ProtoUtils.marshaller(ExplainRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(ExplainResponse.getDefaultInstance()))
          .build();

  private final UnaryCallable<PredictRequest, PredictResponse> predictCallable;
  private final UnaryCallable<ExplainRequest, ExplainResponse> explainCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPredictionServiceStub create(PredictionServiceStubSettings settings)
      throws IOException {
    return new GrpcPredictionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPredictionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcPredictionServiceStub(
        PredictionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPredictionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPredictionServiceStub(
        PredictionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPredictionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPredictionServiceStub(
      PredictionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcPredictionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPredictionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcPredictionServiceStub(
      PredictionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<PredictRequest, PredictResponse> predictTransportSettings =
        GrpcCallSettings.<PredictRequest, PredictResponse>newBuilder()
            .setMethodDescriptor(predictMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<PredictRequest>() {
                  @Override
                  public Map<String, String> extract(PredictRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("endpoint", String.valueOf(request.getEndpoint()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ExplainRequest, ExplainResponse> explainTransportSettings =
        GrpcCallSettings.<ExplainRequest, ExplainResponse>newBuilder()
            .setMethodDescriptor(explainMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExplainRequest>() {
                  @Override
                  public Map<String, String> extract(ExplainRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("endpoint", String.valueOf(request.getEndpoint()));
                    return params.build();
                  }
                })
            .build();

    this.predictCallable =
        callableFactory.createUnaryCallable(
            predictTransportSettings, settings.predictSettings(), clientContext);
    this.explainCallable =
        callableFactory.createUnaryCallable(
            explainTransportSettings, settings.explainSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  public UnaryCallable<PredictRequest, PredictResponse> predictCallable() {
    return predictCallable;
  }

  public UnaryCallable<ExplainRequest, ExplainResponse> explainCallable() {
    return explainCallable;
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
