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

package com.google.cloud.workflows.executions.v1beta.stub;

import static com.google.cloud.workflows.executions.v1beta.ExecutionsClient.ListExecutionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.Execution;
import com.google.cloud.workflows.executions.v1beta.GetExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest;
import com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Executions service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class ExecutionsStub implements BackgroundResource {

  public UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsPagedCallable()");
  }

  public UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> listExecutionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listExecutionsCallable()");
  }

  public UnaryCallable<CreateExecutionRequest, Execution> createExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: createExecutionCallable()");
  }

  public UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: getExecutionCallable()");
  }

  public UnaryCallable<CancelExecutionRequest, Execution> cancelExecutionCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelExecutionCallable()");
  }

  @Override
  public abstract void close();
}
