/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.firestore.v1;

import com.google.api.core.BetaApi;
import com.google.firestore.v1.BatchGetDocumentsRequest;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.BatchWriteRequest;
import com.google.firestore.v1.BatchWriteResponse;
import com.google.firestore.v1.BeginTransactionRequest;
import com.google.firestore.v1.BeginTransactionResponse;
import com.google.firestore.v1.CommitRequest;
import com.google.firestore.v1.CommitResponse;
import com.google.firestore.v1.CreateDocumentRequest;
import com.google.firestore.v1.DeleteDocumentRequest;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.ExecutePipelineRequest;
import com.google.firestore.v1.ExecutePipelineResponse;
import com.google.firestore.v1.FirestoreGrpc.FirestoreImplBase;
import com.google.firestore.v1.GetDocumentRequest;
import com.google.firestore.v1.ListCollectionIdsRequest;
import com.google.firestore.v1.ListCollectionIdsResponse;
import com.google.firestore.v1.ListDocumentsRequest;
import com.google.firestore.v1.ListDocumentsResponse;
import com.google.firestore.v1.ListenRequest;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.PartitionQueryRequest;
import com.google.firestore.v1.PartitionQueryResponse;
import com.google.firestore.v1.RollbackRequest;
import com.google.firestore.v1.RunAggregationQueryRequest;
import com.google.firestore.v1.RunAggregationQueryResponse;
import com.google.firestore.v1.RunQueryRequest;
import com.google.firestore.v1.RunQueryResponse;
import com.google.firestore.v1.UpdateDocumentRequest;
import com.google.firestore.v1.WriteRequest;
import com.google.firestore.v1.WriteResponse;
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
public class MockFirestoreImpl extends FirestoreImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockFirestoreImpl() {
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
  public void batchGetDocuments(
      BatchGetDocumentsRequest request,
      StreamObserver<BatchGetDocumentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchGetDocumentsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchGetDocumentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchGetDocuments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchGetDocumentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void beginTransaction(
      BeginTransactionRequest request, StreamObserver<BeginTransactionResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BeginTransactionResponse) {
      requests.add(request);
      responseObserver.onNext(((BeginTransactionResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BeginTransaction, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BeginTransactionResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void commit(CommitRequest request, StreamObserver<CommitResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CommitResponse) {
      requests.add(request);
      responseObserver.onNext(((CommitResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method Commit, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CommitResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rollback(RollbackRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method Rollback, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runQuery(RunQueryRequest request, StreamObserver<RunQueryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunQueryResponse) {
      requests.add(request);
      responseObserver.onNext(((RunQueryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunQueryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void executePipeline(
      ExecutePipelineRequest request, StreamObserver<ExecutePipelineResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ExecutePipelineResponse) {
      requests.add(request);
      responseObserver.onNext(((ExecutePipelineResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ExecutePipeline, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExecutePipelineResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runAggregationQuery(
      RunAggregationQueryRequest request,
      StreamObserver<RunAggregationQueryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RunAggregationQueryResponse) {
      requests.add(request);
      responseObserver.onNext(((RunAggregationQueryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunAggregationQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RunAggregationQueryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void partitionQuery(
      PartitionQueryRequest request, StreamObserver<PartitionQueryResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PartitionQueryResponse) {
      requests.add(request);
      responseObserver.onNext(((PartitionQueryResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method PartitionQuery, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PartitionQueryResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<WriteRequest> write(final StreamObserver<WriteResponse> responseObserver) {
    StreamObserver<WriteRequest> requestObserver =
        new StreamObserver<WriteRequest>() {
          @Override
          public void onNext(WriteRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof WriteResponse) {
              responseObserver.onNext(((WriteResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method Write, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          WriteResponse.class.getName(),
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
  public StreamObserver<ListenRequest> listen(
      final StreamObserver<ListenResponse> responseObserver) {
    StreamObserver<ListenRequest> requestObserver =
        new StreamObserver<ListenRequest>() {
          @Override
          public void onNext(ListenRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof ListenResponse) {
              responseObserver.onNext(((ListenResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method Listen, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          ListenResponse.class.getName(),
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
  public void listCollectionIds(
      ListCollectionIdsRequest request,
      StreamObserver<ListCollectionIdsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCollectionIdsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCollectionIdsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCollectionIds, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCollectionIdsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchWrite(
      BatchWriteRequest request, StreamObserver<BatchWriteResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchWriteResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchWriteResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchWrite, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchWriteResponse.class.getName(),
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
}
