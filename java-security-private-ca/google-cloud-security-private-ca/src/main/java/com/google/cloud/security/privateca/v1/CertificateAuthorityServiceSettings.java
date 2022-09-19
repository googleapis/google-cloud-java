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

package com.google.cloud.security.privateca.v1;

import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCaPoolsPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateAuthoritiesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateRevocationListsPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificateTemplatesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListCertificatesPagedResponse;
import static com.google.cloud.security.privateca.v1.CertificateAuthorityServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.security.privateca.v1.stub.CertificateAuthorityServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CertificateAuthorityServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (privateca.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createCertificate to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CertificateAuthorityServiceSettings.Builder certificateAuthorityServiceSettingsBuilder =
 *     CertificateAuthorityServiceSettings.newBuilder();
 * certificateAuthorityServiceSettingsBuilder
 *     .createCertificateSettings()
 *     .setRetrySettings(
 *         certificateAuthorityServiceSettingsBuilder
 *             .createCertificateSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CertificateAuthorityServiceSettings certificateAuthorityServiceSettings =
 *     certificateAuthorityServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CertificateAuthorityServiceSettings
    extends ClientSettings<CertificateAuthorityServiceSettings> {

  /** Returns the object with the settings used for calls to createCertificate. */
  public UnaryCallSettings<CreateCertificateRequest, Certificate> createCertificateSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .createCertificateSettings();
  }

  /** Returns the object with the settings used for calls to getCertificate. */
  public UnaryCallSettings<GetCertificateRequest, Certificate> getCertificateSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).getCertificateSettings();
  }

  /** Returns the object with the settings used for calls to listCertificates. */
  public PagedCallSettings<
          ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
      listCertificatesSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).listCertificatesSettings();
  }

  /** Returns the object with the settings used for calls to revokeCertificate. */
  public UnaryCallSettings<RevokeCertificateRequest, Certificate> revokeCertificateSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .revokeCertificateSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificate. */
  public UnaryCallSettings<UpdateCertificateRequest, Certificate> updateCertificateSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .updateCertificateSettings();
  }

  /** Returns the object with the settings used for calls to activateCertificateAuthority. */
  public UnaryCallSettings<ActivateCertificateAuthorityRequest, Operation>
      activateCertificateAuthoritySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .activateCertificateAuthoritySettings();
  }

  /** Returns the object with the settings used for calls to activateCertificateAuthority. */
  public OperationCallSettings<
          ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      activateCertificateAuthorityOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .activateCertificateAuthorityOperationSettings();
  }

  /** Returns the object with the settings used for calls to createCertificateAuthority. */
  public UnaryCallSettings<CreateCertificateAuthorityRequest, Operation>
      createCertificateAuthoritySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .createCertificateAuthoritySettings();
  }

  /** Returns the object with the settings used for calls to createCertificateAuthority. */
  public OperationCallSettings<
          CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      createCertificateAuthorityOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .createCertificateAuthorityOperationSettings();
  }

  /** Returns the object with the settings used for calls to disableCertificateAuthority. */
  public UnaryCallSettings<DisableCertificateAuthorityRequest, Operation>
      disableCertificateAuthoritySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .disableCertificateAuthoritySettings();
  }

  /** Returns the object with the settings used for calls to disableCertificateAuthority. */
  public OperationCallSettings<
          DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      disableCertificateAuthorityOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .disableCertificateAuthorityOperationSettings();
  }

  /** Returns the object with the settings used for calls to enableCertificateAuthority. */
  public UnaryCallSettings<EnableCertificateAuthorityRequest, Operation>
      enableCertificateAuthoritySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .enableCertificateAuthoritySettings();
  }

  /** Returns the object with the settings used for calls to enableCertificateAuthority. */
  public OperationCallSettings<
          EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      enableCertificateAuthorityOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .enableCertificateAuthorityOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchCertificateAuthorityCsr. */
  public UnaryCallSettings<
          FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
      fetchCertificateAuthorityCsrSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .fetchCertificateAuthorityCsrSettings();
  }

  /** Returns the object with the settings used for calls to getCertificateAuthority. */
  public UnaryCallSettings<GetCertificateAuthorityRequest, CertificateAuthority>
      getCertificateAuthoritySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .getCertificateAuthoritySettings();
  }

  /** Returns the object with the settings used for calls to listCertificateAuthorities. */
  public PagedCallSettings<
          ListCertificateAuthoritiesRequest,
          ListCertificateAuthoritiesResponse,
          ListCertificateAuthoritiesPagedResponse>
      listCertificateAuthoritiesSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .listCertificateAuthoritiesSettings();
  }

  /** Returns the object with the settings used for calls to undeleteCertificateAuthority. */
  public UnaryCallSettings<UndeleteCertificateAuthorityRequest, Operation>
      undeleteCertificateAuthoritySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .undeleteCertificateAuthoritySettings();
  }

  /** Returns the object with the settings used for calls to undeleteCertificateAuthority. */
  public OperationCallSettings<
          UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      undeleteCertificateAuthorityOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .undeleteCertificateAuthorityOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateAuthority. */
  public UnaryCallSettings<DeleteCertificateAuthorityRequest, Operation>
      deleteCertificateAuthoritySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .deleteCertificateAuthoritySettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateAuthority. */
  public OperationCallSettings<
          DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      deleteCertificateAuthorityOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .deleteCertificateAuthorityOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateAuthority. */
  public UnaryCallSettings<UpdateCertificateAuthorityRequest, Operation>
      updateCertificateAuthoritySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .updateCertificateAuthoritySettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateAuthority. */
  public OperationCallSettings<
          UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
      updateCertificateAuthorityOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .updateCertificateAuthorityOperationSettings();
  }

  /** Returns the object with the settings used for calls to createCaPool. */
  public UnaryCallSettings<CreateCaPoolRequest, Operation> createCaPoolSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).createCaPoolSettings();
  }

  /** Returns the object with the settings used for calls to createCaPool. */
  public OperationCallSettings<CreateCaPoolRequest, CaPool, OperationMetadata>
      createCaPoolOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .createCaPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCaPool. */
  public UnaryCallSettings<UpdateCaPoolRequest, Operation> updateCaPoolSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).updateCaPoolSettings();
  }

  /** Returns the object with the settings used for calls to updateCaPool. */
  public OperationCallSettings<UpdateCaPoolRequest, CaPool, OperationMetadata>
      updateCaPoolOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .updateCaPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to getCaPool. */
  public UnaryCallSettings<GetCaPoolRequest, CaPool> getCaPoolSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).getCaPoolSettings();
  }

  /** Returns the object with the settings used for calls to listCaPools. */
  public PagedCallSettings<ListCaPoolsRequest, ListCaPoolsResponse, ListCaPoolsPagedResponse>
      listCaPoolsSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).listCaPoolsSettings();
  }

  /** Returns the object with the settings used for calls to deleteCaPool. */
  public UnaryCallSettings<DeleteCaPoolRequest, Operation> deleteCaPoolSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).deleteCaPoolSettings();
  }

  /** Returns the object with the settings used for calls to deleteCaPool. */
  public OperationCallSettings<DeleteCaPoolRequest, Empty, OperationMetadata>
      deleteCaPoolOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .deleteCaPoolOperationSettings();
  }

  /** Returns the object with the settings used for calls to fetchCaCerts. */
  public UnaryCallSettings<FetchCaCertsRequest, FetchCaCertsResponse> fetchCaCertsSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).fetchCaCertsSettings();
  }

  /** Returns the object with the settings used for calls to getCertificateRevocationList. */
  public UnaryCallSettings<GetCertificateRevocationListRequest, CertificateRevocationList>
      getCertificateRevocationListSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .getCertificateRevocationListSettings();
  }

  /** Returns the object with the settings used for calls to listCertificateRevocationLists. */
  public PagedCallSettings<
          ListCertificateRevocationListsRequest,
          ListCertificateRevocationListsResponse,
          ListCertificateRevocationListsPagedResponse>
      listCertificateRevocationListsSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .listCertificateRevocationListsSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateRevocationList. */
  public UnaryCallSettings<UpdateCertificateRevocationListRequest, Operation>
      updateCertificateRevocationListSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .updateCertificateRevocationListSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateRevocationList. */
  public OperationCallSettings<
          UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
      updateCertificateRevocationListOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .updateCertificateRevocationListOperationSettings();
  }

  /** Returns the object with the settings used for calls to createCertificateTemplate. */
  public UnaryCallSettings<CreateCertificateTemplateRequest, Operation>
      createCertificateTemplateSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .createCertificateTemplateSettings();
  }

  /** Returns the object with the settings used for calls to createCertificateTemplate. */
  public OperationCallSettings<
          CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      createCertificateTemplateOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .createCertificateTemplateOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateTemplate. */
  public UnaryCallSettings<DeleteCertificateTemplateRequest, Operation>
      deleteCertificateTemplateSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .deleteCertificateTemplateSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateTemplate. */
  public OperationCallSettings<DeleteCertificateTemplateRequest, Empty, OperationMetadata>
      deleteCertificateTemplateOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .deleteCertificateTemplateOperationSettings();
  }

  /** Returns the object with the settings used for calls to getCertificateTemplate. */
  public UnaryCallSettings<GetCertificateTemplateRequest, CertificateTemplate>
      getCertificateTemplateSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .getCertificateTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listCertificateTemplates. */
  public PagedCallSettings<
          ListCertificateTemplatesRequest,
          ListCertificateTemplatesResponse,
          ListCertificateTemplatesPagedResponse>
      listCertificateTemplatesSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .listCertificateTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateTemplate. */
  public UnaryCallSettings<UpdateCertificateTemplateRequest, Operation>
      updateCertificateTemplateSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .updateCertificateTemplateSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateTemplate. */
  public OperationCallSettings<
          UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
      updateCertificateTemplateOperationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .updateCertificateTemplateOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((CertificateAuthorityServiceStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final CertificateAuthorityServiceSettings create(
      CertificateAuthorityServiceStubSettings stub) throws IOException {
    return new CertificateAuthorityServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CertificateAuthorityServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CertificateAuthorityServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CertificateAuthorityServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CertificateAuthorityServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CertificateAuthorityServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CertificateAuthorityServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CertificateAuthorityServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CertificateAuthorityServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CertificateAuthorityServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CertificateAuthorityServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<CertificateAuthorityServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CertificateAuthorityServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CertificateAuthorityServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CertificateAuthorityServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CertificateAuthorityServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CertificateAuthorityServiceStubSettings.newHttpJsonBuilder());
    }

    public CertificateAuthorityServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CertificateAuthorityServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createCertificate. */
    public UnaryCallSettings.Builder<CreateCertificateRequest, Certificate>
        createCertificateSettings() {
      return getStubSettingsBuilder().createCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to getCertificate. */
    public UnaryCallSettings.Builder<GetCertificateRequest, Certificate> getCertificateSettings() {
      return getStubSettingsBuilder().getCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to listCertificates. */
    public PagedCallSettings.Builder<
            ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
        listCertificatesSettings() {
      return getStubSettingsBuilder().listCertificatesSettings();
    }

    /** Returns the builder for the settings used for calls to revokeCertificate. */
    public UnaryCallSettings.Builder<RevokeCertificateRequest, Certificate>
        revokeCertificateSettings() {
      return getStubSettingsBuilder().revokeCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificate. */
    public UnaryCallSettings.Builder<UpdateCertificateRequest, Certificate>
        updateCertificateSettings() {
      return getStubSettingsBuilder().updateCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to activateCertificateAuthority. */
    public UnaryCallSettings.Builder<ActivateCertificateAuthorityRequest, Operation>
        activateCertificateAuthoritySettings() {
      return getStubSettingsBuilder().activateCertificateAuthoritySettings();
    }

    /** Returns the builder for the settings used for calls to activateCertificateAuthority. */
    public OperationCallSettings.Builder<
            ActivateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        activateCertificateAuthorityOperationSettings() {
      return getStubSettingsBuilder().activateCertificateAuthorityOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateAuthority. */
    public UnaryCallSettings.Builder<CreateCertificateAuthorityRequest, Operation>
        createCertificateAuthoritySettings() {
      return getStubSettingsBuilder().createCertificateAuthoritySettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateAuthority. */
    public OperationCallSettings.Builder<
            CreateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        createCertificateAuthorityOperationSettings() {
      return getStubSettingsBuilder().createCertificateAuthorityOperationSettings();
    }

    /** Returns the builder for the settings used for calls to disableCertificateAuthority. */
    public UnaryCallSettings.Builder<DisableCertificateAuthorityRequest, Operation>
        disableCertificateAuthoritySettings() {
      return getStubSettingsBuilder().disableCertificateAuthoritySettings();
    }

    /** Returns the builder for the settings used for calls to disableCertificateAuthority. */
    public OperationCallSettings.Builder<
            DisableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        disableCertificateAuthorityOperationSettings() {
      return getStubSettingsBuilder().disableCertificateAuthorityOperationSettings();
    }

    /** Returns the builder for the settings used for calls to enableCertificateAuthority. */
    public UnaryCallSettings.Builder<EnableCertificateAuthorityRequest, Operation>
        enableCertificateAuthoritySettings() {
      return getStubSettingsBuilder().enableCertificateAuthoritySettings();
    }

    /** Returns the builder for the settings used for calls to enableCertificateAuthority. */
    public OperationCallSettings.Builder<
            EnableCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        enableCertificateAuthorityOperationSettings() {
      return getStubSettingsBuilder().enableCertificateAuthorityOperationSettings();
    }

    /** Returns the builder for the settings used for calls to fetchCertificateAuthorityCsr. */
    public UnaryCallSettings.Builder<
            FetchCertificateAuthorityCsrRequest, FetchCertificateAuthorityCsrResponse>
        fetchCertificateAuthorityCsrSettings() {
      return getStubSettingsBuilder().fetchCertificateAuthorityCsrSettings();
    }

    /** Returns the builder for the settings used for calls to getCertificateAuthority. */
    public UnaryCallSettings.Builder<GetCertificateAuthorityRequest, CertificateAuthority>
        getCertificateAuthoritySettings() {
      return getStubSettingsBuilder().getCertificateAuthoritySettings();
    }

    /** Returns the builder for the settings used for calls to listCertificateAuthorities. */
    public PagedCallSettings.Builder<
            ListCertificateAuthoritiesRequest,
            ListCertificateAuthoritiesResponse,
            ListCertificateAuthoritiesPagedResponse>
        listCertificateAuthoritiesSettings() {
      return getStubSettingsBuilder().listCertificateAuthoritiesSettings();
    }

    /** Returns the builder for the settings used for calls to undeleteCertificateAuthority. */
    public UnaryCallSettings.Builder<UndeleteCertificateAuthorityRequest, Operation>
        undeleteCertificateAuthoritySettings() {
      return getStubSettingsBuilder().undeleteCertificateAuthoritySettings();
    }

    /** Returns the builder for the settings used for calls to undeleteCertificateAuthority. */
    public OperationCallSettings.Builder<
            UndeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        undeleteCertificateAuthorityOperationSettings() {
      return getStubSettingsBuilder().undeleteCertificateAuthorityOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateAuthority. */
    public UnaryCallSettings.Builder<DeleteCertificateAuthorityRequest, Operation>
        deleteCertificateAuthoritySettings() {
      return getStubSettingsBuilder().deleteCertificateAuthoritySettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateAuthority. */
    public OperationCallSettings.Builder<
            DeleteCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        deleteCertificateAuthorityOperationSettings() {
      return getStubSettingsBuilder().deleteCertificateAuthorityOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateAuthority. */
    public UnaryCallSettings.Builder<UpdateCertificateAuthorityRequest, Operation>
        updateCertificateAuthoritySettings() {
      return getStubSettingsBuilder().updateCertificateAuthoritySettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateAuthority. */
    public OperationCallSettings.Builder<
            UpdateCertificateAuthorityRequest, CertificateAuthority, OperationMetadata>
        updateCertificateAuthorityOperationSettings() {
      return getStubSettingsBuilder().updateCertificateAuthorityOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createCaPool. */
    public UnaryCallSettings.Builder<CreateCaPoolRequest, Operation> createCaPoolSettings() {
      return getStubSettingsBuilder().createCaPoolSettings();
    }

    /** Returns the builder for the settings used for calls to createCaPool. */
    public OperationCallSettings.Builder<CreateCaPoolRequest, CaPool, OperationMetadata>
        createCaPoolOperationSettings() {
      return getStubSettingsBuilder().createCaPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCaPool. */
    public UnaryCallSettings.Builder<UpdateCaPoolRequest, Operation> updateCaPoolSettings() {
      return getStubSettingsBuilder().updateCaPoolSettings();
    }

    /** Returns the builder for the settings used for calls to updateCaPool. */
    public OperationCallSettings.Builder<UpdateCaPoolRequest, CaPool, OperationMetadata>
        updateCaPoolOperationSettings() {
      return getStubSettingsBuilder().updateCaPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getCaPool. */
    public UnaryCallSettings.Builder<GetCaPoolRequest, CaPool> getCaPoolSettings() {
      return getStubSettingsBuilder().getCaPoolSettings();
    }

    /** Returns the builder for the settings used for calls to listCaPools. */
    public PagedCallSettings.Builder<
            ListCaPoolsRequest, ListCaPoolsResponse, ListCaPoolsPagedResponse>
        listCaPoolsSettings() {
      return getStubSettingsBuilder().listCaPoolsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCaPool. */
    public UnaryCallSettings.Builder<DeleteCaPoolRequest, Operation> deleteCaPoolSettings() {
      return getStubSettingsBuilder().deleteCaPoolSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCaPool. */
    public OperationCallSettings.Builder<DeleteCaPoolRequest, Empty, OperationMetadata>
        deleteCaPoolOperationSettings() {
      return getStubSettingsBuilder().deleteCaPoolOperationSettings();
    }

    /** Returns the builder for the settings used for calls to fetchCaCerts. */
    public UnaryCallSettings.Builder<FetchCaCertsRequest, FetchCaCertsResponse>
        fetchCaCertsSettings() {
      return getStubSettingsBuilder().fetchCaCertsSettings();
    }

    /** Returns the builder for the settings used for calls to getCertificateRevocationList. */
    public UnaryCallSettings.Builder<GetCertificateRevocationListRequest, CertificateRevocationList>
        getCertificateRevocationListSettings() {
      return getStubSettingsBuilder().getCertificateRevocationListSettings();
    }

    /** Returns the builder for the settings used for calls to listCertificateRevocationLists. */
    public PagedCallSettings.Builder<
            ListCertificateRevocationListsRequest,
            ListCertificateRevocationListsResponse,
            ListCertificateRevocationListsPagedResponse>
        listCertificateRevocationListsSettings() {
      return getStubSettingsBuilder().listCertificateRevocationListsSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateRevocationList. */
    public UnaryCallSettings.Builder<UpdateCertificateRevocationListRequest, Operation>
        updateCertificateRevocationListSettings() {
      return getStubSettingsBuilder().updateCertificateRevocationListSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateRevocationList. */
    public OperationCallSettings.Builder<
            UpdateCertificateRevocationListRequest, CertificateRevocationList, OperationMetadata>
        updateCertificateRevocationListOperationSettings() {
      return getStubSettingsBuilder().updateCertificateRevocationListOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateTemplate. */
    public UnaryCallSettings.Builder<CreateCertificateTemplateRequest, Operation>
        createCertificateTemplateSettings() {
      return getStubSettingsBuilder().createCertificateTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateTemplate. */
    public OperationCallSettings.Builder<
            CreateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
        createCertificateTemplateOperationSettings() {
      return getStubSettingsBuilder().createCertificateTemplateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateTemplate. */
    public UnaryCallSettings.Builder<DeleteCertificateTemplateRequest, Operation>
        deleteCertificateTemplateSettings() {
      return getStubSettingsBuilder().deleteCertificateTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateTemplate. */
    public OperationCallSettings.Builder<DeleteCertificateTemplateRequest, Empty, OperationMetadata>
        deleteCertificateTemplateOperationSettings() {
      return getStubSettingsBuilder().deleteCertificateTemplateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getCertificateTemplate. */
    public UnaryCallSettings.Builder<GetCertificateTemplateRequest, CertificateTemplate>
        getCertificateTemplateSettings() {
      return getStubSettingsBuilder().getCertificateTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listCertificateTemplates. */
    public PagedCallSettings.Builder<
            ListCertificateTemplatesRequest,
            ListCertificateTemplatesResponse,
            ListCertificateTemplatesPagedResponse>
        listCertificateTemplatesSettings() {
      return getStubSettingsBuilder().listCertificateTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateTemplate. */
    public UnaryCallSettings.Builder<UpdateCertificateTemplateRequest, Operation>
        updateCertificateTemplateSettings() {
      return getStubSettingsBuilder().updateCertificateTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateTemplate. */
    public OperationCallSettings.Builder<
            UpdateCertificateTemplateRequest, CertificateTemplate, OperationMetadata>
        updateCertificateTemplateOperationSettings() {
      return getStubSettingsBuilder().updateCertificateTemplateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public CertificateAuthorityServiceSettings build() throws IOException {
      return new CertificateAuthorityServiceSettings(this);
    }
  }
}
