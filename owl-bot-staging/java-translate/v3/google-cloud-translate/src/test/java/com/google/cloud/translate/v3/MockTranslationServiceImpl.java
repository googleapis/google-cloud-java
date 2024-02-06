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

package com.google.cloud.translate.v3;

import com.google.api.core.BetaApi;
import com.google.cloud.translate.v3.TranslationServiceGrpc.TranslationServiceImplBase;
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

  @Override
  public void createAdaptiveMtDataset(
      CreateAdaptiveMtDatasetRequest request, StreamObserver<AdaptiveMtDataset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AdaptiveMtDataset) {
      requests.add(request);
      responseObserver.onNext(((AdaptiveMtDataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAdaptiveMtDataset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AdaptiveMtDataset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAdaptiveMtDataset(
      DeleteAdaptiveMtDatasetRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAdaptiveMtDataset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAdaptiveMtDataset(
      GetAdaptiveMtDatasetRequest request, StreamObserver<AdaptiveMtDataset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AdaptiveMtDataset) {
      requests.add(request);
      responseObserver.onNext(((AdaptiveMtDataset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAdaptiveMtDataset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AdaptiveMtDataset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAdaptiveMtDatasets(
      ListAdaptiveMtDatasetsRequest request,
      StreamObserver<ListAdaptiveMtDatasetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAdaptiveMtDatasetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAdaptiveMtDatasetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAdaptiveMtDatasets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAdaptiveMtDatasetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void adaptiveMtTranslate(
      AdaptiveMtTranslateRequest request,
      StreamObserver<AdaptiveMtTranslateResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AdaptiveMtTranslateResponse) {
      requests.add(request);
      responseObserver.onNext(((AdaptiveMtTranslateResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AdaptiveMtTranslate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AdaptiveMtTranslateResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAdaptiveMtFile(
      GetAdaptiveMtFileRequest request, StreamObserver<AdaptiveMtFile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AdaptiveMtFile) {
      requests.add(request);
      responseObserver.onNext(((AdaptiveMtFile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAdaptiveMtFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AdaptiveMtFile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAdaptiveMtFile(
      DeleteAdaptiveMtFileRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAdaptiveMtFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importAdaptiveMtFile(
      ImportAdaptiveMtFileRequest request,
      StreamObserver<ImportAdaptiveMtFileResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ImportAdaptiveMtFileResponse) {
      requests.add(request);
      responseObserver.onNext(((ImportAdaptiveMtFileResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportAdaptiveMtFile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ImportAdaptiveMtFileResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAdaptiveMtFiles(
      ListAdaptiveMtFilesRequest request,
      StreamObserver<ListAdaptiveMtFilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAdaptiveMtFilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAdaptiveMtFilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAdaptiveMtFiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAdaptiveMtFilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAdaptiveMtSentences(
      ListAdaptiveMtSentencesRequest request,
      StreamObserver<ListAdaptiveMtSentencesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAdaptiveMtSentencesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAdaptiveMtSentencesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAdaptiveMtSentences, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAdaptiveMtSentencesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
