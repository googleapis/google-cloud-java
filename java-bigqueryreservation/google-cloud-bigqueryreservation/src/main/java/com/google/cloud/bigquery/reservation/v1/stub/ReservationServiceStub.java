/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.bigquery.reservation.v1.stub;

import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListAssignmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListCapacityCommitmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListReservationsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.SearchAllAssignmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.SearchAssignmentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.reservation.v1.Assignment;
import com.google.cloud.bigquery.reservation.v1.BiReservation;
import com.google.cloud.bigquery.reservation.v1.CapacityCommitment;
import com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.CreateReservationRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest;
import com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest;
import com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.GetReservationRequest;
import com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest;
import com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse;
import com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest;
import com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse;
import com.google.cloud.bigquery.reservation.v1.ListReservationsRequest;
import com.google.cloud.bigquery.reservation.v1.ListReservationsResponse;
import com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest;
import com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.Reservation;
import com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsRequest;
import com.google.cloud.bigquery.reservation.v1.SearchAllAssignmentsResponse;
import com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest;
import com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse;
import com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse;
import com.google.cloud.bigquery.reservation.v1.UpdateAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest;
import com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ReservationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ReservationServiceStub implements BackgroundResource {

  public UnaryCallable<CreateReservationRequest, Reservation> createReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: createReservationCallable()");
  }

  public UnaryCallable<ListReservationsRequest, ListReservationsPagedResponse>
      listReservationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReservationsPagedCallable()");
  }

  public UnaryCallable<ListReservationsRequest, ListReservationsResponse>
      listReservationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReservationsCallable()");
  }

  public UnaryCallable<GetReservationRequest, Reservation> getReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: getReservationCallable()");
  }

  public UnaryCallable<DeleteReservationRequest, Empty> deleteReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteReservationCallable()");
  }

  public UnaryCallable<UpdateReservationRequest, Reservation> updateReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateReservationCallable()");
  }

  public UnaryCallable<CreateCapacityCommitmentRequest, CapacityCommitment>
      createCapacityCommitmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createCapacityCommitmentCallable()");
  }

  public UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsPagedResponse>
      listCapacityCommitmentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listCapacityCommitmentsPagedCallable()");
  }

  public UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
      listCapacityCommitmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCapacityCommitmentsCallable()");
  }

  public UnaryCallable<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getCapacityCommitmentCallable()");
  }

  public UnaryCallable<DeleteCapacityCommitmentRequest, Empty> deleteCapacityCommitmentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCapacityCommitmentCallable()");
  }

  public UnaryCallable<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCapacityCommitmentCallable()");
  }

  public UnaryCallable<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentCallable() {
    throw new UnsupportedOperationException("Not implemented: splitCapacityCommitmentCallable()");
  }

  public UnaryCallable<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: mergeCapacityCommitmentsCallable()");
  }

  public UnaryCallable<CreateAssignmentRequest, Assignment> createAssignmentCallable() {
    throw new UnsupportedOperationException("Not implemented: createAssignmentCallable()");
  }

  public UnaryCallable<ListAssignmentsRequest, ListAssignmentsPagedResponse>
      listAssignmentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssignmentsPagedCallable()");
  }

  public UnaryCallable<ListAssignmentsRequest, ListAssignmentsResponse> listAssignmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAssignmentsCallable()");
  }

  public UnaryCallable<DeleteAssignmentRequest, Empty> deleteAssignmentCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAssignmentCallable()");
  }

  @Deprecated
  public UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsPagedResponse>
      searchAssignmentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAssignmentsPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsResponse>
      searchAssignmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAssignmentsCallable()");
  }

  public UnaryCallable<SearchAllAssignmentsRequest, SearchAllAssignmentsPagedResponse>
      searchAllAssignmentsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllAssignmentsPagedCallable()");
  }

  public UnaryCallable<SearchAllAssignmentsRequest, SearchAllAssignmentsResponse>
      searchAllAssignmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchAllAssignmentsCallable()");
  }

  public UnaryCallable<MoveAssignmentRequest, Assignment> moveAssignmentCallable() {
    throw new UnsupportedOperationException("Not implemented: moveAssignmentCallable()");
  }

  public UnaryCallable<UpdateAssignmentRequest, Assignment> updateAssignmentCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAssignmentCallable()");
  }

  public UnaryCallable<GetBiReservationRequest, BiReservation> getBiReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: getBiReservationCallable()");
  }

  public UnaryCallable<UpdateBiReservationRequest, BiReservation> updateBiReservationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateBiReservationCallable()");
  }

  @Override
  public abstract void close();
}
