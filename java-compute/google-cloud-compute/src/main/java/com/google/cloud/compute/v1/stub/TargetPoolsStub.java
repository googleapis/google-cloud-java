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

import static com.google.cloud.compute.v1.TargetPoolsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetPoolsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddHealthCheckTargetPoolRequest;
import com.google.cloud.compute.v1.AddInstanceTargetPoolRequest;
import com.google.cloud.compute.v1.AggregatedListTargetPoolsRequest;
import com.google.cloud.compute.v1.DeleteTargetPoolRequest;
import com.google.cloud.compute.v1.GetHealthTargetPoolRequest;
import com.google.cloud.compute.v1.GetTargetPoolRequest;
import com.google.cloud.compute.v1.InsertTargetPoolRequest;
import com.google.cloud.compute.v1.ListTargetPoolsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.RemoveHealthCheckTargetPoolRequest;
import com.google.cloud.compute.v1.RemoveInstanceTargetPoolRequest;
import com.google.cloud.compute.v1.SetBackupTargetPoolRequest;
import com.google.cloud.compute.v1.TargetPool;
import com.google.cloud.compute.v1.TargetPoolAggregatedList;
import com.google.cloud.compute.v1.TargetPoolInstanceHealth;
import com.google.cloud.compute.v1.TargetPoolList;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TargetPools service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TargetPoolsStub implements BackgroundResource {

  public OperationCallable<AddHealthCheckTargetPoolRequest, Operation, Operation>
      addHealthCheckOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addHealthCheckOperationCallable()");
  }

  public UnaryCallable<AddHealthCheckTargetPoolRequest, Operation> addHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: addHealthCheckCallable()");
  }

  public OperationCallable<AddInstanceTargetPoolRequest, Operation, Operation>
      addInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: addInstanceOperationCallable()");
  }

  public UnaryCallable<AddInstanceTargetPoolRequest, Operation> addInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: addInstanceCallable()");
  }

  public UnaryCallable<AggregatedListTargetPoolsRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListTargetPoolsRequest, TargetPoolAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteTargetPoolRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteTargetPoolRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetTargetPoolRequest, TargetPool> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetHealthTargetPoolRequest, TargetPoolInstanceHealth> getHealthCallable() {
    throw new UnsupportedOperationException("Not implemented: getHealthCallable()");
  }

  public OperationCallable<InsertTargetPoolRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertTargetPoolRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListTargetPoolsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListTargetPoolsRequest, TargetPoolList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<RemoveHealthCheckTargetPoolRequest, Operation, Operation>
      removeHealthCheckOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: removeHealthCheckOperationCallable()");
  }

  public UnaryCallable<RemoveHealthCheckTargetPoolRequest, Operation> removeHealthCheckCallable() {
    throw new UnsupportedOperationException("Not implemented: removeHealthCheckCallable()");
  }

  public OperationCallable<RemoveInstanceTargetPoolRequest, Operation, Operation>
      removeInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: removeInstanceOperationCallable()");
  }

  public UnaryCallable<RemoveInstanceTargetPoolRequest, Operation> removeInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: removeInstanceCallable()");
  }

  public OperationCallable<SetBackupTargetPoolRequest, Operation, Operation>
      setBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setBackupOperationCallable()");
  }

  public UnaryCallable<SetBackupTargetPoolRequest, Operation> setBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: setBackupCallable()");
  }

  @Override
  public abstract void close();
}
