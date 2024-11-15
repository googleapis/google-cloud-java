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

package com.google.cloud.contactcenterinsights.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsGrpc.ContactCenterInsightsImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockContactCenterInsightsImpl extends ContactCenterInsightsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockContactCenterInsightsImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void createConversation(
      CreateConversationRequest request, StreamObserver<Conversation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Conversation) {
      requests.add(request);
      responseObserver.onNext(((Conversation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void uploadConversation(
      UploadConversationRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UploadConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConversation(
      UpdateConversationRequest request, StreamObserver<Conversation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Conversation) {
      requests.add(request);
      responseObserver.onNext(((Conversation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConversation(
      GetConversationRequest request, StreamObserver<Conversation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Conversation) {
      requests.add(request);
      responseObserver.onNext(((Conversation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Conversation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConversations(
      ListConversationsRequest request,
      StreamObserver<ListConversationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConversationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConversationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConversations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConversationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConversation(
      DeleteConversationRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteConversation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAnalysis(
      CreateAnalysisRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAnalysis, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAnalysis(GetAnalysisRequest request, StreamObserver<Analysis> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Analysis) {
      requests.add(request);
      responseObserver.onNext(((Analysis) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAnalysis, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Analysis.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAnalyses(
      ListAnalysesRequest request, StreamObserver<ListAnalysesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAnalysesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAnalysesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAnalyses, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAnalysesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAnalysis(
      DeleteAnalysisRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteAnalysis, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void bulkAnalyzeConversations(
      BulkAnalyzeConversationsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BulkAnalyzeConversations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void bulkDeleteConversations(
      BulkDeleteConversationsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BulkDeleteConversations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void ingestConversations(
      IngestConversationsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method IngestConversations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportInsightsData(
      ExportInsightsDataRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportInsightsData, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createIssueModel(
      CreateIssueModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateIssueModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIssueModel(
      UpdateIssueModelRequest request, StreamObserver<IssueModel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IssueModel) {
      requests.add(request);
      responseObserver.onNext(((IssueModel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateIssueModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IssueModel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIssueModel(
      GetIssueModelRequest request, StreamObserver<IssueModel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IssueModel) {
      requests.add(request);
      responseObserver.onNext(((IssueModel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIssueModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IssueModel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIssueModels(
      ListIssueModelsRequest request, StreamObserver<ListIssueModelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIssueModelsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIssueModelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIssueModels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIssueModelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIssueModel(
      DeleteIssueModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteIssueModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deployIssueModel(
      DeployIssueModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeployIssueModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeployIssueModel(
      UndeployIssueModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UndeployIssueModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportIssueModel(
      ExportIssueModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExportIssueModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importIssueModel(
      ImportIssueModelRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportIssueModel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIssue(GetIssueRequest request, StreamObserver<Issue> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Issue) {
      requests.add(request);
      responseObserver.onNext(((Issue) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIssue, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Issue.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIssues(
      ListIssuesRequest request, StreamObserver<ListIssuesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIssuesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIssuesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIssues, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIssuesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIssue(UpdateIssueRequest request, StreamObserver<Issue> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Issue) {
      requests.add(request);
      responseObserver.onNext(((Issue) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateIssue, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Issue.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIssue(DeleteIssueRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteIssue, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void calculateIssueModelStats(
      CalculateIssueModelStatsRequest request,
      StreamObserver<CalculateIssueModelStatsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CalculateIssueModelStatsResponse) {
      requests.add(request);
      responseObserver.onNext(((CalculateIssueModelStatsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CalculateIssueModelStats, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CalculateIssueModelStatsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPhraseMatcher(
      CreatePhraseMatcherRequest request, StreamObserver<PhraseMatcher> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PhraseMatcher) {
      requests.add(request);
      responseObserver.onNext(((PhraseMatcher) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePhraseMatcher, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PhraseMatcher.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPhraseMatcher(
      GetPhraseMatcherRequest request, StreamObserver<PhraseMatcher> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PhraseMatcher) {
      requests.add(request);
      responseObserver.onNext(((PhraseMatcher) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPhraseMatcher, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PhraseMatcher.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPhraseMatchers(
      ListPhraseMatchersRequest request,
      StreamObserver<ListPhraseMatchersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPhraseMatchersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPhraseMatchersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPhraseMatchers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPhraseMatchersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePhraseMatcher(
      DeletePhraseMatcherRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeletePhraseMatcher, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePhraseMatcher(
      UpdatePhraseMatcherRequest request, StreamObserver<PhraseMatcher> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PhraseMatcher) {
      requests.add(request);
      responseObserver.onNext(((PhraseMatcher) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePhraseMatcher, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PhraseMatcher.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void calculateStats(
      CalculateStatsRequest request, StreamObserver<CalculateStatsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CalculateStatsResponse) {
      requests.add(request);
      responseObserver.onNext(((CalculateStatsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CalculateStats, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CalculateStatsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSettings(GetSettingsRequest request, StreamObserver<Settings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Settings) {
      requests.add(request);
      responseObserver.onNext(((Settings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Settings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSettings(
      UpdateSettingsRequest request, StreamObserver<Settings> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Settings) {
      requests.add(request);
      responseObserver.onNext(((Settings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSettings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Settings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAnalysisRule(
      CreateAnalysisRuleRequest request, StreamObserver<AnalysisRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalysisRule) {
      requests.add(request);
      responseObserver.onNext(((AnalysisRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAnalysisRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalysisRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAnalysisRule(
      GetAnalysisRuleRequest request, StreamObserver<AnalysisRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalysisRule) {
      requests.add(request);
      responseObserver.onNext(((AnalysisRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAnalysisRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalysisRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAnalysisRules(
      ListAnalysisRulesRequest request,
      StreamObserver<ListAnalysisRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAnalysisRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAnalysisRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAnalysisRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAnalysisRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAnalysisRule(
      UpdateAnalysisRuleRequest request, StreamObserver<AnalysisRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalysisRule) {
      requests.add(request);
      responseObserver.onNext(((AnalysisRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAnalysisRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalysisRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAnalysisRule(
      DeleteAnalysisRuleRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteAnalysisRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEncryptionSpec(
      GetEncryptionSpecRequest request, StreamObserver<EncryptionSpec> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EncryptionSpec) {
      requests.add(request);
      responseObserver.onNext(((EncryptionSpec) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEncryptionSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EncryptionSpec.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void initializeEncryptionSpec(
      InitializeEncryptionSpecRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method InitializeEncryptionSpec, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createView(CreateViewRequest request, StreamObserver<View> responseObserver) {
    Object response = responses.poll();
    if (response instanceof View) {
      requests.add(request);
      responseObserver.onNext(((View) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  View.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getView(GetViewRequest request, StreamObserver<View> responseObserver) {
    Object response = responses.poll();
    if (response instanceof View) {
      requests.add(request);
      responseObserver.onNext(((View) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  View.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listViews(
      ListViewsRequest request, StreamObserver<ListViewsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListViewsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListViewsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListViews, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListViewsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateView(UpdateViewRequest request, StreamObserver<View> responseObserver) {
    Object response = responses.poll();
    if (response instanceof View) {
      requests.add(request);
      responseObserver.onNext(((View) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  View.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteView(DeleteViewRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteView, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void queryMetrics(
      QueryMetricsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method QueryMetrics, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createQaQuestion(
      CreateQaQuestionRequest request, StreamObserver<QaQuestion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaQuestion) {
      requests.add(request);
      responseObserver.onNext(((QaQuestion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateQaQuestion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaQuestion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getQaQuestion(
      GetQaQuestionRequest request, StreamObserver<QaQuestion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaQuestion) {
      requests.add(request);
      responseObserver.onNext(((QaQuestion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetQaQuestion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaQuestion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateQaQuestion(
      UpdateQaQuestionRequest request, StreamObserver<QaQuestion> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaQuestion) {
      requests.add(request);
      responseObserver.onNext(((QaQuestion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateQaQuestion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaQuestion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteQaQuestion(
      DeleteQaQuestionRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteQaQuestion, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listQaQuestions(
      ListQaQuestionsRequest request, StreamObserver<ListQaQuestionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListQaQuestionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListQaQuestionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListQaQuestions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListQaQuestionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createQaScorecard(
      CreateQaScorecardRequest request, StreamObserver<QaScorecard> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaScorecard) {
      requests.add(request);
      responseObserver.onNext(((QaScorecard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateQaScorecard, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaScorecard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getQaScorecard(
      GetQaScorecardRequest request, StreamObserver<QaScorecard> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaScorecard) {
      requests.add(request);
      responseObserver.onNext(((QaScorecard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetQaScorecard, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaScorecard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateQaScorecard(
      UpdateQaScorecardRequest request, StreamObserver<QaScorecard> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaScorecard) {
      requests.add(request);
      responseObserver.onNext(((QaScorecard) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateQaScorecard, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaScorecard.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteQaScorecard(
      DeleteQaScorecardRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteQaScorecard, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listQaScorecards(
      ListQaScorecardsRequest request, StreamObserver<ListQaScorecardsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListQaScorecardsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListQaScorecardsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListQaScorecards, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListQaScorecardsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createQaScorecardRevision(
      CreateQaScorecardRevisionRequest request,
      StreamObserver<QaScorecardRevision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaScorecardRevision) {
      requests.add(request);
      responseObserver.onNext(((QaScorecardRevision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateQaScorecardRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaScorecardRevision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getQaScorecardRevision(
      GetQaScorecardRevisionRequest request, StreamObserver<QaScorecardRevision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaScorecardRevision) {
      requests.add(request);
      responseObserver.onNext(((QaScorecardRevision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetQaScorecardRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaScorecardRevision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void tuneQaScorecardRevision(
      TuneQaScorecardRevisionRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TuneQaScorecardRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deployQaScorecardRevision(
      DeployQaScorecardRevisionRequest request,
      StreamObserver<QaScorecardRevision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaScorecardRevision) {
      requests.add(request);
      responseObserver.onNext(((QaScorecardRevision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeployQaScorecardRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaScorecardRevision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeployQaScorecardRevision(
      UndeployQaScorecardRevisionRequest request,
      StreamObserver<QaScorecardRevision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof QaScorecardRevision) {
      requests.add(request);
      responseObserver.onNext(((QaScorecardRevision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UndeployQaScorecardRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  QaScorecardRevision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteQaScorecardRevision(
      DeleteQaScorecardRevisionRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteQaScorecardRevision, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listQaScorecardRevisions(
      ListQaScorecardRevisionsRequest request,
      StreamObserver<ListQaScorecardRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListQaScorecardRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListQaScorecardRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListQaScorecardRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListQaScorecardRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFeedbackLabel(
      CreateFeedbackLabelRequest request, StreamObserver<FeedbackLabel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeedbackLabel) {
      requests.add(request);
      responseObserver.onNext(((FeedbackLabel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFeedbackLabel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeedbackLabel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFeedbackLabels(
      ListFeedbackLabelsRequest request,
      StreamObserver<ListFeedbackLabelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFeedbackLabelsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFeedbackLabelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFeedbackLabels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFeedbackLabelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFeedbackLabel(
      GetFeedbackLabelRequest request, StreamObserver<FeedbackLabel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeedbackLabel) {
      requests.add(request);
      responseObserver.onNext(((FeedbackLabel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFeedbackLabel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeedbackLabel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFeedbackLabel(
      UpdateFeedbackLabelRequest request, StreamObserver<FeedbackLabel> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FeedbackLabel) {
      requests.add(request);
      responseObserver.onNext(((FeedbackLabel) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFeedbackLabel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FeedbackLabel.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFeedbackLabel(
      DeleteFeedbackLabelRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteFeedbackLabel, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAllFeedbackLabels(
      ListAllFeedbackLabelsRequest request,
      StreamObserver<ListAllFeedbackLabelsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAllFeedbackLabelsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAllFeedbackLabelsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAllFeedbackLabels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAllFeedbackLabelsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void bulkUploadFeedbackLabels(
      BulkUploadFeedbackLabelsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BulkUploadFeedbackLabels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void bulkDownloadFeedbackLabels(
      BulkDownloadFeedbackLabelsRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BulkDownloadFeedbackLabels, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
