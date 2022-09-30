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

import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsClustersPagedResponse;
import static com.google.cloud.gkemulticloud.v1.AwsClustersClient.ListAwsNodePoolsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkemulticloud.v1.AwsCluster;
import com.google.cloud.gkemulticloud.v1.AwsNodePool;
import com.google.cloud.gkemulticloud.v1.AwsServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.CreateAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAwsAccessTokenResponse;
import com.google.cloud.gkemulticloud.v1.GetAwsClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsNodePoolRequest;
import com.google.cloud.gkemulticloud.v1.GetAwsServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsClustersResponse;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsRequest;
import com.google.cloud.gkemulticloud.v1.ListAwsNodePoolsResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
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
 */
@Generated("by gapic-generator-java")
public abstract class AwsClustersStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateAwsClusterRequest, AwsCluster, OperationMetadata>
      createAwsClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createAwsClusterOperationCallable()");
  }

  public UnaryCallable<CreateAwsClusterRequest, Operation> createAwsClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createAwsClusterCallable()");
  }

  public OperationCallable<UpdateAwsClusterRequest, AwsCluster, OperationMetadata>
      updateAwsClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAwsClusterOperationCallable()");
  }

  public UnaryCallable<UpdateAwsClusterRequest, Operation> updateAwsClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAwsClusterCallable()");
  }

  public UnaryCallable<GetAwsClusterRequest, AwsCluster> getAwsClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getAwsClusterCallable()");
  }

  public UnaryCallable<ListAwsClustersRequest, ListAwsClustersPagedResponse>
      listAwsClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAwsClustersPagedCallable()");
  }

  public UnaryCallable<ListAwsClustersRequest, ListAwsClustersResponse> listAwsClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listAwsClustersCallable()");
  }

  public OperationCallable<DeleteAwsClusterRequest, Empty, OperationMetadata>
      deleteAwsClusterOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAwsClusterOperationCallable()");
  }

  public UnaryCallable<DeleteAwsClusterRequest, Operation> deleteAwsClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAwsClusterCallable()");
  }

  public UnaryCallable<GenerateAwsAccessTokenRequest, GenerateAwsAccessTokenResponse>
      generateAwsAccessTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: generateAwsAccessTokenCallable()");
  }

  public OperationCallable<CreateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      createAwsNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAwsNodePoolOperationCallable()");
  }

  public UnaryCallable<CreateAwsNodePoolRequest, Operation> createAwsNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: createAwsNodePoolCallable()");
  }

  public OperationCallable<UpdateAwsNodePoolRequest, AwsNodePool, OperationMetadata>
      updateAwsNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAwsNodePoolOperationCallable()");
  }

  public UnaryCallable<UpdateAwsNodePoolRequest, Operation> updateAwsNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAwsNodePoolCallable()");
  }

  public UnaryCallable<GetAwsNodePoolRequest, AwsNodePool> getAwsNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: getAwsNodePoolCallable()");
  }

  public UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsPagedResponse>
      listAwsNodePoolsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAwsNodePoolsPagedCallable()");
  }

  public UnaryCallable<ListAwsNodePoolsRequest, ListAwsNodePoolsResponse>
      listAwsNodePoolsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAwsNodePoolsCallable()");
  }

  public OperationCallable<DeleteAwsNodePoolRequest, Empty, OperationMetadata>
      deleteAwsNodePoolOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAwsNodePoolOperationCallable()");
  }

  public UnaryCallable<DeleteAwsNodePoolRequest, Operation> deleteAwsNodePoolCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAwsNodePoolCallable()");
  }

  public UnaryCallable<GetAwsServerConfigRequest, AwsServerConfig> getAwsServerConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAwsServerConfigCallable()");
  }

  @Override
  public abstract void close();
}
