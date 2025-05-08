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

import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.FetchExamplesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.ListExampleStoresPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ExampleStoreServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.ExampleStoreServiceStubSettings;
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
 * Settings class to configure an instance of {@link ExampleStoreServiceClient}.
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
 * of getExampleStore:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ExampleStoreServiceSettings.Builder exampleStoreServiceSettingsBuilder =
 *     ExampleStoreServiceSettings.newBuilder();
 * exampleStoreServiceSettingsBuilder
 *     .getExampleStoreSettings()
 *     .setRetrySettings(
 *         exampleStoreServiceSettingsBuilder
 *             .getExampleStoreSettings()
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
 * ExampleStoreServiceSettings exampleStoreServiceSettings =
 *     exampleStoreServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createExampleStore:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ExampleStoreServiceSettings.Builder exampleStoreServiceSettingsBuilder =
 *     ExampleStoreServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * exampleStoreServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ExampleStoreServiceSettings extends ClientSettings<ExampleStoreServiceSettings> {

  /** Returns the object with the settings used for calls to createExampleStore. */
  public UnaryCallSettings<CreateExampleStoreRequest, Operation> createExampleStoreSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).createExampleStoreSettings();
  }

  /** Returns the object with the settings used for calls to createExampleStore. */
  public OperationCallSettings<
          CreateExampleStoreRequest, ExampleStore, CreateExampleStoreOperationMetadata>
      createExampleStoreOperationSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings())
        .createExampleStoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to getExampleStore. */
  public UnaryCallSettings<GetExampleStoreRequest, ExampleStore> getExampleStoreSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).getExampleStoreSettings();
  }

  /** Returns the object with the settings used for calls to updateExampleStore. */
  public UnaryCallSettings<UpdateExampleStoreRequest, Operation> updateExampleStoreSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).updateExampleStoreSettings();
  }

  /** Returns the object with the settings used for calls to updateExampleStore. */
  public OperationCallSettings<
          UpdateExampleStoreRequest, ExampleStore, UpdateExampleStoreOperationMetadata>
      updateExampleStoreOperationSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings())
        .updateExampleStoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteExampleStore. */
  public UnaryCallSettings<DeleteExampleStoreRequest, Operation> deleteExampleStoreSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).deleteExampleStoreSettings();
  }

  /** Returns the object with the settings used for calls to deleteExampleStore. */
  public OperationCallSettings<
          DeleteExampleStoreRequest, Empty, DeleteExampleStoreOperationMetadata>
      deleteExampleStoreOperationSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings())
        .deleteExampleStoreOperationSettings();
  }

  /** Returns the object with the settings used for calls to listExampleStores. */
  public PagedCallSettings<
          ListExampleStoresRequest, ListExampleStoresResponse, ListExampleStoresPagedResponse>
      listExampleStoresSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).listExampleStoresSettings();
  }

  /** Returns the object with the settings used for calls to upsertExamples. */
  public UnaryCallSettings<UpsertExamplesRequest, UpsertExamplesResponse> upsertExamplesSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).upsertExamplesSettings();
  }

  /** Returns the object with the settings used for calls to removeExamples. */
  public UnaryCallSettings<RemoveExamplesRequest, RemoveExamplesResponse> removeExamplesSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).removeExamplesSettings();
  }

  /** Returns the object with the settings used for calls to searchExamples. */
  public UnaryCallSettings<SearchExamplesRequest, SearchExamplesResponse> searchExamplesSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).searchExamplesSettings();
  }

  /** Returns the object with the settings used for calls to fetchExamples. */
  public PagedCallSettings<FetchExamplesRequest, FetchExamplesResponse, FetchExamplesPagedResponse>
      fetchExamplesSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).fetchExamplesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ExampleStoreServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ExampleStoreServiceSettings create(ExampleStoreServiceStubSettings stub)
      throws IOException {
    return new ExampleStoreServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ExampleStoreServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ExampleStoreServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ExampleStoreServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ExampleStoreServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ExampleStoreServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ExampleStoreServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ExampleStoreServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ExampleStoreServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ExampleStoreServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ExampleStoreServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ExampleStoreServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ExampleStoreServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ExampleStoreServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ExampleStoreServiceStubSettings.newBuilder());
    }

    public ExampleStoreServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ExampleStoreServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createExampleStore. */
    public UnaryCallSettings.Builder<CreateExampleStoreRequest, Operation>
        createExampleStoreSettings() {
      return getStubSettingsBuilder().createExampleStoreSettings();
    }

    /** Returns the builder for the settings used for calls to createExampleStore. */
    public OperationCallSettings.Builder<
            CreateExampleStoreRequest, ExampleStore, CreateExampleStoreOperationMetadata>
        createExampleStoreOperationSettings() {
      return getStubSettingsBuilder().createExampleStoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getExampleStore. */
    public UnaryCallSettings.Builder<GetExampleStoreRequest, ExampleStore>
        getExampleStoreSettings() {
      return getStubSettingsBuilder().getExampleStoreSettings();
    }

    /** Returns the builder for the settings used for calls to updateExampleStore. */
    public UnaryCallSettings.Builder<UpdateExampleStoreRequest, Operation>
        updateExampleStoreSettings() {
      return getStubSettingsBuilder().updateExampleStoreSettings();
    }

    /** Returns the builder for the settings used for calls to updateExampleStore. */
    public OperationCallSettings.Builder<
            UpdateExampleStoreRequest, ExampleStore, UpdateExampleStoreOperationMetadata>
        updateExampleStoreOperationSettings() {
      return getStubSettingsBuilder().updateExampleStoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExampleStore. */
    public UnaryCallSettings.Builder<DeleteExampleStoreRequest, Operation>
        deleteExampleStoreSettings() {
      return getStubSettingsBuilder().deleteExampleStoreSettings();
    }

    /** Returns the builder for the settings used for calls to deleteExampleStore. */
    public OperationCallSettings.Builder<
            DeleteExampleStoreRequest, Empty, DeleteExampleStoreOperationMetadata>
        deleteExampleStoreOperationSettings() {
      return getStubSettingsBuilder().deleteExampleStoreOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listExampleStores. */
    public PagedCallSettings.Builder<
            ListExampleStoresRequest, ListExampleStoresResponse, ListExampleStoresPagedResponse>
        listExampleStoresSettings() {
      return getStubSettingsBuilder().listExampleStoresSettings();
    }

    /** Returns the builder for the settings used for calls to upsertExamples. */
    public UnaryCallSettings.Builder<UpsertExamplesRequest, UpsertExamplesResponse>
        upsertExamplesSettings() {
      return getStubSettingsBuilder().upsertExamplesSettings();
    }

    /** Returns the builder for the settings used for calls to removeExamples. */
    public UnaryCallSettings.Builder<RemoveExamplesRequest, RemoveExamplesResponse>
        removeExamplesSettings() {
      return getStubSettingsBuilder().removeExamplesSettings();
    }

    /** Returns the builder for the settings used for calls to searchExamples. */
    public UnaryCallSettings.Builder<SearchExamplesRequest, SearchExamplesResponse>
        searchExamplesSettings() {
      return getStubSettingsBuilder().searchExamplesSettings();
    }

    /** Returns the builder for the settings used for calls to fetchExamples. */
    public PagedCallSettings.Builder<
            FetchExamplesRequest, FetchExamplesResponse, FetchExamplesPagedResponse>
        fetchExamplesSettings() {
      return getStubSettingsBuilder().fetchExamplesSettings();
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
    public ExampleStoreServiceSettings build() throws IOException {
      return new ExampleStoreServiceSettings(this);
    }
  }
}
