/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.visionai.v1.stub;

import static com.google.cloud.visionai.v1.StreamsServiceClient.ListClustersPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListEventsPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListSeriesPagedResponse;
import static com.google.cloud.visionai.v1.StreamsServiceClient.ListStreamsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.visionai.v1.Channel;
import com.google.cloud.visionai.v1.Cluster;
import com.google.cloud.visionai.v1.CreateClusterRequest;
import com.google.cloud.visionai.v1.CreateEventRequest;
import com.google.cloud.visionai.v1.CreateSeriesRequest;
import com.google.cloud.visionai.v1.CreateStreamRequest;
import com.google.cloud.visionai.v1.DeleteClusterRequest;
import com.google.cloud.visionai.v1.DeleteEventRequest;
import com.google.cloud.visionai.v1.DeleteSeriesRequest;
import com.google.cloud.visionai.v1.DeleteStreamRequest;
import com.google.cloud.visionai.v1.Event;
import com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest;
import com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse;
import com.google.cloud.visionai.v1.GetClusterRequest;
import com.google.cloud.visionai.v1.GetEventRequest;
import com.google.cloud.visionai.v1.GetSeriesRequest;
import com.google.cloud.visionai.v1.GetStreamRequest;
import com.google.cloud.visionai.v1.GetStreamThumbnailRequest;
import com.google.cloud.visionai.v1.GetStreamThumbnailResponse;
import com.google.cloud.visionai.v1.ListClustersRequest;
import com.google.cloud.visionai.v1.ListClustersResponse;
import com.google.cloud.visionai.v1.ListEventsRequest;
import com.google.cloud.visionai.v1.ListEventsResponse;
import com.google.cloud.visionai.v1.ListSeriesRequest;
import com.google.cloud.visionai.v1.ListSeriesResponse;
import com.google.cloud.visionai.v1.ListStreamsRequest;
import com.google.cloud.visionai.v1.ListStreamsResponse;
import com.google.cloud.visionai.v1.MaterializeChannelRequest;
import com.google.cloud.visionai.v1.OperationMetadata;
import com.google.cloud.visionai.v1.Series;
import com.google.cloud.visionai.v1.Stream;
import com.google.cloud.visionai.v1.UpdateClusterRequest;
import com.google.cloud.visionai.v1.UpdateEventRequest;
import com.google.cloud.visionai.v1.UpdateSeriesRequest;
import com.google.cloud.visionai.v1.UpdateStreamRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StreamsServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (visionai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCluster to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StreamsServiceStubSettings.Builder streamsServiceSettingsBuilder =
 *     StreamsServiceStubSettings.newBuilder();
 * streamsServiceSettingsBuilder
 *     .getClusterSettings()
 *     .setRetrySettings(
 *         streamsServiceSettingsBuilder
 *             .getClusterSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * StreamsServiceStubSettings streamsServiceSettings = streamsServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StreamsServiceStubSettings extends StubSettings<StreamsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings;
  private final UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings;
  private final UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings;
  private final OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings;
  private final UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings;
  private final OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings;
  private final UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings;
  private final OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings;
  private final PagedCallSettings<ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
      listStreamsSettings;
  private final UnaryCallSettings<GetStreamRequest, Stream> getStreamSettings;
  private final UnaryCallSettings<CreateStreamRequest, Operation> createStreamSettings;
  private final OperationCallSettings<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationSettings;
  private final UnaryCallSettings<UpdateStreamRequest, Operation> updateStreamSettings;
  private final OperationCallSettings<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationSettings;
  private final UnaryCallSettings<DeleteStreamRequest, Operation> deleteStreamSettings;
  private final OperationCallSettings<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationSettings;
  private final UnaryCallSettings<GetStreamThumbnailRequest, Operation> getStreamThumbnailSettings;
  private final OperationCallSettings<
          GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
      getStreamThumbnailOperationSettings;
  private final UnaryCallSettings<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
      generateStreamHlsTokenSettings;
  private final PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings;
  private final UnaryCallSettings<GetEventRequest, Event> getEventSettings;
  private final UnaryCallSettings<CreateEventRequest, Operation> createEventSettings;
  private final OperationCallSettings<CreateEventRequest, Event, OperationMetadata>
      createEventOperationSettings;
  private final UnaryCallSettings<UpdateEventRequest, Operation> updateEventSettings;
  private final OperationCallSettings<UpdateEventRequest, Event, OperationMetadata>
      updateEventOperationSettings;
  private final UnaryCallSettings<DeleteEventRequest, Operation> deleteEventSettings;
  private final OperationCallSettings<DeleteEventRequest, Empty, OperationMetadata>
      deleteEventOperationSettings;
  private final PagedCallSettings<ListSeriesRequest, ListSeriesResponse, ListSeriesPagedResponse>
      listSeriesSettings;
  private final UnaryCallSettings<GetSeriesRequest, Series> getSeriesSettings;
  private final UnaryCallSettings<CreateSeriesRequest, Operation> createSeriesSettings;
  private final OperationCallSettings<CreateSeriesRequest, Series, OperationMetadata>
      createSeriesOperationSettings;
  private final UnaryCallSettings<UpdateSeriesRequest, Operation> updateSeriesSettings;
  private final OperationCallSettings<UpdateSeriesRequest, Series, OperationMetadata>
      updateSeriesOperationSettings;
  private final UnaryCallSettings<DeleteSeriesRequest, Operation> deleteSeriesSettings;
  private final OperationCallSettings<DeleteSeriesRequest, Empty, OperationMetadata>
      deleteSeriesOperationSettings;
  private final UnaryCallSettings<MaterializeChannelRequest, Operation> materializeChannelSettings;
  private final OperationCallSettings<MaterializeChannelRequest, Channel, OperationMetadata>
      materializeChannelOperationSettings;

  private static final PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>
      LIST_CLUSTERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListClustersRequest, ListClustersResponse, Cluster>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListClustersRequest injectToken(ListClustersRequest payload, String token) {
              return ListClustersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListClustersRequest injectPageSize(ListClustersRequest payload, int pageSize) {
              return ListClustersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListClustersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListClustersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Cluster> extractResources(ListClustersResponse payload) {
              return payload.getClustersList() == null
                  ? ImmutableList.<Cluster>of()
                  : payload.getClustersList();
            }
          };

  private static final PagedListDescriptor<ListStreamsRequest, ListStreamsResponse, Stream>
      LIST_STREAMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListStreamsRequest, ListStreamsResponse, Stream>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStreamsRequest injectToken(ListStreamsRequest payload, String token) {
              return ListStreamsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStreamsRequest injectPageSize(ListStreamsRequest payload, int pageSize) {
              return ListStreamsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListStreamsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListStreamsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Stream> extractResources(ListStreamsResponse payload) {
              return payload.getStreamsList() == null
                  ? ImmutableList.<Stream>of()
                  : payload.getStreamsList();
            }
          };

  private static final PagedListDescriptor<ListEventsRequest, ListEventsResponse, Event>
      LIST_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEventsRequest, ListEventsResponse, Event>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEventsRequest injectToken(ListEventsRequest payload, String token) {
              return ListEventsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEventsRequest injectPageSize(ListEventsRequest payload, int pageSize) {
              return ListEventsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Event> extractResources(ListEventsResponse payload) {
              return payload.getEventsList() == null
                  ? ImmutableList.<Event>of()
                  : payload.getEventsList();
            }
          };

  private static final PagedListDescriptor<ListSeriesRequest, ListSeriesResponse, Series>
      LIST_SERIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListSeriesRequest, ListSeriesResponse, Series>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSeriesRequest injectToken(ListSeriesRequest payload, String token) {
              return ListSeriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSeriesRequest injectPageSize(ListSeriesRequest payload, int pageSize) {
              return ListSeriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSeriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSeriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Series> extractResources(ListSeriesResponse payload) {
              return payload.getSeriesList() == null
                  ? ImmutableList.<Series>of()
                  : payload.getSeriesList();
            }
          };

  private static final PagedListResponseFactory<
          ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      LIST_CLUSTERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>() {
            @Override
            public ApiFuture<ListClustersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListClustersRequest, ListClustersResponse> callable,
                ListClustersRequest request,
                ApiCallContext context,
                ApiFuture<ListClustersResponse> futureResponse) {
              PageContext<ListClustersRequest, ListClustersResponse, Cluster> pageContext =
                  PageContext.create(callable, LIST_CLUSTERS_PAGE_STR_DESC, request, context);
              return ListClustersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
      LIST_STREAMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>() {
            @Override
            public ApiFuture<ListStreamsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStreamsRequest, ListStreamsResponse> callable,
                ListStreamsRequest request,
                ApiCallContext context,
                ApiFuture<ListStreamsResponse> futureResponse) {
              PageContext<ListStreamsRequest, ListStreamsResponse, Stream> pageContext =
                  PageContext.create(callable, LIST_STREAMS_PAGE_STR_DESC, request, context);
              return ListStreamsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      LIST_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>() {
            @Override
            public ApiFuture<ListEventsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEventsRequest, ListEventsResponse> callable,
                ListEventsRequest request,
                ApiCallContext context,
                ApiFuture<ListEventsResponse> futureResponse) {
              PageContext<ListEventsRequest, ListEventsResponse, Event> pageContext =
                  PageContext.create(callable, LIST_EVENTS_PAGE_STR_DESC, request, context);
              return ListEventsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSeriesRequest, ListSeriesResponse, ListSeriesPagedResponse>
      LIST_SERIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSeriesRequest, ListSeriesResponse, ListSeriesPagedResponse>() {
            @Override
            public ApiFuture<ListSeriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSeriesRequest, ListSeriesResponse> callable,
                ListSeriesRequest request,
                ApiCallContext context,
                ApiFuture<ListSeriesResponse> futureResponse) {
              PageContext<ListSeriesRequest, ListSeriesResponse, Series> pageContext =
                  PageContext.create(callable, LIST_SERIES_PAGE_STR_DESC, request, context);
              return ListSeriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listClusters. */
  public PagedCallSettings<ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
      listClustersSettings() {
    return listClustersSettings;
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return getClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return createClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, OperationMetadata>
      createClusterOperationSettings() {
    return createClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<UpdateClusterRequest, Operation> updateClusterSettings() {
    return updateClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<UpdateClusterRequest, Cluster, OperationMetadata>
      updateClusterOperationSettings() {
    return updateClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Operation> deleteClusterSettings() {
    return deleteClusterSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public OperationCallSettings<DeleteClusterRequest, Empty, OperationMetadata>
      deleteClusterOperationSettings() {
    return deleteClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to listStreams. */
  public PagedCallSettings<ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
      listStreamsSettings() {
    return listStreamsSettings;
  }

  /** Returns the object with the settings used for calls to getStream. */
  public UnaryCallSettings<GetStreamRequest, Stream> getStreamSettings() {
    return getStreamSettings;
  }

  /** Returns the object with the settings used for calls to createStream. */
  public UnaryCallSettings<CreateStreamRequest, Operation> createStreamSettings() {
    return createStreamSettings;
  }

  /** Returns the object with the settings used for calls to createStream. */
  public OperationCallSettings<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationSettings() {
    return createStreamOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateStream. */
  public UnaryCallSettings<UpdateStreamRequest, Operation> updateStreamSettings() {
    return updateStreamSettings;
  }

  /** Returns the object with the settings used for calls to updateStream. */
  public OperationCallSettings<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationSettings() {
    return updateStreamOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteStream. */
  public UnaryCallSettings<DeleteStreamRequest, Operation> deleteStreamSettings() {
    return deleteStreamSettings;
  }

  /** Returns the object with the settings used for calls to deleteStream. */
  public OperationCallSettings<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationSettings() {
    return deleteStreamOperationSettings;
  }

  /** Returns the object with the settings used for calls to getStreamThumbnail. */
  public UnaryCallSettings<GetStreamThumbnailRequest, Operation> getStreamThumbnailSettings() {
    return getStreamThumbnailSettings;
  }

  /** Returns the object with the settings used for calls to getStreamThumbnail. */
  public OperationCallSettings<
          GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
      getStreamThumbnailOperationSettings() {
    return getStreamThumbnailOperationSettings;
  }

  /** Returns the object with the settings used for calls to generateStreamHlsToken. */
  public UnaryCallSettings<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
      generateStreamHlsTokenSettings() {
    return generateStreamHlsTokenSettings;
  }

  /** Returns the object with the settings used for calls to listEvents. */
  public PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings() {
    return listEventsSettings;
  }

  /** Returns the object with the settings used for calls to getEvent. */
  public UnaryCallSettings<GetEventRequest, Event> getEventSettings() {
    return getEventSettings;
  }

  /** Returns the object with the settings used for calls to createEvent. */
  public UnaryCallSettings<CreateEventRequest, Operation> createEventSettings() {
    return createEventSettings;
  }

  /** Returns the object with the settings used for calls to createEvent. */
  public OperationCallSettings<CreateEventRequest, Event, OperationMetadata>
      createEventOperationSettings() {
    return createEventOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEvent. */
  public UnaryCallSettings<UpdateEventRequest, Operation> updateEventSettings() {
    return updateEventSettings;
  }

  /** Returns the object with the settings used for calls to updateEvent. */
  public OperationCallSettings<UpdateEventRequest, Event, OperationMetadata>
      updateEventOperationSettings() {
    return updateEventOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvent. */
  public UnaryCallSettings<DeleteEventRequest, Operation> deleteEventSettings() {
    return deleteEventSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvent. */
  public OperationCallSettings<DeleteEventRequest, Empty, OperationMetadata>
      deleteEventOperationSettings() {
    return deleteEventOperationSettings;
  }

  /** Returns the object with the settings used for calls to listSeries. */
  public PagedCallSettings<ListSeriesRequest, ListSeriesResponse, ListSeriesPagedResponse>
      listSeriesSettings() {
    return listSeriesSettings;
  }

  /** Returns the object with the settings used for calls to getSeries. */
  public UnaryCallSettings<GetSeriesRequest, Series> getSeriesSettings() {
    return getSeriesSettings;
  }

  /** Returns the object with the settings used for calls to createSeries. */
  public UnaryCallSettings<CreateSeriesRequest, Operation> createSeriesSettings() {
    return createSeriesSettings;
  }

  /** Returns the object with the settings used for calls to createSeries. */
  public OperationCallSettings<CreateSeriesRequest, Series, OperationMetadata>
      createSeriesOperationSettings() {
    return createSeriesOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateSeries. */
  public UnaryCallSettings<UpdateSeriesRequest, Operation> updateSeriesSettings() {
    return updateSeriesSettings;
  }

  /** Returns the object with the settings used for calls to updateSeries. */
  public OperationCallSettings<UpdateSeriesRequest, Series, OperationMetadata>
      updateSeriesOperationSettings() {
    return updateSeriesOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteSeries. */
  public UnaryCallSettings<DeleteSeriesRequest, Operation> deleteSeriesSettings() {
    return deleteSeriesSettings;
  }

  /** Returns the object with the settings used for calls to deleteSeries. */
  public OperationCallSettings<DeleteSeriesRequest, Empty, OperationMetadata>
      deleteSeriesOperationSettings() {
    return deleteSeriesOperationSettings;
  }

  /** Returns the object with the settings used for calls to materializeChannel. */
  public UnaryCallSettings<MaterializeChannelRequest, Operation> materializeChannelSettings() {
    return materializeChannelSettings;
  }

  /** Returns the object with the settings used for calls to materializeChannel. */
  public OperationCallSettings<MaterializeChannelRequest, Channel, OperationMetadata>
      materializeChannelOperationSettings() {
    return materializeChannelOperationSettings;
  }

  public StreamsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcStreamsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonStreamsServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "visionai";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "visionai.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "visionai.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(StreamsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(StreamsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StreamsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected StreamsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listClustersSettings = settingsBuilder.listClustersSettings().build();
    getClusterSettings = settingsBuilder.getClusterSettings().build();
    createClusterSettings = settingsBuilder.createClusterSettings().build();
    createClusterOperationSettings = settingsBuilder.createClusterOperationSettings().build();
    updateClusterSettings = settingsBuilder.updateClusterSettings().build();
    updateClusterOperationSettings = settingsBuilder.updateClusterOperationSettings().build();
    deleteClusterSettings = settingsBuilder.deleteClusterSettings().build();
    deleteClusterOperationSettings = settingsBuilder.deleteClusterOperationSettings().build();
    listStreamsSettings = settingsBuilder.listStreamsSettings().build();
    getStreamSettings = settingsBuilder.getStreamSettings().build();
    createStreamSettings = settingsBuilder.createStreamSettings().build();
    createStreamOperationSettings = settingsBuilder.createStreamOperationSettings().build();
    updateStreamSettings = settingsBuilder.updateStreamSettings().build();
    updateStreamOperationSettings = settingsBuilder.updateStreamOperationSettings().build();
    deleteStreamSettings = settingsBuilder.deleteStreamSettings().build();
    deleteStreamOperationSettings = settingsBuilder.deleteStreamOperationSettings().build();
    getStreamThumbnailSettings = settingsBuilder.getStreamThumbnailSettings().build();
    getStreamThumbnailOperationSettings =
        settingsBuilder.getStreamThumbnailOperationSettings().build();
    generateStreamHlsTokenSettings = settingsBuilder.generateStreamHlsTokenSettings().build();
    listEventsSettings = settingsBuilder.listEventsSettings().build();
    getEventSettings = settingsBuilder.getEventSettings().build();
    createEventSettings = settingsBuilder.createEventSettings().build();
    createEventOperationSettings = settingsBuilder.createEventOperationSettings().build();
    updateEventSettings = settingsBuilder.updateEventSettings().build();
    updateEventOperationSettings = settingsBuilder.updateEventOperationSettings().build();
    deleteEventSettings = settingsBuilder.deleteEventSettings().build();
    deleteEventOperationSettings = settingsBuilder.deleteEventOperationSettings().build();
    listSeriesSettings = settingsBuilder.listSeriesSettings().build();
    getSeriesSettings = settingsBuilder.getSeriesSettings().build();
    createSeriesSettings = settingsBuilder.createSeriesSettings().build();
    createSeriesOperationSettings = settingsBuilder.createSeriesOperationSettings().build();
    updateSeriesSettings = settingsBuilder.updateSeriesSettings().build();
    updateSeriesOperationSettings = settingsBuilder.updateSeriesOperationSettings().build();
    deleteSeriesSettings = settingsBuilder.deleteSeriesSettings().build();
    deleteSeriesOperationSettings = settingsBuilder.deleteSeriesOperationSettings().build();
    materializeChannelSettings = settingsBuilder.materializeChannelSettings().build();
    materializeChannelOperationSettings =
        settingsBuilder.materializeChannelOperationSettings().build();
  }

  /** Builder for StreamsServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<StreamsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings;
    private final UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings;
    private final UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings;
    private final OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings;
    private final UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings;
    private final OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings;
    private final OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings;
    private final PagedCallSettings.Builder<
            ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
        listStreamsSettings;
    private final UnaryCallSettings.Builder<GetStreamRequest, Stream> getStreamSettings;
    private final UnaryCallSettings.Builder<CreateStreamRequest, Operation> createStreamSettings;
    private final OperationCallSettings.Builder<CreateStreamRequest, Stream, OperationMetadata>
        createStreamOperationSettings;
    private final UnaryCallSettings.Builder<UpdateStreamRequest, Operation> updateStreamSettings;
    private final OperationCallSettings.Builder<UpdateStreamRequest, Stream, OperationMetadata>
        updateStreamOperationSettings;
    private final UnaryCallSettings.Builder<DeleteStreamRequest, Operation> deleteStreamSettings;
    private final OperationCallSettings.Builder<DeleteStreamRequest, Empty, OperationMetadata>
        deleteStreamOperationSettings;
    private final UnaryCallSettings.Builder<GetStreamThumbnailRequest, Operation>
        getStreamThumbnailSettings;
    private final OperationCallSettings.Builder<
            GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
        getStreamThumbnailOperationSettings;
    private final UnaryCallSettings.Builder<
            GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
        generateStreamHlsTokenSettings;
    private final PagedCallSettings.Builder<
            ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings;
    private final UnaryCallSettings.Builder<GetEventRequest, Event> getEventSettings;
    private final UnaryCallSettings.Builder<CreateEventRequest, Operation> createEventSettings;
    private final OperationCallSettings.Builder<CreateEventRequest, Event, OperationMetadata>
        createEventOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEventRequest, Operation> updateEventSettings;
    private final OperationCallSettings.Builder<UpdateEventRequest, Event, OperationMetadata>
        updateEventOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEventRequest, Operation> deleteEventSettings;
    private final OperationCallSettings.Builder<DeleteEventRequest, Empty, OperationMetadata>
        deleteEventOperationSettings;
    private final PagedCallSettings.Builder<
            ListSeriesRequest, ListSeriesResponse, ListSeriesPagedResponse>
        listSeriesSettings;
    private final UnaryCallSettings.Builder<GetSeriesRequest, Series> getSeriesSettings;
    private final UnaryCallSettings.Builder<CreateSeriesRequest, Operation> createSeriesSettings;
    private final OperationCallSettings.Builder<CreateSeriesRequest, Series, OperationMetadata>
        createSeriesOperationSettings;
    private final UnaryCallSettings.Builder<UpdateSeriesRequest, Operation> updateSeriesSettings;
    private final OperationCallSettings.Builder<UpdateSeriesRequest, Series, OperationMetadata>
        updateSeriesOperationSettings;
    private final UnaryCallSettings.Builder<DeleteSeriesRequest, Operation> deleteSeriesSettings;
    private final OperationCallSettings.Builder<DeleteSeriesRequest, Empty, OperationMetadata>
        deleteSeriesOperationSettings;
    private final UnaryCallSettings.Builder<MaterializeChannelRequest, Operation>
        materializeChannelSettings;
    private final OperationCallSettings.Builder<
            MaterializeChannelRequest, Channel, OperationMetadata>
        materializeChannelOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listClustersSettings = PagedCallSettings.newBuilder(LIST_CLUSTERS_PAGE_STR_FACT);
      getClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterOperationSettings = OperationCallSettings.newBuilder();
      updateClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteClusterOperationSettings = OperationCallSettings.newBuilder();
      listStreamsSettings = PagedCallSettings.newBuilder(LIST_STREAMS_PAGE_STR_FACT);
      getStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createStreamOperationSettings = OperationCallSettings.newBuilder();
      updateStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateStreamOperationSettings = OperationCallSettings.newBuilder();
      deleteStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteStreamOperationSettings = OperationCallSettings.newBuilder();
      getStreamThumbnailSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getStreamThumbnailOperationSettings = OperationCallSettings.newBuilder();
      generateStreamHlsTokenSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEventsSettings = PagedCallSettings.newBuilder(LIST_EVENTS_PAGE_STR_FACT);
      getEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEventOperationSettings = OperationCallSettings.newBuilder();
      updateEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEventOperationSettings = OperationCallSettings.newBuilder();
      deleteEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEventOperationSettings = OperationCallSettings.newBuilder();
      listSeriesSettings = PagedCallSettings.newBuilder(LIST_SERIES_PAGE_STR_FACT);
      getSeriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSeriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSeriesOperationSettings = OperationCallSettings.newBuilder();
      updateSeriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSeriesOperationSettings = OperationCallSettings.newBuilder();
      deleteSeriesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSeriesOperationSettings = OperationCallSettings.newBuilder();
      materializeChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      materializeChannelOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              listStreamsSettings,
              getStreamSettings,
              createStreamSettings,
              updateStreamSettings,
              deleteStreamSettings,
              getStreamThumbnailSettings,
              generateStreamHlsTokenSettings,
              listEventsSettings,
              getEventSettings,
              createEventSettings,
              updateEventSettings,
              deleteEventSettings,
              listSeriesSettings,
              getSeriesSettings,
              createSeriesSettings,
              updateSeriesSettings,
              deleteSeriesSettings,
              materializeChannelSettings);
      initDefaults(this);
    }

    protected Builder(StreamsServiceStubSettings settings) {
      super(settings);

      listClustersSettings = settings.listClustersSettings.toBuilder();
      getClusterSettings = settings.getClusterSettings.toBuilder();
      createClusterSettings = settings.createClusterSettings.toBuilder();
      createClusterOperationSettings = settings.createClusterOperationSettings.toBuilder();
      updateClusterSettings = settings.updateClusterSettings.toBuilder();
      updateClusterOperationSettings = settings.updateClusterOperationSettings.toBuilder();
      deleteClusterSettings = settings.deleteClusterSettings.toBuilder();
      deleteClusterOperationSettings = settings.deleteClusterOperationSettings.toBuilder();
      listStreamsSettings = settings.listStreamsSettings.toBuilder();
      getStreamSettings = settings.getStreamSettings.toBuilder();
      createStreamSettings = settings.createStreamSettings.toBuilder();
      createStreamOperationSettings = settings.createStreamOperationSettings.toBuilder();
      updateStreamSettings = settings.updateStreamSettings.toBuilder();
      updateStreamOperationSettings = settings.updateStreamOperationSettings.toBuilder();
      deleteStreamSettings = settings.deleteStreamSettings.toBuilder();
      deleteStreamOperationSettings = settings.deleteStreamOperationSettings.toBuilder();
      getStreamThumbnailSettings = settings.getStreamThumbnailSettings.toBuilder();
      getStreamThumbnailOperationSettings =
          settings.getStreamThumbnailOperationSettings.toBuilder();
      generateStreamHlsTokenSettings = settings.generateStreamHlsTokenSettings.toBuilder();
      listEventsSettings = settings.listEventsSettings.toBuilder();
      getEventSettings = settings.getEventSettings.toBuilder();
      createEventSettings = settings.createEventSettings.toBuilder();
      createEventOperationSettings = settings.createEventOperationSettings.toBuilder();
      updateEventSettings = settings.updateEventSettings.toBuilder();
      updateEventOperationSettings = settings.updateEventOperationSettings.toBuilder();
      deleteEventSettings = settings.deleteEventSettings.toBuilder();
      deleteEventOperationSettings = settings.deleteEventOperationSettings.toBuilder();
      listSeriesSettings = settings.listSeriesSettings.toBuilder();
      getSeriesSettings = settings.getSeriesSettings.toBuilder();
      createSeriesSettings = settings.createSeriesSettings.toBuilder();
      createSeriesOperationSettings = settings.createSeriesOperationSettings.toBuilder();
      updateSeriesSettings = settings.updateSeriesSettings.toBuilder();
      updateSeriesOperationSettings = settings.updateSeriesOperationSettings.toBuilder();
      deleteSeriesSettings = settings.deleteSeriesSettings.toBuilder();
      deleteSeriesOperationSettings = settings.deleteSeriesOperationSettings.toBuilder();
      materializeChannelSettings = settings.materializeChannelSettings.toBuilder();
      materializeChannelOperationSettings =
          settings.materializeChannelOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listClustersSettings,
              getClusterSettings,
              createClusterSettings,
              updateClusterSettings,
              deleteClusterSettings,
              listStreamsSettings,
              getStreamSettings,
              createStreamSettings,
              updateStreamSettings,
              deleteStreamSettings,
              getStreamThumbnailSettings,
              generateStreamHlsTokenSettings,
              listEventsSettings,
              getEventSettings,
              createEventSettings,
              updateEventSettings,
              deleteEventSettings,
              listSeriesSettings,
              getSeriesSettings,
              createSeriesSettings,
              updateSeriesSettings,
              deleteSeriesSettings,
              materializeChannelSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getStreamThumbnailSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .generateStreamHlsTokenSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listSeriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getSeriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createSeriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateSeriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteSeriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .materializeChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createStreamOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateStreamRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Stream.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateStreamOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateStreamRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Stream.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteStreamOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteStreamRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .getStreamThumbnailOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<GetStreamThumbnailRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  GetStreamThumbnailResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createEventOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateEventRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Event.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateEventOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateEventRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Event.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteEventOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteEventRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createSeriesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSeriesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Series.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateSeriesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSeriesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Series.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteSeriesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSeriesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .materializeChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<MaterializeChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Channel.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public PagedCallSettings.Builder<
            ListClustersRequest, ListClustersResponse, ListClustersPagedResponse>
        listClustersSettings() {
      return listClustersSettings;
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return createClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, OperationMetadata>
        createClusterOperationSettings() {
      return createClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<UpdateClusterRequest, Operation> updateClusterSettings() {
      return updateClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<UpdateClusterRequest, Cluster, OperationMetadata>
        updateClusterOperationSettings() {
      return updateClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Operation> deleteClusterSettings() {
      return deleteClusterSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public OperationCallSettings.Builder<DeleteClusterRequest, Empty, OperationMetadata>
        deleteClusterOperationSettings() {
      return deleteClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listStreams. */
    public PagedCallSettings.Builder<
            ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
        listStreamsSettings() {
      return listStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to getStream. */
    public UnaryCallSettings.Builder<GetStreamRequest, Stream> getStreamSettings() {
      return getStreamSettings;
    }

    /** Returns the builder for the settings used for calls to createStream. */
    public UnaryCallSettings.Builder<CreateStreamRequest, Operation> createStreamSettings() {
      return createStreamSettings;
    }

    /** Returns the builder for the settings used for calls to createStream. */
    public OperationCallSettings.Builder<CreateStreamRequest, Stream, OperationMetadata>
        createStreamOperationSettings() {
      return createStreamOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateStream. */
    public UnaryCallSettings.Builder<UpdateStreamRequest, Operation> updateStreamSettings() {
      return updateStreamSettings;
    }

    /** Returns the builder for the settings used for calls to updateStream. */
    public OperationCallSettings.Builder<UpdateStreamRequest, Stream, OperationMetadata>
        updateStreamOperationSettings() {
      return updateStreamOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStream. */
    public UnaryCallSettings.Builder<DeleteStreamRequest, Operation> deleteStreamSettings() {
      return deleteStreamSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStream. */
    public OperationCallSettings.Builder<DeleteStreamRequest, Empty, OperationMetadata>
        deleteStreamOperationSettings() {
      return deleteStreamOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getStreamThumbnail. */
    public UnaryCallSettings.Builder<GetStreamThumbnailRequest, Operation>
        getStreamThumbnailSettings() {
      return getStreamThumbnailSettings;
    }

    /** Returns the builder for the settings used for calls to getStreamThumbnail. */
    public OperationCallSettings.Builder<
            GetStreamThumbnailRequest, GetStreamThumbnailResponse, OperationMetadata>
        getStreamThumbnailOperationSettings() {
      return getStreamThumbnailOperationSettings;
    }

    /** Returns the builder for the settings used for calls to generateStreamHlsToken. */
    public UnaryCallSettings.Builder<GenerateStreamHlsTokenRequest, GenerateStreamHlsTokenResponse>
        generateStreamHlsTokenSettings() {
      return generateStreamHlsTokenSettings;
    }

    /** Returns the builder for the settings used for calls to listEvents. */
    public PagedCallSettings.Builder<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings() {
      return listEventsSettings;
    }

    /** Returns the builder for the settings used for calls to getEvent. */
    public UnaryCallSettings.Builder<GetEventRequest, Event> getEventSettings() {
      return getEventSettings;
    }

    /** Returns the builder for the settings used for calls to createEvent. */
    public UnaryCallSettings.Builder<CreateEventRequest, Operation> createEventSettings() {
      return createEventSettings;
    }

    /** Returns the builder for the settings used for calls to createEvent. */
    public OperationCallSettings.Builder<CreateEventRequest, Event, OperationMetadata>
        createEventOperationSettings() {
      return createEventOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEvent. */
    public UnaryCallSettings.Builder<UpdateEventRequest, Operation> updateEventSettings() {
      return updateEventSettings;
    }

    /** Returns the builder for the settings used for calls to updateEvent. */
    public OperationCallSettings.Builder<UpdateEventRequest, Event, OperationMetadata>
        updateEventOperationSettings() {
      return updateEventOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvent. */
    public UnaryCallSettings.Builder<DeleteEventRequest, Operation> deleteEventSettings() {
      return deleteEventSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvent. */
    public OperationCallSettings.Builder<DeleteEventRequest, Empty, OperationMetadata>
        deleteEventOperationSettings() {
      return deleteEventOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listSeries. */
    public PagedCallSettings.Builder<ListSeriesRequest, ListSeriesResponse, ListSeriesPagedResponse>
        listSeriesSettings() {
      return listSeriesSettings;
    }

    /** Returns the builder for the settings used for calls to getSeries. */
    public UnaryCallSettings.Builder<GetSeriesRequest, Series> getSeriesSettings() {
      return getSeriesSettings;
    }

    /** Returns the builder for the settings used for calls to createSeries. */
    public UnaryCallSettings.Builder<CreateSeriesRequest, Operation> createSeriesSettings() {
      return createSeriesSettings;
    }

    /** Returns the builder for the settings used for calls to createSeries. */
    public OperationCallSettings.Builder<CreateSeriesRequest, Series, OperationMetadata>
        createSeriesOperationSettings() {
      return createSeriesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateSeries. */
    public UnaryCallSettings.Builder<UpdateSeriesRequest, Operation> updateSeriesSettings() {
      return updateSeriesSettings;
    }

    /** Returns the builder for the settings used for calls to updateSeries. */
    public OperationCallSettings.Builder<UpdateSeriesRequest, Series, OperationMetadata>
        updateSeriesOperationSettings() {
      return updateSeriesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSeries. */
    public UnaryCallSettings.Builder<DeleteSeriesRequest, Operation> deleteSeriesSettings() {
      return deleteSeriesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSeries. */
    public OperationCallSettings.Builder<DeleteSeriesRequest, Empty, OperationMetadata>
        deleteSeriesOperationSettings() {
      return deleteSeriesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to materializeChannel. */
    public UnaryCallSettings.Builder<MaterializeChannelRequest, Operation>
        materializeChannelSettings() {
      return materializeChannelSettings;
    }

    /** Returns the builder for the settings used for calls to materializeChannel. */
    public OperationCallSettings.Builder<MaterializeChannelRequest, Channel, OperationMetadata>
        materializeChannelOperationSettings() {
      return materializeChannelOperationSettings;
    }

    @Override
    public StreamsServiceStubSettings build() throws IOException {
      return new StreamsServiceStubSettings(this);
    }
  }
}
