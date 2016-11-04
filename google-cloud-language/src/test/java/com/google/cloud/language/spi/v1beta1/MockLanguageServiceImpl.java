/*
 * Copyright 2016, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.language.spi.v1beta1;

import com.google.cloud.language.v1beta1.AnalyzeEntitiesRequest;
import com.google.cloud.language.v1beta1.AnalyzeEntitiesResponse;
import com.google.cloud.language.v1beta1.AnalyzeSentimentRequest;
import com.google.cloud.language.v1beta1.AnalyzeSentimentResponse;
import com.google.cloud.language.v1beta1.AnnotateTextRequest;
import com.google.cloud.language.v1beta1.AnnotateTextResponse;
import com.google.cloud.language.v1beta1.LanguageServiceGrpc.LanguageServiceImplBase;
import com.google.common.collect.Lists;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
public class MockLanguageServiceImpl extends LanguageServiceImplBase {
  private ArrayList<GeneratedMessageV3> requests;
  private Queue<GeneratedMessageV3> responses;

  public MockLanguageServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<GeneratedMessageV3> getRequests() {
    return requests;
  }

  public void setResponses(List<GeneratedMessageV3> responses) {
    this.responses = Lists.newLinkedList(responses);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void analyzeSentiment(
      AnalyzeSentimentRequest request, StreamObserver<AnalyzeSentimentResponse> responseObserver) {
    AnalyzeSentimentResponse response = (AnalyzeSentimentResponse) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void analyzeEntities(
      AnalyzeEntitiesRequest request, StreamObserver<AnalyzeEntitiesResponse> responseObserver) {
    AnalyzeEntitiesResponse response = (AnalyzeEntitiesResponse) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void annotateText(
      AnnotateTextRequest request, StreamObserver<AnnotateTextResponse> responseObserver) {
    AnnotateTextResponse response = (AnnotateTextResponse) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
