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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListConversationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListMessagesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.BatchCreateMessagesRequest;
import com.google.cloud.dialogflow.v2beta1.BatchCreateMessagesResponse;
import com.google.cloud.dialogflow.v2beta1.CompleteConversationRequest;
import com.google.cloud.dialogflow.v2beta1.Conversation;
import com.google.cloud.dialogflow.v2beta1.CreateConversationRequest;
import com.google.cloud.dialogflow.v2beta1.GenerateStatelessSuggestionRequest;
import com.google.cloud.dialogflow.v2beta1.GenerateStatelessSuggestionResponse;
import com.google.cloud.dialogflow.v2beta1.GenerateStatelessSummaryRequest;
import com.google.cloud.dialogflow.v2beta1.GenerateStatelessSummaryResponse;
import com.google.cloud.dialogflow.v2beta1.GenerateSuggestionsRequest;
import com.google.cloud.dialogflow.v2beta1.GenerateSuggestionsResponse;
import com.google.cloud.dialogflow.v2beta1.GetConversationRequest;
import com.google.cloud.dialogflow.v2beta1.IngestContextReferencesRequest;
import com.google.cloud.dialogflow.v2beta1.IngestContextReferencesResponse;
import com.google.cloud.dialogflow.v2beta1.ListConversationsRequest;
import com.google.cloud.dialogflow.v2beta1.ListConversationsResponse;
import com.google.cloud.dialogflow.v2beta1.ListMessagesRequest;
import com.google.cloud.dialogflow.v2beta1.ListMessagesResponse;
import com.google.cloud.dialogflow.v2beta1.SearchKnowledgeRequest;
import com.google.cloud.dialogflow.v2beta1.SearchKnowledgeResponse;
import com.google.cloud.dialogflow.v2beta1.SuggestConversationSummaryRequest;
import com.google.cloud.dialogflow.v2beta1.SuggestConversationSummaryResponse;
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
 * gRPC stub implementation for the Conversations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcConversationsStub extends ConversationsStub {
  private static final MethodDescriptor<CreateConversationRequest, Conversation>
      createConversationMethodDescriptor =
          MethodDescriptor.<CreateConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Conversations/CreateConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConversationsRequest, ListConversationsResponse>
      listConversationsMethodDescriptor =
          MethodDescriptor.<ListConversationsRequest, ListConversationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Conversations/ListConversations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConversationRequest, Conversation>
      getConversationMethodDescriptor =
          MethodDescriptor.<GetConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Conversations/GetConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CompleteConversationRequest, Conversation>
      completeConversationMethodDescriptor =
          MethodDescriptor.<CompleteConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.Conversations/CompleteConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CompleteConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          IngestContextReferencesRequest, IngestContextReferencesResponse>
      ingestContextReferencesMethodDescriptor =
          MethodDescriptor
              .<IngestContextReferencesRequest, IngestContextReferencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.Conversations/IngestContextReferences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(IngestContextReferencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(IngestContextReferencesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
      batchCreateMessagesMethodDescriptor =
          MethodDescriptor.<BatchCreateMessagesRequest, BatchCreateMessagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.Conversations/BatchCreateMessages")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateMessagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListMessagesRequest, ListMessagesResponse>
      listMessagesMethodDescriptor =
          MethodDescriptor.<ListMessagesRequest, ListMessagesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Conversations/ListMessages")
              .setRequestMarshaller(ProtoUtils.marshaller(ListMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListMessagesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
      suggestConversationSummaryMethodDescriptor =
          MethodDescriptor
              .<SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.Conversations/SuggestConversationSummary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SuggestConversationSummaryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SuggestConversationSummaryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
      generateStatelessSummaryMethodDescriptor =
          MethodDescriptor
              .<GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.Conversations/GenerateStatelessSummary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateStatelessSummaryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateStatelessSummaryResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
      generateStatelessSuggestionMethodDescriptor =
          MethodDescriptor
              .<GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.Conversations/GenerateStatelessSuggestion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateStatelessSuggestionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateStatelessSuggestionResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<SearchKnowledgeRequest, SearchKnowledgeResponse>
      searchKnowledgeMethodDescriptor =
          MethodDescriptor.<SearchKnowledgeRequest, SearchKnowledgeResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Conversations/SearchKnowledge")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(SearchKnowledgeRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(SearchKnowledgeResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
      generateSuggestionsMethodDescriptor =
          MethodDescriptor.<GenerateSuggestionsRequest, GenerateSuggestionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.dialogflow.v2beta1.Conversations/GenerateSuggestions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GenerateSuggestionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GenerateSuggestionsResponse.getDefaultInstance()))
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

  private final UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable;
  private final UnaryCallable<GetConversationRequest, Conversation> getConversationCallable;
  private final UnaryCallable<CompleteConversationRequest, Conversation>
      completeConversationCallable;
  private final UnaryCallable<IngestContextReferencesRequest, IngestContextReferencesResponse>
      ingestContextReferencesCallable;
  private final UnaryCallable<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
      batchCreateMessagesCallable;
  private final UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable;
  private final UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse>
      listMessagesPagedCallable;
  private final UnaryCallable<SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
      suggestConversationSummaryCallable;
  private final UnaryCallable<GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
      generateStatelessSummaryCallable;
  private final UnaryCallable<
          GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
      generateStatelessSuggestionCallable;
  private final UnaryCallable<SearchKnowledgeRequest, SearchKnowledgeResponse>
      searchKnowledgeCallable;
  private final UnaryCallable<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
      generateSuggestionsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConversationsStub create(ConversationsStubSettings settings)
      throws IOException {
    return new GrpcConversationsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConversationsStub create(ClientContext clientContext) throws IOException {
    return new GrpcConversationsStub(ConversationsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConversationsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConversationsStub(
        ConversationsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConversationsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConversationsStub(ConversationsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConversationsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConversationsStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcConversationsStub(
      ConversationsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateConversationRequest, Conversation> createConversationTransportSettings =
        GrpcCallSettings.<CreateConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(createConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            GrpcCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        GrpcCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CompleteConversationRequest, Conversation>
        completeConversationTransportSettings =
            GrpcCallSettings.<CompleteConversationRequest, Conversation>newBuilder()
                .setMethodDescriptor(completeConversationMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<IngestContextReferencesRequest, IngestContextReferencesResponse>
        ingestContextReferencesTransportSettings =
            GrpcCallSettings
                .<IngestContextReferencesRequest, IngestContextReferencesResponse>newBuilder()
                .setMethodDescriptor(ingestContextReferencesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("conversation", String.valueOf(request.getConversation()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
        batchCreateMessagesTransportSettings =
            GrpcCallSettings.<BatchCreateMessagesRequest, BatchCreateMessagesResponse>newBuilder()
                .setMethodDescriptor(batchCreateMessagesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListMessagesRequest, ListMessagesResponse> listMessagesTransportSettings =
        GrpcCallSettings.<ListMessagesRequest, ListMessagesResponse>newBuilder()
            .setMethodDescriptor(listMessagesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
        suggestConversationSummaryTransportSettings =
            GrpcCallSettings
                .<SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>newBuilder()
                .setMethodDescriptor(suggestConversationSummaryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("conversation", String.valueOf(request.getConversation()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
        generateStatelessSummaryTransportSettings =
            GrpcCallSettings
                .<GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>newBuilder()
                .setMethodDescriptor(generateStatelessSummaryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "stateless_conversation.parent",
                          String.valueOf(request.getStatelessConversation().getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
        generateStatelessSuggestionTransportSettings =
            GrpcCallSettings
                .<GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
                    newBuilder()
                .setMethodDescriptor(generateStatelessSuggestionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<SearchKnowledgeRequest, SearchKnowledgeResponse>
        searchKnowledgeTransportSettings =
            GrpcCallSettings.<SearchKnowledgeRequest, SearchKnowledgeResponse>newBuilder()
                .setMethodDescriptor(searchKnowledgeMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("conversation", String.valueOf(request.getConversation()));
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
        generateSuggestionsTransportSettings =
            GrpcCallSettings.<GenerateSuggestionsRequest, GenerateSuggestionsResponse>newBuilder()
                .setMethodDescriptor(generateSuggestionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("conversation", String.valueOf(request.getConversation()));
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

    this.createConversationCallable =
        callableFactory.createUnaryCallable(
            createConversationTransportSettings,
            settings.createConversationSettings(),
            clientContext);
    this.listConversationsCallable =
        callableFactory.createUnaryCallable(
            listConversationsTransportSettings,
            settings.listConversationsSettings(),
            clientContext);
    this.listConversationsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationsTransportSettings,
            settings.listConversationsSettings(),
            clientContext);
    this.getConversationCallable =
        callableFactory.createUnaryCallable(
            getConversationTransportSettings, settings.getConversationSettings(), clientContext);
    this.completeConversationCallable =
        callableFactory.createUnaryCallable(
            completeConversationTransportSettings,
            settings.completeConversationSettings(),
            clientContext);
    this.ingestContextReferencesCallable =
        callableFactory.createUnaryCallable(
            ingestContextReferencesTransportSettings,
            settings.ingestContextReferencesSettings(),
            clientContext);
    this.batchCreateMessagesCallable =
        callableFactory.createUnaryCallable(
            batchCreateMessagesTransportSettings,
            settings.batchCreateMessagesSettings(),
            clientContext);
    this.listMessagesCallable =
        callableFactory.createUnaryCallable(
            listMessagesTransportSettings, settings.listMessagesSettings(), clientContext);
    this.listMessagesPagedCallable =
        callableFactory.createPagedCallable(
            listMessagesTransportSettings, settings.listMessagesSettings(), clientContext);
    this.suggestConversationSummaryCallable =
        callableFactory.createUnaryCallable(
            suggestConversationSummaryTransportSettings,
            settings.suggestConversationSummarySettings(),
            clientContext);
    this.generateStatelessSummaryCallable =
        callableFactory.createUnaryCallable(
            generateStatelessSummaryTransportSettings,
            settings.generateStatelessSummarySettings(),
            clientContext);
    this.generateStatelessSuggestionCallable =
        callableFactory.createUnaryCallable(
            generateStatelessSuggestionTransportSettings,
            settings.generateStatelessSuggestionSettings(),
            clientContext);
    this.searchKnowledgeCallable =
        callableFactory.createUnaryCallable(
            searchKnowledgeTransportSettings, settings.searchKnowledgeSettings(), clientContext);
    this.generateSuggestionsCallable =
        callableFactory.createUnaryCallable(
            generateSuggestionsTransportSettings,
            settings.generateSuggestionsSettings(),
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
  public UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    return createConversationCallable;
  }

  @Override
  public UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    return listConversationsCallable;
  }

  @Override
  public UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    return listConversationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    return getConversationCallable;
  }

  @Override
  public UnaryCallable<CompleteConversationRequest, Conversation> completeConversationCallable() {
    return completeConversationCallable;
  }

  @Override
  public UnaryCallable<IngestContextReferencesRequest, IngestContextReferencesResponse>
      ingestContextReferencesCallable() {
    return ingestContextReferencesCallable;
  }

  @Override
  public UnaryCallable<BatchCreateMessagesRequest, BatchCreateMessagesResponse>
      batchCreateMessagesCallable() {
    return batchCreateMessagesCallable;
  }

  @Override
  public UnaryCallable<ListMessagesRequest, ListMessagesResponse> listMessagesCallable() {
    return listMessagesCallable;
  }

  @Override
  public UnaryCallable<ListMessagesRequest, ListMessagesPagedResponse> listMessagesPagedCallable() {
    return listMessagesPagedCallable;
  }

  @Override
  public UnaryCallable<SuggestConversationSummaryRequest, SuggestConversationSummaryResponse>
      suggestConversationSummaryCallable() {
    return suggestConversationSummaryCallable;
  }

  @Override
  public UnaryCallable<GenerateStatelessSummaryRequest, GenerateStatelessSummaryResponse>
      generateStatelessSummaryCallable() {
    return generateStatelessSummaryCallable;
  }

  @Override
  public UnaryCallable<GenerateStatelessSuggestionRequest, GenerateStatelessSuggestionResponse>
      generateStatelessSuggestionCallable() {
    return generateStatelessSuggestionCallable;
  }

  @Override
  public UnaryCallable<SearchKnowledgeRequest, SearchKnowledgeResponse> searchKnowledgeCallable() {
    return searchKnowledgeCallable;
  }

  @Override
  public UnaryCallable<GenerateSuggestionsRequest, GenerateSuggestionsResponse>
      generateSuggestionsCallable() {
    return generateSuggestionsCallable;
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
