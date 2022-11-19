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

import static com.google.cloud.compute.v1.RegionNetworkFirewallPoliciesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.RegionNetworkFirewallPoliciesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RegionNetworkFirewallPoliciesClient}.
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
 * RegionNetworkFirewallPoliciesSettings.Builder regionNetworkFirewallPoliciesSettingsBuilder =
 *     RegionNetworkFirewallPoliciesSettings.newBuilder();
 * regionNetworkFirewallPoliciesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         regionNetworkFirewallPoliciesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RegionNetworkFirewallPoliciesSettings regionNetworkFirewallPoliciesSettings =
 *     regionNetworkFirewallPoliciesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RegionNetworkFirewallPoliciesSettings
    extends ClientSettings<RegionNetworkFirewallPoliciesSettings> {

  /** Returns the object with the settings used for calls to addAssociation. */
  public UnaryCallSettings<AddAssociationRegionNetworkFirewallPolicyRequest, Operation>
      addAssociationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).addAssociationSettings();
  }

  /** Returns the object with the settings used for calls to addAssociation. */
  public OperationCallSettings<
          AddAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .addAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public UnaryCallSettings<AddRuleRegionNetworkFirewallPolicyRequest, Operation> addRuleSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).addRuleSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public OperationCallSettings<AddRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      addRuleOperationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .addRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to cloneRules. */
  public UnaryCallSettings<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>
      cloneRulesSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).cloneRulesSettings();
  }

  /** Returns the object with the settings used for calls to cloneRules. */
  public OperationCallSettings<CloneRulesRegionNetworkFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .cloneRulesOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteRegionNetworkFirewallPolicyRequest, Operation> deleteSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteRegionNetworkFirewallPolicyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy> getSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getAssociation. */
  public UnaryCallSettings<
          GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).getAssociationSettings();
  }

  /** Returns the object with the settings used for calls to getEffectiveFirewalls. */
  public UnaryCallSettings<
          GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
          RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .getEffectiveFirewallsSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      getIamPolicySettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>
      getRuleSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).getRuleSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertRegionNetworkFirewallPolicyRequest, Operation> insertSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertRegionNetworkFirewallPolicyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<
          ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
      listSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchRegionNetworkFirewallPolicyRequest, Operation> patchSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchRegionNetworkFirewallPolicyRequest, Operation, Operation>
      patchOperationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public UnaryCallSettings<PatchRuleRegionNetworkFirewallPolicyRequest, Operation>
      patchRuleSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).patchRuleSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public OperationCallSettings<PatchRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .patchRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public UnaryCallSettings<RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>
      removeAssociationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .removeAssociationSettings();
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public OperationCallSettings<
          RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .removeAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public UnaryCallSettings<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>
      removeRuleSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).removeRuleSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public OperationCallSettings<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .removeRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
      setIamPolicySettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<
          TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((RegionNetworkFirewallPoliciesStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final RegionNetworkFirewallPoliciesSettings create(
      RegionNetworkFirewallPoliciesStubSettings stub) throws IOException {
    return new RegionNetworkFirewallPoliciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RegionNetworkFirewallPoliciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RegionNetworkFirewallPoliciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RegionNetworkFirewallPoliciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RegionNetworkFirewallPoliciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RegionNetworkFirewallPoliciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RegionNetworkFirewallPoliciesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RegionNetworkFirewallPoliciesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RegionNetworkFirewallPoliciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RegionNetworkFirewallPoliciesSettings. */
  public static class Builder
      extends ClientSettings.Builder<RegionNetworkFirewallPoliciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RegionNetworkFirewallPoliciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(RegionNetworkFirewallPoliciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RegionNetworkFirewallPoliciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RegionNetworkFirewallPoliciesStubSettings.newBuilder());
    }

    public RegionNetworkFirewallPoliciesStubSettings.Builder getStubSettingsBuilder() {
      return ((RegionNetworkFirewallPoliciesStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<AddAssociationRegionNetworkFirewallPolicyRequest, Operation>
        addAssociationSettings() {
      return getStubSettingsBuilder().addAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to addAssociation. */
    public OperationCallSettings.Builder<
            AddAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
        addAssociationOperationSettings() {
      return getStubSettingsBuilder().addAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public UnaryCallSettings.Builder<AddRuleRegionNetworkFirewallPolicyRequest, Operation>
        addRuleSettings() {
      return getStubSettingsBuilder().addRuleSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public OperationCallSettings.Builder<
            AddRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
        addRuleOperationSettings() {
      return getStubSettingsBuilder().addRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cloneRules. */
    public UnaryCallSettings.Builder<CloneRulesRegionNetworkFirewallPolicyRequest, Operation>
        cloneRulesSettings() {
      return getStubSettingsBuilder().cloneRulesSettings();
    }

    /** Returns the builder for the settings used for calls to cloneRules. */
    public OperationCallSettings.Builder<
            CloneRulesRegionNetworkFirewallPolicyRequest, Operation, Operation>
        cloneRulesOperationSettings() {
      return getStubSettingsBuilder().cloneRulesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteRegionNetworkFirewallPolicyRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<
            DeleteRegionNetworkFirewallPolicyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetRegionNetworkFirewallPolicyRequest, FirewallPolicy>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getAssociation. */
    public UnaryCallSettings.Builder<
            GetAssociationRegionNetworkFirewallPolicyRequest, FirewallPolicyAssociation>
        getAssociationSettings() {
      return getStubSettingsBuilder().getAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to getEffectiveFirewalls. */
    public UnaryCallSettings.Builder<
            GetEffectiveFirewallsRegionNetworkFirewallPolicyRequest,
            RegionNetworkFirewallPoliciesGetEffectiveFirewallsResponse>
        getEffectiveFirewallsSettings() {
      return getStubSettingsBuilder().getEffectiveFirewallsSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
        getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleRegionNetworkFirewallPolicyRequest, FirewallPolicyRule>
        getRuleSettings() {
      return getStubSettingsBuilder().getRuleSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertRegionNetworkFirewallPolicyRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<
            InsertRegionNetworkFirewallPolicyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListRegionNetworkFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchRegionNetworkFirewallPolicyRequest, Operation>
        patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<
            PatchRegionNetworkFirewallPolicyRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public UnaryCallSettings.Builder<PatchRuleRegionNetworkFirewallPolicyRequest, Operation>
        patchRuleSettings() {
      return getStubSettingsBuilder().patchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public OperationCallSettings.Builder<
            PatchRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
        patchRuleOperationSettings() {
      return getStubSettingsBuilder().patchRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public UnaryCallSettings.Builder<RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation>
        removeAssociationSettings() {
      return getStubSettingsBuilder().removeAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public OperationCallSettings.Builder<
            RemoveAssociationRegionNetworkFirewallPolicyRequest, Operation, Operation>
        removeAssociationOperationSettings() {
      return getStubSettingsBuilder().removeAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public UnaryCallSettings.Builder<RemoveRuleRegionNetworkFirewallPolicyRequest, Operation>
        removeRuleSettings() {
      return getStubSettingsBuilder().removeRuleSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public OperationCallSettings.Builder<
            RemoveRuleRegionNetworkFirewallPolicyRequest, Operation, Operation>
        removeRuleOperationSettings() {
      return getStubSettingsBuilder().removeRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRegionNetworkFirewallPolicyRequest, Policy>
        setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsRegionNetworkFirewallPolicyRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public RegionNetworkFirewallPoliciesSettings build() throws IOException {
      return new RegionNetworkFirewallPoliciesSettings(this);
    }
  }
}
