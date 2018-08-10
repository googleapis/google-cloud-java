/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.devtools.containeranalysis.v1alpha1.stub;

import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListNoteOccurrencesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListNotesPagedResponse;
import static com.google.cloud.devtools.containeranalysis.v1alpha1.ContainerAnalysisClient.ListOccurrencesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.containeranalysis.v1alpha1.CreateNoteRequest;
import com.google.containeranalysis.v1alpha1.CreateOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.DeleteNoteRequest;
import com.google.containeranalysis.v1alpha1.DeleteOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceNoteRequest;
import com.google.containeranalysis.v1alpha1.GetOccurrenceRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryRequest;
import com.google.containeranalysis.v1alpha1.GetVulnzOccurrencesSummaryResponse;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListNoteOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.ListNotesRequest;
import com.google.containeranalysis.v1alpha1.ListNotesResponse;
import com.google.containeranalysis.v1alpha1.ListOccurrencesRequest;
import com.google.containeranalysis.v1alpha1.ListOccurrencesResponse;
import com.google.containeranalysis.v1alpha1.Note;
import com.google.containeranalysis.v1alpha1.Occurrence;
import com.google.containeranalysis.v1alpha1.UpdateNoteRequest;
import com.google.containeranalysis.v1alpha1.UpdateOccurrenceRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
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
public class GrpcContainerAnalysisStub extends ContainerAnalysisStub {

