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

package com.google.cloud.gkemulticloud.v1.stub;

import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClientsPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureNodePoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkemulticloud.v1.AzureClient;
import com.google.cloud.gkemulticloud.v1.AzureCluster;
import com.google.cloud.gkemulticloud.v1.AzureNodePool;
import com.google.cloud.gkemulticloud.v1.AzureServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClientsResponse;
import com.google.cloud.gkemulticloud.v1.ListAzureClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureClustersResponse;
import com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAzureNodePoolsResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.UpdateAzureNodePoolRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AzureClusters service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AzureClustersStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAzureClientOperationCallable()");
  }

  public UnaryCallable<CreateAzureClientRequest, Operation> createAzureClientCallable() {
    throw new UnsupportedOperationException("Not implemented: createAzureClientCallable()");
  }

  public UnaryCallable<GetAzureClientRequest, AzureClient> getAzureClientCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureClientCallable()");
  }

  public UnaryCallable<ListAzureClientsRequest, ListAzureClientsPagedResponse>
      listAzureClientsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureClientsPagedCallable()");
  }

  public UnaryCallable<ListAzureClientsRequest, ListAzureClientsResponse>
      listAzureClientsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureClientsCallable()");
  }

  public OperationCallable<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAzureClientOperationCallable()");
  }

  public UnaryCallable<DeleteAzureClientRequest, Operation> deleteAzureClientCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAzureClientCallable()");
  }

  public OperationCallable<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAzureClusterOperationCallable()");
  }

  public UnaryCallable<CreateAzureClusterRequest, Operation> createAzureClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createAzureClusterCallable()");
  }

  public OperationCallable<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAzureClusterOperationCallable()");
  }

  public UnaryCallable<UpdateAzureClusterRequest, Operation> updateAzureClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAzureClusterCallable()");
  }

  public UnaryCallable<GetAzureClusterRequest, AzureCluster> getAzureClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureClusterCallable()");
  }

  public UnaryCallable<ListAzureClustersRequest, ListAzureClustersPagedResponse>
      listAzureClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureClustersPagedCallable()");
  }

  public UnaryCallable<ListAzureClustersRequest, ListAzureClustersResponse>
      listAzureClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureClustersCallable()");
  }

  public OperationCallable<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAzureClusterOperationCallable()");
  }

  public UnaryCallable<DeleteAzureClusterRequest, Operation> deleteAzureClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAzureClusterCallable()");
  }

  public UnaryCallable<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: generateAzureAccessTokenCallable()");
  }

  public OperationCallable<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAzureNodePoolOperationCallable()");
  }

  public UnaryCallable<CreateAzureNodePoolRequest, Operation> createAzureNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createAzureNodePoolCallable()");
  }

  public OperationCallable<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAzureNodePoolOperationCallable()");
  }

  public UnaryCallable<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAzureNodePoolCallable()");
  }

  public UnaryCallable<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureNodePoolCallable()");
  }

  public UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureNodePoolsPagedCallable()");
  }

  public UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
      listAzureNodePoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureNodePoolsCallable()");
  }

  public OperationCallable<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAzureNodePoolOperationCallable()");
  }

  public UnaryCallable<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAzureNodePoolCallable()");
  }

  public UnaryCallable<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureServerConfigCallable()");
  }

  @Override
  public abstract void close();
}
