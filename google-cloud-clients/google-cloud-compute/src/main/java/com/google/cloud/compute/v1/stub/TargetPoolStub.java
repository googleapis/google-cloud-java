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

import static com.google.cloud.compute.v1.TargetPoolClient.AggregatedListTargetPoolsPagedResponse;
import static com.google.cloud.compute.v1.TargetPoolClient.ListTargetPoolsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddHealthCheckTargetPoolHttpRequest;
import com.google.cloud.compute.v1.AddInstanceTargetPoolHttpRequest;
import com.google.cloud.compute.v1.AggregatedListTargetPoolsHttpRequest;
import com.google.cloud.compute.v1.DeleteTargetPoolHttpRequest;
import com.google.cloud.compute.v1.GetHealthTargetPoolHttpRequest;
import com.google.cloud.compute.v1.GetTargetPoolHttpRequest;
import com.google.cloud.compute.v1.InsertTargetPoolHttpRequest;
import com.google.cloud.compute.v1.ListTargetPoolsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RemoveHealthCheckTargetPoolHttpRequest;
import com.google.cloud.compute.v1.RemoveInstanceTargetPoolHttpRequest;
import com.google.cloud.compute.v1.SetBackupTargetPoolHttpRequest;
import com.google.cloud.compute.v1.TargetPool;
import com.google.cloud.compute.v1.TargetPoolAggregatedList;
import com.google.cloud.compute.v1.TargetPoolInstanceHealth;
import com.google.cloud.compute.v1.TargetPoolList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class TargetPoolStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<AddHealthCheckTargetPoolHttpRequest, Operation>
      addHealthCheckTargetPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: addHealthCheckTargetPoolCallable()");
  }

  @BetaApi
  public UnaryCallable<AddInstanceTargetPoolHttpRequest, Operation>
      addInstanceTargetPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: addInstanceTargetPoolCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListTargetPoolsHttpRequest, AggregatedListTargetPoolsPagedResponse>
      aggregatedListTargetPoolsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: aggregatedListTargetPoolsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<AggregatedListTargetPoolsHttpRequest, TargetPoolAggregatedList>
      aggregatedListTargetPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListTargetPoolsCallable()");
  }

  @BetaApi
  public UnaryCallable<DeleteTargetPoolHttpRequest, Operation> deleteTargetPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTargetPoolCallable()");
  }

  @BetaApi
  public UnaryCallable<GetTargetPoolHttpRequest, TargetPool> getTargetPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getTargetPoolCallable()");
  }

  @BetaApi
  public UnaryCallable<GetHealthTargetPoolHttpRequest, TargetPoolInstanceHealth>
      getHealthTargetPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getHealthTargetPoolCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertTargetPoolHttpRequest, Operation> insertTargetPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: insertTargetPoolCallable()");
  }

  @BetaApi
  public UnaryCallable<ListTargetPoolsHttpRequest, ListTargetPoolsPagedResponse>
      listTargetPoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetPoolsPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListTargetPoolsHttpRequest, TargetPoolList> listTargetPoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTargetPoolsCallable()");
  }

  @BetaApi
  public UnaryCallable<RemoveHealthCheckTargetPoolHttpRequest, Operation>
      removeHealthCheckTargetPoolCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeHealthCheckTargetPoolCallable()");
  }

  @BetaApi
  public UnaryCallable<RemoveInstanceTargetPoolHttpRequest, Operation>
      removeInstanceTargetPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: removeInstanceTargetPoolCallable()");
  }

  @BetaApi
  public UnaryCallable<SetBackupTargetPoolHttpRequest, Operation> setBackupTargetPoolCallable() {
    throw new UnsupportedOperationException("Not implemented: setBackupTargetPoolCallable()");
  }

  @Override
  public abstract void close();
}
