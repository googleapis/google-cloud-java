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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListDeploymentResourcePoolsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.DeploymentResourcePoolServiceClient.QueryDeployedModelsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.aiplatform.v1beta1.stub.DeploymentResourcePoolServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DeploymentResourcePoolServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDeploymentResourcePool to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DeploymentResourcePoolServiceSettings.Builder deploymentResourcePoolServiceSettingsBuilder =
 *     DeploymentResourcePoolServiceSettings.newBuilder();
 * deploymentResourcePoolServiceSettingsBuilder
 *     .getDeploymentResourcePoolSettings()
 *     .setRetrySettings(
 *         deploymentResourcePoolServiceSettingsBuilder
 *             .getDeploymentResourcePoolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DeploymentResourcePoolServiceSettings deploymentResourcePoolServiceSettings =
 *     deploymentResourcePoolServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DeploymentResourcePoolServiceSettings
    extends ClientSettings<DeploymentResourcePoolServiceSettings> {

  /** Returns the object with the settings used for calls to createDeploymentResourcePool. */
  public UnaryCallSettings<CreateDeploymentResourcePoolRequest, Operation>
      createDeploymentResourcePoolSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings())
        .createDeploymentResourcePoolSettings();
  }

  /** Returns the object with the settings used for calls to createDeploymentResourcePool. */
  public OperationCallSettings<
          CreateDeploymentResourcePoolRequest,
          DeploymentResourcePool,
          CreateDeploymentResourcePoolOperationMetadata>
      createDeploymentResourcePoolOperationSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings())
        .createDeploymentResourcePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getDeploymentResourcePool. */
  public UnaryCallSettings<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
      getDeploymentResourcePoolSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings())
        .getDeploymentResourcePoolSettings();
  }

  /** Returns the object with the settings used for calls to listDeploymentResourcePools. */
  public PagedCallSettings<
          ListDeploymentResourcePoolsRequest,
          ListDeploymentResourcePoolsResponse,
          ListDeploymentResourcePoolsPagedResponse>
      listDeploymentResourcePoolsSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings())
        .listDeploymentResourcePoolsSettings();
  }

  /** Returns the object with the settings used for calls to deleteDeploymentResourcePool. */
  public UnaryCallSettings<DeleteDeploymentResourcePoolRequest, Operation>
      deleteDeploymentResourcePoolSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings())
        .deleteDeploymentResourcePoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteDeploymentResourcePool. */
  public OperationCallSettings<DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
      deleteDeploymentResourcePoolOperationSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings())
        .deleteDeploymentResourcePoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to queryDeployedModels. */
  public PagedCallSettings<
          QueryDeployedModelsRequest, QueryDeployedModelsResponse, QueryDeployedModelsPagedResponse>
      queryDeployedModelsSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings())
        .queryDeployedModelsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DeploymentResourcePoolServiceStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final DeploymentResourcePoolServiceSettings create(
      DeploymentResourcePoolServiceStubSettings stub) throws IOException {
    return new DeploymentResourcePoolServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DeploymentResourcePoolServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DeploymentResourcePoolServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DeploymentResourcePoolServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DeploymentResourcePoolServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DeploymentResourcePoolServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DeploymentResourcePoolServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DeploymentResourcePoolServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DeploymentResourcePoolServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DeploymentResourcePoolServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<DeploymentResourcePoolServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DeploymentResourcePoolServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DeploymentResourcePoolServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DeploymentResourcePoolServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DeploymentResourcePoolServiceStubSettings.newBuilder());
    }

    public DeploymentResourcePoolServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DeploymentResourcePoolServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createDeploymentResourcePool. */
    public UnaryCallSettings.Builder<CreateDeploymentResourcePoolRequest, Operation>
        createDeploymentResourcePoolSettings() {
      return getStubSettingsBuilder().createDeploymentResourcePoolSettings();
    }

    /** Returns the builder for the settings used for calls to createDeploymentResourcePool. */
    public OperationCallSettings.Builder<
            CreateDeploymentResourcePoolRequest,
            DeploymentResourcePool,
            CreateDeploymentResourcePoolOperationMetadata>
        createDeploymentResourcePoolOperationSettings() {
      return getStubSettingsBuilder().createDeploymentResourcePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getDeploymentResourcePool. */
    public UnaryCallSettings.Builder<GetDeploymentResourcePoolRequest, DeploymentResourcePool>
        getDeploymentResourcePoolSettings() {
      return getStubSettingsBuilder().getDeploymentResourcePoolSettings();
    }

    /** Returns the builder for the settings used for calls to listDeploymentResourcePools. */
    public PagedCallSettings.Builder<
            ListDeploymentResourcePoolsRequest,
            ListDeploymentResourcePoolsResponse,
            ListDeploymentResourcePoolsPagedResponse>
        listDeploymentResourcePoolsSettings() {
      return getStubSettingsBuilder().listDeploymentResourcePoolsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeploymentResourcePool. */
    public UnaryCallSettings.Builder<DeleteDeploymentResourcePoolRequest, Operation>
        deleteDeploymentResourcePoolSettings() {
      return getStubSettingsBuilder().deleteDeploymentResourcePoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDeploymentResourcePool. */
    public OperationCallSettings.Builder<
            DeleteDeploymentResourcePoolRequest, Empty, DeleteOperationMetadata>
        deleteDeploymentResourcePoolOperationSettings() {
      return getStubSettingsBuilder().deleteDeploymentResourcePoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to queryDeployedModels. */
    public PagedCallSettings.Builder<
            QueryDeployedModelsRequest,
            QueryDeployedModelsResponse,
            QueryDeployedModelsPagedResponse>
        queryDeployedModelsSettings() {
      return getStubSettingsBuilder().queryDeployedModelsSettings();
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
    public DeploymentResourcePoolServiceSettings build() throws IOException {
      return new DeploymentResourcePoolServiceSettings(this);
    }
  }
}