  private static final MethodDescriptor<GetOccurrenceRequest, Occurrence>
      getOccurrenceMethodDescriptor =
          MethodDescriptor.<GetOccurrenceRequest, Occurrence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/GetOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Occurrence.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<ListOccurrencesRequest, ListOccurrencesResponse>
      listOccurrencesMethodDescriptor =
          MethodDescriptor.<ListOccurrencesRequest, ListOccurrencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/ListOccurrences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListOccurrencesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteOccurrenceRequest, Empty>
      deleteOccurrenceMethodDescriptor =
          MethodDescriptor.<DeleteOccurrenceRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/DeleteOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<CreateOccurrenceRequest, Occurrence>
      createOccurrenceMethodDescriptor =
          MethodDescriptor.<CreateOccurrenceRequest, Occurrence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/CreateOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Occurrence.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<UpdateOccurrenceRequest, Occurrence>
      updateOccurrenceMethodDescriptor =
          MethodDescriptor.<UpdateOccurrenceRequest, Occurrence>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/UpdateOccurrence")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateOccurrenceRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Occurrence.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetOccurrenceNoteRequest, Note>
      getOccurrenceNoteMethodDescriptor =
          MethodDescriptor.<GetOccurrenceNoteRequest, Note>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/GetOccurrenceNote")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetOccurrenceNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<GetNoteRequest, Note> getNoteMethodDescriptor =
      MethodDescriptor.<GetNoteRequest, Note>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/GetNote")
          .setRequestMarshaller(ProtoUtils.marshaller(GetNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListNotesRequest, ListNotesResponse>
      listNotesMethodDescriptor =
          MethodDescriptor.<ListNotesRequest, ListNotesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/ListNotes")
              .setRequestMarshaller(ProtoUtils.marshaller(ListNotesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListNotesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<DeleteNoteRequest, Empty> deleteNoteMethodDescriptor =
      MethodDescriptor.<DeleteNoteRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/DeleteNote")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<CreateNoteRequest, Note> createNoteMethodDescriptor =
      MethodDescriptor.<CreateNoteRequest, Note>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/CreateNote")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<UpdateNoteRequest, Note> updateNoteMethodDescriptor =
      MethodDescriptor.<UpdateNoteRequest, Note>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/UpdateNote")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateNoteRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Note.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesMethodDescriptor =
          MethodDescriptor.<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/ListNoteOccurrences")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListNoteOccurrencesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListNoteOccurrencesResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<
          GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
      getVulnzOccurrencesSummaryMethodDescriptor =
          MethodDescriptor
              .<GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/GetVulnzOccurrencesSummary")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetVulnzOccurrencesSummaryRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(GetVulnzOccurrencesSummaryResponse.getDefaultInstance()))
              .build();
  private static final MethodDescriptor<SetIamPolicyRequest, Policy> setIamPolicyMethodDescriptor =
      MethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/SetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(SetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<GetIamPolicyRequest, Policy> getIamPolicyMethodDescriptor =
      MethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/GetIamPolicy")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIamPolicyRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Policy.getDefaultInstance()))
          .build();
  private static final MethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          MethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.devtools.containeranalysis.v1alpha1.ContainerAnalysis/TestIamPermissions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(TestIamPermissionsResponse.getDefaultInstance()))
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<GetOccurrenceRequest, Occurrence> getOccurrenceCallable;
  private final UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse>
      listOccurrencesCallable;
  private final UnaryCallable<ListOccurrencesRequest, ListOccurrencesPagedResponse>
      listOccurrencesPagedCallable;
  private final UnaryCallable<DeleteOccurrenceRequest, Empty> deleteOccurrenceCallable;
  private final UnaryCallable<CreateOccurrenceRequest, Occurrence> createOccurrenceCallable;
  private final UnaryCallable<UpdateOccurrenceRequest, Occurrence> updateOccurrenceCallable;
  private final UnaryCallable<GetOccurrenceNoteRequest, Note> getOccurrenceNoteCallable;
  private final UnaryCallable<GetNoteRequest, Note> getNoteCallable;
  private final UnaryCallable<ListNotesRequest, ListNotesResponse> listNotesCallable;
  private final UnaryCallable<ListNotesRequest, ListNotesPagedResponse> listNotesPagedCallable;
  private final UnaryCallable<DeleteNoteRequest, Empty> deleteNoteCallable;
  private final UnaryCallable<CreateNoteRequest, Note> createNoteCallable;
  private final UnaryCallable<UpdateNoteRequest, Note> updateNoteCallable;
  private final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
      listNoteOccurrencesCallable;
  private final UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesPagedCallable;
  private final UnaryCallable<GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
      getVulnzOccurrencesSummaryCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcContainerAnalysisStub create(ContainerAnalysisStubSettings settings)
      throws IOException {
    return new GrpcContainerAnalysisStub(settings, ClientContext.create(settings));
  }

  public static final GrpcContainerAnalysisStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcContainerAnalysisStub(
        ContainerAnalysisStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcContainerAnalysisStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcContainerAnalysisStub(
        ContainerAnalysisStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcContainerAnalysisStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcContainerAnalysisStub(
      ContainerAnalysisStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcContainerAnalysisCallableFactory());
  }

  /**
   * Constructs an instance of GrpcContainerAnalysisStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcContainerAnalysisStub(
      ContainerAnalysisStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    GrpcCallSettings<GetOccurrenceRequest, Occurrence> getOccurrenceTransportSettings =
        GrpcCallSettings.<GetOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(getOccurrenceMethodDescriptor)
            .build();
    GrpcCallSettings<ListOccurrencesRequest, ListOccurrencesResponse>
        listOccurrencesTransportSettings =
            GrpcCallSettings.<ListOccurrencesRequest, ListOccurrencesResponse>newBuilder()
                .setMethodDescriptor(listOccurrencesMethodDescriptor)
                .build();
    GrpcCallSettings<DeleteOccurrenceRequest, Empty> deleteOccurrenceTransportSettings =
        GrpcCallSettings.<DeleteOccurrenceRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteOccurrenceMethodDescriptor)
            .build();
    GrpcCallSettings<CreateOccurrenceRequest, Occurrence> createOccurrenceTransportSettings =
        GrpcCallSettings.<CreateOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(createOccurrenceMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateOccurrenceRequest, Occurrence> updateOccurrenceTransportSettings =
        GrpcCallSettings.<UpdateOccurrenceRequest, Occurrence>newBuilder()
            .setMethodDescriptor(updateOccurrenceMethodDescriptor)
            .build();
    GrpcCallSettings<GetOccurrenceNoteRequest, Note> getOccurrenceNoteTransportSettings =
        GrpcCallSettings.<GetOccurrenceNoteRequest, Note>newBuilder()
            .setMethodDescriptor(getOccurrenceNoteMethodDescriptor)
            .build();
    GrpcCallSettings<GetNoteRequest, Note> getNoteTransportSettings =
        GrpcCallSettings.<GetNoteRequest, Note>newBuilder()
            .setMethodDescriptor(getNoteMethodDescriptor)
            .build();
    GrpcCallSettings<ListNotesRequest, ListNotesResponse> listNotesTransportSettings =
        GrpcCallSettings.<ListNotesRequest, ListNotesResponse>newBuilder()
            .setMethodDescriptor(listNotesMethodDescriptor)
            .build();
    GrpcCallSettings<DeleteNoteRequest, Empty> deleteNoteTransportSettings =
        GrpcCallSettings.<DeleteNoteRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteNoteMethodDescriptor)
            .build();
    GrpcCallSettings<CreateNoteRequest, Note> createNoteTransportSettings =
        GrpcCallSettings.<CreateNoteRequest, Note>newBuilder()
            .setMethodDescriptor(createNoteMethodDescriptor)
            .build();
    GrpcCallSettings<UpdateNoteRequest, Note> updateNoteTransportSettings =
        GrpcCallSettings.<UpdateNoteRequest, Note>newBuilder()
            .setMethodDescriptor(updateNoteMethodDescriptor)
            .build();
    GrpcCallSettings<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>
        listNoteOccurrencesTransportSettings =
            GrpcCallSettings.<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse>newBuilder()
                .setMethodDescriptor(listNoteOccurrencesMethodDescriptor)
                .build();
    GrpcCallSettings<GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
        getVulnzOccurrencesSummaryTransportSettings =
            GrpcCallSettings
                .<GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>newBuilder()
                .setMethodDescriptor(getVulnzOccurrencesSummaryMethodDescriptor)
                .build();
    GrpcCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        GrpcCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    GrpcCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        GrpcCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    GrpcCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            GrpcCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
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
    this.getVulnzOccurrencesSummaryCallable =
        callableFactory.createUnaryCallable(
            getVulnzOccurrencesSummaryTransportSettings,
            settings.getVulnzOccurrencesSummarySettings(),
            clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
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

  public UnaryCallable<GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
      getVulnzOccurrencesSummaryCallable() {
    return getVulnzOccurrencesSummaryCallable;
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
