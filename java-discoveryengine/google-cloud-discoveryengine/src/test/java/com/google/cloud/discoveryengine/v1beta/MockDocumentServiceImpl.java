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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.discoveryengine.v1beta.DocumentServiceGrpc.DocumentServiceImplBase;
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
public class MockDocumentServiceImpl extends DocumentServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDocumentServiceImpl() {
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
  public void getDocument(GetDocumentRequest request, StreamObserver<Document> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Document) {
      requests.add(request);
      responseObserver.onNext(((Document) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Document.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDocuments(
      ListDocumentsRequest request, StreamObserver<ListDocumentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDocumentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDocumentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDocuments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDocumentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDocument(
      CreateDocumentRequest request, StreamObserver<Document> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Document) {
      requests.add(request);
      responseObserver.onNext(((Document) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Document.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDocument(
      UpdateDocumentRequest request, StreamObserver<Document> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Document) {
      requests.add(request);
      responseObserver.onNext(((Document) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Document.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDocument(
      DeleteDocumentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importDocuments(
      ImportDocumentsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportDocuments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
