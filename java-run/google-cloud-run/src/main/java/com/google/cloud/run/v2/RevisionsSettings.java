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

package com.google.cloud.run.v2;

import static com.google.cloud.run.v2.RevisionsClient.ListRevisionsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.run.v2.stub.RevisionsStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link RevisionsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (run.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getRevision to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RevisionsSettings.Builder revisionsSettingsBuilder = RevisionsSettings.newBuilder();
 * revisionsSettingsBuilder
 *     .getRevisionSettings()
 *     .setRetrySettings(
 *         revisionsSettingsBuilder
 *             .getRevisionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * RevisionsSettings revisionsSettings = revisionsSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class RevisionsSettings extends ClientSettings<RevisionsSettings> {

  /** Returns the object with the settings used for calls to getRevision. */
  public UnaryCallSettings<GetRevisionRequest, Revision> getRevisionSettings() {
    return ((RevisionsStubSettings) getStubSettings()).getRevisionSettings();
  }

  /** Returns the object with the settings used for calls to listRevisions. */
  public PagedCallSettings<ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>
      listRevisionsSettings() {
    return ((RevisionsStubSettings) getStubSettings()).listRevisionsSettings();
  }

  /** Returns the object with the settings used for calls to deleteRevision. */
  public UnaryCallSettings<DeleteRevisionRequest, Operation> deleteRevisionSettings() {
    return ((RevisionsStubSettings) getStubSettings()).deleteRevisionSettings();
  }

  /** Returns the object with the settings used for calls to deleteRevision. */
  public OperationCallSettings<DeleteRevisionRequest, Revision, Revision>
      deleteRevisionOperationSettings() {
    return ((RevisionsStubSettings) getStubSettings()).deleteRevisionOperationSettings();
  }

  public static final RevisionsSettings create(RevisionsStubSettings stub) throws IOException {
    return new RevisionsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return RevisionsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return RevisionsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return RevisionsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return RevisionsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return RevisionsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return RevisionsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return RevisionsStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return RevisionsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected RevisionsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for RevisionsSettings. */
  public static class Builder extends ClientSettings.Builder<RevisionsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(RevisionsStubSettings.newBuilder(clientContext));
    }

    protected Builder(RevisionsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(RevisionsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(RevisionsStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(RevisionsStubSettings.newHttpJsonBuilder());
    }

    public RevisionsStubSettings.Builder getStubSettingsBuilder() {
      return ((RevisionsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getRevision. */
    public UnaryCallSettings.Builder<GetRevisionRequest, Revision> getRevisionSettings() {
      return getStubSettingsBuilder().getRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to listRevisions. */
    public PagedCallSettings.Builder<
            ListRevisionsRequest, ListRevisionsResponse, ListRevisionsPagedResponse>
        listRevisionsSettings() {
      return getStubSettingsBuilder().listRevisionsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRevision. */
    public UnaryCallSettings.Builder<DeleteRevisionRequest, Operation> deleteRevisionSettings() {
      return getStubSettingsBuilder().deleteRevisionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRevision. */
    public OperationCallSettings.Builder<DeleteRevisionRequest, Revision, Revision>
        deleteRevisionOperationSettings() {
      return getStubSettingsBuilder().deleteRevisionOperationSettings();
    }

    @Override
    public RevisionsSettings build() throws IOException {
      return new RevisionsSettings(this);
    }
  }
}
