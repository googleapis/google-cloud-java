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
package com.google.cloud.firestore.v1.stub;

import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListFieldsPagedResponse;
import static com.google.cloud.firestore.v1.FirestoreAdminClient.ListIndexesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.firestore.admin.v1.CreateIndexRequest;
import com.google.firestore.admin.v1.DeleteIndexRequest;
import com.google.firestore.admin.v1.ExportDocumentsRequest;
import com.google.firestore.admin.v1.Field;
import com.google.firestore.admin.v1.GetFieldRequest;
import com.google.firestore.admin.v1.GetIndexRequest;
import com.google.firestore.admin.v1.ImportDocumentsRequest;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.admin.v1.ListFieldsRequest;
import com.google.firestore.admin.v1.ListFieldsResponse;
import com.google.firestore.admin.v1.ListIndexesRequest;
import com.google.firestore.admin.v1.ListIndexesResponse;
import com.google.firestore.admin.v1.UpdateFieldRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for Google Cloud Firestore Admin API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class FirestoreAdminStub implements BackgroundResource {

  public UnaryCallable<CreateIndexRequest, Operation> createIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: createIndexCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesPagedResponse> listIndexesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesPagedCallable()");
  }

  public UnaryCallable<ListIndexesRequest, ListIndexesResponse> listIndexesCallable() {
    throw new UnsupportedOperationException("Not implemented: listIndexesCallable()");
  }

  public UnaryCallable<GetIndexRequest, Index> getIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: getIndexCallable()");
  }

  public UnaryCallable<DeleteIndexRequest, Empty> deleteIndexCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteIndexCallable()");
  }

  public UnaryCallable<ImportDocumentsRequest, Operation> importDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: importDocumentsCallable()");
  }

  public UnaryCallable<ExportDocumentsRequest, Operation> exportDocumentsCallable() {
    throw new UnsupportedOperationException("Not implemented: exportDocumentsCallable()");
  }

  public UnaryCallable<GetFieldRequest, Field> getFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: getFieldCallable()");
  }

  public UnaryCallable<ListFieldsRequest, ListFieldsPagedResponse> listFieldsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listFieldsPagedCallable()");
  }

  public UnaryCallable<ListFieldsRequest, ListFieldsResponse> listFieldsCallable() {
    throw new UnsupportedOperationException("Not implemented: listFieldsCallable()");
  }

  public UnaryCallable<UpdateFieldRequest, Operation> updateFieldCallable() {
    throw new UnsupportedOperationException("Not implemented: updateFieldCallable()");
  }

  @Override
  public abstract void close();
}
