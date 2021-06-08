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
}
