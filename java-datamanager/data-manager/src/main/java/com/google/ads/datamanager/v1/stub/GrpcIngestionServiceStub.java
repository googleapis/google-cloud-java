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

import com.google.ads.datamanager.v1.IngestAudienceMembersRequest;
import com.google.ads.datamanager.v1.IngestAudienceMembersResponse;
import com.google.ads.datamanager.v1.IngestEventsRequest;
import com.google.ads.datamanager.v1.IngestEventsResponse;
import com.google.ads.datamanager.v1.RemoveAudienceMembersRequest;
import com.google.ads.datamanager.v1.RemoveAudienceMembersResponse;
import com.google.ads.datamanager.v1.RetrieveRequestStatusRequest;
import com.google.ads.datamanager.v1.RetrieveRequestStatusResponse;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the IngestionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcIngestionServiceStub extends IngestionServiceStub {
  private static final MethodDescriptor<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
      ingestAudienceMembersMethodDescriptor =
          MethodDescriptor.<IngestAudienceMembersRequest, IngestAudienceMembersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.IngestionService/IngestAudienceMembers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(IngestAudienceMembersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IngestAudienceMembersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
      removeAudienceMembersMethodDescriptor =
          MethodDescriptor.<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.IngestionService/RemoveAudienceMembers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RemoveAudienceMembersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RemoveAudienceMembersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<IngestEventsRequest, IngestEventsResponse>
      ingestEventsMethodDescriptor =
          MethodDescriptor.<IngestEventsRequest, IngestEventsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.IngestionService/IngestEvents")
              .setRequestMarshaller(ProtoUtils.marshaller(IngestEventsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IngestEventsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
      retrieveRequestStatusMethodDescriptor =
          MethodDescriptor.<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.ads.datamanager.v1.IngestionService/RetrieveRequestStatus")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(RetrieveRequestStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(RetrieveRequestStatusResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
      ingestAudienceMembersCallable;
  private final UnaryCallable<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
      removeAudienceMembersCallable;
  private final UnaryCallable<IngestEventsRequest, IngestEventsResponse> ingestEventsCallable;
  private final UnaryCallable<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
      retrieveRequestStatusCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcIngestionServiceStub create(IngestionServiceStubSettings settings)
      throws IOException {
    return new GrpcIngestionServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcIngestionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcIngestionServiceStub(
        IngestionServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcIngestionServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcIngestionServiceStub(
        IngestionServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcIngestionServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcIngestionServiceStub(
      IngestionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcIngestionServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcIngestionServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcIngestionServiceStub(
      IngestionServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
        ingestAudienceMembersTransportSettings =
            GrpcCallSettings
                .<IngestAudienceMembersRequest, IngestAudienceMembersResponse>newBuilder()
                .setMethodDescriptor(ingestAudienceMembersMethodDescriptor)
                .build();
    GrpcCallSettings<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
        removeAudienceMembersTransportSettings =
            GrpcCallSettings
                .<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>newBuilder()
                .setMethodDescriptor(removeAudienceMembersMethodDescriptor)
                .build();
    GrpcCallSettings<IngestEventsRequest, IngestEventsResponse> ingestEventsTransportSettings =
        GrpcCallSettings.<IngestEventsRequest, IngestEventsResponse>newBuilder()
            .setMethodDescriptor(ingestEventsMethodDescriptor)
            .build();
    GrpcCallSettings<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
        retrieveRequestStatusTransportSettings =
            GrpcCallSettings
                .<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>newBuilder()
                .setMethodDescriptor(retrieveRequestStatusMethodDescriptor)
                .build();

    this.ingestAudienceMembersCallable =
        callableFactory.createUnaryCallable(
            ingestAudienceMembersTransportSettings,
            settings.ingestAudienceMembersSettings(),
            clientContext);
    this.removeAudienceMembersCallable =
        callableFactory.createUnaryCallable(
            removeAudienceMembersTransportSettings,
            settings.removeAudienceMembersSettings(),
            clientContext);
    this.ingestEventsCallable =
        callableFactory.createUnaryCallable(
            ingestEventsTransportSettings, settings.ingestEventsSettings(), clientContext);
    this.retrieveRequestStatusCallable =
        callableFactory.createUnaryCallable(
            retrieveRequestStatusTransportSettings,
            settings.retrieveRequestStatusSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
      ingestAudienceMembersCallable() {
    return ingestAudienceMembersCallable;
  }

  @Override
  public UnaryCallable<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
      removeAudienceMembersCallable() {
    return removeAudienceMembersCallable;
  }

  @Override
  public UnaryCallable<IngestEventsRequest, IngestEventsResponse> ingestEventsCallable() {
    return ingestEventsCallable;
  }

  @Override
  public UnaryCallable<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
      retrieveRequestStatusCallable() {
    return retrieveRequestStatusCallable;
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
