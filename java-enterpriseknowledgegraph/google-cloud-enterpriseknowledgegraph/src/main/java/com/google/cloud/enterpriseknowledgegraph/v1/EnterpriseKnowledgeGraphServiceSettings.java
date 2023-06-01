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

package com.google.cloud.enterpriseknowledgegraph.v1;

import static com.google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphServiceClient.ListEntityReconciliationJobsPagedResponse;

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
import com.google.cloud.enterpriseknowledgegraph.v1.stub.EnterpriseKnowledgeGraphServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EnterpriseKnowledgeGraphServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (enterpriseknowledgegraph.googleapis.com) and default port
 *       (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createEntityReconciliationJob to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EnterpriseKnowledgeGraphServiceSettings.Builder enterpriseKnowledgeGraphServiceSettingsBuilder =
 *     EnterpriseKnowledgeGraphServiceSettings.newBuilder();
 * enterpriseKnowledgeGraphServiceSettingsBuilder
 *     .createEntityReconciliationJobSettings()
 *     .setRetrySettings(
 *         enterpriseKnowledgeGraphServiceSettingsBuilder
 *             .createEntityReconciliationJobSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EnterpriseKnowledgeGraphServiceSettings enterpriseKnowledgeGraphServiceSettings =
 *     enterpriseKnowledgeGraphServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EnterpriseKnowledgeGraphServiceSettings
    extends ClientSettings<EnterpriseKnowledgeGraphServiceSettings> {

  /** Returns the object with the settings used for calls to createEntityReconciliationJob. */
  public UnaryCallSettings<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
      createEntityReconciliationJobSettings() {
    return ((EnterpriseKnowledgeGraphServiceStubSettings) getStubSettings())
        .createEntityReconciliationJobSettings();
  }

  /** Returns the object with the settings used for calls to getEntityReconciliationJob. */
  public UnaryCallSettings<GetEntityReconciliationJobRequest, EntityReconciliationJob>
      getEntityReconciliationJobSettings() {
    return ((EnterpriseKnowledgeGraphServiceStubSettings) getStubSettings())
        .getEntityReconciliationJobSettings();
  }

  /** Returns the object with the settings used for calls to listEntityReconciliationJobs. */
  public PagedCallSettings<
          ListEntityReconciliationJobsRequest,
          ListEntityReconciliationJobsResponse,
          ListEntityReconciliationJobsPagedResponse>
      listEntityReconciliationJobsSettings() {
    return ((EnterpriseKnowledgeGraphServiceStubSettings) getStubSettings())
        .listEntityReconciliationJobsSettings();
  }

  /** Returns the object with the settings used for calls to cancelEntityReconciliationJob. */
  public UnaryCallSettings<CancelEntityReconciliationJobRequest, Empty>
      cancelEntityReconciliationJobSettings() {
    return ((EnterpriseKnowledgeGraphServiceStubSettings) getStubSettings())
        .cancelEntityReconciliationJobSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntityReconciliationJob. */
  public UnaryCallSettings<DeleteEntityReconciliationJobRequest, Empty>
      deleteEntityReconciliationJobSettings() {
    return ((EnterpriseKnowledgeGraphServiceStubSettings) getStubSettings())
        .deleteEntityReconciliationJobSettings();
  }

  /** Returns the object with the settings used for calls to lookup. */
  public UnaryCallSettings<LookupRequest, LookupResponse> lookupSettings() {
    return ((EnterpriseKnowledgeGraphServiceStubSettings) getStubSettings()).lookupSettings();
  }

  /** Returns the object with the settings used for calls to search. */
  public UnaryCallSettings<SearchRequest, SearchResponse> searchSettings() {
    return ((EnterpriseKnowledgeGraphServiceStubSettings) getStubSettings()).searchSettings();
  }

  /** Returns the object with the settings used for calls to lookupPublicKg. */
  public UnaryCallSettings<LookupPublicKgRequest, LookupPublicKgResponse> lookupPublicKgSettings() {
    return ((EnterpriseKnowledgeGraphServiceStubSettings) getStubSettings())
        .lookupPublicKgSettings();
  }

  /** Returns the object with the settings used for calls to searchPublicKg. */
  public UnaryCallSettings<SearchPublicKgRequest, SearchPublicKgResponse> searchPublicKgSettings() {
    return ((EnterpriseKnowledgeGraphServiceStubSettings) getStubSettings())
        .searchPublicKgSettings();
  }

  public static final EnterpriseKnowledgeGraphServiceSettings create(
      EnterpriseKnowledgeGraphServiceStubSettings stub) throws IOException {
    return new EnterpriseKnowledgeGraphServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return EnterpriseKnowledgeGraphServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return EnterpriseKnowledgeGraphServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return EnterpriseKnowledgeGraphServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return EnterpriseKnowledgeGraphServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return EnterpriseKnowledgeGraphServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return EnterpriseKnowledgeGraphServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return EnterpriseKnowledgeGraphServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EnterpriseKnowledgeGraphServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected EnterpriseKnowledgeGraphServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for EnterpriseKnowledgeGraphServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<EnterpriseKnowledgeGraphServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(EnterpriseKnowledgeGraphServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(EnterpriseKnowledgeGraphServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(EnterpriseKnowledgeGraphServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(EnterpriseKnowledgeGraphServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(EnterpriseKnowledgeGraphServiceStubSettings.newHttpJsonBuilder());
    }

    public EnterpriseKnowledgeGraphServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((EnterpriseKnowledgeGraphServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createEntityReconciliationJob. */
    public UnaryCallSettings.Builder<CreateEntityReconciliationJobRequest, EntityReconciliationJob>
        createEntityReconciliationJobSettings() {
      return getStubSettingsBuilder().createEntityReconciliationJobSettings();
    }

    /** Returns the builder for the settings used for calls to getEntityReconciliationJob. */
    public UnaryCallSettings.Builder<GetEntityReconciliationJobRequest, EntityReconciliationJob>
        getEntityReconciliationJobSettings() {
      return getStubSettingsBuilder().getEntityReconciliationJobSettings();
    }

    /** Returns the builder for the settings used for calls to listEntityReconciliationJobs. */
    public PagedCallSettings.Builder<
            ListEntityReconciliationJobsRequest,
            ListEntityReconciliationJobsResponse,
            ListEntityReconciliationJobsPagedResponse>
        listEntityReconciliationJobsSettings() {
      return getStubSettingsBuilder().listEntityReconciliationJobsSettings();
    }

    /** Returns the builder for the settings used for calls to cancelEntityReconciliationJob. */
    public UnaryCallSettings.Builder<CancelEntityReconciliationJobRequest, Empty>
        cancelEntityReconciliationJobSettings() {
      return getStubSettingsBuilder().cancelEntityReconciliationJobSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntityReconciliationJob. */
    public UnaryCallSettings.Builder<DeleteEntityReconciliationJobRequest, Empty>
        deleteEntityReconciliationJobSettings() {
      return getStubSettingsBuilder().deleteEntityReconciliationJobSettings();
    }

    /** Returns the builder for the settings used for calls to lookup. */
    public UnaryCallSettings.Builder<LookupRequest, LookupResponse> lookupSettings() {
      return getStubSettingsBuilder().lookupSettings();
    }

    /** Returns the builder for the settings used for calls to search. */
    public UnaryCallSettings.Builder<SearchRequest, SearchResponse> searchSettings() {
      return getStubSettingsBuilder().searchSettings();
    }

    /** Returns the builder for the settings used for calls to lookupPublicKg. */
    public UnaryCallSettings.Builder<LookupPublicKgRequest, LookupPublicKgResponse>
        lookupPublicKgSettings() {
      return getStubSettingsBuilder().lookupPublicKgSettings();
    }

    /** Returns the builder for the settings used for calls to searchPublicKg. */
    public UnaryCallSettings.Builder<SearchPublicKgRequest, SearchPublicKgResponse>
        searchPublicKgSettings() {
      return getStubSettingsBuilder().searchPublicKgSettings();
    }

    @Override
    public EnterpriseKnowledgeGraphServiceSettings build() throws IOException {
      return new EnterpriseKnowledgeGraphServiceSettings(this);
    }
  }
}
