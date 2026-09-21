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

import static com.google.ads.admanager.v1.DaiEncodingProfileServiceClient.ListDaiEncodingProfilesPagedResponse;

import com.google.ads.admanager.v1.stub.DaiEncodingProfileServiceStubSettings;
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
 * Settings class to configure an instance of {@link DaiEncodingProfileServiceClient}.
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
 * of getDaiEncodingProfile:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DaiEncodingProfileServiceSettings.Builder daiEncodingProfileServiceSettingsBuilder =
 *     DaiEncodingProfileServiceSettings.newBuilder();
 * daiEncodingProfileServiceSettingsBuilder
 *     .getDaiEncodingProfileSettings()
 *     .setRetrySettings(
 *         daiEncodingProfileServiceSettingsBuilder
 *             .getDaiEncodingProfileSettings()
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
 * DaiEncodingProfileServiceSettings daiEncodingProfileServiceSettings =
 *     daiEncodingProfileServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class DaiEncodingProfileServiceSettings
    extends ClientSettings<DaiEncodingProfileServiceSettings> {

  /** Returns the object with the settings used for calls to getDaiEncodingProfile. */
  public UnaryCallSettings<GetDaiEncodingProfileRequest, DaiEncodingProfile>
      getDaiEncodingProfileSettings() {
    return ((DaiEncodingProfileServiceStubSettings) getStubSettings())
        .getDaiEncodingProfileSettings();
  }

  /** Returns the object with the settings used for calls to listDaiEncodingProfiles. */
  public PagedCallSettings<
          ListDaiEncodingProfilesRequest,
          ListDaiEncodingProfilesResponse,
          ListDaiEncodingProfilesPagedResponse>
      listDaiEncodingProfilesSettings() {
    return ((DaiEncodingProfileServiceStubSettings) getStubSettings())
        .listDaiEncodingProfilesSettings();
  }

  /** Returns the object with the settings used for calls to createDaiEncodingProfile. */
  public UnaryCallSettings<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
      createDaiEncodingProfileSettings() {
    return ((DaiEncodingProfileServiceStubSettings) getStubSettings())
        .createDaiEncodingProfileSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateDaiEncodingProfiles. */
  public UnaryCallSettings<
          BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
      batchCreateDaiEncodingProfilesSettings() {
    return ((DaiEncodingProfileServiceStubSettings) getStubSettings())
        .batchCreateDaiEncodingProfilesSettings();
  }

  /** Returns the object with the settings used for calls to updateDaiEncodingProfile. */
  public UnaryCallSettings<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
      updateDaiEncodingProfileSettings() {
    return ((DaiEncodingProfileServiceStubSettings) getStubSettings())
        .updateDaiEncodingProfileSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateDaiEncodingProfiles. */
  public UnaryCallSettings<
          BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
      batchUpdateDaiEncodingProfilesSettings() {
    return ((DaiEncodingProfileServiceStubSettings) getStubSettings())
        .batchUpdateDaiEncodingProfilesSettings();
  }

  /** Returns the object with the settings used for calls to batchActivateDaiEncodingProfiles. */
  public UnaryCallSettings<
          BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
      batchActivateDaiEncodingProfilesSettings() {
    return ((DaiEncodingProfileServiceStubSettings) getStubSettings())
        .batchActivateDaiEncodingProfilesSettings();
  }

  /** Returns the object with the settings used for calls to batchArchiveDaiEncodingProfiles. */
  public UnaryCallSettings<
          BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
      batchArchiveDaiEncodingProfilesSettings() {
    return ((DaiEncodingProfileServiceStubSettings) getStubSettings())
        .batchArchiveDaiEncodingProfilesSettings();
  }

  public static final DaiEncodingProfileServiceSettings create(
      DaiEncodingProfileServiceStubSettings stub) throws IOException {
    return new DaiEncodingProfileServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DaiEncodingProfileServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DaiEncodingProfileServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DaiEncodingProfileServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DaiEncodingProfileServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DaiEncodingProfileServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DaiEncodingProfileServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DaiEncodingProfileServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DaiEncodingProfileServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DaiEncodingProfileServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DaiEncodingProfileServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(DaiEncodingProfileServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DaiEncodingProfileServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DaiEncodingProfileServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DaiEncodingProfileServiceStubSettings.newBuilder());
    }

    public DaiEncodingProfileServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DaiEncodingProfileServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getDaiEncodingProfile. */
    public UnaryCallSettings.Builder<GetDaiEncodingProfileRequest, DaiEncodingProfile>
        getDaiEncodingProfileSettings() {
      return getStubSettingsBuilder().getDaiEncodingProfileSettings();
    }

    /** Returns the builder for the settings used for calls to listDaiEncodingProfiles. */
    public PagedCallSettings.Builder<
            ListDaiEncodingProfilesRequest,
            ListDaiEncodingProfilesResponse,
            ListDaiEncodingProfilesPagedResponse>
        listDaiEncodingProfilesSettings() {
      return getStubSettingsBuilder().listDaiEncodingProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to createDaiEncodingProfile. */
    public UnaryCallSettings.Builder<CreateDaiEncodingProfileRequest, DaiEncodingProfile>
        createDaiEncodingProfileSettings() {
      return getStubSettingsBuilder().createDaiEncodingProfileSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateDaiEncodingProfiles. */
    public UnaryCallSettings.Builder<
            BatchCreateDaiEncodingProfilesRequest, BatchCreateDaiEncodingProfilesResponse>
        batchCreateDaiEncodingProfilesSettings() {
      return getStubSettingsBuilder().batchCreateDaiEncodingProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to updateDaiEncodingProfile. */
    public UnaryCallSettings.Builder<UpdateDaiEncodingProfileRequest, DaiEncodingProfile>
        updateDaiEncodingProfileSettings() {
      return getStubSettingsBuilder().updateDaiEncodingProfileSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateDaiEncodingProfiles. */
    public UnaryCallSettings.Builder<
            BatchUpdateDaiEncodingProfilesRequest, BatchUpdateDaiEncodingProfilesResponse>
        batchUpdateDaiEncodingProfilesSettings() {
      return getStubSettingsBuilder().batchUpdateDaiEncodingProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to batchActivateDaiEncodingProfiles. */
    public UnaryCallSettings.Builder<
            BatchActivateDaiEncodingProfilesRequest, BatchActivateDaiEncodingProfilesResponse>
        batchActivateDaiEncodingProfilesSettings() {
      return getStubSettingsBuilder().batchActivateDaiEncodingProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchiveDaiEncodingProfiles. */
    public UnaryCallSettings.Builder<
            BatchArchiveDaiEncodingProfilesRequest, BatchArchiveDaiEncodingProfilesResponse>
        batchArchiveDaiEncodingProfilesSettings() {
      return getStubSettingsBuilder().batchArchiveDaiEncodingProfilesSettings();
    }

    @Override
    public DaiEncodingProfileServiceSettings build() throws IOException {
      return new DaiEncodingProfileServiceSettings(this);
    }
  }
}
