/*
 * Copyright 2023 Google LLC
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

package com.google.apps.meet.v2beta.stub;

import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListConferenceRecordsPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListParticipantSessionsPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListParticipantsPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListRecordingsPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListTranscriptEntriesPagedResponse;
import static com.google.apps.meet.v2beta.ConferenceRecordsServiceClient.ListTranscriptsPagedResponse;

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
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.apps.meet.v2beta.ConferenceRecord;
import com.google.apps.meet.v2beta.GetConferenceRecordRequest;
import com.google.apps.meet.v2beta.GetParticipantRequest;
import com.google.apps.meet.v2beta.GetParticipantSessionRequest;
import com.google.apps.meet.v2beta.GetRecordingRequest;
import com.google.apps.meet.v2beta.GetTranscriptEntryRequest;
import com.google.apps.meet.v2beta.GetTranscriptRequest;
import com.google.apps.meet.v2beta.ListConferenceRecordsRequest;
import com.google.apps.meet.v2beta.ListConferenceRecordsResponse;
import com.google.apps.meet.v2beta.ListParticipantSessionsRequest;
import com.google.apps.meet.v2beta.ListParticipantSessionsResponse;
import com.google.apps.meet.v2beta.ListParticipantsRequest;
import com.google.apps.meet.v2beta.ListParticipantsResponse;
import com.google.apps.meet.v2beta.ListRecordingsRequest;
import com.google.apps.meet.v2beta.ListRecordingsResponse;
import com.google.apps.meet.v2beta.ListTranscriptEntriesRequest;
import com.google.apps.meet.v2beta.ListTranscriptEntriesResponse;
import com.google.apps.meet.v2beta.ListTranscriptsRequest;
import com.google.apps.meet.v2beta.ListTranscriptsResponse;
import com.google.apps.meet.v2beta.Participant;
import com.google.apps.meet.v2beta.ParticipantSession;
import com.google.apps.meet.v2beta.Recording;
import com.google.apps.meet.v2beta.Transcript;
import com.google.apps.meet.v2beta.TranscriptEntry;
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
 * REST stub implementation for the ConferenceRecordsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonConferenceRecordsServiceStub extends ConferenceRecordsServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<GetConferenceRecordRequest, ConferenceRecord>
      getConferenceRecordMethodDescriptor =
          ApiMethodDescriptor.<GetConferenceRecordRequest, ConferenceRecord>newBuilder()
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/GetConferenceRecord")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConferenceRecordRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=conferenceRecords/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConferenceRecordRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConferenceRecordRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ConferenceRecord>newBuilder()
                      .setDefaultInstance(ConferenceRecord.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListConferenceRecordsRequest, ListConferenceRecordsResponse>
      listConferenceRecordsMethodDescriptor =
          ApiMethodDescriptor
              .<ListConferenceRecordsRequest, ListConferenceRecordsResponse>newBuilder()
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/ListConferenceRecords")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConferenceRecordsRequest>newBuilder()
                      .setPath(
                          "/v2beta/conferenceRecords",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConferenceRecordsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConferenceRecordsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConferenceRecordsResponse>newBuilder()
                      .setDefaultInstance(ListConferenceRecordsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetParticipantRequest, Participant>
      getParticipantMethodDescriptor =
          ApiMethodDescriptor.<GetParticipantRequest, Participant>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/GetParticipant")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetParticipantRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=conferenceRecords/*/participants/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetParticipantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetParticipantRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/ListParticipants")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListParticipantsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=conferenceRecords/*}/participants",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListParticipantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListParticipantsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private static final ApiMethodDescriptor<GetParticipantSessionRequest, ParticipantSession>
      getParticipantSessionMethodDescriptor =
          ApiMethodDescriptor.<GetParticipantSessionRequest, ParticipantSession>newBuilder()
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/GetParticipantSession")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetParticipantSessionRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=conferenceRecords/*/participants/*/participantSessions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetParticipantSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetParticipantSessionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ParticipantSession>newBuilder()
                      .setDefaultInstance(ParticipantSession.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListParticipantSessionsRequest, ListParticipantSessionsResponse>
      listParticipantSessionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListParticipantSessionsRequest, ListParticipantSessionsResponse>newBuilder()
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/ListParticipantSessions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListParticipantSessionsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=conferenceRecords/*/participants/*}/participantSessions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListParticipantSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListParticipantSessionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListParticipantSessionsResponse>newBuilder()
                      .setDefaultInstance(ListParticipantSessionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetRecordingRequest, Recording>
      getRecordingMethodDescriptor =
          ApiMethodDescriptor.<GetRecordingRequest, Recording>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/GetRecording")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetRecordingRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=conferenceRecords/*/recordings/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecordingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetRecordingRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Recording>newBuilder()
                      .setDefaultInstance(Recording.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListRecordingsRequest, ListRecordingsResponse>
      listRecordingsMethodDescriptor =
          ApiMethodDescriptor.<ListRecordingsRequest, ListRecordingsResponse>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/ListRecordings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRecordingsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=conferenceRecords/*}/recordings",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRecordingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRecordingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRecordingsResponse>newBuilder()
                      .setDefaultInstance(ListRecordingsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTranscriptRequest, Transcript>
      getTranscriptMethodDescriptor =
          ApiMethodDescriptor.<GetTranscriptRequest, Transcript>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/GetTranscript")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTranscriptRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=conferenceRecords/*/transcripts/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTranscriptRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTranscriptRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Transcript>newBuilder()
                      .setDefaultInstance(Transcript.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListTranscriptsRequest, ListTranscriptsResponse>
      listTranscriptsMethodDescriptor =
          ApiMethodDescriptor.<ListTranscriptsRequest, ListTranscriptsResponse>newBuilder()
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/ListTranscripts")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTranscriptsRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=conferenceRecords/*}/transcripts",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTranscriptsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTranscriptsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTranscriptsResponse>newBuilder()
                      .setDefaultInstance(ListTranscriptsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTranscriptEntryRequest, TranscriptEntry>
      getTranscriptEntryMethodDescriptor =
          ApiMethodDescriptor.<GetTranscriptEntryRequest, TranscriptEntry>newBuilder()
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/GetTranscriptEntry")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTranscriptEntryRequest>newBuilder()
                      .setPath(
                          "/v2beta/{name=conferenceRecords/*/transcripts/*/entries/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTranscriptEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTranscriptEntryRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TranscriptEntry>newBuilder()
                      .setDefaultInstance(TranscriptEntry.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>
      listTranscriptEntriesMethodDescriptor =
          ApiMethodDescriptor
              .<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>newBuilder()
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/ListTranscriptEntries")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTranscriptEntriesRequest>newBuilder()
                      .setPath(
                          "/v2beta/{parent=conferenceRecords/*/transcripts/*}/entries",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTranscriptEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTranscriptEntriesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTranscriptEntriesResponse>newBuilder()
                      .setDefaultInstance(ListTranscriptEntriesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<GetConferenceRecordRequest, ConferenceRecord>
      getConferenceRecordCallable;
  private final UnaryCallable<ListConferenceRecordsRequest, ListConferenceRecordsResponse>
      listConferenceRecordsCallable;
  private final UnaryCallable<ListConferenceRecordsRequest, ListConferenceRecordsPagedResponse>
      listConferenceRecordsPagedCallable;
  private final UnaryCallable<GetParticipantRequest, Participant> getParticipantCallable;
  private final UnaryCallable<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsCallable;
  private final UnaryCallable<ListParticipantsRequest, ListParticipantsPagedResponse>
      listParticipantsPagedCallable;
  private final UnaryCallable<GetParticipantSessionRequest, ParticipantSession>
      getParticipantSessionCallable;
  private final UnaryCallable<ListParticipantSessionsRequest, ListParticipantSessionsResponse>
      listParticipantSessionsCallable;
  private final UnaryCallable<ListParticipantSessionsRequest, ListParticipantSessionsPagedResponse>
      listParticipantSessionsPagedCallable;
  private final UnaryCallable<GetRecordingRequest, Recording> getRecordingCallable;
  private final UnaryCallable<ListRecordingsRequest, ListRecordingsResponse> listRecordingsCallable;
  private final UnaryCallable<ListRecordingsRequest, ListRecordingsPagedResponse>
      listRecordingsPagedCallable;
  private final UnaryCallable<GetTranscriptRequest, Transcript> getTranscriptCallable;
  private final UnaryCallable<ListTranscriptsRequest, ListTranscriptsResponse>
      listTranscriptsCallable;
  private final UnaryCallable<ListTranscriptsRequest, ListTranscriptsPagedResponse>
      listTranscriptsPagedCallable;
  private final UnaryCallable<GetTranscriptEntryRequest, TranscriptEntry>
      getTranscriptEntryCallable;
  private final UnaryCallable<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>
      listTranscriptEntriesCallable;
  private final UnaryCallable<ListTranscriptEntriesRequest, ListTranscriptEntriesPagedResponse>
      listTranscriptEntriesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonConferenceRecordsServiceStub create(
      ConferenceRecordsServiceStubSettings settings) throws IOException {
    return new HttpJsonConferenceRecordsServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonConferenceRecordsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonConferenceRecordsServiceStub(
        ConferenceRecordsServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonConferenceRecordsServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonConferenceRecordsServiceStub(
        ConferenceRecordsServiceStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonConferenceRecordsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConferenceRecordsServiceStub(
      ConferenceRecordsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonConferenceRecordsServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonConferenceRecordsServiceStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonConferenceRecordsServiceStub(
      ConferenceRecordsServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<GetConferenceRecordRequest, ConferenceRecord>
        getConferenceRecordTransportSettings =
            HttpJsonCallSettings.<GetConferenceRecordRequest, ConferenceRecord>newBuilder()
                .setMethodDescriptor(getConferenceRecordMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListConferenceRecordsRequest, ListConferenceRecordsResponse>
        listConferenceRecordsTransportSettings =
            HttpJsonCallSettings
                .<ListConferenceRecordsRequest, ListConferenceRecordsResponse>newBuilder()
                .setMethodDescriptor(listConferenceRecordsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetParticipantRequest, Participant> getParticipantTransportSettings =
        HttpJsonCallSettings.<GetParticipantRequest, Participant>newBuilder()
            .setMethodDescriptor(getParticipantMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListParticipantsRequest, ListParticipantsResponse>
        listParticipantsTransportSettings =
            HttpJsonCallSettings.<ListParticipantsRequest, ListParticipantsResponse>newBuilder()
                .setMethodDescriptor(listParticipantsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetParticipantSessionRequest, ParticipantSession>
        getParticipantSessionTransportSettings =
            HttpJsonCallSettings.<GetParticipantSessionRequest, ParticipantSession>newBuilder()
                .setMethodDescriptor(getParticipantSessionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListParticipantSessionsRequest, ListParticipantSessionsResponse>
        listParticipantSessionsTransportSettings =
            HttpJsonCallSettings
                .<ListParticipantSessionsRequest, ListParticipantSessionsResponse>newBuilder()
                .setMethodDescriptor(listParticipantSessionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetRecordingRequest, Recording> getRecordingTransportSettings =
        HttpJsonCallSettings.<GetRecordingRequest, Recording>newBuilder()
            .setMethodDescriptor(getRecordingMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRecordingsRequest, ListRecordingsResponse>
        listRecordingsTransportSettings =
            HttpJsonCallSettings.<ListRecordingsRequest, ListRecordingsResponse>newBuilder()
                .setMethodDescriptor(listRecordingsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTranscriptRequest, Transcript> getTranscriptTransportSettings =
        HttpJsonCallSettings.<GetTranscriptRequest, Transcript>newBuilder()
            .setMethodDescriptor(getTranscriptMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListTranscriptsRequest, ListTranscriptsResponse>
        listTranscriptsTransportSettings =
            HttpJsonCallSettings.<ListTranscriptsRequest, ListTranscriptsResponse>newBuilder()
                .setMethodDescriptor(listTranscriptsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetTranscriptEntryRequest, TranscriptEntry>
        getTranscriptEntryTransportSettings =
            HttpJsonCallSettings.<GetTranscriptEntryRequest, TranscriptEntry>newBuilder()
                .setMethodDescriptor(getTranscriptEntryMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>
        listTranscriptEntriesTransportSettings =
            HttpJsonCallSettings
                .<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>newBuilder()
                .setMethodDescriptor(listTranscriptEntriesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.getConferenceRecordCallable =
        callableFactory.createUnaryCallable(
            getConferenceRecordTransportSettings,
            settings.getConferenceRecordSettings(),
            clientContext);
    this.listConferenceRecordsCallable =
        callableFactory.createUnaryCallable(
            listConferenceRecordsTransportSettings,
            settings.listConferenceRecordsSettings(),
            clientContext);
    this.listConferenceRecordsPagedCallable =
        callableFactory.createPagedCallable(
            listConferenceRecordsTransportSettings,
            settings.listConferenceRecordsSettings(),
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
    this.getParticipantSessionCallable =
        callableFactory.createUnaryCallable(
            getParticipantSessionTransportSettings,
            settings.getParticipantSessionSettings(),
            clientContext);
    this.listParticipantSessionsCallable =
        callableFactory.createUnaryCallable(
            listParticipantSessionsTransportSettings,
            settings.listParticipantSessionsSettings(),
            clientContext);
    this.listParticipantSessionsPagedCallable =
        callableFactory.createPagedCallable(
            listParticipantSessionsTransportSettings,
            settings.listParticipantSessionsSettings(),
            clientContext);
    this.getRecordingCallable =
        callableFactory.createUnaryCallable(
            getRecordingTransportSettings, settings.getRecordingSettings(), clientContext);
    this.listRecordingsCallable =
        callableFactory.createUnaryCallable(
            listRecordingsTransportSettings, settings.listRecordingsSettings(), clientContext);
    this.listRecordingsPagedCallable =
        callableFactory.createPagedCallable(
            listRecordingsTransportSettings, settings.listRecordingsSettings(), clientContext);
    this.getTranscriptCallable =
        callableFactory.createUnaryCallable(
            getTranscriptTransportSettings, settings.getTranscriptSettings(), clientContext);
    this.listTranscriptsCallable =
        callableFactory.createUnaryCallable(
            listTranscriptsTransportSettings, settings.listTranscriptsSettings(), clientContext);
    this.listTranscriptsPagedCallable =
        callableFactory.createPagedCallable(
            listTranscriptsTransportSettings, settings.listTranscriptsSettings(), clientContext);
    this.getTranscriptEntryCallable =
        callableFactory.createUnaryCallable(
            getTranscriptEntryTransportSettings,
            settings.getTranscriptEntrySettings(),
            clientContext);
    this.listTranscriptEntriesCallable =
        callableFactory.createUnaryCallable(
            listTranscriptEntriesTransportSettings,
            settings.listTranscriptEntriesSettings(),
            clientContext);
    this.listTranscriptEntriesPagedCallable =
        callableFactory.createPagedCallable(
            listTranscriptEntriesTransportSettings,
            settings.listTranscriptEntriesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(getConferenceRecordMethodDescriptor);
    methodDescriptors.add(listConferenceRecordsMethodDescriptor);
    methodDescriptors.add(getParticipantMethodDescriptor);
    methodDescriptors.add(listParticipantsMethodDescriptor);
    methodDescriptors.add(getParticipantSessionMethodDescriptor);
    methodDescriptors.add(listParticipantSessionsMethodDescriptor);
    methodDescriptors.add(getRecordingMethodDescriptor);
    methodDescriptors.add(listRecordingsMethodDescriptor);
    methodDescriptors.add(getTranscriptMethodDescriptor);
    methodDescriptors.add(listTranscriptsMethodDescriptor);
    methodDescriptors.add(getTranscriptEntryMethodDescriptor);
    methodDescriptors.add(listTranscriptEntriesMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<GetConferenceRecordRequest, ConferenceRecord> getConferenceRecordCallable() {
    return getConferenceRecordCallable;
  }

  @Override
  public UnaryCallable<ListConferenceRecordsRequest, ListConferenceRecordsResponse>
      listConferenceRecordsCallable() {
    return listConferenceRecordsCallable;
  }

  @Override
  public UnaryCallable<ListConferenceRecordsRequest, ListConferenceRecordsPagedResponse>
      listConferenceRecordsPagedCallable() {
    return listConferenceRecordsPagedCallable;
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
  public UnaryCallable<GetParticipantSessionRequest, ParticipantSession>
      getParticipantSessionCallable() {
    return getParticipantSessionCallable;
  }

  @Override
  public UnaryCallable<ListParticipantSessionsRequest, ListParticipantSessionsResponse>
      listParticipantSessionsCallable() {
    return listParticipantSessionsCallable;
  }

  @Override
  public UnaryCallable<ListParticipantSessionsRequest, ListParticipantSessionsPagedResponse>
      listParticipantSessionsPagedCallable() {
    return listParticipantSessionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetRecordingRequest, Recording> getRecordingCallable() {
    return getRecordingCallable;
  }

  @Override
  public UnaryCallable<ListRecordingsRequest, ListRecordingsResponse> listRecordingsCallable() {
    return listRecordingsCallable;
  }

  @Override
  public UnaryCallable<ListRecordingsRequest, ListRecordingsPagedResponse>
      listRecordingsPagedCallable() {
    return listRecordingsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTranscriptRequest, Transcript> getTranscriptCallable() {
    return getTranscriptCallable;
  }

  @Override
  public UnaryCallable<ListTranscriptsRequest, ListTranscriptsResponse> listTranscriptsCallable() {
    return listTranscriptsCallable;
  }

  @Override
  public UnaryCallable<ListTranscriptsRequest, ListTranscriptsPagedResponse>
      listTranscriptsPagedCallable() {
    return listTranscriptsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTranscriptEntryRequest, TranscriptEntry> getTranscriptEntryCallable() {
    return getTranscriptEntryCallable;
  }

  @Override
  public UnaryCallable<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>
      listTranscriptEntriesCallable() {
    return listTranscriptEntriesCallable;
  }

  @Override
  public UnaryCallable<ListTranscriptEntriesRequest, ListTranscriptEntriesPagedResponse>
      listTranscriptEntriesPagedCallable() {
    return listTranscriptEntriesPagedCallable;
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
