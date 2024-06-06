/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.datasources.v1beta;

import static com.google.shopping.merchant.datasources.v1beta.DataSourcesServiceClient.ListDataSourcesPagedResponse;

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
import com.google.protobuf.Empty;
import com.google.shopping.merchant.datasources.v1beta.stub.DataSourcesServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataSourcesServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (merchantapi.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDataSource to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataSourcesServiceSettings.Builder dataSourcesServiceSettingsBuilder =
 *     DataSourcesServiceSettings.newBuilder();
 * dataSourcesServiceSettingsBuilder
 *     .getDataSourceSettings()
 *     .setRetrySettings(
 *         dataSourcesServiceSettingsBuilder
 *             .getDataSourceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataSourcesServiceSettings dataSourcesServiceSettings =
 *     dataSourcesServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataSourcesServiceSettings extends ClientSettings<DataSourcesServiceSettings> {

  /** Returns the object with the settings used for calls to getDataSource. */
  public UnaryCallSettings<GetDataSourceRequest, DataSource> getDataSourceSettings() {
    return ((DataSourcesServiceStubSettings) getStubSettings()).getDataSourceSettings();
  }

  /** Returns the object with the settings used for calls to listDataSources. */
  public PagedCallSettings<
          ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
      listDataSourcesSettings() {
    return ((DataSourcesServiceStubSettings) getStubSettings()).listDataSourcesSettings();
  }

  /** Returns the object with the settings used for calls to createDataSource. */
  public UnaryCallSettings<CreateDataSourceRequest, DataSource> createDataSourceSettings() {
    return ((DataSourcesServiceStubSettings) getStubSettings()).createDataSourceSettings();
  }

  /** Returns the object with the settings used for calls to updateDataSource. */
  public UnaryCallSettings<UpdateDataSourceRequest, DataSource> updateDataSourceSettings() {
    return ((DataSourcesServiceStubSettings) getStubSettings()).updateDataSourceSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataSource. */
  public UnaryCallSettings<DeleteDataSourceRequest, Empty> deleteDataSourceSettings() {
    return ((DataSourcesServiceStubSettings) getStubSettings()).deleteDataSourceSettings();
  }

  /** Returns the object with the settings used for calls to fetchDataSource. */
  public UnaryCallSettings<FetchDataSourceRequest, Empty> fetchDataSourceSettings() {
    return ((DataSourcesServiceStubSettings) getStubSettings()).fetchDataSourceSettings();
  }

  public static final DataSourcesServiceSettings create(DataSourcesServiceStubSettings stub)
      throws IOException {
    return new DataSourcesServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataSourcesServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataSourcesServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataSourcesServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataSourcesServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataSourcesServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataSourcesServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataSourcesServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataSourcesServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected DataSourcesServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataSourcesServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataSourcesServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataSourcesServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataSourcesServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataSourcesServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataSourcesServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(DataSourcesServiceStubSettings.newHttpJsonBuilder());
    }

    public DataSourcesServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataSourcesServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getDataSource. */
    public UnaryCallSettings.Builder<GetDataSourceRequest, DataSource> getDataSourceSettings() {
      return getStubSettingsBuilder().getDataSourceSettings();
    }

    /** Returns the builder for the settings used for calls to listDataSources. */
    public PagedCallSettings.Builder<
            ListDataSourcesRequest, ListDataSourcesResponse, ListDataSourcesPagedResponse>
        listDataSourcesSettings() {
      return getStubSettingsBuilder().listDataSourcesSettings();
    }

    /** Returns the builder for the settings used for calls to createDataSource. */
    public UnaryCallSettings.Builder<CreateDataSourceRequest, DataSource>
        createDataSourceSettings() {
      return getStubSettingsBuilder().createDataSourceSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataSource. */
    public UnaryCallSettings.Builder<UpdateDataSourceRequest, DataSource>
        updateDataSourceSettings() {
      return getStubSettingsBuilder().updateDataSourceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataSource. */
    public UnaryCallSettings.Builder<DeleteDataSourceRequest, Empty> deleteDataSourceSettings() {
      return getStubSettingsBuilder().deleteDataSourceSettings();
    }

    /** Returns the builder for the settings used for calls to fetchDataSource. */
    public UnaryCallSettings.Builder<FetchDataSourceRequest, Empty> fetchDataSourceSettings() {
      return getStubSettingsBuilder().fetchDataSourceSettings();
    }

    @Override
    public DataSourcesServiceSettings build() throws IOException {
      return new DataSourcesServiceSettings(this);
    }
  }
}
