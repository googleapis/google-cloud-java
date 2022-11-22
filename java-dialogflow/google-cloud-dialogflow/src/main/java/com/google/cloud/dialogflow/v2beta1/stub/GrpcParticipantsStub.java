/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.ParticipantsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ParticipantsClient.ListParticipantsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ParticipantsClient.ListSuggestionsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest;
import com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse;
import com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest;
import com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse;
import com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest;
import com.google.cloud.dialogflow.v2beta1.GetParticipantRequest;
import com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest;
import com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse;
import com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest;
import com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse;
import com.google.cloud.dialogflow.v2beta1.Participant;
import com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest;
import com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse;
import com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Participants service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcParticipantsStub extends ParticipantsStub {
  private static final MethodDescriptor<CreateParticipantRequest, Participant>
      createParticipantMethodDescriptor =
          MethodDescriptor.<CreateParticipantRequest, Participant>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/CreateParticipant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateParticipantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Participant.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetParticipantRequest, Participant>
      getParticipantMethodDescriptor =
          MethodDescriptor.<GetParticipantRequest, Participant>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/GetParticipant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetParticipantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Participant.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsMethodDescriptor =
          MethodDescriptor.<ListParticipantsRequest, ListParticipantsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/ListParticipants")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListParticipantsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListParticipantsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateParticipantRequest, Participant>
      updateParticipantMethodDescriptor =
          MethodDescriptor.<UpdateParticipantRequest, Participant>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/UpdateParticipant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateParticipantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Participant.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<AnalyzeContentRequest, AnalyzeContentResponse>
      analyzeContentMethodDescriptor =
          MethodDescriptor.<AnalyzeContentRequest, AnalyzeContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/AnalyzeContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(AnalyzeContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(AnalyzeContentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
      streamingAnalyzeContentMethodDescriptor =
          MethodDescriptor
              .<StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.Participants/StreamingAnalyzeContent")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(StreamingAnalyzeContentRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(StreamingAnalyzeContentResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SuggestArticlesRequest, SuggestArticlesResponse>
      suggestArticlesMethodDescriptor =
          MethodDescriptor.<SuggestArticlesRequest, SuggestArticlesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/SuggestArticles")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SuggestArticlesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SuggestArticlesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
      suggestFaqAnswersMethodDescriptor =
          MethodDescriptor.<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/SuggestFaqAnswers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SuggestFaqAnswersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SuggestFaqAnswersResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
      suggestSmartRepliesMethodDescriptor =
          MethodDescriptor.<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/SuggestSmartReplies")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SuggestSmartRepliesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SuggestSmartRepliesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListSuggestionsRequest, ListSuggestionsResponse>
      listSuggestionsMethodDescriptor =
          MethodDescriptor.<ListSuggestionsRequest, ListSuggestionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/ListSuggestions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListSuggestionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListSuggestionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CompileSuggestionRequest, CompileSuggestionResponse>
      compileSuggestionMethodDescriptor =
          MethodDescriptor.<CompileSuggestionRequest, CompileSuggestionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/CompileSuggestion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CompileSuggestionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CompileSuggestionResponse.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateParticipantRequest, Participant> createParticipantCallable;
  private final UnaryCallable<GetParticipantRequest, Participant> getParticipantCallable;
  private final UnaryCallable<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsCallable;
  private final UnaryCallable<ListParticipantsRequest, ListParticipantsPagedResponse>
      listParticipantsPagedCallable;
  private final UnaryCallable<UpdateParticipantRequest, Participant> updateParticipantCallable;
  private final UnaryCallable<AnalyzeContentRequest, AnalyzeContentResponse> analyzeContentCallable;
  private final BidiStreamingCallable<
          StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
      streamingAnalyzeContentCallable;
  private final UnaryCallable<SuggestArticlesRequest, SuggestArticlesResponse>
      suggestArticlesCallable;
  private final UnaryCallable<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
      suggestFaqAnswersCallable;
  private final UnaryCallable<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
      suggestSmartRepliesCallable;
  private final UnaryCallable<ListSuggestionsRequest, ListSuggestionsResponse>
      listSuggestionsCallable;
  private final UnaryCallable<ListSuggestionsRequest, ListSuggestionsPagedResponse>
      listSuggestionsPagedCallable;
  private final UnaryCallable<CompileSuggestionRequest, CompileSuggestionResponse>
      compileSuggestionCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcParticipantsStub create(ParticipantsStubSettings settings)
      throws IOException {
    return new GrpcParticipantsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcParticipantsStub create(ClientContext clientContext) throws IOException {
    return new GrpcParticipantsStub(ParticipantsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcParticipantsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcParticipantsStub(
        ParticipantsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcParticipantsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcParticipantsStub(ParticipantsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcParticipantsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcParticipantsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcParticipantsStub(
      ParticipantsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateParticipantRequest, Participant> createParticipantTransportSettings =
        GrpcCallSettings.<CreateParticipantRequest, Participant>newBuilder()
            .setMethodDescriptor(createParticipantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetParticipantRequest, Participant> getParticipantTransportSettings =
        GrpcCallSettings.<GetParticipantRequest, Participant>newBuilder()
            .setMethodDescriptor(getParticipantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListParticipantsRequest, ListParticipantsResponse>
        listParticipantsTransportSettings =
            GrpcCallSettings.<ListParticipantsRequest, ListParticipantsResponse>newBuilder()
                .setMethodDescriptor(listParticipantsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateParticipantRequest, Participant> updateParticipantTransportSettings =
        GrpcCallSettings.<UpdateParticipantRequest, Participant>newBuilder()
            .setMethodDescriptor(updateParticipantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "participant.name", String.valueOf(request.getParticipant().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<AnalyzeContentRequest, AnalyzeContentResponse>
        analyzeContentTransportSettings =
            GrpcCallSettings.<AnalyzeContentRequest, AnalyzeContentResponse>newBuilder()
                .setMethodDescriptor(analyzeContentMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("participant", String.valueOf(request.getParticipant()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
        streamingAnalyzeContentTransportSettings =
            GrpcCallSettings
                .<StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>newBuilder()
                .setMethodDescriptor(streamingAnalyzeContentMethodDescriptor)
                .build();
    GrpcCallSettings<SuggestArticlesRequest, SuggestArticlesResponse>
        suggestArticlesTransportSettings =
            GrpcCallSettings.<SuggestArticlesRequest, SuggestArticlesResponse>newBuilder()
                .setMethodDescriptor(suggestArticlesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
        suggestFaqAnswersTransportSettings =
            GrpcCallSettings.<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>newBuilder()
                .setMethodDescriptor(suggestFaqAnswersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
        suggestSmartRepliesTransportSettings =
            GrpcCallSettings.<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>newBuilder()
                .setMethodDescriptor(suggestSmartRepliesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListSuggestionsRequest, ListSuggestionsResponse>
        listSuggestionsTransportSettings =
            GrpcCallSettings.<ListSuggestionsRequest, ListSuggestionsResponse>newBuilder()
                .setMethodDescriptor(listSuggestionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CompileSuggestionRequest, CompileSuggestionResponse>
        compileSuggestionTransportSettings =
            GrpcCallSettings.<CompileSuggestionRequest, CompileSuggestionResponse>newBuilder()
                .setMethodDescriptor(compileSuggestionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createParticipantCallable =
        callableFactory.createUnaryCallable(
            createParticipantTransportSettings,
            settings.createParticipantSettings(),
            clientContext);
    this.getParticipantCallable =
        callableFactory.createUnaryCallable(
            getParticipantTransportSettings, settings.getParticipantSettings(), clientContext);
    this.listParticipantsCallable =
        callableFactory.createUnaryCallable(
            listParticipantsTransportSettings, settings.listParticipantsSettings(), clientContext);
    this.listParticipantsPagedCallable =
        callableFactory.createPagedCallable(
            listParticipantsTransportSettings, settings.listParticipantsSettings(), clientContext);
    this.updateParticipantCallable =
        callableFactory.createUnaryCallable(
            updateParticipantTransportSettings,
            settings.updateParticipantSettings(),
            clientContext);
    this.analyzeContentCallable =
        callableFactory.createUnaryCallable(
            analyzeContentTransportSettings, settings.analyzeContentSettings(), clientContext);
    this.streamingAnalyzeContentCallable =
        callableFactory.createBidiStreamingCallable(
            streamingAnalyzeContentTransportSettings,
            settings.streamingAnalyzeContentSettings(),
            clientContext);
    this.suggestArticlesCallable =
        callableFactory.createUnaryCallable(
            suggestArticlesTransportSettings, settings.suggestArticlesSettings(), clientContext);
    this.suggestFaqAnswersCallable =
        callableFactory.createUnaryCallable(
            suggestFaqAnswersTransportSettings,
            settings.suggestFaqAnswersSettings(),
            clientContext);
    this.suggestSmartRepliesCallable =
        callableFactory.createUnaryCallable(
            suggestSmartRepliesTransportSettings,
            settings.suggestSmartRepliesSettings(),
            clientContext);
    this.listSuggestionsCallable =
        callableFactory.createUnaryCallable(
            listSuggestionsTransportSettings, settings.listSuggestionsSettings(), clientContext);
    this.listSuggestionsPagedCallable =
        callableFactory.createPagedCallable(
            listSuggestionsTransportSettings, settings.listSuggestionsSettings(), clientContext);
    this.compileSuggestionCallable =
        callableFactory.createUnaryCallable(
            compileSuggestionTransportSettings,
            settings.compileSuggestionSettings(),
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
  public UnaryCallable<CreateParticipantRequest, Participant> createParticipantCallable() {
    return createParticipantCallable;
  }

  @Override
  public UnaryCallable<GetParticipantRequest, Participant> getParticipantCallable() {
    return getParticipantCallable;
  }

  @Override
  public UnaryCallable<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsCallable() {
    return listParticipantsCallable;
  }

  @Override
  public UnaryCallable<ListParticipantsRequest, ListParticipantsPagedResponse>
      listParticipantsPagedCallable() {
    return listParticipantsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateParticipantRequest, Participant> updateParticipantCallable() {
    return updateParticipantCallable;
  }

  @Override
  public UnaryCallable<AnalyzeContentRequest, AnalyzeContentResponse> analyzeContentCallable() {
    return analyzeContentCallable;
  }

  @Override
  public BidiStreamingCallable<StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
      streamingAnalyzeContentCallable() {
    return streamingAnalyzeContentCallable;
  }

  @Override
  public UnaryCallable<SuggestArticlesRequest, SuggestArticlesResponse> suggestArticlesCallable() {
    return suggestArticlesCallable;
  }

  @Override
  public UnaryCallable<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
      suggestFaqAnswersCallable() {
    return suggestFaqAnswersCallable;
  }

  @Override
  public UnaryCallable<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
      suggestSmartRepliesCallable() {
    return suggestSmartRepliesCallable;
  }

  @Override
  public UnaryCallable<ListSuggestionsRequest, ListSuggestionsResponse> listSuggestionsCallable() {
    return listSuggestionsCallable;
  }

  @Override
  public UnaryCallable<ListSuggestionsRequest, ListSuggestionsPagedResponse>
      listSuggestionsPagedCallable() {
    return listSuggestionsPagedCallable;
  }

  @Override
  public UnaryCallable<CompileSuggestionRequest, CompileSuggestionResponse>
      compileSuggestionCallable() {
    return compileSuggestionCallable;
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
