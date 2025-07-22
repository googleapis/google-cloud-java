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

package com.google.cloud.networkconnectivity.v1;

import static com.google.cloud.networkconnectivity.v1.InternalRangeServiceClient.ListInternalRangesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.InternalRangeServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkconnectivity.v1.stub.InternalRangeServiceStubSettings;
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
 * Settings class to configure an instance of {@link InternalRangeServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkconnectivity.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getInternalRange:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InternalRangeServiceSettings.Builder internalRangeServiceSettingsBuilder =
 *     InternalRangeServiceSettings.newBuilder();
 * internalRangeServiceSettingsBuilder
 *     .getInternalRangeSettings()
 *     .setRetrySettings(
 *         internalRangeServiceSettingsBuilder
 *             .getInternalRangeSettings()
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
 * InternalRangeServiceSettings internalRangeServiceSettings =
 *     internalRangeServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInternalRange:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InternalRangeServiceSettings.Builder internalRangeServiceSettingsBuilder =
 *     InternalRangeServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * internalRangeServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InternalRangeServiceSettings extends ClientSettings<InternalRangeServiceSettings> {

  /** Returns the object with the settings used for calls to listInternalRanges. */
  public PagedCallSettings<
          ListInternalRangesRequest, ListInternalRangesResponse, ListInternalRangesPagedResponse>
      listInternalRangesSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).listInternalRangesSettings();
  }

  /** Returns the object with the settings used for calls to getInternalRange. */
  public UnaryCallSettings<GetInternalRangeRequest, InternalRange> getInternalRangeSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).getInternalRangeSettings();
  }

  /** Returns the object with the settings used for calls to createInternalRange. */
  public UnaryCallSettings<CreateInternalRangeRequest, Operation> createInternalRangeSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).createInternalRangeSettings();
  }

  /** Returns the object with the settings used for calls to createInternalRange. */
  public OperationCallSettings<CreateInternalRangeRequest, InternalRange, OperationMetadata>
      createInternalRangeOperationSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings())
        .createInternalRangeOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInternalRange. */
  public UnaryCallSettings<UpdateInternalRangeRequest, Operation> updateInternalRangeSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).updateInternalRangeSettings();
  }

  /** Returns the object with the settings used for calls to updateInternalRange. */
  public OperationCallSettings<UpdateInternalRangeRequest, InternalRange, OperationMetadata>
      updateInternalRangeOperationSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings())
        .updateInternalRangeOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInternalRange. */
  public UnaryCallSettings<DeleteInternalRangeRequest, Operation> deleteInternalRangeSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).deleteInternalRangeSettings();
  }

  /** Returns the object with the settings used for calls to deleteInternalRange. */
  public OperationCallSettings<DeleteInternalRangeRequest, Empty, OperationMetadata>
      deleteInternalRangeOperationSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings())
        .deleteInternalRangeOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((InternalRangeServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final InternalRangeServiceSettings create(InternalRangeServiceStubSettings stub)
      throws IOException {
    return new InternalRangeServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InternalRangeServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InternalRangeServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InternalRangeServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InternalRangeServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InternalRangeServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InternalRangeServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InternalRangeServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InternalRangeServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InternalRangeServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<InternalRangeServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(InternalRangeServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(InternalRangeServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InternalRangeServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(InternalRangeServiceStubSettings.newBuilder());
    }

    public InternalRangeServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((InternalRangeServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listInternalRanges. */
    public PagedCallSettings.Builder<
            ListInternalRangesRequest, ListInternalRangesResponse, ListInternalRangesPagedResponse>
        listInternalRangesSettings() {
      return getStubSettingsBuilder().listInternalRangesSettings();
    }

    /** Returns the builder for the settings used for calls to getInternalRange. */
    public UnaryCallSettings.Builder<GetInternalRangeRequest, InternalRange>
        getInternalRangeSettings() {
      return getStubSettingsBuilder().getInternalRangeSettings();
    }

    /** Returns the builder for the settings used for calls to createInternalRange. */
    public UnaryCallSettings.Builder<CreateInternalRangeRequest, Operation>
        createInternalRangeSettings() {
      return getStubSettingsBuilder().createInternalRangeSettings();
    }

    /** Returns the builder for the settings used for calls to createInternalRange. */
    public OperationCallSettings.Builder<
            CreateInternalRangeRequest, InternalRange, OperationMetadata>
        createInternalRangeOperationSettings() {
      return getStubSettingsBuilder().createInternalRangeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInternalRange. */
    public UnaryCallSettings.Builder<UpdateInternalRangeRequest, Operation>
        updateInternalRangeSettings() {
      return getStubSettingsBuilder().updateInternalRangeSettings();
    }

    /** Returns the builder for the settings used for calls to updateInternalRange. */
    public OperationCallSettings.Builder<
            UpdateInternalRangeRequest, InternalRange, OperationMetadata>
        updateInternalRangeOperationSettings() {
      return getStubSettingsBuilder().updateInternalRangeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInternalRange. */
    public UnaryCallSettings.Builder<DeleteInternalRangeRequest, Operation>
        deleteInternalRangeSettings() {
      return getStubSettingsBuilder().deleteInternalRangeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInternalRange. */
    public OperationCallSettings.Builder<DeleteInternalRangeRequest, Empty, OperationMetadata>
        deleteInternalRangeOperationSettings() {
      return getStubSettingsBuilder().deleteInternalRangeOperationSettings();
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
    public InternalRangeServiceSettings build() throws IOException {
      return new InternalRangeServiceSettings(this);
    }
  }
}
