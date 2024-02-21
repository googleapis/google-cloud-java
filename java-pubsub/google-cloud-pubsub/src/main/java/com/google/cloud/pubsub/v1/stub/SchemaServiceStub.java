/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.pubsub.v1.stub;

import static com.google.cloud.pubsub.v1.SchemaServiceClient.ListSchemaRevisionsPagedResponse;
import static com.google.cloud.pubsub.v1.SchemaServiceClient.ListSchemasPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.CommitSchemaRequest;
import com.google.pubsub.v1.CreateSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRequest;
import com.google.pubsub.v1.DeleteSchemaRevisionRequest;
import com.google.pubsub.v1.GetSchemaRequest;
import com.google.pubsub.v1.ListSchemaRevisionsRequest;
import com.google.pubsub.v1.ListSchemaRevisionsResponse;
import com.google.pubsub.v1.ListSchemasRequest;
import com.google.pubsub.v1.ListSchemasResponse;
import com.google.pubsub.v1.RollbackSchemaRequest;
import com.google.pubsub.v1.Schema;
import com.google.pubsub.v1.ValidateMessageRequest;
import com.google.pubsub.v1.ValidateMessageResponse;
import com.google.pubsub.v1.ValidateSchemaRequest;
import com.google.pubsub.v1.ValidateSchemaResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SchemaService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SchemaServiceStub implements BackgroundResource {

  public UnaryCallable<CreateSchemaRequest, Schema> createSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: createSchemaCallable()");
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

  public UnaryCallable<ListSchemaRevisionsRequest, ListSchemaRevisionsPagedResponse>
      listSchemaRevisionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSchemaRevisionsPagedCallable()");
  }

  public UnaryCallable<ListSchemaRevisionsRequest, ListSchemaRevisionsResponse>
      listSchemaRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSchemaRevisionsCallable()");
  }

  public UnaryCallable<CommitSchemaRequest, Schema> commitSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: commitSchemaCallable()");
  }

  public UnaryCallable<RollbackSchemaRequest, Schema> rollbackSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackSchemaCallable()");
  }

  public UnaryCallable<DeleteSchemaRevisionRequest, Schema> deleteSchemaRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSchemaRevisionCallable()");
  }

  public UnaryCallable<DeleteSchemaRequest, Empty> deleteSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSchemaCallable()");
  }

  public UnaryCallable<ValidateSchemaRequest, ValidateSchemaResponse> validateSchemaCallable() {
    throw new UnsupportedOperationException("Not implemented: validateSchemaCallable()");
  }

  public UnaryCallable<ValidateMessageRequest, ValidateMessageResponse> validateMessageCallable() {
    throw new UnsupportedOperationException("Not implemented: validateMessageCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
