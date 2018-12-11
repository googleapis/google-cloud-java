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

import static com.google.cloud.compute.v1.DiskTypeClient.AggregatedListDiskTypesPagedResponse;
import static com.google.cloud.compute.v1.DiskTypeClient.ListDiskTypesPagedResponse;

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
import com.google.cloud.compute.v1.stub.DiskTypeStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DiskTypeClient}.
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
 * example, to set the total timeout of getDiskType to 30 seconds:
 *
 * <pre>
 * <code>
 * DiskTypeSettings.Builder diskTypeSettingsBuilder =
 *     DiskTypeSettings.newBuilder();
 * diskTypeSettingsBuilder.getDiskTypeSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DiskTypeSettings diskTypeSettings = diskTypeSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class DiskTypeSettings extends ClientSettings<DiskTypeSettings> {
  /** Returns the object with the settings used for calls to aggregatedListDiskTypes. */
  public PagedCallSettings<
          AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList,
          AggregatedListDiskTypesPagedResponse>
      aggregatedListDiskTypesSettings() {
    return ((DiskTypeStubSettings) getStubSettings()).aggregatedListDiskTypesSettings();
  }

  /** Returns the object with the settings used for calls to getDiskType. */
  public UnaryCallSettings<GetDiskTypeHttpRequest, DiskType> getDiskTypeSettings() {
    return ((DiskTypeStubSettings) getStubSettings()).getDiskTypeSettings();
  }

  /** Returns the object with the settings used for calls to listDiskTypes. */
  public PagedCallSettings<ListDiskTypesHttpRequest, DiskTypeList, ListDiskTypesPagedResponse>
      listDiskTypesSettings() {
    return ((DiskTypeStubSettings) getStubSettings()).listDiskTypesSettings();
  }

  public static final DiskTypeSettings create(DiskTypeStubSettings stub) throws IOException {
    return new DiskTypeSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DiskTypeStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DiskTypeStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return DiskTypeStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DiskTypeStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DiskTypeStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DiskTypeStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DiskTypeStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DiskTypeStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DiskTypeSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DiskTypeSettings. */
  public static class Builder extends ClientSettings.Builder<DiskTypeSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(DiskTypeStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(DiskTypeStubSettings.newBuilder());
    }

    protected Builder(DiskTypeSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DiskTypeStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public DiskTypeStubSettings.Builder getStubSettingsBuilder() {
      return ((DiskTypeStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListDiskTypes. */
    public PagedCallSettings.Builder<
            AggregatedListDiskTypesHttpRequest, DiskTypeAggregatedList,
            AggregatedListDiskTypesPagedResponse>
        aggregatedListDiskTypesSettings() {
      return getStubSettingsBuilder().aggregatedListDiskTypesSettings();
    }

    /** Returns the builder for the settings used for calls to getDiskType. */
    public UnaryCallSettings.Builder<GetDiskTypeHttpRequest, DiskType> getDiskTypeSettings() {
      return getStubSettingsBuilder().getDiskTypeSettings();
    }

    /** Returns the builder for the settings used for calls to listDiskTypes. */
    public PagedCallSettings.Builder<
            ListDiskTypesHttpRequest, DiskTypeList, ListDiskTypesPagedResponse>
        listDiskTypesSettings() {
      return getStubSettingsBuilder().listDiskTypesSettings();
    }

    @Override
    public DiskTypeSettings build() throws IOException {
      return new DiskTypeSettings(this);
    }
  }
}
