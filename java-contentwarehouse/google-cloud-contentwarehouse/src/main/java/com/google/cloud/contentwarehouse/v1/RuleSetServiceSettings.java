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

package com.google.cloud.contentwarehouse.v1;

import static com.google.cloud.contentwarehouse.v1.RuleSetServiceClient.ListRuleSetsPagedResponse;

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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.contentwarehouse.v1.stub.RuleSetServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RuleSetServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (contentwarehouse.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createRuleSet to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RuleSetServiceSettings.Builder ruleSetServiceSettingsBuilder =
 *     RuleSetServiceSettings.newBuilder();
 * ruleSetServiceSettingsBuilder
 *     .createRuleSetSettings()
 *     .setRetrySettings(
 *         ruleSetServiceSettingsBuilder.createRuleSetSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RuleSetServiceSettings ruleSetServiceSettings = ruleSetServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RuleSetServiceSettings extends ClientSettings<RuleSetServiceSettings> {

  /** Returns the object with the settings used for calls to createRuleSet. */
  public UnaryCallSettings<CreateRuleSetRequest, RuleSet> createRuleSetSettings() {
    return ((RuleSetServiceStubSettings) getStubSettings()).createRuleSetSettings();
  }

  /** Returns the object with the settings used for calls to getRuleSet. */
  public UnaryCallSettings<GetRuleSetRequest, RuleSet> getRuleSetSettings() {
    return ((RuleSetServiceStubSettings) getStubSettings()).getRuleSetSettings();
  }

  /** Returns the object with the settings used for calls to updateRuleSet. */
  public UnaryCallSettings<UpdateRuleSetRequest, RuleSet> updateRuleSetSettings() {
    return ((RuleSetServiceStubSettings) getStubSettings()).updateRuleSetSettings();
  }

  /** Returns the object with the settings used for calls to deleteRuleSet. */
  public UnaryCallSettings<DeleteRuleSetRequest, Empty> deleteRuleSetSettings() {
    return ((RuleSetServiceStubSettings) getStubSettings()).deleteRuleSetSettings();
  }

  /** Returns the object with the settings used for calls to listRuleSets. */
  public PagedCallSettings<ListRuleSetsRequest, ListRuleSetsResponse, ListRuleSetsPagedResponse>
      listRuleSetsSettings() {
    return ((RuleSetServiceStubSettings) getStubSettings()).listRuleSetsSettings();
  }

  public static final RuleSetServiceSettings create(RuleSetServiceStubSettings stub)
      throws IOException {
    return new RuleSetServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RuleSetServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RuleSetServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RuleSetServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RuleSetServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RuleSetServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RuleSetServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RuleSetServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RuleSetServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RuleSetServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RuleSetServiceSettings. */
  public static class Builder extends ClientSettings.Builder<RuleSetServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RuleSetServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(RuleSetServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RuleSetServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RuleSetServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(RuleSetServiceStubSettings.newHttpJsonBuilder());
    }

    public RuleSetServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((RuleSetServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createRuleSet. */
    public UnaryCallSettings.Builder<CreateRuleSetRequest, RuleSet> createRuleSetSettings() {
      return getStubSettingsBuilder().createRuleSetSettings();
    }

    /** Returns the builder for the settings used for calls to getRuleSet. */
    public UnaryCallSettings.Builder<GetRuleSetRequest, RuleSet> getRuleSetSettings() {
      return getStubSettingsBuilder().getRuleSetSettings();
    }

    /** Returns the builder for the settings used for calls to updateRuleSet. */
    public UnaryCallSettings.Builder<UpdateRuleSetRequest, RuleSet> updateRuleSetSettings() {
      return getStubSettingsBuilder().updateRuleSetSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRuleSet. */
    public UnaryCallSettings.Builder<DeleteRuleSetRequest, Empty> deleteRuleSetSettings() {
      return getStubSettingsBuilder().deleteRuleSetSettings();
    }

    /** Returns the builder for the settings used for calls to listRuleSets. */
    public PagedCallSettings.Builder<
            ListRuleSetsRequest, ListRuleSetsResponse, ListRuleSetsPagedResponse>
        listRuleSetsSettings() {
      return getStubSettingsBuilder().listRuleSetsSettings();
    }

    @Override
    public RuleSetServiceSettings build() throws IOException {
      return new RuleSetServiceSettings(this);
    }
  }
}
