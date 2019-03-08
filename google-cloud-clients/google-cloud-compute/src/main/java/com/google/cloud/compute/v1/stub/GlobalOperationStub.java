/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.GlobalOperationClient.AggregatedListGlobalOperationsPagedResponse;
import static com.google.cloud.compute.v1.GlobalOperationClient.ListGlobalOperationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListGlobalOperationsHttpRequest;
import com.google.cloud.compute.v1.DeleteGlobalOperationHttpRequest;
import com.google.cloud.compute.v1.GetGlobalOperationHttpRequest;
import com.google.cloud.compute.v1.ListGlobalOperationsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.OperationAggregatedList;
import com.google.cloud.compute.v1.OperationList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class GlobalOperationStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListGlobalOperationsHttpRequest, AggregatedListGlobalOperationsPagedResponse>
      aggregatedListGlobalOperationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListGlobalOperationsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListGlobalOperationsHttpRequest, OperationAggregatedList>
      aggregatedListGlobalOperationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListGlobalOperationsCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteGlobalOperationHttpRequest, Void> deleteGlobalOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGlobalOperationCallable()");
  }

  @BetaApi
  public UnaryCallable<GetGlobalOperationHttpRequest, Operation> getGlobalOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: getGlobalOperationCallable()");
  }

  @BetaApi
  public UnaryCallable<ListGlobalOperationsHttpRequest, ListGlobalOperationsPagedResponse>
      listGlobalOperationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listGlobalOperationsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListGlobalOperationsHttpRequest, OperationList>
      listGlobalOperationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGlobalOperationsCallable()");
  }

  @Override
  public abstract void close();
}
