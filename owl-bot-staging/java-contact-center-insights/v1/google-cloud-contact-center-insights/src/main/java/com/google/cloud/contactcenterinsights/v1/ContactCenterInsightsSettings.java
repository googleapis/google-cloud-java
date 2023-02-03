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

package com.google.cloud.contactcenterinsights.v1;

import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListAnalysesPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListConversationsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListPhraseMatchersPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListViewsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.contactcenterinsights.v1.stub.ContactCenterInsightsStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ContactCenterInsightsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (contactcenterinsights.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createConversation to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContactCenterInsightsSettings.Builder contactCenterInsightsSettingsBuilder =
 *     ContactCenterInsightsSettings.newBuilder();
 * contactCenterInsightsSettingsBuilder
 *     .createConversationSettings()
 *     .setRetrySettings(
 *         contactCenterInsightsSettingsBuilder
 *             .createConversationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ContactCenterInsightsSettings contactCenterInsightsSettings =
 *     contactCenterInsightsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ContactCenterInsightsSettings extends ClientSettings<ContactCenterInsightsSettings> {

  /** Returns the object with the settings used for calls to createConversation. */
  public UnaryCallSettings<CreateConversationRequest, Conversation> createConversationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createConversationSettings();
  }

  /** Returns the object with the settings used for calls to updateConversation. */
  public UnaryCallSettings<UpdateConversationRequest, Conversation> updateConversationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updateConversationSettings();
  }

  /** Returns the object with the settings used for calls to getConversation. */
  public UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getConversationSettings();
  }

  /** Returns the object with the settings used for calls to listConversations. */
  public PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listConversationsSettings();
  }

  /** Returns the object with the settings used for calls to deleteConversation. */
  public UnaryCallSettings<DeleteConversationRequest, Empty> deleteConversationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deleteConversationSettings();
  }

  /** Returns the object with the settings used for calls to createAnalysis. */
  public UnaryCallSettings<CreateAnalysisRequest, Operation> createAnalysisSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createAnalysisSettings();
  }

  /** Returns the object with the settings used for calls to createAnalysis. */
  public OperationCallSettings<CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
      createAnalysisOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .createAnalysisOperationSettings();
  }

  /** Returns the object with the settings used for calls to getAnalysis. */
  public UnaryCallSettings<GetAnalysisRequest, Analysis> getAnalysisSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getAnalysisSettings();
  }

  /** Returns the object with the settings used for calls to listAnalyses. */
  public PagedCallSettings<ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
      listAnalysesSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listAnalysesSettings();
  }

  /** Returns the object with the settings used for calls to deleteAnalysis. */
  public UnaryCallSettings<DeleteAnalysisRequest, Empty> deleteAnalysisSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deleteAnalysisSettings();
  }

  /** Returns the object with the settings used for calls to bulkAnalyzeConversations. */
  public UnaryCallSettings<BulkAnalyzeConversationsRequest, Operation>
      bulkAnalyzeConversationsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .bulkAnalyzeConversationsSettings();
  }

  /** Returns the object with the settings used for calls to bulkAnalyzeConversations. */
  public OperationCallSettings<
          BulkAnalyzeConversationsRequest,
          BulkAnalyzeConversationsResponse,
          BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .bulkAnalyzeConversationsOperationSettings();
  }

  /** Returns the object with the settings used for calls to ingestConversations. */
  public UnaryCallSettings<IngestConversationsRequest, Operation> ingestConversationsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).ingestConversationsSettings();
  }

  /** Returns the object with the settings used for calls to ingestConversations. */
  public OperationCallSettings<
          IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .ingestConversationsOperationSettings();
  }

  /** Returns the object with the settings used for calls to exportInsightsData. */
  public UnaryCallSettings<ExportInsightsDataRequest, Operation> exportInsightsDataSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).exportInsightsDataSettings();
  }

  /** Returns the object with the settings used for calls to exportInsightsData. */
  public OperationCallSettings<
          ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .exportInsightsDataOperationSettings();
  }

  /** Returns the object with the settings used for calls to createIssueModel. */
  public UnaryCallSettings<CreateIssueModelRequest, Operation> createIssueModelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createIssueModelSettings();
  }

  /** Returns the object with the settings used for calls to createIssueModel. */
  public OperationCallSettings<CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
      createIssueModelOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .createIssueModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateIssueModel. */
  public UnaryCallSettings<UpdateIssueModelRequest, IssueModel> updateIssueModelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updateIssueModelSettings();
  }

  /** Returns the object with the settings used for calls to getIssueModel. */
  public UnaryCallSettings<GetIssueModelRequest, IssueModel> getIssueModelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getIssueModelSettings();
  }

  /** Returns the object with the settings used for calls to listIssueModels. */
  public UnaryCallSettings<ListIssueModelsRequest, ListIssueModelsResponse>
      listIssueModelsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listIssueModelsSettings();
  }

  /** Returns the object with the settings used for calls to deleteIssueModel. */
  public UnaryCallSettings<DeleteIssueModelRequest, Operation> deleteIssueModelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deleteIssueModelSettings();
  }

  /** Returns the object with the settings used for calls to deleteIssueModel. */
  public OperationCallSettings<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
      deleteIssueModelOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .deleteIssueModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to deployIssueModel. */
  public UnaryCallSettings<DeployIssueModelRequest, Operation> deployIssueModelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deployIssueModelSettings();
  }

  /** Returns the object with the settings used for calls to deployIssueModel. */
  public OperationCallSettings<
          DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .deployIssueModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to undeployIssueModel. */
  public UnaryCallSettings<UndeployIssueModelRequest, Operation> undeployIssueModelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).undeployIssueModelSettings();
  }

  /** Returns the object with the settings used for calls to undeployIssueModel. */
  public OperationCallSettings<
          UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .undeployIssueModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIssue. */
  public UnaryCallSettings<GetIssueRequest, Issue> getIssueSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getIssueSettings();
  }

  /** Returns the object with the settings used for calls to listIssues. */
  public UnaryCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listIssuesSettings();
  }

  /** Returns the object with the settings used for calls to updateIssue. */
  public UnaryCallSettings<UpdateIssueRequest, Issue> updateIssueSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updateIssueSettings();
  }

  /** Returns the object with the settings used for calls to deleteIssue. */
  public UnaryCallSettings<DeleteIssueRequest, Empty> deleteIssueSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deleteIssueSettings();
  }

  /** Returns the object with the settings used for calls to calculateIssueModelStats. */
  public UnaryCallSettings<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .calculateIssueModelStatsSettings();
  }

  /** Returns the object with the settings used for calls to createPhraseMatcher. */
  public UnaryCallSettings<CreatePhraseMatcherRequest, PhraseMatcher>
      createPhraseMatcherSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createPhraseMatcherSettings();
  }

  /** Returns the object with the settings used for calls to getPhraseMatcher. */
  public UnaryCallSettings<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getPhraseMatcherSettings();
  }

  /** Returns the object with the settings used for calls to listPhraseMatchers. */
  public PagedCallSettings<
          ListPhraseMatchersRequest, ListPhraseMatchersResponse, ListPhraseMatchersPagedResponse>
      listPhraseMatchersSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listPhraseMatchersSettings();
  }

  /** Returns the object with the settings used for calls to deletePhraseMatcher. */
  public UnaryCallSettings<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deletePhraseMatcherSettings();
  }

  /** Returns the object with the settings used for calls to updatePhraseMatcher. */
  public UnaryCallSettings<UpdatePhraseMatcherRequest, PhraseMatcher>
      updatePhraseMatcherSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updatePhraseMatcherSettings();
  }

  /** Returns the object with the settings used for calls to calculateStats. */
  public UnaryCallSettings<CalculateStatsRequest, CalculateStatsResponse> calculateStatsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).calculateStatsSettings();
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getSettingsSettings();
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updateSettingsSettings();
  }

  /** Returns the object with the settings used for calls to createView. */
  public UnaryCallSettings<CreateViewRequest, View> createViewSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createViewSettings();
  }

  /** Returns the object with the settings used for calls to getView. */
  public UnaryCallSettings<GetViewRequest, View> getViewSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getViewSettings();
  }

  /** Returns the object with the settings used for calls to listViews. */
  public PagedCallSettings<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      listViewsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listViewsSettings();
  }

  /** Returns the object with the settings used for calls to updateView. */
  public UnaryCallSettings<UpdateViewRequest, View> updateViewSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updateViewSettings();
  }

  /** Returns the object with the settings used for calls to deleteView. */
  public UnaryCallSettings<DeleteViewRequest, Empty> deleteViewSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deleteViewSettings();
  }

  public static final ContactCenterInsightsSettings create(ContactCenterInsightsStubSettings stub)
      throws IOException {
    return new ContactCenterInsightsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ContactCenterInsightsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ContactCenterInsightsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ContactCenterInsightsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ContactCenterInsightsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ContactCenterInsightsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ContactCenterInsightsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ContactCenterInsightsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ContactCenterInsightsStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ContactCenterInsightsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ContactCenterInsightsSettings. */
  public static class Builder
      extends ClientSettings.Builder<ContactCenterInsightsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ContactCenterInsightsStubSettings.newBuilder(clientContext));
    }

    protected Builder(ContactCenterInsightsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ContactCenterInsightsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ContactCenterInsightsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ContactCenterInsightsStubSettings.newHttpJsonBuilder());
    }

    public ContactCenterInsightsStubSettings.Builder getStubSettingsBuilder() {
      return ((ContactCenterInsightsStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createConversation. */
    public UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings() {
      return getStubSettingsBuilder().createConversationSettings();
    }

    /** Returns the builder for the settings used for calls to updateConversation. */
    public UnaryCallSettings.Builder<UpdateConversationRequest, Conversation>
        updateConversationSettings() {
      return getStubSettingsBuilder().updateConversationSettings();
    }

    /** Returns the builder for the settings used for calls to getConversation. */
    public UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings() {
      return getStubSettingsBuilder().getConversationSettings();
    }

    /** Returns the builder for the settings used for calls to listConversations. */
    public PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings() {
      return getStubSettingsBuilder().listConversationsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteConversation. */
    public UnaryCallSettings.Builder<DeleteConversationRequest, Empty>
        deleteConversationSettings() {
      return getStubSettingsBuilder().deleteConversationSettings();
    }

    /** Returns the builder for the settings used for calls to createAnalysis. */
    public UnaryCallSettings.Builder<CreateAnalysisRequest, Operation> createAnalysisSettings() {
      return getStubSettingsBuilder().createAnalysisSettings();
    }

    /** Returns the builder for the settings used for calls to createAnalysis. */
    public OperationCallSettings.Builder<
            CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
        createAnalysisOperationSettings() {
      return getStubSettingsBuilder().createAnalysisOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getAnalysis. */
    public UnaryCallSettings.Builder<GetAnalysisRequest, Analysis> getAnalysisSettings() {
      return getStubSettingsBuilder().getAnalysisSettings();
    }

    /** Returns the builder for the settings used for calls to listAnalyses. */
    public PagedCallSettings.Builder<
            ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
        listAnalysesSettings() {
      return getStubSettingsBuilder().listAnalysesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAnalysis. */
    public UnaryCallSettings.Builder<DeleteAnalysisRequest, Empty> deleteAnalysisSettings() {
      return getStubSettingsBuilder().deleteAnalysisSettings();
    }

    /** Returns the builder for the settings used for calls to bulkAnalyzeConversations. */
    public UnaryCallSettings.Builder<BulkAnalyzeConversationsRequest, Operation>
        bulkAnalyzeConversationsSettings() {
      return getStubSettingsBuilder().bulkAnalyzeConversationsSettings();
    }

    /** Returns the builder for the settings used for calls to bulkAnalyzeConversations. */
    public OperationCallSettings.Builder<
            BulkAnalyzeConversationsRequest,
            BulkAnalyzeConversationsResponse,
            BulkAnalyzeConversationsMetadata>
        bulkAnalyzeConversationsOperationSettings() {
      return getStubSettingsBuilder().bulkAnalyzeConversationsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to ingestConversations. */
    public UnaryCallSettings.Builder<IngestConversationsRequest, Operation>
        ingestConversationsSettings() {
      return getStubSettingsBuilder().ingestConversationsSettings();
    }

    /** Returns the builder for the settings used for calls to ingestConversations. */
    public OperationCallSettings.Builder<
            IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
        ingestConversationsOperationSettings() {
      return getStubSettingsBuilder().ingestConversationsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to exportInsightsData. */
    public UnaryCallSettings.Builder<ExportInsightsDataRequest, Operation>
        exportInsightsDataSettings() {
      return getStubSettingsBuilder().exportInsightsDataSettings();
    }

    /** Returns the builder for the settings used for calls to exportInsightsData. */
    public OperationCallSettings.Builder<
            ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
        exportInsightsDataOperationSettings() {
      return getStubSettingsBuilder().exportInsightsDataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createIssueModel. */
    public UnaryCallSettings.Builder<CreateIssueModelRequest, Operation>
        createIssueModelSettings() {
      return getStubSettingsBuilder().createIssueModelSettings();
    }

    /** Returns the builder for the settings used for calls to createIssueModel. */
    public OperationCallSettings.Builder<
            CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
        createIssueModelOperationSettings() {
      return getStubSettingsBuilder().createIssueModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateIssueModel. */
    public UnaryCallSettings.Builder<UpdateIssueModelRequest, IssueModel>
        updateIssueModelSettings() {
      return getStubSettingsBuilder().updateIssueModelSettings();
    }

    /** Returns the builder for the settings used for calls to getIssueModel. */
    public UnaryCallSettings.Builder<GetIssueModelRequest, IssueModel> getIssueModelSettings() {
      return getStubSettingsBuilder().getIssueModelSettings();
    }

    /** Returns the builder for the settings used for calls to listIssueModels. */
    public UnaryCallSettings.Builder<ListIssueModelsRequest, ListIssueModelsResponse>
        listIssueModelsSettings() {
      return getStubSettingsBuilder().listIssueModelsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIssueModel. */
    public UnaryCallSettings.Builder<DeleteIssueModelRequest, Operation>
        deleteIssueModelSettings() {
      return getStubSettingsBuilder().deleteIssueModelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIssueModel. */
    public OperationCallSettings.Builder<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
        deleteIssueModelOperationSettings() {
      return getStubSettingsBuilder().deleteIssueModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deployIssueModel. */
    public UnaryCallSettings.Builder<DeployIssueModelRequest, Operation>
        deployIssueModelSettings() {
      return getStubSettingsBuilder().deployIssueModelSettings();
    }

    /** Returns the builder for the settings used for calls to deployIssueModel. */
    public OperationCallSettings.Builder<
            DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
        deployIssueModelOperationSettings() {
      return getStubSettingsBuilder().deployIssueModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to undeployIssueModel. */
    public UnaryCallSettings.Builder<UndeployIssueModelRequest, Operation>
        undeployIssueModelSettings() {
      return getStubSettingsBuilder().undeployIssueModelSettings();
    }

    /** Returns the builder for the settings used for calls to undeployIssueModel. */
    public OperationCallSettings.Builder<
            UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
        undeployIssueModelOperationSettings() {
      return getStubSettingsBuilder().undeployIssueModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIssue. */
    public UnaryCallSettings.Builder<GetIssueRequest, Issue> getIssueSettings() {
      return getStubSettingsBuilder().getIssueSettings();
    }

    /** Returns the builder for the settings used for calls to listIssues. */
    public UnaryCallSettings.Builder<ListIssuesRequest, ListIssuesResponse> listIssuesSettings() {
      return getStubSettingsBuilder().listIssuesSettings();
    }

    /** Returns the builder for the settings used for calls to updateIssue. */
    public UnaryCallSettings.Builder<UpdateIssueRequest, Issue> updateIssueSettings() {
      return getStubSettingsBuilder().updateIssueSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIssue. */
    public UnaryCallSettings.Builder<DeleteIssueRequest, Empty> deleteIssueSettings() {
      return getStubSettingsBuilder().deleteIssueSettings();
    }

    /** Returns the builder for the settings used for calls to calculateIssueModelStats. */
    public UnaryCallSettings.Builder<
            CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
        calculateIssueModelStatsSettings() {
      return getStubSettingsBuilder().calculateIssueModelStatsSettings();
    }

    /** Returns the builder for the settings used for calls to createPhraseMatcher. */
    public UnaryCallSettings.Builder<CreatePhraseMatcherRequest, PhraseMatcher>
        createPhraseMatcherSettings() {
      return getStubSettingsBuilder().createPhraseMatcherSettings();
    }

    /** Returns the builder for the settings used for calls to getPhraseMatcher. */
    public UnaryCallSettings.Builder<GetPhraseMatcherRequest, PhraseMatcher>
        getPhraseMatcherSettings() {
      return getStubSettingsBuilder().getPhraseMatcherSettings();
    }

    /** Returns the builder for the settings used for calls to listPhraseMatchers. */
    public PagedCallSettings.Builder<
            ListPhraseMatchersRequest, ListPhraseMatchersResponse, ListPhraseMatchersPagedResponse>
        listPhraseMatchersSettings() {
      return getStubSettingsBuilder().listPhraseMatchersSettings();
    }

    /** Returns the builder for the settings used for calls to deletePhraseMatcher. */
    public UnaryCallSettings.Builder<DeletePhraseMatcherRequest, Empty>
        deletePhraseMatcherSettings() {
      return getStubSettingsBuilder().deletePhraseMatcherSettings();
    }

    /** Returns the builder for the settings used for calls to updatePhraseMatcher. */
    public UnaryCallSettings.Builder<UpdatePhraseMatcherRequest, PhraseMatcher>
        updatePhraseMatcherSettings() {
      return getStubSettingsBuilder().updatePhraseMatcherSettings();
    }

    /** Returns the builder for the settings used for calls to calculateStats. */
    public UnaryCallSettings.Builder<CalculateStatsRequest, CalculateStatsResponse>
        calculateStatsSettings() {
      return getStubSettingsBuilder().calculateStatsSettings();
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getStubSettingsBuilder().getSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings() {
      return getStubSettingsBuilder().updateSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to createView. */
    public UnaryCallSettings.Builder<CreateViewRequest, View> createViewSettings() {
      return getStubSettingsBuilder().createViewSettings();
    }

    /** Returns the builder for the settings used for calls to getView. */
    public UnaryCallSettings.Builder<GetViewRequest, View> getViewSettings() {
      return getStubSettingsBuilder().getViewSettings();
    }

    /** Returns the builder for the settings used for calls to listViews. */
    public PagedCallSettings.Builder<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
        listViewsSettings() {
      return getStubSettingsBuilder().listViewsSettings();
    }

    /** Returns the builder for the settings used for calls to updateView. */
    public UnaryCallSettings.Builder<UpdateViewRequest, View> updateViewSettings() {
      return getStubSettingsBuilder().updateViewSettings();
    }

    /** Returns the builder for the settings used for calls to deleteView. */
    public UnaryCallSettings.Builder<DeleteViewRequest, Empty> deleteViewSettings() {
      return getStubSettingsBuilder().deleteViewSettings();
    }

    @Override
    public ContactCenterInsightsSettings build() throws IOException {
      return new ContactCenterInsightsSettings(this);
    }
  }
}
