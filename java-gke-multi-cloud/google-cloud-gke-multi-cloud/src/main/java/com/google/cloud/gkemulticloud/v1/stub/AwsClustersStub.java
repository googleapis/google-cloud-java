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

import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsNodePoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkemulticloud.v1.AwsCluster;
import com.google.cloud.gkemulticloud.v1.AwsJsonWebKeys;
import com.google.cloud.gkemulticloud.v1.AwsNodePool;
import com.google.cloud.gkemulticloud.v1.AwsOpenIdConfig;
import com.google.cloud.gkemulticloud.v1.AwsServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsClusterAgentTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsJsonWebKeysRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsOpenIdConfigRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.RollbackAwsNodePoolUpdateRequest;
import com.google.cloud.gkemulticloud.v1.UpdateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.UpdateAwsNodePoolRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AwsClusters service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 *
 * @deprecated This class is deprecated and will be removed in the next major version update.
 */
@Deprecated
@Generated("by gapic-generator-java")
public abstract class AwsClustersStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  @Deprecated
  public OperationCallable<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAwsClusterOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateAwsClusterRequest, Operation> createAwsClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createAwsClusterCallable()");
  }

  @Deprecated
  public OperationCallable<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAwsClusterOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateAwsClusterRequest, Operation> updateAwsClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAwsClusterCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAwsClusterRequest, AwsCluster> getAwsClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getAwsClusterCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAwsClustersRequest, ListAwsClustersPagedResponse>
      listAwsClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAwsClustersPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAwsClustersRequest, ListAwsClustersResponse> listAwsClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listAwsClustersCallable()");
  }

  @Deprecated
  public OperationCallable<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAwsClusterOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteAwsClusterRequest, Operation> deleteAwsClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAwsClusterCallable()");
  }

  @Deprecated
  public UnaryCallable<GenerateAwsClusterAgentTokenRequest, GenerateAwsClusterAgentTokenResponse>
      generateAwsClusterAgentTokenCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateAwsClusterAgentTokenCallable()");
  }

  @Deprecated
  public UnaryCallable<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: generateAwsAccessTokenCallable()");
  }

  @Deprecated
  public OperationCallable<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAwsNodePoolOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<CreateAwsNodePoolRequest, Operation> createAwsNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createAwsNodePoolCallable()");
  }

  @Deprecated
  public OperationCallable<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAwsNodePoolOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAwsNodePoolCallable()");
  }

  @Deprecated
  public OperationCallable<RollbackAwsNodePoolUpdateRequest, AwsNodePool, OperationMetadata>
      rollbackAwsNodePoolUpdateOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: rollbackAwsNodePoolUpdateOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<RollbackAwsNodePoolUpdateRequest, Operation>
      rollbackAwsNodePoolUpdateCallable() {
    throw new UnsupportedOperationException("Not implemented: rollbackAwsNodePoolUpdateCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getAwsNodePoolCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAwsNodePoolsPagedCallable()");
  }

  @Deprecated
  public UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
      listAwsNodePoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAwsNodePoolsCallable()");
  }

  @Deprecated
  public OperationCallable<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAwsNodePoolOperationCallable()");
  }

  @Deprecated
  public UnaryCallable<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAwsNodePoolCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAwsOpenIdConfigRequest, AwsOpenIdConfig> getAwsOpenIdConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAwsOpenIdConfigCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAwsJsonWebKeysRequest, AwsJsonWebKeys> getAwsJsonWebKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: getAwsJsonWebKeysCallable()");
  }

  @Deprecated
  public UnaryCallable<GetAwsServerConfigRequest, AwsServerConfig> getAwsServerConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAwsServerConfigCallable()");
  }

  @Override
  public abstract void close();
}
