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

import static com.google.cloud.compute.v1.NetworkFirewallPoliciesClient.ListPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.NetworkFirewallPoliciesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetworkFirewallPoliciesClient}.
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
 * NetworkFirewallPoliciesSettings.Builder networkFirewallPoliciesSettingsBuilder =
 *     NetworkFirewallPoliciesSettings.newBuilder();
 * networkFirewallPoliciesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         networkFirewallPoliciesSettingsBuilder.getSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworkFirewallPoliciesSettings networkFirewallPoliciesSettings =
 *     networkFirewallPoliciesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetworkFirewallPoliciesSettings
    extends ClientSettings<NetworkFirewallPoliciesSettings> {

  /** Returns the object with the settings used for calls to addAssociation. */
  public UnaryCallSettings<AddAssociationNetworkFirewallPolicyRequest, Operation>
      addAssociationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).addAssociationSettings();
  }

  /** Returns the object with the settings used for calls to addAssociation. */
  public OperationCallSettings<AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings())
        .addAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public UnaryCallSettings<AddRuleNetworkFirewallPolicyRequest, Operation> addRuleSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).addRuleSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public OperationCallSettings<AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).addRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to cloneRules. */
  public UnaryCallSettings<CloneRulesNetworkFirewallPolicyRequest, Operation> cloneRulesSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).cloneRulesSettings();
  }

  /** Returns the object with the settings used for calls to cloneRules. */
  public OperationCallSettings<CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).cloneRulesOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteNetworkFirewallPolicyRequest, Operation> deleteSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetNetworkFirewallPolicyRequest, FirewallPolicy> getSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getAssociation. */
  public UnaryCallSettings<GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).getAssociationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
      getIamPolicySettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).getRuleSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertNetworkFirewallPolicyRequest, Operation> insertSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
      listSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchNetworkFirewallPolicyRequest, Operation> patchSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public UnaryCallSettings<PatchRuleNetworkFirewallPolicyRequest, Operation> patchRuleSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).patchRuleSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public OperationCallSettings<PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).patchRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public UnaryCallSettings<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
      removeAssociationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).removeAssociationSettings();
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public OperationCallSettings<RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings())
        .removeAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public UnaryCallSettings<RemoveRuleNetworkFirewallPolicyRequest, Operation> removeRuleSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).removeRuleSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public OperationCallSettings<RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).removeRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
      setIamPolicySettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((NetworkFirewallPoliciesStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final NetworkFirewallPoliciesSettings create(
      NetworkFirewallPoliciesStubSettings stub) throws IOException {
    return new NetworkFirewallPoliciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworkFirewallPoliciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworkFirewallPoliciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworkFirewallPoliciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworkFirewallPoliciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NetworkFirewallPoliciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworkFirewallPoliciesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkFirewallPoliciesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetworkFirewallPoliciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworkFirewallPoliciesSettings. */
  public static class Builder
      extends ClientSettings.Builder<NetworkFirewallPoliciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NetworkFirewallPoliciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(NetworkFirewallPoliciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworkFirewallPoliciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NetworkFirewallPoliciesStubSettings.newBuilder());
    }

    public NetworkFirewallPoliciesStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworkFirewallPoliciesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addAssociation. */
    public UnaryCallSettings.Builder<AddAssociationNetworkFirewallPolicyRequest, Operation>
        addAssociationSettings() {
      return getStubSettingsBuilder().addAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to addAssociation. */
    public OperationCallSettings.Builder<
            AddAssociationNetworkFirewallPolicyRequest, Operation, Operation>
        addAssociationOperationSettings() {
      return getStubSettingsBuilder().addAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public UnaryCallSettings.Builder<AddRuleNetworkFirewallPolicyRequest, Operation>
        addRuleSettings() {
      return getStubSettingsBuilder().addRuleSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public OperationCallSettings.Builder<AddRuleNetworkFirewallPolicyRequest, Operation, Operation>
        addRuleOperationSettings() {
      return getStubSettingsBuilder().addRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cloneRules. */
    public UnaryCallSettings.Builder<CloneRulesNetworkFirewallPolicyRequest, Operation>
        cloneRulesSettings() {
      return getStubSettingsBuilder().cloneRulesSettings();
    }

    /** Returns the builder for the settings used for calls to cloneRules. */
    public OperationCallSettings.Builder<
            CloneRulesNetworkFirewallPolicyRequest, Operation, Operation>
        cloneRulesOperationSettings() {
      return getStubSettingsBuilder().cloneRulesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteNetworkFirewallPolicyRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteNetworkFirewallPolicyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetNetworkFirewallPolicyRequest, FirewallPolicy>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getAssociation. */
    public UnaryCallSettings.Builder<
            GetAssociationNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
        getAssociationSettings() {
      return getStubSettingsBuilder().getAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyNetworkFirewallPolicyRequest, Policy>
        getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleNetworkFirewallPolicyRequest, FirewallPolicyRule>
        getRuleSettings() {
      return getStubSettingsBuilder().getRuleSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertNetworkFirewallPolicyRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertNetworkFirewallPolicyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchNetworkFirewallPolicyRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchNetworkFirewallPolicyRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public UnaryCallSettings.Builder<PatchRuleNetworkFirewallPolicyRequest, Operation>
        patchRuleSettings() {
      return getStubSettingsBuilder().patchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public OperationCallSettings.Builder<
            PatchRuleNetworkFirewallPolicyRequest, Operation, Operation>
        patchRuleOperationSettings() {
      return getStubSettingsBuilder().patchRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public UnaryCallSettings.Builder<RemoveAssociationNetworkFirewallPolicyRequest, Operation>
        removeAssociationSettings() {
      return getStubSettingsBuilder().removeAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public OperationCallSettings.Builder<
            RemoveAssociationNetworkFirewallPolicyRequest, Operation, Operation>
        removeAssociationOperationSettings() {
      return getStubSettingsBuilder().removeAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public UnaryCallSettings.Builder<RemoveRuleNetworkFirewallPolicyRequest, Operation>
        removeRuleSettings() {
      return getStubSettingsBuilder().removeRuleSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public OperationCallSettings.Builder<
            RemoveRuleNetworkFirewallPolicyRequest, Operation, Operation>
        removeRuleOperationSettings() {
      return getStubSettingsBuilder().removeRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyNetworkFirewallPolicyRequest, Policy>
        setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsNetworkFirewallPolicyRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public NetworkFirewallPoliciesSettings build() throws IOException {
      return new NetworkFirewallPoliciesSettings(this);
    }
  }
}
