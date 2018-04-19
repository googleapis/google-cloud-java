/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.dlp.v2beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.dlp.v2beta1.stub.DlpServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.privacy.dlp.v2beta1.AnalyzeDataSourceRiskRequest;
import com.google.privacy.dlp.v2beta1.CreateInspectOperationRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentRequest;
import com.google.privacy.dlp.v2beta1.DeidentifyContentResponse;
import com.google.privacy.dlp.v2beta1.InspectContentRequest;
import com.google.privacy.dlp.v2beta1.InspectContentResponse;
import com.google.privacy.dlp.v2beta1.InspectOperationMetadata;
import com.google.privacy.dlp.v2beta1.InspectOperationResult;
import com.google.privacy.dlp.v2beta1.ListInfoTypesRequest;
import com.google.privacy.dlp.v2beta1.ListInfoTypesResponse;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsRequest;
import com.google.privacy.dlp.v2beta1.ListInspectFindingsResponse;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesRequest;
import com.google.privacy.dlp.v2beta1.ListRootCategoriesResponse;
import com.google.privacy.dlp.v2beta1.RedactContentRequest;
import com.google.privacy.dlp.v2beta1.RedactContentResponse;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationMetadata;
import com.google.privacy.dlp.v2beta1.RiskAnalysisOperationResult;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link DlpServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dlp.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of inspectContent to 30 seconds:
 *
 * <pre>
 * <code>
 * DlpServiceSettings.Builder dlpServiceSettingsBuilder =
 *     DlpServiceSettings.newBuilder();
 * dlpServiceSettingsBuilder.inspectContentSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * DlpServiceSettings dlpServiceSettings = dlpServiceSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class DlpServiceSettings extends ClientSettings<DlpServiceSettings> {
  /** Returns the object with the settings used for calls to inspectContent. */
  public UnaryCallSettings<InspectContentRequest, InspectContentResponse> inspectContentSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).inspectContentSettings();
  }

  /** Returns the object with the settings used for calls to redactContent. */
  public UnaryCallSettings<RedactContentRequest, RedactContentResponse> redactContentSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).redactContentSettings();
  }

  /** Returns the object with the settings used for calls to deidentifyContent. */
  public UnaryCallSettings<DeidentifyContentRequest, DeidentifyContentResponse>
      deidentifyContentSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).deidentifyContentSettings();
  }

  /** Returns the object with the settings used for calls to analyzeDataSourceRisk. */
  public UnaryCallSettings<AnalyzeDataSourceRiskRequest, Operation>
      analyzeDataSourceRiskSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).analyzeDataSourceRiskSettings();
  }

  /** Returns the object with the settings used for calls to analyzeDataSourceRisk. */
  public OperationCallSettings<
          AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult, RiskAnalysisOperationMetadata>
      analyzeDataSourceRiskOperationSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).analyzeDataSourceRiskOperationSettings();
  }

  /** Returns the object with the settings used for calls to createInspectOperation. */
  public UnaryCallSettings<CreateInspectOperationRequest, Operation>
      createInspectOperationSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).createInspectOperationSettings();
  }

  /** Returns the object with the settings used for calls to createInspectOperation. */
  public OperationCallSettings<
          CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
      createInspectOperationOperationSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).createInspectOperationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listInspectFindings. */
  public UnaryCallSettings<ListInspectFindingsRequest, ListInspectFindingsResponse>
      listInspectFindingsSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).listInspectFindingsSettings();
  }

  /** Returns the object with the settings used for calls to listInfoTypes. */
  public UnaryCallSettings<ListInfoTypesRequest, ListInfoTypesResponse> listInfoTypesSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).listInfoTypesSettings();
  }

  /** Returns the object with the settings used for calls to listRootCategories. */
  public UnaryCallSettings<ListRootCategoriesRequest, ListRootCategoriesResponse>
      listRootCategoriesSettings() {
    return ((DlpServiceStubSettings) getStubSettings()).listRootCategoriesSettings();
  }

  public static final DlpServiceSettings create(DlpServiceStubSettings stub) throws IOException {
    return new DlpServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DlpServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DlpServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DlpServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DlpServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DlpServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DlpServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DlpServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DlpServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DlpServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DlpServiceSettings, Builder> {
    protected Builder() throws IOException {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(DlpServiceStubSettings.newBuilder(clientContext));
    }

    private static Builder createDefault() {
      return new Builder(DlpServiceStubSettings.newBuilder());
    }

    protected Builder(DlpServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DlpServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    public DlpServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DlpServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to inspectContent. */
    public UnaryCallSettings.Builder<InspectContentRequest, InspectContentResponse>
        inspectContentSettings() {
      return getStubSettingsBuilder().inspectContentSettings();
    }

    /** Returns the builder for the settings used for calls to redactContent. */
    public UnaryCallSettings.Builder<RedactContentRequest, RedactContentResponse>
        redactContentSettings() {
      return getStubSettingsBuilder().redactContentSettings();
    }

    /** Returns the builder for the settings used for calls to deidentifyContent. */
    public UnaryCallSettings.Builder<DeidentifyContentRequest, DeidentifyContentResponse>
        deidentifyContentSettings() {
      return getStubSettingsBuilder().deidentifyContentSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeDataSourceRisk. */
    public UnaryCallSettings.Builder<AnalyzeDataSourceRiskRequest, Operation>
        analyzeDataSourceRiskSettings() {
      return getStubSettingsBuilder().analyzeDataSourceRiskSettings();
    }

    /** Returns the builder for the settings used for calls to analyzeDataSourceRisk. */
    public OperationCallSettings.Builder<
            AnalyzeDataSourceRiskRequest, RiskAnalysisOperationResult,
            RiskAnalysisOperationMetadata>
        analyzeDataSourceRiskOperationSettings() {
      return getStubSettingsBuilder().analyzeDataSourceRiskOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createInspectOperation. */
    public UnaryCallSettings.Builder<CreateInspectOperationRequest, Operation>
        createInspectOperationSettings() {
      return getStubSettingsBuilder().createInspectOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createInspectOperation. */
    public OperationCallSettings.Builder<
            CreateInspectOperationRequest, InspectOperationResult, InspectOperationMetadata>
        createInspectOperationOperationSettings() {
      return getStubSettingsBuilder().createInspectOperationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listInspectFindings. */
    public UnaryCallSettings.Builder<ListInspectFindingsRequest, ListInspectFindingsResponse>
        listInspectFindingsSettings() {
      return getStubSettingsBuilder().listInspectFindingsSettings();
    }

    /** Returns the builder for the settings used for calls to listInfoTypes. */
    public UnaryCallSettings.Builder<ListInfoTypesRequest, ListInfoTypesResponse>
        listInfoTypesSettings() {
      return getStubSettingsBuilder().listInfoTypesSettings();
    }

    /** Returns the builder for the settings used for calls to listRootCategories. */
    public UnaryCallSettings.Builder<ListRootCategoriesRequest, ListRootCategoriesResponse>
        listRootCategoriesSettings() {
      return getStubSettingsBuilder().listRootCategoriesSettings();
    }

    @Override
    public DlpServiceSettings build() throws IOException {
      return new DlpServiceSettings(this);
    }
  }
}
