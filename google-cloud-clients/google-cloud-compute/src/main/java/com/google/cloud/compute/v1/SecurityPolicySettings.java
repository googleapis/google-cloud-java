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
package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.SecurityPolicyClient.ListSecurityPoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.SecurityPolicyStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link SecurityPolicyClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (https://www.googleapis.com/compute/v1/projects/) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of addRuleSecurityPolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * SecurityPolicySettings.Builder securityPolicySettingsBuilder =
 *     SecurityPolicySettings.newBuilder();
 * securityPolicySettingsBuilder.addRuleSecurityPolicySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * SecurityPolicySettings securityPolicySettings = securityPolicySettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class SecurityPolicySettings extends ClientSettings<SecurityPolicySettings> {
  /** Returns the object with the settings used for calls to addRuleSecurityPolicy. */
  public UnaryCallSettings<AddRuleSecurityPolicyHttpRequest, Operation>
      addRuleSecurityPolicySettings() {
    return ((SecurityPolicyStubSettings) getStubSettings()).addRuleSecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteSecurityPolicy. */
  public UnaryCallSettings<DeleteSecurityPolicyHttpRequest, Operation>
      deleteSecurityPolicySettings() {
    return ((SecurityPolicyStubSettings) getStubSettings()).deleteSecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to getSecurityPolicy. */
  public UnaryCallSettings<GetSecurityPolicyHttpRequest, SecurityPolicy>
      getSecurityPolicySettings() {
    return ((SecurityPolicyStubSettings) getStubSettings()).getSecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to getRuleSecurityPolicy. */
  public UnaryCallSettings<GetRuleSecurityPolicyHttpRequest, SecurityPolicyRule>
      getRuleSecurityPolicySettings() {
    return ((SecurityPolicyStubSettings) getStubSettings()).getRuleSecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to insertSecurityPolicy. */
  public UnaryCallSettings<InsertSecurityPolicyHttpRequest, Operation>
      insertSecurityPolicySettings() {
    return ((SecurityPolicyStubSettings) getStubSettings()).insertSecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to listSecurityPolicies. */
  public PagedCallSettings<
          ListSecurityPoliciesHttpRequest, SecurityPolicyList, ListSecurityPoliciesPagedResponse>
      listSecurityPoliciesSettings() {
    return ((SecurityPolicyStubSettings) getStubSettings()).listSecurityPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to patchSecurityPolicy. */
  public UnaryCallSettings<PatchSecurityPolicyHttpRequest, Operation>
      patchSecurityPolicySettings() {
    return ((SecurityPolicyStubSettings) getStubSettings()).patchSecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to patchRuleSecurityPolicy. */
  public UnaryCallSettings<PatchRuleSecurityPolicyHttpRequest, Operation>
      patchRuleSecurityPolicySettings() {
    return ((SecurityPolicyStubSettings) getStubSettings()).patchRuleSecurityPolicySettings();
  }

  /** Returns the object with the settings used for calls to removeRuleSecurityPolicy. */
  public UnaryCallSettings<RemoveRuleSecurityPolicyHttpRequest, Operation>
      removeRuleSecurityPolicySettings() {
    return ((SecurityPolicyStubSettings) getStubSettings()).removeRuleSecurityPolicySettings();
  }

  public static final SecurityPolicySettings create(SecurityPolicyStubSettings stub)
      throws IOException {
    return new SecurityPolicySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SecurityPolicyStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SecurityPolicyStubSettings.getDefaultEndpoint();
  }
  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return SecurityPolicyStubSettings.getDefaultServicePort();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SecurityPolicyStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SecurityPolicyStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SecurityPolicyStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SecurityPolicyStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SecurityPolicyStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SecurityPolicySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SecurityPolicySettings. */
  public static class Builder extends ClientSettings.Builder<SecurityPolicySettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(SecurityPolicyStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(SecurityPolicyStubSettings.newBuilder());
    }

    protected Builder(SecurityPolicySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SecurityPolicyStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public SecurityPolicyStubSettings.Builder getStubSettingsBuilder() {
      return ((SecurityPolicyStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addRuleSecurityPolicy. */
    public UnaryCallSettings.Builder<AddRuleSecurityPolicyHttpRequest, Operation>
        addRuleSecurityPolicySettings() {
      return getStubSettingsBuilder().addRuleSecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteSecurityPolicy. */
    public UnaryCallSettings.Builder<DeleteSecurityPolicyHttpRequest, Operation>
        deleteSecurityPolicySettings() {
      return getStubSettingsBuilder().deleteSecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getSecurityPolicy. */
    public UnaryCallSettings.Builder<GetSecurityPolicyHttpRequest, SecurityPolicy>
        getSecurityPolicySettings() {
      return getStubSettingsBuilder().getSecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getRuleSecurityPolicy. */
    public UnaryCallSettings.Builder<GetRuleSecurityPolicyHttpRequest, SecurityPolicyRule>
        getRuleSecurityPolicySettings() {
      return getStubSettingsBuilder().getRuleSecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to insertSecurityPolicy. */
    public UnaryCallSettings.Builder<InsertSecurityPolicyHttpRequest, Operation>
        insertSecurityPolicySettings() {
      return getStubSettingsBuilder().insertSecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to listSecurityPolicies. */
    public PagedCallSettings.Builder<
            ListSecurityPoliciesHttpRequest, SecurityPolicyList, ListSecurityPoliciesPagedResponse>
        listSecurityPoliciesSettings() {
      return getStubSettingsBuilder().listSecurityPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to patchSecurityPolicy. */
    public UnaryCallSettings.Builder<PatchSecurityPolicyHttpRequest, Operation>
        patchSecurityPolicySettings() {
      return getStubSettingsBuilder().patchSecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to patchRuleSecurityPolicy. */
    public UnaryCallSettings.Builder<PatchRuleSecurityPolicyHttpRequest, Operation>
        patchRuleSecurityPolicySettings() {
      return getStubSettingsBuilder().patchRuleSecurityPolicySettings();
    }

    /** Returns the builder for the settings used for calls to removeRuleSecurityPolicy. */
    public UnaryCallSettings.Builder<RemoveRuleSecurityPolicyHttpRequest, Operation>
        removeRuleSecurityPolicySettings() {
      return getStubSettingsBuilder().removeRuleSecurityPolicySettings();
    }

    @Override
    public SecurityPolicySettings build() throws IOException {
      return new SecurityPolicySettings(this);
    }
  }
}
