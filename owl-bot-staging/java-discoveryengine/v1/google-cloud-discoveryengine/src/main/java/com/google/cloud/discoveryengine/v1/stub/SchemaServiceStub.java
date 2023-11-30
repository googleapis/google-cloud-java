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

package com.google.cloud.discoveryengine.v1.stub;

import static com.google.cloud.discoveryengine.v1.SchemaServiceClient.ListSchemasPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1.CreateSchemaMetadata;
import com.google.cloud.discoveryengine.v1.CreateSchemaRequest;
import com.google.cloud.discoveryengine.v1.DeleteSchemaMetadata;
import com.google.cloud.discoveryengine.v1.DeleteSchemaRequest;
import com.google.cloud.discoveryengine.v1.GetSchemaRequest;
import com.google.cloud.discoveryengine.v1.ListSchemasRequest;
import com.google.cloud.discoveryengine.v1.ListSchemasResponse;
import com.google.cloud.discoveryengine.v1.Schema;
import com.google.cloud.discoveryengine.v1.UpdateSchemaMetadata;
import com.google.cloud.discoveryengine.v1.UpdateSchemaRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SchemaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SchemaServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetSchemaRequest, Schema> getSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: getSchemaCallable()");
  }

  public UnaryCallable<ListSchemasRequest, ListSchemasPagedResponse> listSchemasPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSchemasPagedCallable()");
  }

  public UnaryCallable<ListSchemasRequest, ListSchemasResponse> listSchemasCallable() {
    throw new UnsupportedOperationException("Not implemented: listSchemasCallable()");
  }

  public OperationCallable<CreateSchemaRequest, Schema, CreateSchemaMetadata>
      createSchemaOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createSchemaOperationCallable()");
  }

  public UnaryCallable<CreateSchemaRequest, Operation> createSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: createSchemaCallable()");
  }

  public OperationCallable<UpdateSchemaRequest, Schema, UpdateSchemaMetadata>
      updateSchemaOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSchemaOperationCallable()");
  }

  public UnaryCallable<UpdateSchemaRequest, Operation> updateSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSchemaCallable()");
  }

  public OperationCallable<DeleteSchemaRequest, Empty, DeleteSchemaMetadata>
      deleteSchemaOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSchemaOperationCallable()");
  }

  public UnaryCallable<DeleteSchemaRequest, Operation> deleteSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSchemaCallable()");
  }

  @Override
  public abstract void close();
}
