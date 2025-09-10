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

package com.google.cloud.retail.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.cloud.retail.v2.ConversationalSearchRequest;
import com.google.cloud.retail.v2.ConversationalSearchResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ConversationalSearchService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcConversationalSearchServiceStub extends ConversationalSearchServiceStub {
  private static final MethodDescriptor<ConversationalSearchRequest, ConversationalSearchResponse>
      conversationalSearchMethodDescriptor =
          MethodDescriptor.<ConversationalSearchRequest, ConversationalSearchResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(
                  "google.cloud.retail.v2.ConversationalSearchService/ConversationalSearch")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ConversationalSearchRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ConversationalSearchResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final ServerStreamingCallable<ConversationalSearchRequest, ConversationalSearchResponse>
      conversationalSearchCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConversationalSearchServiceStub create(
      ConversationalSearchServiceStubSettings settings) throws IOException {
    return new GrpcConversationalSearchServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConversationalSearchServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConversationalSearchServiceStub(
        ConversationalSearchServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConversationalSearchServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConversationalSearchServiceStub(
        ConversationalSearchServiceStubSettings.newBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of GrpcConversationalSearchServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationalSearchServiceStub(
      ConversationalSearchServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConversationalSearchServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConversationalSearchServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConversationalSearchServiceStub(
      ConversationalSearchServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ConversationalSearchRequest, ConversationalSearchResponse>
        conversationalSearchTransportSettings =
            GrpcCallSettings.<ConversationalSearchRequest, ConversationalSearchResponse>newBuilder()
                .setMethodDescriptor(conversationalSearchMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("placement", String.valueOf(request.getPlacement()));
                      return builder.build();
                    })
                .build();

    this.conversationalSearchCallable =
        callableFactory.createServerStreamingCallable(
            conversationalSearchTransportSettings,
            settings.conversationalSearchSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public ServerStreamingCallable<ConversationalSearchRequest, ConversationalSearchResponse>
      conversationalSearchCallable() {
    return conversationalSearchCallable;
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
