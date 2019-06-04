/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.SslPolicyClient.ListSslPoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.SslPolicyStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SslPolicyClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteSslPolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * SslPolicySettings.Builder sslPolicySettingsBuilder =
 *     SslPolicySettings.newBuilder();
 * sslPolicySettingsBuilder.deleteSslPolicySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SslPolicySettings sslPolicySettings = sslPolicySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SslPolicySettings extends ClientSettings<SslPolicySettings> {
  /** Returns the object with the settings used for calls to deleteSslPolicy. */
  public UnaryCallSettings<DeleteSslPolicyHttpRequest, Operation> deleteSslPolicySettings() {
    return ((SslPolicyStubSettings) getStubSettings()).deleteSslPolicySettings();
  }

  /** Returns the object with the settings used for calls to getSslPolicy. */
  public UnaryCallSettings<GetSslPolicyHttpRequest, SslPolicy> getSslPolicySettings() {
    return ((SslPolicyStubSettings) getStubSettings()).getSslPolicySettings();
  }

  /** Returns the object with the settings used for calls to insertSslPolicy. */
  public UnaryCallSettings<InsertSslPolicyHttpRequest, Operation> insertSslPolicySettings() {
    return ((SslPolicyStubSettings) getStubSettings()).insertSslPolicySettings();
  }

  /** Returns the object with the settings used for calls to listSslPolicies. */
  public PagedCallSettings<
          ListSslPoliciesHttpRequest, SslPoliciesList, ListSslPoliciesPagedResponse>
      listSslPoliciesSettings() {
    return ((SslPolicyStubSettings) getStubSettings()).listSslPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to listAvailableFeaturesSslPolicies. */
  public UnaryCallSettings<
          ListAvailableFeaturesSslPoliciesHttpRequest, SslPoliciesListAvailableFeaturesResponse>
      listAvailableFeaturesSslPoliciesSettings() {
    return ((SslPolicyStubSettings) getStubSettings()).listAvailableFeaturesSslPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to patchSslPolicy. */
  public UnaryCallSettings<PatchSslPolicyHttpRequest, Operation> patchSslPolicySettings() {
    return ((SslPolicyStubSettings) getStubSettings()).patchSslPolicySettings();
  }

  public static final SslPolicySettings create(SslPolicyStubSettings stub) throws IOException {
    return new SslPolicySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SslPolicyStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SslPolicyStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return SslPolicyStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SslPolicyStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SslPolicyStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SslPolicyStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SslPolicyStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SslPolicyStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SslPolicySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SslPolicySettings. */
  public static class Builder extends ClientSettings.Builder<SslPolicySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(SslPolicyStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(SslPolicyStubSettings.newBuilder());
    }

    protected Builder(SslPolicySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SslPolicyStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public SslPolicyStubSettings.Builder getStubSettingsBuilder() {
      return ((SslPolicyStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to deleteSslPolicy. */
    public UnaryCallSettings.Builder<DeleteSslPolicyHttpRequest, Operation>
        deleteSslPolicySettings() {
      return getStubSettingsBuilder().deleteSslPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getSslPolicy. */
    public UnaryCallSettings.Builder<GetSslPolicyHttpRequest, SslPolicy> getSslPolicySettings() {
      return getStubSettingsBuilder().getSslPolicySettings();
    }

    /** Returns the builder for the settings used for calls to insertSslPolicy. */
    public UnaryCallSettings.Builder<InsertSslPolicyHttpRequest, Operation>
        insertSslPolicySettings() {
      return getStubSettingsBuilder().insertSslPolicySettings();
    }

    /** Returns the builder for the settings used for calls to listSslPolicies. */
    public PagedCallSettings.Builder<
            ListSslPoliciesHttpRequest, SslPoliciesList, ListSslPoliciesPagedResponse>
        listSslPoliciesSettings() {
      return getStubSettingsBuilder().listSslPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to listAvailableFeaturesSslPolicies. */
    public UnaryCallSettings.Builder<
            ListAvailableFeaturesSslPoliciesHttpRequest, SslPoliciesListAvailableFeaturesResponse>
        listAvailableFeaturesSslPoliciesSettings() {
      return getStubSettingsBuilder().listAvailableFeaturesSslPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to patchSslPolicy. */
    public UnaryCallSettings.Builder<PatchSslPolicyHttpRequest, Operation>
        patchSslPolicySettings() {
      return getStubSettingsBuilder().patchSslPolicySettings();
    }

    @Override
    public SslPolicySettings build() throws IOException {
      return new SslPolicySettings(this);
    }
  }
}
