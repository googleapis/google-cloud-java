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

package com.google.cloud.recommendationengine.v1beta1;

import static com.google.cloud.recommendationengine.v1beta1.PredictionApiKeyRegistryClient.ListPredictionApiKeyRegistrationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.recommendationengine.v1beta1.stub.PredictionApiKeyRegistryStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PredictionApiKeyRegistryClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (recommendationengine.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createPredictionApiKeyRegistration to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PredictionApiKeyRegistrySettings.Builder predictionApiKeyRegistrySettingsBuilder =
 *     PredictionApiKeyRegistrySettings.newBuilder();
 * predictionApiKeyRegistrySettingsBuilder
 *     .createPredictionApiKeyRegistrationSettings()
 *     .setRetrySettings(
 *         predictionApiKeyRegistrySettingsBuilder
 *             .createPredictionApiKeyRegistrationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PredictionApiKeyRegistrySettings predictionApiKeyRegistrySettings =
 *     predictionApiKeyRegistrySettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PredictionApiKeyRegistrySettings
    extends ClientSettings<PredictionApiKeyRegistrySettings> {

  /** Returns the object with the settings used for calls to createPredictionApiKeyRegistration. */
  public UnaryCallSettings<CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
      createPredictionApiKeyRegistrationSettings() {
    return ((PredictionApiKeyRegistryStubSettings) getStubSettings())
        .createPredictionApiKeyRegistrationSettings();
  }

  /** Returns the object with the settings used for calls to listPredictionApiKeyRegistrations. */
  public PagedCallSettings<
          ListPredictionApiKeyRegistrationsRequest,
          ListPredictionApiKeyRegistrationsResponse,
          ListPredictionApiKeyRegistrationsPagedResponse>
      listPredictionApiKeyRegistrationsSettings() {
    return ((PredictionApiKeyRegistryStubSettings) getStubSettings())
        .listPredictionApiKeyRegistrationsSettings();
  }

  /** Returns the object with the settings used for calls to deletePredictionApiKeyRegistration. */
  public UnaryCallSettings<DeletePredictionApiKeyRegistrationRequest, Empty>
      deletePredictionApiKeyRegistrationSettings() {
    return ((PredictionApiKeyRegistryStubSettings) getStubSettings())
        .deletePredictionApiKeyRegistrationSettings();
  }

  public static final PredictionApiKeyRegistrySettings create(
      PredictionApiKeyRegistryStubSettings stub) throws IOException {
    return new PredictionApiKeyRegistrySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PredictionApiKeyRegistryStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PredictionApiKeyRegistryStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PredictionApiKeyRegistryStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PredictionApiKeyRegistryStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PredictionApiKeyRegistryStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PredictionApiKeyRegistryStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PredictionApiKeyRegistryStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PredictionApiKeyRegistryStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected PredictionApiKeyRegistrySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PredictionApiKeyRegistrySettings. */
  public static class Builder
      extends ClientSettings.Builder<PredictionApiKeyRegistrySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PredictionApiKeyRegistryStubSettings.newBuilder(clientContext));
    }

    protected Builder(PredictionApiKeyRegistrySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PredictionApiKeyRegistryStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PredictionApiKeyRegistryStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(PredictionApiKeyRegistryStubSettings.newHttpJsonBuilder());
    }

    public PredictionApiKeyRegistryStubSettings.Builder getStubSettingsBuilder() {
      return ((PredictionApiKeyRegistryStubSettings.Builder) getStubSettings());
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

    /**
     * Returns the builder for the settings used for calls to createPredictionApiKeyRegistration.
     */
    public UnaryCallSettings.Builder<
            CreatePredictionApiKeyRegistrationRequest, PredictionApiKeyRegistration>
        createPredictionApiKeyRegistrationSettings() {
      return getStubSettingsBuilder().createPredictionApiKeyRegistrationSettings();
    }

    /** Returns the builder for the settings used for calls to listPredictionApiKeyRegistrations. */
    public PagedCallSettings.Builder<
            ListPredictionApiKeyRegistrationsRequest,
            ListPredictionApiKeyRegistrationsResponse,
            ListPredictionApiKeyRegistrationsPagedResponse>
        listPredictionApiKeyRegistrationsSettings() {
      return getStubSettingsBuilder().listPredictionApiKeyRegistrationsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deletePredictionApiKeyRegistration.
     */
    public UnaryCallSettings.Builder<DeletePredictionApiKeyRegistrationRequest, Empty>
        deletePredictionApiKeyRegistrationSettings() {
      return getStubSettingsBuilder().deletePredictionApiKeyRegistrationSettings();
    }

    @Override
    public PredictionApiKeyRegistrySettings build() throws IOException {
      return new PredictionApiKeyRegistrySettings(this);
    }
  }
}
