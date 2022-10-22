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

package com.google.cloud.contentwarehouse.v1.stub;

import static com.google.cloud.contentwarehouse.v1.DocumentSchemaServiceClient.ListDocumentSchemasPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.contentwarehouse.v1.CreateDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.DeleteDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.DocumentSchema;
import com.google.cloud.contentwarehouse.v1.GetDocumentSchemaRequest;
import com.google.cloud.contentwarehouse.v1.ListDocumentSchemasRequest;
import com.google.cloud.contentwarehouse.v1.ListDocumentSchemasResponse;
import com.google.cloud.contentwarehouse.v1.UpdateDocumentSchemaRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DocumentSchemaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DocumentSchemaServiceStub implements BackgroundResource {

  public UnaryCallable<CreateDocumentSchemaRequest, DocumentSchema> createDocumentSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: createDocumentSchemaCallable()");
  }

  public UnaryCallable<UpdateDocumentSchemaRequest, DocumentSchema> updateDocumentSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDocumentSchemaCallable()");
  }

  public UnaryCallable<GetDocumentSchemaRequest, DocumentSchema> getDocumentSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: getDocumentSchemaCallable()");
  }

  public UnaryCallable<DeleteDocumentSchemaRequest, Empty> deleteDocumentSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDocumentSchemaCallable()");
  }

  public UnaryCallable<ListDocumentSchemasRequest, ListDocumentSchemasPagedResponse>
      listDocumentSchemasPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDocumentSchemasPagedCallable()");
  }

  public UnaryCallable<ListDocumentSchemasRequest, ListDocumentSchemasResponse>
      listDocumentSchemasCallable() {
    throw new UnsupportedOperationException("Not implemented: listDocumentSchemasCallable()");
  }

  @Override
  public abstract void close();
}
