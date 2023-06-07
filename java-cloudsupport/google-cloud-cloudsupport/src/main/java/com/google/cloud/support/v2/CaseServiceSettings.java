/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.support.v2;

import static com.google.cloud.support.v2.CaseServiceClient.ListCasesPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCaseClassificationsPagedResponse;
import static com.google.cloud.support.v2.CaseServiceClient.SearchCasesPagedResponse;

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
import com.google.cloud.support.v2.stub.CaseServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CaseServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudsupport.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCase to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CaseServiceSettings.Builder caseServiceSettingsBuilder = CaseServiceSettings.newBuilder();
 * caseServiceSettingsBuilder
 *     .getCaseSettings()
 *     .setRetrySettings(
 *         caseServiceSettingsBuilder
 *             .getCaseSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CaseServiceSettings caseServiceSettings = caseServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CaseServiceSettings extends ClientSettings<CaseServiceSettings> {

  /** Returns the object with the settings used for calls to getCase. */
  public UnaryCallSettings<GetCaseRequest, Case> getCaseSettings() {
    return ((CaseServiceStubSettings) getStubSettings()).getCaseSettings();
  }

  /** Returns the object with the settings used for calls to listCases. */
  public PagedCallSettings<ListCasesRequest, ListCasesResponse, ListCasesPagedResponse>
      listCasesSettings() {
    return ((CaseServiceStubSettings) getStubSettings()).listCasesSettings();
  }

  /** Returns the object with the settings used for calls to searchCases. */
  public PagedCallSettings<SearchCasesRequest, SearchCasesResponse, SearchCasesPagedResponse>
      searchCasesSettings() {
    return ((CaseServiceStubSettings) getStubSettings()).searchCasesSettings();
  }

  /** Returns the object with the settings used for calls to createCase. */
  public UnaryCallSettings<CreateCaseRequest, Case> createCaseSettings() {
    return ((CaseServiceStubSettings) getStubSettings()).createCaseSettings();
  }

  /** Returns the object with the settings used for calls to updateCase. */
  public UnaryCallSettings<UpdateCaseRequest, Case> updateCaseSettings() {
    return ((CaseServiceStubSettings) getStubSettings()).updateCaseSettings();
  }

  /** Returns the object with the settings used for calls to escalateCase. */
  public UnaryCallSettings<EscalateCaseRequest, Case> escalateCaseSettings() {
    return ((CaseServiceStubSettings) getStubSettings()).escalateCaseSettings();
  }

  /** Returns the object with the settings used for calls to closeCase. */
  public UnaryCallSettings<CloseCaseRequest, Case> closeCaseSettings() {
    return ((CaseServiceStubSettings) getStubSettings()).closeCaseSettings();
  }

  /** Returns the object with the settings used for calls to searchCaseClassifications. */
  public PagedCallSettings<
          SearchCaseClassificationsRequest,
          SearchCaseClassificationsResponse,
          SearchCaseClassificationsPagedResponse>
      searchCaseClassificationsSettings() {
    return ((CaseServiceStubSettings) getStubSettings()).searchCaseClassificationsSettings();
  }

  public static final CaseServiceSettings create(CaseServiceStubSettings stub) throws IOException {
    return new CaseServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CaseServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CaseServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CaseServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CaseServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CaseServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CaseServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CaseServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CaseServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CaseServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CaseServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CaseServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CaseServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CaseServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CaseServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CaseServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CaseServiceStubSettings.newHttpJsonBuilder());
    }

    public CaseServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CaseServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getCase. */
    public UnaryCallSettings.Builder<GetCaseRequest, Case> getCaseSettings() {
      return getStubSettingsBuilder().getCaseSettings();
    }

    /** Returns the builder for the settings used for calls to listCases. */
    public PagedCallSettings.Builder<ListCasesRequest, ListCasesResponse, ListCasesPagedResponse>
        listCasesSettings() {
      return getStubSettingsBuilder().listCasesSettings();
    }

    /** Returns the builder for the settings used for calls to searchCases. */
    public PagedCallSettings.Builder<
            SearchCasesRequest, SearchCasesResponse, SearchCasesPagedResponse>
        searchCasesSettings() {
      return getStubSettingsBuilder().searchCasesSettings();
    }

    /** Returns the builder for the settings used for calls to createCase. */
    public UnaryCallSettings.Builder<CreateCaseRequest, Case> createCaseSettings() {
      return getStubSettingsBuilder().createCaseSettings();
    }

    /** Returns the builder for the settings used for calls to updateCase. */
    public UnaryCallSettings.Builder<UpdateCaseRequest, Case> updateCaseSettings() {
      return getStubSettingsBuilder().updateCaseSettings();
    }

    /** Returns the builder for the settings used for calls to escalateCase. */
    public UnaryCallSettings.Builder<EscalateCaseRequest, Case> escalateCaseSettings() {
      return getStubSettingsBuilder().escalateCaseSettings();
    }

    /** Returns the builder for the settings used for calls to closeCase. */
    public UnaryCallSettings.Builder<CloseCaseRequest, Case> closeCaseSettings() {
      return getStubSettingsBuilder().closeCaseSettings();
    }

    /** Returns the builder for the settings used for calls to searchCaseClassifications. */
    public PagedCallSettings.Builder<
            SearchCaseClassificationsRequest,
            SearchCaseClassificationsResponse,
            SearchCaseClassificationsPagedResponse>
        searchCaseClassificationsSettings() {
      return getStubSettingsBuilder().searchCaseClassificationsSettings();
    }

    @Override
    public CaseServiceSettings build() throws IOException {
      return new CaseServiceSettings(this);
    }
  }
}
