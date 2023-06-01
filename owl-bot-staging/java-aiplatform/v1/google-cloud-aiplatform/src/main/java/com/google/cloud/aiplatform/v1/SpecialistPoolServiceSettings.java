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

package com.google.cloud.aiplatform.v1;

import static com.google.cloud.aiplatform.v1.SpecialistPoolServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1.SpecialistPoolServiceClient.ListSpecialistPoolsPagedResponse;

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
import com.google.cloud.aiplatform.v1.stub.SpecialistPoolServiceStubSettings;
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
 * Settings class to configure an instance of {@link SpecialistPoolServiceClient}.
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
 * <p>For example, to set the total timeout of getSpecialistPool to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SpecialistPoolServiceSettings.Builder specialistPoolServiceSettingsBuilder =
 *     SpecialistPoolServiceSettings.newBuilder();
 * specialistPoolServiceSettingsBuilder
 *     .getSpecialistPoolSettings()
 *     .setRetrySettings(
 *         specialistPoolServiceSettingsBuilder
 *             .getSpecialistPoolSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SpecialistPoolServiceSettings specialistPoolServiceSettings =
 *     specialistPoolServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SpecialistPoolServiceSettings extends ClientSettings<SpecialistPoolServiceSettings> {

  /** Returns the object with the settings used for calls to createSpecialistPool. */
  public UnaryCallSettings<CreateSpecialistPoolRequest, Operation> createSpecialistPoolSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).createSpecialistPoolSettings();
  }

  /** Returns the object with the settings used for calls to createSpecialistPool. */
  public OperationCallSettings<
          CreateSpecialistPoolRequest, SpecialistPool, CreateSpecialistPoolOperationMetadata>
      createSpecialistPoolOperationSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings())
        .createSpecialistPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getSpecialistPool. */
  public UnaryCallSettings<GetSpecialistPoolRequest, SpecialistPool> getSpecialistPoolSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).getSpecialistPoolSettings();
  }

  /** Returns the object with the settings used for calls to listSpecialistPools. */
  public PagedCallSettings<
          ListSpecialistPoolsRequest, ListSpecialistPoolsResponse, ListSpecialistPoolsPagedResponse>
      listSpecialistPoolsSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).listSpecialistPoolsSettings();
  }

  /** Returns the object with the settings used for calls to deleteSpecialistPool. */
  public UnaryCallSettings<DeleteSpecialistPoolRequest, Operation> deleteSpecialistPoolSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).deleteSpecialistPoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteSpecialistPool. */
  public OperationCallSettings<DeleteSpecialistPoolRequest, Empty, DeleteOperationMetadata>
      deleteSpecialistPoolOperationSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings())
        .deleteSpecialistPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSpecialistPool. */
  public UnaryCallSettings<UpdateSpecialistPoolRequest, Operation> updateSpecialistPoolSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).updateSpecialistPoolSettings();
  }

  /** Returns the object with the settings used for calls to updateSpecialistPool. */
  public OperationCallSettings<
          UpdateSpecialistPoolRequest, SpecialistPool, UpdateSpecialistPoolOperationMetadata>
      updateSpecialistPoolOperationSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings())
        .updateSpecialistPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((SpecialistPoolServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final SpecialistPoolServiceSettings create(SpecialistPoolServiceStubSettings stub)
      throws IOException {
    return new SpecialistPoolServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SpecialistPoolServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SpecialistPoolServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SpecialistPoolServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SpecialistPoolServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SpecialistPoolServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SpecialistPoolServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SpecialistPoolServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SpecialistPoolServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SpecialistPoolServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<SpecialistPoolServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SpecialistPoolServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(SpecialistPoolServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SpecialistPoolServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SpecialistPoolServiceStubSettings.newBuilder());
    }

    public SpecialistPoolServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((SpecialistPoolServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSpecialistPool. */
    public UnaryCallSettings.Builder<CreateSpecialistPoolRequest, Operation>
        createSpecialistPoolSettings() {
      return getStubSettingsBuilder().createSpecialistPoolSettings();
    }

    /** Returns the builder for the settings used for calls to createSpecialistPool. */
    public OperationCallSettings.Builder<
            CreateSpecialistPoolRequest, SpecialistPool, CreateSpecialistPoolOperationMetadata>
        createSpecialistPoolOperationSettings() {
      return getStubSettingsBuilder().createSpecialistPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getSpecialistPool. */
    public UnaryCallSettings.Builder<GetSpecialistPoolRequest, SpecialistPool>
        getSpecialistPoolSettings() {
      return getStubSettingsBuilder().getSpecialistPoolSettings();
    }

    /** Returns the builder for the settings used for calls to listSpecialistPools. */
    public PagedCallSettings.Builder<
            ListSpecialistPoolsRequest,
            ListSpecialistPoolsResponse,
            ListSpecialistPoolsPagedResponse>
        listSpecialistPoolsSettings() {
      return getStubSettingsBuilder().listSpecialistPoolsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSpecialistPool. */
    public UnaryCallSettings.Builder<DeleteSpecialistPoolRequest, Operation>
        deleteSpecialistPoolSettings() {
      return getStubSettingsBuilder().deleteSpecialistPoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSpecialistPool. */
    public OperationCallSettings.Builder<
            DeleteSpecialistPoolRequest, Empty, DeleteOperationMetadata>
        deleteSpecialistPoolOperationSettings() {
      return getStubSettingsBuilder().deleteSpecialistPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateSpecialistPool. */
    public UnaryCallSettings.Builder<UpdateSpecialistPoolRequest, Operation>
        updateSpecialistPoolSettings() {
      return getStubSettingsBuilder().updateSpecialistPoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateSpecialistPool. */
    public OperationCallSettings.Builder<
            UpdateSpecialistPoolRequest, SpecialistPool, UpdateSpecialistPoolOperationMetadata>
        updateSpecialistPoolOperationSettings() {
      return getStubSettingsBuilder().updateSpecialistPoolOperationSettings();
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
    public SpecialistPoolServiceSettings build() throws IOException {
      return new SpecialistPoolServiceSettings(this);
    }
  }
}
