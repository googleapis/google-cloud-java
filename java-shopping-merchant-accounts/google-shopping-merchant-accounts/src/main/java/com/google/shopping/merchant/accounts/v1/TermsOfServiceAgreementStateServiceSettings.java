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

package com.google.shopping.merchant.accounts.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.shopping.merchant.accounts.v1.stub.TermsOfServiceAgreementStateServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TermsOfServiceAgreementStateServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (merchantapi.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getTermsOfServiceAgreementState:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TermsOfServiceAgreementStateServiceSettings.Builder
 *     termsOfServiceAgreementStateServiceSettingsBuilder =
 *         TermsOfServiceAgreementStateServiceSettings.newBuilder();
 * termsOfServiceAgreementStateServiceSettingsBuilder
 *     .getTermsOfServiceAgreementStateSettings()
 *     .setRetrySettings(
 *         termsOfServiceAgreementStateServiceSettingsBuilder
 *             .getTermsOfServiceAgreementStateSettings()
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
 * TermsOfServiceAgreementStateServiceSettings termsOfServiceAgreementStateServiceSettings =
 *     termsOfServiceAgreementStateServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class TermsOfServiceAgreementStateServiceSettings
    extends ClientSettings<TermsOfServiceAgreementStateServiceSettings> {

  /** Returns the object with the settings used for calls to getTermsOfServiceAgreementState. */
  public UnaryCallSettings<GetTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      getTermsOfServiceAgreementStateSettings() {
    return ((TermsOfServiceAgreementStateServiceStubSettings) getStubSettings())
        .getTermsOfServiceAgreementStateSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * retrieveForApplicationTermsOfServiceAgreementState.
   */
  public UnaryCallSettings<
          RetrieveForApplicationTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
      retrieveForApplicationTermsOfServiceAgreementStateSettings() {
    return ((TermsOfServiceAgreementStateServiceStubSettings) getStubSettings())
        .retrieveForApplicationTermsOfServiceAgreementStateSettings();
  }

  public static final TermsOfServiceAgreementStateServiceSettings create(
      TermsOfServiceAgreementStateServiceStubSettings stub) throws IOException {
    return new TermsOfServiceAgreementStateServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TermsOfServiceAgreementStateServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TermsOfServiceAgreementStateServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TermsOfServiceAgreementStateServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TermsOfServiceAgreementStateServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TermsOfServiceAgreementStateServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return TermsOfServiceAgreementStateServiceStubSettings
        .defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TermsOfServiceAgreementStateServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TermsOfServiceAgreementStateServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected TermsOfServiceAgreementStateServiceSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TermsOfServiceAgreementStateServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<TermsOfServiceAgreementStateServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TermsOfServiceAgreementStateServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(TermsOfServiceAgreementStateServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TermsOfServiceAgreementStateServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TermsOfServiceAgreementStateServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(TermsOfServiceAgreementStateServiceStubSettings.newHttpJsonBuilder());
    }

    public TermsOfServiceAgreementStateServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((TermsOfServiceAgreementStateServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getTermsOfServiceAgreementState. */
    public UnaryCallSettings.Builder<
            GetTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
        getTermsOfServiceAgreementStateSettings() {
      return getStubSettingsBuilder().getTermsOfServiceAgreementStateSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * retrieveForApplicationTermsOfServiceAgreementState.
     */
    public UnaryCallSettings.Builder<
            RetrieveForApplicationTermsOfServiceAgreementStateRequest, TermsOfServiceAgreementState>
        retrieveForApplicationTermsOfServiceAgreementStateSettings() {
      return getStubSettingsBuilder().retrieveForApplicationTermsOfServiceAgreementStateSettings();
    }

    @Override
    public TermsOfServiceAgreementStateServiceSettings build() throws IOException {
      return new TermsOfServiceAgreementStateServiceSettings(this);
    }
  }
}
