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

package com.google.cloud.managedkafka.v1.stub;

import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectorsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.ConnectCluster;
import com.google.cloud.managedkafka.v1.Connector;
import com.google.cloud.managedkafka.v1.CreateConnectClusterRequest;
import com.google.cloud.managedkafka.v1.CreateConnectorRequest;
import com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest;
import com.google.cloud.managedkafka.v1.DeleteConnectorRequest;
import com.google.cloud.managedkafka.v1.GetConnectClusterRequest;
import com.google.cloud.managedkafka.v1.GetConnectorRequest;
import com.google.cloud.managedkafka.v1.ListConnectClustersRequest;
import com.google.cloud.managedkafka.v1.ListConnectClustersResponse;
import com.google.cloud.managedkafka.v1.ListConnectorsRequest;
import com.google.cloud.managedkafka.v1.ListConnectorsResponse;
import com.google.cloud.managedkafka.v1.OperationMetadata;
import com.google.cloud.managedkafka.v1.PauseConnectorRequest;
import com.google.cloud.managedkafka.v1.PauseConnectorResponse;
import com.google.cloud.managedkafka.v1.RestartConnectorRequest;
import com.google.cloud.managedkafka.v1.RestartConnectorResponse;
import com.google.cloud.managedkafka.v1.ResumeConnectorRequest;
import com.google.cloud.managedkafka.v1.ResumeConnectorResponse;
import com.google.cloud.managedkafka.v1.StopConnectorRequest;
import com.google.cloud.managedkafka.v1.StopConnectorResponse;
import com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest;
import com.google.cloud.managedkafka.v1.UpdateConnectorRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ManagedKafkaConnectStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (managedkafka.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getConnectCluster:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedKafkaConnectStubSettings.Builder managedKafkaConnectSettingsBuilder =
 *     ManagedKafkaConnectStubSettings.newBuilder();
 * managedKafkaConnectSettingsBuilder
 *     .getConnectClusterSettings()
 *     .setRetrySettings(
 *         managedKafkaConnectSettingsBuilder
 *             .getConnectClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * ManagedKafkaConnectStubSettings managedKafkaConnectSettings =
 *     managedKafkaConnectSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createConnectCluster:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ManagedKafkaConnectStubSettings.Builder managedKafkaConnectSettingsBuilder =
 *     ManagedKafkaConnectStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * managedKafkaConnectSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ManagedKafkaConnectStubSettings extends StubSettings<ManagedKafkaConnectStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListConnectClustersRequest, ListConnectClustersResponse, ListConnectClustersPagedResponse>
      listConnectClustersSettings;
  private final UnaryCallSettings<GetConnectClusterRequest, ConnectCluster>
      getConnectClusterSettings;
  private final UnaryCallSettings<CreateConnectClusterRequest, Operation>
      createConnectClusterSettings;
  private final OperationCallSettings<
          CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
      createConnectClusterOperationSettings;
  private final UnaryCallSettings<UpdateConnectClusterRequest, Operation>
      updateConnectClusterSettings;
  private final OperationCallSettings<
          UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
      updateConnectClusterOperationSettings;
  private final UnaryCallSettings<DeleteConnectClusterRequest, Operation>
      deleteConnectClusterSettings;
  private final OperationCallSettings<DeleteConnectClusterRequest, Empty, OperationMetadata>
      deleteConnectClusterOperationSettings;
  private final PagedCallSettings<
          ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
      listConnectorsSettings;
  private final UnaryCallSettings<GetConnectorRequest, Connector> getConnectorSettings;
  private final UnaryCallSettings<CreateConnectorRequest, Connector> createConnectorSettings;
  private final UnaryCallSettings<UpdateConnectorRequest, Connector> updateConnectorSettings;
  private final UnaryCallSettings<DeleteConnectorRequest, Empty> deleteConnectorSettings;
  private final UnaryCallSettings<PauseConnectorRequest, PauseConnectorResponse>
      pauseConnectorSettings;
  private final UnaryCallSettings<ResumeConnectorRequest, ResumeConnectorResponse>
      resumeConnectorSettings;
  private final UnaryCallSettings<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorSettings;
  private final UnaryCallSettings<StopConnectorRequest, StopConnectorResponse>
      stopConnectorSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListConnectClustersRequest, ListConnectClustersResponse, ConnectCluster>
      LIST_CONNECT_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConnectClustersRequest, ListConnectClustersResponse, ConnectCluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConnectClustersRequest injectToken(
                ListConnectClustersRequest payload, String token) {
              return ListConnectClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConnectClustersRequest injectPageSize(
                ListConnectClustersRequest payload, int pageSize) {
              return ListConnectClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConnectClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConnectClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConnectCluster> extractResources(ListConnectClustersResponse payload) {
              return payload.getConnectClustersList();
            }
          };

  private static final PagedListDescriptor<ListConnectorsRequest, ListConnectorsResponse, Connector>
      LIST_CONNECTORS_PAGE_STR_DESC =
          new PagedListDescriptor<ListConnectorsRequest, ListConnectorsResponse, Connector>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConnectorsRequest injectToken(ListConnectorsRequest payload, String token) {
              return ListConnectorsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConnectorsRequest injectPageSize(
                ListConnectorsRequest payload, int pageSize) {
              return ListConnectorsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConnectorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConnectorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Connector> extractResources(ListConnectorsResponse payload) {
              return payload.getConnectorsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListConnectClustersRequest, ListConnectClustersResponse, ListConnectClustersPagedResponse>
      LIST_CONNECT_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConnectClustersRequest,
              ListConnectClustersResponse,
              ListConnectClustersPagedResponse>() {
            @Override
            public ApiFuture<ListConnectClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConnectClustersRequest, ListConnectClustersResponse> callable,
                ListConnectClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListConnectClustersResponse> futureResponse) {
              PageContext<ListConnectClustersRequest, ListConnectClustersResponse, ConnectCluster>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONNECT_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListConnectClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
      LIST_CONNECTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>() {
            @Override
            public ApiFuture<ListConnectorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConnectorsRequest, ListConnectorsResponse> callable,
                ListConnectorsRequest request,
                ApiCallContext context,
                ApiFuture<ListConnectorsResponse> futureResponse) {
              PageContext<ListConnectorsRequest, ListConnectorsResponse, Connector> pageContext =
                  PageContext.create(callable, LIST_CONNECTORS_PAGE_STR_DESC, request, context);
              return ListConnectorsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listConnectClusters. */
  public PagedCallSettings<
          ListConnectClustersRequest, ListConnectClustersResponse, ListConnectClustersPagedResponse>
      listConnectClustersSettings() {
    return listConnectClustersSettings;
  }

  /** Returns the object with the settings used for calls to getConnectCluster. */
  public UnaryCallSettings<GetConnectClusterRequest, ConnectCluster> getConnectClusterSettings() {
    return getConnectClusterSettings;
  }

  /** Returns the object with the settings used for calls to createConnectCluster. */
  public UnaryCallSettings<CreateConnectClusterRequest, Operation> createConnectClusterSettings() {
    return createConnectClusterSettings;
  }

  /** Returns the object with the settings used for calls to createConnectCluster. */
  public OperationCallSettings<CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
      createConnectClusterOperationSettings() {
    return createConnectClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateConnectCluster. */
  public UnaryCallSettings<UpdateConnectClusterRequest, Operation> updateConnectClusterSettings() {
    return updateConnectClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateConnectCluster. */
  public OperationCallSettings<UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
      updateConnectClusterOperationSettings() {
    return updateConnectClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnectCluster. */
  public UnaryCallSettings<DeleteConnectClusterRequest, Operation> deleteConnectClusterSettings() {
    return deleteConnectClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnectCluster. */
  public OperationCallSettings<DeleteConnectClusterRequest, Empty, OperationMetadata>
      deleteConnectClusterOperationSettings() {
    return deleteConnectClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to listConnectors. */
  public PagedCallSettings<
          ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
      listConnectorsSettings() {
    return listConnectorsSettings;
  }

  /** Returns the object with the settings used for calls to getConnector. */
  public UnaryCallSettings<GetConnectorRequest, Connector> getConnectorSettings() {
    return getConnectorSettings;
  }

  /** Returns the object with the settings used for calls to createConnector. */
  public UnaryCallSettings<CreateConnectorRequest, Connector> createConnectorSettings() {
    return createConnectorSettings;
  }

  /** Returns the object with the settings used for calls to updateConnector. */
  public UnaryCallSettings<UpdateConnectorRequest, Connector> updateConnectorSettings() {
    return updateConnectorSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnector. */
  public UnaryCallSettings<DeleteConnectorRequest, Empty> deleteConnectorSettings() {
    return deleteConnectorSettings;
  }

  /** Returns the object with the settings used for calls to pauseConnector. */
  public UnaryCallSettings<PauseConnectorRequest, PauseConnectorResponse> pauseConnectorSettings() {
    return pauseConnectorSettings;
  }

  /** Returns the object with the settings used for calls to resumeConnector. */
  public UnaryCallSettings<ResumeConnectorRequest, ResumeConnectorResponse>
      resumeConnectorSettings() {
    return resumeConnectorSettings;
  }

  /** Returns the object with the settings used for calls to restartConnector. */
  public UnaryCallSettings<RestartConnectorRequest, RestartConnectorResponse>
      restartConnectorSettings() {
    return restartConnectorSettings;
  }

  /** Returns the object with the settings used for calls to stopConnector. */
  public UnaryCallSettings<StopConnectorRequest, StopConnectorResponse> stopConnectorSettings() {
    return stopConnectorSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public ManagedKafkaConnectStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcManagedKafkaConnectStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonManagedKafkaConnectStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "managedkafka";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "managedkafka.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "managedkafka.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ManagedKafkaConnectStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ManagedKafkaConnectStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ManagedKafkaConnectStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ManagedKafkaConnectStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listConnectClustersSettings = settingsBuilder.listConnectClustersSettings().build();
    getConnectClusterSettings = settingsBuilder.getConnectClusterSettings().build();
    createConnectClusterSettings = settingsBuilder.createConnectClusterSettings().build();
    createConnectClusterOperationSettings =
        settingsBuilder.createConnectClusterOperationSettings().build();
    updateConnectClusterSettings = settingsBuilder.updateConnectClusterSettings().build();
    updateConnectClusterOperationSettings =
        settingsBuilder.updateConnectClusterOperationSettings().build();
    deleteConnectClusterSettings = settingsBuilder.deleteConnectClusterSettings().build();
    deleteConnectClusterOperationSettings =
        settingsBuilder.deleteConnectClusterOperationSettings().build();
    listConnectorsSettings = settingsBuilder.listConnectorsSettings().build();
    getConnectorSettings = settingsBuilder.getConnectorSettings().build();
    createConnectorSettings = settingsBuilder.createConnectorSettings().build();
    updateConnectorSettings = settingsBuilder.updateConnectorSettings().build();
    deleteConnectorSettings = settingsBuilder.deleteConnectorSettings().build();
    pauseConnectorSettings = settingsBuilder.pauseConnectorSettings().build();
    resumeConnectorSettings = settingsBuilder.resumeConnectorSettings().build();
    restartConnectorSettings = settingsBuilder.restartConnectorSettings().build();
    stopConnectorSettings = settingsBuilder.stopConnectorSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ManagedKafkaConnectStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ManagedKafkaConnectStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListConnectClustersRequest,
            ListConnectClustersResponse,
            ListConnectClustersPagedResponse>
        listConnectClustersSettings;
    private final UnaryCallSettings.Builder<GetConnectClusterRequest, ConnectCluster>
        getConnectClusterSettings;
    private final UnaryCallSettings.Builder<CreateConnectClusterRequest, Operation>
        createConnectClusterSettings;
    private final OperationCallSettings.Builder<
            CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
        createConnectClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateConnectClusterRequest, Operation>
        updateConnectClusterSettings;
    private final OperationCallSettings.Builder<
            UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
        updateConnectClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteConnectClusterRequest, Operation>
        deleteConnectClusterSettings;
    private final OperationCallSettings.Builder<
            DeleteConnectClusterRequest, Empty, OperationMetadata>
        deleteConnectClusterOperationSettings;
    private final PagedCallSettings.Builder<
            ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
        listConnectorsSettings;
    private final UnaryCallSettings.Builder<GetConnectorRequest, Connector> getConnectorSettings;
    private final UnaryCallSettings.Builder<CreateConnectorRequest, Connector>
        createConnectorSettings;
    private final UnaryCallSettings.Builder<UpdateConnectorRequest, Connector>
        updateConnectorSettings;
    private final UnaryCallSettings.Builder<DeleteConnectorRequest, Empty> deleteConnectorSettings;
    private final UnaryCallSettings.Builder<PauseConnectorRequest, PauseConnectorResponse>
        pauseConnectorSettings;
    private final UnaryCallSettings.Builder<ResumeConnectorRequest, ResumeConnectorResponse>
        resumeConnectorSettings;
    private final UnaryCallSettings.Builder<RestartConnectorRequest, RestartConnectorResponse>
        restartConnectorSettings;
    private final UnaryCallSettings.Builder<StopConnectorRequest, StopConnectorResponse>
        stopConnectorSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listConnectClustersSettings =
          PagedCallSettings.newBuilder(LIST_CONNECT_CLUSTERS_PAGE_STR_FACT);
      getConnectClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectClusterOperationSettings = OperationCallSettings.newBuilder();
      updateConnectClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConnectClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteConnectClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConnectClusterOperationSettings = OperationCallSettings.newBuilder();
      listConnectorsSettings = PagedCallSettings.newBuilder(LIST_CONNECTORS_PAGE_STR_FACT);
      getConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pauseConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restartConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopConnectorSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConnectClustersSettings,
              getConnectClusterSettings,
              createConnectClusterSettings,
              updateConnectClusterSettings,
              deleteConnectClusterSettings,
              listConnectorsSettings,
              getConnectorSettings,
              createConnectorSettings,
              updateConnectorSettings,
              deleteConnectorSettings,
              pauseConnectorSettings,
              resumeConnectorSettings,
              restartConnectorSettings,
              stopConnectorSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ManagedKafkaConnectStubSettings settings) {
      super(settings);

      listConnectClustersSettings = settings.listConnectClustersSettings.toBuilder();
      getConnectClusterSettings = settings.getConnectClusterSettings.toBuilder();
      createConnectClusterSettings = settings.createConnectClusterSettings.toBuilder();
      createConnectClusterOperationSettings =
          settings.createConnectClusterOperationSettings.toBuilder();
      updateConnectClusterSettings = settings.updateConnectClusterSettings.toBuilder();
      updateConnectClusterOperationSettings =
          settings.updateConnectClusterOperationSettings.toBuilder();
      deleteConnectClusterSettings = settings.deleteConnectClusterSettings.toBuilder();
      deleteConnectClusterOperationSettings =
          settings.deleteConnectClusterOperationSettings.toBuilder();
      listConnectorsSettings = settings.listConnectorsSettings.toBuilder();
      getConnectorSettings = settings.getConnectorSettings.toBuilder();
      createConnectorSettings = settings.createConnectorSettings.toBuilder();
      updateConnectorSettings = settings.updateConnectorSettings.toBuilder();
      deleteConnectorSettings = settings.deleteConnectorSettings.toBuilder();
      pauseConnectorSettings = settings.pauseConnectorSettings.toBuilder();
      resumeConnectorSettings = settings.resumeConnectorSettings.toBuilder();
      restartConnectorSettings = settings.restartConnectorSettings.toBuilder();
      stopConnectorSettings = settings.stopConnectorSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConnectClustersSettings,
              getConnectClusterSettings,
              createConnectClusterSettings,
              updateConnectClusterSettings,
              deleteConnectClusterSettings,
              listConnectorsSettings,
              getConnectorSettings,
              createConnectorSettings,
              updateConnectorSettings,
              deleteConnectorSettings,
              pauseConnectorSettings,
              resumeConnectorSettings,
              restartConnectorSettings,
              stopConnectorSettings,
              listLocationsSettings,
              getLocationSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listConnectClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConnectClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConnectClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateConnectClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteConnectClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listConnectorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .pauseConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resumeConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .restartConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopConnectorSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createConnectClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConnectClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConnectCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateConnectClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateConnectClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConnectCluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteConnectClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteConnectClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listConnectClusters. */
    public PagedCallSettings.Builder<
            ListConnectClustersRequest,
            ListConnectClustersResponse,
            ListConnectClustersPagedResponse>
        listConnectClustersSettings() {
      return listConnectClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getConnectCluster. */
    public UnaryCallSettings.Builder<GetConnectClusterRequest, ConnectCluster>
        getConnectClusterSettings() {
      return getConnectClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createConnectCluster. */
    public UnaryCallSettings.Builder<CreateConnectClusterRequest, Operation>
        createConnectClusterSettings() {
      return createConnectClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createConnectCluster. */
    public OperationCallSettings.Builder<
            CreateConnectClusterRequest, ConnectCluster, OperationMetadata>
        createConnectClusterOperationSettings() {
      return createConnectClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnectCluster. */
    public UnaryCallSettings.Builder<UpdateConnectClusterRequest, Operation>
        updateConnectClusterSettings() {
      return updateConnectClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnectCluster. */
    public OperationCallSettings.Builder<
            UpdateConnectClusterRequest, ConnectCluster, OperationMetadata>
        updateConnectClusterOperationSettings() {
      return updateConnectClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnectCluster. */
    public UnaryCallSettings.Builder<DeleteConnectClusterRequest, Operation>
        deleteConnectClusterSettings() {
      return deleteConnectClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnectCluster. */
    public OperationCallSettings.Builder<DeleteConnectClusterRequest, Empty, OperationMetadata>
        deleteConnectClusterOperationSettings() {
      return deleteConnectClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listConnectors. */
    public PagedCallSettings.Builder<
            ListConnectorsRequest, ListConnectorsResponse, ListConnectorsPagedResponse>
        listConnectorsSettings() {
      return listConnectorsSettings;
    }

    /** Returns the builder for the settings used for calls to getConnector. */
    public UnaryCallSettings.Builder<GetConnectorRequest, Connector> getConnectorSettings() {
      return getConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to createConnector. */
    public UnaryCallSettings.Builder<CreateConnectorRequest, Connector> createConnectorSettings() {
      return createConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnector. */
    public UnaryCallSettings.Builder<UpdateConnectorRequest, Connector> updateConnectorSettings() {
      return updateConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnector. */
    public UnaryCallSettings.Builder<DeleteConnectorRequest, Empty> deleteConnectorSettings() {
      return deleteConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to pauseConnector. */
    public UnaryCallSettings.Builder<PauseConnectorRequest, PauseConnectorResponse>
        pauseConnectorSettings() {
      return pauseConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to resumeConnector. */
    public UnaryCallSettings.Builder<ResumeConnectorRequest, ResumeConnectorResponse>
        resumeConnectorSettings() {
      return resumeConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to restartConnector. */
    public UnaryCallSettings.Builder<RestartConnectorRequest, RestartConnectorResponse>
        restartConnectorSettings() {
      return restartConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to stopConnector. */
    public UnaryCallSettings.Builder<StopConnectorRequest, StopConnectorResponse>
        stopConnectorSettings() {
      return stopConnectorSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public ManagedKafkaConnectStubSettings build() throws IOException {
      return new ManagedKafkaConnectStubSettings(this);
    }
  }
}
