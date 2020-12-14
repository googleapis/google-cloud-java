/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.redis.v1beta1.stub;

import static com.google.cloud.redis.v1beta1.CloudRedisClient.ListInstancesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.redis.v1beta1.CreateInstanceRequest;
import com.google.cloud.redis.v1beta1.DeleteInstanceRequest;
import com.google.cloud.redis.v1beta1.ExportInstanceRequest;
import com.google.cloud.redis.v1beta1.FailoverInstanceRequest;
import com.google.cloud.redis.v1beta1.GetInstanceRequest;
import com.google.cloud.redis.v1beta1.ImportInstanceRequest;
import com.google.cloud.redis.v1beta1.Instance;
import com.google.cloud.redis.v1beta1.ListInstancesRequest;
import com.google.cloud.redis.v1beta1.ListInstancesResponse;
import com.google.cloud.redis.v1beta1.UpdateInstanceRequest;
import com.google.cloud.redis.v1beta1.UpgradeInstanceRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudRedis service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class CloudRedisStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
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

  public OperationCallable<CreateInstanceRequest, Instance, Any> createInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceOperationCallable()");
  }

  public UnaryCallable<CreateInstanceRequest, Operation> createInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: createInstanceCallable()");
  }

  public OperationCallable<UpdateInstanceRequest, Instance, Any> updateInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceOperationCallable()");
  }

  public UnaryCallable<UpdateInstanceRequest, Operation> updateInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateInstanceCallable()");
  }

  public OperationCallable<UpgradeInstanceRequest, Instance, Any>
      upgradeInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeInstanceOperationCallable()");
  }

  public UnaryCallable<UpgradeInstanceRequest, Operation> upgradeInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: upgradeInstanceCallable()");
  }

  public OperationCallable<ImportInstanceRequest, Instance, Any> importInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: importInstanceOperationCallable()");
  }

  public UnaryCallable<ImportInstanceRequest, Operation> importInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: importInstanceCallable()");
  }

  public OperationCallable<ExportInstanceRequest, Instance, Any> exportInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportInstanceOperationCallable()");
  }

  public UnaryCallable<ExportInstanceRequest, Operation> exportInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: exportInstanceCallable()");
  }

  public OperationCallable<FailoverInstanceRequest, Instance, Any>
      failoverInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: failoverInstanceOperationCallable()");
  }

  public UnaryCallable<FailoverInstanceRequest, Operation> failoverInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: failoverInstanceCallable()");
  }

  public OperationCallable<DeleteInstanceRequest, Empty, Any> deleteInstanceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceOperationCallable()");
  }

  public UnaryCallable<DeleteInstanceRequest, Operation> deleteInstanceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceCallable()");
  }

  @Override
  public abstract void close();
}
