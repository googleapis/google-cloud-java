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

package com.google.cloud.apigeeregistry.v1;

import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiDeploymentsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecRevisionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiSpecsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApiVersionsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListApisPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListArtifactsPagedResponse;
import static com.google.cloud.apigeeregistry.v1.RegistryClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
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
import com.google.cloud.apigeeregistry.v1.stub.RegistryStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegistryClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (apigeeregistry.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getApi to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegistrySettings.Builder registrySettingsBuilder = RegistrySettings.newBuilder();
 * registrySettingsBuilder
 *     .getApiSettings()
 *     .setRetrySettings(
 *         registrySettingsBuilder.getApiSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegistrySettings registrySettings = registrySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegistrySettings extends ClientSettings<RegistrySettings> {

  /** Returns the object with the settings used for calls to listApis. */
  public PagedCallSettings<ListApisRequest, ListApisResponse, ListApisPagedResponse>
      listApisSettings() {
    return ((RegistryStubSettings) getStubSettings()).listApisSettings();
  }

  /** Returns the object with the settings used for calls to getApi. */
  public UnaryCallSettings<GetApiRequest, Api> getApiSettings() {
    return ((RegistryStubSettings) getStubSettings()).getApiSettings();
  }

  /** Returns the object with the settings used for calls to createApi. */
  public UnaryCallSettings<CreateApiRequest, Api> createApiSettings() {
    return ((RegistryStubSettings) getStubSettings()).createApiSettings();
  }

  /** Returns the object with the settings used for calls to updateApi. */
  public UnaryCallSettings<UpdateApiRequest, Api> updateApiSettings() {
    return ((RegistryStubSettings) getStubSettings()).updateApiSettings();
  }

  /** Returns the object with the settings used for calls to deleteApi. */
  public UnaryCallSettings<DeleteApiRequest, Empty> deleteApiSettings() {
    return ((RegistryStubSettings) getStubSettings()).deleteApiSettings();
  }

  /** Returns the object with the settings used for calls to listApiVersions. */
  public PagedCallSettings<
          ListApiVersionsRequest, ListApiVersionsResponse, ListApiVersionsPagedResponse>
      listApiVersionsSettings() {
    return ((RegistryStubSettings) getStubSettings()).listApiVersionsSettings();
  }

  /** Returns the object with the settings used for calls to getApiVersion. */
  public UnaryCallSettings<GetApiVersionRequest, ApiVersion> getApiVersionSettings() {
    return ((RegistryStubSettings) getStubSettings()).getApiVersionSettings();
  }

  /** Returns the object with the settings used for calls to createApiVersion. */
  public UnaryCallSettings<CreateApiVersionRequest, ApiVersion> createApiVersionSettings() {
    return ((RegistryStubSettings) getStubSettings()).createApiVersionSettings();
  }

  /** Returns the object with the settings used for calls to updateApiVersion. */
  public UnaryCallSettings<UpdateApiVersionRequest, ApiVersion> updateApiVersionSettings() {
    return ((RegistryStubSettings) getStubSettings()).updateApiVersionSettings();
  }

  /** Returns the object with the settings used for calls to deleteApiVersion. */
  public UnaryCallSettings<DeleteApiVersionRequest, Empty> deleteApiVersionSettings() {
    return ((RegistryStubSettings) getStubSettings()).deleteApiVersionSettings();
  }

  /** Returns the object with the settings used for calls to listApiSpecs. */
  public PagedCallSettings<ListApiSpecsRequest, ListApiSpecsResponse, ListApiSpecsPagedResponse>
      listApiSpecsSettings() {
    return ((RegistryStubSettings) getStubSettings()).listApiSpecsSettings();
  }

  /** Returns the object with the settings used for calls to getApiSpec. */
  public UnaryCallSettings<GetApiSpecRequest, ApiSpec> getApiSpecSettings() {
    return ((RegistryStubSettings) getStubSettings()).getApiSpecSettings();
  }

  /** Returns the object with the settings used for calls to getApiSpecContents. */
  public UnaryCallSettings<GetApiSpecContentsRequest, HttpBody> getApiSpecContentsSettings() {
    return ((RegistryStubSettings) getStubSettings()).getApiSpecContentsSettings();
  }

  /** Returns the object with the settings used for calls to createApiSpec. */
  public UnaryCallSettings<CreateApiSpecRequest, ApiSpec> createApiSpecSettings() {
    return ((RegistryStubSettings) getStubSettings()).createApiSpecSettings();
  }

  /** Returns the object with the settings used for calls to updateApiSpec. */
  public UnaryCallSettings<UpdateApiSpecRequest, ApiSpec> updateApiSpecSettings() {
    return ((RegistryStubSettings) getStubSettings()).updateApiSpecSettings();
  }

  /** Returns the object with the settings used for calls to deleteApiSpec. */
  public UnaryCallSettings<DeleteApiSpecRequest, Empty> deleteApiSpecSettings() {
    return ((RegistryStubSettings) getStubSettings()).deleteApiSpecSettings();
  }

  /** Returns the object with the settings used for calls to tagApiSpecRevision. */
  public UnaryCallSettings<TagApiSpecRevisionRequest, ApiSpec> tagApiSpecRevisionSettings() {
    return ((RegistryStubSettings) getStubSettings()).tagApiSpecRevisionSettings();
  }

  /** Returns the object with the settings used for calls to listApiSpecRevisions. */
  public PagedCallSettings<
          ListApiSpecRevisionsRequest,
          ListApiSpecRevisionsResponse,
          ListApiSpecRevisionsPagedResponse>
      listApiSpecRevisionsSettings() {
    return ((RegistryStubSettings) getStubSettings()).listApiSpecRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to rollbackApiSpec. */
  public UnaryCallSettings<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecSettings() {
    return ((RegistryStubSettings) getStubSettings()).rollbackApiSpecSettings();
  }

  /** Returns the object with the settings used for calls to deleteApiSpecRevision. */
  public UnaryCallSettings<DeleteApiSpecRevisionRequest, ApiSpec> deleteApiSpecRevisionSettings() {
    return ((RegistryStubSettings) getStubSettings()).deleteApiSpecRevisionSettings();
  }

  /** Returns the object with the settings used for calls to listApiDeployments. */
  public PagedCallSettings<
          ListApiDeploymentsRequest, ListApiDeploymentsResponse, ListApiDeploymentsPagedResponse>
      listApiDeploymentsSettings() {
    return ((RegistryStubSettings) getStubSettings()).listApiDeploymentsSettings();
  }

  /** Returns the object with the settings used for calls to getApiDeployment. */
  public UnaryCallSettings<GetApiDeploymentRequest, ApiDeployment> getApiDeploymentSettings() {
    return ((RegistryStubSettings) getStubSettings()).getApiDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to createApiDeployment. */
  public UnaryCallSettings<CreateApiDeploymentRequest, ApiDeployment>
      createApiDeploymentSettings() {
    return ((RegistryStubSettings) getStubSettings()).createApiDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to updateApiDeployment. */
  public UnaryCallSettings<UpdateApiDeploymentRequest, ApiDeployment>
      updateApiDeploymentSettings() {
    return ((RegistryStubSettings) getStubSettings()).updateApiDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deleteApiDeployment. */
  public UnaryCallSettings<DeleteApiDeploymentRequest, Empty> deleteApiDeploymentSettings() {
    return ((RegistryStubSettings) getStubSettings()).deleteApiDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to tagApiDeploymentRevision. */
  public UnaryCallSettings<TagApiDeploymentRevisionRequest, ApiDeployment>
      tagApiDeploymentRevisionSettings() {
    return ((RegistryStubSettings) getStubSettings()).tagApiDeploymentRevisionSettings();
  }

  /** Returns the object with the settings used for calls to listApiDeploymentRevisions. */
  public PagedCallSettings<
          ListApiDeploymentRevisionsRequest,
          ListApiDeploymentRevisionsResponse,
          ListApiDeploymentRevisionsPagedResponse>
      listApiDeploymentRevisionsSettings() {
    return ((RegistryStubSettings) getStubSettings()).listApiDeploymentRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to rollbackApiDeployment. */
  public UnaryCallSettings<RollbackApiDeploymentRequest, ApiDeployment>
      rollbackApiDeploymentSettings() {
    return ((RegistryStubSettings) getStubSettings()).rollbackApiDeploymentSettings();
  }

  /** Returns the object with the settings used for calls to deleteApiDeploymentRevision. */
  public UnaryCallSettings<DeleteApiDeploymentRevisionRequest, ApiDeployment>
      deleteApiDeploymentRevisionSettings() {
    return ((RegistryStubSettings) getStubSettings()).deleteApiDeploymentRevisionSettings();
  }

  /** Returns the object with the settings used for calls to listArtifacts. */
  public PagedCallSettings<ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>
      listArtifactsSettings() {
    return ((RegistryStubSettings) getStubSettings()).listArtifactsSettings();
  }

  /** Returns the object with the settings used for calls to getArtifact. */
  public UnaryCallSettings<GetArtifactRequest, Artifact> getArtifactSettings() {
    return ((RegistryStubSettings) getStubSettings()).getArtifactSettings();
  }

  /** Returns the object with the settings used for calls to getArtifactContents. */
  public UnaryCallSettings<GetArtifactContentsRequest, HttpBody> getArtifactContentsSettings() {
    return ((RegistryStubSettings) getStubSettings()).getArtifactContentsSettings();
  }

  /** Returns the object with the settings used for calls to createArtifact. */
  public UnaryCallSettings<CreateArtifactRequest, Artifact> createArtifactSettings() {
    return ((RegistryStubSettings) getStubSettings()).createArtifactSettings();
  }

  /** Returns the object with the settings used for calls to replaceArtifact. */
  public UnaryCallSettings<ReplaceArtifactRequest, Artifact> replaceArtifactSettings() {
    return ((RegistryStubSettings) getStubSettings()).replaceArtifactSettings();
  }

  /** Returns the object with the settings used for calls to deleteArtifact. */
  public UnaryCallSettings<DeleteArtifactRequest, Empty> deleteArtifactSettings() {
    return ((RegistryStubSettings) getStubSettings()).deleteArtifactSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((RegistryStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((RegistryStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((RegistryStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((RegistryStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((RegistryStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final RegistrySettings create(RegistryStubSettings stub) throws IOException {
    return new RegistrySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegistryStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegistryStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegistryStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegistryStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RegistryStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegistryStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegistryStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegistryStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegistrySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegistrySettings. */
  public static class Builder extends ClientSettings.Builder<RegistrySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegistryStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegistrySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegistryStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegistryStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(RegistryStubSettings.newHttpJsonBuilder());
    }

    public RegistryStubSettings.Builder getStubSettingsBuilder() {
      return ((RegistryStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<CreateApiRequest, Api> createApiSettings() {
      return getStubSettingsBuilder().createApiSettings();
    }

    /** Returns the builder for the settings used for calls to updateApi. */
    public UnaryCallSettings.Builder<UpdateApiRequest, Api> updateApiSettings() {
      return getStubSettingsBuilder().updateApiSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApi. */
    public UnaryCallSettings.Builder<DeleteApiRequest, Empty> deleteApiSettings() {
      return getStubSettingsBuilder().deleteApiSettings();
    }

    /** Returns the builder for the settings used for calls to listApiVersions. */
    public PagedCallSettings.Builder<
            ListApiVersionsRequest, ListApiVersionsResponse, ListApiVersionsPagedResponse>
        listApiVersionsSettings() {
      return getStubSettingsBuilder().listApiVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to getApiVersion. */
    public UnaryCallSettings.Builder<GetApiVersionRequest, ApiVersion> getApiVersionSettings() {
      return getStubSettingsBuilder().getApiVersionSettings();
    }

    /** Returns the builder for the settings used for calls to createApiVersion. */
    public UnaryCallSettings.Builder<CreateApiVersionRequest, ApiVersion>
        createApiVersionSettings() {
      return getStubSettingsBuilder().createApiVersionSettings();
    }

    /** Returns the builder for the settings used for calls to updateApiVersion. */
    public UnaryCallSettings.Builder<UpdateApiVersionRequest, ApiVersion>
        updateApiVersionSettings() {
      return getStubSettingsBuilder().updateApiVersionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApiVersion. */
    public UnaryCallSettings.Builder<DeleteApiVersionRequest, Empty> deleteApiVersionSettings() {
      return getStubSettingsBuilder().deleteApiVersionSettings();
    }

    /** Returns the builder for the settings used for calls to listApiSpecs. */
    public PagedCallSettings.Builder<
            ListApiSpecsRequest, ListApiSpecsResponse, ListApiSpecsPagedResponse>
        listApiSpecsSettings() {
      return getStubSettingsBuilder().listApiSpecsSettings();
    }

    /** Returns the builder for the settings used for calls to getApiSpec. */
    public UnaryCallSettings.Builder<GetApiSpecRequest, ApiSpec> getApiSpecSettings() {
      return getStubSettingsBuilder().getApiSpecSettings();
    }

    /** Returns the builder for the settings used for calls to getApiSpecContents. */
    public UnaryCallSettings.Builder<GetApiSpecContentsRequest, HttpBody>
        getApiSpecContentsSettings() {
      return getStubSettingsBuilder().getApiSpecContentsSettings();
    }

    /** Returns the builder for the settings used for calls to createApiSpec. */
    public UnaryCallSettings.Builder<CreateApiSpecRequest, ApiSpec> createApiSpecSettings() {
      return getStubSettingsBuilder().createApiSpecSettings();
    }

    /** Returns the builder for the settings used for calls to updateApiSpec. */
    public UnaryCallSettings.Builder<UpdateApiSpecRequest, ApiSpec> updateApiSpecSettings() {
      return getStubSettingsBuilder().updateApiSpecSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApiSpec. */
    public UnaryCallSettings.Builder<DeleteApiSpecRequest, Empty> deleteApiSpecSettings() {
      return getStubSettingsBuilder().deleteApiSpecSettings();
    }

    /** Returns the builder for the settings used for calls to tagApiSpecRevision. */
    public UnaryCallSettings.Builder<TagApiSpecRevisionRequest, ApiSpec>
        tagApiSpecRevisionSettings() {
      return getStubSettingsBuilder().tagApiSpecRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to listApiSpecRevisions. */
    public PagedCallSettings.Builder<
            ListApiSpecRevisionsRequest,
            ListApiSpecRevisionsResponse,
            ListApiSpecRevisionsPagedResponse>
        listApiSpecRevisionsSettings() {
      return getStubSettingsBuilder().listApiSpecRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to rollbackApiSpec. */
    public UnaryCallSettings.Builder<RollbackApiSpecRequest, ApiSpec> rollbackApiSpecSettings() {
      return getStubSettingsBuilder().rollbackApiSpecSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApiSpecRevision. */
    public UnaryCallSettings.Builder<DeleteApiSpecRevisionRequest, ApiSpec>
        deleteApiSpecRevisionSettings() {
      return getStubSettingsBuilder().deleteApiSpecRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to listApiDeployments. */
    public PagedCallSettings.Builder<
            ListApiDeploymentsRequest, ListApiDeploymentsResponse, ListApiDeploymentsPagedResponse>
        listApiDeploymentsSettings() {
      return getStubSettingsBuilder().listApiDeploymentsSettings();
    }

    /** Returns the builder for the settings used for calls to getApiDeployment. */
    public UnaryCallSettings.Builder<GetApiDeploymentRequest, ApiDeployment>
        getApiDeploymentSettings() {
      return getStubSettingsBuilder().getApiDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to createApiDeployment. */
    public UnaryCallSettings.Builder<CreateApiDeploymentRequest, ApiDeployment>
        createApiDeploymentSettings() {
      return getStubSettingsBuilder().createApiDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to updateApiDeployment. */
    public UnaryCallSettings.Builder<UpdateApiDeploymentRequest, ApiDeployment>
        updateApiDeploymentSettings() {
      return getStubSettingsBuilder().updateApiDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApiDeployment. */
    public UnaryCallSettings.Builder<DeleteApiDeploymentRequest, Empty>
        deleteApiDeploymentSettings() {
      return getStubSettingsBuilder().deleteApiDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to tagApiDeploymentRevision. */
    public UnaryCallSettings.Builder<TagApiDeploymentRevisionRequest, ApiDeployment>
        tagApiDeploymentRevisionSettings() {
      return getStubSettingsBuilder().tagApiDeploymentRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to listApiDeploymentRevisions. */
    public PagedCallSettings.Builder<
            ListApiDeploymentRevisionsRequest,
            ListApiDeploymentRevisionsResponse,
            ListApiDeploymentRevisionsPagedResponse>
        listApiDeploymentRevisionsSettings() {
      return getStubSettingsBuilder().listApiDeploymentRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to rollbackApiDeployment. */
    public UnaryCallSettings.Builder<RollbackApiDeploymentRequest, ApiDeployment>
        rollbackApiDeploymentSettings() {
      return getStubSettingsBuilder().rollbackApiDeploymentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteApiDeploymentRevision. */
    public UnaryCallSettings.Builder<DeleteApiDeploymentRevisionRequest, ApiDeployment>
        deleteApiDeploymentRevisionSettings() {
      return getStubSettingsBuilder().deleteApiDeploymentRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to listArtifacts. */
    public PagedCallSettings.Builder<
            ListArtifactsRequest, ListArtifactsResponse, ListArtifactsPagedResponse>
        listArtifactsSettings() {
      return getStubSettingsBuilder().listArtifactsSettings();
    }

    /** Returns the builder for the settings used for calls to getArtifact. */
    public UnaryCallSettings.Builder<GetArtifactRequest, Artifact> getArtifactSettings() {
      return getStubSettingsBuilder().getArtifactSettings();
    }

    /** Returns the builder for the settings used for calls to getArtifactContents. */
    public UnaryCallSettings.Builder<GetArtifactContentsRequest, HttpBody>
        getArtifactContentsSettings() {
      return getStubSettingsBuilder().getArtifactContentsSettings();
    }

    /** Returns the builder for the settings used for calls to createArtifact. */
    public UnaryCallSettings.Builder<CreateArtifactRequest, Artifact> createArtifactSettings() {
      return getStubSettingsBuilder().createArtifactSettings();
    }

    /** Returns the builder for the settings used for calls to replaceArtifact. */
    public UnaryCallSettings.Builder<ReplaceArtifactRequest, Artifact> replaceArtifactSettings() {
      return getStubSettingsBuilder().replaceArtifactSettings();
    }

    /** Returns the builder for the settings used for calls to deleteArtifact. */
    public UnaryCallSettings.Builder<DeleteArtifactRequest, Empty> deleteArtifactSettings() {
      return getStubSettingsBuilder().deleteArtifactSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public RegistrySettings build() throws IOException {
      return new RegistrySettings(this);
    }
  }
}
