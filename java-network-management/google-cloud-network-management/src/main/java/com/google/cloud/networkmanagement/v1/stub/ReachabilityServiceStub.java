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

package com.google.cloud.networkmanagement.v1.stub;

import static com.google.cloud.networkmanagement.v1.ReachabilityServiceClient.ListConnectivityTestsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.networkmanagement.v1.ConnectivityTest;
import com.google.cloud.networkmanagement.v1.CreateConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1.DeleteConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1.GetConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1.ListConnectivityTestsRequest;
import com.google.cloud.networkmanagement.v1.ListConnectivityTestsResponse;
import com.google.cloud.networkmanagement.v1.OperationMetadata;
import com.google.cloud.networkmanagement.v1.RerunConnectivityTestRequest;
import com.google.cloud.networkmanagement.v1.UpdateConnectivityTestRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ReachabilityService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ReachabilityServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsPagedResponse>
      listConnectivityTestsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConnectivityTestsPagedCallable()");
  }

  public UnaryCallable<ListConnectivityTestsRequest, ListConnectivityTestsResponse>
      listConnectivityTestsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectivityTestsCallable()");
  }

  public UnaryCallable<GetConnectivityTestRequest, ConnectivityTest> getConnectivityTestCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectivityTestCallable()");
  }

  public OperationCallable<CreateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      createConnectivityTestOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConnectivityTestOperationCallable()");
  }

  public UnaryCallable<CreateConnectivityTestRequest, Operation> createConnectivityTestCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectivityTestCallable()");
  }

  public OperationCallable<UpdateConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      updateConnectivityTestOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateConnectivityTestOperationCallable()");
  }

  public UnaryCallable<UpdateConnectivityTestRequest, Operation> updateConnectivityTestCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectivityTestCallable()");
  }

  public OperationCallable<RerunConnectivityTestRequest, ConnectivityTest, OperationMetadata>
      rerunConnectivityTestOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rerunConnectivityTestOperationCallable()");
  }

  public UnaryCallable<RerunConnectivityTestRequest, Operation> rerunConnectivityTestCallable() {
    throw new UnsupportedOperationException("Not implemented: rerunConnectivityTestCallable()");
  }

  public OperationCallable<DeleteConnectivityTestRequest, Empty, OperationMetadata>
      deleteConnectivityTestOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConnectivityTestOperationCallable()");
  }

  public UnaryCallable<DeleteConnectivityTestRequest, Operation> deleteConnectivityTestCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectivityTestCallable()");
  }

  @Override
  public abstract void close();
}
