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

package com.google.cloud.contactcenterinsights.v1;

import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListAllFeedbackLabelsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListAnalysesPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListAnalysisRulesPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListConversationsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListFeedbackLabelsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListPhraseMatchersPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListQaQuestionsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListQaScorecardRevisionsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListQaScorecardsPagedResponse;
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createConversation:
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
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * ContactCenterInsightsSettings contactCenterInsightsSettings =
 *     contactCenterInsightsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for uploadConversation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ContactCenterInsightsSettings.Builder contactCenterInsightsSettingsBuilder =
 *     ContactCenterInsightsSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * contactCenterInsightsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ContactCenterInsightsSettings extends ClientSettings<ContactCenterInsightsSettings> {

  /** Returns the object with the settings used for calls to createConversation. */
  public UnaryCallSettings<CreateConversationRequest, Conversation> createConversationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createConversationSettings();
  }

  /** Returns the object with the settings used for calls to uploadConversation. */
  public UnaryCallSettings<UploadConversationRequest, Operation> uploadConversationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).uploadConversationSettings();
  }

  /** Returns the object with the settings used for calls to uploadConversation. */
  public OperationCallSettings<UploadConversationRequest, Conversation, UploadConversationMetadata>
      uploadConversationOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .uploadConversationOperationSettings();
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

  /** Returns the object with the settings used for calls to bulkDeleteConversations. */
  public UnaryCallSettings<BulkDeleteConversationsRequest, Operation>
      bulkDeleteConversationsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .bulkDeleteConversationsSettings();
  }

  /** Returns the object with the settings used for calls to bulkDeleteConversations. */
  public OperationCallSettings<
          BulkDeleteConversationsRequest,
          BulkDeleteConversationsResponse,
          BulkDeleteConversationsMetadata>
      bulkDeleteConversationsOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .bulkDeleteConversationsOperationSettings();
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

  /** Returns the object with the settings used for calls to exportIssueModel. */
  public UnaryCallSettings<ExportIssueModelRequest, Operation> exportIssueModelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).exportIssueModelSettings();
  }

  /** Returns the object with the settings used for calls to exportIssueModel. */
  public OperationCallSettings<
          ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .exportIssueModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to importIssueModel. */
  public UnaryCallSettings<ImportIssueModelRequest, Operation> importIssueModelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).importIssueModelSettings();
  }

  /** Returns the object with the settings used for calls to importIssueModel. */
  public OperationCallSettings<
          ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .importIssueModelOperationSettings();
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

  /** Returns the object with the settings used for calls to createAnalysisRule. */
  public UnaryCallSettings<CreateAnalysisRuleRequest, AnalysisRule> createAnalysisRuleSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createAnalysisRuleSettings();
  }

  /** Returns the object with the settings used for calls to getAnalysisRule. */
  public UnaryCallSettings<GetAnalysisRuleRequest, AnalysisRule> getAnalysisRuleSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getAnalysisRuleSettings();
  }

  /** Returns the object with the settings used for calls to listAnalysisRules. */
  public PagedCallSettings<
          ListAnalysisRulesRequest, ListAnalysisRulesResponse, ListAnalysisRulesPagedResponse>
      listAnalysisRulesSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listAnalysisRulesSettings();
  }

  /** Returns the object with the settings used for calls to updateAnalysisRule. */
  public UnaryCallSettings<UpdateAnalysisRuleRequest, AnalysisRule> updateAnalysisRuleSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updateAnalysisRuleSettings();
  }

  /** Returns the object with the settings used for calls to deleteAnalysisRule. */
  public UnaryCallSettings<DeleteAnalysisRuleRequest, Empty> deleteAnalysisRuleSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deleteAnalysisRuleSettings();
  }

  /** Returns the object with the settings used for calls to getEncryptionSpec. */
  public UnaryCallSettings<GetEncryptionSpecRequest, EncryptionSpec> getEncryptionSpecSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getEncryptionSpecSettings();
  }

  /** Returns the object with the settings used for calls to initializeEncryptionSpec. */
  public UnaryCallSettings<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .initializeEncryptionSpecSettings();
  }

  /** Returns the object with the settings used for calls to initializeEncryptionSpec. */
  public OperationCallSettings<
          InitializeEncryptionSpecRequest,
          InitializeEncryptionSpecResponse,
          InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .initializeEncryptionSpecOperationSettings();
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

  /** Returns the object with the settings used for calls to queryMetrics. */
  public UnaryCallSettings<QueryMetricsRequest, Operation> queryMetricsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).queryMetricsSettings();
  }

  /** Returns the object with the settings used for calls to queryMetrics. */
  public OperationCallSettings<QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
      queryMetricsOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).queryMetricsOperationSettings();
  }

  /** Returns the object with the settings used for calls to createQaQuestion. */
  public UnaryCallSettings<CreateQaQuestionRequest, QaQuestion> createQaQuestionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createQaQuestionSettings();
  }

  /** Returns the object with the settings used for calls to getQaQuestion. */
  public UnaryCallSettings<GetQaQuestionRequest, QaQuestion> getQaQuestionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getQaQuestionSettings();
  }

  /** Returns the object with the settings used for calls to updateQaQuestion. */
  public UnaryCallSettings<UpdateQaQuestionRequest, QaQuestion> updateQaQuestionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updateQaQuestionSettings();
  }

  /** Returns the object with the settings used for calls to deleteQaQuestion. */
  public UnaryCallSettings<DeleteQaQuestionRequest, Empty> deleteQaQuestionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deleteQaQuestionSettings();
  }

  /** Returns the object with the settings used for calls to listQaQuestions. */
  public PagedCallSettings<
          ListQaQuestionsRequest, ListQaQuestionsResponse, ListQaQuestionsPagedResponse>
      listQaQuestionsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listQaQuestionsSettings();
  }

  /** Returns the object with the settings used for calls to createQaScorecard. */
  public UnaryCallSettings<CreateQaScorecardRequest, QaScorecard> createQaScorecardSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createQaScorecardSettings();
  }

  /** Returns the object with the settings used for calls to getQaScorecard. */
  public UnaryCallSettings<GetQaScorecardRequest, QaScorecard> getQaScorecardSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getQaScorecardSettings();
  }

  /** Returns the object with the settings used for calls to updateQaScorecard. */
  public UnaryCallSettings<UpdateQaScorecardRequest, QaScorecard> updateQaScorecardSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updateQaScorecardSettings();
  }

  /** Returns the object with the settings used for calls to deleteQaScorecard. */
  public UnaryCallSettings<DeleteQaScorecardRequest, Empty> deleteQaScorecardSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deleteQaScorecardSettings();
  }

  /** Returns the object with the settings used for calls to listQaScorecards. */
  public PagedCallSettings<
          ListQaScorecardsRequest, ListQaScorecardsResponse, ListQaScorecardsPagedResponse>
      listQaScorecardsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listQaScorecardsSettings();
  }

  /** Returns the object with the settings used for calls to createQaScorecardRevision. */
  public UnaryCallSettings<CreateQaScorecardRevisionRequest, QaScorecardRevision>
      createQaScorecardRevisionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .createQaScorecardRevisionSettings();
  }

  /** Returns the object with the settings used for calls to getQaScorecardRevision. */
  public UnaryCallSettings<GetQaScorecardRevisionRequest, QaScorecardRevision>
      getQaScorecardRevisionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getQaScorecardRevisionSettings();
  }

  /** Returns the object with the settings used for calls to tuneQaScorecardRevision. */
  public UnaryCallSettings<TuneQaScorecardRevisionRequest, Operation>
      tuneQaScorecardRevisionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .tuneQaScorecardRevisionSettings();
  }

  /** Returns the object with the settings used for calls to tuneQaScorecardRevision. */
  public OperationCallSettings<
          TuneQaScorecardRevisionRequest,
          TuneQaScorecardRevisionResponse,
          TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .tuneQaScorecardRevisionOperationSettings();
  }

  /** Returns the object with the settings used for calls to deployQaScorecardRevision. */
  public UnaryCallSettings<DeployQaScorecardRevisionRequest, QaScorecardRevision>
      deployQaScorecardRevisionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .deployQaScorecardRevisionSettings();
  }

  /** Returns the object with the settings used for calls to undeployQaScorecardRevision. */
  public UnaryCallSettings<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
      undeployQaScorecardRevisionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .undeployQaScorecardRevisionSettings();
  }

  /** Returns the object with the settings used for calls to deleteQaScorecardRevision. */
  public UnaryCallSettings<DeleteQaScorecardRevisionRequest, Empty>
      deleteQaScorecardRevisionSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .deleteQaScorecardRevisionSettings();
  }

  /** Returns the object with the settings used for calls to listQaScorecardRevisions. */
  public PagedCallSettings<
          ListQaScorecardRevisionsRequest,
          ListQaScorecardRevisionsResponse,
          ListQaScorecardRevisionsPagedResponse>
      listQaScorecardRevisionsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .listQaScorecardRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to createFeedbackLabel. */
  public UnaryCallSettings<CreateFeedbackLabelRequest, FeedbackLabel>
      createFeedbackLabelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).createFeedbackLabelSettings();
  }

  /** Returns the object with the settings used for calls to listFeedbackLabels. */
  public PagedCallSettings<
          ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, ListFeedbackLabelsPagedResponse>
      listFeedbackLabelsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listFeedbackLabelsSettings();
  }

  /** Returns the object with the settings used for calls to getFeedbackLabel. */
  public UnaryCallSettings<GetFeedbackLabelRequest, FeedbackLabel> getFeedbackLabelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).getFeedbackLabelSettings();
  }

  /** Returns the object with the settings used for calls to updateFeedbackLabel. */
  public UnaryCallSettings<UpdateFeedbackLabelRequest, FeedbackLabel>
      updateFeedbackLabelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).updateFeedbackLabelSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeedbackLabel. */
  public UnaryCallSettings<DeleteFeedbackLabelRequest, Empty> deleteFeedbackLabelSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).deleteFeedbackLabelSettings();
  }

  /** Returns the object with the settings used for calls to listAllFeedbackLabels. */
  public PagedCallSettings<
          ListAllFeedbackLabelsRequest,
          ListAllFeedbackLabelsResponse,
          ListAllFeedbackLabelsPagedResponse>
      listAllFeedbackLabelsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings()).listAllFeedbackLabelsSettings();
  }

  /** Returns the object with the settings used for calls to bulkUploadFeedbackLabels. */
  public UnaryCallSettings<BulkUploadFeedbackLabelsRequest, Operation>
      bulkUploadFeedbackLabelsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .bulkUploadFeedbackLabelsSettings();
  }

  /** Returns the object with the settings used for calls to bulkUploadFeedbackLabels. */
  public OperationCallSettings<
          BulkUploadFeedbackLabelsRequest,
          BulkUploadFeedbackLabelsResponse,
          BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .bulkUploadFeedbackLabelsOperationSettings();
  }

  /** Returns the object with the settings used for calls to bulkDownloadFeedbackLabels. */
  public UnaryCallSettings<BulkDownloadFeedbackLabelsRequest, Operation>
      bulkDownloadFeedbackLabelsSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .bulkDownloadFeedbackLabelsSettings();
  }

  /** Returns the object with the settings used for calls to bulkDownloadFeedbackLabels. */
  public OperationCallSettings<
          BulkDownloadFeedbackLabelsRequest,
          BulkDownloadFeedbackLabelsResponse,
          BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsOperationSettings() {
    return ((ContactCenterInsightsStubSettings) getStubSettings())
        .bulkDownloadFeedbackLabelsOperationSettings();
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ContactCenterInsightsStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

    /** Returns the builder for the settings used for calls to uploadConversation. */
    public UnaryCallSettings.Builder<UploadConversationRequest, Operation>
        uploadConversationSettings() {
      return getStubSettingsBuilder().uploadConversationSettings();
    }

    /** Returns the builder for the settings used for calls to uploadConversation. */
    public OperationCallSettings.Builder<
            UploadConversationRequest, Conversation, UploadConversationMetadata>
        uploadConversationOperationSettings() {
      return getStubSettingsBuilder().uploadConversationOperationSettings();
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

    /** Returns the builder for the settings used for calls to bulkDeleteConversations. */
    public UnaryCallSettings.Builder<BulkDeleteConversationsRequest, Operation>
        bulkDeleteConversationsSettings() {
      return getStubSettingsBuilder().bulkDeleteConversationsSettings();
    }

    /** Returns the builder for the settings used for calls to bulkDeleteConversations. */
    public OperationCallSettings.Builder<
            BulkDeleteConversationsRequest,
            BulkDeleteConversationsResponse,
            BulkDeleteConversationsMetadata>
        bulkDeleteConversationsOperationSettings() {
      return getStubSettingsBuilder().bulkDeleteConversationsOperationSettings();
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

    /** Returns the builder for the settings used for calls to exportIssueModel. */
    public UnaryCallSettings.Builder<ExportIssueModelRequest, Operation>
        exportIssueModelSettings() {
      return getStubSettingsBuilder().exportIssueModelSettings();
    }

    /** Returns the builder for the settings used for calls to exportIssueModel. */
    public OperationCallSettings.Builder<
            ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
        exportIssueModelOperationSettings() {
      return getStubSettingsBuilder().exportIssueModelOperationSettings();
    }

    /** Returns the builder for the settings used for calls to importIssueModel. */
    public UnaryCallSettings.Builder<ImportIssueModelRequest, Operation>
        importIssueModelSettings() {
      return getStubSettingsBuilder().importIssueModelSettings();
    }

    /** Returns the builder for the settings used for calls to importIssueModel. */
    public OperationCallSettings.Builder<
            ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
        importIssueModelOperationSettings() {
      return getStubSettingsBuilder().importIssueModelOperationSettings();
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

    /** Returns the builder for the settings used for calls to createAnalysisRule. */
    public UnaryCallSettings.Builder<CreateAnalysisRuleRequest, AnalysisRule>
        createAnalysisRuleSettings() {
      return getStubSettingsBuilder().createAnalysisRuleSettings();
    }

    /** Returns the builder for the settings used for calls to getAnalysisRule. */
    public UnaryCallSettings.Builder<GetAnalysisRuleRequest, AnalysisRule>
        getAnalysisRuleSettings() {
      return getStubSettingsBuilder().getAnalysisRuleSettings();
    }

    /** Returns the builder for the settings used for calls to listAnalysisRules. */
    public PagedCallSettings.Builder<
            ListAnalysisRulesRequest, ListAnalysisRulesResponse, ListAnalysisRulesPagedResponse>
        listAnalysisRulesSettings() {
      return getStubSettingsBuilder().listAnalysisRulesSettings();
    }

    /** Returns the builder for the settings used for calls to updateAnalysisRule. */
    public UnaryCallSettings.Builder<UpdateAnalysisRuleRequest, AnalysisRule>
        updateAnalysisRuleSettings() {
      return getStubSettingsBuilder().updateAnalysisRuleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAnalysisRule. */
    public UnaryCallSettings.Builder<DeleteAnalysisRuleRequest, Empty>
        deleteAnalysisRuleSettings() {
      return getStubSettingsBuilder().deleteAnalysisRuleSettings();
    }

    /** Returns the builder for the settings used for calls to getEncryptionSpec. */
    public UnaryCallSettings.Builder<GetEncryptionSpecRequest, EncryptionSpec>
        getEncryptionSpecSettings() {
      return getStubSettingsBuilder().getEncryptionSpecSettings();
    }

    /** Returns the builder for the settings used for calls to initializeEncryptionSpec. */
    public UnaryCallSettings.Builder<InitializeEncryptionSpecRequest, Operation>
        initializeEncryptionSpecSettings() {
      return getStubSettingsBuilder().initializeEncryptionSpecSettings();
    }

    /** Returns the builder for the settings used for calls to initializeEncryptionSpec. */
    public OperationCallSettings.Builder<
            InitializeEncryptionSpecRequest,
            InitializeEncryptionSpecResponse,
            InitializeEncryptionSpecMetadata>
        initializeEncryptionSpecOperationSettings() {
      return getStubSettingsBuilder().initializeEncryptionSpecOperationSettings();
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

    /** Returns the builder for the settings used for calls to queryMetrics. */
    public UnaryCallSettings.Builder<QueryMetricsRequest, Operation> queryMetricsSettings() {
      return getStubSettingsBuilder().queryMetricsSettings();
    }

    /** Returns the builder for the settings used for calls to queryMetrics. */
    public OperationCallSettings.Builder<
            QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
        queryMetricsOperationSettings() {
      return getStubSettingsBuilder().queryMetricsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createQaQuestion. */
    public UnaryCallSettings.Builder<CreateQaQuestionRequest, QaQuestion>
        createQaQuestionSettings() {
      return getStubSettingsBuilder().createQaQuestionSettings();
    }

    /** Returns the builder for the settings used for calls to getQaQuestion. */
    public UnaryCallSettings.Builder<GetQaQuestionRequest, QaQuestion> getQaQuestionSettings() {
      return getStubSettingsBuilder().getQaQuestionSettings();
    }

    /** Returns the builder for the settings used for calls to updateQaQuestion. */
    public UnaryCallSettings.Builder<UpdateQaQuestionRequest, QaQuestion>
        updateQaQuestionSettings() {
      return getStubSettingsBuilder().updateQaQuestionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteQaQuestion. */
    public UnaryCallSettings.Builder<DeleteQaQuestionRequest, Empty> deleteQaQuestionSettings() {
      return getStubSettingsBuilder().deleteQaQuestionSettings();
    }

    /** Returns the builder for the settings used for calls to listQaQuestions. */
    public PagedCallSettings.Builder<
            ListQaQuestionsRequest, ListQaQuestionsResponse, ListQaQuestionsPagedResponse>
        listQaQuestionsSettings() {
      return getStubSettingsBuilder().listQaQuestionsSettings();
    }

    /** Returns the builder for the settings used for calls to createQaScorecard. */
    public UnaryCallSettings.Builder<CreateQaScorecardRequest, QaScorecard>
        createQaScorecardSettings() {
      return getStubSettingsBuilder().createQaScorecardSettings();
    }

    /** Returns the builder for the settings used for calls to getQaScorecard. */
    public UnaryCallSettings.Builder<GetQaScorecardRequest, QaScorecard> getQaScorecardSettings() {
      return getStubSettingsBuilder().getQaScorecardSettings();
    }

    /** Returns the builder for the settings used for calls to updateQaScorecard. */
    public UnaryCallSettings.Builder<UpdateQaScorecardRequest, QaScorecard>
        updateQaScorecardSettings() {
      return getStubSettingsBuilder().updateQaScorecardSettings();
    }

    /** Returns the builder for the settings used for calls to deleteQaScorecard. */
    public UnaryCallSettings.Builder<DeleteQaScorecardRequest, Empty> deleteQaScorecardSettings() {
      return getStubSettingsBuilder().deleteQaScorecardSettings();
    }

    /** Returns the builder for the settings used for calls to listQaScorecards. */
    public PagedCallSettings.Builder<
            ListQaScorecardsRequest, ListQaScorecardsResponse, ListQaScorecardsPagedResponse>
        listQaScorecardsSettings() {
      return getStubSettingsBuilder().listQaScorecardsSettings();
    }

    /** Returns the builder for the settings used for calls to createQaScorecardRevision. */
    public UnaryCallSettings.Builder<CreateQaScorecardRevisionRequest, QaScorecardRevision>
        createQaScorecardRevisionSettings() {
      return getStubSettingsBuilder().createQaScorecardRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to getQaScorecardRevision. */
    public UnaryCallSettings.Builder<GetQaScorecardRevisionRequest, QaScorecardRevision>
        getQaScorecardRevisionSettings() {
      return getStubSettingsBuilder().getQaScorecardRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to tuneQaScorecardRevision. */
    public UnaryCallSettings.Builder<TuneQaScorecardRevisionRequest, Operation>
        tuneQaScorecardRevisionSettings() {
      return getStubSettingsBuilder().tuneQaScorecardRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to tuneQaScorecardRevision. */
    public OperationCallSettings.Builder<
            TuneQaScorecardRevisionRequest,
            TuneQaScorecardRevisionResponse,
            TuneQaScorecardRevisionMetadata>
        tuneQaScorecardRevisionOperationSettings() {
      return getStubSettingsBuilder().tuneQaScorecardRevisionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deployQaScorecardRevision. */
    public UnaryCallSettings.Builder<DeployQaScorecardRevisionRequest, QaScorecardRevision>
        deployQaScorecardRevisionSettings() {
      return getStubSettingsBuilder().deployQaScorecardRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to undeployQaScorecardRevision. */
    public UnaryCallSettings.Builder<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
        undeployQaScorecardRevisionSettings() {
      return getStubSettingsBuilder().undeployQaScorecardRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteQaScorecardRevision. */
    public UnaryCallSettings.Builder<DeleteQaScorecardRevisionRequest, Empty>
        deleteQaScorecardRevisionSettings() {
      return getStubSettingsBuilder().deleteQaScorecardRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to listQaScorecardRevisions. */
    public PagedCallSettings.Builder<
            ListQaScorecardRevisionsRequest,
            ListQaScorecardRevisionsResponse,
            ListQaScorecardRevisionsPagedResponse>
        listQaScorecardRevisionsSettings() {
      return getStubSettingsBuilder().listQaScorecardRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to createFeedbackLabel. */
    public UnaryCallSettings.Builder<CreateFeedbackLabelRequest, FeedbackLabel>
        createFeedbackLabelSettings() {
      return getStubSettingsBuilder().createFeedbackLabelSettings();
    }

    /** Returns the builder for the settings used for calls to listFeedbackLabels. */
    public PagedCallSettings.Builder<
            ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, ListFeedbackLabelsPagedResponse>
        listFeedbackLabelsSettings() {
      return getStubSettingsBuilder().listFeedbackLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to getFeedbackLabel. */
    public UnaryCallSettings.Builder<GetFeedbackLabelRequest, FeedbackLabel>
        getFeedbackLabelSettings() {
      return getStubSettingsBuilder().getFeedbackLabelSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeedbackLabel. */
    public UnaryCallSettings.Builder<UpdateFeedbackLabelRequest, FeedbackLabel>
        updateFeedbackLabelSettings() {
      return getStubSettingsBuilder().updateFeedbackLabelSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeedbackLabel. */
    public UnaryCallSettings.Builder<DeleteFeedbackLabelRequest, Empty>
        deleteFeedbackLabelSettings() {
      return getStubSettingsBuilder().deleteFeedbackLabelSettings();
    }

    /** Returns the builder for the settings used for calls to listAllFeedbackLabels. */
    public PagedCallSettings.Builder<
            ListAllFeedbackLabelsRequest,
            ListAllFeedbackLabelsResponse,
            ListAllFeedbackLabelsPagedResponse>
        listAllFeedbackLabelsSettings() {
      return getStubSettingsBuilder().listAllFeedbackLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to bulkUploadFeedbackLabels. */
    public UnaryCallSettings.Builder<BulkUploadFeedbackLabelsRequest, Operation>
        bulkUploadFeedbackLabelsSettings() {
      return getStubSettingsBuilder().bulkUploadFeedbackLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to bulkUploadFeedbackLabels. */
    public OperationCallSettings.Builder<
            BulkUploadFeedbackLabelsRequest,
            BulkUploadFeedbackLabelsResponse,
            BulkUploadFeedbackLabelsMetadata>
        bulkUploadFeedbackLabelsOperationSettings() {
      return getStubSettingsBuilder().bulkUploadFeedbackLabelsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to bulkDownloadFeedbackLabels. */
    public UnaryCallSettings.Builder<BulkDownloadFeedbackLabelsRequest, Operation>
        bulkDownloadFeedbackLabelsSettings() {
      return getStubSettingsBuilder().bulkDownloadFeedbackLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to bulkDownloadFeedbackLabels. */
    public OperationCallSettings.Builder<
            BulkDownloadFeedbackLabelsRequest,
            BulkDownloadFeedbackLabelsResponse,
            BulkDownloadFeedbackLabelsMetadata>
        bulkDownloadFeedbackLabelsOperationSettings() {
      return getStubSettingsBuilder().bulkDownloadFeedbackLabelsOperationSettings();
    }

    @Override
    public ContactCenterInsightsSettings build() throws IOException {
      return new ContactCenterInsightsSettings(this);
    }
  }
}
