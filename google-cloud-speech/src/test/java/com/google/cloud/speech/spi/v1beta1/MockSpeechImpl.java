/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.speech.spi.v1beta1;

import com.google.cloud.speech.v1beta1.AsyncRecognizeRequest;
import com.google.cloud.speech.v1beta1.SpeechGrpc.SpeechImplBase;
import com.google.cloud.speech.v1beta1.StreamingRecognizeRequest;
import com.google.cloud.speech.v1beta1.StreamingRecognizeResponse;
import com.google.cloud.speech.v1beta1.SyncRecognizeRequest;
import com.google.cloud.speech.v1beta1.SyncRecognizeResponse;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
public class MockSpeechImpl extends SpeechImplBase {
  private ArrayList<GeneratedMessageV3> requests;
  private Queue<GeneratedMessageV3> responses;

  public MockSpeechImpl() {
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
  public void syncRecognize(
      SyncRecognizeRequest request, StreamObserver<SyncRecognizeResponse> responseObserver) {
    SyncRecognizeResponse response = (SyncRecognizeResponse) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void asyncRecognize(
      AsyncRecognizeRequest request, StreamObserver<Operation> responseObserver) {
    Operation response = (Operation) responses.remove();
    requests.add(request);
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public StreamObserver<StreamingRecognizeRequest> streamingRecognize(
      StreamObserver<StreamingRecognizeResponse> responseObserver) {
    System.err.println("Streaming method is not supported.");
    return null;
  }
}
