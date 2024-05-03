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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybookVersionsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.PlaybooksClient.ListPlaybooksPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CreatePlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.DeletePlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetPlaybookVersionRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybookVersionsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListPlaybooksResponse;
import com.google.cloud.dialogflow.cx.v3beta1.Playbook;
import com.google.cloud.dialogflow.cx.v3beta1.PlaybookVersion;
import com.google.cloud.dialogflow.cx.v3beta1.UpdatePlaybookRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PlaybooksStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createPlaybook to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PlaybooksStubSettings.Builder playbooksSettingsBuilder = PlaybooksStubSettings.newBuilder();
 * playbooksSettingsBuilder
 *     .createPlaybookSettings()
 *     .setRetrySettings(
 *         playbooksSettingsBuilder
 *             .createPlaybookSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PlaybooksStubSettings playbooksSettings = playbooksSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PlaybooksStubSettings extends StubSettings<PlaybooksStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/dialogflow")
          .build();

  private final UnaryCallSettings<CreatePlaybookRequest, Playbook> createPlaybookSettings;
  private final UnaryCallSettings<DeletePlaybookRequest, Empty> deletePlaybookSettings;
  private final PagedCallSettings<
          ListPlaybooksRequest, ListPlaybooksResponse, ListPlaybooksPagedResponse>
      listPlaybooksSettings;
  private final UnaryCallSettings<GetPlaybookRequest, Playbook> getPlaybookSettings;
  private final UnaryCallSettings<UpdatePlaybookRequest, Playbook> updatePlaybookSettings;
  private final UnaryCallSettings<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionSettings;
  private final UnaryCallSettings<GetPlaybookVersionRequest, PlaybookVersion>
      getPlaybookVersionSettings;
  private final PagedCallSettings<
          ListPlaybookVersionsRequest,
          ListPlaybookVersionsResponse,
          ListPlaybookVersionsPagedResponse>
      listPlaybookVersionsSettings;
  private final UnaryCallSettings<DeletePlaybookVersionRequest, Empty>
      deletePlaybookVersionSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListPlaybooksRequest, ListPlaybooksResponse, Playbook>
      LIST_PLAYBOOKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListPlaybooksRequest, ListPlaybooksResponse, Playbook>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPlaybooksRequest injectToken(ListPlaybooksRequest payload, String token) {
              return ListPlaybooksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPlaybooksRequest injectPageSize(ListPlaybooksRequest payload, int pageSize) {
              return ListPlaybooksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPlaybooksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPlaybooksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Playbook> extractResources(ListPlaybooksResponse payload) {
              return payload.getPlaybooksList() == null
                  ? ImmutableList.<Playbook>of()
                  : payload.getPlaybooksList();
            }
          };

  private static final PagedListDescriptor<
          ListPlaybookVersionsRequest, ListPlaybookVersionsResponse, PlaybookVersion>
      LIST_PLAYBOOK_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPlaybookVersionsRequest, ListPlaybookVersionsResponse, PlaybookVersion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPlaybookVersionsRequest injectToken(
                ListPlaybookVersionsRequest payload, String token) {
              return ListPlaybookVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPlaybookVersionsRequest injectPageSize(
                ListPlaybookVersionsRequest payload, int pageSize) {
              return ListPlaybookVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPlaybookVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPlaybookVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PlaybookVersion> extractResources(
                ListPlaybookVersionsResponse payload) {
              return payload.getPlaybookVersionsList() == null
                  ? ImmutableList.<PlaybookVersion>of()
                  : payload.getPlaybookVersionsList();
            }
          };

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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPlaybooksRequest, ListPlaybooksResponse, ListPlaybooksPagedResponse>
      LIST_PLAYBOOKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPlaybooksRequest, ListPlaybooksResponse, ListPlaybooksPagedResponse>() {
            @Override
            public ApiFuture<ListPlaybooksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPlaybooksRequest, ListPlaybooksResponse> callable,
                ListPlaybooksRequest request,
                ApiCallContext context,
                ApiFuture<ListPlaybooksResponse> futureResponse) {
              PageContext<ListPlaybooksRequest, ListPlaybooksResponse, Playbook> pageContext =
                  PageContext.create(callable, LIST_PLAYBOOKS_PAGE_STR_DESC, request, context);
              return ListPlaybooksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPlaybookVersionsRequest,
          ListPlaybookVersionsResponse,
          ListPlaybookVersionsPagedResponse>
      LIST_PLAYBOOK_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPlaybookVersionsRequest,
              ListPlaybookVersionsResponse,
              ListPlaybookVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListPlaybookVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPlaybookVersionsRequest, ListPlaybookVersionsResponse> callable,
                ListPlaybookVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPlaybookVersionsResponse> futureResponse) {
              PageContext<
                      ListPlaybookVersionsRequest, ListPlaybookVersionsResponse, PlaybookVersion>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PLAYBOOK_VERSIONS_PAGE_STR_DESC, request, context);
              return ListPlaybookVersionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createPlaybook. */
  public UnaryCallSettings<CreatePlaybookRequest, Playbook> createPlaybookSettings() {
    return createPlaybookSettings;
  }

  /** Returns the object with the settings used for calls to deletePlaybook. */
  public UnaryCallSettings<DeletePlaybookRequest, Empty> deletePlaybookSettings() {
    return deletePlaybookSettings;
  }

  /** Returns the object with the settings used for calls to listPlaybooks. */
  public PagedCallSettings<ListPlaybooksRequest, ListPlaybooksResponse, ListPlaybooksPagedResponse>
      listPlaybooksSettings() {
    return listPlaybooksSettings;
  }

  /** Returns the object with the settings used for calls to getPlaybook. */
  public UnaryCallSettings<GetPlaybookRequest, Playbook> getPlaybookSettings() {
    return getPlaybookSettings;
  }

  /** Returns the object with the settings used for calls to updatePlaybook. */
  public UnaryCallSettings<UpdatePlaybookRequest, Playbook> updatePlaybookSettings() {
    return updatePlaybookSettings;
  }

  /** Returns the object with the settings used for calls to createPlaybookVersion. */
  public UnaryCallSettings<CreatePlaybookVersionRequest, PlaybookVersion>
      createPlaybookVersionSettings() {
    return createPlaybookVersionSettings;
  }

  /** Returns the object with the settings used for calls to getPlaybookVersion. */
  public UnaryCallSettings<GetPlaybookVersionRequest, PlaybookVersion>
      getPlaybookVersionSettings() {
    return getPlaybookVersionSettings;
  }

  /** Returns the object with the settings used for calls to listPlaybookVersions. */
  public PagedCallSettings<
          ListPlaybookVersionsRequest,
          ListPlaybookVersionsResponse,
          ListPlaybookVersionsPagedResponse>
      listPlaybookVersionsSettings() {
    return listPlaybookVersionsSettings;
  }

  /** Returns the object with the settings used for calls to deletePlaybookVersion. */
  public UnaryCallSettings<DeletePlaybookVersionRequest, Empty> deletePlaybookVersionSettings() {
    return deletePlaybookVersionSettings;
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

  public PlaybooksStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPlaybooksStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPlaybooksStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "dialogflow";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "dialogflow.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dialogflow.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(PlaybooksStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(PlaybooksStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PlaybooksStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected PlaybooksStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createPlaybookSettings = settingsBuilder.createPlaybookSettings().build();
    deletePlaybookSettings = settingsBuilder.deletePlaybookSettings().build();
    listPlaybooksSettings = settingsBuilder.listPlaybooksSettings().build();
    getPlaybookSettings = settingsBuilder.getPlaybookSettings().build();
    updatePlaybookSettings = settingsBuilder.updatePlaybookSettings().build();
    createPlaybookVersionSettings = settingsBuilder.createPlaybookVersionSettings().build();
    getPlaybookVersionSettings = settingsBuilder.getPlaybookVersionSettings().build();
    listPlaybookVersionsSettings = settingsBuilder.listPlaybookVersionsSettings().build();
    deletePlaybookVersionSettings = settingsBuilder.deletePlaybookVersionSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for PlaybooksStubSettings. */
  public static class Builder extends StubSettings.Builder<PlaybooksStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreatePlaybookRequest, Playbook> createPlaybookSettings;
    private final UnaryCallSettings.Builder<DeletePlaybookRequest, Empty> deletePlaybookSettings;
    private final PagedCallSettings.Builder<
            ListPlaybooksRequest, ListPlaybooksResponse, ListPlaybooksPagedResponse>
        listPlaybooksSettings;
    private final UnaryCallSettings.Builder<GetPlaybookRequest, Playbook> getPlaybookSettings;
    private final UnaryCallSettings.Builder<UpdatePlaybookRequest, Playbook> updatePlaybookSettings;
    private final UnaryCallSettings.Builder<CreatePlaybookVersionRequest, PlaybookVersion>
        createPlaybookVersionSettings;
    private final UnaryCallSettings.Builder<GetPlaybookVersionRequest, PlaybookVersion>
        getPlaybookVersionSettings;
    private final PagedCallSettings.Builder<
            ListPlaybookVersionsRequest,
            ListPlaybookVersionsResponse,
            ListPlaybookVersionsPagedResponse>
        listPlaybookVersionsSettings;
    private final UnaryCallSettings.Builder<DeletePlaybookVersionRequest, Empty>
        deletePlaybookVersionSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createPlaybookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePlaybookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPlaybooksSettings = PagedCallSettings.newBuilder(LIST_PLAYBOOKS_PAGE_STR_FACT);
      getPlaybookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePlaybookSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPlaybookVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPlaybookVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPlaybookVersionsSettings =
          PagedCallSettings.newBuilder(LIST_PLAYBOOK_VERSIONS_PAGE_STR_FACT);
      deletePlaybookVersionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPlaybookSettings,
              deletePlaybookSettings,
              listPlaybooksSettings,
              getPlaybookSettings,
              updatePlaybookSettings,
              createPlaybookVersionSettings,
              getPlaybookVersionSettings,
              listPlaybookVersionsSettings,
              deletePlaybookVersionSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(PlaybooksStubSettings settings) {
      super(settings);

      createPlaybookSettings = settings.createPlaybookSettings.toBuilder();
      deletePlaybookSettings = settings.deletePlaybookSettings.toBuilder();
      listPlaybooksSettings = settings.listPlaybooksSettings.toBuilder();
      getPlaybookSettings = settings.getPlaybookSettings.toBuilder();
      updatePlaybookSettings = settings.updatePlaybookSettings.toBuilder();
      createPlaybookVersionSettings = settings.createPlaybookVersionSettings.toBuilder();
      getPlaybookVersionSettings = settings.getPlaybookVersionSettings.toBuilder();
      listPlaybookVersionsSettings = settings.listPlaybookVersionsSettings.toBuilder();
      deletePlaybookVersionSettings = settings.deletePlaybookVersionSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPlaybookSettings,
              deletePlaybookSettings,
              listPlaybooksSettings,
              getPlaybookSettings,
              updatePlaybookSettings,
              createPlaybookVersionSettings,
              getPlaybookVersionSettings,
              listPlaybookVersionsSettings,
              deletePlaybookVersionSettings,
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
          .createPlaybookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deletePlaybookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPlaybooksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPlaybookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updatePlaybookSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createPlaybookVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPlaybookVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPlaybookVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deletePlaybookVersionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to createPlaybook. */
    public UnaryCallSettings.Builder<CreatePlaybookRequest, Playbook> createPlaybookSettings() {
      return createPlaybookSettings;
    }

    /** Returns the builder for the settings used for calls to deletePlaybook. */
    public UnaryCallSettings.Builder<DeletePlaybookRequest, Empty> deletePlaybookSettings() {
      return deletePlaybookSettings;
    }

    /** Returns the builder for the settings used for calls to listPlaybooks. */
    public PagedCallSettings.Builder<
            ListPlaybooksRequest, ListPlaybooksResponse, ListPlaybooksPagedResponse>
        listPlaybooksSettings() {
      return listPlaybooksSettings;
    }

    /** Returns the builder for the settings used for calls to getPlaybook. */
    public UnaryCallSettings.Builder<GetPlaybookRequest, Playbook> getPlaybookSettings() {
      return getPlaybookSettings;
    }

    /** Returns the builder for the settings used for calls to updatePlaybook. */
    public UnaryCallSettings.Builder<UpdatePlaybookRequest, Playbook> updatePlaybookSettings() {
      return updatePlaybookSettings;
    }

    /** Returns the builder for the settings used for calls to createPlaybookVersion. */
    public UnaryCallSettings.Builder<CreatePlaybookVersionRequest, PlaybookVersion>
        createPlaybookVersionSettings() {
      return createPlaybookVersionSettings;
    }

    /** Returns the builder for the settings used for calls to getPlaybookVersion. */
    public UnaryCallSettings.Builder<GetPlaybookVersionRequest, PlaybookVersion>
        getPlaybookVersionSettings() {
      return getPlaybookVersionSettings;
    }

    /** Returns the builder for the settings used for calls to listPlaybookVersions. */
    public PagedCallSettings.Builder<
            ListPlaybookVersionsRequest,
            ListPlaybookVersionsResponse,
            ListPlaybookVersionsPagedResponse>
        listPlaybookVersionsSettings() {
      return listPlaybookVersionsSettings;
    }

    /** Returns the builder for the settings used for calls to deletePlaybookVersion. */
    public UnaryCallSettings.Builder<DeletePlaybookVersionRequest, Empty>
        deletePlaybookVersionSettings() {
      return deletePlaybookVersionSettings;
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
    public PlaybooksStubSettings build() throws IOException {
      return new PlaybooksStubSettings(this);
    }
  }
}
