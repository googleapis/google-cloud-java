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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.AddressGroupServiceClient.ListAddressGroupReferencesPagedResponse;
import static com.google.cloud.networksecurity.v1.AddressGroupServiceClient.ListAddressGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.AddressGroupServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.networksecurity.v1.stub.AddressGroupServiceStubSettings;
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
 * Settings class to configure an instance of {@link AddressGroupServiceClient}.
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
 * of getAddressGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AddressGroupServiceSettings.Builder addressGroupServiceSettingsBuilder =
 *     AddressGroupServiceSettings.newBuilder();
 * addressGroupServiceSettingsBuilder
 *     .getAddressGroupSettings()
 *     .setRetrySettings(
 *         addressGroupServiceSettingsBuilder
 *             .getAddressGroupSettings()
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
 * AddressGroupServiceSettings addressGroupServiceSettings =
 *     addressGroupServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createAddressGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AddressGroupServiceSettings.Builder addressGroupServiceSettingsBuilder =
 *     AddressGroupServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * addressGroupServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AddressGroupServiceSettings extends ClientSettings<AddressGroupServiceSettings> {

  /** Returns the object with the settings used for calls to listAddressGroups. */
  public PagedCallSettings<
          ListAddressGroupsRequest, ListAddressGroupsResponse, ListAddressGroupsPagedResponse>
      listAddressGroupsSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).listAddressGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getAddressGroup. */
  public UnaryCallSettings<GetAddressGroupRequest, AddressGroup> getAddressGroupSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).getAddressGroupSettings();
  }

  /** Returns the object with the settings used for calls to createAddressGroup. */
  public UnaryCallSettings<CreateAddressGroupRequest, Operation> createAddressGroupSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).createAddressGroupSettings();
  }

  /** Returns the object with the settings used for calls to createAddressGroup. */
  public OperationCallSettings<CreateAddressGroupRequest, AddressGroup, OperationMetadata>
      createAddressGroupOperationSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings())
        .createAddressGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAddressGroup. */
  public UnaryCallSettings<UpdateAddressGroupRequest, Operation> updateAddressGroupSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).updateAddressGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateAddressGroup. */
  public OperationCallSettings<UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
      updateAddressGroupOperationSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings())
        .updateAddressGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to addAddressGroupItems. */
  public UnaryCallSettings<AddAddressGroupItemsRequest, Operation> addAddressGroupItemsSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).addAddressGroupItemsSettings();
  }

  /** Returns the object with the settings used for calls to addAddressGroupItems. */
  public OperationCallSettings<AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      addAddressGroupItemsOperationSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings())
        .addAddressGroupItemsOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeAddressGroupItems. */
  public UnaryCallSettings<RemoveAddressGroupItemsRequest, Operation>
      removeAddressGroupItemsSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).removeAddressGroupItemsSettings();
  }

  /** Returns the object with the settings used for calls to removeAddressGroupItems. */
  public OperationCallSettings<RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      removeAddressGroupItemsOperationSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings())
        .removeAddressGroupItemsOperationSettings();
  }

  /** Returns the object with the settings used for calls to cloneAddressGroupItems. */
  public UnaryCallSettings<CloneAddressGroupItemsRequest, Operation>
      cloneAddressGroupItemsSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).cloneAddressGroupItemsSettings();
  }

  /** Returns the object with the settings used for calls to cloneAddressGroupItems. */
  public OperationCallSettings<CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
      cloneAddressGroupItemsOperationSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings())
        .cloneAddressGroupItemsOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAddressGroup. */
  public UnaryCallSettings<DeleteAddressGroupRequest, Operation> deleteAddressGroupSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).deleteAddressGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteAddressGroup. */
  public OperationCallSettings<DeleteAddressGroupRequest, Empty, OperationMetadata>
      deleteAddressGroupOperationSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings())
        .deleteAddressGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAddressGroupReferences. */
  public PagedCallSettings<
          ListAddressGroupReferencesRequest,
          ListAddressGroupReferencesResponse,
          ListAddressGroupReferencesPagedResponse>
      listAddressGroupReferencesSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings())
        .listAddressGroupReferencesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((AddressGroupServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final AddressGroupServiceSettings create(AddressGroupServiceStubSettings stub)
      throws IOException {
    return new AddressGroupServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AddressGroupServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AddressGroupServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AddressGroupServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AddressGroupServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AddressGroupServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AddressGroupServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AddressGroupServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AddressGroupServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AddressGroupServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AddressGroupServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AddressGroupServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AddressGroupServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AddressGroupServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AddressGroupServiceStubSettings.newBuilder());
    }

    public AddressGroupServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AddressGroupServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAddressGroups. */
    public PagedCallSettings.Builder<
            ListAddressGroupsRequest, ListAddressGroupsResponse, ListAddressGroupsPagedResponse>
        listAddressGroupsSettings() {
      return getStubSettingsBuilder().listAddressGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getAddressGroup. */
    public UnaryCallSettings.Builder<GetAddressGroupRequest, AddressGroup>
        getAddressGroupSettings() {
      return getStubSettingsBuilder().getAddressGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createAddressGroup. */
    public UnaryCallSettings.Builder<CreateAddressGroupRequest, Operation>
        createAddressGroupSettings() {
      return getStubSettingsBuilder().createAddressGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createAddressGroup. */
    public OperationCallSettings.Builder<CreateAddressGroupRequest, AddressGroup, OperationMetadata>
        createAddressGroupOperationSettings() {
      return getStubSettingsBuilder().createAddressGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAddressGroup. */
    public UnaryCallSettings.Builder<UpdateAddressGroupRequest, Operation>
        updateAddressGroupSettings() {
      return getStubSettingsBuilder().updateAddressGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateAddressGroup. */
    public OperationCallSettings.Builder<UpdateAddressGroupRequest, AddressGroup, OperationMetadata>
        updateAddressGroupOperationSettings() {
      return getStubSettingsBuilder().updateAddressGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addAddressGroupItems. */
    public UnaryCallSettings.Builder<AddAddressGroupItemsRequest, Operation>
        addAddressGroupItemsSettings() {
      return getStubSettingsBuilder().addAddressGroupItemsSettings();
    }

    /** Returns the builder for the settings used for calls to addAddressGroupItems. */
    public OperationCallSettings.Builder<
            AddAddressGroupItemsRequest, AddressGroup, OperationMetadata>
        addAddressGroupItemsOperationSettings() {
      return getStubSettingsBuilder().addAddressGroupItemsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAddressGroupItems. */
    public UnaryCallSettings.Builder<RemoveAddressGroupItemsRequest, Operation>
        removeAddressGroupItemsSettings() {
      return getStubSettingsBuilder().removeAddressGroupItemsSettings();
    }

    /** Returns the builder for the settings used for calls to removeAddressGroupItems. */
    public OperationCallSettings.Builder<
            RemoveAddressGroupItemsRequest, AddressGroup, OperationMetadata>
        removeAddressGroupItemsOperationSettings() {
      return getStubSettingsBuilder().removeAddressGroupItemsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cloneAddressGroupItems. */
    public UnaryCallSettings.Builder<CloneAddressGroupItemsRequest, Operation>
        cloneAddressGroupItemsSettings() {
      return getStubSettingsBuilder().cloneAddressGroupItemsSettings();
    }

    /** Returns the builder for the settings used for calls to cloneAddressGroupItems. */
    public OperationCallSettings.Builder<
            CloneAddressGroupItemsRequest, AddressGroup, OperationMetadata>
        cloneAddressGroupItemsOperationSettings() {
      return getStubSettingsBuilder().cloneAddressGroupItemsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAddressGroup. */
    public UnaryCallSettings.Builder<DeleteAddressGroupRequest, Operation>
        deleteAddressGroupSettings() {
      return getStubSettingsBuilder().deleteAddressGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAddressGroup. */
    public OperationCallSettings.Builder<DeleteAddressGroupRequest, Empty, OperationMetadata>
        deleteAddressGroupOperationSettings() {
      return getStubSettingsBuilder().deleteAddressGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAddressGroupReferences. */
    public PagedCallSettings.Builder<
            ListAddressGroupReferencesRequest,
            ListAddressGroupReferencesResponse,
            ListAddressGroupReferencesPagedResponse>
        listAddressGroupReferencesSettings() {
      return getStubSettingsBuilder().listAddressGroupReferencesSettings();
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
    public AddressGroupServiceSettings build() throws IOException {
      return new AddressGroupServiceSettings(this);
    }
  }
}
