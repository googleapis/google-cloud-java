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

import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.MemoryBankServiceClient.ListMemoriesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.MemoryBankServiceStubSettings;
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
 * Settings class to configure an instance of {@link MemoryBankServiceClient}.
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
 * of getMemory:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MemoryBankServiceSettings.Builder memoryBankServiceSettingsBuilder =
 *     MemoryBankServiceSettings.newBuilder();
 * memoryBankServiceSettingsBuilder
 *     .getMemorySettings()
 *     .setRetrySettings(
 *         memoryBankServiceSettingsBuilder
 *             .getMemorySettings()
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
 * MemoryBankServiceSettings memoryBankServiceSettings = memoryBankServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createMemory:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MemoryBankServiceSettings.Builder memoryBankServiceSettingsBuilder =
 *     MemoryBankServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * memoryBankServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MemoryBankServiceSettings extends ClientSettings<MemoryBankServiceSettings> {

  /** Returns the object with the settings used for calls to createMemory. */
  public UnaryCallSettings<CreateMemoryRequest, Operation> createMemorySettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).createMemorySettings();
  }

  /** Returns the object with the settings used for calls to createMemory. */
  public OperationCallSettings<CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
      createMemoryOperationSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).createMemoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to getMemory. */
  public UnaryCallSettings<GetMemoryRequest, Memory> getMemorySettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).getMemorySettings();
  }

  /** Returns the object with the settings used for calls to updateMemory. */
  public UnaryCallSettings<UpdateMemoryRequest, Operation> updateMemorySettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).updateMemorySettings();
  }

  /** Returns the object with the settings used for calls to updateMemory. */
  public OperationCallSettings<UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
      updateMemoryOperationSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).updateMemoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to listMemories. */
  public PagedCallSettings<ListMemoriesRequest, ListMemoriesResponse, ListMemoriesPagedResponse>
      listMemoriesSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).listMemoriesSettings();
  }

  /** Returns the object with the settings used for calls to deleteMemory. */
  public UnaryCallSettings<DeleteMemoryRequest, Operation> deleteMemorySettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).deleteMemorySettings();
  }

  /** Returns the object with the settings used for calls to deleteMemory. */
  public OperationCallSettings<DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
      deleteMemoryOperationSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).deleteMemoryOperationSettings();
  }

  /** Returns the object with the settings used for calls to generateMemories. */
  public UnaryCallSettings<GenerateMemoriesRequest, Operation> generateMemoriesSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).generateMemoriesSettings();
  }

  /** Returns the object with the settings used for calls to generateMemories. */
  public OperationCallSettings<
          GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesOperationSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).generateMemoriesOperationSettings();
  }

  /** Returns the object with the settings used for calls to retrieveMemories. */
  public UnaryCallSettings<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
      retrieveMemoriesSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).retrieveMemoriesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((MemoryBankServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final MemoryBankServiceSettings create(MemoryBankServiceStubSettings stub)
      throws IOException {
    return new MemoryBankServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return MemoryBankServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return MemoryBankServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return MemoryBankServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return MemoryBankServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return MemoryBankServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return MemoryBankServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MemoryBankServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected MemoryBankServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for MemoryBankServiceSettings. */
  public static class Builder extends ClientSettings.Builder<MemoryBankServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(MemoryBankServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(MemoryBankServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(MemoryBankServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(MemoryBankServiceStubSettings.newBuilder());
    }

    public MemoryBankServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((MemoryBankServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createMemory. */
    public UnaryCallSettings.Builder<CreateMemoryRequest, Operation> createMemorySettings() {
      return getStubSettingsBuilder().createMemorySettings();
    }

    /** Returns the builder for the settings used for calls to createMemory. */
    public OperationCallSettings.Builder<CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
        createMemoryOperationSettings() {
      return getStubSettingsBuilder().createMemoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getMemory. */
    public UnaryCallSettings.Builder<GetMemoryRequest, Memory> getMemorySettings() {
      return getStubSettingsBuilder().getMemorySettings();
    }

    /** Returns the builder for the settings used for calls to updateMemory. */
    public UnaryCallSettings.Builder<UpdateMemoryRequest, Operation> updateMemorySettings() {
      return getStubSettingsBuilder().updateMemorySettings();
    }

    /** Returns the builder for the settings used for calls to updateMemory. */
    public OperationCallSettings.Builder<UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
        updateMemoryOperationSettings() {
      return getStubSettingsBuilder().updateMemoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listMemories. */
    public PagedCallSettings.Builder<
            ListMemoriesRequest, ListMemoriesResponse, ListMemoriesPagedResponse>
        listMemoriesSettings() {
      return getStubSettingsBuilder().listMemoriesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMemory. */
    public UnaryCallSettings.Builder<DeleteMemoryRequest, Operation> deleteMemorySettings() {
      return getStubSettingsBuilder().deleteMemorySettings();
    }

    /** Returns the builder for the settings used for calls to deleteMemory. */
    public OperationCallSettings.Builder<DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
        deleteMemoryOperationSettings() {
      return getStubSettingsBuilder().deleteMemoryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to generateMemories. */
    public UnaryCallSettings.Builder<GenerateMemoriesRequest, Operation>
        generateMemoriesSettings() {
      return getStubSettingsBuilder().generateMemoriesSettings();
    }

    /** Returns the builder for the settings used for calls to generateMemories. */
    public OperationCallSettings.Builder<
            GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
        generateMemoriesOperationSettings() {
      return getStubSettingsBuilder().generateMemoriesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to retrieveMemories. */
    public UnaryCallSettings.Builder<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
        retrieveMemoriesSettings() {
      return getStubSettingsBuilder().retrieveMemoriesSettings();
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
    public MemoryBankServiceSettings build() throws IOException {
      return new MemoryBankServiceSettings(this);
    }
  }
}
