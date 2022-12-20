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

import static com.google.cloud.gkemulticloud.v1.AttachedClustersClient.ListAttachedClustersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gkemulticloud.v1.AttachedCluster;
import com.google.cloud.gkemulticloud.v1.AttachedServerConfig;
import com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest;
import com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse;
import com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest;
import com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest;
import com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest;
import com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse;
import com.google.cloud.gkemulticloud.v1.OperationMetadata;
import com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the AttachedClusters service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class AttachedClustersStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public OperationCallable<CreateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      createAttachedClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAttachedClusterOperationCallable()");
  }

  public UnaryCallable<CreateAttachedClusterRequest, Operation> createAttachedClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createAttachedClusterCallable()");
  }

  public OperationCallable<UpdateAttachedClusterRequest, AttachedCluster, OperationMetadata>
      updateAttachedClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAttachedClusterOperationCallable()");
  }

  public UnaryCallable<UpdateAttachedClusterRequest, Operation> updateAttachedClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAttachedClusterCallable()");
  }

  public OperationCallable<ImportAttachedClusterRequest, AttachedCluster, OperationMetadata>
      importAttachedClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: importAttachedClusterOperationCallable()");
  }

  public UnaryCallable<ImportAttachedClusterRequest, Operation> importAttachedClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: importAttachedClusterCallable()");
  }

  public UnaryCallable<GetAttachedClusterRequest, AttachedCluster> getAttachedClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getAttachedClusterCallable()");
  }

  public UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersPagedResponse>
      listAttachedClustersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttachedClustersPagedCallable()");
  }

  public UnaryCallable<ListAttachedClustersRequest, ListAttachedClustersResponse>
      listAttachedClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listAttachedClustersCallable()");
  }

  public OperationCallable<DeleteAttachedClusterRequest, Empty, OperationMetadata>
      deleteAttachedClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAttachedClusterOperationCallable()");
  }

  public UnaryCallable<DeleteAttachedClusterRequest, Operation> deleteAttachedClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAttachedClusterCallable()");
  }

  public UnaryCallable<GetAttachedServerConfigRequest, AttachedServerConfig>
      getAttachedServerConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getAttachedServerConfigCallable()");
  }

  public UnaryCallable<
          GenerateAttachedClusterInstallManifestRequest,
          GenerateAttachedClusterInstallManifestResponse>
      generateAttachedClusterInstallManifestCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: generateAttachedClusterInstallManifestCallable()");
  }

  @Override
  public abstract void close();
}
