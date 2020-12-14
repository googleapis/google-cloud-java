/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.language.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.language.v1.LanguageServiceGrpc.LanguageServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockLanguageServiceImpl extends LanguageServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockLanguageServiceImpl() {
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
  public void analyzeSentiment(
      AnalyzeSentimentRequest request, StreamObserver<AnalyzeSentimentResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AnalyzeSentimentResponse) {
      requests.add(request);
      responseObserver.onNext(((AnalyzeSentimentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void analyzeEntities(
      AnalyzeEntitiesRequest request, StreamObserver<AnalyzeEntitiesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AnalyzeEntitiesResponse) {
      requests.add(request);
      responseObserver.onNext(((AnalyzeEntitiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void analyzeEntitySentiment(
      AnalyzeEntitySentimentRequest request,
      StreamObserver<AnalyzeEntitySentimentResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AnalyzeEntitySentimentResponse) {
      requests.add(request);
      responseObserver.onNext(((AnalyzeEntitySentimentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void analyzeSyntax(
      AnalyzeSyntaxRequest request, StreamObserver<AnalyzeSyntaxResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AnalyzeSyntaxResponse) {
      requests.add(request);
      responseObserver.onNext(((AnalyzeSyntaxResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void classifyText(
      ClassifyTextRequest request, StreamObserver<ClassifyTextResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ClassifyTextResponse) {
      requests.add(request);
      responseObserver.onNext(((ClassifyTextResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void annotateText(
      AnnotateTextRequest request, StreamObserver<AnnotateTextResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AnnotateTextResponse) {
      requests.add(request);
      responseObserver.onNext(((AnnotateTextResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
