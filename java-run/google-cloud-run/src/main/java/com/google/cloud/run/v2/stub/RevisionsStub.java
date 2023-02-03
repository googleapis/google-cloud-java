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

package com.google.cloud.run.v2.stub;

import static com.google.cloud.run.v2.RevisionsClient.ListRevisionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.DeleteRevisionRequest;
import com.google.cloud.run.v2.GetRevisionRequest;
import com.google.cloud.run.v2.ListRevisionsRequest;
import com.google.cloud.run.v2.ListRevisionsResponse;
import com.google.cloud.run.v2.Revision;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Revisions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RevisionsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: getRevisionCallable()");
  }

  public UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRevisionsPagedCallable()");
  }

  public UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRevisionsCallable()");
  }

  public OperationCallable<DeleteRevisionRequest, Revision, Revision>
      deleteRevisionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRevisionOperationCallable()");
  }

  public UnaryCallable<DeleteRevisionRequest, Operation> deleteRevisionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRevisionCallable()");
  }

  @Override
  public abstract void close();
}
