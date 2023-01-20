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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.RoutesClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.RoutesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RoutesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RoutesSettings.Builder routesSettingsBuilder = RoutesSettings.newBuilder();
 * routesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         routesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RoutesSettings routesSettings = routesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RoutesSettings extends ClientSettings<RoutesSettings> {

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRouteRequest, Operation> deleteSettings() {
    return ((RoutesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRouteRequest, Operation, Operation> deleteOperationSettings() {
    return ((RoutesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRouteRequest, Route> getSettings() {
    return ((RoutesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRouteRequest, Operation> insertSettings() {
    return ((RoutesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRouteRequest, Operation, Operation> insertOperationSettings() {
    return ((RoutesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListRoutesRequest, RouteList, ListPagedResponse> listSettings() {
    return ((RoutesStubSettings) getStubSettings()).listSettings();
  }

  public static final RoutesSettings create(RoutesStubSettings stub) throws IOException {
    return new RoutesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RoutesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RoutesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RoutesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RoutesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RoutesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RoutesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RoutesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RoutesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RoutesSettings. */
  public static class Builder extends ClientSettings.Builder<RoutesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RoutesStubSettings.newBuilder(clientContext));
    }

    protected Builder(RoutesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RoutesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RoutesStubSettings.newBuilder());
    }

    public RoutesStubSettings.Builder getStubSettingsBuilder() {
      return ((RoutesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRouteRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteRouteRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRouteRequest, Route> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRouteRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertRouteRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListRoutesRequest, RouteList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    @Override
    public RoutesSettings build() throws IOException {
      return new RoutesSettings(this);
    }
  }
}
