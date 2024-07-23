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

package com.google.cloud.discoveryengine.v1alpha.stub;

import static com.google.cloud.discoveryengine.v1alpha.EvaluationServiceClient.ListEvaluationResultsPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.EvaluationServiceClient.ListEvaluationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.CreateEvaluationMetadata;
import com.google.cloud.discoveryengine.v1alpha.CreateEvaluationRequest;
import com.google.cloud.discoveryengine.v1alpha.Evaluation;
import com.google.cloud.discoveryengine.v1alpha.GetEvaluationRequest;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationResultsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationResultsResponse;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationsRequest;
import com.google.cloud.discoveryengine.v1alpha.ListEvaluationsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EvaluationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class EvaluationServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetEvaluationRequest, Evaluation> getEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: getEvaluationCallable()");
  }

  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsPagedResponse>
      listEvaluationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationsPagedCallable()");
  }

  public UnaryCallable<ListEvaluationsRequest, ListEvaluationsResponse> listEvaluationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationsCallable()");
  }

  public OperationCallable<CreateEvaluationRequest, Evaluation, CreateEvaluationMetadata>
      createEvaluationOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEvaluationOperationCallable()");
  }

  public UnaryCallable<CreateEvaluationRequest, Operation> createEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: createEvaluationCallable()");
  }

  public UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsPagedResponse>
      listEvaluationResultsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEvaluationResultsPagedCallable()");
  }

  public UnaryCallable<ListEvaluationResultsRequest, ListEvaluationResultsResponse>
      listEvaluationResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEvaluationResultsCallable()");
  }

  @Override
  public abstract void close();
}
