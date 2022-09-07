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

import static com.google.cloud.monitoring.v3.AlertPolicyServiceClient.ListAlertPoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.monitoring.v3.stub.AlertPolicyServiceStubSettings;
import com.google.monitoring.v3.AlertPolicy;
import com.google.monitoring.v3.CreateAlertPolicyRequest;
import com.google.monitoring.v3.DeleteAlertPolicyRequest;
import com.google.monitoring.v3.GetAlertPolicyRequest;
import com.google.monitoring.v3.ListAlertPoliciesRequest;
import com.google.monitoring.v3.ListAlertPoliciesResponse;
import com.google.monitoring.v3.UpdateAlertPolicyRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AlertPolicyServiceClient}.
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
 * <p>For example, to set the total timeout of getAlertPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AlertPolicyServiceSettings.Builder alertPolicyServiceSettingsBuilder =
 *     AlertPolicyServiceSettings.newBuilder();
 * alertPolicyServiceSettingsBuilder
 *     .getAlertPolicySettings()
 *     .setRetrySettings(
 *         alertPolicyServiceSettingsBuilder
 *             .getAlertPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AlertPolicyServiceSettings alertPolicyServiceSettings =
 *     alertPolicyServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AlertPolicyServiceSettings extends ClientSettings<AlertPolicyServiceSettings> {

  /** Returns the object with the settings used for calls to listAlertPolicies. */
  public PagedCallSettings<
          ListAlertPoliciesRequest, ListAlertPoliciesResponse, ListAlertPoliciesPagedResponse>
      listAlertPoliciesSettings() {
    return ((AlertPolicyServiceStubSettings) getStubSettings()).listAlertPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getAlertPolicy. */
  public UnaryCallSettings<GetAlertPolicyRequest, AlertPolicy> getAlertPolicySettings() {
    return ((AlertPolicyServiceStubSettings) getStubSettings()).getAlertPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAlertPolicy. */
  public UnaryCallSettings<CreateAlertPolicyRequest, AlertPolicy> createAlertPolicySettings() {
    return ((AlertPolicyServiceStubSettings) getStubSettings()).createAlertPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteAlertPolicy. */
  public UnaryCallSettings<DeleteAlertPolicyRequest, Empty> deleteAlertPolicySettings() {
    return ((AlertPolicyServiceStubSettings) getStubSettings()).deleteAlertPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateAlertPolicy. */
  public UnaryCallSettings<UpdateAlertPolicyRequest, AlertPolicy> updateAlertPolicySettings() {
    return ((AlertPolicyServiceStubSettings) getStubSettings()).updateAlertPolicySettings();
  }

  public static final AlertPolicyServiceSettings create(AlertPolicyServiceStubSettings stub)
      throws IOException {
    return new AlertPolicyServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AlertPolicyServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AlertPolicyServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AlertPolicyServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AlertPolicyServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AlertPolicyServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AlertPolicyServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AlertPolicyServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AlertPolicyServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AlertPolicyServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AlertPolicyServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AlertPolicyServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AlertPolicyServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AlertPolicyServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AlertPolicyServiceStubSettings.newBuilder());
    }

    public AlertPolicyServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AlertPolicyServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAlertPolicies. */
    public PagedCallSettings.Builder<
            ListAlertPoliciesRequest, ListAlertPoliciesResponse, ListAlertPoliciesPagedResponse>
        listAlertPoliciesSettings() {
      return getStubSettingsBuilder().listAlertPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getAlertPolicy. */
    public UnaryCallSettings.Builder<GetAlertPolicyRequest, AlertPolicy> getAlertPolicySettings() {
      return getStubSettingsBuilder().getAlertPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAlertPolicy. */
    public UnaryCallSettings.Builder<CreateAlertPolicyRequest, AlertPolicy>
        createAlertPolicySettings() {
      return getStubSettingsBuilder().createAlertPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteAlertPolicy. */
    public UnaryCallSettings.Builder<DeleteAlertPolicyRequest, Empty> deleteAlertPolicySettings() {
      return getStubSettingsBuilder().deleteAlertPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateAlertPolicy. */
    public UnaryCallSettings.Builder<UpdateAlertPolicyRequest, AlertPolicy>
        updateAlertPolicySettings() {
      return getStubSettingsBuilder().updateAlertPolicySettings();
    }

    @Override
    public AlertPolicyServiceSettings build() throws IOException {
      return new AlertPolicyServiceSettings(this);
    }
  }
}
