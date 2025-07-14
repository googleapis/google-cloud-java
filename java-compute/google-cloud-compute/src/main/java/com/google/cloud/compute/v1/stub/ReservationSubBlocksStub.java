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

import static com.google.cloud.compute.v1.ReservationSubBlocksClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.GetReservationSubBlockRequest;
import com.google.cloud.compute.v1.ListReservationSubBlocksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PerformMaintenanceReservationSubBlockRequest;
import com.google.cloud.compute.v1.ReservationSubBlocksGetResponse;
import com.google.cloud.compute.v1.ReservationSubBlocksListResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ReservationSubBlocks service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ReservationSubBlocksStub implements BackgroundResource {

  public UnaryCallable<GetReservationSubBlockRequest, ReservationSubBlocksGetResponse>
      getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<ListReservationSubBlocksRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListReservationSubBlocksRequest, ReservationSubBlocksListResponse>
      listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PerformMaintenanceReservationSubBlockRequest, Operation, Operation>
      performMaintenanceOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: performMaintenanceOperationCallable()");
  }

  public UnaryCallable<PerformMaintenanceReservationSubBlockRequest, Operation>
      performMaintenanceCallable() {
    throw new UnsupportedOperationException("Not implemented: performMaintenanceCallable()");
  }

  @Override
  public abstract void close();
}
