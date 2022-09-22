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
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
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
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Participants service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonParticipantsStub extends ParticipantsStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<CreateParticipantRequest, Participant>
      createParticipantMethodDescriptor =
          ApiMethodDescriptor.<CreateParticipantRequest, Participant>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/CreateParticipant")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateParticipantRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/conversations/*}/participants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateParticipantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/locations/*/conversations/*}/participants")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateParticipantRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("participant", request.getParticipant(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Participant>newBuilder()
                      .setDefaultInstance(Participant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetParticipantRequest, Participant>
      getParticipantMethodDescriptor =
          ApiMethodDescriptor.<GetParticipantRequest, Participant>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/GetParticipant")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetParticipantRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/conversations/*/participants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetParticipantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{name=projects/*/locations/*/conversations/*/participants/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetParticipantRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Participant>newBuilder()
                      .setDefaultInstance(Participant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsMethodDescriptor =
          ApiMethodDescriptor.<ListParticipantsRequest, ListParticipantsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/ListParticipants")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListParticipantsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/conversations/*}/participants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListParticipantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/locations/*/conversations/*}/participants")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListParticipantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListParticipantsResponse>newBuilder()
                      .setDefaultInstance(ListParticipantsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateParticipantRequest, Participant>
      updateParticipantMethodDescriptor =
          ApiMethodDescriptor.<UpdateParticipantRequest, Participant>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/UpdateParticipant")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateParticipantRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{participant.name=projects/*/conversations/*/participants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateParticipantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "participant.name", request.getParticipant().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{participant.name=projects/*/locations/*/conversations/*/participants/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateParticipantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("participant", request.getParticipant(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Participant>newBuilder()
                      .setDefaultInstance(Participant.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<AnalyzeContentRequest, AnalyzeContentResponse>
      analyzeContentMethodDescriptor =
          ApiMethodDescriptor.<AnalyzeContentRequest, AnalyzeContentResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/AnalyzeContent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AnalyzeContentRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{participant=projects/*/conversations/*/participants/*}:analyzeContent",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeContentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "participant", request.getParticipant());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{participant=projects/*/locations/*/conversations/*/participants/*}:analyzeContent")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<AnalyzeContentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "*", request.toBuilder().clearParticipant().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalyzeContentResponse>newBuilder()
                      .setDefaultInstance(AnalyzeContentResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SuggestArticlesRequest, SuggestArticlesResponse>
      suggestArticlesMethodDescriptor =
          ApiMethodDescriptor.<SuggestArticlesRequest, SuggestArticlesResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/SuggestArticles")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SuggestArticlesRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/conversations/*/participants/*}/suggestions:suggestArticles",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SuggestArticlesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/locations/*/conversations/*/participants/*}/suggestions:suggestArticles")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SuggestArticlesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SuggestArticlesResponse>newBuilder()
                      .setDefaultInstance(SuggestArticlesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
      suggestFaqAnswersMethodDescriptor =
          ApiMethodDescriptor.<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/SuggestFaqAnswers")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SuggestFaqAnswersRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/conversations/*/participants/*}/suggestions:suggestFaqAnswers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SuggestFaqAnswersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/locations/*/conversations/*/participants/*}/suggestions:suggestFaqAnswers")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SuggestFaqAnswersRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SuggestFaqAnswersResponse>newBuilder()
                      .setDefaultInstance(SuggestFaqAnswersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
      suggestSmartRepliesMethodDescriptor =
          ApiMethodDescriptor.<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/SuggestSmartReplies")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SuggestSmartRepliesRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/conversations/*/participants/*}/suggestions:suggestSmartReplies",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SuggestSmartRepliesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v2beta1/{parent=projects/*/locations/*/conversations/*/participants/*}/suggestions:suggestSmartReplies")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SuggestSmartRepliesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SuggestSmartRepliesResponse>newBuilder()
                      .setDefaultInstance(SuggestSmartRepliesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListSuggestionsRequest, ListSuggestionsResponse>
      listSuggestionsMethodDescriptor =
          ApiMethodDescriptor.<ListSuggestionsRequest, ListSuggestionsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/ListSuggestions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListSuggestionsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/conversations/*/participants/*}/suggestions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSuggestionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSuggestionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListSuggestionsResponse>newBuilder()
                      .setDefaultInstance(ListSuggestionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CompileSuggestionRequest, CompileSuggestionResponse>
      compileSuggestionMethodDescriptor =
          ApiMethodDescriptor.<CompileSuggestionRequest, CompileSuggestionResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.v2beta1.Participants/CompileSuggestion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CompileSuggestionRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{parent=projects/*/conversations/*/participants/*}/suggestions:compile",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CompileSuggestionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CompileSuggestionRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CompileSuggestionResponse>newBuilder()
                      .setDefaultInstance(CompileSuggestionResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v2beta1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<CreateParticipantRequest, Participant> createParticipantCallable;
  private final UnaryCallable<GetParticipantRequest, Participant> getParticipantCallable;
  private final UnaryCallable<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsCallable;
  private final UnaryCallable<ListParticipantsRequest, ListParticipantsPagedResponse>
      listParticipantsPagedCallable;
  private final UnaryCallable<UpdateParticipantRequest, Participant> updateParticipantCallable;
  private final UnaryCallable<AnalyzeContentRequest, AnalyzeContentResponse> analyzeContentCallable;
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
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonParticipantsStub create(ParticipantsStubSettings settings)
      throws IOException {
    return new HttpJsonParticipantsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonParticipantsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonParticipantsStub(
        ParticipantsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonParticipantsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonParticipantsStub(
        ParticipantsStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonParticipantsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonParticipantsStub(ParticipantsStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonParticipantsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonParticipantsStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonParticipantsStub(
      ParticipantsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<CreateParticipantRequest, Participant> createParticipantTransportSettings =
        HttpJsonCallSettings.<CreateParticipantRequest, Participant>newBuilder()
            .setMethodDescriptor(createParticipantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetParticipantRequest, Participant> getParticipantTransportSettings =
        HttpJsonCallSettings.<GetParticipantRequest, Participant>newBuilder()
            .setMethodDescriptor(getParticipantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListParticipantsRequest, ListParticipantsResponse>
        listParticipantsTransportSettings =
            HttpJsonCallSettings.<ListParticipantsRequest, ListParticipantsResponse>newBuilder()
                .setMethodDescriptor(listParticipantsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateParticipantRequest, Participant> updateParticipantTransportSettings =
        HttpJsonCallSettings.<UpdateParticipantRequest, Participant>newBuilder()
            .setMethodDescriptor(updateParticipantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<AnalyzeContentRequest, AnalyzeContentResponse>
        analyzeContentTransportSettings =
            HttpJsonCallSettings.<AnalyzeContentRequest, AnalyzeContentResponse>newBuilder()
                .setMethodDescriptor(analyzeContentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SuggestArticlesRequest, SuggestArticlesResponse>
        suggestArticlesTransportSettings =
            HttpJsonCallSettings.<SuggestArticlesRequest, SuggestArticlesResponse>newBuilder()
                .setMethodDescriptor(suggestArticlesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>
        suggestFaqAnswersTransportSettings =
            HttpJsonCallSettings.<SuggestFaqAnswersRequest, SuggestFaqAnswersResponse>newBuilder()
                .setMethodDescriptor(suggestFaqAnswersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>
        suggestSmartRepliesTransportSettings =
            HttpJsonCallSettings
                .<SuggestSmartRepliesRequest, SuggestSmartRepliesResponse>newBuilder()
                .setMethodDescriptor(suggestSmartRepliesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListSuggestionsRequest, ListSuggestionsResponse>
        listSuggestionsTransportSettings =
            HttpJsonCallSettings.<ListSuggestionsRequest, ListSuggestionsResponse>newBuilder()
                .setMethodDescriptor(listSuggestionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CompileSuggestionRequest, CompileSuggestionResponse>
        compileSuggestionTransportSettings =
            HttpJsonCallSettings.<CompileSuggestionRequest, CompileSuggestionResponse>newBuilder()
                .setMethodDescriptor(compileSuggestionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createParticipantMethodDescriptor);
    methodDescriptors.add(getParticipantMethodDescriptor);
    methodDescriptors.add(listParticipantsMethodDescriptor);
    methodDescriptors.add(updateParticipantMethodDescriptor);
    methodDescriptors.add(analyzeContentMethodDescriptor);
    methodDescriptors.add(suggestArticlesMethodDescriptor);
    methodDescriptors.add(suggestFaqAnswersMethodDescriptor);
    methodDescriptors.add(suggestSmartRepliesMethodDescriptor);
    methodDescriptors.add(listSuggestionsMethodDescriptor);
    methodDescriptors.add(compileSuggestionMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
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
