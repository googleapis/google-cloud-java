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
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ReservationClient.AggregatedListReservationsPagedResponse;
import static com.google.cloud.compute.v1.ReservationClient.ListReservationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
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
import com.google.cloud.compute.v1.AggregatedListReservationsHttpRequest;
import com.google.cloud.compute.v1.DeleteReservationHttpRequest;
import com.google.cloud.compute.v1.GetIamPolicyReservationHttpRequest;
import com.google.cloud.compute.v1.GetReservationHttpRequest;
import com.google.cloud.compute.v1.InsertReservationHttpRequest;
import com.google.cloud.compute.v1.ListReservationsHttpRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.Reservation;
import com.google.cloud.compute.v1.ReservationAggregatedList;
import com.google.cloud.compute.v1.ReservationList;
import com.google.cloud.compute.v1.ReservationsScopedList;
import com.google.cloud.compute.v1.ResizeReservationHttpRequest;
import com.google.cloud.compute.v1.SetIamPolicyReservationHttpRequest;
import com.google.cloud.compute.v1.TestIamPermissionsReservationHttpRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ReservationStub}.
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
 * <p>For example, to set the total timeout of deleteReservation to 30 seconds:
 *
 * <pre>
 * <code>
 * ReservationStubSettings.Builder reservationSettingsBuilder =
 *     ReservationStubSettings.newBuilder();
 * reservationSettingsBuilder.deleteReservationSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ReservationStubSettings reservationSettings = reservationSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ReservationStubSettings extends StubSettings<ReservationStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .add("https://www.googleapis.com/auth/devstorage.full_control")
          .add("https://www.googleapis.com/auth/devstorage.read_only")
          .add("https://www.googleapis.com/auth/devstorage.read_write")
          .build();

  private final PagedCallSettings<
          AggregatedListReservationsHttpRequest,
          ReservationAggregatedList,
          AggregatedListReservationsPagedResponse>
      aggregatedListReservationsSettings;
  private final UnaryCallSettings<DeleteReservationHttpRequest, Operation>
      deleteReservationSettings;
  private final UnaryCallSettings<GetReservationHttpRequest, Reservation> getReservationSettings;
  private final UnaryCallSettings<GetIamPolicyReservationHttpRequest, Policy>
      getIamPolicyReservationSettings;
  private final UnaryCallSettings<InsertReservationHttpRequest, Operation>
      insertReservationSettings;
  private final PagedCallSettings<
          ListReservationsHttpRequest, ReservationList, ListReservationsPagedResponse>
      listReservationsSettings;
  private final UnaryCallSettings<ResizeReservationHttpRequest, Operation>
      resizeReservationSettings;
  private final UnaryCallSettings<SetIamPolicyReservationHttpRequest, Policy>
      setIamPolicyReservationSettings;
  private final UnaryCallSettings<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
      testIamPermissionsReservationSettings;

  /** Returns the object with the settings used for calls to aggregatedListReservations. */
  public PagedCallSettings<
          AggregatedListReservationsHttpRequest,
          ReservationAggregatedList,
          AggregatedListReservationsPagedResponse>
      aggregatedListReservationsSettings() {
    return aggregatedListReservationsSettings;
  }

  /** Returns the object with the settings used for calls to deleteReservation. */
  public UnaryCallSettings<DeleteReservationHttpRequest, Operation> deleteReservationSettings() {
    return deleteReservationSettings;
  }

  /** Returns the object with the settings used for calls to getReservation. */
  public UnaryCallSettings<GetReservationHttpRequest, Reservation> getReservationSettings() {
    return getReservationSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicyReservation. */
  public UnaryCallSettings<GetIamPolicyReservationHttpRequest, Policy>
      getIamPolicyReservationSettings() {
    return getIamPolicyReservationSettings;
  }

  /** Returns the object with the settings used for calls to insertReservation. */
  public UnaryCallSettings<InsertReservationHttpRequest, Operation> insertReservationSettings() {
    return insertReservationSettings;
  }

  /** Returns the object with the settings used for calls to listReservations. */
  public PagedCallSettings<
          ListReservationsHttpRequest, ReservationList, ListReservationsPagedResponse>
      listReservationsSettings() {
    return listReservationsSettings;
  }

  /** Returns the object with the settings used for calls to resizeReservation. */
  public UnaryCallSettings<ResizeReservationHttpRequest, Operation> resizeReservationSettings() {
    return resizeReservationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicyReservation. */
  public UnaryCallSettings<SetIamPolicyReservationHttpRequest, Policy>
      setIamPolicyReservationSettings() {
    return setIamPolicyReservationSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissionsReservation. */
  public UnaryCallSettings<TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
      testIamPermissionsReservationSettings() {
    return testIamPermissionsReservationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ReservationStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonReservationStub.create(this);
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
    return "https://www.googleapis.com/compute/v1/projects/";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ReservationStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected ReservationStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    aggregatedListReservationsSettings =
        settingsBuilder.aggregatedListReservationsSettings().build();
    deleteReservationSettings = settingsBuilder.deleteReservationSettings().build();
    getReservationSettings = settingsBuilder.getReservationSettings().build();
    getIamPolicyReservationSettings = settingsBuilder.getIamPolicyReservationSettings().build();
    insertReservationSettings = settingsBuilder.insertReservationSettings().build();
    listReservationsSettings = settingsBuilder.listReservationsSettings().build();
    resizeReservationSettings = settingsBuilder.resizeReservationSettings().build();
    setIamPolicyReservationSettings = settingsBuilder.setIamPolicyReservationSettings().build();
    testIamPermissionsReservationSettings =
        settingsBuilder.testIamPermissionsReservationSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListReservationsHttpRequest, ReservationAggregatedList, ReservationsScopedList>
      AGGREGATED_LIST_RESERVATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListReservationsHttpRequest,
              ReservationAggregatedList,
              ReservationsScopedList>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListReservationsHttpRequest injectToken(
                AggregatedListReservationsHttpRequest payload, String token) {
              return AggregatedListReservationsHttpRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public AggregatedListReservationsHttpRequest injectPageSize(
                AggregatedListReservationsHttpRequest payload, int pageSize) {
              return AggregatedListReservationsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListReservationsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ReservationAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ReservationsScopedList> extractResources(
                ReservationAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().values()
                  : ImmutableList.<ReservationsScopedList>of();
            }
          };

  private static final PagedListDescriptor<
          ListReservationsHttpRequest, ReservationList, Reservation>
      LIST_RESERVATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListReservationsHttpRequest, ReservationList, Reservation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReservationsHttpRequest injectToken(
                ListReservationsHttpRequest payload, String token) {
              return ListReservationsHttpRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReservationsHttpRequest injectPageSize(
                ListReservationsHttpRequest payload, int pageSize) {
              return ListReservationsHttpRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListReservationsHttpRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(ReservationList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Reservation> extractResources(ReservationList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Reservation>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListReservationsHttpRequest,
          ReservationAggregatedList,
          AggregatedListReservationsPagedResponse>
      AGGREGATED_LIST_RESERVATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListReservationsHttpRequest,
              ReservationAggregatedList,
              AggregatedListReservationsPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListReservationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListReservationsHttpRequest, ReservationAggregatedList>
                    callable,
                AggregatedListReservationsHttpRequest request,
                ApiCallContext context,
                ApiFuture<ReservationAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListReservationsHttpRequest,
                      ReservationAggregatedList,
                      ReservationsScopedList>
                  pageContext =
                      PageContext.create(
                          callable, AGGREGATED_LIST_RESERVATIONS_PAGE_STR_DESC, request, context);
              return AggregatedListReservationsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReservationsHttpRequest, ReservationList, ListReservationsPagedResponse>
      LIST_RESERVATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReservationsHttpRequest, ReservationList, ListReservationsPagedResponse>() {
            @Override
            public ApiFuture<ListReservationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReservationsHttpRequest, ReservationList> callable,
                ListReservationsHttpRequest request,
                ApiCallContext context,
                ApiFuture<ReservationList> futureResponse) {
              PageContext<ListReservationsHttpRequest, ReservationList, Reservation> pageContext =
                  PageContext.create(callable, LIST_RESERVATIONS_PAGE_STR_DESC, request, context);
              return ListReservationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ReservationStubSettings. */
  public static class Builder extends StubSettings.Builder<ReservationStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            AggregatedListReservationsHttpRequest,
            ReservationAggregatedList,
            AggregatedListReservationsPagedResponse>
        aggregatedListReservationsSettings;
    private final UnaryCallSettings.Builder<DeleteReservationHttpRequest, Operation>
        deleteReservationSettings;
    private final UnaryCallSettings.Builder<GetReservationHttpRequest, Reservation>
        getReservationSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyReservationHttpRequest, Policy>
        getIamPolicyReservationSettings;
    private final UnaryCallSettings.Builder<InsertReservationHttpRequest, Operation>
        insertReservationSettings;
    private final PagedCallSettings.Builder<
            ListReservationsHttpRequest, ReservationList, ListReservationsPagedResponse>
        listReservationsSettings;
    private final UnaryCallSettings.Builder<ResizeReservationHttpRequest, Operation>
        resizeReservationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyReservationHttpRequest, Policy>
        setIamPolicyReservationSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
        testIamPermissionsReservationSettings;

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

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      aggregatedListReservationsSettings =
          PagedCallSettings.newBuilder(AGGREGATED_LIST_RESERVATIONS_PAGE_STR_FACT);

      deleteReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicyReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listReservationsSettings = PagedCallSettings.newBuilder(LIST_RESERVATIONS_PAGE_STR_FACT);

      resizeReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setIamPolicyReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListReservationsSettings,
              deleteReservationSettings,
              getReservationSettings,
              getIamPolicyReservationSettings,
              insertReservationSettings,
              listReservationsSettings,
              resizeReservationSettings,
              setIamPolicyReservationSettings,
              testIamPermissionsReservationSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .aggregatedListReservationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicyReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listReservationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .resizeReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicyReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(ReservationStubSettings settings) {
      super(settings);

      aggregatedListReservationsSettings = settings.aggregatedListReservationsSettings.toBuilder();
      deleteReservationSettings = settings.deleteReservationSettings.toBuilder();
      getReservationSettings = settings.getReservationSettings.toBuilder();
      getIamPolicyReservationSettings = settings.getIamPolicyReservationSettings.toBuilder();
      insertReservationSettings = settings.insertReservationSettings.toBuilder();
      listReservationsSettings = settings.listReservationsSettings.toBuilder();
      resizeReservationSettings = settings.resizeReservationSettings.toBuilder();
      setIamPolicyReservationSettings = settings.setIamPolicyReservationSettings.toBuilder();
      testIamPermissionsReservationSettings =
          settings.testIamPermissionsReservationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              aggregatedListReservationsSettings,
              deleteReservationSettings,
              getReservationSettings,
              getIamPolicyReservationSettings,
              insertReservationSettings,
              listReservationsSettings,
              resizeReservationSettings,
              setIamPolicyReservationSettings,
              testIamPermissionsReservationSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to aggregatedListReservations. */
    public PagedCallSettings.Builder<
            AggregatedListReservationsHttpRequest,
            ReservationAggregatedList,
            AggregatedListReservationsPagedResponse>
        aggregatedListReservationsSettings() {
      return aggregatedListReservationsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReservation. */
    public UnaryCallSettings.Builder<DeleteReservationHttpRequest, Operation>
        deleteReservationSettings() {
      return deleteReservationSettings;
    }

    /** Returns the builder for the settings used for calls to getReservation. */
    public UnaryCallSettings.Builder<GetReservationHttpRequest, Reservation>
        getReservationSettings() {
      return getReservationSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicyReservation. */
    public UnaryCallSettings.Builder<GetIamPolicyReservationHttpRequest, Policy>
        getIamPolicyReservationSettings() {
      return getIamPolicyReservationSettings;
    }

    /** Returns the builder for the settings used for calls to insertReservation. */
    public UnaryCallSettings.Builder<InsertReservationHttpRequest, Operation>
        insertReservationSettings() {
      return insertReservationSettings;
    }

    /** Returns the builder for the settings used for calls to listReservations. */
    public PagedCallSettings.Builder<
            ListReservationsHttpRequest, ReservationList, ListReservationsPagedResponse>
        listReservationsSettings() {
      return listReservationsSettings;
    }

    /** Returns the builder for the settings used for calls to resizeReservation. */
    public UnaryCallSettings.Builder<ResizeReservationHttpRequest, Operation>
        resizeReservationSettings() {
      return resizeReservationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicyReservation. */
    public UnaryCallSettings.Builder<SetIamPolicyReservationHttpRequest, Policy>
        setIamPolicyReservationSettings() {
      return setIamPolicyReservationSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissionsReservation. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsReservationHttpRequest, TestPermissionsResponse>
        testIamPermissionsReservationSettings() {
      return testIamPermissionsReservationSettings;
    }

    @Override
    public ReservationStubSettings build() throws IOException {
      return new ReservationStubSettings(this);
    }
  }
}
