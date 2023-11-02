/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeatureGroupsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListFeaturesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.FeatureRegistryServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link FeatureRegistryServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFeatureGroup to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeatureRegistryServiceSettings.Builder featureRegistryServiceSettingsBuilder =
 *     FeatureRegistryServiceSettings.newBuilder();
 * featureRegistryServiceSettingsBuilder
 *     .getFeatureGroupSettings()
 *     .setRetrySettings(
 *         featureRegistryServiceSettingsBuilder
 *             .getFeatureGroupSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FeatureRegistryServiceSettings featureRegistryServiceSettings =
 *     featureRegistryServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FeatureRegistryServiceSettings extends ClientSettings<FeatureRegistryServiceSettings> {

  /** Returns the object with the settings used for calls to createFeatureGroup. */
  public UnaryCallSettings<CreateFeatureGroupRequest, Operation> createFeatureGroupSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).createFeatureGroupSettings();
  }

  /** Returns the object with the settings used for calls to createFeatureGroup. */
  public OperationCallSettings<
          CreateFeatureGroupRequest, FeatureGroup, CreateFeatureGroupOperationMetadata>
      createFeatureGroupOperationSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings())
        .createFeatureGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to getFeatureGroup. */
  public UnaryCallSettings<GetFeatureGroupRequest, FeatureGroup> getFeatureGroupSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).getFeatureGroupSettings();
  }

  /** Returns the object with the settings used for calls to listFeatureGroups. */
  public PagedCallSettings<
          ListFeatureGroupsRequest, ListFeatureGroupsResponse, ListFeatureGroupsPagedResponse>
      listFeatureGroupsSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).listFeatureGroupsSettings();
  }

  /** Returns the object with the settings used for calls to updateFeatureGroup. */
  public UnaryCallSettings<UpdateFeatureGroupRequest, Operation> updateFeatureGroupSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).updateFeatureGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateFeatureGroup. */
  public OperationCallSettings<
          UpdateFeatureGroupRequest, FeatureGroup, UpdateFeatureGroupOperationMetadata>
      updateFeatureGroupOperationSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings())
        .updateFeatureGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeatureGroup. */
  public UnaryCallSettings<DeleteFeatureGroupRequest, Operation> deleteFeatureGroupSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).deleteFeatureGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeatureGroup. */
  public OperationCallSettings<DeleteFeatureGroupRequest, Empty, DeleteOperationMetadata>
      deleteFeatureGroupOperationSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings())
        .deleteFeatureGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).createFeatureSettings();
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public OperationCallSettings<CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
      createFeatureOperationSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings())
        .createFeatureOperationSettings();
  }

  /** Returns the object with the settings used for calls to getFeature. */
  public UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).getFeatureSettings();
  }

  /** Returns the object with the settings used for calls to listFeatures. */
  public PagedCallSettings<ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).listFeaturesSettings();
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public UnaryCallSettings<UpdateFeatureRequest, Operation> updateFeatureSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).updateFeatureSettings();
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public OperationCallSettings<UpdateFeatureRequest, Feature, UpdateFeatureOperationMetadata>
      updateFeatureOperationSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings())
        .updateFeatureOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).deleteFeatureSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public OperationCallSettings<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings())
        .deleteFeatureOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((FeatureRegistryServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final FeatureRegistryServiceSettings create(FeatureRegistryServiceStubSettings stub)
      throws IOException {
    return new FeatureRegistryServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FeatureRegistryServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FeatureRegistryServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FeatureRegistryServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FeatureRegistryServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FeatureRegistryServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FeatureRegistryServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FeatureRegistryServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FeatureRegistryServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FeatureRegistryServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<FeatureRegistryServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FeatureRegistryServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(FeatureRegistryServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FeatureRegistryServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FeatureRegistryServiceStubSettings.newBuilder());
    }

    public FeatureRegistryServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((FeatureRegistryServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createFeatureGroup. */
    public UnaryCallSettings.Builder<CreateFeatureGroupRequest, Operation>
        createFeatureGroupSettings() {
      return getStubSettingsBuilder().createFeatureGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createFeatureGroup. */
    public OperationCallSettings.Builder<
            CreateFeatureGroupRequest, FeatureGroup, CreateFeatureGroupOperationMetadata>
        createFeatureGroupOperationSettings() {
      return getStubSettingsBuilder().createFeatureGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getFeatureGroup. */
    public UnaryCallSettings.Builder<GetFeatureGroupRequest, FeatureGroup>
        getFeatureGroupSettings() {
      return getStubSettingsBuilder().getFeatureGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listFeatureGroups. */
    public PagedCallSettings.Builder<
            ListFeatureGroupsRequest, ListFeatureGroupsResponse, ListFeatureGroupsPagedResponse>
        listFeatureGroupsSettings() {
      return getStubSettingsBuilder().listFeatureGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeatureGroup. */
    public UnaryCallSettings.Builder<UpdateFeatureGroupRequest, Operation>
        updateFeatureGroupSettings() {
      return getStubSettingsBuilder().updateFeatureGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeatureGroup. */
    public OperationCallSettings.Builder<
            UpdateFeatureGroupRequest, FeatureGroup, UpdateFeatureGroupOperationMetadata>
        updateFeatureGroupOperationSettings() {
      return getStubSettingsBuilder().updateFeatureGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeatureGroup. */
    public UnaryCallSettings.Builder<DeleteFeatureGroupRequest, Operation>
        deleteFeatureGroupSettings() {
      return getStubSettingsBuilder().deleteFeatureGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeatureGroup. */
    public OperationCallSettings.Builder<DeleteFeatureGroupRequest, Empty, DeleteOperationMetadata>
        deleteFeatureGroupOperationSettings() {
      return getStubSettingsBuilder().deleteFeatureGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings() {
      return getStubSettingsBuilder().createFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public OperationCallSettings.Builder<
            CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
        createFeatureOperationSettings() {
      return getStubSettingsBuilder().createFeatureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getFeature. */
    public UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings() {
      return getStubSettingsBuilder().getFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to listFeatures. */
    public PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings() {
      return getStubSettingsBuilder().listFeaturesSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public UnaryCallSettings.Builder<UpdateFeatureRequest, Operation> updateFeatureSettings() {
      return getStubSettingsBuilder().updateFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public OperationCallSettings.Builder<
            UpdateFeatureRequest, Feature, UpdateFeatureOperationMetadata>
        updateFeatureOperationSettings() {
      return getStubSettingsBuilder().updateFeatureOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
      return getStubSettingsBuilder().deleteFeatureSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public OperationCallSettings.Builder<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
        deleteFeatureOperationSettings() {
      return getStubSettingsBuilder().deleteFeatureOperationSettings();
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
    public FeatureRegistryServiceSettings build() throws IOException {
      return new FeatureRegistryServiceSettings(this);
    }
  }
}
