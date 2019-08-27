/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.gaming.v1alpha;

import static com.google.cloud.gaming.v1alpha.AllocationPoliciesServiceClient.ListAllocationPoliciesPagedResponse;

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
import com.google.cloud.gaming.v1alpha.stub.AllocationPoliciesServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link AllocationPoliciesServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (gameservices.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getAllocationPolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * AllocationPoliciesServiceSettings.Builder allocationPoliciesServiceSettingsBuilder =
 *     AllocationPoliciesServiceSettings.newBuilder();
 * allocationPoliciesServiceSettingsBuilder.getAllocationPolicySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * AllocationPoliciesServiceSettings allocationPoliciesServiceSettings = allocationPoliciesServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AllocationPoliciesServiceSettings
    extends ClientSettings<AllocationPoliciesServiceSettings> {
  /** Returns the object with the settings used for calls to listAllocationPolicies. */
  public PagedCallSettings<
          ListAllocationPoliciesRequest,
          ListAllocationPoliciesResponse,
          ListAllocationPoliciesPagedResponse>
      listAllocationPoliciesSettings() {
    return ((AllocationPoliciesServiceStubSettings) getStubSettings())
        .listAllocationPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getAllocationPolicy. */
  public UnaryCallSettings<GetAllocationPolicyRequest, AllocationPolicy>
      getAllocationPolicySettings() {
    return ((AllocationPoliciesServiceStubSettings) getStubSettings())
        .getAllocationPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAllocationPolicy. */
  public UnaryCallSettings<CreateAllocationPolicyRequest, Operation>
      createAllocationPolicySettings() {
    return ((AllocationPoliciesServiceStubSettings) getStubSettings())
        .createAllocationPolicySettings();
  }

  /** Returns the object with the settings used for calls to createAllocationPolicy. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<CreateAllocationPolicyRequest, AllocationPolicy, Empty>
      createAllocationPolicyOperationSettings() {
    return ((AllocationPoliciesServiceStubSettings) getStubSettings())
        .createAllocationPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAllocationPolicy. */
  public UnaryCallSettings<DeleteAllocationPolicyRequest, Operation>
      deleteAllocationPolicySettings() {
    return ((AllocationPoliciesServiceStubSettings) getStubSettings())
        .deleteAllocationPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteAllocationPolicy. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<DeleteAllocationPolicyRequest, Empty, Empty>
      deleteAllocationPolicyOperationSettings() {
    return ((AllocationPoliciesServiceStubSettings) getStubSettings())
        .deleteAllocationPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAllocationPolicy. */
  public UnaryCallSettings<UpdateAllocationPolicyRequest, Operation>
      updateAllocationPolicySettings() {
    return ((AllocationPoliciesServiceStubSettings) getStubSettings())
        .updateAllocationPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateAllocationPolicy. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
      updateAllocationPolicyOperationSettings() {
    return ((AllocationPoliciesServiceStubSettings) getStubSettings())
        .updateAllocationPolicyOperationSettings();
  }

  public static final AllocationPoliciesServiceSettings create(
      AllocationPoliciesServiceStubSettings stub) throws IOException {
    return new AllocationPoliciesServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AllocationPoliciesServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AllocationPoliciesServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AllocationPoliciesServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AllocationPoliciesServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AllocationPoliciesServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AllocationPoliciesServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AllocationPoliciesServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AllocationPoliciesServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AllocationPoliciesServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<AllocationPoliciesServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(AllocationPoliciesServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(AllocationPoliciesServiceStubSettings.newBuilder());
    }

    protected Builder(AllocationPoliciesServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AllocationPoliciesServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public AllocationPoliciesServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AllocationPoliciesServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to listAllocationPolicies. */
    public PagedCallSettings.Builder<
            ListAllocationPoliciesRequest,
            ListAllocationPoliciesResponse,
            ListAllocationPoliciesPagedResponse>
        listAllocationPoliciesSettings() {
      return getStubSettingsBuilder().listAllocationPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getAllocationPolicy. */
    public UnaryCallSettings.Builder<GetAllocationPolicyRequest, AllocationPolicy>
        getAllocationPolicySettings() {
      return getStubSettingsBuilder().getAllocationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAllocationPolicy. */
    public UnaryCallSettings.Builder<CreateAllocationPolicyRequest, Operation>
        createAllocationPolicySettings() {
      return getStubSettingsBuilder().createAllocationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createAllocationPolicy. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateAllocationPolicyRequest, AllocationPolicy, Empty>
        createAllocationPolicyOperationSettings() {
      return getStubSettingsBuilder().createAllocationPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAllocationPolicy. */
    public UnaryCallSettings.Builder<DeleteAllocationPolicyRequest, Operation>
        deleteAllocationPolicySettings() {
      return getStubSettingsBuilder().deleteAllocationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteAllocationPolicy. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAllocationPolicyRequest, Empty, Empty>
        deleteAllocationPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteAllocationPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAllocationPolicy. */
    public UnaryCallSettings.Builder<UpdateAllocationPolicyRequest, Operation>
        updateAllocationPolicySettings() {
      return getStubSettingsBuilder().updateAllocationPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateAllocationPolicy. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateAllocationPolicyRequest, AllocationPolicy, Empty>
        updateAllocationPolicyOperationSettings() {
      return getStubSettingsBuilder().updateAllocationPolicyOperationSettings();
    }

    @Override
    public AllocationPoliciesServiceSettings build() throws IOException {
      return new AllocationPoliciesServiceSettings(this);
    }
  }
}
