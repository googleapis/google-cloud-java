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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListFirewallEndpointsPagedResponse;
import static com.google.cloud.networksecurity.v1.FirewallActivationClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
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
import com.google.cloud.networksecurity.v1.stub.FirewallActivationStubSettings;
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
 * Settings class to configure an instance of {@link FirewallActivationClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networksecurity.googleapis.com) and default port (443) are
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
 * of getFirewallEndpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirewallActivationSettings.Builder firewallActivationSettingsBuilder =
 *     FirewallActivationSettings.newBuilder();
 * firewallActivationSettingsBuilder
 *     .getFirewallEndpointSettings()
 *     .setRetrySettings(
 *         firewallActivationSettingsBuilder
 *             .getFirewallEndpointSettings()
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
 * FirewallActivationSettings firewallActivationSettings =
 *     firewallActivationSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createFirewallEndpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirewallActivationSettings.Builder firewallActivationSettingsBuilder =
 *     FirewallActivationSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * firewallActivationSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FirewallActivationSettings extends ClientSettings<FirewallActivationSettings> {

  /** Returns the object with the settings used for calls to listFirewallEndpoints. */
  public PagedCallSettings<
          ListFirewallEndpointsRequest,
          ListFirewallEndpointsResponse,
          ListFirewallEndpointsPagedResponse>
      listFirewallEndpointsSettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).listFirewallEndpointsSettings();
  }

  /** Returns the object with the settings used for calls to getFirewallEndpoint. */
  public UnaryCallSettings<GetFirewallEndpointRequest, FirewallEndpoint>
      getFirewallEndpointSettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).getFirewallEndpointSettings();
  }

  /** Returns the object with the settings used for calls to createFirewallEndpoint. */
  public UnaryCallSettings<CreateFirewallEndpointRequest, Operation>
      createFirewallEndpointSettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).createFirewallEndpointSettings();
  }

  /** Returns the object with the settings used for calls to createFirewallEndpoint. */
  public OperationCallSettings<CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      createFirewallEndpointOperationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .createFirewallEndpointOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFirewallEndpoint. */
  public UnaryCallSettings<DeleteFirewallEndpointRequest, Operation>
      deleteFirewallEndpointSettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).deleteFirewallEndpointSettings();
  }

  /** Returns the object with the settings used for calls to deleteFirewallEndpoint. */
  public OperationCallSettings<DeleteFirewallEndpointRequest, Empty, OperationMetadata>
      deleteFirewallEndpointOperationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .deleteFirewallEndpointOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateFirewallEndpoint. */
  public UnaryCallSettings<UpdateFirewallEndpointRequest, Operation>
      updateFirewallEndpointSettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).updateFirewallEndpointSettings();
  }

  /** Returns the object with the settings used for calls to updateFirewallEndpoint. */
  public OperationCallSettings<UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
      updateFirewallEndpointOperationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .updateFirewallEndpointOperationSettings();
  }

  /** Returns the object with the settings used for calls to listFirewallEndpointAssociations. */
  public PagedCallSettings<
          ListFirewallEndpointAssociationsRequest,
          ListFirewallEndpointAssociationsResponse,
          ListFirewallEndpointAssociationsPagedResponse>
      listFirewallEndpointAssociationsSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .listFirewallEndpointAssociationsSettings();
  }

  /** Returns the object with the settings used for calls to getFirewallEndpointAssociation. */
  public UnaryCallSettings<GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
      getFirewallEndpointAssociationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .getFirewallEndpointAssociationSettings();
  }

  /** Returns the object with the settings used for calls to createFirewallEndpointAssociation. */
  public UnaryCallSettings<CreateFirewallEndpointAssociationRequest, Operation>
      createFirewallEndpointAssociationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .createFirewallEndpointAssociationSettings();
  }

  /** Returns the object with the settings used for calls to createFirewallEndpointAssociation. */
  public OperationCallSettings<
          CreateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      createFirewallEndpointAssociationOperationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .createFirewallEndpointAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFirewallEndpointAssociation. */
  public UnaryCallSettings<DeleteFirewallEndpointAssociationRequest, Operation>
      deleteFirewallEndpointAssociationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .deleteFirewallEndpointAssociationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFirewallEndpointAssociation. */
  public OperationCallSettings<DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
      deleteFirewallEndpointAssociationOperationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .deleteFirewallEndpointAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateFirewallEndpointAssociation. */
  public UnaryCallSettings<UpdateFirewallEndpointAssociationRequest, Operation>
      updateFirewallEndpointAssociationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .updateFirewallEndpointAssociationSettings();
  }

  /** Returns the object with the settings used for calls to updateFirewallEndpointAssociation. */
  public OperationCallSettings<
          UpdateFirewallEndpointAssociationRequest, FirewallEndpointAssociation, OperationMetadata>
      updateFirewallEndpointAssociationOperationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings())
        .updateFirewallEndpointAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((FirewallActivationStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final FirewallActivationSettings create(FirewallActivationStubSettings stub)
      throws IOException {
    return new FirewallActivationSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FirewallActivationStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FirewallActivationStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FirewallActivationStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FirewallActivationStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FirewallActivationStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FirewallActivationStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirewallActivationStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FirewallActivationSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FirewallActivationSettings. */
  public static class Builder extends ClientSettings.Builder<FirewallActivationSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FirewallActivationStubSettings.newBuilder(clientContext));
    }

    protected Builder(FirewallActivationSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FirewallActivationStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FirewallActivationStubSettings.newBuilder());
    }

    public FirewallActivationStubSettings.Builder getStubSettingsBuilder() {
      return ((FirewallActivationStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listFirewallEndpoints. */
    public PagedCallSettings.Builder<
            ListFirewallEndpointsRequest,
            ListFirewallEndpointsResponse,
            ListFirewallEndpointsPagedResponse>
        listFirewallEndpointsSettings() {
      return getStubSettingsBuilder().listFirewallEndpointsSettings();
    }

    /** Returns the builder for the settings used for calls to getFirewallEndpoint. */
    public UnaryCallSettings.Builder<GetFirewallEndpointRequest, FirewallEndpoint>
        getFirewallEndpointSettings() {
      return getStubSettingsBuilder().getFirewallEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to createFirewallEndpoint. */
    public UnaryCallSettings.Builder<CreateFirewallEndpointRequest, Operation>
        createFirewallEndpointSettings() {
      return getStubSettingsBuilder().createFirewallEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to createFirewallEndpoint. */
    public OperationCallSettings.Builder<
            CreateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
        createFirewallEndpointOperationSettings() {
      return getStubSettingsBuilder().createFirewallEndpointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFirewallEndpoint. */
    public UnaryCallSettings.Builder<DeleteFirewallEndpointRequest, Operation>
        deleteFirewallEndpointSettings() {
      return getStubSettingsBuilder().deleteFirewallEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFirewallEndpoint. */
    public OperationCallSettings.Builder<DeleteFirewallEndpointRequest, Empty, OperationMetadata>
        deleteFirewallEndpointOperationSettings() {
      return getStubSettingsBuilder().deleteFirewallEndpointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateFirewallEndpoint. */
    public UnaryCallSettings.Builder<UpdateFirewallEndpointRequest, Operation>
        updateFirewallEndpointSettings() {
      return getStubSettingsBuilder().updateFirewallEndpointSettings();
    }

    /** Returns the builder for the settings used for calls to updateFirewallEndpoint. */
    public OperationCallSettings.Builder<
            UpdateFirewallEndpointRequest, FirewallEndpoint, OperationMetadata>
        updateFirewallEndpointOperationSettings() {
      return getStubSettingsBuilder().updateFirewallEndpointOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listFirewallEndpointAssociations. */
    public PagedCallSettings.Builder<
            ListFirewallEndpointAssociationsRequest,
            ListFirewallEndpointAssociationsResponse,
            ListFirewallEndpointAssociationsPagedResponse>
        listFirewallEndpointAssociationsSettings() {
      return getStubSettingsBuilder().listFirewallEndpointAssociationsSettings();
    }

    /** Returns the builder for the settings used for calls to getFirewallEndpointAssociation. */
    public UnaryCallSettings.Builder<
            GetFirewallEndpointAssociationRequest, FirewallEndpointAssociation>
        getFirewallEndpointAssociationSettings() {
      return getStubSettingsBuilder().getFirewallEndpointAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to createFirewallEndpointAssociation. */
    public UnaryCallSettings.Builder<CreateFirewallEndpointAssociationRequest, Operation>
        createFirewallEndpointAssociationSettings() {
      return getStubSettingsBuilder().createFirewallEndpointAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to createFirewallEndpointAssociation. */
    public OperationCallSettings.Builder<
            CreateFirewallEndpointAssociationRequest,
            FirewallEndpointAssociation,
            OperationMetadata>
        createFirewallEndpointAssociationOperationSettings() {
      return getStubSettingsBuilder().createFirewallEndpointAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFirewallEndpointAssociation. */
    public UnaryCallSettings.Builder<DeleteFirewallEndpointAssociationRequest, Operation>
        deleteFirewallEndpointAssociationSettings() {
      return getStubSettingsBuilder().deleteFirewallEndpointAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFirewallEndpointAssociation. */
    public OperationCallSettings.Builder<
            DeleteFirewallEndpointAssociationRequest, Empty, OperationMetadata>
        deleteFirewallEndpointAssociationOperationSettings() {
      return getStubSettingsBuilder().deleteFirewallEndpointAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateFirewallEndpointAssociation. */
    public UnaryCallSettings.Builder<UpdateFirewallEndpointAssociationRequest, Operation>
        updateFirewallEndpointAssociationSettings() {
      return getStubSettingsBuilder().updateFirewallEndpointAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to updateFirewallEndpointAssociation. */
    public OperationCallSettings.Builder<
            UpdateFirewallEndpointAssociationRequest,
            FirewallEndpointAssociation,
            OperationMetadata>
        updateFirewallEndpointAssociationOperationSettings() {
      return getStubSettingsBuilder().updateFirewallEndpointAssociationOperationSettings();
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
    public FirewallActivationSettings build() throws IOException {
      return new FirewallActivationSettings(this);
    }
  }
}
