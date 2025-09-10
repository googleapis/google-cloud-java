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
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
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
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the ContactCenterInsights service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcContactCenterInsightsStub extends ContactCenterInsightsStub {
  private static final MethodDescriptor<CreateConversationRequest, Conversation>
      createConversationMethodDescriptor =
          MethodDescriptor.<CreateConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UploadConversationRequest, Operation>
      uploadConversationMethodDescriptor =
          MethodDescriptor.<UploadConversationRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UploadConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UploadConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateConversationRequest, Conversation>
      updateConversationMethodDescriptor =
          MethodDescriptor.<UpdateConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetConversationRequest, Conversation>
      getConversationMethodDescriptor =
          MethodDescriptor.<GetConversationRequest, Conversation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Conversation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListConversationsRequest, ListConversationsResponse>
      listConversationsMethodDescriptor =
          MethodDescriptor.<ListConversationsRequest, ListConversationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListConversations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConversationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConversationsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteConversationRequest, Empty>
      deleteConversationMethodDescriptor =
          MethodDescriptor.<DeleteConversationRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteConversation")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConversationRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAnalysisRequest, Operation>
      createAnalysisMethodDescriptor =
          MethodDescriptor.<CreateAnalysisRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateAnalysis")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAnalysisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAnalysisRequest, Analysis> getAnalysisMethodDescriptor =
      MethodDescriptor.<GetAnalysisRequest, Analysis>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetAnalysis")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAnalysisRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Analysis.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListAnalysesRequest, ListAnalysesResponse>
      listAnalysesMethodDescriptor =
          MethodDescriptor.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListAnalyses")
              .setRequestMarshaller(ProtoUtils.marshaller(ListAnalysesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnalysesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAnalysisRequest, Empty>
      deleteAnalysisMethodDescriptor =
          MethodDescriptor.<DeleteAnalysisRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteAnalysis")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAnalysisRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BulkAnalyzeConversationsRequest, Operation>
      bulkAnalyzeConversationsMethodDescriptor =
          MethodDescriptor.<BulkAnalyzeConversationsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/BulkAnalyzeConversations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkAnalyzeConversationsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BulkDeleteConversationsRequest, Operation>
      bulkDeleteConversationsMethodDescriptor =
          MethodDescriptor.<BulkDeleteConversationsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/BulkDeleteConversations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkDeleteConversationsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<IngestConversationsRequest, Operation>
      ingestConversationsMethodDescriptor =
          MethodDescriptor.<IngestConversationsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/IngestConversations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(IngestConversationsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportInsightsDataRequest, Operation>
      exportInsightsDataMethodDescriptor =
          MethodDescriptor.<ExportInsightsDataRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ExportInsightsData")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportInsightsDataRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateIssueModelRequest, Operation>
      createIssueModelMethodDescriptor =
          MethodDescriptor.<CreateIssueModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateIssueModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateIssueModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateIssueModelRequest, IssueModel>
      updateIssueModelMethodDescriptor =
          MethodDescriptor.<UpdateIssueModelRequest, IssueModel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateIssueModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateIssueModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IssueModel.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIssueModelRequest, IssueModel>
      getIssueModelMethodDescriptor =
          MethodDescriptor.<GetIssueModelRequest, IssueModel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetIssueModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetIssueModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(IssueModel.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListIssueModelsRequest, ListIssueModelsResponse>
      listIssueModelsMethodDescriptor =
          MethodDescriptor.<ListIssueModelsRequest, ListIssueModelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListIssueModels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListIssueModelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListIssueModelsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteIssueModelRequest, Operation>
      deleteIssueModelMethodDescriptor =
          MethodDescriptor.<DeleteIssueModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteIssueModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteIssueModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeployIssueModelRequest, Operation>
      deployIssueModelMethodDescriptor =
          MethodDescriptor.<DeployIssueModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeployIssueModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeployIssueModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UndeployIssueModelRequest, Operation>
      undeployIssueModelMethodDescriptor =
          MethodDescriptor.<UndeployIssueModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UndeployIssueModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployIssueModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ExportIssueModelRequest, Operation>
      exportIssueModelMethodDescriptor =
          MethodDescriptor.<ExportIssueModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ExportIssueModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ExportIssueModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ImportIssueModelRequest, Operation>
      importIssueModelMethodDescriptor =
          MethodDescriptor.<ImportIssueModelRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ImportIssueModel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ImportIssueModelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetIssueRequest, Issue> getIssueMethodDescriptor =
      MethodDescriptor.<GetIssueRequest, Issue>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Issue.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListIssuesRequest, ListIssuesResponse>
      listIssuesMethodDescriptor =
          MethodDescriptor.<ListIssuesRequest, ListIssuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListIssues")
              .setRequestMarshaller(ProtoUtils.marshaller(ListIssuesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListIssuesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateIssueRequest, Issue> updateIssueMethodDescriptor =
      MethodDescriptor.<UpdateIssueRequest, Issue>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Issue.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteIssueRequest, Empty> deleteIssueMethodDescriptor =
      MethodDescriptor.<DeleteIssueRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<
          CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsMethodDescriptor =
          MethodDescriptor
              .<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CalculateIssueModelStats")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CalculateIssueModelStatsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CalculateIssueModelStatsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreatePhraseMatcherRequest, PhraseMatcher>
      createPhraseMatcherMethodDescriptor =
          MethodDescriptor.<CreatePhraseMatcherRequest, PhraseMatcher>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreatePhraseMatcher")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreatePhraseMatcherRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhraseMatcher.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetPhraseMatcherRequest, PhraseMatcher>
      getPhraseMatcherMethodDescriptor =
          MethodDescriptor.<GetPhraseMatcherRequest, PhraseMatcher>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetPhraseMatcher")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetPhraseMatcherRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhraseMatcher.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
      listPhraseMatchersMethodDescriptor =
          MethodDescriptor.<ListPhraseMatchersRequest, ListPhraseMatchersResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListPhraseMatchers")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListPhraseMatchersRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListPhraseMatchersResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeletePhraseMatcherRequest, Empty>
      deletePhraseMatcherMethodDescriptor =
          MethodDescriptor.<DeletePhraseMatcherRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeletePhraseMatcher")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeletePhraseMatcherRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdatePhraseMatcherRequest, PhraseMatcher>
      updatePhraseMatcherMethodDescriptor =
          MethodDescriptor.<UpdatePhraseMatcherRequest, PhraseMatcher>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdatePhraseMatcher")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdatePhraseMatcherRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(PhraseMatcher.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CalculateStatsRequest, CalculateStatsResponse>
      calculateStatsMethodDescriptor =
          MethodDescriptor.<CalculateStatsRequest, CalculateStatsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CalculateStats")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CalculateStatsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(CalculateStatsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetSettingsRequest, Settings> getSettingsMethodDescriptor =
      MethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetSettings")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSettingsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<UpdateSettingsRequest, Settings>
      updateSettingsMethodDescriptor =
          MethodDescriptor.<UpdateSettingsRequest, Settings>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateSettings")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateAnalysisRuleRequest, AnalysisRule>
      createAnalysisRuleMethodDescriptor =
          MethodDescriptor.<CreateAnalysisRuleRequest, AnalysisRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateAnalysisRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateAnalysisRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnalysisRule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetAnalysisRuleRequest, AnalysisRule>
      getAnalysisRuleMethodDescriptor =
          MethodDescriptor.<GetAnalysisRuleRequest, AnalysisRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetAnalysisRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetAnalysisRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnalysisRule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAnalysisRulesRequest, ListAnalysisRulesResponse>
      listAnalysisRulesMethodDescriptor =
          MethodDescriptor.<ListAnalysisRulesRequest, ListAnalysisRulesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListAnalysisRules")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAnalysisRulesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAnalysisRulesResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateAnalysisRuleRequest, AnalysisRule>
      updateAnalysisRuleMethodDescriptor =
          MethodDescriptor.<UpdateAnalysisRuleRequest, AnalysisRule>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateAnalysisRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateAnalysisRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(AnalysisRule.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteAnalysisRuleRequest, Empty>
      deleteAnalysisRuleMethodDescriptor =
          MethodDescriptor.<DeleteAnalysisRuleRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteAnalysisRule")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteAnalysisRuleRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetEncryptionSpecRequest, EncryptionSpec>
      getEncryptionSpecMethodDescriptor =
          MethodDescriptor.<GetEncryptionSpecRequest, EncryptionSpec>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetEncryptionSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetEncryptionSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(EncryptionSpec.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecMethodDescriptor =
          MethodDescriptor.<InitializeEncryptionSpecRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/InitializeEncryptionSpec")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(InitializeEncryptionSpecRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateViewRequest, View> createViewMethodDescriptor =
      MethodDescriptor.<CreateViewRequest, View>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateView")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(View.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<GetViewRequest, View> getViewMethodDescriptor =
      MethodDescriptor.<GetViewRequest, View>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetView")
          .setRequestMarshaller(ProtoUtils.marshaller(GetViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(View.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<ListViewsRequest, ListViewsResponse>
      listViewsMethodDescriptor =
          MethodDescriptor.<ListViewsRequest, ListViewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListViews")
              .setRequestMarshaller(ProtoUtils.marshaller(ListViewsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListViewsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateViewRequest, View> updateViewMethodDescriptor =
      MethodDescriptor.<UpdateViewRequest, View>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateView")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(View.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<DeleteViewRequest, Empty> deleteViewMethodDescriptor =
      MethodDescriptor.<DeleteViewRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteView")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .setSampledToLocalTracing(true)
          .build();

  private static final MethodDescriptor<QueryMetricsRequest, Operation>
      queryMetricsMethodDescriptor =
          MethodDescriptor.<QueryMetricsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/QueryMetrics")
              .setRequestMarshaller(ProtoUtils.marshaller(QueryMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateQaQuestionRequest, QaQuestion>
      createQaQuestionMethodDescriptor =
          MethodDescriptor.<CreateQaQuestionRequest, QaQuestion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateQaQuestion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateQaQuestionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QaQuestion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetQaQuestionRequest, QaQuestion>
      getQaQuestionMethodDescriptor =
          MethodDescriptor.<GetQaQuestionRequest, QaQuestion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetQaQuestion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetQaQuestionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QaQuestion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateQaQuestionRequest, QaQuestion>
      updateQaQuestionMethodDescriptor =
          MethodDescriptor.<UpdateQaQuestionRequest, QaQuestion>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateQaQuestion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateQaQuestionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QaQuestion.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteQaQuestionRequest, Empty>
      deleteQaQuestionMethodDescriptor =
          MethodDescriptor.<DeleteQaQuestionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteQaQuestion")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteQaQuestionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListQaQuestionsRequest, ListQaQuestionsResponse>
      listQaQuestionsMethodDescriptor =
          MethodDescriptor.<ListQaQuestionsRequest, ListQaQuestionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListQaQuestions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListQaQuestionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListQaQuestionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateQaScorecardRequest, QaScorecard>
      createQaScorecardMethodDescriptor =
          MethodDescriptor.<CreateQaScorecardRequest, QaScorecard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateQaScorecard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateQaScorecardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QaScorecard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetQaScorecardRequest, QaScorecard>
      getQaScorecardMethodDescriptor =
          MethodDescriptor.<GetQaScorecardRequest, QaScorecard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetQaScorecard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetQaScorecardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QaScorecard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateQaScorecardRequest, QaScorecard>
      updateQaScorecardMethodDescriptor =
          MethodDescriptor.<UpdateQaScorecardRequest, QaScorecard>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateQaScorecard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateQaScorecardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(QaScorecard.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteQaScorecardRequest, Empty>
      deleteQaScorecardMethodDescriptor =
          MethodDescriptor.<DeleteQaScorecardRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteQaScorecard")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteQaScorecardRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListQaScorecardsRequest, ListQaScorecardsResponse>
      listQaScorecardsMethodDescriptor =
          MethodDescriptor.<ListQaScorecardsRequest, ListQaScorecardsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListQaScorecards")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListQaScorecardsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListQaScorecardsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateQaScorecardRevisionRequest, QaScorecardRevision>
      createQaScorecardRevisionMethodDescriptor =
          MethodDescriptor.<CreateQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateQaScorecardRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateQaScorecardRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QaScorecardRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetQaScorecardRevisionRequest, QaScorecardRevision>
      getQaScorecardRevisionMethodDescriptor =
          MethodDescriptor.<GetQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetQaScorecardRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetQaScorecardRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QaScorecardRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<TuneQaScorecardRevisionRequest, Operation>
      tuneQaScorecardRevisionMethodDescriptor =
          MethodDescriptor.<TuneQaScorecardRevisionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/TuneQaScorecardRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(TuneQaScorecardRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeployQaScorecardRevisionRequest, QaScorecardRevision>
      deployQaScorecardRevisionMethodDescriptor =
          MethodDescriptor.<DeployQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeployQaScorecardRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeployQaScorecardRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QaScorecardRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
      undeployQaScorecardRevisionMethodDescriptor =
          MethodDescriptor.<UndeployQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UndeployQaScorecardRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UndeployQaScorecardRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(QaScorecardRevision.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteQaScorecardRevisionRequest, Empty>
      deleteQaScorecardRevisionMethodDescriptor =
          MethodDescriptor.<DeleteQaScorecardRevisionRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteQaScorecardRevision")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteQaScorecardRevisionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<
          ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>
      listQaScorecardRevisionsMethodDescriptor =
          MethodDescriptor
              .<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListQaScorecardRevisions")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListQaScorecardRevisionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListQaScorecardRevisionsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<CreateFeedbackLabelRequest, FeedbackLabel>
      createFeedbackLabelMethodDescriptor =
          MethodDescriptor.<CreateFeedbackLabelRequest, FeedbackLabel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateFeedbackLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateFeedbackLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FeedbackLabel.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>
      listFeedbackLabelsMethodDescriptor =
          MethodDescriptor.<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListFeedbackLabels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListFeedbackLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListFeedbackLabelsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<GetFeedbackLabelRequest, FeedbackLabel>
      getFeedbackLabelMethodDescriptor =
          MethodDescriptor.<GetFeedbackLabelRequest, FeedbackLabel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetFeedbackLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetFeedbackLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FeedbackLabel.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<UpdateFeedbackLabelRequest, FeedbackLabel>
      updateFeedbackLabelMethodDescriptor =
          MethodDescriptor.<UpdateFeedbackLabelRequest, FeedbackLabel>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateFeedbackLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateFeedbackLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(FeedbackLabel.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<DeleteFeedbackLabelRequest, Empty>
      deleteFeedbackLabelMethodDescriptor =
          MethodDescriptor.<DeleteFeedbackLabelRequest, Empty>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteFeedbackLabel")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteFeedbackLabelRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>
      listAllFeedbackLabelsMethodDescriptor =
          MethodDescriptor.<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListAllFeedbackLabels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListAllFeedbackLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListAllFeedbackLabelsResponse.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BulkUploadFeedbackLabelsRequest, Operation>
      bulkUploadFeedbackLabelsMethodDescriptor =
          MethodDescriptor.<BulkUploadFeedbackLabelsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/BulkUploadFeedbackLabels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkUploadFeedbackLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private static final MethodDescriptor<BulkDownloadFeedbackLabelsRequest, Operation>
      bulkDownloadFeedbackLabelsMethodDescriptor =
          MethodDescriptor.<BulkDownloadFeedbackLabelsRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/BulkDownloadFeedbackLabels")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(BulkDownloadFeedbackLabelsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .setSampledToLocalTracing(true)
              .build();

  private final UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable;
  private final UnaryCallable<UploadConversationRequest, Operation> uploadConversationCallable;
  private final OperationCallable<
          UploadConversationRequest, Conversation, UploadConversationMetadata>
      uploadConversationOperationCallable;
  private final UnaryCallable<UpdateConversationRequest, Conversation> updateConversationCallable;
  private final UnaryCallable<GetConversationRequest, Conversation> getConversationCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable;
  private final UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable;
  private final UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable;
  private final UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable;
  private final OperationCallable<CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
      createAnalysisOperationCallable;
  private final UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable;
  private final UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable;
  private final UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse>
      listAnalysesPagedCallable;
  private final UnaryCallable<DeleteAnalysisRequest, Empty> deleteAnalysisCallable;
  private final UnaryCallable<BulkAnalyzeConversationsRequest, Operation>
      bulkAnalyzeConversationsCallable;
  private final OperationCallable<
          BulkAnalyzeConversationsRequest,
          BulkAnalyzeConversationsResponse,
          BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsOperationCallable;
  private final UnaryCallable<BulkDeleteConversationsRequest, Operation>
      bulkDeleteConversationsCallable;
  private final OperationCallable<
          BulkDeleteConversationsRequest,
          BulkDeleteConversationsResponse,
          BulkDeleteConversationsMetadata>
      bulkDeleteConversationsOperationCallable;
  private final UnaryCallable<IngestConversationsRequest, Operation> ingestConversationsCallable;
  private final OperationCallable<
          IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsOperationCallable;
  private final UnaryCallable<ExportInsightsDataRequest, Operation> exportInsightsDataCallable;
  private final OperationCallable<
          ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataOperationCallable;
  private final UnaryCallable<CreateIssueModelRequest, Operation> createIssueModelCallable;
  private final OperationCallable<CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
      createIssueModelOperationCallable;
  private final UnaryCallable<UpdateIssueModelRequest, IssueModel> updateIssueModelCallable;
  private final UnaryCallable<GetIssueModelRequest, IssueModel> getIssueModelCallable;
  private final UnaryCallable<ListIssueModelsRequest, ListIssueModelsResponse>
      listIssueModelsCallable;
  private final UnaryCallable<DeleteIssueModelRequest, Operation> deleteIssueModelCallable;
  private final OperationCallable<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
      deleteIssueModelOperationCallable;
  private final UnaryCallable<DeployIssueModelRequest, Operation> deployIssueModelCallable;
  private final OperationCallable<
          DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelOperationCallable;
  private final UnaryCallable<UndeployIssueModelRequest, Operation> undeployIssueModelCallable;
  private final OperationCallable<
          UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelOperationCallable;
  private final UnaryCallable<ExportIssueModelRequest, Operation> exportIssueModelCallable;
  private final OperationCallable<
          ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelOperationCallable;
  private final UnaryCallable<ImportIssueModelRequest, Operation> importIssueModelCallable;
  private final OperationCallable<
          ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelOperationCallable;
  private final UnaryCallable<GetIssueRequest, Issue> getIssueCallable;
  private final UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable;
  private final UnaryCallable<UpdateIssueRequest, Issue> updateIssueCallable;
  private final UnaryCallable<DeleteIssueRequest, Empty> deleteIssueCallable;
  private final UnaryCallable<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsCallable;
  private final UnaryCallable<CreatePhraseMatcherRequest, PhraseMatcher>
      createPhraseMatcherCallable;
  private final UnaryCallable<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherCallable;
  private final UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
      listPhraseMatchersCallable;
  private final UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersPagedResponse>
      listPhraseMatchersPagedCallable;
  private final UnaryCallable<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherCallable;
  private final UnaryCallable<UpdatePhraseMatcherRequest, PhraseMatcher>
      updatePhraseMatcherCallable;
  private final UnaryCallable<CalculateStatsRequest, CalculateStatsResponse> calculateStatsCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable;
  private final UnaryCallable<CreateAnalysisRuleRequest, AnalysisRule> createAnalysisRuleCallable;
  private final UnaryCallable<GetAnalysisRuleRequest, AnalysisRule> getAnalysisRuleCallable;
  private final UnaryCallable<ListAnalysisRulesRequest, ListAnalysisRulesResponse>
      listAnalysisRulesCallable;
  private final UnaryCallable<ListAnalysisRulesRequest, ListAnalysisRulesPagedResponse>
      listAnalysisRulesPagedCallable;
  private final UnaryCallable<UpdateAnalysisRuleRequest, AnalysisRule> updateAnalysisRuleCallable;
  private final UnaryCallable<DeleteAnalysisRuleRequest, Empty> deleteAnalysisRuleCallable;
  private final UnaryCallable<GetEncryptionSpecRequest, EncryptionSpec> getEncryptionSpecCallable;
  private final UnaryCallable<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecCallable;
  private final OperationCallable<
          InitializeEncryptionSpecRequest,
          InitializeEncryptionSpecResponse,
          InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecOperationCallable;
  private final UnaryCallable<CreateViewRequest, View> createViewCallable;
  private final UnaryCallable<GetViewRequest, View> getViewCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable;
  private final UnaryCallable<UpdateViewRequest, View> updateViewCallable;
  private final UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable;
  private final UnaryCallable<QueryMetricsRequest, Operation> queryMetricsCallable;
  private final OperationCallable<QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
      queryMetricsOperationCallable;
  private final UnaryCallable<CreateQaQuestionRequest, QaQuestion> createQaQuestionCallable;
  private final UnaryCallable<GetQaQuestionRequest, QaQuestion> getQaQuestionCallable;
  private final UnaryCallable<UpdateQaQuestionRequest, QaQuestion> updateQaQuestionCallable;
  private final UnaryCallable<DeleteQaQuestionRequest, Empty> deleteQaQuestionCallable;
  private final UnaryCallable<ListQaQuestionsRequest, ListQaQuestionsResponse>
      listQaQuestionsCallable;
  private final UnaryCallable<ListQaQuestionsRequest, ListQaQuestionsPagedResponse>
      listQaQuestionsPagedCallable;
  private final UnaryCallable<CreateQaScorecardRequest, QaScorecard> createQaScorecardCallable;
  private final UnaryCallable<GetQaScorecardRequest, QaScorecard> getQaScorecardCallable;
  private final UnaryCallable<UpdateQaScorecardRequest, QaScorecard> updateQaScorecardCallable;
  private final UnaryCallable<DeleteQaScorecardRequest, Empty> deleteQaScorecardCallable;
  private final UnaryCallable<ListQaScorecardsRequest, ListQaScorecardsResponse>
      listQaScorecardsCallable;
  private final UnaryCallable<ListQaScorecardsRequest, ListQaScorecardsPagedResponse>
      listQaScorecardsPagedCallable;
  private final UnaryCallable<CreateQaScorecardRevisionRequest, QaScorecardRevision>
      createQaScorecardRevisionCallable;
  private final UnaryCallable<GetQaScorecardRevisionRequest, QaScorecardRevision>
      getQaScorecardRevisionCallable;
  private final UnaryCallable<TuneQaScorecardRevisionRequest, Operation>
      tuneQaScorecardRevisionCallable;
  private final OperationCallable<
          TuneQaScorecardRevisionRequest,
          TuneQaScorecardRevisionResponse,
          TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionOperationCallable;
  private final UnaryCallable<DeployQaScorecardRevisionRequest, QaScorecardRevision>
      deployQaScorecardRevisionCallable;
  private final UnaryCallable<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
      undeployQaScorecardRevisionCallable;
  private final UnaryCallable<DeleteQaScorecardRevisionRequest, Empty>
      deleteQaScorecardRevisionCallable;
  private final UnaryCallable<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>
      listQaScorecardRevisionsCallable;
  private final UnaryCallable<
          ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsPagedResponse>
      listQaScorecardRevisionsPagedCallable;
  private final UnaryCallable<CreateFeedbackLabelRequest, FeedbackLabel>
      createFeedbackLabelCallable;
  private final UnaryCallable<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>
      listFeedbackLabelsCallable;
  private final UnaryCallable<ListFeedbackLabelsRequest, ListFeedbackLabelsPagedResponse>
      listFeedbackLabelsPagedCallable;
  private final UnaryCallable<GetFeedbackLabelRequest, FeedbackLabel> getFeedbackLabelCallable;
  private final UnaryCallable<UpdateFeedbackLabelRequest, FeedbackLabel>
      updateFeedbackLabelCallable;
  private final UnaryCallable<DeleteFeedbackLabelRequest, Empty> deleteFeedbackLabelCallable;
  private final UnaryCallable<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>
      listAllFeedbackLabelsCallable;
  private final UnaryCallable<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsPagedResponse>
      listAllFeedbackLabelsPagedCallable;
  private final UnaryCallable<BulkUploadFeedbackLabelsRequest, Operation>
      bulkUploadFeedbackLabelsCallable;
  private final OperationCallable<
          BulkUploadFeedbackLabelsRequest,
          BulkUploadFeedbackLabelsResponse,
          BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsOperationCallable;
  private final UnaryCallable<BulkDownloadFeedbackLabelsRequest, Operation>
      bulkDownloadFeedbackLabelsCallable;
  private final OperationCallable<
          BulkDownloadFeedbackLabelsRequest,
          BulkDownloadFeedbackLabelsResponse,
          BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsOperationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcContactCenterInsightsStub create(
      ContactCenterInsightsStubSettings settings) throws IOException {
    return new GrpcContactCenterInsightsStub(settings, ClientContext.create(settings));
  }

  public static final GrpcContactCenterInsightsStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcContactCenterInsightsStub(
        ContactCenterInsightsStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcContactCenterInsightsStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcContactCenterInsightsStub(
        ContactCenterInsightsStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcContactCenterInsightsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcContactCenterInsightsStub(
      ContactCenterInsightsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcContactCenterInsightsCallableFactory());
  }

  /**
   * Constructs an instance of GrpcContactCenterInsightsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GrpcContactCenterInsightsStub(
      ContactCenterInsightsStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<CreateConversationRequest, Conversation> createConversationTransportSettings =
        GrpcCallSettings.<CreateConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(createConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UploadConversationRequest, Operation> uploadConversationTransportSettings =
        GrpcCallSettings.<UploadConversationRequest, Operation>newBuilder()
            .setMethodDescriptor(uploadConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateConversationRequest, Conversation> updateConversationTransportSettings =
        GrpcCallSettings.<UpdateConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(updateConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "conversation.name", String.valueOf(request.getConversation().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        GrpcCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            GrpcCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteConversationRequest, Empty> deleteConversationTransportSettings =
        GrpcCallSettings.<DeleteConversationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAnalysisRequest, Operation> createAnalysisTransportSettings =
        GrpcCallSettings.<CreateAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAnalysisRequest, Analysis> getAnalysisTransportSettings =
        GrpcCallSettings.<GetAnalysisRequest, Analysis>newBuilder()
            .setMethodDescriptor(getAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAnalysesRequest, ListAnalysesResponse> listAnalysesTransportSettings =
        GrpcCallSettings.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
            .setMethodDescriptor(listAnalysesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAnalysisRequest, Empty> deleteAnalysisTransportSettings =
        GrpcCallSettings.<DeleteAnalysisRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<BulkAnalyzeConversationsRequest, Operation>
        bulkAnalyzeConversationsTransportSettings =
            GrpcCallSettings.<BulkAnalyzeConversationsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkAnalyzeConversationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BulkDeleteConversationsRequest, Operation>
        bulkDeleteConversationsTransportSettings =
            GrpcCallSettings.<BulkDeleteConversationsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkDeleteConversationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<IngestConversationsRequest, Operation> ingestConversationsTransportSettings =
        GrpcCallSettings.<IngestConversationsRequest, Operation>newBuilder()
            .setMethodDescriptor(ingestConversationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportInsightsDataRequest, Operation> exportInsightsDataTransportSettings =
        GrpcCallSettings.<ExportInsightsDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportInsightsDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateIssueModelRequest, Operation> createIssueModelTransportSettings =
        GrpcCallSettings.<CreateIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateIssueModelRequest, IssueModel> updateIssueModelTransportSettings =
        GrpcCallSettings.<UpdateIssueModelRequest, IssueModel>newBuilder()
            .setMethodDescriptor(updateIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "issue_model.name", String.valueOf(request.getIssueModel().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIssueModelRequest, IssueModel> getIssueModelTransportSettings =
        GrpcCallSettings.<GetIssueModelRequest, IssueModel>newBuilder()
            .setMethodDescriptor(getIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListIssueModelsRequest, ListIssueModelsResponse>
        listIssueModelsTransportSettings =
            GrpcCallSettings.<ListIssueModelsRequest, ListIssueModelsResponse>newBuilder()
                .setMethodDescriptor(listIssueModelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteIssueModelRequest, Operation> deleteIssueModelTransportSettings =
        GrpcCallSettings.<DeleteIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeployIssueModelRequest, Operation> deployIssueModelTransportSettings =
        GrpcCallSettings.<DeployIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deployIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UndeployIssueModelRequest, Operation> undeployIssueModelTransportSettings =
        GrpcCallSettings.<UndeployIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ExportIssueModelRequest, Operation> exportIssueModelTransportSettings =
        GrpcCallSettings.<ExportIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(exportIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ImportIssueModelRequest, Operation> importIssueModelTransportSettings =
        GrpcCallSettings.<ImportIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(importIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetIssueRequest, Issue> getIssueTransportSettings =
        GrpcCallSettings.<GetIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(getIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesTransportSettings =
        GrpcCallSettings.<ListIssuesRequest, ListIssuesResponse>newBuilder()
            .setMethodDescriptor(listIssuesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateIssueRequest, Issue> updateIssueTransportSettings =
        GrpcCallSettings.<UpdateIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(updateIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("issue.name", String.valueOf(request.getIssue().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteIssueRequest, Empty> deleteIssueTransportSettings =
        GrpcCallSettings.<DeleteIssueRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
        calculateIssueModelStatsTransportSettings =
            GrpcCallSettings
                .<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>newBuilder()
                .setMethodDescriptor(calculateIssueModelStatsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("issue_model", String.valueOf(request.getIssueModel()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreatePhraseMatcherRequest, PhraseMatcher>
        createPhraseMatcherTransportSettings =
            GrpcCallSettings.<CreatePhraseMatcherRequest, PhraseMatcher>newBuilder()
                .setMethodDescriptor(createPhraseMatcherMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherTransportSettings =
        GrpcCallSettings.<GetPhraseMatcherRequest, PhraseMatcher>newBuilder()
            .setMethodDescriptor(getPhraseMatcherMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
        listPhraseMatchersTransportSettings =
            GrpcCallSettings.<ListPhraseMatchersRequest, ListPhraseMatchersResponse>newBuilder()
                .setMethodDescriptor(listPhraseMatchersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherTransportSettings =
        GrpcCallSettings.<DeletePhraseMatcherRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePhraseMatcherMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdatePhraseMatcherRequest, PhraseMatcher>
        updatePhraseMatcherTransportSettings =
            GrpcCallSettings.<UpdatePhraseMatcherRequest, PhraseMatcher>newBuilder()
                .setMethodDescriptor(updatePhraseMatcherMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "phrase_matcher.name",
                          String.valueOf(request.getPhraseMatcher().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CalculateStatsRequest, CalculateStatsResponse>
        calculateStatsTransportSettings =
            GrpcCallSettings.<CalculateStatsRequest, CalculateStatsResponse>newBuilder()
                .setMethodDescriptor(calculateStatsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("location", String.valueOf(request.getLocation()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        GrpcCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        GrpcCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("settings.name", String.valueOf(request.getSettings().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateAnalysisRuleRequest, AnalysisRule> createAnalysisRuleTransportSettings =
        GrpcCallSettings.<CreateAnalysisRuleRequest, AnalysisRule>newBuilder()
            .setMethodDescriptor(createAnalysisRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetAnalysisRuleRequest, AnalysisRule> getAnalysisRuleTransportSettings =
        GrpcCallSettings.<GetAnalysisRuleRequest, AnalysisRule>newBuilder()
            .setMethodDescriptor(getAnalysisRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAnalysisRulesRequest, ListAnalysisRulesResponse>
        listAnalysisRulesTransportSettings =
            GrpcCallSettings.<ListAnalysisRulesRequest, ListAnalysisRulesResponse>newBuilder()
                .setMethodDescriptor(listAnalysisRulesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UpdateAnalysisRuleRequest, AnalysisRule> updateAnalysisRuleTransportSettings =
        GrpcCallSettings.<UpdateAnalysisRuleRequest, AnalysisRule>newBuilder()
            .setMethodDescriptor(updateAnalysisRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "analysis_rule.name", String.valueOf(request.getAnalysisRule().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteAnalysisRuleRequest, Empty> deleteAnalysisRuleTransportSettings =
        GrpcCallSettings.<DeleteAnalysisRuleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnalysisRuleMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetEncryptionSpecRequest, EncryptionSpec> getEncryptionSpecTransportSettings =
        GrpcCallSettings.<GetEncryptionSpecRequest, EncryptionSpec>newBuilder()
            .setMethodDescriptor(getEncryptionSpecMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<InitializeEncryptionSpecRequest, Operation>
        initializeEncryptionSpecTransportSettings =
            GrpcCallSettings.<InitializeEncryptionSpecRequest, Operation>newBuilder()
                .setMethodDescriptor(initializeEncryptionSpecMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "encryption_spec.name",
                          String.valueOf(request.getEncryptionSpec().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateViewRequest, View> createViewTransportSettings =
        GrpcCallSettings.<CreateViewRequest, View>newBuilder()
            .setMethodDescriptor(createViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetViewRequest, View> getViewTransportSettings =
        GrpcCallSettings.<GetViewRequest, View>newBuilder()
            .setMethodDescriptor(getViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListViewsRequest, ListViewsResponse> listViewsTransportSettings =
        GrpcCallSettings.<ListViewsRequest, ListViewsResponse>newBuilder()
            .setMethodDescriptor(listViewsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateViewRequest, View> updateViewTransportSettings =
        GrpcCallSettings.<UpdateViewRequest, View>newBuilder()
            .setMethodDescriptor(updateViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("view.name", String.valueOf(request.getView().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteViewRequest, Empty> deleteViewTransportSettings =
        GrpcCallSettings.<DeleteViewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<QueryMetricsRequest, Operation> queryMetricsTransportSettings =
        GrpcCallSettings.<QueryMetricsRequest, Operation>newBuilder()
            .setMethodDescriptor(queryMetricsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("location", String.valueOf(request.getLocation()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateQaQuestionRequest, QaQuestion> createQaQuestionTransportSettings =
        GrpcCallSettings.<CreateQaQuestionRequest, QaQuestion>newBuilder()
            .setMethodDescriptor(createQaQuestionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetQaQuestionRequest, QaQuestion> getQaQuestionTransportSettings =
        GrpcCallSettings.<GetQaQuestionRequest, QaQuestion>newBuilder()
            .setMethodDescriptor(getQaQuestionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateQaQuestionRequest, QaQuestion> updateQaQuestionTransportSettings =
        GrpcCallSettings.<UpdateQaQuestionRequest, QaQuestion>newBuilder()
            .setMethodDescriptor(updateQaQuestionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "qa_question.name", String.valueOf(request.getQaQuestion().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteQaQuestionRequest, Empty> deleteQaQuestionTransportSettings =
        GrpcCallSettings.<DeleteQaQuestionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteQaQuestionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListQaQuestionsRequest, ListQaQuestionsResponse>
        listQaQuestionsTransportSettings =
            GrpcCallSettings.<ListQaQuestionsRequest, ListQaQuestionsResponse>newBuilder()
                .setMethodDescriptor(listQaQuestionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateQaScorecardRequest, QaScorecard> createQaScorecardTransportSettings =
        GrpcCallSettings.<CreateQaScorecardRequest, QaScorecard>newBuilder()
            .setMethodDescriptor(createQaScorecardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetQaScorecardRequest, QaScorecard> getQaScorecardTransportSettings =
        GrpcCallSettings.<GetQaScorecardRequest, QaScorecard>newBuilder()
            .setMethodDescriptor(getQaScorecardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateQaScorecardRequest, QaScorecard> updateQaScorecardTransportSettings =
        GrpcCallSettings.<UpdateQaScorecardRequest, QaScorecard>newBuilder()
            .setMethodDescriptor(updateQaScorecardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "qa_scorecard.name", String.valueOf(request.getQaScorecard().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteQaScorecardRequest, Empty> deleteQaScorecardTransportSettings =
        GrpcCallSettings.<DeleteQaScorecardRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteQaScorecardMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListQaScorecardsRequest, ListQaScorecardsResponse>
        listQaScorecardsTransportSettings =
            GrpcCallSettings.<ListQaScorecardsRequest, ListQaScorecardsResponse>newBuilder()
                .setMethodDescriptor(listQaScorecardsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateQaScorecardRevisionRequest, QaScorecardRevision>
        createQaScorecardRevisionTransportSettings =
            GrpcCallSettings.<CreateQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
                .setMethodDescriptor(createQaScorecardRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetQaScorecardRevisionRequest, QaScorecardRevision>
        getQaScorecardRevisionTransportSettings =
            GrpcCallSettings.<GetQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
                .setMethodDescriptor(getQaScorecardRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<TuneQaScorecardRevisionRequest, Operation>
        tuneQaScorecardRevisionTransportSettings =
            GrpcCallSettings.<TuneQaScorecardRevisionRequest, Operation>newBuilder()
                .setMethodDescriptor(tuneQaScorecardRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeployQaScorecardRevisionRequest, QaScorecardRevision>
        deployQaScorecardRevisionTransportSettings =
            GrpcCallSettings.<DeployQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
                .setMethodDescriptor(deployQaScorecardRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
        undeployQaScorecardRevisionTransportSettings =
            GrpcCallSettings.<UndeployQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
                .setMethodDescriptor(undeployQaScorecardRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteQaScorecardRevisionRequest, Empty>
        deleteQaScorecardRevisionTransportSettings =
            GrpcCallSettings.<DeleteQaScorecardRevisionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteQaScorecardRevisionMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>
        listQaScorecardRevisionsTransportSettings =
            GrpcCallSettings
                .<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>newBuilder()
                .setMethodDescriptor(listQaScorecardRevisionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<CreateFeedbackLabelRequest, FeedbackLabel>
        createFeedbackLabelTransportSettings =
            GrpcCallSettings.<CreateFeedbackLabelRequest, FeedbackLabel>newBuilder()
                .setMethodDescriptor(createFeedbackLabelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>
        listFeedbackLabelsTransportSettings =
            GrpcCallSettings.<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>newBuilder()
                .setMethodDescriptor(listFeedbackLabelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetFeedbackLabelRequest, FeedbackLabel> getFeedbackLabelTransportSettings =
        GrpcCallSettings.<GetFeedbackLabelRequest, FeedbackLabel>newBuilder()
            .setMethodDescriptor(getFeedbackLabelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateFeedbackLabelRequest, FeedbackLabel>
        updateFeedbackLabelTransportSettings =
            GrpcCallSettings.<UpdateFeedbackLabelRequest, FeedbackLabel>newBuilder()
                .setMethodDescriptor(updateFeedbackLabelMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "feedback_label.name",
                          String.valueOf(request.getFeedbackLabel().getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteFeedbackLabelRequest, Empty> deleteFeedbackLabelTransportSettings =
        GrpcCallSettings.<DeleteFeedbackLabelRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFeedbackLabelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>
        listAllFeedbackLabelsTransportSettings =
            GrpcCallSettings
                .<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>newBuilder()
                .setMethodDescriptor(listAllFeedbackLabelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BulkUploadFeedbackLabelsRequest, Operation>
        bulkUploadFeedbackLabelsTransportSettings =
            GrpcCallSettings.<BulkUploadFeedbackLabelsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkUploadFeedbackLabelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<BulkDownloadFeedbackLabelsRequest, Operation>
        bulkDownloadFeedbackLabelsTransportSettings =
            GrpcCallSettings.<BulkDownloadFeedbackLabelsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkDownloadFeedbackLabelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.createConversationCallable =
        callableFactory.createUnaryCallable(
            createConversationTransportSettings,
            settings.createConversationSettings(),
            clientContext);
    this.uploadConversationCallable =
        callableFactory.createUnaryCallable(
            uploadConversationTransportSettings,
            settings.uploadConversationSettings(),
            clientContext);
    this.uploadConversationOperationCallable =
        callableFactory.createOperationCallable(
            uploadConversationTransportSettings,
            settings.uploadConversationOperationSettings(),
            clientContext,
            operationsStub);
    this.updateConversationCallable =
        callableFactory.createUnaryCallable(
            updateConversationTransportSettings,
            settings.updateConversationSettings(),
            clientContext);
    this.getConversationCallable =
        callableFactory.createUnaryCallable(
            getConversationTransportSettings, settings.getConversationSettings(), clientContext);
    this.listConversationsCallable =
        callableFactory.createUnaryCallable(
            listConversationsTransportSettings,
            settings.listConversationsSettings(),
            clientContext);
    this.listConversationsPagedCallable =
        callableFactory.createPagedCallable(
            listConversationsTransportSettings,
            settings.listConversationsSettings(),
            clientContext);
    this.deleteConversationCallable =
        callableFactory.createUnaryCallable(
            deleteConversationTransportSettings,
            settings.deleteConversationSettings(),
            clientContext);
    this.createAnalysisCallable =
        callableFactory.createUnaryCallable(
            createAnalysisTransportSettings, settings.createAnalysisSettings(), clientContext);
    this.createAnalysisOperationCallable =
        callableFactory.createOperationCallable(
            createAnalysisTransportSettings,
            settings.createAnalysisOperationSettings(),
            clientContext,
            operationsStub);
    this.getAnalysisCallable =
        callableFactory.createUnaryCallable(
            getAnalysisTransportSettings, settings.getAnalysisSettings(), clientContext);
    this.listAnalysesCallable =
        callableFactory.createUnaryCallable(
            listAnalysesTransportSettings, settings.listAnalysesSettings(), clientContext);
    this.listAnalysesPagedCallable =
        callableFactory.createPagedCallable(
            listAnalysesTransportSettings, settings.listAnalysesSettings(), clientContext);
    this.deleteAnalysisCallable =
        callableFactory.createUnaryCallable(
            deleteAnalysisTransportSettings, settings.deleteAnalysisSettings(), clientContext);
    this.bulkAnalyzeConversationsCallable =
        callableFactory.createUnaryCallable(
            bulkAnalyzeConversationsTransportSettings,
            settings.bulkAnalyzeConversationsSettings(),
            clientContext);
    this.bulkAnalyzeConversationsOperationCallable =
        callableFactory.createOperationCallable(
            bulkAnalyzeConversationsTransportSettings,
            settings.bulkAnalyzeConversationsOperationSettings(),
            clientContext,
            operationsStub);
    this.bulkDeleteConversationsCallable =
        callableFactory.createUnaryCallable(
            bulkDeleteConversationsTransportSettings,
            settings.bulkDeleteConversationsSettings(),
            clientContext);
    this.bulkDeleteConversationsOperationCallable =
        callableFactory.createOperationCallable(
            bulkDeleteConversationsTransportSettings,
            settings.bulkDeleteConversationsOperationSettings(),
            clientContext,
            operationsStub);
    this.ingestConversationsCallable =
        callableFactory.createUnaryCallable(
            ingestConversationsTransportSettings,
            settings.ingestConversationsSettings(),
            clientContext);
    this.ingestConversationsOperationCallable =
        callableFactory.createOperationCallable(
            ingestConversationsTransportSettings,
            settings.ingestConversationsOperationSettings(),
            clientContext,
            operationsStub);
    this.exportInsightsDataCallable =
        callableFactory.createUnaryCallable(
            exportInsightsDataTransportSettings,
            settings.exportInsightsDataSettings(),
            clientContext);
    this.exportInsightsDataOperationCallable =
        callableFactory.createOperationCallable(
            exportInsightsDataTransportSettings,
            settings.exportInsightsDataOperationSettings(),
            clientContext,
            operationsStub);
    this.createIssueModelCallable =
        callableFactory.createUnaryCallable(
            createIssueModelTransportSettings, settings.createIssueModelSettings(), clientContext);
    this.createIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            createIssueModelTransportSettings,
            settings.createIssueModelOperationSettings(),
            clientContext,
            operationsStub);
    this.updateIssueModelCallable =
        callableFactory.createUnaryCallable(
            updateIssueModelTransportSettings, settings.updateIssueModelSettings(), clientContext);
    this.getIssueModelCallable =
        callableFactory.createUnaryCallable(
            getIssueModelTransportSettings, settings.getIssueModelSettings(), clientContext);
    this.listIssueModelsCallable =
        callableFactory.createUnaryCallable(
            listIssueModelsTransportSettings, settings.listIssueModelsSettings(), clientContext);
    this.deleteIssueModelCallable =
        callableFactory.createUnaryCallable(
            deleteIssueModelTransportSettings, settings.deleteIssueModelSettings(), clientContext);
    this.deleteIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            deleteIssueModelTransportSettings,
            settings.deleteIssueModelOperationSettings(),
            clientContext,
            operationsStub);
    this.deployIssueModelCallable =
        callableFactory.createUnaryCallable(
            deployIssueModelTransportSettings, settings.deployIssueModelSettings(), clientContext);
    this.deployIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            deployIssueModelTransportSettings,
            settings.deployIssueModelOperationSettings(),
            clientContext,
            operationsStub);
    this.undeployIssueModelCallable =
        callableFactory.createUnaryCallable(
            undeployIssueModelTransportSettings,
            settings.undeployIssueModelSettings(),
            clientContext);
    this.undeployIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            undeployIssueModelTransportSettings,
            settings.undeployIssueModelOperationSettings(),
            clientContext,
            operationsStub);
    this.exportIssueModelCallable =
        callableFactory.createUnaryCallable(
            exportIssueModelTransportSettings, settings.exportIssueModelSettings(), clientContext);
    this.exportIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            exportIssueModelTransportSettings,
            settings.exportIssueModelOperationSettings(),
            clientContext,
            operationsStub);
    this.importIssueModelCallable =
        callableFactory.createUnaryCallable(
            importIssueModelTransportSettings, settings.importIssueModelSettings(), clientContext);
    this.importIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            importIssueModelTransportSettings,
            settings.importIssueModelOperationSettings(),
            clientContext,
            operationsStub);
    this.getIssueCallable =
        callableFactory.createUnaryCallable(
            getIssueTransportSettings, settings.getIssueSettings(), clientContext);
    this.listIssuesCallable =
        callableFactory.createUnaryCallable(
            listIssuesTransportSettings, settings.listIssuesSettings(), clientContext);
    this.updateIssueCallable =
        callableFactory.createUnaryCallable(
            updateIssueTransportSettings, settings.updateIssueSettings(), clientContext);
    this.deleteIssueCallable =
        callableFactory.createUnaryCallable(
            deleteIssueTransportSettings, settings.deleteIssueSettings(), clientContext);
    this.calculateIssueModelStatsCallable =
        callableFactory.createUnaryCallable(
            calculateIssueModelStatsTransportSettings,
            settings.calculateIssueModelStatsSettings(),
            clientContext);
    this.createPhraseMatcherCallable =
        callableFactory.createUnaryCallable(
            createPhraseMatcherTransportSettings,
            settings.createPhraseMatcherSettings(),
            clientContext);
    this.getPhraseMatcherCallable =
        callableFactory.createUnaryCallable(
            getPhraseMatcherTransportSettings, settings.getPhraseMatcherSettings(), clientContext);
    this.listPhraseMatchersCallable =
        callableFactory.createUnaryCallable(
            listPhraseMatchersTransportSettings,
            settings.listPhraseMatchersSettings(),
            clientContext);
    this.listPhraseMatchersPagedCallable =
        callableFactory.createPagedCallable(
            listPhraseMatchersTransportSettings,
            settings.listPhraseMatchersSettings(),
            clientContext);
    this.deletePhraseMatcherCallable =
        callableFactory.createUnaryCallable(
            deletePhraseMatcherTransportSettings,
            settings.deletePhraseMatcherSettings(),
            clientContext);
    this.updatePhraseMatcherCallable =
        callableFactory.createUnaryCallable(
            updatePhraseMatcherTransportSettings,
            settings.updatePhraseMatcherSettings(),
            clientContext);
    this.calculateStatsCallable =
        callableFactory.createUnaryCallable(
            calculateStatsTransportSettings, settings.calculateStatsSettings(), clientContext);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);
    this.createAnalysisRuleCallable =
        callableFactory.createUnaryCallable(
            createAnalysisRuleTransportSettings,
            settings.createAnalysisRuleSettings(),
            clientContext);
    this.getAnalysisRuleCallable =
        callableFactory.createUnaryCallable(
            getAnalysisRuleTransportSettings, settings.getAnalysisRuleSettings(), clientContext);
    this.listAnalysisRulesCallable =
        callableFactory.createUnaryCallable(
            listAnalysisRulesTransportSettings,
            settings.listAnalysisRulesSettings(),
            clientContext);
    this.listAnalysisRulesPagedCallable =
        callableFactory.createPagedCallable(
            listAnalysisRulesTransportSettings,
            settings.listAnalysisRulesSettings(),
            clientContext);
    this.updateAnalysisRuleCallable =
        callableFactory.createUnaryCallable(
            updateAnalysisRuleTransportSettings,
            settings.updateAnalysisRuleSettings(),
            clientContext);
    this.deleteAnalysisRuleCallable =
        callableFactory.createUnaryCallable(
            deleteAnalysisRuleTransportSettings,
            settings.deleteAnalysisRuleSettings(),
            clientContext);
    this.getEncryptionSpecCallable =
        callableFactory.createUnaryCallable(
            getEncryptionSpecTransportSettings,
            settings.getEncryptionSpecSettings(),
            clientContext);
    this.initializeEncryptionSpecCallable =
        callableFactory.createUnaryCallable(
            initializeEncryptionSpecTransportSettings,
            settings.initializeEncryptionSpecSettings(),
            clientContext);
    this.initializeEncryptionSpecOperationCallable =
        callableFactory.createOperationCallable(
            initializeEncryptionSpecTransportSettings,
            settings.initializeEncryptionSpecOperationSettings(),
            clientContext,
            operationsStub);
    this.createViewCallable =
        callableFactory.createUnaryCallable(
            createViewTransportSettings, settings.createViewSettings(), clientContext);
    this.getViewCallable =
        callableFactory.createUnaryCallable(
            getViewTransportSettings, settings.getViewSettings(), clientContext);
    this.listViewsCallable =
        callableFactory.createUnaryCallable(
            listViewsTransportSettings, settings.listViewsSettings(), clientContext);
    this.listViewsPagedCallable =
        callableFactory.createPagedCallable(
            listViewsTransportSettings, settings.listViewsSettings(), clientContext);
    this.updateViewCallable =
        callableFactory.createUnaryCallable(
            updateViewTransportSettings, settings.updateViewSettings(), clientContext);
    this.deleteViewCallable =
        callableFactory.createUnaryCallable(
            deleteViewTransportSettings, settings.deleteViewSettings(), clientContext);
    this.queryMetricsCallable =
        callableFactory.createUnaryCallable(
            queryMetricsTransportSettings, settings.queryMetricsSettings(), clientContext);
    this.queryMetricsOperationCallable =
        callableFactory.createOperationCallable(
            queryMetricsTransportSettings,
            settings.queryMetricsOperationSettings(),
            clientContext,
            operationsStub);
    this.createQaQuestionCallable =
        callableFactory.createUnaryCallable(
            createQaQuestionTransportSettings, settings.createQaQuestionSettings(), clientContext);
    this.getQaQuestionCallable =
        callableFactory.createUnaryCallable(
            getQaQuestionTransportSettings, settings.getQaQuestionSettings(), clientContext);
    this.updateQaQuestionCallable =
        callableFactory.createUnaryCallable(
            updateQaQuestionTransportSettings, settings.updateQaQuestionSettings(), clientContext);
    this.deleteQaQuestionCallable =
        callableFactory.createUnaryCallable(
            deleteQaQuestionTransportSettings, settings.deleteQaQuestionSettings(), clientContext);
    this.listQaQuestionsCallable =
        callableFactory.createUnaryCallable(
            listQaQuestionsTransportSettings, settings.listQaQuestionsSettings(), clientContext);
    this.listQaQuestionsPagedCallable =
        callableFactory.createPagedCallable(
            listQaQuestionsTransportSettings, settings.listQaQuestionsSettings(), clientContext);
    this.createQaScorecardCallable =
        callableFactory.createUnaryCallable(
            createQaScorecardTransportSettings,
            settings.createQaScorecardSettings(),
            clientContext);
    this.getQaScorecardCallable =
        callableFactory.createUnaryCallable(
            getQaScorecardTransportSettings, settings.getQaScorecardSettings(), clientContext);
    this.updateQaScorecardCallable =
        callableFactory.createUnaryCallable(
            updateQaScorecardTransportSettings,
            settings.updateQaScorecardSettings(),
            clientContext);
    this.deleteQaScorecardCallable =
        callableFactory.createUnaryCallable(
            deleteQaScorecardTransportSettings,
            settings.deleteQaScorecardSettings(),
            clientContext);
    this.listQaScorecardsCallable =
        callableFactory.createUnaryCallable(
            listQaScorecardsTransportSettings, settings.listQaScorecardsSettings(), clientContext);
    this.listQaScorecardsPagedCallable =
        callableFactory.createPagedCallable(
            listQaScorecardsTransportSettings, settings.listQaScorecardsSettings(), clientContext);
    this.createQaScorecardRevisionCallable =
        callableFactory.createUnaryCallable(
            createQaScorecardRevisionTransportSettings,
            settings.createQaScorecardRevisionSettings(),
            clientContext);
    this.getQaScorecardRevisionCallable =
        callableFactory.createUnaryCallable(
            getQaScorecardRevisionTransportSettings,
            settings.getQaScorecardRevisionSettings(),
            clientContext);
    this.tuneQaScorecardRevisionCallable =
        callableFactory.createUnaryCallable(
            tuneQaScorecardRevisionTransportSettings,
            settings.tuneQaScorecardRevisionSettings(),
            clientContext);
    this.tuneQaScorecardRevisionOperationCallable =
        callableFactory.createOperationCallable(
            tuneQaScorecardRevisionTransportSettings,
            settings.tuneQaScorecardRevisionOperationSettings(),
            clientContext,
            operationsStub);
    this.deployQaScorecardRevisionCallable =
        callableFactory.createUnaryCallable(
            deployQaScorecardRevisionTransportSettings,
            settings.deployQaScorecardRevisionSettings(),
            clientContext);
    this.undeployQaScorecardRevisionCallable =
        callableFactory.createUnaryCallable(
            undeployQaScorecardRevisionTransportSettings,
            settings.undeployQaScorecardRevisionSettings(),
            clientContext);
    this.deleteQaScorecardRevisionCallable =
        callableFactory.createUnaryCallable(
            deleteQaScorecardRevisionTransportSettings,
            settings.deleteQaScorecardRevisionSettings(),
            clientContext);
    this.listQaScorecardRevisionsCallable =
        callableFactory.createUnaryCallable(
            listQaScorecardRevisionsTransportSettings,
            settings.listQaScorecardRevisionsSettings(),
            clientContext);
    this.listQaScorecardRevisionsPagedCallable =
        callableFactory.createPagedCallable(
            listQaScorecardRevisionsTransportSettings,
            settings.listQaScorecardRevisionsSettings(),
            clientContext);
    this.createFeedbackLabelCallable =
        callableFactory.createUnaryCallable(
            createFeedbackLabelTransportSettings,
            settings.createFeedbackLabelSettings(),
            clientContext);
    this.listFeedbackLabelsCallable =
        callableFactory.createUnaryCallable(
            listFeedbackLabelsTransportSettings,
            settings.listFeedbackLabelsSettings(),
            clientContext);
    this.listFeedbackLabelsPagedCallable =
        callableFactory.createPagedCallable(
            listFeedbackLabelsTransportSettings,
            settings.listFeedbackLabelsSettings(),
            clientContext);
    this.getFeedbackLabelCallable =
        callableFactory.createUnaryCallable(
            getFeedbackLabelTransportSettings, settings.getFeedbackLabelSettings(), clientContext);
    this.updateFeedbackLabelCallable =
        callableFactory.createUnaryCallable(
            updateFeedbackLabelTransportSettings,
            settings.updateFeedbackLabelSettings(),
            clientContext);
    this.deleteFeedbackLabelCallable =
        callableFactory.createUnaryCallable(
            deleteFeedbackLabelTransportSettings,
            settings.deleteFeedbackLabelSettings(),
            clientContext);
    this.listAllFeedbackLabelsCallable =
        callableFactory.createUnaryCallable(
            listAllFeedbackLabelsTransportSettings,
            settings.listAllFeedbackLabelsSettings(),
            clientContext);
    this.listAllFeedbackLabelsPagedCallable =
        callableFactory.createPagedCallable(
            listAllFeedbackLabelsTransportSettings,
            settings.listAllFeedbackLabelsSettings(),
            clientContext);
    this.bulkUploadFeedbackLabelsCallable =
        callableFactory.createUnaryCallable(
            bulkUploadFeedbackLabelsTransportSettings,
            settings.bulkUploadFeedbackLabelsSettings(),
            clientContext);
    this.bulkUploadFeedbackLabelsOperationCallable =
        callableFactory.createOperationCallable(
            bulkUploadFeedbackLabelsTransportSettings,
            settings.bulkUploadFeedbackLabelsOperationSettings(),
            clientContext,
            operationsStub);
    this.bulkDownloadFeedbackLabelsCallable =
        callableFactory.createUnaryCallable(
            bulkDownloadFeedbackLabelsTransportSettings,
            settings.bulkDownloadFeedbackLabelsSettings(),
            clientContext);
    this.bulkDownloadFeedbackLabelsOperationCallable =
        callableFactory.createOperationCallable(
            bulkDownloadFeedbackLabelsTransportSettings,
            settings.bulkDownloadFeedbackLabelsOperationSettings(),
            clientContext,
            operationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable() {
    return createConversationCallable;
  }

  @Override
  public UnaryCallable<UploadConversationRequest, Operation> uploadConversationCallable() {
    return uploadConversationCallable;
  }

  @Override
  public OperationCallable<UploadConversationRequest, Conversation, UploadConversationMetadata>
      uploadConversationOperationCallable() {
    return uploadConversationOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConversationRequest, Conversation> updateConversationCallable() {
    return updateConversationCallable;
  }

  @Override
  public UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    return getConversationCallable;
  }

  @Override
  public UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    return listConversationsCallable;
  }

  @Override
  public UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    return listConversationsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable() {
    return deleteConversationCallable;
  }

  @Override
  public UnaryCallable<CreateAnalysisRequest, Operation> createAnalysisCallable() {
    return createAnalysisCallable;
  }

  @Override
  public OperationCallable<CreateAnalysisRequest, Analysis, CreateAnalysisOperationMetadata>
      createAnalysisOperationCallable() {
    return createAnalysisOperationCallable;
  }

  @Override
  public UnaryCallable<GetAnalysisRequest, Analysis> getAnalysisCallable() {
    return getAnalysisCallable;
  }

  @Override
  public UnaryCallable<ListAnalysesRequest, ListAnalysesResponse> listAnalysesCallable() {
    return listAnalysesCallable;
  }

  @Override
  public UnaryCallable<ListAnalysesRequest, ListAnalysesPagedResponse> listAnalysesPagedCallable() {
    return listAnalysesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteAnalysisRequest, Empty> deleteAnalysisCallable() {
    return deleteAnalysisCallable;
  }

  @Override
  public UnaryCallable<BulkAnalyzeConversationsRequest, Operation>
      bulkAnalyzeConversationsCallable() {
    return bulkAnalyzeConversationsCallable;
  }

  @Override
  public OperationCallable<
          BulkAnalyzeConversationsRequest,
          BulkAnalyzeConversationsResponse,
          BulkAnalyzeConversationsMetadata>
      bulkAnalyzeConversationsOperationCallable() {
    return bulkAnalyzeConversationsOperationCallable;
  }

  @Override
  public UnaryCallable<BulkDeleteConversationsRequest, Operation>
      bulkDeleteConversationsCallable() {
    return bulkDeleteConversationsCallable;
  }

  @Override
  public OperationCallable<
          BulkDeleteConversationsRequest,
          BulkDeleteConversationsResponse,
          BulkDeleteConversationsMetadata>
      bulkDeleteConversationsOperationCallable() {
    return bulkDeleteConversationsOperationCallable;
  }

  @Override
  public UnaryCallable<IngestConversationsRequest, Operation> ingestConversationsCallable() {
    return ingestConversationsCallable;
  }

  @Override
  public OperationCallable<
          IngestConversationsRequest, IngestConversationsResponse, IngestConversationsMetadata>
      ingestConversationsOperationCallable() {
    return ingestConversationsOperationCallable;
  }

  @Override
  public UnaryCallable<ExportInsightsDataRequest, Operation> exportInsightsDataCallable() {
    return exportInsightsDataCallable;
  }

  @Override
  public OperationCallable<
          ExportInsightsDataRequest, ExportInsightsDataResponse, ExportInsightsDataMetadata>
      exportInsightsDataOperationCallable() {
    return exportInsightsDataOperationCallable;
  }

  @Override
  public UnaryCallable<CreateIssueModelRequest, Operation> createIssueModelCallable() {
    return createIssueModelCallable;
  }

  @Override
  public OperationCallable<CreateIssueModelRequest, IssueModel, CreateIssueModelMetadata>
      createIssueModelOperationCallable() {
    return createIssueModelOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateIssueModelRequest, IssueModel> updateIssueModelCallable() {
    return updateIssueModelCallable;
  }

  @Override
  public UnaryCallable<GetIssueModelRequest, IssueModel> getIssueModelCallable() {
    return getIssueModelCallable;
  }

  @Override
  public UnaryCallable<ListIssueModelsRequest, ListIssueModelsResponse> listIssueModelsCallable() {
    return listIssueModelsCallable;
  }

  @Override
  public UnaryCallable<DeleteIssueModelRequest, Operation> deleteIssueModelCallable() {
    return deleteIssueModelCallable;
  }

  @Override
  public OperationCallable<DeleteIssueModelRequest, Empty, DeleteIssueModelMetadata>
      deleteIssueModelOperationCallable() {
    return deleteIssueModelOperationCallable;
  }

  @Override
  public UnaryCallable<DeployIssueModelRequest, Operation> deployIssueModelCallable() {
    return deployIssueModelCallable;
  }

  @Override
  public OperationCallable<
          DeployIssueModelRequest, DeployIssueModelResponse, DeployIssueModelMetadata>
      deployIssueModelOperationCallable() {
    return deployIssueModelOperationCallable;
  }

  @Override
  public UnaryCallable<UndeployIssueModelRequest, Operation> undeployIssueModelCallable() {
    return undeployIssueModelCallable;
  }

  @Override
  public OperationCallable<
          UndeployIssueModelRequest, UndeployIssueModelResponse, UndeployIssueModelMetadata>
      undeployIssueModelOperationCallable() {
    return undeployIssueModelOperationCallable;
  }

  @Override
  public UnaryCallable<ExportIssueModelRequest, Operation> exportIssueModelCallable() {
    return exportIssueModelCallable;
  }

  @Override
  public OperationCallable<
          ExportIssueModelRequest, ExportIssueModelResponse, ExportIssueModelMetadata>
      exportIssueModelOperationCallable() {
    return exportIssueModelOperationCallable;
  }

  @Override
  public UnaryCallable<ImportIssueModelRequest, Operation> importIssueModelCallable() {
    return importIssueModelCallable;
  }

  @Override
  public OperationCallable<
          ImportIssueModelRequest, ImportIssueModelResponse, ImportIssueModelMetadata>
      importIssueModelOperationCallable() {
    return importIssueModelOperationCallable;
  }

  @Override
  public UnaryCallable<GetIssueRequest, Issue> getIssueCallable() {
    return getIssueCallable;
  }

  @Override
  public UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable() {
    return listIssuesCallable;
  }

  @Override
  public UnaryCallable<UpdateIssueRequest, Issue> updateIssueCallable() {
    return updateIssueCallable;
  }

  @Override
  public UnaryCallable<DeleteIssueRequest, Empty> deleteIssueCallable() {
    return deleteIssueCallable;
  }

  @Override
  public UnaryCallable<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsCallable() {
    return calculateIssueModelStatsCallable;
  }

  @Override
  public UnaryCallable<CreatePhraseMatcherRequest, PhraseMatcher> createPhraseMatcherCallable() {
    return createPhraseMatcherCallable;
  }

  @Override
  public UnaryCallable<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherCallable() {
    return getPhraseMatcherCallable;
  }

  @Override
  public UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
      listPhraseMatchersCallable() {
    return listPhraseMatchersCallable;
  }

  @Override
  public UnaryCallable<ListPhraseMatchersRequest, ListPhraseMatchersPagedResponse>
      listPhraseMatchersPagedCallable() {
    return listPhraseMatchersPagedCallable;
  }

  @Override
  public UnaryCallable<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherCallable() {
    return deletePhraseMatcherCallable;
  }

  @Override
  public UnaryCallable<UpdatePhraseMatcherRequest, PhraseMatcher> updatePhraseMatcherCallable() {
    return updatePhraseMatcherCallable;
  }

  @Override
  public UnaryCallable<CalculateStatsRequest, CalculateStatsResponse> calculateStatsCallable() {
    return calculateStatsCallable;
  }

  @Override
  public UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable() {
    return getSettingsCallable;
  }

  @Override
  public UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable() {
    return updateSettingsCallable;
  }

  @Override
  public UnaryCallable<CreateAnalysisRuleRequest, AnalysisRule> createAnalysisRuleCallable() {
    return createAnalysisRuleCallable;
  }

  @Override
  public UnaryCallable<GetAnalysisRuleRequest, AnalysisRule> getAnalysisRuleCallable() {
    return getAnalysisRuleCallable;
  }

  @Override
  public UnaryCallable<ListAnalysisRulesRequest, ListAnalysisRulesResponse>
      listAnalysisRulesCallable() {
    return listAnalysisRulesCallable;
  }

  @Override
  public UnaryCallable<ListAnalysisRulesRequest, ListAnalysisRulesPagedResponse>
      listAnalysisRulesPagedCallable() {
    return listAnalysisRulesPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateAnalysisRuleRequest, AnalysisRule> updateAnalysisRuleCallable() {
    return updateAnalysisRuleCallable;
  }

  @Override
  public UnaryCallable<DeleteAnalysisRuleRequest, Empty> deleteAnalysisRuleCallable() {
    return deleteAnalysisRuleCallable;
  }

  @Override
  public UnaryCallable<GetEncryptionSpecRequest, EncryptionSpec> getEncryptionSpecCallable() {
    return getEncryptionSpecCallable;
  }

  @Override
  public UnaryCallable<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecCallable() {
    return initializeEncryptionSpecCallable;
  }

  @Override
  public OperationCallable<
          InitializeEncryptionSpecRequest,
          InitializeEncryptionSpecResponse,
          InitializeEncryptionSpecMetadata>
      initializeEncryptionSpecOperationCallable() {
    return initializeEncryptionSpecOperationCallable;
  }

  @Override
  public UnaryCallable<CreateViewRequest, View> createViewCallable() {
    return createViewCallable;
  }

  @Override
  public UnaryCallable<GetViewRequest, View> getViewCallable() {
    return getViewCallable;
  }

  @Override
  public UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable() {
    return listViewsCallable;
  }

  @Override
  public UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable() {
    return listViewsPagedCallable;
  }

  @Override
  public UnaryCallable<UpdateViewRequest, View> updateViewCallable() {
    return updateViewCallable;
  }

  @Override
  public UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable() {
    return deleteViewCallable;
  }

  @Override
  public UnaryCallable<QueryMetricsRequest, Operation> queryMetricsCallable() {
    return queryMetricsCallable;
  }

  @Override
  public OperationCallable<QueryMetricsRequest, QueryMetricsResponse, QueryMetricsMetadata>
      queryMetricsOperationCallable() {
    return queryMetricsOperationCallable;
  }

  @Override
  public UnaryCallable<CreateQaQuestionRequest, QaQuestion> createQaQuestionCallable() {
    return createQaQuestionCallable;
  }

  @Override
  public UnaryCallable<GetQaQuestionRequest, QaQuestion> getQaQuestionCallable() {
    return getQaQuestionCallable;
  }

  @Override
  public UnaryCallable<UpdateQaQuestionRequest, QaQuestion> updateQaQuestionCallable() {
    return updateQaQuestionCallable;
  }

  @Override
  public UnaryCallable<DeleteQaQuestionRequest, Empty> deleteQaQuestionCallable() {
    return deleteQaQuestionCallable;
  }

  @Override
  public UnaryCallable<ListQaQuestionsRequest, ListQaQuestionsResponse> listQaQuestionsCallable() {
    return listQaQuestionsCallable;
  }

  @Override
  public UnaryCallable<ListQaQuestionsRequest, ListQaQuestionsPagedResponse>
      listQaQuestionsPagedCallable() {
    return listQaQuestionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateQaScorecardRequest, QaScorecard> createQaScorecardCallable() {
    return createQaScorecardCallable;
  }

  @Override
  public UnaryCallable<GetQaScorecardRequest, QaScorecard> getQaScorecardCallable() {
    return getQaScorecardCallable;
  }

  @Override
  public UnaryCallable<UpdateQaScorecardRequest, QaScorecard> updateQaScorecardCallable() {
    return updateQaScorecardCallable;
  }

  @Override
  public UnaryCallable<DeleteQaScorecardRequest, Empty> deleteQaScorecardCallable() {
    return deleteQaScorecardCallable;
  }

  @Override
  public UnaryCallable<ListQaScorecardsRequest, ListQaScorecardsResponse>
      listQaScorecardsCallable() {
    return listQaScorecardsCallable;
  }

  @Override
  public UnaryCallable<ListQaScorecardsRequest, ListQaScorecardsPagedResponse>
      listQaScorecardsPagedCallable() {
    return listQaScorecardsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateQaScorecardRevisionRequest, QaScorecardRevision>
      createQaScorecardRevisionCallable() {
    return createQaScorecardRevisionCallable;
  }

  @Override
  public UnaryCallable<GetQaScorecardRevisionRequest, QaScorecardRevision>
      getQaScorecardRevisionCallable() {
    return getQaScorecardRevisionCallable;
  }

  @Override
  public UnaryCallable<TuneQaScorecardRevisionRequest, Operation>
      tuneQaScorecardRevisionCallable() {
    return tuneQaScorecardRevisionCallable;
  }

  @Override
  public OperationCallable<
          TuneQaScorecardRevisionRequest,
          TuneQaScorecardRevisionResponse,
          TuneQaScorecardRevisionMetadata>
      tuneQaScorecardRevisionOperationCallable() {
    return tuneQaScorecardRevisionOperationCallable;
  }

  @Override
  public UnaryCallable<DeployQaScorecardRevisionRequest, QaScorecardRevision>
      deployQaScorecardRevisionCallable() {
    return deployQaScorecardRevisionCallable;
  }

  @Override
  public UnaryCallable<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
      undeployQaScorecardRevisionCallable() {
    return undeployQaScorecardRevisionCallable;
  }

  @Override
  public UnaryCallable<DeleteQaScorecardRevisionRequest, Empty>
      deleteQaScorecardRevisionCallable() {
    return deleteQaScorecardRevisionCallable;
  }

  @Override
  public UnaryCallable<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>
      listQaScorecardRevisionsCallable() {
    return listQaScorecardRevisionsCallable;
  }

  @Override
  public UnaryCallable<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsPagedResponse>
      listQaScorecardRevisionsPagedCallable() {
    return listQaScorecardRevisionsPagedCallable;
  }

  @Override
  public UnaryCallable<CreateFeedbackLabelRequest, FeedbackLabel> createFeedbackLabelCallable() {
    return createFeedbackLabelCallable;
  }

  @Override
  public UnaryCallable<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>
      listFeedbackLabelsCallable() {
    return listFeedbackLabelsCallable;
  }

  @Override
  public UnaryCallable<ListFeedbackLabelsRequest, ListFeedbackLabelsPagedResponse>
      listFeedbackLabelsPagedCallable() {
    return listFeedbackLabelsPagedCallable;
  }

  @Override
  public UnaryCallable<GetFeedbackLabelRequest, FeedbackLabel> getFeedbackLabelCallable() {
    return getFeedbackLabelCallable;
  }

  @Override
  public UnaryCallable<UpdateFeedbackLabelRequest, FeedbackLabel> updateFeedbackLabelCallable() {
    return updateFeedbackLabelCallable;
  }

  @Override
  public UnaryCallable<DeleteFeedbackLabelRequest, Empty> deleteFeedbackLabelCallable() {
    return deleteFeedbackLabelCallable;
  }

  @Override
  public UnaryCallable<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>
      listAllFeedbackLabelsCallable() {
    return listAllFeedbackLabelsCallable;
  }

  @Override
  public UnaryCallable<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsPagedResponse>
      listAllFeedbackLabelsPagedCallable() {
    return listAllFeedbackLabelsPagedCallable;
  }

  @Override
  public UnaryCallable<BulkUploadFeedbackLabelsRequest, Operation>
      bulkUploadFeedbackLabelsCallable() {
    return bulkUploadFeedbackLabelsCallable;
  }

  @Override
  public OperationCallable<
          BulkUploadFeedbackLabelsRequest,
          BulkUploadFeedbackLabelsResponse,
          BulkUploadFeedbackLabelsMetadata>
      bulkUploadFeedbackLabelsOperationCallable() {
    return bulkUploadFeedbackLabelsOperationCallable;
  }

  @Override
  public UnaryCallable<BulkDownloadFeedbackLabelsRequest, Operation>
      bulkDownloadFeedbackLabelsCallable() {
    return bulkDownloadFeedbackLabelsCallable;
  }

  @Override
  public OperationCallable<
          BulkDownloadFeedbackLabelsRequest,
          BulkDownloadFeedbackLabelsResponse,
          BulkDownloadFeedbackLabelsMetadata>
      bulkDownloadFeedbackLabelsOperationCallable() {
    return bulkDownloadFeedbackLabelsOperationCallable;
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
