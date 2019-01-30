/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.firestore.v1beta1;

import com.google.api.core.BetaApi;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.BeginTransactionRequest;
import com.google.firestore.v1beta1.BeginTransactionResponse;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.CreateDocumentRequest;
import com.google.firestore.v1beta1.DeleteDocumentRequest;
import com.google.firestore.v1beta1.Document;
import com.google.firestore.v1beta1.FirestoreGrpc.FirestoreImplBase;
import com.google.firestore.v1beta1.GetDocumentRequest;
import com.google.firestore.v1beta1.ListCollectionIdsRequest;
import com.google.firestore.v1beta1.ListCollectionIdsResponse;
import com.google.firestore.v1beta1.ListDocumentsRequest;
import com.google.firestore.v1beta1.ListDocumentsResponse;
import com.google.firestore.v1beta1.ListenRequest;
import com.google.firestore.v1beta1.ListenResponse;
import com.google.firestore.v1beta1.RollbackRequest;
import com.google.firestore.v1beta1.RunQueryRequest;
import com.google.firestore.v1beta1.RunQueryResponse;
import com.google.firestore.v1beta1.UpdateDocumentRequest;
import com.google.firestore.v1beta1.WriteRequest;
import com.google.firestore.v1beta1.WriteResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.GeneratedMessageV3;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@javax.annotation.Generated("by GAPIC")
@BetaApi
public class MockFirestoreImpl extends FirestoreImplBase {
  private ArrayList<GeneratedMessageV3> requests;
  private Queue<Object> responses;

  public MockFirestoreImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<GeneratedMessageV3> getRequests() {
    return requests;
  }

  public void addResponse(GeneratedMessageV3 response) {
    responses.add(response);
  }

  public void setResponses(List<GeneratedMessageV3> responses) {
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
    Object response = responses.remove();
    if (response instanceof Document) {
      requests.add(request);
      responseObserver.onNext((Document) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listDocuments(
      ListDocumentsRequest request, StreamObserver<ListDocumentsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListDocumentsResponse) {
      requests.add(request);
      responseObserver.onNext((ListDocumentsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createDocument(
      CreateDocumentRequest request, StreamObserver<Document> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Document) {
      requests.add(request);
      responseObserver.onNext((Document) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateDocument(
      UpdateDocumentRequest request, StreamObserver<Document> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Document) {
      requests.add(request);
      responseObserver.onNext((Document) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void deleteDocument(
      DeleteDocumentRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void batchGetDocuments(
      BatchGetDocumentsRequest request,
      StreamObserver<BatchGetDocumentsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BatchGetDocumentsResponse) {
      requests.add(request);
      responseObserver.onNext((BatchGetDocumentsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void beginTransaction(
      BeginTransactionRequest request, StreamObserver<BeginTransactionResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof BeginTransactionResponse) {
      requests.add(request);
      responseObserver.onNext((BeginTransactionResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void commit(CommitRequest request, StreamObserver<CommitResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof CommitResponse) {
      requests.add(request);
      responseObserver.onNext((CommitResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void rollback(RollbackRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext((Empty) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void runQuery(RunQueryRequest request, StreamObserver<RunQueryResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof RunQueryResponse) {
      requests.add(request);
      responseObserver.onNext((RunQueryResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public StreamObserver<WriteRequest> write(final StreamObserver<WriteResponse> responseObserver) {
    final Object response = responses.remove();
    StreamObserver<WriteRequest> requestObserver =
        new StreamObserver<WriteRequest>() {
          @Override
          public void onNext(WriteRequest value) {
            if (response instanceof WriteResponse) {
              responseObserver.onNext((WriteResponse) response);
            } else if (response instanceof Exception) {
              responseObserver.onError((Exception) response);
            } else {
              responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
  public StreamObserver<ListenRequest> listen(
      final StreamObserver<ListenResponse> responseObserver) {
    final Object response = responses.remove();
    StreamObserver<ListenRequest> requestObserver =
        new StreamObserver<ListenRequest>() {
          @Override
          public void onNext(ListenRequest value) {
            if (response instanceof ListenResponse) {
              responseObserver.onNext((ListenResponse) response);
            } else if (response instanceof Exception) {
              responseObserver.onError((Exception) response);
            } else {
              responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
  public void listCollectionIds(
      ListCollectionIdsRequest request,
      StreamObserver<ListCollectionIdsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListCollectionIdsResponse) {
      requests.add(request);
      responseObserver.onNext((ListCollectionIdsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
