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

  public UnaryCallable<GetIssueRequest, Issue> getIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: getIssueCallable()");
  }

  public UnaryCallable<ListIssuesRequest, ListIssuesResponse> listIssuesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIssuesCallable()");
  }

  public UnaryCallable<UpdateIssueRequest, Issue> updateIssueCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIssueCallable()");
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

  @Override
  public abstract void close();
}
