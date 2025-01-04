/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.LintingServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.apihub.v1.stub.LintingServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LintingServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apihub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getStyleGuide:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LintingServiceSettings.Builder lintingServiceSettingsBuilder =
 *     LintingServiceSettings.newBuilder();
 * lintingServiceSettingsBuilder
 *     .getStyleGuideSettings()
 *     .setRetrySettings(
 *         lintingServiceSettingsBuilder
 *             .getStyleGuideSettings()
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
 * LintingServiceSettings lintingServiceSettings = lintingServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class LintingServiceSettings extends ClientSettings<LintingServiceSettings> {

  /** Returns the object with the settings used for calls to getStyleGuide. */
  public UnaryCallSettings<GetStyleGuideRequest, StyleGuide> getStyleGuideSettings() {
    return ((LintingServiceStubSettings) getStubSettings()).getStyleGuideSettings();
  }

  /** Returns the object with the settings used for calls to updateStyleGuide. */
  public UnaryCallSettings<UpdateStyleGuideRequest, StyleGuide> updateStyleGuideSettings() {
    return ((LintingServiceStubSettings) getStubSettings()).updateStyleGuideSettings();
  }

  /** Returns the object with the settings used for calls to getStyleGuideContents. */
  public UnaryCallSettings<GetStyleGuideContentsRequest, StyleGuideContents>
      getStyleGuideContentsSettings() {
    return ((LintingServiceStubSettings) getStubSettings()).getStyleGuideContentsSettings();
  }

  /** Returns the object with the settings used for calls to lintSpec. */
  public UnaryCallSettings<LintSpecRequest, Empty> lintSpecSettings() {
    return ((LintingServiceStubSettings) getStubSettings()).lintSpecSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((LintingServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((LintingServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final LintingServiceSettings create(LintingServiceStubSettings stub)
      throws IOException {
    return new LintingServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return LintingServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return LintingServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return LintingServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return LintingServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return LintingServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return LintingServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LintingServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected LintingServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for LintingServiceSettings. */
  public static class Builder extends ClientSettings.Builder<LintingServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(LintingServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(LintingServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(LintingServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(LintingServiceStubSettings.newBuilder());
    }

    public LintingServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((LintingServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getStyleGuide. */
    public UnaryCallSettings.Builder<GetStyleGuideRequest, StyleGuide> getStyleGuideSettings() {
      return getStubSettingsBuilder().getStyleGuideSettings();
    }

    /** Returns the builder for the settings used for calls to updateStyleGuide. */
    public UnaryCallSettings.Builder<UpdateStyleGuideRequest, StyleGuide>
        updateStyleGuideSettings() {
      return getStubSettingsBuilder().updateStyleGuideSettings();
    }

    /** Returns the builder for the settings used for calls to getStyleGuideContents. */
    public UnaryCallSettings.Builder<GetStyleGuideContentsRequest, StyleGuideContents>
        getStyleGuideContentsSettings() {
      return getStubSettingsBuilder().getStyleGuideContentsSettings();
    }

    /** Returns the builder for the settings used for calls to lintSpec. */
    public UnaryCallSettings.Builder<LintSpecRequest, Empty> lintSpecSettings() {
      return getStubSettingsBuilder().lintSpecSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public LintingServiceSettings build() throws IOException {
      return new LintingServiceSettings(this);
    }
  }
}
