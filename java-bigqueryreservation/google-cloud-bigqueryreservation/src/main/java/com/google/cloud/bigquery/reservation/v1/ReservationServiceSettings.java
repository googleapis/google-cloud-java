/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.bigquery.reservation.v1;

import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListAssignmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListCapacityCommitmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListReservationGroupsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListReservationsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.SearchAllAssignmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.SearchAssignmentsPagedResponse;

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
import com.google.cloud.bigquery.reservation.v1.stub.ReservationServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ReservationServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigqueryreservation.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createReservation:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReservationServiceSettings.Builder reservationServiceSettingsBuilder =
 *     ReservationServiceSettings.newBuilder();
 * reservationServiceSettingsBuilder
 *     .createReservationSettings()
 *     .setRetrySettings(
 *         reservationServiceSettingsBuilder
 *             .createReservationSettings()
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
 * ReservationServiceSettings reservationServiceSettings =
 *     reservationServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@Generated("by gapic-generator-java")
public class ReservationServiceSettings extends ClientSettings<ReservationServiceSettings> {

  /** Returns the object with the settings used for calls to createReservation. */
  public UnaryCallSettings<CreateReservationRequest, Reservation> createReservationSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).createReservationSettings();
  }

  /** Returns the object with the settings used for calls to listReservations. */
  public PagedCallSettings<
          ListReservationsRequest, ListReservationsResponse, ListReservationsPagedResponse>
      listReservationsSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).listReservationsSettings();
  }

  /** Returns the object with the settings used for calls to getReservation. */
  public UnaryCallSettings<GetReservationRequest, Reservation> getReservationSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).getReservationSettings();
  }

  /** Returns the object with the settings used for calls to deleteReservation. */
  public UnaryCallSettings<DeleteReservationRequest, Empty> deleteReservationSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).deleteReservationSettings();
  }

  /** Returns the object with the settings used for calls to updateReservation. */
  public UnaryCallSettings<UpdateReservationRequest, Reservation> updateReservationSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).updateReservationSettings();
  }

  /** Returns the object with the settings used for calls to failoverReservation. */
  public UnaryCallSettings<FailoverReservationRequest, Reservation> failoverReservationSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).failoverReservationSettings();
  }

  /** Returns the object with the settings used for calls to createCapacityCommitment. */
  public UnaryCallSettings<CreateCapacityCommitmentRequest, CapacityCommitment>
      createCapacityCommitmentSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).createCapacityCommitmentSettings();
  }

  /** Returns the object with the settings used for calls to listCapacityCommitments. */
  public PagedCallSettings<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          ListCapacityCommitmentsPagedResponse>
      listCapacityCommitmentsSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).listCapacityCommitmentsSettings();
  }

  /** Returns the object with the settings used for calls to getCapacityCommitment. */
  public UnaryCallSettings<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).getCapacityCommitmentSettings();
  }

  /** Returns the object with the settings used for calls to deleteCapacityCommitment. */
  public UnaryCallSettings<DeleteCapacityCommitmentRequest, Empty>
      deleteCapacityCommitmentSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).deleteCapacityCommitmentSettings();
  }

  /** Returns the object with the settings used for calls to updateCapacityCommitment. */
  public UnaryCallSettings<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).updateCapacityCommitmentSettings();
  }

  /** Returns the object with the settings used for calls to splitCapacityCommitment. */
  public UnaryCallSettings<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).splitCapacityCommitmentSettings();
  }

  /** Returns the object with the settings used for calls to mergeCapacityCommitments. */
  public UnaryCallSettings<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).mergeCapacityCommitmentsSettings();
  }

  /** Returns the object with the settings used for calls to createAssignment. */
  public UnaryCallSettings<CreateAssignmentRequest, Assignment> createAssignmentSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).createAssignmentSettings();
  }

  /** Returns the object with the settings used for calls to listAssignments. */
  public PagedCallSettings<
          ListAssignmentsRequest, ListAssignmentsResponse, ListAssignmentsPagedResponse>
      listAssignmentsSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).listAssignmentsSettings();
  }

  /** Returns the object with the settings used for calls to deleteAssignment. */
  public UnaryCallSettings<DeleteAssignmentRequest, Empty> deleteAssignmentSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).deleteAssignmentSettings();
  }

  /**
   * Returns the object with the settings used for calls to searchAssignments.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public PagedCallSettings<
          SearchAssignmentsRequest, SearchAssignmentsResponse, SearchAssignmentsPagedResponse>
      searchAssignmentsSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).searchAssignmentsSettings();
  }

  /** Returns the object with the settings used for calls to searchAllAssignments. */
  public PagedCallSettings<
          SearchAllAssignmentsRequest,
          SearchAllAssignmentsResponse,
          SearchAllAssignmentsPagedResponse>
      searchAllAssignmentsSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).searchAllAssignmentsSettings();
  }

  /** Returns the object with the settings used for calls to moveAssignment. */
  public UnaryCallSettings<MoveAssignmentRequest, Assignment> moveAssignmentSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).moveAssignmentSettings();
  }

  /** Returns the object with the settings used for calls to updateAssignment. */
  public UnaryCallSettings<UpdateAssignmentRequest, Assignment> updateAssignmentSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).updateAssignmentSettings();
  }

  /** Returns the object with the settings used for calls to getBiReservation. */
  public UnaryCallSettings<GetBiReservationRequest, BiReservation> getBiReservationSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).getBiReservationSettings();
  }

  /** Returns the object with the settings used for calls to updateBiReservation. */
  public UnaryCallSettings<UpdateBiReservationRequest, BiReservation>
      updateBiReservationSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).updateBiReservationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to createReservationGroup. */
  public UnaryCallSettings<CreateReservationGroupRequest, ReservationGroup>
      createReservationGroupSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).createReservationGroupSettings();
  }

  /** Returns the object with the settings used for calls to getReservationGroup. */
  public UnaryCallSettings<GetReservationGroupRequest, ReservationGroup>
      getReservationGroupSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).getReservationGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteReservationGroup. */
  public UnaryCallSettings<DeleteReservationGroupRequest, Empty> deleteReservationGroupSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).deleteReservationGroupSettings();
  }

  /** Returns the object with the settings used for calls to listReservationGroups. */
  public PagedCallSettings<
          ListReservationGroupsRequest,
          ListReservationGroupsResponse,
          ListReservationGroupsPagedResponse>
      listReservationGroupsSettings() {
    return ((ReservationServiceStubSettings) getStubSettings()).listReservationGroupsSettings();
  }

  public static final ReservationServiceSettings create(ReservationServiceStubSettings stub)
      throws IOException {
    return new ReservationServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ReservationServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ReservationServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ReservationServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ReservationServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ReservationServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ReservationServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ReservationServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ReservationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ReservationServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ReservationServiceSettings. */
  public static class Builder extends ClientSettings.Builder<ReservationServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ReservationServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ReservationServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ReservationServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ReservationServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ReservationServiceStubSettings.newHttpJsonBuilder());
    }

    public ReservationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ReservationServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to createReservation. */
    public UnaryCallSettings.Builder<CreateReservationRequest, Reservation>
        createReservationSettings() {
      return getStubSettingsBuilder().createReservationSettings();
    }

    /** Returns the builder for the settings used for calls to listReservations. */
    public PagedCallSettings.Builder<
            ListReservationsRequest, ListReservationsResponse, ListReservationsPagedResponse>
        listReservationsSettings() {
      return getStubSettingsBuilder().listReservationsSettings();
    }

    /** Returns the builder for the settings used for calls to getReservation. */
    public UnaryCallSettings.Builder<GetReservationRequest, Reservation> getReservationSettings() {
      return getStubSettingsBuilder().getReservationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReservation. */
    public UnaryCallSettings.Builder<DeleteReservationRequest, Empty> deleteReservationSettings() {
      return getStubSettingsBuilder().deleteReservationSettings();
    }

    /** Returns the builder for the settings used for calls to updateReservation. */
    public UnaryCallSettings.Builder<UpdateReservationRequest, Reservation>
        updateReservationSettings() {
      return getStubSettingsBuilder().updateReservationSettings();
    }

    /** Returns the builder for the settings used for calls to failoverReservation. */
    public UnaryCallSettings.Builder<FailoverReservationRequest, Reservation>
        failoverReservationSettings() {
      return getStubSettingsBuilder().failoverReservationSettings();
    }

    /** Returns the builder for the settings used for calls to createCapacityCommitment. */
    public UnaryCallSettings.Builder<CreateCapacityCommitmentRequest, CapacityCommitment>
        createCapacityCommitmentSettings() {
      return getStubSettingsBuilder().createCapacityCommitmentSettings();
    }

    /** Returns the builder for the settings used for calls to listCapacityCommitments. */
    public PagedCallSettings.Builder<
            ListCapacityCommitmentsRequest,
            ListCapacityCommitmentsResponse,
            ListCapacityCommitmentsPagedResponse>
        listCapacityCommitmentsSettings() {
      return getStubSettingsBuilder().listCapacityCommitmentsSettings();
    }

    /** Returns the builder for the settings used for calls to getCapacityCommitment. */
    public UnaryCallSettings.Builder<GetCapacityCommitmentRequest, CapacityCommitment>
        getCapacityCommitmentSettings() {
      return getStubSettingsBuilder().getCapacityCommitmentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCapacityCommitment. */
    public UnaryCallSettings.Builder<DeleteCapacityCommitmentRequest, Empty>
        deleteCapacityCommitmentSettings() {
      return getStubSettingsBuilder().deleteCapacityCommitmentSettings();
    }

    /** Returns the builder for the settings used for calls to updateCapacityCommitment. */
    public UnaryCallSettings.Builder<UpdateCapacityCommitmentRequest, CapacityCommitment>
        updateCapacityCommitmentSettings() {
      return getStubSettingsBuilder().updateCapacityCommitmentSettings();
    }

    /** Returns the builder for the settings used for calls to splitCapacityCommitment. */
    public UnaryCallSettings.Builder<
            SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
        splitCapacityCommitmentSettings() {
      return getStubSettingsBuilder().splitCapacityCommitmentSettings();
    }

    /** Returns the builder for the settings used for calls to mergeCapacityCommitments. */
    public UnaryCallSettings.Builder<MergeCapacityCommitmentsRequest, CapacityCommitment>
        mergeCapacityCommitmentsSettings() {
      return getStubSettingsBuilder().mergeCapacityCommitmentsSettings();
    }

    /** Returns the builder for the settings used for calls to createAssignment. */
    public UnaryCallSettings.Builder<CreateAssignmentRequest, Assignment>
        createAssignmentSettings() {
      return getStubSettingsBuilder().createAssignmentSettings();
    }

    /** Returns the builder for the settings used for calls to listAssignments. */
    public PagedCallSettings.Builder<
            ListAssignmentsRequest, ListAssignmentsResponse, ListAssignmentsPagedResponse>
        listAssignmentsSettings() {
      return getStubSettingsBuilder().listAssignmentsSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAssignment. */
    public UnaryCallSettings.Builder<DeleteAssignmentRequest, Empty> deleteAssignmentSettings() {
      return getStubSettingsBuilder().deleteAssignmentSettings();
    }

    /**
     * Returns the builder for the settings used for calls to searchAssignments.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public PagedCallSettings.Builder<
            SearchAssignmentsRequest, SearchAssignmentsResponse, SearchAssignmentsPagedResponse>
        searchAssignmentsSettings() {
      return getStubSettingsBuilder().searchAssignmentsSettings();
    }

    /** Returns the builder for the settings used for calls to searchAllAssignments. */
    public PagedCallSettings.Builder<
            SearchAllAssignmentsRequest,
            SearchAllAssignmentsResponse,
            SearchAllAssignmentsPagedResponse>
        searchAllAssignmentsSettings() {
      return getStubSettingsBuilder().searchAllAssignmentsSettings();
    }

    /** Returns the builder for the settings used for calls to moveAssignment. */
    public UnaryCallSettings.Builder<MoveAssignmentRequest, Assignment> moveAssignmentSettings() {
      return getStubSettingsBuilder().moveAssignmentSettings();
    }

    /** Returns the builder for the settings used for calls to updateAssignment. */
    public UnaryCallSettings.Builder<UpdateAssignmentRequest, Assignment>
        updateAssignmentSettings() {
      return getStubSettingsBuilder().updateAssignmentSettings();
    }

    /** Returns the builder for the settings used for calls to getBiReservation. */
    public UnaryCallSettings.Builder<GetBiReservationRequest, BiReservation>
        getBiReservationSettings() {
      return getStubSettingsBuilder().getBiReservationSettings();
    }

    /** Returns the builder for the settings used for calls to updateBiReservation. */
    public UnaryCallSettings.Builder<UpdateBiReservationRequest, BiReservation>
        updateBiReservationSettings() {
      return getStubSettingsBuilder().updateBiReservationSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to createReservationGroup. */
    public UnaryCallSettings.Builder<CreateReservationGroupRequest, ReservationGroup>
        createReservationGroupSettings() {
      return getStubSettingsBuilder().createReservationGroupSettings();
    }

    /** Returns the builder for the settings used for calls to getReservationGroup. */
    public UnaryCallSettings.Builder<GetReservationGroupRequest, ReservationGroup>
        getReservationGroupSettings() {
      return getStubSettingsBuilder().getReservationGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteReservationGroup. */
    public UnaryCallSettings.Builder<DeleteReservationGroupRequest, Empty>
        deleteReservationGroupSettings() {
      return getStubSettingsBuilder().deleteReservationGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listReservationGroups. */
    public PagedCallSettings.Builder<
            ListReservationGroupsRequest,
            ListReservationGroupsResponse,
            ListReservationGroupsPagedResponse>
        listReservationGroupsSettings() {
      return getStubSettingsBuilder().listReservationGroupsSettings();
    }

    @Override
    public ReservationServiceSettings build() throws IOException {
      return new ReservationServiceSettings(this);
    }
  }
}
