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

package com.google.cloud.contactcenterinsights.v1.stub;

import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListAnalysesPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListConversationsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListPhraseMatchersPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListViewsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contactcenterinsights.v1.Analysis;
import com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsMetadata;
import com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest;
import com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsResponse;
import com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest;
import com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse;
import com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest;
import com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse;
import com.google.cloud.contactcenterinsights.v1.Conversation;
import com.google.cloud.contactcenterinsights.v1.CreateAnalysisOperationMetadata;
import com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest;
import com.google.cloud.contactcenterinsights.v1.CreateConversationRequest;
import com.google.cloud.contactcenterinsights.v1.CreateIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.CreateViewRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest;
import com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteViewRequest;
import com.google.cloud.contactcenterinsights.v1.DeployIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.DeployIssueModelResponse;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataMetadata;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataResponse;
import com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest;
import com.google.cloud.contactcenterinsights.v1.GetConversationRequest;
import com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.GetIssueRequest;
import com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.GetSettingsRequest;
import com.google.cloud.contactcenterinsights.v1.GetViewRequest;
import com.google.cloud.contactcenterinsights.v1.IngestConversationsMetadata;
import com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest;
import com.google.cloud.contactcenterinsights.v1.IngestConversationsResponse;
import com.google.cloud.contactcenterinsights.v1.Issue;
import com.google.cloud.contactcenterinsights.v1.IssueModel;
import com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest;
import com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse;
import com.google.cloud.contactcenterinsights.v1.ListConversationsRequest;
import com.google.cloud.contactcenterinsights.v1.ListConversationsResponse;
import com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest;
import com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse;
import com.google.cloud.contactcenterinsights.v1.ListIssuesRequest;
import com.google.cloud.contactcenterinsights.v1.ListIssuesResponse;
import com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest;
import com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse;
import com.google.cloud.contactcenterinsights.v1.ListViewsRequest;
import com.google.cloud.contactcenterinsights.v1.ListViewsResponse;
import com.google.cloud.contactcenterinsights.v1.PhraseMatcher;
import com.google.cloud.contactcenterinsights.v1.Settings;
import com.google.cloud.contactcenterinsights.v1.UndeployIssueModelMetadata;
import com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.UndeployIssueModelResponse;
import com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest;
import com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateViewRequest;
import com.google.cloud.contactcenterinsights.v1.View;
import com.google.common.collect.ImmutableMap;
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
              .build();

  private static final MethodDescriptor<GetAnalysisRequest, Analysis> getAnalysisMethodDescriptor =
      MethodDescriptor.<GetAnalysisRequest, Analysis>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetAnalysis")
          .setRequestMarshaller(ProtoUtils.marshaller(GetAnalysisRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Analysis.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetIssueRequest, Issue> getIssueMethodDescriptor =
      MethodDescriptor.<GetIssueRequest, Issue>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(GetIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Issue.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListIssuesRequest, ListIssuesResponse>
      listIssuesMethodDescriptor =
          MethodDescriptor.<ListIssuesRequest, ListIssuesResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListIssues")
              .setRequestMarshaller(ProtoUtils.marshaller(ListIssuesRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListIssuesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateIssueRequest, Issue> updateIssueMethodDescriptor =
      MethodDescriptor.<UpdateIssueRequest, Issue>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Issue.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteIssueRequest, Empty> deleteIssueMethodDescriptor =
      MethodDescriptor.<DeleteIssueRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteIssue")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteIssueRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<GetSettingsRequest, Settings> getSettingsMethodDescriptor =
      MethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetSettings")
          .setRequestMarshaller(ProtoUtils.marshaller(GetSettingsRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Settings.getDefaultInstance()))
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
              .build();

  private static final MethodDescriptor<CreateViewRequest, View> createViewMethodDescriptor =
      MethodDescriptor.<CreateViewRequest, View>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateView")
          .setRequestMarshaller(ProtoUtils.marshaller(CreateViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(View.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<GetViewRequest, View> getViewMethodDescriptor =
      MethodDescriptor.<GetViewRequest, View>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetView")
          .setRequestMarshaller(ProtoUtils.marshaller(GetViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(View.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<ListViewsRequest, ListViewsResponse>
      listViewsMethodDescriptor =
          MethodDescriptor.<ListViewsRequest, ListViewsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListViews")
              .setRequestMarshaller(ProtoUtils.marshaller(ListViewsRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(ListViewsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateViewRequest, View> updateViewMethodDescriptor =
      MethodDescriptor.<UpdateViewRequest, View>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateView")
          .setRequestMarshaller(ProtoUtils.marshaller(UpdateViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(View.getDefaultInstance()))
          .build();

  private static final MethodDescriptor<DeleteViewRequest, Empty> deleteViewMethodDescriptor =
      MethodDescriptor.<DeleteViewRequest, Empty>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteView")
          .setRequestMarshaller(ProtoUtils.marshaller(DeleteViewRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Empty.getDefaultInstance()))
          .build();

  private final UnaryCallable<CreateConversationRequest, Conversation> createConversationCallable;
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
  private final UnaryCallable<CreateViewRequest, View> createViewCallable;
  private final UnaryCallable<GetViewRequest, View> getViewCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsResponse> listViewsCallable;
  private final UnaryCallable<ListViewsRequest, ListViewsPagedResponse> listViewsPagedCallable;
  private final UnaryCallable<UpdateViewRequest, View> updateViewCallable;
  private final UnaryCallable<DeleteViewRequest, Empty> deleteViewCallable;

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
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateConversationRequest, Conversation> updateConversationTransportSettings =
        GrpcCallSettings.<UpdateConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(updateConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put(
                      "conversation.name", String.valueOf(request.getConversation().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        GrpcCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            GrpcCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteConversationRequest, Empty> deleteConversationTransportSettings =
        GrpcCallSettings.<DeleteConversationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateAnalysisRequest, Operation> createAnalysisTransportSettings =
        GrpcCallSettings.<CreateAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetAnalysisRequest, Analysis> getAnalysisTransportSettings =
        GrpcCallSettings.<GetAnalysisRequest, Analysis>newBuilder()
            .setMethodDescriptor(getAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListAnalysesRequest, ListAnalysesResponse> listAnalysesTransportSettings =
        GrpcCallSettings.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
            .setMethodDescriptor(listAnalysesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteAnalysisRequest, Empty> deleteAnalysisTransportSettings =
        GrpcCallSettings.<DeleteAnalysisRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnalysisMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<BulkAnalyzeConversationsRequest, Operation>
        bulkAnalyzeConversationsTransportSettings =
            GrpcCallSettings.<BulkAnalyzeConversationsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkAnalyzeConversationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<IngestConversationsRequest, Operation> ingestConversationsTransportSettings =
        GrpcCallSettings.<IngestConversationsRequest, Operation>newBuilder()
            .setMethodDescriptor(ingestConversationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ExportInsightsDataRequest, Operation> exportInsightsDataTransportSettings =
        GrpcCallSettings.<ExportInsightsDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportInsightsDataMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateIssueModelRequest, Operation> createIssueModelTransportSettings =
        GrpcCallSettings.<CreateIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateIssueModelRequest, IssueModel> updateIssueModelTransportSettings =
        GrpcCallSettings.<UpdateIssueModelRequest, IssueModel>newBuilder()
            .setMethodDescriptor(updateIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("issue_model.name", String.valueOf(request.getIssueModel().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIssueModelRequest, IssueModel> getIssueModelTransportSettings =
        GrpcCallSettings.<GetIssueModelRequest, IssueModel>newBuilder()
            .setMethodDescriptor(getIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListIssueModelsRequest, ListIssueModelsResponse>
        listIssueModelsTransportSettings =
            GrpcCallSettings.<ListIssueModelsRequest, ListIssueModelsResponse>newBuilder()
                .setMethodDescriptor(listIssueModelsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeleteIssueModelRequest, Operation> deleteIssueModelTransportSettings =
        GrpcCallSettings.<DeleteIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeployIssueModelRequest, Operation> deployIssueModelTransportSettings =
        GrpcCallSettings.<DeployIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deployIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UndeployIssueModelRequest, Operation> undeployIssueModelTransportSettings =
        GrpcCallSettings.<UndeployIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployIssueModelMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetIssueRequest, Issue> getIssueTransportSettings =
        GrpcCallSettings.<GetIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(getIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesTransportSettings =
        GrpcCallSettings.<ListIssuesRequest, ListIssuesResponse>newBuilder()
            .setMethodDescriptor(listIssuesMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateIssueRequest, Issue> updateIssueTransportSettings =
        GrpcCallSettings.<UpdateIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(updateIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("issue.name", String.valueOf(request.getIssue().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteIssueRequest, Empty> deleteIssueTransportSettings =
        GrpcCallSettings.<DeleteIssueRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIssueMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
        calculateIssueModelStatsTransportSettings =
            GrpcCallSettings
                .<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>newBuilder()
                .setMethodDescriptor(calculateIssueModelStatsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("issue_model", String.valueOf(request.getIssueModel()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CreatePhraseMatcherRequest, PhraseMatcher>
        createPhraseMatcherTransportSettings =
            GrpcCallSettings.<CreatePhraseMatcherRequest, PhraseMatcher>newBuilder()
                .setMethodDescriptor(createPhraseMatcherMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherTransportSettings =
        GrpcCallSettings.<GetPhraseMatcherRequest, PhraseMatcher>newBuilder()
            .setMethodDescriptor(getPhraseMatcherMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
        listPhraseMatchersTransportSettings =
            GrpcCallSettings.<ListPhraseMatchersRequest, ListPhraseMatchersResponse>newBuilder()
                .setMethodDescriptor(listPhraseMatchersMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("parent", String.valueOf(request.getParent()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherTransportSettings =
        GrpcCallSettings.<DeletePhraseMatcherRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePhraseMatcherMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdatePhraseMatcherRequest, PhraseMatcher>
        updatePhraseMatcherTransportSettings =
            GrpcCallSettings.<UpdatePhraseMatcherRequest, PhraseMatcher>newBuilder()
                .setMethodDescriptor(updatePhraseMatcherMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put(
                          "phrase_matcher.name",
                          String.valueOf(request.getPhraseMatcher().getName()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<CalculateStatsRequest, CalculateStatsResponse>
        calculateStatsTransportSettings =
            GrpcCallSettings.<CalculateStatsRequest, CalculateStatsResponse>newBuilder()
                .setMethodDescriptor(calculateStatsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                      params.put("location", String.valueOf(request.getLocation()));
                      return params.build();
                    })
                .build();
    GrpcCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        GrpcCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        GrpcCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("settings.name", String.valueOf(request.getSettings().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<CreateViewRequest, View> createViewTransportSettings =
        GrpcCallSettings.<CreateViewRequest, View>newBuilder()
            .setMethodDescriptor(createViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<GetViewRequest, View> getViewTransportSettings =
        GrpcCallSettings.<GetViewRequest, View>newBuilder()
            .setMethodDescriptor(getViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<ListViewsRequest, ListViewsResponse> listViewsTransportSettings =
        GrpcCallSettings.<ListViewsRequest, ListViewsResponse>newBuilder()
            .setMethodDescriptor(listViewsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("parent", String.valueOf(request.getParent()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<UpdateViewRequest, View> updateViewTransportSettings =
        GrpcCallSettings.<UpdateViewRequest, View>newBuilder()
            .setMethodDescriptor(updateViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("view.name", String.valueOf(request.getView().getName()));
                  return params.build();
                })
            .build();
    GrpcCallSettings<DeleteViewRequest, Empty> deleteViewTransportSettings =
        GrpcCallSettings.<DeleteViewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteViewMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                  params.put("name", String.valueOf(request.getName()));
                  return params.build();
                })
            .build();

    this.createConversationCallable =
        callableFactory.createUnaryCallable(
            createConversationTransportSettings,
            settings.createConversationSettings(),
            clientContext);
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
