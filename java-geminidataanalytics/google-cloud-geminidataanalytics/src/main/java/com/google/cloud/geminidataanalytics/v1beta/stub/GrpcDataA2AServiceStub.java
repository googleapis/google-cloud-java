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

package com.google.cloud.geminidataanalytics.v1beta.stub;

import static com.google.cloud.geminidataanalytics.v1beta.DataA2AServiceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.geminidataanalytics.v1beta.AgentCard;
import com.google.cloud.geminidataanalytics.v1beta.GetAgentCardRequest;
import com.google.cloud.geminidataanalytics.v1beta.SendMessageRequest;
import com.google.cloud.geminidataanalytics.v1beta.SendMessageResponse;
import com.google.cloud.geminidataanalytics.v1beta.StreamResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DataA2AService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcDataA2AServiceStub extends DataA2AServiceStub {
  private static final MethodDescriptor<SendMessageRequest, SendMessageResponse>
      sendMessageMethodDescriptor =
          MethodDescriptor.<SendMessageRequest, SendMessageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataA2AService/SendMessage")
              .setRequestMarshaller(ProtoUtils.marshaller(SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SendMessageResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SendMessageRequest, StreamResponse>
      sendStreamingMessageMethodDescriptor =
          MethodDescriptor.<SendMessageRequest, StreamResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataA2AService/SendStreamingMessage")
              .setRequestMarshaller(ProtoUtils.marshaller(SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(StreamResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAgentCardRequest, AgentCard>
      getAgentCardMethodDescriptor =
          MethodDescriptor.<GetAgentCardRequest, AgentCard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.geminidataanalytics.v1beta.DataA2AService/GetAgentCard")
              .setRequestMarshaller(ProtoUtils.marshaller(GetAgentCardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AgentCard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private final UnaryCallable<SendMessageRequest, SendMessageResponse> sendMessageCallable;
  private final ServerStreamingCallable<SendMessageRequest, StreamResponse>
      sendStreamingMessageCallable;
  private final UnaryCallable<GetAgentCardRequest, AgentCard> getAgentCardCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDataA2AServiceStub create(DataA2AServiceStubSettings settings)
      throws IOException {
    return new GrpcDataA2AServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDataA2AServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDataA2AServiceStub(
        DataA2AServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDataA2AServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDataA2AServiceStub(
        DataA2AServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDataA2AServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataA2AServiceStub(DataA2AServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcDataA2AServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDataA2AServiceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDataA2AServiceStub(
      DataA2AServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<SendMessageRequest, SendMessageResponse> sendMessageTransportSettings =
        GrpcCallSettings.<SendMessageRequest, SendMessageResponse>newBuilder()
            .setMethodDescriptor(sendMessageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tenant", String.valueOf(request.getTenant()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SendMessageRequest, StreamResponse> sendStreamingMessageTransportSettings =
        GrpcCallSettings.<SendMessageRequest, StreamResponse>newBuilder()
            .setMethodDescriptor(sendStreamingMessageMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tenant", String.valueOf(request.getTenant()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAgentCardRequest, AgentCard> getAgentCardTransportSettings =
        GrpcCallSettings.<GetAgentCardRequest, AgentCard>newBuilder()
            .setMethodDescriptor(getAgentCardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("tenant", String.valueOf(request.getTenant()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.sendMessageCallable =
        callableFactory.createUnaryCallable(
            sendMessageTransportSettings, settings.sendMessageSettings(), clientContext);
    this.sendStreamingMessageCallable =
        callableFactory.createServerStreamingCallable(
            sendStreamingMessageTransportSettings,
            settings.sendStreamingMessageSettings(),
            clientContext);
    this.getAgentCardCallable =
        callableFactory.createUnaryCallable(
            getAgentCardTransportSettings, settings.getAgentCardSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<SendMessageRequest, SendMessageResponse> sendMessageCallable() {
    return sendMessageCallable;
  }

  @Override
  public ServerStreamingCallable<SendMessageRequest, StreamResponse>
      sendStreamingMessageCallable() {
    return sendStreamingMessageCallable;
  }

  @Override
  public UnaryCallable<GetAgentCardRequest, AgentCard> getAgentCardCallable() {
    return getAgentCardCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
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
