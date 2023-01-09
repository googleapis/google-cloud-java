/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.RegionBackendServicesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
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
import com.google.cloud.compute.v1.stub.RegionBackendServicesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionBackendServicesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionBackendServicesSettings.Builder regionBackendServicesSettingsBuilder =
 *     RegionBackendServicesSettings.newBuilder();
 * regionBackendServicesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionBackendServicesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionBackendServicesSettings regionBackendServicesSettings =
 *     regionBackendServicesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionBackendServicesSettings extends ClientSettings<RegionBackendServicesSettings> {

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionBackendServiceRequest, Operation> deleteSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionBackendServiceRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionBackendServiceRequest, BackendService> getSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getHealth. */
  public UnaryCallSettings<GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>
      getHealthSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).getHealthSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRegionBackendServiceRequest, Policy> getIamPolicySettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionBackendServiceRequest, Operation> insertSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionBackendServiceRequest, Operation, Operation>
      insertOperationSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRegionBackendServicesRequest, BackendServiceList, ListPagedResponse>
      listSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRegionBackendServiceRequest, Operation> patchSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRegionBackendServiceRequest, Operation, Operation>
      patchOperationSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRegionBackendServiceRequest, Policy> setIamPolicySettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateRegionBackendServiceRequest, Operation> updateSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).updateSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateRegionBackendServiceRequest, Operation, Operation>
      updateOperationSettings() {
    return ((RegionBackendServicesStubSettings) getStubSettings()).updateOperationSettings();
  }

  public static final RegionBackendServicesSettings create(RegionBackendServicesStubSettings stub)
      throws IOException {
    return new RegionBackendServicesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionBackendServicesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionBackendServicesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionBackendServicesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionBackendServicesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionBackendServicesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionBackendServicesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionBackendServicesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionBackendServicesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionBackendServicesSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionBackendServicesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegionBackendServicesStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegionBackendServicesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionBackendServicesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegionBackendServicesStubSettings.newBuilder());
    }

    public RegionBackendServicesStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionBackendServicesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRegionBackendServiceRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRegionBackendServiceRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionBackendServiceRequest, BackendService> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getHealth. */
    public UnaryCallSettings.Builder<
            GetHealthRegionBackendServiceRequest, BackendServiceGroupHealth>
        getHealthSettings() {
      return getStubSettingsBuilder().getHealthSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRegionBackendServiceRequest, Policy>
        getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionBackendServiceRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRegionBackendServiceRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionBackendServicesRequest, BackendServiceList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRegionBackendServiceRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchRegionBackendServiceRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRegionBackendServiceRequest, Policy>
        setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateRegionBackendServiceRequest, Operation>
        updateSettings() {
      return getStubSettingsBuilder().updateSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateRegionBackendServiceRequest, Operation, Operation>
        updateOperationSettings() {
      return getStubSettingsBuilder().updateOperationSettings();
    }

    @Override
    public RegionBackendServicesSettings build() throws IOException {
      return new RegionBackendServicesSettings(this);
    }
  }
}
