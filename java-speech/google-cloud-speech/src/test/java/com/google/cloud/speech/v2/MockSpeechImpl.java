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

package com.google.cloud.speech.v2;

import com.google.api.core.BetaApi;
import com.google.cloud.speech.v2.SpeechGrpc.SpeechImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockSpeechImpl extends SpeechImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSpeechImpl() {
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
  public void createRecognizer(
      CreateRecognizerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateRecognizer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRecognizers(
      ListRecognizersRequest request, StreamObserver<ListRecognizersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRecognizersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRecognizersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRecognizers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRecognizersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRecognizer(
      GetRecognizerRequest request, StreamObserver<Recognizer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Recognizer) {
      requests.add(request);
      responseObserver.onNext(((Recognizer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRecognizer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Recognizer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRecognizer(
      UpdateRecognizerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateRecognizer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRecognizer(
      DeleteRecognizerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRecognizer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeleteRecognizer(
      UndeleteRecognizerRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UndeleteRecognizer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void recognize(
      RecognizeRequest request, StreamObserver<RecognizeResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RecognizeResponse) {
      requests.add(request);
      responseObserver.onNext(((RecognizeResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Recognize, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RecognizeResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<StreamingRecognizeRequest> streamingRecognize(
      final StreamObserver<StreamingRecognizeResponse> responseObserver) {
    StreamObserver<StreamingRecognizeRequest> requestObserver =
        new StreamObserver<StreamingRecognizeRequest>() {
          @Override
          public void onNext(StreamingRecognizeRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof StreamingRecognizeResponse) {
              responseObserver.onNext(((StreamingRecognizeResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method StreamingRecognize, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          StreamingRecognizeResponse.class.getName(),
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
  public void batchRecognize(
      BatchRecognizeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method BatchRecognize, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConfig(GetConfigRequest request, StreamObserver<Config> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Config) {
      requests.add(request);
      responseObserver.onNext(((Config) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Config.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConfig(UpdateConfigRequest request, StreamObserver<Config> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Config) {
      requests.add(request);
      responseObserver.onNext(((Config) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Config.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCustomClass(
      CreateCustomClassRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCustomClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCustomClasses(
      ListCustomClassesRequest request,
      StreamObserver<ListCustomClassesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCustomClassesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCustomClassesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCustomClasses, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCustomClassesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCustomClass(
      GetCustomClassRequest request, StreamObserver<CustomClass> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CustomClass) {
      requests.add(request);
      responseObserver.onNext(((CustomClass) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCustomClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CustomClass.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCustomClass(
      UpdateCustomClassRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateCustomClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCustomClass(
      DeleteCustomClassRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCustomClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeleteCustomClass(
      UndeleteCustomClassRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UndeleteCustomClass, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPhraseSet(
      CreatePhraseSetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPhraseSets(
      ListPhraseSetsRequest request, StreamObserver<ListPhraseSetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPhraseSetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPhraseSetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPhraseSets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPhraseSetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPhraseSet(
      GetPhraseSetRequest request, StreamObserver<PhraseSet> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PhraseSet) {
      requests.add(request);
      responseObserver.onNext(((PhraseSet) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PhraseSet.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePhraseSet(
      UpdatePhraseSetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdatePhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePhraseSet(
      DeletePhraseSetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeletePhraseSet(
      UndeletePhraseSetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UndeletePhraseSet, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
