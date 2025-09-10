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

package com.google.cloud.eventarc.publishing.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.eventarc.publishing.v1.PublishChannelConnectionEventsRequest;
import com.google.cloud.eventarc.publishing.v1.PublishChannelConnectionEventsResponse;
import com.google.cloud.eventarc.publishing.v1.PublishEventsRequest;
import com.google.cloud.eventarc.publishing.v1.PublishEventsResponse;
import com.google.cloud.eventarc.publishing.v1.PublishRequest;
import com.google.cloud.eventarc.publishing.v1.PublishResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Publisher service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcPublisherStub extends PublisherStub {
  private static final MethodDescriptor<
          PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
      publishChannelConnectionEventsMethodDescriptor =
          MethodDescriptor
              .<PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.eventarc.publishing.v1.Publisher/PublishChannelConnectionEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PublishChannelConnectionEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(
                      PublishChannelConnectionEventsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PublishEventsRequest, PublishEventsResponse>
      publishEventsMethodDescriptor =
          MethodDescriptor.<PublishEventsRequest, PublishEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.eventarc.publishing.v1.Publisher/PublishEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(PublishEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(PublishEventsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<PublishRequest, PublishResponse> publishMethodDescriptor =
      MethodDescriptor.<PublishRequest, PublishResponse>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.eventarc.publishing.v1.Publisher/Publish")
          .setRequestMarshaller(ProtoUtils.marshaller(PublishRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(PublishResponse.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<
          PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
      publishChannelConnectionEventsCallable;
  private final UnaryCallable<PublishEventsRequest, PublishEventsResponse> publishEventsCallable;
  private final UnaryCallable<PublishRequest, PublishResponse> publishCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcPublisherStub create(PublisherStubSettings settings) throws IOException {
    return new GrpcPublisherStub(settings, ClientContext.create(settings));
  }

  public static final GrpcPublisherStub create(ClientContext clientContext) throws IOException {
    return new GrpcPublisherStub(PublisherStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcPublisherStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcPublisherStub(
        PublisherStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcPublisherStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPublisherStub(PublisherStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcPublisherCallableFactory());
  }

  /**
   * Constructs an instance of GrpcPublisherStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcPublisherStub(
      PublisherStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
        publishChannelConnectionEventsTransportSettings =
            GrpcCallSettings
                .<PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
                    newBuilder()
                .setMethodDescriptor(publishChannelConnectionEventsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "channel_connection", String.valueOf(request.getChannelConnection()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<PublishEventsRequest, PublishEventsResponse> publishEventsTransportSettings =
        GrpcCallSettings.<PublishEventsRequest, PublishEventsResponse>newBuilder()
            .setMethodDescriptor(publishEventsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("channel", String.valueOf(request.getChannel()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<PublishRequest, PublishResponse> publishTransportSettings =
        GrpcCallSettings.<PublishRequest, PublishResponse>newBuilder()
            .setMethodDescriptor(publishMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("message_bus", String.valueOf(request.getMessageBus()));
                  return builder.build();
                })
            .build();

    this.publishChannelConnectionEventsCallable =
        callableFactory.createUnaryCallable(
            publishChannelConnectionEventsTransportSettings,
            settings.publishChannelConnectionEventsSettings(),
            clientContext);
    this.publishEventsCallable =
        callableFactory.createUnaryCallable(
            publishEventsTransportSettings, settings.publishEventsSettings(), clientContext);
    this.publishCallable =
        callableFactory.createUnaryCallable(
            publishTransportSettings, settings.publishSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<
          PublishChannelConnectionEventsRequest, PublishChannelConnectionEventsResponse>
      publishChannelConnectionEventsCallable() {
    return publishChannelConnectionEventsCallable;
  }

  @Override
  public UnaryCallable<PublishEventsRequest, PublishEventsResponse> publishEventsCallable() {
    return publishEventsCallable;
  }

  @Override
  public UnaryCallable<PublishRequest, PublishResponse> publishCallable() {
    return publishCallable;
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
