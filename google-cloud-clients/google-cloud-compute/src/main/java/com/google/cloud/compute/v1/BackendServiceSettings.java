/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.BackendServiceClient.AggregatedListBackendServicesPagedResponse;
import static com.google.cloud.compute.v1.BackendServiceClient.ListBackendServicesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.BackendServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link BackendServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteBackendService to 30 seconds:
 *
 * <pre>
 * <code>
 * BackendServiceSettings.Builder backendServiceSettingsBuilder =
 *     BackendServiceSettings.newBuilder();
 * backendServiceSettingsBuilder.deleteBackendServiceSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * BackendServiceSettings backendServiceSettings = backendServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class BackendServiceSettings extends ClientSettings<BackendServiceSettings> {
  /** Returns the object with the settings used for calls to aggregatedListBackendServices. */
  public PagedCallSettings<
          AggregatedListBackendServicesHttpRequest, BackendServiceAggregatedList,
          AggregatedListBackendServicesPagedResponse>
      aggregatedListBackendServicesSettings() {
    return ((BackendServiceStubSettings) getStubSettings()).aggregatedListBackendServicesSettings();
  }

  /** Returns the object with the settings used for calls to deleteBackendService. */
  public UnaryCallSettings<DeleteBackendServiceHttpRequest, Operation>
      deleteBackendServiceSettings() {
    return ((BackendServiceStubSettings) getStubSettings()).deleteBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to getBackendService. */
  public UnaryCallSettings<GetBackendServiceHttpRequest, BackendService>
      getBackendServiceSettings() {
    return ((BackendServiceStubSettings) getStubSettings()).getBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to getHealthBackendService. */
  public UnaryCallSettings<GetHealthBackendServiceHttpRequest, BackendServiceGroupHealth>
      getHealthBackendServiceSettings() {
    return ((BackendServiceStubSettings) getStubSettings()).getHealthBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to insertBackendService. */
  public UnaryCallSettings<InsertBackendServiceHttpRequest, Operation>
      insertBackendServiceSettings() {
    return ((BackendServiceStubSettings) getStubSettings()).insertBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to listBackendServices. */
  public PagedCallSettings<
          ListBackendServicesHttpRequest, BackendServiceList, ListBackendServicesPagedResponse>
      listBackendServicesSettings() {
    return ((BackendServiceStubSettings) getStubSettings()).listBackendServicesSettings();
  }

  /** Returns the object with the settings used for calls to patchBackendService. */
  public UnaryCallSettings<PatchBackendServiceHttpRequest, Operation>
      patchBackendServiceSettings() {
    return ((BackendServiceStubSettings) getStubSettings()).patchBackendServiceSettings();
  }

  /** Returns the object with the settings used for calls to updateBackendService. */
  public UnaryCallSettings<UpdateBackendServiceHttpRequest, Operation>
      updateBackendServiceSettings() {
    return ((BackendServiceStubSettings) getStubSettings()).updateBackendServiceSettings();
  }

  public static final BackendServiceSettings create(BackendServiceStubSettings stub)
      throws IOException {
    return new BackendServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return BackendServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return BackendServiceStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return BackendServiceStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return BackendServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return BackendServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return BackendServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return BackendServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BackendServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected BackendServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for BackendServiceSettings. */
  public static class Builder extends ClientSettings.Builder<BackendServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(BackendServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(BackendServiceStubSettings.newBuilder());
    }

    protected Builder(BackendServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(BackendServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public BackendServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((BackendServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to aggregatedListBackendServices. */
    public PagedCallSettings.Builder<
            AggregatedListBackendServicesHttpRequest, BackendServiceAggregatedList,
            AggregatedListBackendServicesPagedResponse>
        aggregatedListBackendServicesSettings() {
      return getStubSettingsBuilder().aggregatedListBackendServicesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBackendService. */
    public UnaryCallSettings.Builder<DeleteBackendServiceHttpRequest, Operation>
        deleteBackendServiceSettings() {
      return getStubSettingsBuilder().deleteBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to getBackendService. */
    public UnaryCallSettings.Builder<GetBackendServiceHttpRequest, BackendService>
        getBackendServiceSettings() {
      return getStubSettingsBuilder().getBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to getHealthBackendService. */
    public UnaryCallSettings.Builder<GetHealthBackendServiceHttpRequest, BackendServiceGroupHealth>
        getHealthBackendServiceSettings() {
      return getStubSettingsBuilder().getHealthBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to insertBackendService. */
    public UnaryCallSettings.Builder<InsertBackendServiceHttpRequest, Operation>
        insertBackendServiceSettings() {
      return getStubSettingsBuilder().insertBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to listBackendServices. */
    public PagedCallSettings.Builder<
            ListBackendServicesHttpRequest, BackendServiceList, ListBackendServicesPagedResponse>
        listBackendServicesSettings() {
      return getStubSettingsBuilder().listBackendServicesSettings();
    }

    /** Returns the builder for the settings used for calls to patchBackendService. */
    public UnaryCallSettings.Builder<PatchBackendServiceHttpRequest, Operation>
        patchBackendServiceSettings() {
      return getStubSettingsBuilder().patchBackendServiceSettings();
    }

    /** Returns the builder for the settings used for calls to updateBackendService. */
    public UnaryCallSettings.Builder<UpdateBackendServiceHttpRequest, Operation>
        updateBackendServiceSettings() {
      return getStubSettingsBuilder().updateBackendServiceSettings();
    }

    @Override
    public BackendServiceSettings build() throws IOException {
      return new BackendServiceSettings(this);
    }
  }
}
