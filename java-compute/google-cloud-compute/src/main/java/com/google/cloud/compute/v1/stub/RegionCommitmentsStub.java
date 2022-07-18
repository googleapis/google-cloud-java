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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionCommitmentsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.RegionCommitmentsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListRegionCommitmentsRequest;
import com.google.cloud.compute.v1.Commitment;
import com.google.cloud.compute.v1.CommitmentAggregatedList;
import com.google.cloud.compute.v1.CommitmentList;
import com.google.cloud.compute.v1.GetRegionCommitmentRequest;
import com.google.cloud.compute.v1.InsertRegionCommitmentRequest;
import com.google.cloud.compute.v1.ListRegionCommitmentsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.UpdateRegionCommitmentRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionCommitments service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionCommitmentsStub implements BackgroundResource {

  public UnaryCallable<AggregatedListRegionCommitmentsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListRegionCommitmentsRequest, CommitmentAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public UnaryCallable<GetRegionCommitmentRequest, Commitment> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertRegionCommitmentRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionCommitmentRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionCommitmentsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionCommitmentsRequest, CommitmentList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<UpdateRegionCommitmentRequest, Operation, Operation>
      updateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateOperationCallable()");
  }

  public UnaryCallable<UpdateRegionCommitmentRequest, Operation> updateCallable() {
    throw new UnsupportedOperationException("Not implemented: updateCallable()");
  }

  @Override
  public abstract void close();
}
