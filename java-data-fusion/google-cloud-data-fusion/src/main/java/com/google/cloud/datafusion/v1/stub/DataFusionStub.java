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

package com.google.cloud.datafusion.v1.stub;

import static com.google.cloud.datafusion.v1.DataFusionClient.ListAvailableVersionsPagedResponse;
import static com.google.cloud.datafusion.v1.DataFusionClient.ListInstancesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datafusion.v1.CreateInstanceRequest;
import com.google.cloud.datafusion.v1.DeleteInstanceRequest;
import com.google.cloud.datafusion.v1.GetInstanceRequest;
import com.google.cloud.datafusion.v1.Instance;
import com.google.cloud.datafusion.v1.ListAvailableVersionsRequest;
import com.google.cloud.datafusion.v1.ListAvailableVersionsResponse;
import com.google.cloud.datafusion.v1.ListInstancesRequest;
import com.google.cloud.datafusion.v1.ListInstancesResponse;
import com.google.cloud.datafusion.v1.OperationMetadata;
import com.google.cloud.datafusion.v1.RestartInstanceRequest;
import com.google.cloud.datafusion.v1.UpdateInstanceRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataFusion service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataFusionStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsPagedResponse>
      listAvailableVersionsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAvailableVersionsPagedCallable()");
  }

  public UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsResponse>
      listAvailableVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAvailableVersionsCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesPagedResponse>
      listInstancesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesPagedCallable()");
  }

  public UnaryCallable<ListInstancesRequest, ListInstancesResponse> listInstancesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstancesCallable()");
  }

  public UnaryCallable<GetInstanceRequest, Instance> getInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceCallable()");
  }

  public OperationCallable<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceOperationCallable()");
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceCallable()");
  }

  public OperationCallable<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
  }

  public OperationCallable<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceCallable()");
  }

  public OperationCallable<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: restartInstanceOperationCallable()");
  }

  public UnaryCallable<RestartInstanceRequest, Operation> restartInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: restartInstanceCallable()");
  }

  @Override
  public abstract void close();
}
