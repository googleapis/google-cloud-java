/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dataproc.v1beta2;

import static com.google.cloud.dataproc.v1beta2.AutoscalingPolicyServiceClient.ListAutoscalingPoliciesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dataproc.v1beta2.stub.AutoscalingPolicyServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AutoscalingPolicyServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataproc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createAutoscalingPolicy to 30 seconds:
 *
 * <pre>{@code
 * AutoscalingPolicyServiceSettings.Builder autoscalingPolicyServiceSettingsBuilder =
 *     AutoscalingPolicyServiceSettings.newBuilder();
 * autoscalingPolicyServiceSettingsBuilder
 *     .createAutoscalingPolicySettings()
 *     .setRetrySettings(
 *         autoscalingPolicyServiceSettingsBuilder
 *             .createAutoscalingPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AutoscalingPolicyServiceSettings autoscalingPolicyServiceSettings =
 *     autoscalingPolicyServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AutoscalingPolicyServiceSettings
    extends ClientSettings<AutoscalingPolicyServiceSettings> {

  /** Returns the object with the settings used for calls to createAutoscalingPolicy. */
  public UnaryCallSettings<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicySettings() {
    return ((AutoscalingPolicyServiceStubSettings) getStubSettings())
        .createAutoscalingPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateAutoscalingPolicy. */
  public UnaryCallSettings<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicySettings() {
    return ((AutoscalingPolicyServiceStubSettings) getStubSettings())
        .updateAutoscalingPolicySettings();
  }

  /** Returns the object with the settings used for calls to getAutoscalingPolicy. */
  public UnaryCallSettings<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicySettings() {
    return ((AutoscalingPolicyServiceStubSettings) getStubSettings())
        .getAutoscalingPolicySettings();
  }

  /** Returns the object with the settings used for calls to listAutoscalingPolicies. */
  public PagedCallSettings<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesSettings() {
    return ((AutoscalingPolicyServiceStubSettings) getStubSettings())
        .listAutoscalingPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to deleteAutoscalingPolicy. */
  public UnaryCallSettings<DeleteAutoscalingPolicyRequest, Empty>
      deleteAutoscalingPolicySettings() {
    return ((AutoscalingPolicyServiceStubSettings) getStubSettings())
        .deleteAutoscalingPolicySettings();
  }

  public static final AutoscalingPolicyServiceSettings create(
      AutoscalingPolicyServiceStubSettings stub) throws IOException {
    return new AutoscalingPolicyServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AutoscalingPolicyServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AutoscalingPolicyServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AutoscalingPolicyServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AutoscalingPolicyServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AutoscalingPolicyServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AutoscalingPolicyServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AutoscalingPolicyServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AutoscalingPolicyServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AutoscalingPolicyServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<AutoscalingPolicyServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AutoscalingPolicyServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AutoscalingPolicyServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AutoscalingPolicyServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AutoscalingPolicyServiceStubSettings.newBuilder());
    }

    public AutoscalingPolicyServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AutoscalingPolicyServiceStubSettings.Builder) getStubSettings());
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
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

    /** Returns the builder for the settings used for calls to createAutoscalingPolicy. */
    public UnaryCallSettings.Builder<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
        createAutoscalingPolicySettings() {
      return getStubSettingsBuilder().createAutoscalingPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateAutoscalingPolicy. */
    public UnaryCallSettings.Builder<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
        updateAutoscalingPolicySettings() {
      return getStubSettingsBuilder().updateAutoscalingPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getAutoscalingPolicy. */
    public UnaryCallSettings.Builder<GetAutoscalingPolicyRequest, AutoscalingPolicy>
        getAutoscalingPolicySettings() {
      return getStubSettingsBuilder().getAutoscalingPolicySettings();
    }

    /** Returns the builder for the settings used for calls to listAutoscalingPolicies. */
    public PagedCallSettings.Builder<
            ListAutoscalingPoliciesRequest,
            ListAutoscalingPoliciesResponse,
            ListAutoscalingPoliciesPagedResponse>
        listAutoscalingPoliciesSettings() {
      return getStubSettingsBuilder().listAutoscalingPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAutoscalingPolicy. */
    public UnaryCallSettings.Builder<DeleteAutoscalingPolicyRequest, Empty>
        deleteAutoscalingPolicySettings() {
      return getStubSettingsBuilder().deleteAutoscalingPolicySettings();
    }

    @Override
    public AutoscalingPolicyServiceSettings build() throws IOException {
      return new AutoscalingPolicyServiceSettings(this);
    }
  }
}
