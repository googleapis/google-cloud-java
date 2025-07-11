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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.ProgrammaticBuyerServiceClient.ListProgrammaticBuyersPagedResponse;

import com.google.ads.admanager.v1.stub.ProgrammaticBuyerServiceStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ProgrammaticBuyerServiceClient}.
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
 * of getProgrammaticBuyer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ProgrammaticBuyerServiceSettings.Builder programmaticBuyerServiceSettingsBuilder =
 *     ProgrammaticBuyerServiceSettings.newBuilder();
 * programmaticBuyerServiceSettingsBuilder
 *     .getProgrammaticBuyerSettings()
 *     .setRetrySettings(
 *         programmaticBuyerServiceSettingsBuilder
 *             .getProgrammaticBuyerSettings()
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
 * ProgrammaticBuyerServiceSettings programmaticBuyerServiceSettings =
 *     programmaticBuyerServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ProgrammaticBuyerServiceSettings
    extends ClientSettings<ProgrammaticBuyerServiceSettings> {

  /** Returns the object with the settings used for calls to getProgrammaticBuyer. */
  public UnaryCallSettings<GetProgrammaticBuyerRequest, ProgrammaticBuyer>
      getProgrammaticBuyerSettings() {
    return ((ProgrammaticBuyerServiceStubSettings) getStubSettings())
        .getProgrammaticBuyerSettings();
  }

  /** Returns the object with the settings used for calls to listProgrammaticBuyers. */
  public PagedCallSettings<
          ListProgrammaticBuyersRequest,
          ListProgrammaticBuyersResponse,
          ListProgrammaticBuyersPagedResponse>
      listProgrammaticBuyersSettings() {
    return ((ProgrammaticBuyerServiceStubSettings) getStubSettings())
        .listProgrammaticBuyersSettings();
  }

  public static final ProgrammaticBuyerServiceSettings create(
      ProgrammaticBuyerServiceStubSettings stub) throws IOException {
    return new ProgrammaticBuyerServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ProgrammaticBuyerServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ProgrammaticBuyerServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ProgrammaticBuyerServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ProgrammaticBuyerServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ProgrammaticBuyerServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ProgrammaticBuyerServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ProgrammaticBuyerServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ProgrammaticBuyerServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ProgrammaticBuyerServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ProgrammaticBuyerServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ProgrammaticBuyerServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ProgrammaticBuyerServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ProgrammaticBuyerServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ProgrammaticBuyerServiceStubSettings.newBuilder());
    }

    public ProgrammaticBuyerServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ProgrammaticBuyerServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getProgrammaticBuyer. */
    public UnaryCallSettings.Builder<GetProgrammaticBuyerRequest, ProgrammaticBuyer>
        getProgrammaticBuyerSettings() {
      return getStubSettingsBuilder().getProgrammaticBuyerSettings();
    }

    /** Returns the builder for the settings used for calls to listProgrammaticBuyers. */
    public PagedCallSettings.Builder<
            ListProgrammaticBuyersRequest,
            ListProgrammaticBuyersResponse,
            ListProgrammaticBuyersPagedResponse>
        listProgrammaticBuyersSettings() {
      return getStubSettingsBuilder().listProgrammaticBuyersSettings();
    }

    @Override
    public ProgrammaticBuyerServiceSettings build() throws IOException {
      return new ProgrammaticBuyerServiceSettings(this);
    }
  }
}
