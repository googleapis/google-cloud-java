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

import static com.google.cloud.gaming.v1alpha.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.gaming.v1alpha.CommitRolloutRequest;
import com.google.cloud.gaming.v1alpha.CreateGameServerDeploymentRequest;
import com.google.cloud.gaming.v1alpha.DeleteGameServerDeploymentRequest;
import com.google.cloud.gaming.v1alpha.DeploymentTarget;
import com.google.cloud.gaming.v1alpha.GameServerDeployment;
import com.google.cloud.gaming.v1alpha.GetDeploymentTargetRequest;
import com.google.cloud.gaming.v1alpha.GetGameServerDeploymentRequest;
import com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsRequest;
import com.google.cloud.gaming.v1alpha.ListGameServerDeploymentsResponse;
import com.google.cloud.gaming.v1alpha.RevertRolloutRequest;
import com.google.cloud.gaming.v1alpha.SetRolloutTargetRequest;
import com.google.cloud.gaming.v1alpha.StartRolloutRequest;
import com.google.cloud.gaming.v1alpha.UpdateGameServerDeploymentRequest;
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
public abstract class GameServerDeploymentsServiceStub implements BackgroundResource {

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
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

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CreateGameServerDeploymentRequest, GameServerDeployment, Empty>
      createGameServerDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGameServerDeploymentOperationCallable()");
  }

  public UnaryCallable<CreateGameServerDeploymentRequest, Operation>
      createGameServerDeploymentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGameServerDeploymentCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<DeleteGameServerDeploymentRequest, Empty, Empty>
      deleteGameServerDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGameServerDeploymentOperationCallable()");
  }

  public UnaryCallable<DeleteGameServerDeploymentRequest, Operation>
      deleteGameServerDeploymentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGameServerDeploymentCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<UpdateGameServerDeploymentRequest, GameServerDeployment, Empty>
      updateGameServerDeploymentOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGameServerDeploymentOperationCallable()");
  }

  public UnaryCallable<UpdateGameServerDeploymentRequest, Operation>
      updateGameServerDeploymentCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateGameServerDeploymentCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<StartRolloutRequest, GameServerDeployment, Empty>
      startRolloutOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: startRolloutOperationCallable()");
  }

  public UnaryCallable<StartRolloutRequest, Operation> startRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: startRolloutCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<SetRolloutTargetRequest, GameServerDeployment, Empty>
      setRolloutTargetOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setRolloutTargetOperationCallable()");
  }

  public UnaryCallable<SetRolloutTargetRequest, Operation> setRolloutTargetCallable() {
    throw new UnsupportedOperationException("Not implemented: setRolloutTargetCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<CommitRolloutRequest, GameServerDeployment, Empty>
      commitRolloutOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: commitRolloutOperationCallable()");
  }

  public UnaryCallable<CommitRolloutRequest, Operation> commitRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: commitRolloutCallable()");
  }

  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public OperationCallable<RevertRolloutRequest, GameServerDeployment, Empty>
      revertRolloutOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: revertRolloutOperationCallable()");
  }

  public UnaryCallable<RevertRolloutRequest, Operation> revertRolloutCallable() {
    throw new UnsupportedOperationException("Not implemented: revertRolloutCallable()");
  }

  public UnaryCallable<GetDeploymentTargetRequest, DeploymentTarget> getDeploymentTargetCallable() {
    throw new UnsupportedOperationException("Not implemented: getDeploymentTargetCallable()");
  }

  @Override
  public abstract void close();
}
