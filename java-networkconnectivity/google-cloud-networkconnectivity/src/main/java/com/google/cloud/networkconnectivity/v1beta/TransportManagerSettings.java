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

package com.google.cloud.networkconnectivity.v1beta;

import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListRemoteTransportProfilesPagedResponse;
import static com.google.cloud.networkconnectivity.v1beta.TransportManagerClient.ListTransportsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1beta.stub.TransportManagerStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TransportManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkconnectivity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getRemoteTransportProfile:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TransportManagerSettings.Builder transportManagerSettingsBuilder =
 *     TransportManagerSettings.newBuilder();
 * transportManagerSettingsBuilder
 *     .getRemoteTransportProfileSettings()
 *     .setRetrySettings(
 *         transportManagerSettingsBuilder
 *             .getRemoteTransportProfileSettings()
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
 * TransportManagerSettings transportManagerSettings = transportManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createTransport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TransportManagerSettings.Builder transportManagerSettingsBuilder =
 *     TransportManagerSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * transportManagerSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TransportManagerSettings extends ClientSettings<TransportManagerSettings> {

  /** Returns the object with the settings used for calls to listRemoteTransportProfiles. */
  public PagedCallSettings<
          ListRemoteTransportProfilesRequest,
          ListRemoteTransportProfilesResponse,
          ListRemoteTransportProfilesPagedResponse>
      listRemoteTransportProfilesSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).listRemoteTransportProfilesSettings();
  }

  /** Returns the object with the settings used for calls to getRemoteTransportProfile. */
  public UnaryCallSettings<GetRemoteTransportProfileRequest, RemoteTransportProfile>
      getRemoteTransportProfileSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).getRemoteTransportProfileSettings();
  }

  /** Returns the object with the settings used for calls to listTransports. */
  public PagedCallSettings<
          ListTransportsRequest, ListTransportsResponse, ListTransportsPagedResponse>
      listTransportsSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).listTransportsSettings();
  }

  /** Returns the object with the settings used for calls to getTransport. */
  public UnaryCallSettings<GetTransportRequest, Transport> getTransportSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).getTransportSettings();
  }

  /** Returns the object with the settings used for calls to getStatus. */
  public UnaryCallSettings<GetStatusRequest, GetStatusResponse> getStatusSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).getStatusSettings();
  }

  /** Returns the object with the settings used for calls to createTransport. */
  public UnaryCallSettings<CreateTransportRequest, Operation> createTransportSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).createTransportSettings();
  }

  /** Returns the object with the settings used for calls to createTransport. */
  public OperationCallSettings<CreateTransportRequest, Transport, OperationMetadata>
      createTransportOperationSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).createTransportOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTransport. */
  public UnaryCallSettings<UpdateTransportRequest, Operation> updateTransportSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).updateTransportSettings();
  }

  /** Returns the object with the settings used for calls to updateTransport. */
  public OperationCallSettings<UpdateTransportRequest, Transport, OperationMetadata>
      updateTransportOperationSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).updateTransportOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTransport. */
  public UnaryCallSettings<DeleteTransportRequest, Operation> deleteTransportSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).deleteTransportSettings();
  }

  /** Returns the object with the settings used for calls to deleteTransport. */
  public OperationCallSettings<DeleteTransportRequest, Empty, OperationMetadata>
      deleteTransportOperationSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).deleteTransportOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((TransportManagerStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((TransportManagerStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((TransportManagerStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final TransportManagerSettings create(TransportManagerStubSettings stub)
      throws IOException {
    return new TransportManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TransportManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TransportManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TransportManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TransportManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TransportManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TransportManagerStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TransportManagerStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected TransportManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TransportManagerSettings. */
  public static class Builder extends ClientSettings.Builder<TransportManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TransportManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(TransportManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TransportManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TransportManagerStubSettings.newBuilder());
    }

    public TransportManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((TransportManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listRemoteTransportProfiles. */
    public PagedCallSettings.Builder<
            ListRemoteTransportProfilesRequest,
            ListRemoteTransportProfilesResponse,
            ListRemoteTransportProfilesPagedResponse>
        listRemoteTransportProfilesSettings() {
      return getStubSettingsBuilder().listRemoteTransportProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to getRemoteTransportProfile. */
    public UnaryCallSettings.Builder<GetRemoteTransportProfileRequest, RemoteTransportProfile>
        getRemoteTransportProfileSettings() {
      return getStubSettingsBuilder().getRemoteTransportProfileSettings();
    }

    /** Returns the builder for the settings used for calls to listTransports. */
    public PagedCallSettings.Builder<
            ListTransportsRequest, ListTransportsResponse, ListTransportsPagedResponse>
        listTransportsSettings() {
      return getStubSettingsBuilder().listTransportsSettings();
    }

    /** Returns the builder for the settings used for calls to getTransport. */
    public UnaryCallSettings.Builder<GetTransportRequest, Transport> getTransportSettings() {
      return getStubSettingsBuilder().getTransportSettings();
    }

    /** Returns the builder for the settings used for calls to getStatus. */
    public UnaryCallSettings.Builder<GetStatusRequest, GetStatusResponse> getStatusSettings() {
      return getStubSettingsBuilder().getStatusSettings();
    }

    /** Returns the builder for the settings used for calls to createTransport. */
    public UnaryCallSettings.Builder<CreateTransportRequest, Operation> createTransportSettings() {
      return getStubSettingsBuilder().createTransportSettings();
    }

    /** Returns the builder for the settings used for calls to createTransport. */
    public OperationCallSettings.Builder<CreateTransportRequest, Transport, OperationMetadata>
        createTransportOperationSettings() {
      return getStubSettingsBuilder().createTransportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTransport. */
    public UnaryCallSettings.Builder<UpdateTransportRequest, Operation> updateTransportSettings() {
      return getStubSettingsBuilder().updateTransportSettings();
    }

    /** Returns the builder for the settings used for calls to updateTransport. */
    public OperationCallSettings.Builder<UpdateTransportRequest, Transport, OperationMetadata>
        updateTransportOperationSettings() {
      return getStubSettingsBuilder().updateTransportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTransport. */
    public UnaryCallSettings.Builder<DeleteTransportRequest, Operation> deleteTransportSettings() {
      return getStubSettingsBuilder().deleteTransportSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTransport. */
    public OperationCallSettings.Builder<DeleteTransportRequest, Empty, OperationMetadata>
        deleteTransportOperationSettings() {
      return getStubSettingsBuilder().deleteTransportOperationSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public TransportManagerSettings build() throws IOException {
      return new TransportManagerSettings(this);
    }
  }
}
