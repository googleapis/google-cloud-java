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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RolloutsClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.CancelRolloutRequest;
import com.google.cloud.compute.v1.DeleteRolloutRequest;
import com.google.cloud.compute.v1.GetRolloutRequest;
import com.google.cloud.compute.v1.ListRolloutsRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Rollout;
import com.google.cloud.compute.v1.RolloutsListResponse;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Rollouts service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@NullMarked
@Generated("by gapic-generator-java")
public abstract class RolloutsStub implements BackgroundResource {

  public OperationCallable<CancelRolloutRequest, Operation, Operation> cancelOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelOperationCallable()");
  }

  public UnaryCallable<CancelRolloutRequest, Operation> cancelCallable() {
    throw new UnsupportedOperationException("Not implemented: cancelCallable()");
  }

  public OperationCallable<DeleteRolloutRequest, Operation, Operation> deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRolloutRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetRolloutRequest, Rollout> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<ListRolloutsRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRolloutsRequest, RolloutsListResponse> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  @Override
  public abstract void close();
}
