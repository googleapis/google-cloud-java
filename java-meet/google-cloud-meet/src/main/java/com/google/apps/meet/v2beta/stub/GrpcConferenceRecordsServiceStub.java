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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ConferenceRecordsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GrpcConferenceRecordsServiceStub extends ConferenceRecordsServiceStub {
  private static final MethodDescriptor<GetConferenceRecordRequest, ConferenceRecord>
      getConferenceRecordMethodDescriptor =
          MethodDescriptor.<GetConferenceRecordRequest, ConferenceRecord>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/GetConferenceRecord")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConferenceRecordRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ConferenceRecord.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListConferenceRecordsRequest, ListConferenceRecordsResponse>
      listConferenceRecordsMethodDescriptor =
          MethodDescriptor.<ListConferenceRecordsRequest, ListConferenceRecordsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/ListConferenceRecords")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConferenceRecordsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConferenceRecordsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetParticipantRequest, Participant>
      getParticipantMethodDescriptor =
          MethodDescriptor.<GetParticipantRequest, Participant>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/GetParticipant")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetParticipantRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Participant.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListParticipantsRequest, ListParticipantsResponse>
      listParticipantsMethodDescriptor =
          MethodDescriptor.<ListParticipantsRequest, ListParticipantsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/ListParticipants")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListParticipantsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListParticipantsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetParticipantSessionRequest, ParticipantSession>
      getParticipantSessionMethodDescriptor =
          MethodDescriptor.<GetParticipantSessionRequest, ParticipantSession>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/GetParticipantSession")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetParticipantSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ParticipantSession.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListParticipantSessionsRequest, ListParticipantSessionsResponse>
      listParticipantSessionsMethodDescriptor =
          MethodDescriptor
              .<ListParticipantSessionsRequest, ListParticipantSessionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/ListParticipantSessions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListParticipantSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListParticipantSessionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetRecordingRequest, Recording>
      getRecordingMethodDescriptor =
          MethodDescriptor.<GetRecordingRequest, Recording>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/GetRecording")
              .setRequestMarshaller(ProtoUtils.marshaller(GetRecordingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Recording.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListRecordingsRequest, ListRecordingsResponse>
      listRecordingsMethodDescriptor =
          MethodDescriptor.<ListRecordingsRequest, ListRecordingsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/ListRecordings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListRecordingsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListRecordingsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTranscriptRequest, Transcript>
      getTranscriptMethodDescriptor =
          MethodDescriptor.<GetTranscriptRequest, Transcript>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/GetTranscript")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTranscriptRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Transcript.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTranscriptsRequest, ListTranscriptsResponse>
      listTranscriptsMethodDescriptor =
          MethodDescriptor.<ListTranscriptsRequest, ListTranscriptsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.apps.meet.v2beta.ConferenceRecordsService/ListTranscripts")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTranscriptsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTranscriptsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetTranscriptEntryRequest, TranscriptEntry>
      getTranscriptEntryMethodDescriptor =
          MethodDescriptor.<GetTranscriptEntryRequest, TranscriptEntry>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/GetTranscriptEntry")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetTranscriptEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(TranscriptEntry.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>
      listTranscriptEntriesMethodDescriptor =
          MethodDescriptor.<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.apps.meet.v2beta.ConferenceRecordsService/ListTranscriptEntries")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListTranscriptEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListTranscriptEntriesResponse.getDefaultInstance()))
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
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcConferenceRecordsServiceStub create(
      ConferenceRecordsServiceStubSettings settings) throws IOException {
    return new GrpcConferenceRecordsServiceStub(settings, ClientContext.create(settings));
  }

  public static final GrpcConferenceRecordsServiceStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcConferenceRecordsServiceStub(
        ConferenceRecordsServiceStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcConferenceRecordsServiceStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcConferenceRecordsServiceStub(
        ConferenceRecordsServiceStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcConferenceRecordsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConferenceRecordsServiceStub(
      ConferenceRecordsServiceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcConferenceRecordsServiceCallableFactory());
  }

  /**
   * Constructs an instance of GrpcConferenceRecordsServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcConferenceRecordsServiceStub(
      ConferenceRecordsServiceStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetConferenceRecordRequest, ConferenceRecord>
        getConferenceRecordTransportSettings =
            GrpcCallSettings.<GetConferenceRecordRequest, ConferenceRecord>newBuilder()
                .setMethodDescriptor(getConferenceRecordMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListConferenceRecordsRequest, ListConferenceRecordsResponse>
        listConferenceRecordsTransportSettings =
            GrpcCallSettings
                .<ListConferenceRecordsRequest, ListConferenceRecordsResponse>newBuilder()
                .setMethodDescriptor(listConferenceRecordsMethodDescriptor)
                .build();
    GrpcCallSettings<GetParticipantRequest, Participant> getParticipantTransportSettings =
        GrpcCallSettings.<GetParticipantRequest, Participant>newBuilder()
            .setMethodDescriptor(getParticipantMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListParticipantsRequest, ListParticipantsResponse>
        listParticipantsTransportSettings =
            GrpcCallSettings.<ListParticipantsRequest, ListParticipantsResponse>newBuilder()
                .setMethodDescriptor(listParticipantsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetParticipantSessionRequest, ParticipantSession>
        getParticipantSessionTransportSettings =
            GrpcCallSettings.<GetParticipantSessionRequest, ParticipantSession>newBuilder()
                .setMethodDescriptor(getParticipantSessionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListParticipantSessionsRequest, ListParticipantSessionsResponse>
        listParticipantSessionsTransportSettings =
            GrpcCallSettings
                .<ListParticipantSessionsRequest, ListParticipantSessionsResponse>newBuilder()
                .setMethodDescriptor(listParticipantSessionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetRecordingRequest, Recording> getRecordingTransportSettings =
        GrpcCallSettings.<GetRecordingRequest, Recording>newBuilder()
            .setMethodDescriptor(getRecordingMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListRecordingsRequest, ListRecordingsResponse>
        listRecordingsTransportSettings =
            GrpcCallSettings.<ListRecordingsRequest, ListRecordingsResponse>newBuilder()
                .setMethodDescriptor(listRecordingsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetTranscriptRequest, Transcript> getTranscriptTransportSettings =
        GrpcCallSettings.<GetTranscriptRequest, Transcript>newBuilder()
            .setMethodDescriptor(getTranscriptMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListTranscriptsRequest, ListTranscriptsResponse>
        listTranscriptsTransportSettings =
            GrpcCallSettings.<ListTranscriptsRequest, ListTranscriptsResponse>newBuilder()
                .setMethodDescriptor(listTranscriptsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetTranscriptEntryRequest, TranscriptEntry>
        getTranscriptEntryTransportSettings =
            GrpcCallSettings.<GetTranscriptEntryRequest, TranscriptEntry>newBuilder()
                .setMethodDescriptor(getTranscriptEntryMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>
        listTranscriptEntriesTransportSettings =
            GrpcCallSettings
                .<ListTranscriptEntriesRequest, ListTranscriptEntriesResponse>newBuilder()
                .setMethodDescriptor(listTranscriptEntriesMethodDescriptor)
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

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
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
