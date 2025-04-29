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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ReservationBlocksClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.GetReservationBlockRequest;
import com.google.cloud.compute.v1.ListReservationBlocksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PerformMaintenanceReservationBlockRequest;
import com.google.cloud.compute.v1.ReservationBlocksGetResponse;
import com.google.cloud.compute.v1.ReservationBlocksListResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ReservationBlocks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ReservationBlocksStub implements BackgroundResource {

  public UnaryCallable<GetReservationBlockRequest, ReservationBlocksGetResponse> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<ListReservationBlocksRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListReservationBlocksRequest, ReservationBlocksListResponse> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PerformMaintenanceReservationBlockRequest, Operation, Operation>
      performMaintenanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: performMaintenanceOperationCallable()");
  }

  public UnaryCallable<PerformMaintenanceReservationBlockRequest, Operation>
      performMaintenanceCallable() {
    throw new UnsupportedOperationException("Not implemented: performMaintenanceCallable()");
  }

  @Override
  public abstract void close();
}
