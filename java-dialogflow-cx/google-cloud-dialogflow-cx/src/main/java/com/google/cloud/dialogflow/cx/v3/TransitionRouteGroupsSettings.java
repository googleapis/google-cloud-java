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

package com.google.cloud.dialogflow.cx.v3;

import static com.google.cloud.dialogflow.cx.v3.TransitionRouteGroupsClient.ListTransitionRouteGroupsPagedResponse;

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
import com.google.cloud.dialogflow.cx.v3.stub.TransitionRouteGroupsStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link TransitionRouteGroupsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dialogflow.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getTransitionRouteGroup to 30 seconds:
 *
 * <pre>{@code
 * TransitionRouteGroupsSettings.Builder transitionRouteGroupsSettingsBuilder =
 *     TransitionRouteGroupsSettings.newBuilder();
 * transitionRouteGroupsSettingsBuilder
 *     .getTransitionRouteGroupSettings()
 *     .setRetrySettings(
 *         transitionRouteGroupsSettingsBuilder
 *             .getTransitionRouteGroupSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * TransitionRouteGroupsSettings transitionRouteGroupsSettings =
 *     transitionRouteGroupsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class TransitionRouteGroupsSettings extends ClientSettings<TransitionRouteGroupsSettings> {

  /** Returns the object with the settings used for calls to listTransitionRouteGroups. */
  public PagedCallSettings<
          ListTransitionRouteGroupsRequest,
          ListTransitionRouteGroupsResponse,
          ListTransitionRouteGroupsPagedResponse>
      listTransitionRouteGroupsSettings() {
    return ((TransitionRouteGroupsStubSettings) getStubSettings())
        .listTransitionRouteGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getTransitionRouteGroup. */
  public UnaryCallSettings<GetTransitionRouteGroupRequest, TransitionRouteGroup>
      getTransitionRouteGroupSettings() {
    return ((TransitionRouteGroupsStubSettings) getStubSettings())
        .getTransitionRouteGroupSettings();
  }

  /** Returns the object with the settings used for calls to createTransitionRouteGroup. */
  public UnaryCallSettings<CreateTransitionRouteGroupRequest, TransitionRouteGroup>
      createTransitionRouteGroupSettings() {
    return ((TransitionRouteGroupsStubSettings) getStubSettings())
        .createTransitionRouteGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateTransitionRouteGroup. */
  public UnaryCallSettings<UpdateTransitionRouteGroupRequest, TransitionRouteGroup>
      updateTransitionRouteGroupSettings() {
    return ((TransitionRouteGroupsStubSettings) getStubSettings())
        .updateTransitionRouteGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteTransitionRouteGroup. */
  public UnaryCallSettings<DeleteTransitionRouteGroupRequest, Empty>
      deleteTransitionRouteGroupSettings() {
    return ((TransitionRouteGroupsStubSettings) getStubSettings())
        .deleteTransitionRouteGroupSettings();
  }

  public static final TransitionRouteGroupsSettings create(TransitionRouteGroupsStubSettings stub)
      throws IOException {
    return new TransitionRouteGroupsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return TransitionRouteGroupsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return TransitionRouteGroupsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return TransitionRouteGroupsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return TransitionRouteGroupsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return TransitionRouteGroupsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return TransitionRouteGroupsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return TransitionRouteGroupsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected TransitionRouteGroupsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for TransitionRouteGroupsSettings. */
  public static class Builder
      extends ClientSettings.Builder<TransitionRouteGroupsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(TransitionRouteGroupsStubSettings.newBuilder(clientContext));
    }

    protected Builder(TransitionRouteGroupsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(TransitionRouteGroupsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(TransitionRouteGroupsStubSettings.newBuilder());
    }

    public TransitionRouteGroupsStubSettings.Builder getStubSettingsBuilder() {
      return ((TransitionRouteGroupsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listTransitionRouteGroups. */
    public PagedCallSettings.Builder<
            ListTransitionRouteGroupsRequest,
            ListTransitionRouteGroupsResponse,
            ListTransitionRouteGroupsPagedResponse>
        listTransitionRouteGroupsSettings() {
      return getStubSettingsBuilder().listTransitionRouteGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getTransitionRouteGroup. */
    public UnaryCallSettings.Builder<GetTransitionRouteGroupRequest, TransitionRouteGroup>
        getTransitionRouteGroupSettings() {
      return getStubSettingsBuilder().getTransitionRouteGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createTransitionRouteGroup. */
    public UnaryCallSettings.Builder<CreateTransitionRouteGroupRequest, TransitionRouteGroup>
        createTransitionRouteGroupSettings() {
      return getStubSettingsBuilder().createTransitionRouteGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateTransitionRouteGroup. */
    public UnaryCallSettings.Builder<UpdateTransitionRouteGroupRequest, TransitionRouteGroup>
        updateTransitionRouteGroupSettings() {
      return getStubSettingsBuilder().updateTransitionRouteGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTransitionRouteGroup. */
    public UnaryCallSettings.Builder<DeleteTransitionRouteGroupRequest, Empty>
        deleteTransitionRouteGroupSettings() {
      return getStubSettingsBuilder().deleteTransitionRouteGroupSettings();
    }

    @Override
    public TransitionRouteGroupsSettings build() throws IOException {
      return new TransitionRouteGroupsSettings(this);
    }
  }
}
