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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.SessionsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.AnswerFeedback;
import com.google.cloud.dialogflow.cx.v3beta1.DetectIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DetectIntentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.FulfillIntentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.MatchIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.MatchIntentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentRequest;
import com.google.cloud.dialogflow.cx.v3beta1.StreamingDetectIntentResponse;
import com.google.cloud.dialogflow.cx.v3beta1.SubmitAnswerFeedbackRequest;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Sessions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcSessionsStub extends SessionsStub {
  private static final MethodDescriptor<DetectIntentRequest, DetectIntentResponse>
      detectIntentMethodDescriptor =
          MethodDescriptor.<DetectIntentRequest, DetectIntentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Sessions/DetectIntent")
              .setRequestMarshaller(ProtoUtils.marshaller(DetectIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DetectIntentResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DetectIntentRequest, DetectIntentResponse>
      serverStreamingDetectIntentMethodDescriptor =
          MethodDescriptor.<DetectIntentRequest, DetectIntentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Sessions/ServerStreamingDetectIntent")
              .setRequestMarshaller(ProtoUtils.marshaller(DetectIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(DetectIntentResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentMethodDescriptor =
          MethodDescriptor.<StreamingDetectIntentRequest, StreamingDetectIntentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.Sessions/StreamingDetectIntent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingDetectIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingDetectIntentResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<MatchIntentRequest, MatchIntentResponse>
      matchIntentMethodDescriptor =
          MethodDescriptor.<MatchIntentRequest, MatchIntentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Sessions/MatchIntent")
              .setRequestMarshaller(ProtoUtils.marshaller(MatchIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(MatchIntentResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<FulfillIntentRequest, FulfillIntentResponse>
      fulfillIntentMethodDescriptor =
          MethodDescriptor.<FulfillIntentRequest, FulfillIntentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Sessions/FulfillIntent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FulfillIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FulfillIntentResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<SubmitAnswerFeedbackRequest, AnswerFeedback>
      submitAnswerFeedbackMethodDescriptor =
          MethodDescriptor.<SubmitAnswerFeedbackRequest, AnswerFeedback>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.Sessions/SubmitAnswerFeedback")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SubmitAnswerFeedbackRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnswerFeedback.getDefaultInstance()))
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

  private final UnaryCallable<DetectIntentRequest, DetectIntentResponse> detectIntentCallable;
  private final ServerStreamingCallable<DetectIntentRequest, DetectIntentResponse>
      serverStreamingDetectIntentCallable;
  private final BidiStreamingCallable<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentCallable;
  private final UnaryCallable<MatchIntentRequest, MatchIntentResponse> matchIntentCallable;
  private final UnaryCallable<FulfillIntentRequest, FulfillIntentResponse> fulfillIntentCallable;
  private final UnaryCallable<SubmitAnswerFeedbackRequest, AnswerFeedback>
      submitAnswerFeedbackCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcSessionsStub create(SessionsStubSettings settings) throws IOException {
    return new GrpcSessionsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcSessionsStub create(ClientContext clientContext) throws IOException {
    return new GrpcSessionsStub(SessionsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcSessionsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcSessionsStub(
        SessionsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcSessionsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSessionsStub(SessionsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcSessionsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcSessionsStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcSessionsStub(
      SessionsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<DetectIntentRequest, DetectIntentResponse> detectIntentTransportSettings =
        GrpcCallSettings.<DetectIntentRequest, DetectIntentResponse>newBuilder()
            .setMethodDescriptor(detectIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DetectIntentRequest, DetectIntentResponse>
        serverStreamingDetectIntentTransportSettings =
            GrpcCallSettings.<DetectIntentRequest, DetectIntentResponse>newBuilder()
                .setMethodDescriptor(serverStreamingDetectIntentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("session", String.valueOf(request.getSession()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
        streamingDetectIntentTransportSettings =
            GrpcCallSettings
                .<StreamingDetectIntentRequest, StreamingDetectIntentResponse>newBuilder()
                .setMethodDescriptor(streamingDetectIntentMethodDescriptor)
                .build();
    GrpcCallSettings<MatchIntentRequest, MatchIntentResponse> matchIntentTransportSettings =
        GrpcCallSettings.<MatchIntentRequest, MatchIntentResponse>newBuilder()
            .setMethodDescriptor(matchIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("session", String.valueOf(request.getSession()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<FulfillIntentRequest, FulfillIntentResponse> fulfillIntentTransportSettings =
        GrpcCallSettings.<FulfillIntentRequest, FulfillIntentResponse>newBuilder()
            .setMethodDescriptor(fulfillIntentMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "match_intent_request.session",
                      String.valueOf(request.getMatchIntentRequest().getSession()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SubmitAnswerFeedbackRequest, AnswerFeedback>
        submitAnswerFeedbackTransportSettings =
            GrpcCallSettings.<SubmitAnswerFeedbackRequest, AnswerFeedback>newBuilder()
                .setMethodDescriptor(submitAnswerFeedbackMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("session", String.valueOf(request.getSession()));
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

    this.detectIntentCallable =
        callableFactory.createUnaryCallable(
            detectIntentTransportSettings, settings.detectIntentSettings(), clientContext);
    this.serverStreamingDetectIntentCallable =
        callableFactory.createServerStreamingCallable(
            serverStreamingDetectIntentTransportSettings,
            settings.serverStreamingDetectIntentSettings(),
            clientContext);
    this.streamingDetectIntentCallable =
        callableFactory.createBidiStreamingCallable(
            streamingDetectIntentTransportSettings,
            settings.streamingDetectIntentSettings(),
            clientContext);
    this.matchIntentCallable =
        callableFactory.createUnaryCallable(
            matchIntentTransportSettings, settings.matchIntentSettings(), clientContext);
    this.fulfillIntentCallable =
        callableFactory.createUnaryCallable(
            fulfillIntentTransportSettings, settings.fulfillIntentSettings(), clientContext);
    this.submitAnswerFeedbackCallable =
        callableFactory.createUnaryCallable(
            submitAnswerFeedbackTransportSettings,
            settings.submitAnswerFeedbackSettings(),
            clientContext);
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
  public UnaryCallable<DetectIntentRequest, DetectIntentResponse> detectIntentCallable() {
    return detectIntentCallable;
  }

  @Override
  public ServerStreamingCallable<DetectIntentRequest, DetectIntentResponse>
      serverStreamingDetectIntentCallable() {
    return serverStreamingDetectIntentCallable;
  }

  @Override
  public BidiStreamingCallable<StreamingDetectIntentRequest, StreamingDetectIntentResponse>
      streamingDetectIntentCallable() {
    return streamingDetectIntentCallable;
  }

  @Override
  public UnaryCallable<MatchIntentRequest, MatchIntentResponse> matchIntentCallable() {
    return matchIntentCallable;
  }

  @Override
  public UnaryCallable<FulfillIntentRequest, FulfillIntentResponse> fulfillIntentCallable() {
    return fulfillIntentCallable;
  }

  @Override
  public UnaryCallable<SubmitAnswerFeedbackRequest, AnswerFeedback> submitAnswerFeedbackCallable() {
    return submitAnswerFeedbackCallable;
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
