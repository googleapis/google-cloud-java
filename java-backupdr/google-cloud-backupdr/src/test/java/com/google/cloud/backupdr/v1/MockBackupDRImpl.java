/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.backupdr.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.backupdr.v1.BackupDRGrpc.BackupDRImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockBackupDRImpl extends BackupDRImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockBackupDRImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void listManagementServers(
      ListManagementServersRequest request,
      StreamObserver<ListManagementServersResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListManagementServersResponse) {
      requests.add(request);
      responseObserver.onNext(((ListManagementServersResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListManagementServers, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListManagementServersResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getManagementServer(
      GetManagementServerRequest request, StreamObserver<ManagementServer> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ManagementServer) {
      requests.add(request);
      responseObserver.onNext(((ManagementServer) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetManagementServer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ManagementServer.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createManagementServer(
      CreateManagementServerRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateManagementServer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteManagementServer(
      DeleteManagementServerRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteManagementServer, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBackupVault(
      CreateBackupVaultRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBackupVault, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBackupVaults(
      ListBackupVaultsRequest request, StreamObserver<ListBackupVaultsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBackupVaultsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBackupVaultsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBackupVaults, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBackupVaultsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchUsableBackupVaults(
      FetchUsableBackupVaultsRequest request,
      StreamObserver<FetchUsableBackupVaultsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchUsableBackupVaultsResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchUsableBackupVaultsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchUsableBackupVaults, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchUsableBackupVaultsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBackupVault(
      GetBackupVaultRequest request, StreamObserver<BackupVault> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BackupVault) {
      requests.add(request);
      responseObserver.onNext(((BackupVault) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBackupVault, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BackupVault.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBackupVault(
      UpdateBackupVaultRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBackupVault, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBackupVault(
      DeleteBackupVaultRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteBackupVault, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataSources(
      ListDataSourcesRequest request, StreamObserver<ListDataSourcesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataSourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataSourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataSources, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataSourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataSource(
      GetDataSourceRequest request, StreamObserver<DataSource> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataSource) {
      requests.add(request);
      responseObserver.onNext(((DataSource) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataSource.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataSource(
      UpdateDataSourceRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataSource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBackups(
      ListBackupsRequest request, StreamObserver<ListBackupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBackupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBackupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBackups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBackupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBackup(GetBackupRequest request, StreamObserver<Backup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Backup) {
      requests.add(request);
      responseObserver.onNext(((Backup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBackup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Backup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBackup(
      UpdateBackupRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBackup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBackup(
      DeleteBackupRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteBackup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restoreBackup(
      RestoreBackupRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RestoreBackup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBackupPlan(
      CreateBackupPlanRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBackupPlan, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBackupPlan(
      GetBackupPlanRequest request, StreamObserver<BackupPlan> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BackupPlan) {
      requests.add(request);
      responseObserver.onNext(((BackupPlan) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBackupPlan, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BackupPlan.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBackupPlans(
      ListBackupPlansRequest request, StreamObserver<ListBackupPlansResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBackupPlansResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBackupPlansResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBackupPlans, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBackupPlansResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBackupPlan(
      DeleteBackupPlanRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteBackupPlan, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBackupPlanAssociation(
      CreateBackupPlanAssociationRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBackupPlanAssociation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBackupPlanAssociation(
      GetBackupPlanAssociationRequest request,
      StreamObserver<BackupPlanAssociation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BackupPlanAssociation) {
      requests.add(request);
      responseObserver.onNext(((BackupPlanAssociation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBackupPlanAssociation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BackupPlanAssociation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBackupPlanAssociations(
      ListBackupPlanAssociationsRequest request,
      StreamObserver<ListBackupPlanAssociationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListBackupPlanAssociationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBackupPlanAssociationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBackupPlanAssociations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBackupPlanAssociationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBackupPlanAssociation(
      DeleteBackupPlanAssociationRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteBackupPlanAssociation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void triggerBackup(
      TriggerBackupRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TriggerBackup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
