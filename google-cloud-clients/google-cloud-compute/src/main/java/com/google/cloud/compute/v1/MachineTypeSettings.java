/*
 * Copyright 2019 Google LLC
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

import static com.google.cloud.compute.v1.MachineTypeClient.AggregatedListMachineTypesPagedResponse;
import static com.google.cloud.compute.v1.MachineTypeClient.ListMachineTypesPagedResponse;

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
import com.google.cloud.compute.v1.stub.MachineTypeStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link MachineTypeClient}.
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
 * example, to set the total timeout of getMachineType to 30 seconds:
 *
 * <pre>
 * <code>
 * MachineTypeSettings.Builder machineTypeSettingsBuilder =
 *     MachineTypeSettings.newBuilder();
 * machineTypeSettingsBuilder.getMachineTypeSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * MachineTypeSettings machineTypeSettings = machineTypeSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class MachineTypeSettings extends ClientSettings<MachineTypeSettings> {
  /** Returns the object with the settings used for calls to aggregatedListMachineTypes. */
  public PagedCallSettings<
          AggregatedListMachineTypesHttpRequest,
          MachineTypeAggregatedList,
          AggregatedListMachineTypesPagedResponse>
      aggregatedListMachineTypesSettings() {
    return ((MachineTypeStubSettings) getStubSettings()).aggregatedListMachineTypesSettings();
  }

  /** Returns the object with the settings used for calls to getMachineType. */
  public UnaryCallSettings<GetMachineTypeHttpRequest, MachineType> getMachineTypeSettings() {
    return ((MachineTypeStubSettings) getStubSettings()).getMachineTypeSettings();
  }

  /** Returns the object with the settings used for calls to listMachineTypes. */
  public PagedCallSettings<
          ListMachineTypesHttpRequest, MachineTypeList, ListMachineTypesPagedResponse>
      listMachineTypesSettings() {
    return ((MachineTypeStubSettings) getStubSettings()).listMachineTypesSettings();
  }

  public static final MachineTypeSettings create(MachineTypeStubSettings stub) throws IOException {
    return new MachineTypeSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MachineTypeStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MachineTypeStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return MachineTypeStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MachineTypeStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MachineTypeStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return MachineTypeStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MachineTypeStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MachineTypeStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MachineTypeSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MachineTypeSettings. */
  public static class Builder extends ClientSettings.Builder<MachineTypeSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(MachineTypeStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(MachineTypeStubSettings.newBuilder());
    }

    protected Builder(MachineTypeSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MachineTypeStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public MachineTypeStubSettings.Builder getStubSettingsBuilder() {
      return ((MachineTypeStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListMachineTypes. */
    public PagedCallSettings.Builder<
            AggregatedListMachineTypesHttpRequest,
            MachineTypeAggregatedList,
            AggregatedListMachineTypesPagedResponse>
        aggregatedListMachineTypesSettings() {
      return getStubSettingsBuilder().aggregatedListMachineTypesSettings();
    }

    /** Returns the builder for the settings used for calls to getMachineType. */
    public UnaryCallSettings.Builder<GetMachineTypeHttpRequest, MachineType>
        getMachineTypeSettings() {
      return getStubSettingsBuilder().getMachineTypeSettings();
    }

    /** Returns the builder for the settings used for calls to listMachineTypes. */
    public PagedCallSettings.Builder<
            ListMachineTypesHttpRequest, MachineTypeList, ListMachineTypesPagedResponse>
        listMachineTypesSettings() {
      return getStubSettingsBuilder().listMachineTypesSettings();
    }

    @Override
    public MachineTypeSettings build() throws IOException {
      return new MachineTypeSettings(this);
    }
  }
}
