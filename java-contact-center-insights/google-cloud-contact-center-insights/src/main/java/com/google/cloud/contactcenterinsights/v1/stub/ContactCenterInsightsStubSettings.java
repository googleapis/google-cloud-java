/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.contactcenterinsights.v1.stub;

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
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contactcenterinsights.v1.Analysis;
import com.google.cloud.contactcenterinsights.v1.AnalysisRule;
import com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsMetadata;
import com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest;
import com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsResponse;
import com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsMetadata;
import com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest;
import com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsResponse;
import com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsMetadata;
import com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest;
import com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsResponse;
import com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsMetadata;
import com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest;
import com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsResponse;
import com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest;
import com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse;
import com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest;
import com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse;
import com.google.cloud.contactcenterinsights.v1.Conversation;
import com.google.cloud.contactcenterinsights.v1.CreateAnalysisOperationMetadata;
import com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest;
import com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest;
import com.google.cloud.contactcenterinsights.v1.CreateConversationRequest;
import com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest;
import com.google.cloud.contactcenterinsights.v1.CreateIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest;
import com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest;
import com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest;
import com.google.cloud.contactcenterinsights.v1.CreateViewRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest;
import com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteViewRequest;
import com.google.cloud.contactcenterinsights.v1.DeployIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.DeployIssueModelResponse;
import com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest;
import com.google.cloud.contactcenterinsights.v1.EncryptionSpec;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataMetadata;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataResponse;
import com.google.cloud.contactcenterinsights.v1.ExportIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.ExportIssueModelResponse;
import com.google.cloud.contactcenterinsights.v1.FeedbackLabel;
import com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest;
import com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest;
import com.google.cloud.contactcenterinsights.v1.GetConversationRequest;
import com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest;
import com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest;
import com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.GetIssueRequest;
import com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest;
import com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest;
import com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest;
import com.google.cloud.contactcenterinsights.v1.GetSettingsRequest;
import com.google.cloud.contactcenterinsights.v1.GetViewRequest;
import com.google.cloud.contactcenterinsights.v1.ImportIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.ImportIssueModelResponse;
import com.google.cloud.contactcenterinsights.v1.IngestConversationsMetadata;
import com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest;
import com.google.cloud.contactcenterinsights.v1.IngestConversationsResponse;
import com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecMetadata;
import com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest;
import com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecResponse;
import com.google.cloud.contactcenterinsights.v1.Issue;
import com.google.cloud.contactcenterinsights.v1.IssueModel;
import com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest;
import com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse;
import com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest;
import com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse;
import com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest;
import com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse;
import com.google.cloud.contactcenterinsights.v1.ListConversationsRequest;
import com.google.cloud.contactcenterinsights.v1.ListConversationsResponse;
import com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest;
import com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse;
import com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest;
import com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse;
import com.google.cloud.contactcenterinsights.v1.ListIssuesRequest;
import com.google.cloud.contactcenterinsights.v1.ListIssuesResponse;
import com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest;
import com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse;
import com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest;
import com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse;
import com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest;
import com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse;
import com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest;
import com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse;
import com.google.cloud.contactcenterinsights.v1.ListViewsRequest;
import com.google.cloud.contactcenterinsights.v1.ListViewsResponse;
import com.google.cloud.contactcenterinsights.v1.PhraseMatcher;
import com.google.cloud.contactcenterinsights.v1.QaQuestion;
import com.google.cloud.contactcenterinsights.v1.QaScorecard;
import com.google.cloud.contactcenterinsights.v1.QaScorecardRevision;
import com.google.cloud.contactcenterinsights.v1.QueryMetricsMetadata;
import com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest;
import com.google.cloud.contactcenterinsights.v1.QueryMetricsResponse;
import com.google.cloud.contactcenterinsights.v1.Settings;
import com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionMetadata;
import com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest;
import com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionResponse;
import com.google.cloud.contactcenterinsights.v1.UndeployIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.UndeployIssueModelResponse;
import com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest;
import com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateViewRequest;
import com.google.cloud.contactcenterinsights.v1.UploadConversationMetadata;
import com.google.cloud.contactcenterinsights.v1.UploadConversationRequest;
import com.google.cloud.contactcenterinsights.v1.View;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ContactCenterInsightsStub}.
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
 * ContactCenterInsightsStubSettings.Builder contactCenterInsightsSettingsBuilder =
 *     ContactCenterInsightsStubSettings.newBuilder();
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
 * ContactCenterInsightsStubSettings contactCenterInsightsSettings =
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
 * ContactCenterInsightsStubSettings.Builder contactCenterInsightsSettingsBuilder =
 *     ContactCenterInsightsStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelay(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * contactCenterInsightsSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ContactCenterInsightsStubSettings
    extends StubSettings<ContactCenterInsightsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateConversationRequest, Conversation>
      createConversationSettings;
  private final UnaryCallSettings<UploadConversationRequest, Operation> uploadConversationSettings;
  private final OperationCallSettings<
          UploadConversationRequest, Conversation, UploadConversationMetadata>
      uploadConversationOperationSettings;
  private final UnaryCallSettings<UpdateConversationRequest, Conversation>
      updateConversationSettings;
  private final UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings;
  private final PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings;
  private final UnaryCallSettings<DeleteConversationRequest, Empty> deleteConversationSettings;
  private final UnaryCallSettings<CreateAnalysisRequest, Operation> createAnalysisSettings;
  private final OperationCallSettings<
          CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
      createAnalysisOperationSettings;
  private final UnaryCallSettings<GetAnalysisRequest, Analysis> getAnalysisSettings;
  private final PagedCallSettings<
          ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
      listAnalysesSettings;
  private final UnaryCallSettings<DeleteAnalysisRequest, Empty> deleteAnalysisSettings;
  private final UnaryCallSettings<BulkAnalyzeConversationsRequest, Operation>
      bulkAnalyzeConversationsSettings;
  private final OperationCallSettings<
          BulkAnalyzeConversationsRequest,
          BulkAnalyzeConversationsResponse,
          BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsOperationSettings;
  private final UnaryCallSettings<BulkDeleteConversationsRequest, Operation>
      bulkDeleteConversationsSettings;
  private final OperationCallSettings<
          BulkDeleteConversationsRequest,
          BulkDeleteConversationsResponse,
          BulkDeleteConversationsMetadata>
      bulkDeleteConversationsOperationSettings;
  private final UnaryCallSettings<IngestConversationsRequest, Operation>
      ingestConversationsSettings;
  private final OperationCallSettings<
          IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsOperationSettings;
  private final UnaryCallSettings<ExportInsightsDataRequest, Operation> exportInsightsDataSettings;
  private final OperationCallSettings<
          ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataOperationSettings;
  private final UnaryCallSettings<CreateIssueModelRequest, Operation> createIssueModelSettings;
  private final OperationCallSettings<CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
      createIssueModelOperationSettings;
  private final UnaryCallSettings<UpdateIssueModelRequest, IssueModel> updateIssueModelSettings;
  private final UnaryCallSettings<GetIssueModelRequest, IssueModel> getIssueModelSettings;
  private final UnaryCallSettings<ListIssueModelsRequest, ListIssueModelsResponse>
      listIssueModelsSettings;
  private final UnaryCallSettings<DeleteIssueModelRequest, Operation> deleteIssueModelSettings;
  private final OperationCallSettings<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
      deleteIssueModelOperationSettings;
  private final UnaryCallSettings<DeployIssueModelRequest, Operation> deployIssueModelSettings;
  private final OperationCallSettings<
          DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelOperationSettings;
  private final UnaryCallSettings<UndeployIssueModelRequest, Operation> undeployIssueModelSettings;
  private final OperationCallSettings<
          UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelOperationSettings;
  private final UnaryCallSettings<ExportIssueModelRequest, Operation> exportIssueModelSettings;
  private final OperationCallSettings<
          ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelOperationSettings;
  private final UnaryCallSettings<ImportIssueModelRequest, Operation> importIssueModelSettings;
  private final OperationCallSettings<
          ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelOperationSettings;
  private final UnaryCallSettings<GetIssueRequest, Issue> getIssueSettings;
  private final UnaryCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesSettings;
  private final UnaryCallSettings<UpdateIssueRequest, Issue> updateIssueSettings;
  private final UnaryCallSettings<DeleteIssueRequest, Empty> deleteIssueSettings;
  private final UnaryCallSettings<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsSettings;
  private final UnaryCallSettings<CreatePhraseMatcherRequest, PhraseMatcher>
      createPhraseMatcherSettings;
  private final UnaryCallSettings<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherSettings;
  private final PagedCallSettings<
          ListPhraseMatchersRequest, ListPhraseMatchersResponse, ListPhraseMatchersPagedResponse>
      listPhraseMatchersSettings;
  private final UnaryCallSettings<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherSettings;
  private final UnaryCallSettings<UpdatePhraseMatcherRequest, PhraseMatcher>
      updatePhraseMatcherSettings;
  private final UnaryCallSettings<CalculateStatsRequest, CalculateStatsResponse>
      calculateStatsSettings;
  private final UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings;
  private final UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings;
  private final UnaryCallSettings<CreateAnalysisRuleRequest, AnalysisRule>
      createAnalysisRuleSettings;
  private final UnaryCallSettings<GetAnalysisRuleRequest, AnalysisRule> getAnalysisRuleSettings;
  private final PagedCallSettings<
          ListAnalysisRulesRequest, ListAnalysisRulesResponse, ListAnalysisRulesPagedResponse>
      listAnalysisRulesSettings;
  private final UnaryCallSettings<UpdateAnalysisRuleRequest, AnalysisRule>
      updateAnalysisRuleSettings;
  private final UnaryCallSettings<DeleteAnalysisRuleRequest, Empty> deleteAnalysisRuleSettings;
  private final UnaryCallSettings<GetEncryptionSpecRequest, EncryptionSpec>
      getEncryptionSpecSettings;
  private final UnaryCallSettings<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecSettings;
  private final OperationCallSettings<
          InitializeEncryptionSpecRequest,
          InitializeEncryptionSpecResponse,
          InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecOperationSettings;
  private final UnaryCallSettings<CreateViewRequest, View> createViewSettings;
  private final UnaryCallSettings<GetViewRequest, View> getViewSettings;
  private final PagedCallSettings<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      listViewsSettings;
  private final UnaryCallSettings<UpdateViewRequest, View> updateViewSettings;
  private final UnaryCallSettings<DeleteViewRequest, Empty> deleteViewSettings;
  private final UnaryCallSettings<QueryMetricsRequest, Operation> queryMetricsSettings;
  private final OperationCallSettings<
          QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
      queryMetricsOperationSettings;
  private final UnaryCallSettings<CreateQaQuestionRequest, QaQuestion> createQaQuestionSettings;
  private final UnaryCallSettings<GetQaQuestionRequest, QaQuestion> getQaQuestionSettings;
  private final UnaryCallSettings<UpdateQaQuestionRequest, QaQuestion> updateQaQuestionSettings;
  private final UnaryCallSettings<DeleteQaQuestionRequest, Empty> deleteQaQuestionSettings;
  private final PagedCallSettings<
          ListQaQuestionsRequest, ListQaQuestionsResponse, ListQaQuestionsPagedResponse>
      listQaQuestionsSettings;
  private final UnaryCallSettings<CreateQaScorecardRequest, QaScorecard> createQaScorecardSettings;
  private final UnaryCallSettings<GetQaScorecardRequest, QaScorecard> getQaScorecardSettings;
  private final UnaryCallSettings<UpdateQaScorecardRequest, QaScorecard> updateQaScorecardSettings;
  private final UnaryCallSettings<DeleteQaScorecardRequest, Empty> deleteQaScorecardSettings;
  private final PagedCallSettings<
          ListQaScorecardsRequest, ListQaScorecardsResponse, ListQaScorecardsPagedResponse>
      listQaScorecardsSettings;
  private final UnaryCallSettings<CreateQaScorecardRevisionRequest, QaScorecardRevision>
      createQaScorecardRevisionSettings;
  private final UnaryCallSettings<GetQaScorecardRevisionRequest, QaScorecardRevision>
      getQaScorecardRevisionSettings;
  private final UnaryCallSettings<TuneQaScorecardRevisionRequest, Operation>
      tuneQaScorecardRevisionSettings;
  private final OperationCallSettings<
          TuneQaScorecardRevisionRequest,
          TuneQaScorecardRevisionResponse,
          TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionOperationSettings;
  private final UnaryCallSettings<DeployQaScorecardRevisionRequest, QaScorecardRevision>
      deployQaScorecardRevisionSettings;
  private final UnaryCallSettings<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
      undeployQaScorecardRevisionSettings;
  private final UnaryCallSettings<DeleteQaScorecardRevisionRequest, Empty>
      deleteQaScorecardRevisionSettings;
  private final PagedCallSettings<
          ListQaScorecardRevisionsRequest,
          ListQaScorecardRevisionsResponse,
          ListQaScorecardRevisionsPagedResponse>
      listQaScorecardRevisionsSettings;
  private final UnaryCallSettings<CreateFeedbackLabelRequest, FeedbackLabel>
      createFeedbackLabelSettings;
  private final PagedCallSettings<
          ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, ListFeedbackLabelsPagedResponse>
      listFeedbackLabelsSettings;
  private final UnaryCallSettings<GetFeedbackLabelRequest, FeedbackLabel> getFeedbackLabelSettings;
  private final UnaryCallSettings<UpdateFeedbackLabelRequest, FeedbackLabel>
      updateFeedbackLabelSettings;
  private final UnaryCallSettings<DeleteFeedbackLabelRequest, Empty> deleteFeedbackLabelSettings;
  private final PagedCallSettings<
          ListAllFeedbackLabelsRequest,
          ListAllFeedbackLabelsResponse,
          ListAllFeedbackLabelsPagedResponse>
      listAllFeedbackLabelsSettings;
  private final UnaryCallSettings<BulkUploadFeedbackLabelsRequest, Operation>
      bulkUploadFeedbackLabelsSettings;
  private final OperationCallSettings<
          BulkUploadFeedbackLabelsRequest,
          BulkUploadFeedbackLabelsResponse,
          BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsOperationSettings;
  private final UnaryCallSettings<BulkDownloadFeedbackLabelsRequest, Operation>
      bulkDownloadFeedbackLabelsSettings;
  private final OperationCallSettings<
          BulkDownloadFeedbackLabelsRequest,
          BulkDownloadFeedbackLabelsResponse,
          BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsOperationSettings;

  private static final PagedListDescriptor<
          ListConversationsRequest, ListConversationsResponse, Conversation>
      LIST_CONVERSATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConversationsRequest, ListConversationsResponse, Conversation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConversationsRequest injectToken(
                ListConversationsRequest payload, String token) {
              return ListConversationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConversationsRequest injectPageSize(
                ListConversationsRequest payload, int pageSize) {
              return ListConversationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConversationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConversationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Conversation> extractResources(ListConversationsResponse payload) {
              return payload.getConversationsList();
            }
          };

  private static final PagedListDescriptor<ListAnalysesRequest, ListAnalysesResponse, Analysis>
      LIST_ANALYSES_PAGE_STR_DESC =
          new PagedListDescriptor<ListAnalysesRequest, ListAnalysesResponse, Analysis>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnalysesRequest injectToken(ListAnalysesRequest payload, String token) {
              return ListAnalysesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnalysesRequest injectPageSize(ListAnalysesRequest payload, int pageSize) {
              return ListAnalysesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAnalysesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnalysesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Analysis> extractResources(ListAnalysesResponse payload) {
              return payload.getAnalysesList();
            }
          };

  private static final PagedListDescriptor<
          ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher>
      LIST_PHRASE_MATCHERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPhraseMatchersRequest injectToken(
                ListPhraseMatchersRequest payload, String token) {
              return ListPhraseMatchersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPhraseMatchersRequest injectPageSize(
                ListPhraseMatchersRequest payload, int pageSize) {
              return ListPhraseMatchersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPhraseMatchersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPhraseMatchersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PhraseMatcher> extractResources(ListPhraseMatchersResponse payload) {
              return payload.getPhraseMatchersList();
            }
          };

  private static final PagedListDescriptor<
          ListAnalysisRulesRequest, ListAnalysisRulesResponse, AnalysisRule>
      LIST_ANALYSIS_RULES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAnalysisRulesRequest, ListAnalysisRulesResponse, AnalysisRule>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAnalysisRulesRequest injectToken(
                ListAnalysisRulesRequest payload, String token) {
              return ListAnalysisRulesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAnalysisRulesRequest injectPageSize(
                ListAnalysisRulesRequest payload, int pageSize) {
              return ListAnalysisRulesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAnalysisRulesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAnalysisRulesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AnalysisRule> extractResources(ListAnalysisRulesResponse payload) {
              return payload.getAnalysisRulesList();
            }
          };

  private static final PagedListDescriptor<ListViewsRequest, ListViewsResponse, View>
      LIST_VIEWS_PAGE_STR_DESC =
          new PagedListDescriptor<ListViewsRequest, ListViewsResponse, View>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListViewsRequest injectToken(ListViewsRequest payload, String token) {
              return ListViewsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListViewsRequest injectPageSize(ListViewsRequest payload, int pageSize) {
              return ListViewsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListViewsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListViewsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<View> extractResources(ListViewsResponse payload) {
              return payload.getViewsList();
            }
          };

  private static final PagedListDescriptor<
          ListQaQuestionsRequest, ListQaQuestionsResponse, QaQuestion>
      LIST_QA_QUESTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListQaQuestionsRequest, ListQaQuestionsResponse, QaQuestion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListQaQuestionsRequest injectToken(
                ListQaQuestionsRequest payload, String token) {
              return ListQaQuestionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListQaQuestionsRequest injectPageSize(
                ListQaQuestionsRequest payload, int pageSize) {
              return ListQaQuestionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListQaQuestionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListQaQuestionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<QaQuestion> extractResources(ListQaQuestionsResponse payload) {
              return payload.getQaQuestionsList();
            }
          };

  private static final PagedListDescriptor<
          ListQaScorecardsRequest, ListQaScorecardsResponse, QaScorecard>
      LIST_QA_SCORECARDS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListQaScorecardsRequest, ListQaScorecardsResponse, QaScorecard>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListQaScorecardsRequest injectToken(
                ListQaScorecardsRequest payload, String token) {
              return ListQaScorecardsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListQaScorecardsRequest injectPageSize(
                ListQaScorecardsRequest payload, int pageSize) {
              return ListQaScorecardsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListQaScorecardsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListQaScorecardsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<QaScorecard> extractResources(ListQaScorecardsResponse payload) {
              return payload.getQaScorecardsList();
            }
          };

  private static final PagedListDescriptor<
          ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse, QaScorecardRevision>
      LIST_QA_SCORECARD_REVISIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListQaScorecardRevisionsRequest,
              ListQaScorecardRevisionsResponse,
              QaScorecardRevision>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListQaScorecardRevisionsRequest injectToken(
                ListQaScorecardRevisionsRequest payload, String token) {
              return ListQaScorecardRevisionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListQaScorecardRevisionsRequest injectPageSize(
                ListQaScorecardRevisionsRequest payload, int pageSize) {
              return ListQaScorecardRevisionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListQaScorecardRevisionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListQaScorecardRevisionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<QaScorecardRevision> extractResources(
                ListQaScorecardRevisionsResponse payload) {
              return payload.getQaScorecardRevisionsList();
            }
          };

  private static final PagedListDescriptor<
          ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, FeedbackLabel>
      LIST_FEEDBACK_LABELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, FeedbackLabel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeedbackLabelsRequest injectToken(
                ListFeedbackLabelsRequest payload, String token) {
              return ListFeedbackLabelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeedbackLabelsRequest injectPageSize(
                ListFeedbackLabelsRequest payload, int pageSize) {
              return ListFeedbackLabelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeedbackLabelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeedbackLabelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeedbackLabel> extractResources(ListFeedbackLabelsResponse payload) {
              return payload.getFeedbackLabelsList();
            }
          };

  private static final PagedListDescriptor<
          ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse, FeedbackLabel>
      LIST_ALL_FEEDBACK_LABELS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse, FeedbackLabel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAllFeedbackLabelsRequest injectToken(
                ListAllFeedbackLabelsRequest payload, String token) {
              return ListAllFeedbackLabelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAllFeedbackLabelsRequest injectPageSize(
                ListAllFeedbackLabelsRequest payload, int pageSize) {
              return ListAllFeedbackLabelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAllFeedbackLabelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAllFeedbackLabelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeedbackLabel> extractResources(ListAllFeedbackLabelsResponse payload) {
              return payload.getFeedbackLabelsList();
            }
          };

  private static final PagedListResponseFactory<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      LIST_CONVERSATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConversationsRequest,
              ListConversationsResponse,
              ListConversationsPagedResponse>() {
            @Override
            public ApiFuture<ListConversationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConversationsRequest, ListConversationsResponse> callable,
                ListConversationsRequest request,
                ApiCallContext context,
                ApiFuture<ListConversationsResponse> futureResponse) {
              PageContext<ListConversationsRequest, ListConversationsResponse, Conversation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONVERSATIONS_PAGE_STR_DESC, request, context);
              return ListConversationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
      LIST_ANALYSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>() {
            @Override
            public ApiFuture<ListAnalysesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> callable,
                ListAnalysesRequest request,
                ApiCallContext context,
                ApiFuture<ListAnalysesResponse> futureResponse) {
              PageContext<ListAnalysesRequest, ListAnalysesResponse, Analysis> pageContext =
                  PageContext.create(callable, LIST_ANALYSES_PAGE_STR_DESC, request, context);
              return ListAnalysesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPhraseMatchersRequest, ListPhraseMatchersResponse, ListPhraseMatchersPagedResponse>
      LIST_PHRASE_MATCHERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPhraseMatchersRequest,
              ListPhraseMatchersResponse,
              ListPhraseMatchersPagedResponse>() {
            @Override
            public ApiFuture<ListPhraseMatchersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersResponse> callable,
                ListPhraseMatchersRequest request,
                ApiCallContext context,
                ApiFuture<ListPhraseMatchersResponse> futureResponse) {
              PageContext<ListPhraseMatchersRequest, ListPhraseMatchersResponse, PhraseMatcher>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PHRASE_MATCHERS_PAGE_STR_DESC, request, context);
              return ListPhraseMatchersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAnalysisRulesRequest, ListAnalysisRulesResponse, ListAnalysisRulesPagedResponse>
      LIST_ANALYSIS_RULES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAnalysisRulesRequest,
              ListAnalysisRulesResponse,
              ListAnalysisRulesPagedResponse>() {
            @Override
            public ApiFuture<ListAnalysisRulesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAnalysisRulesRequest, ListAnalysisRulesResponse> callable,
                ListAnalysisRulesRequest request,
                ApiCallContext context,
                ApiFuture<ListAnalysisRulesResponse> futureResponse) {
              PageContext<ListAnalysisRulesRequest, ListAnalysisRulesResponse, AnalysisRule>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ANALYSIS_RULES_PAGE_STR_DESC, request, context);
              return ListAnalysisRulesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      LIST_VIEWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>() {
            @Override
            public ApiFuture<ListViewsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListViewsRequest, ListViewsResponse> callable,
                ListViewsRequest request,
                ApiCallContext context,
                ApiFuture<ListViewsResponse> futureResponse) {
              PageContext<ListViewsRequest, ListViewsResponse, View> pageContext =
                  PageContext.create(callable, LIST_VIEWS_PAGE_STR_DESC, request, context);
              return ListViewsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListQaQuestionsRequest, ListQaQuestionsResponse, ListQaQuestionsPagedResponse>
      LIST_QA_QUESTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListQaQuestionsRequest, ListQaQuestionsResponse, ListQaQuestionsPagedResponse>() {
            @Override
            public ApiFuture<ListQaQuestionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListQaQuestionsRequest, ListQaQuestionsResponse> callable,
                ListQaQuestionsRequest request,
                ApiCallContext context,
                ApiFuture<ListQaQuestionsResponse> futureResponse) {
              PageContext<ListQaQuestionsRequest, ListQaQuestionsResponse, QaQuestion> pageContext =
                  PageContext.create(callable, LIST_QA_QUESTIONS_PAGE_STR_DESC, request, context);
              return ListQaQuestionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListQaScorecardsRequest, ListQaScorecardsResponse, ListQaScorecardsPagedResponse>
      LIST_QA_SCORECARDS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListQaScorecardsRequest, ListQaScorecardsResponse, ListQaScorecardsPagedResponse>() {
            @Override
            public ApiFuture<ListQaScorecardsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListQaScorecardsRequest, ListQaScorecardsResponse> callable,
                ListQaScorecardsRequest request,
                ApiCallContext context,
                ApiFuture<ListQaScorecardsResponse> futureResponse) {
              PageContext<ListQaScorecardsRequest, ListQaScorecardsResponse, QaScorecard>
                  pageContext =
                      PageContext.create(
                          callable, LIST_QA_SCORECARDS_PAGE_STR_DESC, request, context);
              return ListQaScorecardsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListQaScorecardRevisionsRequest,
          ListQaScorecardRevisionsResponse,
          ListQaScorecardRevisionsPagedResponse>
      LIST_QA_SCORECARD_REVISIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListQaScorecardRevisionsRequest,
              ListQaScorecardRevisionsResponse,
              ListQaScorecardRevisionsPagedResponse>() {
            @Override
            public ApiFuture<ListQaScorecardRevisionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>
                    callable,
                ListQaScorecardRevisionsRequest request,
                ApiCallContext context,
                ApiFuture<ListQaScorecardRevisionsResponse> futureResponse) {
              PageContext<
                      ListQaScorecardRevisionsRequest,
                      ListQaScorecardRevisionsResponse,
                      QaScorecardRevision>
                  pageContext =
                      PageContext.create(
                          callable, LIST_QA_SCORECARD_REVISIONS_PAGE_STR_DESC, request, context);
              return ListQaScorecardRevisionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, ListFeedbackLabelsPagedResponse>
      LIST_FEEDBACK_LABELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeedbackLabelsRequest,
              ListFeedbackLabelsResponse,
              ListFeedbackLabelsPagedResponse>() {
            @Override
            public ApiFuture<ListFeedbackLabelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse> callable,
                ListFeedbackLabelsRequest request,
                ApiCallContext context,
                ApiFuture<ListFeedbackLabelsResponse> futureResponse) {
              PageContext<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, FeedbackLabel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FEEDBACK_LABELS_PAGE_STR_DESC, request, context);
              return ListFeedbackLabelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAllFeedbackLabelsRequest,
          ListAllFeedbackLabelsResponse,
          ListAllFeedbackLabelsPagedResponse>
      LIST_ALL_FEEDBACK_LABELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAllFeedbackLabelsRequest,
              ListAllFeedbackLabelsResponse,
              ListAllFeedbackLabelsPagedResponse>() {
            @Override
            public ApiFuture<ListAllFeedbackLabelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse> callable,
                ListAllFeedbackLabelsRequest request,
                ApiCallContext context,
                ApiFuture<ListAllFeedbackLabelsResponse> futureResponse) {
              PageContext<
                      ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse, FeedbackLabel>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ALL_FEEDBACK_LABELS_PAGE_STR_DESC, request, context);
              return ListAllFeedbackLabelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createConversation. */
  public UnaryCallSettings<CreateConversationRequest, Conversation> createConversationSettings() {
    return createConversationSettings;
  }

  /** Returns the object with the settings used for calls to uploadConversation. */
  public UnaryCallSettings<UploadConversationRequest, Operation> uploadConversationSettings() {
    return uploadConversationSettings;
  }

  /** Returns the object with the settings used for calls to uploadConversation. */
  public OperationCallSettings<UploadConversationRequest, Conversation, UploadConversationMetadata>
      uploadConversationOperationSettings() {
    return uploadConversationOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateConversation. */
  public UnaryCallSettings<UpdateConversationRequest, Conversation> updateConversationSettings() {
    return updateConversationSettings;
  }

  /** Returns the object with the settings used for calls to getConversation. */
  public UnaryCallSettings<GetConversationRequest, Conversation> getConversationSettings() {
    return getConversationSettings;
  }

  /** Returns the object with the settings used for calls to listConversations. */
  public PagedCallSettings<
          ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
      listConversationsSettings() {
    return listConversationsSettings;
  }

  /** Returns the object with the settings used for calls to deleteConversation. */
  public UnaryCallSettings<DeleteConversationRequest, Empty> deleteConversationSettings() {
    return deleteConversationSettings;
  }

  /** Returns the object with the settings used for calls to createAnalysis. */
  public UnaryCallSettings<CreateAnalysisRequest, Operation> createAnalysisSettings() {
    return createAnalysisSettings;
  }

  /** Returns the object with the settings used for calls to createAnalysis. */
  public OperationCallSettings<CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
      createAnalysisOperationSettings() {
    return createAnalysisOperationSettings;
  }

  /** Returns the object with the settings used for calls to getAnalysis. */
  public UnaryCallSettings<GetAnalysisRequest, Analysis> getAnalysisSettings() {
    return getAnalysisSettings;
  }

  /** Returns the object with the settings used for calls to listAnalyses. */
  public PagedCallSettings<ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
      listAnalysesSettings() {
    return listAnalysesSettings;
  }

  /** Returns the object with the settings used for calls to deleteAnalysis. */
  public UnaryCallSettings<DeleteAnalysisRequest, Empty> deleteAnalysisSettings() {
    return deleteAnalysisSettings;
  }

  /** Returns the object with the settings used for calls to bulkAnalyzeConversations. */
  public UnaryCallSettings<BulkAnalyzeConversationsRequest, Operation>
      bulkAnalyzeConversationsSettings() {
    return bulkAnalyzeConversationsSettings;
  }

  /** Returns the object with the settings used for calls to bulkAnalyzeConversations. */
  public OperationCallSettings<
          BulkAnalyzeConversationsRequest,
          BulkAnalyzeConversationsResponse,
          BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsOperationSettings() {
    return bulkAnalyzeConversationsOperationSettings;
  }

  /** Returns the object with the settings used for calls to bulkDeleteConversations. */
  public UnaryCallSettings<BulkDeleteConversationsRequest, Operation>
      bulkDeleteConversationsSettings() {
    return bulkDeleteConversationsSettings;
  }

  /** Returns the object with the settings used for calls to bulkDeleteConversations. */
  public OperationCallSettings<
          BulkDeleteConversationsRequest,
          BulkDeleteConversationsResponse,
          BulkDeleteConversationsMetadata>
      bulkDeleteConversationsOperationSettings() {
    return bulkDeleteConversationsOperationSettings;
  }

  /** Returns the object with the settings used for calls to ingestConversations. */
  public UnaryCallSettings<IngestConversationsRequest, Operation> ingestConversationsSettings() {
    return ingestConversationsSettings;
  }

  /** Returns the object with the settings used for calls to ingestConversations. */
  public OperationCallSettings<
          IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsOperationSettings() {
    return ingestConversationsOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportInsightsData. */
  public UnaryCallSettings<ExportInsightsDataRequest, Operation> exportInsightsDataSettings() {
    return exportInsightsDataSettings;
  }

  /** Returns the object with the settings used for calls to exportInsightsData. */
  public OperationCallSettings<
          ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataOperationSettings() {
    return exportInsightsDataOperationSettings;
  }

  /** Returns the object with the settings used for calls to createIssueModel. */
  public UnaryCallSettings<CreateIssueModelRequest, Operation> createIssueModelSettings() {
    return createIssueModelSettings;
  }

  /** Returns the object with the settings used for calls to createIssueModel. */
  public OperationCallSettings<CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
      createIssueModelOperationSettings() {
    return createIssueModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateIssueModel. */
  public UnaryCallSettings<UpdateIssueModelRequest, IssueModel> updateIssueModelSettings() {
    return updateIssueModelSettings;
  }

  /** Returns the object with the settings used for calls to getIssueModel. */
  public UnaryCallSettings<GetIssueModelRequest, IssueModel> getIssueModelSettings() {
    return getIssueModelSettings;
  }

  /** Returns the object with the settings used for calls to listIssueModels. */
  public UnaryCallSettings<ListIssueModelsRequest, ListIssueModelsResponse>
      listIssueModelsSettings() {
    return listIssueModelsSettings;
  }

  /** Returns the object with the settings used for calls to deleteIssueModel. */
  public UnaryCallSettings<DeleteIssueModelRequest, Operation> deleteIssueModelSettings() {
    return deleteIssueModelSettings;
  }

  /** Returns the object with the settings used for calls to deleteIssueModel. */
  public OperationCallSettings<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
      deleteIssueModelOperationSettings() {
    return deleteIssueModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to deployIssueModel. */
  public UnaryCallSettings<DeployIssueModelRequest, Operation> deployIssueModelSettings() {
    return deployIssueModelSettings;
  }

  /** Returns the object with the settings used for calls to deployIssueModel. */
  public OperationCallSettings<
          DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelOperationSettings() {
    return deployIssueModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to undeployIssueModel. */
  public UnaryCallSettings<UndeployIssueModelRequest, Operation> undeployIssueModelSettings() {
    return undeployIssueModelSettings;
  }

  /** Returns the object with the settings used for calls to undeployIssueModel. */
  public OperationCallSettings<
          UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelOperationSettings() {
    return undeployIssueModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportIssueModel. */
  public UnaryCallSettings<ExportIssueModelRequest, Operation> exportIssueModelSettings() {
    return exportIssueModelSettings;
  }

  /** Returns the object with the settings used for calls to exportIssueModel. */
  public OperationCallSettings<
          ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelOperationSettings() {
    return exportIssueModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to importIssueModel. */
  public UnaryCallSettings<ImportIssueModelRequest, Operation> importIssueModelSettings() {
    return importIssueModelSettings;
  }

  /** Returns the object with the settings used for calls to importIssueModel. */
  public OperationCallSettings<
          ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelOperationSettings() {
    return importIssueModelOperationSettings;
  }

  /** Returns the object with the settings used for calls to getIssue. */
  public UnaryCallSettings<GetIssueRequest, Issue> getIssueSettings() {
    return getIssueSettings;
  }

  /** Returns the object with the settings used for calls to listIssues. */
  public UnaryCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesSettings() {
    return listIssuesSettings;
  }

  /** Returns the object with the settings used for calls to updateIssue. */
  public UnaryCallSettings<UpdateIssueRequest, Issue> updateIssueSettings() {
    return updateIssueSettings;
  }

  /** Returns the object with the settings used for calls to deleteIssue. */
  public UnaryCallSettings<DeleteIssueRequest, Empty> deleteIssueSettings() {
    return deleteIssueSettings;
  }

  /** Returns the object with the settings used for calls to calculateIssueModelStats. */
  public UnaryCallSettings<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsSettings() {
    return calculateIssueModelStatsSettings;
  }

  /** Returns the object with the settings used for calls to createPhraseMatcher. */
  public UnaryCallSettings<CreatePhraseMatcherRequest, PhraseMatcher>
      createPhraseMatcherSettings() {
    return createPhraseMatcherSettings;
  }

  /** Returns the object with the settings used for calls to getPhraseMatcher. */
  public UnaryCallSettings<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherSettings() {
    return getPhraseMatcherSettings;
  }

  /** Returns the object with the settings used for calls to listPhraseMatchers. */
  public PagedCallSettings<
          ListPhraseMatchersRequest, ListPhraseMatchersResponse, ListPhraseMatchersPagedResponse>
      listPhraseMatchersSettings() {
    return listPhraseMatchersSettings;
  }

  /** Returns the object with the settings used for calls to deletePhraseMatcher. */
  public UnaryCallSettings<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherSettings() {
    return deletePhraseMatcherSettings;
  }

  /** Returns the object with the settings used for calls to updatePhraseMatcher. */
  public UnaryCallSettings<UpdatePhraseMatcherRequest, PhraseMatcher>
      updatePhraseMatcherSettings() {
    return updatePhraseMatcherSettings;
  }

  /** Returns the object with the settings used for calls to calculateStats. */
  public UnaryCallSettings<CalculateStatsRequest, CalculateStatsResponse> calculateStatsSettings() {
    return calculateStatsSettings;
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return getSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Settings> updateSettingsSettings() {
    return updateSettingsSettings;
  }

  /** Returns the object with the settings used for calls to createAnalysisRule. */
  public UnaryCallSettings<CreateAnalysisRuleRequest, AnalysisRule> createAnalysisRuleSettings() {
    return createAnalysisRuleSettings;
  }

  /** Returns the object with the settings used for calls to getAnalysisRule. */
  public UnaryCallSettings<GetAnalysisRuleRequest, AnalysisRule> getAnalysisRuleSettings() {
    return getAnalysisRuleSettings;
  }

  /** Returns the object with the settings used for calls to listAnalysisRules. */
  public PagedCallSettings<
          ListAnalysisRulesRequest, ListAnalysisRulesResponse, ListAnalysisRulesPagedResponse>
      listAnalysisRulesSettings() {
    return listAnalysisRulesSettings;
  }

  /** Returns the object with the settings used for calls to updateAnalysisRule. */
  public UnaryCallSettings<UpdateAnalysisRuleRequest, AnalysisRule> updateAnalysisRuleSettings() {
    return updateAnalysisRuleSettings;
  }

  /** Returns the object with the settings used for calls to deleteAnalysisRule. */
  public UnaryCallSettings<DeleteAnalysisRuleRequest, Empty> deleteAnalysisRuleSettings() {
    return deleteAnalysisRuleSettings;
  }

  /** Returns the object with the settings used for calls to getEncryptionSpec. */
  public UnaryCallSettings<GetEncryptionSpecRequest, EncryptionSpec> getEncryptionSpecSettings() {
    return getEncryptionSpecSettings;
  }

  /** Returns the object with the settings used for calls to initializeEncryptionSpec. */
  public UnaryCallSettings<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecSettings() {
    return initializeEncryptionSpecSettings;
  }

  /** Returns the object with the settings used for calls to initializeEncryptionSpec. */
  public OperationCallSettings<
          InitializeEncryptionSpecRequest,
          InitializeEncryptionSpecResponse,
          InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecOperationSettings() {
    return initializeEncryptionSpecOperationSettings;
  }

  /** Returns the object with the settings used for calls to createView. */
  public UnaryCallSettings<CreateViewRequest, View> createViewSettings() {
    return createViewSettings;
  }

  /** Returns the object with the settings used for calls to getView. */
  public UnaryCallSettings<GetViewRequest, View> getViewSettings() {
    return getViewSettings;
  }

  /** Returns the object with the settings used for calls to listViews. */
  public PagedCallSettings<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      listViewsSettings() {
    return listViewsSettings;
  }

  /** Returns the object with the settings used for calls to updateView. */
  public UnaryCallSettings<UpdateViewRequest, View> updateViewSettings() {
    return updateViewSettings;
  }

  /** Returns the object with the settings used for calls to deleteView. */
  public UnaryCallSettings<DeleteViewRequest, Empty> deleteViewSettings() {
    return deleteViewSettings;
  }

  /** Returns the object with the settings used for calls to queryMetrics. */
  public UnaryCallSettings<QueryMetricsRequest, Operation> queryMetricsSettings() {
    return queryMetricsSettings;
  }

  /** Returns the object with the settings used for calls to queryMetrics. */
  public OperationCallSettings<QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
      queryMetricsOperationSettings() {
    return queryMetricsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createQaQuestion. */
  public UnaryCallSettings<CreateQaQuestionRequest, QaQuestion> createQaQuestionSettings() {
    return createQaQuestionSettings;
  }

  /** Returns the object with the settings used for calls to getQaQuestion. */
  public UnaryCallSettings<GetQaQuestionRequest, QaQuestion> getQaQuestionSettings() {
    return getQaQuestionSettings;
  }

  /** Returns the object with the settings used for calls to updateQaQuestion. */
  public UnaryCallSettings<UpdateQaQuestionRequest, QaQuestion> updateQaQuestionSettings() {
    return updateQaQuestionSettings;
  }

  /** Returns the object with the settings used for calls to deleteQaQuestion. */
  public UnaryCallSettings<DeleteQaQuestionRequest, Empty> deleteQaQuestionSettings() {
    return deleteQaQuestionSettings;
  }

  /** Returns the object with the settings used for calls to listQaQuestions. */
  public PagedCallSettings<
          ListQaQuestionsRequest, ListQaQuestionsResponse, ListQaQuestionsPagedResponse>
      listQaQuestionsSettings() {
    return listQaQuestionsSettings;
  }

  /** Returns the object with the settings used for calls to createQaScorecard. */
  public UnaryCallSettings<CreateQaScorecardRequest, QaScorecard> createQaScorecardSettings() {
    return createQaScorecardSettings;
  }

  /** Returns the object with the settings used for calls to getQaScorecard. */
  public UnaryCallSettings<GetQaScorecardRequest, QaScorecard> getQaScorecardSettings() {
    return getQaScorecardSettings;
  }

  /** Returns the object with the settings used for calls to updateQaScorecard. */
  public UnaryCallSettings<UpdateQaScorecardRequest, QaScorecard> updateQaScorecardSettings() {
    return updateQaScorecardSettings;
  }

  /** Returns the object with the settings used for calls to deleteQaScorecard. */
  public UnaryCallSettings<DeleteQaScorecardRequest, Empty> deleteQaScorecardSettings() {
    return deleteQaScorecardSettings;
  }

  /** Returns the object with the settings used for calls to listQaScorecards. */
  public PagedCallSettings<
          ListQaScorecardsRequest, ListQaScorecardsResponse, ListQaScorecardsPagedResponse>
      listQaScorecardsSettings() {
    return listQaScorecardsSettings;
  }

  /** Returns the object with the settings used for calls to createQaScorecardRevision. */
  public UnaryCallSettings<CreateQaScorecardRevisionRequest, QaScorecardRevision>
      createQaScorecardRevisionSettings() {
    return createQaScorecardRevisionSettings;
  }

  /** Returns the object with the settings used for calls to getQaScorecardRevision. */
  public UnaryCallSettings<GetQaScorecardRevisionRequest, QaScorecardRevision>
      getQaScorecardRevisionSettings() {
    return getQaScorecardRevisionSettings;
  }

  /** Returns the object with the settings used for calls to tuneQaScorecardRevision. */
  public UnaryCallSettings<TuneQaScorecardRevisionRequest, Operation>
      tuneQaScorecardRevisionSettings() {
    return tuneQaScorecardRevisionSettings;
  }

  /** Returns the object with the settings used for calls to tuneQaScorecardRevision. */
  public OperationCallSettings<
          TuneQaScorecardRevisionRequest,
          TuneQaScorecardRevisionResponse,
          TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionOperationSettings() {
    return tuneQaScorecardRevisionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deployQaScorecardRevision. */
  public UnaryCallSettings<DeployQaScorecardRevisionRequest, QaScorecardRevision>
      deployQaScorecardRevisionSettings() {
    return deployQaScorecardRevisionSettings;
  }

  /** Returns the object with the settings used for calls to undeployQaScorecardRevision. */
  public UnaryCallSettings<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
      undeployQaScorecardRevisionSettings() {
    return undeployQaScorecardRevisionSettings;
  }

  /** Returns the object with the settings used for calls to deleteQaScorecardRevision. */
  public UnaryCallSettings<DeleteQaScorecardRevisionRequest, Empty>
      deleteQaScorecardRevisionSettings() {
    return deleteQaScorecardRevisionSettings;
  }

  /** Returns the object with the settings used for calls to listQaScorecardRevisions. */
  public PagedCallSettings<
          ListQaScorecardRevisionsRequest,
          ListQaScorecardRevisionsResponse,
          ListQaScorecardRevisionsPagedResponse>
      listQaScorecardRevisionsSettings() {
    return listQaScorecardRevisionsSettings;
  }

  /** Returns the object with the settings used for calls to createFeedbackLabel. */
  public UnaryCallSettings<CreateFeedbackLabelRequest, FeedbackLabel>
      createFeedbackLabelSettings() {
    return createFeedbackLabelSettings;
  }

  /** Returns the object with the settings used for calls to listFeedbackLabels. */
  public PagedCallSettings<
          ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, ListFeedbackLabelsPagedResponse>
      listFeedbackLabelsSettings() {
    return listFeedbackLabelsSettings;
  }

  /** Returns the object with the settings used for calls to getFeedbackLabel. */
  public UnaryCallSettings<GetFeedbackLabelRequest, FeedbackLabel> getFeedbackLabelSettings() {
    return getFeedbackLabelSettings;
  }

  /** Returns the object with the settings used for calls to updateFeedbackLabel. */
  public UnaryCallSettings<UpdateFeedbackLabelRequest, FeedbackLabel>
      updateFeedbackLabelSettings() {
    return updateFeedbackLabelSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeedbackLabel. */
  public UnaryCallSettings<DeleteFeedbackLabelRequest, Empty> deleteFeedbackLabelSettings() {
    return deleteFeedbackLabelSettings;
  }

  /** Returns the object with the settings used for calls to listAllFeedbackLabels. */
  public PagedCallSettings<
          ListAllFeedbackLabelsRequest,
          ListAllFeedbackLabelsResponse,
          ListAllFeedbackLabelsPagedResponse>
      listAllFeedbackLabelsSettings() {
    return listAllFeedbackLabelsSettings;
  }

  /** Returns the object with the settings used for calls to bulkUploadFeedbackLabels. */
  public UnaryCallSettings<BulkUploadFeedbackLabelsRequest, Operation>
      bulkUploadFeedbackLabelsSettings() {
    return bulkUploadFeedbackLabelsSettings;
  }

  /** Returns the object with the settings used for calls to bulkUploadFeedbackLabels. */
  public OperationCallSettings<
          BulkUploadFeedbackLabelsRequest,
          BulkUploadFeedbackLabelsResponse,
          BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsOperationSettings() {
    return bulkUploadFeedbackLabelsOperationSettings;
  }

  /** Returns the object with the settings used for calls to bulkDownloadFeedbackLabels. */
  public UnaryCallSettings<BulkDownloadFeedbackLabelsRequest, Operation>
      bulkDownloadFeedbackLabelsSettings() {
    return bulkDownloadFeedbackLabelsSettings;
  }

  /** Returns the object with the settings used for calls to bulkDownloadFeedbackLabels. */
  public OperationCallSettings<
          BulkDownloadFeedbackLabelsRequest,
          BulkDownloadFeedbackLabelsResponse,
          BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsOperationSettings() {
    return bulkDownloadFeedbackLabelsOperationSettings;
  }

  public ContactCenterInsightsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcContactCenterInsightsStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonContactCenterInsightsStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "contactcenterinsights";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "contactcenterinsights.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "contactcenterinsights.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ContactCenterInsightsStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ContactCenterInsightsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ContactCenterInsightsStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ContactCenterInsightsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createConversationSettings = settingsBuilder.createConversationSettings().build();
    uploadConversationSettings = settingsBuilder.uploadConversationSettings().build();
    uploadConversationOperationSettings =
        settingsBuilder.uploadConversationOperationSettings().build();
    updateConversationSettings = settingsBuilder.updateConversationSettings().build();
    getConversationSettings = settingsBuilder.getConversationSettings().build();
    listConversationsSettings = settingsBuilder.listConversationsSettings().build();
    deleteConversationSettings = settingsBuilder.deleteConversationSettings().build();
    createAnalysisSettings = settingsBuilder.createAnalysisSettings().build();
    createAnalysisOperationSettings = settingsBuilder.createAnalysisOperationSettings().build();
    getAnalysisSettings = settingsBuilder.getAnalysisSettings().build();
    listAnalysesSettings = settingsBuilder.listAnalysesSettings().build();
    deleteAnalysisSettings = settingsBuilder.deleteAnalysisSettings().build();
    bulkAnalyzeConversationsSettings = settingsBuilder.bulkAnalyzeConversationsSettings().build();
    bulkAnalyzeConversationsOperationSettings =
        settingsBuilder.bulkAnalyzeConversationsOperationSettings().build();
    bulkDeleteConversationsSettings = settingsBuilder.bulkDeleteConversationsSettings().build();
    bulkDeleteConversationsOperationSettings =
        settingsBuilder.bulkDeleteConversationsOperationSettings().build();
    ingestConversationsSettings = settingsBuilder.ingestConversationsSettings().build();
    ingestConversationsOperationSettings =
        settingsBuilder.ingestConversationsOperationSettings().build();
    exportInsightsDataSettings = settingsBuilder.exportInsightsDataSettings().build();
    exportInsightsDataOperationSettings =
        settingsBuilder.exportInsightsDataOperationSettings().build();
    createIssueModelSettings = settingsBuilder.createIssueModelSettings().build();
    createIssueModelOperationSettings = settingsBuilder.createIssueModelOperationSettings().build();
    updateIssueModelSettings = settingsBuilder.updateIssueModelSettings().build();
    getIssueModelSettings = settingsBuilder.getIssueModelSettings().build();
    listIssueModelsSettings = settingsBuilder.listIssueModelsSettings().build();
    deleteIssueModelSettings = settingsBuilder.deleteIssueModelSettings().build();
    deleteIssueModelOperationSettings = settingsBuilder.deleteIssueModelOperationSettings().build();
    deployIssueModelSettings = settingsBuilder.deployIssueModelSettings().build();
    deployIssueModelOperationSettings = settingsBuilder.deployIssueModelOperationSettings().build();
    undeployIssueModelSettings = settingsBuilder.undeployIssueModelSettings().build();
    undeployIssueModelOperationSettings =
        settingsBuilder.undeployIssueModelOperationSettings().build();
    exportIssueModelSettings = settingsBuilder.exportIssueModelSettings().build();
    exportIssueModelOperationSettings = settingsBuilder.exportIssueModelOperationSettings().build();
    importIssueModelSettings = settingsBuilder.importIssueModelSettings().build();
    importIssueModelOperationSettings = settingsBuilder.importIssueModelOperationSettings().build();
    getIssueSettings = settingsBuilder.getIssueSettings().build();
    listIssuesSettings = settingsBuilder.listIssuesSettings().build();
    updateIssueSettings = settingsBuilder.updateIssueSettings().build();
    deleteIssueSettings = settingsBuilder.deleteIssueSettings().build();
    calculateIssueModelStatsSettings = settingsBuilder.calculateIssueModelStatsSettings().build();
    createPhraseMatcherSettings = settingsBuilder.createPhraseMatcherSettings().build();
    getPhraseMatcherSettings = settingsBuilder.getPhraseMatcherSettings().build();
    listPhraseMatchersSettings = settingsBuilder.listPhraseMatchersSettings().build();
    deletePhraseMatcherSettings = settingsBuilder.deletePhraseMatcherSettings().build();
    updatePhraseMatcherSettings = settingsBuilder.updatePhraseMatcherSettings().build();
    calculateStatsSettings = settingsBuilder.calculateStatsSettings().build();
    getSettingsSettings = settingsBuilder.getSettingsSettings().build();
    updateSettingsSettings = settingsBuilder.updateSettingsSettings().build();
    createAnalysisRuleSettings = settingsBuilder.createAnalysisRuleSettings().build();
    getAnalysisRuleSettings = settingsBuilder.getAnalysisRuleSettings().build();
    listAnalysisRulesSettings = settingsBuilder.listAnalysisRulesSettings().build();
    updateAnalysisRuleSettings = settingsBuilder.updateAnalysisRuleSettings().build();
    deleteAnalysisRuleSettings = settingsBuilder.deleteAnalysisRuleSettings().build();
    getEncryptionSpecSettings = settingsBuilder.getEncryptionSpecSettings().build();
    initializeEncryptionSpecSettings = settingsBuilder.initializeEncryptionSpecSettings().build();
    initializeEncryptionSpecOperationSettings =
        settingsBuilder.initializeEncryptionSpecOperationSettings().build();
    createViewSettings = settingsBuilder.createViewSettings().build();
    getViewSettings = settingsBuilder.getViewSettings().build();
    listViewsSettings = settingsBuilder.listViewsSettings().build();
    updateViewSettings = settingsBuilder.updateViewSettings().build();
    deleteViewSettings = settingsBuilder.deleteViewSettings().build();
    queryMetricsSettings = settingsBuilder.queryMetricsSettings().build();
    queryMetricsOperationSettings = settingsBuilder.queryMetricsOperationSettings().build();
    createQaQuestionSettings = settingsBuilder.createQaQuestionSettings().build();
    getQaQuestionSettings = settingsBuilder.getQaQuestionSettings().build();
    updateQaQuestionSettings = settingsBuilder.updateQaQuestionSettings().build();
    deleteQaQuestionSettings = settingsBuilder.deleteQaQuestionSettings().build();
    listQaQuestionsSettings = settingsBuilder.listQaQuestionsSettings().build();
    createQaScorecardSettings = settingsBuilder.createQaScorecardSettings().build();
    getQaScorecardSettings = settingsBuilder.getQaScorecardSettings().build();
    updateQaScorecardSettings = settingsBuilder.updateQaScorecardSettings().build();
    deleteQaScorecardSettings = settingsBuilder.deleteQaScorecardSettings().build();
    listQaScorecardsSettings = settingsBuilder.listQaScorecardsSettings().build();
    createQaScorecardRevisionSettings = settingsBuilder.createQaScorecardRevisionSettings().build();
    getQaScorecardRevisionSettings = settingsBuilder.getQaScorecardRevisionSettings().build();
    tuneQaScorecardRevisionSettings = settingsBuilder.tuneQaScorecardRevisionSettings().build();
    tuneQaScorecardRevisionOperationSettings =
        settingsBuilder.tuneQaScorecardRevisionOperationSettings().build();
    deployQaScorecardRevisionSettings = settingsBuilder.deployQaScorecardRevisionSettings().build();
    undeployQaScorecardRevisionSettings =
        settingsBuilder.undeployQaScorecardRevisionSettings().build();
    deleteQaScorecardRevisionSettings = settingsBuilder.deleteQaScorecardRevisionSettings().build();
    listQaScorecardRevisionsSettings = settingsBuilder.listQaScorecardRevisionsSettings().build();
    createFeedbackLabelSettings = settingsBuilder.createFeedbackLabelSettings().build();
    listFeedbackLabelsSettings = settingsBuilder.listFeedbackLabelsSettings().build();
    getFeedbackLabelSettings = settingsBuilder.getFeedbackLabelSettings().build();
    updateFeedbackLabelSettings = settingsBuilder.updateFeedbackLabelSettings().build();
    deleteFeedbackLabelSettings = settingsBuilder.deleteFeedbackLabelSettings().build();
    listAllFeedbackLabelsSettings = settingsBuilder.listAllFeedbackLabelsSettings().build();
    bulkUploadFeedbackLabelsSettings = settingsBuilder.bulkUploadFeedbackLabelsSettings().build();
    bulkUploadFeedbackLabelsOperationSettings =
        settingsBuilder.bulkUploadFeedbackLabelsOperationSettings().build();
    bulkDownloadFeedbackLabelsSettings =
        settingsBuilder.bulkDownloadFeedbackLabelsSettings().build();
    bulkDownloadFeedbackLabelsOperationSettings =
        settingsBuilder.bulkDownloadFeedbackLabelsOperationSettings().build();
  }

  /** Builder for ContactCenterInsightsStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ContactCenterInsightsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings;
    private final UnaryCallSettings.Builder<UploadConversationRequest, Operation>
        uploadConversationSettings;
    private final OperationCallSettings.Builder<
            UploadConversationRequest, Conversation, UploadConversationMetadata>
        uploadConversationOperationSettings;
    private final UnaryCallSettings.Builder<UpdateConversationRequest, Conversation>
        updateConversationSettings;
    private final UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings;
    private final PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings;
    private final UnaryCallSettings.Builder<DeleteConversationRequest, Empty>
        deleteConversationSettings;
    private final UnaryCallSettings.Builder<CreateAnalysisRequest, Operation>
        createAnalysisSettings;
    private final OperationCallSettings.Builder<
            CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
        createAnalysisOperationSettings;
    private final UnaryCallSettings.Builder<GetAnalysisRequest, Analysis> getAnalysisSettings;
    private final PagedCallSettings.Builder<
            ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
        listAnalysesSettings;
    private final UnaryCallSettings.Builder<DeleteAnalysisRequest, Empty> deleteAnalysisSettings;
    private final UnaryCallSettings.Builder<BulkAnalyzeConversationsRequest, Operation>
        bulkAnalyzeConversationsSettings;
    private final OperationCallSettings.Builder<
            BulkAnalyzeConversationsRequest,
            BulkAnalyzeConversationsResponse,
            BulkAnalyzeConversationsMetadata>
        bulkAnalyzeConversationsOperationSettings;
    private final UnaryCallSettings.Builder<BulkDeleteConversationsRequest, Operation>
        bulkDeleteConversationsSettings;
    private final OperationCallSettings.Builder<
            BulkDeleteConversationsRequest,
            BulkDeleteConversationsResponse,
            BulkDeleteConversationsMetadata>
        bulkDeleteConversationsOperationSettings;
    private final UnaryCallSettings.Builder<IngestConversationsRequest, Operation>
        ingestConversationsSettings;
    private final OperationCallSettings.Builder<
            IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
        ingestConversationsOperationSettings;
    private final UnaryCallSettings.Builder<ExportInsightsDataRequest, Operation>
        exportInsightsDataSettings;
    private final OperationCallSettings.Builder<
            ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
        exportInsightsDataOperationSettings;
    private final UnaryCallSettings.Builder<CreateIssueModelRequest, Operation>
        createIssueModelSettings;
    private final OperationCallSettings.Builder<
            CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
        createIssueModelOperationSettings;
    private final UnaryCallSettings.Builder<UpdateIssueModelRequest, IssueModel>
        updateIssueModelSettings;
    private final UnaryCallSettings.Builder<GetIssueModelRequest, IssueModel> getIssueModelSettings;
    private final UnaryCallSettings.Builder<ListIssueModelsRequest, ListIssueModelsResponse>
        listIssueModelsSettings;
    private final UnaryCallSettings.Builder<DeleteIssueModelRequest, Operation>
        deleteIssueModelSettings;
    private final OperationCallSettings.Builder<
            DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
        deleteIssueModelOperationSettings;
    private final UnaryCallSettings.Builder<DeployIssueModelRequest, Operation>
        deployIssueModelSettings;
    private final OperationCallSettings.Builder<
            DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
        deployIssueModelOperationSettings;
    private final UnaryCallSettings.Builder<UndeployIssueModelRequest, Operation>
        undeployIssueModelSettings;
    private final OperationCallSettings.Builder<
            UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
        undeployIssueModelOperationSettings;
    private final UnaryCallSettings.Builder<ExportIssueModelRequest, Operation>
        exportIssueModelSettings;
    private final OperationCallSettings.Builder<
            ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
        exportIssueModelOperationSettings;
    private final UnaryCallSettings.Builder<ImportIssueModelRequest, Operation>
        importIssueModelSettings;
    private final OperationCallSettings.Builder<
            ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
        importIssueModelOperationSettings;
    private final UnaryCallSettings.Builder<GetIssueRequest, Issue> getIssueSettings;
    private final UnaryCallSettings.Builder<ListIssuesRequest, ListIssuesResponse>
        listIssuesSettings;
    private final UnaryCallSettings.Builder<UpdateIssueRequest, Issue> updateIssueSettings;
    private final UnaryCallSettings.Builder<DeleteIssueRequest, Empty> deleteIssueSettings;
    private final UnaryCallSettings.Builder<
            CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
        calculateIssueModelStatsSettings;
    private final UnaryCallSettings.Builder<CreatePhraseMatcherRequest, PhraseMatcher>
        createPhraseMatcherSettings;
    private final UnaryCallSettings.Builder<GetPhraseMatcherRequest, PhraseMatcher>
        getPhraseMatcherSettings;
    private final PagedCallSettings.Builder<
            ListPhraseMatchersRequest, ListPhraseMatchersResponse, ListPhraseMatchersPagedResponse>
        listPhraseMatchersSettings;
    private final UnaryCallSettings.Builder<DeletePhraseMatcherRequest, Empty>
        deletePhraseMatcherSettings;
    private final UnaryCallSettings.Builder<UpdatePhraseMatcherRequest, PhraseMatcher>
        updatePhraseMatcherSettings;
    private final UnaryCallSettings.Builder<CalculateStatsRequest, CalculateStatsResponse>
        calculateStatsSettings;
    private final UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings;
    private final UnaryCallSettings.Builder<CreateAnalysisRuleRequest, AnalysisRule>
        createAnalysisRuleSettings;
    private final UnaryCallSettings.Builder<GetAnalysisRuleRequest, AnalysisRule>
        getAnalysisRuleSettings;
    private final PagedCallSettings.Builder<
            ListAnalysisRulesRequest, ListAnalysisRulesResponse, ListAnalysisRulesPagedResponse>
        listAnalysisRulesSettings;
    private final UnaryCallSettings.Builder<UpdateAnalysisRuleRequest, AnalysisRule>
        updateAnalysisRuleSettings;
    private final UnaryCallSettings.Builder<DeleteAnalysisRuleRequest, Empty>
        deleteAnalysisRuleSettings;
    private final UnaryCallSettings.Builder<GetEncryptionSpecRequest, EncryptionSpec>
        getEncryptionSpecSettings;
    private final UnaryCallSettings.Builder<InitializeEncryptionSpecRequest, Operation>
        initializeEncryptionSpecSettings;
    private final OperationCallSettings.Builder<
            InitializeEncryptionSpecRequest,
            InitializeEncryptionSpecResponse,
            InitializeEncryptionSpecMetadata>
        initializeEncryptionSpecOperationSettings;
    private final UnaryCallSettings.Builder<CreateViewRequest, View> createViewSettings;
    private final UnaryCallSettings.Builder<GetViewRequest, View> getViewSettings;
    private final PagedCallSettings.Builder<
            ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
        listViewsSettings;
    private final UnaryCallSettings.Builder<UpdateViewRequest, View> updateViewSettings;
    private final UnaryCallSettings.Builder<DeleteViewRequest, Empty> deleteViewSettings;
    private final UnaryCallSettings.Builder<QueryMetricsRequest, Operation> queryMetricsSettings;
    private final OperationCallSettings.Builder<
            QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
        queryMetricsOperationSettings;
    private final UnaryCallSettings.Builder<CreateQaQuestionRequest, QaQuestion>
        createQaQuestionSettings;
    private final UnaryCallSettings.Builder<GetQaQuestionRequest, QaQuestion> getQaQuestionSettings;
    private final UnaryCallSettings.Builder<UpdateQaQuestionRequest, QaQuestion>
        updateQaQuestionSettings;
    private final UnaryCallSettings.Builder<DeleteQaQuestionRequest, Empty>
        deleteQaQuestionSettings;
    private final PagedCallSettings.Builder<
            ListQaQuestionsRequest, ListQaQuestionsResponse, ListQaQuestionsPagedResponse>
        listQaQuestionsSettings;
    private final UnaryCallSettings.Builder<CreateQaScorecardRequest, QaScorecard>
        createQaScorecardSettings;
    private final UnaryCallSettings.Builder<GetQaScorecardRequest, QaScorecard>
        getQaScorecardSettings;
    private final UnaryCallSettings.Builder<UpdateQaScorecardRequest, QaScorecard>
        updateQaScorecardSettings;
    private final UnaryCallSettings.Builder<DeleteQaScorecardRequest, Empty>
        deleteQaScorecardSettings;
    private final PagedCallSettings.Builder<
            ListQaScorecardsRequest, ListQaScorecardsResponse, ListQaScorecardsPagedResponse>
        listQaScorecardsSettings;
    private final UnaryCallSettings.Builder<CreateQaScorecardRevisionRequest, QaScorecardRevision>
        createQaScorecardRevisionSettings;
    private final UnaryCallSettings.Builder<GetQaScorecardRevisionRequest, QaScorecardRevision>
        getQaScorecardRevisionSettings;
    private final UnaryCallSettings.Builder<TuneQaScorecardRevisionRequest, Operation>
        tuneQaScorecardRevisionSettings;
    private final OperationCallSettings.Builder<
            TuneQaScorecardRevisionRequest,
            TuneQaScorecardRevisionResponse,
            TuneQaScorecardRevisionMetadata>
        tuneQaScorecardRevisionOperationSettings;
    private final UnaryCallSettings.Builder<DeployQaScorecardRevisionRequest, QaScorecardRevision>
        deployQaScorecardRevisionSettings;
    private final UnaryCallSettings.Builder<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
        undeployQaScorecardRevisionSettings;
    private final UnaryCallSettings.Builder<DeleteQaScorecardRevisionRequest, Empty>
        deleteQaScorecardRevisionSettings;
    private final PagedCallSettings.Builder<
            ListQaScorecardRevisionsRequest,
            ListQaScorecardRevisionsResponse,
            ListQaScorecardRevisionsPagedResponse>
        listQaScorecardRevisionsSettings;
    private final UnaryCallSettings.Builder<CreateFeedbackLabelRequest, FeedbackLabel>
        createFeedbackLabelSettings;
    private final PagedCallSettings.Builder<
            ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, ListFeedbackLabelsPagedResponse>
        listFeedbackLabelsSettings;
    private final UnaryCallSettings.Builder<GetFeedbackLabelRequest, FeedbackLabel>
        getFeedbackLabelSettings;
    private final UnaryCallSettings.Builder<UpdateFeedbackLabelRequest, FeedbackLabel>
        updateFeedbackLabelSettings;
    private final UnaryCallSettings.Builder<DeleteFeedbackLabelRequest, Empty>
        deleteFeedbackLabelSettings;
    private final PagedCallSettings.Builder<
            ListAllFeedbackLabelsRequest,
            ListAllFeedbackLabelsResponse,
            ListAllFeedbackLabelsPagedResponse>
        listAllFeedbackLabelsSettings;
    private final UnaryCallSettings.Builder<BulkUploadFeedbackLabelsRequest, Operation>
        bulkUploadFeedbackLabelsSettings;
    private final OperationCallSettings.Builder<
            BulkUploadFeedbackLabelsRequest,
            BulkUploadFeedbackLabelsResponse,
            BulkUploadFeedbackLabelsMetadata>
        bulkUploadFeedbackLabelsOperationSettings;
    private final UnaryCallSettings.Builder<BulkDownloadFeedbackLabelsRequest, Operation>
        bulkDownloadFeedbackLabelsSettings;
    private final OperationCallSettings.Builder<
            BulkDownloadFeedbackLabelsRequest,
            BulkDownloadFeedbackLabelsResponse,
            BulkDownloadFeedbackLabelsMetadata>
        bulkDownloadFeedbackLabelsOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      uploadConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      uploadConversationOperationSettings = OperationCallSettings.newBuilder();
      updateConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversationsSettings = PagedCallSettings.newBuilder(LIST_CONVERSATIONS_PAGE_STR_FACT);
      deleteConversationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAnalysisSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAnalysisOperationSettings = OperationCallSettings.newBuilder();
      getAnalysisSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnalysesSettings = PagedCallSettings.newBuilder(LIST_ANALYSES_PAGE_STR_FACT);
      deleteAnalysisSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkAnalyzeConversationsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkAnalyzeConversationsOperationSettings = OperationCallSettings.newBuilder();
      bulkDeleteConversationsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkDeleteConversationsOperationSettings = OperationCallSettings.newBuilder();
      ingestConversationsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      ingestConversationsOperationSettings = OperationCallSettings.newBuilder();
      exportInsightsDataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportInsightsDataOperationSettings = OperationCallSettings.newBuilder();
      createIssueModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createIssueModelOperationSettings = OperationCallSettings.newBuilder();
      updateIssueModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIssueModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listIssueModelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIssueModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIssueModelOperationSettings = OperationCallSettings.newBuilder();
      deployIssueModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deployIssueModelOperationSettings = OperationCallSettings.newBuilder();
      undeployIssueModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeployIssueModelOperationSettings = OperationCallSettings.newBuilder();
      exportIssueModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportIssueModelOperationSettings = OperationCallSettings.newBuilder();
      importIssueModelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importIssueModelOperationSettings = OperationCallSettings.newBuilder();
      getIssueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listIssuesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateIssueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteIssueSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      calculateIssueModelStatsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPhraseMatcherSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPhraseMatcherSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPhraseMatchersSettings = PagedCallSettings.newBuilder(LIST_PHRASE_MATCHERS_PAGE_STR_FACT);
      deletePhraseMatcherSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePhraseMatcherSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      calculateStatsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAnalysisRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAnalysisRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAnalysisRulesSettings = PagedCallSettings.newBuilder(LIST_ANALYSIS_RULES_PAGE_STR_FACT);
      updateAnalysisRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAnalysisRuleSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEncryptionSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      initializeEncryptionSpecSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      initializeEncryptionSpecOperationSettings = OperationCallSettings.newBuilder();
      createViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listViewsSettings = PagedCallSettings.newBuilder(LIST_VIEWS_PAGE_STR_FACT);
      updateViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryMetricsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      queryMetricsOperationSettings = OperationCallSettings.newBuilder();
      createQaQuestionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getQaQuestionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateQaQuestionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteQaQuestionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listQaQuestionsSettings = PagedCallSettings.newBuilder(LIST_QA_QUESTIONS_PAGE_STR_FACT);
      createQaScorecardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getQaScorecardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateQaScorecardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteQaScorecardSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listQaScorecardsSettings = PagedCallSettings.newBuilder(LIST_QA_SCORECARDS_PAGE_STR_FACT);
      createQaScorecardRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getQaScorecardRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      tuneQaScorecardRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      tuneQaScorecardRevisionOperationSettings = OperationCallSettings.newBuilder();
      deployQaScorecardRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeployQaScorecardRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteQaScorecardRevisionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listQaScorecardRevisionsSettings =
          PagedCallSettings.newBuilder(LIST_QA_SCORECARD_REVISIONS_PAGE_STR_FACT);
      createFeedbackLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeedbackLabelsSettings = PagedCallSettings.newBuilder(LIST_FEEDBACK_LABELS_PAGE_STR_FACT);
      getFeedbackLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeedbackLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeedbackLabelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAllFeedbackLabelsSettings =
          PagedCallSettings.newBuilder(LIST_ALL_FEEDBACK_LABELS_PAGE_STR_FACT);
      bulkUploadFeedbackLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkUploadFeedbackLabelsOperationSettings = OperationCallSettings.newBuilder();
      bulkDownloadFeedbackLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkDownloadFeedbackLabelsOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversationSettings,
              uploadConversationSettings,
              updateConversationSettings,
              getConversationSettings,
              listConversationsSettings,
              deleteConversationSettings,
              createAnalysisSettings,
              getAnalysisSettings,
              listAnalysesSettings,
              deleteAnalysisSettings,
              bulkAnalyzeConversationsSettings,
              bulkDeleteConversationsSettings,
              ingestConversationsSettings,
              exportInsightsDataSettings,
              createIssueModelSettings,
              updateIssueModelSettings,
              getIssueModelSettings,
              listIssueModelsSettings,
              deleteIssueModelSettings,
              deployIssueModelSettings,
              undeployIssueModelSettings,
              exportIssueModelSettings,
              importIssueModelSettings,
              getIssueSettings,
              listIssuesSettings,
              updateIssueSettings,
              deleteIssueSettings,
              calculateIssueModelStatsSettings,
              createPhraseMatcherSettings,
              getPhraseMatcherSettings,
              listPhraseMatchersSettings,
              deletePhraseMatcherSettings,
              updatePhraseMatcherSettings,
              calculateStatsSettings,
              getSettingsSettings,
              updateSettingsSettings,
              createAnalysisRuleSettings,
              getAnalysisRuleSettings,
              listAnalysisRulesSettings,
              updateAnalysisRuleSettings,
              deleteAnalysisRuleSettings,
              getEncryptionSpecSettings,
              initializeEncryptionSpecSettings,
              createViewSettings,
              getViewSettings,
              listViewsSettings,
              updateViewSettings,
              deleteViewSettings,
              queryMetricsSettings,
              createQaQuestionSettings,
              getQaQuestionSettings,
              updateQaQuestionSettings,
              deleteQaQuestionSettings,
              listQaQuestionsSettings,
              createQaScorecardSettings,
              getQaScorecardSettings,
              updateQaScorecardSettings,
              deleteQaScorecardSettings,
              listQaScorecardsSettings,
              createQaScorecardRevisionSettings,
              getQaScorecardRevisionSettings,
              tuneQaScorecardRevisionSettings,
              deployQaScorecardRevisionSettings,
              undeployQaScorecardRevisionSettings,
              deleteQaScorecardRevisionSettings,
              listQaScorecardRevisionsSettings,
              createFeedbackLabelSettings,
              listFeedbackLabelsSettings,
              getFeedbackLabelSettings,
              updateFeedbackLabelSettings,
              deleteFeedbackLabelSettings,
              listAllFeedbackLabelsSettings,
              bulkUploadFeedbackLabelsSettings,
              bulkDownloadFeedbackLabelsSettings);
      initDefaults(this);
    }

    protected Builder(ContactCenterInsightsStubSettings settings) {
      super(settings);

      createConversationSettings = settings.createConversationSettings.toBuilder();
      uploadConversationSettings = settings.uploadConversationSettings.toBuilder();
      uploadConversationOperationSettings =
          settings.uploadConversationOperationSettings.toBuilder();
      updateConversationSettings = settings.updateConversationSettings.toBuilder();
      getConversationSettings = settings.getConversationSettings.toBuilder();
      listConversationsSettings = settings.listConversationsSettings.toBuilder();
      deleteConversationSettings = settings.deleteConversationSettings.toBuilder();
      createAnalysisSettings = settings.createAnalysisSettings.toBuilder();
      createAnalysisOperationSettings = settings.createAnalysisOperationSettings.toBuilder();
      getAnalysisSettings = settings.getAnalysisSettings.toBuilder();
      listAnalysesSettings = settings.listAnalysesSettings.toBuilder();
      deleteAnalysisSettings = settings.deleteAnalysisSettings.toBuilder();
      bulkAnalyzeConversationsSettings = settings.bulkAnalyzeConversationsSettings.toBuilder();
      bulkAnalyzeConversationsOperationSettings =
          settings.bulkAnalyzeConversationsOperationSettings.toBuilder();
      bulkDeleteConversationsSettings = settings.bulkDeleteConversationsSettings.toBuilder();
      bulkDeleteConversationsOperationSettings =
          settings.bulkDeleteConversationsOperationSettings.toBuilder();
      ingestConversationsSettings = settings.ingestConversationsSettings.toBuilder();
      ingestConversationsOperationSettings =
          settings.ingestConversationsOperationSettings.toBuilder();
      exportInsightsDataSettings = settings.exportInsightsDataSettings.toBuilder();
      exportInsightsDataOperationSettings =
          settings.exportInsightsDataOperationSettings.toBuilder();
      createIssueModelSettings = settings.createIssueModelSettings.toBuilder();
      createIssueModelOperationSettings = settings.createIssueModelOperationSettings.toBuilder();
      updateIssueModelSettings = settings.updateIssueModelSettings.toBuilder();
      getIssueModelSettings = settings.getIssueModelSettings.toBuilder();
      listIssueModelsSettings = settings.listIssueModelsSettings.toBuilder();
      deleteIssueModelSettings = settings.deleteIssueModelSettings.toBuilder();
      deleteIssueModelOperationSettings = settings.deleteIssueModelOperationSettings.toBuilder();
      deployIssueModelSettings = settings.deployIssueModelSettings.toBuilder();
      deployIssueModelOperationSettings = settings.deployIssueModelOperationSettings.toBuilder();
      undeployIssueModelSettings = settings.undeployIssueModelSettings.toBuilder();
      undeployIssueModelOperationSettings =
          settings.undeployIssueModelOperationSettings.toBuilder();
      exportIssueModelSettings = settings.exportIssueModelSettings.toBuilder();
      exportIssueModelOperationSettings = settings.exportIssueModelOperationSettings.toBuilder();
      importIssueModelSettings = settings.importIssueModelSettings.toBuilder();
      importIssueModelOperationSettings = settings.importIssueModelOperationSettings.toBuilder();
      getIssueSettings = settings.getIssueSettings.toBuilder();
      listIssuesSettings = settings.listIssuesSettings.toBuilder();
      updateIssueSettings = settings.updateIssueSettings.toBuilder();
      deleteIssueSettings = settings.deleteIssueSettings.toBuilder();
      calculateIssueModelStatsSettings = settings.calculateIssueModelStatsSettings.toBuilder();
      createPhraseMatcherSettings = settings.createPhraseMatcherSettings.toBuilder();
      getPhraseMatcherSettings = settings.getPhraseMatcherSettings.toBuilder();
      listPhraseMatchersSettings = settings.listPhraseMatchersSettings.toBuilder();
      deletePhraseMatcherSettings = settings.deletePhraseMatcherSettings.toBuilder();
      updatePhraseMatcherSettings = settings.updatePhraseMatcherSettings.toBuilder();
      calculateStatsSettings = settings.calculateStatsSettings.toBuilder();
      getSettingsSettings = settings.getSettingsSettings.toBuilder();
      updateSettingsSettings = settings.updateSettingsSettings.toBuilder();
      createAnalysisRuleSettings = settings.createAnalysisRuleSettings.toBuilder();
      getAnalysisRuleSettings = settings.getAnalysisRuleSettings.toBuilder();
      listAnalysisRulesSettings = settings.listAnalysisRulesSettings.toBuilder();
      updateAnalysisRuleSettings = settings.updateAnalysisRuleSettings.toBuilder();
      deleteAnalysisRuleSettings = settings.deleteAnalysisRuleSettings.toBuilder();
      getEncryptionSpecSettings = settings.getEncryptionSpecSettings.toBuilder();
      initializeEncryptionSpecSettings = settings.initializeEncryptionSpecSettings.toBuilder();
      initializeEncryptionSpecOperationSettings =
          settings.initializeEncryptionSpecOperationSettings.toBuilder();
      createViewSettings = settings.createViewSettings.toBuilder();
      getViewSettings = settings.getViewSettings.toBuilder();
      listViewsSettings = settings.listViewsSettings.toBuilder();
      updateViewSettings = settings.updateViewSettings.toBuilder();
      deleteViewSettings = settings.deleteViewSettings.toBuilder();
      queryMetricsSettings = settings.queryMetricsSettings.toBuilder();
      queryMetricsOperationSettings = settings.queryMetricsOperationSettings.toBuilder();
      createQaQuestionSettings = settings.createQaQuestionSettings.toBuilder();
      getQaQuestionSettings = settings.getQaQuestionSettings.toBuilder();
      updateQaQuestionSettings = settings.updateQaQuestionSettings.toBuilder();
      deleteQaQuestionSettings = settings.deleteQaQuestionSettings.toBuilder();
      listQaQuestionsSettings = settings.listQaQuestionsSettings.toBuilder();
      createQaScorecardSettings = settings.createQaScorecardSettings.toBuilder();
      getQaScorecardSettings = settings.getQaScorecardSettings.toBuilder();
      updateQaScorecardSettings = settings.updateQaScorecardSettings.toBuilder();
      deleteQaScorecardSettings = settings.deleteQaScorecardSettings.toBuilder();
      listQaScorecardsSettings = settings.listQaScorecardsSettings.toBuilder();
      createQaScorecardRevisionSettings = settings.createQaScorecardRevisionSettings.toBuilder();
      getQaScorecardRevisionSettings = settings.getQaScorecardRevisionSettings.toBuilder();
      tuneQaScorecardRevisionSettings = settings.tuneQaScorecardRevisionSettings.toBuilder();
      tuneQaScorecardRevisionOperationSettings =
          settings.tuneQaScorecardRevisionOperationSettings.toBuilder();
      deployQaScorecardRevisionSettings = settings.deployQaScorecardRevisionSettings.toBuilder();
      undeployQaScorecardRevisionSettings =
          settings.undeployQaScorecardRevisionSettings.toBuilder();
      deleteQaScorecardRevisionSettings = settings.deleteQaScorecardRevisionSettings.toBuilder();
      listQaScorecardRevisionsSettings = settings.listQaScorecardRevisionsSettings.toBuilder();
      createFeedbackLabelSettings = settings.createFeedbackLabelSettings.toBuilder();
      listFeedbackLabelsSettings = settings.listFeedbackLabelsSettings.toBuilder();
      getFeedbackLabelSettings = settings.getFeedbackLabelSettings.toBuilder();
      updateFeedbackLabelSettings = settings.updateFeedbackLabelSettings.toBuilder();
      deleteFeedbackLabelSettings = settings.deleteFeedbackLabelSettings.toBuilder();
      listAllFeedbackLabelsSettings = settings.listAllFeedbackLabelsSettings.toBuilder();
      bulkUploadFeedbackLabelsSettings = settings.bulkUploadFeedbackLabelsSettings.toBuilder();
      bulkUploadFeedbackLabelsOperationSettings =
          settings.bulkUploadFeedbackLabelsOperationSettings.toBuilder();
      bulkDownloadFeedbackLabelsSettings = settings.bulkDownloadFeedbackLabelsSettings.toBuilder();
      bulkDownloadFeedbackLabelsOperationSettings =
          settings.bulkDownloadFeedbackLabelsOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversationSettings,
              uploadConversationSettings,
              updateConversationSettings,
              getConversationSettings,
              listConversationsSettings,
              deleteConversationSettings,
              createAnalysisSettings,
              getAnalysisSettings,
              listAnalysesSettings,
              deleteAnalysisSettings,
              bulkAnalyzeConversationsSettings,
              bulkDeleteConversationsSettings,
              ingestConversationsSettings,
              exportInsightsDataSettings,
              createIssueModelSettings,
              updateIssueModelSettings,
              getIssueModelSettings,
              listIssueModelsSettings,
              deleteIssueModelSettings,
              deployIssueModelSettings,
              undeployIssueModelSettings,
              exportIssueModelSettings,
              importIssueModelSettings,
              getIssueSettings,
              listIssuesSettings,
              updateIssueSettings,
              deleteIssueSettings,
              calculateIssueModelStatsSettings,
              createPhraseMatcherSettings,
              getPhraseMatcherSettings,
              listPhraseMatchersSettings,
              deletePhraseMatcherSettings,
              updatePhraseMatcherSettings,
              calculateStatsSettings,
              getSettingsSettings,
              updateSettingsSettings,
              createAnalysisRuleSettings,
              getAnalysisRuleSettings,
              listAnalysisRulesSettings,
              updateAnalysisRuleSettings,
              deleteAnalysisRuleSettings,
              getEncryptionSpecSettings,
              initializeEncryptionSpecSettings,
              createViewSettings,
              getViewSettings,
              listViewsSettings,
              updateViewSettings,
              deleteViewSettings,
              queryMetricsSettings,
              createQaQuestionSettings,
              getQaQuestionSettings,
              updateQaQuestionSettings,
              deleteQaQuestionSettings,
              listQaQuestionsSettings,
              createQaScorecardSettings,
              getQaScorecardSettings,
              updateQaScorecardSettings,
              deleteQaScorecardSettings,
              listQaScorecardsSettings,
              createQaScorecardRevisionSettings,
              getQaScorecardRevisionSettings,
              tuneQaScorecardRevisionSettings,
              deployQaScorecardRevisionSettings,
              undeployQaScorecardRevisionSettings,
              deleteQaScorecardRevisionSettings,
              listQaScorecardRevisionsSettings,
              createFeedbackLabelSettings,
              listFeedbackLabelsSettings,
              getFeedbackLabelSettings,
              updateFeedbackLabelSettings,
              deleteFeedbackLabelSettings,
              listAllFeedbackLabelsSettings,
              bulkUploadFeedbackLabelsSettings,
              bulkDownloadFeedbackLabelsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .uploadConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConversationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteConversationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAnalysisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAnalysisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAnalysesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAnalysisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .bulkAnalyzeConversationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .bulkDeleteConversationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .ingestConversationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportInsightsDataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createIssueModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateIssueModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIssueModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listIssueModelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteIssueModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deployIssueModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeployIssueModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .exportIssueModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .importIssueModelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIssueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listIssuesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateIssueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteIssueSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .calculateIssueModelStatsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPhraseMatcherSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPhraseMatcherSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPhraseMatchersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePhraseMatcherSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updatePhraseMatcherSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .calculateStatsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createAnalysisRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getAnalysisRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAnalysisRulesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateAnalysisRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteAnalysisRuleSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEncryptionSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .initializeEncryptionSpecSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listViewsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .queryMetricsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createQaQuestionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getQaQuestionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateQaQuestionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteQaQuestionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listQaQuestionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createQaScorecardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getQaScorecardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateQaScorecardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteQaScorecardSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listQaScorecardsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createQaScorecardRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getQaScorecardRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .tuneQaScorecardRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deployQaScorecardRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeployQaScorecardRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteQaScorecardRevisionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listQaScorecardRevisionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createFeedbackLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listFeedbackLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getFeedbackLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateFeedbackLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteFeedbackLabelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listAllFeedbackLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .bulkUploadFeedbackLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .bulkDownloadFeedbackLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .uploadConversationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UploadConversationRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Conversation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UploadConversationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createAnalysisOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateAnalysisRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Analysis.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateAnalysisOperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .bulkAnalyzeConversationsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BulkAnalyzeConversationsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BulkAnalyzeConversationsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BulkAnalyzeConversationsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .bulkDeleteConversationsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BulkDeleteConversationsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BulkDeleteConversationsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BulkDeleteConversationsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .ingestConversationsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<IngestConversationsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  IngestConversationsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  IngestConversationsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportInsightsDataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportInsightsDataRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportInsightsDataResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ExportInsightsDataMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createIssueModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateIssueModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(IssueModel.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateIssueModelMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteIssueModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteIssueModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteIssueModelMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deployIssueModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeployIssueModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DeployIssueModelResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeployIssueModelMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .undeployIssueModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UndeployIssueModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  UndeployIssueModelResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UndeployIssueModelMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .exportIssueModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportIssueModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ExportIssueModelResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ExportIssueModelMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .importIssueModelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportIssueModelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ImportIssueModelResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(ImportIssueModelMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .initializeEncryptionSpecOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InitializeEncryptionSpecRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  InitializeEncryptionSpecResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  InitializeEncryptionSpecMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .queryMetricsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<QueryMetricsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(QueryMetricsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(QueryMetricsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .tuneQaScorecardRevisionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<TuneQaScorecardRevisionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  TuneQaScorecardRevisionResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  TuneQaScorecardRevisionMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .bulkUploadFeedbackLabelsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BulkUploadFeedbackLabelsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BulkUploadFeedbackLabelsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BulkUploadFeedbackLabelsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .bulkDownloadFeedbackLabelsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BulkDownloadFeedbackLabelsRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BulkDownloadFeedbackLabelsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BulkDownloadFeedbackLabelsMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createConversation. */
    public UnaryCallSettings.Builder<CreateConversationRequest, Conversation>
        createConversationSettings() {
      return createConversationSettings;
    }

    /** Returns the builder for the settings used for calls to uploadConversation. */
    public UnaryCallSettings.Builder<UploadConversationRequest, Operation>
        uploadConversationSettings() {
      return uploadConversationSettings;
    }

    /** Returns the builder for the settings used for calls to uploadConversation. */
    public OperationCallSettings.Builder<
            UploadConversationRequest, Conversation, UploadConversationMetadata>
        uploadConversationOperationSettings() {
      return uploadConversationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConversation. */
    public UnaryCallSettings.Builder<UpdateConversationRequest, Conversation>
        updateConversationSettings() {
      return updateConversationSettings;
    }

    /** Returns the builder for the settings used for calls to getConversation. */
    public UnaryCallSettings.Builder<GetConversationRequest, Conversation>
        getConversationSettings() {
      return getConversationSettings;
    }

    /** Returns the builder for the settings used for calls to listConversations. */
    public PagedCallSettings.Builder<
            ListConversationsRequest, ListConversationsResponse, ListConversationsPagedResponse>
        listConversationsSettings() {
      return listConversationsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConversation. */
    public UnaryCallSettings.Builder<DeleteConversationRequest, Empty>
        deleteConversationSettings() {
      return deleteConversationSettings;
    }

    /** Returns the builder for the settings used for calls to createAnalysis. */
    public UnaryCallSettings.Builder<CreateAnalysisRequest, Operation> createAnalysisSettings() {
      return createAnalysisSettings;
    }

    /** Returns the builder for the settings used for calls to createAnalysis. */
    public OperationCallSettings.Builder<
            CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
        createAnalysisOperationSettings() {
      return createAnalysisOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getAnalysis. */
    public UnaryCallSettings.Builder<GetAnalysisRequest, Analysis> getAnalysisSettings() {
      return getAnalysisSettings;
    }

    /** Returns the builder for the settings used for calls to listAnalyses. */
    public PagedCallSettings.Builder<
            ListAnalysesRequest, ListAnalysesResponse, ListAnalysesPagedResponse>
        listAnalysesSettings() {
      return listAnalysesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAnalysis. */
    public UnaryCallSettings.Builder<DeleteAnalysisRequest, Empty> deleteAnalysisSettings() {
      return deleteAnalysisSettings;
    }

    /** Returns the builder for the settings used for calls to bulkAnalyzeConversations. */
    public UnaryCallSettings.Builder<BulkAnalyzeConversationsRequest, Operation>
        bulkAnalyzeConversationsSettings() {
      return bulkAnalyzeConversationsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkAnalyzeConversations. */
    public OperationCallSettings.Builder<
            BulkAnalyzeConversationsRequest,
            BulkAnalyzeConversationsResponse,
            BulkAnalyzeConversationsMetadata>
        bulkAnalyzeConversationsOperationSettings() {
      return bulkAnalyzeConversationsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to bulkDeleteConversations. */
    public UnaryCallSettings.Builder<BulkDeleteConversationsRequest, Operation>
        bulkDeleteConversationsSettings() {
      return bulkDeleteConversationsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkDeleteConversations. */
    public OperationCallSettings.Builder<
            BulkDeleteConversationsRequest,
            BulkDeleteConversationsResponse,
            BulkDeleteConversationsMetadata>
        bulkDeleteConversationsOperationSettings() {
      return bulkDeleteConversationsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to ingestConversations. */
    public UnaryCallSettings.Builder<IngestConversationsRequest, Operation>
        ingestConversationsSettings() {
      return ingestConversationsSettings;
    }

    /** Returns the builder for the settings used for calls to ingestConversations. */
    public OperationCallSettings.Builder<
            IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
        ingestConversationsOperationSettings() {
      return ingestConversationsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportInsightsData. */
    public UnaryCallSettings.Builder<ExportInsightsDataRequest, Operation>
        exportInsightsDataSettings() {
      return exportInsightsDataSettings;
    }

    /** Returns the builder for the settings used for calls to exportInsightsData. */
    public OperationCallSettings.Builder<
            ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
        exportInsightsDataOperationSettings() {
      return exportInsightsDataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createIssueModel. */
    public UnaryCallSettings.Builder<CreateIssueModelRequest, Operation>
        createIssueModelSettings() {
      return createIssueModelSettings;
    }

    /** Returns the builder for the settings used for calls to createIssueModel. */
    public OperationCallSettings.Builder<
            CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
        createIssueModelOperationSettings() {
      return createIssueModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateIssueModel. */
    public UnaryCallSettings.Builder<UpdateIssueModelRequest, IssueModel>
        updateIssueModelSettings() {
      return updateIssueModelSettings;
    }

    /** Returns the builder for the settings used for calls to getIssueModel. */
    public UnaryCallSettings.Builder<GetIssueModelRequest, IssueModel> getIssueModelSettings() {
      return getIssueModelSettings;
    }

    /** Returns the builder for the settings used for calls to listIssueModels. */
    public UnaryCallSettings.Builder<ListIssueModelsRequest, ListIssueModelsResponse>
        listIssueModelsSettings() {
      return listIssueModelsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIssueModel. */
    public UnaryCallSettings.Builder<DeleteIssueModelRequest, Operation>
        deleteIssueModelSettings() {
      return deleteIssueModelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIssueModel. */
    public OperationCallSettings.Builder<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
        deleteIssueModelOperationSettings() {
      return deleteIssueModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deployIssueModel. */
    public UnaryCallSettings.Builder<DeployIssueModelRequest, Operation>
        deployIssueModelSettings() {
      return deployIssueModelSettings;
    }

    /** Returns the builder for the settings used for calls to deployIssueModel. */
    public OperationCallSettings.Builder<
            DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
        deployIssueModelOperationSettings() {
      return deployIssueModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to undeployIssueModel. */
    public UnaryCallSettings.Builder<UndeployIssueModelRequest, Operation>
        undeployIssueModelSettings() {
      return undeployIssueModelSettings;
    }

    /** Returns the builder for the settings used for calls to undeployIssueModel. */
    public OperationCallSettings.Builder<
            UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
        undeployIssueModelOperationSettings() {
      return undeployIssueModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportIssueModel. */
    public UnaryCallSettings.Builder<ExportIssueModelRequest, Operation>
        exportIssueModelSettings() {
      return exportIssueModelSettings;
    }

    /** Returns the builder for the settings used for calls to exportIssueModel. */
    public OperationCallSettings.Builder<
            ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
        exportIssueModelOperationSettings() {
      return exportIssueModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importIssueModel. */
    public UnaryCallSettings.Builder<ImportIssueModelRequest, Operation>
        importIssueModelSettings() {
      return importIssueModelSettings;
    }

    /** Returns the builder for the settings used for calls to importIssueModel. */
    public OperationCallSettings.Builder<
            ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
        importIssueModelOperationSettings() {
      return importIssueModelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getIssue. */
    public UnaryCallSettings.Builder<GetIssueRequest, Issue> getIssueSettings() {
      return getIssueSettings;
    }

    /** Returns the builder for the settings used for calls to listIssues. */
    public UnaryCallSettings.Builder<ListIssuesRequest, ListIssuesResponse> listIssuesSettings() {
      return listIssuesSettings;
    }

    /** Returns the builder for the settings used for calls to updateIssue. */
    public UnaryCallSettings.Builder<UpdateIssueRequest, Issue> updateIssueSettings() {
      return updateIssueSettings;
    }

    /** Returns the builder for the settings used for calls to deleteIssue. */
    public UnaryCallSettings.Builder<DeleteIssueRequest, Empty> deleteIssueSettings() {
      return deleteIssueSettings;
    }

    /** Returns the builder for the settings used for calls to calculateIssueModelStats. */
    public UnaryCallSettings.Builder<
            CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
        calculateIssueModelStatsSettings() {
      return calculateIssueModelStatsSettings;
    }

    /** Returns the builder for the settings used for calls to createPhraseMatcher. */
    public UnaryCallSettings.Builder<CreatePhraseMatcherRequest, PhraseMatcher>
        createPhraseMatcherSettings() {
      return createPhraseMatcherSettings;
    }

    /** Returns the builder for the settings used for calls to getPhraseMatcher. */
    public UnaryCallSettings.Builder<GetPhraseMatcherRequest, PhraseMatcher>
        getPhraseMatcherSettings() {
      return getPhraseMatcherSettings;
    }

    /** Returns the builder for the settings used for calls to listPhraseMatchers. */
    public PagedCallSettings.Builder<
            ListPhraseMatchersRequest, ListPhraseMatchersResponse, ListPhraseMatchersPagedResponse>
        listPhraseMatchersSettings() {
      return listPhraseMatchersSettings;
    }

    /** Returns the builder for the settings used for calls to deletePhraseMatcher. */
    public UnaryCallSettings.Builder<DeletePhraseMatcherRequest, Empty>
        deletePhraseMatcherSettings() {
      return deletePhraseMatcherSettings;
    }

    /** Returns the builder for the settings used for calls to updatePhraseMatcher. */
    public UnaryCallSettings.Builder<UpdatePhraseMatcherRequest, PhraseMatcher>
        updatePhraseMatcherSettings() {
      return updatePhraseMatcherSettings;
    }

    /** Returns the builder for the settings used for calls to calculateStats. */
    public UnaryCallSettings.Builder<CalculateStatsRequest, CalculateStatsResponse>
        calculateStatsSettings() {
      return calculateStatsSettings;
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Settings> updateSettingsSettings() {
      return updateSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to createAnalysisRule. */
    public UnaryCallSettings.Builder<CreateAnalysisRuleRequest, AnalysisRule>
        createAnalysisRuleSettings() {
      return createAnalysisRuleSettings;
    }

    /** Returns the builder for the settings used for calls to getAnalysisRule. */
    public UnaryCallSettings.Builder<GetAnalysisRuleRequest, AnalysisRule>
        getAnalysisRuleSettings() {
      return getAnalysisRuleSettings;
    }

    /** Returns the builder for the settings used for calls to listAnalysisRules. */
    public PagedCallSettings.Builder<
            ListAnalysisRulesRequest, ListAnalysisRulesResponse, ListAnalysisRulesPagedResponse>
        listAnalysisRulesSettings() {
      return listAnalysisRulesSettings;
    }

    /** Returns the builder for the settings used for calls to updateAnalysisRule. */
    public UnaryCallSettings.Builder<UpdateAnalysisRuleRequest, AnalysisRule>
        updateAnalysisRuleSettings() {
      return updateAnalysisRuleSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAnalysisRule. */
    public UnaryCallSettings.Builder<DeleteAnalysisRuleRequest, Empty>
        deleteAnalysisRuleSettings() {
      return deleteAnalysisRuleSettings;
    }

    /** Returns the builder for the settings used for calls to getEncryptionSpec. */
    public UnaryCallSettings.Builder<GetEncryptionSpecRequest, EncryptionSpec>
        getEncryptionSpecSettings() {
      return getEncryptionSpecSettings;
    }

    /** Returns the builder for the settings used for calls to initializeEncryptionSpec. */
    public UnaryCallSettings.Builder<InitializeEncryptionSpecRequest, Operation>
        initializeEncryptionSpecSettings() {
      return initializeEncryptionSpecSettings;
    }

    /** Returns the builder for the settings used for calls to initializeEncryptionSpec. */
    public OperationCallSettings.Builder<
            InitializeEncryptionSpecRequest,
            InitializeEncryptionSpecResponse,
            InitializeEncryptionSpecMetadata>
        initializeEncryptionSpecOperationSettings() {
      return initializeEncryptionSpecOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createView. */
    public UnaryCallSettings.Builder<CreateViewRequest, View> createViewSettings() {
      return createViewSettings;
    }

    /** Returns the builder for the settings used for calls to getView. */
    public UnaryCallSettings.Builder<GetViewRequest, View> getViewSettings() {
      return getViewSettings;
    }

    /** Returns the builder for the settings used for calls to listViews. */
    public PagedCallSettings.Builder<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
        listViewsSettings() {
      return listViewsSettings;
    }

    /** Returns the builder for the settings used for calls to updateView. */
    public UnaryCallSettings.Builder<UpdateViewRequest, View> updateViewSettings() {
      return updateViewSettings;
    }

    /** Returns the builder for the settings used for calls to deleteView. */
    public UnaryCallSettings.Builder<DeleteViewRequest, Empty> deleteViewSettings() {
      return deleteViewSettings;
    }

    /** Returns the builder for the settings used for calls to queryMetrics. */
    public UnaryCallSettings.Builder<QueryMetricsRequest, Operation> queryMetricsSettings() {
      return queryMetricsSettings;
    }

    /** Returns the builder for the settings used for calls to queryMetrics. */
    public OperationCallSettings.Builder<
            QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
        queryMetricsOperationSettings() {
      return queryMetricsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createQaQuestion. */
    public UnaryCallSettings.Builder<CreateQaQuestionRequest, QaQuestion>
        createQaQuestionSettings() {
      return createQaQuestionSettings;
    }

    /** Returns the builder for the settings used for calls to getQaQuestion. */
    public UnaryCallSettings.Builder<GetQaQuestionRequest, QaQuestion> getQaQuestionSettings() {
      return getQaQuestionSettings;
    }

    /** Returns the builder for the settings used for calls to updateQaQuestion. */
    public UnaryCallSettings.Builder<UpdateQaQuestionRequest, QaQuestion>
        updateQaQuestionSettings() {
      return updateQaQuestionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteQaQuestion. */
    public UnaryCallSettings.Builder<DeleteQaQuestionRequest, Empty> deleteQaQuestionSettings() {
      return deleteQaQuestionSettings;
    }

    /** Returns the builder for the settings used for calls to listQaQuestions. */
    public PagedCallSettings.Builder<
            ListQaQuestionsRequest, ListQaQuestionsResponse, ListQaQuestionsPagedResponse>
        listQaQuestionsSettings() {
      return listQaQuestionsSettings;
    }

    /** Returns the builder for the settings used for calls to createQaScorecard. */
    public UnaryCallSettings.Builder<CreateQaScorecardRequest, QaScorecard>
        createQaScorecardSettings() {
      return createQaScorecardSettings;
    }

    /** Returns the builder for the settings used for calls to getQaScorecard. */
    public UnaryCallSettings.Builder<GetQaScorecardRequest, QaScorecard> getQaScorecardSettings() {
      return getQaScorecardSettings;
    }

    /** Returns the builder for the settings used for calls to updateQaScorecard. */
    public UnaryCallSettings.Builder<UpdateQaScorecardRequest, QaScorecard>
        updateQaScorecardSettings() {
      return updateQaScorecardSettings;
    }

    /** Returns the builder for the settings used for calls to deleteQaScorecard. */
    public UnaryCallSettings.Builder<DeleteQaScorecardRequest, Empty> deleteQaScorecardSettings() {
      return deleteQaScorecardSettings;
    }

    /** Returns the builder for the settings used for calls to listQaScorecards. */
    public PagedCallSettings.Builder<
            ListQaScorecardsRequest, ListQaScorecardsResponse, ListQaScorecardsPagedResponse>
        listQaScorecardsSettings() {
      return listQaScorecardsSettings;
    }

    /** Returns the builder for the settings used for calls to createQaScorecardRevision. */
    public UnaryCallSettings.Builder<CreateQaScorecardRevisionRequest, QaScorecardRevision>
        createQaScorecardRevisionSettings() {
      return createQaScorecardRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to getQaScorecardRevision. */
    public UnaryCallSettings.Builder<GetQaScorecardRevisionRequest, QaScorecardRevision>
        getQaScorecardRevisionSettings() {
      return getQaScorecardRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to tuneQaScorecardRevision. */
    public UnaryCallSettings.Builder<TuneQaScorecardRevisionRequest, Operation>
        tuneQaScorecardRevisionSettings() {
      return tuneQaScorecardRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to tuneQaScorecardRevision. */
    public OperationCallSettings.Builder<
            TuneQaScorecardRevisionRequest,
            TuneQaScorecardRevisionResponse,
            TuneQaScorecardRevisionMetadata>
        tuneQaScorecardRevisionOperationSettings() {
      return tuneQaScorecardRevisionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deployQaScorecardRevision. */
    public UnaryCallSettings.Builder<DeployQaScorecardRevisionRequest, QaScorecardRevision>
        deployQaScorecardRevisionSettings() {
      return deployQaScorecardRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to undeployQaScorecardRevision. */
    public UnaryCallSettings.Builder<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
        undeployQaScorecardRevisionSettings() {
      return undeployQaScorecardRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteQaScorecardRevision. */
    public UnaryCallSettings.Builder<DeleteQaScorecardRevisionRequest, Empty>
        deleteQaScorecardRevisionSettings() {
      return deleteQaScorecardRevisionSettings;
    }

    /** Returns the builder for the settings used for calls to listQaScorecardRevisions. */
    public PagedCallSettings.Builder<
            ListQaScorecardRevisionsRequest,
            ListQaScorecardRevisionsResponse,
            ListQaScorecardRevisionsPagedResponse>
        listQaScorecardRevisionsSettings() {
      return listQaScorecardRevisionsSettings;
    }

    /** Returns the builder for the settings used for calls to createFeedbackLabel. */
    public UnaryCallSettings.Builder<CreateFeedbackLabelRequest, FeedbackLabel>
        createFeedbackLabelSettings() {
      return createFeedbackLabelSettings;
    }

    /** Returns the builder for the settings used for calls to listFeedbackLabels. */
    public PagedCallSettings.Builder<
            ListFeedbackLabelsRequest, ListFeedbackLabelsResponse, ListFeedbackLabelsPagedResponse>
        listFeedbackLabelsSettings() {
      return listFeedbackLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to getFeedbackLabel. */
    public UnaryCallSettings.Builder<GetFeedbackLabelRequest, FeedbackLabel>
        getFeedbackLabelSettings() {
      return getFeedbackLabelSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeedbackLabel. */
    public UnaryCallSettings.Builder<UpdateFeedbackLabelRequest, FeedbackLabel>
        updateFeedbackLabelSettings() {
      return updateFeedbackLabelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeedbackLabel. */
    public UnaryCallSettings.Builder<DeleteFeedbackLabelRequest, Empty>
        deleteFeedbackLabelSettings() {
      return deleteFeedbackLabelSettings;
    }

    /** Returns the builder for the settings used for calls to listAllFeedbackLabels. */
    public PagedCallSettings.Builder<
            ListAllFeedbackLabelsRequest,
            ListAllFeedbackLabelsResponse,
            ListAllFeedbackLabelsPagedResponse>
        listAllFeedbackLabelsSettings() {
      return listAllFeedbackLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkUploadFeedbackLabels. */
    public UnaryCallSettings.Builder<BulkUploadFeedbackLabelsRequest, Operation>
        bulkUploadFeedbackLabelsSettings() {
      return bulkUploadFeedbackLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkUploadFeedbackLabels. */
    public OperationCallSettings.Builder<
            BulkUploadFeedbackLabelsRequest,
            BulkUploadFeedbackLabelsResponse,
            BulkUploadFeedbackLabelsMetadata>
        bulkUploadFeedbackLabelsOperationSettings() {
      return bulkUploadFeedbackLabelsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to bulkDownloadFeedbackLabels. */
    public UnaryCallSettings.Builder<BulkDownloadFeedbackLabelsRequest, Operation>
        bulkDownloadFeedbackLabelsSettings() {
      return bulkDownloadFeedbackLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkDownloadFeedbackLabels. */
    public OperationCallSettings.Builder<
            BulkDownloadFeedbackLabelsRequest,
            BulkDownloadFeedbackLabelsResponse,
            BulkDownloadFeedbackLabelsMetadata>
        bulkDownloadFeedbackLabelsOperationSettings() {
      return bulkDownloadFeedbackLabelsOperationSettings;
    }

    @Override
    public ContactCenterInsightsStubSettings build() throws IOException {
      return new ContactCenterInsightsStubSettings(this);
    }
  }
}
