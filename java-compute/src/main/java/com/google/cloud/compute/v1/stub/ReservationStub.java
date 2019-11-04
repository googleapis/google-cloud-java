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

import static com.google.cloud.compute.v1.ReservationClient.AggregatedListReservationsPagedResponse;
import static com.google.cloud.compute.v1.ReservationClient.ListReservationsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListReservationsHttpRequest;
import com.google.cloud.compute.v1.DeleteReservationHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyReservationHttpRequest;
import com.google.cloud.compute.v1.GetReservationHttpRequest;
import com.google.cloud.compute.v1.InsertReservationHttpRequest;
import com.google.cloud.compute.v1.ListReservationsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.Reservation;
import com.google.cloud.compute.v1.ReservationAggregatedList;
import com.google.cloud.compute.v1.ReservationList;
import com.google.cloud.compute.v1.ResizeReservationHttpRequest;
import com.google.cloud.compute.v1.SetIamPolicyReservationHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsReservationHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class ReservationStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListReservationsHttpRequest, AggregatedListReservationsPagedResponse>
      aggregatedListReservationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListReservationsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListReservationsHttpRequest, ReservationAggregatedList>
      aggregatedListReservationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListReservationsCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteReservationHttpRequest, Operation> deleteReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReservationCallable()");
  }

  @BetaApi
  public UnaryCallable<GetReservationHttpRequest, Reservation> getReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: getReservationCallable()");
  }

  @BetaApi
  public UnaryCallable<GetIamPolicyReservationHttpRequest, Policy>
      getIamPolicyReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyReservationCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertReservationHttpRequest, Operation> insertReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertReservationCallable()");
  }

  @BetaApi
  public UnaryCallable<ListReservationsHttpRequest, ListReservationsPagedResponse>
      listReservationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReservationsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListReservationsHttpRequest, ReservationList> listReservationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReservationsCallable()");
  }

  @BetaApi
  public UnaryCallable<ResizeReservationHttpRequest, Operation> resizeReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: resizeReservationCallable()");
  }

  @BetaApi
  public UnaryCallable<SetIamPolicyReservationHttpRequest, Policy>
      setIamPolicyReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyReservationCallable()");
  }

  @BetaApi
  public UnaryCallable<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
      testIamPermissionsReservationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: testIamPermissionsReservationCallable()");
  }

  @Override
  public abstract void close();
}
