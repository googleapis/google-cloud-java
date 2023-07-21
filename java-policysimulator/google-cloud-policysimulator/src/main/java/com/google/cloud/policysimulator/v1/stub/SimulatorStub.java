/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.policysimulator.v1.stub;

import static com.google.cloud.policysimulator.v1.SimulatorClient.ListReplayResultsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.policysimulator.v1.CreateReplayRequest;
import com.google.cloud.policysimulator.v1.GetReplayRequest;
import com.google.cloud.policysimulator.v1.ListReplayResultsRequest;
import com.google.cloud.policysimulator.v1.ListReplayResultsResponse;
import com.google.cloud.policysimulator.v1.Replay;
import com.google.cloud.policysimulator.v1.ReplayOperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Simulator service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SimulatorStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<GetReplayRequest, Replay> getReplayCallable() {
    throw new UnsupportedOperationException("Not implemented: getReplayCallable()");
  }

  public OperationCallable<CreateReplayRequest, Replay, ReplayOperationMetadata>
      createReplayOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createReplayOperationCallable()");
  }

  public UnaryCallable<CreateReplayRequest, Operation> createReplayCallable() {
    throw new UnsupportedOperationException("Not implemented: createReplayCallable()");
  }

  public UnaryCallable<ListReplayResultsRequest, ListReplayResultsPagedResponse>
      listReplayResultsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReplayResultsPagedCallable()");
  }

  public UnaryCallable<ListReplayResultsRequest, ListReplayResultsResponse>
      listReplayResultsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReplayResultsCallable()");
  }

  @Override
  public abstract void close();
}
