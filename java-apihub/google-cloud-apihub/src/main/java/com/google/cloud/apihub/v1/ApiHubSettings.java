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

package com.google.cloud.apihub.v1;

import static com.google.cloud.apihub.v1.ApiHubClient.ListApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListAttributesPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListDeploymentsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListExternalApisPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListLocationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListSpecsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.ListVersionsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubClient.SearchResourcesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.apihub.v1.stub.ApiHubStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ApiHubClient}.
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
 * <p>For example, to set the total timeout of createApi to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ApiHubSettings.Builder apiHubSettingsBuilder = ApiHubSettings.newBuilder();
 * apiHubSettingsBuilder
 *     .createApiSettings()
 *     .setRetrySettings(
 *         apiHubSettingsBuilder
 *             .createApiSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ApiHubSettings apiHubSettings = apiHubSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ApiHubSettings extends ClientSettings<ApiHubSettings> {

  /** Returns the object with the settings used for calls to createApi. */
  public UnaryCallSettings<CreateApiRequest, Api> createApiSettings() {
    return ((ApiHubStubSettings) getStubSettings()).createApiSettings();
  }

  /** Returns the object with the settings used for calls to getApi. */
  public UnaryCallSettings<GetApiRequest, Api> getApiSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getApiSettings();
  }

  /** Returns the object with the settings used for calls to listApis. */
  public PagedCallSettings<ListApisRequest, ListApisResponse, ListApisPagedResponse>
      listApisSettings() {
    return ((ApiHubStubSettings) getStubSettings()).listApisSettings();
  }

  /** Returns the object with the settings used for calls to updateApi. */
  public UnaryCallSettings<UpdateApiRequest, Api> updateApiSettings() {
    return ((ApiHubStubSettings) getStubSettings()).updateApiSettings();
  }

  /** Returns the object with the settings used for calls to deleteApi. */
  public UnaryCallSettings<DeleteApiRequest, Empty> deleteApiSettings() {
    return ((ApiHubStubSettings) getStubSettings()).deleteApiSettings();
  }

  /** Returns the object with the settings used for calls to createVersion. */
  public UnaryCallSettings<CreateVersionRequest, Version> createVersionSettings() {
    return ((ApiHubStubSettings) getStubSettings()).createVersionSettings();
  }

  /** Returns the object with the settings used for calls to getVersion. */
  public UnaryCallSettings<GetVersionRequest, Version> getVersionSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getVersionSettings();
  }

  /** Returns the object with the settings used for calls to listVersions. */
  public PagedCallSettings<ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
      listVersionsSettings() {
    return ((ApiHubStubSettings) getStubSettings()).listVersionsSettings();
  }

  /** Returns the object with the settings used for calls to updateVersion. */
  public UnaryCallSettings<UpdateVersionRequest, Version> updateVersionSettings() {
    return ((ApiHubStubSettings) getStubSettings()).updateVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteVersion. */
  public UnaryCallSettings<DeleteVersionRequest, Empty> deleteVersionSettings() {
    return ((ApiHubStubSettings) getStubSettings()).deleteVersionSettings();
  }

  /** Returns the object with the settings used for calls to createSpec. */
  public UnaryCallSettings<CreateSpecRequest, Spec> createSpecSettings() {
    return ((ApiHubStubSettings) getStubSettings()).createSpecSettings();
  }

  /** Returns the object with the settings used for calls to getSpec. */
  public UnaryCallSettings<GetSpecRequest, Spec> getSpecSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getSpecSettings();
  }

  /** Returns the object with the settings used for calls to getSpecContents. */
  public UnaryCallSettings<GetSpecContentsRequest, SpecContents> getSpecContentsSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getSpecContentsSettings();
  }

  /** Returns the object with the settings used for calls to listSpecs. */
  public PagedCallSettings<ListSpecsRequest, ListSpecsResponse, ListSpecsPagedResponse>
      listSpecsSettings() {
    return ((ApiHubStubSettings) getStubSettings()).listSpecsSettings();
  }

  /** Returns the object with the settings used for calls to updateSpec. */
  public UnaryCallSettings<UpdateSpecRequest, Spec> updateSpecSettings() {
    return ((ApiHubStubSettings) getStubSettings()).updateSpecSettings();
  }

  /** Returns the object with the settings used for calls to deleteSpec. */
  public UnaryCallSettings<DeleteSpecRequest, Empty> deleteSpecSettings() {
    return ((ApiHubStubSettings) getStubSettings()).deleteSpecSettings();
  }

  /** Returns the object with the settings used for calls to getApi. */
  public UnaryCallSettings<GetApiOperationRequest, ApiOperation> getApiOperationSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getApiOperationSettings();
  }

  /** Returns the object with the settings used for calls to listApiOperations. */
  public PagedCallSettings<
          ListApiOperationsRequest, ListApiOperationsResponse, ListApiOperationsPagedResponse>
      listApiOperationsSettings() {
    return ((ApiHubStubSettings) getStubSettings()).listApiOperationsSettings();
  }

  /** Returns the object with the settings used for calls to getDefinition. */
  public UnaryCallSettings<GetDefinitionRequest, Definition> getDefinitionSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getDefinitionSettings();
  }

  /** Returns the object with the settings used for calls to createDeployment. */
  public UnaryCallSettings<CreateDeploymentRequest, Deployment> createDeploymentSettings() {
    return ((ApiHubStubSettings) getStubSettings()).createDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to getDeployment. */
  public UnaryCallSettings<GetDeploymentRequest, Deployment> getDeploymentSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to listDeployments. */
  public PagedCallSettings<
          ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
      listDeploymentsSettings() {
    return ((ApiHubStubSettings) getStubSettings()).listDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to updateDeployment. */
  public UnaryCallSettings<UpdateDeploymentRequest, Deployment> updateDeploymentSettings() {
    return ((ApiHubStubSettings) getStubSettings()).updateDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deleteDeployment. */
  public UnaryCallSettings<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
    return ((ApiHubStubSettings) getStubSettings()).deleteDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createAttribute. */
  public UnaryCallSettings<CreateAttributeRequest, Attribute> createAttributeSettings() {
    return ((ApiHubStubSettings) getStubSettings()).createAttributeSettings();
  }

  /** Returns the object with the settings used for calls to getAttribute. */
  public UnaryCallSettings<GetAttributeRequest, Attribute> getAttributeSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getAttributeSettings();
  }

  /** Returns the object with the settings used for calls to updateAttribute. */
  public UnaryCallSettings<UpdateAttributeRequest, Attribute> updateAttributeSettings() {
    return ((ApiHubStubSettings) getStubSettings()).updateAttributeSettings();
  }

  /** Returns the object with the settings used for calls to deleteAttribute. */
  public UnaryCallSettings<DeleteAttributeRequest, Empty> deleteAttributeSettings() {
    return ((ApiHubStubSettings) getStubSettings()).deleteAttributeSettings();
  }

  /** Returns the object with the settings used for calls to listAttributes. */
  public PagedCallSettings<
          ListAttributesRequest, ListAttributesResponse, ListAttributesPagedResponse>
      listAttributesSettings() {
    return ((ApiHubStubSettings) getStubSettings()).listAttributesSettings();
  }

  /** Returns the object with the settings used for calls to searchResources. */
  public PagedCallSettings<
          SearchResourcesRequest, SearchResourcesResponse, SearchResourcesPagedResponse>
      searchResourcesSettings() {
    return ((ApiHubStubSettings) getStubSettings()).searchResourcesSettings();
  }

  /** Returns the object with the settings used for calls to createExternalApi. */
  public UnaryCallSettings<CreateExternalApiRequest, ExternalApi> createExternalApiSettings() {
    return ((ApiHubStubSettings) getStubSettings()).createExternalApiSettings();
  }

  /** Returns the object with the settings used for calls to getExternalApi. */
  public UnaryCallSettings<GetExternalApiRequest, ExternalApi> getExternalApiSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getExternalApiSettings();
  }

  /** Returns the object with the settings used for calls to updateExternalApi. */
  public UnaryCallSettings<UpdateExternalApiRequest, ExternalApi> updateExternalApiSettings() {
    return ((ApiHubStubSettings) getStubSettings()).updateExternalApiSettings();
  }

  /** Returns the object with the settings used for calls to deleteExternalApi. */
  public UnaryCallSettings<DeleteExternalApiRequest, Empty> deleteExternalApiSettings() {
    return ((ApiHubStubSettings) getStubSettings()).deleteExternalApiSettings();
  }

  /** Returns the object with the settings used for calls to listExternalApis. */
  public PagedCallSettings<
          ListExternalApisRequest, ListExternalApisResponse, ListExternalApisPagedResponse>
      listExternalApisSettings() {
    return ((ApiHubStubSettings) getStubSettings()).listExternalApisSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ApiHubStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ApiHubStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final ApiHubSettings create(ApiHubStubSettings stub) throws IOException {
    return new ApiHubSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ApiHubStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ApiHubStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ApiHubStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ApiHubStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ApiHubStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ApiHubStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiHubStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ApiHubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ApiHubSettings. */
  public static class Builder extends ClientSettings.Builder<ApiHubSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ApiHubStubSettings.newBuilder(clientContext));
    }

    protected Builder(ApiHubSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ApiHubStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ApiHubStubSettings.newBuilder());
    }

    public ApiHubStubSettings.Builder getStubSettingsBuilder() {
      return ((ApiHubStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createApi. */
    public UnaryCallSettings.Builder<CreateApiRequest, Api> createApiSettings() {
      return getStubSettingsBuilder().createApiSettings();
    }

    /** Returns the builder for the settings used for calls to getApi. */
    public UnaryCallSettings.Builder<GetApiRequest, Api> getApiSettings() {
      return getStubSettingsBuilder().getApiSettings();
    }

    /** Returns the builder for the settings used for calls to listApis. */
    public PagedCallSettings.Builder<ListApisRequest, ListApisResponse, ListApisPagedResponse>
        listApisSettings() {
      return getStubSettingsBuilder().listApisSettings();
    }

    /** Returns the builder for the settings used for calls to updateApi. */
    public UnaryCallSettings.Builder<UpdateApiRequest, Api> updateApiSettings() {
      return getStubSettingsBuilder().updateApiSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApi. */
    public UnaryCallSettings.Builder<DeleteApiRequest, Empty> deleteApiSettings() {
      return getStubSettingsBuilder().deleteApiSettings();
    }

    /** Returns the builder for the settings used for calls to createVersion. */
    public UnaryCallSettings.Builder<CreateVersionRequest, Version> createVersionSettings() {
      return getStubSettingsBuilder().createVersionSettings();
    }

    /** Returns the builder for the settings used for calls to getVersion. */
    public UnaryCallSettings.Builder<GetVersionRequest, Version> getVersionSettings() {
      return getStubSettingsBuilder().getVersionSettings();
    }

    /** Returns the builder for the settings used for calls to listVersions. */
    public PagedCallSettings.Builder<
            ListVersionsRequest, ListVersionsResponse, ListVersionsPagedResponse>
        listVersionsSettings() {
      return getStubSettingsBuilder().listVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to updateVersion. */
    public UnaryCallSettings.Builder<UpdateVersionRequest, Version> updateVersionSettings() {
      return getStubSettingsBuilder().updateVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVersion. */
    public UnaryCallSettings.Builder<DeleteVersionRequest, Empty> deleteVersionSettings() {
      return getStubSettingsBuilder().deleteVersionSettings();
    }

    /** Returns the builder for the settings used for calls to createSpec. */
    public UnaryCallSettings.Builder<CreateSpecRequest, Spec> createSpecSettings() {
      return getStubSettingsBuilder().createSpecSettings();
    }

    /** Returns the builder for the settings used for calls to getSpec. */
    public UnaryCallSettings.Builder<GetSpecRequest, Spec> getSpecSettings() {
      return getStubSettingsBuilder().getSpecSettings();
    }

    /** Returns the builder for the settings used for calls to getSpecContents. */
    public UnaryCallSettings.Builder<GetSpecContentsRequest, SpecContents>
        getSpecContentsSettings() {
      return getStubSettingsBuilder().getSpecContentsSettings();
    }

    /** Returns the builder for the settings used for calls to listSpecs. */
    public PagedCallSettings.Builder<ListSpecsRequest, ListSpecsResponse, ListSpecsPagedResponse>
        listSpecsSettings() {
      return getStubSettingsBuilder().listSpecsSettings();
    }

    /** Returns the builder for the settings used for calls to updateSpec. */
    public UnaryCallSettings.Builder<UpdateSpecRequest, Spec> updateSpecSettings() {
      return getStubSettingsBuilder().updateSpecSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSpec. */
    public UnaryCallSettings.Builder<DeleteSpecRequest, Empty> deleteSpecSettings() {
      return getStubSettingsBuilder().deleteSpecSettings();
    }

    /** Returns the builder for the settings used for calls to getApi. */
    public UnaryCallSettings.Builder<GetApiOperationRequest, ApiOperation>
        getApiOperationSettings() {
      return getStubSettingsBuilder().getApiOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listApiOperations. */
    public PagedCallSettings.Builder<
            ListApiOperationsRequest, ListApiOperationsResponse, ListApiOperationsPagedResponse>
        listApiOperationsSettings() {
      return getStubSettingsBuilder().listApiOperationsSettings();
    }

    /** Returns the builder for the settings used for calls to getDefinition. */
    public UnaryCallSettings.Builder<GetDefinitionRequest, Definition> getDefinitionSettings() {
      return getStubSettingsBuilder().getDefinitionSettings();
    }

    /** Returns the builder for the settings used for calls to createDeployment. */
    public UnaryCallSettings.Builder<CreateDeploymentRequest, Deployment>
        createDeploymentSettings() {
      return getStubSettingsBuilder().createDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to getDeployment. */
    public UnaryCallSettings.Builder<GetDeploymentRequest, Deployment> getDeploymentSettings() {
      return getStubSettingsBuilder().getDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to listDeployments. */
    public PagedCallSettings.Builder<
            ListDeploymentsRequest, ListDeploymentsResponse, ListDeploymentsPagedResponse>
        listDeploymentsSettings() {
      return getStubSettingsBuilder().listDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to updateDeployment. */
    public UnaryCallSettings.Builder<UpdateDeploymentRequest, Deployment>
        updateDeploymentSettings() {
      return getStubSettingsBuilder().updateDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeployment. */
    public UnaryCallSettings.Builder<DeleteDeploymentRequest, Empty> deleteDeploymentSettings() {
      return getStubSettingsBuilder().deleteDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createAttribute. */
    public UnaryCallSettings.Builder<CreateAttributeRequest, Attribute> createAttributeSettings() {
      return getStubSettingsBuilder().createAttributeSettings();
    }

    /** Returns the builder for the settings used for calls to getAttribute. */
    public UnaryCallSettings.Builder<GetAttributeRequest, Attribute> getAttributeSettings() {
      return getStubSettingsBuilder().getAttributeSettings();
    }

    /** Returns the builder for the settings used for calls to updateAttribute. */
    public UnaryCallSettings.Builder<UpdateAttributeRequest, Attribute> updateAttributeSettings() {
      return getStubSettingsBuilder().updateAttributeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAttribute. */
    public UnaryCallSettings.Builder<DeleteAttributeRequest, Empty> deleteAttributeSettings() {
      return getStubSettingsBuilder().deleteAttributeSettings();
    }

    /** Returns the builder for the settings used for calls to listAttributes. */
    public PagedCallSettings.Builder<
            ListAttributesRequest, ListAttributesResponse, ListAttributesPagedResponse>
        listAttributesSettings() {
      return getStubSettingsBuilder().listAttributesSettings();
    }

    /** Returns the builder for the settings used for calls to searchResources. */
    public PagedCallSettings.Builder<
            SearchResourcesRequest, SearchResourcesResponse, SearchResourcesPagedResponse>
        searchResourcesSettings() {
      return getStubSettingsBuilder().searchResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to createExternalApi. */
    public UnaryCallSettings.Builder<CreateExternalApiRequest, ExternalApi>
        createExternalApiSettings() {
      return getStubSettingsBuilder().createExternalApiSettings();
    }

    /** Returns the builder for the settings used for calls to getExternalApi. */
    public UnaryCallSettings.Builder<GetExternalApiRequest, ExternalApi> getExternalApiSettings() {
      return getStubSettingsBuilder().getExternalApiSettings();
    }

    /** Returns the builder for the settings used for calls to updateExternalApi. */
    public UnaryCallSettings.Builder<UpdateExternalApiRequest, ExternalApi>
        updateExternalApiSettings() {
      return getStubSettingsBuilder().updateExternalApiSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExternalApi. */
    public UnaryCallSettings.Builder<DeleteExternalApiRequest, Empty> deleteExternalApiSettings() {
      return getStubSettingsBuilder().deleteExternalApiSettings();
    }

    /** Returns the builder for the settings used for calls to listExternalApis. */
    public PagedCallSettings.Builder<
            ListExternalApisRequest, ListExternalApisResponse, ListExternalApisPagedResponse>
        listExternalApisSettings() {
      return getStubSettingsBuilder().listExternalApisSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public ApiHubSettings build() throws IOException {
      return new ApiHubSettings(this);
    }
  }
}
