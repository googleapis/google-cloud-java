/*
 * Copyright 2021 Google LLC
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

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsExtractor;
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
import com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest;
import com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest;
import com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataMetadata;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest;
import com.google.cloud.contactcenterinsights.v1.ExportInsightsDataResponse;
import com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest;
import com.google.cloud.contactcenterinsights.v1.GetConversationRequest;
import com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest;
import com.google.cloud.contactcenterinsights.v1.GetIssueRequest;
import com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest;
import com.google.cloud.contactcenterinsights.v1.GetSettingsRequest;
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
import com.google.cloud.contactcenterinsights.v1.PhraseMatcher;
import com.google.cloud.contactcenterinsights.v1.Settings;
import com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest;
import com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest;
import com.google.common.collect.ImmutableMap;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.Map;
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
  private final UnaryCallable<GetIssueModelRequest, IssueModel> getIssueModelCallable;
  private final UnaryCallable<ListIssueModelsRequest, ListIssueModelsResponse>
      listIssueModelsCallable;
  private final UnaryCallable<GetIssueRequest, Issue> getIssueCallable;
  private final UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable;
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
  private final UnaryCallable<CalculateStatsRequest, CalculateStatsResponse> calculateStatsCallable;
  private final UnaryCallable<GetSettingsRequest, Settings> getSettingsCallable;
  private final UnaryCallable<UpdateSettingsRequest, Settings> updateSettingsCallable;

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
                new RequestParamsExtractor<CreateConversationRequest>() {
                  @Override
                  public Map<String, String> extract(CreateConversationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateConversationRequest, Conversation> updateConversationTransportSettings =
        GrpcCallSettings.<UpdateConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(updateConversationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateConversationRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateConversationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put(
                        "conversation.name", String.valueOf(request.getConversation().getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetConversationRequest, Conversation> getConversationTransportSettings =
        GrpcCallSettings.<GetConversationRequest, Conversation>newBuilder()
            .setMethodDescriptor(getConversationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetConversationRequest>() {
                  @Override
                  public Map<String, String> extract(GetConversationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListConversationsRequest, ListConversationsResponse>
        listConversationsTransportSettings =
            GrpcCallSettings.<ListConversationsRequest, ListConversationsResponse>newBuilder()
                .setMethodDescriptor(listConversationsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListConversationsRequest>() {
                      @Override
                      public Map<String, String> extract(ListConversationsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeleteConversationRequest, Empty> deleteConversationTransportSettings =
        GrpcCallSettings.<DeleteConversationRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteConversationMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteConversationRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteConversationRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CreateAnalysisRequest, Operation> createAnalysisTransportSettings =
        GrpcCallSettings.<CreateAnalysisRequest, Operation>newBuilder()
            .setMethodDescriptor(createAnalysisMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<CreateAnalysisRequest>() {
                  @Override
                  public Map<String, String> extract(CreateAnalysisRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetAnalysisRequest, Analysis> getAnalysisTransportSettings =
        GrpcCallSettings.<GetAnalysisRequest, Analysis>newBuilder()
            .setMethodDescriptor(getAnalysisMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetAnalysisRequest>() {
                  @Override
                  public Map<String, String> extract(GetAnalysisRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListAnalysesRequest, ListAnalysesResponse> listAnalysesTransportSettings =
        GrpcCallSettings.<ListAnalysesRequest, ListAnalysesResponse>newBuilder()
            .setMethodDescriptor(listAnalysesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListAnalysesRequest>() {
                  @Override
                  public Map<String, String> extract(ListAnalysesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<DeleteAnalysisRequest, Empty> deleteAnalysisTransportSettings =
        GrpcCallSettings.<DeleteAnalysisRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteAnalysisMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeleteAnalysisRequest>() {
                  @Override
                  public Map<String, String> extract(DeleteAnalysisRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ExportInsightsDataRequest, Operation> exportInsightsDataTransportSettings =
        GrpcCallSettings.<ExportInsightsDataRequest, Operation>newBuilder()
            .setMethodDescriptor(exportInsightsDataMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ExportInsightsDataRequest>() {
                  @Override
                  public Map<String, String> extract(ExportInsightsDataRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<GetIssueModelRequest, IssueModel> getIssueModelTransportSettings =
        GrpcCallSettings.<GetIssueModelRequest, IssueModel>newBuilder()
            .setMethodDescriptor(getIssueModelMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIssueModelRequest>() {
                  @Override
                  public Map<String, String> extract(GetIssueModelRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListIssueModelsRequest, ListIssueModelsResponse>
        listIssueModelsTransportSettings =
            GrpcCallSettings.<ListIssueModelsRequest, ListIssueModelsResponse>newBuilder()
                .setMethodDescriptor(listIssueModelsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListIssueModelsRequest>() {
                      @Override
                      public Map<String, String> extract(ListIssueModelsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetIssueRequest, Issue> getIssueTransportSettings =
        GrpcCallSettings.<GetIssueRequest, Issue>newBuilder()
            .setMethodDescriptor(getIssueMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetIssueRequest>() {
                  @Override
                  public Map<String, String> extract(GetIssueRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListIssuesRequest, ListIssuesResponse> listIssuesTransportSettings =
        GrpcCallSettings.<ListIssuesRequest, ListIssuesResponse>newBuilder()
            .setMethodDescriptor(listIssuesMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<ListIssuesRequest>() {
                  @Override
                  public Map<String, String> extract(ListIssuesRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("parent", String.valueOf(request.getParent()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>
        calculateIssueModelStatsTransportSettings =
            GrpcCallSettings
                .<CalculateIssueModelStatsRequest, CalculateIssueModelStatsResponse>newBuilder()
                .setMethodDescriptor(calculateIssueModelStatsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CalculateIssueModelStatsRequest>() {
                      @Override
                      public Map<String, String> extract(CalculateIssueModelStatsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("issue_model", String.valueOf(request.getIssueModel()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<CreatePhraseMatcherRequest, PhraseMatcher>
        createPhraseMatcherTransportSettings =
            GrpcCallSettings.<CreatePhraseMatcherRequest, PhraseMatcher>newBuilder()
                .setMethodDescriptor(createPhraseMatcherMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CreatePhraseMatcherRequest>() {
                      @Override
                      public Map<String, String> extract(CreatePhraseMatcherRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetPhraseMatcherRequest, PhraseMatcher> getPhraseMatcherTransportSettings =
        GrpcCallSettings.<GetPhraseMatcherRequest, PhraseMatcher>newBuilder()
            .setMethodDescriptor(getPhraseMatcherMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetPhraseMatcherRequest>() {
                  @Override
                  public Map<String, String> extract(GetPhraseMatcherRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<ListPhraseMatchersRequest, ListPhraseMatchersResponse>
        listPhraseMatchersTransportSettings =
            GrpcCallSettings.<ListPhraseMatchersRequest, ListPhraseMatchersResponse>newBuilder()
                .setMethodDescriptor(listPhraseMatchersMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<ListPhraseMatchersRequest>() {
                      @Override
                      public Map<String, String> extract(ListPhraseMatchersRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("parent", String.valueOf(request.getParent()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<DeletePhraseMatcherRequest, Empty> deletePhraseMatcherTransportSettings =
        GrpcCallSettings.<DeletePhraseMatcherRequest, Empty>newBuilder()
            .setMethodDescriptor(deletePhraseMatcherMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<DeletePhraseMatcherRequest>() {
                  @Override
                  public Map<String, String> extract(DeletePhraseMatcherRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<CalculateStatsRequest, CalculateStatsResponse>
        calculateStatsTransportSettings =
            GrpcCallSettings.<CalculateStatsRequest, CalculateStatsResponse>newBuilder()
                .setMethodDescriptor(calculateStatsMethodDescriptor)
                .setParamsExtractor(
                    new RequestParamsExtractor<CalculateStatsRequest>() {
                      @Override
                      public Map<String, String> extract(CalculateStatsRequest request) {
                        ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                        params.put("location", String.valueOf(request.getLocation()));
                        return params.build();
                      }
                    })
                .build();
    GrpcCallSettings<GetSettingsRequest, Settings> getSettingsTransportSettings =
        GrpcCallSettings.<GetSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(getSettingsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<GetSettingsRequest>() {
                  @Override
                  public Map<String, String> extract(GetSettingsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("name", String.valueOf(request.getName()));
                    return params.build();
                  }
                })
            .build();
    GrpcCallSettings<UpdateSettingsRequest, Settings> updateSettingsTransportSettings =
        GrpcCallSettings.<UpdateSettingsRequest, Settings>newBuilder()
            .setMethodDescriptor(updateSettingsMethodDescriptor)
            .setParamsExtractor(
                new RequestParamsExtractor<UpdateSettingsRequest>() {
                  @Override
                  public Map<String, String> extract(UpdateSettingsRequest request) {
                    ImmutableMap.Builder<String, String> params = ImmutableMap.builder();
                    params.put("settings.name", String.valueOf(request.getSettings().getName()));
                    return params.build();
                  }
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
    this.getIssueModelCallable =
        callableFactory.createUnaryCallable(
            getIssueModelTransportSettings, settings.getIssueModelSettings(), clientContext);
    this.listIssueModelsCallable =
        callableFactory.createUnaryCallable(
            listIssueModelsTransportSettings, settings.listIssueModelsSettings(), clientContext);
    this.getIssueCallable =
        callableFactory.createUnaryCallable(
            getIssueTransportSettings, settings.getIssueSettings(), clientContext);
    this.listIssuesCallable =
        callableFactory.createUnaryCallable(
            listIssuesTransportSettings, settings.listIssuesSettings(), clientContext);
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
    this.calculateStatsCallable =
        callableFactory.createUnaryCallable(
            calculateStatsTransportSettings, settings.calculateStatsSettings(), clientContext);
    this.getSettingsCallable =
        callableFactory.createUnaryCallable(
            getSettingsTransportSettings, settings.getSettingsSettings(), clientContext);
    this.updateSettingsCallable =
        callableFactory.createUnaryCallable(
            updateSettingsTransportSettings, settings.updateSettingsSettings(), clientContext);

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
  public UnaryCallable<GetIssueModelRequest, IssueModel> getIssueModelCallable() {
    return getIssueModelCallable;
  }

  @Override
  public UnaryCallable<ListIssueModelsRequest, ListIssueModelsResponse> listIssueModelsCallable() {
    return listIssueModelsCallable;
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
