/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.compute.v1.TargetInstancesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.TargetInstancesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AggregatedListTargetInstancesRequest;
import com.google.cloud.compute.v1.DeleteTargetInstanceRequest;
import com.google.cloud.compute.v1.GetTargetInstanceRequest;
import com.google.cloud.compute.v1.InsertTargetInstanceRequest;
import com.google.cloud.compute.v1.ListTargetInstancesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.SetSecurityPolicyTargetInstanceRequest;
import com.google.cloud.compute.v1.TargetInstance;
import com.google.cloud.compute.v1.TargetInstanceAggregatedList;
import com.google.cloud.compute.v1.TargetInstanceList;
import com.google.cloud.compute.v1.TestIamPermissionsTargetInstanceRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TargetInstances service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TargetInstancesStub implements BackgroundResource {

  public UnaryCallable<AggregatedListTargetInstancesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListPagedCallable()");
  }

  public UnaryCallable<AggregatedListTargetInstancesRequest, TargetInstanceAggregatedList>
      aggregatedListCallable() {
    throw new UnsupportedOperationException("Not implemented: aggregatedListCallable()");
  }

  public OperationCallable<DeleteTargetInstanceRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteTargetInstanceRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetTargetInstanceRequest, TargetInstance> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertTargetInstanceRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertTargetInstanceRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListTargetInstancesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListTargetInstancesRequest, TargetInstanceList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<SetSecurityPolicyTargetInstanceRequest, Operation, Operation>
      setSecurityPolicyOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: setSecurityPolicyOperationCallable()");
  }

  public UnaryCallable<SetSecurityPolicyTargetInstanceRequest, Operation>
      setSecurityPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setSecurityPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsTargetInstanceRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
