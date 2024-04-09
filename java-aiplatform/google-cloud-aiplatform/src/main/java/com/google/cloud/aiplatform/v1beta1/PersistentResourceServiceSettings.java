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

import static com.google.cloud.aiplatform.v1beta1.PersistentResourceServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.PersistentResourceServiceClient.ListPersistentResourcesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.stub.PersistentResourceServiceStubSettings;
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
 * Settings class to configure an instance of {@link PersistentResourceServiceClient}.
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
 * <p>For example, to set the total timeout of getPersistentResource to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PersistentResourceServiceSettings.Builder persistentResourceServiceSettingsBuilder =
 *     PersistentResourceServiceSettings.newBuilder();
 * persistentResourceServiceSettingsBuilder
 *     .getPersistentResourceSettings()
 *     .setRetrySettings(
 *         persistentResourceServiceSettingsBuilder
 *             .getPersistentResourceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PersistentResourceServiceSettings persistentResourceServiceSettings =
 *     persistentResourceServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PersistentResourceServiceSettings
    extends ClientSettings<PersistentResourceServiceSettings> {

  /** Returns the object with the settings used for calls to createPersistentResource. */
  public UnaryCallSettings<CreatePersistentResourceRequest, Operation>
      createPersistentResourceSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .createPersistentResourceSettings();
  }

  /** Returns the object with the settings used for calls to createPersistentResource. */
  public OperationCallSettings<
          CreatePersistentResourceRequest,
          PersistentResource,
          CreatePersistentResourceOperationMetadata>
      createPersistentResourceOperationSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .createPersistentResourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to getPersistentResource. */
  public UnaryCallSettings<GetPersistentResourceRequest, PersistentResource>
      getPersistentResourceSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .getPersistentResourceSettings();
  }

  /** Returns the object with the settings used for calls to listPersistentResources. */
  public PagedCallSettings<
          ListPersistentResourcesRequest,
          ListPersistentResourcesResponse,
          ListPersistentResourcesPagedResponse>
      listPersistentResourcesSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .listPersistentResourcesSettings();
  }

  /** Returns the object with the settings used for calls to deletePersistentResource. */
  public UnaryCallSettings<DeletePersistentResourceRequest, Operation>
      deletePersistentResourceSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .deletePersistentResourceSettings();
  }

  /** Returns the object with the settings used for calls to deletePersistentResource. */
  public OperationCallSettings<DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
      deletePersistentResourceOperationSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .deletePersistentResourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updatePersistentResource. */
  public UnaryCallSettings<UpdatePersistentResourceRequest, Operation>
      updatePersistentResourceSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .updatePersistentResourceSettings();
  }

  /** Returns the object with the settings used for calls to updatePersistentResource. */
  public OperationCallSettings<
          UpdatePersistentResourceRequest,
          PersistentResource,
          UpdatePersistentResourceOperationMetadata>
      updatePersistentResourceOperationSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .updatePersistentResourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to rebootPersistentResource. */
  public UnaryCallSettings<RebootPersistentResourceRequest, Operation>
      rebootPersistentResourceSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .rebootPersistentResourceSettings();
  }

  /** Returns the object with the settings used for calls to rebootPersistentResource. */
  public OperationCallSettings<
          RebootPersistentResourceRequest,
          PersistentResource,
          RebootPersistentResourceOperationMetadata>
      rebootPersistentResourceOperationSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings())
        .rebootPersistentResourceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((PersistentResourceServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final PersistentResourceServiceSettings create(
      PersistentResourceServiceStubSettings stub) throws IOException {
    return new PersistentResourceServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PersistentResourceServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PersistentResourceServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PersistentResourceServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PersistentResourceServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PersistentResourceServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PersistentResourceServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PersistentResourceServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PersistentResourceServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PersistentResourceServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<PersistentResourceServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PersistentResourceServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(PersistentResourceServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PersistentResourceServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PersistentResourceServiceStubSettings.newBuilder());
    }

    public PersistentResourceServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((PersistentResourceServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createPersistentResource. */
    public UnaryCallSettings.Builder<CreatePersistentResourceRequest, Operation>
        createPersistentResourceSettings() {
      return getStubSettingsBuilder().createPersistentResourceSettings();
    }

    /** Returns the builder for the settings used for calls to createPersistentResource. */
    public OperationCallSettings.Builder<
            CreatePersistentResourceRequest,
            PersistentResource,
            CreatePersistentResourceOperationMetadata>
        createPersistentResourceOperationSettings() {
      return getStubSettingsBuilder().createPersistentResourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getPersistentResource. */
    public UnaryCallSettings.Builder<GetPersistentResourceRequest, PersistentResource>
        getPersistentResourceSettings() {
      return getStubSettingsBuilder().getPersistentResourceSettings();
    }

    /** Returns the builder for the settings used for calls to listPersistentResources. */
    public PagedCallSettings.Builder<
            ListPersistentResourcesRequest,
            ListPersistentResourcesResponse,
            ListPersistentResourcesPagedResponse>
        listPersistentResourcesSettings() {
      return getStubSettingsBuilder().listPersistentResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to deletePersistentResource. */
    public UnaryCallSettings.Builder<DeletePersistentResourceRequest, Operation>
        deletePersistentResourceSettings() {
      return getStubSettingsBuilder().deletePersistentResourceSettings();
    }

    /** Returns the builder for the settings used for calls to deletePersistentResource. */
    public OperationCallSettings.Builder<
            DeletePersistentResourceRequest, Empty, DeleteOperationMetadata>
        deletePersistentResourceOperationSettings() {
      return getStubSettingsBuilder().deletePersistentResourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updatePersistentResource. */
    public UnaryCallSettings.Builder<UpdatePersistentResourceRequest, Operation>
        updatePersistentResourceSettings() {
      return getStubSettingsBuilder().updatePersistentResourceSettings();
    }

    /** Returns the builder for the settings used for calls to updatePersistentResource. */
    public OperationCallSettings.Builder<
            UpdatePersistentResourceRequest,
            PersistentResource,
            UpdatePersistentResourceOperationMetadata>
        updatePersistentResourceOperationSettings() {
      return getStubSettingsBuilder().updatePersistentResourceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to rebootPersistentResource. */
    public UnaryCallSettings.Builder<RebootPersistentResourceRequest, Operation>
        rebootPersistentResourceSettings() {
      return getStubSettingsBuilder().rebootPersistentResourceSettings();
    }

    /** Returns the builder for the settings used for calls to rebootPersistentResource. */
    public OperationCallSettings.Builder<
            RebootPersistentResourceRequest,
            PersistentResource,
            RebootPersistentResourceOperationMetadata>
        rebootPersistentResourceOperationSettings() {
      return getStubSettingsBuilder().rebootPersistentResourceOperationSettings();
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
    public PersistentResourceServiceSettings build() throws IOException {
      return new PersistentResourceServiceSettings(this);
    }
  }
}
