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

import static com.google.cloud.gaming.v1alpha.ScalingPoliciesServiceClient.ListScalingPoliciesPagedResponse;

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
import com.google.cloud.gaming.v1alpha.stub.ScalingPoliciesServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ScalingPoliciesServiceClient}.
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
 * <p>For example, to set the total timeout of getScalingPolicy to 30 seconds:
 *
 * <pre>
 * <code>
 * ScalingPoliciesServiceSettings.Builder scalingPoliciesServiceSettingsBuilder =
 *     ScalingPoliciesServiceSettings.newBuilder();
 * scalingPoliciesServiceSettingsBuilder.getScalingPolicySettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ScalingPoliciesServiceSettings scalingPoliciesServiceSettings = scalingPoliciesServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ScalingPoliciesServiceSettings extends ClientSettings<ScalingPoliciesServiceSettings> {
  /** Returns the object with the settings used for calls to listScalingPolicies. */
  public PagedCallSettings<
          ListScalingPoliciesRequest, ListScalingPoliciesResponse, ListScalingPoliciesPagedResponse>
      listScalingPoliciesSettings() {
    return ((ScalingPoliciesServiceStubSettings) getStubSettings()).listScalingPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getScalingPolicy. */
  public UnaryCallSettings<GetScalingPolicyRequest, ScalingPolicy> getScalingPolicySettings() {
    return ((ScalingPoliciesServiceStubSettings) getStubSettings()).getScalingPolicySettings();
  }

  /** Returns the object with the settings used for calls to createScalingPolicy. */
  public UnaryCallSettings<CreateScalingPolicyRequest, Operation> createScalingPolicySettings() {
    return ((ScalingPoliciesServiceStubSettings) getStubSettings()).createScalingPolicySettings();
  }

  /** Returns the object with the settings used for calls to createScalingPolicy. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<CreateScalingPolicyRequest, ScalingPolicy, Empty>
      createScalingPolicyOperationSettings() {
    return ((ScalingPoliciesServiceStubSettings) getStubSettings())
        .createScalingPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteScalingPolicy. */
  public UnaryCallSettings<DeleteScalingPolicyRequest, Operation> deleteScalingPolicySettings() {
    return ((ScalingPoliciesServiceStubSettings) getStubSettings()).deleteScalingPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteScalingPolicy. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<DeleteScalingPolicyRequest, Empty, Empty>
      deleteScalingPolicyOperationSettings() {
    return ((ScalingPoliciesServiceStubSettings) getStubSettings())
        .deleteScalingPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateScalingPolicy. */
  public UnaryCallSettings<UpdateScalingPolicyRequest, Operation> updateScalingPolicySettings() {
    return ((ScalingPoliciesServiceStubSettings) getStubSettings()).updateScalingPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateScalingPolicy. */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public OperationCallSettings<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
      updateScalingPolicyOperationSettings() {
    return ((ScalingPoliciesServiceStubSettings) getStubSettings())
        .updateScalingPolicyOperationSettings();
  }

  public static final ScalingPoliciesServiceSettings create(ScalingPoliciesServiceStubSettings stub)
      throws IOException {
    return new ScalingPoliciesServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ScalingPoliciesServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ScalingPoliciesServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ScalingPoliciesServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ScalingPoliciesServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ScalingPoliciesServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ScalingPoliciesServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ScalingPoliciesServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ScalingPoliciesServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ScalingPoliciesServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ScalingPoliciesServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(ScalingPoliciesServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(ScalingPoliciesServiceStubSettings.newBuilder());
    }

    protected Builder(ScalingPoliciesServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ScalingPoliciesServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public ScalingPoliciesServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ScalingPoliciesServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listScalingPolicies. */
    public PagedCallSettings.Builder<
            ListScalingPoliciesRequest,
            ListScalingPoliciesResponse,
            ListScalingPoliciesPagedResponse>
        listScalingPoliciesSettings() {
      return getStubSettingsBuilder().listScalingPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getScalingPolicy. */
    public UnaryCallSettings.Builder<GetScalingPolicyRequest, ScalingPolicy>
        getScalingPolicySettings() {
      return getStubSettingsBuilder().getScalingPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createScalingPolicy. */
    public UnaryCallSettings.Builder<CreateScalingPolicyRequest, Operation>
        createScalingPolicySettings() {
      return getStubSettingsBuilder().createScalingPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createScalingPolicy. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateScalingPolicyRequest, ScalingPolicy, Empty>
        createScalingPolicyOperationSettings() {
      return getStubSettingsBuilder().createScalingPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteScalingPolicy. */
    public UnaryCallSettings.Builder<DeleteScalingPolicyRequest, Operation>
        deleteScalingPolicySettings() {
      return getStubSettingsBuilder().deleteScalingPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteScalingPolicy. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteScalingPolicyRequest, Empty, Empty>
        deleteScalingPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteScalingPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateScalingPolicy. */
    public UnaryCallSettings.Builder<UpdateScalingPolicyRequest, Operation>
        updateScalingPolicySettings() {
      return getStubSettingsBuilder().updateScalingPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateScalingPolicy. */
    @BetaApi(
        "The surface for long-running operations is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateScalingPolicyRequest, ScalingPolicy, Empty>
        updateScalingPolicyOperationSettings() {
      return getStubSettingsBuilder().updateScalingPolicyOperationSettings();
    }

    @Override
    public ScalingPoliciesServiceSettings build() throws IOException {
      return new ScalingPoliciesServiceSettings(this);
    }
  }
}
