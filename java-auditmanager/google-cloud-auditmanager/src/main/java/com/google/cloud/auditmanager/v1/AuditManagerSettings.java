/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.auditmanager.v1;

import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListAuditReportsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListControlsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.auditmanager.v1.AuditManagerClient.ListResourceEnrollmentStatusesPagedResponse;

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
import com.google.cloud.auditmanager.v1.stub.AuditManagerStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AuditManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (auditmanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of enrollResource:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuditManagerSettings.Builder auditManagerSettingsBuilder = AuditManagerSettings.newBuilder();
 * auditManagerSettingsBuilder
 *     .enrollResourceSettings()
 *     .setRetrySettings(
 *         auditManagerSettingsBuilder
 *             .enrollResourceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * AuditManagerSettings auditManagerSettings = auditManagerSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for generateAuditReport:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AuditManagerSettings.Builder auditManagerSettingsBuilder = AuditManagerSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * auditManagerSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AuditManagerSettings extends ClientSettings<AuditManagerSettings> {

  /** Returns the object with the settings used for calls to enrollResource. */
  public UnaryCallSettings<EnrollResourceRequest, Enrollment> enrollResourceSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).enrollResourceSettings();
  }

  /** Returns the object with the settings used for calls to generateAuditScopeReport. */
  public UnaryCallSettings<GenerateAuditScopeReportRequest, AuditScopeReport>
      generateAuditScopeReportSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).generateAuditScopeReportSettings();
  }

  /** Returns the object with the settings used for calls to generateAuditReport. */
  public UnaryCallSettings<GenerateAuditReportRequest, Operation> generateAuditReportSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).generateAuditReportSettings();
  }

  /** Returns the object with the settings used for calls to generateAuditReport. */
  public OperationCallSettings<GenerateAuditReportRequest, AuditReport, OperationMetadata>
      generateAuditReportOperationSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).generateAuditReportOperationSettings();
  }

  /** Returns the object with the settings used for calls to listAuditReports. */
  public PagedCallSettings<
          ListAuditReportsRequest, ListAuditReportsResponse, ListAuditReportsPagedResponse>
      listAuditReportsSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).listAuditReportsSettings();
  }

  /** Returns the object with the settings used for calls to getAuditReport. */
  public UnaryCallSettings<GetAuditReportRequest, AuditReport> getAuditReportSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).getAuditReportSettings();
  }

  /** Returns the object with the settings used for calls to getResourceEnrollmentStatus. */
  public UnaryCallSettings<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
      getResourceEnrollmentStatusSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).getResourceEnrollmentStatusSettings();
  }

  /** Returns the object with the settings used for calls to listResourceEnrollmentStatuses. */
  public PagedCallSettings<
          ListResourceEnrollmentStatusesRequest,
          ListResourceEnrollmentStatusesResponse,
          ListResourceEnrollmentStatusesPagedResponse>
      listResourceEnrollmentStatusesSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).listResourceEnrollmentStatusesSettings();
  }

  /** Returns the object with the settings used for calls to listControls. */
  public PagedCallSettings<ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
      listControlsSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).listControlsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((AuditManagerStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final AuditManagerSettings create(AuditManagerStubSettings stub)
      throws IOException {
    return new AuditManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AuditManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AuditManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AuditManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AuditManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AuditManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AuditManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AuditManagerStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AuditManagerStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected AuditManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AuditManagerSettings. */
  public static class Builder extends ClientSettings.Builder<AuditManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AuditManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(AuditManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AuditManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AuditManagerStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AuditManagerStubSettings.newHttpJsonBuilder());
    }

    public AuditManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((AuditManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to enrollResource. */
    public UnaryCallSettings.Builder<EnrollResourceRequest, Enrollment> enrollResourceSettings() {
      return getStubSettingsBuilder().enrollResourceSettings();
    }

    /** Returns the builder for the settings used for calls to generateAuditScopeReport. */
    public UnaryCallSettings.Builder<GenerateAuditScopeReportRequest, AuditScopeReport>
        generateAuditScopeReportSettings() {
      return getStubSettingsBuilder().generateAuditScopeReportSettings();
    }

    /** Returns the builder for the settings used for calls to generateAuditReport. */
    public UnaryCallSettings.Builder<GenerateAuditReportRequest, Operation>
        generateAuditReportSettings() {
      return getStubSettingsBuilder().generateAuditReportSettings();
    }

    /** Returns the builder for the settings used for calls to generateAuditReport. */
    public OperationCallSettings.Builder<GenerateAuditReportRequest, AuditReport, OperationMetadata>
        generateAuditReportOperationSettings() {
      return getStubSettingsBuilder().generateAuditReportOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listAuditReports. */
    public PagedCallSettings.Builder<
            ListAuditReportsRequest, ListAuditReportsResponse, ListAuditReportsPagedResponse>
        listAuditReportsSettings() {
      return getStubSettingsBuilder().listAuditReportsSettings();
    }

    /** Returns the builder for the settings used for calls to getAuditReport. */
    public UnaryCallSettings.Builder<GetAuditReportRequest, AuditReport> getAuditReportSettings() {
      return getStubSettingsBuilder().getAuditReportSettings();
    }

    /** Returns the builder for the settings used for calls to getResourceEnrollmentStatus. */
    public UnaryCallSettings.Builder<GetResourceEnrollmentStatusRequest, ResourceEnrollmentStatus>
        getResourceEnrollmentStatusSettings() {
      return getStubSettingsBuilder().getResourceEnrollmentStatusSettings();
    }

    /** Returns the builder for the settings used for calls to listResourceEnrollmentStatuses. */
    public PagedCallSettings.Builder<
            ListResourceEnrollmentStatusesRequest,
            ListResourceEnrollmentStatusesResponse,
            ListResourceEnrollmentStatusesPagedResponse>
        listResourceEnrollmentStatusesSettings() {
      return getStubSettingsBuilder().listResourceEnrollmentStatusesSettings();
    }

    /** Returns the builder for the settings used for calls to listControls. */
    public PagedCallSettings.Builder<
            ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
        listControlsSettings() {
      return getStubSettingsBuilder().listControlsSettings();
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
    public AuditManagerSettings build() throws IOException {
      return new AuditManagerSettings(this);
    }
  }
}
