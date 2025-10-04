/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.support.v2beta.stub;

import static com.google.cloud.support.v2beta.FeedServiceClient.ShowFeedPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2beta.ShowFeedRequest;
import com.google.cloud.support.v2beta.ShowFeedResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the FeedService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcFeedServiceStub extends FeedServiceStub {
  private static final MethodDescriptor<ShowFeedRequest, ShowFeedResponse>
      showFeedMethodDescriptor =
          MethodDescriptor.<ShowFeedRequest, ShowFeedResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.support.v2beta.FeedService/ShowFeed")
              .setRequestMarshaller(ProtoUtils.marshaller(ShowFeedRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ShowFeedResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<ShowFeedRequest, ShowFeedResponse> showFeedCallable;
  private final UnaryCallable<ShowFeedRequest, ShowFeedPagedResponse> showFeedPagedCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcFeedServiceStub create(FeedServiceStubSettings settings)
      throws IOException {
    return new GrpcFeedServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcFeedServiceStub create(ClientContext clientContext) throws IOException {
    return new GrpcFeedServiceStub(FeedServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcFeedServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcFeedServiceStub(
        FeedServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcFeedServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFeedServiceStub(FeedServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcFeedServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcFeedServiceStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcFeedServiceStub(
      FeedServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ShowFeedRequest, ShowFeedResponse> showFeedTransportSettings =
        GrpcCallSettings.<ShowFeedRequest, ShowFeedResponse>newBuilder()
            .setMethodDescriptor(showFeedMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();

    this.showFeedCallable =
        callableFactory.createUnaryCallable(
            showFeedTransportSettings, settings.showFeedSettings(), clientContext);
    this.showFeedPagedCallable =
        callableFactory.createPagedCallable(
            showFeedTransportSettings, settings.showFeedSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ShowFeedRequest, ShowFeedResponse> showFeedCallable() {
    return showFeedCallable;
  }

  @Override
  public UnaryCallable<ShowFeedRequest, ShowFeedPagedResponse> showFeedPagedCallable() {
    return showFeedPagedCallable;
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
