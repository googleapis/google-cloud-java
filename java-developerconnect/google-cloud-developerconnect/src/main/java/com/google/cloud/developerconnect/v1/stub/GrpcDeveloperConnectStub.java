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

package com.google.cloud.developerconnect.v1.stub;

import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchGitRefsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.FetchLinkableGitRepositoriesPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListConnectionsPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListGitRepositoryLinksPagedResponse;
import static com.google.cloud.developerconnect.v1.DeveloperConnectClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.grpc.GrpcCallSettings;
import com.google.api.gax.grpc.GrpcStubCallableFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.developerconnect.v1.Connection;
import com.google.cloud.developerconnect.v1.CreateConnectionRequest;
import com.google.cloud.developerconnect.v1.CreateGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.DeleteConnectionRequest;
import com.google.cloud.developerconnect.v1.DeleteGitRepositoryLinkRequest;
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
import com.google.cloud.developerconnect.v1.GetConnectionRequest;
import com.google.cloud.developerconnect.v1.GetGitRepositoryLinkRequest;
import com.google.cloud.developerconnect.v1.GitRepositoryLink;
import com.google.cloud.developerconnect.v1.ListConnectionsRequest;
import com.google.cloud.developerconnect.v1.ListConnectionsResponse;
import com.google.cloud.developerconnect.v1.ListGitRepositoryLinksRequest;
import com.google.cloud.developerconnect.v1.ListGitRepositoryLinksResponse;
import com.google.cloud.developerconnect.v1.OperationMetadata;
import com.google.cloud.developerconnect.v1.UpdateConnectionRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.protobuf.Empty;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * gRPC stub implementation for the DeveloperConnect service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class GrpcDeveloperConnectStub extends DeveloperConnectStub {
  private static final MethodDescriptor<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsMethodDescriptor =
          MethodDescriptor.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/ListConnections")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListConnectionsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListConnectionsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetConnectionRequest, Connection>
      getConnectionMethodDescriptor =
          MethodDescriptor.<GetConnectionRequest, Connection>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.developerconnect.v1.DeveloperConnect/GetConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Connection.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateConnectionRequest, Operation>
      createConnectionMethodDescriptor =
          MethodDescriptor.<CreateConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/CreateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<UpdateConnectionRequest, Operation>
      updateConnectionMethodDescriptor =
          MethodDescriptor.<UpdateConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/UpdateConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(UpdateConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteConnectionRequest, Operation>
      deleteConnectionMethodDescriptor =
          MethodDescriptor.<DeleteConnectionRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/DeleteConnection")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteConnectionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkMethodDescriptor =
          MethodDescriptor.<CreateGitRepositoryLinkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/CreateGitRepositoryLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(CreateGitRepositoryLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkMethodDescriptor =
          MethodDescriptor.<DeleteGitRepositoryLinkRequest, Operation>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/DeleteGitRepositoryLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(DeleteGitRepositoryLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(Operation.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
      listGitRepositoryLinksMethodDescriptor =
          MethodDescriptor
              .<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/ListGitRepositoryLinks")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListGitRepositoryLinksRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListGitRepositoryLinksResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkMethodDescriptor =
          MethodDescriptor.<GetGitRepositoryLinkRequest, GitRepositoryLink>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/GetGitRepositoryLink")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(GetGitRepositoryLinkRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(GitRepositoryLink.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenMethodDescriptor =
          MethodDescriptor.<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/FetchReadWriteToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchReadWriteTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchReadWriteTokenResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchReadTokenRequest, FetchReadTokenResponse>
      fetchReadTokenMethodDescriptor =
          MethodDescriptor.<FetchReadTokenRequest, FetchReadTokenResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.developerconnect.v1.DeveloperConnect/FetchReadToken")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchReadTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchReadTokenResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
      fetchLinkableGitRepositoriesMethodDescriptor =
          MethodDescriptor
              .<FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
                  newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/FetchLinkableGitRepositories")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchLinkableGitRepositoriesRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchLinkableGitRepositoriesResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<
          FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsMethodDescriptor =
          MethodDescriptor
              .<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(
                  "google.cloud.developerconnect.v1.DeveloperConnect/FetchGitHubInstallations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(FetchGitHubInstallationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchGitHubInstallationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<FetchGitRefsRequest, FetchGitRefsResponse>
      fetchGitRefsMethodDescriptor =
          MethodDescriptor.<FetchGitRefsRequest, FetchGitRefsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.developerconnect.v1.DeveloperConnect/FetchGitRefs")
              .setRequestMarshaller(ProtoUtils.marshaller(FetchGitRefsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(FetchGitRefsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          MethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setRequestMarshaller(
                  ProtoUtils.marshaller(ListLocationsRequest.getDefaultInstance()))
              .setResponseMarshaller(
                  ProtoUtils.marshaller(ListLocationsResponse.getDefaultInstance()))
              .build();

  private static final MethodDescriptor<GetLocationRequest, Location> getLocationMethodDescriptor =
      MethodDescriptor.<GetLocationRequest, Location>newBuilder()
          .setType(MethodDescriptor.MethodType.UNARY)
          .setFullMethodName("google.cloud.location.Locations/GetLocation")
          .setRequestMarshaller(ProtoUtils.marshaller(GetLocationRequest.getDefaultInstance()))
          .setResponseMarshaller(ProtoUtils.marshaller(Location.getDefaultInstance()))
          .build();

  private final UnaryCallable<ListConnectionsRequest, ListConnectionsResponse>
      listConnectionsCallable;
  private final UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable;
  private final UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable;
  private final UnaryCallable<CreateConnectionRequest, Operation> createConnectionCallable;
  private final OperationCallable<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationCallable;
  private final UnaryCallable<UpdateConnectionRequest, Operation> updateConnectionCallable;
  private final OperationCallable<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationCallable;
  private final UnaryCallable<DeleteConnectionRequest, Operation> deleteConnectionCallable;
  private final OperationCallable<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationCallable;
  private final UnaryCallable<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkCallable;
  private final OperationCallable<
          CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
      createGitRepositoryLinkOperationCallable;
  private final UnaryCallable<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkCallable;
  private final OperationCallable<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
      deleteGitRepositoryLinkOperationCallable;
  private final UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
      listGitRepositoryLinksCallable;
  private final UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksPagedResponse>
      listGitRepositoryLinksPagedCallable;
  private final UnaryCallable<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkCallable;
  private final UnaryCallable<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenCallable;
  private final UnaryCallable<FetchReadTokenRequest, FetchReadTokenResponse> fetchReadTokenCallable;
  private final UnaryCallable<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
      fetchLinkableGitRepositoriesCallable;
  private final UnaryCallable<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesPagedResponse>
      fetchLinkableGitRepositoriesPagedCallable;
  private final UnaryCallable<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsCallable;
  private final UnaryCallable<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsCallable;
  private final UnaryCallable<FetchGitRefsRequest, FetchGitRefsPagedResponse>
      fetchGitRefsPagedCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final GrpcOperationsStub operationsStub;
  private final GrpcStubCallableFactory callableFactory;

  public static final GrpcDeveloperConnectStub create(DeveloperConnectStubSettings settings)
      throws IOException {
    return new GrpcDeveloperConnectStub(settings, ClientContext.create(settings));
  }

  public static final GrpcDeveloperConnectStub create(ClientContext clientContext)
      throws IOException {
    return new GrpcDeveloperConnectStub(
        DeveloperConnectStubSettings.newBuilder().build(), clientContext);
  }

  public static final GrpcDeveloperConnectStub create(
      ClientContext clientContext, GrpcStubCallableFactory callableFactory) throws IOException {
    return new GrpcDeveloperConnectStub(
        DeveloperConnectStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of GrpcDeveloperConnectStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDeveloperConnectStub(
      DeveloperConnectStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new GrpcDeveloperConnectCallableFactory());
  }

  /**
   * Constructs an instance of GrpcDeveloperConnectStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GrpcDeveloperConnectStub(
      DeveloperConnectStubSettings settings,
      ClientContext clientContext,
      GrpcStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.operationsStub = GrpcOperationsStub.create(clientContext, callableFactory);

    GrpcCallSettings<ListConnectionsRequest, ListConnectionsResponse>
        listConnectionsTransportSettings =
            GrpcCallSettings.<ListConnectionsRequest, ListConnectionsResponse>newBuilder()
                .setMethodDescriptor(listConnectionsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetConnectionRequest, Connection> getConnectionTransportSettings =
        GrpcCallSettings.<GetConnectionRequest, Connection>newBuilder()
            .setMethodDescriptor(getConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateConnectionRequest, Operation> createConnectionTransportSettings =
        GrpcCallSettings.<CreateConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(createConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<UpdateConnectionRequest, Operation> updateConnectionTransportSettings =
        GrpcCallSettings.<UpdateConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(updateConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("connection.name", String.valueOf(request.getConnection().getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<DeleteConnectionRequest, Operation> deleteConnectionTransportSettings =
        GrpcCallSettings.<DeleteConnectionRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteConnectionMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<CreateGitRepositoryLinkRequest, Operation>
        createGitRepositoryLinkTransportSettings =
            GrpcCallSettings.<CreateGitRepositoryLinkRequest, Operation>newBuilder()
                .setMethodDescriptor(createGitRepositoryLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<DeleteGitRepositoryLinkRequest, Operation>
        deleteGitRepositoryLinkTransportSettings =
            GrpcCallSettings.<DeleteGitRepositoryLinkRequest, Operation>newBuilder()
                .setMethodDescriptor(deleteGitRepositoryLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
        listGitRepositoryLinksTransportSettings =
            GrpcCallSettings
                .<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>newBuilder()
                .setMethodDescriptor(listGitRepositoryLinksMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<GetGitRepositoryLinkRequest, GitRepositoryLink>
        getGitRepositoryLinkTransportSettings =
            GrpcCallSettings.<GetGitRepositoryLinkRequest, GitRepositoryLink>newBuilder()
                .setMethodDescriptor(getGitRepositoryLinkMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
        fetchReadWriteTokenTransportSettings =
            GrpcCallSettings.<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>newBuilder()
                .setMethodDescriptor(fetchReadWriteTokenMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "git_repository_link", String.valueOf(request.getGitRepositoryLink()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchReadTokenRequest, FetchReadTokenResponse>
        fetchReadTokenTransportSettings =
            GrpcCallSettings.<FetchReadTokenRequest, FetchReadTokenResponse>newBuilder()
                .setMethodDescriptor(fetchReadTokenMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "git_repository_link", String.valueOf(request.getGitRepositoryLink()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
        fetchLinkableGitRepositoriesTransportSettings =
            GrpcCallSettings
                .<FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
                    newBuilder()
                .setMethodDescriptor(fetchLinkableGitRepositoriesMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("connection", String.valueOf(request.getConnection()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
        fetchGitHubInstallationsTransportSettings =
            GrpcCallSettings
                .<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>newBuilder()
                .setMethodDescriptor(fetchGitHubInstallationsMethodDescriptor)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("connection", String.valueOf(request.getConnection()));
                      return builder.build();
                    })
                .build();
    GrpcCallSettings<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsTransportSettings =
        GrpcCallSettings.<FetchGitRefsRequest, FetchGitRefsResponse>newBuilder()
            .setMethodDescriptor(fetchGitRefsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add(
                      "git_repository_link", String.valueOf(request.getGitRepositoryLink()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<ListLocationsRequest, ListLocationsResponse> listLocationsTransportSettings =
        GrpcCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
            .setMethodDescriptor(listLocationsMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    GrpcCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        GrpcCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listConnectionsCallable =
        callableFactory.createUnaryCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.listConnectionsPagedCallable =
        callableFactory.createPagedCallable(
            listConnectionsTransportSettings, settings.listConnectionsSettings(), clientContext);
    this.getConnectionCallable =
        callableFactory.createUnaryCallable(
            getConnectionTransportSettings, settings.getConnectionSettings(), clientContext);
    this.createConnectionCallable =
        callableFactory.createUnaryCallable(
            createConnectionTransportSettings, settings.createConnectionSettings(), clientContext);
    this.createConnectionOperationCallable =
        callableFactory.createOperationCallable(
            createConnectionTransportSettings,
            settings.createConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.updateConnectionCallable =
        callableFactory.createUnaryCallable(
            updateConnectionTransportSettings, settings.updateConnectionSettings(), clientContext);
    this.updateConnectionOperationCallable =
        callableFactory.createOperationCallable(
            updateConnectionTransportSettings,
            settings.updateConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteConnectionCallable =
        callableFactory.createUnaryCallable(
            deleteConnectionTransportSettings, settings.deleteConnectionSettings(), clientContext);
    this.deleteConnectionOperationCallable =
        callableFactory.createOperationCallable(
            deleteConnectionTransportSettings,
            settings.deleteConnectionOperationSettings(),
            clientContext,
            operationsStub);
    this.createGitRepositoryLinkCallable =
        callableFactory.createUnaryCallable(
            createGitRepositoryLinkTransportSettings,
            settings.createGitRepositoryLinkSettings(),
            clientContext);
    this.createGitRepositoryLinkOperationCallable =
        callableFactory.createOperationCallable(
            createGitRepositoryLinkTransportSettings,
            settings.createGitRepositoryLinkOperationSettings(),
            clientContext,
            operationsStub);
    this.deleteGitRepositoryLinkCallable =
        callableFactory.createUnaryCallable(
            deleteGitRepositoryLinkTransportSettings,
            settings.deleteGitRepositoryLinkSettings(),
            clientContext);
    this.deleteGitRepositoryLinkOperationCallable =
        callableFactory.createOperationCallable(
            deleteGitRepositoryLinkTransportSettings,
            settings.deleteGitRepositoryLinkOperationSettings(),
            clientContext,
            operationsStub);
    this.listGitRepositoryLinksCallable =
        callableFactory.createUnaryCallable(
            listGitRepositoryLinksTransportSettings,
            settings.listGitRepositoryLinksSettings(),
            clientContext);
    this.listGitRepositoryLinksPagedCallable =
        callableFactory.createPagedCallable(
            listGitRepositoryLinksTransportSettings,
            settings.listGitRepositoryLinksSettings(),
            clientContext);
    this.getGitRepositoryLinkCallable =
        callableFactory.createUnaryCallable(
            getGitRepositoryLinkTransportSettings,
            settings.getGitRepositoryLinkSettings(),
            clientContext);
    this.fetchReadWriteTokenCallable =
        callableFactory.createUnaryCallable(
            fetchReadWriteTokenTransportSettings,
            settings.fetchReadWriteTokenSettings(),
            clientContext);
    this.fetchReadTokenCallable =
        callableFactory.createUnaryCallable(
            fetchReadTokenTransportSettings, settings.fetchReadTokenSettings(), clientContext);
    this.fetchLinkableGitRepositoriesCallable =
        callableFactory.createUnaryCallable(
            fetchLinkableGitRepositoriesTransportSettings,
            settings.fetchLinkableGitRepositoriesSettings(),
            clientContext);
    this.fetchLinkableGitRepositoriesPagedCallable =
        callableFactory.createPagedCallable(
            fetchLinkableGitRepositoriesTransportSettings,
            settings.fetchLinkableGitRepositoriesSettings(),
            clientContext);
    this.fetchGitHubInstallationsCallable =
        callableFactory.createUnaryCallable(
            fetchGitHubInstallationsTransportSettings,
            settings.fetchGitHubInstallationsSettings(),
            clientContext);
    this.fetchGitRefsCallable =
        callableFactory.createUnaryCallable(
            fetchGitRefsTransportSettings, settings.fetchGitRefsSettings(), clientContext);
    this.fetchGitRefsPagedCallable =
        callableFactory.createPagedCallable(
            fetchGitRefsTransportSettings, settings.fetchGitRefsSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public GrpcOperationsStub getOperationsStub() {
    return operationsStub;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsResponse> listConnectionsCallable() {
    return listConnectionsCallable;
  }

  @Override
  public UnaryCallable<ListConnectionsRequest, ListConnectionsPagedResponse>
      listConnectionsPagedCallable() {
    return listConnectionsPagedCallable;
  }

  @Override
  public UnaryCallable<GetConnectionRequest, Connection> getConnectionCallable() {
    return getConnectionCallable;
  }

  @Override
  public UnaryCallable<CreateConnectionRequest, Operation> createConnectionCallable() {
    return createConnectionCallable;
  }

  @Override
  public OperationCallable<CreateConnectionRequest, Connection, OperationMetadata>
      createConnectionOperationCallable() {
    return createConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<UpdateConnectionRequest, Operation> updateConnectionCallable() {
    return updateConnectionCallable;
  }

  @Override
  public OperationCallable<UpdateConnectionRequest, Connection, OperationMetadata>
      updateConnectionOperationCallable() {
    return updateConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteConnectionRequest, Operation> deleteConnectionCallable() {
    return deleteConnectionCallable;
  }

  @Override
  public OperationCallable<DeleteConnectionRequest, Empty, OperationMetadata>
      deleteConnectionOperationCallable() {
    return deleteConnectionOperationCallable;
  }

  @Override
  public UnaryCallable<CreateGitRepositoryLinkRequest, Operation>
      createGitRepositoryLinkCallable() {
    return createGitRepositoryLinkCallable;
  }

  @Override
  public OperationCallable<CreateGitRepositoryLinkRequest, GitRepositoryLink, OperationMetadata>
      createGitRepositoryLinkOperationCallable() {
    return createGitRepositoryLinkOperationCallable;
  }

  @Override
  public UnaryCallable<DeleteGitRepositoryLinkRequest, Operation>
      deleteGitRepositoryLinkCallable() {
    return deleteGitRepositoryLinkCallable;
  }

  @Override
  public OperationCallable<DeleteGitRepositoryLinkRequest, Empty, OperationMetadata>
      deleteGitRepositoryLinkOperationCallable() {
    return deleteGitRepositoryLinkOperationCallable;
  }

  @Override
  public UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksResponse>
      listGitRepositoryLinksCallable() {
    return listGitRepositoryLinksCallable;
  }

  @Override
  public UnaryCallable<ListGitRepositoryLinksRequest, ListGitRepositoryLinksPagedResponse>
      listGitRepositoryLinksPagedCallable() {
    return listGitRepositoryLinksPagedCallable;
  }

  @Override
  public UnaryCallable<GetGitRepositoryLinkRequest, GitRepositoryLink>
      getGitRepositoryLinkCallable() {
    return getGitRepositoryLinkCallable;
  }

  @Override
  public UnaryCallable<FetchReadWriteTokenRequest, FetchReadWriteTokenResponse>
      fetchReadWriteTokenCallable() {
    return fetchReadWriteTokenCallable;
  }

  @Override
  public UnaryCallable<FetchReadTokenRequest, FetchReadTokenResponse> fetchReadTokenCallable() {
    return fetchReadTokenCallable;
  }

  @Override
  public UnaryCallable<FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesResponse>
      fetchLinkableGitRepositoriesCallable() {
    return fetchLinkableGitRepositoriesCallable;
  }

  @Override
  public UnaryCallable<
          FetchLinkableGitRepositoriesRequest, FetchLinkableGitRepositoriesPagedResponse>
      fetchLinkableGitRepositoriesPagedCallable() {
    return fetchLinkableGitRepositoriesPagedCallable;
  }

  @Override
  public UnaryCallable<FetchGitHubInstallationsRequest, FetchGitHubInstallationsResponse>
      fetchGitHubInstallationsCallable() {
    return fetchGitHubInstallationsCallable;
  }

  @Override
  public UnaryCallable<FetchGitRefsRequest, FetchGitRefsResponse> fetchGitRefsCallable() {
    return fetchGitRefsCallable;
  }

  @Override
  public UnaryCallable<FetchGitRefsRequest, FetchGitRefsPagedResponse> fetchGitRefsPagedCallable() {
    return fetchGitRefsPagedCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
