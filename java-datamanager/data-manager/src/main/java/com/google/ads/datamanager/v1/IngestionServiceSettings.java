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

package com.google.ads.datamanager.v1;

import com.google.ads.datamanager.v1.stub.IngestionServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link IngestionServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datamanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of ingestAudienceMembers:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IngestionServiceSettings.Builder ingestionServiceSettingsBuilder =
 *     IngestionServiceSettings.newBuilder();
 * ingestionServiceSettingsBuilder
 *     .ingestAudienceMembersSettings()
 *     .setRetrySettings(
 *         ingestionServiceSettingsBuilder
 *             .ingestAudienceMembersSettings()
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
 * IngestionServiceSettings ingestionServiceSettings = ingestionServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class IngestionServiceSettings extends ClientSettings<IngestionServiceSettings> {

  /** Returns the object with the settings used for calls to ingestAudienceMembers. */
  public UnaryCallSettings<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
      ingestAudienceMembersSettings() {
    return ((IngestionServiceStubSettings) getStubSettings()).ingestAudienceMembersSettings();
  }

  /** Returns the object with the settings used for calls to removeAudienceMembers. */
  public UnaryCallSettings<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
      removeAudienceMembersSettings() {
    return ((IngestionServiceStubSettings) getStubSettings()).removeAudienceMembersSettings();
  }

  /** Returns the object with the settings used for calls to ingestEvents. */
  public UnaryCallSettings<IngestEventsRequest, IngestEventsResponse> ingestEventsSettings() {
    return ((IngestionServiceStubSettings) getStubSettings()).ingestEventsSettings();
  }

  /** Returns the object with the settings used for calls to retrieveRequestStatus. */
  public UnaryCallSettings<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
      retrieveRequestStatusSettings() {
    return ((IngestionServiceStubSettings) getStubSettings()).retrieveRequestStatusSettings();
  }

  public static final IngestionServiceSettings create(IngestionServiceStubSettings stub)
      throws IOException {
    return new IngestionServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return IngestionServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return IngestionServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return IngestionServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return IngestionServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return IngestionServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return IngestionServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return IngestionServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return IngestionServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected IngestionServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for IngestionServiceSettings. */
  public static class Builder extends ClientSettings.Builder<IngestionServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(IngestionServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(IngestionServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(IngestionServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(IngestionServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(IngestionServiceStubSettings.newHttpJsonBuilder());
    }

    public IngestionServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((IngestionServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to ingestAudienceMembers. */
    public UnaryCallSettings.Builder<IngestAudienceMembersRequest, IngestAudienceMembersResponse>
        ingestAudienceMembersSettings() {
      return getStubSettingsBuilder().ingestAudienceMembersSettings();
    }

    /** Returns the builder for the settings used for calls to removeAudienceMembers. */
    public UnaryCallSettings.Builder<RemoveAudienceMembersRequest, RemoveAudienceMembersResponse>
        removeAudienceMembersSettings() {
      return getStubSettingsBuilder().removeAudienceMembersSettings();
    }

    /** Returns the builder for the settings used for calls to ingestEvents. */
    public UnaryCallSettings.Builder<IngestEventsRequest, IngestEventsResponse>
        ingestEventsSettings() {
      return getStubSettingsBuilder().ingestEventsSettings();
    }

    /** Returns the builder for the settings used for calls to retrieveRequestStatus. */
    public UnaryCallSettings.Builder<RetrieveRequestStatusRequest, RetrieveRequestStatusResponse>
        retrieveRequestStatusSettings() {
      return getStubSettingsBuilder().retrieveRequestStatusSettings();
    }

    @Override
    public IngestionServiceSettings build() throws IOException {
      return new IngestionServiceSettings(this);
    }
  }
}
