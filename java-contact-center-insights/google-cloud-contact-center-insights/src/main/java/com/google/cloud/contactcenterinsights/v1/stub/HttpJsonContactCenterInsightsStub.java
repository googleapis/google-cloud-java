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

import com.google.api.HttpRule;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
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
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the ContactCenterInsights service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonContactCenterInsightsStub extends ContactCenterInsightsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(InitializeEncryptionSpecResponse.getDescriptor())
          .add(ExportInsightsDataMetadata.getDescriptor())
          .add(InitializeEncryptionSpecMetadata.getDescriptor())
          .add(IssueModel.getDescriptor())
          .add(BulkDownloadFeedbackLabelsResponse.getDescriptor())
          .add(DeleteIssueModelMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(BulkDownloadFeedbackLabelsMetadata.getDescriptor())
          .add(UndeployIssueModelResponse.getDescriptor())
          .add(QueryMetricsMetadata.getDescriptor())
          .add(BulkDeleteConversationsResponse.getDescriptor())
          .add(ImportIssueModelResponse.getDescriptor())
          .add(BulkUploadFeedbackLabelsResponse.getDescriptor())
          .add(BulkAnalyzeConversationsResponse.getDescriptor())
          .add(DeployIssueModelMetadata.getDescriptor())
          .add(ExportIssueModelMetadata.getDescriptor())
          .add(Analysis.getDescriptor())
          .add(TuneQaScorecardRevisionResponse.getDescriptor())
          .add(IngestConversationsResponse.getDescriptor())
          .add(ExportIssueModelResponse.getDescriptor())
          .add(CreateIssueModelMetadata.getDescriptor())
          .add(TuneQaScorecardRevisionMetadata.getDescriptor())
          .add(UploadConversationMetadata.getDescriptor())
          .add(IngestConversationsMetadata.getDescriptor())
          .add(DeployIssueModelResponse.getDescriptor())
          .add(CreateAnalysisOperationMetadata.getDescriptor())
          .add(BulkUploadFeedbackLabelsMetadata.getDescriptor())
          .add(BulkAnalyzeConversationsMetadata.getDescriptor())
          .add(ImportIssueModelMetadata.getDescriptor())
          .add(Conversation.getDescriptor())
          .add(ExportInsightsDataResponse.getDescriptor())
          .add(UndeployIssueModelMetadata.getDescriptor())
          .add(BulkDeleteConversationsMetadata.getDescriptor())
          .add(QueryMetricsResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<CreateConversationRequest, Conversation>
      createConversationMethodDescriptor =
          ApiMethodDescriptor.<CreateConversationRequest, Conversation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateConversation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateConversationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/conversations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "conversationId", request.getConversationId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("conversation", request.getConversation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Conversation>newBuilder()
                      .setDefaultInstance(Conversation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UploadConversationRequest, Operation>
      uploadConversationMethodDescriptor =
          ApiMethodDescriptor.<UploadConversationRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UploadConversation")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UploadConversationRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/conversations:upload",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UploadConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UploadConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UploadConversationRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateConversationRequest, Conversation>
      updateConversationMethodDescriptor =
          ApiMethodDescriptor.<UpdateConversationRequest, Conversation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateConversation")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateConversationRequest>newBuilder()
                      .setPath(
                          "/v1/{conversation.name=projects/*/locations/*/conversations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "conversation.name", request.getConversation().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("conversation", request.getConversation(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Conversation>newBuilder()
                      .setDefaultInstance(Conversation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetConversationRequest, Conversation>
      getConversationMethodDescriptor =
          ApiMethodDescriptor.<GetConversationRequest, Conversation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetConversation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetConversationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/conversations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Conversation>newBuilder()
                      .setDefaultInstance(Conversation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListConversationsRequest, ListConversationsResponse>
      listConversationsMethodDescriptor =
          ApiMethodDescriptor.<ListConversationsRequest, ListConversationsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListConversations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListConversationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/conversations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getViewValue());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListConversationsResponse>newBuilder()
                      .setDefaultInstance(ListConversationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteConversationRequest, Empty>
      deleteConversationMethodDescriptor =
          ApiMethodDescriptor.<DeleteConversationRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteConversation")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteConversationRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/conversations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteConversationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAnalysisRequest, Operation>
      createAnalysisMethodDescriptor =
          ApiMethodDescriptor.<CreateAnalysisRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateAnalysis")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAnalysisRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/conversations/*}/analyses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("analysis", request.getAnalysis(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateAnalysisRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetAnalysisRequest, Analysis>
      getAnalysisMethodDescriptor =
          ApiMethodDescriptor.<GetAnalysisRequest, Analysis>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetAnalysis")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAnalysisRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/conversations/*/analyses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Analysis>newBuilder()
                      .setDefaultInstance(Analysis.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAnalysesRequest, ListAnalysesResponse>
      listAnalysesMethodDescriptor =
          ApiMethodDescriptor.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListAnalyses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAnalysesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/conversations/*}/analyses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalysesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalysesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAnalysesResponse>newBuilder()
                      .setDefaultInstance(ListAnalysesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAnalysisRequest, Empty>
      deleteAnalysisMethodDescriptor =
          ApiMethodDescriptor.<DeleteAnalysisRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteAnalysis")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAnalysisRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/conversations/*/analyses/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalysisRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BulkAnalyzeConversationsRequest, Operation>
      bulkAnalyzeConversationsMethodDescriptor =
          ApiMethodDescriptor.<BulkAnalyzeConversationsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/BulkAnalyzeConversations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkAnalyzeConversationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/conversations:bulkAnalyze",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkAnalyzeConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkAnalyzeConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BulkAnalyzeConversationsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BulkDeleteConversationsRequest, Operation>
      bulkDeleteConversationsMethodDescriptor =
          ApiMethodDescriptor.<BulkDeleteConversationsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/BulkDeleteConversations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkDeleteConversationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/conversations:bulkDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkDeleteConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkDeleteConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BulkDeleteConversationsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<IngestConversationsRequest, Operation>
      ingestConversationsMethodDescriptor =
          ApiMethodDescriptor.<IngestConversationsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/IngestConversations")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<IngestConversationsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/conversations:ingest",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<IngestConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<IngestConversationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (IngestConversationsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportInsightsDataRequest, Operation>
      exportInsightsDataMethodDescriptor =
          ApiMethodDescriptor.<ExportInsightsDataRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ExportInsightsData")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportInsightsDataRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/insightsdata:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportInsightsDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportInsightsDataRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportInsightsDataRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateIssueModelRequest, Operation>
      createIssueModelMethodDescriptor =
          ApiMethodDescriptor.<CreateIssueModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateIssueModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateIssueModelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/issueModels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("issueModel", request.getIssueModel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (CreateIssueModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UpdateIssueModelRequest, IssueModel>
      updateIssueModelMethodDescriptor =
          ApiMethodDescriptor.<UpdateIssueModelRequest, IssueModel>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateIssueModel")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateIssueModelRequest>newBuilder()
                      .setPath(
                          "/v1/{issueModel.name=projects/*/locations/*/issueModels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "issueModel.name", request.getIssueModel().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("issueModel", request.getIssueModel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IssueModel>newBuilder()
                      .setDefaultInstance(IssueModel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIssueModelRequest, IssueModel>
      getIssueModelMethodDescriptor =
          ApiMethodDescriptor.<GetIssueModelRequest, IssueModel>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetIssueModel")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIssueModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/issueModels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<IssueModel>newBuilder()
                      .setDefaultInstance(IssueModel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListIssueModelsRequest, ListIssueModelsResponse>
      listIssueModelsMethodDescriptor =
          ApiMethodDescriptor.<ListIssueModelsRequest, ListIssueModelsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListIssueModels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIssueModelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/issueModels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIssueModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIssueModelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIssueModelsResponse>newBuilder()
                      .setDefaultInstance(ListIssueModelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteIssueModelRequest, Operation>
      deleteIssueModelMethodDescriptor =
          ApiMethodDescriptor.<DeleteIssueModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteIssueModel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteIssueModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/issueModels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteIssueModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeployIssueModelRequest, Operation>
      deployIssueModelMethodDescriptor =
          ApiMethodDescriptor.<DeployIssueModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeployIssueModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeployIssueModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/issueModels/*}:deploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeployIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeployIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeployIssueModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<UndeployIssueModelRequest, Operation>
      undeployIssueModelMethodDescriptor =
          ApiMethodDescriptor.<UndeployIssueModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UndeployIssueModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeployIssueModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/issueModels/*}:undeploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (UndeployIssueModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportIssueModelRequest, Operation>
      exportIssueModelMethodDescriptor =
          ApiMethodDescriptor.<ExportIssueModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ExportIssueModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportIssueModelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/issueModels/*}:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportIssueModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ImportIssueModelRequest, Operation>
      importIssueModelMethodDescriptor =
          ApiMethodDescriptor.<ImportIssueModelRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ImportIssueModel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportIssueModelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/issueModels:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportIssueModelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportIssueModelRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<GetIssueRequest, Issue> getIssueMethodDescriptor =
      ApiMethodDescriptor.<GetIssueRequest, Issue>newBuilder()
          .setFullMethodName("google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetIssue")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetIssueRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/issueModels/*/issues/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Issue>newBuilder()
                  .setDefaultInstance(Issue.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListIssuesRequest, ListIssuesResponse>
      listIssuesMethodDescriptor =
          ApiMethodDescriptor.<ListIssuesRequest, ListIssuesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListIssues")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListIssuesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/issueModels/*}/issues",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListIssuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListIssuesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListIssuesResponse>newBuilder()
                      .setDefaultInstance(ListIssuesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateIssueRequest, Issue> updateIssueMethodDescriptor =
      ApiMethodDescriptor.<UpdateIssueRequest, Issue>newBuilder()
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateIssue")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateIssueRequest>newBuilder()
                  .setPath(
                      "/v1/{issue.name=projects/*/locations/*/issueModels/*/issues/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "issue.name", request.getIssue().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("issue", request.getIssue(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Issue>newBuilder()
                  .setDefaultInstance(Issue.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteIssueRequest, Empty> deleteIssueMethodDescriptor =
      ApiMethodDescriptor.<DeleteIssueRequest, Empty>newBuilder()
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteIssue")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteIssueRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/issueModels/*/issues/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteIssueRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<
          CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
      calculateIssueModelStatsMethodDescriptor =
          ApiMethodDescriptor
              .<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CalculateIssueModelStats")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CalculateIssueModelStatsRequest>newBuilder()
                      .setPath(
                          "/v1/{issueModel=projects/*/locations/*/issueModels/*}:calculateIssueModelStats",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CalculateIssueModelStatsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "issueModel", request.getIssueModel());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CalculateIssueModelStatsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CalculateIssueModelStatsResponse>newBuilder()
                      .setDefaultInstance(CalculateIssueModelStatsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreatePhraseMatcherRequest, PhraseMatcher>
      createPhraseMatcherMethodDescriptor =
          ApiMethodDescriptor.<CreatePhraseMatcherRequest, PhraseMatcher>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreatePhraseMatcher")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreatePhraseMatcherRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/phraseMatchers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePhraseMatcherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreatePhraseMatcherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("phraseMatcher", request.getPhraseMatcher(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PhraseMatcher>newBuilder()
                      .setDefaultInstance(PhraseMatcher.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetPhraseMatcherRequest, PhraseMatcher>
      getPhraseMatcherMethodDescriptor =
          ApiMethodDescriptor.<GetPhraseMatcherRequest, PhraseMatcher>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetPhraseMatcher")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetPhraseMatcherRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/phraseMatchers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetPhraseMatcherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetPhraseMatcherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PhraseMatcher>newBuilder()
                      .setDefaultInstance(PhraseMatcher.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
      listPhraseMatchersMethodDescriptor =
          ApiMethodDescriptor.<ListPhraseMatchersRequest, ListPhraseMatchersResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListPhraseMatchers")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListPhraseMatchersRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/phraseMatchers",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListPhraseMatchersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListPhraseMatchersRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListPhraseMatchersResponse>newBuilder()
                      .setDefaultInstance(ListPhraseMatchersResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeletePhraseMatcherRequest, Empty>
      deletePhraseMatcherMethodDescriptor =
          ApiMethodDescriptor.<DeletePhraseMatcherRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeletePhraseMatcher")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeletePhraseMatcherRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/phraseMatchers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePhraseMatcherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeletePhraseMatcherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdatePhraseMatcherRequest, PhraseMatcher>
      updatePhraseMatcherMethodDescriptor =
          ApiMethodDescriptor.<UpdatePhraseMatcherRequest, PhraseMatcher>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdatePhraseMatcher")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdatePhraseMatcherRequest>newBuilder()
                      .setPath(
                          "/v1/{phraseMatcher.name=projects/*/locations/*/phraseMatchers/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePhraseMatcherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "phraseMatcher.name", request.getPhraseMatcher().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdatePhraseMatcherRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("phraseMatcher", request.getPhraseMatcher(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PhraseMatcher>newBuilder()
                      .setDefaultInstance(PhraseMatcher.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CalculateStatsRequest, CalculateStatsResponse>
      calculateStatsMethodDescriptor =
          ApiMethodDescriptor.<CalculateStatsRequest, CalculateStatsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CalculateStats")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CalculateStatsRequest>newBuilder()
                      .setPath(
                          "/v1/{location=projects/*/locations/*}/conversations:calculateStats",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CalculateStatsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CalculateStatsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CalculateStatsResponse>newBuilder()
                      .setDefaultInstance(CalculateStatsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetSettingsRequest, Settings>
      getSettingsMethodDescriptor =
          ApiMethodDescriptor.<GetSettingsRequest, Settings>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetSettings")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Settings>newBuilder()
                      .setDefaultInstance(Settings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateSettingsRequest, Settings>
      updateSettingsMethodDescriptor =
          ApiMethodDescriptor.<UpdateSettingsRequest, Settings>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateSettings")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateSettingsRequest>newBuilder()
                      .setPath(
                          "/v1/{settings.name=projects/*/locations/*/settings}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "settings.name", request.getSettings().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSettingsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("settings", request.getSettings(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Settings>newBuilder()
                      .setDefaultInstance(Settings.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateAnalysisRuleRequest, AnalysisRule>
      createAnalysisRuleMethodDescriptor =
          ApiMethodDescriptor.<CreateAnalysisRuleRequest, AnalysisRule>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateAnalysisRule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateAnalysisRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/analysisRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalysisRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateAnalysisRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("analysisRule", request.getAnalysisRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalysisRule>newBuilder()
                      .setDefaultInstance(AnalysisRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetAnalysisRuleRequest, AnalysisRule>
      getAnalysisRuleMethodDescriptor =
          ApiMethodDescriptor.<GetAnalysisRuleRequest, AnalysisRule>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetAnalysisRule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetAnalysisRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/analysisRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnalysisRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetAnalysisRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalysisRule>newBuilder()
                      .setDefaultInstance(AnalysisRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListAnalysisRulesRequest, ListAnalysisRulesResponse>
      listAnalysisRulesMethodDescriptor =
          ApiMethodDescriptor.<ListAnalysisRulesRequest, ListAnalysisRulesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListAnalysisRules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAnalysisRulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/analysisRules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalysisRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAnalysisRulesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAnalysisRulesResponse>newBuilder()
                      .setDefaultInstance(ListAnalysisRulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateAnalysisRuleRequest, AnalysisRule>
      updateAnalysisRuleMethodDescriptor =
          ApiMethodDescriptor.<UpdateAnalysisRuleRequest, AnalysisRule>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateAnalysisRule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateAnalysisRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{analysisRule.name=projects/*/locations/*/analysisRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAnalysisRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "analysisRule.name", request.getAnalysisRule().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateAnalysisRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("analysisRule", request.getAnalysisRule(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<AnalysisRule>newBuilder()
                      .setDefaultInstance(AnalysisRule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteAnalysisRuleRequest, Empty>
      deleteAnalysisRuleMethodDescriptor =
          ApiMethodDescriptor.<DeleteAnalysisRuleRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteAnalysisRule")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteAnalysisRuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/analysisRules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalysisRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteAnalysisRuleRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetEncryptionSpecRequest, EncryptionSpec>
      getEncryptionSpecMethodDescriptor =
          ApiMethodDescriptor.<GetEncryptionSpecRequest, EncryptionSpec>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetEncryptionSpec")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetEncryptionSpecRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/encryptionSpec}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEncryptionSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEncryptionSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EncryptionSpec>newBuilder()
                      .setDefaultInstance(EncryptionSpec.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<InitializeEncryptionSpecRequest, Operation>
      initializeEncryptionSpecMethodDescriptor =
          ApiMethodDescriptor.<InitializeEncryptionSpecRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/InitializeEncryptionSpec")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InitializeEncryptionSpecRequest>newBuilder()
                      .setPath(
                          "/v1/{encryptionSpec.name=projects/*/locations/*/encryptionSpec}:initialize",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<InitializeEncryptionSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "encryptionSpec.name",
                                request.getEncryptionSpec().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<InitializeEncryptionSpecRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (InitializeEncryptionSpecRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateViewRequest, View> createViewMethodDescriptor =
      ApiMethodDescriptor.<CreateViewRequest, View>newBuilder()
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateView")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateViewRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*}/views",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("view", request.getView(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<View>newBuilder()
                  .setDefaultInstance(View.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetViewRequest, View> getViewMethodDescriptor =
      ApiMethodDescriptor.<GetViewRequest, View>newBuilder()
          .setFullMethodName("google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetView")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetViewRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/views/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<View>newBuilder()
                  .setDefaultInstance(View.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListViewsRequest, ListViewsResponse>
      listViewsMethodDescriptor =
          ApiMethodDescriptor.<ListViewsRequest, ListViewsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListViews")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListViewsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/views",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListViewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListViewsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListViewsResponse>newBuilder()
                      .setDefaultInstance(ListViewsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateViewRequest, View> updateViewMethodDescriptor =
      ApiMethodDescriptor.<UpdateViewRequest, View>newBuilder()
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateView")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateViewRequest>newBuilder()
                  .setPath(
                      "/v1/{view.name=projects/*/locations/*/views/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "view.name", request.getView().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create().toBody("view", request.getView(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<View>newBuilder()
                  .setDefaultInstance(View.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DeleteViewRequest, Empty> deleteViewMethodDescriptor =
      ApiMethodDescriptor.<DeleteViewRequest, Empty>newBuilder()
          .setFullMethodName(
              "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteView")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteViewRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/views/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteViewRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Empty>newBuilder()
                  .setDefaultInstance(Empty.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<QueryMetricsRequest, Operation>
      queryMetricsMethodDescriptor =
          ApiMethodDescriptor.<QueryMetricsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/QueryMetrics")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<QueryMetricsRequest>newBuilder()
                      .setPath(
                          "/v1/{location=projects/*/locations/*}:queryMetrics",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<QueryMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "location", request.getLocation());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<QueryMetricsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearLocation().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (QueryMetricsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateQaQuestionRequest, QaQuestion>
      createQaQuestionMethodDescriptor =
          ApiMethodDescriptor.<CreateQaQuestionRequest, QaQuestion>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateQaQuestion")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateQaQuestionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/qaScorecards/*/revisions/*}/qaQuestions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateQaQuestionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateQaQuestionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "qaQuestionId", request.getQaQuestionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("qaQuestion", request.getQaQuestion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaQuestion>newBuilder()
                      .setDefaultInstance(QaQuestion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetQaQuestionRequest, QaQuestion>
      getQaQuestionMethodDescriptor =
          ApiMethodDescriptor.<GetQaQuestionRequest, QaQuestion>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetQaQuestion")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetQaQuestionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/qaScorecards/*/revisions/*/qaQuestions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetQaQuestionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetQaQuestionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaQuestion>newBuilder()
                      .setDefaultInstance(QaQuestion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateQaQuestionRequest, QaQuestion>
      updateQaQuestionMethodDescriptor =
          ApiMethodDescriptor.<UpdateQaQuestionRequest, QaQuestion>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateQaQuestion")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateQaQuestionRequest>newBuilder()
                      .setPath(
                          "/v1/{qaQuestion.name=projects/*/locations/*/qaScorecards/*/revisions/*/qaQuestions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateQaQuestionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "qaQuestion.name", request.getQaQuestion().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateQaQuestionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("qaQuestion", request.getQaQuestion(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaQuestion>newBuilder()
                      .setDefaultInstance(QaQuestion.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteQaQuestionRequest, Empty>
      deleteQaQuestionMethodDescriptor =
          ApiMethodDescriptor.<DeleteQaQuestionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteQaQuestion")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteQaQuestionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/qaScorecards/*/revisions/*/qaQuestions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteQaQuestionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteQaQuestionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListQaQuestionsRequest, ListQaQuestionsResponse>
      listQaQuestionsMethodDescriptor =
          ApiMethodDescriptor.<ListQaQuestionsRequest, ListQaQuestionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListQaQuestions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListQaQuestionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/qaScorecards/*/revisions/*}/qaQuestions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListQaQuestionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListQaQuestionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListQaQuestionsResponse>newBuilder()
                      .setDefaultInstance(ListQaQuestionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateQaScorecardRequest, QaScorecard>
      createQaScorecardMethodDescriptor =
          ApiMethodDescriptor.<CreateQaScorecardRequest, QaScorecard>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateQaScorecard")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateQaScorecardRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/qaScorecards",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateQaScorecardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateQaScorecardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "qaScorecardId", request.getQaScorecardId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("qaScorecard", request.getQaScorecard(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaScorecard>newBuilder()
                      .setDefaultInstance(QaScorecard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetQaScorecardRequest, QaScorecard>
      getQaScorecardMethodDescriptor =
          ApiMethodDescriptor.<GetQaScorecardRequest, QaScorecard>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetQaScorecard")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetQaScorecardRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/qaScorecards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetQaScorecardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetQaScorecardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaScorecard>newBuilder()
                      .setDefaultInstance(QaScorecard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateQaScorecardRequest, QaScorecard>
      updateQaScorecardMethodDescriptor =
          ApiMethodDescriptor.<UpdateQaScorecardRequest, QaScorecard>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateQaScorecard")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateQaScorecardRequest>newBuilder()
                      .setPath(
                          "/v1/{qaScorecard.name=projects/*/locations/*/qaScorecards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateQaScorecardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "qaScorecard.name", request.getQaScorecard().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateQaScorecardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("qaScorecard", request.getQaScorecard(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaScorecard>newBuilder()
                      .setDefaultInstance(QaScorecard.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteQaScorecardRequest, Empty>
      deleteQaScorecardMethodDescriptor =
          ApiMethodDescriptor.<DeleteQaScorecardRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteQaScorecard")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteQaScorecardRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/qaScorecards/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteQaScorecardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteQaScorecardRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListQaScorecardsRequest, ListQaScorecardsResponse>
      listQaScorecardsMethodDescriptor =
          ApiMethodDescriptor.<ListQaScorecardsRequest, ListQaScorecardsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListQaScorecards")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListQaScorecardsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/qaScorecards",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListQaScorecardsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListQaScorecardsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListQaScorecardsResponse>newBuilder()
                      .setDefaultInstance(ListQaScorecardsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateQaScorecardRevisionRequest, QaScorecardRevision>
      createQaScorecardRevisionMethodDescriptor =
          ApiMethodDescriptor.<CreateQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateQaScorecardRevision")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateQaScorecardRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/qaScorecards/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields,
                                "qaScorecardRevisionId",
                                request.getQaScorecardRevisionId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "qaScorecardRevision",
                                      request.getQaScorecardRevision(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaScorecardRevision>newBuilder()
                      .setDefaultInstance(QaScorecardRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetQaScorecardRevisionRequest, QaScorecardRevision>
      getQaScorecardRevisionMethodDescriptor =
          ApiMethodDescriptor.<GetQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetQaScorecardRevision")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetQaScorecardRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/qaScorecards/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaScorecardRevision>newBuilder()
                      .setDefaultInstance(QaScorecardRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TuneQaScorecardRevisionRequest, Operation>
      tuneQaScorecardRevisionMethodDescriptor =
          ApiMethodDescriptor.<TuneQaScorecardRevisionRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/TuneQaScorecardRevision")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TuneQaScorecardRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/qaScorecards/*/revisions/*}:tuneQaScorecardRevision",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TuneQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TuneQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (TuneQaScorecardRevisionRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<DeployQaScorecardRevisionRequest, QaScorecardRevision>
      deployQaScorecardRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeployQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeployQaScorecardRevision")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeployQaScorecardRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/qaScorecards/*/revisions/*}:deploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeployQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeployQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaScorecardRevision>newBuilder()
                      .setDefaultInstance(QaScorecardRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
      undeployQaScorecardRevisionMethodDescriptor =
          ApiMethodDescriptor.<UndeployQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UndeployQaScorecardRevision")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UndeployQaScorecardRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/qaScorecards/*/revisions/*}:undeploy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UndeployQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<QaScorecardRevision>newBuilder()
                      .setDefaultInstance(QaScorecardRevision.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteQaScorecardRevisionRequest, Empty>
      deleteQaScorecardRevisionMethodDescriptor =
          ApiMethodDescriptor.<DeleteQaScorecardRevisionRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteQaScorecardRevision")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteQaScorecardRevisionRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/qaScorecards/*/revisions/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteQaScorecardRevisionRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "force", request.getForce());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>
      listQaScorecardRevisionsMethodDescriptor =
          ApiMethodDescriptor
              .<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListQaScorecardRevisions")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListQaScorecardRevisionsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/qaScorecards/*}/revisions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListQaScorecardRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListQaScorecardRevisionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListQaScorecardRevisionsResponse>newBuilder()
                      .setDefaultInstance(ListQaScorecardRevisionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateFeedbackLabelRequest, FeedbackLabel>
      createFeedbackLabelMethodDescriptor =
          ApiMethodDescriptor.<CreateFeedbackLabelRequest, FeedbackLabel>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/CreateFeedbackLabel")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateFeedbackLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/conversations/*}/feedbackLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFeedbackLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateFeedbackLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "feedbackLabelId", request.getFeedbackLabelId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("feedbackLabel", request.getFeedbackLabel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FeedbackLabel>newBuilder()
                      .setDefaultInstance(FeedbackLabel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>
      listFeedbackLabelsMethodDescriptor =
          ApiMethodDescriptor.<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListFeedbackLabels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListFeedbackLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/conversations/*}/feedbackLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedbackLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListFeedbackLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListFeedbackLabelsResponse>newBuilder()
                      .setDefaultInstance(ListFeedbackLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetFeedbackLabelRequest, FeedbackLabel>
      getFeedbackLabelMethodDescriptor =
          ApiMethodDescriptor.<GetFeedbackLabelRequest, FeedbackLabel>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/GetFeedbackLabel")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetFeedbackLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/conversations/*/feedbackLabels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetFeedbackLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetFeedbackLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FeedbackLabel>newBuilder()
                      .setDefaultInstance(FeedbackLabel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateFeedbackLabelRequest, FeedbackLabel>
      updateFeedbackLabelMethodDescriptor =
          ApiMethodDescriptor.<UpdateFeedbackLabelRequest, FeedbackLabel>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/UpdateFeedbackLabel")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateFeedbackLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{feedbackLabel.name=projects/*/locations/*/conversations/*/feedbackLabels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFeedbackLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "feedbackLabel.name", request.getFeedbackLabel().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateFeedbackLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("feedbackLabel", request.getFeedbackLabel(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<FeedbackLabel>newBuilder()
                      .setDefaultInstance(FeedbackLabel.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteFeedbackLabelRequest, Empty>
      deleteFeedbackLabelMethodDescriptor =
          ApiMethodDescriptor.<DeleteFeedbackLabelRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/DeleteFeedbackLabel")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteFeedbackLabelRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/conversations/*/feedbackLabels/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFeedbackLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteFeedbackLabelRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>
      listAllFeedbackLabelsMethodDescriptor =
          ApiMethodDescriptor
              .<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/ListAllFeedbackLabels")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListAllFeedbackLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:listAllFeedbackLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListAllFeedbackLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListAllFeedbackLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListAllFeedbackLabelsResponse>newBuilder()
                      .setDefaultInstance(ListAllFeedbackLabelsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BulkUploadFeedbackLabelsRequest, Operation>
      bulkUploadFeedbackLabelsMethodDescriptor =
          ApiMethodDescriptor.<BulkUploadFeedbackLabelsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/BulkUploadFeedbackLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkUploadFeedbackLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:bulkUploadFeedbackLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkUploadFeedbackLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkUploadFeedbackLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BulkUploadFeedbackLabelsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BulkDownloadFeedbackLabelsRequest, Operation>
      bulkDownloadFeedbackLabelsMethodDescriptor =
          ApiMethodDescriptor.<BulkDownloadFeedbackLabelsRequest, Operation>newBuilder()
              .setFullMethodName(
                  "google.cloud.contactcenterinsights.v1.ContactCenterInsights/BulkDownloadFeedbackLabels")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BulkDownloadFeedbackLabelsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:bulkDownloadFeedbackLabels",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BulkDownloadFeedbackLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BulkDownloadFeedbackLabelsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BulkDownloadFeedbackLabelsRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
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
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonContactCenterInsightsStub create(
      ContactCenterInsightsStubSettings settings) throws IOException {
    return new HttpJsonContactCenterInsightsStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonContactCenterInsightsStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonContactCenterInsightsStub(
        ContactCenterInsightsStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonContactCenterInsightsStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonContactCenterInsightsStub(
        ContactCenterInsightsStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonContactCenterInsightsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContactCenterInsightsStub(
      ContactCenterInsightsStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonContactCenterInsightsCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonContactCenterInsightsStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonContactCenterInsightsStub(
      ContactCenterInsightsStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<CreateConversationRequest, Conversation>
        createConversationTransportSettings =
            HttpJsonCallSettings.<CreateConversationRequest, Conversation>newBuilder()
                .setMethodDescriptor(createConversationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UploadConversationRequest, Operation> uploadConversationTransportSettings =
        HttpJsonCallSettings.<UploadConversationRequest, Operation>newBuilder()
            .setMethodDescriptor(uploadConversationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateConversationRequest, Conversation>
        updateConversationTransportSettings =
            HttpJsonCallSettings.<UpdateConversationRequest, Conversation>newBuilder()
                .setMethodDescriptor(updateConversationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "conversation.name", String.valueOf(request.getConversation().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        HttpJsonCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            HttpJsonCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteConversationRequest, Empty> deleteConversationTransportSettings =
        HttpJsonCallSettings.<DeleteConversationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAnalysisRequest, Operation> createAnalysisTransportSettings =
        HttpJsonCallSettings.<CreateAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetAnalysisRequest, Analysis> getAnalysisTransportSettings =
        HttpJsonCallSettings.<GetAnalysisRequest, Analysis>newBuilder()
            .setMethodDescriptor(getAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAnalysesRequest, ListAnalysesResponse> listAnalysesTransportSettings =
        HttpJsonCallSettings.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
            .setMethodDescriptor(listAnalysesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteAnalysisRequest, Empty> deleteAnalysisTransportSettings =
        HttpJsonCallSettings.<DeleteAnalysisRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BulkAnalyzeConversationsRequest, Operation>
        bulkAnalyzeConversationsTransportSettings =
            HttpJsonCallSettings.<BulkAnalyzeConversationsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkAnalyzeConversationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BulkDeleteConversationsRequest, Operation>
        bulkDeleteConversationsTransportSettings =
            HttpJsonCallSettings.<BulkDeleteConversationsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkDeleteConversationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<IngestConversationsRequest, Operation>
        ingestConversationsTransportSettings =
            HttpJsonCallSettings.<IngestConversationsRequest, Operation>newBuilder()
                .setMethodDescriptor(ingestConversationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExportInsightsDataRequest, Operation> exportInsightsDataTransportSettings =
        HttpJsonCallSettings.<ExportInsightsDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportInsightsDataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateIssueModelRequest, Operation> createIssueModelTransportSettings =
        HttpJsonCallSettings.<CreateIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateIssueModelRequest, IssueModel> updateIssueModelTransportSettings =
        HttpJsonCallSettings.<UpdateIssueModelRequest, IssueModel>newBuilder()
            .setMethodDescriptor(updateIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "issue_model.name", String.valueOf(request.getIssueModel().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIssueModelRequest, IssueModel> getIssueModelTransportSettings =
        HttpJsonCallSettings.<GetIssueModelRequest, IssueModel>newBuilder()
            .setMethodDescriptor(getIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListIssueModelsRequest, ListIssueModelsResponse>
        listIssueModelsTransportSettings =
            HttpJsonCallSettings.<ListIssueModelsRequest, ListIssueModelsResponse>newBuilder()
                .setMethodDescriptor(listIssueModelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteIssueModelRequest, Operation> deleteIssueModelTransportSettings =
        HttpJsonCallSettings.<DeleteIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeployIssueModelRequest, Operation> deployIssueModelTransportSettings =
        HttpJsonCallSettings.<DeployIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deployIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UndeployIssueModelRequest, Operation> undeployIssueModelTransportSettings =
        HttpJsonCallSettings.<UndeployIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ExportIssueModelRequest, Operation> exportIssueModelTransportSettings =
        HttpJsonCallSettings.<ExportIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(exportIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ImportIssueModelRequest, Operation> importIssueModelTransportSettings =
        HttpJsonCallSettings.<ImportIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(importIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIssueRequest, Issue> getIssueTransportSettings =
        HttpJsonCallSettings.<GetIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(getIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesTransportSettings =
        HttpJsonCallSettings.<ListIssuesRequest, ListIssuesResponse>newBuilder()
            .setMethodDescriptor(listIssuesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateIssueRequest, Issue> updateIssueTransportSettings =
        HttpJsonCallSettings.<UpdateIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(updateIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("issue.name", String.valueOf(request.getIssue().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteIssueRequest, Empty> deleteIssueTransportSettings =
        HttpJsonCallSettings.<DeleteIssueRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
        calculateIssueModelStatsTransportSettings =
            HttpJsonCallSettings
                .<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>newBuilder()
                .setMethodDescriptor(calculateIssueModelStatsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("issue_model", String.valueOf(request.getIssueModel()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreatePhraseMatcherRequest, PhraseMatcher>
        createPhraseMatcherTransportSettings =
            HttpJsonCallSettings.<CreatePhraseMatcherRequest, PhraseMatcher>newBuilder()
                .setMethodDescriptor(createPhraseMatcherMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherTransportSettings =
        HttpJsonCallSettings.<GetPhraseMatcherRequest, PhraseMatcher>newBuilder()
            .setMethodDescriptor(getPhraseMatcherMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
        listPhraseMatchersTransportSettings =
            HttpJsonCallSettings.<ListPhraseMatchersRequest, ListPhraseMatchersResponse>newBuilder()
                .setMethodDescriptor(listPhraseMatchersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherTransportSettings =
        HttpJsonCallSettings.<DeletePhraseMatcherRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePhraseMatcherMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdatePhraseMatcherRequest, PhraseMatcher>
        updatePhraseMatcherTransportSettings =
            HttpJsonCallSettings.<UpdatePhraseMatcherRequest, PhraseMatcher>newBuilder()
                .setMethodDescriptor(updatePhraseMatcherMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "phrase_matcher.name",
                          String.valueOf(request.getPhraseMatcher().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CalculateStatsRequest, CalculateStatsResponse>
        calculateStatsTransportSettings =
            HttpJsonCallSettings.<CalculateStatsRequest, CalculateStatsResponse>newBuilder()
                .setMethodDescriptor(calculateStatsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("location", String.valueOf(request.getLocation()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        HttpJsonCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        HttpJsonCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("settings.name", String.valueOf(request.getSettings().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateAnalysisRuleRequest, AnalysisRule>
        createAnalysisRuleTransportSettings =
            HttpJsonCallSettings.<CreateAnalysisRuleRequest, AnalysisRule>newBuilder()
                .setMethodDescriptor(createAnalysisRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetAnalysisRuleRequest, AnalysisRule> getAnalysisRuleTransportSettings =
        HttpJsonCallSettings.<GetAnalysisRuleRequest, AnalysisRule>newBuilder()
            .setMethodDescriptor(getAnalysisRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAnalysisRulesRequest, ListAnalysisRulesResponse>
        listAnalysisRulesTransportSettings =
            HttpJsonCallSettings.<ListAnalysisRulesRequest, ListAnalysisRulesResponse>newBuilder()
                .setMethodDescriptor(listAnalysisRulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UpdateAnalysisRuleRequest, AnalysisRule>
        updateAnalysisRuleTransportSettings =
            HttpJsonCallSettings.<UpdateAnalysisRuleRequest, AnalysisRule>newBuilder()
                .setMethodDescriptor(updateAnalysisRuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "analysis_rule.name",
                          String.valueOf(request.getAnalysisRule().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteAnalysisRuleRequest, Empty> deleteAnalysisRuleTransportSettings =
        HttpJsonCallSettings.<DeleteAnalysisRuleRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnalysisRuleMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetEncryptionSpecRequest, EncryptionSpec>
        getEncryptionSpecTransportSettings =
            HttpJsonCallSettings.<GetEncryptionSpecRequest, EncryptionSpec>newBuilder()
                .setMethodDescriptor(getEncryptionSpecMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<InitializeEncryptionSpecRequest, Operation>
        initializeEncryptionSpecTransportSettings =
            HttpJsonCallSettings.<InitializeEncryptionSpecRequest, Operation>newBuilder()
                .setMethodDescriptor(initializeEncryptionSpecMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "encryption_spec.name",
                          String.valueOf(request.getEncryptionSpec().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateViewRequest, View> createViewTransportSettings =
        HttpJsonCallSettings.<CreateViewRequest, View>newBuilder()
            .setMethodDescriptor(createViewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetViewRequest, View> getViewTransportSettings =
        HttpJsonCallSettings.<GetViewRequest, View>newBuilder()
            .setMethodDescriptor(getViewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListViewsRequest, ListViewsResponse> listViewsTransportSettings =
        HttpJsonCallSettings.<ListViewsRequest, ListViewsResponse>newBuilder()
            .setMethodDescriptor(listViewsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateViewRequest, View> updateViewTransportSettings =
        HttpJsonCallSettings.<UpdateViewRequest, View>newBuilder()
            .setMethodDescriptor(updateViewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("view.name", String.valueOf(request.getView().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteViewRequest, Empty> deleteViewTransportSettings =
        HttpJsonCallSettings.<DeleteViewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteViewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<QueryMetricsRequest, Operation> queryMetricsTransportSettings =
        HttpJsonCallSettings.<QueryMetricsRequest, Operation>newBuilder()
            .setMethodDescriptor(queryMetricsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("location", String.valueOf(request.getLocation()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateQaQuestionRequest, QaQuestion> createQaQuestionTransportSettings =
        HttpJsonCallSettings.<CreateQaQuestionRequest, QaQuestion>newBuilder()
            .setMethodDescriptor(createQaQuestionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetQaQuestionRequest, QaQuestion> getQaQuestionTransportSettings =
        HttpJsonCallSettings.<GetQaQuestionRequest, QaQuestion>newBuilder()
            .setMethodDescriptor(getQaQuestionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateQaQuestionRequest, QaQuestion> updateQaQuestionTransportSettings =
        HttpJsonCallSettings.<UpdateQaQuestionRequest, QaQuestion>newBuilder()
            .setMethodDescriptor(updateQaQuestionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "qa_question.name", String.valueOf(request.getQaQuestion().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteQaQuestionRequest, Empty> deleteQaQuestionTransportSettings =
        HttpJsonCallSettings.<DeleteQaQuestionRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteQaQuestionMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListQaQuestionsRequest, ListQaQuestionsResponse>
        listQaQuestionsTransportSettings =
            HttpJsonCallSettings.<ListQaQuestionsRequest, ListQaQuestionsResponse>newBuilder()
                .setMethodDescriptor(listQaQuestionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateQaScorecardRequest, QaScorecard> createQaScorecardTransportSettings =
        HttpJsonCallSettings.<CreateQaScorecardRequest, QaScorecard>newBuilder()
            .setMethodDescriptor(createQaScorecardMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetQaScorecardRequest, QaScorecard> getQaScorecardTransportSettings =
        HttpJsonCallSettings.<GetQaScorecardRequest, QaScorecard>newBuilder()
            .setMethodDescriptor(getQaScorecardMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateQaScorecardRequest, QaScorecard> updateQaScorecardTransportSettings =
        HttpJsonCallSettings.<UpdateQaScorecardRequest, QaScorecard>newBuilder()
            .setMethodDescriptor(updateQaScorecardMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "qa_scorecard.name", String.valueOf(request.getQaScorecard().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteQaScorecardRequest, Empty> deleteQaScorecardTransportSettings =
        HttpJsonCallSettings.<DeleteQaScorecardRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteQaScorecardMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListQaScorecardsRequest, ListQaScorecardsResponse>
        listQaScorecardsTransportSettings =
            HttpJsonCallSettings.<ListQaScorecardsRequest, ListQaScorecardsResponse>newBuilder()
                .setMethodDescriptor(listQaScorecardsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateQaScorecardRevisionRequest, QaScorecardRevision>
        createQaScorecardRevisionTransportSettings =
            HttpJsonCallSettings.<CreateQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
                .setMethodDescriptor(createQaScorecardRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetQaScorecardRevisionRequest, QaScorecardRevision>
        getQaScorecardRevisionTransportSettings =
            HttpJsonCallSettings.<GetQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
                .setMethodDescriptor(getQaScorecardRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<TuneQaScorecardRevisionRequest, Operation>
        tuneQaScorecardRevisionTransportSettings =
            HttpJsonCallSettings.<TuneQaScorecardRevisionRequest, Operation>newBuilder()
                .setMethodDescriptor(tuneQaScorecardRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeployQaScorecardRevisionRequest, QaScorecardRevision>
        deployQaScorecardRevisionTransportSettings =
            HttpJsonCallSettings.<DeployQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
                .setMethodDescriptor(deployQaScorecardRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<UndeployQaScorecardRevisionRequest, QaScorecardRevision>
        undeployQaScorecardRevisionTransportSettings =
            HttpJsonCallSettings
                .<UndeployQaScorecardRevisionRequest, QaScorecardRevision>newBuilder()
                .setMethodDescriptor(undeployQaScorecardRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteQaScorecardRevisionRequest, Empty>
        deleteQaScorecardRevisionTransportSettings =
            HttpJsonCallSettings.<DeleteQaScorecardRevisionRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteQaScorecardRevisionMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>
        listQaScorecardRevisionsTransportSettings =
            HttpJsonCallSettings
                .<ListQaScorecardRevisionsRequest, ListQaScorecardRevisionsResponse>newBuilder()
                .setMethodDescriptor(listQaScorecardRevisionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateFeedbackLabelRequest, FeedbackLabel>
        createFeedbackLabelTransportSettings =
            HttpJsonCallSettings.<CreateFeedbackLabelRequest, FeedbackLabel>newBuilder()
                .setMethodDescriptor(createFeedbackLabelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>
        listFeedbackLabelsTransportSettings =
            HttpJsonCallSettings.<ListFeedbackLabelsRequest, ListFeedbackLabelsResponse>newBuilder()
                .setMethodDescriptor(listFeedbackLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetFeedbackLabelRequest, FeedbackLabel> getFeedbackLabelTransportSettings =
        HttpJsonCallSettings.<GetFeedbackLabelRequest, FeedbackLabel>newBuilder()
            .setMethodDescriptor(getFeedbackLabelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateFeedbackLabelRequest, FeedbackLabel>
        updateFeedbackLabelTransportSettings =
            HttpJsonCallSettings.<UpdateFeedbackLabelRequest, FeedbackLabel>newBuilder()
                .setMethodDescriptor(updateFeedbackLabelMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "feedback_label.name",
                          String.valueOf(request.getFeedbackLabel().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteFeedbackLabelRequest, Empty> deleteFeedbackLabelTransportSettings =
        HttpJsonCallSettings.<DeleteFeedbackLabelRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteFeedbackLabelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>
        listAllFeedbackLabelsTransportSettings =
            HttpJsonCallSettings
                .<ListAllFeedbackLabelsRequest, ListAllFeedbackLabelsResponse>newBuilder()
                .setMethodDescriptor(listAllFeedbackLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BulkUploadFeedbackLabelsRequest, Operation>
        bulkUploadFeedbackLabelsTransportSettings =
            HttpJsonCallSettings.<BulkUploadFeedbackLabelsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkUploadFeedbackLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<BulkDownloadFeedbackLabelsRequest, Operation>
        bulkDownloadFeedbackLabelsTransportSettings =
            HttpJsonCallSettings.<BulkDownloadFeedbackLabelsRequest, Operation>newBuilder()
                .setMethodDescriptor(bulkDownloadFeedbackLabelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.createIssueModelCallable =
        callableFactory.createUnaryCallable(
            createIssueModelTransportSettings, settings.createIssueModelSettings(), clientContext);
    this.createIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            createIssueModelTransportSettings,
            settings.createIssueModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.deployIssueModelCallable =
        callableFactory.createUnaryCallable(
            deployIssueModelTransportSettings, settings.deployIssueModelSettings(), clientContext);
    this.deployIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            deployIssueModelTransportSettings,
            settings.deployIssueModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
    this.exportIssueModelCallable =
        callableFactory.createUnaryCallable(
            exportIssueModelTransportSettings, settings.exportIssueModelSettings(), clientContext);
    this.exportIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            exportIssueModelTransportSettings,
            settings.exportIssueModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.importIssueModelCallable =
        callableFactory.createUnaryCallable(
            importIssueModelTransportSettings, settings.importIssueModelSettings(), clientContext);
    this.importIssueModelOperationCallable =
        callableFactory.createOperationCallable(
            importIssueModelTransportSettings,
            settings.importIssueModelOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);
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
            httpJsonOperationsStub);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createConversationMethodDescriptor);
    methodDescriptors.add(uploadConversationMethodDescriptor);
    methodDescriptors.add(updateConversationMethodDescriptor);
    methodDescriptors.add(getConversationMethodDescriptor);
    methodDescriptors.add(listConversationsMethodDescriptor);
    methodDescriptors.add(deleteConversationMethodDescriptor);
    methodDescriptors.add(createAnalysisMethodDescriptor);
    methodDescriptors.add(getAnalysisMethodDescriptor);
    methodDescriptors.add(listAnalysesMethodDescriptor);
    methodDescriptors.add(deleteAnalysisMethodDescriptor);
    methodDescriptors.add(bulkAnalyzeConversationsMethodDescriptor);
    methodDescriptors.add(bulkDeleteConversationsMethodDescriptor);
    methodDescriptors.add(ingestConversationsMethodDescriptor);
    methodDescriptors.add(exportInsightsDataMethodDescriptor);
    methodDescriptors.add(createIssueModelMethodDescriptor);
    methodDescriptors.add(updateIssueModelMethodDescriptor);
    methodDescriptors.add(getIssueModelMethodDescriptor);
    methodDescriptors.add(listIssueModelsMethodDescriptor);
    methodDescriptors.add(deleteIssueModelMethodDescriptor);
    methodDescriptors.add(deployIssueModelMethodDescriptor);
    methodDescriptors.add(undeployIssueModelMethodDescriptor);
    methodDescriptors.add(exportIssueModelMethodDescriptor);
    methodDescriptors.add(importIssueModelMethodDescriptor);
    methodDescriptors.add(getIssueMethodDescriptor);
    methodDescriptors.add(listIssuesMethodDescriptor);
    methodDescriptors.add(updateIssueMethodDescriptor);
    methodDescriptors.add(deleteIssueMethodDescriptor);
    methodDescriptors.add(calculateIssueModelStatsMethodDescriptor);
    methodDescriptors.add(createPhraseMatcherMethodDescriptor);
    methodDescriptors.add(getPhraseMatcherMethodDescriptor);
    methodDescriptors.add(listPhraseMatchersMethodDescriptor);
    methodDescriptors.add(deletePhraseMatcherMethodDescriptor);
    methodDescriptors.add(updatePhraseMatcherMethodDescriptor);
    methodDescriptors.add(calculateStatsMethodDescriptor);
    methodDescriptors.add(getSettingsMethodDescriptor);
    methodDescriptors.add(updateSettingsMethodDescriptor);
    methodDescriptors.add(createAnalysisRuleMethodDescriptor);
    methodDescriptors.add(getAnalysisRuleMethodDescriptor);
    methodDescriptors.add(listAnalysisRulesMethodDescriptor);
    methodDescriptors.add(updateAnalysisRuleMethodDescriptor);
    methodDescriptors.add(deleteAnalysisRuleMethodDescriptor);
    methodDescriptors.add(getEncryptionSpecMethodDescriptor);
    methodDescriptors.add(initializeEncryptionSpecMethodDescriptor);
    methodDescriptors.add(createViewMethodDescriptor);
    methodDescriptors.add(getViewMethodDescriptor);
    methodDescriptors.add(listViewsMethodDescriptor);
    methodDescriptors.add(updateViewMethodDescriptor);
    methodDescriptors.add(deleteViewMethodDescriptor);
    methodDescriptors.add(queryMetricsMethodDescriptor);
    methodDescriptors.add(createQaQuestionMethodDescriptor);
    methodDescriptors.add(getQaQuestionMethodDescriptor);
    methodDescriptors.add(updateQaQuestionMethodDescriptor);
    methodDescriptors.add(deleteQaQuestionMethodDescriptor);
    methodDescriptors.add(listQaQuestionsMethodDescriptor);
    methodDescriptors.add(createQaScorecardMethodDescriptor);
    methodDescriptors.add(getQaScorecardMethodDescriptor);
    methodDescriptors.add(updateQaScorecardMethodDescriptor);
    methodDescriptors.add(deleteQaScorecardMethodDescriptor);
    methodDescriptors.add(listQaScorecardsMethodDescriptor);
    methodDescriptors.add(createQaScorecardRevisionMethodDescriptor);
    methodDescriptors.add(getQaScorecardRevisionMethodDescriptor);
    methodDescriptors.add(tuneQaScorecardRevisionMethodDescriptor);
    methodDescriptors.add(deployQaScorecardRevisionMethodDescriptor);
    methodDescriptors.add(undeployQaScorecardRevisionMethodDescriptor);
    methodDescriptors.add(deleteQaScorecardRevisionMethodDescriptor);
    methodDescriptors.add(listQaScorecardRevisionsMethodDescriptor);
    methodDescriptors.add(createFeedbackLabelMethodDescriptor);
    methodDescriptors.add(listFeedbackLabelsMethodDescriptor);
    methodDescriptors.add(getFeedbackLabelMethodDescriptor);
    methodDescriptors.add(updateFeedbackLabelMethodDescriptor);
    methodDescriptors.add(deleteFeedbackLabelMethodDescriptor);
    methodDescriptors.add(listAllFeedbackLabelsMethodDescriptor);
    methodDescriptors.add(bulkUploadFeedbackLabelsMethodDescriptor);
    methodDescriptors.add(bulkDownloadFeedbackLabelsMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
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
