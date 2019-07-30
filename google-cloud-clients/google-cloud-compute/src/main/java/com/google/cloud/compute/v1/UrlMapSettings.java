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

import static com.google.cloud.compute.v1.UrlMapClient.ListUrlMapsPagedResponse;

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
import com.google.cloud.compute.v1.stub.UrlMapStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link UrlMapClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteUrlMap to 30 seconds:
 *
 * <pre>
 * <code>
 * UrlMapSettings.Builder urlMapSettingsBuilder =
 *     UrlMapSettings.newBuilder();
 * urlMapSettingsBuilder.deleteUrlMapSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * UrlMapSettings urlMapSettings = urlMapSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class UrlMapSettings extends ClientSettings<UrlMapSettings> {
  /** Returns the object with the settings used for calls to deleteUrlMap. */
  public UnaryCallSettings<DeleteUrlMapHttpRequest, Operation> deleteUrlMapSettings() {
    return ((UrlMapStubSettings) getStubSettings()).deleteUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to getUrlMap. */
  public UnaryCallSettings<GetUrlMapHttpRequest, UrlMap> getUrlMapSettings() {
    return ((UrlMapStubSettings) getStubSettings()).getUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to insertUrlMap. */
  public UnaryCallSettings<InsertUrlMapHttpRequest, Operation> insertUrlMapSettings() {
    return ((UrlMapStubSettings) getStubSettings()).insertUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to invalidateCacheUrlMap. */
  public UnaryCallSettings<InvalidateCacheUrlMapHttpRequest, Operation>
      invalidateCacheUrlMapSettings() {
    return ((UrlMapStubSettings) getStubSettings()).invalidateCacheUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to listUrlMaps. */
  public PagedCallSettings<ListUrlMapsHttpRequest, UrlMapList, ListUrlMapsPagedResponse>
      listUrlMapsSettings() {
    return ((UrlMapStubSettings) getStubSettings()).listUrlMapsSettings();
  }

  /** Returns the object with the settings used for calls to patchUrlMap. */
  public UnaryCallSettings<PatchUrlMapHttpRequest, Operation> patchUrlMapSettings() {
    return ((UrlMapStubSettings) getStubSettings()).patchUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to updateUrlMap. */
  public UnaryCallSettings<UpdateUrlMapHttpRequest, Operation> updateUrlMapSettings() {
    return ((UrlMapStubSettings) getStubSettings()).updateUrlMapSettings();
  }

  /** Returns the object with the settings used for calls to validateUrlMap. */
  public UnaryCallSettings<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
      validateUrlMapSettings() {
    return ((UrlMapStubSettings) getStubSettings()).validateUrlMapSettings();
  }

  public static final UrlMapSettings create(UrlMapStubSettings stub) throws IOException {
    return new UrlMapSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return UrlMapStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return UrlMapStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return UrlMapStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return UrlMapStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return UrlMapStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return UrlMapStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return UrlMapStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return UrlMapStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected UrlMapSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for UrlMapSettings. */
  public static class Builder extends ClientSettings.Builder<UrlMapSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(UrlMapStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(UrlMapStubSettings.newBuilder());
    }

    protected Builder(UrlMapSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(UrlMapStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public UrlMapStubSettings.Builder getStubSettingsBuilder() {
      return ((UrlMapStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to deleteUrlMap. */
    public UnaryCallSettings.Builder<DeleteUrlMapHttpRequest, Operation> deleteUrlMapSettings() {
      return getStubSettingsBuilder().deleteUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to getUrlMap. */
    public UnaryCallSettings.Builder<GetUrlMapHttpRequest, UrlMap> getUrlMapSettings() {
      return getStubSettingsBuilder().getUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to insertUrlMap. */
    public UnaryCallSettings.Builder<InsertUrlMapHttpRequest, Operation> insertUrlMapSettings() {
      return getStubSettingsBuilder().insertUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to invalidateCacheUrlMap. */
    public UnaryCallSettings.Builder<InvalidateCacheUrlMapHttpRequest, Operation>
        invalidateCacheUrlMapSettings() {
      return getStubSettingsBuilder().invalidateCacheUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to listUrlMaps. */
    public PagedCallSettings.Builder<ListUrlMapsHttpRequest, UrlMapList, ListUrlMapsPagedResponse>
        listUrlMapsSettings() {
      return getStubSettingsBuilder().listUrlMapsSettings();
    }

    /** Returns the builder for the settings used for calls to patchUrlMap. */
    public UnaryCallSettings.Builder<PatchUrlMapHttpRequest, Operation> patchUrlMapSettings() {
      return getStubSettingsBuilder().patchUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to updateUrlMap. */
    public UnaryCallSettings.Builder<UpdateUrlMapHttpRequest, Operation> updateUrlMapSettings() {
      return getStubSettingsBuilder().updateUrlMapSettings();
    }

    /** Returns the builder for the settings used for calls to validateUrlMap. */
    public UnaryCallSettings.Builder<ValidateUrlMapHttpRequest, UrlMapsValidateResponse>
        validateUrlMapSettings() {
      return getStubSettingsBuilder().validateUrlMapSettings();
    }

    @Override
    public UrlMapSettings build() throws IOException {
      return new UrlMapSettings(this);
    }
  }
}
