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

import static com.google.ads.admanager.v1.DaiAuthenticationKeyServiceClient.ListDaiAuthenticationKeysPagedResponse;

import com.google.ads.admanager.v1.stub.DaiAuthenticationKeyServiceStubSettings;
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
 * Settings class to configure an instance of {@link DaiAuthenticationKeyServiceClient}.
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
 * of getDaiAuthenticationKey:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DaiAuthenticationKeyServiceSettings.Builder daiAuthenticationKeyServiceSettingsBuilder =
 *     DaiAuthenticationKeyServiceSettings.newBuilder();
 * daiAuthenticationKeyServiceSettingsBuilder
 *     .getDaiAuthenticationKeySettings()
 *     .setRetrySettings(
 *         daiAuthenticationKeyServiceSettingsBuilder
 *             .getDaiAuthenticationKeySettings()
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
 * DaiAuthenticationKeyServiceSettings daiAuthenticationKeyServiceSettings =
 *     daiAuthenticationKeyServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DaiAuthenticationKeyServiceSettings
    extends ClientSettings<DaiAuthenticationKeyServiceSettings> {

  /** Returns the object with the settings used for calls to getDaiAuthenticationKey. */
  public UnaryCallSettings<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      getDaiAuthenticationKeySettings() {
    return ((DaiAuthenticationKeyServiceStubSettings) getStubSettings())
        .getDaiAuthenticationKeySettings();
  }

  /** Returns the object with the settings used for calls to listDaiAuthenticationKeys. */
  public PagedCallSettings<
          ListDaiAuthenticationKeysRequest,
          ListDaiAuthenticationKeysResponse,
          ListDaiAuthenticationKeysPagedResponse>
      listDaiAuthenticationKeysSettings() {
    return ((DaiAuthenticationKeyServiceStubSettings) getStubSettings())
        .listDaiAuthenticationKeysSettings();
  }

  /** Returns the object with the settings used for calls to createDaiAuthenticationKey. */
  public UnaryCallSettings<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      createDaiAuthenticationKeySettings() {
    return ((DaiAuthenticationKeyServiceStubSettings) getStubSettings())
        .createDaiAuthenticationKeySettings();
  }

  /** Returns the object with the settings used for calls to batchCreateDaiAuthenticationKeys. */
  public UnaryCallSettings<
          BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
      batchCreateDaiAuthenticationKeysSettings() {
    return ((DaiAuthenticationKeyServiceStubSettings) getStubSettings())
        .batchCreateDaiAuthenticationKeysSettings();
  }

  /** Returns the object with the settings used for calls to updateDaiAuthenticationKey. */
  public UnaryCallSettings<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
      updateDaiAuthenticationKeySettings() {
    return ((DaiAuthenticationKeyServiceStubSettings) getStubSettings())
        .updateDaiAuthenticationKeySettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateDaiAuthenticationKeys. */
  public UnaryCallSettings<
          BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
      batchUpdateDaiAuthenticationKeysSettings() {
    return ((DaiAuthenticationKeyServiceStubSettings) getStubSettings())
        .batchUpdateDaiAuthenticationKeysSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateDaiAuthenticationKeys. */
  public UnaryCallSettings<
          BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
      batchActivateDaiAuthenticationKeysSettings() {
    return ((DaiAuthenticationKeyServiceStubSettings) getStubSettings())
        .batchActivateDaiAuthenticationKeysSettings();
  }

  /**
   * Returns the object with the settings used for calls to batchDeactivateDaiAuthenticationKeys.
   */
  public UnaryCallSettings<
          BatchDeactivateDaiAuthenticationKeysRequest, BatchDeactivateDaiAuthenticationKeysResponse>
      batchDeactivateDaiAuthenticationKeysSettings() {
    return ((DaiAuthenticationKeyServiceStubSettings) getStubSettings())
        .batchDeactivateDaiAuthenticationKeysSettings();
  }

  public static final DaiAuthenticationKeyServiceSettings create(
      DaiAuthenticationKeyServiceStubSettings stub) throws IOException {
    return new DaiAuthenticationKeyServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DaiAuthenticationKeyServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DaiAuthenticationKeyServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DaiAuthenticationKeyServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DaiAuthenticationKeyServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DaiAuthenticationKeyServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DaiAuthenticationKeyServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DaiAuthenticationKeyServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DaiAuthenticationKeyServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DaiAuthenticationKeyServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DaiAuthenticationKeyServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(DaiAuthenticationKeyServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DaiAuthenticationKeyServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DaiAuthenticationKeyServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DaiAuthenticationKeyServiceStubSettings.newBuilder());
    }

    public DaiAuthenticationKeyServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DaiAuthenticationKeyServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getDaiAuthenticationKey. */
    public UnaryCallSettings.Builder<GetDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        getDaiAuthenticationKeySettings() {
      return getStubSettingsBuilder().getDaiAuthenticationKeySettings();
    }

    /** Returns the builder for the settings used for calls to listDaiAuthenticationKeys. */
    public PagedCallSettings.Builder<
            ListDaiAuthenticationKeysRequest,
            ListDaiAuthenticationKeysResponse,
            ListDaiAuthenticationKeysPagedResponse>
        listDaiAuthenticationKeysSettings() {
      return getStubSettingsBuilder().listDaiAuthenticationKeysSettings();
    }

    /** Returns the builder for the settings used for calls to createDaiAuthenticationKey. */
    public UnaryCallSettings.Builder<CreateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        createDaiAuthenticationKeySettings() {
      return getStubSettingsBuilder().createDaiAuthenticationKeySettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateDaiAuthenticationKeys. */
    public UnaryCallSettings.Builder<
            BatchCreateDaiAuthenticationKeysRequest, BatchCreateDaiAuthenticationKeysResponse>
        batchCreateDaiAuthenticationKeysSettings() {
      return getStubSettingsBuilder().batchCreateDaiAuthenticationKeysSettings();
    }

    /** Returns the builder for the settings used for calls to updateDaiAuthenticationKey. */
    public UnaryCallSettings.Builder<UpdateDaiAuthenticationKeyRequest, DaiAuthenticationKey>
        updateDaiAuthenticationKeySettings() {
      return getStubSettingsBuilder().updateDaiAuthenticationKeySettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateDaiAuthenticationKeys. */
    public UnaryCallSettings.Builder<
            BatchUpdateDaiAuthenticationKeysRequest, BatchUpdateDaiAuthenticationKeysResponse>
        batchUpdateDaiAuthenticationKeysSettings() {
      return getStubSettingsBuilder().batchUpdateDaiAuthenticationKeysSettings();
    }

    /**
     * Returns the builder for the settings used for calls to batchActivateDaiAuthenticationKeys.
     */
    public UnaryCallSettings.Builder<
            BatchActivateDaiAuthenticationKeysRequest, BatchActivateDaiAuthenticationKeysResponse>
        batchActivateDaiAuthenticationKeysSettings() {
      return getStubSettingsBuilder().batchActivateDaiAuthenticationKeysSettings();
    }

    /**
     * Returns the builder for the settings used for calls to batchDeactivateDaiAuthenticationKeys.
     */
    public UnaryCallSettings.Builder<
            BatchDeactivateDaiAuthenticationKeysRequest,
            BatchDeactivateDaiAuthenticationKeysResponse>
        batchDeactivateDaiAuthenticationKeysSettings() {
      return getStubSettingsBuilder().batchDeactivateDaiAuthenticationKeysSettings();
    }

    @Override
    public DaiAuthenticationKeyServiceSettings build() throws IOException {
      return new DaiAuthenticationKeyServiceSettings(this);
    }
  }
}
