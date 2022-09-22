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

package com.google.cloud.apigateway.v1.stub;

import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApiConfigsPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApisPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListGatewaysPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.cloud.apigateway.v1.Api;
import com.google.cloud.apigateway.v1.ApiConfig;
import com.google.cloud.apigateway.v1.CreateApiConfigRequest;
import com.google.cloud.apigateway.v1.CreateApiRequest;
import com.google.cloud.apigateway.v1.CreateGatewayRequest;
import com.google.cloud.apigateway.v1.DeleteApiConfigRequest;
import com.google.cloud.apigateway.v1.DeleteApiRequest;
import com.google.cloud.apigateway.v1.DeleteGatewayRequest;
import com.google.cloud.apigateway.v1.Gateway;
import com.google.cloud.apigateway.v1.GetApiConfigRequest;
import com.google.cloud.apigateway.v1.GetApiRequest;
import com.google.cloud.apigateway.v1.GetGatewayRequest;
import com.google.cloud.apigateway.v1.ListApiConfigsRequest;
import com.google.cloud.apigateway.v1.ListApiConfigsResponse;
import com.google.cloud.apigateway.v1.ListApisRequest;
import com.google.cloud.apigateway.v1.ListApisResponse;
import com.google.cloud.apigateway.v1.ListGatewaysRequest;
import com.google.cloud.apigateway.v1.ListGatewaysResponse;
import com.google.cloud.apigateway.v1.OperationMetadata;
import com.google.cloud.apigateway.v1.UpdateApiConfigRequest;
import com.google.cloud.apigateway.v1.UpdateApiRequest;
import com.google.cloud.apigateway.v1.UpdateGatewayRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiGatewayServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apigateway.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getGateway to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiGatewayServiceStubSettings.Builder apiGatewayServiceSettingsBuilder =
 *     ApiGatewayServiceStubSettings.newBuilder();
 * apiGatewayServiceSettingsBuilder
 *     .getGatewaySettings()
 *     .setRetrySettings(
 *         apiGatewayServiceSettingsBuilder.getGatewaySettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ApiGatewayServiceStubSettings apiGatewayServiceSettings =
 *     apiGatewayServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApiGatewayServiceStubSettings extends StubSettings<ApiGatewayServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
      listGatewaysSettings;
  private final UnaryCallSettings<GetGatewayRequest, Gateway> getGatewaySettings;
  private final UnaryCallSettings<CreateGatewayRequest, Operation> createGatewaySettings;
  private final OperationCallSettings<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationSettings;
  private final UnaryCallSettings<UpdateGatewayRequest, Operation> updateGatewaySettings;
  private final OperationCallSettings<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationSettings;
  private final UnaryCallSettings<DeleteGatewayRequest, Operation> deleteGatewaySettings;
  private final OperationCallSettings<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationSettings;
  private final PagedCallSettings<ListApisRequest, ListApisResponse, ListApisPagedResponse>
      listApisSettings;
  private final UnaryCallSettings<GetApiRequest, Api> getApiSettings;
  private final UnaryCallSettings<CreateApiRequest, Operation> createApiSettings;
  private final OperationCallSettings<CreateApiRequest, Api, OperationMetadata>
      createApiOperationSettings;
  private final UnaryCallSettings<UpdateApiRequest, Operation> updateApiSettings;
  private final OperationCallSettings<UpdateApiRequest, Api, OperationMetadata>
      updateApiOperationSettings;
  private final UnaryCallSettings<DeleteApiRequest, Operation> deleteApiSettings;
  private final OperationCallSettings<DeleteApiRequest, Empty, OperationMetadata>
      deleteApiOperationSettings;
  private final PagedCallSettings<
          ListApiConfigsRequest, ListApiConfigsResponse, ListApiConfigsPagedResponse>
      listApiConfigsSettings;
  private final UnaryCallSettings<GetApiConfigRequest, ApiConfig> getApiConfigSettings;
  private final UnaryCallSettings<CreateApiConfigRequest, Operation> createApiConfigSettings;
  private final OperationCallSettings<CreateApiConfigRequest, ApiConfig, OperationMetadata>
      createApiConfigOperationSettings;
  private final UnaryCallSettings<UpdateApiConfigRequest, Operation> updateApiConfigSettings;
  private final OperationCallSettings<UpdateApiConfigRequest, ApiConfig, OperationMetadata>
      updateApiConfigOperationSettings;
  private final UnaryCallSettings<DeleteApiConfigRequest, Operation> deleteApiConfigSettings;
  private final OperationCallSettings<DeleteApiConfigRequest, Empty, OperationMetadata>
      deleteApiConfigOperationSettings;

  private static final PagedListDescriptor<ListGatewaysRequest, ListGatewaysResponse, Gateway>
      LIST_GATEWAYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListGatewaysRequest, ListGatewaysResponse, Gateway>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGatewaysRequest injectToken(ListGatewaysRequest payload, String token) {
              return ListGatewaysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGatewaysRequest injectPageSize(ListGatewaysRequest payload, int pageSize) {
              return ListGatewaysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGatewaysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGatewaysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Gateway> extractResources(ListGatewaysResponse payload) {
              return payload.getGatewaysList() == null
                  ? ImmutableList.<Gateway>of()
                  : payload.getGatewaysList();
            }
          };

  private static final PagedListDescriptor<ListApisRequest, ListApisResponse, Api>
      LIST_APIS_PAGE_STR_DESC =
          new PagedListDescriptor<ListApisRequest, ListApisResponse, Api>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApisRequest injectToken(ListApisRequest payload, String token) {
              return ListApisRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApisRequest injectPageSize(ListApisRequest payload, int pageSize) {
              return ListApisRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApisRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApisResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Api> extractResources(ListApisResponse payload) {
              return payload.getApisList() == null
                  ? ImmutableList.<Api>of()
                  : payload.getApisList();
            }
          };

  private static final PagedListDescriptor<ListApiConfigsRequest, ListApiConfigsResponse, ApiConfig>
      LIST_API_CONFIGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListApiConfigsRequest, ListApiConfigsResponse, ApiConfig>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListApiConfigsRequest injectToken(ListApiConfigsRequest payload, String token) {
              return ListApiConfigsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListApiConfigsRequest injectPageSize(
                ListApiConfigsRequest payload, int pageSize) {
              return ListApiConfigsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListApiConfigsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListApiConfigsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ApiConfig> extractResources(ListApiConfigsResponse payload) {
              return payload.getApiConfigsList() == null
                  ? ImmutableList.<ApiConfig>of()
                  : payload.getApiConfigsList();
            }
          };

  private static final PagedListResponseFactory<
          ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
      LIST_GATEWAYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>() {
            @Override
            public ApiFuture<ListGatewaysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> callable,
                ListGatewaysRequest request,
                ApiCallContext context,
                ApiFuture<ListGatewaysResponse> futureResponse) {
              PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> pageContext =
                  PageContext.create(callable, LIST_GATEWAYS_PAGE_STR_DESC, request, context);
              return ListGatewaysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApisRequest, ListApisResponse, ListApisPagedResponse>
      LIST_APIS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListApisRequest, ListApisResponse, ListApisPagedResponse>() {
            @Override
            public ApiFuture<ListApisPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApisRequest, ListApisResponse> callable,
                ListApisRequest request,
                ApiCallContext context,
                ApiFuture<ListApisResponse> futureResponse) {
              PageContext<ListApisRequest, ListApisResponse, Api> pageContext =
                  PageContext.create(callable, LIST_APIS_PAGE_STR_DESC, request, context);
              return ListApisPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListApiConfigsRequest, ListApiConfigsResponse, ListApiConfigsPagedResponse>
      LIST_API_CONFIGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListApiConfigsRequest, ListApiConfigsResponse, ListApiConfigsPagedResponse>() {
            @Override
            public ApiFuture<ListApiConfigsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListApiConfigsRequest, ListApiConfigsResponse> callable,
                ListApiConfigsRequest request,
                ApiCallContext context,
                ApiFuture<ListApiConfigsResponse> futureResponse) {
              PageContext<ListApiConfigsRequest, ListApiConfigsResponse, ApiConfig> pageContext =
                  PageContext.create(callable, LIST_API_CONFIGS_PAGE_STR_DESC, request, context);
              return ListApiConfigsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listGateways. */
  public PagedCallSettings<ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
      listGatewaysSettings() {
    return listGatewaysSettings;
  }

  /** Returns the object with the settings used for calls to getGateway. */
  public UnaryCallSettings<GetGatewayRequest, Gateway> getGatewaySettings() {
    return getGatewaySettings;
  }

  /** Returns the object with the settings used for calls to createGateway. */
  public UnaryCallSettings<CreateGatewayRequest, Operation> createGatewaySettings() {
    return createGatewaySettings;
  }

  /** Returns the object with the settings used for calls to createGateway. */
  public OperationCallSettings<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationSettings() {
    return createGatewayOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGateway. */
  public UnaryCallSettings<UpdateGatewayRequest, Operation> updateGatewaySettings() {
    return updateGatewaySettings;
  }

  /** Returns the object with the settings used for calls to updateGateway. */
  public OperationCallSettings<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationSettings() {
    return updateGatewayOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGateway. */
  public UnaryCallSettings<DeleteGatewayRequest, Operation> deleteGatewaySettings() {
    return deleteGatewaySettings;
  }

  /** Returns the object with the settings used for calls to deleteGateway. */
  public OperationCallSettings<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationSettings() {
    return deleteGatewayOperationSettings;
  }

  /** Returns the object with the settings used for calls to listApis. */
  public PagedCallSettings<ListApisRequest, ListApisResponse, ListApisPagedResponse>
      listApisSettings() {
    return listApisSettings;
  }

  /** Returns the object with the settings used for calls to getApi. */
  public UnaryCallSettings<GetApiRequest, Api> getApiSettings() {
    return getApiSettings;
  }

  /** Returns the object with the settings used for calls to createApi. */
  public UnaryCallSettings<CreateApiRequest, Operation> createApiSettings() {
    return createApiSettings;
  }

  /** Returns the object with the settings used for calls to createApi. */
  public OperationCallSettings<CreateApiRequest, Api, OperationMetadata>
      createApiOperationSettings() {
    return createApiOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateApi. */
  public UnaryCallSettings<UpdateApiRequest, Operation> updateApiSettings() {
    return updateApiSettings;
  }

  /** Returns the object with the settings used for calls to updateApi. */
  public OperationCallSettings<UpdateApiRequest, Api, OperationMetadata>
      updateApiOperationSettings() {
    return updateApiOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteApi. */
  public UnaryCallSettings<DeleteApiRequest, Operation> deleteApiSettings() {
    return deleteApiSettings;
  }

  /** Returns the object with the settings used for calls to deleteApi. */
  public OperationCallSettings<DeleteApiRequest, Empty, OperationMetadata>
      deleteApiOperationSettings() {
    return deleteApiOperationSettings;
  }

  /** Returns the object with the settings used for calls to listApiConfigs. */
  public PagedCallSettings<
          ListApiConfigsRequest, ListApiConfigsResponse, ListApiConfigsPagedResponse>
      listApiConfigsSettings() {
    return listApiConfigsSettings;
  }

  /** Returns the object with the settings used for calls to getApiConfig. */
  public UnaryCallSettings<GetApiConfigRequest, ApiConfig> getApiConfigSettings() {
    return getApiConfigSettings;
  }

  /** Returns the object with the settings used for calls to createApiConfig. */
  public UnaryCallSettings<CreateApiConfigRequest, Operation> createApiConfigSettings() {
    return createApiConfigSettings;
  }

  /** Returns the object with the settings used for calls to createApiConfig. */
  public OperationCallSettings<CreateApiConfigRequest, ApiConfig, OperationMetadata>
      createApiConfigOperationSettings() {
    return createApiConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateApiConfig. */
  public UnaryCallSettings<UpdateApiConfigRequest, Operation> updateApiConfigSettings() {
    return updateApiConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateApiConfig. */
  public OperationCallSettings<UpdateApiConfigRequest, ApiConfig, OperationMetadata>
      updateApiConfigOperationSettings() {
    return updateApiConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteApiConfig. */
  public UnaryCallSettings<DeleteApiConfigRequest, Operation> deleteApiConfigSettings() {
    return deleteApiConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteApiConfig. */
  public OperationCallSettings<DeleteApiConfigRequest, Empty, OperationMetadata>
      deleteApiConfigOperationSettings() {
    return deleteApiConfigOperationSettings;
  }

  public ApiGatewayServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcApiGatewayServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonApiGatewayServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "apigateway.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "apigateway.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ApiGatewayServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ApiGatewayServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiGatewayServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ApiGatewayServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listGatewaysSettings = settingsBuilder.listGatewaysSettings().build();
    getGatewaySettings = settingsBuilder.getGatewaySettings().build();
    createGatewaySettings = settingsBuilder.createGatewaySettings().build();
    createGatewayOperationSettings = settingsBuilder.createGatewayOperationSettings().build();
    updateGatewaySettings = settingsBuilder.updateGatewaySettings().build();
    updateGatewayOperationSettings = settingsBuilder.updateGatewayOperationSettings().build();
    deleteGatewaySettings = settingsBuilder.deleteGatewaySettings().build();
    deleteGatewayOperationSettings = settingsBuilder.deleteGatewayOperationSettings().build();
    listApisSettings = settingsBuilder.listApisSettings().build();
    getApiSettings = settingsBuilder.getApiSettings().build();
    createApiSettings = settingsBuilder.createApiSettings().build();
    createApiOperationSettings = settingsBuilder.createApiOperationSettings().build();
    updateApiSettings = settingsBuilder.updateApiSettings().build();
    updateApiOperationSettings = settingsBuilder.updateApiOperationSettings().build();
    deleteApiSettings = settingsBuilder.deleteApiSettings().build();
    deleteApiOperationSettings = settingsBuilder.deleteApiOperationSettings().build();
    listApiConfigsSettings = settingsBuilder.listApiConfigsSettings().build();
    getApiConfigSettings = settingsBuilder.getApiConfigSettings().build();
    createApiConfigSettings = settingsBuilder.createApiConfigSettings().build();
    createApiConfigOperationSettings = settingsBuilder.createApiConfigOperationSettings().build();
    updateApiConfigSettings = settingsBuilder.updateApiConfigSettings().build();
    updateApiConfigOperationSettings = settingsBuilder.updateApiConfigOperationSettings().build();
    deleteApiConfigSettings = settingsBuilder.deleteApiConfigSettings().build();
    deleteApiConfigOperationSettings = settingsBuilder.deleteApiConfigOperationSettings().build();
  }

  /** Builder for ApiGatewayServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ApiGatewayServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
        listGatewaysSettings;
    private final UnaryCallSettings.Builder<GetGatewayRequest, Gateway> getGatewaySettings;
    private final UnaryCallSettings.Builder<CreateGatewayRequest, Operation> createGatewaySettings;
    private final OperationCallSettings.Builder<CreateGatewayRequest, Gateway, OperationMetadata>
        createGatewayOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGatewayRequest, Operation> updateGatewaySettings;
    private final OperationCallSettings.Builder<UpdateGatewayRequest, Gateway, OperationMetadata>
        updateGatewayOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGatewayRequest, Operation> deleteGatewaySettings;
    private final OperationCallSettings.Builder<DeleteGatewayRequest, Empty, OperationMetadata>
        deleteGatewayOperationSettings;
    private final PagedCallSettings.Builder<
            ListApisRequest, ListApisResponse, ListApisPagedResponse>
        listApisSettings;
    private final UnaryCallSettings.Builder<GetApiRequest, Api> getApiSettings;
    private final UnaryCallSettings.Builder<CreateApiRequest, Operation> createApiSettings;
    private final OperationCallSettings.Builder<CreateApiRequest, Api, OperationMetadata>
        createApiOperationSettings;
    private final UnaryCallSettings.Builder<UpdateApiRequest, Operation> updateApiSettings;
    private final OperationCallSettings.Builder<UpdateApiRequest, Api, OperationMetadata>
        updateApiOperationSettings;
    private final UnaryCallSettings.Builder<DeleteApiRequest, Operation> deleteApiSettings;
    private final OperationCallSettings.Builder<DeleteApiRequest, Empty, OperationMetadata>
        deleteApiOperationSettings;
    private final PagedCallSettings.Builder<
            ListApiConfigsRequest, ListApiConfigsResponse, ListApiConfigsPagedResponse>
        listApiConfigsSettings;
    private final UnaryCallSettings.Builder<GetApiConfigRequest, ApiConfig> getApiConfigSettings;
    private final UnaryCallSettings.Builder<CreateApiConfigRequest, Operation>
        createApiConfigSettings;
    private final OperationCallSettings.Builder<
            CreateApiConfigRequest, ApiConfig, OperationMetadata>
        createApiConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateApiConfigRequest, Operation>
        updateApiConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateApiConfigRequest, ApiConfig, OperationMetadata>
        updateApiConfigOperationSettings;
    private final UnaryCallSettings.Builder<DeleteApiConfigRequest, Operation>
        deleteApiConfigSettings;
    private final OperationCallSettings.Builder<DeleteApiConfigRequest, Empty, OperationMetadata>
        deleteApiConfigOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNKNOWN, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listGatewaysSettings = PagedCallSettings.newBuilder(LIST_GATEWAYS_PAGE_STR_FACT);
      getGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGatewayOperationSettings = OperationCallSettings.newBuilder();
      updateGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGatewayOperationSettings = OperationCallSettings.newBuilder();
      deleteGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGatewayOperationSettings = OperationCallSettings.newBuilder();
      listApisSettings = PagedCallSettings.newBuilder(LIST_APIS_PAGE_STR_FACT);
      getApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApiOperationSettings = OperationCallSettings.newBuilder();
      updateApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApiOperationSettings = OperationCallSettings.newBuilder();
      deleteApiSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiOperationSettings = OperationCallSettings.newBuilder();
      listApiConfigsSettings = PagedCallSettings.newBuilder(LIST_API_CONFIGS_PAGE_STR_FACT);
      getApiConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApiConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createApiConfigOperationSettings = OperationCallSettings.newBuilder();
      updateApiConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateApiConfigOperationSettings = OperationCallSettings.newBuilder();
      deleteApiConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteApiConfigOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGatewaysSettings,
              getGatewaySettings,
              createGatewaySettings,
              updateGatewaySettings,
              deleteGatewaySettings,
              listApisSettings,
              getApiSettings,
              createApiSettings,
              updateApiSettings,
              deleteApiSettings,
              listApiConfigsSettings,
              getApiConfigSettings,
              createApiConfigSettings,
              updateApiConfigSettings,
              deleteApiConfigSettings);
      initDefaults(this);
    }

    protected Builder(ApiGatewayServiceStubSettings settings) {
      super(settings);

      listGatewaysSettings = settings.listGatewaysSettings.toBuilder();
      getGatewaySettings = settings.getGatewaySettings.toBuilder();
      createGatewaySettings = settings.createGatewaySettings.toBuilder();
      createGatewayOperationSettings = settings.createGatewayOperationSettings.toBuilder();
      updateGatewaySettings = settings.updateGatewaySettings.toBuilder();
      updateGatewayOperationSettings = settings.updateGatewayOperationSettings.toBuilder();
      deleteGatewaySettings = settings.deleteGatewaySettings.toBuilder();
      deleteGatewayOperationSettings = settings.deleteGatewayOperationSettings.toBuilder();
      listApisSettings = settings.listApisSettings.toBuilder();
      getApiSettings = settings.getApiSettings.toBuilder();
      createApiSettings = settings.createApiSettings.toBuilder();
      createApiOperationSettings = settings.createApiOperationSettings.toBuilder();
      updateApiSettings = settings.updateApiSettings.toBuilder();
      updateApiOperationSettings = settings.updateApiOperationSettings.toBuilder();
      deleteApiSettings = settings.deleteApiSettings.toBuilder();
      deleteApiOperationSettings = settings.deleteApiOperationSettings.toBuilder();
      listApiConfigsSettings = settings.listApiConfigsSettings.toBuilder();
      getApiConfigSettings = settings.getApiConfigSettings.toBuilder();
      createApiConfigSettings = settings.createApiConfigSettings.toBuilder();
      createApiConfigOperationSettings = settings.createApiConfigOperationSettings.toBuilder();
      updateApiConfigSettings = settings.updateApiConfigSettings.toBuilder();
      updateApiConfigOperationSettings = settings.updateApiConfigOperationSettings.toBuilder();
      deleteApiConfigSettings = settings.deleteApiConfigSettings.toBuilder();
      deleteApiConfigOperationSettings = settings.deleteApiConfigOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listGatewaysSettings,
              getGatewaySettings,
              createGatewaySettings,
              updateGatewaySettings,
              deleteGatewaySettings,
              listApisSettings,
              getApiSettings,
              createApiSettings,
              updateApiSettings,
              deleteApiSettings,
              listApiConfigsSettings,
              getApiConfigSettings,
              createApiConfigSettings,
              updateApiConfigSettings,
              deleteApiConfigSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listGatewaysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApisSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteApiSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listApiConfigsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getApiConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createApiConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateApiConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteApiConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGatewayOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGatewayRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Gateway.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateGatewayOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGatewayRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Gateway.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteGatewayOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGatewayRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createApiOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateApiRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Api.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateApiOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateApiRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Api.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteApiOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteApiRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createApiConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateApiConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ApiConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateApiConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateApiConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ApiConfig.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteApiConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteApiConfigRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to listGateways. */
    public PagedCallSettings.Builder<
            ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
        listGatewaysSettings() {
      return listGatewaysSettings;
    }

    /** Returns the builder for the settings used for calls to getGateway. */
    public UnaryCallSettings.Builder<GetGatewayRequest, Gateway> getGatewaySettings() {
      return getGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to createGateway. */
    public UnaryCallSettings.Builder<CreateGatewayRequest, Operation> createGatewaySettings() {
      return createGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to createGateway. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateGatewayRequest, Gateway, OperationMetadata>
        createGatewayOperationSettings() {
      return createGatewayOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGateway. */
    public UnaryCallSettings.Builder<UpdateGatewayRequest, Operation> updateGatewaySettings() {
      return updateGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to updateGateway. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateGatewayRequest, Gateway, OperationMetadata>
        updateGatewayOperationSettings() {
      return updateGatewayOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGateway. */
    public UnaryCallSettings.Builder<DeleteGatewayRequest, Operation> deleteGatewaySettings() {
      return deleteGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to deleteGateway. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteGatewayRequest, Empty, OperationMetadata>
        deleteGatewayOperationSettings() {
      return deleteGatewayOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listApis. */
    public PagedCallSettings.Builder<ListApisRequest, ListApisResponse, ListApisPagedResponse>
        listApisSettings() {
      return listApisSettings;
    }

    /** Returns the builder for the settings used for calls to getApi. */
    public UnaryCallSettings.Builder<GetApiRequest, Api> getApiSettings() {
      return getApiSettings;
    }

    /** Returns the builder for the settings used for calls to createApi. */
    public UnaryCallSettings.Builder<CreateApiRequest, Operation> createApiSettings() {
      return createApiSettings;
    }

    /** Returns the builder for the settings used for calls to createApi. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateApiRequest, Api, OperationMetadata>
        createApiOperationSettings() {
      return createApiOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApi. */
    public UnaryCallSettings.Builder<UpdateApiRequest, Operation> updateApiSettings() {
      return updateApiSettings;
    }

    /** Returns the builder for the settings used for calls to updateApi. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateApiRequest, Api, OperationMetadata>
        updateApiOperationSettings() {
      return updateApiOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApi. */
    public UnaryCallSettings.Builder<DeleteApiRequest, Operation> deleteApiSettings() {
      return deleteApiSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApi. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteApiRequest, Empty, OperationMetadata>
        deleteApiOperationSettings() {
      return deleteApiOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listApiConfigs. */
    public PagedCallSettings.Builder<
            ListApiConfigsRequest, ListApiConfigsResponse, ListApiConfigsPagedResponse>
        listApiConfigsSettings() {
      return listApiConfigsSettings;
    }

    /** Returns the builder for the settings used for calls to getApiConfig. */
    public UnaryCallSettings.Builder<GetApiConfigRequest, ApiConfig> getApiConfigSettings() {
      return getApiConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createApiConfig. */
    public UnaryCallSettings.Builder<CreateApiConfigRequest, Operation> createApiConfigSettings() {
      return createApiConfigSettings;
    }

    /** Returns the builder for the settings used for calls to createApiConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateApiConfigRequest, ApiConfig, OperationMetadata>
        createApiConfigOperationSettings() {
      return createApiConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateApiConfig. */
    public UnaryCallSettings.Builder<UpdateApiConfigRequest, Operation> updateApiConfigSettings() {
      return updateApiConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateApiConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateApiConfigRequest, ApiConfig, OperationMetadata>
        updateApiConfigOperationSettings() {
      return updateApiConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApiConfig. */
    public UnaryCallSettings.Builder<DeleteApiConfigRequest, Operation> deleteApiConfigSettings() {
      return deleteApiConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteApiConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteApiConfigRequest, Empty, OperationMetadata>
        deleteApiConfigOperationSettings() {
      return deleteApiConfigOperationSettings;
    }

    @Override
    public ApiGatewayServiceStubSettings build() throws IOException {
      return new ApiGatewayServiceStubSettings(this);
    }
  }
}
