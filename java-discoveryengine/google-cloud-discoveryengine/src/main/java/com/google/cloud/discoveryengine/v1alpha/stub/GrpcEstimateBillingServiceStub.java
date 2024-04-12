/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha.stub;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeMetadata;
import com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest;
import com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the EstimateBillingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcEstimateBillingServiceStub extends EstimateBillingServiceStub {
  private static final MethodDescriptor<EstimateDataSizeRequest, Operation>
      estimateDataSizeMethodDescriptor =
          MethodDescriptor.<EstimateDataSizeRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.discoveryengine.v1alpha.EstimateBillingService/EstimateDataSize")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(EstimateDataSizeRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private final UnaryCallable<EstimateDataSizeRequest, Operation> estimateDataSizeCallable;
  private final OperationCallable<
          EstimateDataSizeRequest, EstimateDataSizeResponse, EstimateDataSizeMetadata>
      estimateDataSizeOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcEstimateBillingServiceStub create(
      EstimateBillingServiceStubSettings settings) throws IOException {
    return new GrpcEstimateBillingServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcEstimateBillingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcEstimateBillingServiceStub(
        EstimateBillingServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcEstimateBillingServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcEstimateBillingServiceStub(
        EstimateBillingServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcEstimateBillingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEstimateBillingServiceStub(
      EstimateBillingServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcEstimateBillingServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcEstimateBillingServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcEstimateBillingServiceStub(
      EstimateBillingServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<EstimateDataSizeRequest, Operation> estimateDataSizeTransportSettings =
        GrpcCallSettings.<EstimateDataSizeRequest, Operation>newBuilder()
            .setMethodDescriptor(estimateDataSizeMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("location", String.valueOf(request.getLocation()));
                  return builder.build();
                })
            .build();

    this.estimateDataSizeCallable =
        callableFactory.createUnaryCallable(
            estimateDataSizeTransportSettings, settings.estimateDataSizeSettings(), clientContext);
    this.estimateDataSizeOperationCallable =
        callableFactory.createOperationCallable(
            estimateDataSizeTransportSettings,
            settings.estimateDataSizeOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<EstimateDataSizeRequest, Operation> estimateDataSizeCallable() {
    return estimateDataSizeCallable;
  }

  @Override
  public OperationCallable<
          EstimateDataSizeRequest, EstimateDataSizeResponse, EstimateDataSizeMetadata>
      estimateDataSizeOperationCallable() {
    return estimateDataSizeOperationCallable;
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
