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

package com.google.appengine.v1;

import static com.google.appengine.v1.FirewallClient.ListIngressRulesPagedResponse;

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
import com.google.appengine.v1.firewall.FirewallRule;
import com.google.appengine.v1.stub.FirewallStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FirewallClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (appengine.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of batchUpdateIngressRules to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FirewallSettings.Builder firewallSettingsBuilder = FirewallSettings.newBuilder();
 * firewallSettingsBuilder
 *     .batchUpdateIngressRulesSettings()
 *     .setRetrySettings(
 *         firewallSettingsBuilder.batchUpdateIngressRulesSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FirewallSettings firewallSettings = firewallSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class FirewallSettings extends ClientSettings<FirewallSettings> {

  /** Returns the object with the settings used for calls to listIngressRules. */
  public PagedCallSettings<
          ListIngressRulesRequest, ListIngressRulesResponse, ListIngressRulesPagedResponse>
      listIngressRulesSettings() {
    return ((FirewallStubSettings) getStubSettings()).listIngressRulesSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateIngressRules. */
  public UnaryCallSettings<BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
      batchUpdateIngressRulesSettings() {
    return ((FirewallStubSettings) getStubSettings()).batchUpdateIngressRulesSettings();
  }

  /** Returns the object with the settings used for calls to createIngressRule. */
  public UnaryCallSettings<CreateIngressRuleRequest, FirewallRule> createIngressRuleSettings() {
    return ((FirewallStubSettings) getStubSettings()).createIngressRuleSettings();
  }

  /** Returns the object with the settings used for calls to getIngressRule. */
  public UnaryCallSettings<GetIngressRuleRequest, FirewallRule> getIngressRuleSettings() {
    return ((FirewallStubSettings) getStubSettings()).getIngressRuleSettings();
  }

  /** Returns the object with the settings used for calls to updateIngressRule. */
  public UnaryCallSettings<UpdateIngressRuleRequest, FirewallRule> updateIngressRuleSettings() {
    return ((FirewallStubSettings) getStubSettings()).updateIngressRuleSettings();
  }

  /** Returns the object with the settings used for calls to deleteIngressRule. */
  public UnaryCallSettings<DeleteIngressRuleRequest, Empty> deleteIngressRuleSettings() {
    return ((FirewallStubSettings) getStubSettings()).deleteIngressRuleSettings();
  }

  public static final FirewallSettings create(FirewallStubSettings stub) throws IOException {
    return new FirewallSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return FirewallStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return FirewallStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return FirewallStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return FirewallStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return FirewallStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return FirewallStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return FirewallStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return FirewallStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected FirewallSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for FirewallSettings. */
  public static class Builder extends ClientSettings.Builder<FirewallSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(FirewallStubSettings.newBuilder(clientContext));
    }

    protected Builder(FirewallSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(FirewallStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(FirewallStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(FirewallStubSettings.newHttpJsonBuilder());
    }

    public FirewallStubSettings.Builder getStubSettingsBuilder() {
      return ((FirewallStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listIngressRules. */
    public PagedCallSettings.Builder<
            ListIngressRulesRequest, ListIngressRulesResponse, ListIngressRulesPagedResponse>
        listIngressRulesSettings() {
      return getStubSettingsBuilder().listIngressRulesSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateIngressRules. */
    public UnaryCallSettings.Builder<
            BatchUpdateIngressRulesRequest, BatchUpdateIngressRulesResponse>
        batchUpdateIngressRulesSettings() {
      return getStubSettingsBuilder().batchUpdateIngressRulesSettings();
    }

    /** Returns the builder for the settings used for calls to createIngressRule. */
    public UnaryCallSettings.Builder<CreateIngressRuleRequest, FirewallRule>
        createIngressRuleSettings() {
      return getStubSettingsBuilder().createIngressRuleSettings();
    }

    /** Returns the builder for the settings used for calls to getIngressRule. */
    public UnaryCallSettings.Builder<GetIngressRuleRequest, FirewallRule> getIngressRuleSettings() {
      return getStubSettingsBuilder().getIngressRuleSettings();
    }

    /** Returns the builder for the settings used for calls to updateIngressRule. */
    public UnaryCallSettings.Builder<UpdateIngressRuleRequest, FirewallRule>
        updateIngressRuleSettings() {
      return getStubSettingsBuilder().updateIngressRuleSettings();
    }

    /** Returns the builder for the settings used for calls to deleteIngressRule. */
    public UnaryCallSettings.Builder<DeleteIngressRuleRequest, Empty> deleteIngressRuleSettings() {
      return getStubSettingsBuilder().deleteIngressRuleSettings();
    }

    @Override
    public FirewallSettings build() throws IOException {
      return new FirewallSettings(this);
    }
  }
}
