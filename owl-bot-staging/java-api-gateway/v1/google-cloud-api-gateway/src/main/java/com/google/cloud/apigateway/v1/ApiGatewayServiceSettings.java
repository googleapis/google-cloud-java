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

package com.google.cloud.apigateway.v1;

import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApiConfigsPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListApisPagedResponse;
import static com.google.cloud.apigateway.v1.ApiGatewayServiceClient.ListGatewaysPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.apigateway.v1.stub.ApiGatewayServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiGatewayServiceClient}.
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
 * ApiGatewayServiceSettings.Builder apiGatewayServiceSettingsBuilder =
 *     ApiGatewayServiceSettings.newBuilder();
 * apiGatewayServiceSettingsBuilder
 *     .getGatewaySettings()
 *     .setRetrySettings(
 *         apiGatewayServiceSettingsBuilder
 *             .getGatewaySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ApiGatewayServiceSettings apiGatewayServiceSettings = apiGatewayServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApiGatewayServiceSettings extends ClientSettings<ApiGatewayServiceSettings> {

  /** Returns the object with the settings used for calls to listGateways. */
  public PagedCallSettings<ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
      listGatewaysSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).listGatewaysSettings();
  }

  /** Returns the object with the settings used for calls to getGateway. */
  public UnaryCallSettings<GetGatewayRequest, Gateway> getGatewaySettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).getGatewaySettings();
  }

  /** Returns the object with the settings used for calls to createGateway. */
  public UnaryCallSettings<CreateGatewayRequest, Operation> createGatewaySettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).createGatewaySettings();
  }

  /** Returns the object with the settings used for calls to createGateway. */
  public OperationCallSettings<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).createGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGateway. */
  public UnaryCallSettings<UpdateGatewayRequest, Operation> updateGatewaySettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).updateGatewaySettings();
  }

  /** Returns the object with the settings used for calls to updateGateway. */
  public OperationCallSettings<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).updateGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGateway. */
  public UnaryCallSettings<DeleteGatewayRequest, Operation> deleteGatewaySettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).deleteGatewaySettings();
  }

  /** Returns the object with the settings used for calls to deleteGateway. */
  public OperationCallSettings<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).deleteGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to listApis. */
  public PagedCallSettings<ListApisRequest, ListApisResponse, ListApisPagedResponse>
      listApisSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).listApisSettings();
  }

  /** Returns the object with the settings used for calls to getApi. */
  public UnaryCallSettings<GetApiRequest, Api> getApiSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).getApiSettings();
  }

  /** Returns the object with the settings used for calls to createApi. */
  public UnaryCallSettings<CreateApiRequest, Operation> createApiSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).createApiSettings();
  }

  /** Returns the object with the settings used for calls to createApi. */
  public OperationCallSettings<CreateApiRequest, Api, OperationMetadata>
      createApiOperationSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).createApiOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateApi. */
  public UnaryCallSettings<UpdateApiRequest, Operation> updateApiSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).updateApiSettings();
  }

  /** Returns the object with the settings used for calls to updateApi. */
  public OperationCallSettings<UpdateApiRequest, Api, OperationMetadata>
      updateApiOperationSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).updateApiOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApi. */
  public UnaryCallSettings<DeleteApiRequest, Operation> deleteApiSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).deleteApiSettings();
  }

  /** Returns the object with the settings used for calls to deleteApi. */
  public OperationCallSettings<DeleteApiRequest, Empty, OperationMetadata>
      deleteApiOperationSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).deleteApiOperationSettings();
  }

  /** Returns the object with the settings used for calls to listApiConfigs. */
  public PagedCallSettings<
          ListApiConfigsRequest, ListApiConfigsResponse, ListApiConfigsPagedResponse>
      listApiConfigsSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).listApiConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getApiConfig. */
  public UnaryCallSettings<GetApiConfigRequest, ApiConfig> getApiConfigSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).getApiConfigSettings();
  }

  /** Returns the object with the settings used for calls to createApiConfig. */
  public UnaryCallSettings<CreateApiConfigRequest, Operation> createApiConfigSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).createApiConfigSettings();
  }

  /** Returns the object with the settings used for calls to createApiConfig. */
  public OperationCallSettings<CreateApiConfigRequest, ApiConfig, OperationMetadata>
      createApiConfigOperationSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).createApiConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateApiConfig. */
  public UnaryCallSettings<UpdateApiConfigRequest, Operation> updateApiConfigSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).updateApiConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateApiConfig. */
  public OperationCallSettings<UpdateApiConfigRequest, ApiConfig, OperationMetadata>
      updateApiConfigOperationSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).updateApiConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteApiConfig. */
  public UnaryCallSettings<DeleteApiConfigRequest, Operation> deleteApiConfigSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).deleteApiConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteApiConfig. */
  public OperationCallSettings<DeleteApiConfigRequest, Empty, OperationMetadata>
      deleteApiConfigOperationSettings() {
    return ((ApiGatewayServiceStubSettings) getStubSettings()).deleteApiConfigOperationSettings();
  }

  public static final ApiGatewayServiceSettings create(ApiGatewayServiceStubSettings stub)
      throws IOException {
    return new ApiGatewayServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ApiGatewayServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ApiGatewayServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ApiGatewayServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ApiGatewayServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ApiGatewayServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ApiGatewayServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ApiGatewayServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiGatewayServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ApiGatewayServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ApiGatewayServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ApiGatewayServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ApiGatewayServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ApiGatewayServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ApiGatewayServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ApiGatewayServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(ApiGatewayServiceStubSettings.newHttpJsonBuilder());
    }

    public ApiGatewayServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ApiGatewayServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listGateways. */
    public PagedCallSettings.Builder<
            ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
        listGatewaysSettings() {
      return getStubSettingsBuilder().listGatewaysSettings();
    }

    /** Returns the builder for the settings used for calls to getGateway. */
    public UnaryCallSettings.Builder<GetGatewayRequest, Gateway> getGatewaySettings() {
      return getStubSettingsBuilder().getGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to createGateway. */
    public UnaryCallSettings.Builder<CreateGatewayRequest, Operation> createGatewaySettings() {
      return getStubSettingsBuilder().createGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to createGateway. */
    public OperationCallSettings.Builder<CreateGatewayRequest, Gateway, OperationMetadata>
        createGatewayOperationSettings() {
      return getStubSettingsBuilder().createGatewayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGateway. */
    public UnaryCallSettings.Builder<UpdateGatewayRequest, Operation> updateGatewaySettings() {
      return getStubSettingsBuilder().updateGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to updateGateway. */
    public OperationCallSettings.Builder<UpdateGatewayRequest, Gateway, OperationMetadata>
        updateGatewayOperationSettings() {
      return getStubSettingsBuilder().updateGatewayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGateway. */
    public UnaryCallSettings.Builder<DeleteGatewayRequest, Operation> deleteGatewaySettings() {
      return getStubSettingsBuilder().deleteGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to deleteGateway. */
    public OperationCallSettings.Builder<DeleteGatewayRequest, Empty, OperationMetadata>
        deleteGatewayOperationSettings() {
      return getStubSettingsBuilder().deleteGatewayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listApis. */
    public PagedCallSettings.Builder<ListApisRequest, ListApisResponse, ListApisPagedResponse>
        listApisSettings() {
      return getStubSettingsBuilder().listApisSettings();
    }

    /** Returns the builder for the settings used for calls to getApi. */
    public UnaryCallSettings.Builder<GetApiRequest, Api> getApiSettings() {
      return getStubSettingsBuilder().getApiSettings();
    }

    /** Returns the builder for the settings used for calls to createApi. */
    public UnaryCallSettings.Builder<CreateApiRequest, Operation> createApiSettings() {
      return getStubSettingsBuilder().createApiSettings();
    }

    /** Returns the builder for the settings used for calls to createApi. */
    public OperationCallSettings.Builder<CreateApiRequest, Api, OperationMetadata>
        createApiOperationSettings() {
      return getStubSettingsBuilder().createApiOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateApi. */
    public UnaryCallSettings.Builder<UpdateApiRequest, Operation> updateApiSettings() {
      return getStubSettingsBuilder().updateApiSettings();
    }

    /** Returns the builder for the settings used for calls to updateApi. */
    public OperationCallSettings.Builder<UpdateApiRequest, Api, OperationMetadata>
        updateApiOperationSettings() {
      return getStubSettingsBuilder().updateApiOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApi. */
    public UnaryCallSettings.Builder<DeleteApiRequest, Operation> deleteApiSettings() {
      return getStubSettingsBuilder().deleteApiSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApi. */
    public OperationCallSettings.Builder<DeleteApiRequest, Empty, OperationMetadata>
        deleteApiOperationSettings() {
      return getStubSettingsBuilder().deleteApiOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listApiConfigs. */
    public PagedCallSettings.Builder<
            ListApiConfigsRequest, ListApiConfigsResponse, ListApiConfigsPagedResponse>
        listApiConfigsSettings() {
      return getStubSettingsBuilder().listApiConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getApiConfig. */
    public UnaryCallSettings.Builder<GetApiConfigRequest, ApiConfig> getApiConfigSettings() {
      return getStubSettingsBuilder().getApiConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createApiConfig. */
    public UnaryCallSettings.Builder<CreateApiConfigRequest, Operation> createApiConfigSettings() {
      return getStubSettingsBuilder().createApiConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createApiConfig. */
    public OperationCallSettings.Builder<CreateApiConfigRequest, ApiConfig, OperationMetadata>
        createApiConfigOperationSettings() {
      return getStubSettingsBuilder().createApiConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateApiConfig. */
    public UnaryCallSettings.Builder<UpdateApiConfigRequest, Operation> updateApiConfigSettings() {
      return getStubSettingsBuilder().updateApiConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateApiConfig. */
    public OperationCallSettings.Builder<UpdateApiConfigRequest, ApiConfig, OperationMetadata>
        updateApiConfigOperationSettings() {
      return getStubSettingsBuilder().updateApiConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApiConfig. */
    public UnaryCallSettings.Builder<DeleteApiConfigRequest, Operation> deleteApiConfigSettings() {
      return getStubSettingsBuilder().deleteApiConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApiConfig. */
    public OperationCallSettings.Builder<DeleteApiConfigRequest, Empty, OperationMetadata>
        deleteApiConfigOperationSettings() {
      return getStubSettingsBuilder().deleteApiConfigOperationSettings();
    }

    @Override
    public ApiGatewayServiceSettings build() throws IOException {
      return new ApiGatewayServiceSettings(this);
    }
  }
}
