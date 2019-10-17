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

import static com.google.cloud.compute.v1.SslCertificateClient.AggregatedListSslCertificatesPagedResponse;
import static com.google.cloud.compute.v1.SslCertificateClient.ListSslCertificatesPagedResponse;

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
import com.google.cloud.compute.v1.stub.SslCertificateStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SslCertificateClient}.
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
 * <p>For example, to set the total timeout of deleteSslCertificate to 30 seconds:
 *
 * <pre>
 * <code>
 * SslCertificateSettings.Builder sslCertificateSettingsBuilder =
 *     SslCertificateSettings.newBuilder();
 * sslCertificateSettingsBuilder.deleteSslCertificateSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SslCertificateSettings sslCertificateSettings = sslCertificateSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SslCertificateSettings extends ClientSettings<SslCertificateSettings> {
  /** Returns the object with the settings used for calls to aggregatedListSslCertificates. */
  public PagedCallSettings<
          AggregatedListSslCertificatesHttpRequest,
          SslCertificateAggregatedList,
          AggregatedListSslCertificatesPagedResponse>
      aggregatedListSslCertificatesSettings() {
    return ((SslCertificateStubSettings) getStubSettings()).aggregatedListSslCertificatesSettings();
  }

  /** Returns the object with the settings used for calls to deleteSslCertificate. */
  public UnaryCallSettings<DeleteSslCertificateHttpRequest, Operation>
      deleteSslCertificateSettings() {
    return ((SslCertificateStubSettings) getStubSettings()).deleteSslCertificateSettings();
  }

  /** Returns the object with the settings used for calls to getSslCertificate. */
  public UnaryCallSettings<GetSslCertificateHttpRequest, SslCertificate>
      getSslCertificateSettings() {
    return ((SslCertificateStubSettings) getStubSettings()).getSslCertificateSettings();
  }

  /** Returns the object with the settings used for calls to insertSslCertificate. */
  public UnaryCallSettings<InsertSslCertificateHttpRequest, Operation>
      insertSslCertificateSettings() {
    return ((SslCertificateStubSettings) getStubSettings()).insertSslCertificateSettings();
  }

  /** Returns the object with the settings used for calls to listSslCertificates. */
  public PagedCallSettings<
          ListSslCertificatesHttpRequest, SslCertificateList, ListSslCertificatesPagedResponse>
      listSslCertificatesSettings() {
    return ((SslCertificateStubSettings) getStubSettings()).listSslCertificatesSettings();
  }

  public static final SslCertificateSettings create(SslCertificateStubSettings stub)
      throws IOException {
    return new SslCertificateSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SslCertificateStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SslCertificateStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return SslCertificateStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SslCertificateStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SslCertificateStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SslCertificateStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SslCertificateStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SslCertificateStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SslCertificateSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SslCertificateSettings. */
  public static class Builder extends ClientSettings.Builder<SslCertificateSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(SslCertificateStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(SslCertificateStubSettings.newBuilder());
    }

    protected Builder(SslCertificateSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SslCertificateStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public SslCertificateStubSettings.Builder getStubSettingsBuilder() {
      return ((SslCertificateStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListSslCertificates. */
    public PagedCallSettings.Builder<
            AggregatedListSslCertificatesHttpRequest,
            SslCertificateAggregatedList,
            AggregatedListSslCertificatesPagedResponse>
        aggregatedListSslCertificatesSettings() {
      return getStubSettingsBuilder().aggregatedListSslCertificatesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSslCertificate. */
    public UnaryCallSettings.Builder<DeleteSslCertificateHttpRequest, Operation>
        deleteSslCertificateSettings() {
      return getStubSettingsBuilder().deleteSslCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to getSslCertificate. */
    public UnaryCallSettings.Builder<GetSslCertificateHttpRequest, SslCertificate>
        getSslCertificateSettings() {
      return getStubSettingsBuilder().getSslCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to insertSslCertificate. */
    public UnaryCallSettings.Builder<InsertSslCertificateHttpRequest, Operation>
        insertSslCertificateSettings() {
      return getStubSettingsBuilder().insertSslCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to listSslCertificates. */
    public PagedCallSettings.Builder<
            ListSslCertificatesHttpRequest, SslCertificateList, ListSslCertificatesPagedResponse>
        listSslCertificatesSettings() {
      return getStubSettingsBuilder().listSslCertificatesSettings();
    }

    @Override
    public SslCertificateSettings build() throws IOException {
      return new SslCertificateSettings(this);
    }
  }
}
