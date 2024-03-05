/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.cloudcontrolspartner.v1;

import static com.google.cloud.cloudcontrolspartner.v1.CloudControlsPartnerMonitoringClient.ListViolationsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.cloudcontrolspartner.v1.stub.CloudControlsPartnerMonitoringStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudControlsPartnerMonitoringClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudcontrolspartner.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getViolation to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudControlsPartnerMonitoringSettings.Builder cloudControlsPartnerMonitoringSettingsBuilder =
 *     CloudControlsPartnerMonitoringSettings.newBuilder();
 * cloudControlsPartnerMonitoringSettingsBuilder
 *     .getViolationSettings()
 *     .setRetrySettings(
 *         cloudControlsPartnerMonitoringSettingsBuilder
 *             .getViolationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudControlsPartnerMonitoringSettings cloudControlsPartnerMonitoringSettings =
 *     cloudControlsPartnerMonitoringSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudControlsPartnerMonitoringSettings
    extends ClientSettings<CloudControlsPartnerMonitoringSettings> {

  /** Returns the object with the settings used for calls to listViolations. */
  public PagedCallSettings<
          ListViolationsRequest, ListViolationsResponse, ListViolationsPagedResponse>
      listViolationsSettings() {
    return ((CloudControlsPartnerMonitoringStubSettings) getStubSettings())
        .listViolationsSettings();
  }

  /** Returns the object with the settings used for calls to getViolation. */
  public UnaryCallSettings<GetViolationRequest, Violation> getViolationSettings() {
    return ((CloudControlsPartnerMonitoringStubSettings) getStubSettings()).getViolationSettings();
  }

  public static final CloudControlsPartnerMonitoringSettings create(
      CloudControlsPartnerMonitoringStubSettings stub) throws IOException {
    return new CloudControlsPartnerMonitoringSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudControlsPartnerMonitoringStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudControlsPartnerMonitoringStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudControlsPartnerMonitoringStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudControlsPartnerMonitoringStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudControlsPartnerMonitoringStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudControlsPartnerMonitoringStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudControlsPartnerMonitoringStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudControlsPartnerMonitoringStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudControlsPartnerMonitoringSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudControlsPartnerMonitoringSettings. */
  public static class Builder
      extends ClientSettings.Builder<CloudControlsPartnerMonitoringSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudControlsPartnerMonitoringStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudControlsPartnerMonitoringSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudControlsPartnerMonitoringStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudControlsPartnerMonitoringStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(CloudControlsPartnerMonitoringStubSettings.newHttpJsonBuilder());
    }

    public CloudControlsPartnerMonitoringStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudControlsPartnerMonitoringStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listViolations. */
    public PagedCallSettings.Builder<
            ListViolationsRequest, ListViolationsResponse, ListViolationsPagedResponse>
        listViolationsSettings() {
      return getStubSettingsBuilder().listViolationsSettings();
    }

    /** Returns the builder for the settings used for calls to getViolation. */
    public UnaryCallSettings.Builder<GetViolationRequest, Violation> getViolationSettings() {
      return getStubSettingsBuilder().getViolationSettings();
    }

    @Override
    public CloudControlsPartnerMonitoringSettings build() throws IOException {
      return new CloudControlsPartnerMonitoringSettings(this);
    }
  }
}
