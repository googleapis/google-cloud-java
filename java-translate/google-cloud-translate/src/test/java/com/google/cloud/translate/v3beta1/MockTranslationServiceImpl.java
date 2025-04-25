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

package com.google.cloud.translate.v3beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.translate.v3beta1.TranslationServiceGrpc.TranslationServiceImplBase;
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
public class MockTranslationServiceImpl extends TranslationServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockTranslationServiceImpl() {
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
  public void translateText(
      TranslateTextRequest request, StreamObserver<TranslateTextResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TranslateTextResponse) {
      requests.add(request);
      responseObserver.onNext(((TranslateTextResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TranslateText, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TranslateTextResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void detectLanguage(
      DetectLanguageRequest request, StreamObserver<DetectLanguageResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DetectLanguageResponse) {
      requests.add(request);
      responseObserver.onNext(((DetectLanguageResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DetectLanguage, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DetectLanguageResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSupportedLanguages(
      GetSupportedLanguagesRequest request, StreamObserver<SupportedLanguages> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SupportedLanguages) {
      requests.add(request);
      responseObserver.onNext(((SupportedLanguages) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSupportedLanguages, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SupportedLanguages.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void translateDocument(
      TranslateDocumentRequest request,
      StreamObserver<TranslateDocumentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TranslateDocumentResponse) {
      requests.add(request);
      responseObserver.onNext(((TranslateDocumentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TranslateDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TranslateDocumentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchTranslateText(
      BatchTranslateTextRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method BatchTranslateText, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchTranslateDocument(
      BatchTranslateDocumentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method BatchTranslateDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createGlossary(
      CreateGlossaryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateGlossary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listGlossaries(
      ListGlossariesRequest request, StreamObserver<ListGlossariesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListGlossariesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListGlossariesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListGlossaries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListGlossariesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getGlossary(GetGlossaryRequest request, StreamObserver<Glossary> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Glossary) {
      requests.add(request);
      responseObserver.onNext(((Glossary) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetGlossary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Glossary.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteGlossary(
      DeleteGlossaryRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteGlossary, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
