/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.example.library.v1.stub;

import static com.google.cloud.example.library.v1.LibraryServiceClient.ListBooksPagedResponse;
import static com.google.cloud.example.library.v1.LibraryServiceClient.ListShelvesPagedResponse;

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
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.example.library.v1.Book;
import com.google.example.library.v1.CreateBookRequest;
import com.google.example.library.v1.CreateShelfRequest;
import com.google.example.library.v1.DeleteBookRequest;
import com.google.example.library.v1.DeleteShelfRequest;
import com.google.example.library.v1.GetBookRequest;
import com.google.example.library.v1.GetShelfRequest;
import com.google.example.library.v1.ListBooksRequest;
import com.google.example.library.v1.ListBooksResponse;
import com.google.example.library.v1.ListShelvesRequest;
import com.google.example.library.v1.ListShelvesResponse;
import com.google.example.library.v1.MergeShelvesRequest;
import com.google.example.library.v1.MoveBookRequest;
import com.google.example.library.v1.Shelf;
import com.google.example.library.v1.UpdateBookRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LibraryServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (library-example.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createShelf:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LibraryServiceStubSettings.Builder libraryServiceSettingsBuilder =
 *     LibraryServiceStubSettings.newBuilder();
 * libraryServiceSettingsBuilder
 *     .createShelfSettings()
 *     .setRetrySettings(
 *         libraryServiceSettingsBuilder
 *             .createShelfSettings()
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
 * LibraryServiceStubSettings libraryServiceSettings = libraryServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class LibraryServiceStubSettings extends StubSettings<LibraryServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<CreateShelfRequest, Shelf> createShelfSettings;
  private final UnaryCallSettings<GetShelfRequest, Shelf> getShelfSettings;
  private final PagedCallSettings<ListShelvesRequest, ListShelvesResponse, ListShelvesPagedResponse>
      listShelvesSettings;
  private final UnaryCallSettings<DeleteShelfRequest, Empty> deleteShelfSettings;
  private final UnaryCallSettings<MergeShelvesRequest, Shelf> mergeShelvesSettings;
  private final UnaryCallSettings<CreateBookRequest, Book> createBookSettings;
  private final UnaryCallSettings<GetBookRequest, Book> getBookSettings;
  private final PagedCallSettings<ListBooksRequest, ListBooksResponse, ListBooksPagedResponse>
      listBooksSettings;
  private final UnaryCallSettings<DeleteBookRequest, Empty> deleteBookSettings;
  private final UnaryCallSettings<UpdateBookRequest, Book> updateBookSettings;
  private final UnaryCallSettings<MoveBookRequest, Book> moveBookSettings;

  private static final PagedListDescriptor<ListShelvesRequest, ListShelvesResponse, Shelf>
      LIST_SHELVES_PAGE_STR_DESC =
          new PagedListDescriptor<ListShelvesRequest, ListShelvesResponse, Shelf>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListShelvesRequest injectToken(ListShelvesRequest payload, String token) {
              return ListShelvesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListShelvesRequest injectPageSize(ListShelvesRequest payload, int pageSize) {
              return ListShelvesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListShelvesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListShelvesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Shelf> extractResources(ListShelvesResponse payload) {
              return payload.getShelvesList();
            }
          };

  private static final PagedListDescriptor<ListBooksRequest, ListBooksResponse, Book>
      LIST_BOOKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBooksRequest, ListBooksResponse, Book>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBooksRequest injectToken(ListBooksRequest payload, String token) {
              return ListBooksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBooksRequest injectPageSize(ListBooksRequest payload, int pageSize) {
              return ListBooksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBooksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBooksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Book> extractResources(ListBooksResponse payload) {
              return payload.getBooksList();
            }
          };

  private static final PagedListResponseFactory<
          ListShelvesRequest, ListShelvesResponse, ListShelvesPagedResponse>
      LIST_SHELVES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListShelvesRequest, ListShelvesResponse, ListShelvesPagedResponse>() {
            @Override
            public ApiFuture<ListShelvesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListShelvesRequest, ListShelvesResponse> callable,
                ListShelvesRequest request,
                ApiCallContext context,
                ApiFuture<ListShelvesResponse> futureResponse) {
              PageContext<ListShelvesRequest, ListShelvesResponse, Shelf> pageContext =
                  PageContext.create(callable, LIST_SHELVES_PAGE_STR_DESC, request, context);
              return ListShelvesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBooksRequest, ListBooksResponse, ListBooksPagedResponse>
      LIST_BOOKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBooksRequest, ListBooksResponse, ListBooksPagedResponse>() {
            @Override
            public ApiFuture<ListBooksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBooksRequest, ListBooksResponse> callable,
                ListBooksRequest request,
                ApiCallContext context,
                ApiFuture<ListBooksResponse> futureResponse) {
              PageContext<ListBooksRequest, ListBooksResponse, Book> pageContext =
                  PageContext.create(callable, LIST_BOOKS_PAGE_STR_DESC, request, context);
              return ListBooksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createShelf. */
  public UnaryCallSettings<CreateShelfRequest, Shelf> createShelfSettings() {
    return createShelfSettings;
  }

  /** Returns the object with the settings used for calls to getShelf. */
  public UnaryCallSettings<GetShelfRequest, Shelf> getShelfSettings() {
    return getShelfSettings;
  }

  /** Returns the object with the settings used for calls to listShelves. */
  public PagedCallSettings<ListShelvesRequest, ListShelvesResponse, ListShelvesPagedResponse>
      listShelvesSettings() {
    return listShelvesSettings;
  }

  /** Returns the object with the settings used for calls to deleteShelf. */
  public UnaryCallSettings<DeleteShelfRequest, Empty> deleteShelfSettings() {
    return deleteShelfSettings;
  }

  /** Returns the object with the settings used for calls to mergeShelves. */
  public UnaryCallSettings<MergeShelvesRequest, Shelf> mergeShelvesSettings() {
    return mergeShelvesSettings;
  }

  /** Returns the object with the settings used for calls to createBook. */
  public UnaryCallSettings<CreateBookRequest, Book> createBookSettings() {
    return createBookSettings;
  }

  /** Returns the object with the settings used for calls to getBook. */
  public UnaryCallSettings<GetBookRequest, Book> getBookSettings() {
    return getBookSettings;
  }

  /** Returns the object with the settings used for calls to listBooks. */
  public PagedCallSettings<ListBooksRequest, ListBooksResponse, ListBooksPagedResponse>
      listBooksSettings() {
    return listBooksSettings;
  }

  /** Returns the object with the settings used for calls to deleteBook. */
  public UnaryCallSettings<DeleteBookRequest, Empty> deleteBookSettings() {
    return deleteBookSettings;
  }

  /** Returns the object with the settings used for calls to updateBook. */
  public UnaryCallSettings<UpdateBookRequest, Book> updateBookSettings() {
    return updateBookSettings;
  }

  /** Returns the object with the settings used for calls to moveBook. */
  public UnaryCallSettings<MoveBookRequest, Book> moveBookSettings() {
    return moveBookSettings;
  }

  public LibraryServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcLibraryServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLibraryServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "library-example";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "library-example.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "library-example.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(LibraryServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(LibraryServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LibraryServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected LibraryServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createShelfSettings = settingsBuilder.createShelfSettings().build();
    getShelfSettings = settingsBuilder.getShelfSettings().build();
    listShelvesSettings = settingsBuilder.listShelvesSettings().build();
    deleteShelfSettings = settingsBuilder.deleteShelfSettings().build();
    mergeShelvesSettings = settingsBuilder.mergeShelvesSettings().build();
    createBookSettings = settingsBuilder.createBookSettings().build();
    getBookSettings = settingsBuilder.getBookSettings().build();
    listBooksSettings = settingsBuilder.listBooksSettings().build();
    deleteBookSettings = settingsBuilder.deleteBookSettings().build();
    updateBookSettings = settingsBuilder.updateBookSettings().build();
    moveBookSettings = settingsBuilder.moveBookSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder().build();
  }

  /** Builder for LibraryServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<LibraryServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateShelfRequest, Shelf> createShelfSettings;
    private final UnaryCallSettings.Builder<GetShelfRequest, Shelf> getShelfSettings;
    private final PagedCallSettings.Builder<
            ListShelvesRequest, ListShelvesResponse, ListShelvesPagedResponse>
        listShelvesSettings;
    private final UnaryCallSettings.Builder<DeleteShelfRequest, Empty> deleteShelfSettings;
    private final UnaryCallSettings.Builder<MergeShelvesRequest, Shelf> mergeShelvesSettings;
    private final UnaryCallSettings.Builder<CreateBookRequest, Book> createBookSettings;
    private final UnaryCallSettings.Builder<GetBookRequest, Book> getBookSettings;
    private final PagedCallSettings.Builder<
            ListBooksRequest, ListBooksResponse, ListBooksPagedResponse>
        listBooksSettings;
    private final UnaryCallSettings.Builder<DeleteBookRequest, Empty> deleteBookSettings;
    private final UnaryCallSettings.Builder<UpdateBookRequest, Book> updateBookSettings;
    private final UnaryCallSettings.Builder<MoveBookRequest, Book> moveBookSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createShelfSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getShelfSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listShelvesSettings = PagedCallSettings.newBuilder(LIST_SHELVES_PAGE_STR_FACT);
      deleteShelfSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      mergeShelvesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBooksSettings = PagedCallSettings.newBuilder(LIST_BOOKS_PAGE_STR_FACT);
      deleteBookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      moveBookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createShelfSettings,
              getShelfSettings,
              listShelvesSettings,
              deleteShelfSettings,
              mergeShelvesSettings,
              createBookSettings,
              getBookSettings,
              listBooksSettings,
              deleteBookSettings,
              updateBookSettings,
              moveBookSettings);
      initDefaults(this);
    }

    protected Builder(LibraryServiceStubSettings settings) {
      super(settings);

      createShelfSettings = settings.createShelfSettings.toBuilder();
      getShelfSettings = settings.getShelfSettings.toBuilder();
      listShelvesSettings = settings.listShelvesSettings.toBuilder();
      deleteShelfSettings = settings.deleteShelfSettings.toBuilder();
      mergeShelvesSettings = settings.mergeShelvesSettings.toBuilder();
      createBookSettings = settings.createBookSettings.toBuilder();
      getBookSettings = settings.getBookSettings.toBuilder();
      listBooksSettings = settings.listBooksSettings.toBuilder();
      deleteBookSettings = settings.deleteBookSettings.toBuilder();
      updateBookSettings = settings.updateBookSettings.toBuilder();
      moveBookSettings = settings.moveBookSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createShelfSettings,
              getShelfSettings,
              listShelvesSettings,
              deleteShelfSettings,
              mergeShelvesSettings,
              createBookSettings,
              getBookSettings,
              listBooksSettings,
              deleteBookSettings,
              updateBookSettings,
              moveBookSettings);
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
          .createShelfSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getShelfSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listShelvesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteShelfSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .mergeShelvesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createBookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getBookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBooksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteBookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateBookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .moveBookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

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

    /** Returns the builder for the settings used for calls to createShelf. */
    public UnaryCallSettings.Builder<CreateShelfRequest, Shelf> createShelfSettings() {
      return createShelfSettings;
    }

    /** Returns the builder for the settings used for calls to getShelf. */
    public UnaryCallSettings.Builder<GetShelfRequest, Shelf> getShelfSettings() {
      return getShelfSettings;
    }

    /** Returns the builder for the settings used for calls to listShelves. */
    public PagedCallSettings.Builder<
            ListShelvesRequest, ListShelvesResponse, ListShelvesPagedResponse>
        listShelvesSettings() {
      return listShelvesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteShelf. */
    public UnaryCallSettings.Builder<DeleteShelfRequest, Empty> deleteShelfSettings() {
      return deleteShelfSettings;
    }

    /** Returns the builder for the settings used for calls to mergeShelves. */
    public UnaryCallSettings.Builder<MergeShelvesRequest, Shelf> mergeShelvesSettings() {
      return mergeShelvesSettings;
    }

    /** Returns the builder for the settings used for calls to createBook. */
    public UnaryCallSettings.Builder<CreateBookRequest, Book> createBookSettings() {
      return createBookSettings;
    }

    /** Returns the builder for the settings used for calls to getBook. */
    public UnaryCallSettings.Builder<GetBookRequest, Book> getBookSettings() {
      return getBookSettings;
    }

    /** Returns the builder for the settings used for calls to listBooks. */
    public PagedCallSettings.Builder<ListBooksRequest, ListBooksResponse, ListBooksPagedResponse>
        listBooksSettings() {
      return listBooksSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBook. */
    public UnaryCallSettings.Builder<DeleteBookRequest, Empty> deleteBookSettings() {
      return deleteBookSettings;
    }

    /** Returns the builder for the settings used for calls to updateBook. */
    public UnaryCallSettings.Builder<UpdateBookRequest, Book> updateBookSettings() {
      return updateBookSettings;
    }

    /** Returns the builder for the settings used for calls to moveBook. */
    public UnaryCallSettings.Builder<MoveBookRequest, Book> moveBookSettings() {
      return moveBookSettings;
    }

    @Override
    public LibraryServiceStubSettings build() throws IOException {
      return new LibraryServiceStubSettings(this);
    }
  }
}
