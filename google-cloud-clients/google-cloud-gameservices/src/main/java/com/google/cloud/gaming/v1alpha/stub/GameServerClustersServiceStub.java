/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1alpha.stub;

import static com.google.cloud.gaming.v1alpha.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1alpha.CreateGameServerClusterRequest;
import com.google.cloud.gaming.v1alpha.DeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1alpha.GameServerCluster;
import com.google.cloud.gaming.v1alpha.GetGameServerClusterRequest;
import com.google.cloud.gaming.v1alpha.ListGameServerClustersRequest;
import com.google.cloud.gaming.v1alpha.ListGameServerClustersResponse;
import com.google.cloud.gaming.v1alpha.UpdateGameServerClusterRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for gameservices API (prod).
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class GameServerClustersServiceStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersPagedResponse>
      listGameServerClustersPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGameServerClustersPagedCallable()");
  }

  public UnaryCallable<ListGameServerClustersRequest, ListGameServerClustersResponse>
      listGameServerClustersCallable() {
    throw new UnsupportedOperationException("Not implemented: listGameServerClustersCallable()");
  }

  public UnaryCallable<GetGameServerClusterRequest, GameServerCluster>
      getGameServerClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: getGameServerClusterCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateGameServerClusterRequest, GameServerCluster, Empty>
      createGameServerClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGameServerClusterOperationCallable()");
  }

  public UnaryCallable<CreateGameServerClusterRequest, Operation>
      createGameServerClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createGameServerClusterCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<DeleteGameServerClusterRequest, Empty, Empty>
      deleteGameServerClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGameServerClusterOperationCallable()");
  }

  public UnaryCallable<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGameServerClusterCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateGameServerClusterRequest, GameServerCluster, Empty>
      updateGameServerClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGameServerClusterOperationCallable()");
  }

  public UnaryCallable<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGameServerClusterCallable()");
  }

  @Override
  public abstract void close();
}
