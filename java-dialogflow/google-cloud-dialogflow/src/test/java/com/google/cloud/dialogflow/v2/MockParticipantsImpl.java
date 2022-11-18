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

package com.google.cloud.dialogflow.v2;

import com.google.api.core.BetaApi;
import com.google.cloud.dialogflow.v2.ParticipantsGrpc.ParticipantsImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockParticipantsImpl extends ParticipantsImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockParticipantsImpl() {
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
  public void createParticipant(
      CreateParticipantRequest request, StreamObserver<Participant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Participant) {
      requests.add(request);
      responseObserver.onNext(((Participant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateParticipant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Participant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getParticipant(
      GetParticipantRequest request, StreamObserver<Participant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Participant) {
      requests.add(request);
      responseObserver.onNext(((Participant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetParticipant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Participant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listParticipants(
      ListParticipantsRequest request, StreamObserver<ListParticipantsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListParticipantsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListParticipantsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListParticipants, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListParticipantsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateParticipant(
      UpdateParticipantRequest request, StreamObserver<Participant> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Participant) {
      requests.add(request);
      responseObserver.onNext(((Participant) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateParticipant, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Participant.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void analyzeContent(
      AnalyzeContentRequest request, StreamObserver<AnalyzeContentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnalyzeContentResponse) {
      requests.add(request);
      responseObserver.onNext(((AnalyzeContentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AnalyzeContent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnalyzeContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<StreamingAnalyzeContentRequest> streamingAnalyzeContent(
      final StreamObserver<StreamingAnalyzeContentResponse> responseObserver) {
    StreamObserver<StreamingAnalyzeContentRequest> requestObserver =
        new StreamObserver<StreamingAnalyzeContentRequest>() {
          @Override
          public void onNext(StreamingAnalyzeContentRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamingAnalyzeContentResponse) {
              responseObserver.onNext(((StreamingAnalyzeContentResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamingAnalyzeContent, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamingAnalyzeContentResponse.class.getName(),
                          Exception.class.getName())));
            }
          }

          @Override
          public void onError(Throwable t) {
            responseObserver.onError(t);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        };
    return requestObserver;
  }

  @Override
  public void suggestArticles(
      SuggestArticlesRequest request, StreamObserver<SuggestArticlesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SuggestArticlesResponse) {
      requests.add(request);
      responseObserver.onNext(((SuggestArticlesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SuggestArticles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SuggestArticlesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void suggestFaqAnswers(
      SuggestFaqAnswersRequest request,
      StreamObserver<SuggestFaqAnswersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SuggestFaqAnswersResponse) {
      requests.add(request);
      responseObserver.onNext(((SuggestFaqAnswersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SuggestFaqAnswers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SuggestFaqAnswersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void suggestSmartReplies(
      SuggestSmartRepliesRequest request,
      StreamObserver<SuggestSmartRepliesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SuggestSmartRepliesResponse) {
      requests.add(request);
      responseObserver.onNext(((SuggestSmartRepliesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SuggestSmartReplies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SuggestSmartRepliesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
