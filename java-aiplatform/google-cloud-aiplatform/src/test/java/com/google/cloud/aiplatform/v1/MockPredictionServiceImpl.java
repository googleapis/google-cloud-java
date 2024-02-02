/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.aiplatform.v1;

import com.google.api.HttpBody;
import com.google.api.core.BetaApi;
import com.google.cloud.aiplatform.v1.PredictionServiceGrpc.PredictionServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockPredictionServiceImpl extends PredictionServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPredictionServiceImpl() {
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
  public void predict(PredictRequest request, StreamObserver<PredictResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PredictResponse) {
      requests.add(request);
      responseObserver.onNext(((PredictResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Predict, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PredictResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rawPredict(RawPredictRequest request, StreamObserver<HttpBody> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HttpBody) {
      requests.add(request);
      responseObserver.onNext(((HttpBody) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RawPredict, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HttpBody.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void streamRawPredict(
      StreamRawPredictRequest request, StreamObserver<HttpBody> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HttpBody) {
      requests.add(request);
      responseObserver.onNext(((HttpBody) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StreamRawPredict, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HttpBody.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void directPredict(
      DirectPredictRequest request, StreamObserver<DirectPredictResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DirectPredictResponse) {
      requests.add(request);
      responseObserver.onNext(((DirectPredictResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DirectPredict, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DirectPredictResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void directRawPredict(
      DirectRawPredictRequest request, StreamObserver<DirectRawPredictResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DirectRawPredictResponse) {
      requests.add(request);
      responseObserver.onNext(((DirectRawPredictResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DirectRawPredict, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DirectRawPredictResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<StreamDirectPredictRequest> streamDirectPredict(
      final StreamObserver<StreamDirectPredictResponse> responseObserver) {
    StreamObserver<StreamDirectPredictRequest> requestObserver =
        new StreamObserver<StreamDirectPredictRequest>() {
          @Override
          public void onNext(StreamDirectPredictRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamDirectPredictResponse) {
              responseObserver.onNext(((StreamDirectPredictResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamDirectPredict, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamDirectPredictResponse.class.getName(),
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
  public StreamObserver<StreamDirectRawPredictRequest> streamDirectRawPredict(
      final StreamObserver<StreamDirectRawPredictResponse> responseObserver) {
    StreamObserver<StreamDirectRawPredictRequest> requestObserver =
        new StreamObserver<StreamDirectRawPredictRequest>() {
          @Override
          public void onNext(StreamDirectRawPredictRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamDirectRawPredictResponse) {
              responseObserver.onNext(((StreamDirectRawPredictResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamDirectRawPredict, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamDirectRawPredictResponse.class.getName(),
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
  public StreamObserver<StreamingPredictRequest> streamingPredict(
      final StreamObserver<StreamingPredictResponse> responseObserver) {
    StreamObserver<StreamingPredictRequest> requestObserver =
        new StreamObserver<StreamingPredictRequest>() {
          @Override
          public void onNext(StreamingPredictRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamingPredictResponse) {
              responseObserver.onNext(((StreamingPredictResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamingPredict, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamingPredictResponse.class.getName(),
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
  public void serverStreamingPredict(
      StreamingPredictRequest request, StreamObserver<StreamingPredictResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof StreamingPredictResponse) {
      requests.add(request);
      responseObserver.onNext(((StreamingPredictResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ServerStreamingPredict, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  StreamingPredictResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<StreamingRawPredictRequest> streamingRawPredict(
      final StreamObserver<StreamingRawPredictResponse> responseObserver) {
    StreamObserver<StreamingRawPredictRequest> requestObserver =
        new StreamObserver<StreamingRawPredictRequest>() {
          @Override
          public void onNext(StreamingRawPredictRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamingRawPredictResponse) {
              responseObserver.onNext(((StreamingRawPredictResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamingRawPredict, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamingRawPredictResponse.class.getName(),
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
  public void explain(ExplainRequest request, StreamObserver<ExplainResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExplainResponse) {
      requests.add(request);
      responseObserver.onNext(((ExplainResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Explain, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExplainResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateContent(
      GenerateContentRequest request, StreamObserver<GenerateContentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateContentResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateContentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateContent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void streamGenerateContent(
      GenerateContentRequest request, StreamObserver<GenerateContentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateContentResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateContentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method StreamGenerateContent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateContentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
