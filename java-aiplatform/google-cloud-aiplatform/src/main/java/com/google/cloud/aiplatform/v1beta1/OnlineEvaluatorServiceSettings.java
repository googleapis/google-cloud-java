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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.OnlineEvaluatorServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.OnlineEvaluatorServiceClient.ListOnlineEvaluatorsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.OnlineEvaluatorServiceStubSettings;
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
 * Settings class to configure an instance of {@link OnlineEvaluatorServiceClient}.
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
 * of getOnlineEvaluator:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OnlineEvaluatorServiceSettings.Builder onlineEvaluatorServiceSettingsBuilder =
 *     OnlineEvaluatorServiceSettings.newBuilder();
 * onlineEvaluatorServiceSettingsBuilder
 *     .getOnlineEvaluatorSettings()
 *     .setRetrySettings(
 *         onlineEvaluatorServiceSettingsBuilder
 *             .getOnlineEvaluatorSettings()
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
 * OnlineEvaluatorServiceSettings onlineEvaluatorServiceSettings =
 *     onlineEvaluatorServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createOnlineEvaluator:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OnlineEvaluatorServiceSettings.Builder onlineEvaluatorServiceSettingsBuilder =
 *     OnlineEvaluatorServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * onlineEvaluatorServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class OnlineEvaluatorServiceSettings extends ClientSettings<OnlineEvaluatorServiceSettings> {

  /** Returns the object with the settings used for calls to createOnlineEvaluator. */
  public UnaryCallSettings<CreateOnlineEvaluatorRequest, Operation>
      createOnlineEvaluatorSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).createOnlineEvaluatorSettings();
  }

  /** Returns the object with the settings used for calls to createOnlineEvaluator. */
  public OperationCallSettings<
          CreateOnlineEvaluatorRequest, OnlineEvaluator, CreateOnlineEvaluatorOperationMetadata>
      createOnlineEvaluatorOperationSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings())
        .createOnlineEvaluatorOperationSettings();
  }

  /** Returns the object with the settings used for calls to getOnlineEvaluator. */
  public UnaryCallSettings<GetOnlineEvaluatorRequest, OnlineEvaluator>
      getOnlineEvaluatorSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).getOnlineEvaluatorSettings();
  }

  /** Returns the object with the settings used for calls to updateOnlineEvaluator. */
  public UnaryCallSettings<UpdateOnlineEvaluatorRequest, Operation>
      updateOnlineEvaluatorSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).updateOnlineEvaluatorSettings();
  }

  /** Returns the object with the settings used for calls to updateOnlineEvaluator. */
  public OperationCallSettings<
          UpdateOnlineEvaluatorRequest, OnlineEvaluator, UpdateOnlineEvaluatorOperationMetadata>
      updateOnlineEvaluatorOperationSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings())
        .updateOnlineEvaluatorOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteOnlineEvaluator. */
  public UnaryCallSettings<DeleteOnlineEvaluatorRequest, Operation>
      deleteOnlineEvaluatorSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).deleteOnlineEvaluatorSettings();
  }

  /** Returns the object with the settings used for calls to deleteOnlineEvaluator. */
  public OperationCallSettings<
          DeleteOnlineEvaluatorRequest, Empty, DeleteOnlineEvaluatorOperationMetadata>
      deleteOnlineEvaluatorOperationSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings())
        .deleteOnlineEvaluatorOperationSettings();
  }

  /** Returns the object with the settings used for calls to listOnlineEvaluators. */
  public PagedCallSettings<
          ListOnlineEvaluatorsRequest,
          ListOnlineEvaluatorsResponse,
          ListOnlineEvaluatorsPagedResponse>
      listOnlineEvaluatorsSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).listOnlineEvaluatorsSettings();
  }

  /** Returns the object with the settings used for calls to activateOnlineEvaluator. */
  public UnaryCallSettings<ActivateOnlineEvaluatorRequest, Operation>
      activateOnlineEvaluatorSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings())
        .activateOnlineEvaluatorSettings();
  }

  /** Returns the object with the settings used for calls to activateOnlineEvaluator. */
  public OperationCallSettings<
          ActivateOnlineEvaluatorRequest, OnlineEvaluator, ActivateOnlineEvaluatorOperationMetadata>
      activateOnlineEvaluatorOperationSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings())
        .activateOnlineEvaluatorOperationSettings();
  }

  /** Returns the object with the settings used for calls to suspendOnlineEvaluator. */
  public UnaryCallSettings<SuspendOnlineEvaluatorRequest, Operation>
      suspendOnlineEvaluatorSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings())
        .suspendOnlineEvaluatorSettings();
  }

  /** Returns the object with the settings used for calls to suspendOnlineEvaluator. */
  public OperationCallSettings<
          SuspendOnlineEvaluatorRequest, OnlineEvaluator, SuspendOnlineEvaluatorOperationMetadata>
      suspendOnlineEvaluatorOperationSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings())
        .suspendOnlineEvaluatorOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((OnlineEvaluatorServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final OnlineEvaluatorServiceSettings create(OnlineEvaluatorServiceStubSettings stub)
      throws IOException {
    return new OnlineEvaluatorServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OnlineEvaluatorServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OnlineEvaluatorServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OnlineEvaluatorServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OnlineEvaluatorServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return OnlineEvaluatorServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OnlineEvaluatorServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OnlineEvaluatorServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected OnlineEvaluatorServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OnlineEvaluatorServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<OnlineEvaluatorServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OnlineEvaluatorServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(OnlineEvaluatorServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OnlineEvaluatorServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OnlineEvaluatorServiceStubSettings.newBuilder());
    }

    public OnlineEvaluatorServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((OnlineEvaluatorServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createOnlineEvaluator. */
    public UnaryCallSettings.Builder<CreateOnlineEvaluatorRequest, Operation>
        createOnlineEvaluatorSettings() {
      return getStubSettingsBuilder().createOnlineEvaluatorSettings();
    }

    /** Returns the builder for the settings used for calls to createOnlineEvaluator. */
    public OperationCallSettings.Builder<
            CreateOnlineEvaluatorRequest, OnlineEvaluator, CreateOnlineEvaluatorOperationMetadata>
        createOnlineEvaluatorOperationSettings() {
      return getStubSettingsBuilder().createOnlineEvaluatorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getOnlineEvaluator. */
    public UnaryCallSettings.Builder<GetOnlineEvaluatorRequest, OnlineEvaluator>
        getOnlineEvaluatorSettings() {
      return getStubSettingsBuilder().getOnlineEvaluatorSettings();
    }

    /** Returns the builder for the settings used for calls to updateOnlineEvaluator. */
    public UnaryCallSettings.Builder<UpdateOnlineEvaluatorRequest, Operation>
        updateOnlineEvaluatorSettings() {
      return getStubSettingsBuilder().updateOnlineEvaluatorSettings();
    }

    /** Returns the builder for the settings used for calls to updateOnlineEvaluator. */
    public OperationCallSettings.Builder<
            UpdateOnlineEvaluatorRequest, OnlineEvaluator, UpdateOnlineEvaluatorOperationMetadata>
        updateOnlineEvaluatorOperationSettings() {
      return getStubSettingsBuilder().updateOnlineEvaluatorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOnlineEvaluator. */
    public UnaryCallSettings.Builder<DeleteOnlineEvaluatorRequest, Operation>
        deleteOnlineEvaluatorSettings() {
      return getStubSettingsBuilder().deleteOnlineEvaluatorSettings();
    }

    /** Returns the builder for the settings used for calls to deleteOnlineEvaluator. */
    public OperationCallSettings.Builder<
            DeleteOnlineEvaluatorRequest, Empty, DeleteOnlineEvaluatorOperationMetadata>
        deleteOnlineEvaluatorOperationSettings() {
      return getStubSettingsBuilder().deleteOnlineEvaluatorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listOnlineEvaluators. */
    public PagedCallSettings.Builder<
            ListOnlineEvaluatorsRequest,
            ListOnlineEvaluatorsResponse,
            ListOnlineEvaluatorsPagedResponse>
        listOnlineEvaluatorsSettings() {
      return getStubSettingsBuilder().listOnlineEvaluatorsSettings();
    }

    /** Returns the builder for the settings used for calls to activateOnlineEvaluator. */
    public UnaryCallSettings.Builder<ActivateOnlineEvaluatorRequest, Operation>
        activateOnlineEvaluatorSettings() {
      return getStubSettingsBuilder().activateOnlineEvaluatorSettings();
    }

    /** Returns the builder for the settings used for calls to activateOnlineEvaluator. */
    public OperationCallSettings.Builder<
            ActivateOnlineEvaluatorRequest,
            OnlineEvaluator,
            ActivateOnlineEvaluatorOperationMetadata>
        activateOnlineEvaluatorOperationSettings() {
      return getStubSettingsBuilder().activateOnlineEvaluatorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to suspendOnlineEvaluator. */
    public UnaryCallSettings.Builder<SuspendOnlineEvaluatorRequest, Operation>
        suspendOnlineEvaluatorSettings() {
      return getStubSettingsBuilder().suspendOnlineEvaluatorSettings();
    }

    /** Returns the builder for the settings used for calls to suspendOnlineEvaluator. */
    public OperationCallSettings.Builder<
            SuspendOnlineEvaluatorRequest, OnlineEvaluator, SuspendOnlineEvaluatorOperationMetadata>
        suspendOnlineEvaluatorOperationSettings() {
      return getStubSettingsBuilder().suspendOnlineEvaluatorOperationSettings();
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
    public OnlineEvaluatorServiceSettings build() throws IOException {
      return new OnlineEvaluatorServiceSettings(this);
    }
  }
}
