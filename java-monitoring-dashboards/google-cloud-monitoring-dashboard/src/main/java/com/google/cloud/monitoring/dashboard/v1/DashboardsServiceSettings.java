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

package com.google.cloud.monitoring.dashboard.v1;

import static com.google.cloud.monitoring.dashboard.v1.DashboardsServiceClient.ListDashboardsPagedResponse;

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
import com.google.cloud.monitoring.dashboard.v1.stub.DashboardsServiceStubSettings;
import com.google.monitoring.dashboard.v1.CreateDashboardRequest;
import com.google.monitoring.dashboard.v1.Dashboard;
import com.google.monitoring.dashboard.v1.DeleteDashboardRequest;
import com.google.monitoring.dashboard.v1.GetDashboardRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsRequest;
import com.google.monitoring.dashboard.v1.ListDashboardsResponse;
import com.google.monitoring.dashboard.v1.UpdateDashboardRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DashboardsServiceClient}.
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
 * <p>For example, to set the total timeout of createDashboard to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DashboardsServiceSettings.Builder dashboardsServiceSettingsBuilder =
 *     DashboardsServiceSettings.newBuilder();
 * dashboardsServiceSettingsBuilder
 *     .createDashboardSettings()
 *     .setRetrySettings(
 *         dashboardsServiceSettingsBuilder
 *             .createDashboardSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DashboardsServiceSettings dashboardsServiceSettings = dashboardsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DashboardsServiceSettings extends ClientSettings<DashboardsServiceSettings> {

  /** Returns the object with the settings used for calls to createDashboard. */
  public UnaryCallSettings<CreateDashboardRequest, Dashboard> createDashboardSettings() {
    return ((DashboardsServiceStubSettings) getStubSettings()).createDashboardSettings();
  }

  /** Returns the object with the settings used for calls to listDashboards. */
  public PagedCallSettings<
          ListDashboardsRequest, ListDashboardsResponse, ListDashboardsPagedResponse>
      listDashboardsSettings() {
    return ((DashboardsServiceStubSettings) getStubSettings()).listDashboardsSettings();
  }

  /** Returns the object with the settings used for calls to getDashboard. */
  public UnaryCallSettings<GetDashboardRequest, Dashboard> getDashboardSettings() {
    return ((DashboardsServiceStubSettings) getStubSettings()).getDashboardSettings();
  }

  /** Returns the object with the settings used for calls to deleteDashboard. */
  public UnaryCallSettings<DeleteDashboardRequest, Empty> deleteDashboardSettings() {
    return ((DashboardsServiceStubSettings) getStubSettings()).deleteDashboardSettings();
  }

  /** Returns the object with the settings used for calls to updateDashboard. */
  public UnaryCallSettings<UpdateDashboardRequest, Dashboard> updateDashboardSettings() {
    return ((DashboardsServiceStubSettings) getStubSettings()).updateDashboardSettings();
  }

  public static final DashboardsServiceSettings create(DashboardsServiceStubSettings stub)
      throws IOException {
    return new DashboardsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DashboardsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DashboardsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DashboardsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DashboardsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DashboardsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DashboardsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DashboardsServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DashboardsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected DashboardsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DashboardsServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DashboardsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DashboardsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DashboardsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DashboardsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DashboardsServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DashboardsServiceStubSettings.newHttpJsonBuilder());
    }

    public DashboardsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DashboardsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDashboard. */
    public UnaryCallSettings.Builder<CreateDashboardRequest, Dashboard> createDashboardSettings() {
      return getStubSettingsBuilder().createDashboardSettings();
    }

    /** Returns the builder for the settings used for calls to listDashboards. */
    public PagedCallSettings.Builder<
            ListDashboardsRequest, ListDashboardsResponse, ListDashboardsPagedResponse>
        listDashboardsSettings() {
      return getStubSettingsBuilder().listDashboardsSettings();
    }

    /** Returns the builder for the settings used for calls to getDashboard. */
    public UnaryCallSettings.Builder<GetDashboardRequest, Dashboard> getDashboardSettings() {
      return getStubSettingsBuilder().getDashboardSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDashboard. */
    public UnaryCallSettings.Builder<DeleteDashboardRequest, Empty> deleteDashboardSettings() {
      return getStubSettingsBuilder().deleteDashboardSettings();
    }

    /** Returns the builder for the settings used for calls to updateDashboard. */
    public UnaryCallSettings.Builder<UpdateDashboardRequest, Dashboard> updateDashboardSettings() {
      return getStubSettingsBuilder().updateDashboardSettings();
    }

    @Override
    public DashboardsServiceSettings build() throws IOException {
      return new DashboardsServiceSettings(this);
    }
  }
}
