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

package com.google.ads.datamanager.v1.stub;

import com.google.ads.datamanager.v1.RetrieveInsightsRequest;
import com.google.ads.datamanager.v1.RetrieveInsightsResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the MarketingDataInsightsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcMarketingDataInsightsServiceStub extends MarketingDataInsightsServiceStub {
  private static final MethodDescriptor<RetrieveInsightsRequest, RetrieveInsightsResponse>
      retrieveInsightsMethodDescriptor =
          MethodDescriptor.<RetrieveInsightsRequest, RetrieveInsightsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.ads.datamanager.v1.MarketingDataInsightsService/RetrieveInsights")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetrieveInsightsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RetrieveInsightsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<RetrieveInsightsRequest, RetrieveInsightsResponse>
      retrieveInsightsCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcMarketingDataInsightsServiceStub create(
      MarketingDataInsightsServiceStubSettings settings) throws IOException {
    return new GrpcMarketingDataInsightsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcMarketingDataInsightsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcMarketingDataInsightsServiceStub(
        MarketingDataInsightsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcMarketingDataInsightsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcMarketingDataInsightsServiceStub(
        MarketingDataInsightsServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcMarketingDataInsightsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMarketingDataInsightsServiceStub(
      MarketingDataInsightsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcMarketingDataInsightsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcMarketingDataInsightsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcMarketingDataInsightsServiceStub(
      MarketingDataInsightsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<RetrieveInsightsRequest, RetrieveInsightsResponse>
        retrieveInsightsTransportSettings =
            GrpcCallSettings.<RetrieveInsightsRequest, RetrieveInsightsResponse>newBuilder()
                .setMethodDescriptor(retrieveInsightsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.retrieveInsightsCallable =
        callableFactory.createUnaryCallable(
            retrieveInsightsTransportSettings, settings.retrieveInsightsSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<RetrieveInsightsRequest, RetrieveInsightsResponse>
      retrieveInsightsCallable() {
    return retrieveInsightsCallable;
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
