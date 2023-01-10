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

package com.google.cloud.gaming.v1.stub;

import static com.google.cloud.gaming.v1.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1.CreateGameServerClusterRequest;
import com.google.cloud.gaming.v1.DeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1.GameServerCluster;
import com.google.cloud.gaming.v1.GetGameServerClusterRequest;
import com.google.cloud.gaming.v1.ListGameServerClustersRequest;
import com.google.cloud.gaming.v1.ListGameServerClustersResponse;
import com.google.cloud.gaming.v1.OperationMetadata;
import com.google.cloud.gaming.v1.PreviewCreateGameServerClusterRequest;
import com.google.cloud.gaming.v1.PreviewCreateGameServerClusterResponse;
import com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterRequest;
import com.google.cloud.gaming.v1.PreviewDeleteGameServerClusterResponse;
import com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterRequest;
import com.google.cloud.gaming.v1.PreviewUpdateGameServerClusterResponse;
import com.google.cloud.gaming.v1.UpdateGameServerClusterRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GameServerClustersService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class GameServerClustersServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
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

  public OperationCallable<CreateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      createGameServerClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGameServerClusterOperationCallable()");
  }

  public UnaryCallable<CreateGameServerClusterRequest, Operation>
      createGameServerClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: createGameServerClusterCallable()");
  }

  public UnaryCallable<
          PreviewCreateGameServerClusterRequest, PreviewCreateGameServerClusterResponse>
      previewCreateGameServerClusterCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: previewCreateGameServerClusterCallable()");
  }

  public OperationCallable<DeleteGameServerClusterRequest, Empty, OperationMetadata>
      deleteGameServerClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGameServerClusterOperationCallable()");
  }

  public UnaryCallable<DeleteGameServerClusterRequest, Operation>
      deleteGameServerClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGameServerClusterCallable()");
  }

  public UnaryCallable<
          PreviewDeleteGameServerClusterRequest, PreviewDeleteGameServerClusterResponse>
      previewDeleteGameServerClusterCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: previewDeleteGameServerClusterCallable()");
  }

  public OperationCallable<UpdateGameServerClusterRequest, GameServerCluster, OperationMetadata>
      updateGameServerClusterOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGameServerClusterOperationCallable()");
  }

  public UnaryCallable<UpdateGameServerClusterRequest, Operation>
      updateGameServerClusterCallable() {
    throw new UnsupportedOperationException("Not implemented: updateGameServerClusterCallable()");
  }

  public UnaryCallable<
          PreviewUpdateGameServerClusterRequest, PreviewUpdateGameServerClusterResponse>
      previewUpdateGameServerClusterCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: previewUpdateGameServerClusterCallable()");
  }

  @Override
  public abstract void close();
}
