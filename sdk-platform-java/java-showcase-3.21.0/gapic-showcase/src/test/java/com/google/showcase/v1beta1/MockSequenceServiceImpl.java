/*
 * Copyright 2025 Google LLC
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

package com.google.showcase.v1beta1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.showcase.v1beta1.SequenceServiceGrpc.SequenceServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockSequenceServiceImpl extends SequenceServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSequenceServiceImpl() {
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
  public void createSequence(
      CreateSequenceRequest request, StreamObserver<Sequence> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Sequence) {
      requests.add(request);
      responseObserver.onNext(((Sequence) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSequence, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Sequence.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createStreamingSequence(
      CreateStreamingSequenceRequest request, StreamObserver<StreamingSequence> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StreamingSequence) {
      requests.add(request);
      responseObserver.onNext(((StreamingSequence) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateStreamingSequence, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  StreamingSequence.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSequenceReport(
      GetSequenceReportRequest request, StreamObserver<SequenceReport> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SequenceReport) {
      requests.add(request);
      responseObserver.onNext(((SequenceReport) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSequenceReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SequenceReport.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getStreamingSequenceReport(
      GetStreamingSequenceReportRequest request,
      StreamObserver<StreamingSequenceReport> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StreamingSequenceReport) {
      requests.add(request);
      responseObserver.onNext(((StreamingSequenceReport) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetStreamingSequenceReport, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StreamingSequenceReport.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void attemptSequence(
      AttemptSequenceRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method AttemptSequence, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void attemptStreamingSequence(
      AttemptStreamingSequenceRequest request,
      StreamObserver<AttemptStreamingSequenceResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AttemptStreamingSequenceResponse) {
      requests.add(request);
      responseObserver.onNext(((AttemptStreamingSequenceResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AttemptStreamingSequence, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AttemptStreamingSequenceResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
