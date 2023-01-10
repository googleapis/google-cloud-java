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

import static com.google.cloud.compute.v1.FirewallPoliciesClient.ListPagedResponse;

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
import com.google.cloud.compute.v1.stub.FirewallPoliciesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FirewallPoliciesClient}.
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
 * FirewallPoliciesSettings.Builder firewallPoliciesSettingsBuilder =
 *     FirewallPoliciesSettings.newBuilder();
 * firewallPoliciesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         firewallPoliciesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FirewallPoliciesSettings firewallPoliciesSettings = firewallPoliciesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FirewallPoliciesSettings extends ClientSettings<FirewallPoliciesSettings> {

  /** Returns the object with the settings used for calls to addAssociation. */
  public UnaryCallSettings<AddAssociationFirewallPolicyRequest, Operation>
      addAssociationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).addAssociationSettings();
  }

  /** Returns the object with the settings used for calls to addAssociation. */
  public OperationCallSettings<AddAssociationFirewallPolicyRequest, Operation, Operation>
      addAssociationOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).addAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public UnaryCallSettings<AddRuleFirewallPolicyRequest, Operation> addRuleSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).addRuleSettings();
  }

  /** Returns the object with the settings used for calls to addRule. */
  public OperationCallSettings<AddRuleFirewallPolicyRequest, Operation, Operation>
      addRuleOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).addRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to cloneRules. */
  public UnaryCallSettings<CloneRulesFirewallPolicyRequest, Operation> cloneRulesSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).cloneRulesSettings();
  }

  /** Returns the object with the settings used for calls to cloneRules. */
  public OperationCallSettings<CloneRulesFirewallPolicyRequest, Operation, Operation>
      cloneRulesOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).cloneRulesOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteFirewallPolicyRequest, Operation> deleteSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteFirewallPolicyRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetFirewallPolicyRequest, FirewallPolicy> getSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getAssociation. */
  public UnaryCallSettings<GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>
      getAssociationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).getAssociationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyFirewallPolicyRequest, Policy> getIamPolicySettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getRule. */
  public UnaryCallSettings<GetRuleFirewallPolicyRequest, FirewallPolicyRule> getRuleSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).getRuleSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertFirewallPolicyRequest, Operation> insertSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertFirewallPolicyRequest, Operation, Operation>
      insertOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
      listSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listAssociations. */
  public UnaryCallSettings<
          ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
      listAssociationsSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).listAssociationsSettings();
  }

  /** Returns the object with the settings used for calls to move. */
  public UnaryCallSettings<MoveFirewallPolicyRequest, Operation> moveSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).moveSettings();
  }

  /** Returns the object with the settings used for calls to move. */
  public OperationCallSettings<MoveFirewallPolicyRequest, Operation, Operation>
      moveOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).moveOperationSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchFirewallPolicyRequest, Operation> patchSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchFirewallPolicyRequest, Operation, Operation>
      patchOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).patchOperationSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public UnaryCallSettings<PatchRuleFirewallPolicyRequest, Operation> patchRuleSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).patchRuleSettings();
  }

  /** Returns the object with the settings used for calls to patchRule. */
  public OperationCallSettings<PatchRuleFirewallPolicyRequest, Operation, Operation>
      patchRuleOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).patchRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public UnaryCallSettings<RemoveAssociationFirewallPolicyRequest, Operation>
      removeAssociationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).removeAssociationSettings();
  }

  /** Returns the object with the settings used for calls to removeAssociation. */
  public OperationCallSettings<RemoveAssociationFirewallPolicyRequest, Operation, Operation>
      removeAssociationOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).removeAssociationOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public UnaryCallSettings<RemoveRuleFirewallPolicyRequest, Operation> removeRuleSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).removeRuleSettings();
  }

  /** Returns the object with the settings used for calls to removeRule. */
  public OperationCallSettings<RemoveRuleFirewallPolicyRequest, Operation, Operation>
      removeRuleOperationSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).removeRuleOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyFirewallPolicyRequest, Policy> setIamPolicySettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((FirewallPoliciesStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final FirewallPoliciesSettings create(FirewallPoliciesStubSettings stub)
      throws IOException {
    return new FirewallPoliciesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FirewallPoliciesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FirewallPoliciesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FirewallPoliciesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FirewallPoliciesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return FirewallPoliciesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FirewallPoliciesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirewallPoliciesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FirewallPoliciesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FirewallPoliciesSettings. */
  public static class Builder extends ClientSettings.Builder<FirewallPoliciesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FirewallPoliciesStubSettings.newBuilder(clientContext));
    }

    protected Builder(FirewallPoliciesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FirewallPoliciesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FirewallPoliciesStubSettings.newBuilder());
    }

    public FirewallPoliciesStubSettings.Builder getStubSettingsBuilder() {
      return ((FirewallPoliciesStubSettings.Builder) getStubSettings());
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
    public UnaryCallSettings.Builder<AddAssociationFirewallPolicyRequest, Operation>
        addAssociationSettings() {
      return getStubSettingsBuilder().addAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to addAssociation. */
    public OperationCallSettings.Builder<AddAssociationFirewallPolicyRequest, Operation, Operation>
        addAssociationOperationSettings() {
      return getStubSettingsBuilder().addAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public UnaryCallSettings.Builder<AddRuleFirewallPolicyRequest, Operation> addRuleSettings() {
      return getStubSettingsBuilder().addRuleSettings();
    }

    /** Returns the builder for the settings used for calls to addRule. */
    public OperationCallSettings.Builder<AddRuleFirewallPolicyRequest, Operation, Operation>
        addRuleOperationSettings() {
      return getStubSettingsBuilder().addRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cloneRules. */
    public UnaryCallSettings.Builder<CloneRulesFirewallPolicyRequest, Operation>
        cloneRulesSettings() {
      return getStubSettingsBuilder().cloneRulesSettings();
    }

    /** Returns the builder for the settings used for calls to cloneRules. */
    public OperationCallSettings.Builder<CloneRulesFirewallPolicyRequest, Operation, Operation>
        cloneRulesOperationSettings() {
      return getStubSettingsBuilder().cloneRulesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteFirewallPolicyRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteFirewallPolicyRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetFirewallPolicyRequest, FirewallPolicy> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getAssociation. */
    public UnaryCallSettings.Builder<GetAssociationFirewallPolicyRequest, FirewallPolicyAssociation>
        getAssociationSettings() {
      return getStubSettingsBuilder().getAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyFirewallPolicyRequest, Policy>
        getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getRule. */
    public UnaryCallSettings.Builder<GetRuleFirewallPolicyRequest, FirewallPolicyRule>
        getRuleSettings() {
      return getStubSettingsBuilder().getRuleSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertFirewallPolicyRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertFirewallPolicyRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<
            ListFirewallPoliciesRequest, FirewallPolicyList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listAssociations. */
    public UnaryCallSettings.Builder<
            ListAssociationsFirewallPolicyRequest, FirewallPoliciesListAssociationsResponse>
        listAssociationsSettings() {
      return getStubSettingsBuilder().listAssociationsSettings();
    }

    /** Returns the builder for the settings used for calls to move. */
    public UnaryCallSettings.Builder<MoveFirewallPolicyRequest, Operation> moveSettings() {
      return getStubSettingsBuilder().moveSettings();
    }

    /** Returns the builder for the settings used for calls to move. */
    public OperationCallSettings.Builder<MoveFirewallPolicyRequest, Operation, Operation>
        moveOperationSettings() {
      return getStubSettingsBuilder().moveOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchFirewallPolicyRequest, Operation> patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<PatchFirewallPolicyRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public UnaryCallSettings.Builder<PatchRuleFirewallPolicyRequest, Operation>
        patchRuleSettings() {
      return getStubSettingsBuilder().patchRuleSettings();
    }

    /** Returns the builder for the settings used for calls to patchRule. */
    public OperationCallSettings.Builder<PatchRuleFirewallPolicyRequest, Operation, Operation>
        patchRuleOperationSettings() {
      return getStubSettingsBuilder().patchRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public UnaryCallSettings.Builder<RemoveAssociationFirewallPolicyRequest, Operation>
        removeAssociationSettings() {
      return getStubSettingsBuilder().removeAssociationSettings();
    }

    /** Returns the builder for the settings used for calls to removeAssociation. */
    public OperationCallSettings.Builder<
            RemoveAssociationFirewallPolicyRequest, Operation, Operation>
        removeAssociationOperationSettings() {
      return getStubSettingsBuilder().removeAssociationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public UnaryCallSettings.Builder<RemoveRuleFirewallPolicyRequest, Operation>
        removeRuleSettings() {
      return getStubSettingsBuilder().removeRuleSettings();
    }

    /** Returns the builder for the settings used for calls to removeRule. */
    public OperationCallSettings.Builder<RemoveRuleFirewallPolicyRequest, Operation, Operation>
        removeRuleOperationSettings() {
      return getStubSettingsBuilder().removeRuleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyFirewallPolicyRequest, Policy>
        setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<
            TestIamPermissionsFirewallPolicyRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public FirewallPoliciesSettings build() throws IOException {
      return new FirewallPoliciesSettings(this);
    }
  }
}
