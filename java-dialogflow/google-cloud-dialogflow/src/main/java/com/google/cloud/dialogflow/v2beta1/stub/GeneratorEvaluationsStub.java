/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dialogflow.v2beta1.stub;

import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListGeneratorEvaluationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationsClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.CreateGeneratorEvaluationRequest;
import com.google.cloud.dialogflow.v2beta1.DeleteGeneratorEvaluationRequest;
import com.google.cloud.dialogflow.v2beta1.GeneratorEvaluation;
import com.google.cloud.dialogflow.v2beta1.GeneratorEvaluationOperationMetadata;
import com.google.cloud.dialogflow.v2beta1.GetGeneratorEvaluationRequest;
import com.google.cloud.dialogflow.v2beta1.ListGeneratorEvaluationsRequest;
import com.google.cloud.dialogflow.v2beta1.ListGeneratorEvaluationsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GeneratorEvaluations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class GeneratorEvaluationsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<
          CreateGeneratorEvaluationRequest,
          GeneratorEvaluation,
          GeneratorEvaluationOperationMetadata>
      createGeneratorEvaluationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGeneratorEvaluationOperationCallable()");
  }

  public UnaryCallable<CreateGeneratorEvaluationRequest, Operation>
      createGeneratorEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: createGeneratorEvaluationCallable()");
  }

  public UnaryCallable<GetGeneratorEvaluationRequest, GeneratorEvaluation>
      getGeneratorEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: getGeneratorEvaluationCallable()");
  }

  public UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsPagedResponse>
      listGeneratorEvaluationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGeneratorEvaluationsPagedCallable()");
  }

  public UnaryCallable<ListGeneratorEvaluationsRequest, ListGeneratorEvaluationsResponse>
      listGeneratorEvaluationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGeneratorEvaluationsCallable()");
  }

  public UnaryCallable<DeleteGeneratorEvaluationRequest, Empty>
      deleteGeneratorEvaluationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGeneratorEvaluationCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
