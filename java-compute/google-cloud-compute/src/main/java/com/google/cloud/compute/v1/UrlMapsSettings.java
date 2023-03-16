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

import static com.google.cloud.compute.v1.UrlMapsClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.UrlMapsClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.UrlMapsStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link UrlMapsClient}.
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
 * UrlMapsSettings.Builder urlMapsSettingsBuilder = UrlMapsSettings.newBuilder();
 * urlMapsSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         urlMapsSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * UrlMapsSettings urlMapsSettings = urlMapsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class UrlMapsSettings extends ClientSettings<UrlMapsSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListUrlMapsRequest, UrlMapsAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteUrlMapRequest, Operation> deleteSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteUrlMapRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetUrlMapRequest, UrlMap> getSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertUrlMapRequest, Operation> insertSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertUrlMapRequest, Operation, Operation>
      insertOperationSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to invalidateCache. */
  public UnaryCallSettings<InvalidateCacheUrlMapRequest, Operation> invalidateCacheSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).invalidateCacheSettings();
  }

  /** Returns the object with the settings used for calls to invalidateCache. */
  public OperationCallSettings<InvalidateCacheUrlMapRequest, Operation, Operation>
      invalidateCacheOperationSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).invalidateCacheOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListUrlMapsRequest, UrlMapList, ListPagedResponse> listSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchUrlMapRequest, Operation> patchSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchUrlMapRequest, Operation, Operation> patchOperationSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateUrlMapRequest, Operation> updateSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).updateSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateUrlMapRequest, Operation, Operation>
      updateOperationSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).updateOperationSettings();
  }

  /** Returns the object with the settings used for calls to validate. */
  public UnaryCallSettings<ValidateUrlMapRequest, UrlMapsValidateResponse> validateSettings() {
    return ((UrlMapsStubSettings) getStubSettings()).validateSettings();
  }

  public static final UrlMapsSettings create(UrlMapsStubSettings stub) throws IOException {
    return new UrlMapsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return UrlMapsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return UrlMapsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return UrlMapsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return UrlMapsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return UrlMapsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return UrlMapsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return UrlMapsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected UrlMapsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for UrlMapsSettings. */
  public static class Builder extends ClientSettings.Builder<UrlMapsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(UrlMapsStubSettings.newBuilder(clientContext));
    }

    protected Builder(UrlMapsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(UrlMapsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(UrlMapsStubSettings.newBuilder());
    }

    public UrlMapsStubSettings.Builder getStubSettingsBuilder() {
      return ((UrlMapsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListUrlMapsRequest, UrlMapsAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteUrlMapRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteUrlMapRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetUrlMapRequest, UrlMap> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertUrlMapRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertUrlMapRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to invalidateCache. */
    public UnaryCallSettings.Builder<InvalidateCacheUrlMapRequest, Operation>
        invalidateCacheSettings() {
      return getStubSettingsBuilder().invalidateCacheSettings();
    }

    /** Returns the builder for the settings used for calls to invalidateCache. */
    public OperationCallSettings.Builder<InvalidateCacheUrlMapRequest, Operation, Operation>
        invalidateCacheOperationSettings() {
      return getStubSettingsBuilder().invalidateCacheOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListUrlMapsRequest, UrlMapList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchUrlMapRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchUrlMapRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateUrlMapRequest, Operation> updateSettings() {
      return getStubSettingsBuilder().updateSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateUrlMapRequest, Operation, Operation>
        updateOperationSettings() {
      return getStubSettingsBuilder().updateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to validate. */
    public UnaryCallSettings.Builder<ValidateUrlMapRequest, UrlMapsValidateResponse>
        validateSettings() {
      return getStubSettingsBuilder().validateSettings();
    }

    @Override
    public UrlMapsSettings build() throws IOException {
      return new UrlMapsSettings(this);
    }
  }
}
