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

import static com.google.cloud.compute.v1.RegionOperationClient.ListRegionOperationsPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionOperationStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RegionOperationClient}.
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
 * example, to set the total timeout of deleteRegionOperation to 30 seconds:
 *
 * <pre>
 * <code>
 * RegionOperationSettings.Builder regionOperationSettingsBuilder =
 *     RegionOperationSettings.newBuilder();
 * regionOperationSettingsBuilder.deleteRegionOperationSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RegionOperationSettings regionOperationSettings = regionOperationSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RegionOperationSettings extends ClientSettings<RegionOperationSettings> {
  /** Returns the object with the settings used for calls to deleteRegionOperation. */
  public UnaryCallSettings<DeleteRegionOperationHttpRequest, Void> deleteRegionOperationSettings() {
    return ((RegionOperationStubSettings) getStubSettings()).deleteRegionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getRegionOperation. */
  public UnaryCallSettings<GetRegionOperationHttpRequest, Operation> getRegionOperationSettings() {
    return ((RegionOperationStubSettings) getStubSettings()).getRegionOperationSettings();
  }

  /** Returns the object with the settings used for calls to listRegionOperations. */
  public PagedCallSettings<
          ListRegionOperationsHttpRequest, OperationList, ListRegionOperationsPagedResponse>
      listRegionOperationsSettings() {
    return ((RegionOperationStubSettings) getStubSettings()).listRegionOperationsSettings();
  }

  public static final RegionOperationSettings create(RegionOperationStubSettings stub)
      throws IOException {
    return new RegionOperationSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionOperationStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionOperationStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RegionOperationStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionOperationStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionOperationStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionOperationStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionOperationStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionOperationStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionOperationSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionOperationSettings. */
  public static class Builder extends ClientSettings.Builder<RegionOperationSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RegionOperationStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RegionOperationStubSettings.newBuilder());
    }

    protected Builder(RegionOperationSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionOperationStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RegionOperationStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionOperationStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteRegionOperation. */
    public UnaryCallSettings.Builder<DeleteRegionOperationHttpRequest, Void>
        deleteRegionOperationSettings() {
      return getStubSettingsBuilder().deleteRegionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getRegionOperation. */
    public UnaryCallSettings.Builder<GetRegionOperationHttpRequest, Operation>
        getRegionOperationSettings() {
      return getStubSettingsBuilder().getRegionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listRegionOperations. */
    public PagedCallSettings.Builder<
            ListRegionOperationsHttpRequest, OperationList, ListRegionOperationsPagedResponse>
        listRegionOperationsSettings() {
      return getStubSettingsBuilder().listRegionOperationsSettings();
    }

    @Override
    public RegionOperationSettings build() throws IOException {
      return new RegionOperationSettings(this);
    }
  }
}
