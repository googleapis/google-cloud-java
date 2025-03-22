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

package com.google.cloud.managedkafka.v1.stub;

import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectorsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.ConnectCluster;
import com.google.cloud.managedkafka.v1.Connector;
import com.google.cloud.managedkafka.v1.CreateConnectClusterRequest;
import com.google.cloud.managedkafka.v1.CreateConnectorRequest;
import com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest;
import com.google.cloud.managedkafka.v1.DeleteConnectorRequest;
import com.google.cloud.managedkafka.v1.GetConnectClusterRequest;
import com.google.cloud.managedkafka.v1.GetConnectorRequest;
import com.google.cloud.managedkafka.v1.ListConnectClustersRequest;
import com.google.cloud.managedkafka.v1.ListConnectClustersResponse;
import com.google.cloud.managedkafka.v1.ListConnectorsRequest;
import com.google.cloud.managedkafka.v1.ListConnectorsResponse;
import com.google.cloud.managedkafka.v1.OperationMetadata;
import com.google.cloud.managedkafka.v1.PauseConnectorRequest;
import com.google.cloud.managedkafka.v1.PauseConnectorResponse;
import com.google.cloud.managedkafka.v1.RestartConnectorRequest;
import com.google.cloud.managedkafka.v1.RestartConnectorResponse;
import com.google.cloud.managedkafka.v1.ResumeConnectorRequest;
import com.google.cloud.managedkafka.v1.ResumeConnectorResponse;
import com.google.cloud.managedkafka.v1.StopConnectorRequest;
import com.google.cloud.managedkafka.v1.StopConnectorResponse;
import com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest;
import com.google.cloud.managedkafka.v1.UpdateConnectorRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ManagedKafkaConnect service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ManagedKafkaConnectStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListConnectClustersRequest, ListConnectClustersPagedResponse>
      listConnectClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectClustersPagedCallable()");
  }

  public UnaryCallable<ListConnectClustersRequest, ListConnectClustersResponse>
      listConnectClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectClustersCallable()");
  }

  public UnaryCallable<GetConnectClusterRequest, ConnectCluster> getConnectClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectClusterCallable()");
  }

  public OperationCallable<CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
      createConnectClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConnectClusterOperationCallable()");
  }

  public UnaryCallable<CreateConnectClusterRequest, Operation> createConnectClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectClusterCallable()");
  }

  public OperationCallable<UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
      updateConnectClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateConnectClusterOperationCallable()");
  }

  public UnaryCallable<UpdateConnectClusterRequest, Operation> updateConnectClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectClusterCallable()");
  }

  public OperationCallable<DeleteConnectClusterRequest, Empty, OperationMetadata>
      deleteConnectClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConnectClusterOperationCallable()");
  }

  public UnaryCallable<DeleteConnectClusterRequest, Operation> deleteConnectClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectClusterCallable()");
  }

  public UnaryCallable<ListConnectorsRequest, ListConnectorsPagedResponse>
      listConnectorsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectorsPagedCallable()");
  }

  public UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> listConnectorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectorsCallable()");
  }

  public UnaryCallable<GetConnectorRequest, Connector> getConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectorCallable()");
  }

  public UnaryCallable<CreateConnectorRequest, Connector> createConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectorCallable()");
  }

  public UnaryCallable<UpdateConnectorRequest, Connector> updateConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectorCallable()");
  }

  public UnaryCallable<DeleteConnectorRequest, Empty> deleteConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectorCallable()");
  }

  public UnaryCallable<PauseConnectorRequest, PauseConnectorResponse> pauseConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: pauseConnectorCallable()");
  }

  public UnaryCallable<ResumeConnectorRequest, ResumeConnectorResponse> resumeConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeConnectorCallable()");
  }

  public UnaryCallable<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: restartConnectorCallable()");
  }

  public UnaryCallable<StopConnectorRequest, StopConnectorResponse> stopConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: stopConnectorCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
