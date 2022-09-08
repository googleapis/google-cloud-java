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

package com.google.cloud.debugger.v2;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.debugger.v2.stub.Debugger2StubSettings;
import com.google.devtools.clouddebugger.v2.DeleteBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.GetBreakpointResponse;
import com.google.devtools.clouddebugger.v2.ListBreakpointsRequest;
import com.google.devtools.clouddebugger.v2.ListBreakpointsResponse;
import com.google.devtools.clouddebugger.v2.ListDebuggeesRequest;
import com.google.devtools.clouddebugger.v2.ListDebuggeesResponse;
import com.google.devtools.clouddebugger.v2.SetBreakpointRequest;
import com.google.devtools.clouddebugger.v2.SetBreakpointResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link Debugger2Client}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (clouddebugger.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of setBreakpoint to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * Debugger2Settings.Builder debugger2SettingsBuilder = Debugger2Settings.newBuilder();
 * debugger2SettingsBuilder
 *     .setBreakpointSettings()
 *     .setRetrySettings(
 *         debugger2SettingsBuilder.setBreakpointSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * Debugger2Settings debugger2Settings = debugger2SettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class Debugger2Settings extends ClientSettings<Debugger2Settings> {

  /** Returns the object with the settings used for calls to setBreakpoint. */
  public UnaryCallSettings<SetBreakpointRequest, SetBreakpointResponse> setBreakpointSettings() {
    return ((Debugger2StubSettings) getStubSettings()).setBreakpointSettings();
  }

  /** Returns the object with the settings used for calls to getBreakpoint. */
  public UnaryCallSettings<GetBreakpointRequest, GetBreakpointResponse> getBreakpointSettings() {
    return ((Debugger2StubSettings) getStubSettings()).getBreakpointSettings();
  }

  /** Returns the object with the settings used for calls to deleteBreakpoint. */
  public UnaryCallSettings<DeleteBreakpointRequest, Empty> deleteBreakpointSettings() {
    return ((Debugger2StubSettings) getStubSettings()).deleteBreakpointSettings();
  }

  /** Returns the object with the settings used for calls to listBreakpoints. */
  public UnaryCallSettings<ListBreakpointsRequest, ListBreakpointsResponse>
      listBreakpointsSettings() {
    return ((Debugger2StubSettings) getStubSettings()).listBreakpointsSettings();
  }

  /** Returns the object with the settings used for calls to listDebuggees. */
  public UnaryCallSettings<ListDebuggeesRequest, ListDebuggeesResponse> listDebuggeesSettings() {
    return ((Debugger2StubSettings) getStubSettings()).listDebuggeesSettings();
  }

  public static final Debugger2Settings create(Debugger2StubSettings stub) throws IOException {
    return new Debugger2Settings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return Debugger2StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return Debugger2StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return Debugger2StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return Debugger2StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return Debugger2StubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return Debugger2StubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return Debugger2StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return Debugger2StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected Debugger2Settings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for Debugger2Settings. */
  public static class Builder extends ClientSettings.Builder<Debugger2Settings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(Debugger2StubSettings.newBuilder(clientContext));
    }

    protected Builder(Debugger2Settings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(Debugger2StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(Debugger2StubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(Debugger2StubSettings.newHttpJsonBuilder());
    }

    public Debugger2StubSettings.Builder getStubSettingsBuilder() {
      return ((Debugger2StubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to setBreakpoint. */
    public UnaryCallSettings.Builder<SetBreakpointRequest, SetBreakpointResponse>
        setBreakpointSettings() {
      return getStubSettingsBuilder().setBreakpointSettings();
    }

    /** Returns the builder for the settings used for calls to getBreakpoint. */
    public UnaryCallSettings.Builder<GetBreakpointRequest, GetBreakpointResponse>
        getBreakpointSettings() {
      return getStubSettingsBuilder().getBreakpointSettings();
    }

    /** Returns the builder for the settings used for calls to deleteBreakpoint. */
    public UnaryCallSettings.Builder<DeleteBreakpointRequest, Empty> deleteBreakpointSettings() {
      return getStubSettingsBuilder().deleteBreakpointSettings();
    }

    /** Returns the builder for the settings used for calls to listBreakpoints. */
    public UnaryCallSettings.Builder<ListBreakpointsRequest, ListBreakpointsResponse>
        listBreakpointsSettings() {
      return getStubSettingsBuilder().listBreakpointsSettings();
    }

    /** Returns the builder for the settings used for calls to listDebuggees. */
    public UnaryCallSettings.Builder<ListDebuggeesRequest, ListDebuggeesResponse>
        listDebuggeesSettings() {
      return getStubSettingsBuilder().listDebuggeesSettings();
    }

    @Override
    public Debugger2Settings build() throws IOException {
      return new Debugger2Settings(this);
    }
  }
}
