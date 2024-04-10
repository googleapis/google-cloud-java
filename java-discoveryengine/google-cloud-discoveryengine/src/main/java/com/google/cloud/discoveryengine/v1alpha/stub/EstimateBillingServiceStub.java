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

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeMetadata;
import com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeRequest;
import com.google.cloud.discoveryengine.v1alpha.EstimateDataSizeResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EstimateBillingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class EstimateBillingServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<
          EstimateDataSizeRequest, EstimateDataSizeResponse, EstimateDataSizeMetadata>
      estimateDataSizeOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: estimateDataSizeOperationCallable()");
  }

  public UnaryCallable<EstimateDataSizeRequest, Operation> estimateDataSizeCallable() {
    throw new UnsupportedOperationException("Not implemented: estimateDataSizeCallable()");
  }

  @Override
  public abstract void close();
}
