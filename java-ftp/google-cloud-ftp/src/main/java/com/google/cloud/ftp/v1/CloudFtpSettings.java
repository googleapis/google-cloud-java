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

package com.google.cloud.ftp.v1;

import static com.google.cloud.ftp.v1.CloudFtpClient.ListLocationsPagedResponse;
import static com.google.cloud.ftp.v1.CloudFtpClient.ListServersPagedResponse;
import static com.google.cloud.ftp.v1.CloudFtpClient.ListUsersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.ftp.v1.stub.CloudFtpStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudFtpClient}.
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
 * CloudFtpSettings.Builder cloudFtpSettingsBuilder = CloudFtpSettings.newBuilder();
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
 * CloudFtpSettings cloudFtpSettings = cloudFtpSettingsBuilder.build();
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
 * CloudFtpSettings.Builder cloudFtpSettingsBuilder = CloudFtpSettings.newBuilder();
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
public class CloudFtpSettings extends ClientSettings<CloudFtpSettings> {

  /** Returns the object with the settings used for calls to listServers. */
  public PagedCallSettings<ListServersRequest, ListServersResponse, ListServersPagedResponse>
      listServersSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).listServersSettings();
  }

  /** Returns the object with the settings used for calls to getServer. */
  public UnaryCallSettings<GetServerRequest, Server> getServerSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).getServerSettings();
  }

  /** Returns the object with the settings used for calls to createServer. */
  public UnaryCallSettings<CreateServerRequest, Operation> createServerSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).createServerSettings();
  }

  /** Returns the object with the settings used for calls to createServer. */
  public OperationCallSettings<CreateServerRequest, Server, OperationMetadata>
      createServerOperationSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).createServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateServer. */
  public UnaryCallSettings<UpdateServerRequest, Operation> updateServerSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).updateServerSettings();
  }

  /** Returns the object with the settings used for calls to updateServer. */
  public OperationCallSettings<UpdateServerRequest, Server, OperationMetadata>
      updateServerOperationSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).updateServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteServer. */
  public UnaryCallSettings<DeleteServerRequest, Operation> deleteServerSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).deleteServerSettings();
  }

  /** Returns the object with the settings used for calls to deleteServer. */
  public OperationCallSettings<DeleteServerRequest, Empty, OperationMetadata>
      deleteServerOperationSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).deleteServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to listUsers. */
  public PagedCallSettings<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
      listUsersSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).listUsersSettings();
  }

  /** Returns the object with the settings used for calls to getUser. */
  public UnaryCallSettings<GetUserRequest, User> getUserSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).getUserSettings();
  }

  /** Returns the object with the settings used for calls to createUser. */
  public UnaryCallSettings<CreateUserRequest, Operation> createUserSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).createUserSettings();
  }

  /** Returns the object with the settings used for calls to createUser. */
  public OperationCallSettings<CreateUserRequest, User, OperationMetadata>
      createUserOperationSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).createUserOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateUser. */
  public UnaryCallSettings<UpdateUserRequest, Operation> updateUserSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).updateUserSettings();
  }

  /** Returns the object with the settings used for calls to updateUser. */
  public OperationCallSettings<UpdateUserRequest, User, OperationMetadata>
      updateUserOperationSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).updateUserOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteUser. */
  public UnaryCallSettings<DeleteUserRequest, Operation> deleteUserSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).deleteUserSettings();
  }

  /** Returns the object with the settings used for calls to deleteUser. */
  public OperationCallSettings<DeleteUserRequest, Empty, OperationMetadata>
      deleteUserOperationSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).deleteUserOperationSettings();
  }

  /** Returns the object with the settings used for calls to startServer. */
  public UnaryCallSettings<StartServerRequest, Operation> startServerSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).startServerSettings();
  }

  /** Returns the object with the settings used for calls to startServer. */
  public OperationCallSettings<StartServerRequest, Server, OperationMetadata>
      startServerOperationSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).startServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to stopServer. */
  public UnaryCallSettings<StopServerRequest, Operation> stopServerSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).stopServerSettings();
  }

  /** Returns the object with the settings used for calls to stopServer. */
  public OperationCallSettings<StopServerRequest, Server, OperationMetadata>
      stopServerOperationSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).stopServerOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((CloudFtpStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final CloudFtpSettings create(CloudFtpStubSettings stub) throws IOException {
    return new CloudFtpSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudFtpStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudFtpStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudFtpStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudFtpStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudFtpStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudFtpStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudFtpStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudFtpSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudFtpSettings. */
  public static class Builder extends ClientSettings.Builder<CloudFtpSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(CloudFtpStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudFtpSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudFtpStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudFtpStubSettings.newBuilder());
    }

    public CloudFtpStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudFtpStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listServers. */
    public PagedCallSettings.Builder<
            ListServersRequest, ListServersResponse, ListServersPagedResponse>
        listServersSettings() {
      return getStubSettingsBuilder().listServersSettings();
    }

    /** Returns the builder for the settings used for calls to getServer. */
    public UnaryCallSettings.Builder<GetServerRequest, Server> getServerSettings() {
      return getStubSettingsBuilder().getServerSettings();
    }

    /** Returns the builder for the settings used for calls to createServer. */
    public UnaryCallSettings.Builder<CreateServerRequest, Operation> createServerSettings() {
      return getStubSettingsBuilder().createServerSettings();
    }

    /** Returns the builder for the settings used for calls to createServer. */
    public OperationCallSettings.Builder<CreateServerRequest, Server, OperationMetadata>
        createServerOperationSettings() {
      return getStubSettingsBuilder().createServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateServer. */
    public UnaryCallSettings.Builder<UpdateServerRequest, Operation> updateServerSettings() {
      return getStubSettingsBuilder().updateServerSettings();
    }

    /** Returns the builder for the settings used for calls to updateServer. */
    public OperationCallSettings.Builder<UpdateServerRequest, Server, OperationMetadata>
        updateServerOperationSettings() {
      return getStubSettingsBuilder().updateServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServer. */
    public UnaryCallSettings.Builder<DeleteServerRequest, Operation> deleteServerSettings() {
      return getStubSettingsBuilder().deleteServerSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServer. */
    public OperationCallSettings.Builder<DeleteServerRequest, Empty, OperationMetadata>
        deleteServerOperationSettings() {
      return getStubSettingsBuilder().deleteServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listUsers. */
    public PagedCallSettings.Builder<ListUsersRequest, ListUsersResponse, ListUsersPagedResponse>
        listUsersSettings() {
      return getStubSettingsBuilder().listUsersSettings();
    }

    /** Returns the builder for the settings used for calls to getUser. */
    public UnaryCallSettings.Builder<GetUserRequest, User> getUserSettings() {
      return getStubSettingsBuilder().getUserSettings();
    }

    /** Returns the builder for the settings used for calls to createUser. */
    public UnaryCallSettings.Builder<CreateUserRequest, Operation> createUserSettings() {
      return getStubSettingsBuilder().createUserSettings();
    }

    /** Returns the builder for the settings used for calls to createUser. */
    public OperationCallSettings.Builder<CreateUserRequest, User, OperationMetadata>
        createUserOperationSettings() {
      return getStubSettingsBuilder().createUserOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateUser. */
    public UnaryCallSettings.Builder<UpdateUserRequest, Operation> updateUserSettings() {
      return getStubSettingsBuilder().updateUserSettings();
    }

    /** Returns the builder for the settings used for calls to updateUser. */
    public OperationCallSettings.Builder<UpdateUserRequest, User, OperationMetadata>
        updateUserOperationSettings() {
      return getStubSettingsBuilder().updateUserOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUser. */
    public UnaryCallSettings.Builder<DeleteUserRequest, Operation> deleteUserSettings() {
      return getStubSettingsBuilder().deleteUserSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUser. */
    public OperationCallSettings.Builder<DeleteUserRequest, Empty, OperationMetadata>
        deleteUserOperationSettings() {
      return getStubSettingsBuilder().deleteUserOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startServer. */
    public UnaryCallSettings.Builder<StartServerRequest, Operation> startServerSettings() {
      return getStubSettingsBuilder().startServerSettings();
    }

    /** Returns the builder for the settings used for calls to startServer. */
    public OperationCallSettings.Builder<StartServerRequest, Server, OperationMetadata>
        startServerOperationSettings() {
      return getStubSettingsBuilder().startServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stopServer. */
    public UnaryCallSettings.Builder<StopServerRequest, Operation> stopServerSettings() {
      return getStubSettingsBuilder().stopServerSettings();
    }

    /** Returns the builder for the settings used for calls to stopServer. */
    public OperationCallSettings.Builder<StopServerRequest, Server, OperationMetadata>
        stopServerOperationSettings() {
      return getStubSettingsBuilder().stopServerOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public CloudFtpSettings build() throws IOException {
      return new CloudFtpSettings(this);
    }
  }
}
