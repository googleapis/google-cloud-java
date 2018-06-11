/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.RegionCommitmentClient.AggregatedListRegionCommitmentsPagedResponse;
import static com.google.cloud.compute.v1.RegionCommitmentClient.ListRegionCommitmentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListRegionCommitmentsHttpRequest;
import com.google.cloud.compute.v1.Commitment;
import com.google.cloud.compute.v1.CommitmentAggregatedList;
import com.google.cloud.compute.v1.CommitmentList;
import com.google.cloud.compute.v1.GetRegionCommitmentHttpRequest;
import com.google.cloud.compute.v1.InsertRegionCommitmentHttpRequest;
import com.google.cloud.compute.v1.ListRegionCommitmentsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class RegionCommitmentStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListRegionCommitmentsHttpRequest, AggregatedListRegionCommitmentsPagedResponse>
      aggregatedListRegionCommitmentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListRegionCommitmentsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListRegionCommitmentsHttpRequest, CommitmentAggregatedList>
      aggregatedListRegionCommitmentsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListRegionCommitmentsCallable()");
  }

  @BetaApi
  public UnaryCallable<GetRegionCommitmentHttpRequest, Commitment> getRegionCommitmentCallable() {
    throw new UnsupportedOperationException("Not implemented: getRegionCommitmentCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertRegionCommitmentHttpRequest, Operation>
      insertRegionCommitmentCallable() {
    throw new UnsupportedOperationException("Not implemented: insertRegionCommitmentCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionCommitmentsHttpRequest, ListRegionCommitmentsPagedResponse>
      listRegionCommitmentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listRegionCommitmentsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListRegionCommitmentsHttpRequest, CommitmentList>
      listRegionCommitmentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRegionCommitmentsCallable()");
  }

  @Override
  public abstract void close();
}
