/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.devtools.containeranalysis.v1beta1.stub;

import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListNoteOccurrencesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListNotesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1beta1.GrafeasV1Beta1Client.ListOccurrencesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsExtractor;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.Empty;
import io.grafeas.v1beta1.BatchCreateNotesRequest;
import io.grafeas.v1beta1.BatchCreateNotesResponse;
import io.grafeas.v1beta1.BatchCreateOccurrencesRequest;
import io.grafeas.v1beta1.BatchCreateOccurrencesResponse;
import io.grafeas.v1beta1.CreateNoteRequest;
import io.grafeas.v1beta1.CreateOccurrenceRequest;
import io.grafeas.v1beta1.DeleteNoteRequest;
import io.grafeas.v1beta1.DeleteOccurrenceRequest;
import io.grafeas.v1beta1.GetNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceNoteRequest;
import io.grafeas.v1beta1.GetOccurrenceRequest;
import io.grafeas.v1beta1.GetVulnerabilityOccurrencesSummaryRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesRequest;
import io.grafeas.v1beta1.ListNoteOccurrencesResponse;
import io.grafeas.v1beta1.ListNotesRequest;
import io.grafeas.v1beta1.ListNotesResponse;
import io.grafeas.v1beta1.ListOccurrencesRequest;
import io.grafeas.v1beta1.ListOccurrencesResponse;
import io.grafeas.v1beta1.Note;
import io.grafeas.v1beta1.Occurrence;
import io.grafeas.v1beta1.UpdateNoteRequest;
import io.grafeas.v1beta1.UpdateOccurrenceRequest;
import io.grafeas.v1beta1.VulnerabilityOccurrencesSummary;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * gRPC stub implementation for Container Analysis API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class GrpcGrafeasV1Beta1Stub extends GrafeasV1Beta1Stub {

  private static final MethodDescriptor<GetOccurrenceRequest, Occurrence>
      getOccurrenceMethodDescriptor =
          MethodDescriptor.<GetOccurrenceRequest, Occurrence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/GetOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Occurrence.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListOccurrencesRequest, ListOccurrencesResponse>
      listOccurrencesMethodDescriptor =
          MethodDescriptor.<ListOccurrencesRequest, ListOccurrencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/ListOccurrences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOccurrencesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteOccurrenceRequest, Empty>
      deleteOccurrenceMethodDescriptor =
          MethodDescriptor.<DeleteOccurrenceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/DeleteOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateOccurrenceRequest, Occurrence>
      createOccurrenceMethodDescriptor =
          MethodDescriptor.<CreateOccurrenceRequest, Occurrence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/CreateOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Occurrence.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<
          BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesMethodDescriptor =
          MethodDescriptor
              .<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/BatchCreateOccurrences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateOccurrencesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateOccurrenceRequest, Occurrence>
      updateOccurrenceMethodDescriptor =
          MethodDescriptor.<UpdateOccurrenceRequest, Occurrence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/UpdateOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Occurrence.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetOccurrenceNoteRequest, Note>
      getOccurrenceNoteMethodDescriptor =
          MethodDescriptor.<GetOccurrenceNoteRequest, Note>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/GetOccurrenceNote")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOccurrenceNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetNoteRequest, Note> getNoteMethodDescriptor =
      MethodDescriptor.<GetNoteRequest, Note>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/GetNote")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListNotesRequest, ListNotesResponse>
      listNotesMethodDescriptor =
          MethodDescriptor.<ListNotesRequest, ListNotesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/ListNotes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListNotesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteNoteRequest, Empty> deleteNoteMethodDescriptor =
      MethodDescriptor.<DeleteNoteRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/DeleteNote")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<CreateNoteRequest, Note> createNoteMethodDescriptor =
      MethodDescriptor.<CreateNoteRequest, Note>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/CreateNote")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesMethodDescriptor =
          MethodDescriptor.<BatchCreateNotesRequest, BatchCreateNotesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/BatchCreateNotes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateNotesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateNoteRequest, Note> updateNoteMethodDescriptor =
      MethodDescriptor.<UpdateNoteRequest, Note>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/UpdateNote")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesMethodDescriptor =
          MethodDescriptor.<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1beta1.GrafeasV1Beta1/ListNoteOccurrences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNoteOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNoteOccurrencesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<
          GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
      getVulnerabilityOccurrencesSummaryMethodDescriptor =
          MethodDescriptor
              .<GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "grafeas.v1beta1.GrafeasV1Beta1/GetVulnerabilityOccurrencesSummary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(
                      GetVulnerabilityOccurrencesSummaryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(VulnerabilityOccurrencesSummary.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetOccurrenceRequest, Occurrence> getOccurrenceCallable;
  private final UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse>
      listOccurrencesCallable;
  private final UnaryCallable<ListOccurrencesRequest, ListOccurrencesPagedResponse>
      listOccurrencesPagedCallable;
  private final UnaryCallable<DeleteOccurrenceRequest, Empty> deleteOccurrenceCallable;
  private final UnaryCallable<CreateOccurrenceRequest, Occurrence> createOccurrenceCallable;
  private final UnaryCallable<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesCallable;
  private final UnaryCallable<UpdateOccurrenceRequest, Occurrence> updateOccurrenceCallable;
  private final UnaryCallable<GetOccurrenceNoteRequest, Note> getOccurrenceNoteCallable;
  private final UnaryCallable<GetNoteRequest, Note> getNoteCallable;
  private final UnaryCallable<ListNotesRequest, ListNotesResponse> listNotesCallable;
  private final UnaryCallable<ListNotesRequest, ListNotesPagedResponse> listNotesPagedCallable;
  private final UnaryCallable<DeleteNoteRequest, Empty> deleteNoteCallable;
  private final UnaryCallable<CreateNoteRequest, Note> createNoteCallable;
  private final UnaryCallable<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesCallable;
  private final UnaryCallable<UpdateNoteRequest, Note> updateNoteCallable;
  private final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesCallable;
  private final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesPagedCallable;
  private final UnaryCallable<
          GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
      getVulnerabilityOccurrencesSummaryCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGrafeasV1Beta1Stub create(GrafeasV1Beta1StubSettings settings)
      throws IOException {
    return new GrpcGrafeasV1Beta1Stub(settings, ClientContext.create(settings));
  }

  public static final GrpcGrafeasV1Beta1Stub create(ClientContext clientContext)
      throws IOException {
    return new GrpcGrafeasV1Beta1Stub(
        GrafeasV1Beta1StubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGrafeasV1Beta1Stub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGrafeasV1Beta1Stub(
        GrafeasV1Beta1StubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGrafeasV1Beta1Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGrafeasV1Beta1Stub(GrafeasV1Beta1StubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGrafeasV1Beta1CallableFactory());
  }

  /**
   * Constructs an instance of GrpcGrafeasV1Beta1Stub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcGrafeasV1Beta1Stub(
      GrafeasV1Beta1StubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<GetOccurrenceRequest, Occurrence> getOccurrenceTransportSettings =
        GrpcCallSettings.<GetOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(getOccurrenceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetOccurrenceRequest>() {
                  @Override
                  public Map<String, String> extract(GetOccurrenceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListOccurrencesRequest, ListOccurrencesResponse>
        listOccurrencesTransportSettings =
            GrpcCallSettings.<ListOccurrencesRequest, ListOccurrencesResponse>newBuilder()
                .setMethodDescriptor(listOccurrencesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListOccurrencesRequest>() {
                      @Override
                      public Map<String, String> extract(ListOccurrencesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteOccurrenceRequest, Empty> deleteOccurrenceTransportSettings =
        GrpcCallSettings.<DeleteOccurrenceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteOccurrenceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteOccurrenceRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteOccurrenceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateOccurrenceRequest, Occurrence> createOccurrenceTransportSettings =
        GrpcCallSettings.<CreateOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(createOccurrenceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateOccurrenceRequest>() {
                  @Override
                  public Map<String, String> extract(CreateOccurrenceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
        batchCreateOccurrencesTransportSettings =
            GrpcCallSettings
                .<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>newBuilder()
                .setMethodDescriptor(batchCreateOccurrencesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchCreateOccurrencesRequest>() {
                      @Override
                      public Map<String, String> extract(BatchCreateOccurrencesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateOccurrenceRequest, Occurrence> updateOccurrenceTransportSettings =
        GrpcCallSettings.<UpdateOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(updateOccurrenceMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateOccurrenceRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateOccurrenceRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetOccurrenceNoteRequest, Note> getOccurrenceNoteTransportSettings =
        GrpcCallSettings.<GetOccurrenceNoteRequest, Note>newBuilder()
            .setMethodDescriptor(getOccurrenceNoteMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetOccurrenceNoteRequest>() {
                  @Override
                  public Map<String, String> extract(GetOccurrenceNoteRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetNoteRequest, Note> getNoteTransportSettings =
        GrpcCallSettings.<GetNoteRequest, Note>newBuilder()
            .setMethodDescriptor(getNoteMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetNoteRequest>() {
                  @Override
                  public Map<String, String> extract(GetNoteRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListNotesRequest, ListNotesResponse> listNotesTransportSettings =
        GrpcCallSettings.<ListNotesRequest, ListNotesResponse>newBuilder()
            .setMethodDescriptor(listNotesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListNotesRequest>() {
                  @Override
                  public Map<String, String> extract(ListNotesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteNoteRequest, Empty> deleteNoteTransportSettings =
        GrpcCallSettings.<DeleteNoteRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteNoteMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteNoteRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteNoteRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateNoteRequest, Note> createNoteTransportSettings =
        GrpcCallSettings.<CreateNoteRequest, Note>newBuilder()
            .setMethodDescriptor(createNoteMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateNoteRequest>() {
                  @Override
                  public Map<String, String> extract(CreateNoteRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<BatchCreateNotesRequest, BatchCreateNotesResponse>
        batchCreateNotesTransportSettings =
            GrpcCallSettings.<BatchCreateNotesRequest, BatchCreateNotesResponse>newBuilder()
                .setMethodDescriptor(batchCreateNotesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<BatchCreateNotesRequest>() {
                      @Override
                      public Map<String, String> extract(BatchCreateNotesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<UpdateNoteRequest, Note> updateNoteTransportSettings =
        GrpcCallSettings.<UpdateNoteRequest, Note>newBuilder()
            .setMethodDescriptor(updateNoteMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateNoteRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateNoteRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
        listNoteOccurrencesTransportSettings =
            GrpcCallSettings.<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>newBuilder()
                .setMethodDescriptor(listNoteOccurrencesMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListNoteOccurrencesRequest>() {
                      @Override
                      public Map<String, String> extract(ListNoteOccurrencesRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("name", String.valueOf(request.getName()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
        getVulnerabilityOccurrencesSummaryTransportSettings =
            GrpcCallSettings
                .<GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
                    newBuilder()
                .setMethodDescriptor(getVulnerabilityOccurrencesSummaryMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<GetVulnerabilityOccurrencesSummaryRequest>() {
                      @Override
                      public Map<String, String> extract(
                          GetVulnerabilityOccurrencesSummaryRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();

    this.getOccurrenceCallable =
        callableFactory.createUnaryCallable(
            getOccurrenceTransportSettings, settings.getOccurrenceSettings(), clientContext);
    this.listOccurrencesCallable =
        callableFactory.createUnaryCallable(
            listOccurrencesTransportSettings, settings.listOccurrencesSettings(), clientContext);
    this.listOccurrencesPagedCallable =
        callableFactory.createPagedCallable(
            listOccurrencesTransportSettings, settings.listOccurrencesSettings(), clientContext);
    this.deleteOccurrenceCallable =
        callableFactory.createUnaryCallable(
            deleteOccurrenceTransportSettings, settings.deleteOccurrenceSettings(), clientContext);
    this.createOccurrenceCallable =
        callableFactory.createUnaryCallable(
            createOccurrenceTransportSettings, settings.createOccurrenceSettings(), clientContext);
    this.batchCreateOccurrencesCallable =
        callableFactory.createUnaryCallable(
            batchCreateOccurrencesTransportSettings,
            settings.batchCreateOccurrencesSettings(),
            clientContext);
    this.updateOccurrenceCallable =
        callableFactory.createUnaryCallable(
            updateOccurrenceTransportSettings, settings.updateOccurrenceSettings(), clientContext);
    this.getOccurrenceNoteCallable =
        callableFactory.createUnaryCallable(
            getOccurrenceNoteTransportSettings,
            settings.getOccurrenceNoteSettings(),
            clientContext);
    this.getNoteCallable =
        callableFactory.createUnaryCallable(
            getNoteTransportSettings, settings.getNoteSettings(), clientContext);
    this.listNotesCallable =
        callableFactory.createUnaryCallable(
            listNotesTransportSettings, settings.listNotesSettings(), clientContext);
    this.listNotesPagedCallable =
        callableFactory.createPagedCallable(
            listNotesTransportSettings, settings.listNotesSettings(), clientContext);
    this.deleteNoteCallable =
        callableFactory.createUnaryCallable(
            deleteNoteTransportSettings, settings.deleteNoteSettings(), clientContext);
    this.createNoteCallable =
        callableFactory.createUnaryCallable(
            createNoteTransportSettings, settings.createNoteSettings(), clientContext);
    this.batchCreateNotesCallable =
        callableFactory.createUnaryCallable(
            batchCreateNotesTransportSettings, settings.batchCreateNotesSettings(), clientContext);
    this.updateNoteCallable =
        callableFactory.createUnaryCallable(
            updateNoteTransportSettings, settings.updateNoteSettings(), clientContext);
    this.listNoteOccurrencesCallable =
        callableFactory.createUnaryCallable(
            listNoteOccurrencesTransportSettings,
            settings.listNoteOccurrencesSettings(),
            clientContext);
    this.listNoteOccurrencesPagedCallable =
        callableFactory.createPagedCallable(
            listNoteOccurrencesTransportSettings,
            settings.listNoteOccurrencesSettings(),
            clientContext);
    this.getVulnerabilityOccurrencesSummaryCallable =
        callableFactory.createUnaryCallable(
            getVulnerabilityOccurrencesSummaryTransportSettings,
            settings.getVulnerabilityOccurrencesSummarySettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<GetOccurrenceRequest, Occurrence> getOccurrenceCallable() {
    return getOccurrenceCallable;
  }

  public UnaryCallable<ListOccurrencesRequest, ListOccurrencesPagedResponse>
      listOccurrencesPagedCallable() {
    return listOccurrencesPagedCallable;
  }

  public UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse> listOccurrencesCallable() {
    return listOccurrencesCallable;
  }

  public UnaryCallable<DeleteOccurrenceRequest, Empty> deleteOccurrenceCallable() {
    return deleteOccurrenceCallable;
  }

  public UnaryCallable<CreateOccurrenceRequest, Occurrence> createOccurrenceCallable() {
    return createOccurrenceCallable;
  }

  public UnaryCallable<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesCallable() {
    return batchCreateOccurrencesCallable;
  }

  public UnaryCallable<UpdateOccurrenceRequest, Occurrence> updateOccurrenceCallable() {
    return updateOccurrenceCallable;
  }

  public UnaryCallable<GetOccurrenceNoteRequest, Note> getOccurrenceNoteCallable() {
    return getOccurrenceNoteCallable;
  }

  public UnaryCallable<GetNoteRequest, Note> getNoteCallable() {
    return getNoteCallable;
  }

  public UnaryCallable<ListNotesRequest, ListNotesPagedResponse> listNotesPagedCallable() {
    return listNotesPagedCallable;
  }

  public UnaryCallable<ListNotesRequest, ListNotesResponse> listNotesCallable() {
    return listNotesCallable;
  }

  public UnaryCallable<DeleteNoteRequest, Empty> deleteNoteCallable() {
    return deleteNoteCallable;
  }

  public UnaryCallable<CreateNoteRequest, Note> createNoteCallable() {
    return createNoteCallable;
  }

  public UnaryCallable<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesCallable() {
    return batchCreateNotesCallable;
  }

  public UnaryCallable<UpdateNoteRequest, Note> updateNoteCallable() {
    return updateNoteCallable;
  }

  public UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesPagedCallable() {
    return listNoteOccurrencesPagedCallable;
  }

  public UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesCallable() {
    return listNoteOccurrencesCallable;
  }

  public UnaryCallable<GetVulnerabilityOccurrencesSummaryRequest, VulnerabilityOccurrencesSummary>
      getVulnerabilityOccurrencesSummaryCallable() {
    return getVulnerabilityOccurrencesSummaryCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
