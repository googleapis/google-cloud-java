/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.v2.stub;

import static com.google.cloud.dialogflow.v2.EntityTypesClient.ListEntityTypesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2.BatchCreateEntitiesRequest;
import com.google.cloud.dialogflow.v2.BatchDeleteEntitiesRequest;
import com.google.cloud.dialogflow.v2.BatchDeleteEntityTypesRequest;
import com.google.cloud.dialogflow.v2.BatchUpdateEntitiesRequest;
import com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesRequest;
import com.google.cloud.dialogflow.v2.BatchUpdateEntityTypesResponse;
import com.google.cloud.dialogflow.v2.CreateEntityTypeRequest;
import com.google.cloud.dialogflow.v2.DeleteEntityTypeRequest;
import com.google.cloud.dialogflow.v2.EntityType;
import com.google.cloud.dialogflow.v2.GetEntityTypeRequest;
import com.google.cloud.dialogflow.v2.ListEntityTypesRequest;
import com.google.cloud.dialogflow.v2.ListEntityTypesResponse;
import com.google.cloud.dialogflow.v2.UpdateEntityTypeRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EntityTypes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EntityTypesStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntityTypesPagedCallable()");
  }

  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse> listEntityTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntityTypesCallable()");
  }

  public UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntityTypeCallable()");
  }

  public UnaryCallable<CreateEntityTypeRequest, EntityType> createEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntityTypeCallable()");
  }

  public UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntityTypeCallable()");
  }

  public UnaryCallable<DeleteEntityTypeRequest, Empty> deleteEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntityTypeCallable()");
  }

  public OperationCallable<BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
      batchUpdateEntityTypesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateEntityTypesOperationCallable()");
  }

  public UnaryCallable<BatchUpdateEntityTypesRequest, Operation> batchUpdateEntityTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateEntityTypesCallable()");
  }

  public OperationCallable<BatchDeleteEntityTypesRequest, Empty, Struct>
      batchDeleteEntityTypesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeleteEntityTypesOperationCallable()");
  }

  public UnaryCallable<BatchDeleteEntityTypesRequest, Operation> batchDeleteEntityTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteEntityTypesCallable()");
  }

  public OperationCallable<BatchCreateEntitiesRequest, Empty, Struct>
      batchCreateEntitiesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateEntitiesOperationCallable()");
  }

  public UnaryCallable<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateEntitiesCallable()");
  }

  public OperationCallable<BatchUpdateEntitiesRequest, Empty, Struct>
      batchUpdateEntitiesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateEntitiesOperationCallable()");
  }

  public UnaryCallable<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateEntitiesCallable()");
  }

  public OperationCallable<BatchDeleteEntitiesRequest, Empty, Struct>
      batchDeleteEntitiesOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDeleteEntitiesOperationCallable()");
  }

  public UnaryCallable<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteEntitiesCallable()");
  }

  @Override
  public abstract void close();
}
