/*
 * Copyright 2018 Google LLC
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

import static com.google.cloud.compute.v1.RouterClient.AggregatedListRoutersPagedResponse;
import static com.google.cloud.compute.v1.RouterClient.ListRoutersPagedResponse;

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
import com.google.cloud.compute.v1.stub.RouterStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link RouterClient}.
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
 * example, to set the total timeout of deleteRouter to 30 seconds:
 *
 * <pre>
 * <code>
 * RouterSettings.Builder routerSettingsBuilder =
 *     RouterSettings.newBuilder();
 * routerSettingsBuilder.deleteRouterSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * RouterSettings routerSettings = routerSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class RouterSettings extends ClientSettings<RouterSettings> {
  /** Returns the object with the settings used for calls to aggregatedListRouters. */
  public PagedCallSettings<
          AggregatedListRoutersHttpRequest, RouterAggregatedList,
          AggregatedListRoutersPagedResponse>
      aggregatedListRoutersSettings() {
    return ((RouterStubSettings) getStubSettings()).aggregatedListRoutersSettings();
  }

  /** Returns the object with the settings used for calls to deleteRouter. */
  public UnaryCallSettings<DeleteRouterHttpRequest, Operation> deleteRouterSettings() {
    return ((RouterStubSettings) getStubSettings()).deleteRouterSettings();
  }

  /** Returns the object with the settings used for calls to getRouter. */
  public UnaryCallSettings<GetRouterHttpRequest, Router> getRouterSettings() {
    return ((RouterStubSettings) getStubSettings()).getRouterSettings();
  }

  /** Returns the object with the settings used for calls to getRouterStatusRouter. */
  public UnaryCallSettings<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
      getRouterStatusRouterSettings() {
    return ((RouterStubSettings) getStubSettings()).getRouterStatusRouterSettings();
  }

  /** Returns the object with the settings used for calls to insertRouter. */
  public UnaryCallSettings<InsertRouterHttpRequest, Operation> insertRouterSettings() {
    return ((RouterStubSettings) getStubSettings()).insertRouterSettings();
  }

  /** Returns the object with the settings used for calls to listRouters. */
  public PagedCallSettings<ListRoutersHttpRequest, RouterList, ListRoutersPagedResponse>
      listRoutersSettings() {
    return ((RouterStubSettings) getStubSettings()).listRoutersSettings();
  }

  /** Returns the object with the settings used for calls to patchRouter. */
  public UnaryCallSettings<PatchRouterHttpRequest, Operation> patchRouterSettings() {
    return ((RouterStubSettings) getStubSettings()).patchRouterSettings();
  }

  /** Returns the object with the settings used for calls to previewRouter. */
  public UnaryCallSettings<PreviewRouterHttpRequest, RoutersPreviewResponse>
      previewRouterSettings() {
    return ((RouterStubSettings) getStubSettings()).previewRouterSettings();
  }

  /** Returns the object with the settings used for calls to updateRouter. */
  public UnaryCallSettings<UpdateRouterHttpRequest, Operation> updateRouterSettings() {
    return ((RouterStubSettings) getStubSettings()).updateRouterSettings();
  }

  public static final RouterSettings create(RouterStubSettings stub) throws IOException {
    return new RouterSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RouterStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RouterStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return RouterStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RouterStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RouterStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RouterStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RouterStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RouterStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RouterSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RouterSettings. */
  public static class Builder extends ClientSettings.Builder<RouterSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(RouterStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(RouterStubSettings.newBuilder());
    }

    protected Builder(RouterSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RouterStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public RouterStubSettings.Builder getStubSettingsBuilder() {
      return ((RouterStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedListRouters. */
    public PagedCallSettings.Builder<
            AggregatedListRoutersHttpRequest, RouterAggregatedList,
            AggregatedListRoutersPagedResponse>
        aggregatedListRoutersSettings() {
      return getStubSettingsBuilder().aggregatedListRoutersSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRouter. */
    public UnaryCallSettings.Builder<DeleteRouterHttpRequest, Operation> deleteRouterSettings() {
      return getStubSettingsBuilder().deleteRouterSettings();
    }

    /** Returns the builder for the settings used for calls to getRouter. */
    public UnaryCallSettings.Builder<GetRouterHttpRequest, Router> getRouterSettings() {
      return getStubSettingsBuilder().getRouterSettings();
    }

    /** Returns the builder for the settings used for calls to getRouterStatusRouter. */
    public UnaryCallSettings.Builder<GetRouterStatusRouterHttpRequest, RouterStatusResponse>
        getRouterStatusRouterSettings() {
      return getStubSettingsBuilder().getRouterStatusRouterSettings();
    }

    /** Returns the builder for the settings used for calls to insertRouter. */
    public UnaryCallSettings.Builder<InsertRouterHttpRequest, Operation> insertRouterSettings() {
      return getStubSettingsBuilder().insertRouterSettings();
    }

    /** Returns the builder for the settings used for calls to listRouters. */
    public PagedCallSettings.Builder<ListRoutersHttpRequest, RouterList, ListRoutersPagedResponse>
        listRoutersSettings() {
      return getStubSettingsBuilder().listRoutersSettings();
    }

    /** Returns the builder for the settings used for calls to patchRouter. */
    public UnaryCallSettings.Builder<PatchRouterHttpRequest, Operation> patchRouterSettings() {
      return getStubSettingsBuilder().patchRouterSettings();
    }

    /** Returns the builder for the settings used for calls to previewRouter. */
    public UnaryCallSettings.Builder<PreviewRouterHttpRequest, RoutersPreviewResponse>
        previewRouterSettings() {
      return getStubSettingsBuilder().previewRouterSettings();
    }

    /** Returns the builder for the settings used for calls to updateRouter. */
    public UnaryCallSettings.Builder<UpdateRouterHttpRequest, Operation> updateRouterSettings() {
      return getStubSettingsBuilder().updateRouterSettings();
    }

    @Override
    public RouterSettings build() throws IOException {
      return new RouterSettings(this);
    }
  }
}
