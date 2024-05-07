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

package com.google.cloud.visionai.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.AcquireLeaseRequest;
import com.google.cloud.visionai.v1.Lease;
import com.google.cloud.visionai.v1.ReceiveEventsRequest;
import com.google.cloud.visionai.v1.ReceiveEventsResponse;
import com.google.cloud.visionai.v1.ReceivePacketsRequest;
import com.google.cloud.visionai.v1.ReceivePacketsResponse;
import com.google.cloud.visionai.v1.ReleaseLeaseRequest;
import com.google.cloud.visionai.v1.ReleaseLeaseResponse;
import com.google.cloud.visionai.v1.RenewLeaseRequest;
import com.google.cloud.visionai.v1.SendPacketsRequest;
import com.google.cloud.visionai.v1.SendPacketsResponse;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the StreamingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcStreamingServiceStub extends StreamingServiceStub {
  private static final MethodDescriptor<SendPacketsRequest, SendPacketsResponse>
      sendPacketsMethodDescriptor =
          MethodDescriptor.<SendPacketsRequest, SendPacketsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.visionai.v1.StreamingService/SendPackets")
              .setRequestMarshaller(ProtoUtils.marshaller(SendPacketsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SendPacketsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReceivePacketsRequest, ReceivePacketsResponse>
      receivePacketsMethodDescriptor =
          MethodDescriptor.<ReceivePacketsRequest, ReceivePacketsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.visionai.v1.StreamingService/ReceivePackets")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReceivePacketsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReceivePacketsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ReceiveEventsRequest, ReceiveEventsResponse>
      receiveEventsMethodDescriptor =
          MethodDescriptor.<ReceiveEventsRequest, ReceiveEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName("google.cloud.visionai.v1.StreamingService/ReceiveEvents")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ReceiveEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReceiveEventsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AcquireLeaseRequest, Lease> acquireLeaseMethodDescriptor =
      MethodDescriptor.<AcquireLeaseRequest, Lease>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.StreamingService/AcquireLease")
          .setRequestMarshaller(ProtoUtils.marshaller(AcquireLeaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Lease.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<RenewLeaseRequest, Lease> renewLeaseMethodDescriptor =
      MethodDescriptor.<RenewLeaseRequest, Lease>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.visionai.v1.StreamingService/RenewLease")
          .setRequestMarshaller(ProtoUtils.marshaller(RenewLeaseRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Lease.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ReleaseLeaseRequest, ReleaseLeaseResponse>
      releaseLeaseMethodDescriptor =
          MethodDescriptor.<ReleaseLeaseRequest, ReleaseLeaseResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.visionai.v1.StreamingService/ReleaseLease")
              .setRequestMarshaller(ProtoUtils.marshaller(ReleaseLeaseRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ReleaseLeaseResponse.getDefaultInstance()))
              .build();

  private final BidiStreamingCallable<SendPacketsRequest, SendPacketsResponse> sendPacketsCallable;
  private final BidiStreamingCallable<ReceivePacketsRequest, ReceivePacketsResponse>
      receivePacketsCallable;
  private final BidiStreamingCallable<ReceiveEventsRequest, ReceiveEventsResponse>
      receiveEventsCallable;
  private final UnaryCallable<AcquireLeaseRequest, Lease> acquireLeaseCallable;
  private final UnaryCallable<RenewLeaseRequest, Lease> renewLeaseCallable;
  private final UnaryCallable<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcStreamingServiceStub create(StreamingServiceStubSettings settings)
      throws IOException {
    return new GrpcStreamingServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcStreamingServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcStreamingServiceStub(
        StreamingServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcStreamingServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcStreamingServiceStub(
        StreamingServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcStreamingServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcStreamingServiceStub(
      StreamingServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcStreamingServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcStreamingServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcStreamingServiceStub(
      StreamingServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SendPacketsRequest, SendPacketsResponse> sendPacketsTransportSettings =
        GrpcCallSettings.<SendPacketsRequest, SendPacketsResponse>newBuilder()
            .setMethodDescriptor(sendPacketsMethodDescriptor)
            .build();
    GrpcCallSettings<ReceivePacketsRequest, ReceivePacketsResponse>
        receivePacketsTransportSettings =
            GrpcCallSettings.<ReceivePacketsRequest, ReceivePacketsResponse>newBuilder()
                .setMethodDescriptor(receivePacketsMethodDescriptor)
                .build();
    GrpcCallSettings<ReceiveEventsRequest, ReceiveEventsResponse> receiveEventsTransportSettings =
        GrpcCallSettings.<ReceiveEventsRequest, ReceiveEventsResponse>newBuilder()
            .setMethodDescriptor(receiveEventsMethodDescriptor)
            .build();
    GrpcCallSettings<AcquireLeaseRequest, Lease> acquireLeaseTransportSettings =
        GrpcCallSettings.<AcquireLeaseRequest, Lease>newBuilder()
            .setMethodDescriptor(acquireLeaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("series", String.valueOf(request.getSeries()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<RenewLeaseRequest, Lease> renewLeaseTransportSettings =
        GrpcCallSettings.<RenewLeaseRequest, Lease>newBuilder()
            .setMethodDescriptor(renewLeaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("series", String.valueOf(request.getSeries()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseTransportSettings =
        GrpcCallSettings.<ReleaseLeaseRequest, ReleaseLeaseResponse>newBuilder()
            .setMethodDescriptor(releaseLeaseMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("series", String.valueOf(request.getSeries()));
                  return builder.build();
                })
            .build();

    this.sendPacketsCallable =
        callableFactory.createBidiStreamingCallable(
            sendPacketsTransportSettings, settings.sendPacketsSettings(), clientContext);
    this.receivePacketsCallable =
        callableFactory.createBidiStreamingCallable(
            receivePacketsTransportSettings, settings.receivePacketsSettings(), clientContext);
    this.receiveEventsCallable =
        callableFactory.createBidiStreamingCallable(
            receiveEventsTransportSettings, settings.receiveEventsSettings(), clientContext);
    this.acquireLeaseCallable =
        callableFactory.createUnaryCallable(
            acquireLeaseTransportSettings, settings.acquireLeaseSettings(), clientContext);
    this.renewLeaseCallable =
        callableFactory.createUnaryCallable(
            renewLeaseTransportSettings, settings.renewLeaseSettings(), clientContext);
    this.releaseLeaseCallable =
        callableFactory.createUnaryCallable(
            releaseLeaseTransportSettings, settings.releaseLeaseSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public BidiStreamingCallable<SendPacketsRequest, SendPacketsResponse> sendPacketsCallable() {
    return sendPacketsCallable;
  }

  @Override
  public BidiStreamingCallable<ReceivePacketsRequest, ReceivePacketsResponse>
      receivePacketsCallable() {
    return receivePacketsCallable;
  }

  @Override
  public BidiStreamingCallable<ReceiveEventsRequest, ReceiveEventsResponse>
      receiveEventsCallable() {
    return receiveEventsCallable;
  }

  @Override
  public UnaryCallable<AcquireLeaseRequest, Lease> acquireLeaseCallable() {
    return acquireLeaseCallable;
  }

  @Override
  public UnaryCallable<RenewLeaseRequest, Lease> renewLeaseCallable() {
    return renewLeaseCallable;
  }

  @Override
  public UnaryCallable<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseCallable() {
    return releaseLeaseCallable;
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
