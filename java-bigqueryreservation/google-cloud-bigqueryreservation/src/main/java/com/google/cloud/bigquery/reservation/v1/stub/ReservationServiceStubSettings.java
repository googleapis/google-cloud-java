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

package com.google.cloud.bigquery.reservation.v1.stub;

import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListAssignmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListCapacityCommitmentsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.ListReservationsPagedResponse;
import static com.google.cloud.bigquery.reservation.v1.ReservationServiceClient.SearchAssignmentsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.reservation.v1.Assignment;
import com.google.cloud.bigquery.reservation.v1.BiReservation;
import com.google.cloud.bigquery.reservation.v1.CapacityCommitment;
import com.google.cloud.bigquery.reservation.v1.CreateAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.CreateCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.CreateReservationRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.DeleteReservationRequest;
import com.google.cloud.bigquery.reservation.v1.GetBiReservationRequest;
import com.google.cloud.bigquery.reservation.v1.GetCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.GetReservationRequest;
import com.google.cloud.bigquery.reservation.v1.ListAssignmentsRequest;
import com.google.cloud.bigquery.reservation.v1.ListAssignmentsResponse;
import com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsRequest;
import com.google.cloud.bigquery.reservation.v1.ListCapacityCommitmentsResponse;
import com.google.cloud.bigquery.reservation.v1.ListReservationsRequest;
import com.google.cloud.bigquery.reservation.v1.ListReservationsResponse;
import com.google.cloud.bigquery.reservation.v1.MergeCapacityCommitmentsRequest;
import com.google.cloud.bigquery.reservation.v1.MoveAssignmentRequest;
import com.google.cloud.bigquery.reservation.v1.Reservation;
import com.google.cloud.bigquery.reservation.v1.SearchAssignmentsRequest;
import com.google.cloud.bigquery.reservation.v1.SearchAssignmentsResponse;
import com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.SplitCapacityCommitmentResponse;
import com.google.cloud.bigquery.reservation.v1.UpdateBiReservationRequest;
import com.google.cloud.bigquery.reservation.v1.UpdateCapacityCommitmentRequest;
import com.google.cloud.bigquery.reservation.v1.UpdateReservationRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ReservationServiceStub}.
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
 * <p>For example, to set the total timeout of createReservation to 30 seconds:
 *
 * <pre>{@code
 * ReservationServiceStubSettings.Builder reservationServiceSettingsBuilder =
 *     ReservationServiceStubSettings.newBuilder();
 * reservationServiceSettingsBuilder
 *     .createReservationSettings()
 *     .setRetrySettings(
 *         reservationServiceSettingsBuilder
 *             .createReservationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ReservationServiceStubSettings reservationServiceSettings =
 *     reservationServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ReservationServiceStubSettings extends StubSettings<ReservationServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<CreateReservationRequest, Reservation> createReservationSettings;
  private final PagedCallSettings<
          ListReservationsRequest, ListReservationsResponse, ListReservationsPagedResponse>
      listReservationsSettings;
  private final UnaryCallSettings<GetReservationRequest, Reservation> getReservationSettings;
  private final UnaryCallSettings<DeleteReservationRequest, Empty> deleteReservationSettings;
  private final UnaryCallSettings<UpdateReservationRequest, Reservation> updateReservationSettings;
  private final UnaryCallSettings<CreateCapacityCommitmentRequest, CapacityCommitment>
      createCapacityCommitmentSettings;
  private final PagedCallSettings<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          ListCapacityCommitmentsPagedResponse>
      listCapacityCommitmentsSettings;
  private final UnaryCallSettings<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentSettings;
  private final UnaryCallSettings<DeleteCapacityCommitmentRequest, Empty>
      deleteCapacityCommitmentSettings;
  private final UnaryCallSettings<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentSettings;
  private final UnaryCallSettings<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentSettings;
  private final UnaryCallSettings<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsSettings;
  private final UnaryCallSettings<CreateAssignmentRequest, Assignment> createAssignmentSettings;
  private final PagedCallSettings<
          ListAssignmentsRequest, ListAssignmentsResponse, ListAssignmentsPagedResponse>
      listAssignmentsSettings;
  private final UnaryCallSettings<DeleteAssignmentRequest, Empty> deleteAssignmentSettings;
  private final PagedCallSettings<
          SearchAssignmentsRequest, SearchAssignmentsResponse, SearchAssignmentsPagedResponse>
      searchAssignmentsSettings;
  private final UnaryCallSettings<MoveAssignmentRequest, Assignment> moveAssignmentSettings;
  private final UnaryCallSettings<GetBiReservationRequest, BiReservation> getBiReservationSettings;
  private final UnaryCallSettings<UpdateBiReservationRequest, BiReservation>
      updateBiReservationSettings;

  private static final PagedListDescriptor<
          ListReservationsRequest, ListReservationsResponse, Reservation>
      LIST_RESERVATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReservationsRequest, ListReservationsResponse, Reservation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReservationsRequest injectToken(
                ListReservationsRequest payload, String token) {
              return ListReservationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReservationsRequest injectPageSize(
                ListReservationsRequest payload, int pageSize) {
              return ListReservationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListReservationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListReservationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Reservation> extractResources(ListReservationsResponse payload) {
              return payload.getReservationsList() == null
                  ? ImmutableList.<Reservation>of()
                  : payload.getReservationsList();
            }
          };

  private static final PagedListDescriptor<
          ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse, CapacityCommitment>
      LIST_CAPACITY_COMMITMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListCapacityCommitmentsRequest,
              ListCapacityCommitmentsResponse,
              CapacityCommitment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListCapacityCommitmentsRequest injectToken(
                ListCapacityCommitmentsRequest payload, String token) {
              return ListCapacityCommitmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListCapacityCommitmentsRequest injectPageSize(
                ListCapacityCommitmentsRequest payload, int pageSize) {
              return ListCapacityCommitmentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListCapacityCommitmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListCapacityCommitmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<CapacityCommitment> extractResources(
                ListCapacityCommitmentsResponse payload) {
              return payload.getCapacityCommitmentsList() == null
                  ? ImmutableList.<CapacityCommitment>of()
                  : payload.getCapacityCommitmentsList();
            }
          };

  private static final PagedListDescriptor<
          ListAssignmentsRequest, ListAssignmentsResponse, Assignment>
      LIST_ASSIGNMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListAssignmentsRequest, ListAssignmentsResponse, Assignment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAssignmentsRequest injectToken(
                ListAssignmentsRequest payload, String token) {
              return ListAssignmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAssignmentsRequest injectPageSize(
                ListAssignmentsRequest payload, int pageSize) {
              return ListAssignmentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAssignmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAssignmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Assignment> extractResources(ListAssignmentsResponse payload) {
              return payload.getAssignmentsList() == null
                  ? ImmutableList.<Assignment>of()
                  : payload.getAssignmentsList();
            }
          };

  private static final PagedListDescriptor<
          SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment>
      SEARCH_ASSIGNMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchAssignmentsRequest injectToken(
                SearchAssignmentsRequest payload, String token) {
              return SearchAssignmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchAssignmentsRequest injectPageSize(
                SearchAssignmentsRequest payload, int pageSize) {
              return SearchAssignmentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchAssignmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchAssignmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Assignment> extractResources(SearchAssignmentsResponse payload) {
              return payload.getAssignmentsList() == null
                  ? ImmutableList.<Assignment>of()
                  : payload.getAssignmentsList();
            }
          };

  private static final PagedListResponseFactory<
          ListReservationsRequest, ListReservationsResponse, ListReservationsPagedResponse>
      LIST_RESERVATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReservationsRequest, ListReservationsResponse, ListReservationsPagedResponse>() {
            @Override
            public ApiFuture<ListReservationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReservationsRequest, ListReservationsResponse> callable,
                ListReservationsRequest request,
                ApiCallContext context,
                ApiFuture<ListReservationsResponse> futureResponse) {
              PageContext<ListReservationsRequest, ListReservationsResponse, Reservation>
                  pageContext =
                      PageContext.create(
                          callable, LIST_RESERVATIONS_PAGE_STR_DESC, request, context);
              return ListReservationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          ListCapacityCommitmentsPagedResponse>
      LIST_CAPACITY_COMMITMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListCapacityCommitmentsRequest,
              ListCapacityCommitmentsResponse,
              ListCapacityCommitmentsPagedResponse>() {
            @Override
            public ApiFuture<ListCapacityCommitmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListCapacityCommitmentsRequest, ListCapacityCommitmentsResponse>
                    callable,
                ListCapacityCommitmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListCapacityCommitmentsResponse> futureResponse) {
              PageContext<
                      ListCapacityCommitmentsRequest,
                      ListCapacityCommitmentsResponse,
                      CapacityCommitment>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CAPACITY_COMMITMENTS_PAGE_STR_DESC, request, context);
              return ListCapacityCommitmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListAssignmentsRequest, ListAssignmentsResponse, ListAssignmentsPagedResponse>
      LIST_ASSIGNMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAssignmentsRequest, ListAssignmentsResponse, ListAssignmentsPagedResponse>() {
            @Override
            public ApiFuture<ListAssignmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAssignmentsRequest, ListAssignmentsResponse> callable,
                ListAssignmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListAssignmentsResponse> futureResponse) {
              PageContext<ListAssignmentsRequest, ListAssignmentsResponse, Assignment> pageContext =
                  PageContext.create(callable, LIST_ASSIGNMENTS_PAGE_STR_DESC, request, context);
              return ListAssignmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchAssignmentsRequest, SearchAssignmentsResponse, SearchAssignmentsPagedResponse>
      SEARCH_ASSIGNMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchAssignmentsRequest,
              SearchAssignmentsResponse,
              SearchAssignmentsPagedResponse>() {
            @Override
            public ApiFuture<SearchAssignmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchAssignmentsRequest, SearchAssignmentsResponse> callable,
                SearchAssignmentsRequest request,
                ApiCallContext context,
                ApiFuture<SearchAssignmentsResponse> futureResponse) {
              PageContext<SearchAssignmentsRequest, SearchAssignmentsResponse, Assignment>
                  pageContext =
                      PageContext.create(
                          callable, SEARCH_ASSIGNMENTS_PAGE_STR_DESC, request, context);
              return SearchAssignmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createReservation. */
  public UnaryCallSettings<CreateReservationRequest, Reservation> createReservationSettings() {
    return createReservationSettings;
  }

  /** Returns the object with the settings used for calls to listReservations. */
  public PagedCallSettings<
          ListReservationsRequest, ListReservationsResponse, ListReservationsPagedResponse>
      listReservationsSettings() {
    return listReservationsSettings;
  }

  /** Returns the object with the settings used for calls to getReservation. */
  public UnaryCallSettings<GetReservationRequest, Reservation> getReservationSettings() {
    return getReservationSettings;
  }

  /** Returns the object with the settings used for calls to deleteReservation. */
  public UnaryCallSettings<DeleteReservationRequest, Empty> deleteReservationSettings() {
    return deleteReservationSettings;
  }

  /** Returns the object with the settings used for calls to updateReservation. */
  public UnaryCallSettings<UpdateReservationRequest, Reservation> updateReservationSettings() {
    return updateReservationSettings;
  }

  /** Returns the object with the settings used for calls to createCapacityCommitment. */
  public UnaryCallSettings<CreateCapacityCommitmentRequest, CapacityCommitment>
      createCapacityCommitmentSettings() {
    return createCapacityCommitmentSettings;
  }

  /** Returns the object with the settings used for calls to listCapacityCommitments. */
  public PagedCallSettings<
          ListCapacityCommitmentsRequest,
          ListCapacityCommitmentsResponse,
          ListCapacityCommitmentsPagedResponse>
      listCapacityCommitmentsSettings() {
    return listCapacityCommitmentsSettings;
  }

  /** Returns the object with the settings used for calls to getCapacityCommitment. */
  public UnaryCallSettings<GetCapacityCommitmentRequest, CapacityCommitment>
      getCapacityCommitmentSettings() {
    return getCapacityCommitmentSettings;
  }

  /** Returns the object with the settings used for calls to deleteCapacityCommitment. */
  public UnaryCallSettings<DeleteCapacityCommitmentRequest, Empty>
      deleteCapacityCommitmentSettings() {
    return deleteCapacityCommitmentSettings;
  }

  /** Returns the object with the settings used for calls to updateCapacityCommitment. */
  public UnaryCallSettings<UpdateCapacityCommitmentRequest, CapacityCommitment>
      updateCapacityCommitmentSettings() {
    return updateCapacityCommitmentSettings;
  }

  /** Returns the object with the settings used for calls to splitCapacityCommitment. */
  public UnaryCallSettings<SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
      splitCapacityCommitmentSettings() {
    return splitCapacityCommitmentSettings;
  }

  /** Returns the object with the settings used for calls to mergeCapacityCommitments. */
  public UnaryCallSettings<MergeCapacityCommitmentsRequest, CapacityCommitment>
      mergeCapacityCommitmentsSettings() {
    return mergeCapacityCommitmentsSettings;
  }

  /** Returns the object with the settings used for calls to createAssignment. */
  public UnaryCallSettings<CreateAssignmentRequest, Assignment> createAssignmentSettings() {
    return createAssignmentSettings;
  }

  /** Returns the object with the settings used for calls to listAssignments. */
  public PagedCallSettings<
          ListAssignmentsRequest, ListAssignmentsResponse, ListAssignmentsPagedResponse>
      listAssignmentsSettings() {
    return listAssignmentsSettings;
  }

  /** Returns the object with the settings used for calls to deleteAssignment. */
  public UnaryCallSettings<DeleteAssignmentRequest, Empty> deleteAssignmentSettings() {
    return deleteAssignmentSettings;
  }

  /** Returns the object with the settings used for calls to searchAssignments. */
  public PagedCallSettings<
          SearchAssignmentsRequest, SearchAssignmentsResponse, SearchAssignmentsPagedResponse>
      searchAssignmentsSettings() {
    return searchAssignmentsSettings;
  }

  /** Returns the object with the settings used for calls to moveAssignment. */
  public UnaryCallSettings<MoveAssignmentRequest, Assignment> moveAssignmentSettings() {
    return moveAssignmentSettings;
  }

  /** Returns the object with the settings used for calls to getBiReservation. */
  public UnaryCallSettings<GetBiReservationRequest, BiReservation> getBiReservationSettings() {
    return getBiReservationSettings;
  }

  /** Returns the object with the settings used for calls to updateBiReservation. */
  public UnaryCallSettings<UpdateBiReservationRequest, BiReservation>
      updateBiReservationSettings() {
    return updateBiReservationSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ReservationServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcReservationServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "bigqueryreservation.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ReservationServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected ReservationServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createReservationSettings = settingsBuilder.createReservationSettings().build();
    listReservationsSettings = settingsBuilder.listReservationsSettings().build();
    getReservationSettings = settingsBuilder.getReservationSettings().build();
    deleteReservationSettings = settingsBuilder.deleteReservationSettings().build();
    updateReservationSettings = settingsBuilder.updateReservationSettings().build();
    createCapacityCommitmentSettings = settingsBuilder.createCapacityCommitmentSettings().build();
    listCapacityCommitmentsSettings = settingsBuilder.listCapacityCommitmentsSettings().build();
    getCapacityCommitmentSettings = settingsBuilder.getCapacityCommitmentSettings().build();
    deleteCapacityCommitmentSettings = settingsBuilder.deleteCapacityCommitmentSettings().build();
    updateCapacityCommitmentSettings = settingsBuilder.updateCapacityCommitmentSettings().build();
    splitCapacityCommitmentSettings = settingsBuilder.splitCapacityCommitmentSettings().build();
    mergeCapacityCommitmentsSettings = settingsBuilder.mergeCapacityCommitmentsSettings().build();
    createAssignmentSettings = settingsBuilder.createAssignmentSettings().build();
    listAssignmentsSettings = settingsBuilder.listAssignmentsSettings().build();
    deleteAssignmentSettings = settingsBuilder.deleteAssignmentSettings().build();
    searchAssignmentsSettings = settingsBuilder.searchAssignmentsSettings().build();
    moveAssignmentSettings = settingsBuilder.moveAssignmentSettings().build();
    getBiReservationSettings = settingsBuilder.getBiReservationSettings().build();
    updateBiReservationSettings = settingsBuilder.updateBiReservationSettings().build();
  }

  /** Builder for ReservationServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ReservationServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateReservationRequest, Reservation>
        createReservationSettings;
    private final PagedCallSettings.Builder<
            ListReservationsRequest, ListReservationsResponse, ListReservationsPagedResponse>
        listReservationsSettings;
    private final UnaryCallSettings.Builder<GetReservationRequest, Reservation>
        getReservationSettings;
    private final UnaryCallSettings.Builder<DeleteReservationRequest, Empty>
        deleteReservationSettings;
    private final UnaryCallSettings.Builder<UpdateReservationRequest, Reservation>
        updateReservationSettings;
    private final UnaryCallSettings.Builder<CreateCapacityCommitmentRequest, CapacityCommitment>
        createCapacityCommitmentSettings;
    private final PagedCallSettings.Builder<
            ListCapacityCommitmentsRequest,
            ListCapacityCommitmentsResponse,
            ListCapacityCommitmentsPagedResponse>
        listCapacityCommitmentsSettings;
    private final UnaryCallSettings.Builder<GetCapacityCommitmentRequest, CapacityCommitment>
        getCapacityCommitmentSettings;
    private final UnaryCallSettings.Builder<DeleteCapacityCommitmentRequest, Empty>
        deleteCapacityCommitmentSettings;
    private final UnaryCallSettings.Builder<UpdateCapacityCommitmentRequest, CapacityCommitment>
        updateCapacityCommitmentSettings;
    private final UnaryCallSettings.Builder<
            SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
        splitCapacityCommitmentSettings;
    private final UnaryCallSettings.Builder<MergeCapacityCommitmentsRequest, CapacityCommitment>
        mergeCapacityCommitmentsSettings;
    private final UnaryCallSettings.Builder<CreateAssignmentRequest, Assignment>
        createAssignmentSettings;
    private final PagedCallSettings.Builder<
            ListAssignmentsRequest, ListAssignmentsResponse, ListAssignmentsPagedResponse>
        listAssignmentsSettings;
    private final UnaryCallSettings.Builder<DeleteAssignmentRequest, Empty>
        deleteAssignmentSettings;
    private final PagedCallSettings.Builder<
            SearchAssignmentsRequest, SearchAssignmentsResponse, SearchAssignmentsPagedResponse>
        searchAssignmentsSettings;
    private final UnaryCallSettings.Builder<MoveAssignmentRequest, Assignment>
        moveAssignmentSettings;
    private final UnaryCallSettings.Builder<GetBiReservationRequest, BiReservation>
        getBiReservationSettings;
    private final UnaryCallSettings.Builder<UpdateBiReservationRequest, BiReservation>
        updateBiReservationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listReservationsSettings = PagedCallSettings.newBuilder(LIST_RESERVATIONS_PAGE_STR_FACT);
      getReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createCapacityCommitmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listCapacityCommitmentsSettings =
          PagedCallSettings.newBuilder(LIST_CAPACITY_COMMITMENTS_PAGE_STR_FACT);
      getCapacityCommitmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteCapacityCommitmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateCapacityCommitmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      splitCapacityCommitmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      mergeCapacityCommitmentsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAssignmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAssignmentsSettings = PagedCallSettings.newBuilder(LIST_ASSIGNMENTS_PAGE_STR_FACT);
      deleteAssignmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchAssignmentsSettings = PagedCallSettings.newBuilder(SEARCH_ASSIGNMENTS_PAGE_STR_FACT);
      moveAssignmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBiReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBiReservationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createReservationSettings,
              listReservationsSettings,
              getReservationSettings,
              deleteReservationSettings,
              updateReservationSettings,
              createCapacityCommitmentSettings,
              listCapacityCommitmentsSettings,
              getCapacityCommitmentSettings,
              deleteCapacityCommitmentSettings,
              updateCapacityCommitmentSettings,
              splitCapacityCommitmentSettings,
              mergeCapacityCommitmentsSettings,
              createAssignmentSettings,
              listAssignmentsSettings,
              deleteAssignmentSettings,
              searchAssignmentsSettings,
              moveAssignmentSettings,
              getBiReservationSettings,
              updateBiReservationSettings);
      initDefaults(this);
    }

    protected Builder(ReservationServiceStubSettings settings) {
      super(settings);

      createReservationSettings = settings.createReservationSettings.toBuilder();
      listReservationsSettings = settings.listReservationsSettings.toBuilder();
      getReservationSettings = settings.getReservationSettings.toBuilder();
      deleteReservationSettings = settings.deleteReservationSettings.toBuilder();
      updateReservationSettings = settings.updateReservationSettings.toBuilder();
      createCapacityCommitmentSettings = settings.createCapacityCommitmentSettings.toBuilder();
      listCapacityCommitmentsSettings = settings.listCapacityCommitmentsSettings.toBuilder();
      getCapacityCommitmentSettings = settings.getCapacityCommitmentSettings.toBuilder();
      deleteCapacityCommitmentSettings = settings.deleteCapacityCommitmentSettings.toBuilder();
      updateCapacityCommitmentSettings = settings.updateCapacityCommitmentSettings.toBuilder();
      splitCapacityCommitmentSettings = settings.splitCapacityCommitmentSettings.toBuilder();
      mergeCapacityCommitmentsSettings = settings.mergeCapacityCommitmentsSettings.toBuilder();
      createAssignmentSettings = settings.createAssignmentSettings.toBuilder();
      listAssignmentsSettings = settings.listAssignmentsSettings.toBuilder();
      deleteAssignmentSettings = settings.deleteAssignmentSettings.toBuilder();
      searchAssignmentsSettings = settings.searchAssignmentsSettings.toBuilder();
      moveAssignmentSettings = settings.moveAssignmentSettings.toBuilder();
      getBiReservationSettings = settings.getBiReservationSettings.toBuilder();
      updateBiReservationSettings = settings.updateBiReservationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createReservationSettings,
              listReservationsSettings,
              getReservationSettings,
              deleteReservationSettings,
              updateReservationSettings,
              createCapacityCommitmentSettings,
              listCapacityCommitmentsSettings,
              getCapacityCommitmentSettings,
              deleteCapacityCommitmentSettings,
              updateCapacityCommitmentSettings,
              splitCapacityCommitmentSettings,
              mergeCapacityCommitmentsSettings,
              createAssignmentSettings,
              listAssignmentsSettings,
              deleteAssignmentSettings,
              searchAssignmentsSettings,
              moveAssignmentSettings,
              getBiReservationSettings,
              updateBiReservationSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listReservationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createCapacityCommitmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listCapacityCommitmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getCapacityCommitmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteCapacityCommitmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateCapacityCommitmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .splitCapacityCommitmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .mergeCapacityCommitmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createAssignmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listAssignmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .deleteAssignmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .searchAssignmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .moveAssignmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getBiReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateBiReservationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createReservation. */
    public UnaryCallSettings.Builder<CreateReservationRequest, Reservation>
        createReservationSettings() {
      return createReservationSettings;
    }

    /** Returns the builder for the settings used for calls to listReservations. */
    public PagedCallSettings.Builder<
            ListReservationsRequest, ListReservationsResponse, ListReservationsPagedResponse>
        listReservationsSettings() {
      return listReservationsSettings;
    }

    /** Returns the builder for the settings used for calls to getReservation. */
    public UnaryCallSettings.Builder<GetReservationRequest, Reservation> getReservationSettings() {
      return getReservationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteReservation. */
    public UnaryCallSettings.Builder<DeleteReservationRequest, Empty> deleteReservationSettings() {
      return deleteReservationSettings;
    }

    /** Returns the builder for the settings used for calls to updateReservation. */
    public UnaryCallSettings.Builder<UpdateReservationRequest, Reservation>
        updateReservationSettings() {
      return updateReservationSettings;
    }

    /** Returns the builder for the settings used for calls to createCapacityCommitment. */
    public UnaryCallSettings.Builder<CreateCapacityCommitmentRequest, CapacityCommitment>
        createCapacityCommitmentSettings() {
      return createCapacityCommitmentSettings;
    }

    /** Returns the builder for the settings used for calls to listCapacityCommitments. */
    public PagedCallSettings.Builder<
            ListCapacityCommitmentsRequest,
            ListCapacityCommitmentsResponse,
            ListCapacityCommitmentsPagedResponse>
        listCapacityCommitmentsSettings() {
      return listCapacityCommitmentsSettings;
    }

    /** Returns the builder for the settings used for calls to getCapacityCommitment. */
    public UnaryCallSettings.Builder<GetCapacityCommitmentRequest, CapacityCommitment>
        getCapacityCommitmentSettings() {
      return getCapacityCommitmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCapacityCommitment. */
    public UnaryCallSettings.Builder<DeleteCapacityCommitmentRequest, Empty>
        deleteCapacityCommitmentSettings() {
      return deleteCapacityCommitmentSettings;
    }

    /** Returns the builder for the settings used for calls to updateCapacityCommitment. */
    public UnaryCallSettings.Builder<UpdateCapacityCommitmentRequest, CapacityCommitment>
        updateCapacityCommitmentSettings() {
      return updateCapacityCommitmentSettings;
    }

    /** Returns the builder for the settings used for calls to splitCapacityCommitment. */
    public UnaryCallSettings.Builder<
            SplitCapacityCommitmentRequest, SplitCapacityCommitmentResponse>
        splitCapacityCommitmentSettings() {
      return splitCapacityCommitmentSettings;
    }

    /** Returns the builder for the settings used for calls to mergeCapacityCommitments. */
    public UnaryCallSettings.Builder<MergeCapacityCommitmentsRequest, CapacityCommitment>
        mergeCapacityCommitmentsSettings() {
      return mergeCapacityCommitmentsSettings;
    }

    /** Returns the builder for the settings used for calls to createAssignment. */
    public UnaryCallSettings.Builder<CreateAssignmentRequest, Assignment>
        createAssignmentSettings() {
      return createAssignmentSettings;
    }

    /** Returns the builder for the settings used for calls to listAssignments. */
    public PagedCallSettings.Builder<
            ListAssignmentsRequest, ListAssignmentsResponse, ListAssignmentsPagedResponse>
        listAssignmentsSettings() {
      return listAssignmentsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAssignment. */
    public UnaryCallSettings.Builder<DeleteAssignmentRequest, Empty> deleteAssignmentSettings() {
      return deleteAssignmentSettings;
    }

    /** Returns the builder for the settings used for calls to searchAssignments. */
    public PagedCallSettings.Builder<
            SearchAssignmentsRequest, SearchAssignmentsResponse, SearchAssignmentsPagedResponse>
        searchAssignmentsSettings() {
      return searchAssignmentsSettings;
    }

    /** Returns the builder for the settings used for calls to moveAssignment. */
    public UnaryCallSettings.Builder<MoveAssignmentRequest, Assignment> moveAssignmentSettings() {
      return moveAssignmentSettings;
    }

    /** Returns the builder for the settings used for calls to getBiReservation. */
    public UnaryCallSettings.Builder<GetBiReservationRequest, BiReservation>
        getBiReservationSettings() {
      return getBiReservationSettings;
    }

    /** Returns the builder for the settings used for calls to updateBiReservation. */
    public UnaryCallSettings.Builder<UpdateBiReservationRequest, BiReservation>
        updateBiReservationSettings() {
      return updateBiReservationSettings;
    }

    @Override
    public ReservationServiceStubSettings build() throws IOException {
      return new ReservationServiceStubSettings(this);
    }
  }
}
