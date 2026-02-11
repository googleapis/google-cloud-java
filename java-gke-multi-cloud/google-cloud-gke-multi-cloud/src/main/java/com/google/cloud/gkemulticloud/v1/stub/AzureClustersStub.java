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

package com.google.cloud.gkemulticloud.v1.stub;

import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClientsPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AzureClustersClient.ListAzureNodePoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkemulticloud.v1.AzureClient;
import com.google.cloud.gkemulticloud.v1.AzureCluster;
import com.google.cloud.gkemulticloud.v1.AzureJsonWebKeys;
import com.google.cloud.gkemulticloud.v1.AzureNodePool;
import com.google.cloud.gkemulticloud.v1.AzureOpenIdConfig;
import com.google.cloud.gkemulticloud.v1.AzureServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GenerateAzureClusterAgentTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAzureClusterAgentTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAzureClientRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureJsonWebKeysRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAzureOpenIdConfigRequest;
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
 *
 * @deprecated This class is deprecated and will be removed in the next major version update.
 */
@Deprecated
@Generated("by gapic-generator-java")
public abstract class AzureClustersStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  @Deprecated
  public OperationCallable<CreateAzureClientRequest, AzureClient, OperationMetadata>
      createAzureClientOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAzureClientOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateAzureClientRequest, Operation> createAzureClientCallable() {
    throw new UnsupportedOperationException("Not implemented: createAzureClientCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAzureClientRequest, AzureClient> getAzureClientCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureClientCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAzureClientsRequest, ListAzureClientsPagedResponse>
      listAzureClientsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureClientsPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAzureClientsRequest, ListAzureClientsResponse>
      listAzureClientsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureClientsCallable()");
  }

  @Deprecated
  public OperationCallable<DeleteAzureClientRequest, Empty, OperationMetadata>
      deleteAzureClientOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAzureClientOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteAzureClientRequest, Operation> deleteAzureClientCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAzureClientCallable()");
  }

  @Deprecated
  public OperationCallable<CreateAzureClusterRequest, AzureCluster, OperationMetadata>
      createAzureClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAzureClusterOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateAzureClusterRequest, Operation> createAzureClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createAzureClusterCallable()");
  }

  @Deprecated
  public OperationCallable<UpdateAzureClusterRequest, AzureCluster, OperationMetadata>
      updateAzureClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAzureClusterOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateAzureClusterRequest, Operation> updateAzureClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAzureClusterCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAzureClusterRequest, AzureCluster> getAzureClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureClusterCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAzureClustersRequest, ListAzureClustersPagedResponse>
      listAzureClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureClustersPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAzureClustersRequest, ListAzureClustersResponse>
      listAzureClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureClustersCallable()");
  }

  @Deprecated
  public OperationCallable<DeleteAzureClusterRequest, Empty, OperationMetadata>
      deleteAzureClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAzureClusterOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteAzureClusterRequest, Operation> deleteAzureClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAzureClusterCallable()");
  }

  @Deprecated
  public UnaryCallable<
          GenerateAzureClusterAgentTokenRequest, GenerateAzureClusterAgentTokenResponse>
      generateAzureClusterAgentTokenCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateAzureClusterAgentTokenCallable()");
  }

  @Deprecated
  public UnaryCallable<GenerateAzureAccessTokenRequest, GenerateAzureAccessTokenResponse>
      generateAzureAccessTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: generateAzureAccessTokenCallable()");
  }

  @Deprecated
  public OperationCallable<CreateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      createAzureNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAzureNodePoolOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateAzureNodePoolRequest, Operation> createAzureNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createAzureNodePoolCallable()");
  }

  @Deprecated
  public OperationCallable<UpdateAzureNodePoolRequest, AzureNodePool, OperationMetadata>
      updateAzureNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAzureNodePoolOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateAzureNodePoolRequest, Operation> updateAzureNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAzureNodePoolCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAzureNodePoolRequest, AzureNodePool> getAzureNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureNodePoolCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsPagedResponse>
      listAzureNodePoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureNodePoolsPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAzureNodePoolsRequest, ListAzureNodePoolsResponse>
      listAzureNodePoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAzureNodePoolsCallable()");
  }

  @Deprecated
  public OperationCallable<DeleteAzureNodePoolRequest, Empty, OperationMetadata>
      deleteAzureNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAzureNodePoolOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteAzureNodePoolRequest, Operation> deleteAzureNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAzureNodePoolCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAzureOpenIdConfigRequest, AzureOpenIdConfig>
      getAzureOpenIdConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureOpenIdConfigCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAzureJsonWebKeysRequest, AzureJsonWebKeys> getAzureJsonWebKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureJsonWebKeysCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAzureServerConfigRequest, AzureServerConfig>
      getAzureServerConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAzureServerConfigCallable()");
  }

  @Override
  public abstract void close();
}
