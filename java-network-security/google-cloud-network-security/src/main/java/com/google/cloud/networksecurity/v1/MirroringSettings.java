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

import static com.google.cloud.networksecurity.v1.MirroringClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringDeploymentsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupAssociationsPagedResponse;
import static com.google.cloud.networksecurity.v1.MirroringClient.ListMirroringEndpointGroupsPagedResponse;

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
import com.google.cloud.networksecurity.v1.stub.MirroringStubSettings;
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
 * Settings class to configure an instance of {@link MirroringClient}.
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
 * of getMirroringEndpointGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MirroringSettings.Builder mirroringSettingsBuilder = MirroringSettings.newBuilder();
 * mirroringSettingsBuilder
 *     .getMirroringEndpointGroupSettings()
 *     .setRetrySettings(
 *         mirroringSettingsBuilder
 *             .getMirroringEndpointGroupSettings()
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
 * MirroringSettings mirroringSettings = mirroringSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createMirroringEndpointGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MirroringSettings.Builder mirroringSettingsBuilder = MirroringSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * mirroringSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class MirroringSettings extends ClientSettings<MirroringSettings> {

  /** Returns the object with the settings used for calls to listMirroringEndpointGroups. */
  public PagedCallSettings<
          ListMirroringEndpointGroupsRequest,
          ListMirroringEndpointGroupsResponse,
          ListMirroringEndpointGroupsPagedResponse>
      listMirroringEndpointGroupsSettings() {
    return ((MirroringStubSettings) getStubSettings()).listMirroringEndpointGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getMirroringEndpointGroup. */
  public UnaryCallSettings<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
      getMirroringEndpointGroupSettings() {
    return ((MirroringStubSettings) getStubSettings()).getMirroringEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to createMirroringEndpointGroup. */
  public UnaryCallSettings<CreateMirroringEndpointGroupRequest, Operation>
      createMirroringEndpointGroupSettings() {
    return ((MirroringStubSettings) getStubSettings()).createMirroringEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to createMirroringEndpointGroup. */
  public OperationCallSettings<
          CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      createMirroringEndpointGroupOperationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .createMirroringEndpointGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMirroringEndpointGroup. */
  public UnaryCallSettings<UpdateMirroringEndpointGroupRequest, Operation>
      updateMirroringEndpointGroupSettings() {
    return ((MirroringStubSettings) getStubSettings()).updateMirroringEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateMirroringEndpointGroup. */
  public OperationCallSettings<
          UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
      updateMirroringEndpointGroupOperationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .updateMirroringEndpointGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMirroringEndpointGroup. */
  public UnaryCallSettings<DeleteMirroringEndpointGroupRequest, Operation>
      deleteMirroringEndpointGroupSettings() {
    return ((MirroringStubSettings) getStubSettings()).deleteMirroringEndpointGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteMirroringEndpointGroup. */
  public OperationCallSettings<DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupOperationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .deleteMirroringEndpointGroupOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to listMirroringEndpointGroupAssociations.
   */
  public PagedCallSettings<
          ListMirroringEndpointGroupAssociationsRequest,
          ListMirroringEndpointGroupAssociationsResponse,
          ListMirroringEndpointGroupAssociationsPagedResponse>
      listMirroringEndpointGroupAssociationsSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .listMirroringEndpointGroupAssociationsSettings();
  }

  /**
   * Returns the object with the settings used for calls to getMirroringEndpointGroupAssociation.
   */
  public UnaryCallSettings<
          GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
      getMirroringEndpointGroupAssociationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .getMirroringEndpointGroupAssociationSettings();
  }

  /**
   * Returns the object with the settings used for calls to createMirroringEndpointGroupAssociation.
   */
  public UnaryCallSettings<CreateMirroringEndpointGroupAssociationRequest, Operation>
      createMirroringEndpointGroupAssociationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .createMirroringEndpointGroupAssociationSettings();
  }

  /**
   * Returns the object with the settings used for calls to createMirroringEndpointGroupAssociation.
   */
  public OperationCallSettings<
          CreateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      createMirroringEndpointGroupAssociationOperationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .createMirroringEndpointGroupAssociationOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateMirroringEndpointGroupAssociation.
   */
  public UnaryCallSettings<UpdateMirroringEndpointGroupAssociationRequest, Operation>
      updateMirroringEndpointGroupAssociationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .updateMirroringEndpointGroupAssociationSettings();
  }

  /**
   * Returns the object with the settings used for calls to updateMirroringEndpointGroupAssociation.
   */
  public OperationCallSettings<
          UpdateMirroringEndpointGroupAssociationRequest,
          MirroringEndpointGroupAssociation,
          OperationMetadata>
      updateMirroringEndpointGroupAssociationOperationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .updateMirroringEndpointGroupAssociationOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteMirroringEndpointGroupAssociation.
   */
  public UnaryCallSettings<DeleteMirroringEndpointGroupAssociationRequest, Operation>
      deleteMirroringEndpointGroupAssociationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .deleteMirroringEndpointGroupAssociationSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteMirroringEndpointGroupAssociation.
   */
  public OperationCallSettings<
          DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
      deleteMirroringEndpointGroupAssociationOperationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .deleteMirroringEndpointGroupAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listMirroringDeploymentGroups. */
  public PagedCallSettings<
          ListMirroringDeploymentGroupsRequest,
          ListMirroringDeploymentGroupsResponse,
          ListMirroringDeploymentGroupsPagedResponse>
      listMirroringDeploymentGroupsSettings() {
    return ((MirroringStubSettings) getStubSettings()).listMirroringDeploymentGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getMirroringDeploymentGroup. */
  public UnaryCallSettings<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
      getMirroringDeploymentGroupSettings() {
    return ((MirroringStubSettings) getStubSettings()).getMirroringDeploymentGroupSettings();
  }

  /** Returns the object with the settings used for calls to createMirroringDeploymentGroup. */
  public UnaryCallSettings<CreateMirroringDeploymentGroupRequest, Operation>
      createMirroringDeploymentGroupSettings() {
    return ((MirroringStubSettings) getStubSettings()).createMirroringDeploymentGroupSettings();
  }

  /** Returns the object with the settings used for calls to createMirroringDeploymentGroup. */
  public OperationCallSettings<
          CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      createMirroringDeploymentGroupOperationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .createMirroringDeploymentGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMirroringDeploymentGroup. */
  public UnaryCallSettings<UpdateMirroringDeploymentGroupRequest, Operation>
      updateMirroringDeploymentGroupSettings() {
    return ((MirroringStubSettings) getStubSettings()).updateMirroringDeploymentGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateMirroringDeploymentGroup. */
  public OperationCallSettings<
          UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
      updateMirroringDeploymentGroupOperationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .updateMirroringDeploymentGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMirroringDeploymentGroup. */
  public UnaryCallSettings<DeleteMirroringDeploymentGroupRequest, Operation>
      deleteMirroringDeploymentGroupSettings() {
    return ((MirroringStubSettings) getStubSettings()).deleteMirroringDeploymentGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteMirroringDeploymentGroup. */
  public OperationCallSettings<DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentGroupOperationSettings() {
    return ((MirroringStubSettings) getStubSettings())
        .deleteMirroringDeploymentGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listMirroringDeployments. */
  public PagedCallSettings<
          ListMirroringDeploymentsRequest,
          ListMirroringDeploymentsResponse,
          ListMirroringDeploymentsPagedResponse>
      listMirroringDeploymentsSettings() {
    return ((MirroringStubSettings) getStubSettings()).listMirroringDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to getMirroringDeployment. */
  public UnaryCallSettings<GetMirroringDeploymentRequest, MirroringDeployment>
      getMirroringDeploymentSettings() {
    return ((MirroringStubSettings) getStubSettings()).getMirroringDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createMirroringDeployment. */
  public UnaryCallSettings<CreateMirroringDeploymentRequest, Operation>
      createMirroringDeploymentSettings() {
    return ((MirroringStubSettings) getStubSettings()).createMirroringDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createMirroringDeployment. */
  public OperationCallSettings<
          CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      createMirroringDeploymentOperationSettings() {
    return ((MirroringStubSettings) getStubSettings()).createMirroringDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMirroringDeployment. */
  public UnaryCallSettings<UpdateMirroringDeploymentRequest, Operation>
      updateMirroringDeploymentSettings() {
    return ((MirroringStubSettings) getStubSettings()).updateMirroringDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updateMirroringDeployment. */
  public OperationCallSettings<
          UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
      updateMirroringDeploymentOperationSettings() {
    return ((MirroringStubSettings) getStubSettings()).updateMirroringDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMirroringDeployment. */
  public UnaryCallSettings<DeleteMirroringDeploymentRequest, Operation>
      deleteMirroringDeploymentSettings() {
    return ((MirroringStubSettings) getStubSettings()).deleteMirroringDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deleteMirroringDeployment. */
  public OperationCallSettings<DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
      deleteMirroringDeploymentOperationSettings() {
    return ((MirroringStubSettings) getStubSettings()).deleteMirroringDeploymentOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((MirroringStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((MirroringStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((MirroringStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((MirroringStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((MirroringStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final MirroringSettings create(MirroringStubSettings stub) throws IOException {
    return new MirroringSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MirroringStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MirroringStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MirroringStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MirroringStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MirroringStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MirroringStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MirroringStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MirroringSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MirroringSettings. */
  public static class Builder extends ClientSettings.Builder<MirroringSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MirroringStubSettings.newBuilder(clientContext));
    }

    protected Builder(MirroringSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MirroringStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MirroringStubSettings.newBuilder());
    }

    public MirroringStubSettings.Builder getStubSettingsBuilder() {
      return ((MirroringStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listMirroringEndpointGroups. */
    public PagedCallSettings.Builder<
            ListMirroringEndpointGroupsRequest,
            ListMirroringEndpointGroupsResponse,
            ListMirroringEndpointGroupsPagedResponse>
        listMirroringEndpointGroupsSettings() {
      return getStubSettingsBuilder().listMirroringEndpointGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getMirroringEndpointGroup. */
    public UnaryCallSettings.Builder<GetMirroringEndpointGroupRequest, MirroringEndpointGroup>
        getMirroringEndpointGroupSettings() {
      return getStubSettingsBuilder().getMirroringEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createMirroringEndpointGroup. */
    public UnaryCallSettings.Builder<CreateMirroringEndpointGroupRequest, Operation>
        createMirroringEndpointGroupSettings() {
      return getStubSettingsBuilder().createMirroringEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createMirroringEndpointGroup. */
    public OperationCallSettings.Builder<
            CreateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
        createMirroringEndpointGroupOperationSettings() {
      return getStubSettingsBuilder().createMirroringEndpointGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMirroringEndpointGroup. */
    public UnaryCallSettings.Builder<UpdateMirroringEndpointGroupRequest, Operation>
        updateMirroringEndpointGroupSettings() {
      return getStubSettingsBuilder().updateMirroringEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateMirroringEndpointGroup. */
    public OperationCallSettings.Builder<
            UpdateMirroringEndpointGroupRequest, MirroringEndpointGroup, OperationMetadata>
        updateMirroringEndpointGroupOperationSettings() {
      return getStubSettingsBuilder().updateMirroringEndpointGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMirroringEndpointGroup. */
    public UnaryCallSettings.Builder<DeleteMirroringEndpointGroupRequest, Operation>
        deleteMirroringEndpointGroupSettings() {
      return getStubSettingsBuilder().deleteMirroringEndpointGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMirroringEndpointGroup. */
    public OperationCallSettings.Builder<
            DeleteMirroringEndpointGroupRequest, Empty, OperationMetadata>
        deleteMirroringEndpointGroupOperationSettings() {
      return getStubSettingsBuilder().deleteMirroringEndpointGroupOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listMirroringEndpointGroupAssociations.
     */
    public PagedCallSettings.Builder<
            ListMirroringEndpointGroupAssociationsRequest,
            ListMirroringEndpointGroupAssociationsResponse,
            ListMirroringEndpointGroupAssociationsPagedResponse>
        listMirroringEndpointGroupAssociationsSettings() {
      return getStubSettingsBuilder().listMirroringEndpointGroupAssociationsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getMirroringEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<
            GetMirroringEndpointGroupAssociationRequest, MirroringEndpointGroupAssociation>
        getMirroringEndpointGroupAssociationSettings() {
      return getStubSettingsBuilder().getMirroringEndpointGroupAssociationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * createMirroringEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<CreateMirroringEndpointGroupAssociationRequest, Operation>
        createMirroringEndpointGroupAssociationSettings() {
      return getStubSettingsBuilder().createMirroringEndpointGroupAssociationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * createMirroringEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            CreateMirroringEndpointGroupAssociationRequest,
            MirroringEndpointGroupAssociation,
            OperationMetadata>
        createMirroringEndpointGroupAssociationOperationSettings() {
      return getStubSettingsBuilder().createMirroringEndpointGroupAssociationOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateMirroringEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<UpdateMirroringEndpointGroupAssociationRequest, Operation>
        updateMirroringEndpointGroupAssociationSettings() {
      return getStubSettingsBuilder().updateMirroringEndpointGroupAssociationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * updateMirroringEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            UpdateMirroringEndpointGroupAssociationRequest,
            MirroringEndpointGroupAssociation,
            OperationMetadata>
        updateMirroringEndpointGroupAssociationOperationSettings() {
      return getStubSettingsBuilder().updateMirroringEndpointGroupAssociationOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteMirroringEndpointGroupAssociation.
     */
    public UnaryCallSettings.Builder<DeleteMirroringEndpointGroupAssociationRequest, Operation>
        deleteMirroringEndpointGroupAssociationSettings() {
      return getStubSettingsBuilder().deleteMirroringEndpointGroupAssociationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * deleteMirroringEndpointGroupAssociation.
     */
    public OperationCallSettings.Builder<
            DeleteMirroringEndpointGroupAssociationRequest, Empty, OperationMetadata>
        deleteMirroringEndpointGroupAssociationOperationSettings() {
      return getStubSettingsBuilder().deleteMirroringEndpointGroupAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listMirroringDeploymentGroups. */
    public PagedCallSettings.Builder<
            ListMirroringDeploymentGroupsRequest,
            ListMirroringDeploymentGroupsResponse,
            ListMirroringDeploymentGroupsPagedResponse>
        listMirroringDeploymentGroupsSettings() {
      return getStubSettingsBuilder().listMirroringDeploymentGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getMirroringDeploymentGroup. */
    public UnaryCallSettings.Builder<GetMirroringDeploymentGroupRequest, MirroringDeploymentGroup>
        getMirroringDeploymentGroupSettings() {
      return getStubSettingsBuilder().getMirroringDeploymentGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createMirroringDeploymentGroup. */
    public UnaryCallSettings.Builder<CreateMirroringDeploymentGroupRequest, Operation>
        createMirroringDeploymentGroupSettings() {
      return getStubSettingsBuilder().createMirroringDeploymentGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createMirroringDeploymentGroup. */
    public OperationCallSettings.Builder<
            CreateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
        createMirroringDeploymentGroupOperationSettings() {
      return getStubSettingsBuilder().createMirroringDeploymentGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMirroringDeploymentGroup. */
    public UnaryCallSettings.Builder<UpdateMirroringDeploymentGroupRequest, Operation>
        updateMirroringDeploymentGroupSettings() {
      return getStubSettingsBuilder().updateMirroringDeploymentGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateMirroringDeploymentGroup. */
    public OperationCallSettings.Builder<
            UpdateMirroringDeploymentGroupRequest, MirroringDeploymentGroup, OperationMetadata>
        updateMirroringDeploymentGroupOperationSettings() {
      return getStubSettingsBuilder().updateMirroringDeploymentGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMirroringDeploymentGroup. */
    public UnaryCallSettings.Builder<DeleteMirroringDeploymentGroupRequest, Operation>
        deleteMirroringDeploymentGroupSettings() {
      return getStubSettingsBuilder().deleteMirroringDeploymentGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMirroringDeploymentGroup. */
    public OperationCallSettings.Builder<
            DeleteMirroringDeploymentGroupRequest, Empty, OperationMetadata>
        deleteMirroringDeploymentGroupOperationSettings() {
      return getStubSettingsBuilder().deleteMirroringDeploymentGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listMirroringDeployments. */
    public PagedCallSettings.Builder<
            ListMirroringDeploymentsRequest,
            ListMirroringDeploymentsResponse,
            ListMirroringDeploymentsPagedResponse>
        listMirroringDeploymentsSettings() {
      return getStubSettingsBuilder().listMirroringDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to getMirroringDeployment. */
    public UnaryCallSettings.Builder<GetMirroringDeploymentRequest, MirroringDeployment>
        getMirroringDeploymentSettings() {
      return getStubSettingsBuilder().getMirroringDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createMirroringDeployment. */
    public UnaryCallSettings.Builder<CreateMirroringDeploymentRequest, Operation>
        createMirroringDeploymentSettings() {
      return getStubSettingsBuilder().createMirroringDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createMirroringDeployment. */
    public OperationCallSettings.Builder<
            CreateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
        createMirroringDeploymentOperationSettings() {
      return getStubSettingsBuilder().createMirroringDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMirroringDeployment. */
    public UnaryCallSettings.Builder<UpdateMirroringDeploymentRequest, Operation>
        updateMirroringDeploymentSettings() {
      return getStubSettingsBuilder().updateMirroringDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updateMirroringDeployment. */
    public OperationCallSettings.Builder<
            UpdateMirroringDeploymentRequest, MirroringDeployment, OperationMetadata>
        updateMirroringDeploymentOperationSettings() {
      return getStubSettingsBuilder().updateMirroringDeploymentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMirroringDeployment. */
    public UnaryCallSettings.Builder<DeleteMirroringDeploymentRequest, Operation>
        deleteMirroringDeploymentSettings() {
      return getStubSettingsBuilder().deleteMirroringDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMirroringDeployment. */
    public OperationCallSettings.Builder<DeleteMirroringDeploymentRequest, Empty, OperationMetadata>
        deleteMirroringDeploymentOperationSettings() {
      return getStubSettingsBuilder().deleteMirroringDeploymentOperationSettings();
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
    public MirroringSettings build() throws IOException {
      return new MirroringSettings(this);
    }
  }
}
