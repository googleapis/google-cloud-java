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

package com.google.cloud.webrisk.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.webrisk.v1beta1.stub.WebRiskServiceV1Beta1StubSettings;
import com.google.webrisk.v1beta1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1beta1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1beta1.SearchHashesRequest;
import com.google.webrisk.v1beta1.SearchHashesResponse;
import com.google.webrisk.v1beta1.SearchUrisRequest;
import com.google.webrisk.v1beta1.SearchUrisResponse;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WebRiskServiceV1Beta1Client}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (webrisk.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of computeThreatListDiff to 30 seconds:
 *
 * <pre>{@code
 * WebRiskServiceV1Beta1Settings.Builder webRiskServiceV1Beta1SettingsBuilder =
 *     WebRiskServiceV1Beta1Settings.newBuilder();
 * webRiskServiceV1Beta1SettingsBuilder
 *     .computeThreatListDiffSettings()
 *     .setRetrySettings(
 *         webRiskServiceV1Beta1SettingsBuilder
 *             .computeThreatListDiffSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WebRiskServiceV1Beta1Settings webRiskServiceV1Beta1Settings =
 *     webRiskServiceV1Beta1SettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WebRiskServiceV1Beta1Settings extends ClientSettings<WebRiskServiceV1Beta1Settings> {

  /** Returns the object with the settings used for calls to computeThreatListDiff. */
  public UnaryCallSettings<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffSettings() {
    return ((WebRiskServiceV1Beta1StubSettings) getStubSettings()).computeThreatListDiffSettings();
  }

  /** Returns the object with the settings used for calls to searchUris. */
  public UnaryCallSettings<SearchUrisRequest, SearchUrisResponse> searchUrisSettings() {
    return ((WebRiskServiceV1Beta1StubSettings) getStubSettings()).searchUrisSettings();
  }

  /** Returns the object with the settings used for calls to searchHashes. */
  public UnaryCallSettings<SearchHashesRequest, SearchHashesResponse> searchHashesSettings() {
    return ((WebRiskServiceV1Beta1StubSettings) getStubSettings()).searchHashesSettings();
  }

  public static final WebRiskServiceV1Beta1Settings create(WebRiskServiceV1Beta1StubSettings stub)
      throws IOException {
    return new WebRiskServiceV1Beta1Settings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WebRiskServiceV1Beta1StubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WebRiskServiceV1Beta1StubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WebRiskServiceV1Beta1StubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WebRiskServiceV1Beta1StubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WebRiskServiceV1Beta1StubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WebRiskServiceV1Beta1StubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WebRiskServiceV1Beta1StubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected WebRiskServiceV1Beta1Settings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WebRiskServiceV1Beta1Settings. */
  public static class Builder
      extends ClientSettings.Builder<WebRiskServiceV1Beta1Settings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WebRiskServiceV1Beta1StubSettings.newBuilder(clientContext));
    }

    protected Builder(WebRiskServiceV1Beta1Settings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WebRiskServiceV1Beta1StubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WebRiskServiceV1Beta1StubSettings.newBuilder());
    }

    public WebRiskServiceV1Beta1StubSettings.Builder getStubSettingsBuilder() {
      return ((WebRiskServiceV1Beta1StubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to computeThreatListDiff. */
    public UnaryCallSettings.Builder<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
        computeThreatListDiffSettings() {
      return getStubSettingsBuilder().computeThreatListDiffSettings();
    }

    /** Returns the builder for the settings used for calls to searchUris. */
    public UnaryCallSettings.Builder<SearchUrisRequest, SearchUrisResponse> searchUrisSettings() {
      return getStubSettingsBuilder().searchUrisSettings();
    }

    /** Returns the builder for the settings used for calls to searchHashes. */
    public UnaryCallSettings.Builder<SearchHashesRequest, SearchHashesResponse>
        searchHashesSettings() {
      return getStubSettingsBuilder().searchHashesSettings();
    }

    @Override
    public WebRiskServiceV1Beta1Settings build() throws IOException {
      return new WebRiskServiceV1Beta1Settings(this);
    }
  }
}
