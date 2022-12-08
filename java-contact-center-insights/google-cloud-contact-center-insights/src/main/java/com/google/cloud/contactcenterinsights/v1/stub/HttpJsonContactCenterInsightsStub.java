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

import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contactcenterinsights.v1.Analysis;
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
@BetaApi
public class HttpJsonContactCenterInsightsStub extends ContactCenterInsightsStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(DeleteIssueModelMetadata.getDescriptor())
          .add(DeployIssueModelMetadata.getDescriptor())
          .add(CreateAnalysisOperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .add(Analysis.getDescriptor())
          .add(ExportInsightsDataResponse.getDescriptor())
          .add(UndeployIssueModelResponse.getDescriptor())
          .add(CreateIssueModelMetadata.getDescriptor())
          .add(UndeployIssueModelMetadata.getDescriptor())
          .add(ExportInsightsDataMetadata.getDescriptor())
          .add(IssueModel.getDescriptor())
          .add(DeployIssueModelResponse.getDescriptor())
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
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<CreateConversationRequest, Conversation>
        createConversationTransportSettings =
            HttpJsonCallSettings.<CreateConversationRequest, Conversation>newBuilder()
                .setMethodDescriptor(createConversationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<UpdateConversationRequest, Conversation>
        updateConversationTransportSettings =
            HttpJsonCallSettings.<UpdateConversationRequest, Conversation>newBuilder()
                .setMethodDescriptor(updateConversationMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        HttpJsonCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            HttpJsonCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteConversationRequest, Empty> deleteConversationTransportSettings =
        HttpJsonCallSettings.<DeleteConversationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateAnalysisRequest, Operation> createAnalysisTransportSettings =
        HttpJsonCallSettings.<CreateAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetAnalysisRequest, Analysis> getAnalysisTransportSettings =
        HttpJsonCallSettings.<GetAnalysisRequest, Analysis>newBuilder()
            .setMethodDescriptor(getAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListAnalysesRequest, ListAnalysesResponse> listAnalysesTransportSettings =
        HttpJsonCallSettings.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
            .setMethodDescriptor(listAnalysesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteAnalysisRequest, Empty> deleteAnalysisTransportSettings =
        HttpJsonCallSettings.<DeleteAnalysisRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnalysisMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ExportInsightsDataRequest, Operation> exportInsightsDataTransportSettings =
        HttpJsonCallSettings.<ExportInsightsDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportInsightsDataMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateIssueModelRequest, Operation> createIssueModelTransportSettings =
        HttpJsonCallSettings.<CreateIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(createIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateIssueModelRequest, IssueModel> updateIssueModelTransportSettings =
        HttpJsonCallSettings.<UpdateIssueModelRequest, IssueModel>newBuilder()
            .setMethodDescriptor(updateIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIssueModelRequest, IssueModel> getIssueModelTransportSettings =
        HttpJsonCallSettings.<GetIssueModelRequest, IssueModel>newBuilder()
            .setMethodDescriptor(getIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListIssueModelsRequest, ListIssueModelsResponse>
        listIssueModelsTransportSettings =
            HttpJsonCallSettings.<ListIssueModelsRequest, ListIssueModelsResponse>newBuilder()
                .setMethodDescriptor(listIssueModelsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeleteIssueModelRequest, Operation> deleteIssueModelTransportSettings =
        HttpJsonCallSettings.<DeleteIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeployIssueModelRequest, Operation> deployIssueModelTransportSettings =
        HttpJsonCallSettings.<DeployIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(deployIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UndeployIssueModelRequest, Operation> undeployIssueModelTransportSettings =
        HttpJsonCallSettings.<UndeployIssueModelRequest, Operation>newBuilder()
            .setMethodDescriptor(undeployIssueModelMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetIssueRequest, Issue> getIssueTransportSettings =
        HttpJsonCallSettings.<GetIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(getIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesTransportSettings =
        HttpJsonCallSettings.<ListIssuesRequest, ListIssuesResponse>newBuilder()
            .setMethodDescriptor(listIssuesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateIssueRequest, Issue> updateIssueTransportSettings =
        HttpJsonCallSettings.<UpdateIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(updateIssueMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
        calculateIssueModelStatsTransportSettings =
            HttpJsonCallSettings
                .<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>newBuilder()
                .setMethodDescriptor(calculateIssueModelStatsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CreatePhraseMatcherRequest, PhraseMatcher>
        createPhraseMatcherTransportSettings =
            HttpJsonCallSettings.<CreatePhraseMatcherRequest, PhraseMatcher>newBuilder()
                .setMethodDescriptor(createPhraseMatcherMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherTransportSettings =
        HttpJsonCallSettings.<GetPhraseMatcherRequest, PhraseMatcher>newBuilder()
            .setMethodDescriptor(getPhraseMatcherMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
        listPhraseMatchersTransportSettings =
            HttpJsonCallSettings.<ListPhraseMatchersRequest, ListPhraseMatchersResponse>newBuilder()
                .setMethodDescriptor(listPhraseMatchersMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherTransportSettings =
        HttpJsonCallSettings.<DeletePhraseMatcherRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePhraseMatcherMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdatePhraseMatcherRequest, PhraseMatcher>
        updatePhraseMatcherTransportSettings =
            HttpJsonCallSettings.<UpdatePhraseMatcherRequest, PhraseMatcher>newBuilder()
                .setMethodDescriptor(updatePhraseMatcherMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<CalculateStatsRequest, CalculateStatsResponse>
        calculateStatsTransportSettings =
            HttpJsonCallSettings.<CalculateStatsRequest, CalculateStatsResponse>newBuilder()
                .setMethodDescriptor(calculateStatsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        HttpJsonCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        HttpJsonCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateViewRequest, View> createViewTransportSettings =
        HttpJsonCallSettings.<CreateViewRequest, View>newBuilder()
            .setMethodDescriptor(createViewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetViewRequest, View> getViewTransportSettings =
        HttpJsonCallSettings.<GetViewRequest, View>newBuilder()
            .setMethodDescriptor(getViewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListViewsRequest, ListViewsResponse> listViewsTransportSettings =
        HttpJsonCallSettings.<ListViewsRequest, ListViewsResponse>newBuilder()
            .setMethodDescriptor(listViewsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateViewRequest, View> updateViewTransportSettings =
        HttpJsonCallSettings.<UpdateViewRequest, View>newBuilder()
            .setMethodDescriptor(updateViewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<DeleteViewRequest, Empty> deleteViewTransportSettings =
        HttpJsonCallSettings.<DeleteViewRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteViewMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
    this.getIssueCallable =
        callableFactory.createUnaryCallable(
            getIssueTransportSettings, settings.getIssueSettings(), clientContext);
    this.listIssuesCallable =
        callableFactory.createUnaryCallable(
            listIssuesTransportSettings, settings.listIssuesSettings(), clientContext);
    this.updateIssueCallable =
        callableFactory.createUnaryCallable(
            updateIssueTransportSettings, settings.updateIssueSettings(), clientContext);
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

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(createConversationMethodDescriptor);
    methodDescriptors.add(updateConversationMethodDescriptor);
    methodDescriptors.add(getConversationMethodDescriptor);
    methodDescriptors.add(listConversationsMethodDescriptor);
    methodDescriptors.add(deleteConversationMethodDescriptor);
    methodDescriptors.add(createAnalysisMethodDescriptor);
    methodDescriptors.add(getAnalysisMethodDescriptor);
    methodDescriptors.add(listAnalysesMethodDescriptor);
    methodDescriptors.add(deleteAnalysisMethodDescriptor);
    methodDescriptors.add(exportInsightsDataMethodDescriptor);
    methodDescriptors.add(createIssueModelMethodDescriptor);
    methodDescriptors.add(updateIssueModelMethodDescriptor);
    methodDescriptors.add(getIssueModelMethodDescriptor);
    methodDescriptors.add(listIssueModelsMethodDescriptor);
    methodDescriptors.add(deleteIssueModelMethodDescriptor);
    methodDescriptors.add(deployIssueModelMethodDescriptor);
    methodDescriptors.add(undeployIssueModelMethodDescriptor);
    methodDescriptors.add(getIssueMethodDescriptor);
    methodDescriptors.add(listIssuesMethodDescriptor);
    methodDescriptors.add(updateIssueMethodDescriptor);
    methodDescriptors.add(calculateIssueModelStatsMethodDescriptor);
    methodDescriptors.add(createPhraseMatcherMethodDescriptor);
    methodDescriptors.add(getPhraseMatcherMethodDescriptor);
    methodDescriptors.add(listPhraseMatchersMethodDescriptor);
    methodDescriptors.add(deletePhraseMatcherMethodDescriptor);
    methodDescriptors.add(updatePhraseMatcherMethodDescriptor);
    methodDescriptors.add(calculateStatsMethodDescriptor);
    methodDescriptors.add(getSettingsMethodDescriptor);
    methodDescriptors.add(updateSettingsMethodDescriptor);
    methodDescriptors.add(createViewMethodDescriptor);
    methodDescriptors.add(getViewMethodDescriptor);
    methodDescriptors.add(listViewsMethodDescriptor);
    methodDescriptors.add(updateViewMethodDescriptor);
    methodDescriptors.add(deleteViewMethodDescriptor);
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
