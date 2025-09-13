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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginInstancesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubPluginClient.ListPluginsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.CreatePluginInstanceRequest;
import com.google.cloud.apihub.v1.CreatePluginRequest;
import com.google.cloud.apihub.v1.DeletePluginInstanceRequest;
import com.google.cloud.apihub.v1.DeletePluginRequest;
import com.google.cloud.apihub.v1.DisablePluginInstanceActionRequest;
import com.google.cloud.apihub.v1.DisablePluginInstanceActionResponse;
import com.google.cloud.apihub.v1.DisablePluginRequest;
import com.google.cloud.apihub.v1.EnablePluginInstanceActionRequest;
import com.google.cloud.apihub.v1.EnablePluginInstanceActionResponse;
import com.google.cloud.apihub.v1.EnablePluginRequest;
import com.google.cloud.apihub.v1.ExecutePluginInstanceActionRequest;
import com.google.cloud.apihub.v1.ExecutePluginInstanceActionResponse;
import com.google.cloud.apihub.v1.GetPluginInstanceRequest;
import com.google.cloud.apihub.v1.GetPluginRequest;
import com.google.cloud.apihub.v1.ListPluginInstancesRequest;
import com.google.cloud.apihub.v1.ListPluginInstancesResponse;
import com.google.cloud.apihub.v1.ListPluginsRequest;
import com.google.cloud.apihub.v1.ListPluginsResponse;
import com.google.cloud.apihub.v1.OperationMetadata;
import com.google.cloud.apihub.v1.Plugin;
import com.google.cloud.apihub.v1.PluginInstance;
import com.google.cloud.apihub.v1.UpdatePluginInstanceRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiHubPluginStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apihub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getPlugin:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubPluginStubSettings.Builder apiHubPluginSettingsBuilder =
 *     ApiHubPluginStubSettings.newBuilder();
 * apiHubPluginSettingsBuilder
 *     .getPluginSettings()
 *     .setRetrySettings(
 *         apiHubPluginSettingsBuilder
 *             .getPluginSettings()
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
 * ApiHubPluginStubSettings apiHubPluginSettings = apiHubPluginSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for deletePlugin:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubPluginStubSettings.Builder apiHubPluginSettingsBuilder =
 *     ApiHubPluginStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * apiHubPluginSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApiHubPluginStubSettings extends StubSettings<ApiHubPluginStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetPluginRequest, Plugin> getPluginSettings;
  private final UnaryCallSettings<EnablePluginRequest, Plugin> enablePluginSettings;
  private final UnaryCallSettings<DisablePluginRequest, Plugin> disablePluginSettings;
  private final UnaryCallSettings<CreatePluginRequest, Plugin> createPluginSettings;
  private final PagedCallSettings<ListPluginsRequest, ListPluginsResponse, ListPluginsPagedResponse>
      listPluginsSettings;
  private final UnaryCallSettings<DeletePluginRequest, Operation> deletePluginSettings;
  private final OperationCallSettings<DeletePluginRequest, Empty, OperationMetadata>
      deletePluginOperationSettings;
  private final UnaryCallSettings<CreatePluginInstanceRequest, Operation>
      createPluginInstanceSettings;
  private final OperationCallSettings<
          CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
      createPluginInstanceOperationSettings;
  private final UnaryCallSettings<ExecutePluginInstanceActionRequest, Operation>
      executePluginInstanceActionSettings;
  private final OperationCallSettings<
          ExecutePluginInstanceActionRequest,
          ExecutePluginInstanceActionResponse,
          OperationMetadata>
      executePluginInstanceActionOperationSettings;
  private final UnaryCallSettings<GetPluginInstanceRequest, PluginInstance>
      getPluginInstanceSettings;
  private final PagedCallSettings<
          ListPluginInstancesRequest, ListPluginInstancesResponse, ListPluginInstancesPagedResponse>
      listPluginInstancesSettings;
  private final UnaryCallSettings<EnablePluginInstanceActionRequest, Operation>
      enablePluginInstanceActionSettings;
  private final OperationCallSettings<
          EnablePluginInstanceActionRequest, EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionOperationSettings;
  private final UnaryCallSettings<DisablePluginInstanceActionRequest, Operation>
      disablePluginInstanceActionSettings;
  private final OperationCallSettings<
          DisablePluginInstanceActionRequest,
          DisablePluginInstanceActionResponse,
          OperationMetadata>
      disablePluginInstanceActionOperationSettings;
  private final UnaryCallSettings<UpdatePluginInstanceRequest, PluginInstance>
      updatePluginInstanceSettings;
  private final UnaryCallSettings<DeletePluginInstanceRequest, Operation>
      deletePluginInstanceSettings;
  private final OperationCallSettings<DeletePluginInstanceRequest, Empty, OperationMetadata>
      deletePluginInstanceOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListPluginsRequest, ListPluginsResponse, Plugin>
      LIST_PLUGINS_PAGE_STR_DESC =
          new PagedListDescriptor<ListPluginsRequest, ListPluginsResponse, Plugin>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPluginsRequest injectToken(ListPluginsRequest payload, String token) {
              return ListPluginsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPluginsRequest injectPageSize(ListPluginsRequest payload, int pageSize) {
              return ListPluginsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPluginsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPluginsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Plugin> extractResources(ListPluginsResponse payload) {
              return payload.getPluginsList();
            }
          };

  private static final PagedListDescriptor<
          ListPluginInstancesRequest, ListPluginInstancesResponse, PluginInstance>
      LIST_PLUGIN_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPluginInstancesRequest, ListPluginInstancesResponse, PluginInstance>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPluginInstancesRequest injectToken(
                ListPluginInstancesRequest payload, String token) {
              return ListPluginInstancesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPluginInstancesRequest injectPageSize(
                ListPluginInstancesRequest payload, int pageSize) {
              return ListPluginInstancesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPluginInstancesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPluginInstancesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PluginInstance> extractResources(ListPluginInstancesResponse payload) {
              return payload.getPluginInstancesList();
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
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPluginsRequest, ListPluginsResponse, ListPluginsPagedResponse>
      LIST_PLUGINS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPluginsRequest, ListPluginsResponse, ListPluginsPagedResponse>() {
            @Override
            public ApiFuture<ListPluginsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPluginsRequest, ListPluginsResponse> callable,
                ListPluginsRequest request,
                ApiCallContext context,
                ApiFuture<ListPluginsResponse> futureResponse) {
              PageContext<ListPluginsRequest, ListPluginsResponse, Plugin> pageContext =
                  PageContext.create(callable, LIST_PLUGINS_PAGE_STR_DESC, request, context);
              return ListPluginsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPluginInstancesRequest, ListPluginInstancesResponse, ListPluginInstancesPagedResponse>
      LIST_PLUGIN_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPluginInstancesRequest,
              ListPluginInstancesResponse,
              ListPluginInstancesPagedResponse>() {
            @Override
            public ApiFuture<ListPluginInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPluginInstancesRequest, ListPluginInstancesResponse> callable,
                ListPluginInstancesRequest request,
                ApiCallContext context,
                ApiFuture<ListPluginInstancesResponse> futureResponse) {
              PageContext<ListPluginInstancesRequest, ListPluginInstancesResponse, PluginInstance>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PLUGIN_INSTANCES_PAGE_STR_DESC, request, context);
              return ListPluginInstancesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to getPlugin. */
  public UnaryCallSettings<GetPluginRequest, Plugin> getPluginSettings() {
    return getPluginSettings;
  }

  /** Returns the object with the settings used for calls to enablePlugin. */
  public UnaryCallSettings<EnablePluginRequest, Plugin> enablePluginSettings() {
    return enablePluginSettings;
  }

  /** Returns the object with the settings used for calls to disablePlugin. */
  public UnaryCallSettings<DisablePluginRequest, Plugin> disablePluginSettings() {
    return disablePluginSettings;
  }

  /** Returns the object with the settings used for calls to createPlugin. */
  public UnaryCallSettings<CreatePluginRequest, Plugin> createPluginSettings() {
    return createPluginSettings;
  }

  /** Returns the object with the settings used for calls to listPlugins. */
  public PagedCallSettings<ListPluginsRequest, ListPluginsResponse, ListPluginsPagedResponse>
      listPluginsSettings() {
    return listPluginsSettings;
  }

  /** Returns the object with the settings used for calls to deletePlugin. */
  public UnaryCallSettings<DeletePluginRequest, Operation> deletePluginSettings() {
    return deletePluginSettings;
  }

  /** Returns the object with the settings used for calls to deletePlugin. */
  public OperationCallSettings<DeletePluginRequest, Empty, OperationMetadata>
      deletePluginOperationSettings() {
    return deletePluginOperationSettings;
  }

  /** Returns the object with the settings used for calls to createPluginInstance. */
  public UnaryCallSettings<CreatePluginInstanceRequest, Operation> createPluginInstanceSettings() {
    return createPluginInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createPluginInstance. */
  public OperationCallSettings<CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
      createPluginInstanceOperationSettings() {
    return createPluginInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to executePluginInstanceAction. */
  public UnaryCallSettings<ExecutePluginInstanceActionRequest, Operation>
      executePluginInstanceActionSettings() {
    return executePluginInstanceActionSettings;
  }

  /** Returns the object with the settings used for calls to executePluginInstanceAction. */
  public OperationCallSettings<
          ExecutePluginInstanceActionRequest,
          ExecutePluginInstanceActionResponse,
          OperationMetadata>
      executePluginInstanceActionOperationSettings() {
    return executePluginInstanceActionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPluginInstance. */
  public UnaryCallSettings<GetPluginInstanceRequest, PluginInstance> getPluginInstanceSettings() {
    return getPluginInstanceSettings;
  }

  /** Returns the object with the settings used for calls to listPluginInstances. */
  public PagedCallSettings<
          ListPluginInstancesRequest, ListPluginInstancesResponse, ListPluginInstancesPagedResponse>
      listPluginInstancesSettings() {
    return listPluginInstancesSettings;
  }

  /** Returns the object with the settings used for calls to enablePluginInstanceAction. */
  public UnaryCallSettings<EnablePluginInstanceActionRequest, Operation>
      enablePluginInstanceActionSettings() {
    return enablePluginInstanceActionSettings;
  }

  /** Returns the object with the settings used for calls to enablePluginInstanceAction. */
  public OperationCallSettings<
          EnablePluginInstanceActionRequest, EnablePluginInstanceActionResponse, OperationMetadata>
      enablePluginInstanceActionOperationSettings() {
    return enablePluginInstanceActionOperationSettings;
  }

  /** Returns the object with the settings used for calls to disablePluginInstanceAction. */
  public UnaryCallSettings<DisablePluginInstanceActionRequest, Operation>
      disablePluginInstanceActionSettings() {
    return disablePluginInstanceActionSettings;
  }

  /** Returns the object with the settings used for calls to disablePluginInstanceAction. */
  public OperationCallSettings<
          DisablePluginInstanceActionRequest,
          DisablePluginInstanceActionResponse,
          OperationMetadata>
      disablePluginInstanceActionOperationSettings() {
    return disablePluginInstanceActionOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePluginInstance. */
  public UnaryCallSettings<UpdatePluginInstanceRequest, PluginInstance>
      updatePluginInstanceSettings() {
    return updatePluginInstanceSettings;
  }

  /** Returns the object with the settings used for calls to deletePluginInstance. */
  public UnaryCallSettings<DeletePluginInstanceRequest, Operation> deletePluginInstanceSettings() {
    return deletePluginInstanceSettings;
  }

  /** Returns the object with the settings used for calls to deletePluginInstance. */
  public OperationCallSettings<DeletePluginInstanceRequest, Empty, OperationMetadata>
      deletePluginInstanceOperationSettings() {
    return deletePluginInstanceOperationSettings;
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

  public ApiHubPluginStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonApiHubPluginStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "apihub";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "apihub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "apihub.mtls.googleapis.com:443";
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ApiHubPluginStubSettings.class))
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

  protected ApiHubPluginStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getPluginSettings = settingsBuilder.getPluginSettings().build();
    enablePluginSettings = settingsBuilder.enablePluginSettings().build();
    disablePluginSettings = settingsBuilder.disablePluginSettings().build();
    createPluginSettings = settingsBuilder.createPluginSettings().build();
    listPluginsSettings = settingsBuilder.listPluginsSettings().build();
    deletePluginSettings = settingsBuilder.deletePluginSettings().build();
    deletePluginOperationSettings = settingsBuilder.deletePluginOperationSettings().build();
    createPluginInstanceSettings = settingsBuilder.createPluginInstanceSettings().build();
    createPluginInstanceOperationSettings =
        settingsBuilder.createPluginInstanceOperationSettings().build();
    executePluginInstanceActionSettings =
        settingsBuilder.executePluginInstanceActionSettings().build();
    executePluginInstanceActionOperationSettings =
        settingsBuilder.executePluginInstanceActionOperationSettings().build();
    getPluginInstanceSettings = settingsBuilder.getPluginInstanceSettings().build();
    listPluginInstancesSettings = settingsBuilder.listPluginInstancesSettings().build();
    enablePluginInstanceActionSettings =
        settingsBuilder.enablePluginInstanceActionSettings().build();
    enablePluginInstanceActionOperationSettings =
        settingsBuilder.enablePluginInstanceActionOperationSettings().build();
    disablePluginInstanceActionSettings =
        settingsBuilder.disablePluginInstanceActionSettings().build();
    disablePluginInstanceActionOperationSettings =
        settingsBuilder.disablePluginInstanceActionOperationSettings().build();
    updatePluginInstanceSettings = settingsBuilder.updatePluginInstanceSettings().build();
    deletePluginInstanceSettings = settingsBuilder.deletePluginInstanceSettings().build();
    deletePluginInstanceOperationSettings =
        settingsBuilder.deletePluginInstanceOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for ApiHubPluginStubSettings. */
  public static class Builder extends StubSettings.Builder<ApiHubPluginStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetPluginRequest, Plugin> getPluginSettings;
    private final UnaryCallSettings.Builder<EnablePluginRequest, Plugin> enablePluginSettings;
    private final UnaryCallSettings.Builder<DisablePluginRequest, Plugin> disablePluginSettings;
    private final UnaryCallSettings.Builder<CreatePluginRequest, Plugin> createPluginSettings;
    private final PagedCallSettings.Builder<
            ListPluginsRequest, ListPluginsResponse, ListPluginsPagedResponse>
        listPluginsSettings;
    private final UnaryCallSettings.Builder<DeletePluginRequest, Operation> deletePluginSettings;
    private final OperationCallSettings.Builder<DeletePluginRequest, Empty, OperationMetadata>
        deletePluginOperationSettings;
    private final UnaryCallSettings.Builder<CreatePluginInstanceRequest, Operation>
        createPluginInstanceSettings;
    private final OperationCallSettings.Builder<
            CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
        createPluginInstanceOperationSettings;
    private final UnaryCallSettings.Builder<ExecutePluginInstanceActionRequest, Operation>
        executePluginInstanceActionSettings;
    private final OperationCallSettings.Builder<
            ExecutePluginInstanceActionRequest,
            ExecutePluginInstanceActionResponse,
            OperationMetadata>
        executePluginInstanceActionOperationSettings;
    private final UnaryCallSettings.Builder<GetPluginInstanceRequest, PluginInstance>
        getPluginInstanceSettings;
    private final PagedCallSettings.Builder<
            ListPluginInstancesRequest,
            ListPluginInstancesResponse,
            ListPluginInstancesPagedResponse>
        listPluginInstancesSettings;
    private final UnaryCallSettings.Builder<EnablePluginInstanceActionRequest, Operation>
        enablePluginInstanceActionSettings;
    private final OperationCallSettings.Builder<
            EnablePluginInstanceActionRequest,
            EnablePluginInstanceActionResponse,
            OperationMetadata>
        enablePluginInstanceActionOperationSettings;
    private final UnaryCallSettings.Builder<DisablePluginInstanceActionRequest, Operation>
        disablePluginInstanceActionSettings;
    private final OperationCallSettings.Builder<
            DisablePluginInstanceActionRequest,
            DisablePluginInstanceActionResponse,
            OperationMetadata>
        disablePluginInstanceActionOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePluginInstanceRequest, PluginInstance>
        updatePluginInstanceSettings;
    private final UnaryCallSettings.Builder<DeletePluginInstanceRequest, Operation>
        deletePluginInstanceSettings;
    private final OperationCallSettings.Builder<
            DeletePluginInstanceRequest, Empty, OperationMetadata>
        deletePluginInstanceOperationSettings;
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
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
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
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getPluginSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enablePluginSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disablePluginSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPluginSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPluginsSettings = PagedCallSettings.newBuilder(LIST_PLUGINS_PAGE_STR_FACT);
      deletePluginSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePluginOperationSettings = OperationCallSettings.newBuilder();
      createPluginInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPluginInstanceOperationSettings = OperationCallSettings.newBuilder();
      executePluginInstanceActionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      executePluginInstanceActionOperationSettings = OperationCallSettings.newBuilder();
      getPluginInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPluginInstancesSettings =
          PagedCallSettings.newBuilder(LIST_PLUGIN_INSTANCES_PAGE_STR_FACT);
      enablePluginInstanceActionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      enablePluginInstanceActionOperationSettings = OperationCallSettings.newBuilder();
      disablePluginInstanceActionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      disablePluginInstanceActionOperationSettings = OperationCallSettings.newBuilder();
      updatePluginInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePluginInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePluginInstanceOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getPluginSettings,
              enablePluginSettings,
              disablePluginSettings,
              createPluginSettings,
              listPluginsSettings,
              deletePluginSettings,
              createPluginInstanceSettings,
              executePluginInstanceActionSettings,
              getPluginInstanceSettings,
              listPluginInstancesSettings,
              enablePluginInstanceActionSettings,
              disablePluginInstanceActionSettings,
              updatePluginInstanceSettings,
              deletePluginInstanceSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ApiHubPluginStubSettings settings) {
      super(settings);

      getPluginSettings = settings.getPluginSettings.toBuilder();
      enablePluginSettings = settings.enablePluginSettings.toBuilder();
      disablePluginSettings = settings.disablePluginSettings.toBuilder();
      createPluginSettings = settings.createPluginSettings.toBuilder();
      listPluginsSettings = settings.listPluginsSettings.toBuilder();
      deletePluginSettings = settings.deletePluginSettings.toBuilder();
      deletePluginOperationSettings = settings.deletePluginOperationSettings.toBuilder();
      createPluginInstanceSettings = settings.createPluginInstanceSettings.toBuilder();
      createPluginInstanceOperationSettings =
          settings.createPluginInstanceOperationSettings.toBuilder();
      executePluginInstanceActionSettings =
          settings.executePluginInstanceActionSettings.toBuilder();
      executePluginInstanceActionOperationSettings =
          settings.executePluginInstanceActionOperationSettings.toBuilder();
      getPluginInstanceSettings = settings.getPluginInstanceSettings.toBuilder();
      listPluginInstancesSettings = settings.listPluginInstancesSettings.toBuilder();
      enablePluginInstanceActionSettings = settings.enablePluginInstanceActionSettings.toBuilder();
      enablePluginInstanceActionOperationSettings =
          settings.enablePluginInstanceActionOperationSettings.toBuilder();
      disablePluginInstanceActionSettings =
          settings.disablePluginInstanceActionSettings.toBuilder();
      disablePluginInstanceActionOperationSettings =
          settings.disablePluginInstanceActionOperationSettings.toBuilder();
      updatePluginInstanceSettings = settings.updatePluginInstanceSettings.toBuilder();
      deletePluginInstanceSettings = settings.deletePluginInstanceSettings.toBuilder();
      deletePluginInstanceOperationSettings =
          settings.deletePluginInstanceOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getPluginSettings,
              enablePluginSettings,
              disablePluginSettings,
              createPluginSettings,
              listPluginsSettings,
              deletePluginSettings,
              createPluginInstanceSettings,
              executePluginInstanceActionSettings,
              getPluginInstanceSettings,
              listPluginInstancesSettings,
              enablePluginInstanceActionSettings,
              disablePluginInstanceActionSettings,
              updatePluginInstanceSettings,
              deletePluginInstanceSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .getPluginSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .enablePluginSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .disablePluginSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createPluginSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPluginsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deletePluginSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createPluginInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .executePluginInstanceActionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPluginInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPluginInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .enablePluginInstanceActionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .disablePluginInstanceActionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updatePluginInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deletePluginInstanceSettings()
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

      builder
          .deletePluginOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePluginRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createPluginInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePluginInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PluginInstance.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .executePluginInstanceActionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExecutePluginInstanceActionRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExecutePluginInstanceActionResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .enablePluginInstanceActionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<EnablePluginInstanceActionRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  EnablePluginInstanceActionResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .disablePluginInstanceActionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DisablePluginInstanceActionRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  DisablePluginInstanceActionResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deletePluginInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePluginInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to getPlugin. */
    public UnaryCallSettings.Builder<GetPluginRequest, Plugin> getPluginSettings() {
      return getPluginSettings;
    }

    /** Returns the builder for the settings used for calls to enablePlugin. */
    public UnaryCallSettings.Builder<EnablePluginRequest, Plugin> enablePluginSettings() {
      return enablePluginSettings;
    }

    /** Returns the builder for the settings used for calls to disablePlugin. */
    public UnaryCallSettings.Builder<DisablePluginRequest, Plugin> disablePluginSettings() {
      return disablePluginSettings;
    }

    /** Returns the builder for the settings used for calls to createPlugin. */
    public UnaryCallSettings.Builder<CreatePluginRequest, Plugin> createPluginSettings() {
      return createPluginSettings;
    }

    /** Returns the builder for the settings used for calls to listPlugins. */
    public PagedCallSettings.Builder<
            ListPluginsRequest, ListPluginsResponse, ListPluginsPagedResponse>
        listPluginsSettings() {
      return listPluginsSettings;
    }

    /** Returns the builder for the settings used for calls to deletePlugin. */
    public UnaryCallSettings.Builder<DeletePluginRequest, Operation> deletePluginSettings() {
      return deletePluginSettings;
    }

    /** Returns the builder for the settings used for calls to deletePlugin. */
    public OperationCallSettings.Builder<DeletePluginRequest, Empty, OperationMetadata>
        deletePluginOperationSettings() {
      return deletePluginOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createPluginInstance. */
    public UnaryCallSettings.Builder<CreatePluginInstanceRequest, Operation>
        createPluginInstanceSettings() {
      return createPluginInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createPluginInstance. */
    public OperationCallSettings.Builder<
            CreatePluginInstanceRequest, PluginInstance, OperationMetadata>
        createPluginInstanceOperationSettings() {
      return createPluginInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to executePluginInstanceAction. */
    public UnaryCallSettings.Builder<ExecutePluginInstanceActionRequest, Operation>
        executePluginInstanceActionSettings() {
      return executePluginInstanceActionSettings;
    }

    /** Returns the builder for the settings used for calls to executePluginInstanceAction. */
    public OperationCallSettings.Builder<
            ExecutePluginInstanceActionRequest,
            ExecutePluginInstanceActionResponse,
            OperationMetadata>
        executePluginInstanceActionOperationSettings() {
      return executePluginInstanceActionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPluginInstance. */
    public UnaryCallSettings.Builder<GetPluginInstanceRequest, PluginInstance>
        getPluginInstanceSettings() {
      return getPluginInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to listPluginInstances. */
    public PagedCallSettings.Builder<
            ListPluginInstancesRequest,
            ListPluginInstancesResponse,
            ListPluginInstancesPagedResponse>
        listPluginInstancesSettings() {
      return listPluginInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to enablePluginInstanceAction. */
    public UnaryCallSettings.Builder<EnablePluginInstanceActionRequest, Operation>
        enablePluginInstanceActionSettings() {
      return enablePluginInstanceActionSettings;
    }

    /** Returns the builder for the settings used for calls to enablePluginInstanceAction. */
    public OperationCallSettings.Builder<
            EnablePluginInstanceActionRequest,
            EnablePluginInstanceActionResponse,
            OperationMetadata>
        enablePluginInstanceActionOperationSettings() {
      return enablePluginInstanceActionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to disablePluginInstanceAction. */
    public UnaryCallSettings.Builder<DisablePluginInstanceActionRequest, Operation>
        disablePluginInstanceActionSettings() {
      return disablePluginInstanceActionSettings;
    }

    /** Returns the builder for the settings used for calls to disablePluginInstanceAction. */
    public OperationCallSettings.Builder<
            DisablePluginInstanceActionRequest,
            DisablePluginInstanceActionResponse,
            OperationMetadata>
        disablePluginInstanceActionOperationSettings() {
      return disablePluginInstanceActionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePluginInstance. */
    public UnaryCallSettings.Builder<UpdatePluginInstanceRequest, PluginInstance>
        updatePluginInstanceSettings() {
      return updatePluginInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to deletePluginInstance. */
    public UnaryCallSettings.Builder<DeletePluginInstanceRequest, Operation>
        deletePluginInstanceSettings() {
      return deletePluginInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to deletePluginInstance. */
    public OperationCallSettings.Builder<DeletePluginInstanceRequest, Empty, OperationMetadata>
        deletePluginInstanceOperationSettings() {
      return deletePluginInstanceOperationSettings;
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
    public ApiHubPluginStubSettings build() throws IOException {
      return new ApiHubPluginStubSettings(this);
    }
  }
}
