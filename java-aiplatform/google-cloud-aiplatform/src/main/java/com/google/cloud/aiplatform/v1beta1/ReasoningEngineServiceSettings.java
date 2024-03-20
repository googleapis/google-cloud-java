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

package com.google.cloud.aiplatform.v1beta1;

import static com.google.cloud.aiplatform.v1beta1.ReasoningEngineServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.ReasoningEngineServiceClient.ListReasoningEnginesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.ReasoningEngineServiceStubSettings;
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
 * Settings class to configure an instance of {@link ReasoningEngineServiceClient}.
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
 * <p>For example, to set the total timeout of getReasoningEngine to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReasoningEngineServiceSettings.Builder reasoningEngineServiceSettingsBuilder =
 *     ReasoningEngineServiceSettings.newBuilder();
 * reasoningEngineServiceSettingsBuilder
 *     .getReasoningEngineSettings()
 *     .setRetrySettings(
 *         reasoningEngineServiceSettingsBuilder
 *             .getReasoningEngineSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ReasoningEngineServiceSettings reasoningEngineServiceSettings =
 *     reasoningEngineServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ReasoningEngineServiceSettings extends ClientSettings<ReasoningEngineServiceSettings> {

  /** Returns the object with the settings used for calls to createReasoningEngine. */
  public UnaryCallSettings<CreateReasoningEngineRequest, Operation>
      createReasoningEngineSettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings()).createReasoningEngineSettings();
  }

  /** Returns the object with the settings used for calls to createReasoningEngine. */
  public OperationCallSettings<
          CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineOperationSettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings())
        .createReasoningEngineOperationSettings();
  }

  /** Returns the object with the settings used for calls to getReasoningEngine. */
  public UnaryCallSettings<GetReasoningEngineRequest, ReasoningEngine>
      getReasoningEngineSettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings()).getReasoningEngineSettings();
  }

  /** Returns the object with the settings used for calls to listReasoningEngines. */
  public PagedCallSettings<
          ListReasoningEnginesRequest,
          ListReasoningEnginesResponse,
          ListReasoningEnginesPagedResponse>
      listReasoningEnginesSettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings()).listReasoningEnginesSettings();
  }

  /** Returns the object with the settings used for calls to deleteReasoningEngine. */
  public UnaryCallSettings<DeleteReasoningEngineRequest, Operation>
      deleteReasoningEngineSettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings()).deleteReasoningEngineSettings();
  }

  /** Returns the object with the settings used for calls to deleteReasoningEngine. */
  public OperationCallSettings<DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
      deleteReasoningEngineOperationSettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings())
        .deleteReasoningEngineOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ReasoningEngineServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final ReasoningEngineServiceSettings create(ReasoningEngineServiceStubSettings stub)
      throws IOException {
    return new ReasoningEngineServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ReasoningEngineServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ReasoningEngineServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ReasoningEngineServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ReasoningEngineServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ReasoningEngineServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ReasoningEngineServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ReasoningEngineServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ReasoningEngineServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ReasoningEngineServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ReasoningEngineServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ReasoningEngineServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ReasoningEngineServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ReasoningEngineServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ReasoningEngineServiceStubSettings.newBuilder());
    }

    public ReasoningEngineServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ReasoningEngineServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createReasoningEngine. */
    public UnaryCallSettings.Builder<CreateReasoningEngineRequest, Operation>
        createReasoningEngineSettings() {
      return getStubSettingsBuilder().createReasoningEngineSettings();
    }

    /** Returns the builder for the settings used for calls to createReasoningEngine. */
    public OperationCallSettings.Builder<
            CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
        createReasoningEngineOperationSettings() {
      return getStubSettingsBuilder().createReasoningEngineOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getReasoningEngine. */
    public UnaryCallSettings.Builder<GetReasoningEngineRequest, ReasoningEngine>
        getReasoningEngineSettings() {
      return getStubSettingsBuilder().getReasoningEngineSettings();
    }

    /** Returns the builder for the settings used for calls to listReasoningEngines. */
    public PagedCallSettings.Builder<
            ListReasoningEnginesRequest,
            ListReasoningEnginesResponse,
            ListReasoningEnginesPagedResponse>
        listReasoningEnginesSettings() {
      return getStubSettingsBuilder().listReasoningEnginesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReasoningEngine. */
    public UnaryCallSettings.Builder<DeleteReasoningEngineRequest, Operation>
        deleteReasoningEngineSettings() {
      return getStubSettingsBuilder().deleteReasoningEngineSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReasoningEngine. */
    public OperationCallSettings.Builder<
            DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
        deleteReasoningEngineOperationSettings() {
      return getStubSettingsBuilder().deleteReasoningEngineOperationSettings();
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
    public ReasoningEngineServiceSettings build() throws IOException {
      return new ReasoningEngineServiceSettings(this);
    }
  }
}
