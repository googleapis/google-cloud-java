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

package com.google.cloud.certificatemanager.v1;

import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateIssuanceConfigsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateMapEntriesPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificateMapsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListCertificatesPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListDnsAuthorizationsPagedResponse;
import static com.google.cloud.certificatemanager.v1.CertificateManagerClient.ListLocationsPagedResponse;

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
import com.google.cloud.certificatemanager.v1.stub.CertificateManagerStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CertificateManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (certificatemanager.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCertificate to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CertificateManagerSettings.Builder certificateManagerSettingsBuilder =
 *     CertificateManagerSettings.newBuilder();
 * certificateManagerSettingsBuilder
 *     .getCertificateSettings()
 *     .setRetrySettings(
 *         certificateManagerSettingsBuilder
 *             .getCertificateSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CertificateManagerSettings certificateManagerSettings =
 *     certificateManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CertificateManagerSettings extends ClientSettings<CertificateManagerSettings> {

  /** Returns the object with the settings used for calls to listCertificates. */
  public PagedCallSettings<
          ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
      listCertificatesSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).listCertificatesSettings();
  }

  /** Returns the object with the settings used for calls to getCertificate. */
  public UnaryCallSettings<GetCertificateRequest, Certificate> getCertificateSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).getCertificateSettings();
  }

  /** Returns the object with the settings used for calls to createCertificate. */
  public UnaryCallSettings<CreateCertificateRequest, Operation> createCertificateSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).createCertificateSettings();
  }

  /** Returns the object with the settings used for calls to createCertificate. */
  public OperationCallSettings<CreateCertificateRequest, Certificate, OperationMetadata>
      createCertificateOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .createCertificateOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificate. */
  public UnaryCallSettings<UpdateCertificateRequest, Operation> updateCertificateSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).updateCertificateSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificate. */
  public OperationCallSettings<UpdateCertificateRequest, Certificate, OperationMetadata>
      updateCertificateOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .updateCertificateOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificate. */
  public UnaryCallSettings<DeleteCertificateRequest, Operation> deleteCertificateSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).deleteCertificateSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificate. */
  public OperationCallSettings<DeleteCertificateRequest, Empty, OperationMetadata>
      deleteCertificateOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .deleteCertificateOperationSettings();
  }

  /** Returns the object with the settings used for calls to listCertificateMaps. */
  public PagedCallSettings<
          ListCertificateMapsRequest, ListCertificateMapsResponse, ListCertificateMapsPagedResponse>
      listCertificateMapsSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).listCertificateMapsSettings();
  }

  /** Returns the object with the settings used for calls to getCertificateMap. */
  public UnaryCallSettings<GetCertificateMapRequest, CertificateMap> getCertificateMapSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).getCertificateMapSettings();
  }

  /** Returns the object with the settings used for calls to createCertificateMap. */
  public UnaryCallSettings<CreateCertificateMapRequest, Operation> createCertificateMapSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).createCertificateMapSettings();
  }

  /** Returns the object with the settings used for calls to createCertificateMap. */
  public OperationCallSettings<CreateCertificateMapRequest, CertificateMap, OperationMetadata>
      createCertificateMapOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .createCertificateMapOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateMap. */
  public UnaryCallSettings<UpdateCertificateMapRequest, Operation> updateCertificateMapSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).updateCertificateMapSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateMap. */
  public OperationCallSettings<UpdateCertificateMapRequest, CertificateMap, OperationMetadata>
      updateCertificateMapOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .updateCertificateMapOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateMap. */
  public UnaryCallSettings<DeleteCertificateMapRequest, Operation> deleteCertificateMapSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).deleteCertificateMapSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateMap. */
  public OperationCallSettings<DeleteCertificateMapRequest, Empty, OperationMetadata>
      deleteCertificateMapOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .deleteCertificateMapOperationSettings();
  }

  /** Returns the object with the settings used for calls to listCertificateMapEntries. */
  public PagedCallSettings<
          ListCertificateMapEntriesRequest,
          ListCertificateMapEntriesResponse,
          ListCertificateMapEntriesPagedResponse>
      listCertificateMapEntriesSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).listCertificateMapEntriesSettings();
  }

  /** Returns the object with the settings used for calls to getCertificateMapEntry. */
  public UnaryCallSettings<GetCertificateMapEntryRequest, CertificateMapEntry>
      getCertificateMapEntrySettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).getCertificateMapEntrySettings();
  }

  /** Returns the object with the settings used for calls to createCertificateMapEntry. */
  public UnaryCallSettings<CreateCertificateMapEntryRequest, Operation>
      createCertificateMapEntrySettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).createCertificateMapEntrySettings();
  }

  /** Returns the object with the settings used for calls to createCertificateMapEntry. */
  public OperationCallSettings<
          CreateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      createCertificateMapEntryOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .createCertificateMapEntryOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateMapEntry. */
  public UnaryCallSettings<UpdateCertificateMapEntryRequest, Operation>
      updateCertificateMapEntrySettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).updateCertificateMapEntrySettings();
  }

  /** Returns the object with the settings used for calls to updateCertificateMapEntry. */
  public OperationCallSettings<
          UpdateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
      updateCertificateMapEntryOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .updateCertificateMapEntryOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateMapEntry. */
  public UnaryCallSettings<DeleteCertificateMapEntryRequest, Operation>
      deleteCertificateMapEntrySettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).deleteCertificateMapEntrySettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateMapEntry. */
  public OperationCallSettings<DeleteCertificateMapEntryRequest, Empty, OperationMetadata>
      deleteCertificateMapEntryOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .deleteCertificateMapEntryOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDnsAuthorizations. */
  public PagedCallSettings<
          ListDnsAuthorizationsRequest,
          ListDnsAuthorizationsResponse,
          ListDnsAuthorizationsPagedResponse>
      listDnsAuthorizationsSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).listDnsAuthorizationsSettings();
  }

  /** Returns the object with the settings used for calls to getDnsAuthorization. */
  public UnaryCallSettings<GetDnsAuthorizationRequest, DnsAuthorization>
      getDnsAuthorizationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).getDnsAuthorizationSettings();
  }

  /** Returns the object with the settings used for calls to createDnsAuthorization. */
  public UnaryCallSettings<CreateDnsAuthorizationRequest, Operation>
      createDnsAuthorizationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).createDnsAuthorizationSettings();
  }

  /** Returns the object with the settings used for calls to createDnsAuthorization. */
  public OperationCallSettings<CreateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      createDnsAuthorizationOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .createDnsAuthorizationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDnsAuthorization. */
  public UnaryCallSettings<UpdateDnsAuthorizationRequest, Operation>
      updateDnsAuthorizationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).updateDnsAuthorizationSettings();
  }

  /** Returns the object with the settings used for calls to updateDnsAuthorization. */
  public OperationCallSettings<UpdateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
      updateDnsAuthorizationOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .updateDnsAuthorizationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDnsAuthorization. */
  public UnaryCallSettings<DeleteDnsAuthorizationRequest, Operation>
      deleteDnsAuthorizationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).deleteDnsAuthorizationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDnsAuthorization. */
  public OperationCallSettings<DeleteDnsAuthorizationRequest, Empty, OperationMetadata>
      deleteDnsAuthorizationOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .deleteDnsAuthorizationOperationSettings();
  }

  /** Returns the object with the settings used for calls to listCertificateIssuanceConfigs. */
  public PagedCallSettings<
          ListCertificateIssuanceConfigsRequest,
          ListCertificateIssuanceConfigsResponse,
          ListCertificateIssuanceConfigsPagedResponse>
      listCertificateIssuanceConfigsSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .listCertificateIssuanceConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getCertificateIssuanceConfig. */
  public UnaryCallSettings<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
      getCertificateIssuanceConfigSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .getCertificateIssuanceConfigSettings();
  }

  /** Returns the object with the settings used for calls to createCertificateIssuanceConfig. */
  public UnaryCallSettings<CreateCertificateIssuanceConfigRequest, Operation>
      createCertificateIssuanceConfigSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .createCertificateIssuanceConfigSettings();
  }

  /** Returns the object with the settings used for calls to createCertificateIssuanceConfig. */
  public OperationCallSettings<
          CreateCertificateIssuanceConfigRequest, CertificateIssuanceConfig, OperationMetadata>
      createCertificateIssuanceConfigOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .createCertificateIssuanceConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateIssuanceConfig. */
  public UnaryCallSettings<DeleteCertificateIssuanceConfigRequest, Operation>
      deleteCertificateIssuanceConfigSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .deleteCertificateIssuanceConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteCertificateIssuanceConfig. */
  public OperationCallSettings<DeleteCertificateIssuanceConfigRequest, Empty, OperationMetadata>
      deleteCertificateIssuanceConfigOperationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings())
        .deleteCertificateIssuanceConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((CertificateManagerStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final CertificateManagerSettings create(CertificateManagerStubSettings stub)
      throws IOException {
    return new CertificateManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CertificateManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CertificateManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CertificateManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CertificateManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CertificateManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CertificateManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CertificateManagerStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CertificateManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CertificateManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CertificateManagerSettings. */
  public static class Builder extends ClientSettings.Builder<CertificateManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CertificateManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(CertificateManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CertificateManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CertificateManagerStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CertificateManagerStubSettings.newHttpJsonBuilder());
    }

    public CertificateManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((CertificateManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listCertificates. */
    public PagedCallSettings.Builder<
            ListCertificatesRequest, ListCertificatesResponse, ListCertificatesPagedResponse>
        listCertificatesSettings() {
      return getStubSettingsBuilder().listCertificatesSettings();
    }

    /** Returns the builder for the settings used for calls to getCertificate. */
    public UnaryCallSettings.Builder<GetCertificateRequest, Certificate> getCertificateSettings() {
      return getStubSettingsBuilder().getCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to createCertificate. */
    public UnaryCallSettings.Builder<CreateCertificateRequest, Operation>
        createCertificateSettings() {
      return getStubSettingsBuilder().createCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to createCertificate. */
    public OperationCallSettings.Builder<CreateCertificateRequest, Certificate, OperationMetadata>
        createCertificateOperationSettings() {
      return getStubSettingsBuilder().createCertificateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificate. */
    public UnaryCallSettings.Builder<UpdateCertificateRequest, Operation>
        updateCertificateSettings() {
      return getStubSettingsBuilder().updateCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificate. */
    public OperationCallSettings.Builder<UpdateCertificateRequest, Certificate, OperationMetadata>
        updateCertificateOperationSettings() {
      return getStubSettingsBuilder().updateCertificateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificate. */
    public UnaryCallSettings.Builder<DeleteCertificateRequest, Operation>
        deleteCertificateSettings() {
      return getStubSettingsBuilder().deleteCertificateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificate. */
    public OperationCallSettings.Builder<DeleteCertificateRequest, Empty, OperationMetadata>
        deleteCertificateOperationSettings() {
      return getStubSettingsBuilder().deleteCertificateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listCertificateMaps. */
    public PagedCallSettings.Builder<
            ListCertificateMapsRequest,
            ListCertificateMapsResponse,
            ListCertificateMapsPagedResponse>
        listCertificateMapsSettings() {
      return getStubSettingsBuilder().listCertificateMapsSettings();
    }

    /** Returns the builder for the settings used for calls to getCertificateMap. */
    public UnaryCallSettings.Builder<GetCertificateMapRequest, CertificateMap>
        getCertificateMapSettings() {
      return getStubSettingsBuilder().getCertificateMapSettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateMap. */
    public UnaryCallSettings.Builder<CreateCertificateMapRequest, Operation>
        createCertificateMapSettings() {
      return getStubSettingsBuilder().createCertificateMapSettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateMap. */
    public OperationCallSettings.Builder<
            CreateCertificateMapRequest, CertificateMap, OperationMetadata>
        createCertificateMapOperationSettings() {
      return getStubSettingsBuilder().createCertificateMapOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateMap. */
    public UnaryCallSettings.Builder<UpdateCertificateMapRequest, Operation>
        updateCertificateMapSettings() {
      return getStubSettingsBuilder().updateCertificateMapSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateMap. */
    public OperationCallSettings.Builder<
            UpdateCertificateMapRequest, CertificateMap, OperationMetadata>
        updateCertificateMapOperationSettings() {
      return getStubSettingsBuilder().updateCertificateMapOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateMap. */
    public UnaryCallSettings.Builder<DeleteCertificateMapRequest, Operation>
        deleteCertificateMapSettings() {
      return getStubSettingsBuilder().deleteCertificateMapSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateMap. */
    public OperationCallSettings.Builder<DeleteCertificateMapRequest, Empty, OperationMetadata>
        deleteCertificateMapOperationSettings() {
      return getStubSettingsBuilder().deleteCertificateMapOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listCertificateMapEntries. */
    public PagedCallSettings.Builder<
            ListCertificateMapEntriesRequest,
            ListCertificateMapEntriesResponse,
            ListCertificateMapEntriesPagedResponse>
        listCertificateMapEntriesSettings() {
      return getStubSettingsBuilder().listCertificateMapEntriesSettings();
    }

    /** Returns the builder for the settings used for calls to getCertificateMapEntry. */
    public UnaryCallSettings.Builder<GetCertificateMapEntryRequest, CertificateMapEntry>
        getCertificateMapEntrySettings() {
      return getStubSettingsBuilder().getCertificateMapEntrySettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateMapEntry. */
    public UnaryCallSettings.Builder<CreateCertificateMapEntryRequest, Operation>
        createCertificateMapEntrySettings() {
      return getStubSettingsBuilder().createCertificateMapEntrySettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateMapEntry. */
    public OperationCallSettings.Builder<
            CreateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
        createCertificateMapEntryOperationSettings() {
      return getStubSettingsBuilder().createCertificateMapEntryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateMapEntry. */
    public UnaryCallSettings.Builder<UpdateCertificateMapEntryRequest, Operation>
        updateCertificateMapEntrySettings() {
      return getStubSettingsBuilder().updateCertificateMapEntrySettings();
    }

    /** Returns the builder for the settings used for calls to updateCertificateMapEntry. */
    public OperationCallSettings.Builder<
            UpdateCertificateMapEntryRequest, CertificateMapEntry, OperationMetadata>
        updateCertificateMapEntryOperationSettings() {
      return getStubSettingsBuilder().updateCertificateMapEntryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateMapEntry. */
    public UnaryCallSettings.Builder<DeleteCertificateMapEntryRequest, Operation>
        deleteCertificateMapEntrySettings() {
      return getStubSettingsBuilder().deleteCertificateMapEntrySettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateMapEntry. */
    public OperationCallSettings.Builder<DeleteCertificateMapEntryRequest, Empty, OperationMetadata>
        deleteCertificateMapEntryOperationSettings() {
      return getStubSettingsBuilder().deleteCertificateMapEntryOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDnsAuthorizations. */
    public PagedCallSettings.Builder<
            ListDnsAuthorizationsRequest,
            ListDnsAuthorizationsResponse,
            ListDnsAuthorizationsPagedResponse>
        listDnsAuthorizationsSettings() {
      return getStubSettingsBuilder().listDnsAuthorizationsSettings();
    }

    /** Returns the builder for the settings used for calls to getDnsAuthorization. */
    public UnaryCallSettings.Builder<GetDnsAuthorizationRequest, DnsAuthorization>
        getDnsAuthorizationSettings() {
      return getStubSettingsBuilder().getDnsAuthorizationSettings();
    }

    /** Returns the builder for the settings used for calls to createDnsAuthorization. */
    public UnaryCallSettings.Builder<CreateDnsAuthorizationRequest, Operation>
        createDnsAuthorizationSettings() {
      return getStubSettingsBuilder().createDnsAuthorizationSettings();
    }

    /** Returns the builder for the settings used for calls to createDnsAuthorization. */
    public OperationCallSettings.Builder<
            CreateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
        createDnsAuthorizationOperationSettings() {
      return getStubSettingsBuilder().createDnsAuthorizationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDnsAuthorization. */
    public UnaryCallSettings.Builder<UpdateDnsAuthorizationRequest, Operation>
        updateDnsAuthorizationSettings() {
      return getStubSettingsBuilder().updateDnsAuthorizationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDnsAuthorization. */
    public OperationCallSettings.Builder<
            UpdateDnsAuthorizationRequest, DnsAuthorization, OperationMetadata>
        updateDnsAuthorizationOperationSettings() {
      return getStubSettingsBuilder().updateDnsAuthorizationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDnsAuthorization. */
    public UnaryCallSettings.Builder<DeleteDnsAuthorizationRequest, Operation>
        deleteDnsAuthorizationSettings() {
      return getStubSettingsBuilder().deleteDnsAuthorizationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDnsAuthorization. */
    public OperationCallSettings.Builder<DeleteDnsAuthorizationRequest, Empty, OperationMetadata>
        deleteDnsAuthorizationOperationSettings() {
      return getStubSettingsBuilder().deleteDnsAuthorizationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listCertificateIssuanceConfigs. */
    public PagedCallSettings.Builder<
            ListCertificateIssuanceConfigsRequest,
            ListCertificateIssuanceConfigsResponse,
            ListCertificateIssuanceConfigsPagedResponse>
        listCertificateIssuanceConfigsSettings() {
      return getStubSettingsBuilder().listCertificateIssuanceConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getCertificateIssuanceConfig. */
    public UnaryCallSettings.Builder<GetCertificateIssuanceConfigRequest, CertificateIssuanceConfig>
        getCertificateIssuanceConfigSettings() {
      return getStubSettingsBuilder().getCertificateIssuanceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateIssuanceConfig. */
    public UnaryCallSettings.Builder<CreateCertificateIssuanceConfigRequest, Operation>
        createCertificateIssuanceConfigSettings() {
      return getStubSettingsBuilder().createCertificateIssuanceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createCertificateIssuanceConfig. */
    public OperationCallSettings.Builder<
            CreateCertificateIssuanceConfigRequest, CertificateIssuanceConfig, OperationMetadata>
        createCertificateIssuanceConfigOperationSettings() {
      return getStubSettingsBuilder().createCertificateIssuanceConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateIssuanceConfig. */
    public UnaryCallSettings.Builder<DeleteCertificateIssuanceConfigRequest, Operation>
        deleteCertificateIssuanceConfigSettings() {
      return getStubSettingsBuilder().deleteCertificateIssuanceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCertificateIssuanceConfig. */
    public OperationCallSettings.Builder<
            DeleteCertificateIssuanceConfigRequest, Empty, OperationMetadata>
        deleteCertificateIssuanceConfigOperationSettings() {
      return getStubSettingsBuilder().deleteCertificateIssuanceConfigOperationSettings();
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

    @Override
    public CertificateManagerSettings build() throws IOException {
      return new CertificateManagerSettings(this);
    }
  }
}
