/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.firestore.v1beta1.stub;

import static com.google.cloud.firestore.v1beta1.PagedResponseWrappers.ListCollectionIdsPagedResponse;
import static com.google.cloud.firestore.v1beta1.PagedResponseWrappers.ListDocumentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.firestore.v1beta1.BatchGetDocumentsRequest;
import com.google.firestore.v1beta1.BatchGetDocumentsResponse;
import com.google.firestore.v1beta1.BeginTransactionRequest;
import com.google.firestore.v1beta1.BeginTransactionResponse;
import com.google.firestore.v1beta1.CommitRequest;
import com.google.firestore.v1beta1.CommitResponse;
import com.google.firestore.v1beta1.CreateDocumentRequest;
import com.google.firestore.v1beta1.DeleteDocumentRequest;
import com.google.firestore.v1beta1.Document;
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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Google Cloud Firestore API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by GAPIC v0.0.5")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class FirestoreStub implements BackgroundResource {

  public UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: getDocumentCallable()");
  }

  public UnaryCallable<ListDocumentsRequest, ListDocumentsPagedResponse>
      listDocumentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDocumentsPagedCallable()");
  }

  public UnaryCallable<ListDocumentsRequest, ListDocumentsResponse> listDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDocumentsCallable()");
  }

  public UnaryCallable<CreateDocumentRequest, Document> createDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: createDocumentCallable()");
  }

  public UnaryCallable<UpdateDocumentRequest, Document> updateDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDocumentCallable()");
  }

  public UnaryCallable<DeleteDocumentRequest, Empty> deleteDocumentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDocumentCallable()");
  }

  public ServerStreamingCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchGetDocumentsCallable()");
  }

  public UnaryCallable<BeginTransactionRequest, BeginTransactionResponse>
      beginTransactionCallable() {
    throw new UnsupportedOperationException("Not implemented: beginTransactionCallable()");
  }

  public UnaryCallable<CommitRequest, CommitResponse> commitCallable() {
    throw new UnsupportedOperationException("Not implemented: commitCallable()");
  }

  public UnaryCallable<RollbackRequest, Empty> rollbackCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackCallable()");
  }

  public ServerStreamingCallable<RunQueryRequest, RunQueryResponse> runQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: runQueryCallable()");
  }

  public BidiStreamingCallable<WriteRequest, WriteResponse> writeCallable() {
    throw new UnsupportedOperationException("Not implemented: writeCallable()");
  }

  public BidiStreamingCallable<ListenRequest, ListenResponse> listenCallable() {
    throw new UnsupportedOperationException("Not implemented: listenCallable()");
  }

  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsPagedResponse>
      listCollectionIdsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCollectionIdsPagedCallable()");
  }

  public UnaryCallable<ListCollectionIdsRequest, ListCollectionIdsResponse>
      listCollectionIdsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCollectionIdsCallable()");
  }
}
