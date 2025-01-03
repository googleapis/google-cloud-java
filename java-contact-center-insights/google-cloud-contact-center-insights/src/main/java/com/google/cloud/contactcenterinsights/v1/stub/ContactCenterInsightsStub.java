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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
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
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ContactCenterInsights service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ContactCenterInsightsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: createConversationCallable()");
  }

  public OperationCallable<UploadConversationRequest, Conversation, UploadConversationMetadata>
      uploadConversationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: uploadConversationOperationCallable()");
  }

  public UnaryCallable<UploadConversationRequest, Operation> uploadConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: uploadConversationCallable()");
  }

  public UnaryCallable<UpdateConversationRequest, Conversation> updateConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConversationCallable()");
  }

  public UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: getConversationCallable()");
  }

  public UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationsPagedCallable()");
  }

  public UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConversationsCallable()");
  }

  public UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConversationCallable()");
  }

  public OperationCallable<CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
      createAnalysisOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAnalysisOperationCallable()");
  }

  public UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable() {
    throw new UnsupportedOperationException("Not implemented: createAnalysisCallable()");
  }

  public UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnalysisCallable()");
  }

  public UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse> listAnalysesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalysesPagedCallable()");
  }

  public UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalysesCallable()");
  }

  public UnaryCallable<DeleteAnalysisRequest, Empty> deleteAnalysisCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAnalysisCallable()");
  }

  public OperationCallable<
          BulkAnalyzeConversationsRequest,
          BulkAnalyzeConversationsResponse,
          BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: bulkAnalyzeConversationsOperationCallable()");
  }

  public UnaryCallable<BulkAnalyzeConversationsRequest, Operation>
      bulkAnalyzeConversationsCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkAnalyzeConversationsCallable()");
  }

  public OperationCallable<
          BulkDeleteConversationsRequest,
          BulkDeleteConversationsResponse,
          BulkDeleteConversationsMetadata>
      bulkDeleteConversationsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: bulkDeleteConversationsOperationCallable()");
  }

  public UnaryCallable<BulkDeleteConversationsRequest, Operation>
      bulkDeleteConversationsCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkDeleteConversationsCallable()");
  }

  public OperationCallable<
          IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: ingestConversationsOperationCallable()");
  }

  public UnaryCallable<IngestConversationsRequest, Operation> ingestConversationsCallable() {
    throw new UnsupportedOperationException("Not implemented: ingestConversationsCallable()");
  }

  public OperationCallable<
          ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: exportInsightsDataOperationCallable()");
  }

  public UnaryCallable<ExportInsightsDataRequest, Operation> exportInsightsDataCallable() {
    throw new UnsupportedOperationException("Not implemented: exportInsightsDataCallable()");
  }

  public OperationCallable<CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
      createIssueModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createIssueModelOperationCallable()");
  }

  public UnaryCallable<CreateIssueModelRequest, Operation> createIssueModelCallable() {
    throw new UnsupportedOperationException("Not implemented: createIssueModelCallable()");
  }

  public UnaryCallable<UpdateIssueModelRequest, IssueModel> updateIssueModelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIssueModelCallable()");
  }

  public UnaryCallable<GetIssueModelRequest, IssueModel> getIssueModelCallable() {
    throw new UnsupportedOperationException("Not implemented: getIssueModelCallable()");
  }

  public UnaryCallable<ListIssueModelsRequest, ListIssueModelsResponse> listIssueModelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIssueModelsCallable()");
  }

  public OperationCallable<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
      deleteIssueModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIssueModelOperationCallable()");
  }

  public UnaryCallable<DeleteIssueModelRequest, Operation> deleteIssueModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIssueModelCallable()");
  }

  public OperationCallable<
          DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deployIssueModelOperationCallable()");
  }

  public UnaryCallable<DeployIssueModelRequest, Operation> deployIssueModelCallable() {
    throw new UnsupportedOperationException("Not implemented: deployIssueModelCallable()");
  }

  public OperationCallable<
          UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeployIssueModelOperationCallable()");
  }

  public UnaryCallable<UndeployIssueModelRequest, Operation> undeployIssueModelCallable() {
    throw new UnsupportedOperationException("Not implemented: undeployIssueModelCallable()");
  }

  public OperationCallable<
          ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportIssueModelOperationCallable()");
  }

  public UnaryCallable<ExportIssueModelRequest, Operation> exportIssueModelCallable() {
    throw new UnsupportedOperationException("Not implemented: exportIssueModelCallable()");
  }

  public OperationCallable<
          ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importIssueModelOperationCallable()");
  }

  public UnaryCallable<ImportIssueModelRequest, Operation> importIssueModelCallable() {
    throw new UnsupportedOperationException("Not implemented: importIssueModelCallable()");
  }

  public UnaryCallable<GetIssueRequest, Issue> getIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: getIssueCallable()");
  }

  public UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIssuesCallable()");
  }

  public UnaryCallable<UpdateIssueRequest, Issue> updateIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIssueCallable()");
  }

  public UnaryCallable<DeleteIssueRequest, Empty> deleteIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIssueCallable()");
  }

  public UnaryCallable<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsCallable() {
    throw new UnsupportedOperationException("Not implemented: calculateIssueModelStatsCallable()");
  }

  public UnaryCallable<CreatePhraseMatcherRequest, PhraseMatcher> createPhraseMatcherCallable() {
    throw new UnsupportedOperationException("Not implemented: createPhraseMatcherCallable()");
  }

  public UnaryCallable<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherCallable() {
    throw new UnsupportedOperationException("Not implemented: getPhraseMatcherCallable()");
  }

  public UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersPagedResponse>
      listPhraseMatchersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPhraseMatchersPagedCallable()");
  }

  public UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
      listPhraseMatchersCallable() {
    throw new UnsupportedOperationException("Not implemented: listPhraseMatchersCallable()");
  }

  public UnaryCallable<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherCallable() {
    throw new UnsupportedOperationException("Not implemented: deletePhraseMatcherCallable()");
  }

  public UnaryCallable<UpdatePhraseMatcherRequest, PhraseMatcher> updatePhraseMatcherCallable() {
    throw new UnsupportedOperationException("Not implemented: updatePhraseMatcherCallable()");
  }

  public UnaryCallable<CalculateStatsRequest, CalculateStatsResponse> calculateStatsCallable() {
    throw new UnsupportedOperationException("Not implemented: calculateStatsCallable()");
  }

  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: getSettingsCallable()");
  }

  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSettingsCallable()");
  }

  public UnaryCallable<CreateAnalysisRuleRequest, AnalysisRule> createAnalysisRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: createAnalysisRuleCallable()");
  }

  public UnaryCallable<GetAnalysisRuleRequest, AnalysisRule> getAnalysisRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: getAnalysisRuleCallable()");
  }

  public UnaryCallable<ListAnalysisRulesRequest, ListAnalysisRulesPagedResponse>
      listAnalysisRulesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalysisRulesPagedCallable()");
  }

  public UnaryCallable<ListAnalysisRulesRequest, ListAnalysisRulesResponse>
      listAnalysisRulesCallable() {
    throw new UnsupportedOperationException("Not implemented: listAnalysisRulesCallable()");
  }

  public UnaryCallable<UpdateAnalysisRuleRequest, AnalysisRule> updateAnalysisRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAnalysisRuleCallable()");
  }

  public UnaryCallable<DeleteAnalysisRuleRequest, Empty> deleteAnalysisRuleCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAnalysisRuleCallable()");
  }

  public UnaryCallable<GetEncryptionSpecRequest, EncryptionSpec> getEncryptionSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: getEncryptionSpecCallable()");
  }

  public OperationCallable<
          InitializeEncryptionSpecRequest,
          InitializeEncryptionSpecResponse,
          InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: initializeEncryptionSpecOperationCallable()");
  }

  public UnaryCallable<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecCallable() {
    throw new UnsupportedOperationException("Not implemented: initializeEncryptionSpecCallable()");
  }

  public UnaryCallable<CreateViewRequest, View> createViewCallable() {
    throw new UnsupportedOperationException("Not implemented: createViewCallable()");
  }

  public UnaryCallable<GetViewRequest, View> getViewCallable() {
    throw new UnsupportedOperationException("Not implemented: getViewCallable()");
  }

  public UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listViewsPagedCallable()");
  }

  public UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    throw new UnsupportedOperationException("Not implemented: listViewsCallable()");
  }

  public UnaryCallable<UpdateViewRequest, View> updateViewCallable() {
    throw new UnsupportedOperationException("Not implemented: updateViewCallable()");
  }

  public UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteViewCallable()");
  }

  public OperationCallable<QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
      queryMetricsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: queryMetricsOperationCallable()");
  }

  public UnaryCallable<QueryMetricsRequest, Operation> queryMetricsCallable() {
    throw new UnsupportedOperationException("Not implemented: queryMetricsCallable()");
  }

  public UnaryCallable<CreateQaQuestionRequest, QaQuestion> createQaQuestionCallable() {
    throw new UnsupportedOperationException("Not implemented: createQaQuestionCallable()");
  }

  public UnaryCallable<GetQaQuestionRequest, QaQuestion> getQaQuestionCallable() {
    throw new UnsupportedOperationException("Not implemented: getQaQuestionCallable()");
  }

  public UnaryCallable<UpdateQaQuestionRequest, QaQuestion> updateQaQuestionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateQaQuestionCallable()");
  }

  public UnaryCallable<DeleteQaQuestionRequest, Empty> deleteQaQuestionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteQaQuestionCallable()");
  }

  public UnaryCallable<ListQaQuestionsRequest, ListQaQuestionsPagedResponse>
      listQaQuestionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listQaQuestionsPagedCallable()");
  }

  public UnaryCallable<ListQaQuestionsRequest, ListQaQuestionsResponse> listQaQuestionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listQaQuestionsCallable()");
  }

  public UnaryCallable<CreateQaScorecardRequest, QaScorecard> createQaScorecardCallable() {
    throw new UnsupportedOperationException("Not implemented: createQaScorecardCallable()");
  }

  public UnaryCallable<GetQaScorecardRequest, QaScorecard> getQaScorecardCallable() {
    throw new UnsupportedOperationException("Not implemented: getQaScorecardCallable()");
  }

  public UnaryCallable<UpdateQaScorecardRequest, QaScorecard> updateQaScorecardCallable() {
    throw new UnsupportedOperationException("Not implemented: updateQaScorecardCallable()");
  }

  public UnaryCallable<DeleteQaScorecardRequest, Empty> deleteQaScorecardCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteQaScorecardCallable()");
  }

  public UnaryCallable<ListQaScorecardsRequest, ListQaScorecardsPagedResponse>
      listQaScorecardsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listQaScorecardsPagedCallable()");
  }

  public UnaryCallable<ListQaScorecardsRequest, ListQaScorecardsResponse>
      listQaScorecardsCallable() {
    throw new UnsupportedOperationException("Not implemented: listQaScorecardsCallable()");
  }

  public UnaryCallable<CreateQaScorecardRevisionRequest, QaScorecardRevision>
      createQaScorecardRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: createQaScorecardRevisionCallable()");
  }

  public UnaryCallable<GetQaScorecardRevisionRequest, QaScorecardRevision>
      getQaScorecardRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: getQaScorecardRevisionCallable()");
  }

  public OperationCallable<
          TuneQaScorecardRevisionRequest,
          TuneQaScorecardRevisionResponse,
          TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: tuneQaScorecardRevisionOperationCallable()");
  }

  public UnaryCallable<TuneQaScorecardRevisionRequest, Operation>
      tuneQaScorecardRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: tuneQaScorecardRevisionCallable()");
  }

  public UnaryCallable<DeployQaScorecardRevisionRequest, QaScorecardRevision>
      deployQaScorecardRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: deployQaScorecardRevisionCallable()");
  }

  public UnaryCallable<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
      undeployQaScorecardRevisionCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: undeployQaScorecardRevisionCallable()");
  }

  public UnaryCallable<DeleteQaScorecardRevisionRequest, Empty>
      deleteQaScorecardRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteQaScorecardRevisionCallable()");
  }

  public UnaryCallable<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsPagedResponse>
      listQaScorecardRevisionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listQaScorecardRevisionsPagedCallable()");
  }

  public UnaryCallable<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>
      listQaScorecardRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listQaScorecardRevisionsCallable()");
  }

  public UnaryCallable<CreateFeedbackLabelRequest, FeedbackLabel> createFeedbackLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: createFeedbackLabelCallable()");
  }

  public UnaryCallable<ListFeedbackLabelsRequest, ListFeedbackLabelsPagedResponse>
      listFeedbackLabelsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeedbackLabelsPagedCallable()");
  }

  public UnaryCallable<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>
      listFeedbackLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFeedbackLabelsCallable()");
  }

  public UnaryCallable<GetFeedbackLabelRequest, FeedbackLabel> getFeedbackLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: getFeedbackLabelCallable()");
  }

  public UnaryCallable<UpdateFeedbackLabelRequest, FeedbackLabel> updateFeedbackLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFeedbackLabelCallable()");
  }

  public UnaryCallable<DeleteFeedbackLabelRequest, Empty> deleteFeedbackLabelCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteFeedbackLabelCallable()");
  }

  public UnaryCallable<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsPagedResponse>
      listAllFeedbackLabelsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAllFeedbackLabelsPagedCallable()");
  }

  public UnaryCallable<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>
      listAllFeedbackLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAllFeedbackLabelsCallable()");
  }

  public OperationCallable<
          BulkUploadFeedbackLabelsRequest,
          BulkUploadFeedbackLabelsResponse,
          BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: bulkUploadFeedbackLabelsOperationCallable()");
  }

  public UnaryCallable<BulkUploadFeedbackLabelsRequest, Operation>
      bulkUploadFeedbackLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkUploadFeedbackLabelsCallable()");
  }

  public OperationCallable<
          BulkDownloadFeedbackLabelsRequest,
          BulkDownloadFeedbackLabelsResponse,
          BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: bulkDownloadFeedbackLabelsOperationCallable()");
  }

  public UnaryCallable<BulkDownloadFeedbackLabelsRequest, Operation>
      bulkDownloadFeedbackLabelsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: bulkDownloadFeedbackLabelsCallable()");
  }

  @Override
  public abstract void close();
}
