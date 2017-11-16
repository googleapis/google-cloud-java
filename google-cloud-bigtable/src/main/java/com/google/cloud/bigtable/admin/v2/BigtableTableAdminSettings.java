/*
 * Copyright 2017, Google LLC All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.admin.v2;

import static com.google.cloud.bigtable.admin.v2.PagedResponseWrappers.ListTablesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.grpc.GrpcExtraHeaderData;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.admin.v2.CreateTableRequest;
import com.google.bigtable.admin.v2.DeleteTableRequest;
import com.google.bigtable.admin.v2.DropRowRangeRequest;
import com.google.bigtable.admin.v2.GetTableRequest;
import com.google.bigtable.admin.v2.ListTablesRequest;
import com.google.bigtable.admin.v2.ListTablesResponse;
import com.google.bigtable.admin.v2.ModifyColumnFamiliesRequest;
import com.google.bigtable.admin.v2.Table;
import com.google.cloud.bigtable.admin.v2.stub.BigtableTableAdminStub;
import com.google.cloud.bigtable.admin.v2.stub.GrpcBigtableTableAdminStub;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link BigtableTableAdminClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigtableadmin.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of createTable to 30 seconds:
 *
 * <pre>
 * <code>
 * BigtableTableAdminSettings.Builder bigtableTableAdminSettingsBuilder =
 *     BigtableTableAdminSettings.newBuilder();
 * bigtableTableAdminSettingsBuilder.createTableSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * BigtableTableAdminSettings bigtableTableAdminSettings = bigtableTableAdminSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class BigtableTableAdminSettings extends ClientSettings<BigtableTableAdminSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigtable.admin")
          .add("https://www.googleapis.com/auth/bigtable.admin.cluster")
          .add("https://www.googleapis.com/auth/bigtable.admin.instance")
          .add("https://www.googleapis.com/auth/bigtable.admin.table")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin.cluster")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin.table")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE =
      "/com/google/cloud/bigtable/admin/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final UnaryCallSettings<CreateTableRequest, Table> createTableSettings;
  private final PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings;
  private final UnaryCallSettings<GetTableRequest, Table> getTableSettings;
  private final UnaryCallSettings<DeleteTableRequest, Empty> deleteTableSettings;
  private final UnaryCallSettings<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesSettings;
  private final UnaryCallSettings<DropRowRangeRequest, Empty> dropRowRangeSettings;

  /** Returns the object with the settings used for calls to createTable. */
  public UnaryCallSettings<CreateTableRequest, Table> createTableSettings() {
    return createTableSettings;
  }

  /** Returns the object with the settings used for calls to listTables. */
  public PagedCallSettings<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      listTablesSettings() {
    return listTablesSettings;
  }

  /** Returns the object with the settings used for calls to getTable. */
  public UnaryCallSettings<GetTableRequest, Table> getTableSettings() {
    return getTableSettings;
  }

  /** Returns the object with the settings used for calls to deleteTable. */
  public UnaryCallSettings<DeleteTableRequest, Empty> deleteTableSettings() {
    return deleteTableSettings;
  }

  /** Returns the object with the settings used for calls to modifyColumnFamilies. */
  public UnaryCallSettings<ModifyColumnFamiliesRequest, Table> modifyColumnFamiliesSettings() {
    return modifyColumnFamiliesSettings;
  }

  /** Returns the object with the settings used for calls to dropRowRange. */
  public UnaryCallSettings<DropRowRangeRequest, Empty> dropRowRangeSettings() {
    return dropRowRangeSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public BigtableTableAdminStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBigtableTableAdminStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "bigtableadmin.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion())
        .setApiClientHeaderLineKey("x-goog-api-client")
        .addApiClientHeaderLineData(GrpcExtraHeaderData.getXGoogApiClientData());
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(
              BigtableTableAdminSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
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

  private BigtableTableAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createTableSettings = settingsBuilder.createTableSettings().build();
    listTablesSettings = settingsBuilder.listTablesSettings().build();
    getTableSettings = settingsBuilder.getTableSettings().build();
    deleteTableSettings = settingsBuilder.deleteTableSettings().build();
    modifyColumnFamiliesSettings = settingsBuilder.modifyColumnFamiliesSettings().build();
    dropRowRangeSettings = settingsBuilder.dropRowRangeSettings().build();
  }

  private static final PagedListDescriptor<ListTablesRequest, ListTablesResponse, Table>
      LIST_TABLES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTablesRequest, ListTablesResponse, Table>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTablesRequest injectToken(ListTablesRequest payload, String token) {
              return ListTablesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTablesRequest injectPageSize(ListTablesRequest payload, int pageSize) {
              throw new UnsupportedOperationException(
                  "page size is not supported by this API method");
            }

            @Override
            public Integer extractPageSize(ListTablesRequest payload) {
              throw new UnsupportedOperationException(
                  "page size is not supported by this API method");
            }

            @Override
            public String extractNextToken(ListTablesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Table> extractResources(ListTablesResponse payload) {
              return payload.getTablesList();
            }
          };

  private static final PagedListResponseFactory<
          ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
      LIST_TABLES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>() {
            @Override
            public ApiFuture<ListTablesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTablesRequest, ListTablesResponse> callable,
                ListTablesRequest request,
                ApiCallContext context,
                ApiFuture<ListTablesResponse> futureResponse) {
              PageContext<ListTablesRequest, ListTablesResponse, Table> pageContext =
                  PageContext.create(callable, LIST_TABLES_PAGE_STR_DESC, request, context);
              return ListTablesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for BigtableTableAdminSettings. */
  public static class Builder extends ClientSettings.Builder<BigtableTableAdminSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<CreateTableRequest, Table> createTableSettings;
    private final PagedCallSettings.Builder<
            ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings;
    private final UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings;
    private final UnaryCallSettings.Builder<DeleteTableRequest, Empty> deleteTableSettings;
    private final UnaryCallSettings.Builder<ModifyColumnFamiliesRequest, Table>
        modifyColumnFamiliesSettings;
    private final UnaryCallSettings.Builder<DropRowRangeRequest, Empty> dropRowRangeSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      this((ClientContext) null);
    }

    private Builder(ClientContext clientContext) {
      super(clientContext);

      createTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listTablesSettings = PagedCallSettings.newBuilder(LIST_TABLES_PAGE_STR_FACT);

      getTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteTableSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      modifyColumnFamiliesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      dropRowRangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTableSettings,
              listTablesSettings,
              getTableSettings,
              deleteTableSettings,
              modifyColumnFamiliesSettings,
              dropRowRangeSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .createTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTablesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteTableSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .modifyColumnFamiliesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .dropRowRangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(BigtableTableAdminSettings settings) {
      super(settings);

      createTableSettings = settings.createTableSettings.toBuilder();
      listTablesSettings = settings.listTablesSettings.toBuilder();
      getTableSettings = settings.getTableSettings.toBuilder();
      deleteTableSettings = settings.deleteTableSettings.toBuilder();
      modifyColumnFamiliesSettings = settings.modifyColumnFamiliesSettings.toBuilder();
      dropRowRangeSettings = settings.dropRowRangeSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTableSettings,
              listTablesSettings,
              getTableSettings,
              deleteTableSettings,
              modifyColumnFamiliesSettings,
              dropRowRangeSettings);
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to createTable. */
    public UnaryCallSettings.Builder<CreateTableRequest, Table> createTableSettings() {
      return createTableSettings;
    }

    /** Returns the builder for the settings used for calls to listTables. */
    public PagedCallSettings.Builder<ListTablesRequest, ListTablesResponse, ListTablesPagedResponse>
        listTablesSettings() {
      return listTablesSettings;
    }

    /** Returns the builder for the settings used for calls to getTable. */
    public UnaryCallSettings.Builder<GetTableRequest, Table> getTableSettings() {
      return getTableSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTable. */
    public UnaryCallSettings.Builder<DeleteTableRequest, Empty> deleteTableSettings() {
      return deleteTableSettings;
    }

    /** Returns the builder for the settings used for calls to modifyColumnFamilies. */
    public UnaryCallSettings.Builder<ModifyColumnFamiliesRequest, Table>
        modifyColumnFamiliesSettings() {
      return modifyColumnFamiliesSettings;
    }

    /** Returns the builder for the settings used for calls to dropRowRange. */
    public UnaryCallSettings.Builder<DropRowRangeRequest, Empty> dropRowRangeSettings() {
      return dropRowRangeSettings;
    }

    @Override
    public BigtableTableAdminSettings build() throws IOException {
      return new BigtableTableAdminSettings(this);
    }
  }
}
