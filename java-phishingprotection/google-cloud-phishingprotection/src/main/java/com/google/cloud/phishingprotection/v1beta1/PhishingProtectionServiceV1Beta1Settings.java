/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.phishingprotection.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.phishingprotection.v1beta1.stub.PhishingProtectionServiceV1Beta1StubSettings;
import com.google.phishingprotection.v1beta1.ReportPhishingRequest;
import com.google.phishingprotection.v1beta1.ReportPhishingResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PhishingProtectionServiceV1Beta1Client}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (phishingprotection.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of reportPhishing to 30 seconds:
 *
 * <pre>{@code
 * PhishingProtectionServiceV1Beta1Settings.Builder
 *     phishingProtectionServiceV1Beta1SettingsBuilder =
 *         PhishingProtectionServiceV1Beta1Settings.newBuilder();
 * phishingProtectionServiceV1Beta1SettingsBuilder
 *     .reportPhishingSettings()
 *     .setRetrySettings(
 *         phishingProtectionServiceV1Beta1SettingsBuilder
 *             .reportPhishingSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PhishingProtectionServiceV1Beta1Settings phishingProtectionServiceV1Beta1Settings =
 *     phishingProtectionServiceV1Beta1SettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PhishingProtectionServiceV1Beta1Settings
    extends ClientSettings<PhishingProtectionServiceV1Beta1Settings> {

  /** Returns the object with the settings used for calls to reportPhishing. */
  public UnaryCallSettings<ReportPhishingRequest, ReportPhishingResponse> reportPhishingSettings() {
    return ((PhishingProtectionServiceV1Beta1StubSettings) getStubSettings())
        .reportPhishingSettings();
  }

  public static final PhishingProtectionServiceV1Beta1Settings create(
      PhishingProtectionServiceV1Beta1StubSettings stub) throws IOException {
    return new PhishingProtectionServiceV1Beta1Settings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PhishingProtectionServiceV1Beta1StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PhishingProtectionServiceV1Beta1StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PhishingProtectionServiceV1Beta1StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PhishingProtectionServiceV1Beta1StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PhishingProtectionServiceV1Beta1StubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PhishingProtectionServiceV1Beta1StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PhishingProtectionServiceV1Beta1StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PhishingProtectionServiceV1Beta1Settings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PhishingProtectionServiceV1Beta1Settings. */
  public static class Builder
      extends ClientSettings.Builder<PhishingProtectionServiceV1Beta1Settings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PhishingProtectionServiceV1Beta1StubSettings.newBuilder(clientContext));
    }

    protected Builder(PhishingProtectionServiceV1Beta1Settings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PhishingProtectionServiceV1Beta1StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PhishingProtectionServiceV1Beta1StubSettings.newBuilder());
    }

    public PhishingProtectionServiceV1Beta1StubSettings.Builder getStubSettingsBuilder() {
      return ((PhishingProtectionServiceV1Beta1StubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to reportPhishing. */
    public UnaryCallSettings.Builder<ReportPhishingRequest, ReportPhishingResponse>
        reportPhishingSettings() {
      return getStubSettingsBuilder().reportPhishingSettings();
    }

    @Override
    public PhishingProtectionServiceV1Beta1Settings build() throws IOException {
      return new PhishingProtectionServiceV1Beta1Settings(this);
    }
  }
}
