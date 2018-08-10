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

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ContainerAnalysisStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (containeranalysis.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of getOccurrence to 30 seconds:
 *
 * <pre>
 * <code>
 * ContainerAnalysisStubSettings.Builder containerAnalysisSettingsBuilder =
 *     ContainerAnalysisStubSettings.newBuilder();
 * containerAnalysisSettingsBuilder.getOccurrenceSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ContainerAnalysisStubSettings containerAnalysisSettings = containerAnalysisSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ContainerAnalysisStubSettings extends StubSettings<ContainerAnalysisStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetOccurrenceRequest, Occurrence> getOccurrenceSettings;
  private final PagedCallSettings<
          ListOccurrencesRequest, ListOccurrencesResponse, ListOccurrencesPagedResponse>
      listOccurrencesSettings;
  private final UnaryCallSettings<DeleteOccurrenceRequest, Empty> deleteOccurrenceSettings;
  private final UnaryCallSettings<CreateOccurrenceRequest, Occurrence> createOccurrenceSettings;
  private final UnaryCallSettings<UpdateOccurrenceRequest, Occurrence> updateOccurrenceSettings;
  private final UnaryCallSettings<GetOccurrenceNoteRequest, Note> getOccurrenceNoteSettings;
  private final UnaryCallSettings<GetNoteRequest, Note> getNoteSettings;
  private final PagedCallSettings<ListNotesRequest, ListNotesResponse, ListNotesPagedResponse>
      listNotesSettings;
  private final UnaryCallSettings<DeleteNoteRequest, Empty> deleteNoteSettings;
  private final UnaryCallSettings<CreateNoteRequest, Note> createNoteSettings;
  private final UnaryCallSettings<UpdateNoteRequest, Note> updateNoteSettings;
  private final PagedCallSettings<
          ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesSettings;
  private final UnaryCallSettings<
          GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
      getVulnzOccurrencesSummarySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  /** Returns the object with the settings used for calls to getOccurrence. */
  public UnaryCallSettings<GetOccurrenceRequest, Occurrence> getOccurrenceSettings() {
    return getOccurrenceSettings;
  }

  /** Returns the object with the settings used for calls to listOccurrences. */
  public PagedCallSettings<
          ListOccurrencesRequest, ListOccurrencesResponse, ListOccurrencesPagedResponse>
      listOccurrencesSettings() {
    return listOccurrencesSettings;
  }

  /** Returns the object with the settings used for calls to deleteOccurrence. */
  public UnaryCallSettings<DeleteOccurrenceRequest, Empty> deleteOccurrenceSettings() {
    return deleteOccurrenceSettings;
  }

  /** Returns the object with the settings used for calls to createOccurrence. */
  public UnaryCallSettings<CreateOccurrenceRequest, Occurrence> createOccurrenceSettings() {
    return createOccurrenceSettings;
  }

  /** Returns the object with the settings used for calls to updateOccurrence. */
  public UnaryCallSettings<UpdateOccurrenceRequest, Occurrence> updateOccurrenceSettings() {
    return updateOccurrenceSettings;
  }

  /** Returns the object with the settings used for calls to getOccurrenceNote. */
  public UnaryCallSettings<GetOccurrenceNoteRequest, Note> getOccurrenceNoteSettings() {
    return getOccurrenceNoteSettings;
  }

  /** Returns the object with the settings used for calls to getNote. */
  public UnaryCallSettings<GetNoteRequest, Note> getNoteSettings() {
    return getNoteSettings;
  }

  /** Returns the object with the settings used for calls to listNotes. */
  public PagedCallSettings<ListNotesRequest, ListNotesResponse, ListNotesPagedResponse>
      listNotesSettings() {
    return listNotesSettings;
  }

  /** Returns the object with the settings used for calls to deleteNote. */
  public UnaryCallSettings<DeleteNoteRequest, Empty> deleteNoteSettings() {
    return deleteNoteSettings;
  }

  /** Returns the object with the settings used for calls to createNote. */
  public UnaryCallSettings<CreateNoteRequest, Note> createNoteSettings() {
    return createNoteSettings;
  }

  /** Returns the object with the settings used for calls to updateNote. */
  public UnaryCallSettings<UpdateNoteRequest, Note> updateNoteSettings() {
    return updateNoteSettings;
  }

  /** Returns the object with the settings used for calls to listNoteOccurrences. */
  public PagedCallSettings<
          ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, ListNoteOccurrencesPagedResponse>
      listNoteOccurrencesSettings() {
    return listNoteOccurrencesSettings;
  }

  /** Returns the object with the settings used for calls to getVulnzOccurrencesSummary. */
  public UnaryCallSettings<GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
      getVulnzOccurrencesSummarySettings() {
    return getVulnzOccurrencesSummarySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ContainerAnalysisStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcContainerAnalysisStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "containeranalysis.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ContainerAnalysisStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ContainerAnalysisStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getOccurrenceSettings = settingsBuilder.getOccurrenceSettings().build();
    listOccurrencesSettings = settingsBuilder.listOccurrencesSettings().build();
    deleteOccurrenceSettings = settingsBuilder.deleteOccurrenceSettings().build();
    createOccurrenceSettings = settingsBuilder.createOccurrenceSettings().build();
    updateOccurrenceSettings = settingsBuilder.updateOccurrenceSettings().build();
    getOccurrenceNoteSettings = settingsBuilder.getOccurrenceNoteSettings().build();
    getNoteSettings = settingsBuilder.getNoteSettings().build();
    listNotesSettings = settingsBuilder.listNotesSettings().build();
    deleteNoteSettings = settingsBuilder.deleteNoteSettings().build();
    createNoteSettings = settingsBuilder.createNoteSettings().build();
    updateNoteSettings = settingsBuilder.updateNoteSettings().build();
    listNoteOccurrencesSettings = settingsBuilder.listNoteOccurrencesSettings().build();
    getVulnzOccurrencesSummarySettings =
        settingsBuilder.getVulnzOccurrencesSummarySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  private static final PagedListDescriptor<
          ListOccurrencesRequest, ListOccurrencesResponse, Occurrence>
      LIST_OCCURRENCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListOccurrencesRequest, ListOccurrencesResponse, Occurrence>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOccurrencesRequest injectToken(
                ListOccurrencesRequest payload, String token) {
              return ListOccurrencesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOccurrencesRequest injectPageSize(
                ListOccurrencesRequest payload, int pageSize) {
              return ListOccurrencesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOccurrencesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOccurrencesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Occurrence> extractResources(ListOccurrencesResponse payload) {
              return payload.getOccurrencesList();
            }
          };

  private static final PagedListDescriptor<ListNotesRequest, ListNotesResponse, Note>
      LIST_NOTES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNotesRequest, ListNotesResponse, Note>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNotesRequest injectToken(ListNotesRequest payload, String token) {
              return ListNotesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNotesRequest injectPageSize(ListNotesRequest payload, int pageSize) {
              return ListNotesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNotesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNotesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Note> extractResources(ListNotesResponse payload) {
              return payload.getNotesList();
            }
          };

  private static final PagedListDescriptor<
          ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence>
      LIST_NOTE_OCCURRENCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNoteOccurrencesRequest injectToken(
                ListNoteOccurrencesRequest payload, String token) {
              return ListNoteOccurrencesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNoteOccurrencesRequest injectPageSize(
                ListNoteOccurrencesRequest payload, int pageSize) {
              return ListNoteOccurrencesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNoteOccurrencesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNoteOccurrencesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Occurrence> extractResources(ListNoteOccurrencesResponse payload) {
              return payload.getOccurrencesList();
            }
          };

  private static final PagedListResponseFactory<
          ListOccurrencesRequest, ListOccurrencesResponse, ListOccurrencesPagedResponse>
      LIST_OCCURRENCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOccurrencesRequest, ListOccurrencesResponse, ListOccurrencesPagedResponse>() {
            @Override
            public ApiFuture<ListOccurrencesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOccurrencesRequest, ListOccurrencesResponse> callable,
                ListOccurrencesRequest request,
                ApiCallContext context,
                ApiFuture<ListOccurrencesResponse> futureResponse) {
              PageContext<ListOccurrencesRequest, ListOccurrencesResponse, Occurrence> pageContext =
                  PageContext.create(callable, LIST_OCCURRENCES_PAGE_STR_DESC, request, context);
              return ListOccurrencesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNotesRequest, ListNotesResponse, ListNotesPagedResponse>
      LIST_NOTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNotesRequest, ListNotesResponse, ListNotesPagedResponse>() {
            @Override
            public ApiFuture<ListNotesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNotesRequest, ListNotesResponse> callable,
                ListNotesRequest request,
                ApiCallContext context,
                ApiFuture<ListNotesResponse> futureResponse) {
              PageContext<ListNotesRequest, ListNotesResponse, Note> pageContext =
                  PageContext.create(callable, LIST_NOTES_PAGE_STR_DESC, request, context);
              return ListNotesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, ListNoteOccurrencesPagedResponse>
      LIST_NOTE_OCCURRENCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNoteOccurrencesRequest, ListNoteOccurrencesResponse,
              ListNoteOccurrencesPagedResponse>() {
            @Override
            public ApiFuture<ListNoteOccurrencesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse> callable,
                ListNoteOccurrencesRequest request,
                ApiCallContext context,
                ApiFuture<ListNoteOccurrencesResponse> futureResponse) {
              PageContext<ListNoteOccurrencesRequest, ListNoteOccurrencesResponse, Occurrence>
                  pageContext =
                      PageContext.create(
                          callable, LIST_NOTE_OCCURRENCES_PAGE_STR_DESC, request, context);
              return ListNoteOccurrencesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ContainerAnalysisStubSettings. */
  public static class Builder extends StubSettings.Builder<ContainerAnalysisStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<GetOccurrenceRequest, Occurrence> getOccurrenceSettings;
    private final PagedCallSettings.Builder<
            ListOccurrencesRequest, ListOccurrencesResponse, ListOccurrencesPagedResponse>
        listOccurrencesSettings;
    private final UnaryCallSettings.Builder<DeleteOccurrenceRequest, Empty>
        deleteOccurrenceSettings;
    private final UnaryCallSettings.Builder<CreateOccurrenceRequest, Occurrence>
        createOccurrenceSettings;
    private final UnaryCallSettings.Builder<UpdateOccurrenceRequest, Occurrence>
        updateOccurrenceSettings;
    private final UnaryCallSettings.Builder<GetOccurrenceNoteRequest, Note>
        getOccurrenceNoteSettings;
    private final UnaryCallSettings.Builder<GetNoteRequest, Note> getNoteSettings;
    private final PagedCallSettings.Builder<
            ListNotesRequest, ListNotesResponse, ListNotesPagedResponse>
        listNotesSettings;
    private final UnaryCallSettings.Builder<DeleteNoteRequest, Empty> deleteNoteSettings;
    private final UnaryCallSettings.Builder<CreateNoteRequest, Note> createNoteSettings;
    private final UnaryCallSettings.Builder<UpdateNoteRequest, Note> updateNoteSettings;
    private final PagedCallSettings.Builder<
            ListNoteOccurrencesRequest, ListNoteOccurrencesResponse,
            ListNoteOccurrencesPagedResponse>
        listNoteOccurrencesSettings;
    private final UnaryCallSettings.Builder<
            GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
        getVulnzOccurrencesSummarySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getOccurrenceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listOccurrencesSettings = PagedCallSettings.newBuilder(LIST_OCCURRENCES_PAGE_STR_FACT);

      deleteOccurrenceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createOccurrenceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateOccurrenceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getOccurrenceNoteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getNoteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listNotesSettings = PagedCallSettings.newBuilder(LIST_NOTES_PAGE_STR_FACT);

      deleteNoteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createNoteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateNoteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listNoteOccurrencesSettings =
          PagedCallSettings.newBuilder(LIST_NOTE_OCCURRENCES_PAGE_STR_FACT);

      getVulnzOccurrencesSummarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getOccurrenceSettings,
              listOccurrencesSettings,
              deleteOccurrenceSettings,
              createOccurrenceSettings,
              updateOccurrenceSettings,
              getOccurrenceNoteSettings,
              getNoteSettings,
              listNotesSettings,
              deleteNoteSettings,
              createNoteSettings,
              updateNoteSettings,
              listNoteOccurrencesSettings,
              getVulnzOccurrencesSummarySettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .getOccurrenceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listOccurrencesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteOccurrenceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createOccurrenceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateOccurrenceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getOccurrenceNoteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getNoteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNotesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteNoteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createNoteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateNoteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listNoteOccurrencesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getVulnzOccurrencesSummarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(ContainerAnalysisStubSettings settings) {
      super(settings);

      getOccurrenceSettings = settings.getOccurrenceSettings.toBuilder();
      listOccurrencesSettings = settings.listOccurrencesSettings.toBuilder();
      deleteOccurrenceSettings = settings.deleteOccurrenceSettings.toBuilder();
      createOccurrenceSettings = settings.createOccurrenceSettings.toBuilder();
      updateOccurrenceSettings = settings.updateOccurrenceSettings.toBuilder();
      getOccurrenceNoteSettings = settings.getOccurrenceNoteSettings.toBuilder();
      getNoteSettings = settings.getNoteSettings.toBuilder();
      listNotesSettings = settings.listNotesSettings.toBuilder();
      deleteNoteSettings = settings.deleteNoteSettings.toBuilder();
      createNoteSettings = settings.createNoteSettings.toBuilder();
      updateNoteSettings = settings.updateNoteSettings.toBuilder();
      listNoteOccurrencesSettings = settings.listNoteOccurrencesSettings.toBuilder();
      getVulnzOccurrencesSummarySettings = settings.getVulnzOccurrencesSummarySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getOccurrenceSettings,
              listOccurrencesSettings,
              deleteOccurrenceSettings,
              createOccurrenceSettings,
              updateOccurrenceSettings,
              getOccurrenceNoteSettings,
              getNoteSettings,
              listNotesSettings,
              deleteNoteSettings,
              createNoteSettings,
              updateNoteSettings,
              listNoteOccurrencesSettings,
              getVulnzOccurrencesSummarySettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to getOccurrence. */
    public UnaryCallSettings.Builder<GetOccurrenceRequest, Occurrence> getOccurrenceSettings() {
      return getOccurrenceSettings;
    }

    /** Returns the builder for the settings used for calls to listOccurrences. */
    public PagedCallSettings.Builder<
            ListOccurrencesRequest, ListOccurrencesResponse, ListOccurrencesPagedResponse>
        listOccurrencesSettings() {
      return listOccurrencesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOccurrence. */
    public UnaryCallSettings.Builder<DeleteOccurrenceRequest, Empty> deleteOccurrenceSettings() {
      return deleteOccurrenceSettings;
    }

    /** Returns the builder for the settings used for calls to createOccurrence. */
    public UnaryCallSettings.Builder<CreateOccurrenceRequest, Occurrence>
        createOccurrenceSettings() {
      return createOccurrenceSettings;
    }

    /** Returns the builder for the settings used for calls to updateOccurrence. */
    public UnaryCallSettings.Builder<UpdateOccurrenceRequest, Occurrence>
        updateOccurrenceSettings() {
      return updateOccurrenceSettings;
    }

    /** Returns the builder for the settings used for calls to getOccurrenceNote. */
    public UnaryCallSettings.Builder<GetOccurrenceNoteRequest, Note> getOccurrenceNoteSettings() {
      return getOccurrenceNoteSettings;
    }

    /** Returns the builder for the settings used for calls to getNote. */
    public UnaryCallSettings.Builder<GetNoteRequest, Note> getNoteSettings() {
      return getNoteSettings;
    }

    /** Returns the builder for the settings used for calls to listNotes. */
    public PagedCallSettings.Builder<ListNotesRequest, ListNotesResponse, ListNotesPagedResponse>
        listNotesSettings() {
      return listNotesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteNote. */
    public UnaryCallSettings.Builder<DeleteNoteRequest, Empty> deleteNoteSettings() {
      return deleteNoteSettings;
    }

    /** Returns the builder for the settings used for calls to createNote. */
    public UnaryCallSettings.Builder<CreateNoteRequest, Note> createNoteSettings() {
      return createNoteSettings;
    }

    /** Returns the builder for the settings used for calls to updateNote. */
    public UnaryCallSettings.Builder<UpdateNoteRequest, Note> updateNoteSettings() {
      return updateNoteSettings;
    }

    /** Returns the builder for the settings used for calls to listNoteOccurrences. */
    public PagedCallSettings.Builder<
            ListNoteOccurrencesRequest, ListNoteOccurrencesResponse,
            ListNoteOccurrencesPagedResponse>
        listNoteOccurrencesSettings() {
      return listNoteOccurrencesSettings;
    }

    /** Returns the builder for the settings used for calls to getVulnzOccurrencesSummary. */
    public UnaryCallSettings.Builder<
            GetVulnzOccurrencesSummaryRequest, GetVulnzOccurrencesSummaryResponse>
        getVulnzOccurrencesSummarySettings() {
      return getVulnzOccurrencesSummarySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public ContainerAnalysisStubSettings build() throws IOException {
      return new ContainerAnalysisStubSettings(this);
    }
  }
}
