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

package com.google.cloud.retail.v2.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2.CompleteQueryRequest;
import com.google.cloud.retail.v2.CompleteQueryResponse;
import com.google.cloud.retail.v2.ImportCompletionDataRequest;
import com.google.cloud.retail.v2.ImportCompletionDataResponse;
import com.google.cloud.retail.v2.ImportMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CompletionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CompletionServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<CompleteQueryRequest, CompleteQueryResponse> completeQueryCallable() {
    throw new UnsupportedOperationException("Not implemented: completeQueryCallable()");
  }

  public OperationCallable<
          ImportCompletionDataRequest, ImportCompletionDataResponse, ImportMetadata>
      importCompletionDataOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importCompletionDataOperationCallable()");
  }

  public UnaryCallable<ImportCompletionDataRequest, Operation> importCompletionDataCallable() {
    throw new UnsupportedOperationException("Not implemented: importCompletionDataCallable()");
  }

  @Override
  public abstract void close();
}
