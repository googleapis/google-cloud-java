/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.vectorsearch.v1beta.stub;

import static com.google.cloud.vectorsearch.v1beta.DataObjectServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchCreateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.BatchDeleteDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsRequest;
import com.google.cloud.vectorsearch.v1beta.BatchUpdateDataObjectsResponse;
import com.google.cloud.vectorsearch.v1beta.CreateDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.DataObject;
import com.google.cloud.vectorsearch.v1beta.DeleteDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.GetDataObjectRequest;
import com.google.cloud.vectorsearch.v1beta.UpdateDataObjectRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataObjectServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (vectorsearch.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createDataObject:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataObjectServiceStubSettings.Builder dataObjectServiceSettingsBuilder =
 *     DataObjectServiceStubSettings.newBuilder();
 * dataObjectServiceSettingsBuilder
 *     .createDataObjectSettings()
 *     .setRetrySettings(
 *         dataObjectServiceSettingsBuilder
 *             .createDataObjectSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * DataObjectServiceStubSettings dataObjectServiceSettings =
 *     dataObjectServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataObjectServiceStubSettings extends StubSettings<DataObjectServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDataObjectRequest, DataObject> createDataObjectSettings;
  private final UnaryCallSettings<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsSettings;
  private final UnaryCallSettings<GetDataObjectRequest, DataObject> getDataObjectSettings;
  private final UnaryCallSettings<UpdateDataObjectRequest, DataObject> updateDataObjectSettings;
  private final UnaryCallSettings<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsSettings;
  private final UnaryCallSettings<DeleteDataObjectRequest, Empty> deleteDataObjectSettings;
  private final UnaryCallSettings<BatchDeleteDataObjectsRequest, Empty>
      batchDeleteDataObjectsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDataObject. */
  public UnaryCallSettings<CreateDataObjectRequest, DataObject> createDataObjectSettings() {
    return createDataObjectSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateDataObjects. */
  public UnaryCallSettings<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
      batchCreateDataObjectsSettings() {
    return batchCreateDataObjectsSettings;
  }

  /** Returns the object with the settings used for calls to getDataObject. */
  public UnaryCallSettings<GetDataObjectRequest, DataObject> getDataObjectSettings() {
    return getDataObjectSettings;
  }

  /** Returns the object with the settings used for calls to updateDataObject. */
  public UnaryCallSettings<UpdateDataObjectRequest, DataObject> updateDataObjectSettings() {
    return updateDataObjectSettings;
  }

  /** Returns the object with the settings used for calls to batchUpdateDataObjects. */
  public UnaryCallSettings<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
      batchUpdateDataObjectsSettings() {
    return batchUpdateDataObjectsSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataObject. */
  public UnaryCallSettings<DeleteDataObjectRequest, Empty> deleteDataObjectSettings() {
    return deleteDataObjectSettings;
  }

  /** Returns the object with the settings used for calls to batchDeleteDataObjects. */
  public UnaryCallSettings<BatchDeleteDataObjectsRequest, Empty> batchDeleteDataObjectsSettings() {
    return batchDeleteDataObjectsSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  public DataObjectServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataObjectServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataObjectServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "vectorsearch";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "vectorsearch.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "vectorsearch.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataObjectServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataObjectServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataObjectServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataObjectServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDataObjectSettings = settingsBuilder.createDataObjectSettings().build();
    batchCreateDataObjectsSettings = settingsBuilder.batchCreateDataObjectsSettings().build();
    getDataObjectSettings = settingsBuilder.getDataObjectSettings().build();
    updateDataObjectSettings = settingsBuilder.updateDataObjectSettings().build();
    batchUpdateDataObjectsSettings = settingsBuilder.batchUpdateDataObjectsSettings().build();
    deleteDataObjectSettings = settingsBuilder.deleteDataObjectSettings().build();
    batchDeleteDataObjectsSettings = settingsBuilder.batchDeleteDataObjectsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DataObjectServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<DataObjectServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDataObjectRequest, DataObject>
        createDataObjectSettings;
    private final UnaryCallSettings.Builder<
            BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
        batchCreateDataObjectsSettings;
    private final UnaryCallSettings.Builder<GetDataObjectRequest, DataObject> getDataObjectSettings;
    private final UnaryCallSettings.Builder<UpdateDataObjectRequest, DataObject>
        updateDataObjectSettings;
    private final UnaryCallSettings.Builder<
            BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
        batchUpdateDataObjectsSettings;
    private final UnaryCallSettings.Builder<DeleteDataObjectRequest, Empty>
        deleteDataObjectSettings;
    private final UnaryCallSettings.Builder<BatchDeleteDataObjectsRequest, Empty>
        batchDeleteDataObjectsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_2_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "no_retry_3_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_2_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setTotalTimeoutDuration(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_3_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDataObjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateDataObjectsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getDataObjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataObjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchUpdateDataObjectsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataObjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchDeleteDataObjectsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataObjectSettings,
              batchCreateDataObjectsSettings,
              getDataObjectSettings,
              updateDataObjectSettings,
              batchUpdateDataObjectsSettings,
              deleteDataObjectSettings,
              batchDeleteDataObjectsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DataObjectServiceStubSettings settings) {
      super(settings);

      createDataObjectSettings = settings.createDataObjectSettings.toBuilder();
      batchCreateDataObjectsSettings = settings.batchCreateDataObjectsSettings.toBuilder();
      getDataObjectSettings = settings.getDataObjectSettings.toBuilder();
      updateDataObjectSettings = settings.updateDataObjectSettings.toBuilder();
      batchUpdateDataObjectsSettings = settings.batchUpdateDataObjectsSettings.toBuilder();
      deleteDataObjectSettings = settings.deleteDataObjectSettings.toBuilder();
      batchDeleteDataObjectsSettings = settings.batchDeleteDataObjectsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataObjectSettings,
              batchCreateDataObjectsSettings,
              getDataObjectSettings,
              updateDataObjectSettings,
              batchUpdateDataObjectsSettings,
              deleteDataObjectSettings,
              batchDeleteDataObjectsSettings,
              listLocationsSettings,
              getLocationSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createDataObjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .batchCreateDataObjectsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_3_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_3_params"));

      builder
          .getDataObjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataObjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .batchUpdateDataObjectsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .deleteDataObjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .batchDeleteDataObjectsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_2_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createDataObject. */
    public UnaryCallSettings.Builder<CreateDataObjectRequest, DataObject>
        createDataObjectSettings() {
      return createDataObjectSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateDataObjects. */
    public UnaryCallSettings.Builder<BatchCreateDataObjectsRequest, BatchCreateDataObjectsResponse>
        batchCreateDataObjectsSettings() {
      return batchCreateDataObjectsSettings;
    }

    /** Returns the builder for the settings used for calls to getDataObject. */
    public UnaryCallSettings.Builder<GetDataObjectRequest, DataObject> getDataObjectSettings() {
      return getDataObjectSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataObject. */
    public UnaryCallSettings.Builder<UpdateDataObjectRequest, DataObject>
        updateDataObjectSettings() {
      return updateDataObjectSettings;
    }

    /** Returns the builder for the settings used for calls to batchUpdateDataObjects. */
    public UnaryCallSettings.Builder<BatchUpdateDataObjectsRequest, BatchUpdateDataObjectsResponse>
        batchUpdateDataObjectsSettings() {
      return batchUpdateDataObjectsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataObject. */
    public UnaryCallSettings.Builder<DeleteDataObjectRequest, Empty> deleteDataObjectSettings() {
      return deleteDataObjectSettings;
    }

    /** Returns the builder for the settings used for calls to batchDeleteDataObjects. */
    public UnaryCallSettings.Builder<BatchDeleteDataObjectsRequest, Empty>
        batchDeleteDataObjectsSettings() {
      return batchDeleteDataObjectsSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    @Override
    public DataObjectServiceStubSettings build() throws IOException {
      return new DataObjectServiceStubSettings(this);
    }
  }
}
