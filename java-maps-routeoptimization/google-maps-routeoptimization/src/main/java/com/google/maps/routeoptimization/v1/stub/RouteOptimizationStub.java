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

package com.google.maps.routeoptimization.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursMetadata;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursRequest;
import com.google.maps.routeoptimization.v1.BatchOptimizeToursResponse;
import com.google.maps.routeoptimization.v1.OptimizeToursLongRunningMetadata;
import com.google.maps.routeoptimization.v1.OptimizeToursRequest;
import com.google.maps.routeoptimization.v1.OptimizeToursResponse;
import com.google.maps.routeoptimization.v1.OptimizeToursUriMetadata;
import com.google.maps.routeoptimization.v1.OptimizeToursUriRequest;
import com.google.maps.routeoptimization.v1.OptimizeToursUriResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RouteOptimization service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RouteOptimizationStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<OptimizeToursRequest, OptimizeToursResponse> optimizeToursCallable() {
    throw new UnsupportedOperationException("Not implemented: optimizeToursCallable()");
  }

  public OperationCallable<
          BatchOptimizeToursRequest, BatchOptimizeToursResponse, BatchOptimizeToursMetadata>
      batchOptimizeToursOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchOptimizeToursOperationCallable()");
  }

  public UnaryCallable<BatchOptimizeToursRequest, Operation> batchOptimizeToursCallable() {
    throw new UnsupportedOperationException("Not implemented: batchOptimizeToursCallable()");
  }

  public OperationCallable<
          OptimizeToursRequest, OptimizeToursResponse, OptimizeToursLongRunningMetadata>
      optimizeToursLongRunningOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: optimizeToursLongRunningOperationCallable()");
  }

  public UnaryCallable<OptimizeToursRequest, Operation> optimizeToursLongRunningCallable() {
    throw new UnsupportedOperationException("Not implemented: optimizeToursLongRunningCallable()");
  }

  public OperationCallable<
          OptimizeToursUriRequest, OptimizeToursUriResponse, OptimizeToursUriMetadata>
      optimizeToursUriOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: optimizeToursUriOperationCallable()");
  }

  public UnaryCallable<OptimizeToursUriRequest, Operation> optimizeToursUriCallable() {
    throw new UnsupportedOperationException("Not implemented: optimizeToursUriCallable()");
  }

  @Override
  public abstract void close();
}
