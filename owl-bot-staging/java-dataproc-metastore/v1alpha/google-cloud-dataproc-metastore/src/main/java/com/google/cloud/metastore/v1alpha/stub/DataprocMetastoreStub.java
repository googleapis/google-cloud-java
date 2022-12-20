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

package com.google.cloud.metastore.v1alpha.stub;

import static com.google.cloud.metastore.v1alpha.DataprocMetastoreClient.ListBackupsPagedResponse;
import static com.google.cloud.metastore.v1alpha.DataprocMetastoreClient.ListMetadataImportsPagedResponse;
import static com.google.cloud.metastore.v1alpha.DataprocMetastoreClient.ListServicesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.metastore.v1alpha.AlterMetadataResourceLocationRequest;
import com.google.cloud.metastore.v1alpha.AlterMetadataResourceLocationResponse;
import com.google.cloud.metastore.v1alpha.Backup;
import com.google.cloud.metastore.v1alpha.CreateBackupRequest;
import com.google.cloud.metastore.v1alpha.CreateMetadataImportRequest;
import com.google.cloud.metastore.v1alpha.CreateServiceRequest;
import com.google.cloud.metastore.v1alpha.DeleteBackupRequest;
import com.google.cloud.metastore.v1alpha.DeleteServiceRequest;
import com.google.cloud.metastore.v1alpha.ExportMetadataRequest;
import com.google.cloud.metastore.v1alpha.GetBackupRequest;
import com.google.cloud.metastore.v1alpha.GetMetadataImportRequest;
import com.google.cloud.metastore.v1alpha.GetServiceRequest;
import com.google.cloud.metastore.v1alpha.ListBackupsRequest;
import com.google.cloud.metastore.v1alpha.ListBackupsResponse;
import com.google.cloud.metastore.v1alpha.ListMetadataImportsRequest;
import com.google.cloud.metastore.v1alpha.ListMetadataImportsResponse;
import com.google.cloud.metastore.v1alpha.ListServicesRequest;
import com.google.cloud.metastore.v1alpha.ListServicesResponse;
import com.google.cloud.metastore.v1alpha.MetadataExport;
import com.google.cloud.metastore.v1alpha.MetadataImport;
import com.google.cloud.metastore.v1alpha.MoveTableToDatabaseRequest;
import com.google.cloud.metastore.v1alpha.MoveTableToDatabaseResponse;
import com.google.cloud.metastore.v1alpha.OperationMetadata;
import com.google.cloud.metastore.v1alpha.QueryMetadataRequest;
import com.google.cloud.metastore.v1alpha.QueryMetadataResponse;
import com.google.cloud.metastore.v1alpha.RemoveIamPolicyRequest;
import com.google.cloud.metastore.v1alpha.RemoveIamPolicyResponse;
import com.google.cloud.metastore.v1alpha.Restore;
import com.google.cloud.metastore.v1alpha.RestoreServiceRequest;
import com.google.cloud.metastore.v1alpha.Service;
import com.google.cloud.metastore.v1alpha.UpdateMetadataImportRequest;
import com.google.cloud.metastore.v1alpha.UpdateServiceRequest;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataprocMetastore service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class DataprocMetastoreStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesPagedCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesCallable()");
  }

  public UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: getServiceCallable()");
  }

  public OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceOperationCallable()");
  }

  public UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: createServiceCallable()");
  }

  public OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceOperationCallable()");
  }

  public UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServiceCallable()");
  }

  public OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceOperationCallable()");
  }

  public UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteServiceCallable()");
  }

  public UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsPagedResponse>
      listMetadataImportsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMetadataImportsPagedCallable()");
  }

  public UnaryCallable<ListMetadataImportsRequest, ListMetadataImportsResponse>
      listMetadataImportsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMetadataImportsCallable()");
  }

  public UnaryCallable<GetMetadataImportRequest, MetadataImport> getMetadataImportCallable() {
    throw new UnsupportedOperationException("Not implemented: getMetadataImportCallable()");
  }

  public OperationCallable<CreateMetadataImportRequest, MetadataImport, OperationMetadata>
      createMetadataImportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createMetadataImportOperationCallable()");
  }

  public UnaryCallable<CreateMetadataImportRequest, Operation> createMetadataImportCallable() {
    throw new UnsupportedOperationException("Not implemented: createMetadataImportCallable()");
  }

  public OperationCallable<UpdateMetadataImportRequest, MetadataImport, OperationMetadata>
      updateMetadataImportOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateMetadataImportOperationCallable()");
  }

  public UnaryCallable<UpdateMetadataImportRequest, Operation> updateMetadataImportCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMetadataImportCallable()");
  }

  public OperationCallable<ExportMetadataRequest, MetadataExport, OperationMetadata>
      exportMetadataOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: exportMetadataOperationCallable()");
  }

  public UnaryCallable<ExportMetadataRequest, Operation> exportMetadataCallable() {
    throw new UnsupportedOperationException("Not implemented: exportMetadataCallable()");
  }

  public OperationCallable<RestoreServiceRequest, Restore, OperationMetadata>
      restoreServiceOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreServiceOperationCallable()");
  }

  public UnaryCallable<RestoreServiceRequest, Operation> restoreServiceCallable() {
    throw new UnsupportedOperationException("Not implemented: restoreServiceCallable()");
  }

  public UnaryCallable<ListBackupsRequest, ListBackupsPagedResponse> listBackupsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupsPagedCallable()");
  }

  public UnaryCallable<ListBackupsRequest, ListBackupsResponse> listBackupsCallable() {
    throw new UnsupportedOperationException("Not implemented: listBackupsCallable()");
  }

  public UnaryCallable<GetBackupRequest, Backup> getBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: getBackupCallable()");
  }

  public OperationCallable<CreateBackupRequest, Backup, OperationMetadata>
      createBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupOperationCallable()");
  }

  public UnaryCallable<CreateBackupRequest, Operation> createBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: createBackupCallable()");
  }

  public OperationCallable<DeleteBackupRequest, Empty, OperationMetadata>
      deleteBackupOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupOperationCallable()");
  }

  public UnaryCallable<DeleteBackupRequest, Operation> deleteBackupCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteBackupCallable()");
  }

  public UnaryCallable<RemoveIamPolicyRequest, RemoveIamPolicyResponse> removeIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: removeIamPolicyCallable()");
  }

  public OperationCallable<QueryMetadataRequest, QueryMetadataResponse, OperationMetadata>
      queryMetadataOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: queryMetadataOperationCallable()");
  }

  public UnaryCallable<QueryMetadataRequest, Operation> queryMetadataCallable() {
    throw new UnsupportedOperationException("Not implemented: queryMetadataCallable()");
  }

  public OperationCallable<
          MoveTableToDatabaseRequest, MoveTableToDatabaseResponse, OperationMetadata>
      moveTableToDatabaseOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: moveTableToDatabaseOperationCallable()");
  }

  public UnaryCallable<MoveTableToDatabaseRequest, Operation> moveTableToDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: moveTableToDatabaseCallable()");
  }

  public OperationCallable<
          AlterMetadataResourceLocationRequest,
          AlterMetadataResourceLocationResponse,
          OperationMetadata>
      alterMetadataResourceLocationOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: alterMetadataResourceLocationOperationCallable()");
  }

  public UnaryCallable<AlterMetadataResourceLocationRequest, Operation>
      alterMetadataResourceLocationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: alterMetadataResourceLocationCallable()");
  }

  @Override
  public abstract void close();
}
