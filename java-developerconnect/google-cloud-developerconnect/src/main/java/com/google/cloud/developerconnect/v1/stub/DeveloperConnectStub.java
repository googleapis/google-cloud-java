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

package com.google.cloud.developerconnect.v1.stub;

import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchGitRefsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchLinkableGitRepositoriesPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListAccountConnectorsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListConnectionsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListGitRepositoryLinksPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListLocationsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListUsersPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.developerconnect.v1.AccountConnector;
import com.google.cloud.developerconnect.v1.Connection;
import com.google.cloud.developerconnect.v1.CreateAccountConnectorRequest;
import com.google.cloud.developerconnect.v1.CreateConnectionRequest;
import com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.DeleteAccountConnectorRequest;
import com.google.cloud.developerconnect.v1.DeleteConnectionRequest;
import com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.DeleteSelfRequest;
import com.google.cloud.developerconnect.v1.DeleteUserRequest;
import com.google.cloud.developerconnect.v1.FetchAccessTokenRequest;
import com.google.cloud.developerconnect.v1.FetchAccessTokenResponse;
import com.google.cloud.developerconnect.v1.FetchGitHubInstallationsRequest;
import com.google.cloud.developerconnect.v1.FetchGitHubInstallationsResponse;
import com.google.cloud.developerconnect.v1.FetchGitRefsRequest;
import com.google.cloud.developerconnect.v1.FetchGitRefsResponse;
import com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesRequest;
import com.google.cloud.developerconnect.v1.FetchLinkableGitRepositoriesResponse;
import com.google.cloud.developerconnect.v1.FetchReadTokenRequest;
import com.google.cloud.developerconnect.v1.FetchReadTokenResponse;
import com.google.cloud.developerconnect.v1.FetchReadWriteTokenRequest;
import com.google.cloud.developerconnect.v1.FetchReadWriteTokenResponse;
import com.google.cloud.developerconnect.v1.FetchSelfRequest;
import com.google.cloud.developerconnect.v1.GetAccountConnectorRequest;
import com.google.cloud.developerconnect.v1.GetConnectionRequest;
import com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.GitRepositoryLink;
import com.google.cloud.developerconnect.v1.ListAccountConnectorsRequest;
import com.google.cloud.developerconnect.v1.ListAccountConnectorsResponse;
import com.google.cloud.developerconnect.v1.ListConnectionsRequest;
import com.google.cloud.developerconnect.v1.ListConnectionsResponse;
import com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest;
import com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse;
import com.google.cloud.developerconnect.v1.ListUsersRequest;
import com.google.cloud.developerconnect.v1.ListUsersResponse;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.cloud.developerconnect.v1.UpdateAccountConnectorRequest;
import com.google.cloud.developerconnect.v1.UpdateConnectionRequest;
import com.google.cloud.developerconnect.v1.User;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DeveloperConnect service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DeveloperConnectStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectionsPagedCallable()");
  }

  public UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> listConnectionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listConnectionsCallable()");
  }

  public UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: getConnectionCallable()");
  }

  public OperationCallable<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectionOperationCallable()");
  }

  public UnaryCallable<CreateConnectionRequest, Operation> createConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: createConnectionCallable()");
  }

  public OperationCallable<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectionOperationCallable()");
  }

  public UnaryCallable<UpdateConnectionRequest, Operation> updateConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: updateConnectionCallable()");
  }

  public OperationCallable<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectionOperationCallable()");
  }

  public UnaryCallable<DeleteConnectionRequest, Operation> deleteConnectionCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteConnectionCallable()");
  }

  public OperationCallable<CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
      createGitRepositoryLinkOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createGitRepositoryLinkOperationCallable()");
  }

  public UnaryCallable<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: createGitRepositoryLinkCallable()");
  }

  public OperationCallable<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
      deleteGitRepositoryLinkOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteGitRepositoryLinkOperationCallable()");
  }

  public UnaryCallable<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteGitRepositoryLinkCallable()");
  }

  public UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksPagedResponse>
      listGitRepositoryLinksPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listGitRepositoryLinksPagedCallable()");
  }

  public UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
      listGitRepositoryLinksCallable() {
    throw new UnsupportedOperationException("Not implemented: listGitRepositoryLinksCallable()");
  }

  public UnaryCallable<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkCallable() {
    throw new UnsupportedOperationException("Not implemented: getGitRepositoryLinkCallable()");
  }

  public UnaryCallable<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchReadWriteTokenCallable()");
  }

  public UnaryCallable<FetchReadTokenRequest, FetchReadTokenResponse> fetchReadTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchReadTokenCallable()");
  }

  public UnaryCallable<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesPagedResponse>
      fetchLinkableGitRepositoriesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchLinkableGitRepositoriesPagedCallable()");
  }

  public UnaryCallable<FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
      fetchLinkableGitRepositoriesCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: fetchLinkableGitRepositoriesCallable()");
  }

  public UnaryCallable<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchGitHubInstallationsCallable()");
  }

  public UnaryCallable<FetchGitRefsRequest, FetchGitRefsPagedResponse> fetchGitRefsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchGitRefsPagedCallable()");
  }

  public UnaryCallable<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchGitRefsCallable()");
  }

  public UnaryCallable<ListAccountConnectorsRequest, ListAccountConnectorsPagedResponse>
      listAccountConnectorsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listAccountConnectorsPagedCallable()");
  }

  public UnaryCallable<ListAccountConnectorsRequest, ListAccountConnectorsResponse>
      listAccountConnectorsCallable() {
    throw new UnsupportedOperationException("Not implemented: listAccountConnectorsCallable()");
  }

  public UnaryCallable<GetAccountConnectorRequest, AccountConnector> getAccountConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: getAccountConnectorCallable()");
  }

  public OperationCallable<CreateAccountConnectorRequest, AccountConnector, OperationMetadata>
      createAccountConnectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createAccountConnectorOperationCallable()");
  }

  public UnaryCallable<CreateAccountConnectorRequest, Operation> createAccountConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: createAccountConnectorCallable()");
  }

  public OperationCallable<UpdateAccountConnectorRequest, AccountConnector, OperationMetadata>
      updateAccountConnectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateAccountConnectorOperationCallable()");
  }

  public UnaryCallable<UpdateAccountConnectorRequest, Operation> updateAccountConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: updateAccountConnectorCallable()");
  }

  public OperationCallable<DeleteAccountConnectorRequest, Empty, OperationMetadata>
      deleteAccountConnectorOperationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: deleteAccountConnectorOperationCallable()");
  }

  public UnaryCallable<DeleteAccountConnectorRequest, Operation> deleteAccountConnectorCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteAccountConnectorCallable()");
  }

  public UnaryCallable<FetchAccessTokenRequest, FetchAccessTokenResponse>
      fetchAccessTokenCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchAccessTokenCallable()");
  }

  public UnaryCallable<ListUsersRequest, ListUsersPagedResponse> listUsersPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsersPagedCallable()");
  }

  public UnaryCallable<ListUsersRequest, ListUsersResponse> listUsersCallable() {
    throw new UnsupportedOperationException("Not implemented: listUsersCallable()");
  }

  public OperationCallable<DeleteUserRequest, Empty, OperationMetadata>
      deleteUserOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserOperationCallable()");
  }

  public UnaryCallable<DeleteUserRequest, Operation> deleteUserCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteUserCallable()");
  }

  public UnaryCallable<FetchSelfRequest, User> fetchSelfCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchSelfCallable()");
  }

  public OperationCallable<DeleteSelfRequest, Empty, OperationMetadata>
      deleteSelfOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSelfOperationCallable()");
  }

  public UnaryCallable<DeleteSelfRequest, Operation> deleteSelfCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSelfCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
