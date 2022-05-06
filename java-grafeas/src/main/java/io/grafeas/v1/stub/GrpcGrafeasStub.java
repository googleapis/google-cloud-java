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

package io.grafeas.v1.stub;

import static io.grafeas.v1.GrafeasClient.ListNoteOccurrencesPagedResponse;
import static io.grafeas.v1.GrafeasClient.ListNotesPagedResponse;
import static io.grafeas.v1.GrafeasClient.ListOccurrencesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grafeas.v1.BatchCreateNotesRequest;
import io.grafeas.v1.BatchCreateNotesResponse;
import io.grafeas.v1.BatchCreateOccurrencesRequest;
import io.grafeas.v1.BatchCreateOccurrencesResponse;
import io.grafeas.v1.CreateNoteRequest;
import io.grafeas.v1.CreateOccurrenceRequest;
import io.grafeas.v1.DeleteNoteRequest;
import io.grafeas.v1.DeleteOccurrenceRequest;
import io.grafeas.v1.GetNoteRequest;
import io.grafeas.v1.GetOccurrenceNoteRequest;
import io.grafeas.v1.GetOccurrenceRequest;
import io.grafeas.v1.ListNoteOccurrencesRequest;
import io.grafeas.v1.ListNoteOccurrencesResponse;
import io.grafeas.v1.ListNotesRequest;
import io.grafeas.v1.ListNotesResponse;
import io.grafeas.v1.ListOccurrencesRequest;
import io.grafeas.v1.ListOccurrencesResponse;
import io.grafeas.v1.Note;
import io.grafeas.v1.Occurrence;
import io.grafeas.v1.UpdateNoteRequest;
import io.grafeas.v1.UpdateOccurrenceRequest;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the Grafeas service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcGrafeasStub extends GrafeasStub {
  private static final MethodDescriptor<GetOccurrenceRequest, Occurrence>
      getOccurrenceMethodDescriptor =
          MethodDescriptor.<GetOccurrenceRequest, Occurrence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1.Grafeas/GetOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Occurrence.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListOccurrencesRequest, ListOccurrencesResponse>
      listOccurrencesMethodDescriptor =
          MethodDescriptor.<ListOccurrencesRequest, ListOccurrencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1.Grafeas/ListOccurrences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOccurrencesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteOccurrenceRequest, Empty>
      deleteOccurrenceMethodDescriptor =
          MethodDescriptor.<DeleteOccurrenceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1.Grafeas/DeleteOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateOccurrenceRequest, Occurrence>
      createOccurrenceMethodDescriptor =
          MethodDescriptor.<CreateOccurrenceRequest, Occurrence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1.Grafeas/CreateOccurrence")
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
              .setFullMethodName("grafeas.v1.Grafeas/BatchCreateOccurrences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateOccurrencesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateOccurrenceRequest, Occurrence>
      updateOccurrenceMethodDescriptor =
          MethodDescriptor.<UpdateOccurrenceRequest, Occurrence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1.Grafeas/UpdateOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Occurrence.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetOccurrenceNoteRequest, Note>
      getOccurrenceNoteMethodDescriptor =
          MethodDescriptor.<GetOccurrenceNoteRequest, Note>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1.Grafeas/GetOccurrenceNote")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOccurrenceNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetNoteRequest, Note> getNoteMethodDescriptor =
      MethodDescriptor.<GetNoteRequest, Note>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("grafeas.v1.Grafeas/GetNote")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListNotesRequest, ListNotesResponse>
      listNotesMethodDescriptor =
          MethodDescriptor.<ListNotesRequest, ListNotesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1.Grafeas/ListNotes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListNotesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteNoteRequest, Empty> deleteNoteMethodDescriptor =
      MethodDescriptor.<DeleteNoteRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("grafeas.v1.Grafeas/DeleteNote")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<CreateNoteRequest, Note> createNoteMethodDescriptor =
      MethodDescriptor.<CreateNoteRequest, Note>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("grafeas.v1.Grafeas/CreateNote")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesMethodDescriptor =
          MethodDescriptor.<BatchCreateNotesRequest, BatchCreateNotesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1.Grafeas/BatchCreateNotes")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BatchCreateNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(BatchCreateNotesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateNoteRequest, Note> updateNoteMethodDescriptor =
      MethodDescriptor.<UpdateNoteRequest, Note>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("grafeas.v1.Grafeas/UpdateNote")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesMethodDescriptor =
          MethodDescriptor.<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("grafeas.v1.Grafeas/ListNoteOccurrences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNoteOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNoteOccurrencesResponse.getDefaultInstance()))
              .build();

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

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcGrafeasStub create(GrafeasStubSettings settings) throws IOException {
    return new GrpcGrafeasStub(settings, ClientContext.create(settings));
  }

  public static final GrpcGrafeasStub create(ClientContext clientContext) throws IOException {
    return new GrpcGrafeasStub(GrafeasStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcGrafeasStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcGrafeasStub(
        GrafeasStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcGrafeasStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcGrafeasStub(GrafeasStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new GrpcGrafeasCallableFactory());
  }

  /**
   * Constructs an instance of GrpcGrafeasStub, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected GrpcGrafeasStub(
      GrafeasStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<GetOccurrenceRequest, Occurrence> getOccurrenceTransportSettings =
        GrpcCallSettings.<GetOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(getOccurrenceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListOccurrencesRequest, ListOccurrencesResponse>
        listOccurrencesTransportSettings =
            GrpcCallSettings.<ListOccurrencesRequest, ListOccurrencesResponse>newBuilder()
                .setMethodDescriptor(listOccurrencesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteOccurrenceRequest, Empty> deleteOccurrenceTransportSettings =
        GrpcCallSettings.<DeleteOccurrenceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteOccurrenceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateOccurrenceRequest, Occurrence> createOccurrenceTransportSettings =
        GrpcCallSettings.<CreateOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(createOccurrenceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
        batchCreateOccurrencesTransportSettings =
            GrpcCallSettings
                .<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>newBuilder()
                .setMethodDescriptor(batchCreateOccurrencesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateOccurrenceRequest, Occurrence> updateOccurrenceTransportSettings =
        GrpcCallSettings.<UpdateOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(updateOccurrenceMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetOccurrenceNoteRequest, Note> getOccurrenceNoteTransportSettings =
        GrpcCallSettings.<GetOccurrenceNoteRequest, Note>newBuilder()
            .setMethodDescriptor(getOccurrenceNoteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetNoteRequest, Note> getNoteTransportSettings =
        GrpcCallSettings.<GetNoteRequest, Note>newBuilder()
            .setMethodDescriptor(getNoteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListNotesRequest, ListNotesResponse> listNotesTransportSettings =
        GrpcCallSettings.<ListNotesRequest, ListNotesResponse>newBuilder()
            .setMethodDescriptor(listNotesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteNoteRequest, Empty> deleteNoteTransportSettings =
        GrpcCallSettings.<DeleteNoteRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteNoteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateNoteRequest, Note> createNoteTransportSettings =
        GrpcCallSettings.<CreateNoteRequest, Note>newBuilder()
            .setMethodDescriptor(createNoteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BatchCreateNotesRequest, BatchCreateNotesResponse>
        batchCreateNotesTransportSettings =
            GrpcCallSettings.<BatchCreateNotesRequest, BatchCreateNotesResponse>newBuilder()
                .setMethodDescriptor(batchCreateNotesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<UpdateNoteRequest, Note> updateNoteTransportSettings =
        GrpcCallSettings.<UpdateNoteRequest, Note>newBuilder()
            .setMethodDescriptor(updateNoteMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
        listNoteOccurrencesTransportSettings =
            GrpcCallSettings.<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>newBuilder()
                .setMethodDescriptor(listNoteOccurrencesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("name", String.valueOf(request.getName()));
                      return params.build();
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

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<GetOccurrenceRequest, Occurrence> getOccurrenceCallable() {
    return getOccurrenceCallable;
  }

  @Override
  public UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse> listOccurrencesCallable() {
    return listOccurrencesCallable;
  }

  @Override
  public UnaryCallable<ListOccurrencesRequest, ListOccurrencesPagedResponse>
      listOccurrencesPagedCallable() {
    return listOccurrencesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteOccurrenceRequest, Empty> deleteOccurrenceCallable() {
    return deleteOccurrenceCallable;
  }

  @Override
  public UnaryCallable<CreateOccurrenceRequest, Occurrence> createOccurrenceCallable() {
    return createOccurrenceCallable;
  }

  @Override
  public UnaryCallable<BatchCreateOccurrencesRequest, BatchCreateOccurrencesResponse>
      batchCreateOccurrencesCallable() {
    return batchCreateOccurrencesCallable;
  }

  @Override
  public UnaryCallable<UpdateOccurrenceRequest, Occurrence> updateOccurrenceCallable() {
    return updateOccurrenceCallable;
  }

  @Override
  public UnaryCallable<GetOccurrenceNoteRequest, Note> getOccurrenceNoteCallable() {
    return getOccurrenceNoteCallable;
  }

  @Override
  public UnaryCallable<GetNoteRequest, Note> getNoteCallable() {
    return getNoteCallable;
  }

  @Override
  public UnaryCallable<ListNotesRequest, ListNotesResponse> listNotesCallable() {
    return listNotesCallable;
  }

  @Override
  public UnaryCallable<ListNotesRequest, ListNotesPagedResponse> listNotesPagedCallable() {
    return listNotesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteNoteRequest, Empty> deleteNoteCallable() {
    return deleteNoteCallable;
  }

  @Override
  public UnaryCallable<CreateNoteRequest, Note> createNoteCallable() {
    return createNoteCallable;
  }

  @Override
  public UnaryCallable<BatchCreateNotesRequest, BatchCreateNotesResponse>
      batchCreateNotesCallable() {
    return batchCreateNotesCallable;
  }

  @Override
  public UnaryCallable<UpdateNoteRequest, Note> updateNoteCallable() {
    return updateNoteCallable;
  }

  @Override
  public UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesCallable() {
    return listNoteOccurrencesCallable;
  }

  @Override
  public UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesPagedCallable() {
    return listNoteOccurrencesPagedCallable;
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
