/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.ftp.v1.stub;

import static com.google.cloud.ftp.v1.CloudFtpClient.ListLocationsPagedResponse;
import static com.google.cloud.ftp.v1.CloudFtpClient.ListServersPagedResponse;
import static com.google.cloud.ftp.v1.CloudFtpClient.ListUsersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.cloud.ftp.v1.CreateServerRequest;
import com.google.cloud.ftp.v1.CreateUserRequest;
import com.google.cloud.ftp.v1.DeleteServerRequest;
import com.google.cloud.ftp.v1.DeleteUserRequest;
import com.google.cloud.ftp.v1.GetServerRequest;
import com.google.cloud.ftp.v1.GetUserRequest;
import com.google.cloud.ftp.v1.ListServersRequest;
import com.google.cloud.ftp.v1.ListServersResponse;
import com.google.cloud.ftp.v1.ListUsersRequest;
import com.google.cloud.ftp.v1.ListUsersResponse;
import com.google.cloud.ftp.v1.OperationMetadata;
import com.google.cloud.ftp.v1.Server;
import com.google.cloud.ftp.v1.StartServerRequest;
import com.google.cloud.ftp.v1.StopServerRequest;
import com.google.cloud.ftp.v1.UpdateServerRequest;
import com.google.cloud.ftp.v1.UpdateUserRequest;
import com.google.cloud.ftp.v1.User;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudFtpStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (ftp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getServer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudFtpStubSettings.Builder cloudFtpSettingsBuilder = CloudFtpStubSettings.newBuilder();
 * cloudFtpSettingsBuilder
 *     .getServerSettings()
 *     .setRetrySettings(
 *         cloudFtpSettingsBuilder
 *             .getServerSettings()
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
 * CloudFtpStubSettings cloudFtpSettings = cloudFtpSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createServer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudFtpStubSettings.Builder cloudFtpSettingsBuilder = CloudFtpStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * cloudFtpSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class CloudFtpStubSettings extends StubSettings<CloudFtpStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<ListServersRequest, ListServersResponse, ListServersPagedResponse>
      listServersSettings;
  private final UnaryCallSettings<GetServerRequest, Server> getServerSettings;
  private final UnaryCallSettings<CreateServerRequest, Operation> createServerSettings;
  private final OperationCallSettings<CreateServerRequest, Server, OperationMetadata>
      createServerOperationSettings;
  private final UnaryCallSettings<UpdateServerRequest, Operation> updateServerSettings;
  private final OperationCallSettings<UpdateServerRequest, Server, OperationMetadata>
      updateServerOperationSettings;
  private final UnaryCallSettings<DeleteServerRequest, Operation> deleteServerSettings;
  private final OperationCallSettings<DeleteServerRequest, Empty, OperationMetadata>
      deleteServerOperationSettings;
  private final PagedCallSettings<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
      listUsersSettings;
  private final UnaryCallSettings<GetUserRequest, User> getUserSettings;
  private final UnaryCallSettings<CreateUserRequest, Operation> createUserSettings;
  private final OperationCallSettings<CreateUserRequest, User, OperationMetadata>
      createUserOperationSettings;
  private final UnaryCallSettings<UpdateUserRequest, Operation> updateUserSettings;
  private final OperationCallSettings<UpdateUserRequest, User, OperationMetadata>
      updateUserOperationSettings;
  private final UnaryCallSettings<DeleteUserRequest, Operation> deleteUserSettings;
  private final OperationCallSettings<DeleteUserRequest, Empty, OperationMetadata>
      deleteUserOperationSettings;
  private final UnaryCallSettings<StartServerRequest, Operation> startServerSettings;
  private final OperationCallSettings<StartServerRequest, Server, OperationMetadata>
      startServerOperationSettings;
  private final UnaryCallSettings<StopServerRequest, Operation> stopServerSettings;
  private final OperationCallSettings<StopServerRequest, Server, OperationMetadata>
      stopServerOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListServersRequest, ListServersResponse, Server>
      LIST_SERVERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListServersRequest, ListServersResponse, Server>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServersRequest injectToken(ListServersRequest payload, String token) {
              return ListServersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServersRequest injectPageSize(ListServersRequest payload, int pageSize) {
              return ListServersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Server> extractResources(ListServersResponse payload) {
              return payload.getServersList();
            }
          };

  private static final PagedListDescriptor<ListUsersRequest, ListUsersResponse, User>
      LIST_USERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListUsersRequest, ListUsersResponse, User>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListUsersRequest injectToken(ListUsersRequest payload, String token) {
              return ListUsersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListUsersRequest injectPageSize(ListUsersRequest payload, int pageSize) {
              return ListUsersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListUsersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListUsersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<User> extractResources(ListUsersResponse payload) {
              return payload.getUsersList();
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
          ListServersRequest, ListServersResponse, ListServersPagedResponse>
      LIST_SERVERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServersRequest, ListServersResponse, ListServersPagedResponse>() {
            @Override
            public ApiFuture<ListServersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServersRequest, ListServersResponse> callable,
                ListServersRequest request,
                ApiCallContext context,
                ApiFuture<ListServersResponse> futureResponse) {
              PageContext<ListServersRequest, ListServersResponse, Server> pageContext =
                  PageContext.create(callable, LIST_SERVERS_PAGE_STR_DESC, request, context);
              return ListServersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
      LIST_USERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>() {
            @Override
            public ApiFuture<ListUsersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListUsersRequest, ListUsersResponse> callable,
                ListUsersRequest request,
                ApiCallContext context,
                ApiFuture<ListUsersResponse> futureResponse) {
              PageContext<ListUsersRequest, ListUsersResponse, User> pageContext =
                  PageContext.create(callable, LIST_USERS_PAGE_STR_DESC, request, context);
              return ListUsersPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listServers. */
  public PagedCallSettings<ListServersRequest, ListServersResponse, ListServersPagedResponse>
      listServersSettings() {
    return listServersSettings;
  }

  /** Returns the object with the settings used for calls to getServer. */
  public UnaryCallSettings<GetServerRequest, Server> getServerSettings() {
    return getServerSettings;
  }

  /** Returns the object with the settings used for calls to createServer. */
  public UnaryCallSettings<CreateServerRequest, Operation> createServerSettings() {
    return createServerSettings;
  }

  /** Returns the object with the settings used for calls to createServer. */
  public OperationCallSettings<CreateServerRequest, Server, OperationMetadata>
      createServerOperationSettings() {
    return createServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateServer. */
  public UnaryCallSettings<UpdateServerRequest, Operation> updateServerSettings() {
    return updateServerSettings;
  }

  /** Returns the object with the settings used for calls to updateServer. */
  public OperationCallSettings<UpdateServerRequest, Server, OperationMetadata>
      updateServerOperationSettings() {
    return updateServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteServer. */
  public UnaryCallSettings<DeleteServerRequest, Operation> deleteServerSettings() {
    return deleteServerSettings;
  }

  /** Returns the object with the settings used for calls to deleteServer. */
  public OperationCallSettings<DeleteServerRequest, Empty, OperationMetadata>
      deleteServerOperationSettings() {
    return deleteServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to listUsers. */
  public PagedCallSettings<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
      listUsersSettings() {
    return listUsersSettings;
  }

  /** Returns the object with the settings used for calls to getUser. */
  public UnaryCallSettings<GetUserRequest, User> getUserSettings() {
    return getUserSettings;
  }

  /** Returns the object with the settings used for calls to createUser. */
  public UnaryCallSettings<CreateUserRequest, Operation> createUserSettings() {
    return createUserSettings;
  }

  /** Returns the object with the settings used for calls to createUser. */
  public OperationCallSettings<CreateUserRequest, User, OperationMetadata>
      createUserOperationSettings() {
    return createUserOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateUser. */
  public UnaryCallSettings<UpdateUserRequest, Operation> updateUserSettings() {
    return updateUserSettings;
  }

  /** Returns the object with the settings used for calls to updateUser. */
  public OperationCallSettings<UpdateUserRequest, User, OperationMetadata>
      updateUserOperationSettings() {
    return updateUserOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteUser. */
  public UnaryCallSettings<DeleteUserRequest, Operation> deleteUserSettings() {
    return deleteUserSettings;
  }

  /** Returns the object with the settings used for calls to deleteUser. */
  public OperationCallSettings<DeleteUserRequest, Empty, OperationMetadata>
      deleteUserOperationSettings() {
    return deleteUserOperationSettings;
  }

  /** Returns the object with the settings used for calls to startServer. */
  public UnaryCallSettings<StartServerRequest, Operation> startServerSettings() {
    return startServerSettings;
  }

  /** Returns the object with the settings used for calls to startServer. */
  public OperationCallSettings<StartServerRequest, Server, OperationMetadata>
      startServerOperationSettings() {
    return startServerOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopServer. */
  public UnaryCallSettings<StopServerRequest, Operation> stopServerSettings() {
    return stopServerSettings;
  }

  /** Returns the object with the settings used for calls to stopServer. */
  public OperationCallSettings<StopServerRequest, Server, OperationMetadata>
      stopServerOperationSettings() {
    return stopServerOperationSettings;
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

  public CloudFtpStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCloudFtpStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "ftp";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "ftp.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "ftp.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(CloudFtpStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CloudFtpStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listServersSettings = settingsBuilder.listServersSettings().build();
    getServerSettings = settingsBuilder.getServerSettings().build();
    createServerSettings = settingsBuilder.createServerSettings().build();
    createServerOperationSettings = settingsBuilder.createServerOperationSettings().build();
    updateServerSettings = settingsBuilder.updateServerSettings().build();
    updateServerOperationSettings = settingsBuilder.updateServerOperationSettings().build();
    deleteServerSettings = settingsBuilder.deleteServerSettings().build();
    deleteServerOperationSettings = settingsBuilder.deleteServerOperationSettings().build();
    listUsersSettings = settingsBuilder.listUsersSettings().build();
    getUserSettings = settingsBuilder.getUserSettings().build();
    createUserSettings = settingsBuilder.createUserSettings().build();
    createUserOperationSettings = settingsBuilder.createUserOperationSettings().build();
    updateUserSettings = settingsBuilder.updateUserSettings().build();
    updateUserOperationSettings = settingsBuilder.updateUserOperationSettings().build();
    deleteUserSettings = settingsBuilder.deleteUserSettings().build();
    deleteUserOperationSettings = settingsBuilder.deleteUserOperationSettings().build();
    startServerSettings = settingsBuilder.startServerSettings().build();
    startServerOperationSettings = settingsBuilder.startServerOperationSettings().build();
    stopServerSettings = settingsBuilder.stopServerSettings().build();
    stopServerOperationSettings = settingsBuilder.stopServerOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-ftp")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for CloudFtpStubSettings. */
  public static class Builder extends StubSettings.Builder<CloudFtpStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListServersRequest, ListServersResponse, ListServersPagedResponse>
        listServersSettings;
    private final UnaryCallSettings.Builder<GetServerRequest, Server> getServerSettings;
    private final UnaryCallSettings.Builder<CreateServerRequest, Operation> createServerSettings;
    private final OperationCallSettings.Builder<CreateServerRequest, Server, OperationMetadata>
        createServerOperationSettings;
    private final UnaryCallSettings.Builder<UpdateServerRequest, Operation> updateServerSettings;
    private final OperationCallSettings.Builder<UpdateServerRequest, Server, OperationMetadata>
        updateServerOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServerRequest, Operation> deleteServerSettings;
    private final OperationCallSettings.Builder<DeleteServerRequest, Empty, OperationMetadata>
        deleteServerOperationSettings;
    private final PagedCallSettings.Builder<
            ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
        listUsersSettings;
    private final UnaryCallSettings.Builder<GetUserRequest, User> getUserSettings;
    private final UnaryCallSettings.Builder<CreateUserRequest, Operation> createUserSettings;
    private final OperationCallSettings.Builder<CreateUserRequest, User, OperationMetadata>
        createUserOperationSettings;
    private final UnaryCallSettings.Builder<UpdateUserRequest, Operation> updateUserSettings;
    private final OperationCallSettings.Builder<UpdateUserRequest, User, OperationMetadata>
        updateUserOperationSettings;
    private final UnaryCallSettings.Builder<DeleteUserRequest, Operation> deleteUserSettings;
    private final OperationCallSettings.Builder<DeleteUserRequest, Empty, OperationMetadata>
        deleteUserOperationSettings;
    private final UnaryCallSettings.Builder<StartServerRequest, Operation> startServerSettings;
    private final OperationCallSettings.Builder<StartServerRequest, Server, OperationMetadata>
        startServerOperationSettings;
    private final UnaryCallSettings.Builder<StopServerRequest, Operation> stopServerSettings;
    private final OperationCallSettings.Builder<StopServerRequest, Server, OperationMetadata>
        stopServerOperationSettings;
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

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      listServersSettings = PagedCallSettings.newBuilder(LIST_SERVERS_PAGE_STR_FACT);
      getServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServerOperationSettings = OperationCallSettings.newBuilder();
      updateServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateServerOperationSettings = OperationCallSettings.newBuilder();
      deleteServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServerOperationSettings = OperationCallSettings.newBuilder();
      listUsersSettings = PagedCallSettings.newBuilder(LIST_USERS_PAGE_STR_FACT);
      getUserSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUserSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createUserOperationSettings = OperationCallSettings.newBuilder();
      updateUserSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateUserOperationSettings = OperationCallSettings.newBuilder();
      deleteUserSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteUserOperationSettings = OperationCallSettings.newBuilder();
      startServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startServerOperationSettings = OperationCallSettings.newBuilder();
      stopServerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopServerOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServersSettings,
              getServerSettings,
              createServerSettings,
              updateServerSettings,
              deleteServerSettings,
              listUsersSettings,
              getUserSettings,
              createUserSettings,
              updateUserSettings,
              deleteUserSettings,
              startServerSettings,
              stopServerSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(CloudFtpStubSettings settings) {
      super(settings);

      listServersSettings = settings.listServersSettings.toBuilder();
      getServerSettings = settings.getServerSettings.toBuilder();
      createServerSettings = settings.createServerSettings.toBuilder();
      createServerOperationSettings = settings.createServerOperationSettings.toBuilder();
      updateServerSettings = settings.updateServerSettings.toBuilder();
      updateServerOperationSettings = settings.updateServerOperationSettings.toBuilder();
      deleteServerSettings = settings.deleteServerSettings.toBuilder();
      deleteServerOperationSettings = settings.deleteServerOperationSettings.toBuilder();
      listUsersSettings = settings.listUsersSettings.toBuilder();
      getUserSettings = settings.getUserSettings.toBuilder();
      createUserSettings = settings.createUserSettings.toBuilder();
      createUserOperationSettings = settings.createUserOperationSettings.toBuilder();
      updateUserSettings = settings.updateUserSettings.toBuilder();
      updateUserOperationSettings = settings.updateUserOperationSettings.toBuilder();
      deleteUserSettings = settings.deleteUserSettings.toBuilder();
      deleteUserOperationSettings = settings.deleteUserOperationSettings.toBuilder();
      startServerSettings = settings.startServerSettings.toBuilder();
      startServerOperationSettings = settings.startServerOperationSettings.toBuilder();
      stopServerSettings = settings.stopServerSettings.toBuilder();
      stopServerOperationSettings = settings.stopServerOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServersSettings,
              getServerSettings,
              createServerSettings,
              updateServerSettings,
              deleteServerSettings,
              listUsersSettings,
              getUserSettings,
              createUserSettings,
              updateUserSettings,
              deleteUserSettings,
              startServerSettings,
              stopServerSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .listServersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listUsersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getUserSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createUserSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateUserSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteUserSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .startServerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopServerSettings()
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
          .createServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Server.class))
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
          .updateServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Server.class))
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
          .deleteServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

      builder
          .createUserOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateUserRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(User.class))
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
          .updateUserOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateUserRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(User.class))
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
          .deleteUserOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteUserRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

      builder
          .startServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<StartServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Server.class))
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
          .stopServerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<StopServerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Server.class))
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

    /** Returns the builder for the settings used for calls to listServers. */
    public PagedCallSettings.Builder<
            ListServersRequest, ListServersResponse, ListServersPagedResponse>
        listServersSettings() {
      return listServersSettings;
    }

    /** Returns the builder for the settings used for calls to getServer. */
    public UnaryCallSettings.Builder<GetServerRequest, Server> getServerSettings() {
      return getServerSettings;
    }

    /** Returns the builder for the settings used for calls to createServer. */
    public UnaryCallSettings.Builder<CreateServerRequest, Operation> createServerSettings() {
      return createServerSettings;
    }

    /** Returns the builder for the settings used for calls to createServer. */
    public OperationCallSettings.Builder<CreateServerRequest, Server, OperationMetadata>
        createServerOperationSettings() {
      return createServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateServer. */
    public UnaryCallSettings.Builder<UpdateServerRequest, Operation> updateServerSettings() {
      return updateServerSettings;
    }

    /** Returns the builder for the settings used for calls to updateServer. */
    public OperationCallSettings.Builder<UpdateServerRequest, Server, OperationMetadata>
        updateServerOperationSettings() {
      return updateServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServer. */
    public UnaryCallSettings.Builder<DeleteServerRequest, Operation> deleteServerSettings() {
      return deleteServerSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServer. */
    public OperationCallSettings.Builder<DeleteServerRequest, Empty, OperationMetadata>
        deleteServerOperationSettings() {
      return deleteServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listUsers. */
    public PagedCallSettings.Builder<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
        listUsersSettings() {
      return listUsersSettings;
    }

    /** Returns the builder for the settings used for calls to getUser. */
    public UnaryCallSettings.Builder<GetUserRequest, User> getUserSettings() {
      return getUserSettings;
    }

    /** Returns the builder for the settings used for calls to createUser. */
    public UnaryCallSettings.Builder<CreateUserRequest, Operation> createUserSettings() {
      return createUserSettings;
    }

    /** Returns the builder for the settings used for calls to createUser. */
    public OperationCallSettings.Builder<CreateUserRequest, User, OperationMetadata>
        createUserOperationSettings() {
      return createUserOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateUser. */
    public UnaryCallSettings.Builder<UpdateUserRequest, Operation> updateUserSettings() {
      return updateUserSettings;
    }

    /** Returns the builder for the settings used for calls to updateUser. */
    public OperationCallSettings.Builder<UpdateUserRequest, User, OperationMetadata>
        updateUserOperationSettings() {
      return updateUserOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUser. */
    public UnaryCallSettings.Builder<DeleteUserRequest, Operation> deleteUserSettings() {
      return deleteUserSettings;
    }

    /** Returns the builder for the settings used for calls to deleteUser. */
    public OperationCallSettings.Builder<DeleteUserRequest, Empty, OperationMetadata>
        deleteUserOperationSettings() {
      return deleteUserOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startServer. */
    public UnaryCallSettings.Builder<StartServerRequest, Operation> startServerSettings() {
      return startServerSettings;
    }

    /** Returns the builder for the settings used for calls to startServer. */
    public OperationCallSettings.Builder<StartServerRequest, Server, OperationMetadata>
        startServerOperationSettings() {
      return startServerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopServer. */
    public UnaryCallSettings.Builder<StopServerRequest, Operation> stopServerSettings() {
      return stopServerSettings;
    }

    /** Returns the builder for the settings used for calls to stopServer. */
    public OperationCallSettings.Builder<StopServerRequest, Server, OperationMetadata>
        stopServerOperationSettings() {
      return stopServerOperationSettings;
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
    public CloudFtpStubSettings build() throws IOException {
      return new CloudFtpStubSettings(this);
    }
  }
}
