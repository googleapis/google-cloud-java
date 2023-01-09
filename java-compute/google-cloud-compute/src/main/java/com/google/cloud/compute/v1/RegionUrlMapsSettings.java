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

import static com.google.cloud.compute.v1.RegionUrlMapsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionUrlMapsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionUrlMapsClient}.
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
 * RegionUrlMapsSettings.Builder regionUrlMapsSettingsBuilder = RegionUrlMapsSettings.newBuilder();
 * regionUrlMapsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionUrlMapsSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionUrlMapsSettings regionUrlMapsSettings = regionUrlMapsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionUrlMapsSettings extends ClientSettings<RegionUrlMapsSettings> {

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionUrlMapRequest, Operation> deleteSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionUrlMapRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionUrlMapRequest, UrlMap> getSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionUrlMapRequest, Operation> insertSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionUrlMapRequest, Operation, Operation>
      insertOperationSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRegionUrlMapsRequest, UrlMapList, ListPagedResponse> listSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRegionUrlMapRequest, Operation> patchSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRegionUrlMapRequest, Operation, Operation>
      patchOperationSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateRegionUrlMapRequest, Operation> updateSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).updateSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateRegionUrlMapRequest, Operation, Operation>
      updateOperationSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).updateOperationSettings();
  }

  /** Returns the object with the settings used for calls to validate. */
  public UnaryCallSettings<ValidateRegionUrlMapRequest, UrlMapsValidateResponse>
      validateSettings() {
    return ((RegionUrlMapsStubSettings) getStubSettings()).validateSettings();
  }

  public static final RegionUrlMapsSettings create(RegionUrlMapsStubSettings stub)
      throws IOException {
    return new RegionUrlMapsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionUrlMapsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionUrlMapsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionUrlMapsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionUrlMapsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionUrlMapsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionUrlMapsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionUrlMapsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionUrlMapsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionUrlMapsSettings. */
  public static class Builder extends ClientSettings.Builder<RegionUrlMapsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegionUrlMapsStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegionUrlMapsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionUrlMapsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegionUrlMapsStubSettings.newBuilder());
    }

    public RegionUrlMapsStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionUrlMapsStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<DeleteRegionUrlMapRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRegionUrlMapRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionUrlMapRequest, UrlMap> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionUrlMapRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRegionUrlMapRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListRegionUrlMapsRequest, UrlMapList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRegionUrlMapRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchRegionUrlMapRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateRegionUrlMapRequest, Operation> updateSettings() {
      return getStubSettingsBuilder().updateSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateRegionUrlMapRequest, Operation, Operation>
        updateOperationSettings() {
      return getStubSettingsBuilder().updateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to validate. */
    public UnaryCallSettings.Builder<ValidateRegionUrlMapRequest, UrlMapsValidateResponse>
        validateSettings() {
      return getStubSettingsBuilder().validateSettings();
    }

    @Override
    public RegionUrlMapsSettings build() throws IOException {
      return new RegionUrlMapsSettings(this);
    }
  }
}
