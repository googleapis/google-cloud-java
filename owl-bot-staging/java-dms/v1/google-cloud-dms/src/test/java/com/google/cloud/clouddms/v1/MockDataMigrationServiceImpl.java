/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.clouddms.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.clouddms.v1.DataMigrationServiceGrpc.DataMigrationServiceImplBase;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockDataMigrationServiceImpl extends DataMigrationServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataMigrationServiceImpl() {
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
  public void listMigrationJobs(
      ListMigrationJobsRequest request,
      StreamObserver<ListMigrationJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMigrationJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMigrationJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMigrationJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMigrationJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMigrationJob(
      GetMigrationJobRequest request, StreamObserver<MigrationJob> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MigrationJob) {
      requests.add(request);
      responseObserver.onNext(((MigrationJob) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MigrationJob.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMigrationJob(
      CreateMigrationJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMigrationJob(
      UpdateMigrationJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMigrationJob(
      DeleteMigrationJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void startMigrationJob(
      StartMigrationJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StartMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void stopMigrationJob(
      StopMigrationJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method StopMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void resumeMigrationJob(
      ResumeMigrationJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ResumeMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void promoteMigrationJob(
      PromoteMigrationJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method PromoteMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void verifyMigrationJob(
      VerifyMigrationJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method VerifyMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void restartMigrationJob(
      RestartMigrationJobRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RestartMigrationJob, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateSshScript(
      GenerateSshScriptRequest request, StreamObserver<SshScript> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SshScript) {
      requests.add(request);
      responseObserver.onNext(((SshScript) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateSshScript, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SshScript.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateTcpProxyScript(
      GenerateTcpProxyScriptRequest request, StreamObserver<TcpProxyScript> responseObserver) {
    Object response = responses.poll();
    if (response instanceof TcpProxyScript) {
      requests.add(request);
      responseObserver.onNext(((TcpProxyScript) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateTcpProxyScript, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  TcpProxyScript.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConnectionProfiles(
      ListConnectionProfilesRequest request,
      StreamObserver<ListConnectionProfilesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConnectionProfilesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConnectionProfilesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConnectionProfiles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConnectionProfilesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConnectionProfile(
      GetConnectionProfileRequest request, StreamObserver<ConnectionProfile> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConnectionProfile) {
      requests.add(request);
      responseObserver.onNext(((ConnectionProfile) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConnectionProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConnectionProfile.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConnectionProfile(
      CreateConnectionProfileRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateConnectionProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConnectionProfile(
      UpdateConnectionProfileRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateConnectionProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConnectionProfile(
      DeleteConnectionProfileRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConnectionProfile, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPrivateConnection(
      CreatePrivateConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPrivateConnection(
      GetPrivateConnectionRequest request, StreamObserver<PrivateConnection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PrivateConnection) {
      requests.add(request);
      responseObserver.onNext(((PrivateConnection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PrivateConnection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPrivateConnections(
      ListPrivateConnectionsRequest request,
      StreamObserver<ListPrivateConnectionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPrivateConnectionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPrivateConnectionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPrivateConnections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPrivateConnectionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePrivateConnection(
      DeletePrivateConnectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePrivateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConversionWorkspace(
      GetConversionWorkspaceRequest request, StreamObserver<ConversionWorkspace> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ConversionWorkspace) {
      requests.add(request);
      responseObserver.onNext(((ConversionWorkspace) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConversionWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ConversionWorkspace.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConversionWorkspaces(
      ListConversionWorkspacesRequest request,
      StreamObserver<ListConversionWorkspacesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConversionWorkspacesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConversionWorkspacesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConversionWorkspaces, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConversionWorkspacesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConversionWorkspace(
      CreateConversionWorkspaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateConversionWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConversionWorkspace(
      UpdateConversionWorkspaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateConversionWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConversionWorkspace(
      DeleteConversionWorkspaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConversionWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMappingRule(
      CreateMappingRuleRequest request, StreamObserver<MappingRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MappingRule) {
      requests.add(request);
      responseObserver.onNext(((MappingRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMappingRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MappingRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMappingRule(
      DeleteMappingRuleRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteMappingRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMappingRules(
      ListMappingRulesRequest request, StreamObserver<ListMappingRulesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListMappingRulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMappingRulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMappingRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMappingRulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMappingRule(
      GetMappingRuleRequest request, StreamObserver<MappingRule> responseObserver) {
    Object response = responses.poll();
    if (response instanceof MappingRule) {
      requests.add(request);
      responseObserver.onNext(((MappingRule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMappingRule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MappingRule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void seedConversionWorkspace(
      SeedConversionWorkspaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SeedConversionWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importMappingRules(
      ImportMappingRulesRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportMappingRules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void convertConversionWorkspace(
      ConvertConversionWorkspaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ConvertConversionWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void commitConversionWorkspace(
      CommitConversionWorkspaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CommitConversionWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void rollbackConversionWorkspace(
      RollbackConversionWorkspaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RollbackConversionWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void applyConversionWorkspace(
      ApplyConversionWorkspaceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ApplyConversionWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void describeDatabaseEntities(
      DescribeDatabaseEntitiesRequest request,
      StreamObserver<DescribeDatabaseEntitiesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DescribeDatabaseEntitiesResponse) {
      requests.add(request);
      responseObserver.onNext(((DescribeDatabaseEntitiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DescribeDatabaseEntities, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DescribeDatabaseEntitiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchBackgroundJobs(
      SearchBackgroundJobsRequest request,
      StreamObserver<SearchBackgroundJobsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchBackgroundJobsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchBackgroundJobsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchBackgroundJobs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchBackgroundJobsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void describeConversionWorkspaceRevisions(
      DescribeConversionWorkspaceRevisionsRequest request,
      StreamObserver<DescribeConversionWorkspaceRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DescribeConversionWorkspaceRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((DescribeConversionWorkspaceRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DescribeConversionWorkspaceRevisions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DescribeConversionWorkspaceRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchStaticIps(
      FetchStaticIpsRequest request, StreamObserver<FetchStaticIpsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchStaticIpsResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchStaticIpsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchStaticIps, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchStaticIpsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
