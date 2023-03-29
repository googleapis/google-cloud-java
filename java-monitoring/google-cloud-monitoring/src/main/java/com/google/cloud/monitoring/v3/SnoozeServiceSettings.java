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

package com.google.cloud.monitoring.v3;

import static com.google.cloud.monitoring.v3.SnoozeServiceClient.ListSnoozesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.monitoring.v3.stub.SnoozeServiceStubSettings;
import com.google.monitoring.v3.CreateSnoozeRequest;
import com.google.monitoring.v3.GetSnoozeRequest;
import com.google.monitoring.v3.ListSnoozesRequest;
import com.google.monitoring.v3.ListSnoozesResponse;
import com.google.monitoring.v3.Snooze;
import com.google.monitoring.v3.UpdateSnoozeRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SnoozeServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (monitoring.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createSnooze to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SnoozeServiceSettings.Builder snoozeServiceSettingsBuilder = SnoozeServiceSettings.newBuilder();
 * snoozeServiceSettingsBuilder
 *     .createSnoozeSettings()
 *     .setRetrySettings(
 *         snoozeServiceSettingsBuilder
 *             .createSnoozeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SnoozeServiceSettings snoozeServiceSettings = snoozeServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SnoozeServiceSettings extends ClientSettings<SnoozeServiceSettings> {

  /** Returns the object with the settings used for calls to createSnooze. */
  public UnaryCallSettings<CreateSnoozeRequest, Snooze> createSnoozeSettings() {
    return ((SnoozeServiceStubSettings) getStubSettings()).createSnoozeSettings();
  }

  /** Returns the object with the settings used for calls to listSnoozes. */
  public PagedCallSettings<ListSnoozesRequest, ListSnoozesResponse, ListSnoozesPagedResponse>
      listSnoozesSettings() {
    return ((SnoozeServiceStubSettings) getStubSettings()).listSnoozesSettings();
  }

  /** Returns the object with the settings used for calls to getSnooze. */
  public UnaryCallSettings<GetSnoozeRequest, Snooze> getSnoozeSettings() {
    return ((SnoozeServiceStubSettings) getStubSettings()).getSnoozeSettings();
  }

  /** Returns the object with the settings used for calls to updateSnooze. */
  public UnaryCallSettings<UpdateSnoozeRequest, Snooze> updateSnoozeSettings() {
    return ((SnoozeServiceStubSettings) getStubSettings()).updateSnoozeSettings();
  }

  public static final SnoozeServiceSettings create(SnoozeServiceStubSettings stub)
      throws IOException {
    return new SnoozeServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SnoozeServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SnoozeServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SnoozeServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SnoozeServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SnoozeServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SnoozeServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SnoozeServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SnoozeServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SnoozeServiceSettings. */
  public static class Builder extends ClientSettings.Builder<SnoozeServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SnoozeServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SnoozeServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SnoozeServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SnoozeServiceStubSettings.newBuilder());
    }

    public SnoozeServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SnoozeServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSnooze. */
    public UnaryCallSettings.Builder<CreateSnoozeRequest, Snooze> createSnoozeSettings() {
      return getStubSettingsBuilder().createSnoozeSettings();
    }

    /** Returns the builder for the settings used for calls to listSnoozes. */
    public PagedCallSettings.Builder<
            ListSnoozesRequest, ListSnoozesResponse, ListSnoozesPagedResponse>
        listSnoozesSettings() {
      return getStubSettingsBuilder().listSnoozesSettings();
    }

    /** Returns the builder for the settings used for calls to getSnooze. */
    public UnaryCallSettings.Builder<GetSnoozeRequest, Snooze> getSnoozeSettings() {
      return getStubSettingsBuilder().getSnoozeSettings();
    }

    /** Returns the builder for the settings used for calls to updateSnooze. */
    public UnaryCallSettings.Builder<UpdateSnoozeRequest, Snooze> updateSnoozeSettings() {
      return getStubSettingsBuilder().updateSnoozeSettings();
    }

    @Override
    public SnoozeServiceSettings build() throws IOException {
      return new SnoozeServiceSettings(this);
    }
  }
}
