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

import static com.google.cloud.compute.v1.ReservationSlotsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.GetReservationSlotRequest;
import com.google.cloud.compute.v1.GetVersionReservationSlotRequest;
import com.google.cloud.compute.v1.ListReservationSlotsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ReservationSlotsGetResponse;
import com.google.cloud.compute.v1.ReservationSlotsListResponse;
import com.google.cloud.compute.v1.UpdateReservationSlotRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ReservationSlots service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ReservationSlotsStub implements BackgroundResource {

  public UnaryCallable<GetReservationSlotRequest, ReservationSlotsGetResponse> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<GetVersionReservationSlotRequest, Operation, Operation>
      getVersionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: getVersionOperationCallable()");
  }

  public UnaryCallable<GetVersionReservationSlotRequest, Operation> getVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getVersionCallable()");
  }

  public UnaryCallable<ListReservationSlotsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListReservationSlotsRequest, ReservationSlotsListResponse> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<UpdateReservationSlotRequest, Operation, Operation>
      updateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperationCallable()");
  }

  public UnaryCallable<UpdateReservationSlotRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  @Override
  public abstract void close();
}
