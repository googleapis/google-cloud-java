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

package com.google.cloud.contentwarehouse.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.contentwarehouse.v1.DocumentServiceGrpc.DocumentServiceImplBase;
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
  public void createDocument(
      CreateDocumentRequest request, StreamObserver<CreateDocumentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CreateDocumentResponse) {
      requests.add(request);
      responseObserver.onNext(((CreateDocumentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CreateDocumentResponse.class.getName(),
                  Exception.class.getName())));
    }
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
  public void updateDocument(
      UpdateDocumentRequest request, StreamObserver<UpdateDocumentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof UpdateDocumentResponse) {
      requests.add(request);
      responseObserver.onNext(((UpdateDocumentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDocument, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  UpdateDocumentResponse.class.getName(),
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
  public void searchDocuments(
      SearchDocumentsRequest request, StreamObserver<SearchDocumentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchDocumentsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchDocumentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchDocuments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchDocumentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchAcl(FetchAclRequest request, StreamObserver<FetchAclResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchAclResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchAclResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchAcl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchAclResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setAcl(SetAclRequest request, StreamObserver<SetAclResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SetAclResponse) {
      requests.add(request);
      responseObserver.onNext(((SetAclResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetAcl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SetAclResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
