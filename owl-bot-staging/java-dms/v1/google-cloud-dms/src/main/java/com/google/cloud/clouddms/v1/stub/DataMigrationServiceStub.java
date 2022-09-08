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

package com.google.cloud.clouddms.v1.stub;

import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.clouddms.v1.DataMigrationServiceClient.ListMigrationJobsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.clouddms.v1.ConnectionProfile;
import com.google.cloud.clouddms.v1.CreateConnectionProfileRequest;
import com.google.cloud.clouddms.v1.CreateMigrationJobRequest;
import com.google.cloud.clouddms.v1.DeleteConnectionProfileRequest;
import com.google.cloud.clouddms.v1.DeleteMigrationJobRequest;
import com.google.cloud.clouddms.v1.GenerateSshScriptRequest;
import com.google.cloud.clouddms.v1.GetConnectionProfileRequest;
import com.google.cloud.clouddms.v1.GetMigrationJobRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesRequest;
import com.google.cloud.clouddms.v1.ListConnectionProfilesResponse;
import com.google.cloud.clouddms.v1.ListMigrationJobsRequest;
import com.google.cloud.clouddms.v1.ListMigrationJobsResponse;
import com.google.cloud.clouddms.v1.MigrationJob;
import com.google.cloud.clouddms.v1.OperationMetadata;
import com.google.cloud.clouddms.v1.PromoteMigrationJobRequest;
import com.google.cloud.clouddms.v1.RestartMigrationJobRequest;
import com.google.cloud.clouddms.v1.ResumeMigrationJobRequest;
import com.google.cloud.clouddms.v1.SshScript;
import com.google.cloud.clouddms.v1.StartMigrationJobRequest;
import com.google.cloud.clouddms.v1.StopMigrationJobRequest;
import com.google.cloud.clouddms.v1.UpdateConnectionProfileRequest;
import com.google.cloud.clouddms.v1.UpdateMigrationJobRequest;
import com.google.cloud.clouddms.v1.VerifyMigrationJobRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataMigrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataMigrationServiceStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    throw new UnsupportedOperationException("Not implemented: getOperationsStub()");
  }

  public UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsPagedResponse>
      listMigrationJobsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMigrationJobsPagedCallable()");
  }

  public UnaryCallable<ListMigrationJobsRequest, ListMigrationJobsResponse>
      listMigrationJobsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMigrationJobsCallable()");
  }

  public UnaryCallable<GetMigrationJobRequest, MigrationJob> getMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: getMigrationJobCallable()");
  }

  public OperationCallable<CreateMigrationJobRequest, MigrationJob, OperationMetadata>
      createMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMigrationJobOperationCallable()");
  }

  public UnaryCallable<CreateMigrationJobRequest, Operation> createMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: createMigrationJobCallable()");
  }

  public OperationCallable<UpdateMigrationJobRequest, MigrationJob, OperationMetadata>
      updateMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMigrationJobOperationCallable()");
  }

  public UnaryCallable<UpdateMigrationJobRequest, Operation> updateMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMigrationJobCallable()");
  }

  public OperationCallable<DeleteMigrationJobRequest, Empty, OperationMetadata>
      deleteMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteMigrationJobOperationCallable()");
  }

  public UnaryCallable<DeleteMigrationJobRequest, Operation> deleteMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMigrationJobCallable()");
  }

  public OperationCallable<StartMigrationJobRequest, MigrationJob, OperationMetadata>
      startMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: startMigrationJobOperationCallable()");
  }

  public UnaryCallable<StartMigrationJobRequest, Operation> startMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: startMigrationJobCallable()");
  }

  public OperationCallable<StopMigrationJobRequest, MigrationJob, OperationMetadata>
      stopMigrationJobOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: stopMigrationJobOperationCallable()");
  }

  public UnaryCallable<StopMigrationJobRequest, Operation> stopMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: stopMigrationJobCallable()");
  }

  public OperationCallable<ResumeMigrationJobRequest, MigrationJob, OperationMetadata>
      resumeMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: resumeMigrationJobOperationCallable()");
  }

  public UnaryCallable<ResumeMigrationJobRequest, Operation> resumeMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: resumeMigrationJobCallable()");
  }

  public OperationCallable<PromoteMigrationJobRequest, MigrationJob, OperationMetadata>
      promoteMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: promoteMigrationJobOperationCallable()");
  }

  public UnaryCallable<PromoteMigrationJobRequest, Operation> promoteMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: promoteMigrationJobCallable()");
  }

  public OperationCallable<VerifyMigrationJobRequest, MigrationJob, OperationMetadata>
      verifyMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: verifyMigrationJobOperationCallable()");
  }

  public UnaryCallable<VerifyMigrationJobRequest, Operation> verifyMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: verifyMigrationJobCallable()");
  }

  public OperationCallable<RestartMigrationJobRequest, MigrationJob, OperationMetadata>
      restartMigrationJobOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: restartMigrationJobOperationCallable()");
  }

  public UnaryCallable<RestartMigrationJobRequest, Operation> restartMigrationJobCallable() {
    throw new UnsupportedOperationException("Not implemented: restartMigrationJobCallable()");
  }

  public UnaryCallable<GenerateSshScriptRequest, SshScript> generateSshScriptCallable() {
    throw new UnsupportedOperationException("Not implemented: generateSshScriptCallable()");
  }

  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesPagedResponse>
      listConnectionProfilesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listConnectionProfilesPagedCallable()");
  }

  public UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
      listConnectionProfilesCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectionProfilesCallable()");
  }

  public UnaryCallable<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectionProfileCallable()");
  }

  public OperationCallable<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createConnectionProfileOperationCallable()");
  }

  public UnaryCallable<CreateConnectionProfileRequest, Operation>
      createConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectionProfileCallable()");
  }

  public OperationCallable<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateConnectionProfileOperationCallable()");
  }

  public UnaryCallable<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectionProfileCallable()");
  }

  public OperationCallable<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteConnectionProfileOperationCallable()");
  }

  public UnaryCallable<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectionProfileCallable()");
  }

  @Override
  public abstract void close();
}
