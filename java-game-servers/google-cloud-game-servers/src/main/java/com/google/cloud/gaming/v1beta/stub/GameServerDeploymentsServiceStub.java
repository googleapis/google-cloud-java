/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.gaming.v1beta.stub;

import static com.google.cloud.gaming.v1beta.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1beta.CreateGameServerDeploymentRequest;
import com.google.cloud.gaming.v1beta.DeleteGameServerDeploymentRequest;
import com.google.cloud.gaming.v1beta.FetchDeploymentStateRequest;
import com.google.cloud.gaming.v1beta.FetchDeploymentStateResponse;
import com.google.cloud.gaming.v1beta.GameServerDeployment;
import com.google.cloud.gaming.v1beta.GameServerDeploymentRollout;
import com.google.cloud.gaming.v1beta.GetGameServerDeploymentRequest;
import com.google.cloud.gaming.v1beta.GetGameServerDeploymentRolloutRequest;
import com.google.cloud.gaming.v1beta.ListGameServerDeploymentsRequest;
import com.google.cloud.gaming.v1beta.ListGameServerDeploymentsResponse;
import com.google.cloud.gaming.v1beta.OperationMetadata;
import com.google.cloud.gaming.v1beta.PreviewGameServerDeploymentRolloutRequest;
import com.google.cloud.gaming.v1beta.PreviewGameServerDeploymentRolloutResponse;
import com.google.cloud.gaming.v1beta.UpdateGameServerDeploymentRequest;
import com.google.cloud.gaming.v1beta.UpdateGameServerDeploymentRolloutRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the GameServerDeploymentsService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class GameServerDeploymentsServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListGameServerDeploymentsRequest, ListGameServerDeploymentsPagedResponse>
      listGameServerDeploymentsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGameServerDeploymentsPagedCallable()");
  }

  public UnaryCallable<ListGameServerDeploymentsRequest, ListGameServerDeploymentsResponse>
      listGameServerDeploymentsCallable() {
    throw new UnsupportedOperationException("Not implemented: listGameServerDeploymentsCallable()");
  }

  public UnaryCallable<GetGameServerDeploymentRequest, GameServerDeployment>
      getGameServerDeploymentCallable() {
    throw new UnsupportedOperationException("Not implemented: getGameServerDeploymentCallable()");
  }

  public OperationCallable<
          CreateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      createGameServerDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGameServerDeploymentOperationCallable()");
  }

  public UnaryCallable<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGameServerDeploymentCallable()");
  }

  public OperationCallable<DeleteGameServerDeploymentRequest, Empty, OperationMetadata>
      deleteGameServerDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGameServerDeploymentOperationCallable()");
  }

  public UnaryCallable<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGameServerDeploymentCallable()");
  }

  public OperationCallable<
          UpdateGameServerDeploymentRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGameServerDeploymentOperationCallable()");
  }

  public UnaryCallable<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGameServerDeploymentCallable()");
  }

  public UnaryCallable<GetGameServerDeploymentRolloutRequest, GameServerDeploymentRollout>
      getGameServerDeploymentRolloutCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getGameServerDeploymentRolloutCallable()");
  }

  public OperationCallable<
          UpdateGameServerDeploymentRolloutRequest, GameServerDeployment, OperationMetadata>
      updateGameServerDeploymentRolloutOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGameServerDeploymentRolloutOperationCallable()");
  }

  public UnaryCallable<UpdateGameServerDeploymentRolloutRequest, Operation>
      updateGameServerDeploymentRolloutCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGameServerDeploymentRolloutCallable()");
  }

  public UnaryCallable<
          PreviewGameServerDeploymentRolloutRequest, PreviewGameServerDeploymentRolloutResponse>
      previewGameServerDeploymentRolloutCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: previewGameServerDeploymentRolloutCallable()");
  }

  public UnaryCallable<FetchDeploymentStateRequest, FetchDeploymentStateResponse>
      fetchDeploymentStateCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchDeploymentStateCallable()");
  }

  @Override
  public abstract void close();
}
