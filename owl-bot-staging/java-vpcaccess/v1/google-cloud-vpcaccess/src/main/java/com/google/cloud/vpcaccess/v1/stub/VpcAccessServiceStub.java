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

package com.google.cloud.vpcaccess.v1.stub;

import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListConnectorsPagedResponse;
import static com.google.cloud.vpcaccess.v1.VpcAccessServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.vpcaccess.v1.Connector;
import com.google.cloud.vpcaccess.v1.CreateConnectorRequest;
import com.google.cloud.vpcaccess.v1.DeleteConnectorRequest;
import com.google.cloud.vpcaccess.v1.GetConnectorRequest;
import com.google.cloud.vpcaccess.v1.ListConnectorsRequest;
import com.google.cloud.vpcaccess.v1.ListConnectorsResponse;
import com.google.cloud.vpcaccess.v1.OperationMetadata;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the VpcAccessService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class VpcAccessServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateConnectorRequest, Connector, OperationMetadata>
      createConnectorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectorOperationCallable()");
  }

  public UnaryCallable<CreateConnectorRequest, Operation> createConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectorCallable()");
  }

  public UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectorCallable()");
  }

  public UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectorsPagedCallable()");
  }

  public UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> listConnectorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectorsCallable()");
  }

  public OperationCallable<DeleteConnectorRequest, Empty, OperationMetadata>
      deleteConnectorOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectorOperationCallable()");
  }

  public UnaryCallable<DeleteConnectorRequest, Operation> deleteConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectorCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  @Override
  public abstract void close();
}
