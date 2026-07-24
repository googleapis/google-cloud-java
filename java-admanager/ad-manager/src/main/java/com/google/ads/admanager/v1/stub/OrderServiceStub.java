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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.OrderServiceClient.ListOrdersPagedResponse;

import com.google.ads.admanager.v1.BatchApproveAndOverbookOrdersRequest;
import com.google.ads.admanager.v1.BatchApproveAndOverbookOrdersResponse;
import com.google.ads.admanager.v1.BatchApproveOrdersRequest;
import com.google.ads.admanager.v1.BatchApproveOrdersResponse;
import com.google.ads.admanager.v1.BatchApproveOrdersWithoutReservationRequest;
import com.google.ads.admanager.v1.BatchApproveOrdersWithoutReservationResponse;
import com.google.ads.admanager.v1.BatchArchiveOrdersRequest;
import com.google.ads.admanager.v1.BatchArchiveOrdersResponse;
import com.google.ads.admanager.v1.BatchCreateOrdersRequest;
import com.google.ads.admanager.v1.BatchCreateOrdersResponse;
import com.google.ads.admanager.v1.BatchDeleteOrdersRequest;
import com.google.ads.admanager.v1.BatchDeleteOrdersResponse;
import com.google.ads.admanager.v1.BatchDisapproveOrdersRequest;
import com.google.ads.admanager.v1.BatchDisapproveOrdersResponse;
import com.google.ads.admanager.v1.BatchDisapproveOrdersWithoutReservationChangesRequest;
import com.google.ads.admanager.v1.BatchDisapproveOrdersWithoutReservationChangesResponse;
import com.google.ads.admanager.v1.BatchPauseOrdersRequest;
import com.google.ads.admanager.v1.BatchPauseOrdersResponse;
import com.google.ads.admanager.v1.BatchResumeAndOverbookOrdersRequest;
import com.google.ads.admanager.v1.BatchResumeAndOverbookOrdersResponse;
import com.google.ads.admanager.v1.BatchResumeOrdersRequest;
import com.google.ads.admanager.v1.BatchResumeOrdersResponse;
import com.google.ads.admanager.v1.BatchRetractOrdersRequest;
import com.google.ads.admanager.v1.BatchRetractOrdersResponse;
import com.google.ads.admanager.v1.BatchRetractOrdersWithoutReservationChangesRequest;
import com.google.ads.admanager.v1.BatchRetractOrdersWithoutReservationChangesResponse;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalAndOverbookRequest;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalAndOverbookResponse;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalRequest;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalResponse;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalWithoutReservationChangesRequest;
import com.google.ads.admanager.v1.BatchSubmitOrdersForApprovalWithoutReservationChangesResponse;
import com.google.ads.admanager.v1.BatchUnarchiveOrdersRequest;
import com.google.ads.admanager.v1.BatchUnarchiveOrdersResponse;
import com.google.ads.admanager.v1.BatchUpdateOrdersRequest;
import com.google.ads.admanager.v1.BatchUpdateOrdersResponse;
import com.google.ads.admanager.v1.GetOrderRequest;
import com.google.ads.admanager.v1.ListOrdersRequest;
import com.google.ads.admanager.v1.ListOrdersResponse;
import com.google.ads.admanager.v1.Order;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the OrderService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class OrderServiceStub implements BackgroundResource {

  public UnaryCallable<GetOrderRequest, Order> getOrderCallable() {
    throw new UnsupportedOperationException("Not implemented: getOrderCallable()");
  }

  public UnaryCallable<ListOrdersRequest, ListOrdersPagedResponse> listOrdersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrdersPagedCallable()");
  }

  public UnaryCallable<ListOrdersRequest, ListOrdersResponse> listOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrdersCallable()");
  }

  public UnaryCallable<BatchCreateOrdersRequest, BatchCreateOrdersResponse>
      batchCreateOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateOrdersCallable()");
  }

  public UnaryCallable<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>
      batchUpdateOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateOrdersCallable()");
  }

  public UnaryCallable<BatchApproveOrdersRequest, BatchApproveOrdersResponse>
      batchApproveOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchApproveOrdersCallable()");
  }

  public UnaryCallable<BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
      batchApproveAndOverbookOrdersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchApproveAndOverbookOrdersCallable()");
  }

  public UnaryCallable<BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
      batchSubmitOrdersForApprovalCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchSubmitOrdersForApprovalCallable()");
  }

  public UnaryCallable<
          BatchSubmitOrdersForApprovalAndOverbookRequest,
          BatchSubmitOrdersForApprovalAndOverbookResponse>
      batchSubmitOrdersForApprovalAndOverbookCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchSubmitOrdersForApprovalAndOverbookCallable()");
  }

  public UnaryCallable<
          BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
          BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
      batchSubmitOrdersForApprovalWithoutReservationChangesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchSubmitOrdersForApprovalWithoutReservationChangesCallable()");
  }

  public UnaryCallable<BatchPauseOrdersRequest, BatchPauseOrdersResponse>
      batchPauseOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchPauseOrdersCallable()");
  }

  public UnaryCallable<BatchResumeOrdersRequest, BatchResumeOrdersResponse>
      batchResumeOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchResumeOrdersCallable()");
  }

  public UnaryCallable<BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
      batchResumeAndOverbookOrdersCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchResumeAndOverbookOrdersCallable()");
  }

  public UnaryCallable<
          BatchApproveOrdersWithoutReservationRequest, BatchApproveOrdersWithoutReservationResponse>
      batchApproveOrdersWithoutReservationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchApproveOrdersWithoutReservationCallable()");
  }

  public UnaryCallable<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>
      batchArchiveOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchiveOrdersCallable()");
  }

  public UnaryCallable<BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>
      batchUnarchiveOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUnarchiveOrdersCallable()");
  }

  public UnaryCallable<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>
      batchDeleteOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeleteOrdersCallable()");
  }

  public UnaryCallable<BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>
      batchDisapproveOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDisapproveOrdersCallable()");
  }

  public UnaryCallable<
          BatchDisapproveOrdersWithoutReservationChangesRequest,
          BatchDisapproveOrdersWithoutReservationChangesResponse>
      batchDisapproveOrdersWithoutReservationChangesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDisapproveOrdersWithoutReservationChangesCallable()");
  }

  public UnaryCallable<BatchRetractOrdersRequest, BatchRetractOrdersResponse>
      batchRetractOrdersCallable() {
    throw new UnsupportedOperationException("Not implemented: batchRetractOrdersCallable()");
  }

  public UnaryCallable<
          BatchRetractOrdersWithoutReservationChangesRequest,
          BatchRetractOrdersWithoutReservationChangesResponse>
      batchRetractOrdersWithoutReservationChangesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchRetractOrdersWithoutReservationChangesCallable()");
  }

  @Override
  public abstract void close();
}
