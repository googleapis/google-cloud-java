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

import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListInterceptEndpointGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.InterceptClient.ListLocationsPagedResponse;

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
import com.google.cloud.networksecurity.v1.stub.InterceptStubSettings;
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
 * Settings class to configure an instance of {@link InterceptClient}.
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
 * of getInterceptEndpointGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InterceptSettings.Builder interceptSettingsBuilder = InterceptSettings.newBuilder();
 * interceptSettingsBuilder
 *     .getInterceptEndpointGroupSettings()
 *     .setRetrySettings(
 *         interceptSettingsBuilder
 *             .getInterceptEndpointGroupSettings()
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
 * InterceptSettings interceptSettings = interceptSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInterceptEndpointGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InterceptSettings.Builder interceptSettingsBuilder = InterceptSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * interceptSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InterceptSettings extends ClientSettings<InterceptSettings> {

  /** Returns the object with the settings used for calls to listInterceptEndpointGroups. */
  public PagedCallSettings<
          ListInterceptEndpointGroupsRequest,
          ListInterceptEndpointGroupsResponse,
          ListInterceptEndpointGroupsPagedResponse>
      listInterceptEndpointGroupsSettings() {
    return ((InterceptStubSettings) getStubSettings()).listInterceptEndpointGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getInterceptEndpointGroup. */
  public UnaryCallSettings<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
      getInterceptEndpointGroupSettings() {
    return ((InterceptStubSettings) getStubSettings()).getInterceptEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to createInterceptEndpointGroup. */
  public UnaryCallSettings<CreateInterceptEndpointGroupRequest, Operation>
      createInterceptEndpointGroupSettings() {
    return ((InterceptStubSettings) getStubSettings()).createInterceptEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to createInterceptEndpointGroup. */
  public OperationCallSettings<
          CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      createInterceptEndpointGroupOperationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .createInterceptEndpointGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInterceptEndpointGroup. */
  public UnaryCallSettings<UpdateInterceptEndpointGroupRequest, Operation>
      updateInterceptEndpointGroupSettings() {
    return ((InterceptStubSettings) getStubSettings()).updateInterceptEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateInterceptEndpointGroup. */
  public OperationCallSettings<
          UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
      updateInterceptEndpointGroupOperationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .updateInterceptEndpointGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInterceptEndpointGroup. */
  public UnaryCallSettings<DeleteInterceptEndpointGroupRequest, Operation>
      deleteInterceptEndpointGroupSettings() {
    return ((InterceptStubSettings) getStubSettings()).deleteInterceptEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteInterceptEndpointGroup. */
  public OperationCallSettings<DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupOperationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .deleteInterceptEndpointGroupOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to listInterceptEndpointGroupAssociations.
   */
  public PagedCallSettings<
          ListInterceptEndpointGroupAssociationsRequest,
          ListInterceptEndpointGroupAssociationsResponse,
          ListInterceptEndpointGroupAssociationsPagedResponse>
      listInterceptEndpointGroupAssociationsSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .listInterceptEndpointGroupAssociationsSettings();
  }

  /**
   * Returns the object with the settings used for calls to getInterceptEndpointGroupAssociation.
   */
  public UnaryCallSettings<
          GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
      getInterceptEndpointGroupAssociationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .getInterceptEndpointGroupAssociationSettings();
  }

  /**
   * Returns the object with the settings used for calls to createInterceptEndpointGroupAssociation.
   */
  public UnaryCallSettings<CreateInterceptEndpointGroupAssociationRequest, Operation>
      createInterceptEndpointGroupAssociationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .createInterceptEndpointGroupAssociationSettings();
  }

  /**
   * Returns the object with the settings used for calls to createInterceptEndpointGroupAssociation.
   */
  public OperationCallSettings<
          CreateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      createInterceptEndpointGroupAssociationOperationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .createInterceptEndpointGroupAssociationOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateInterceptEndpointGroupAssociation.
   */
  public UnaryCallSettings<UpdateInterceptEndpointGroupAssociationRequest, Operation>
      updateInterceptEndpointGroupAssociationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .updateInterceptEndpointGroupAssociationSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateInterceptEndpointGroupAssociation.
   */
  public OperationCallSettings<
          UpdateInterceptEndpointGroupAssociationRequest,
          InterceptEndpointGroupAssociation,
          OperationMetadata>
      updateInterceptEndpointGroupAssociationOperationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .updateInterceptEndpointGroupAssociationOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteInterceptEndpointGroupAssociation.
   */
  public UnaryCallSettings<DeleteInterceptEndpointGroupAssociationRequest, Operation>
      deleteInterceptEndpointGroupAssociationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .deleteInterceptEndpointGroupAssociationSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteInterceptEndpointGroupAssociation.
   */
  public OperationCallSettings<
          DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteInterceptEndpointGroupAssociationOperationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .deleteInterceptEndpointGroupAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listInterceptDeploymentGroups. */
  public PagedCallSettings<
          ListInterceptDeploymentGroupsRequest,
          ListInterceptDeploymentGroupsResponse,
          ListInterceptDeploymentGroupsPagedResponse>
      listInterceptDeploymentGroupsSettings() {
    return ((InterceptStubSettings) getStubSettings()).listInterceptDeploymentGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getInterceptDeploymentGroup. */
  public UnaryCallSettings<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
      getInterceptDeploymentGroupSettings() {
    return ((InterceptStubSettings) getStubSettings()).getInterceptDeploymentGroupSettings();
  }

  /** Returns the object with the settings used for calls to createInterceptDeploymentGroup. */
  public UnaryCallSettings<CreateInterceptDeploymentGroupRequest, Operation>
      createInterceptDeploymentGroupSettings() {
    return ((InterceptStubSettings) getStubSettings()).createInterceptDeploymentGroupSettings();
  }

  /** Returns the object with the settings used for calls to createInterceptDeploymentGroup. */
  public OperationCallSettings<
          CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      createInterceptDeploymentGroupOperationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .createInterceptDeploymentGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInterceptDeploymentGroup. */
  public UnaryCallSettings<UpdateInterceptDeploymentGroupRequest, Operation>
      updateInterceptDeploymentGroupSettings() {
    return ((InterceptStubSettings) getStubSettings()).updateInterceptDeploymentGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateInterceptDeploymentGroup. */
  public OperationCallSettings<
          UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
      updateInterceptDeploymentGroupOperationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .updateInterceptDeploymentGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInterceptDeploymentGroup. */
  public UnaryCallSettings<DeleteInterceptDeploymentGroupRequest, Operation>
      deleteInterceptDeploymentGroupSettings() {
    return ((InterceptStubSettings) getStubSettings()).deleteInterceptDeploymentGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteInterceptDeploymentGroup. */
  public OperationCallSettings<DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentGroupOperationSettings() {
    return ((InterceptStubSettings) getStubSettings())
        .deleteInterceptDeploymentGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listInterceptDeployments. */
  public PagedCallSettings<
          ListInterceptDeploymentsRequest,
          ListInterceptDeploymentsResponse,
          ListInterceptDeploymentsPagedResponse>
      listInterceptDeploymentsSettings() {
    return ((InterceptStubSettings) getStubSettings()).listInterceptDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to getInterceptDeployment. */
  public UnaryCallSettings<GetInterceptDeploymentRequest, InterceptDeployment>
      getInterceptDeploymentSettings() {
    return ((InterceptStubSettings) getStubSettings()).getInterceptDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createInterceptDeployment. */
  public UnaryCallSettings<CreateInterceptDeploymentRequest, Operation>
      createInterceptDeploymentSettings() {
    return ((InterceptStubSettings) getStubSettings()).createInterceptDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createInterceptDeployment. */
  public OperationCallSettings<
          CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      createInterceptDeploymentOperationSettings() {
    return ((InterceptStubSettings) getStubSettings()).createInterceptDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInterceptDeployment. */
  public UnaryCallSettings<UpdateInterceptDeploymentRequest, Operation>
      updateInterceptDeploymentSettings() {
    return ((InterceptStubSettings) getStubSettings()).updateInterceptDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updateInterceptDeployment. */
  public OperationCallSettings<
          UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
      updateInterceptDeploymentOperationSettings() {
    return ((InterceptStubSettings) getStubSettings()).updateInterceptDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInterceptDeployment. */
  public UnaryCallSettings<DeleteInterceptDeploymentRequest, Operation>
      deleteInterceptDeploymentSettings() {
    return ((InterceptStubSettings) getStubSettings()).deleteInterceptDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deleteInterceptDeployment. */
  public OperationCallSettings<DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
      deleteInterceptDeploymentOperationSettings() {
    return ((InterceptStubSettings) getStubSettings()).deleteInterceptDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((InterceptStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((InterceptStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((InterceptStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((InterceptStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((InterceptStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final InterceptSettings create(InterceptStubSettings stub) throws IOException {
    return new InterceptSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InterceptStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InterceptStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InterceptStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InterceptStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InterceptStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InterceptStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InterceptStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InterceptSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InterceptSettings. */
  public static class Builder extends ClientSettings.Builder<InterceptSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(InterceptStubSettings.newBuilder(clientContext));
    }

    protected Builder(InterceptSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InterceptStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(InterceptStubSettings.newBuilder());
    }

    public InterceptStubSettings.Builder getStubSettingsBuilder() {
      return ((InterceptStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listInterceptEndpointGroups. */
    public PagedCallSettings.Builder<
            ListInterceptEndpointGroupsRequest,
            ListInterceptEndpointGroupsResponse,
            ListInterceptEndpointGroupsPagedResponse>
        listInterceptEndpointGroupsSettings() {
      return getStubSettingsBuilder().listInterceptEndpointGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getInterceptEndpointGroup. */
    public UnaryCallSettings.Builder<GetInterceptEndpointGroupRequest, InterceptEndpointGroup>
        getInterceptEndpointGroupSettings() {
      return getStubSettingsBuilder().getInterceptEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createInterceptEndpointGroup. */
    public UnaryCallSettings.Builder<CreateInterceptEndpointGroupRequest, Operation>
        createInterceptEndpointGroupSettings() {
      return getStubSettingsBuilder().createInterceptEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createInterceptEndpointGroup. */
    public OperationCallSettings.Builder<
            CreateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
        createInterceptEndpointGroupOperationSettings() {
      return getStubSettingsBuilder().createInterceptEndpointGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInterceptEndpointGroup. */
    public UnaryCallSettings.Builder<UpdateInterceptEndpointGroupRequest, Operation>
        updateInterceptEndpointGroupSettings() {
      return getStubSettingsBuilder().updateInterceptEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateInterceptEndpointGroup. */
    public OperationCallSettings.Builder<
            UpdateInterceptEndpointGroupRequest, InterceptEndpointGroup, OperationMetadata>
        updateInterceptEndpointGroupOperationSettings() {
      return getStubSettingsBuilder().updateInterceptEndpointGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInterceptEndpointGroup. */
    public UnaryCallSettings.Builder<DeleteInterceptEndpointGroupRequest, Operation>
        deleteInterceptEndpointGroupSettings() {
      return getStubSettingsBuilder().deleteInterceptEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInterceptEndpointGroup. */
    public OperationCallSettings.Builder<
            DeleteInterceptEndpointGroupRequest, Empty, OperationMetadata>
        deleteInterceptEndpointGroupOperationSettings() {
      return getStubSettingsBuilder().deleteInterceptEndpointGroupOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listInterceptEndpointGroupAssociations.
     */
    public PagedCallSettings.Builder<
            ListInterceptEndpointGroupAssociationsRequest,
            ListInterceptEndpointGroupAssociationsResponse,
            ListInterceptEndpointGroupAssociationsPagedResponse>
        listInterceptEndpointGroupAssociationsSettings() {
      return getStubSettingsBuilder().listInterceptEndpointGroupAssociationsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getInterceptEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<
            GetInterceptEndpointGroupAssociationRequest, InterceptEndpointGroupAssociation>
        getInterceptEndpointGroupAssociationSettings() {
      return getStubSettingsBuilder().getInterceptEndpointGroupAssociationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * createInterceptEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<CreateInterceptEndpointGroupAssociationRequest, Operation>
        createInterceptEndpointGroupAssociationSettings() {
      return getStubSettingsBuilder().createInterceptEndpointGroupAssociationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * createInterceptEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            CreateInterceptEndpointGroupAssociationRequest,
            InterceptEndpointGroupAssociation,
            OperationMetadata>
        createInterceptEndpointGroupAssociationOperationSettings() {
      return getStubSettingsBuilder().createInterceptEndpointGroupAssociationOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateInterceptEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<UpdateInterceptEndpointGroupAssociationRequest, Operation>
        updateInterceptEndpointGroupAssociationSettings() {
      return getStubSettingsBuilder().updateInterceptEndpointGroupAssociationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateInterceptEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            UpdateInterceptEndpointGroupAssociationRequest,
            InterceptEndpointGroupAssociation,
            OperationMetadata>
        updateInterceptEndpointGroupAssociationOperationSettings() {
      return getStubSettingsBuilder().updateInterceptEndpointGroupAssociationOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteInterceptEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<DeleteInterceptEndpointGroupAssociationRequest, Operation>
        deleteInterceptEndpointGroupAssociationSettings() {
      return getStubSettingsBuilder().deleteInterceptEndpointGroupAssociationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteInterceptEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            DeleteInterceptEndpointGroupAssociationRequest, Empty, OperationMetadata>
        deleteInterceptEndpointGroupAssociationOperationSettings() {
      return getStubSettingsBuilder().deleteInterceptEndpointGroupAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listInterceptDeploymentGroups. */
    public PagedCallSettings.Builder<
            ListInterceptDeploymentGroupsRequest,
            ListInterceptDeploymentGroupsResponse,
            ListInterceptDeploymentGroupsPagedResponse>
        listInterceptDeploymentGroupsSettings() {
      return getStubSettingsBuilder().listInterceptDeploymentGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getInterceptDeploymentGroup. */
    public UnaryCallSettings.Builder<GetInterceptDeploymentGroupRequest, InterceptDeploymentGroup>
        getInterceptDeploymentGroupSettings() {
      return getStubSettingsBuilder().getInterceptDeploymentGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createInterceptDeploymentGroup. */
    public UnaryCallSettings.Builder<CreateInterceptDeploymentGroupRequest, Operation>
        createInterceptDeploymentGroupSettings() {
      return getStubSettingsBuilder().createInterceptDeploymentGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createInterceptDeploymentGroup. */
    public OperationCallSettings.Builder<
            CreateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
        createInterceptDeploymentGroupOperationSettings() {
      return getStubSettingsBuilder().createInterceptDeploymentGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInterceptDeploymentGroup. */
    public UnaryCallSettings.Builder<UpdateInterceptDeploymentGroupRequest, Operation>
        updateInterceptDeploymentGroupSettings() {
      return getStubSettingsBuilder().updateInterceptDeploymentGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateInterceptDeploymentGroup. */
    public OperationCallSettings.Builder<
            UpdateInterceptDeploymentGroupRequest, InterceptDeploymentGroup, OperationMetadata>
        updateInterceptDeploymentGroupOperationSettings() {
      return getStubSettingsBuilder().updateInterceptDeploymentGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInterceptDeploymentGroup. */
    public UnaryCallSettings.Builder<DeleteInterceptDeploymentGroupRequest, Operation>
        deleteInterceptDeploymentGroupSettings() {
      return getStubSettingsBuilder().deleteInterceptDeploymentGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInterceptDeploymentGroup. */
    public OperationCallSettings.Builder<
            DeleteInterceptDeploymentGroupRequest, Empty, OperationMetadata>
        deleteInterceptDeploymentGroupOperationSettings() {
      return getStubSettingsBuilder().deleteInterceptDeploymentGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listInterceptDeployments. */
    public PagedCallSettings.Builder<
            ListInterceptDeploymentsRequest,
            ListInterceptDeploymentsResponse,
            ListInterceptDeploymentsPagedResponse>
        listInterceptDeploymentsSettings() {
      return getStubSettingsBuilder().listInterceptDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to getInterceptDeployment. */
    public UnaryCallSettings.Builder<GetInterceptDeploymentRequest, InterceptDeployment>
        getInterceptDeploymentSettings() {
      return getStubSettingsBuilder().getInterceptDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createInterceptDeployment. */
    public UnaryCallSettings.Builder<CreateInterceptDeploymentRequest, Operation>
        createInterceptDeploymentSettings() {
      return getStubSettingsBuilder().createInterceptDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createInterceptDeployment. */
    public OperationCallSettings.Builder<
            CreateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
        createInterceptDeploymentOperationSettings() {
      return getStubSettingsBuilder().createInterceptDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInterceptDeployment. */
    public UnaryCallSettings.Builder<UpdateInterceptDeploymentRequest, Operation>
        updateInterceptDeploymentSettings() {
      return getStubSettingsBuilder().updateInterceptDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updateInterceptDeployment. */
    public OperationCallSettings.Builder<
            UpdateInterceptDeploymentRequest, InterceptDeployment, OperationMetadata>
        updateInterceptDeploymentOperationSettings() {
      return getStubSettingsBuilder().updateInterceptDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInterceptDeployment. */
    public UnaryCallSettings.Builder<DeleteInterceptDeploymentRequest, Operation>
        deleteInterceptDeploymentSettings() {
      return getStubSettingsBuilder().deleteInterceptDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInterceptDeployment. */
    public OperationCallSettings.Builder<DeleteInterceptDeploymentRequest, Empty, OperationMetadata>
        deleteInterceptDeploymentOperationSettings() {
      return getStubSettingsBuilder().deleteInterceptDeploymentOperationSettings();
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
    public InterceptSettings build() throws IOException {
      return new InterceptSettings(this);
    }
  }
}
