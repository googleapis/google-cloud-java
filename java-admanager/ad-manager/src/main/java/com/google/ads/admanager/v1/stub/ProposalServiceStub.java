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

import static com.google.ads.admanager.v1.ProposalServiceClient.FetchMarketplaceCommentsPagedResponse;
import static com.google.ads.admanager.v1.ProposalServiceClient.ListProposalsPagedResponse;

import com.google.ads.admanager.v1.BatchArchiveProposalsRequest;
import com.google.ads.admanager.v1.BatchArchiveProposalsResponse;
import com.google.ads.admanager.v1.BatchCreateProposalsRequest;
import com.google.ads.admanager.v1.BatchCreateProposalsResponse;
import com.google.ads.admanager.v1.BatchDiscardDraftProposalsRequest;
import com.google.ads.admanager.v1.BatchDiscardDraftProposalsResponse;
import com.google.ads.admanager.v1.BatchPauseProposalsRequest;
import com.google.ads.admanager.v1.BatchPauseProposalsResponse;
import com.google.ads.admanager.v1.BatchPushToOrderProposalsRequest;
import com.google.ads.admanager.v1.BatchPushToOrderProposalsResponse;
import com.google.ads.admanager.v1.BatchRedraftProposalsRequest;
import com.google.ads.admanager.v1.BatchRedraftProposalsResponse;
import com.google.ads.admanager.v1.BatchRequestBuyerAcceptProposalsRequest;
import com.google.ads.admanager.v1.BatchRequestBuyerAcceptProposalsResponse;
import com.google.ads.admanager.v1.BatchRequestBuyerReviewProposalsRequest;
import com.google.ads.admanager.v1.BatchRequestBuyerReviewProposalsResponse;
import com.google.ads.admanager.v1.BatchReserveProposalsRequest;
import com.google.ads.admanager.v1.BatchReserveProposalsResponse;
import com.google.ads.admanager.v1.BatchResumeProposalsRequest;
import com.google.ads.admanager.v1.BatchResumeProposalsResponse;
import com.google.ads.admanager.v1.BatchTerminateProposalsRequest;
import com.google.ads.admanager.v1.BatchTerminateProposalsResponse;
import com.google.ads.admanager.v1.BatchUnarchiveProposalsRequest;
import com.google.ads.admanager.v1.BatchUnarchiveProposalsResponse;
import com.google.ads.admanager.v1.BatchUpdateProposalsRequest;
import com.google.ads.admanager.v1.BatchUpdateProposalsResponse;
import com.google.ads.admanager.v1.CreateProposalRequest;
import com.google.ads.admanager.v1.FetchMarketplaceCommentsRequest;
import com.google.ads.admanager.v1.FetchMarketplaceCommentsResponse;
import com.google.ads.admanager.v1.GetProposalRequest;
import com.google.ads.admanager.v1.ListProposalsRequest;
import com.google.ads.admanager.v1.ListProposalsResponse;
import com.google.ads.admanager.v1.Proposal;
import com.google.ads.admanager.v1.UpdateProposalRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ProposalService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class ProposalServiceStub implements BackgroundResource {

  public UnaryCallable<GetProposalRequest, Proposal> getProposalCallable() {
    throw new UnsupportedOperationException("Not implemented: getProposalCallable()");
  }

  public UnaryCallable<ListProposalsRequest, ListProposalsPagedResponse>
      listProposalsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listProposalsPagedCallable()");
  }

  public UnaryCallable<ListProposalsRequest, ListProposalsResponse> listProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: listProposalsCallable()");
  }

  public UnaryCallable<CreateProposalRequest, Proposal> createProposalCallable() {
    throw new UnsupportedOperationException("Not implemented: createProposalCallable()");
  }

  public UnaryCallable<BatchCreateProposalsRequest, BatchCreateProposalsResponse>
      batchCreateProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateProposalsCallable()");
  }

  public UnaryCallable<UpdateProposalRequest, Proposal> updateProposalCallable() {
    throw new UnsupportedOperationException("Not implemented: updateProposalCallable()");
  }

  public UnaryCallable<BatchUpdateProposalsRequest, BatchUpdateProposalsResponse>
      batchUpdateProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateProposalsCallable()");
  }

  public UnaryCallable<BatchArchiveProposalsRequest, BatchArchiveProposalsResponse>
      batchArchiveProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchArchiveProposalsCallable()");
  }

  public UnaryCallable<BatchUnarchiveProposalsRequest, BatchUnarchiveProposalsResponse>
      batchUnarchiveProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUnarchiveProposalsCallable()");
  }

  public UnaryCallable<BatchPauseProposalsRequest, BatchPauseProposalsResponse>
      batchPauseProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchPauseProposalsCallable()");
  }

  public UnaryCallable<BatchResumeProposalsRequest, BatchResumeProposalsResponse>
      batchResumeProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchResumeProposalsCallable()");
  }

  public UnaryCallable<
          BatchRequestBuyerReviewProposalsRequest, BatchRequestBuyerReviewProposalsResponse>
      batchRequestBuyerReviewProposalsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchRequestBuyerReviewProposalsCallable()");
  }

  public UnaryCallable<
          BatchRequestBuyerAcceptProposalsRequest, BatchRequestBuyerAcceptProposalsResponse>
      batchRequestBuyerAcceptProposalsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchRequestBuyerAcceptProposalsCallable()");
  }

  public UnaryCallable<BatchReserveProposalsRequest, BatchReserveProposalsResponse>
      batchReserveProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchReserveProposalsCallable()");
  }

  public UnaryCallable<BatchRedraftProposalsRequest, BatchRedraftProposalsResponse>
      batchRedraftProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchRedraftProposalsCallable()");
  }

  public UnaryCallable<BatchDiscardDraftProposalsRequest, BatchDiscardDraftProposalsResponse>
      batchDiscardDraftProposalsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchDiscardDraftProposalsCallable()");
  }

  public UnaryCallable<BatchTerminateProposalsRequest, BatchTerminateProposalsResponse>
      batchTerminateProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchTerminateProposalsCallable()");
  }

  public UnaryCallable<BatchPushToOrderProposalsRequest, BatchPushToOrderProposalsResponse>
      batchPushToOrderProposalsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchPushToOrderProposalsCallable()");
  }

  public UnaryCallable<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsPagedResponse>
      fetchMarketplaceCommentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchMarketplaceCommentsPagedCallable()");
  }

  public UnaryCallable<FetchMarketplaceCommentsRequest, FetchMarketplaceCommentsResponse>
      fetchMarketplaceCommentsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchMarketplaceCommentsCallable()");
  }

  @Override
  public abstract void close();
}
