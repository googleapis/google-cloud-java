/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.YieldGroupServiceClient.ListYieldGroupsPagedResponse;

import com.google.ads.admanager.v1.stub.YieldGroupServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link YieldGroupServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getYieldGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * YieldGroupServiceSettings.Builder yieldGroupServiceSettingsBuilder =
 *     YieldGroupServiceSettings.newBuilder();
 * yieldGroupServiceSettingsBuilder
 *     .getYieldGroupSettings()
 *     .setRetrySettings(
 *         yieldGroupServiceSettingsBuilder
 *             .getYieldGroupSettings()
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
 * YieldGroupServiceSettings yieldGroupServiceSettings = yieldGroupServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class YieldGroupServiceSettings extends ClientSettings<YieldGroupServiceSettings> {

  /** Returns the object with the settings used for calls to getYieldGroup. */
  public UnaryCallSettings<GetYieldGroupRequest, YieldGroup> getYieldGroupSettings() {
    return ((YieldGroupServiceStubSettings) getStubSettings()).getYieldGroupSettings();
  }

  /** Returns the object with the settings used for calls to listYieldGroups. */
  public PagedCallSettings<
          ListYieldGroupsRequest, ListYieldGroupsResponse, ListYieldGroupsPagedResponse>
      listYieldGroupsSettings() {
    return ((YieldGroupServiceStubSettings) getStubSettings()).listYieldGroupsSettings();
  }

  /** Returns the object with the settings used for calls to createYieldGroup. */
  public UnaryCallSettings<CreateYieldGroupRequest, YieldGroup> createYieldGroupSettings() {
    return ((YieldGroupServiceStubSettings) getStubSettings()).createYieldGroupSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateYieldGroups. */
  public UnaryCallSettings<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
      batchCreateYieldGroupsSettings() {
    return ((YieldGroupServiceStubSettings) getStubSettings()).batchCreateYieldGroupsSettings();
  }

  /** Returns the object with the settings used for calls to updateYieldGroup. */
  public UnaryCallSettings<UpdateYieldGroupRequest, YieldGroup> updateYieldGroupSettings() {
    return ((YieldGroupServiceStubSettings) getStubSettings()).updateYieldGroupSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateYieldGroups. */
  public UnaryCallSettings<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
      batchUpdateYieldGroupsSettings() {
    return ((YieldGroupServiceStubSettings) getStubSettings()).batchUpdateYieldGroupsSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateYieldGroups. */
  public UnaryCallSettings<BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
      batchActivateYieldGroupsSettings() {
    return ((YieldGroupServiceStubSettings) getStubSettings()).batchActivateYieldGroupsSettings();
  }

  /** Returns the object with the settings used for calls to batchDeactivateYieldGroups. */
  public UnaryCallSettings<BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
      batchDeactivateYieldGroupsSettings() {
    return ((YieldGroupServiceStubSettings) getStubSettings()).batchDeactivateYieldGroupsSettings();
  }

  /** Returns the object with the settings used for calls to batchArchiveYieldGroups. */
  public UnaryCallSettings<BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
      batchArchiveYieldGroupsSettings() {
    return ((YieldGroupServiceStubSettings) getStubSettings()).batchArchiveYieldGroupsSettings();
  }

  public static final YieldGroupServiceSettings create(YieldGroupServiceStubSettings stub)
      throws IOException {
    return new YieldGroupServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return YieldGroupServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return YieldGroupServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return YieldGroupServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return YieldGroupServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return YieldGroupServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return YieldGroupServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return YieldGroupServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected YieldGroupServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for YieldGroupServiceSettings. */
  public static class Builder extends ClientSettings.Builder<YieldGroupServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(YieldGroupServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(YieldGroupServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(YieldGroupServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(YieldGroupServiceStubSettings.newBuilder());
    }

    public YieldGroupServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((YieldGroupServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getYieldGroup. */
    public UnaryCallSettings.Builder<GetYieldGroupRequest, YieldGroup> getYieldGroupSettings() {
      return getStubSettingsBuilder().getYieldGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listYieldGroups. */
    public PagedCallSettings.Builder<
            ListYieldGroupsRequest, ListYieldGroupsResponse, ListYieldGroupsPagedResponse>
        listYieldGroupsSettings() {
      return getStubSettingsBuilder().listYieldGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to createYieldGroup. */
    public UnaryCallSettings.Builder<CreateYieldGroupRequest, YieldGroup>
        createYieldGroupSettings() {
      return getStubSettingsBuilder().createYieldGroupSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateYieldGroups. */
    public UnaryCallSettings.Builder<BatchCreateYieldGroupsRequest, BatchCreateYieldGroupsResponse>
        batchCreateYieldGroupsSettings() {
      return getStubSettingsBuilder().batchCreateYieldGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to updateYieldGroup. */
    public UnaryCallSettings.Builder<UpdateYieldGroupRequest, YieldGroup>
        updateYieldGroupSettings() {
      return getStubSettingsBuilder().updateYieldGroupSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateYieldGroups. */
    public UnaryCallSettings.Builder<BatchUpdateYieldGroupsRequest, BatchUpdateYieldGroupsResponse>
        batchUpdateYieldGroupsSettings() {
      return getStubSettingsBuilder().batchUpdateYieldGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivateYieldGroups. */
    public UnaryCallSettings.Builder<
            BatchActivateYieldGroupsRequest, BatchActivateYieldGroupsResponse>
        batchActivateYieldGroupsSettings() {
      return getStubSettingsBuilder().batchActivateYieldGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeactivateYieldGroups. */
    public UnaryCallSettings.Builder<
            BatchDeactivateYieldGroupsRequest, BatchDeactivateYieldGroupsResponse>
        batchDeactivateYieldGroupsSettings() {
      return getStubSettingsBuilder().batchDeactivateYieldGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchiveYieldGroups. */
    public UnaryCallSettings.Builder<
            BatchArchiveYieldGroupsRequest, BatchArchiveYieldGroupsResponse>
        batchArchiveYieldGroupsSettings() {
      return getStubSettingsBuilder().batchArchiveYieldGroupsSettings();
    }

    @Override
    public YieldGroupServiceSettings build() throws IOException {
      return new YieldGroupServiceSettings(this);
    }
  }
}
