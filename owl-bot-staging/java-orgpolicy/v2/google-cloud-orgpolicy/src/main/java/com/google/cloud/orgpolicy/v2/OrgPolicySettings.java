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

package com.google.cloud.orgpolicy.v2;

import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListConstraintsPagedResponse;
import static com.google.cloud.orgpolicy.v2.OrgPolicyClient.ListPoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.orgpolicy.v2.stub.OrgPolicyStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OrgPolicyClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (orgpolicy.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrgPolicySettings.Builder orgPolicySettingsBuilder = OrgPolicySettings.newBuilder();
 * orgPolicySettingsBuilder
 *     .getPolicySettings()
 *     .setRetrySettings(
 *         orgPolicySettingsBuilder
 *             .getPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OrgPolicySettings orgPolicySettings = orgPolicySettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OrgPolicySettings extends ClientSettings<OrgPolicySettings> {

  /** Returns the object with the settings used for calls to listConstraints. */
  public PagedCallSettings<
          ListConstraintsRequest, ListConstraintsResponse, ListConstraintsPagedResponse>
      listConstraintsSettings() {
    return ((OrgPolicyStubSettings) getStubSettings()).listConstraintsSettings();
  }

  /** Returns the object with the settings used for calls to listPolicies. */
  public PagedCallSettings<ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
      listPoliciesSettings() {
    return ((OrgPolicyStubSettings) getStubSettings()).listPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getPolicy. */
  public UnaryCallSettings<GetPolicyRequest, Policy> getPolicySettings() {
    return ((OrgPolicyStubSettings) getStubSettings()).getPolicySettings();
  }

  /** Returns the object with the settings used for calls to getEffectivePolicy. */
  public UnaryCallSettings<GetEffectivePolicyRequest, Policy> getEffectivePolicySettings() {
    return ((OrgPolicyStubSettings) getStubSettings()).getEffectivePolicySettings();
  }

  /** Returns the object with the settings used for calls to createPolicy. */
  public UnaryCallSettings<CreatePolicyRequest, Policy> createPolicySettings() {
    return ((OrgPolicyStubSettings) getStubSettings()).createPolicySettings();
  }

  /** Returns the object with the settings used for calls to updatePolicy. */
  public UnaryCallSettings<UpdatePolicyRequest, Policy> updatePolicySettings() {
    return ((OrgPolicyStubSettings) getStubSettings()).updatePolicySettings();
  }

  /** Returns the object with the settings used for calls to deletePolicy. */
  public UnaryCallSettings<DeletePolicyRequest, Empty> deletePolicySettings() {
    return ((OrgPolicyStubSettings) getStubSettings()).deletePolicySettings();
  }

  public static final OrgPolicySettings create(OrgPolicyStubSettings stub) throws IOException {
    return new OrgPolicySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OrgPolicyStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OrgPolicyStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OrgPolicyStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OrgPolicyStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return OrgPolicyStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return OrgPolicyStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OrgPolicyStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OrgPolicyStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected OrgPolicySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OrgPolicySettings. */
  public static class Builder extends ClientSettings.Builder<OrgPolicySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OrgPolicyStubSettings.newBuilder(clientContext));
    }

    protected Builder(OrgPolicySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OrgPolicyStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OrgPolicyStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(OrgPolicyStubSettings.newHttpJsonBuilder());
    }

    public OrgPolicyStubSettings.Builder getStubSettingsBuilder() {
      return ((OrgPolicyStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listConstraints. */
    public PagedCallSettings.Builder<
            ListConstraintsRequest, ListConstraintsResponse, ListConstraintsPagedResponse>
        listConstraintsSettings() {
      return getStubSettingsBuilder().listConstraintsSettings();
    }

    /** Returns the builder for the settings used for calls to listPolicies. */
    public PagedCallSettings.Builder<
            ListPoliciesRequest, ListPoliciesResponse, ListPoliciesPagedResponse>
        listPoliciesSettings() {
      return getStubSettingsBuilder().listPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getPolicy. */
    public UnaryCallSettings.Builder<GetPolicyRequest, Policy> getPolicySettings() {
      return getStubSettingsBuilder().getPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getEffectivePolicy. */
    public UnaryCallSettings.Builder<GetEffectivePolicyRequest, Policy>
        getEffectivePolicySettings() {
      return getStubSettingsBuilder().getEffectivePolicySettings();
    }

    /** Returns the builder for the settings used for calls to createPolicy. */
    public UnaryCallSettings.Builder<CreatePolicyRequest, Policy> createPolicySettings() {
      return getStubSettingsBuilder().createPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updatePolicy. */
    public UnaryCallSettings.Builder<UpdatePolicyRequest, Policy> updatePolicySettings() {
      return getStubSettingsBuilder().updatePolicySettings();
    }

    /** Returns the builder for the settings used for calls to deletePolicy. */
    public UnaryCallSettings.Builder<DeletePolicyRequest, Empty> deletePolicySettings() {
      return getStubSettingsBuilder().deletePolicySettings();
    }

    @Override
    public OrgPolicySettings build() throws IOException {
      return new OrgPolicySettings(this);
    }
  }
}
