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

import static com.google.cloud.compute.v1.TargetInstanceClient.AggregatedListTargetInstancesPagedResponse;
import static com.google.cloud.compute.v1.TargetInstanceClient.ListTargetInstancesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListTargetInstancesHttpRequest;
import com.google.cloud.compute.v1.DeleteTargetInstanceHttpRequest;
import com.google.cloud.compute.v1.GetTargetInstanceHttpRequest;
import com.google.cloud.compute.v1.InsertTargetInstanceHttpRequest;
import com.google.cloud.compute.v1.ListTargetInstancesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.TargetInstance;
import com.google.cloud.compute.v1.TargetInstanceAggregatedList;
import com.google.cloud.compute.v1.TargetInstanceList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class TargetInstanceStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<
          AggregatedListTargetInstancesHttpRequest, AggregatedListTargetInstancesPagedResponse>
      aggregatedListTargetInstancesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListTargetInstancesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListTargetInstancesHttpRequest, TargetInstanceAggregatedList>
      aggregatedListTargetInstancesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListTargetInstancesCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteTargetInstanceHttpRequest, Operation> deleteTargetInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTargetInstanceCallable()");
  }

  @BetaApi
  public UnaryCallable<GetTargetInstanceHttpRequest, TargetInstance> getTargetInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getTargetInstanceCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertTargetInstanceHttpRequest, Operation> insertTargetInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: insertTargetInstanceCallable()");
  }

  @BetaApi
  public UnaryCallable<ListTargetInstancesHttpRequest, ListTargetInstancesPagedResponse>
      listTargetInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetInstancesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListTargetInstancesHttpRequest, TargetInstanceList>
      listTargetInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetInstancesCallable()");
  }

  @Override
  public abstract void close();
}
