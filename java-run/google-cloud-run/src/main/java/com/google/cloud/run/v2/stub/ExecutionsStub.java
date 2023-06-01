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

import static com.google.cloud.run.v2.ExecutionsClient.ListExecutionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.DeleteExecutionRequest;
import com.google.cloud.run.v2.Execution;
import com.google.cloud.run.v2.GetExecutionRequest;
import com.google.cloud.run.v2.ListExecutionsRequest;
import com.google.cloud.run.v2.ListExecutionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Executions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ExecutionsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: getExecutionCallable()");
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsPagedCallable()");
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsCallable()");
  }

  public OperationCallable<DeleteExecutionRequest, Execution, Execution>
      deleteExecutionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExecutionOperationCallable()");
  }

  public UnaryCallable<DeleteExecutionRequest, Operation> deleteExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteExecutionCallable()");
  }

  @Override
  public abstract void close();
}
