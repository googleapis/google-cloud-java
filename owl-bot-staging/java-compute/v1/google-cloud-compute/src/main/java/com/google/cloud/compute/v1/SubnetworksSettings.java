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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.SubnetworksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListPagedResponse;
import static com.google.cloud.compute.v1.SubnetworksClient.ListUsablePagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.SubnetworksStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SubnetworksClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SubnetworksSettings.Builder subnetworksSettingsBuilder = SubnetworksSettings.newBuilder();
 * subnetworksSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         subnetworksSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * SubnetworksSettings subnetworksSettings = subnetworksSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class SubnetworksSettings extends ClientSettings<SubnetworksSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListSubnetworksRequest, SubnetworkAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteSubnetworkRequest, Operation> deleteSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteSubnetworkRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to expandIpCidrRange. */
  public UnaryCallSettings<ExpandIpCidrRangeSubnetworkRequest, Operation>
      expandIpCidrRangeSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).expandIpCidrRangeSettings();
  }

  /** Returns the object with the settings used for calls to expandIpCidrRange. */
  public OperationCallSettings<ExpandIpCidrRangeSubnetworkRequest, Operation, Operation>
      expandIpCidrRangeOperationSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).expandIpCidrRangeOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetSubnetworkRequest, Subnetwork> getSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicySubnetworkRequest, Policy> getIamPolicySettings() {
    return ((SubnetworksStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertSubnetworkRequest, Operation> insertSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertSubnetworkRequest, Operation, Operation>
      insertOperationSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListSubnetworksRequest, SubnetworkList, ListPagedResponse>
      listSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listUsable. */
  public PagedCallSettings<
          ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, ListUsablePagedResponse>
      listUsableSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).listUsableSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchSubnetworkRequest, Operation> patchSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchSubnetworkRequest, Operation, Operation>
      patchOperationSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicySubnetworkRequest, Policy> setIamPolicySettings() {
    return ((SubnetworksStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setPrivateIpGoogleAccess. */
  public UnaryCallSettings<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
      setPrivateIpGoogleAccessSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).setPrivateIpGoogleAccessSettings();
  }

  /** Returns the object with the settings used for calls to setPrivateIpGoogleAccess. */
  public OperationCallSettings<SetPrivateIpGoogleAccessSubnetworkRequest, Operation, Operation>
      setPrivateIpGoogleAccessOperationSettings() {
    return ((SubnetworksStubSettings) getStubSettings())
        .setPrivateIpGoogleAccessOperationSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((SubnetworksStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final SubnetworksSettings create(SubnetworksStubSettings stub) throws IOException {
    return new SubnetworksSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SubnetworksStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SubnetworksStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SubnetworksStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SubnetworksStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SubnetworksStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SubnetworksStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SubnetworksStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SubnetworksSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SubnetworksSettings. */
  public static class Builder extends ClientSettings.Builder<SubnetworksSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SubnetworksStubSettings.newBuilder(clientContext));
    }

    protected Builder(SubnetworksSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SubnetworksStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SubnetworksStubSettings.newBuilder());
    }

    public SubnetworksStubSettings.Builder getStubSettingsBuilder() {
      return ((SubnetworksStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListSubnetworksRequest, SubnetworkAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteSubnetworkRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteSubnetworkRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to expandIpCidrRange. */
    public UnaryCallSettings.Builder<ExpandIpCidrRangeSubnetworkRequest, Operation>
        expandIpCidrRangeSettings() {
      return getStubSettingsBuilder().expandIpCidrRangeSettings();
    }

    /** Returns the builder for the settings used for calls to expandIpCidrRange. */
    public OperationCallSettings.Builder<ExpandIpCidrRangeSubnetworkRequest, Operation, Operation>
        expandIpCidrRangeOperationSettings() {
      return getStubSettingsBuilder().expandIpCidrRangeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetSubnetworkRequest, Subnetwork> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicySubnetworkRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertSubnetworkRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertSubnetworkRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListSubnetworksRequest, SubnetworkList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listUsable. */
    public PagedCallSettings.Builder<
            ListUsableSubnetworksRequest, UsableSubnetworksAggregatedList, ListUsablePagedResponse>
        listUsableSettings() {
      return getStubSettingsBuilder().listUsableSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchSubnetworkRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchSubnetworkRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicySubnetworkRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setPrivateIpGoogleAccess. */
    public UnaryCallSettings.Builder<SetPrivateIpGoogleAccessSubnetworkRequest, Operation>
        setPrivateIpGoogleAccessSettings() {
      return getStubSettingsBuilder().setPrivateIpGoogleAccessSettings();
    }

    /** Returns the builder for the settings used for calls to setPrivateIpGoogleAccess. */
    public OperationCallSettings.Builder<
            SetPrivateIpGoogleAccessSubnetworkRequest, Operation, Operation>
        setPrivateIpGoogleAccessOperationSettings() {
      return getStubSettingsBuilder().setPrivateIpGoogleAccessOperationSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsSubnetworkRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public SubnetworksSettings build() throws IOException {
      return new SubnetworksSettings(this);
    }
  }
}
