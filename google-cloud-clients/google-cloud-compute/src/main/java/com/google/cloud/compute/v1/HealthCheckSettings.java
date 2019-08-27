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

import static com.google.cloud.compute.v1.HealthCheckClient.ListHealthChecksPagedResponse;

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
import com.google.cloud.compute.v1.stub.HealthCheckStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link HealthCheckClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://compute.googleapis.com/compute/v1/projects/) and
 *       default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteHealthCheck to 30 seconds:
 *
 * <pre>
 * <code>
 * HealthCheckSettings.Builder healthCheckSettingsBuilder =
 *     HealthCheckSettings.newBuilder();
 * healthCheckSettingsBuilder.deleteHealthCheckSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * HealthCheckSettings healthCheckSettings = healthCheckSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class HealthCheckSettings extends ClientSettings<HealthCheckSettings> {
  /** Returns the object with the settings used for calls to deleteHealthCheck. */
  public UnaryCallSettings<DeleteHealthCheckHttpRequest, Operation> deleteHealthCheckSettings() {
    return ((HealthCheckStubSettings) getStubSettings()).deleteHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to getHealthCheck. */
  public UnaryCallSettings<GetHealthCheckHttpRequest, HealthCheck> getHealthCheckSettings() {
    return ((HealthCheckStubSettings) getStubSettings()).getHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to insertHealthCheck. */
  public UnaryCallSettings<InsertHealthCheckHttpRequest, Operation> insertHealthCheckSettings() {
    return ((HealthCheckStubSettings) getStubSettings()).insertHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to listHealthChecks. */
  public PagedCallSettings<
          ListHealthChecksHttpRequest, HealthCheckList, ListHealthChecksPagedResponse>
      listHealthChecksSettings() {
    return ((HealthCheckStubSettings) getStubSettings()).listHealthChecksSettings();
  }

  /** Returns the object with the settings used for calls to patchHealthCheck. */
  public UnaryCallSettings<PatchHealthCheckHttpRequest, Operation> patchHealthCheckSettings() {
    return ((HealthCheckStubSettings) getStubSettings()).patchHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to updateHealthCheck. */
  public UnaryCallSettings<UpdateHealthCheckHttpRequest, Operation> updateHealthCheckSettings() {
    return ((HealthCheckStubSettings) getStubSettings()).updateHealthCheckSettings();
  }

  public static final HealthCheckSettings create(HealthCheckStubSettings stub) throws IOException {
    return new HealthCheckSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return HealthCheckStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return HealthCheckStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return HealthCheckStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return HealthCheckStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return HealthCheckStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return HealthCheckStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return HealthCheckStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return HealthCheckStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected HealthCheckSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for HealthCheckSettings. */
  public static class Builder extends ClientSettings.Builder<HealthCheckSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(HealthCheckStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(HealthCheckStubSettings.newBuilder());
    }

    protected Builder(HealthCheckSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(HealthCheckStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public HealthCheckStubSettings.Builder getStubSettingsBuilder() {
      return ((HealthCheckStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteHealthCheck. */
    public UnaryCallSettings.Builder<DeleteHealthCheckHttpRequest, Operation>
        deleteHealthCheckSettings() {
      return getStubSettingsBuilder().deleteHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to getHealthCheck. */
    public UnaryCallSettings.Builder<GetHealthCheckHttpRequest, HealthCheck>
        getHealthCheckSettings() {
      return getStubSettingsBuilder().getHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to insertHealthCheck. */
    public UnaryCallSettings.Builder<InsertHealthCheckHttpRequest, Operation>
        insertHealthCheckSettings() {
      return getStubSettingsBuilder().insertHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to listHealthChecks. */
    public PagedCallSettings.Builder<
            ListHealthChecksHttpRequest, HealthCheckList, ListHealthChecksPagedResponse>
        listHealthChecksSettings() {
      return getStubSettingsBuilder().listHealthChecksSettings();
    }

    /** Returns the builder for the settings used for calls to patchHealthCheck. */
    public UnaryCallSettings.Builder<PatchHealthCheckHttpRequest, Operation>
        patchHealthCheckSettings() {
      return getStubSettingsBuilder().patchHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to updateHealthCheck. */
    public UnaryCallSettings.Builder<UpdateHealthCheckHttpRequest, Operation>
        updateHealthCheckSettings() {
      return getStubSettingsBuilder().updateHealthCheckSettings();
    }

    @Override
    public HealthCheckSettings build() throws IOException {
      return new HealthCheckSettings(this);
    }
  }
}
