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

import static com.google.cloud.compute.v1.HttpsHealthCheckClient.ListHttpsHealthChecksPagedResponse;

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
import com.google.cloud.compute.v1.stub.HttpsHealthCheckStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link HttpsHealthCheckClient}.
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
 * example, to set the total timeout of deleteHttpsHealthCheck to 30 seconds:
 *
 * <pre>
 * <code>
 * HttpsHealthCheckSettings.Builder httpsHealthCheckSettingsBuilder =
 *     HttpsHealthCheckSettings.newBuilder();
 * httpsHealthCheckSettingsBuilder.deleteHttpsHealthCheckSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * HttpsHealthCheckSettings httpsHealthCheckSettings = httpsHealthCheckSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class HttpsHealthCheckSettings extends ClientSettings<HttpsHealthCheckSettings> {
  /** Returns the object with the settings used for calls to deleteHttpsHealthCheck. */
  public UnaryCallSettings<DeleteHttpsHealthCheckHttpRequest, Operation>
      deleteHttpsHealthCheckSettings() {
    return ((HttpsHealthCheckStubSettings) getStubSettings()).deleteHttpsHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to getHttpsHealthCheck. */
  public UnaryCallSettings<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck2>
      getHttpsHealthCheckSettings() {
    return ((HttpsHealthCheckStubSettings) getStubSettings()).getHttpsHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to insertHttpsHealthCheck. */
  public UnaryCallSettings<InsertHttpsHealthCheckHttpRequest, Operation>
      insertHttpsHealthCheckSettings() {
    return ((HttpsHealthCheckStubSettings) getStubSettings()).insertHttpsHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to listHttpsHealthChecks. */
  public PagedCallSettings<
          ListHttpsHealthChecksHttpRequest,
          HttpsHealthCheckList,
          ListHttpsHealthChecksPagedResponse>
      listHttpsHealthChecksSettings() {
    return ((HttpsHealthCheckStubSettings) getStubSettings()).listHttpsHealthChecksSettings();
  }

  /** Returns the object with the settings used for calls to patchHttpsHealthCheck. */
  public UnaryCallSettings<PatchHttpsHealthCheckHttpRequest, Operation>
      patchHttpsHealthCheckSettings() {
    return ((HttpsHealthCheckStubSettings) getStubSettings()).patchHttpsHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to updateHttpsHealthCheck. */
  public UnaryCallSettings<UpdateHttpsHealthCheckHttpRequest, Operation>
      updateHttpsHealthCheckSettings() {
    return ((HttpsHealthCheckStubSettings) getStubSettings()).updateHttpsHealthCheckSettings();
  }

  public static final HttpsHealthCheckSettings create(HttpsHealthCheckStubSettings stub)
      throws IOException {
    return new HttpsHealthCheckSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return HttpsHealthCheckStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return HttpsHealthCheckStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return HttpsHealthCheckStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return HttpsHealthCheckStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return HttpsHealthCheckStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return HttpsHealthCheckStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return HttpsHealthCheckStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return HttpsHealthCheckStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected HttpsHealthCheckSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for HttpsHealthCheckSettings. */
  public static class Builder extends ClientSettings.Builder<HttpsHealthCheckSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(HttpsHealthCheckStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(HttpsHealthCheckStubSettings.newBuilder());
    }

    protected Builder(HttpsHealthCheckSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(HttpsHealthCheckStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public HttpsHealthCheckStubSettings.Builder getStubSettingsBuilder() {
      return ((HttpsHealthCheckStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteHttpsHealthCheck. */
    public UnaryCallSettings.Builder<DeleteHttpsHealthCheckHttpRequest, Operation>
        deleteHttpsHealthCheckSettings() {
      return getStubSettingsBuilder().deleteHttpsHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to getHttpsHealthCheck. */
    public UnaryCallSettings.Builder<GetHttpsHealthCheckHttpRequest, HttpsHealthCheck2>
        getHttpsHealthCheckSettings() {
      return getStubSettingsBuilder().getHttpsHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to insertHttpsHealthCheck. */
    public UnaryCallSettings.Builder<InsertHttpsHealthCheckHttpRequest, Operation>
        insertHttpsHealthCheckSettings() {
      return getStubSettingsBuilder().insertHttpsHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to listHttpsHealthChecks. */
    public PagedCallSettings.Builder<
            ListHttpsHealthChecksHttpRequest,
            HttpsHealthCheckList,
            ListHttpsHealthChecksPagedResponse>
        listHttpsHealthChecksSettings() {
      return getStubSettingsBuilder().listHttpsHealthChecksSettings();
    }

    /** Returns the builder for the settings used for calls to patchHttpsHealthCheck. */
    public UnaryCallSettings.Builder<PatchHttpsHealthCheckHttpRequest, Operation>
        patchHttpsHealthCheckSettings() {
      return getStubSettingsBuilder().patchHttpsHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to updateHttpsHealthCheck. */
    public UnaryCallSettings.Builder<UpdateHttpsHealthCheckHttpRequest, Operation>
        updateHttpsHealthCheckSettings() {
      return getStubSettingsBuilder().updateHttpsHealthCheckSettings();
    }

    @Override
    public HttpsHealthCheckSettings build() throws IOException {
      return new HttpsHealthCheckSettings(this);
    }
  }
}
