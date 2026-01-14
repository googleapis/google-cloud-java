/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.FutureReservationsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.FutureReservationsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListFutureReservationsRequest;
import com.google.cloud.compute.v1.CancelFutureReservationRequest;
import com.google.cloud.compute.v1.DeleteFutureReservationRequest;
import com.google.cloud.compute.v1.FutureReservation;
import com.google.cloud.compute.v1.FutureReservationsAggregatedListResponse;
import com.google.cloud.compute.v1.FutureReservationsListResponse;
import com.google.cloud.compute.v1.GetFutureReservationRequest;
import com.google.cloud.compute.v1.InsertFutureReservationRequest;
import com.google.cloud.compute.v1.ListFutureReservationsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.UpdateFutureReservationRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the FutureReservations service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class FutureReservationsStub implements BackgroundResource {

  public UnaryCallable<AggregatedListFutureReservationsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<
          AggregatedListFutureReservationsRequest, FutureReservationsAggregatedListResponse>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<CancelFutureReservationRequest, Operation, Operation>
      cancelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelOperationCallable()");
  }

  public UnaryCallable<CancelFutureReservationRequest, Operation> cancelCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelCallable()");
  }

  public OperationCallable<DeleteFutureReservationRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteFutureReservationRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetFutureReservationRequest, FutureReservation> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertFutureReservationRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertFutureReservationRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListFutureReservationsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListFutureReservationsRequest, FutureReservationsListResponse>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<UpdateFutureReservationRequest, Operation, Operation>
      updateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperationCallable()");
  }

  public UnaryCallable<UpdateFutureReservationRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  @Override
  public abstract void close();
}
