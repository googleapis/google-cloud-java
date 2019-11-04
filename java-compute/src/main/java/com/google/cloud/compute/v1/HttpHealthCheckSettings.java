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

import static com.google.cloud.compute.v1.HttpHealthCheckClient.ListHttpHealthChecksPagedResponse;

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
import com.google.cloud.compute.v1.stub.HttpHealthCheckStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link HttpHealthCheckClient}.
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
 * <p>For example, to set the total timeout of deleteHttpHealthCheck to 30 seconds:
 *
 * <pre>
 * <code>
 * HttpHealthCheckSettings.Builder httpHealthCheckSettingsBuilder =
 *     HttpHealthCheckSettings.newBuilder();
 * httpHealthCheckSettingsBuilder.deleteHttpHealthCheckSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * HttpHealthCheckSettings httpHealthCheckSettings = httpHealthCheckSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class HttpHealthCheckSettings extends ClientSettings<HttpHealthCheckSettings> {
  /** Returns the object with the settings used for calls to deleteHttpHealthCheck. */
  public UnaryCallSettings<DeleteHttpHealthCheckHttpRequest, Operation>
      deleteHttpHealthCheckSettings() {
    return ((HttpHealthCheckStubSettings) getStubSettings()).deleteHttpHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to getHttpHealthCheck. */
  public UnaryCallSettings<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>
      getHttpHealthCheckSettings() {
    return ((HttpHealthCheckStubSettings) getStubSettings()).getHttpHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to insertHttpHealthCheck. */
  public UnaryCallSettings<InsertHttpHealthCheckHttpRequest, Operation>
      insertHttpHealthCheckSettings() {
    return ((HttpHealthCheckStubSettings) getStubSettings()).insertHttpHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to listHttpHealthChecks. */
  public PagedCallSettings<
          ListHttpHealthChecksHttpRequest, HttpHealthCheckList, ListHttpHealthChecksPagedResponse>
      listHttpHealthChecksSettings() {
    return ((HttpHealthCheckStubSettings) getStubSettings()).listHttpHealthChecksSettings();
  }

  /** Returns the object with the settings used for calls to patchHttpHealthCheck. */
  public UnaryCallSettings<PatchHttpHealthCheckHttpRequest, Operation>
      patchHttpHealthCheckSettings() {
    return ((HttpHealthCheckStubSettings) getStubSettings()).patchHttpHealthCheckSettings();
  }

  /** Returns the object with the settings used for calls to updateHttpHealthCheck. */
  public UnaryCallSettings<UpdateHttpHealthCheckHttpRequest, Operation>
      updateHttpHealthCheckSettings() {
    return ((HttpHealthCheckStubSettings) getStubSettings()).updateHttpHealthCheckSettings();
  }

  public static final HttpHealthCheckSettings create(HttpHealthCheckStubSettings stub)
      throws IOException {
    return new HttpHealthCheckSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return HttpHealthCheckStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return HttpHealthCheckStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return HttpHealthCheckStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return HttpHealthCheckStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return HttpHealthCheckStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return HttpHealthCheckStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return HttpHealthCheckStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return HttpHealthCheckStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected HttpHealthCheckSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for HttpHealthCheckSettings. */
  public static class Builder extends ClientSettings.Builder<HttpHealthCheckSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(HttpHealthCheckStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(HttpHealthCheckStubSettings.newBuilder());
    }

    protected Builder(HttpHealthCheckSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(HttpHealthCheckStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public HttpHealthCheckStubSettings.Builder getStubSettingsBuilder() {
      return ((HttpHealthCheckStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteHttpHealthCheck. */
    public UnaryCallSettings.Builder<DeleteHttpHealthCheckHttpRequest, Operation>
        deleteHttpHealthCheckSettings() {
      return getStubSettingsBuilder().deleteHttpHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to getHttpHealthCheck. */
    public UnaryCallSettings.Builder<GetHttpHealthCheckHttpRequest, HttpHealthCheck2>
        getHttpHealthCheckSettings() {
      return getStubSettingsBuilder().getHttpHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to insertHttpHealthCheck. */
    public UnaryCallSettings.Builder<InsertHttpHealthCheckHttpRequest, Operation>
        insertHttpHealthCheckSettings() {
      return getStubSettingsBuilder().insertHttpHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to listHttpHealthChecks. */
    public PagedCallSettings.Builder<
            ListHttpHealthChecksHttpRequest, HttpHealthCheckList, ListHttpHealthChecksPagedResponse>
        listHttpHealthChecksSettings() {
      return getStubSettingsBuilder().listHttpHealthChecksSettings();
    }

    /** Returns the builder for the settings used for calls to patchHttpHealthCheck. */
    public UnaryCallSettings.Builder<PatchHttpHealthCheckHttpRequest, Operation>
        patchHttpHealthCheckSettings() {
      return getStubSettingsBuilder().patchHttpHealthCheckSettings();
    }

    /** Returns the builder for the settings used for calls to updateHttpHealthCheck. */
    public UnaryCallSettings.Builder<UpdateHttpHealthCheckHttpRequest, Operation>
        updateHttpHealthCheckSettings() {
      return getStubSettingsBuilder().updateHttpHealthCheckSettings();
    }

    @Override
    public HttpHealthCheckSettings build() throws IOException {
      return new HttpHealthCheckSettings(this);
    }
  }
}
