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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.ModelGardenServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ModelGardenServiceClient.ListPublisherModelsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.aiplatform.v1beta1.stub.ModelGardenServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ModelGardenServiceClient}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getPublisherModel:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelGardenServiceSettings.Builder modelGardenServiceSettingsBuilder =
 *     ModelGardenServiceSettings.newBuilder();
 * modelGardenServiceSettingsBuilder
 *     .getPublisherModelSettings()
 *     .setRetrySettings(
 *         modelGardenServiceSettingsBuilder
 *             .getPublisherModelSettings()
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
 * ModelGardenServiceSettings modelGardenServiceSettings =
 *     modelGardenServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for deploy:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ModelGardenServiceSettings.Builder modelGardenServiceSettingsBuilder =
 *     ModelGardenServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * modelGardenServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ModelGardenServiceSettings extends ClientSettings<ModelGardenServiceSettings> {

  /** Returns the object with the settings used for calls to getPublisherModel. */
  public UnaryCallSettings<GetPublisherModelRequest, PublisherModel> getPublisherModelSettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).getPublisherModelSettings();
  }

  /** Returns the object with the settings used for calls to listPublisherModels. */
  public PagedCallSettings<
          ListPublisherModelsRequest, ListPublisherModelsResponse, ListPublisherModelsPagedResponse>
      listPublisherModelsSettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).listPublisherModelsSettings();
  }

  /** Returns the object with the settings used for calls to deploy. */
  public UnaryCallSettings<DeployRequest, Operation> deploySettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).deploySettings();
  }

  /** Returns the object with the settings used for calls to deploy. */
  public OperationCallSettings<DeployRequest, DeployResponse, DeployOperationMetadata>
      deployOperationSettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).deployOperationSettings();
  }

  /** Returns the object with the settings used for calls to deployPublisherModel. */
  public UnaryCallSettings<DeployPublisherModelRequest, Operation> deployPublisherModelSettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).deployPublisherModelSettings();
  }

  /** Returns the object with the settings used for calls to deployPublisherModel. */
  public OperationCallSettings<
          DeployPublisherModelRequest,
          DeployPublisherModelResponse,
          DeployPublisherModelOperationMetadata>
      deployPublisherModelOperationSettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings())
        .deployPublisherModelOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ModelGardenServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ModelGardenServiceSettings create(ModelGardenServiceStubSettings stub)
      throws IOException {
    return new ModelGardenServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ModelGardenServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ModelGardenServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ModelGardenServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ModelGardenServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ModelGardenServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ModelGardenServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ModelGardenServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ModelGardenServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ModelGardenServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ModelGardenServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ModelGardenServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ModelGardenServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ModelGardenServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ModelGardenServiceStubSettings.newBuilder());
    }

    public ModelGardenServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ModelGardenServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getPublisherModel. */
    public UnaryCallSettings.Builder<GetPublisherModelRequest, PublisherModel>
        getPublisherModelSettings() {
      return getStubSettingsBuilder().getPublisherModelSettings();
    }

    /** Returns the builder for the settings used for calls to listPublisherModels. */
    public PagedCallSettings.Builder<
            ListPublisherModelsRequest,
            ListPublisherModelsResponse,
            ListPublisherModelsPagedResponse>
        listPublisherModelsSettings() {
      return getStubSettingsBuilder().listPublisherModelsSettings();
    }

    /** Returns the builder for the settings used for calls to deploy. */
    public UnaryCallSettings.Builder<DeployRequest, Operation> deploySettings() {
      return getStubSettingsBuilder().deploySettings();
    }

    /** Returns the builder for the settings used for calls to deploy. */
    public OperationCallSettings.Builder<DeployRequest, DeployResponse, DeployOperationMetadata>
        deployOperationSettings() {
      return getStubSettingsBuilder().deployOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deployPublisherModel. */
    public UnaryCallSettings.Builder<DeployPublisherModelRequest, Operation>
        deployPublisherModelSettings() {
      return getStubSettingsBuilder().deployPublisherModelSettings();
    }

    /** Returns the builder for the settings used for calls to deployPublisherModel. */
    public OperationCallSettings.Builder<
            DeployPublisherModelRequest,
            DeployPublisherModelResponse,
            DeployPublisherModelOperationMetadata>
        deployPublisherModelOperationSettings() {
      return getStubSettingsBuilder().deployPublisherModelOperationSettings();
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
    public ModelGardenServiceSettings build() throws IOException {
      return new ModelGardenServiceSettings(this);
    }
  }
}
