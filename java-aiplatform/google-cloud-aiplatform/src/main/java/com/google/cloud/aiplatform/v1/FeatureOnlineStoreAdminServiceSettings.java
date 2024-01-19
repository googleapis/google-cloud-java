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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListFeatureOnlineStoresPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewSyncsPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewsPagedResponse;
import static com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.aiplatform.v1.stub.FeatureOnlineStoreAdminServiceStubSettings;
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
 * Settings class to configure an instance of {@link FeatureOnlineStoreAdminServiceClient}.
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
 * <p>For example, to set the total timeout of getFeatureOnlineStore to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeatureOnlineStoreAdminServiceSettings.Builder featureOnlineStoreAdminServiceSettingsBuilder =
 *     FeatureOnlineStoreAdminServiceSettings.newBuilder();
 * featureOnlineStoreAdminServiceSettingsBuilder
 *     .getFeatureOnlineStoreSettings()
 *     .setRetrySettings(
 *         featureOnlineStoreAdminServiceSettingsBuilder
 *             .getFeatureOnlineStoreSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FeatureOnlineStoreAdminServiceSettings featureOnlineStoreAdminServiceSettings =
 *     featureOnlineStoreAdminServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FeatureOnlineStoreAdminServiceSettings
    extends ClientSettings<FeatureOnlineStoreAdminServiceSettings> {

  /** Returns the object with the settings used for calls to createFeatureOnlineStore. */
  public UnaryCallSettings<CreateFeatureOnlineStoreRequest, Operation>
      createFeatureOnlineStoreSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .createFeatureOnlineStoreSettings();
  }

  /** Returns the object with the settings used for calls to createFeatureOnlineStore. */
  public OperationCallSettings<
          CreateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreOperationSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .createFeatureOnlineStoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to getFeatureOnlineStore. */
  public UnaryCallSettings<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
      getFeatureOnlineStoreSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .getFeatureOnlineStoreSettings();
  }

  /** Returns the object with the settings used for calls to listFeatureOnlineStores. */
  public PagedCallSettings<
          ListFeatureOnlineStoresRequest,
          ListFeatureOnlineStoresResponse,
          ListFeatureOnlineStoresPagedResponse>
      listFeatureOnlineStoresSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .listFeatureOnlineStoresSettings();
  }

  /** Returns the object with the settings used for calls to updateFeatureOnlineStore. */
  public UnaryCallSettings<UpdateFeatureOnlineStoreRequest, Operation>
      updateFeatureOnlineStoreSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .updateFeatureOnlineStoreSettings();
  }

  /** Returns the object with the settings used for calls to updateFeatureOnlineStore. */
  public OperationCallSettings<
          UpdateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          UpdateFeatureOnlineStoreOperationMetadata>
      updateFeatureOnlineStoreOperationSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .updateFeatureOnlineStoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeatureOnlineStore. */
  public UnaryCallSettings<DeleteFeatureOnlineStoreRequest, Operation>
      deleteFeatureOnlineStoreSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .deleteFeatureOnlineStoreSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeatureOnlineStore. */
  public OperationCallSettings<DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOnlineStoreOperationSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .deleteFeatureOnlineStoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to createFeatureView. */
  public UnaryCallSettings<CreateFeatureViewRequest, Operation> createFeatureViewSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .createFeatureViewSettings();
  }

  /** Returns the object with the settings used for calls to createFeatureView. */
  public OperationCallSettings<
          CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewOperationSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .createFeatureViewOperationSettings();
  }

  /** Returns the object with the settings used for calls to getFeatureView. */
  public UnaryCallSettings<GetFeatureViewRequest, FeatureView> getFeatureViewSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .getFeatureViewSettings();
  }

  /** Returns the object with the settings used for calls to listFeatureViews. */
  public PagedCallSettings<
          ListFeatureViewsRequest, ListFeatureViewsResponse, ListFeatureViewsPagedResponse>
      listFeatureViewsSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .listFeatureViewsSettings();
  }

  /** Returns the object with the settings used for calls to updateFeatureView. */
  public UnaryCallSettings<UpdateFeatureViewRequest, Operation> updateFeatureViewSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .updateFeatureViewSettings();
  }

  /** Returns the object with the settings used for calls to updateFeatureView. */
  public OperationCallSettings<
          UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
      updateFeatureViewOperationSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .updateFeatureViewOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeatureView. */
  public UnaryCallSettings<DeleteFeatureViewRequest, Operation> deleteFeatureViewSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .deleteFeatureViewSettings();
  }

  /** Returns the object with the settings used for calls to deleteFeatureView. */
  public OperationCallSettings<DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
      deleteFeatureViewOperationSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .deleteFeatureViewOperationSettings();
  }

  /** Returns the object with the settings used for calls to syncFeatureView. */
  public UnaryCallSettings<SyncFeatureViewRequest, SyncFeatureViewResponse>
      syncFeatureViewSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .syncFeatureViewSettings();
  }

  /** Returns the object with the settings used for calls to getFeatureViewSync. */
  public UnaryCallSettings<GetFeatureViewSyncRequest, FeatureViewSync>
      getFeatureViewSyncSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .getFeatureViewSyncSettings();
  }

  /** Returns the object with the settings used for calls to listFeatureViewSyncs. */
  public PagedCallSettings<
          ListFeatureViewSyncsRequest,
          ListFeatureViewSyncsResponse,
          ListFeatureViewSyncsPagedResponse>
      listFeatureViewSyncsSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .listFeatureViewSyncsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((FeatureOnlineStoreAdminServiceStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final FeatureOnlineStoreAdminServiceSettings create(
      FeatureOnlineStoreAdminServiceStubSettings stub) throws IOException {
    return new FeatureOnlineStoreAdminServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FeatureOnlineStoreAdminServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FeatureOnlineStoreAdminServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FeatureOnlineStoreAdminServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FeatureOnlineStoreAdminServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FeatureOnlineStoreAdminServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FeatureOnlineStoreAdminServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FeatureOnlineStoreAdminServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FeatureOnlineStoreAdminServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FeatureOnlineStoreAdminServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<FeatureOnlineStoreAdminServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FeatureOnlineStoreAdminServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(FeatureOnlineStoreAdminServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FeatureOnlineStoreAdminServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FeatureOnlineStoreAdminServiceStubSettings.newBuilder());
    }

    public FeatureOnlineStoreAdminServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((FeatureOnlineStoreAdminServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createFeatureOnlineStore. */
    public UnaryCallSettings.Builder<CreateFeatureOnlineStoreRequest, Operation>
        createFeatureOnlineStoreSettings() {
      return getStubSettingsBuilder().createFeatureOnlineStoreSettings();
    }

    /** Returns the builder for the settings used for calls to createFeatureOnlineStore. */
    public OperationCallSettings.Builder<
            CreateFeatureOnlineStoreRequest,
            FeatureOnlineStore,
            CreateFeatureOnlineStoreOperationMetadata>
        createFeatureOnlineStoreOperationSettings() {
      return getStubSettingsBuilder().createFeatureOnlineStoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getFeatureOnlineStore. */
    public UnaryCallSettings.Builder<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
        getFeatureOnlineStoreSettings() {
      return getStubSettingsBuilder().getFeatureOnlineStoreSettings();
    }

    /** Returns the builder for the settings used for calls to listFeatureOnlineStores. */
    public PagedCallSettings.Builder<
            ListFeatureOnlineStoresRequest,
            ListFeatureOnlineStoresResponse,
            ListFeatureOnlineStoresPagedResponse>
        listFeatureOnlineStoresSettings() {
      return getStubSettingsBuilder().listFeatureOnlineStoresSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeatureOnlineStore. */
    public UnaryCallSettings.Builder<UpdateFeatureOnlineStoreRequest, Operation>
        updateFeatureOnlineStoreSettings() {
      return getStubSettingsBuilder().updateFeatureOnlineStoreSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeatureOnlineStore. */
    public OperationCallSettings.Builder<
            UpdateFeatureOnlineStoreRequest,
            FeatureOnlineStore,
            UpdateFeatureOnlineStoreOperationMetadata>
        updateFeatureOnlineStoreOperationSettings() {
      return getStubSettingsBuilder().updateFeatureOnlineStoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeatureOnlineStore. */
    public UnaryCallSettings.Builder<DeleteFeatureOnlineStoreRequest, Operation>
        deleteFeatureOnlineStoreSettings() {
      return getStubSettingsBuilder().deleteFeatureOnlineStoreSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeatureOnlineStore. */
    public OperationCallSettings.Builder<
            DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
        deleteFeatureOnlineStoreOperationSettings() {
      return getStubSettingsBuilder().deleteFeatureOnlineStoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createFeatureView. */
    public UnaryCallSettings.Builder<CreateFeatureViewRequest, Operation>
        createFeatureViewSettings() {
      return getStubSettingsBuilder().createFeatureViewSettings();
    }

    /** Returns the builder for the settings used for calls to createFeatureView. */
    public OperationCallSettings.Builder<
            CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
        createFeatureViewOperationSettings() {
      return getStubSettingsBuilder().createFeatureViewOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getFeatureView. */
    public UnaryCallSettings.Builder<GetFeatureViewRequest, FeatureView> getFeatureViewSettings() {
      return getStubSettingsBuilder().getFeatureViewSettings();
    }

    /** Returns the builder for the settings used for calls to listFeatureViews. */
    public PagedCallSettings.Builder<
            ListFeatureViewsRequest, ListFeatureViewsResponse, ListFeatureViewsPagedResponse>
        listFeatureViewsSettings() {
      return getStubSettingsBuilder().listFeatureViewsSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeatureView. */
    public UnaryCallSettings.Builder<UpdateFeatureViewRequest, Operation>
        updateFeatureViewSettings() {
      return getStubSettingsBuilder().updateFeatureViewSettings();
    }

    /** Returns the builder for the settings used for calls to updateFeatureView. */
    public OperationCallSettings.Builder<
            UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
        updateFeatureViewOperationSettings() {
      return getStubSettingsBuilder().updateFeatureViewOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeatureView. */
    public UnaryCallSettings.Builder<DeleteFeatureViewRequest, Operation>
        deleteFeatureViewSettings() {
      return getStubSettingsBuilder().deleteFeatureViewSettings();
    }

    /** Returns the builder for the settings used for calls to deleteFeatureView. */
    public OperationCallSettings.Builder<DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
        deleteFeatureViewOperationSettings() {
      return getStubSettingsBuilder().deleteFeatureViewOperationSettings();
    }

    /** Returns the builder for the settings used for calls to syncFeatureView. */
    public UnaryCallSettings.Builder<SyncFeatureViewRequest, SyncFeatureViewResponse>
        syncFeatureViewSettings() {
      return getStubSettingsBuilder().syncFeatureViewSettings();
    }

    /** Returns the builder for the settings used for calls to getFeatureViewSync. */
    public UnaryCallSettings.Builder<GetFeatureViewSyncRequest, FeatureViewSync>
        getFeatureViewSyncSettings() {
      return getStubSettingsBuilder().getFeatureViewSyncSettings();
    }

    /** Returns the builder for the settings used for calls to listFeatureViewSyncs. */
    public PagedCallSettings.Builder<
            ListFeatureViewSyncsRequest,
            ListFeatureViewSyncsResponse,
            ListFeatureViewSyncsPagedResponse>
        listFeatureViewSyncsSettings() {
      return getStubSettingsBuilder().listFeatureViewSyncsSettings();
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
    public FeatureOnlineStoreAdminServiceSettings build() throws IOException {
      return new FeatureOnlineStoreAdminServiceSettings(this);
    }
  }
}
