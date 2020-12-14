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

package com.google.cloud.webrisk.v1;

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
import com.google.cloud.webrisk.v1.stub.WebRiskServiceStubSettings;
import com.google.webrisk.v1.ComputeThreatListDiffRequest;
import com.google.webrisk.v1.ComputeThreatListDiffResponse;
import com.google.webrisk.v1.CreateSubmissionRequest;
import com.google.webrisk.v1.SearchHashesRequest;
import com.google.webrisk.v1.SearchHashesResponse;
import com.google.webrisk.v1.SearchUrisRequest;
import com.google.webrisk.v1.SearchUrisResponse;
import com.google.webrisk.v1.Submission;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link WebRiskServiceClient}.
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
 * WebRiskServiceSettings.Builder webRiskServiceSettingsBuilder =
 *     WebRiskServiceSettings.newBuilder();
 * webRiskServiceSettingsBuilder
 *     .computeThreatListDiffSettings()
 *     .setRetrySettings(
 *         webRiskServiceSettingsBuilder
 *             .computeThreatListDiffSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * WebRiskServiceSettings webRiskServiceSettings = webRiskServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class WebRiskServiceSettings extends ClientSettings<WebRiskServiceSettings> {

  /** Returns the object with the settings used for calls to computeThreatListDiff. */
  public UnaryCallSettings<ComputeThreatListDiffRequest, ComputeThreatListDiffResponse>
      computeThreatListDiffSettings() {
    return ((WebRiskServiceStubSettings) getStubSettings()).computeThreatListDiffSettings();
  }

  /** Returns the object with the settings used for calls to searchUris. */
  public UnaryCallSettings<SearchUrisRequest, SearchUrisResponse> searchUrisSettings() {
    return ((WebRiskServiceStubSettings) getStubSettings()).searchUrisSettings();
  }

  /** Returns the object with the settings used for calls to searchHashes. */
  public UnaryCallSettings<SearchHashesRequest, SearchHashesResponse> searchHashesSettings() {
    return ((WebRiskServiceStubSettings) getStubSettings()).searchHashesSettings();
  }

  /** Returns the object with the settings used for calls to createSubmission. */
  public UnaryCallSettings<CreateSubmissionRequest, Submission> createSubmissionSettings() {
    return ((WebRiskServiceStubSettings) getStubSettings()).createSubmissionSettings();
  }

  public static final WebRiskServiceSettings create(WebRiskServiceStubSettings stub)
      throws IOException {
    return new WebRiskServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return WebRiskServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return WebRiskServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return WebRiskServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return WebRiskServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return WebRiskServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return WebRiskServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return WebRiskServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected WebRiskServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for WebRiskServiceSettings. */
  public static class Builder extends ClientSettings.Builder<WebRiskServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(WebRiskServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(WebRiskServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(WebRiskServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(WebRiskServiceStubSettings.newBuilder());
    }

    public WebRiskServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((WebRiskServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createSubmission. */
    public UnaryCallSettings.Builder<CreateSubmissionRequest, Submission>
        createSubmissionSettings() {
      return getStubSettingsBuilder().createSubmissionSettings();
    }

    @Override
    public WebRiskServiceSettings build() throws IOException {
      return new WebRiskServiceSettings(this);
    }
  }
}
